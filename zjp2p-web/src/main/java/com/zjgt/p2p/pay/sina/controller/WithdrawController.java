package com.zjgt.p2p.pay.sina.controller;

import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.domain.BatchRapidPayToBankcardResponse;
import com.zjgt.thirdpay.service.PayService;
import com.zjgt.thirdpay.util.MapToBean;
import com.zjgt.thirdpay.util.PayLogUtil;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.MessageFormat;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springfk.pancloud.domain.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/pay/withdraw"})
public class WithdrawController
{

  @Autowired
  private PayService payService;

  @RequestMapping({"withdraw.do"})
  @ResponseBody
  public JsonResponse withdraw(ModelAndView andView, boolean isRapid, double amount, String bankName, String bankAcountNo, String bankAcountName, String bankprince, String bankcity, String subBankName)
    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException
  {
    JsonResponse jsonResponse = new JsonResponse();
    Long userId = null;
    try {
      Subject subject = SecurityUtils.getSubject();
      ShiroMember currUser = null;
      currUser = (ShiroMember)subject.getPrincipal();
      userId = currUser.getId();

      String resultMsg = this.payService.withdraw(userId, isRapid, BigDecimal.valueOf(amount), bankName, bankAcountNo, bankAcountName, bankprince, bankcity, subBankName);
      if (resultMsg == null) {
        jsonResponse.setStatus("SUCCESS");
        jsonResponse.setMsg("申请提现成功");
      } else {
        jsonResponse.setStatus("FAIL");
        jsonResponse.setMsg(resultMsg);
      }
    } catch (Exception exception) {
      String msg = MessageFormat.format("参数:{0},{1},{2},{3},{4},{5},{6},{7},{8}", new Object[] { userId, Boolean.valueOf(isRapid), Double.valueOf(amount), bankName, bankAcountNo, bankAcountName, bankprince, bankcity, subBankName });
      PayLogUtil.log(new StringBuilder().append("申请提现失败 , ").append(msg.toString()).toString(), exception);
      jsonResponse.setStatus("FAIL");
      jsonResponse.setMsg("申请提现失败");
    }
    return jsonResponse;
  }

  @RequestMapping({"back.do"})
  @ResponseBody
  public String back(HttpServletRequest request)
  {
    boolean flag = false;
    Map resultMap = null;
    BatchRapidPayToBankcardResponse payResponse = null;
    try {
      resultMap = request.getParameterMap();
      payResponse = (BatchRapidPayToBankcardResponse)MapToBean.getBean(resultMap, BatchRapidPayToBankcardResponse.class);
      PayLogUtil.log("withdraw back response :{}", new Object[] { payResponse });
      flag = this.payService.withdrawRespond(payResponse);
      PayLogUtil.log("withdraw back response process result :{} , batchNumber is {}", new Object[] { Boolean.valueOf(flag), payResponse.getBatchNumber() });
    } catch (Exception exception) {
      StringBuilder builder = new StringBuilder();
      if (resultMap != null) {
        builder.append(new StringBuilder().append("ParameterMap:").append(resultMap.toString()).append("\n").toString());
      }
      if (payResponse != null) {
        builder.append(new StringBuilder().append("payResponse :").append(payResponse.toString()).append("\n").toString());
      }
      PayLogUtil.log(new StringBuilder().append("提现回调失败 , ").append(builder.toString()).toString(), exception);
    }
    if (flag) {
      return "<result>1</result>";
    }
    return "<result>0</result>";
  }
}