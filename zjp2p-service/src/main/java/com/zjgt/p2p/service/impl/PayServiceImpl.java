package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.PaydealFlow;
import com.zjgt.p2p.service.CapitalBatchTransation;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.thirdpay.domain.BatchRapidPayToBankcardRequest;
import com.zjgt.thirdpay.domain.BatchRapidPayToBankcardResponse;
import com.zjgt.thirdpay.domain.PayToBankSyncResult;
import com.zjgt.thirdpay.domain.SinaPayRequest;
import com.zjgt.thirdpay.domain.SinaPayResponse;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayService;
import com.zjgt.thirdpay.sign.SignAndVerify;
import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.util.HttpClientUtil;
import com.zjgt.thirdpay.util.JaxbUtil;
import com.zjgt.thirdpay.util.MapToBean;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PoundageUtil;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.DecimalFormat;
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
public class PayServiceImpl
  implements PayService
{
  Logger logger;

  @Autowired
  PayDealFlowService dealFlowService;

  @Autowired
  MemberAcctService acctService;

  @Autowired
  private SignAndVerify signAndVerify;

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
  public static final String SERIAL_NO = "RapidToBankcardBatchNumberNo";

  public PayServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(PayServiceImpl.class);
  }

  @Transactional
  public boolean fill(SinaPayRequest payRequest, Integer orderAmount)
    throws BusinessException
  {
    Long memberId = Long.valueOf(payRequest.getPayerId());
    BigDecimal amount = new BigDecimal(orderAmount.intValue());
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
      SinaPayResponse payResponse = new SinaPayResponse();
      payResponse.setOrderId(payRequest.getOrderId());
      payResponse.setPayResult("10");
      payResponse.setOrderAmount(payRequest.getOrderAmount());
      fillRespond(payResponse);
    }
    return true;
  }

  @Transactional
  public boolean fillRespond(SinaPayResponse payResponse) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getOrderId();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("fillRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      return true;
    }

    boolean verifySign = true;

    if (!(Constants.isDebugProfile())) {
      verifySign = verifySign(dealFlow, payResponse.getSignMsg(), payResponse.generateSignContent());
    }
    if (verifySign) {
      String payResult = payResponse.getPayResult();
      String memberid = String.valueOf(dealFlow.getDealuserid());

      if ("10".equals(payResult)) {
        dealFlow.setDealstatus(1);
        this.batchTransation.fillCapitalRespond(memberid, dealFlow.getDealamount(), batchNo, Integer.valueOf(1));
        resultFlag = true;
        MemberAcct memberAcct = this.acctService.findByMemberId(Long.valueOf(memberid));

        this.messageService.sendMessage("message.recharge", Long.valueOf(memberid).longValue(), new String[] { String.valueOf(dealFlow.getDealamount()), String.valueOf(memberAcct.getBlance()) });
      }
      else if ("11".equals(payResult)) {
        dealFlow.setDealstatus(2);
        dealFlow.setDealfaileddesc(payResponse.getErrCode());
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

  private String addDealFlow(SinaPayRequest payRequest, String dealType, Long userId, BigDecimal amount) throws Exception {
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
      PayLogUtil.log("验签失败,InvalidKeyException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,InvalidKeyException 原因:" + e.getMessage());
    } catch (SignatureException e) {
      PayLogUtil.log("验签失败,SignatureException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,SignatureException 原因:" + e.getMessage());
    } catch (NoSuchAlgorithmException e) {
      PayLogUtil.log("验签失败,NoSuchAlgorithmException 原因:" + e.getMessage());
      paydealFlow.setDealstatus(2);
      paydealFlow.setDealfaileddesc("验签失败,NoSuchAlgorithmException 原因:" + e.getMessage());
    }
    return verify;
  }

  @Transactional
  public String withdraw(Long memberid, boolean isRapid, BigDecimal amount, String bankName, String bankAcountNo, String bankAcountName, String bankprince, String bankcity, String subBankName)
    throws BusinessException
  {
    BigDecimal fees = null;
    try
    {
      int times = this.capitalTransService.getTimes(memberid.longValue());

      int drawalCount = this.capitalTransService.getTimesAsInvest(memberid.longValue());
      fees = new BigDecimal(String.valueOf(PoundageUtil.getPoundageForMember(drawalCount, String.valueOf(amount), times)));
    } catch (Exception e) {
      new BusinessException("计算手续费失败," + e.getMessage());
    }

    BigDecimal withdrawAccount = new BigDecimal(amount.subtract(fees).doubleValue());

    BatchRapidPayToBankcardRequest payRequest = new BatchRapidPayToBankcardRequest();
    payRequest.setInputCharset(Constants.inputCharset);
    String actionUrl = null;
    if (isRapid) {
      payRequest.setVersion(Constants.rapidPayToBankVersion);
      payRequest.setBgUrl(Constants.rapidPayToBankBackUrl);
      actionUrl = Constants.rapidPayToBankUrl;
    } else {
      payRequest.setVersion(Constants.payToBankVersion);
      payRequest.setBgUrl(Constants.payToBankBackUrl);
      actionUrl = Constants.payToBankUrl;
    }
    payRequest.setSignType(Constants.signType);

    String batchNumber = this.serialService.getSerial("RapidToBankcardBatchNumberNo", null);
    payRequest.setBatchNumber(batchNumber);
    payRequest.setPayDate(DateUtils.getCurrentFormatDate("yyyyMMdd"));
    DecimalFormat df = new DecimalFormat("#0");

    payRequest.setTotalAmount(String.valueOf(df.format(withdrawAccount.multiply(BigDecimal.valueOf(100L)))));
    payRequest.setTotalQuantity("1");
    payRequest.setDetailData(batchNumber + "0001^" + bankAcountName + "^" + bankName + "^" + bankAcountNo + "^" + bankprince + "^" + bankcity + "^" + subBankName + "^" + payRequest.getTotalAmount() + "^1^付款到银行卡");

    payRequest.setPid(Constants.pid);
    payRequest.setExtendData(null);
    String generateSignContent = payRequest.generateSignContent();
    String signMsg;
    try {
      signMsg = this.signAndVerify.sign(generateSignContent);
    } catch (Exception e) {
      throw new BusinessException("签名失败," + e.getMessage());
    }
    payRequest.setSignMsg(signMsg);

    Map requestMap = null;
    try {
      requestMap = MapToBean.getMap(payRequest);
    } catch (Exception e) {
      new BusinessException("MapToBean.getMap 失败", e);
    }
    PayLogUtil.log("withdraw request :{},{}", new Object[] { actionUrl, payRequest });

    String result = null;
    try {
      result = HttpClientUtil.sendSSLPostRequest(actionUrl, requestMap);
    } catch (Exception e) {
      throw new BusinessException("sendSSLPostRequest 发送提现http请求失败", e);
    }
    PayLogUtil.log("withdraw response :{}", new Object[] { result });
    PayToBankSyncResult toBankResult = (PayToBankSyncResult)JaxbUtil.converyToJavaBean(result, PayToBankSyncResult.class);
    if ("Y".equals(toBankResult.getResult())) {
      String batchNo = payRequest.getBatchNumber();
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

      this.batchTransation.withdrawal(String.valueOf(memberid), amount, fees, batchNo, 1);

      if (Constants.isDebugProfile()) {
        BatchRapidPayToBankcardResponse response = new BatchRapidPayToBankcardResponse();
        response.setBatchNumber(batchNumber);
        response.setSuccessTotalQuantity("1");
        response.setOriginalTotalQuantity("1");
        withdrawRespond(response);
      }
      return null;
    }
    return toBankResult.getErrorMessage();
  }

  @Transactional
  public boolean withdrawRespond(BatchRapidPayToBankcardResponse payResponse) throws BusinessException
  {
    boolean resultFlag = false;
    String batchNo = payResponse.getBatchNumber();
    PaydealFlow dealFlow = this.dealFlowService.getForUpdate(batchNo);
    if (dealFlow == null) {
      PayLogUtil.log("withdrawRespond dealFlow is null , batchNo = " + batchNo);
      return false;
    }
    if (1 == dealFlow.getDealstatus()) {
      return true;
    }
    boolean verifySign = true;

    if (!(Constants.isDebugProfile())) {
      verifySign = verifySign(dealFlow, payResponse.getSignMsg(), payResponse.generateSignContent());
    }
    if (verifySign) {
      String memberid = String.valueOf(dealFlow.getDealuserid());

      if (payResponse.getSuccessTotalQuantity().equals(payResponse.getOriginalTotalQuantity())) {
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
          dealFlow.setDealfaileddesc(payResponse.getBatchFailureDetail());
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