package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Capitaltrans
{
  private Long id;
  private String transno;
  private Date transtime;
  private Integer transtype;
  private Integer memberAcctid;
  private Integer memberid;
  private String realname;
  private BigDecimal amount;
  private BigDecimal availamount;
  private BigDecimal fees;
  private BigDecimal feerate;
  private String currency;
  private Long payaccountid;
  private String payaccountno;
  private String payername;
  private String paycardnum;
  private Integer payaccounttype;
  private Long payeeaccountid;
  private String payeeaccountno;
  private String payeename;
  private String payeecardnum;
  private Integer payeeaccounttype;
  private Integer transstatus;
  private String remark;
  private List<Translog> tranLogs;
  private List<Translogplat> translogplat;

  public List<Translogplat> getTranslogplat()
  {
    return this.translogplat;
  }

  public void setTranslogplat(List<Translogplat> translogplat) {
    this.translogplat = translogplat;
  }

  public List<Translog> getTranLogs() {
    return this.tranLogs;
  }

  public void setTranLogs(List<Translog> tranLogs) {
    this.tranLogs = tranLogs;
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

  public Integer getTranstype()
  {
    return this.transtype;
  }

  public void setTranstype(Integer transtype)
  {
    this.transtype = transtype;
  }

  public Integer getMemberAcctid()
  {
    return this.memberAcctid;
  }

  public void setMemberAcctid(Integer memberAcctid)
  {
    this.memberAcctid = memberAcctid;
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
  }

  public String getRealname()
  {
    return this.realname;
  }

  public void setRealname(String realname)
  {
    this.realname = ((realname == null) ? null : realname.trim());
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

  public BigDecimal getFees()
  {
    return this.fees;
  }

  public void setFees(BigDecimal fees)
  {
    this.fees = fees;
  }

  public BigDecimal getFeerate()
  {
    return this.feerate;
  }

  public void setFeerate(BigDecimal feerate)
  {
    this.feerate = feerate;
  }

  public String getCurrency()
  {
    return this.currency;
  }

  public void setCurrency(String currency)
  {
    this.currency = ((currency == null) ? null : currency.trim());
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

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }
}