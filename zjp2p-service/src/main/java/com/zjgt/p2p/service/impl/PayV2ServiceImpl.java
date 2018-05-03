package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.dict.AcctTranDef;
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
import com.zjgt.thirdpay.domain.ThirdpayBaseRequest;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayV2Service;
import com.zjgt.thirdpay.sign.SignAndVerifyV2;
import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.util.MapToBean;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.thirdpay.v2.domain.BatchPay2bankRequest;
import com.zjgt.thirdpay.v2.domain.BatchPay2bankResponse;
import com.zjgt.thirdpay.v2.domain.InstantOrderResponse;
import com.zjgt.thirdpay.v2.util.CallServiceUtil;
import com.zjgt.thirdpay.v2.util.GsonUtil;
import com.zjgt.thirdpay.v2.util.Tools;
import com.zjgt.util.PoundageUtil;
import com.zjgt.util.PropertiesUtils;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.DateUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayV2ServiceImpl
  implements PayV2Service
{
  Logger logger;

  @Autowired
  PayDealFlowService dealFlowService;

  @Autowired
  MemberAcctService acctService;

  @Autowired
  MemberService memberService;

  @Autowired
  private SignAndVerifyV2 signAndVerify;

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
  public static final String SERIAL_NO = "RapidToBankcardBatchNumberNo";

  public PayV2ServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(PayV2ServiceImpl.class);
  }

  @Transactional
  public boolean fill(ThirdpayBaseRequest payRequest, Float orderAmount)
    throws BusinessException
  {
    Long memberId = Long.valueOf(payRequest.getPayerId());
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
    this.batchTransation.fillCapital(String.valueOf(memberId), amount, transNo, 1);

    if (Constants.isDebugProfile()) {
      PayLogUtil.log("debug mode PayV2 : mock fill response :{},{}", new Object[] { Constants.isDebug, payRequest.getOrderId() });
      InstantOrderResponse payResponse = new InstantOrderResponse();
      payResponse.setOut_trade_no(payRequest.getOrderId());
      payResponse.setTrade_status("PAY_FINISHED");
      payResponse.setTrade_amount(payRequest.getOrderAmount());
      fillRespond(payResponse);
    }
    return true;
  }

  @Transactional
  public boolean fillRespond(InstantOrderResponse payResponse) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getOut_trade_no();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("fillRespond V2 dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      PayLogUtil.log("fillRespond {} 已成功处理", new Object[] { batchNo });
      return true;
    }

    boolean verifySign = false;

    if (!(Constants.isDebugProfile())) {
      try {
        String content = payResponse.generateSign();
        verifySign = verifySign(dealFlow, payResponse.getSign(), content);
        PayLogUtil.log("verifySign {},{},{}", new Object[] { Boolean.valueOf(verifySign), payResponse.getSign(), content });
      } catch (Exception e) {
        PayLogUtil.log("V2 verifySign error", e);
        this.logger.error("V2 verifySign error", e);
      }
    }
    else {
      verifySign = true;
    }
    if (verifySign) {
      String payResult = payResponse.getTrade_status();
      String memberid = String.valueOf(dealFlow.getDealuserid());

      if ("PAY_FINISHED".equals(payResult)) {
        dealFlow.setDealstatus(1);
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(1));
        resultFlag = true;

        Member member = this.memberService.findMemberByid(Long.valueOf(memberid).longValue());
        MemberAcct memberAcct = this.acctService.findByMemberId(Long.valueOf(memberid));

        this.messageService.sendMessage("message.recharge", Long.valueOf(memberid).longValue(), new String[] { String.valueOf(dealFlow.getDealamount()), String.valueOf(memberAcct.getBlance()) });
        String sendContext = null;
        try {
          sendContext = PropertiesUtils.getProperties("mobile.context.recharge.success");
          sendContext = MessageFormat.format(sendContext, new Object[] { Float.valueOf(Float.parseFloat(payResponse.getTrade_amount())), memberAcct.getBlance() });
          this.ismsservice.sendMessageByTemplet(member.getMobile(), sendContext);
        } catch (Exception e) {
          PayLogUtil.log("短信发送失败 ,batchNo=" + batchNo + ",mobile=" + member.getMobile() + ",context=" + sendContext, e);
        }

      }
      else if ("TRADE_FAILED".equals(payResult)) {
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

  private String addDealFlow(ThirdpayBaseRequest payRequest, String dealType, Long userId, BigDecimal amount) throws Exception {
    String batchNo = payRequest.getOrderId();
    PaydealFlow dealFlow = new PaydealFlow();
    dealFlow.setDealflownum(batchNo);

    dealFlow.setDealid(null);
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

  private boolean verifySign(PaydealFlow paydealFlow, String signMsg, String signContent) {
    boolean verify = false;
    try {
      verify = this.signAndVerify.verify(signMsg, signContent);
    } catch (InvalidKeyException e) {
      PayLogUtil.log("V2 验签失败,InvalidKeyException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,InvalidKeyException 原因:" + e.getMessage());
    } catch (SignatureException e) {
      PayLogUtil.log("V2 验签失败,SignatureException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,SignatureException 原因:" + e.getMessage());
    } catch (NoSuchAlgorithmException e) {
      PayLogUtil.log("V2 验签失败,NoSuchAlgorithmException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,NoSuchAlgorithmException 原因:" + e.getMessage());
    }
    return verify;
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

    BatchPay2bankRequest payRequest = new BatchPay2bankRequest();

    payRequest.setService("create_batch_pay2bank");
    String input_charset = PropertiesUtils.getProperties("pay.v2._input_charset");
    payRequest.set_input_charset(input_charset);
    payRequest.setVersion(PropertiesUtils.getProperties("pay.v2.version"));
    payRequest.setNotify_url(PropertiesUtils.getProperties("pay.v2.withdrawBgUrl"));
    String actionUrl = PropertiesUtils.getProperties("pay.v2.withdrawActionUrl");
    payRequest.setSign_type(PropertiesUtils.getProperties("pay.v2.sign_type"));
    payRequest.setRequest_time(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    payRequest.setPartner_id(PropertiesUtils.getProperties("pay.v2.partner_id"));
    payRequest.setPayto_type(PropertiesUtils.getProperties("pay.v2.withdrawPayto_type"));

    String batchNumber = this.serialService.getSerial("RapidToBankcardBatchNumberNo", null);
    payRequest.setBatch_no(batchNumber);
    DecimalFormat df = new DecimalFormat("#0.00");

    if (StringUtils.isEmpty(subBankName)) {
      subBankName = PropertiesUtils.getProperties("pay.v2.withdrawDefSubBank");
    }
    String detail_list = batchNumber + "0001^" + bankAcountName + "^" + bankAcountIdCard + "^" + bankAcountNo + "^" + bankName + "^" + bankCode + "^" + bankprince + "^" + bankcity + "^" + subBankName + "^" + df.format(withdrawAccount) + "^C^DEBIT^付款到银行卡";

    String signMsg = null;
    PayLogUtil.log("V2 withdraw detail_list:{}", new Object[] { detail_list });
    try {
      payRequest.setDetail_list(this.signAndVerify.create_detail_list_like(detail_list));
      String generateSignContent = payRequest.generateSign();
      signMsg = this.signAndVerify.sign(generateSignContent);
    } catch (Exception e) {
      throw new BusinessException("签名失败," + e.getMessage());
    }
    payRequest.setSign(signMsg);
    Map requestMap = null;
    try {
      requestMap = MapToBean.getMap(payRequest);
    } catch (Exception e) {
      new BusinessException("MapToBean.getMap 失败", e);
    }
    PayLogUtil.log("V2 withdraw request :{},{}", new Object[] { actionUrl, payRequest });

    this.batchTransation.withdrawal(String.valueOf(memberid), amount, fees, batchNumber, 1);
    String result = null;
    try {
      String param = Tools.createLinkString(requestMap, true);

      result = CallServiceUtil.sendPost(actionUrl, param);

      result = URLDecoder.decode(result, input_charset);
    } catch (Throwable e) {
      throw new BusinessException("sendSSLPostRequest 发送提现http请求失败", e);
    }
    PayLogUtil.log("V2 withdraw request response :{}", new Object[] { result });
    Map sendResultMap = (Map)GsonUtil.fronJson2Map(result);
    PayLogUtil.log("V2 batch_status :{},{}", new Object[] { sendResultMap.get("batch_status"), Boolean.valueOf("APPLY_SUCCESS".equals(sendResultMap.get("batch_status"))) });

    if ("APPLY_SUCCESS".equals(sendResultMap.get("batch_status"))) {
      PayLogUtil.log("V2 insert into dealFlow");
      String batchNo = payRequest.getBatch_no();
      PaydealFlow dealFlow = new PaydealFlow();
      dealFlow.setDealflownum(batchNo);
      dealFlow.setDealid(null);
      dealFlow.setDealuserid(memberid);
      dealFlow.setDealobject(null);
      dealFlow.setDealamount(amount);
      dealFlow.setDealtype(AcctTranDef.WITHDRAW.getTranCode());
      dealFlow.setDealrequestmsg(payRequest.toString());
      dealFlow.setDealrequesttime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
      dealFlow.setDealstatus(0);
      this.dealFlowService.add(dealFlow);

      if (Constants.isDebugProfile()) {
        BatchPay2bankResponse response = new BatchPay2bankResponse();
        response.setBatch_no(batchNumber);
        response.setBatch_status("FINISHED");
        response.setTrade_list("参数1~参数2~参数3~参数4~SUCCESS~参数6~参数7~参数8~参数9~参数10~");
        withdrawRespond(response);
      }
      return null;
    }
    String retMsg = null;

    if ("BLANCE_NOT_ENOUGH".equals(sendResultMap.get("batch_status")))
      retMsg = "尊敬的用户，系统正在安全升级，暂时无法提现，请您稍后再试。给您带来不便，敬请谅解。";
    else {
      retMsg = (String)sendResultMap.get("response_message");
    }
    return retMsg;
  }

  @Transactional
  public boolean withdrawRespond(BatchPay2bankResponse payResponse) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getBatch_no();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("V2 withdrawRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      return true;
    }
    boolean verifySign = true;

    if (!(Constants.isDebugProfile())) {
      verifySign = verifySign(dealFlow, payResponse.getSign(), payResponse.generateSign());
    }
    if (verifySign) {
      String memberid = String.valueOf(dealFlow.getDealuserid());

      String trade_list = payResponse.getTrade_list();

      String outStatus = trade_list.split("~")[4];
      if (("FINISHED".equals(payResponse.getBatch_status())) && ("SUCCESS".equals(outStatus))) {
        this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(1), Integer.valueOf(dealFlow.getDealstatus()));
        dealFlow.setDealstatus(1);
        resultFlag = true;
      }
      else
      {
        if (2 != dealFlow.getDealstatus())
        {
          this.batchTransation.withdrawalRespond(memberid, batchNo, Integer.valueOf(2), null);
          dealFlow.setDealstatus(2);
          dealFlow.setDealfaileddesc(null);
        }
        resultFlag = false;
      }
    }
    dealFlow.setDealresponsemsg(payResponse.toString());
    dealFlow.setDealresponsetime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
    this.dealFlowService.update(dealFlow);
    return resultFlag;
  }

  @Transactional
  public boolean closeTimeoutTrans(String currTime)
  {
    if (StringUtils.isEmpty(currTime)) {
      currTime = DateUtils.getCurrentFormatDate("yyyyMMddHHmmss");
    }
    this.logger.info("closeTimeoutTrans start : currTime is " + currTime);
    List timeoutProcessTrans = this.dealFlowService.getTimeoutProcessTrans(currTime);
    StringBuffer idsStr = new StringBuffer();
    List ids = new ArrayList();
    for (int i = 0; i < timeoutProcessTrans.size(); ++i) {
      String id = (String)((Map)timeoutProcessTrans.get(i)).get("dealFlowNum");
      ids.add(id);
      idsStr.append(id + ",");
    }
    this.logger.info("size:" + ids.size() + " , close ids is " + idsStr);
    if (!(ids.isEmpty()))
    {
      int updateDealFlowCount = this.dealFlowService.closeTimeoutProcessTrans(ids);
      this.logger.info("ids size = " + ids.size() + ",updateDealFlowCount = " + updateDealFlowCount);
      int updateCapitalTransCount = 0;

      for (int i = 0; i < ids.size(); ++i) {
        ++updateCapitalTransCount;
        this.capitalTransService.updateStatusByTransNo((String)ids.get(i), 2);
      }
      this.logger.info("ids size = " + ids.size() + ",updateCapitalTransCount = " + updateCapitalTransCount);
    }
    return true;
  }
}