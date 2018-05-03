package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Bid
{
  private Integer id;
  private String bidcode;
  private String bidno;
  private String bidclassno;
  private Integer bidtypeid;
  private String bidtype;
  private String bidclassname;
  private String bidclasssubject;
  private String bidimg;
  private BigDecimal amount;
  private BigDecimal remainpriamount;
  private Integer investperiodtypeid;
  private Integer investperiod;
  private String raiseperiod;
  private Date raisebegindate;
  private Date raiseenddate;
  private Date exptinterestdate;
  private Date exptexpiredate;
  private BigDecimal annualizedrate;
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
  private String pledgetype;
  private String borrowercode;
  private String borrowername;
  private String borrowerdesc;
  private BigDecimal borrowerinterest;
  private String instcode;
  private String assureinstname;
  private String ensuretype;
  private Integer agreement1;
  private Integer agreement2;
  private Integer agreement3;
  private BigDecimal raisemoney;
  private Integer raisestate;
  private String repaymentway;
  private String bindinnerno;
  private String bidclassintro;
  private String investscope;
  private String incomedesc;
  private Integer incomeway;
  private String raisecond;
  private String redeemway;
  private BigDecimal raiserate;
  private BigDecimal redemrate;
  private BigDecimal transrate;
  private BigDecimal prepayrate;
  private String receiptdesc;
  private Integer bidnum;
  private Date pubdate;
  private Integer memberid;
  private String staffNo;
  private String membername;
  private BigDecimal riskmgrfee;
  private String transname;
  private String projectcode;
  private String projectfeature;
  private BigDecimal yearservicefee;
  private BigDecimal pubfee;
  private BigDecimal infofee;
  private BigDecimal overduefee;
  private BigDecimal unpaidfee;
  private String investordercode;
  private Integer ifextrarate;
  private Integer ifvirtual;
  private BigDecimal extrarate;
  private Integer approstatus;
  private Integer bidstatus;
  private Integer borrowstatus;
  private Integer lockupperiod;
  private String remark;
  private String assureinstdesc;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getBidcode()
  {
    return this.bidcode;
  }

  public void setBidcode(String bidcode)
  {
    this.bidcode = ((bidcode == null) ? null : bidcode.trim());
  }

  public String getBidno()
  {
    return this.bidno;
  }

  public void setBidno(String bidno)
  {
    this.bidno = ((bidno == null) ? null : bidno.trim());
  }

  public String getBidclassno()
  {
    return this.bidclassno;
  }

  public void setBidclassno(String bidclassno)
  {
    this.bidclassno = ((bidclassno == null) ? null : bidclassno.trim());
  }

  public Integer getBidtypeid()
  {
    return this.bidtypeid;
  }

  public void setBidtypeid(Integer bidtypeid)
  {
    this.bidtypeid = bidtypeid;
  }

  public String getBidtype()
  {
    return this.bidtype;
  }

  public void setBidtype(String bidtype)
  {
    this.bidtype = ((bidtype == null) ? null : bidtype.trim());
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

  public String getBidimg()
  {
    return this.bidimg;
  }

  public void setBidimg(String bidimg)
  {
    this.bidimg = ((bidimg == null) ? null : bidimg.trim());
  }

  public BigDecimal getAmount()
  {
    if (this.amount == null) {
      this.amount = BigDecimal.ZERO;
    }
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
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

  public Integer getInvestperiodtypeid()
  {
    return this.investperiodtypeid;
  }

  public void setInvestperiodtypeid(Integer investperiodtypeid)
  {
    this.investperiodtypeid = investperiodtypeid;
  }

  public Integer getInvestperiod()
  {
    return this.investperiod;
  }

  public void setInvestperiod(Integer investperiod)
  {
    this.investperiod = investperiod;
  }

  public String getRaiseperiod()
  {
    return this.raiseperiod;
  }

  public void setRaiseperiod(String raiseperiod)
  {
    this.raiseperiod = ((raiseperiod == null) ? null : raiseperiod.trim());
  }

  public Date getRaisebegindate()
  {
    return this.raisebegindate;
  }

  public void setRaisebegindate(Date raisebegindate)
  {
    this.raisebegindate = raisebegindate;
  }

  public Date getRaiseenddate()
  {
    return this.raiseenddate;
  }

  public void setRaiseenddate(Date raiseenddate)
  {
    this.raiseenddate = raiseenddate;
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

  public BigDecimal getAnnualizedrate()
  {
    if (this.annualizedrate == null) {
      this.annualizedrate = BigDecimal.ZERO;
    }
    return this.annualizedrate;
  }

  public void setAnnualizedrate(BigDecimal annualizedrate)
  {
    this.annualizedrate = annualizedrate;
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
    if (this.mininvestamount == null) {
      this.mininvestamount = BigDecimal.ZERO;
    }
    return this.mininvestamount;
  }

  public void setMininvestamount(BigDecimal mininvestamount)
  {
    this.mininvestamount = mininvestamount;
  }

  public BigDecimal getMaxinvestamount()
  {
    if (this.maxinvestamount == null) {
      this.maxinvestamount = BigDecimal.ZERO;
    }
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
    if (this.redeemfee == null) {
      this.redeemfee = BigDecimal.ZERO;
    }
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
    if (this.transfee == null) {
      this.transfee = BigDecimal.ZERO;
    }
    return this.transfee;
  }

  public void setTransfee(BigDecimal transfee)
  {
    this.transfee = transfee;
  }

  public String getPledgetype()
  {
    return this.pledgetype;
  }

  public void setPledgetype(String pledgetype)
  {
    this.pledgetype = ((pledgetype == null) ? null : pledgetype.trim());
  }

  public String getBorrowercode()
  {
    return this.borrowercode;
  }

  public void setBorrowercode(String borrowercode)
  {
    this.borrowercode = ((borrowercode == null) ? null : borrowercode.trim());
  }

  public String getBorrowername()
  {
    return this.borrowername;
  }

  public void setBorrowername(String borrowername)
  {
    this.borrowername = ((borrowername == null) ? null : borrowername.trim());
  }

  public String getBorrowerdesc()
  {
    return this.borrowerdesc;
  }

  public void setBorrowerdesc(String borrowerdesc)
  {
    this.borrowerdesc = ((borrowerdesc == null) ? null : borrowerdesc.trim());
  }

  public BigDecimal getBorrowerinterest()
  {
    return this.borrowerinterest;
  }

  public void setBorrowerinterest(BigDecimal borrowerinterest)
  {
    this.borrowerinterest = borrowerinterest;
  }

  public String getInstcode()
  {
    return this.instcode;
  }

  public void setInstcode(String instcode)
  {
    this.instcode = ((instcode == null) ? null : instcode.trim());
  }

  public String getAssureinstname()
  {
    return this.assureinstname;
  }

  public void setAssureinstname(String assureinstname)
  {
    this.assureinstname = ((assureinstname == null) ? null : assureinstname.trim());
  }

  public String getEnsuretype()
  {
    return this.ensuretype;
  }

  public void setEnsuretype(String ensuretype)
  {
    this.ensuretype = ((ensuretype == null) ? null : ensuretype.trim());
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

  public BigDecimal getRaisemoney()
  {
    return this.raisemoney;
  }

  public void setRaisemoney(BigDecimal raisemoney)
  {
    this.raisemoney = raisemoney;
  }

  public Integer getRaisestate()
  {
    return this.raisestate;
  }

  public void setRaisestate(Integer raisestate)
  {
    this.raisestate = raisestate;
  }

  public String getRepaymentway()
  {
    return this.repaymentway;
  }

  public void setRepaymentway(String repaymentway)
  {
    this.repaymentway = ((repaymentway == null) ? null : repaymentway.trim());
  }

  public String getBindinnerno()
  {
    return this.bindinnerno;
  }

  public void setBindinnerno(String bindinnerno)
  {
    this.bindinnerno = ((bindinnerno == null) ? null : bindinnerno.trim());
  }

  public String getBidclassintro()
  {
    return this.bidclassintro;
  }

  public void setBidclassintro(String bidclassintro)
  {
    this.bidclassintro = ((bidclassintro == null) ? null : bidclassintro.trim());
  }

  public String getInvestscope()
  {
    return this.investscope;
  }

  public void setInvestscope(String investscope)
  {
    this.investscope = ((investscope == null) ? null : investscope.trim());
  }

  public String getIncomedesc()
  {
    return this.incomedesc;
  }

  public void setIncomedesc(String incomedesc)
  {
    this.incomedesc = ((incomedesc == null) ? null : incomedesc.trim());
  }

  public Integer getIncomeway()
  {
    return this.incomeway;
  }

  public void setIncomeway(Integer incomeway)
  {
    this.incomeway = incomeway;
  }

  public String getRaisecond()
  {
    return this.raisecond;
  }

  public void setRaisecond(String raisecond)
  {
    this.raisecond = ((raisecond == null) ? null : raisecond.trim());
  }

  public String getRedeemway()
  {
    return this.redeemway;
  }

  public void setRedeemway(String redeemway)
  {
    this.redeemway = ((redeemway == null) ? null : redeemway.trim());
  }

  public BigDecimal getRaiserate()
  {
    return this.raiserate;
  }

  public void setRaiserate(BigDecimal raiserate)
  {
    this.raiserate = raiserate;
  }

  public BigDecimal getRedemrate()
  {
    return this.redemrate;
  }

  public void setRedemrate(BigDecimal redemrate)
  {
    this.redemrate = redemrate;
  }

  public BigDecimal getTransrate()
  {
    return this.transrate;
  }

  public void setTransrate(BigDecimal transrate)
  {
    this.transrate = transrate;
  }

  public BigDecimal getPrepayrate()
  {
    if (this.transfee == null) {
      this.prepayrate = BigDecimal.ZERO;
    }
    return this.prepayrate;
  }

  public void setPrepayrate(BigDecimal prepayrate)
  {
    this.prepayrate = prepayrate;
  }

  public String getReceiptdesc()
  {
    return this.receiptdesc;
  }

  public void setReceiptdesc(String receiptdesc)
  {
    this.receiptdesc = ((receiptdesc == null) ? null : receiptdesc.trim());
  }

  public Integer getBidnum()
  {
    return this.bidnum;
  }

  public void setBidnum(Integer bidnum)
  {
    this.bidnum = bidnum;
  }

  public Date getPubdate()
  {
    return this.pubdate;
  }

  public void setPubdate(Date pubdate)
  {
    this.pubdate = pubdate;
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
  }

  public String getStaffNo()
  {
    return this.staffNo;
  }

  public void setStaffNo(String staffNo)
  {
    this.staffNo = ((staffNo == null) ? null : staffNo.trim());
  }

  public String getMembername()
  {
    return this.membername;
  }

  public void setMembername(String membername)
  {
    this.membername = ((membername == null) ? null : membername.trim());
  }

  public BigDecimal getRiskmgrfee()
  {
    if (this.riskmgrfee == null) {
      this.riskmgrfee = BigDecimal.ZERO;
    }
    return this.riskmgrfee;
  }

  public void setRiskmgrfee(BigDecimal riskmgrfee)
  {
    this.riskmgrfee = riskmgrfee;
  }

  public String getTransname()
  {
    return this.transname;
  }

  public void setTransname(String transname)
  {
    this.transname = ((transname == null) ? null : transname.trim());
  }

  public String getProjectcode()
  {
    return this.projectcode;
  }

  public void setProjectcode(String projectcode)
  {
    this.projectcode = ((projectcode == null) ? null : projectcode.trim());
  }

  public String getProjectfeature()
  {
    return this.projectfeature;
  }

  public void setProjectfeature(String projectfeature)
  {
    this.projectfeature = ((projectfeature == null) ? null : projectfeature.trim());
  }

  public BigDecimal getYearservicefee()
  {
    if (this.yearservicefee == null) {
      this.yearservicefee = BigDecimal.ZERO;
    }
    return this.yearservicefee;
  }

  public void setYearservicefee(BigDecimal yearservicefee)
  {
    this.yearservicefee = yearservicefee;
  }

  public BigDecimal getPubfee()
  {
    if (this.pubfee == null) {
      this.pubfee = BigDecimal.ZERO;
    }
    return this.pubfee;
  }

  public void setPubfee(BigDecimal pubfee)
  {
    this.pubfee = pubfee;
  }

  public BigDecimal getInfofee()
  {
    if (this.infofee == null) {
      this.infofee = BigDecimal.ZERO;
    }
    return this.infofee;
  }

  public void setInfofee(BigDecimal infofee)
  {
    this.infofee = infofee;
  }

  public BigDecimal getOverduefee()
  {
    if (this.overduefee == null) {
      this.overduefee = BigDecimal.ZERO;
    }
    return this.overduefee;
  }

  public void setOverduefee(BigDecimal overduefee)
  {
    this.overduefee = overduefee;
  }

  public BigDecimal getUnpaidfee()
  {
    if (this.unpaidfee == null) {
      this.unpaidfee = BigDecimal.ZERO;
    }
    return this.unpaidfee;
  }

  public void setUnpaidfee(BigDecimal unpaidfee)
  {
    this.unpaidfee = unpaidfee;
  }

  public String getInvestordercode()
  {
    return this.investordercode;
  }

  public void setInvestordercode(String investordercode)
  {
    this.investordercode = ((investordercode == null) ? null : investordercode.trim());
  }

  public Integer getIfextrarate()
  {
    return this.ifextrarate;
  }

  public void setIfextrarate(Integer ifextrarate)
  {
    this.ifextrarate = ifextrarate;
  }

  public Integer getIfvirtual()
  {
    return this.ifvirtual;
  }

  public void setIfvirtual(Integer ifvirtual)
  {
    this.ifvirtual = ifvirtual;
  }

  public BigDecimal getExtrarate()
  {
    return this.extrarate;
  }

  public void setExtrarate(BigDecimal extrarate)
  {
    this.extrarate = extrarate;
  }

  public Integer getApprostatus()
  {
    return this.approstatus;
  }

  public void setApprostatus(Integer approstatus)
  {
    this.approstatus = approstatus;
  }

  public Integer getBidstatus()
  {
    return this.bidstatus;
  }

  public void setBidstatus(Integer bidstatus)
  {
    this.bidstatus = bidstatus;
  }

  public Integer getBorrowstatus()
  {
    return this.borrowstatus;
  }

  public void setBorrowstatus(Integer borrowstatus)
  {
    this.borrowstatus = borrowstatus;
  }

  public Integer getLockupperiod()
  {
    return this.lockupperiod;
  }

  public void setLockupperiod(Integer lockupperiod)
  {
    this.lockupperiod = lockupperiod;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }

  public String getAssureinstdesc()
  {
    return this.assureinstdesc;
  }

  public void setAssureinstdesc(String assureinstdesc)
  {
    this.assureinstdesc = ((assureinstdesc == null) ? null : assureinstdesc.trim());
  }
}