package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberProdIncome
{
  private Long id;
  private Long memberid;
  private Integer bidtypeid;
  private String bidclassname;
  private BigDecimal totalincome;
  private BigDecimal income;
  private BigDecimal recvincome;
  private Integer membertype;
  private Date modifyDate;
  private Date createDate;
  private Date freezeDate;
  private Date updateDate;
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

  public Integer getBidtypeid()
  {
    return this.bidtypeid;
  }

  public void setBidtypeid(Integer bidtypeid)
  {
    this.bidtypeid = bidtypeid;
  }

  public String getBidclassname()
  {
    return this.bidclassname;
  }

  public void setBidclassname(String bidclassname)
  {
    this.bidclassname = ((bidclassname == null) ? null : bidclassname.trim());
  }

  public BigDecimal getTotalincome()
  {
    return this.totalincome;
  }

  public void setTotalincome(BigDecimal totalincome)
  {
    this.totalincome = totalincome;
  }

  public BigDecimal getIncome()
  {
    return this.income;
  }

  public void setIncome(BigDecimal income)
  {
    this.income = income;
  }

  public BigDecimal getRecvincome()
  {
    return this.recvincome;
  }

  public void setRecvincome(BigDecimal recvincome)
  {
    this.recvincome = recvincome;
  }

  public Integer getMembertype()
  {
    return this.membertype;
  }

  public void setMembertype(Integer membertype)
  {
    this.membertype = membertype;
  }

  public Date getModifyDate()
  {
    return this.modifyDate;
  }

  public void setModifyDate(Date modifyDate)
  {
    this.modifyDate = modifyDate;
  }

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public Date getFreezeDate()
  {
    return this.freezeDate;
  }

  public void setFreezeDate(Date freezeDate)
  {
    this.freezeDate = freezeDate;
  }

  public Date getUpdateDate()
  {
    return this.updateDate;
  }

  public void setUpdateDate(Date updateDate)
  {
    this.updateDate = updateDate;
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