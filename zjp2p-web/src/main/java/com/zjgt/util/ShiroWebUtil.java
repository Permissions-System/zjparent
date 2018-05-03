package com.zjgt.util;

import com.zjgt.shiro.ShiroMember;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroWebUtil
{
  public static ShiroMember getCurrentUser()
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    return currUser;
  }
}