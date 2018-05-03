package com.zjgt.p2p.model;

import java.math.BigDecimal;

public class CpsCommissionrate
{
  private Long id;
  private Integer bidtype;
  private BigDecimal investamtf;
  private BigDecimal investamtt;
  private BigDecimal commissionrate;
  private String channel;
  private String channel2;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Integer getBidtype()
  {
    return this.bidtype;
  }

  public void setBidtype(Integer bidtype)
  {
    this.bidtype = bidtype;
  }

  public BigDecimal getInvestamtf()
  {
    return this.investamtf;
  }

  public void setInvestamtf(BigDecimal investamtf)
  {
    this.investamtf = investamtf;
  }

  public BigDecimal getInvestamtt()
  {
    return this.investamtt;
  }

  public void setInvestamtt(BigDecimal investamtt)
  {
    this.investamtt = investamtt;
  }

  public BigDecimal getCommissionrate()
  {
    return this.commissionrate;
  }

  public void setCommissionrate(BigDecimal commissionrate)
  {
    this.commissionrate = commissionrate;
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

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }
}