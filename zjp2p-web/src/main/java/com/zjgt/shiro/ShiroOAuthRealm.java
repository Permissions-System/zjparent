package com.zjgt.shiro;

import com.zjgt.p2p.base.service.IWebLoginLogService;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.Const.USER_STATUS;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.shiro.token.OAuthQQToken;

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
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroOAuthRealm extends BaseRealm
{
  Logger logger;

  @Autowired
  private MemberService memberService;

  @Autowired
  private IWebLoginLogService webLoginLogService;

  public ShiroOAuthRealm()
  {
    this.logger = LoggerFactory.getLogger(ShiroOAuthRealm.class);
  }

  public boolean supports(AuthenticationToken token)
  {
    return token instanceof OAuthQQToken;
  }

  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
    throws AuthenticationException
  {
    HttpServletRequest request = (HttpServletRequest)((WebSubject)SecurityUtils.getSubject()).getServletRequest();
    OAuthQQToken token = (OAuthQQToken)authcToken;
    Member member = this.memberService.findByOpenId(token.getOpenId());

    if ((member.getUserstatus() != null) && (Const.USER_STATUS.FREEZE == member.getUserstatus())) {
      request.setAttribute("loginState", "7");
      throw new AuthenticationException("账号已被冻结");
    }
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
    saveLoginLog(request, String.valueOf(member.getId()), String.valueOf(member.getId()), "第三方认证登录成功!", true);
    return new SimpleAuthenticationInfo(shiroMember, shiroMember.getOpenid(), getName());
  }

  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
  {
    ShiroMember shiroMember = (ShiroMember)principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    return info;
  }
}