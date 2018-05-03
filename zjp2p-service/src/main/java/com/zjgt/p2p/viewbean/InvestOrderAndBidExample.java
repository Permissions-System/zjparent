package com.zjgt.p2p.viewbean;

import java.util.Date;
import java.util.List;

public class InvestOrderAndBidExample
{
  private List<String> bidtypeids;
  private String orderstatus;
  private String orderstatusdesc;
  private long memberid;
  private String transstatus;
  protected String bidclassname;
  protected Date investOrderstarttime;
  protected Date investOrderendtime;
  protected Integer startPos;
  protected Integer pageSize;

  public String getBidclassname()
  {
    return this.bidclassname;
  }

  public void setBidclassname(String bidclassname)
  {
    this.bidclassname = bidclassname;
  }

  public Date getInvestOrderstarttime()
  {
    return this.investOrderstarttime;
  }

  public void setInvestOrderstarttime(Date investOrderstarttime)
  {
    this.investOrderstarttime = investOrderstarttime;
  }

  public Date getInvestOrderendtime()
  {
    return this.investOrderendtime;
  }

  public void setInvestOrderendtime(Date investOrderendtime)
  {
    this.investOrderendtime = investOrderendtime;
  }

  public void setTransstatus(String transstatus)
  {
    this.transstatus = transstatus;
  }

  public String getTransstatus()
  {
    return this.transstatus;
  }

  public String getOrderstatusdesc()
  {
    return this.orderstatusdesc;
  }

  public void setOrderstatusdesc(String orderstatusdesc)
  {
    this.orderstatusdesc = orderstatusdesc;
  }

  public List<String> getBidtypeid()
  {
    return this.bidtypeids;
  }

  public void setBidtypeids(List<String> bidtypeids)
  {
    this.bidtypeids = bidtypeids;
  }

  public String getOrderstatus()
  {
    return this.orderstatus;
  }

  public void setOrderstatus(String orderstatus) {
    this.orderstatus = orderstatus;
  }

  public long getMemberid() {
    return this.memberid;
  }

  public void setMemberid(long memberid) {
    this.memberid = memberid;
  }

  public Integer getStartPos() {
    return this.startPos;
  }

  public void setStartPos(Integer startPos) {
    this.startPos = startPos;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
}