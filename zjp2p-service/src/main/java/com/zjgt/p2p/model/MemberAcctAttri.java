package com.zjgt.p2p.model;

import java.util.Date;

public class MemberAcctAttri
{
  private Date createDate;
  private Long memberid;
  private Integer capitalStatus;
  private Integer withdrawStatus;
  private String operUser;
  private Date operDate;
  private String memo;
  private Date updateDate;

  public Date getCreateDate()
  {
    return this.createDate;
  }

  public void setCreateDate(Date createDate)
  {
    this.createDate = createDate;
  }

  public Long getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Long memberid)
  {
    this.memberid = memberid;
  }

  public Integer getCapitalStatus()
  {
    return this.capitalStatus;
  }

  public void setCapitalStatus(Integer capitalStatus)
  {
    this.capitalStatus = capitalStatus;
  }

  public Integer getWithdrawStatus()
  {
    return this.withdrawStatus;
  }

  public void setWithdrawStatus(Integer withdrawStatus)
  {
    this.withdrawStatus = withdrawStatus;
  }

  public String getOperUser()
  {
    return this.operUser;
  }

  public void setOperUser(String operUser)
  {
    this.operUser = ((operUser == null) ? null : operUser.trim());
  }

  public Date getOperDate()
  {
    return this.operDate;
  }

  public void setOperDate(Date operDate)
  {
    this.operDate = operDate;
  }

  public String getMemo()
  {
    return this.memo;
  }

  public void setMemo(String memo)
  {
    this.memo = ((memo == null) ? null : memo.trim());
  }

  public Date getUpdateDate()
  {
    return this.updateDate;
  }

  public void setUpdateDate(Date updateDate)
  {
    this.updateDate = updateDate;
  }
}