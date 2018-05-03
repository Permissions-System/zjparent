package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.util.Date;

public class BasicRecordProperty
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String username;
  private String fkUserId;
  private Date startDate;
  private Date endDate;
  private String operatingTarget;

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getFkUserId()
  {
    return this.fkUserId;
  }

  public void setFkUserId(String fkUserId)
  {
    this.fkUserId = fkUserId;
  }

  public Date getStartDate()
  {
    return this.startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public Date getEndDate()
  {
    return this.endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  public String getOperatingTarget()
  {
    return this.operatingTarget;
  }

  public void setOperatingTarget(String operatingTarget)
  {
    this.operatingTarget = operatingTarget;
  }
}