package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class PlatformAsset
{
  private Long id;
  private Long acctid;
  private Long memberid;
  private Date createDate;
  private BigDecimal account;
  private BigDecimal blance;
  private BigDecimal freezeBlance;
  private BigDecimal income;
  private BigDecimal expense;
  private Date modifyDate;
  private Date freezeDate;
  private Date updateDate;
  private Integer membertype;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Long getAcctid()
  {
    return this.acctid;
  }

  public void setAcctid(Long acctid)
  {
    this.acctid = acctid;
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public BigDecimal getAccount()
  {
    if (this.account == null) {
      this.account = new BigDecimal(0);
    }
    return this.account;
  }

  public void setAccount(BigDecimal account)
  {
    this.account = account;
  }

  public BigDecimal getBlance()
  {
    if (this.blance == null) {
      this.blance = new BigDecimal(0);
    }
    return this.blance;
  }

  public void setBlance(BigDecimal blance)
  {
    this.blance = blance;
  }

  public BigDecimal getFreezeBlance()
  {
    if (this.freezeBlance == null) {
      this.freezeBlance = new BigDecimal(0);
    }
    return this.freezeBlance;
  }

  public void setFreezeBlance(BigDecimal freezeBlance)
  {
    this.freezeBlance = freezeBlance;
  }

  public BigDecimal getIncome()
  {
    if (this.income == null) {
      this.income = new BigDecimal(0);
    }
    return this.income;
  }

  public void setIncome(BigDecimal income)
  {
    this.income = income;
  }

  public BigDecimal getExpense()
  {
    if (this.expense == null) {
      this.expense = new BigDecimal(0);
    }
    return this.expense;
  }

  public void setExpense(BigDecimal expense)
  {
    this.expense = expense;
  }

  public Date getModifyDate()
  {
    return this.modifyDate;
  }

  public void setModifyDate(Date modifyDate)
  {
    this.modifyDate = modifyDate;
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

  public Integer getMembertype()
  {
    return this.membertype;
  }

  public void setMembertype(Integer membertype)
  {
    this.membertype = membertype;
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