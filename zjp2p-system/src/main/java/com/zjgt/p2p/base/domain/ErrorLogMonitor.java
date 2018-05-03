package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ErrorLogMonitor
  implements Serializable
{
  private static final long serialVersionUID = 1057879827514746062L;

  @NotNull(message="错误码不能为空")
  @Size(min=8, max=8, message="错误码长度为8个字符")
  private String errorCode;

  @NotNull(message="周期阀值不能为空")
  private BigDecimal cycleThreshold;

  @NotNull(message="每日阀值不能为空")
  private BigDecimal dayThreshold;

  @NotNull(message="周期出错数不能为空")
  private BigDecimal cycleNum;

  @NotNull(message="当日累计出错数不能为空")
  private BigDecimal dayNum;

  @NotNull(message="统计次数不能为空")
  private BigDecimal totalTimes;

  @NotNull(message="是否自适应不能为空")
  private String autoAdjustment;
  private BigDecimal thresholdRate;
  private BigDecimal lastCycleNum;
  private BigDecimal lastDayNum;

  @NotNull(message="时间不能为空")
  private String logTimestamp;

  @NotNull(message="统计天数不能为空")
  private BigDecimal totalDays;
  private String productCode;

  public ErrorLogMonitor()
  {
    this.lastCycleNum = BigDecimal.ZERO;

    this.lastDayNum = BigDecimal.ZERO;
  }

  public String getErrorCode()
  {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode)
  {
    this.errorCode = ((errorCode == null) ? null : errorCode.trim());
  }

  public BigDecimal getCycleThreshold()
  {
    return this.cycleThreshold;
  }

  public void setCycleThreshold(BigDecimal cycleThreshold)
  {
    this.cycleThreshold = cycleThreshold;
  }

  public BigDecimal getDayThreshold()
  {
    return this.dayThreshold;
  }

  public void setDayThreshold(BigDecimal dayThreshold)
  {
    this.dayThreshold = dayThreshold;
  }

  public BigDecimal getCycleNum()
  {
    return this.cycleNum;
  }

  public void setCycleNum(BigDecimal cycleNum)
  {
    this.cycleNum = cycleNum;
  }

  public BigDecimal getDayNum()
  {
    return this.dayNum;
  }

  public void setDayNum(BigDecimal dayNum)
  {
    this.dayNum = dayNum;
  }

  public BigDecimal getTotalTimes()
  {
    return this.totalTimes;
  }

  public void setTotalTimes(BigDecimal totalTimes)
  {
    this.totalTimes = totalTimes;
  }

  public String getAutoAdjustment()
  {
    return this.autoAdjustment;
  }

  public void setAutoAdjustment(String autoAdjustment)
  {
    this.autoAdjustment = ((autoAdjustment == null) ? null : autoAdjustment.trim());
  }

  public String getLogTimestamp()
  {
    return this.logTimestamp;
  }

  public void setLogTimestamp(String logTimestamp)
  {
    this.logTimestamp = ((logTimestamp == null) ? null : logTimestamp.trim());
  }

  public BigDecimal getTotalDays()
  {
    return this.totalDays;
  }

  public void setTotalDays(BigDecimal totalDays)
  {
    this.totalDays = totalDays;
  }

  public String getProductCode()
  {
    return this.productCode;
  }

  public void setProductCode(String productCode)
  {
    this.productCode = ((productCode == null) ? null : productCode.trim());
  }

  public BigDecimal getThresholdRate() {
    return this.thresholdRate;
  }

  public void setThresholdRate(BigDecimal thresholdRate) {
    this.thresholdRate = thresholdRate;
  }

  public BigDecimal getLastCycleNum() {
    return this.lastCycleNum;
  }

  public void setLastCycleNum(BigDecimal lastCycleNum) {
    this.lastCycleNum = lastCycleNum;
  }

  public BigDecimal getLastDayNum() {
    return this.lastDayNum;
  }

  public void setLastDayNum(BigDecimal lastDayNum) {
    this.lastDayNum = lastDayNum;
  }
}