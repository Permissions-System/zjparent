package com.zjgt.thirdpay.domain;

import org.springfk.pancloud.utils.StringUtils;

public class BatchRapidPayToBankcardResponse
{
  private String pid;
  private String version;
  private String signType;
  private String batchNumber;
  private String serviceType;
  private String dealId;
  private String payDate;
  private String originalTotalAmount;
  private String originalTotalQuantity;
  private String successTotalAmount;
  private String successTotalQuantity;
  private String totalFee;
  private String batchSuccessDetail;
  private String batchFailureDetail;
  private String batchFeeDetail;
  private String notifyTime;
  private String signMsg;

  public String generateSignContent()
  {
    StringBuilder builder = new StringBuilder();
    if (this.pid != null) {
      builder.append("pid").append('=').append(this.pid);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.append('&').append("version").append('=').append(this.version);
    }
    if (StringUtils.isNotEmpty(this.signType)) {
      builder.append('&').append("signType").append('=').append(this.signType);
    }
    if (StringUtils.isNotEmpty(this.batchNumber)) {
      builder.append('&').append("batchNumber").append('=').append(this.batchNumber);
    }
    if (StringUtils.isNotEmpty(this.serviceType)) {
      builder.append('&').append("serviceType").append('=').append(this.serviceType);
    }
    if (StringUtils.isNotEmpty(this.dealId)) {
      builder.append('&').append("dealId").append('=').append(this.dealId);
    }
    if (StringUtils.isNotEmpty(this.payDate)) {
      builder.append('&').append("payDate").append('=').append(this.payDate);
    }
    if (StringUtils.isNotEmpty(this.originalTotalAmount)) {
      builder.append('&').append("originalTotalAmount").append('=').append(this.originalTotalAmount);
    }
    if (StringUtils.isNotEmpty(this.originalTotalQuantity)) {
      builder.append('&').append("originalTotalQuantity").append('=').append(this.originalTotalQuantity);
    }
    if (StringUtils.isNotEmpty(this.successTotalAmount)) {
      builder.append('&').append("successTotalAmount").append('=').append(this.successTotalAmount);
    }
    if (StringUtils.isNotEmpty(this.successTotalQuantity)) {
      builder.append('&').append("successTotalQuantity").append('=').append(this.successTotalQuantity);
    }
    if (StringUtils.isNotEmpty(this.totalFee)) {
      builder.append('&').append("totalFee").append('=').append(this.totalFee);
    }
    if (StringUtils.isNotEmpty(this.batchSuccessDetail)) {
      builder.append('&').append("batchSuccessDetail").append('=').append(this.batchSuccessDetail);
    }
    if (StringUtils.isNotEmpty(this.batchFailureDetail)) {
      builder.append('&').append("batchFailureDetail").append('=').append(this.batchFailureDetail);
    }
    if (StringUtils.isNotEmpty(this.batchFeeDetail)) {
      builder.append('&').append("batchFeeDetail").append('=').append(this.batchFeeDetail);
    }
    if (StringUtils.isNotEmpty(this.notifyTime)) {
      builder.append('&').append("notifyTime").append('=').append(this.notifyTime);
    }
    return builder.toString();
  }

  public String getPid() {
    return this.pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getSignType() {
    return this.signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getBatchNumber() {
    return this.batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }

  public String getServiceType() {
    return this.serviceType;
  }

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public String getDealId() {
    return this.dealId;
  }

  public void setDealId(String dealId) {
    this.dealId = dealId;
  }

  public String getPayDate() {
    return this.payDate;
  }

  public void setPayDate(String payDate) {
    this.payDate = payDate;
  }

  public String getOriginalTotalAmount() {
    return this.originalTotalAmount;
  }

  public void setOriginalTotalAmount(String originalTotalAmount) {
    this.originalTotalAmount = originalTotalAmount;
  }

  public String getOriginalTotalQuantity() {
    return this.originalTotalQuantity;
  }

  public void setOriginalTotalQuantity(String originalTotalQuantity) {
    this.originalTotalQuantity = originalTotalQuantity;
  }

  public String getSuccessTotalAmount() {
    return this.successTotalAmount;
  }

  public void setSuccessTotalAmount(String successTotalAmount) {
    this.successTotalAmount = successTotalAmount;
  }

  public String getSuccessTotalQuantity() {
    return this.successTotalQuantity;
  }

  public void setSuccessTotalQuantity(String successTotalQuantity) {
    this.successTotalQuantity = successTotalQuantity;
  }

  public String getTotalFee() {
    return this.totalFee;
  }

  public void setTotalFee(String totalFee) {
    this.totalFee = totalFee;
  }

  public String getBatchSuccessDetail() {
    return this.batchSuccessDetail;
  }

  public void setBatchSuccessDetail(String batchSuccessDetail) {
    this.batchSuccessDetail = batchSuccessDetail;
  }

  public String getBatchFailureDetail() {
    return this.batchFailureDetail;
  }

  public void setBatchFailureDetail(String batchFailureDetail) {
    this.batchFailureDetail = batchFailureDetail;
  }

  public String getBatchFeeDetail() {
    return this.batchFeeDetail;
  }

  public void setBatchFeeDetail(String batchFeeDetail) {
    this.batchFeeDetail = batchFeeDetail;
  }

  public String getNotifyTime() {
    return this.notifyTime;
  }

  public void setNotifyTime(String notifyTime) {
    this.notifyTime = notifyTime;
  }

  public String getSignMsg() {
    return this.signMsg;
  }

  public void setSignMsg(String signMsg) {
    this.signMsg = signMsg;
  }

  public String toString()
  {
    return new StringBuilder().append("Response [pid=").append(this.pid).append(", version=").append(this.version).append(", signType=").append(this.signType).append(", batchNumber=").append(this.batchNumber).append(", serviceType=").append(this.serviceType).append(", dealId=").append(this.dealId).append(", payDate=").append(this.payDate).append(", originalTotalAmount=").append(this.originalTotalAmount).append(", originalTotalQuantity=").append(this.originalTotalQuantity).append(", successTotalAmount=").append(this.successTotalAmount).append(", successTotalQuantity=").append(this.successTotalQuantity).append(", totalFee=").append(this.totalFee).append(", batchSuccessDetail=").append(this.batchSuccessDetail).append(", batchFailureDetail=").append(this.batchFailureDetail).append(", batchFeeDetail=").append(this.batchFeeDetail).append(", notifyTime=").append(this.notifyTime).append(", signMsg=").append(this.signMsg).append("]").toString();
  }
}