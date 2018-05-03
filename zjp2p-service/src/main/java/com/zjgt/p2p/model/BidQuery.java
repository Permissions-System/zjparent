package com.zjgt.p2p.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BidQuery
  implements Serializable
{
  private static final long serialVersionUID = 5689259285233975751L;
  private Integer bidtype;
  private String borrowername;
  private String bidname;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date payDateStart;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date payDateEnd;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date exptDateStart;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date exptDateEnd;
  private Integer borrowstatus;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date toAcctDateStart;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date toAcctDateEnd;
  private Integer removebidstatus;
  private String investordercode;

  public Integer getBidtype()
  {
    return this.bidtype;
  }

  public void setBidtype(Integer bidtype) {
    this.bidtype = bidtype;
  }

  public String getBorrowername() {
    return this.borrowername;
  }

  public void setBorrowername(String borrowername) {
    this.borrowername = borrowername;
  }

  public String getBidname() {
    return this.bidname;
  }

  public void setBidname(String bidname) {
    this.bidname = bidname;
  }

  public Date getPayDateStart() {
    return this.payDateStart;
  }

  public void setPayDateStart(Date payDateStart) {
    this.payDateStart = payDateStart;
  }

  public Date getPayDateEnd() {
    return this.payDateEnd;
  }

  public void setPayDateEnd(Date payDateEnd) {
    this.payDateEnd = payDateEnd;
  }

  public Date getExptDateStart() {
    return this.exptDateStart;
  }

  public void setExptDateStart(Date exptDateStart) {
    this.exptDateStart = exptDateStart;
  }

  public Date getExptDateEnd() {
    return this.exptDateEnd;
  }

  public void setExptDateEnd(Date exptDateEnd) {
    this.exptDateEnd = exptDateEnd;
  }

  public Integer getBorrowstatus() {
    return this.borrowstatus;
  }

  public void setBorrowstatus(Integer borrowstatus) {
    this.borrowstatus = borrowstatus;
  }

  public Date getToAcctDateStart() {
    return this.toAcctDateStart;
  }

  public void setToAcctDateStart(Date toAcctDateStart) {
    this.toAcctDateStart = toAcctDateStart;
  }

  public Date getToAcctDateEnd() {
    return this.toAcctDateEnd;
  }

  public void setToAcctDateEnd(Date toAcctDateEnd) {
    this.toAcctDateEnd = toAcctDateEnd;
  }

  public Integer getRemovebidstatus() {
    return this.removebidstatus;
  }

  public void setRemovebidstatus(Integer removebidstatus) {
    this.removebidstatus = removebidstatus;
  }

  public String getInvestordercode() {
    return this.investordercode;
  }

  public void setInvestordercode(String investordercode) {
    this.investordercode = investordercode;
  }
}