package com.zjgt.p2p.pay.sina.controller;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.PaydealFlow;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.domain.SinaPayRequest;
import com.zjgt.thirdpay.domain.SinaPayResponse;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayService;
import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.util.FormGenerator;
import com.zjgt.thirdpay.util.MapToBean;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PropertiesUtils;
import java.text.MessageFormat;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/pay/recharge"})
public class RechargeController
{

  @Autowired
  private MemberService memberservice;

  @Autowired
  private MemberAccountService memberaccountservice;

  @Autowired
  private PayDealFlowService paydealflowservice;

  @Autowired
  private ISmsService ismsservice;

  @Autowired
  private FormGenerator formGenerator;

  @Autowired
  private ISerialService serialService;

  @Autowired
  private PayService thirdPayService;

  @Autowired
  private MessageService messageService;
  public static final String SERIAL_NO = "payOrderNo";

  @RequestMapping({"recharge.do"})
  public String recharge(Model model, Integer orderAmount, String bankId)
  {
    SinaPayRequest payRequest = new SinaPayRequest();
    try {
      payRequest.setVersion(Constants.version);
      payRequest.setLanguage(Constants.language);
      payRequest.setInputCharset(Constants.inputCharset);
      payRequest.setSignType(Constants.signType);
      payRequest.setMerchantAcctId(Constants.merchantAcctId);
      payRequest.setBgUrl(Constants.rechargeBgUrl);

      payRequest.setOrderAmount(String.valueOf(orderAmount.intValue() * 100));
      String orderId = this.serialService.getSerial("payOrderNo", null);

      payRequest.setOrderId(orderId);

      payRequest.setOrderTime(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
      if (!("SINA_PAY".equals(bankId)))
      {
        payRequest.setPayType("20");
        if (Constants.isDebugProfile())
          payRequest.setBankId("TESTBANK");
        else {
          payRequest.setBankId(bankId);
        }
      }
      payRequest.setPid(Constants.pid);
      payRequest.setProductId(null);
      payRequest.setProductName("充值");
      payRequest.setProductNum("1");
      payRequest.setProductDesc(null);
      payRequest.setRedoFlag("1");
      String payerId = null;
      Subject subject = SecurityUtils.getSubject();
      ShiroMember currUser = null;
      currUser = (ShiroMember)subject.getPrincipal();
      payerId = String.valueOf(currUser.getId());

      payRequest.setPayerId(payerId);
      String generateForm = this.formGenerator.generateForm(payRequest);
      PayLogUtil.log("recharge request generatedForm:{}", new Object[] { generateForm });
      model.addAttribute("content", generateForm);
      this.thirdPayService.fill(payRequest, orderAmount);
    } catch (Exception exception) {
      String msg = MessageFormat.format("参数:orderAmount:{0},{1}", new Object[] { orderAmount, payRequest.toString() });
      PayLogUtil.log(new StringBuilder().append("申请充值失败 , ").append(msg.toString()).toString(), exception);
      return "redirect:/member/rechargeApplyFail.do";
    }
    return "/pay/recharge/recharge";
  }

  @RequestMapping({"back.do"})
  @ResponseBody
  public String back(HttpServletRequest request)
  {
    boolean processResult = false;
    Map resultMap = null;
    SinaPayResponse payResponse = null;
    try {
      resultMap = request.getParameterMap();
      payResponse = (SinaPayResponse)MapToBean.getBean(resultMap, SinaPayResponse.class);
      PayLogUtil.log("recharge back response :{}", new Object[] { payResponse });
      processResult = this.thirdPayService.fillRespond(payResponse);
      PayLogUtil.log("recharge back response process result :{}", new Object[] { Boolean.valueOf(processResult) });
    } catch (Exception exception) {
      StringBuilder builder = new StringBuilder();
      if (resultMap != null) {
        builder.append(new StringBuilder().append("ParameterMap:").append(resultMap.toString()).append("\n").toString());
      }
      if (payResponse != null) {
        builder.append(new StringBuilder().append("payResponse :").append(payResponse.toString()).append("\n").toString());
      }
      PayLogUtil.log(new StringBuilder().append("充值回调失败 , ").append(builder.toString()).toString(), exception);
    }
    if (processResult) {
      String batchNo = payResponse.getOrderId();
      PaydealFlow dealFlow = this.paydealflowservice.get(batchNo);
      long memberid = dealFlow.getDealuserid().longValue();
      Member member = this.memberservice.findMemberByid(memberid);
      MemberAccount memberAccount = this.memberaccountservice.getByMemberId(Long.valueOf(memberid));
      String sendContext = null;
      try {
        sendContext = PropertiesUtils.getProperties("mobile.context.recharge.success");
        sendContext = MessageFormat.format(sendContext, new Object[] { Integer.valueOf(Integer.parseInt(payResponse.getPayAmount()) / 100), memberAccount.getBlance() });
        this.ismsservice.sendMessageByTemplet(member.getMobile(), sendContext);
      } catch (Exception e) {
        PayLogUtil.log(new StringBuilder().append("短信发送失败 ,batchNo=").append(batchNo).append(",mobile=").append(member.getMobile()).append(",context=").append(sendContext).toString(), e);
      }
      return new StringBuilder().append("<result>1</result><redirecturl><![CDATA[").append(Constants.rechargeRedirectUrl).append("]]></redirecturl>").toString();
    }
    return "<result>0</result>";
  }

  @RequestMapping({"success.do"})
  public String success(HttpServletRequest request)
  {
    return "/pay/recharge/recharge_success";
  }

  public void setFormGenerator(FormGenerator formGenerator) {
    this.formGenerator = formGenerator;
  }
}