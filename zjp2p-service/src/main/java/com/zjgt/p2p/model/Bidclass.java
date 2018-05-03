package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Bidclass
{
  private Long id;
  private String bidclassno;
  private String bidclassname;
  private String bidclasssubject;
  private String thumpic;
  private String bidclasspic;
  private BigDecimal amount;
  private String investperiod;
  private String raiseperiod;
  private Date exptinterestdate;
  private Date exptexpiredate;
  private Integer intestcalctypeid;
  private String intestcalctype;
  private Date exptlastacctdate;
  private BigDecimal mininvestamount;
  private BigDecimal maxinvestamount;
  private Integer ifredeem;
  private Integer redeemfeetype;
  private BigDecimal redeemfee;
  private Integer iftransfer;
  private Integer transfertype;
  private BigDecimal transfee;
  private Integer assureinstid;
  private Integer ensuretype;
  private Integer agreement1;
  private Integer agreement2;
  private Integer agreement3;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getBidclassno()
  {
    return this.bidclassno;
  }

  public void setBidclassno(String bidclassno)
  {
    this.bidclassno = ((bidclassno == null) ? null : bidclassno.trim());
  }

  public String getBidclassname()
  {
    return this.bidclassname;
  }

  public void setBidclassname(String bidclassname)
  {
    this.bidclassname = ((bidclassname == null) ? null : bidclassname.trim());
  }

  public String getBidclasssubject()
  {
    return this.bidclasssubject;
  }

  public void setBidclasssubject(String bidclasssubject)
  {
    this.bidclasssubject = ((bidclasssubject == null) ? null : bidclasssubject.trim());
  }

  public String getThumpic()
  {
    return this.thumpic;
  }

  public void setThumpic(String thumpic)
  {
    this.thumpic = ((thumpic == null) ? null : thumpic.trim());
  }

  public String getBidclasspic()
  {
    return this.bidclasspic;
  }

  public void setBidclasspic(String bidclasspic)
  {
    this.bidclasspic = ((bidclasspic == null) ? null : bidclasspic.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public String getInvestperiod()
  {
    return this.investperiod;
  }

  public void setInvestperiod(String investperiod)
  {
    this.investperiod = ((investperiod == null) ? null : investperiod.trim());
  }

  public String getRaiseperiod()
  {
    return this.raiseperiod;
  }

  public void setRaiseperiod(String raiseperiod)
  {
    this.raiseperiod = ((raiseperiod == null) ? null : raiseperiod.trim());
  }

  public Date getExptinterestdate()
  {
    return this.exptinterestdate;
  }

  public void setExptinterestdate(Date exptinterestdate)
  {
    this.exptinterestdate = exptinterestdate;
  }

  public Date getExptexpiredate()
  {
    return this.exptexpiredate;
  }

  public void setExptexpiredate(Date exptexpiredate)
  {
    this.exptexpiredate = exptexpiredate;
  }

  public Integer getIntestcalctypeid()
  {
    return this.intestcalctypeid;
  }

  public void setIntestcalctypeid(Integer intestcalctypeid)
  {
    this.intestcalctypeid = intestcalctypeid;
  }

  public String getIntestcalctype()
  {
    return this.intestcalctype;
  }

  public void setIntestcalctype(String intestcalctype)
  {
    this.intestcalctype = ((intestcalctype == null) ? null : intestcalctype.trim());
  }

  public Date getExptlastacctdate()
  {
    return this.exptlastacctdate;
  }

  public void setExptlastacctdate(Date exptlastacctdate)
  {
    this.exptlastacctdate = exptlastacctdate;
  }

  public BigDecimal getMininvestamount()
  {
    return this.mininvestamount;
  }

  public void setMininvestamount(BigDecimal mininvestamount)
  {
    this.mininvestamount = mininvestamount;
  }

  public BigDecimal getMaxinvestamount()
  {
    return this.maxinvestamount;
  }

  public void setMaxinvestamount(BigDecimal maxinvestamount)
  {
    this.maxinvestamount = maxinvestamount;
  }

  public Integer getIfredeem()
  {
    return this.ifredeem;
  }

  public void setIfredeem(Integer ifredeem)
  {
    this.ifredeem = ifredeem;
  }

  public Integer getRedeemfeetype()
  {
    return this.redeemfeetype;
  }

  public void setRedeemfeetype(Integer redeemfeetype)
  {
    this.redeemfeetype = redeemfeetype;
  }

  public BigDecimal getRedeemfee()
  {
    return this.redeemfee;
  }

  public void setRedeemfee(BigDecimal redeemfee)
  {
    this.redeemfee = redeemfee;
  }

  public Integer getIftransfer()
  {
    return this.iftransfer;
  }

  public void setIftransfer(Integer iftransfer)
  {
    this.iftransfer = iftransfer;
  }

  public Integer getTransfertype()
  {
    return this.transfertype;
  }

  public void setTransfertype(Integer transfertype)
  {
    this.transfertype = transfertype;
  }

  public BigDecimal getTransfee()
  {
    return this.transfee;
  }

  public void setTransfee(BigDecimal transfee)
  {
    this.transfee = transfee;
  }

  public Integer getAssureinstid()
  {
    return this.assureinstid;
  }

  public void setAssureinstid(Integer assureinstid)
  {
    this.assureinstid = assureinstid;
  }

  public Integer getEnsuretype()
  {
    return this.ensuretype;
  }

  public void setEnsuretype(Integer ensuretype)
  {
    this.ensuretype = ensuretype;
  }

  public Integer getAgreement1()
  {
    return this.agreement1;
  }

  public void setAgreement1(Integer agreement1)
  {
    this.agreement1 = agreement1;
  }

  public Integer getAgreement2()
  {
    return this.agreement2;
  }

  public void setAgreement2(Integer agreement2)
  {
    this.agreement2 = agreement2;
  }

  public Integer getAgreement3()
  {
    return this.agreement3;
  }

  public void setAgreement3(Integer agreement3)
  {
    this.agreement3 = agreement3;
  }
}