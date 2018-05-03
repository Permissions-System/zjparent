package com.zjgt.p2p.controller;

import com.zjgt.p2p.base.util.IdcardUtils;
import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.exception.MemberException;
import com.zjgt.p2p.model.Cpsrec;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberActPwd;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.service.BonusService;
import com.zjgt.p2p.service.CpsRegService;
import com.zjgt.p2p.service.ISmsService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.util.email.EmailBean;
import com.zjgt.p2p.util.email.SendEmail;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.shiro.token.NoPasswordToken;
import com.zjgt.shiro.token.OAuthQQToken;
import com.zjgt.util.BankcardUtil;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.DrawImgeUtil;
import com.zjgt.util.PropertiesUtils;
import com.zjgt.util.SafeUtil;
import com.zjgt.util.SmsUtil;
import com.zjgt.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.kit.PathKit;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"member", "uuid", "membersafety"})
public class MemberController
{
  Logger logger;

  @Autowired
  private MemberService memberservice;

  @Autowired
  private BonusService bonusService;

  @Autowired
  private ISmsService ismsservice;

  @Autowired
  private MemberAcctService memberacctservice;

  @Autowired
  private MessageService messageService;

  @Autowired
  private CpsRegService cpsregService;
  public static Integer lock = Integer.valueOf(0);

  public MemberController()
  {
    this.logger = LoggerFactory.getLogger(MemberController.class);
  }

