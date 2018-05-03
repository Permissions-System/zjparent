package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class LoginLocale
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String recNo;
  private String userNo;
  private String locale;
  private int loginTimes;
  private String lastTime;

  public String getRecNo()
  {
    return this.recNo;
  }

  public void setRecNo(String recNo) {
    this.recNo = ((recNo == null) ? null : recNo.trim());
  }

  public String getUserNo() {
    return this.userNo;
  }

  public void setUserNo(String userNo) {
    this.userNo = ((userNo == null) ? null : userNo.trim());
  }

  public String getLocale() {
    return this.locale;
  }

  public void setLocale(String locale) {
    this.locale = ((locale == null) ? null : locale.trim());
  }

  public int getLoginTimes() {
    return this.loginTimes;
  }

  public void setLoginTimes(int loginTimes) {
    this.loginTimes = loginTimes;
  }

  public String getLastTime() {
    return this.lastTime;
  }

  public void setLastTime(String lastTime) {
    this.lastTime = ((lastTime == null) ? null : lastTime.trim());
  }
}