package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberAccount
{
  private Long id;
  private Long memberid;
  private BigDecimal account;
  private BigDecimal blance;
  private BigDecimal usedaccount;
  private BigDecimal freezeBlance;
  private BigDecimal totalincome;
  private BigDecimal income;
  private BigDecimal recvincome;
  private BigDecimal goldaccount;
  private BigDecimal goldblance;
  private BigDecimal freezegoldblance;
  private BigDecimal usedgoldaccount;
  private BigDecimal commisiontotalaccount;
  private BigDecimal commisionaccount;
  private Integer membertype;
  private Date modifyDate;
  private Date createDate;
  private Date freezeDate;
  private Date updateDate;
  private String remark;
  private BigDecimal zero;

  public MemberAccount()
  {
    this.zero = BigDecimal.ZERO;
  }

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

  public BigDecimal getUsedaccount()
  {
    if (this.usedaccount == null) {
      this.usedaccount = new BigDecimal(0);
    }
    return this.usedaccount;
  }

  public void setUsedaccount(BigDecimal usedaccount)
  {
    this.usedaccount = usedaccount;
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

  public BigDecimal getTotalincome()
  {
    if (this.totalincome == null) {
      this.totalincome = new BigDecimal(0);
    }
    return this.totalincome;
  }

  public void setTotalincome(BigDecimal totalincome)
  {
    this.totalincome = totalincome;
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

  public BigDecimal getRecvincome()
  {
    return this.recvincome;
  }

  public void setRecvincome(BigDecimal recvincome)
  {
    this.recvincome = recvincome;
  }

  public BigDecimal getGoldaccount()
  {
    return this.goldaccount;
  }

  public void setGoldaccount(BigDecimal goldaccount)
  {
    this.goldaccount = goldaccount;
  }

  public BigDecimal getGoldblance()
  {
    return this.goldblance;
  }

  public void setGoldblance(BigDecimal goldblance)
  {
    this.goldblance = goldblance;
  }

  public BigDecimal getFreezegoldblance()
  {
    return this.freezegoldblance;
  }

  public void setFreezegoldblance(BigDecimal freezegoldblance)
  {
    this.freezegoldblance = freezegoldblance;
  }

  public BigDecimal getUsedgoldaccount()
  {
    return this.usedgoldaccount;
  }

  public void setUsedgoldaccount(BigDecimal usedgoldaccount)
  {
    this.usedgoldaccount = usedgoldaccount;
  }

  public BigDecimal getCommisiontotalaccount()
  {
    if (this.commisiontotalaccount == null) {
      this.commisiontotalaccount = this.zero;
    }
    return this.commisiontotalaccount;
  }

  public void setCommisiontotalaccount(BigDecimal commisiontotalaccount)
  {
    this.commisiontotalaccount = commisiontotalaccount;
  }

  public BigDecimal getCommisionaccount()
  {
    if (this.commisionaccount == null) {
      this.commisionaccount = this.zero;
    }
    return this.commisionaccount;
  }

  public void setCommisionaccount(BigDecimal commisionaccount)
  {
    this.commisionaccount = commisionaccount;
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