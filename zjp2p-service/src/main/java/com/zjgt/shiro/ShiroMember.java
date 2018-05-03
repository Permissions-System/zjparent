package com.zjgt.shiro;

import com.zjgt.p2p.model.Member;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroMember extends Member
{
  private static final long serialVersionUID = 7509755133131498574L;
  private AtomicInteger unreadMessageCount;

  public ShiroMember()
  {
    this.unreadMessageCount = new AtomicInteger(0); }

  public Integer getUnreadMessageCount() {
    return Integer.valueOf(this.unreadMessageCount.intValue());
  }

  public void setUnreadMessageCount(Integer unreadMessageCount) {
    this.unreadMessageCount = new AtomicInteger(unreadMessageCount.intValue());
  }

  public Integer subtractUnreadMessageCount()
  {
    if (this.unreadMessageCount.intValue() == 0) {
      return Integer.valueOf(this.unreadMessageCount.intValue());
    }
    return Integer.valueOf(this.unreadMessageCount.getAndDecrement());
  }

  public String getFormatAmount() {
    DecimalFormat format = new DecimalFormat(",###.00");
    return format.format(super.getAmount().doubleValue());
  }

  public String getHeadImgPath() {
    if (StringUtils.isEmpty(getHeadimg())) {
      return "/static/images/head.png";
    }
    return "/static/upload/img/" + getHeadimg();
  }

  public static ShiroMember getCurrentLogin()
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if ((subject != null) && (subject.isAuthenticated())) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    return currUser;
  }
}