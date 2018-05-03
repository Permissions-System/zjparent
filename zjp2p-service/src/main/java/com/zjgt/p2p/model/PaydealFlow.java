package com.zjgt.p2p.model;

import java.math.BigDecimal;

public class PaydealFlow
{
  private String dealflownum;
  private String dealid;
  private String dealtype;
  private Long dealuserid;
  private String dealrequesttime;
  private String dealobject;
  private BigDecimal dealamount;
  private String dealresponsemsg;
  private String dealrequestmsg;
  private int dealstatus;
  private String dealresponsetime;
  private String dealfaileddesc;

  public String getDealflownum()
  {
    return this.dealflownum;
  }

  public void setDealflownum(String dealflownum)
  {
    this.dealflownum = ((dealflownum == null) ? null : dealflownum.trim());
  }

  public String getDealid()
  {
    return this.dealid;
  }

  public void setDealid(String dealid)
  {
    this.dealid = ((dealid == null) ? null : dealid.trim());
  }

  public String getDealtype()
  {
    return this.dealtype;
  }

  public void setDealtype(String dealtype)
  {
    this.dealtype = ((dealtype == null) ? null : dealtype.trim());
  }

  public Long getDealuserid()
  {
    return this.dealuserid;
  }

  public void setDealuserid(Long dealuserid)
  {
    this.dealuserid = dealuserid;
  }

  public String getDealrequesttime()
  {
    return this.dealrequesttime;
  }

  public void setDealrequesttime(String dealrequesttime)
  {
    this.dealrequesttime = ((dealrequesttime == null) ? null : dealrequesttime.trim());
  }

  public String getDealobject()
  {
    return this.dealobject;
  }

  public void setDealobject(String dealobject)
  {
    this.dealobject = ((dealobject == null) ? null : dealobject.trim());
  }

  public BigDecimal getDealamount()
  {
    return this.dealamount;
  }

  public void setDealamount(BigDecimal dealamount)
  {
    this.dealamount = dealamount;
  }

  public String getDealresponsemsg()
  {
    return this.dealresponsemsg;
  }

  public void setDealresponsemsg(String dealresponsemsg)
  {
    this.dealresponsemsg = ((dealresponsemsg == null) ? null : dealresponsemsg.trim());
  }

  public String getDealrequestmsg()
  {
    return this.dealrequestmsg;
  }

  public void setDealrequestmsg(String dealrequestmsg)
  {
    this.dealrequestmsg = ((dealrequestmsg == null) ? null : dealrequestmsg.trim());
  }

  public int getDealstatus()
  {
    return this.dealstatus;
  }

  public void setDealstatus(int dealstatus)
  {
    this.dealstatus = dealstatus;
  }

  public String getDealresponsetime()
  {
    return this.dealresponsetime;
  }

  public void setDealresponsetime(String dealresponsetime)
  {
    this.dealresponsetime = ((dealresponsetime == null) ? null : dealresponsetime.trim());
  }

  public String getDealfaileddesc()
  {
    return this.dealfaileddesc;
  }

  public void setDealfaileddesc(String dealfaileddesc)
  {
    this.dealfaileddesc = ((dealfaileddesc == null) ? null : dealfaileddesc.trim());
  }
}