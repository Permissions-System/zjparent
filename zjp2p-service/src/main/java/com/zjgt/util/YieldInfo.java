package com.zjgt.util;

import com.zjgt.p2p.model.Yieldplan;
import java.math.BigDecimal;
import java.util.List;

public class YieldInfo
{
  private BigDecimal totalAmount;
  private BigDecimal totalInterest;
  private BigDecimal perTermAmount;
  private BigDecimal firstRepayAmount;
  private List<Yieldplan> yieldDtls;

  public BigDecimal getTotalAmount()
  {
    return this.totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  public BigDecimal getTotalInterest() {
    return this.totalInterest;
  }

  public void setTotalInterest(BigDecimal totalInterest) {
    this.totalInterest = totalInterest;
  }

  public BigDecimal getPerTermAmount() {
    return this.perTermAmount;
  }

  public void setPerTermAmount(BigDecimal perTermAmount) {
    this.perTermAmount = perTermAmount;
  }

  public BigDecimal getFirstRepayAmount() {
    return this.firstRepayAmount;
  }

  public void setFirstRepayAmount(BigDecimal firstRepayAmount) {
    this.firstRepayAmount = firstRepayAmount;
  }

  public List<Yieldplan> getYieldDtls() {
    return this.yieldDtls;
  }

  public void setYieldDtls(List<Yieldplan> yieldDtls) {
    this.yieldDtls = yieldDtls;
  }
}