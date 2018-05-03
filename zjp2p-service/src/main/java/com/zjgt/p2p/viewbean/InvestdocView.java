package com.zjgt.p2p.viewbean;

import java.math.BigDecimal;

public class InvestdocView
{
  private BigDecimal amount;
  private String bidclassname;
  private String color;
  private BigDecimal allamount;

  public BigDecimal getAllamount()
  {
    return this.allamount;
  }

  public void setAllamount(BigDecimal allamount) {
    this.allamount = allamount;
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getBidclassname() {
    return this.bidclassname;
  }

  public void setBidclassname(String bidclassname) {
    this.bidclassname = bidclassname;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}