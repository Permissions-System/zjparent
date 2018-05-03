package com.zjgt.p2p.service.impl;

import com.alibaba.fastjson.JSON;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.LLPayMapper;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.PaydealFlow;
import com.zjgt.p2p.service.CapitalBatchTransation;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.service.TranslogService;
import com.zjgt.thirdpay.lianlian.conn.HttpRequestSimple;
import com.zjgt.thirdpay.lianlian.utils.LLPayUtil;
import com.zjgt.thirdpay.lianlian.vo.CashBean;
import com.zjgt.thirdpay.lianlian.vo.CashNotifyRetBean;
import com.zjgt.thirdpay.lianlian.vo.CashSyncRetBean;
import com.zjgt.thirdpay.lianlian.vo.OrderQueryRequest;
import com.zjgt.thirdpay.lianlian.vo.OrderQueryResponse;
import com.zjgt.thirdpay.lianlian.vo.PaymentInfo;
import com.zjgt.thirdpay.lianlian.vo.PaymentNotifyRetBean;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayLLService;
import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PoundageUtil;
import com.zjgt.util.PropertiesUtils;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.DateUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayLLServiceImpl
  implements PayLLService
{
  Logger logger;

  @Autowired
  PayDealFlowService dealFlowService;

  @Autowired
  MemberAcctService acctService;

  @Autowired
  MemberService memberService;

  @Autowired
  private MemberAccountService accountingService;

  @Autowired
  private CapitalBatchTransation batchTransation;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private ISerialService serialService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private ISmsService ismsservice;

  @Autowired
  private LLPayMapper llPayMapper;

  @Autowired
  private TranslogService translogService;
  public static final String SERIAL_NO = "RapidToBankcardBatchNumberNo";
  private Map<String, String> withdrawBankMap;
  private Map<String, String> authPayBankMap;

  public PayLLServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(PayLLServiceImpl.class);

    this.withdrawBankMap = new HashMap();

    this.authPayBankMap = new HashMap();
  }

  @PostConstruct
  public void init() {
    this.withdrawBankMap.put("ICBC", "中国工商银行");
    this.withdrawBankMap.put("ABC", "中国农业银行");
    this.withdrawBankMap.put("BOC", "中国银行");
    this.withdrawBankMap.put("CCB", "中国建设银行");
    this.withdrawBankMap.put("CMB", "招商银行");
    this.withdrawBankMap.put("SPDB", "上海浦东发展银行");
    this.withdrawBankMap.put("CEB", "中国光大银行");

    this.authPayBankMap.put("中国邮政储蓄银行", "1");
    this.authPayBankMap.put("中国工商银行", "5");
    this.authPayBankMap.put("中国农业银行", "2");
    this.authPayBankMap.put("中国银行", "50");
    this.authPayBankMap.put("中国建设银行", "50");
    this.authPayBankMap.put("中信银行", "50");
    this.authPayBankMap.put("华夏银行", "50");
    this.authPayBankMap.put("中国民生银行", "5");
    this.authPayBankMap.put("广东发展银行", "5");
    this.authPayBankMap.put("平安银行", "20");
    this.authPayBankMap.put("招商银行", "50");
    this.authPayBankMap.put("兴业银行", "50");
    this.authPayBankMap.put("上海浦东发展银行", "5");
    this.authPayBankMap.put("中国光大银行", "50");
  }

  @Transactional
  public boolean fill(PaymentInfo payRequest, Float orderAmount)
    throws BusinessException
  {
    Long memberId = Long.valueOf(payRequest.getUser_id());
    BigDecimal amount = new BigDecimal(orderAmount.floatValue());
    MemberAcct memberAcct = this.acctService.findByMemberId(memberId);

    if (amount.scale() > 2) {
      throw new BusinessException("金额不允许小数点后2位");
    }
    String transNo = null;
    try {
      transNo = addDealFlow(payRequest, AcctTranDef.FILL.getTranCode(), memberAcct.getMemberid(), amount);
    } catch (Exception e) {
      new BusinessException("新增支付交易记录失败," + e.getMessage());
    }
    this.batchTransation.fillCapital(String.valueOf(memberId), amount, transNo, 2);

    if (Constants.isDebugProfile()) {
      PayLogUtil.log("debug mode PayLL : mock fill response :{},{}", new Object[] { Constants.isDebug, payRequest.getNo_order() });
      PaymentNotifyRetBean payResponse = new PaymentNotifyRetBean();
      payResponse.setNo_order(payRequest.getNo_order());
      payResponse.setResult_pay("SUCCESS");
      payResponse.setMoney_order(payRequest.getMoney_order());
      fillRespond(payResponse, null);
    }
    return true;
  }

  @Transactional
  public boolean fillRespond(PaymentNotifyRetBean payResponse, String reqStr) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getNo_order();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("fillRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      PayLogUtil.log("fillRespond {} 已成功处理", new Object[] { batchNo });
      return true;
    }
    boolean verifySign = false;

    if (!(Constants.isDebugProfile())) {
      try {
        String publicKey = PropertiesUtils.getProperties("pay.ll.public.sign_key");
        verifySign = LLPayUtil.checkSign(reqStr, publicKey, null);
        PayLogUtil.log("verifySign {},{},{}", new Object[] { Boolean.valueOf(verifySign), payResponse.getSign(), null });
      } catch (Exception e) {
        PayLogUtil.log("LianLian verifySign error", e);
        this.logger.error("LianLian verifySign error", e);
      }
    }
    else {
      verifySign = true;
    }
    if (verifySign) {
      String payResult = payResponse.getResult_pay();
      String memberid = String.valueOf(dealFlow.getDealuserid());

      if ("SUCCESS".equals(payResult)) {
        dealFlow.setDealstatus(1);
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(1));
        resultFlag = true;

        Member member = this.memberService.findMemberByid(Long.valueOf(memberid).longValue());
        MemberAcct memberAcct = this.acctService.findByMemberId(Long.valueOf(memberid));

        if (!(Constants.isDebugProfile()))
        {
          this.messageService.sendMessage("message.recharge", Long.valueOf(memberid).longValue(), new String[] { String.valueOf(dealFlow.getDealamount()), String.valueOf(memberAcct.getBlance()) });
          String sendContext = null;
          try {
            sendContext = PropertiesUtils.getProperties("mobile.context.recharge.success");
            sendContext = MessageFormat.format(sendContext, new Object[] { dealFlow.getDealamount(), memberAcct.getBlance() });
            this.ismsservice.sendMessageByTemplet(member.getMobile(), sendContext);
          } catch (Exception e) {
            PayLogUtil.log("短信发送失败 ,batchNo=" + batchNo + ",mobile=" + member.getMobile() + ",context=" + sendContext, e);
          }
        }

      }
      else if (("FAILURE".equals(payResult)) || ("REFUND".equals(payResult))) {
        dealFlow.setDealstatus(2);
        dealFlow.setDealfaileddesc(payResult);
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(2));
        resultFlag = false;
      } else {
        resultFlag = false;
      }
    }
    dealFlow.setDealresponsemsg(payResponse.toString());
    dealFlow.setDealresponsetime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    this.dealFlowService.update(dealFlow);
    return resultFlag;
  }

  private String addDealFlow(PaymentInfo payRequest, String dealType, Long userId, BigDecimal amount) throws Exception {
    String batchNo = payRequest.getNo_order();
    PaydealFlow dealFlow = new PaydealFlow();
    dealFlow.setDealflownum(batchNo);

    dealFlow.setDealid("1");
    dealFlow.setDealuserid(userId);
    dealFlow.setDealobject(null);
    dealFlow.setDealamount(amount);
    dealFlow.setDealtype(dealType);
    dealFlow.setDealrequestmsg(payRequest.toString());
    dealFlow.setDealrequesttime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    dealFlow.setDealstatus(0);
    this.dealFlowService.add(dealFlow);
    return batchNo;
  }

  @Transactional
  public String withdraw(Long memberid, boolean isRapid, BigDecimal amount, String bankName, String bankCode, String bankAcountNo, String bankAcountName, String bankAcountIdCard, String bankprince, String bankcity, String subBankName)
    throws BusinessException
  {
    if (amount.compareTo(BigDecimal.valueOf(20000L)) == 1) {
      this.logger.warn("提现金额一笔不能超过{}", Long.valueOf(20000L));
      throw new BusinessException("提现金额一笔不能超过20000");
    }

    BigDecimal fees = null;

    int times = this.capitalTransService.getTimes(memberid.longValue());
    if (times > 2)
      new BusinessException("一天内提现次数不能超过3次");
    try
    {
      int drawalCount = this.capitalTransService.getTimesAsInvest(memberid.longValue());
      fees = new BigDecimal(String.valueOf(PoundageUtil.getPoundageForMember(drawalCount, String.valueOf(amount), times)));
    } catch (Exception e) {
      new BusinessException("计算手续费失败," + e.getMessage());
    }

    MemberAcct acctInfo = this.acctService.findByMemberId(Long.valueOf(memberid.longValue()));
    if (amount.compareTo(acctInfo.getBlance()) == 1) {
      this.logger.warn("提现金额不能大于可用余额,{},{}", amount, acctInfo.getBlance());
      throw new BusinessException("提现金额不能大于可用余额,可用余额为 " + acctInfo.getBlance());
    }

    BigDecimal withdrawAccount = new BigDecimal(amount.subtract(fees).doubleValue());
    if (withdrawAccount.compareTo(BigDecimal.ZERO) <= 0) {
      this.logger.warn("提现金额不能小于等于手续费,{},{}", amount, fees);
      throw new BusinessException("提现金额不能小于手续费");
    }

    String batchNumber = this.serialService.getSerial("RapidToBankcardBatchNumberNo", null);
    CashBean reqBean = new CashBean();
    reqBean.setApi_version(PropertiesUtils.getProperties("pay.ll.withdraw.version"));
    reqBean.setOid_partner(PropertiesUtils.getProperties("pay.ll.oid_partner"));
    reqBean.setSign_type(PropertiesUtils.getProperties("pay.ll.sign_type"));
    reqBean.setNo_order(batchNumber);
    reqBean.setDt_order(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    reqBean.setUser_id(String.valueOf(memberid));
    reqBean.setAcct_name(bankAcountName);
    reqBean.setCard_no(bankAcountNo);

    if (!(this.withdrawBankMap.containsKey(bankCode)))
    {
      String provinceCode = this.llPayMapper.getProvinceIdByName(bankprince);

      String cityCode = this.llPayMapper.getCityIdByName(bankcity);
      reqBean.setProvince_code(provinceCode);
      reqBean.setCity_code(cityCode);

      if (StringUtils.isNotEmpty(subBankName)) {
        reqBean.setBrabank_name(subBankName);
      }
      else {
        reqBean.setBrabank_name(PropertiesUtils.getProperties("pay.ll.withdrawDefSubBank"));
      }
    }

    if ("true".equals(PropertiesUtils.getProperties("pay.ll.withdraw.debug")))
      reqBean.setMoney_order("0.01");
    else {
      reqBean.setMoney_order(String.valueOf(withdrawAccount));
    }
    reqBean.setFlag_card("0");
    reqBean.setInfo_order("提现");
    reqBean.setNotify_url(PropertiesUtils.getProperties("pay.ll.withdraw.notify_url"));
    String signMsg = null;
    try {
      signMsg = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(reqBean)), PropertiesUtils.getProperties("pay.ll.private.sign_key"), null);
      reqBean.setSign(signMsg);
    } catch (Exception e) {
      throw new BusinessException("签名失败," + e.getMessage());
    }

    this.batchTransation.withdrawal(String.valueOf(memberid), amount, fees, batchNumber, 2);

    String cashSyncResult = null;
    try {
      String reqJson = JSON.toJSONString(reqBean);
      String actionUrl = PropertiesUtils.getProperties("pay.ll.withdraw.actionUrl");
      PayLogUtil.log("LianLian withdraw request :{} , {}", new Object[] { actionUrl, reqJson });
      HttpRequestSimple httpclent = HttpRequestSimple.getInstance();

      cashSyncResult = httpclent.postSendHttp(actionUrl, reqJson);
    } catch (Exception e) {
      throw new BusinessException("sendSSLPostRequest 发送提现http请求失败", e);
    }
    PayLogUtil.log("LianLian withdraw sync response :{}", new Object[] { cashSyncResult });
    CashSyncRetBean cashSyncRetBean = (CashSyncRetBean)JSON.parseObject(cashSyncResult, CashSyncRetBean.class);

    if ("0000".equals(cashSyncRetBean.getRet_code())) {
      String batchNo = reqBean.getNo_order();
      PayLogUtil.log("LianLian insert into dealFlow " + batchNo);
      PaydealFlow dealFlow = new PaydealFlow();
      dealFlow.setDealflownum(batchNo);
      dealFlow.setDealid("1");
      dealFlow.setDealuserid(memberid);
      dealFlow.setDealobject(null);
      dealFlow.setDealamount(amount);
      dealFlow.setDealtype(AcctTranDef.WITHDRAW.getTranCode());
      dealFlow.setDealrequestmsg(reqBean.toString());
      dealFlow.setDealrequesttime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
      dealFlow.setDealstatus(0);
      this.dealFlowService.add(dealFlow);

      if (Constants.isDebugProfile()) {
        CashNotifyRetBean response = new CashNotifyRetBean();
        response.setNo_order(batchNumber);
        response.setMoney_order(String.valueOf(amount));
        response.setResult_pay("SUCCESS");

        withdrawRespond(response, null);
      }
      return null;
    }
    String retMsg = null;

    if ("9104".equals(cashSyncRetBean.getRet_code())) {
      retMsg = "尊敬的用户，系统正在安全升级，暂时无法提现，请您稍后再试。给您带来不便，敬请谅解。";
    }
    else if ("商户请求参数[brabank_name]非法。".equals(cashSyncRetBean.getRet_msg()))
      retMsg = "请先绑定银行卡支行信息";
    else {
      retMsg = cashSyncRetBean.getRet_msg();
    }
    return retMsg;
  }

  @Transactional
  public boolean withdrawRespond(CashNotifyRetBean payResponse, String reqStr) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getNo_order();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("LianLian withdrawRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      return true;
    }
    boolean verifySign = true;

    if (!(Constants.isDebugProfile())) {
      try {
        String publicKey = PropertiesUtils.getProperties("pay.ll.public.sign_key");
        verifySign = LLPayUtil.checkSign(reqStr, publicKey, null);
        PayLogUtil.log("verifySign {},{},{}", new Object[] { Boolean.valueOf(verifySign), payResponse.getSign(), null });
      } catch (Exception e) {
        PayLogUtil.log("LianLian verifySign error", e);
        this.logger.error("LianLian verifySign error", e);
      }
    }
    if (verifySign) {
      String memberid = String.valueOf(dealFlow.getDealuserid());

      String outStatus = payResponse.getResult_pay();
      if ("SUCCESS".equals(outStatus)) {
        this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(1), Integer.valueOf(dealFlow.getDealstatus()));
        dealFlow.setDealstatus(1);
        resultFlag = true;
      }
      else
      {
        if (((("FAILURE".equals(outStatus)) || ("CANCEL".equals(outStatus)))) && (2 != dealFlow.getDealstatus()))
        {
          this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(2), null);
          dealFlow.setDealstatus(2);
          dealFlow.setDealfaileddesc(payResponse.getInfo_order());
          Map withdrawFailDescMap = new HashMap();
          withdrawFailDescMap.put("failDesc", dealFlow.getDealfaileddesc());
          withdrawFailDescMap.put("dealFlowNum", batchNo);
          this.translogService.updateWithdrawFailDesc(withdrawFailDescMap);
        }
        resultFlag = false;
      }
    }
    dealFlow.setDealresponsemsg(payResponse.toString());
    dealFlow.setDealresponsetime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    this.dealFlowService.update(dealFlow);
    return resultFlag;
  }

  public Map<String, String> getAuthPayBank()
  {
    return this.authPayBankMap;
  }

  public String getBankCodeByName(String bankName)
  {
    return this.llPayMapper.getBankCodeByName(bankName);
  }

  public boolean scheduledProcessPayResponse(String currTime)
  {
    if (StringUtils.isEmpty(currTime)) {
      currTime = DateUtils.getCurrentFormatDate("yyyyMMddHHmmss");
    }
    this.logger.info("processTimeoutPayResponse start : currTime is " + currTime);
    List results = this.dealFlowService.getProcessPayRequest(currTime);
    for (int i = 0; i < results.size(); ++i) {
      String dealFlowNum = ((Map)results.get(i)).get("dealFlowNum").toString();
      String dealtype = ((Map)results.get(i)).get("dealtype").toString();
      OrderQueryRequest queryRequest = new OrderQueryRequest();
      queryRequest.setOid_partner(PropertiesUtils.getProperties("pay.ll.oid_partner"));
      queryRequest.setSign_type(PropertiesUtils.getProperties("pay.ll.sign_type"));
      queryRequest.setNo_order(dealFlowNum);
      queryRequest.setQuery_version("1.1");

      if (AcctTranDef.WITHDRAW.getTranCode().equals(dealtype))
        queryRequest.setType_dc("1");
      else if (!(AcctTranDef.FILL.getTranCode().equals(dealtype)));
      String signMsg = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(queryRequest)), PropertiesUtils.getProperties("pay.ll.private.sign_key"), null);
      queryRequest.setSign(signMsg);
      String queryRequestJson = JSON.toJSONString(queryRequest);

      String syncResponseJson = null;
      try {
        this.logger.info("queryRequestJson is {} , queryRequest : {}", queryRequestJson, queryRequest);
        HttpRequestSimple httpclent = HttpRequestSimple.getInstance();
        syncResponseJson = httpclent.postSendHttp(PropertiesUtils.getProperties("pay.ll.orderquery.actionUrl"), queryRequestJson);
        this.logger.info("queryRequest syncResponseJson is {},{}", dealFlowNum, syncResponseJson);
      } catch (Exception e) {
        throw new BusinessException("sendSSLPostRequest 发送提现http请求失败", e);
      }
      OrderQueryResponse orderQueryResponse = (OrderQueryResponse)JSON.parseObject(syncResponseJson, OrderQueryResponse.class);
      this.logger.info("orderQueryResponse is {}", orderQueryResponse);
      if ("0000".equals(orderQueryResponse.getRet_code())) {
        this.logger.info("ret_code is 0000 , dealtype is {} , process start...", dealtype);

        if (AcctTranDef.WITHDRAW.getTranCode().equals(dealtype)) {
          withdrawRespond(orderQueryResponse, syncResponseJson);
        }
        else if (AcctTranDef.FILL.getTranCode().equals(dealtype)) {
          fillRespond(orderQueryResponse, syncResponseJson);
        }
      }
    }
    return false;
  }

  @Transactional
  public boolean withdrawRespond(OrderQueryResponse payResponse, String reqStr)
    throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getNo_order();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      this.logger.info("LianLian withdrawRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      return true;
    }
    boolean verifySign = true;

    if (!(Constants.isDebugProfile())) {
      try {
        String publicKey = PropertiesUtils.getProperties("pay.ll.public.sign_key");
        verifySign = LLPayUtil.checkSign(reqStr, publicKey, null);
        this.logger.info("verifySign {},{},{}", new Object[] { Boolean.valueOf(verifySign), payResponse.getSign(), null });
      } catch (Exception e) {
        this.logger.info("LianLian verifySign error", e);
        this.logger.error("LianLian verifySign error", e);
      }
    }
    if (verifySign) {
      String memberid = String.valueOf(dealFlow.getDealuserid());

      String outStatus = payResponse.getResult_pay();
      if ("SUCCESS".equals(outStatus)) {
        this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(1), Integer.valueOf(dealFlow.getDealstatus()));
        dealFlow.setDealstatus(1);
        resultFlag = true;
      }
      else if (("FAILURE".equals(outStatus)) && (2 != dealFlow.getDealstatus()))
      {
        this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(2), null);
        dealFlow.setDealstatus(2);
        dealFlow.setDealfaileddesc(payResponse.getMemo());
        Map withdrawFailDescMap = new HashMap();
        withdrawFailDescMap.put("failDesc", dealFlow.getDealfaileddesc());
        withdrawFailDescMap.put("dealFlowNum", batchNo);
        this.translogService.updateWithdrawFailDesc(withdrawFailDescMap);
        resultFlag = false;
      }
      else {
        return false;
      }
    }

    dealFlow.setDealresponsemsg(payResponse.toString());
    dealFlow.setDealresponsetime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    this.dealFlowService.update(dealFlow);
    return resultFlag;
  }

  @Transactional
  public boolean fillRespond(OrderQueryResponse payResponse, String reqStr)
    throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getNo_order();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      this.logger.info("fillRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      this.logger.info("fillRespond {} 已成功处理", batchNo);
      return true;
    }
    boolean verifySign = false;

    if (!(Constants.isDebugProfile())) {
      try {
        String publicKey = PropertiesUtils.getProperties("pay.ll.public.sign_key");
        verifySign = LLPayUtil.checkOrderQuerySign(reqStr, publicKey, null);
        this.logger.info("verifySign {},{},{}", new Object[] { Boolean.valueOf(verifySign), payResponse.getSign(), null });
      } catch (Exception e) {
        this.logger.info("LianLian verifySign error", e);
        this.logger.error("LianLian verifySign error", e);
      }
    }
    else {
      verifySign = true;
    }
    if (verifySign) {
      String payResult = payResponse.getResult_pay();
      String memberid = String.valueOf(dealFlow.getDealuserid());

      if ("SUCCESS".equals(payResult)) {
        dealFlow.setDealstatus(1);
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(1));
        resultFlag = true;
        Member member = this.memberService.findMemberByid(Long.valueOf(memberid).longValue());
        MemberAcct memberAcct = this.acctService.findByMemberId(Long.valueOf(memberid));

        if (!(Constants.isDebugProfile()))
        {
          this.messageService.sendMessage("message.recharge", Long.valueOf(memberid).longValue(), new String[] { String.valueOf(dealFlow.getDealamount()), String.valueOf(memberAcct.getBlance()) });
          String sendContext = null;
          try {
            sendContext = PropertiesUtils.getProperties("mobile.context.recharge.success");
            sendContext = MessageFormat.format(sendContext, new Object[] { dealFlow.getDealamount(), memberAcct.getBlance() });
            this.ismsservice.sendMessageByTemplet(member.getMobile(), sendContext);
          } catch (Exception e) {
            this.logger.info("短信发送失败 ,batchNo=" + batchNo + ",mobile=" + member.getMobile() + ",context=" + sendContext, e);
          }
        }

      }
      else if (("FAILURE".equals(payResult)) || ("REFUND".equals(payResult))) {
        dealFlow.setDealstatus(2);
        dealFlow.setDealfaileddesc(payResponse.getMemo());
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(2));
        resultFlag = false;
      }
      else {
        return false;
      }
    }
    dealFlow.setDealresponsemsg(payResponse.toString());
    dealFlow.setDealresponsetime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    this.dealFlowService.update(dealFlow);
    return resultFlag;
  }
}