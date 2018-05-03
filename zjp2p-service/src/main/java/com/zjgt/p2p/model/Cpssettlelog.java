package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Cpssettlelog
{
  private Long id;
  private Integer termnum;
  private String channel;
  private String channel2;
  private Long memberid;
  private String bidcode;
  private BigDecimal amount;
  private BigDecimal settleamount;
  private Date settledate;
  private BigDecimal commission;
  private String investordercode;
  private Integer settlestatus;
  private String remark;
  private Date opdate;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Integer getTermnum()
  {
    return this.termnum;
  }

  public void setTermnum(Integer termnum)
  {
    this.termnum = termnum;
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

  public Date getSettledate()
  {
    return this.settledate;
  }

  public void setSettledate(Date settledate)
  {
    this.settledate = settledate;
  }

  public BigDecimal getCommission()
  {
    return this.commission;
  }

  public void setCommission(BigDecimal commission)
  {
    this.commission = commission;
  }

  public String getInvestordercode()
  {
    return this.investordercode;
  }

  public void setInvestordercode(String investordercode)
  {
    this.investordercode = ((investordercode == null) ? null : investordercode.trim());
  }

  public Integer getSettlestatus()
  {
    return this.settlestatus;
  }

  public void setSettlestatus(Integer settlestatus)
  {
    this.settlestatus = settlestatus;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }

  public Date getOpdate()
  {
    return this.opdate;
  }

  public void setOpdate(Date opdate)
  {
    this.opdate = opdate;
  }
}