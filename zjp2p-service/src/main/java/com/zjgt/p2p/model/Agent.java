package com.zjgt.p2p.model;

import java.math.BigDecimal;

public class Agent
{
  private Long id;
  private Long memberid;
  private Integer level;
  private Integer iscompany;
  private Integer isMerchant;
  private BigDecimal commissionrate;
  private String remark;

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

  public Integer getLevel()
  {
    return this.level;
  }

  public void setLevel(Integer level)
  {
    this.level = level;
  }

  public Integer getIscompany()
  {
    return this.iscompany;
  }

  public void setIscompany(Integer iscompany)
  {
    this.iscompany = iscompany;
  }

  public Integer getIsMerchant()
  {
    return this.isMerchant;
  }

  public void setIsMerchant(Integer isMerchant) {
    this.isMerchant = isMerchant;
  }

  public BigDecimal getCommissionrate()
  {
    return this.commissionrate;
  }

  public void setCommissionrate(BigDecimal commissionrate)
  {
    this.commissionrate = commissionrate;
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