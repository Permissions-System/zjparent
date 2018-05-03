package com.zjgt.shiro;

import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.service.MemberService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.utils.SpringContextUtil;

public class BiifooDefaultSecurityManager extends DefaultWebSecurityManager
{
  Logger logger;

  public BiifooDefaultSecurityManager()
  {
    this.logger = LoggerFactory.getLogger(BiifooDefaultSecurityManager.class);
  }

  protected void onSuccessfulLogin(AuthenticationToken token, AuthenticationInfo info, Subject subject) {
    super.onSuccessfulLogin(token, info, subject);
    Session session = subject.getSession();
    ShiroMember currUser = (ShiroMember)subject.getPrincipal();
    MemberService memberService = (MemberService)SpringContextUtil.getBean(MemberService.class);
    Membersafety membersafety = memberService.findMemberSafetyByMemberId(currUser.getId());
    this.logger.info("onSuccessfulLogin " + membersafety);
    session.setAttribute("membersafety", membersafety);
  }

  public void logout(Subject subject)
  {
    super.logout(subject);
    Session session = subject.getSession();
    session.removeAttribute("membersafety");
    this.logger.info("loggin out");
  }
}