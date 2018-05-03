package com.zjgt.shiro;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.Const.USER_STATUS;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
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
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.subject.WebSubject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroDbRealm extends BaseRealm
{
  Logger logger;

  @Autowired
  private MemberService memberService;

  @Autowired
  private MessageService messageservice;

  public ShiroDbRealm()
  {
    this.logger = LoggerFactory.getLogger(ShiroDbRealm.class);
  }

  public boolean supports(AuthenticationToken token)
  {
    return token instanceof UsernamePasswordToken;
  }

  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
    throws AuthenticationException
  {
    HttpServletRequest request = (HttpServletRequest)((WebSubject)SecurityUtils.getSubject()).getServletRequest();
    UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
    String userLoginStr = token.getUsername().trim();
    String curPwd = String.valueOf(token.getPassword());
    Member member = this.memberService.findMemberByAll(userLoginStr);
    if (member == null) {
      try {
        saveLoginLog(request, "NoAccount", userLoginStr, "账号不存在");
      } catch (Exception e) {
        this.logger.error(e.getMessage());
      }
      request.setAttribute("loginState", "1");
      throw new AuthenticationException("账号不存在");
    }

    if ((member.getUserstatus() != null) && (Const.USER_STATUS.FREEZE == member.getUserstatus())) {
      request.setAttribute("loginState", "7");
      throw new AuthenticationException("账号已被冻结");
    }

    if (!(this.memberService.isRightPwd(member, curPwd))) {
      saveLoginLog(request, String.valueOf(member.getId()), userLoginStr, "输入密码错误!");
      request.setAttribute("loginErrorMsg", "密码错误");
      request.setAttribute("loginState", "5");
      throw new AuthenticationException("密码错误");
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
    saveLoginLog(request, String.valueOf(member.getId()), String.valueOf(member.getId()), "登录成功!", true);
    try
    {
      shiroMember.setUnreadMessageCount(Integer.valueOf(this.messageservice.getUnreadMessageCount(member.getId().longValue())));
    } catch (Exception e) {
      this.logger.error("读取未读消息条数错误", e);
    }
    return new SimpleAuthenticationInfo(shiroMember, curPwd, getName());
  }

  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
  {
    ShiroMember shiroMember = (ShiroMember)principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    return info;
  }

  @PostConstruct
  public void initCredentialsMatcher()
  {
  }
}