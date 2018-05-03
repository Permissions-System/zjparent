package com.zjgt.p2p.viewbean;

import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Member;

public class InvestOrderApprove
{
  private String number;
  private Integer investNo;
  private Integer bidamount;
  private InvestOrder investOrder;
  private Bid bid;
  private Member member;
  private Approve approve;

  public Integer getInvestNo()
  {
    return this.investNo;
  }

  public void setInvestNo(Integer investNo) {
    this.investNo = investNo;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public InvestOrder getInvestOrder() {
    return this.investOrder;
  }

  public void setInvestOrder(InvestOrder investOrder) {
    this.investOrder = investOrder;
  }

  public Bid getBid() {
    return this.bid;
  }

  public void setBid(Bid bid) {
    this.bid = bid;
  }

  public Member getMember() {
    return this.member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Approve getApprove() {
    return this.approve;
  }

  public void setApprove(Approve approve) {
    this.approve = approve;
  }

  public Integer getBidamount() {
    return this.bidamount;
  }

  public void setBidamount(Integer bidamount) {
    this.bidamount = bidamount;
  }
}