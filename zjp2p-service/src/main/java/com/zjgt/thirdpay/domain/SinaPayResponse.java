package com.zjgt.thirdpay.domain;

import org.springfk.pancloud.utils.StringUtils;

public class SinaPayResponse
{
  private String merchantAcctId;
  private String version;
  private String language;
  private String signType;
  private String payType;
  private String bankId;
  private String orderId;
  private String orderTime;
  private String orderAmount;
  private String dealId;
  private String bankDealId;
  private String dealTime;
  private String payAmount;
  private String fee;
  private String ext1;
  private String ext2;
  private String payResult;
  private String payIp;
  private String errCode;
  private String signMsg;

  public String generateSignContent()
  {
    StringBuilder builder = new StringBuilder();
    if (StringUtils.isNotEmpty(this.merchantAcctId)) {
      builder.append("merchantAcctId").append('=').append(this.merchantAcctId);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.append('&').append("version").append('=').append(this.version);
    }
    if (StringUtils.isNotEmpty(this.language)) {
      builder.append('&').append("language").append('=').append(this.language);
    }
    if (StringUtils.isNotEmpty(this.signType)) {
      builder.append('&').append("signType").append('=').append(this.signType);
    }
    if (StringUtils.isNotEmpty(this.payType)) {
      builder.append('&').append("payType").append('=').append(this.payType);
    }
    if (StringUtils.isNotEmpty(this.bankId)) {
      builder.append('&').append("bankId").append('=').append(this.bankId);
    }
    if (StringUtils.isNotEmpty(this.orderId)) {
      builder.append('&').append("orderId").append('=').append(this.orderId);
    }
    if (StringUtils.isNotEmpty(this.orderTime)) {
      builder.append('&').append("orderTime").append('=').append(this.orderTime);
    }
    if (StringUtils.isNotEmpty(this.orderAmount)) {
      builder.append('&').append("orderAmount").append('=').append(this.orderAmount);
    }
    if (StringUtils.isNotEmpty(this.dealId)) {
      builder.append('&').append("dealId").append('=').append(this.dealId);
    }
    if (StringUtils.isNotEmpty(this.bankDealId)) {
      builder.append('&').append("bankDealId").append('=').append(this.bankDealId);
    }
    if (StringUtils.isNotEmpty(this.dealTime)) {
      builder.append('&').append("dealTime").append('=').append(this.dealTime);
    }
    if (StringUtils.isNotEmpty(this.payAmount)) {
      builder.append('&').append("payAmount").append('=').append(this.payAmount);
    }
    if (StringUtils.isNotEmpty(this.fee)) {
      builder.append('&').append("fee").append('=').append(this.fee);
    }
    if (StringUtils.isNotEmpty(this.ext1)) {
      builder.append('&').append("ext1").append('=').append(this.ext1);
    }
    if (StringUtils.isNotEmpty(this.ext2)) {
      builder.append('&').append("ext2").append('=').append(this.ext2);
    }
    if (StringUtils.isNotEmpty(this.payResult)) {
      builder.append('&').append("payResult").append('=').append(this.payResult);
    }
    if (StringUtils.isNotEmpty(this.payIp)) {
      builder.append('&').append("payIp").append('=').append(this.payIp);
    }
    if (StringUtils.isNotEmpty(this.errCode)) {
      builder.append('&').append("errCode").append('=').append(this.errCode);
    }
    return builder.toString();
  }

  public String getMerchantAcctId() {
    return this.merchantAcctId;
  }

  public void setMerchantAcctId(String merchantAcctId) {
    this.merchantAcctId = merchantAcctId;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getSignType() {
    return this.signType;
  }

  public void setSignType(String signType) {
    this.signType = signType;
  }

  public String getPayType() {
    return this.payType;
  }

  public void setPayType(String payType) {
    this.payType = payType;
  }

  public String getBankId() {
    return this.bankId;
  }

  public void setBankId(String bankId) {
    this.bankId = bankId;
  }

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderTime() {
    return this.orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public String getOrderAmount() {
    return this.orderAmount;
  }

  public void setOrderAmount(String orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getDealId() {
    return this.dealId;
  }

  public void setDealId(String dealId) {
    this.dealId = dealId;
  }

  public String getBankDealId() {
    return this.bankDealId;
  }

  public void setBankDealId(String bankDealId) {
    this.bankDealId = bankDealId;
  }

  public String getDealTime() {
    return this.dealTime;
  }

  public void setDealTime(String dealTime) {
    this.dealTime = dealTime;
  }

  public String getPayAmount() {
    return this.payAmount;
  }

  public void setPayAmount(String payAmount) {
    this.payAmount = payAmount;
  }

  public String getFee() {
    return this.fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }

  public String getExt1() {
    return this.ext1;
  }

  public void setExt1(String ext1) {
    this.ext1 = ext1;
  }

  public String getExt2() {
    return this.ext2;
  }

  public void setExt2(String ext2) {
    this.ext2 = ext2;
  }

  public String getPayResult() {
    return this.payResult;
  }

  public void setPayResult(String payResult) {
    this.payResult = payResult;
  }

  public String getPayIp() {
    return this.payIp;
  }

  public void setPayIp(String payIp) {
    this.payIp = payIp;
  }

  public String getErrCode() {
    return this.errCode;
  }

  public void setErrCode(String errCode) {
    this.errCode = errCode;
  }

  public String getSignMsg() {
    return this.signMsg;
  }

  public void setSignMsg(String signMsg) {
    this.signMsg = signMsg;
  }

  public String toString()
  {
    return new StringBuilder().append("Response [merchantAcctId=").append(this.merchantAcctId).append(", version=").append(this.version).append(", language=").append(this.language).append(", signType=").append(this.signType).append(", payType=").append(this.payType).append(", bankId=").append(this.bankId).append(", orderId=").append(this.orderId).append(", orderTime=").append(this.orderTime).append(", orderAmount=").append(this.orderAmount).append(", dealId=").append(this.dealId).append(", bankDealId=").append(this.bankDealId).append(", dealTime=").append(this.dealTime).append(", payAmount=").append(this.payAmount).append(", fee=").append(this.fee).append(", ext1=").append(this.ext1).append(", ext2=").append(this.ext2).append(", payResult=").append(this.payResult).append(", payIp=").append(this.payIp).append(", errCode=").append(this.errCode).append(", signMsg=").append(this.signMsg).append("]").toString();
  }
}