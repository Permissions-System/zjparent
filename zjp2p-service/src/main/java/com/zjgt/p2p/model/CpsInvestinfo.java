package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class CpsInvestinfo
{
  private Long id;
  private String channel;
  private String channel2;
  private String sessionid;
  private Long memberid;
  private String bidcode;
  private BigDecimal amount;
  private BigDecimal settleamount;
  private Long commission;
  private String orderno;
  private Date orderdate;
  private Date lastsettledate;
  private Integer profitstatus;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
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

  public String getSessionid()
  {
    return this.sessionid;
  }

  public void setSessionid(String sessionid)
  {
    this.sessionid = ((sessionid == null) ? null : sessionid.trim());
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public String getBidcode()
  {
    return this.bidcode;
  }

  public void setBidcode(String bidcode)
  {
    this.bidcode = ((bidcode == null) ? null : bidcode.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public BigDecimal getSettleamount()
  {
    return this.settleamount;
  }

  public void setSettleamount(BigDecimal settleamount)
  {
    this.settleamount = settleamount;
  }

  public Long getCommission()
  {
    return this.commission;
  }

  public void setCommission(Long commission)
  {
    this.commission = commission;
  }

  public String getOrderno()
  {
    return this.orderno;
  }

  public void setOrderno(String orderno)
  {
    this.orderno = ((orderno == null) ? null : orderno.trim());
  }

  public Date getOrderdate()
  {
    return this.orderdate;
  }

  public void setOrderdate(Date orderdate)
  {
    this.orderdate = orderdate;
  }

  public Date getLastsettledate()
  {
    return this.lastsettledate;
  }

  public void setLastsettledate(Date lastsettledate)
  {
    this.lastsettledate = lastsettledate;
  }

  public Integer getProfitstatus()
  {
    return this.profitstatus;
  }

  public void setProfitstatus(Integer profitstatus)
  {
    this.profitstatus = profitstatus;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }
}