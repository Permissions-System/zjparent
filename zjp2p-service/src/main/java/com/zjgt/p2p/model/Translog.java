package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Translog
{
  private Long id;
  private String transno;
  private Date transtime;
  private String transcode;
  private String transdesc;
  private BigDecimal amount;
  private BigDecimal availamount;
  private BigDecimal platavailamount;
  private BigDecimal paysubamount;
  private BigDecimal payeesubamount;
  private String currency;
  private Integer paymemberid;
  private Long payaccountid;
  private String payaccountno;
  private String payername;
  private String paycardnum;
  private Integer payaccounttype;
  private Integer payeememberid;
  private Long payeeaccountid;
  private String payeeaccountno;
  private String payeename;
  private String payeecardnum;
  private Integer payeeaccounttype;
  private Integer transstatus;
  private Integer memberid;
  private String remark;
  private String transCodeName;
  private String capitalDirection;

  public String getTransCodeName()
  {
    return this.transCodeName;
  }

  public void setTransCodeName(String transCodeName) {
    this.transCodeName = transCodeName;
  }

  public String getCapitalDirection() {
    return this.capitalDirection;
  }

  public void setCapitalDirection(String capitalDirection) {
    this.capitalDirection = capitalDirection;
  }

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getTransno()
  {
    return this.transno;
  }

  public void setTransno(String transno)
  {
    this.transno = ((transno == null) ? null : transno.trim());
  }

  public Date getTranstime()
  {
    return this.transtime;
  }

  public void setTranstime(Date transtime)
  {
    this.transtime = transtime;
  }

  public String getTranscode()
  {
    return this.transcode;
  }

  public void setTranscode(String transcode)
  {
    this.transcode = ((transcode == null) ? null : transcode.trim());
  }

  public String getTransdesc()
  {
    return this.transdesc;
  }

  public void setTransdesc(String transdesc)
  {
    this.transdesc = ((transdesc == null) ? null : transdesc.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public BigDecimal getAvailamount()
  {
    return this.availamount;
  }

  public void setAvailamount(BigDecimal availamount)
  {
    this.availamount = availamount;
  }

  public BigDecimal getPlatavailamount()
  {
    return this.platavailamount;
  }

  public void setPlatavailamount(BigDecimal platavailamount)
  {
    this.platavailamount = platavailamount;
  }

  public BigDecimal getPaysubamount()
  {
    return this.paysubamount;
  }

  public void setPaysubamount(BigDecimal paysubamount)
  {
    this.paysubamount = paysubamount;
  }

  public BigDecimal getPayeesubamount()
  {
    return this.payeesubamount;
  }

  public void setPayeesubamount(BigDecimal payeesubamount)
  {
    this.payeesubamount = payeesubamount;
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = ((currency == null) ? null : currency.trim());
  }

  public Integer getPaymemberid()
  {
    return this.paymemberid;
  }

  public void setPaymemberid(Integer paymemberid)
  {
    this.paymemberid = paymemberid;
  }

  public Long getPayaccountid()
  {
    return this.payaccountid;
  }

  public void setPayaccountid(Long payaccountid)
  {
    this.payaccountid = payaccountid;
  }

  public String getPayaccountno()
  {
    return this.payaccountno;
  }

  public void setPayaccountno(String payaccountno)
  {
    this.payaccountno = ((payaccountno == null) ? null : payaccountno.trim());
  }

  public String getPayername()
  {
    return this.payername;
  }

  public void setPayername(String payername)
  {
    this.payername = ((payername == null) ? null : payername.trim());
  }

  public String getPaycardnum()
  {
    return this.paycardnum;
  }

  public void setPaycardnum(String paycardnum)
  {
    this.paycardnum = ((paycardnum == null) ? null : paycardnum.trim());
  }

  public Integer getPayaccounttype()
  {
    return this.payaccounttype;
  }

  public void setPayaccounttype(Integer payaccounttype)
  {
    this.payaccounttype = payaccounttype;
  }

  public Integer getPayeememberid()
  {
    return this.payeememberid;
  }

  public void setPayeememberid(Integer payeememberid)
  {
    this.payeememberid = payeememberid;
  }

  public Long getPayeeaccountid()
  {
    return this.payeeaccountid;
  }

  public void setPayeeaccountid(Long payeeaccountid)
  {
    this.payeeaccountid = payeeaccountid;
  }

  public String getPayeeaccountno()
  {
    return this.payeeaccountno;
  }

  public void setPayeeaccountno(String payeeaccountno)
  {
    this.payeeaccountno = ((payeeaccountno == null) ? null : payeeaccountno.trim());
  }

  public String getPayeename()
  {
    return this.payeename;
  }

  public void setPayeename(String payeename)
  {
    this.payeename = ((payeename == null) ? null : payeename.trim());
  }

  public String getPayeecardnum()
  {
    return this.payeecardnum;
  }

  public void setPayeecardnum(String payeecardnum)
  {
    this.payeecardnum = ((payeecardnum == null) ? null : payeecardnum.trim());
  }

  public Integer getPayeeaccounttype()
  {
    return this.payeeaccounttype;
  }

  public void setPayeeaccounttype(Integer payeeaccounttype)
  {
    this.payeeaccounttype = payeeaccounttype;
  }

  public Integer getTransstatus()
  {
    return this.transstatus;
  }

  public void setTransstatus(Integer transstatus)
  {
    this.transstatus = transstatus;
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
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