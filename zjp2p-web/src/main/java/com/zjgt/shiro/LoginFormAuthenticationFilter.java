package com.zjgt.shiro;

import com.zjgt.util.StringUtil;
import java.net.URLDecoder;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFormAuthenticationFilter extends FormAuthenticationFilter
{
  private static Logger logger = LoggerFactory.getLogger(LoginFormAuthenticationFilter.class);

  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
    throws Exception
  {
    HttpServletRequest request2 = (HttpServletRequest)request;
    String preurl = (String)request2.getSession().getAttribute("preurl");
    if (StringUtil.isNotEmpty(preurl)) {
      String decodePreurl = URLDecoder.decode(preurl, "UTF-8");
      logger.info("登录前页面{},{}", preurl, decodePreurl);
      boolean contextRelative = true;
      SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
      if ((savedRequest != null) && (savedRequest.getMethod().equalsIgnoreCase("GET"))) {
        contextRelative = false;
      }
      WebUtils.issueRedirect(request, response, decodePreurl, null, contextRelative);
      return false;
    }
    return super.onLoginSuccess(token, subject, request, response);
  }
}