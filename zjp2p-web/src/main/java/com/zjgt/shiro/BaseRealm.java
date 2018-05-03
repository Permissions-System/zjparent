package com.zjgt.shiro;

import com.zjgt.p2p.base.domain.WebLoginLog;
import com.zjgt.p2p.base.service.IWebLoginLogService;
import com.zjgt.p2p.service.MemberService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseRealm extends AuthorizingRealm
{
  Logger logger;

  @Autowired
  private IWebLoginLogService webLoginLogService;

  @Autowired
  private MemberService memberService;

  public BaseRealm()
  {
    this.logger = LoggerFactory.getLogger(BaseRealm.class);
  }

  public void saveLoginLog(HttpServletRequest request, String userNo, String loginName, String result)
  {
    try
    {
      saveLoginLog(request, userNo, loginName, null, null, result);
    } catch (Exception e) {
      this.logger.error("saveLoginLog errror " + e);
    }
  }

  public void saveLoginLog(HttpServletRequest request, String userNo, String loginName, String result, boolean isSuccess)
  {
    try {
      if (isSuccess) {
        this.memberService.updateLastLoginDateByPrimary(Long.valueOf(userNo));
      }
      saveLoginLog(request, userNo, loginName, result);
    } catch (Exception e) {
      this.logger.error("saveLoginLog errror " + e);
    }
  }

  public void saveLoginLog(HttpServletRequest request, String userNo, String loginName, String cifNo, String userType, String result)
  {
    WebLoginLog webLoginLog = new WebLoginLog();

    String bigCookie = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        String cookieName = cookie.getName();
        String cookieValue = cookie.getValue();
        this.logger.debug("cookieName:" + cookieName);
        this.logger.debug("cookieValue:" + cookieValue);
        if (cookieName.startsWith("BIG")) {
          bigCookie = cookieValue;
          break;
        }
      }
    }
    webLoginLog.setBigCookie(bigCookie);

    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    webLoginLog.setLoginTime(format.format(new Date()));

    String ip = request.getHeader("x-forwarded-for");
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getRemoteAddr();
    }

    String agent = request.getHeader("user-Agent").toLowerCase();
    String browser = "";
    if (agent.indexOf("trident") >= 0)
      browser = "ie";
    else if (agent.indexOf("firefox") >= 0)
      browser = "firefox";
    else if (agent.indexOf("chrome") >= 0)
      browser = "chrome";
    else {
      browser = "other";
    }

    String os = "";
    if (agent.indexOf("windows") >= 0)
      os = "windows";
    else if (agent.indexOf("linux") >= 0)
      os = "linux";
    else if (agent.indexOf("mac") >= 0)
      os = "mac";
    else {
      os = "other";
    }

    webLoginLog.setIpAddress(ip);
    webLoginLog.setBrowser(browser);
    webLoginLog.setOs(os);

    webLoginLog.setLoginDesc(result);
    webLoginLog.setRecNo(UUIDUtils.generate());

    if (userNo == null) {
      userNo = "NoAccount";
    }
    webLoginLog.setUserNo(userNo);
    webLoginLog.setLoginName(loginName);
    webLoginLog.setSessionId(SecurityUtils.getSubject().getSession().getId().toString());
    this.webLoginLogService.addWebLoginLog(webLoginLog);
  }
}