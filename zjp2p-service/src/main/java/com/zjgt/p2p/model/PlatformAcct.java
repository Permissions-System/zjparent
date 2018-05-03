package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class PlatformAcct
{
  private Long id;
  private Long acctid;
  private Long memberid;
  private Date createDate;
  private Integer acctType;
  private String acctName;
  private BigDecimal account;
  private BigDecimal blance;
  private BigDecimal freezeBlance;
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

  public Integer getAcctType()
  {
    return this.acctType;
  }

  public void setAcctType(Integer acctType)
  {
    this.acctType = acctType;
  }

  public String getAcctName()
  {
    return this.acctName;
  }

  public void setAcctName(String acctName)
  {
    this.acctName = ((acctName == null) ? null : acctName.trim());
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
    return this.freezeBlance;
  }

  public void setFreezeBlance(BigDecimal freezeBlance)
  {
    this.freezeBlance = freezeBlance;
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