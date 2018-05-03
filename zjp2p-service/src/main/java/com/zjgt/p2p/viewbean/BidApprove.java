package com.zjgt.p2p.viewbean;

import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.Bid;

public class BidApprove
{
  private String number;
  private Bid bid;
  private Approve approve;

  public Bid getBid()
  {
    return this.bid;
  }

  public void setBid(Bid bid) {
    this.bid = bid;
  }

  public Approve getApprove() {
    return this.approve;
  }

  public void setApprove(Approve approve) {
    this.approve = approve;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}