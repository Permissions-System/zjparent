package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class CpsLog
{
  private Long id;
  private Long memberid;
  private String realname;
  private String mobile;
  private String userdistrict;
  private BigDecimal amount;
  private Date orderdate;
  private BigDecimal cpsfee;
  private Date regdate;
  private Date lastlogindate;
  private Integer regsource;
  private Integer ifexperience;
  private String channel;
  private String channel2;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public String getRealname()
  {
    return this.realname;
  }

  public void setRealname(String realname)
  {
    this.realname = ((realname == null) ? null : realname.trim());
  }

  public String getMobile()
  {
    return this.mobile;
  }

  public void setMobile(String mobile)
  {
    this.mobile = ((mobile == null) ? null : mobile.trim());
  }

  public String getUserdistrict()
  {
    return this.userdistrict;
  }

  public void setUserdistrict(String userdistrict)
  {
    this.userdistrict = ((userdistrict == null) ? null : userdistrict.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public Date getOrderdate()
  {
    return this.orderdate;
  }

  public void setOrderdate(Date orderdate)
  {
    this.orderdate = orderdate;
  }

  public BigDecimal getCpsfee()
  {
    return this.cpsfee;
  }

  public void setCpsfee(BigDecimal cpsfee)
  {
    this.cpsfee = cpsfee;
  }

  public Date getRegdate()
  {
    return this.regdate;
  }

  public void setRegdate(Date regdate)
  {
    this.regdate = regdate;
  }

  public Date getLastlogindate()
  {
    return this.lastlogindate;
  }

  public void setLastlogindate(Date lastlogindate)
  {
    this.lastlogindate = lastlogindate;
  }

  public Integer getRegsource()
  {
    return this.regsource;
  }

  public void setRegsource(Integer regsource)
  {
    this.regsource = regsource;
  }

  public Integer getIfexperience()
  {
    return this.ifexperience;
  }

  public void setIfexperience(Integer ifexperience)
  {
    this.ifexperience = ifexperience;
  }

  public String getChannel()
  {
    return this.channel;
  }

  public void setChannel(String channel)
  {
    this.channel = ((channel == null) ? null : channel.trim());
  }

  public String getChannel2()
  {
    return this.channel2;
  }

  public void setChannel2(String channel2)
  {
    this.channel2 = ((channel2 == null) ? null : channel2.trim());
  }
}