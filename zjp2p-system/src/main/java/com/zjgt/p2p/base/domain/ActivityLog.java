package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class ActivityLog
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String recNo;
  private String userNo;
  private String operTime;
  private String operCode;
  private String operName;
  private String operDesc;
  private String sessionId;

  public String getRecNo()
  {
    return this.recNo;
  }

  public void setRecNo(String recNo) {
    this.recNo = recNo;
  }

  public String getUserNo() {
    return this.userNo;
  }

  public void setUserNo(String userNo) {
    this.userNo = userNo;
  }

  public String getOperTime() {
    return this.operTime;
  }

  public void setOperTime(String operTime) {
    this.operTime = operTime;
  }

  public String getOperCode() {
    return this.operCode;
  }

  public void setOperCode(String operCode) {
    this.operCode = operCode;
  }

  public String getOperName() {
    return this.operName;
  }

  public void setOperName(String operName) {
    this.operName = operName;
  }

  public String getOperDesc() {
    return this.operDesc;
  }

  public void setOperDesc(String operDesc) {
    this.operDesc = operDesc;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }
}