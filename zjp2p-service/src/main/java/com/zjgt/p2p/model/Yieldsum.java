package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Yieldsum
{
  private Long id;
  private Long parentid;
  private String investordercode;
  private Integer termnum;
  private Date termdate;
  private Date repaydate;
  private BigDecimal termamount;
  private BigDecimal principalamountsum;
  private BigDecimal accruedinterestsum;
  private BigDecimal remaininterestsum;
  private BigDecimal remainpriamount;
  private BigDecimal repaidinterestsum;
  private BigDecimal repaidamountsum;
  private String termstatus;
  private String transcode;
  private Integer paystatus;
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

  public Date getRepaydate()
  {
    return this.repaydate;
  }

  public void setRepaydate(Date repaydate)
  {
    this.repaydate = repaydate;
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

  public BigDecimal getPrincipalamountsum()
  {
    if (this.principalamountsum == null) {
      this.principalamountsum = BigDecimal.ZERO;
    }
    return this.principalamountsum;
  }

  public void setPrincipalamountsum(BigDecimal principalamountsum)
  {
    this.principalamountsum = principalamountsum;
  }

  public BigDecimal getAccruedinterestsum()
  {
    if (this.accruedinterestsum == null) {
      this.accruedinterestsum = BigDecimal.ZERO;
    }
    return this.accruedinterestsum;
  }

  public void setAccruedinterestsum(BigDecimal accruedinterestsum)
  {
    this.accruedinterestsum = accruedinterestsum;
  }

  public BigDecimal getRemaininterestsum()
  {
    if (this.remaininterestsum == null) {
      this.remaininterestsum = BigDecimal.ZERO;
    }
    return this.remaininterestsum;
  }

  public void setRemaininterestsum(BigDecimal remaininterestsum)
  {
    this.remaininterestsum = remaininterestsum;
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

  public BigDecimal getRepaidinterestsum()
  {
    if (this.repaidinterestsum == null) {
      this.repaidinterestsum = BigDecimal.ZERO;
    }
    return this.repaidinterestsum;
  }

  public void setRepaidinterestsum(BigDecimal repaidinterestsum)
  {
    this.repaidinterestsum = repaidinterestsum;
  }

  public BigDecimal getRepaidamountsum()
  {
    if (this.repaidamountsum == null) {
      this.repaidamountsum = BigDecimal.ZERO;
    }
    return this.repaidamountsum;
  }

  public void setRepaidamountsum(BigDecimal repaidamountsum)
  {
    this.repaidamountsum = repaidamountsum;
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

  public Integer getPaystatus()
  {
    return this.paystatus;
  }

  public void setPaystatus(Integer paystatus)
  {
    this.paystatus = paystatus;
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