package com.zjgt.p2p.viewbean;

import java.util.Date;

public class InvestOrderApproveExample
{
  protected String id;
  protected Integer flowstep;
  protected String bidcode;
  protected String username;
  protected String name;
  protected String orderstatusdesc;
  protected Date bidstarttime;
  protected Date bidendtime;
  protected Date applystarttime;
  protected Date applyendtime;
  protected Integer startPos;
  protected Integer pageSize;

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrderstatusdesc()
  {
    return this.orderstatusdesc;
  }

  public void setOrderstatusdesc(String orderstatusdesc) {
    this.orderstatusdesc = orderstatusdesc;
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

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getFlowstep() {
    return this.flowstep;
  }

  public void setFlowstep(Integer flowstep) {
    this.flowstep = flowstep;
  }

  public String getBidcode() {
    return this.bidcode;
  }

  public void setBidcode(String bidcode) {
    this.bidcode = bidcode;
  }

  public Date getBidstarttime() {
    return this.bidstarttime;
  }

  public void setBidstarttime(Date bidstarttime) {
    this.bidstarttime = bidstarttime;
  }

  public Date getBidendtime() {
    return this.bidendtime;
  }

  public void setBidendtime(Date bidendtime) {
    this.bidendtime = bidendtime;
  }

  public Date getApplystarttime() {
    return this.applystarttime;
  }

  public void setApplystarttime(Date applystarttime) {
    this.applystarttime = applystarttime;
  }

  public Date getApplyendtime() {
    return this.applyendtime;
  }

  public void setApplyendtime(Date applyendtime) {
    this.applyendtime = applyendtime;
  }
}