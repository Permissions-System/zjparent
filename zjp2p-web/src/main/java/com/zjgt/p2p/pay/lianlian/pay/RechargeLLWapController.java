package com.zjgt.p2p.pay.lianlian.pay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.lianlian.conn.HttpRequestSimple;
import com.zjgt.thirdpay.lianlian.utils.LLPayUtil;
import com.zjgt.thirdpay.lianlian.vo.OrderInfo;
import com.zjgt.thirdpay.lianlian.vo.RetBean;
import com.zjgt.thirdpay.lianlian.vo.wap.UserBankCardRetBean;
import com.zjgt.thirdpay.lianlian.vo.wap.UserBankCardRetBean.Agreement;
import com.zjgt.thirdpay.lianlian.vo.wap.WapPaymentInfo;
import com.zjgt.thirdpay.lianlian.vo.wap.WapPaymentNotifyRetBean;
import com.zjgt.thirdpay.service.PayDealFlowService;
import com.zjgt.thirdpay.service.PayLLService;
import com.zjgt.thirdpay.util.FormGenerator;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.ShiroWebUtil;
import java.text.MessageFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.utils.DateUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/pay/ll/wapRecharge"})
public class RechargeLLWapController
{
  Logger logger;

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

  public RechargeLLWapController()
  {
    this.logger = LoggerFactory.getLogger(RechargeLLWapController.class);
  }

  @RequestMapping({"recharge.do"})
  public String recharge(Model model, Integer orderAmount, HttpServletRequest req)
  {
    WapPaymentInfo payRequest = null;
    try
    {
      OrderInfo order = createOrder(orderAmount);

      String no_agree = null;
      PayLogUtil.log("LianLian wapRecharge request no_agree:{}", new Object[] { no_agree });
      payRequest = plainPay(req, no_agree, order);
      String req_data = JSON.toJSONString(payRequest);
      PayLogUtil.log("LianLian wapRecharge request generatedForm:{}", new Object[] { req_data });
      model.addAttribute("req_data", req_data);
      String actionUrl = PropertiesUtils.getProperties("pay.ll.wapRecharge.actionUrl");
      model.addAttribute("req_action", actionUrl);
      this.thirdPayService.fill(payRequest, Float.valueOf(orderAmount.intValue()));
    } catch (Exception exception) {
      String msg = MessageFormat.format("参数:orderAmount:{0},{1}", new Object[] { orderAmount, payRequest.toString() });
      PayLogUtil.log(new StringBuilder().append("LianLian 申请充值失败 , ").append(msg.toString()).toString(), exception);
      return "redirect:/pay/ll/wapRecharge/rechargeApplyFail.do";
    }
    return "/pay/recharge/wapRecharge";
  }

  @RequestMapping({"rechargeApplyFail"})
  public String rechargeApplyFail() {
    return "/pay/recharge/recharge_apply_fail";
  }

  private String getLastNoAgree()
  {
    UserBankCardRetBean bankCardRetBean = queryBankcardList();
    if ((bankCardRetBean != null) && (bankCardRetBean.getAgreementList() != null)) {
      return ((UserBankCardRetBean.Agreement)bankCardRetBean.getAgreementList().get(0)).getNo_agree();
    }
    return null;
  }

  private UserBankCardRetBean queryBankcardList()
  {
    ShiroMember currUser = ShiroWebUtil.getCurrentUser();
    JSONObject reqObj = new JSONObject();
    reqObj.put("oid_partner", PropertiesUtils.getProperties("pay.ll.oid_partner"));
    reqObj.put("user_id", currUser.getId());
    reqObj.put("offset", "0");
    reqObj.put("sign_type", PropertiesUtils.getProperties("pay.ll.sign_type"));
    reqObj.put("pay_type", "D");
    String sign = LLPayUtil.addSign(reqObj, PropertiesUtils.getProperties("pay.ll.private.sign_key"), null);
    reqObj.put("sign", sign);
    String reqJSON = reqObj.toString();
    this.logger.info(new StringBuilder().append("用户已绑定银行列表查询请求报文[").append(reqJSON).append("]").toString());
    String resJSON = HttpRequestSimple.getInstance().postSendHttp(PropertiesUtils.getProperties("pay.ll.userbankcard.actionUrl"), reqJSON);
    this.logger.info(new StringBuilder().append("用户已绑定银行列表查询响应报文[").append(resJSON).append("]").toString());
    UserBankCardRetBean bankCardRetBean = (UserBankCardRetBean)JSON.parseObject(resJSON, UserBankCardRetBean.class);
    try {
      if ((StringUtils.isNotEmpty(bankCardRetBean.getCount())) && (Integer.parseInt(bankCardRetBean.getCount()) > 0))
        bankCardRetBean.setAgreementList(JSON.parseArray(bankCardRetBean.getAgreement_list(), UserBankCardRetBean.Agreement.class));
    }
    catch (NumberFormatException e) {
      this.logger.warn(new StringBuilder().append("Integer.parseInt(bankCardRetBean.getCount()) error , ").append(bankCardRetBean.getCount()).toString());
    }
    return bankCardRetBean;
  }

