package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class EntTask
  implements Serializable
{
  private static final long serialVersionUID = 5802531827810705974L;
  private String recheckNo;
  private String taskNo;
  private String transCode;
  private String productCode;
  private String userNo;
  private String operTitle;
  private String operDesc;
  private String createTime;
  private String detailPage;
  private String taskStatus;
  private String finalReType;
  private String finalPage;
  private String entNo;
  private String workflowNo;
  private BigDecimal recheckCount;

  public String getRecheckNo()
  {
    return this.recheckNo;
  }

  public void setRecheckNo(String recheckNo)
  {
    this.recheckNo = ((recheckNo == null) ? null : recheckNo.trim());
  }

  public String getTaskNo()
  {
    return this.taskNo;
  }

  public void setTaskNo(String taskNo)
  {
    this.taskNo = ((taskNo == null) ? null : taskNo.trim());
  }

  public String getTransCode()
  {
    return this.transCode;
  }

  public void setTransCode(String transCode)
  {
    this.transCode = ((transCode == null) ? null : transCode.trim());
  }

  public String getProductCode()
  {
    return this.productCode;
  }

  public void setProductCode(String productCode)
  {
    this.productCode = ((productCode == null) ? null : productCode.trim());
  }

  public String getUserNo()
  {
    return this.userNo;
  }

  public void setUserNo(String userNo)
  {
    this.userNo = ((userNo == null) ? null : userNo.trim());
  }

  public String getOperTitle()
  {
    return this.operTitle;
  }

  public void setOperTitle(String operTitle)
  {
    this.operTitle = ((operTitle == null) ? null : operTitle.trim());
  }

  public String getOperDesc()
  {
    return this.operDesc;
  }

  public void setOperDesc(String operDesc)
  {
    this.operDesc = ((operDesc == null) ? null : operDesc.trim());
  }

  public String getCreateTime()
  {
    return this.createTime;
  }

  public void setCreateTime(String createTime)
  {
    this.createTime = ((createTime == null) ? null : createTime.trim());
  }

  public String getDetailPage()
  {
    return this.detailPage;
  }

  public void setDetailPage(String detailPage)
  {
    this.detailPage = ((detailPage == null) ? null : detailPage.trim());
  }

  public String getTaskStatus()
  {
    return this.taskStatus;
  }

  public void setTaskStatus(String taskStatus)
  {
    this.taskStatus = ((taskStatus == null) ? null : taskStatus.trim());
  }

  public String getFinalReType()
  {
    return this.finalReType;
  }

  public void setFinalReType(String finalReType)
  {
    this.finalReType = ((finalReType == null) ? null : finalReType.trim());
  }

  public String getFinalPage()
  {
    return this.finalPage;
  }

  public void setFinalPage(String finalPage)
  {
    this.finalPage = ((finalPage == null) ? null : finalPage.trim());
  }

  public String getEntNo()
  {
    return this.entNo;
  }

  public void setEntNo(String entNo)
  {
    this.entNo = ((entNo == null) ? null : entNo.trim());
  }

  public String getWorkflowNo()
  {
    return this.workflowNo;
  }

  public void setWorkflowNo(String workflowNo)
  {
    this.workflowNo = ((workflowNo == null) ? null : workflowNo.trim());
  }

  public BigDecimal getRecheckCount()
  {
    return this.recheckCount;
  }

  public void setRecheckCount(BigDecimal recheckCount)
  {
    this.recheckCount = recheckCount;
  }
}