package com.zjgt.p2p.pay.lianlian.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.lianlian.utils.LLPayUtil;
import com.zjgt.thirdpay.lianlian.vo.OrderInfo;
import com.zjgt.thirdpay.lianlian.vo.PaymentInfo;
import com.zjgt.thirdpay.lianlian.vo.PaymentNotifyRetBean;
import com.zjgt.thirdpay.lianlian.vo.RetBean;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayLLService;
import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.util.FormGenerator;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.ShiroWebUtil;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springfk.pancloud.utils.DateUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/pay/ll/recharge"})
public class RechargeLLController
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
  private PayLLService thirdPayService;

  @Autowired
  private MessageService messageService;
  public static final String SERIAL_NO = "payOrderNo";

  @RequestMapping({"getAuthPayBank.do"})
  @ResponseBody
  public Map<String, String> getAuthPayBank()
  {
    return this.thirdPayService.getAuthPayBank();
  }

  @RequestMapping({"recharge.do"})
  public String recharge(Model model, Integer orderAmount, String bankId, HttpServletRequest req) {
    PaymentInfo payRequest = null;
    try
    {
      OrderInfo order = createOrder(orderAmount);
      payRequest = plainPay(req, order, bankId);
      String generateForm = generateForm(payRequest);
      PayLogUtil.log("LianLian recharge request generatedForm:{}", new Object[] { generateForm });
      model.addAttribute("content", generateForm);
      this.thirdPayService.fill(payRequest, Float.valueOf(orderAmount.intValue()));
    } catch (Exception exception) {
      String msg = MessageFormat.format("参数:orderAmount:{0},{1}", new Object[] { orderAmount, payRequest.toString() });
      PayLogUtil.log(new StringBuilder().append("LianLian 申请充值失败 , ").append(msg.toString()).toString(), exception);
      return "redirect:/member/rechargeApplyFail.do";
    }
    return "/pay/recharge/recharge";
  }

  public String generateForm(PaymentInfo order) {
    BeanMap params = new BeanMap(order);
    StringBuilder formBuilder = new StringBuilder();
    String actionUrl = PropertiesUtils.getProperties("pay.ll.recharge.actionUrl");
    formBuilder.append(new StringBuilder().append("<form id=\"").append(Constants.getFormElementId()).append("\" action=\"").append(actionUrl).append("\" method=\"post\">\r\n").toString());

    Iterator keyIterator = params.keyIterator();
    while (keyIterator.hasNext()) {
      String propertyName = (String)keyIterator.next();
      Object value = params.get(propertyName);
      if ((value != null) && (value instanceof String)) {
        formBuilder.append("<input type=\"hidden\" name=\"").append(propertyName).append("\" value=\"");
        formBuilder.append(StringEscapeUtils.escapeHtml4((String)value)).append("\" />\r\n");
      }
    }
    formBuilder.append("</form>");
    return formBuilder.toString();
  }

  @RequestMapping({"back.do"})
  @ResponseBody
  public String back(HttpServletRequest request) {
    RetBean retBean = new RetBean();
    String reqStr = LLWebPayUtil.readReqStr(request);
    if (LLPayUtil.isnull(reqStr)) {
      PayLogUtil.log(new StringBuilder().append("LianLian /pay/ll/recharge/back.do;reqStr is null ,").append(reqStr).toString());
      retBean.setError();
      return JSON.toJSONString(retBean);
    }
    boolean processResult = false;
    PaymentNotifyRetBean payResponse = null;
    try {
      payResponse = (PaymentNotifyRetBean)JSON.parseObject(reqStr, PaymentNotifyRetBean.class);
      PayLogUtil.log("LianLian recharge back response :{}", new Object[] { payResponse });
      processResult = this.thirdPayService.fillRespond(payResponse, reqStr);
      PayLogUtil.log("LianLian recharge back response process result :{}", new Object[] { Boolean.valueOf(processResult) });
    } catch (Exception exception) {
      StringBuilder builder = new StringBuilder();
      builder.append(new StringBuilder().append("reqStr:").append(reqStr).append("\n").toString());
      if (payResponse != null) {
        builder.append(new StringBuilder().append("payResponse :").append(payResponse.toString()).append("\n").toString());
      }
      PayLogUtil.log(new StringBuilder().append("LianLian 充值回调失败 , ").append(builder.toString()).toString(), exception);
    }
    if (processResult) {
      retBean.setSuccess();
      return JSON.toJSONString(retBean);
    }
    retBean.setError();
    return JSON.toJSONString(retBean);
  }

  @RequestMapping({"success.do"})
  public String success(HttpServletRequest request)
  {
    Map resultMap = request.getParameterMap();
    StringBuffer msg = new StringBuffer();
    Iterator iterator = resultMap.keySet().iterator();
    while (iterator.hasNext()) {
      String key = (String)iterator.next();
      msg.append(new StringBuilder().append(key).append(":").toString());
      msg.append(new StringBuilder().append(resultMap.get(key)).append(";").toString());
    }
    PayLogUtil.log(new StringBuilder().append("LianLian /pay/ll/recharge/success.do;ParameterMap:").append(msg).toString());
    return "/pay/recharge/recharge_success";
  }

  public void setFormGenerator(FormGenerator formGenerator) {
    this.formGenerator = formGenerator;
  }

  private String createRiskItem(ShiroMember currUser)
  {
    JSONObject riskItemObj = new JSONObject();
    riskItemObj.put("frms_ware_category", "2009");
    riskItemObj.put("user_info_mercht_userno", currUser.getId());
    riskItemObj.put("user_info_dt_register", DateUtils.formatDate(currUser.getCreateDate(), "yyyyMMddHHmmss"));
    riskItemObj.put("user_info_full_name", currUser.getRealname());
    riskItemObj.put("user_info_id_no", currUser.getIdcard());
    riskItemObj.put("user_info_identify_type", "3");
    return riskItemObj.toString();
  }

  private PaymentInfo plainPay(HttpServletRequest req, OrderInfo order, String bankId)
  {
    ShiroMember currUser = ShiroWebUtil.getCurrentUser();

    PaymentInfo paymentInfo = new PaymentInfo();
    paymentInfo.setVersion(PropertiesUtils.getProperties("pay.ll.recharge.version"));
    paymentInfo.setOid_partner(PropertiesUtils.getProperties("pay.ll.oid_partner"));
    paymentInfo.setUser_id(String.valueOf(currUser.getId()));
    paymentInfo.setSign_type(PropertiesUtils.getProperties("pay.ll.sign_type"));
    paymentInfo.setBusi_partner(PropertiesUtils.getProperties("pay.ll.busi_partner"));
    paymentInfo.setNo_order(order.getNo_order());
    paymentInfo.setDt_order(order.getDt_order());
    paymentInfo.setName_goods(order.getName_goods());
    paymentInfo.setInfo_order(order.getInfo_order());
    if ("true".equals(PropertiesUtils.getProperties("pay.ll.recharge.debug")))
      paymentInfo.setMoney_order("0.01");
    else {
      paymentInfo.setMoney_order(order.getMoney_order());
    }
    paymentInfo.setNotify_url(PropertiesUtils.getProperties("pay.ll.recharge.notify_url"));
    paymentInfo.setUrl_return(PropertiesUtils.getProperties("pay.ll.recharge.url_return"));
    paymentInfo.setUserreq_ip(LLWebPayUtil.getIpAddr(req).replaceAll("\\.", "_"));

    paymentInfo.setValid_order("10080");
    paymentInfo.setTimestamp(LLPayUtil.getCurrentDateTimeStr());
    paymentInfo.setRisk_item(createRiskItem(currUser));
    if (StringUtils.isNotEmpty(bankId));
    String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(paymentInfo)), PropertiesUtils.getProperties("pay.ll.private.sign_key"), null);
    paymentInfo.setSign(sign);
    return paymentInfo;
  }

  private OrderInfo createOrder(Integer orderAmount)
  {
    OrderInfo orderInfo = new OrderInfo();
    orderInfo.setNo_order(this.serialService.getSerial("payOrderNo", null));
    orderInfo.setDt_order(LLPayUtil.getCurrentDateTimeStr());
    orderInfo.setMoney_order(String.valueOf(orderAmount));
    orderInfo.setName_goods("账户充值");
    orderInfo.setInfo_order("账户充值");
    return orderInfo;
  }
}