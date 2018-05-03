package com.zjgt.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

public class AjaxUserFilter extends UserFilter
{
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
    throws Exception
  {
    HttpServletRequest req = WebUtils.toHttp(request);
    String xmlHttpRequest = req.getHeader("X-Requested-With");
    if ((xmlHttpRequest != null) && 
      (xmlHttpRequest.equalsIgnoreCase("XMLHttpRequest"))) {
      HttpServletResponse res = WebUtils.toHttp(response);
      res.sendError(401);
      return false;
    }
    return super.onAccessDenied(request, response);
  }
}