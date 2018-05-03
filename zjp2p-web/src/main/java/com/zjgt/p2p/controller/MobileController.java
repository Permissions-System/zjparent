package com.zjgt.p2p.controller;

import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.util.email.EmailBean;
import com.zjgt.p2p.util.email.SendEmail;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.util.DrawImgeUtil;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.SafeUtil;
import java.io.IOException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"membersafety"})
public class MobileController
{

  @Autowired
  private MemberService memberservice;

  @Autowired
  private ISmsService ismsservice;
  Logger logger;

  public MobileController()
  {
    this.logger = LoggerFactory.getLogger(MemberController.class);
  }

  @RequestMapping({"/mobiledraw"})
  public void mobiledraw(HttpServletRequest request, HttpServletResponse response)
  {
    String msg = null;
    HttpSession session = request.getSession();
    try {
      msg = DrawImgeUtil.getValidationCodes(response.getOutputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    session.setAttribute("msg", msg);
    this.logger.info("msg:" + msg);
  }

  @RequestMapping(value={"/mobileregister"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView register(ModelAndView mv)
  {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated())
      mv.setViewName("mobileregister_success");
    else {
      mv.setViewName("mobileregister");
    }
    return mv;
  }

  @RequestMapping(value={"/mobileregister"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView register(ModelAndView mv, Member member, HttpServletRequest request)
  {
    String plainPwd = member.getPassword();

    member.setRegisterIp(request.getRemoteAddr());

    member.setLoginIp(request.getRemoteAddr());

    member.setNickname(java.util.UUID.randomUUID().toString().split("-")[0]);

    String emailverifyuuid = java.util.UUID.randomUUID().toString().split("-")[0];

    member = this.memberservice.register(member, emailverifyuuid);
    try
    {
      SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的邮箱认证邮件", member.getEmail(), getEmailAuthenticationContext(member.getEmail(), emailverifyuuid)));
    }
    catch (Exception e)
    {
      this.logger.error("发送邮箱认证邮件 , email:" + member.getEmail() + "\n" + e.getMessage(), e);
    }

    return shiroLoginByRegister(mv, member, plainPwd);
  }

  private ModelAndView shiroLoginByRegister(ModelAndView mv, Member member, String plainPwd)
  {
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken();
    token.setUsername(member.getEmail());
    token.setPassword(plainPwd.toCharArray());
    try {
      subject.login(token);
    } catch (Exception e) {
      this.logger.error("注册成功 subject.login 登录失败 , memberId = " + member.getId() + " , plainPwd=" + plainPwd, e);

      mv.setViewName("redirect:/login.do");
      mv.addObject("errormsg", "自动登录失败");
      mv.addObject("username", member.getEmail());
      return mv;
    }
    mv.setViewName("redirect: /authentication.do");
    return mv;
  }

  private String getRegistryNoticeContext() throws Exception {
    String emailContext = PropertiesUtils.getProperties("email.context.registryNotice");

    String emailPre = PropertiesUtils.getProperties("email");

    return (emailContext = MessageFormat.format(emailContext, new Object[] { emailPre + "static/images/twocode/baifu_new.jpg", emailPre + "static/images/twocode/baifu360.jpg", emailPre + "static/images/twocode/baifu.jpg" }));
  }

  private String getEmailAuthenticationContext(String email, String emailverifyuuid)
    throws Exception
  {
    String emailContext = PropertiesUtils.getProperties("email.context.authentication");

    String emailContextDate = DateUtils.getCurrentFormatDate("yyyy年 MM月dd日 HH时mm分ss秒");

    String emailContextUrl = PropertiesUtils.getEmail("email") + "member/authenticationEmail.do?email=" + email + "&emailverifyuuid=" + emailverifyuuid;

    return (emailContext = MessageFormat.format(emailContext, new Object[] { emailContextDate, "<a href='" + emailContextUrl + "'>" + emailContextUrl + "<a/>" }));
  }

  @RequestMapping({"/mobileemailajax"})
  @ResponseBody
  public JsonResponse mobileemailajax(String email)
  {
    this.logger.info("email:" + email);
    JsonResponse jsonResponse = new JsonResponse();
    if (this.memberservice.findByEmail(email))
      jsonResponse.setResult("E-mail可用");
    else {
      jsonResponse.setResult("E-mail不可用");
    }
    return jsonResponse;
  }

  @RequestMapping(value={"/authentication"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView authentication(ModelAndView mv)
  {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      mv.setViewName("mobileregister_success");
      return mv;
    }
    mv.setViewName("redirect:/mobileregister.do");
    return mv;
  }

  @RequestMapping(value={"/authentication"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView authentication(ModelAndView mv, String idcard, String realname, String mobile)
  {
    this.logger.info("membersafety" + realname + mobile + idcard);
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
      if (realname != null) {
        currUser.setRealname(realname);
      }
      if (idcard != null) {
        currUser.setIdcard(idcard);
      }
      Membersafety membersafety = this.memberservice.authenticationIDcard(currUser.getId().longValue(), idcard, realname);
      if (mobile != null) {
        currUser.setMobile(mobile);
        this.memberservice.authenticationMobil(currUser.getId().longValue(), membersafety.getId().longValue(), mobile);
        membersafety.setMobile(mobile);
        membersafety.setMobileifverified(Integer.valueOf(1));
        membersafety.setMobileifverifydate(new Date());
      }
      mv.addObject("membersafety", membersafety);
      mv.setViewName("redirect: /mobileregisterfinish.do");
      return mv;
    }
    mv.setViewName("redirect:/mobileregister.do");
    return mv;
  }

  @RequestMapping({"/mobileregisterfinish"})
  public ModelAndView mobileregisterfinish(ModelAndView mv) {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated())
      mv.setViewName("mobileregister_finish");
    else {
      mv.setViewName("redirect:/mobileregister.do");
    }
    return mv;
  }

  @RequestMapping({"/ismobilereg"})
  @ResponseBody
  public JsonResponse phoneIsUsable(String mobile)
  {
    JsonResponse jsonResponse = new JsonResponse();
    if (this.memberservice.getMobileForMember(mobile) > 0)
    {
      jsonResponse.setStatus("0");
    }
    else {
      jsonResponse.setStatus("1");
    }
    return jsonResponse;
  }

  @RequestMapping({"/regmobile"})
  public ModelAndView regMobile(ModelAndView mv, String activity)
  {
    if ("JDB".equals(activity)) {
      mv.setViewName("/mobile/jdb/mobile");
    }
    else if ("PUBLIC".equals(activity)) {
      mv.setViewName("/mobile/public/mobile");
    }
    else if ("RED".equals(activity))
      mv.setViewName("/mobile/red/mobile");
    else {
      mv.setViewName("/mobile/red/mobile");
    }
    return mv;
  }

  @RequestMapping({"/member/mobileregsuccess"})
  public ModelAndView regMobileSuc(ModelAndView mv, String activity)
  {
    if ("JDB".equals(activity)) {
      mv.setViewName("/mobile/jdb/mobilesuc");
    }
    else if ("PUBLIC".equals(activity)) {
      mv.setViewName("/mobile/public/mobilesuc");
    }
    else if ("RED".equals(activity))
      mv.setViewName("/mobile/red/mobilesuc");
    else {
      mv.setViewName("/mobile/red/mobilesuc");
    }
    return mv;
  }

  @RequestMapping({"/member/mobilefin"})
  public ModelAndView regMobileFin(ModelAndView mv, String activity) {
    if ("JDB".equals(activity)) {
      mv.setViewName("/mobile/jdb/mobilefin");
    }
    else if ("PUBLIC".equals(activity)) {
      mv.setViewName("/mobile/public/mobilefin");
    }
    else if ("RED".equals(activity))
      mv.setViewName("/mobile/red/mobilefin");
    else {
      mv.setViewName("/mobile/red/mobilefin");
    }
    return mv;
  }

  @RequestMapping({"/sendMobilcode"})
  @ResponseBody
  public void sendMobil(HttpSession session, String mobile)
  {
    int mobilecode = (int)((Math.random() * 9.0D + 1.0D) * 100000.0D);
    Date date = new Date();
    session.setAttribute("code", mobilecode + "_" + date.getTime());
    try
    {
      this.ismsservice.send(mobile, mobilecode + "");
    } catch (Exception e) {
      this.logger.error("手机验证码发送失败");
    }
  }

  @RequestMapping({"/mobilecodeisright"})
  @ResponseBody
  public JsonResponse mobilecodeisright(HttpSession session, String code)
  {
    JsonResponse jsonResponse = new JsonResponse();
    String code1 = (String)session.getAttribute("code");

    long time = new Date().getTime();
    if (code == null) {
      jsonResponse.setResult("验证码错误");
      return jsonResponse;
    }
    if (code1 == null) {
      jsonResponse.setResult("验证码错误");
      return jsonResponse;
    }
    if (time - Long.parseLong(code1.split("_")[1]) < 600000L) {
      if (code1.split("_")[0].equals(code)) {
        jsonResponse.setResult("验证码正确");
      }
      else {
        jsonResponse.setResult("验证码错误");
      }
      return jsonResponse;
    }
    jsonResponse.setResult("验证超时");
    return jsonResponse;
  }

  @RequestMapping(value={"/member/idcard"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public JsonResponse authenticationIDcard(ModelAndView mv, String realname, String idcard)
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    currUser.setRealname(realname);
    currUser.setIdcard(idcard);
    this.memberservice.authenticationIDcard(currUser.getId().longValue(), idcard, realname);

    jsonResponse.setStatus("1");
    return jsonResponse; }

  @RequestMapping({"/mpwd"})
  @ResponseBody
  public JsonResponse modifyPassword(HttpSession session, String code, String password, String mobile) {
    System.out.println("code:" + code + "mobile:" + mobile + "password:" + password);
    JsonResponse jsonResponse = new JsonResponse();
    String code1 = (String)session.getAttribute("code");
    if ((code1 != null) && (code1.split("_")[0].equals(code))) {
      jsonResponse.setStatus("1");
      this.memberservice.modifyPasswordByMobile(mobile, SafeUtil.generatePassword(password));
    }
    return jsonResponse;
  }
}