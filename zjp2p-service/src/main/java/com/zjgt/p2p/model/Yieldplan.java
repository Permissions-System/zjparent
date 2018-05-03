package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Yieldplan
{
  private Long id;
  private Long parentid;
  private String investordercode;
  private Integer termnum;
  private Date termdate;
  private BigDecimal termamount;
  private BigDecimal principalamount;
  private BigDecimal accruedinterest;
  private BigDecimal remainpriamount;
  private BigDecimal remaininterest;
  private Date repaydate;
  private BigDecimal repaidamount;
  private String termstatus;
  private String transcode;
  private String creditcode;
  private String remark;
  private Integer memberid;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Long getParentid()
  {
    return this.parentid;
  }

  public void setParentid(Long parentid)
  {
    this.parentid = parentid;
  }

  public String getInvestordercode()
  {
    return this.investordercode;
  }

  public void setInvestordercode(String investordercode)
  {
    this.investordercode = ((investordercode == null) ? null : investordercode.trim());
  }

  public Integer getTermnum()
  {
    return this.termnum;
  }

  public void setTermnum(Integer termnum)
  {
    this.termnum = termnum;
  }

  public Date getTermdate()
  {
    return this.termdate;
  }

  public void setTermdate(Date termdate)
  {
    this.termdate = termdate;
  }

  public BigDecimal getTermamount()
  {
    if (this.termamount == null) {
      this.termamount = BigDecimal.ZERO;
    }
    return this.termamount;
  }

  public void setTermamount(BigDecimal termamount)
  {
    this.termamount = termamount;
  }

  public BigDecimal getPrincipalamount()
  {
    if (this.principalamount == null) {
      this.principalamount = BigDecimal.ZERO;
    }
    return this.principalamount;
  }

  public void setPrincipalamount(BigDecimal principalamount)
  {
    this.principalamount = principalamount;
  }

  public BigDecimal getAccruedinterest()
  {
    if (this.accruedinterest == null) {
      this.accruedinterest = BigDecimal.ZERO;
    }
    return this.accruedinterest;
  }

  public void setAccruedinterest(BigDecimal accruedinterest)
  {
    this.accruedinterest = accruedinterest;
  }

  public BigDecimal getRemainpriamount()
  {
    if (this.remainpriamount == null) {
      this.remainpriamount = BigDecimal.ZERO;
    }
    return this.remainpriamount;
  }

  public void setRemainpriamount(BigDecimal remainpriamount)
  {
    this.remainpriamount = remainpriamount;
  }

  public BigDecimal getRemaininterest()
  {
    if (this.remaininterest == null) {
      this.remaininterest = BigDecimal.ZERO;
    }
    return this.remaininterest;
  }

  public void setRemaininterest(BigDecimal remaininterest)
  {
    this.remaininterest = remaininterest;
  }

  public Date getRepaydate()
  {
    return this.repaydate;
  }

  public void setRepaydate(Date repaydate)
  {
    this.repaydate = repaydate;
  }

  public BigDecimal getRepaidamount()
  {
    if (this.repaidamount == null) {
      this.repaidamount = BigDecimal.ZERO;
    }
    return this.repaidamount;
  }

  public void setRepaidamount(BigDecimal repaidamount)
  {
    this.repaidamount = repaidamount;
  }

  public String getTermstatus()
  {
    return this.termstatus;
  }

  public void setTermstatus(String termstatus)
  {
    this.termstatus = ((termstatus == null) ? null : termstatus.trim());
  }

  public String getTranscode()
  {
    return this.transcode;
  }

  public void setTranscode(String transcode)
  {
    this.transcode = ((transcode == null) ? null : transcode.trim());
  }

  public String getCreditcode()
  {
    return this.creditcode;
  }

  public void setCreditcode(String creditcode)
  {
    this.creditcode = ((creditcode == null) ? null : creditcode.trim());
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
  }
}