  @RequestMapping({"/member/redpacketAcct"})
  @ResponseBody
  public JsonResponse toRedpacketrecord()
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    MemberAcct mac = this.memberacctservice.findByMemberId(currUser.getId(), Integer.valueOf(AcctType.GIFT.getKey()));
    JsonResponse jsonResponse = new JsonResponse();
    jsonResponse.setResult(mac);
    return jsonResponse;
  }

  @RequestMapping({"/marketingmsg"})
  @ResponseBody
  public void marketingmsg()
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
      SmsUtil smsutil = new SmsUtil();
      smsutil.sendbyweixin2(currUser.getMobile(), "  我们希望在用户注册以后，系统自动触发一条通知短息给用户，内容为：恭喜您成为百富网天使级会员，点击www.biifoo.com实名认证并绑定银行卡就能获得1000元的红包，还有8%收益的活期产品等着您哦！");
    }
  }

  @RequestMapping(value={"/draw"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void draw(HttpServletResponse response, HttpServletRequest request)
  {
    String msg = null;
    HttpSession session = request.getSession();
    try {
      msg = DrawImgeUtil.getValidationCodes(response.getOutputStream());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    session.setAttribute("msg", msg);
  }

  @RequestMapping({"imgcheck.do"})
  @ResponseBody
  public JsonResponse imgCheck(HttpServletRequest request, String msg)
  {
    this.logger.info("date:" + new Date().toLocaleString());
    JsonResponse jsonResponse = new JsonResponse();
    String msg0 = (String)request.getSession().getAttribute("msg");
    String msg1 = msg0.toLowerCase();
    if (!(msg.toLowerCase().equals(msg1))) {
      jsonResponse.setStatus("1");
      jsonResponse.setResult("验证码错误");
      return jsonResponse;
    }
    jsonResponse.setStatus("2");
    jsonResponse.setResult("验证码正确");
    return jsonResponse;
  }

  @RequestMapping({"/modifyemail"})
  public void modifyEmail(Member member, HttpServletResponse response)
  {
    PrintWriter out = null;
    try {
      out = response.getWriter();
      if (this.memberservice.modifyemail(member) == 0)
        out.write("修改失败");
      else
        out.write("修改成功");
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
    out.flush();
    out.close();
  }

  @RequestMapping({"/member/modifynickname"})
  @ResponseBody
  public JsonResponse modifyNickname(Member member)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    member.setId(currUser.getId());
    currUser.setNickname(member.getNickname());
    this.memberservice.modifyNickname(member);
    JsonResponse jsonResponse = new JsonResponse();
    jsonResponse.setStatus("1");
    jsonResponse.setResult(member.getNickname());
    return jsonResponse;
  }

  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String registerAfter(HttpServletRequest request) {
    String channel = request.getParameter(Const.CHANNEL);
    String channel2 = request.getParameter(Const.CHANNEL2);
    if (StringUtil.isNotEmpty(channel))
      request.getSession().setAttribute(Const.CHANNEL, channel);
    else {
      channel = (String)request.getSession().getAttribute(Const.CHANNEL);
    }
    if (StringUtil.isNotEmpty(channel2))
      request.getSession().setAttribute(Const.CHANNEL2, channel2);
    else {
      channel2 = (String)request.getSession().getAttribute(Const.CHANNEL2);
    }
    this.logger.info("注册channel:" + channel);
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      return "redirect:/index.do";
    }
    return "register";
  }

  @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public synchronized ModelAndView register(Member member, ModelAndView mv, HttpServletRequest request, String msg)
  {
    String plainPwd = member.getPassword();

    member.setRegisterIp(request.getRemoteAddr());

    member.setLoginIp(request.getRemoteAddr());

    member.setNickname(UUID.randomUUID().toString().split("-")[0]);

    String emailverifyuuid = UUID.randomUUID().toString().split("-")[0];

    member = this.memberservice.register(member, emailverifyuuid);
    try
    {
      SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的注册确认邮件", member.getEmail(), getRegistryNoticeContext()));
    } catch (Exception e) {
      this.logger.error("发送注册确认邮件 , email:" + member.getEmail() + "\n" + e.getMessage(), e);
    }
    try
    {
      SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的邮箱认证邮件", member.getEmail(), getEmailAuthenticationContext(member.getEmail(), emailverifyuuid)));
    } catch (Exception e) {
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
    mv.setViewName("redirect:/member/reg_return.do");
    return mv;
  }

  @RequestMapping(value={"/registerAjax"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public synchronized JsonResponse registerAjax(Member member, ModelAndView mv, HttpServletRequest request, String msg, String code)
  {
    JsonResponse jsonResponse = new JsonResponse();
    String realcode = (String)request.getSession().getAttribute("code");
    if (realcode == null) {
      jsonResponse.setResult("验证码错误");
      jsonResponse.setStatus("0");
      return jsonResponse;
    }
    if (!(realcode.split("_")[0].equals(code))) {
      jsonResponse.setResult("验证码错误");
      jsonResponse.setStatus("0");
      return jsonResponse;
    }
    this.logger.info("member email" + member.getEmail() + " mobile" + member.getMobile());
    if (member.getEmail().equals("")) {
      member.setEmail(null);
    }
    String plainPwd = member.getPassword();

    member.setRegisterIp(getIpAddr(request));

    member.setLoginIp(getIpAddr(request));

    member.setNickname(UUID.randomUUID().toString().split("-")[0]);

    String emailverifyuuid = UUID.randomUUID().toString().split("-")[0];

    member = this.memberservice.register(member, emailverifyuuid);

    if (member.getEmail() != null) {
      try {
        SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的注册确认邮件", member.getEmail(), getRegistryNoticeContext()));
      } catch (Exception e) {
        this.logger.error("发送注册确认邮件 , email:" + member.getEmail() + "\n" + e.getMessage(), e);
      }
      try
      {
        SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的邮箱认证邮件", member.getEmail(), getEmailAuthenticationContext(member.getEmail(), emailverifyuuid)));
      } catch (Exception e) {
        this.logger.error("发送邮箱认证邮件 , email:" + member.getEmail() + "\n" + e.getMessage(), e);
      }
    }
    String channel = (String)request.getSession().getAttribute(Const.CHANNEL);
    if (StringUtil.isNotEmpty(channel)) {
      Cpsrec cpsrec = new Cpsrec();
      cpsrec.setChannel(channel);
      String channel2 = (String)request.getSession().getAttribute(Const.CHANNEL2);
      if (StringUtil.isNotEmpty(channel2)) {
        cpsrec.setChannel2(channel2);
      }
      cpsrec.setMemberid(member.getId());
      cpsrec.setPagename("");
      cpsrec.setUrl(request.getRequestURL().toString());
      cpsrec.setOpdate(new Date());
      this.cpsregService.cpsRec(cpsrec, "registerAjax.do");
    }

    return shiroLoginByRegisterAjax(jsonResponse, member, plainPwd);
  }

  public String getIpAddr(HttpServletRequest request)
  {
    String ipAddress = request.getHeader("x-forwarded-for");
    if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
    {
      ipAddress = request.getHeader("Proxy-Client-IP");
    }
    if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
    {
      ipAddress = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ipAddress == null) || (ipAddress.length() == 0) || ("unknown".equalsIgnoreCase(ipAddress)))
    {
      ipAddress = request.getRemoteAddr();
      if ((ipAddress.equals("127.0.0.1")) || (ipAddress.equals("0:0:0:0:0:0:0:1")))
      {
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          this.logger.debug("获取ip地址发生异常");
        }
        ipAddress = inet.getHostAddress();
      }
    }

    if ((ipAddress != null) && (ipAddress.length() > 15) && 
      (ipAddress.indexOf(",") > 0)) {
      ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
    }

    return ipAddress; }

  private ModelAndView shiroLoginByAuthEmailSuccess(String email, ModelAndView mv) {
    Member member = this.memberservice.findMemberByEmail(email);
    if (member != null)
    {
      NoPasswordToken token = new NoPasswordToken();
      token.setKey(email);
      token.setMember(member);
      try {
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
      } catch (Exception e) {
        this.logger.error("邮箱验证成功后自动登录失败 , email = " + email, e);
        mv.setViewName("redirect:/login.do");
        mv.addObject("errormsg", "自动登录失败");
        mv.addObject("username", email);
        return mv;
      }
    } else {
      this.logger.warn("authenticationEmail 成功,但无法通过email获取member,所以无法自动登录. email:" + email);
    }
    mv.setViewName("redirect:/member/securitycenter.do");
    return mv;
  }

  private JsonResponse shiroLoginByRegisterAjax(JsonResponse jsonResponse, Member member, String plainPwd) {
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken();
    if (member.getMobile() != null)
      token.setUsername(member.getMobile());
    else {
      token.setUsername(member.getEmail());
    }
    token.setPassword(plainPwd.toCharArray());
    try {
      subject.login(token);
    } catch (Exception e) {
      this.logger.error("注册成功 subject.login 登录失败 , memberId = " + member.getId() + " , plainPwd=" + plainPwd, e);

      jsonResponse.setStatus("0");
      jsonResponse.setResult("自动登录失败");
      return jsonResponse;
    }

    jsonResponse.setStatus("1");
    return jsonResponse;
  }

  @RequestMapping({"/emailajax"})
  @ResponseBody
  public JsonResponse ajax(String email)
  {
    JsonResponse jsonResponse = new JsonResponse();
    if (this.memberservice.findByEmail(email))
      jsonResponse.setResult("E-mail可用");
    else {
      jsonResponse.setResult("E-mail不可用");
    }
    return jsonResponse;
  }

  @RequestMapping({"/sendemailagain"})
  @ResponseBody
  public JsonResponse sendemailagein(String email)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }

    String emailverifyuuid = UUID.randomUUID().toString().split("-")[0];
    JsonResponse jsonResponse = new JsonResponse();
    if (currUser.getEmail() == null) {
      Member member = new Member();
      member.setId(currUser.getId());
      member.setEmail(email);
      this.memberservice.updateformthree(member, emailverifyuuid);
      try {
        SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的邮箱认证邮件", email, getEmailAuthenticationContext(email, emailverifyuuid)));
      } catch (Exception e) {
        this.logger.error("邮件发送失败:" + currUser.getEmail(), e);
        jsonResponse = new JsonResponse();
        jsonResponse.setResult("邮件发送失败");
        return jsonResponse;
      }
      jsonResponse.setResult("邮件发送成功");
      return jsonResponse;
    }
    Membersafety ms = new Membersafety();
    ms.setMemberid(currUser.getId());
    ms.setEmailverifydate(new Date());

    ms.setEmailverifyuuid(emailverifyuuid);
    this.memberservice.updateMembersafety(ms);
    try {
      SendEmail.sendHtmlEmail(EmailBean.getbean("来自百富网的邮箱认证邮件", currUser.getEmail(), getEmailAuthenticationContext(currUser.getEmail(), emailverifyuuid)));
    } catch (Exception e) {
      this.logger.error("邮件发送失败:" + currUser.getEmail(), jsonResponse);     
      jsonResponse.setResult("邮件发送失败");
      return jsonResponse;
    }
    jsonResponse.setResult("邮件发送成功");
    return jsonResponse;
  }

  private String getEmailAuthenticationContext(String email, String emailverifyuuid) throws Exception {
    String emailContext = PropertiesUtils.getProperties("email.context.authentication");
    String emailContextDate = DateUtils.getCurrentFormatDate("yyyy年 MM月dd日 HH时mm分ss秒");
    String emailContextUrl = PropertiesUtils.getEmail("email") + "member/authenticationEmail.do?email=" + email + "&emailverifyuuid=" + emailverifyuuid;
    return (emailContext = MessageFormat.format(emailContext, new Object[] { emailContextDate, "<a href='" + emailContextUrl + "'>" + emailContextUrl + "<a/>" }));
  }

  private String getRegistryNoticeContext() throws Exception {
    String emailContext = PropertiesUtils.getProperties("email.context.registryNotice");

    String emailPre = PropertiesUtils.getProperties("email");

    return (emailContext = MessageFormat.format(emailContext, new Object[] { emailPre + "static/images/twocode/baifu_new.jpg", emailPre + "static/images/twocode/baifu360.jpg", emailPre + "static/images/twocode/baifu.jpg" }));
  }

  @RequestMapping(value={"/qqloginafter"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView qqLogin(String openid, ModelAndView mv)
  {
    if (openid == null) {
      throw new MemberException("QQ登录失败");
    }
    Member member = this.memberservice.findByOpenId(openid);
    if (member == null) {
      member = new Member();
      member.setOpenid(openid);
      this.memberservice.registerQQ(member);
    }
    if (StringUtil.isNotEmpty(openid)) {
      Subject subject = SecurityUtils.getSubject();
      OAuthQQToken authQQToken = new OAuthQQToken();
      authQQToken.setOpenId(openid);
      authQQToken.setMember(member);
      try {
        subject.login(authQQToken);
      } catch (Exception e) {
        this.logger.error("subject.login 登录失败 , openID = " + openid, e);
        mv.setViewName("redirect:/login.do");
        mv.addObject("errormsg", "自动登录失败 ");
        return mv;
      }
    }
    mv.setViewName("redirect:/index.do");
    return mv;
  }

  @RequestMapping({"/find"})
  @ResponseBody
  public void findPassword(Member member, HttpServletRequest request)
  {
    String uuid = UUID.randomUUID().toString();

    this.memberservice.updataPassword(member, uuid);
    try
    {
      String sendContext = PropertiesUtils.getProperties("email.context.updatePwNotice");
      String url = PropertiesUtils.getEmail("email") + "ismodify.do?uuid=" + uuid;
      sendContext = MessageFormat.format(sendContext, new Object[] { url, url });
      SendEmail.sendHtmlEmail(EmailBean.getbean(member.getEmail(), sendContext));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @RequestMapping({"/ismodify"})
  public ModelAndView isModify(String uuid, ModelAndView mv)
  {
    if (this.memberservice.findUUIDIsValid(uuid)) {
      mv.addObject("uuid", uuid);
      mv.setViewName("redirect:/reset_pwd2.do");
    } else {
      throw new MemberException("邮件失效了");
    }
    return mv;
  }

  @RequestMapping({"/modifypassword"})
  @ResponseBody
  public JsonResponse modifypassword(HttpSession session, MemberActPwd mbwp, Member member, ModelAndView mv)
  {
    JsonResponse jsonResponse = new JsonResponse();
    if ((mbwp.getPwduuid() != null) && (mbwp.getPwduuid().equals((String)session.getAttribute("uuid")))) {
      mbwp.setUuidisvalid(Boolean.valueOf(false));
      this.memberservice.modifyPassword(mbwp, member);
      jsonResponse.setResult("修改成功");
    } else {
      jsonResponse.setResult("修改失败");
    }
    return jsonResponse;
  }

  @RequestMapping({"/member/oldpasswordisright"})
  @ResponseBody
  public JsonResponse oldpasswordisright(String oldpassword)
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if (currUser.getPassword().equals(SafeUtil.generatePassword(oldpassword))) {
      jsonResponse.setResult("密码匹配");
      return jsonResponse;
    }
    jsonResponse.setResult("密码错误");
    return jsonResponse;
  }

  @RequestMapping(value={"/member/sendMobilcode"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
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

  @RequestMapping({"/member/mobilecodeisright"})
  @ResponseBody
  public JsonResponse mobilecodeisright(HttpSession session, String code)
  {
    JsonResponse jsonResponse = new JsonResponse();
    String code1 = (String)session.getAttribute("code");

    long time = new Date().getTime();
    if (code == null)
    {
      jsonResponse.setResult("验证码错误");
      return jsonResponse;
    }
    if (code1 == null) {
      jsonResponse.setResult("验证码错误");
      return jsonResponse;
    }
    if (time - Long.parseLong(code1.split("_")[1]) < 600000L) {
      if (code1.split("_")[0].equals(code)) {
        jsonResponse.setStatus("1");
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

  @RequestMapping(value={"/member/alterPassword"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String alterPassword(String newpassword)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    currUser.setPassword(SafeUtil.generatePassword(newpassword));
    this.memberservice.alterPassword(currUser.getId().longValue(), SafeUtil.generatePassword(newpassword));
    this.messageService.sendMessage("message.password", currUser.getId().longValue(), new String[0]);
    return "redirect:securitycenter.do";
  }

  @RequestMapping(value={"/member/authenticationEmail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView authenticationEmail(String email, String emailverifyuuid, ModelAndView mv)
  {
    Membersafety ms = this.memberservice.authenticationEmail(email, emailverifyuuid);
    if (ms == null) {
      mv.setViewName("redirect:/index.do");
      return mv;
    }
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }

    this.bonusService.addReferralBonus(currUser.getId());
    this.messageService.sendMessage("message.email", currUser.getId().longValue(), new String[0]);

    return shiroLoginByAuthEmailSuccess(email, mv);
  }

  @RequestMapping({"/member/bankcardno"})
  @ResponseBody
  public JsonResponse bankcardisright(String bankcardno)
  {
    JsonResponse jsonResponse = new JsonResponse();
    if (StringUtil.isEmpty(bankcardno)) {
      jsonResponse.setResult("银行卡号为必输项");
      return jsonResponse;
    }

    if (!(BankcardUtil.checkBankCard(bankcardno))) {
      jsonResponse.setResult("银行卡号不正确");
      return jsonResponse;
    }
    jsonResponse.setResult("银行卡号正确");
    return jsonResponse;
  }

  @RequestMapping(value={"/member/authenticationIDcard"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String authenticationIDcard(ModelAndView mv, String realname, String idcard)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    currUser.setRealname(realname);
    currUser.setIdcard(idcard);
    this.memberservice.authenticationIDcard(currUser.getId().longValue(), idcard, realname);

    this.bonusService.addReferralBonus(currUser.getId());
    this.messageService.sendMessage("message.realname", currUser.getId().longValue(), new String[0]);

    return "redirect:securitycenter.do"; }

  @RequestMapping({"/member/idcardisuseful"})
  @ResponseBody
  public JsonResponse idcardisuseful(String idcard) {
    JsonResponse jsonResponse = new JsonResponse();
    if (IdcardUtils.validateCard(idcard)) {
      jsonResponse.setStatus("1");
    } else {
      jsonResponse.setStatus("2");
      jsonResponse.setResult("身份证格式错误");
    }
    return jsonResponse;
  }

  @RequestMapping({"/member/dealpasswordValidate"})
  @ResponseBody
  public JsonResponse dealpasswordValidate(String newPw)
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if ((StringUtil.isNotEmpty(newPw)) && (SafeUtil.generatePassword(newPw).equals(currUser.getPassword()))) {
      jsonResponse.setMsg("交易密码不能与登录密码相同");
      jsonResponse.setStatus("FAIL");
    } else {
      jsonResponse.setStatus("SUCCESS");
    }
    return jsonResponse;
  }

  @RequestMapping(value={"/member/dealpassword"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String dealPassword(String dealpassword, HttpSession session)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    currUser.setTranspasswd(SafeUtil.generatePassword(dealpassword));
    Membersafety ms = (Membersafety)session.getAttribute("membersafety");
    this.memberservice.adddealpassword(currUser.getId().longValue(), ms.getId().longValue(), dealpassword);
    this.messageService.sendMessage("message.tranpassword", currUser.getId().longValue(), new String[0]);
    return "redirect:securitycenter.do";
  }

  @RequestMapping(value={"/member/authenticationBankcard"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String authenticationBankcard(HttpServletRequest request, Membersafety membersafety, HttpSession session)
  {
    String[] referers = request.getHeader("referer").split("/");
    String referer = referers[(referers.length - 1)];

    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    membersafety.setMemberid(currUser.getId());
    this.memberservice.authenticationBankcard(membersafety);
    this.messageService.sendMessage("message.bankcode", currUser.getId().longValue(), new String[0]);

    if ("takecash.do".equals(referer)) {
      return "redirect:takecash.do";
    }
    return "redirect:securitycenter.do";
  }

  @RequestMapping({"/member/authenticationMobile"})
  public String authenticationMobile(HttpSession session, String mobile)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    Membersafety ms = (Membersafety)session.getAttribute("membersafety");
    this.memberservice.authenticationMobil(currUser.getId().longValue(), ms.getId().longValue(), mobile);
    currUser.setMobile(mobile);
    this.messageService.sendMessage("message.mobile", currUser.getId().longValue(), new String[0]);

    this.bonusService.addReferralBonus(currUser.getId());
    return "redirect:securitycenter.do";
  }

  @RequestMapping({"member/securitycenter"})
  public ModelAndView gotoSecuritycenter(ModelAndView mv)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    mv.addObject("membersafety", this.memberservice.findMembersafety(currUser.getId().longValue()));
    mv.setViewName("vip/securitycenter");
    return mv;
  }

  @RequestMapping(value={"/member/membercenter"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView memberCenter(ModelAndView mv, HttpServletRequest request)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if ("1".equals(request.getParameter("status"))) {
      request.setAttribute("status", Integer.valueOf(1));
    }
    mv.addObject("membersafety", this.memberservice.findMemberSafetyByMemberId(currUser.getId()));
    mv.setViewName("vip/person");
    return mv;
  }

  public static void main(String[] args) {
    Member member = new Member();
    System.out.println(member.getIfjoinexpence());
  }

  @RequestMapping(value={"/member/updatecenter"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String updateCenter(@RequestParam("birthday") String birthday, Member member, Boolean ifjoinexpence, HttpServletRequest request)
    throws ParseException
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if (ifjoinexpence != null)
      member.setIfjoinexpence(ifjoinexpence);
    else {
      member.setIfjoinexpence(Boolean.valueOf(false));
    }
    member.setId(currUser.getId());
    if (this.memberservice.updataMember(member) > 0) {
      currUser.setIfjoinexpence(member.getIfjoinexpence());
      if (member.getNickname() != null) {
        currUser.setNickname(member.getNickname());
      }
      if (member.getGender() != null) {
        currUser.setGender(member.getGender());
      }
      if ((birthday != null) && (!(birthday.equals("")))) {
        member.setBirth(DateConverterUtil.parseDate(birthday));
        currUser.setBirth(DateConverterUtil.parseDate(birthday));
      }
      if (member.getAddress() != null) {
        currUser.setAddress(member.getAddress());
      }
      if (member.getMobile() != null) {
        currUser.setMobile(member.getMobile());
      }
      if (member.getRealname() != null) {
        currUser.setRealname(member.getRealname());
      }
      return "redirect:membercenter.do?status=1";
    }
    return "redirect:membercenter.do?status=0";
  }

  @ExceptionHandler({MemberException.class})
  public String error(MemberException me, HttpServletRequest request)
  {
    request.setAttribute("errormsg", me.getMessage());
    return "login";
  }

  @RequestMapping({"/member/uploadImg"})
  public void uploadImg(MultipartHttpServletRequest request, HttpServletResponse response) throws IOException {
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    SimpleDateFormat simpleFormat = new SimpleDateFormat("MMddHHmmsss");
    String generationfileName = simpleFormat.format(new Date()) + new Random().nextInt(1000);

    String savePath = PathKit.getWebRootPath() + "/static/upload/img";
    String updateP = request.getParameter("updateP");
    String fileNameSuffix = null;
    String fileName = null;
    if ((null == updateP) || ("".equals(updateP))) return;
    try {
      MultipartFile mf = request.getFile(updateP);
      fileName = mf.getOriginalFilename();
      if ((null != mf) && (!("".equals(mf)))) {
        fileNameSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
        String[] suffix = { "gif", "jpeg", "png", "jpg" };
        if (!(StringUtil.equalWith(fileNameSuffix, suffix))) {
          out.write("{'state':'2','msg':'仅支持gif、jpg、jpeg、png等图片格式'}");
          return;
        }
        String newFileName = generationfileName + "." + fileNameSuffix;
        saveFileFromInputStream(mf.getInputStream(), savePath, newFileName);
        Subject currentUser = SecurityUtils.getSubject();
        ShiroMember shiroMember = (ShiroMember)currentUser.getPrincipal();
        Member member = new Member();
        member.setId(shiroMember.getId());
        member.setHeadimg(newFileName);
        this.memberservice.updataMember(member);
        shiroMember.setHeadimg(newFileName);
        out.write("{'state':'0','fileName':'" + newFileName + "','updateP':'" + updateP + "'}");
      }
    } catch (Exception e) {
      out.write("{'state':'1'}");
      e.printStackTrace();
    }
  }

  public void saveFileFromInputStream(InputStream stream, String path, String filename)
    throws IOException
  {
    File folderFile = new File(path);
    if (!(folderFile.exists()))
    {
      folderFile.mkdirs();
    }
    FileOutputStream fs = new FileOutputStream(path + "/" + filename);
    byte[] buffer = new byte[1048576];

    int bytesum = 0;
    int byteread = 0;
    while ((byteread = stream.read(buffer)) != -1) {
      bytesum += byteread;
      fs.write(buffer, 0, byteread);
      fs.flush();
    }
    fs.close();
    stream.close();
  }

  @RequestMapping({"/member/rechargeApplyFail"})
  public String rechargeApplyFail() {
    return "/pay/recharge/recharge_apply_fail";
  }

  @RequestMapping({"/member/mobileisusable"})
  @ResponseBody
  public JsonResponse phoneIsUsable(String mobile) {
    JsonResponse jsonResponse = new JsonResponse();
    if (this.memberservice.getMobile(mobile) > 0)
    {
      jsonResponse.setStatus("0");
    }
    else {
      jsonResponse.setStatus("1");
    }
    return jsonResponse;
  }
}