  @RequestMapping({"back.do"})
  @ResponseBody
  public String back(HttpServletRequest request) {
    RetBean retBean = new RetBean();
    String reqStr = LLWebPayUtil.readReqStr(request);
    if (LLPayUtil.isnull(reqStr)) {
      PayLogUtil.log(new StringBuilder().append("LianLian /pay/ll/wapRecharge/back.do;reqStr is null ,").append(reqStr).toString());
      retBean.setError();
      return JSON.toJSONString(retBean);
    }
    boolean processResult = false;
    WapPaymentNotifyRetBean payResponse = null;
    try {
      payResponse = (WapPaymentNotifyRetBean)JSON.parseObject(reqStr, WapPaymentNotifyRetBean.class);
      PayLogUtil.log("LianLian wapRecharge back response :{}", new Object[] { payResponse });
      processResult = this.thirdPayService.fillRespond(payResponse, reqStr);
      PayLogUtil.log("LianLian wapRecharge back response process result :{}", new Object[] { Boolean.valueOf(processResult) });
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
  public String success(HttpServletRequest request, Model model)
  {
    String res_data = request.getParameter("res_data");
    if (res_data != null) {
      boolean processResult = false;
      WapPaymentNotifyRetBean payResponse = null;
      try {
        payResponse = (WapPaymentNotifyRetBean)JSON.parseObject(res_data, WapPaymentNotifyRetBean.class);
        PayLogUtil.log("LianLian wapRecharge success response :{}", new Object[] { payResponse });
        processResult = this.thirdPayService.fillRespond(payResponse, res_data);
        PayLogUtil.log("LianLian wapRecharge success response process result :{}", new Object[] { Boolean.valueOf(processResult) });
      } catch (Exception exception) {
        StringBuilder builder = new StringBuilder();
        builder.append(new StringBuilder().append("reqStr:").append(res_data).append("\n").toString());
        if (payResponse != null) {
          builder.append(new StringBuilder().append("payResponse :").append(payResponse.toString()).append("\n").toString());
        }
        PayLogUtil.log(new StringBuilder().append("LianLian wapRecharge 充值同步烦返回处理失败 , ").append(builder.toString()).toString(), exception);
      }

    }

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
    riskItemObj.put("user_info_identify_state", "0");
    riskItemObj.put("user_info_identify_type", "4");
    return riskItemObj.toString();
  }

  private WapPaymentInfo plainPay(HttpServletRequest req, String no_agree, OrderInfo order)
  {
    ShiroMember currUser = ShiroWebUtil.getCurrentUser();

    WapPaymentInfo payInfo = new WapPaymentInfo();
    payInfo.setApp_request("3");
    payInfo.setBusi_partner(PropertiesUtils.getProperties("pay.ll.busi_partner"));
    payInfo.setDt_order(order.getDt_order());
    payInfo.setId_no(currUser.getIdcard());
    payInfo.setInfo_order(order.getInfo_order());
    if ("true".equals(PropertiesUtils.getProperties("pay.ll.recharge.debug")))
      payInfo.setMoney_order("0.01");
    else {
      payInfo.setMoney_order(order.getMoney_order());
    }
    payInfo.setName_goods(order.getName_goods());
    if (StringUtils.isNotEmpty(no_agree)) {
      payInfo.setNo_agree(no_agree);
    }
    payInfo.setNo_order(order.getNo_order());
    payInfo.setNotify_url(PropertiesUtils.getProperties("pay.ll.wapRecharge.notify_url"));
    payInfo.setOid_partner(PropertiesUtils.getProperties("pay.ll.oid_partner"));
    payInfo.setAcct_name(currUser.getRealname());
    payInfo.setRisk_item(createRiskItem(currUser));
    String card_no = this.memberservice.findMembersafety(currUser.getId().longValue()).getBankcardno();
    payInfo.setCard_no(card_no);
    payInfo.setSign_type(PropertiesUtils.getProperties("pay.ll.sign_type"));
    payInfo.setUrl_return(PropertiesUtils.getProperties("pay.ll.wapRecharge.url_return"));
    payInfo.setUser_id(String.valueOf(currUser.getId()));
    payInfo.setValid_order(PropertiesUtils.getProperties("pay.ll.recharge.valid_order"));

    String sign = LLPayUtil.addSign(JSON.parseObject(JSON.toJSONString(payInfo)), PropertiesUtils.getProperties("pay.ll.private.sign_key"), null);
    payInfo.setSign(sign);
    return payInfo;
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