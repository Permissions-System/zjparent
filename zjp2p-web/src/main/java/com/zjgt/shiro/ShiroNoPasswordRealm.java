package com.zjgt.shiro;

import com.zjgt.p2p.model.Member;
import com.zjgt.shiro.token.NoPasswordToken;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroNoPasswordRealm extends BaseRealm
{
  Logger logger;

  public ShiroNoPasswordRealm()
  {
    this.logger = LoggerFactory.getLogger(ShiroNoPasswordRealm.class); }

  public boolean supports(AuthenticationToken token) {
    return token instanceof NoPasswordToken;
  }

  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
    throws AuthenticationException
  {
    HttpServletRequest request = (HttpServletRequest)((WebSubject)SecurityUtils.getSubject()).getServletRequest();
    NoPasswordToken token = (NoPasswordToken)authcToken;
    Member member = token.getMember();
    ShiroMember shiroMember = new ShiroMember();
    try {
      ConvertUtils.register(new DateConverter(null), Date.class);
      ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
      BeanUtils.copyProperties(shiroMember, member);
    } catch (IllegalAccessException e) {
      throw new AuthenticationException("后台错误");
    } catch (InvocationTargetException e) {
      throw new AuthenticationException("后台错误");
    }
    saveLoginLog(request, String.valueOf(member.getId()), String.valueOf(member.getId()), "邮箱认证,自动登录成功!", true);
    return new SimpleAuthenticationInfo(shiroMember, token.getCredentials(), getName());
  }

  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
  {
    ShiroMember shiroMember = (ShiroMember)principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    return info;
  }
}