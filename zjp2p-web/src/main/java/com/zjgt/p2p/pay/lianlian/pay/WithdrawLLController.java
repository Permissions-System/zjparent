package com.zjgt.p2p.pay.lianlian.pay;

import com.alibaba.fastjson.JSON;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.thirdpay.lianlian.utils.LLPayUtil;
import com.zjgt.thirdpay.lianlian.vo.CashNotifyRetBean;
import com.zjgt.thirdpay.lianlian.vo.RetBean;
import com.zjgt.thirdpay.service.PayLLService;
import com.zjgt.thirdpay.util.PayLogUtil;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.MessageFormat;
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
@RequestMapping({"/pay/ll/withdraw"})
public class WithdrawLLController
{

  @Autowired
  private PayLLService payService;

  @RequestMapping({"withdraw.do"})
  @ResponseBody
  public JsonResponse withdraw(ModelAndView andView, boolean isRapid, double amount, String bankName, String bankCode, String bankAcountNo, String bankAcountName, String bankprince, String bankcity, String subBankName)
    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException
  {
    JsonResponse jsonResponse = new JsonResponse();
    Long userId = null;
    try {
      Subject subject = SecurityUtils.getSubject();
      ShiroMember currUser = null;
      currUser = (ShiroMember)subject.getPrincipal();
      userId = currUser.getId();
      String bankAcountIdCard = currUser.getIdcard();
      String resultMsg = this.payService.withdraw(userId, isRapid, BigDecimal.valueOf(amount), bankName, bankCode, bankAcountNo, bankAcountName, bankAcountIdCard, bankprince, bankcity, subBankName);
      if (resultMsg == null) {
        jsonResponse.setStatus("SUCCESS");
        jsonResponse.setMsg("申请提现成功");
      } else {
        jsonResponse.setStatus("FAIL");
        jsonResponse.setMsg(resultMsg);
      }
    } catch (Exception exception) {
      String msg = MessageFormat.format("参数:{0},{1},{2},{3},{4},{5},{6},{7},{8}", new Object[] { userId, Boolean.valueOf(isRapid), Double.valueOf(amount), bankName, bankAcountNo, bankAcountName, bankprince, bankcity, subBankName });
      PayLogUtil.log("LianLian 申请提现失败 , " + msg.toString(), exception);
      jsonResponse.setStatus("FAIL");
      jsonResponse.setMsg("申请提现失败");
    }
    return jsonResponse;
  }

  @RequestMapping({"back.do"})
  @ResponseBody
  public String back(HttpServletRequest request) {
    CashNotifyRetBean payResponse = null;
    String reqStr = LLWebPayUtil.readReqStr(request);
    if (LLPayUtil.isnull(reqStr)) {
      PayLogUtil.log("LianLian /pay/ll/withdraw/back.do;reqStr is null ," + reqStr);
      return JSON.toJSONString(RetBean.getErrorObj());
    }
    boolean flag = false;
    try {
      payResponse = (CashNotifyRetBean)JSON.parseObject(reqStr, CashNotifyRetBean.class);
      PayLogUtil.log("LianLian withdraw back reqStr :{} ,response :{}", new Object[] { reqStr, payResponse });
      flag = this.payService.withdrawRespond(payResponse, reqStr);
      PayLogUtil.log("LianLian withdraw back response process result :{} , batchNumber is {}", new Object[] { Boolean.valueOf(flag), payResponse.getNo_order() });
    } catch (Exception exception) {
      PayLogUtil.log("LianLian 提现回调失败 , reqStr:" + reqStr, exception);
    }
    if (flag) {
      return JSON.toJSONString(RetBean.getSuccessObj());
    }
    return JSON.toJSONString(RetBean.getErrorObj());
  }
}