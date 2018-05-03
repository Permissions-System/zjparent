package com.zjgt.p2p.viewbean;

public class BidApproveExample
{
  protected String id;
  protected String bidclassname;
  protected String bidcode;
  protected Integer approStatus;
  protected Integer flowstep;
  protected Integer startPos;
  protected Integer pageSize;

  public String getBidclassname()
  {
    return this.bidclassname;
  }

  public void setBidclassname(String bidclassname) {
    this.bidclassname = bidclassname;
  }

  public String getBidcode() {
    return this.bidcode;
  }

  public void setBidcode(String bidcode) {
    this.bidcode = bidcode;
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

  public Integer getApproStatus() {
    return this.approStatus;
  }

  public void setApproStatus(Integer approStatus) {
    this.approStatus = approStatus;
  }

  public Integer getFlowstep() {
    return this.flowstep;
  }

  public void setFlowstep(Integer flowstep) {
    this.flowstep = flowstep;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
}