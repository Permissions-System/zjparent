package com.zjgt.p2p.pay.sina.controller;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayV2Service;
import com.zjgt.thirdpay.sign.SignAndVerifyV2;
import com.zjgt.thirdpay.util.FormGenerator;
import com.zjgt.thirdpay.util.MapToBean;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.thirdpay.v2.domain.InstantOrderRequest;
import com.zjgt.thirdpay.v2.domain.InstantOrderResponse;
import com.zjgt.thirdpay.v2.util.Tools;
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
@RequestMapping({"/pay/rechargeV2"})
public class RechargeV2Controller
{

  @Autowired
  private MemberService memberservice;

  @Autowired
  private MemberAccountService memberaccountservice;

  @Autowired
  private PayDealFlowService paydealflowservice;

  @Autowired
  private FormGenerator formGenerator;

  @Autowired
  private ISerialService serialService;

  @Autowired
  private PayV2Service thirdPayService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private SignAndVerifyV2 andVerify;
  public static final String SERIAL_NO = "payOrderNo";

  @RequestMapping({"recharge.do"})
  public String recharge(Model model, Float orderAmount, String bankId)
  {
    InstantOrderRequest payRequest = new InstantOrderRequest();
    try
    {
      payRequest.setService("create_instant_order");
      payRequest.setVersion(PropertiesUtils.getProperties("pay.v2.version"));

      payRequest.setRequest_time(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss"));
      payRequest.setPartner_id(PropertiesUtils.getProperties("pay.v2.partner_id"));
      String input_charset = PropertiesUtils.getProperties("pay.v2._input_charset");
      payRequest.set_input_charset(input_charset);
      payRequest.setReturn_url(PropertiesUtils.getProperties("pay.v2.rechargeRedirectUrl"));
      payRequest.setNotify_url(PropertiesUtils.getProperties("pay.v2.rechargeBgUrl"));
      payRequest.setSign_type(PropertiesUtils.getProperties("pay.v2.sign_type"));

      payRequest.setSeller_identity_id(PropertiesUtils.getProperties("pay.v2.seller_identity_id"));
      payRequest.setSeller_identity_type(PropertiesUtils.getProperties("pay.v2.seller_identity_type"));
      payRequest.setOut_trade_no(this.serialService.getSerial("payOrderNo", null));
      payRequest.setAmount(String.valueOf(orderAmount));
      payRequest.setProduct_desc(null);
      if (!("SINA_PAY".equals(bankId))) {
        String online_bank_bankid = bankId;
        String online_bank_card_type = "DEBIT";
        String online_bank_card_attribute = "C";
        String pay_bankmethod = new StringBuilder().append("online_bank^").append(orderAmount).append("^").append(online_bank_bankid).append(",").append(online_bank_card_type).append(",").append(online_bank_card_attribute).toString();
        payRequest.setPay_method(pay_bankmethod);
      }
      String content = Tools.createLinkString(payRequest.generateSignContent(), false);
      String sign = this.andVerify.sign(content);

      payRequest.setSign(sign);

      String generateForm = this.formGenerator.generateForm(payRequest, input_charset);
      PayLogUtil.log("recharge request generatedForm:{}", new Object[] { generateForm });
      model.addAttribute("content", generateForm);

      Subject subject = SecurityUtils.getSubject();
      ShiroMember currUser = null;
      currUser = (ShiroMember)subject.getPrincipal();
      String payerId = String.valueOf(currUser.getId());
      payRequest.setPayerId(payerId);
      payRequest.setOrderId(payRequest.getOut_trade_no());
      payRequest.setOrderAmount(payRequest.getAmount());
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
    InstantOrderResponse payResponse = null;
    try {
      resultMap = request.getParameterMap();
      payResponse = (InstantOrderResponse)MapToBean.getBean(resultMap, InstantOrderResponse.class);
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
      return "success";
    }
    return "fail";
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