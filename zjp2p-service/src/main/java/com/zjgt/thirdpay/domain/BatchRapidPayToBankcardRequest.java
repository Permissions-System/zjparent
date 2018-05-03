package com.zjgt.thirdpay.domain;

import org.springfk.pancloud.utils.StringUtils;

public class BatchRapidPayToBankcardRequest
{
  private String inputCharset;
  private String version;
  private String bgUrl;
  private String signType;
  private String batchNumber;
  private String payDate;
  private String totalAmount;
  private String totalQuantity;
  private String detailData;
  private String pid;
  private String extendData;
  private String signMsg;

  public String md5KeyProperty()
  {
    return "key";
  }

  public String generateSignContent()
  {
    StringBuilder builder = new StringBuilder();
    if (this.inputCharset != null) {
      builder.append("inputCharset").append('=').append(this.inputCharset);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.append('&').append("version").append('=').append(this.version);
    }
    if (StringUtils.isNotEmpty(this.bgUrl)) {
      builder.append('&').append("bgUrl").append('=').append(this.bgUrl);
    }
    if (StringUtils.isNotEmpty(this.signType)) {
      builder.append('&').append("signType").append('=').append(this.signType);
    }
    if (StringUtils.isNotEmpty(this.batchNumber)) {
      builder.append('&').append("batchNumber").append('=').append(this.batchNumber);
    }
    if (StringUtils.isNotEmpty(this.payDate)) {
      builder.append('&').append("payDate").append('=').append(this.payDate);
    }
    if (StringUtils.isNotEmpty(this.totalAmount)) {
      builder.append('&').append("totalAmount").append('=').append(this.totalAmount);
    }
    if (StringUtils.isNotEmpty(this.totalQuantity)) {
      builder.append('&').append("totalQuantity").append('=').append(this.totalQuantity);
    }
    if (StringUtils.isNotEmpty(this.detailData)) {
      builder.append('&').append("detailData").append('=').append(this.detailData);
    }
    if (StringUtils.isNotEmpty(this.pid)) {
      builder.append('&').append("pid").append('=').append(this.pid);
    }
    if (StringUtils.isNotEmpty(this.extendData)) {
      builder.append('&').append("extendData").append('=').append(this.extendData);
    }
    return builder.toString();
  }

  public String getInputCharset() {
    return this.inputCharset;
  }

  public void setInputCharset(String inputCharset) {
    this.inputCharset = inputCharset;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getBgUrl() {
    return this.bgUrl;
  }

  public void setBgUrl(String bgUrl) {
    this.bgUrl = bgUrl;
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

  public String getPayDate() {
    return this.payDate;
  }

  public void setPayDate(String payDate) {
    this.payDate = payDate;
  }

  public String getTotalAmount() {
    return this.totalAmount;
  }

  public void setTotalAmount(String totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getTotalQuantity() {
    return this.totalQuantity;
  }

  public void setTotalQuantity(String totalQuantity) {
    this.totalQuantity = totalQuantity;
  }

  public String getDetailData() {
    return this.detailData;
  }

  public void setDetailData(String detailData) {
    this.detailData = detailData;
  }

  public String getPid() {
    return this.pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public String getExtendData() {
    return this.extendData;
  }

  public void setExtendData(String extendData) {
    this.extendData = extendData;
  }

  public String getSignMsg() {
    return this.signMsg;
  }

  public void setSignMsg(String signMsg) {
    this.signMsg = signMsg;
  }

  public String toString()
  {
    return new StringBuilder().append("Request [inputCharset=").append(this.inputCharset).append(", version=").append(this.version).append(", bgUrl=").append(this.bgUrl).append(", signType=").append(this.signType).append(", batchNumber=").append(this.batchNumber).append(", payDate=").append(this.payDate).append(", totalAmount=").append(this.totalAmount).append(", totalQuantity=").append(this.totalQuantity).append(", detailData=").append(this.detailData).append(", pid=").append(this.pid).append(", extendData=").append(this.extendData).append(", signMsg=").append(this.signMsg).append("]").toString();
  }
}