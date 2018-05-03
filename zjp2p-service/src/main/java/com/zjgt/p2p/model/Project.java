package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Project
{
  private Long id;
  private String projectcode;
  private String projectname;
  private BigDecimal account;
  private String instcode;
  private String instname;
  private String subject;
  private Integer bidnum;
  private BigDecimal bidamount;
  private Date opdate;
  private Integer memberid;
  private BigDecimal loanrate;
  private BigDecimal mgrrate;
  private BigDecimal pubrate;
  private BigDecimal exprate;
  private BigDecimal debtrate;
  private BigDecimal inforate;
  private Integer payway;
  private String remark;
  private Integer status;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getProjectcode()
  {
    return this.projectcode;
  }

  public void setProjectcode(String projectcode)
  {
    this.projectcode = ((projectcode == null) ? null : projectcode.trim());
  }

  public String getProjectname()
  {
    return this.projectname;
  }

  public void setProjectname(String projectname)
  {
    this.projectname = ((projectname == null) ? null : projectname.trim());
  }

  public BigDecimal getAccount()
  {
    return this.account;
  }

  public void setAccount(BigDecimal account)
  {
    this.account = account;
  }

  public String getInstcode()
  {
    return this.instcode;
  }

  public void setInstcode(String instcode)
  {
    this.instcode = instcode;
  }

  public String getInstname()
  {
    return this.instname;
  }

  public void setInstname(String instname)
  {
    this.instname = ((instname == null) ? null : instname.trim());
  }

  public String getSubject()
  {
    return this.subject;
  }

  public void setSubject(String subject)
  {
    this.subject = ((subject == null) ? null : subject.trim());
  }

  public Integer getBidnum()
  {
    return this.bidnum;
  }

  public void setBidnum(Integer bidnum)
  {
    this.bidnum = bidnum;
  }

  public BigDecimal getBidamount()
  {
    return this.bidamount;
  }

  public void setBidamount(BigDecimal bidamount)
  {
    this.bidamount = bidamount;
  }

  public Date getOpdate()
  {
    return this.opdate;
  }

  public void setOpdate(Date opdate)
  {
    this.opdate = opdate;
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
  }

  public BigDecimal getLoanrate()
  {
    return this.loanrate;
  }

  public void setLoanrate(BigDecimal loanrate)
  {
    this.loanrate = loanrate;
  }

  public BigDecimal getMgrrate()
  {
    return this.mgrrate;
  }

  public void setMgrrate(BigDecimal mgrrate)
  {
    this.mgrrate = mgrrate;
  }

  public BigDecimal getPubrate()
  {
    return this.pubrate;
  }

  public void setPubrate(BigDecimal pubrate)
  {
    this.pubrate = pubrate;
  }

  public BigDecimal getExprate()
  {
    return this.exprate;
  }

  public void setExprate(BigDecimal exprate)
  {
    this.exprate = exprate;
  }

  public BigDecimal getDebtrate()
  {
    return this.debtrate;
  }

  public void setDebtrate(BigDecimal debtrate)
  {
    this.debtrate = debtrate;
  }

  public BigDecimal getInforate()
  {
    return this.inforate;
  }

  public void setInforate(BigDecimal inforate)
  {
    this.inforate = inforate;
  }

  public Integer getPayway()
  {
    return this.payway;
  }

  public void setPayway(Integer payway)
  {
    this.payway = payway;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }

  public Integer getStatus()
  {
    return this.status;
  }

  public void setStatus(Integer status)
  {
    this.status = status;
  }
}