package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ErrStatictsInfo
  implements Serializable
{
  private static final long serialVersionUID = -6210661811343030580L;
  private String errorCode;
  private BigDecimal errorCount;
  private String statictDate;
  private String startDate;
  private String endDate;

  public String getErrorCode()
  {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode)
  {
    this.errorCode = ((errorCode == null) ? null : errorCode.trim());
  }

  public BigDecimal getErrorCount()
  {
    return this.errorCount;
  }

  public void setErrorCount(BigDecimal errorCount)
  {
    this.errorCount = errorCount;
  }

  public String getStatictDate()
  {
    return this.statictDate;
  }

  public void setStatictDate(String statictDate)
  {
    this.statictDate = ((statictDate == null) ? null : statictDate.trim());
  }

  public String getStartDate()
  {
    return this.startDate;
  }

  public void setStartDate(String startDate)
  {
    this.startDate = ((startDate == null) ? null : startDate.trim());
  }

  public String getEndDate()
  {
    return this.endDate;
  }

  public void setEndDate(String endDate)
  {
    this.endDate = ((endDate == null) ? null : endDate.trim());
  }
}