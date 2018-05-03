package com.zjgt.p2p.model;

import java.math.BigDecimal;
import java.util.Date;

public class Investorderhistory
{
  private Integer id;
  private Integer serialid;
  private String investordercode;
  private String preordercode;
  private String bidcode;
  private Integer creditmatchruleid;
  private Long customerid;
  private String customernickname;
  private String customername;
  private Long salerid;
  private String businesstype;
  private BigDecimal amount;
  private BigDecimal fee;
  private BigDecimal bonusamount;
  private Integer bonustype;
  private Integer investterm;
  private String termtype;
  private String channelcode;
  private BigDecimal exptincome;
  private String transname;
  private Integer transstatus;
  private Integer approstatus;
  private Integer orderstatus;
  private String orderstatusdesc;
  private Date orderdate;
  private Date opdate;
  private String remark;
  private Date expiredate;
  private Integer ifsum;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getSerialid()
  {
    return this.serialid;
  }

  public void setSerialid(Integer serialid)
  {
    this.serialid = serialid;
  }

  public String getInvestordercode()
  {
    return this.investordercode;
  }

  public void setInvestordercode(String investordercode)
  {
    this.investordercode = ((investordercode == null) ? null : investordercode.trim());
  }

  public String getPreordercode()
  {
    return this.preordercode;
  }

  public void setPreordercode(String preordercode)
  {
    this.preordercode = ((preordercode == null) ? null : preordercode.trim());
  }

  public String getBidcode()
  {
    return this.bidcode;
  }

  public void setBidcode(String bidcode)
  {
    this.bidcode = ((bidcode == null) ? null : bidcode.trim());
  }

  public Integer getCreditmatchruleid()
  {
    return this.creditmatchruleid;
  }

  public void setCreditmatchruleid(Integer creditmatchruleid)
  {
    this.creditmatchruleid = creditmatchruleid;
  }

  public Long getCustomerid()
  {
    return this.customerid;
  }

  public void setCustomerid(Long customerid)
  {
    this.customerid = customerid;
  }

  public String getCustomernickname()
  {
    return this.customernickname;
  }

  public void setCustomernickname(String customernickname)
  {
    this.customernickname = ((customernickname == null) ? null : customernickname.trim());
  }

  public String getCustomername()
  {
    return this.customername;
  }

  public void setCustomername(String customername)
  {
    this.customername = ((customername == null) ? null : customername.trim());
  }

  public Long getSalerid()
  {
    return this.salerid;
  }

  public void setSalerid(Long salerid)
  {
    this.salerid = salerid;
  }

  public String getBusinesstype()
  {
    return this.businesstype;
  }

  public void setBusinesstype(String businesstype)
  {
    this.businesstype = ((businesstype == null) ? null : businesstype.trim());
  }

  public BigDecimal getAmount()
  {
    return this.amount;
  }

  public void setAmount(BigDecimal amount)
  {
    this.amount = amount;
  }

  public BigDecimal getFee()
  {
    return this.fee;
  }

  public void setFee(BigDecimal fee)
  {
    this.fee = fee;
  }

  public BigDecimal getBonusamount()
  {
    return this.bonusamount;
  }

  public void setBonusamount(BigDecimal bonusamount)
  {
    this.bonusamount = bonusamount;
  }

  public Integer getBonustype()
  {
    return this.bonustype;
  }

  public void setBonustype(Integer bonustype)
  {
    this.bonustype = bonustype;
  }

  public Integer getInvestterm()
  {
    return this.investterm;
  }

  public void setInvestterm(Integer investterm)
  {
    this.investterm = investterm;
  }

  public String getTermtype()
  {
    return this.termtype;
  }

  public void setTermtype(String termtype)
  {
    this.termtype = ((termtype == null) ? null : termtype.trim());
  }

  public String getChannelcode()
  {
    return this.channelcode;
  }

  public void setChannelcode(String channelcode)
  {
    this.channelcode = ((channelcode == null) ? null : channelcode.trim());
  }

  public BigDecimal getExptincome()
  {
    return this.exptincome;
  }

  public void setExptincome(BigDecimal exptincome)
  {
    this.exptincome = exptincome;
  }

  public String getTransname()
  {
    return this.transname;
  }

  public void setTransname(String transname)
  {
    this.transname = ((transname == null) ? null : transname.trim());
  }

  public Integer getTransstatus()
  {
    return this.transstatus;
  }

  public void setTransstatus(Integer transstatus)
  {
    this.transstatus = transstatus;
  }

  public Integer getApprostatus()
  {
    return this.approstatus;
  }

  public void setApprostatus(Integer approstatus)
  {
    this.approstatus = approstatus;
  }

  public Integer getOrderstatus()
  {
    return this.orderstatus;
  }

  public void setOrderstatus(Integer orderstatus)
  {
    this.orderstatus = orderstatus;
  }

  public String getOrderstatusdesc()
  {
    return this.orderstatusdesc;
  }

  public void setOrderstatusdesc(String orderstatusdesc)
  {
    this.orderstatusdesc = ((orderstatusdesc == null) ? null : orderstatusdesc.trim());
  }

  public Date getOrderdate()
  {
    return this.orderdate;
  }

  public void setOrderdate(Date orderdate)
  {
    this.orderdate = orderdate;
  }

  public Date getOpdate()
  {
    return this.opdate;
  }

  public void setOpdate(Date opdate)
  {
    this.opdate = opdate;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }

  public Date getExpiredate()
  {
    return this.expiredate;
  }

  public void setExpiredate(Date expiredate)
  {
    this.expiredate = expiredate;
  }

  public Integer getIfsum()
  {
    return this.ifsum;
  }

  public void setIfsum(Integer ifsum)
  {
    this.ifsum = ifsum;
  }
}