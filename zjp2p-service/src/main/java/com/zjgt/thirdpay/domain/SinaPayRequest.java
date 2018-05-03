package com.zjgt.thirdpay.domain;

import org.springfk.pancloud.utils.StringUtils;

public class SinaPayRequest extends SinaBaseRequest
{
  private static final long serialVersionUID = 1L;
  private String inputCharset;
  private String pageUrl;
  private String bgUrl;
  private String language;
  private String merchantAcctId;
  private String merchantIdentityType;
  private String merchantIdentity;
  private String payerName;
  private String payerContactType;
  private String payerContact;
  private String payerIdType;
  private String payerId;
  private String orderAmount;
  private String orderTime;
  private String productName;
  private String productNum;
  private String productId;
  private String productDesc;
  private String platformId;
  private String platformSignType;
  private String platformUrl;
  private String ext1;
  private String ext2;
  private String payType;
  private String bankId;
  private String cardIssuer;
  private String cardNum;
  private String remitType;
  private String remitCode;
  private String redoFlag;
  private String submitType;
  private String platformSignMsg;
  private String ip;
  private String deviceId;
  private String sharingFlag;
  private String sharingData;

  public String getInputCharset()
  {
    return this.inputCharset;
  }

  public void setInputCharset(String inputCharset) {
    this.inputCharset = inputCharset;
  }

  public String getPageUrl() {
    return this.pageUrl;
  }

  public void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  public String getBgUrl() {
    return this.bgUrl;
  }

  public void setBgUrl(String bgUrl) {
    this.bgUrl = bgUrl;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getMerchantAcctId() {
    return this.merchantAcctId;
  }

  public void setMerchantAcctId(String merchantAcctId) {
    this.merchantAcctId = merchantAcctId;
  }

  public String getPayerName() {
    return this.payerName;
  }

  public void setPayerName(String payerName) {
    this.payerName = payerName;
  }

  public String getPayerContactType() {
    return this.payerContactType;
  }

  public void setPayerContactType(String payerContactType) {
    this.payerContactType = payerContactType;
  }

  public String getPayerContact() {
    return this.payerContact;
  }

  public void setPayerContact(String payerContact) {
    this.payerContact = payerContact;
  }

  public String getPayerIdType() {
    return this.payerIdType;
  }

  public void setPayerIdType(String payerIdType) {
    this.payerIdType = payerIdType;
  }

  public String getPayerId() {
    return this.payerId;
  }

  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }

  public String getOrderAmount() {
    return this.orderAmount;
  }

  public void setOrderAmount(String orderAmount) {
    this.orderAmount = orderAmount;
  }

  public String getOrderTime() {
    return this.orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public String getProductName() {
    return this.productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductNum() {
    return this.productNum;
  }

  public void setProductNum(String productNum) {
    this.productNum = productNum;
  }

  public String getProductId() {
    return this.productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductDesc() {
    return this.productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public String getPlatformId() {
    return this.platformId;
  }

  public void setPlatformId(String platformId) {
    this.platformId = platformId;
  }

  public String getPlatformSignType() {
    return this.platformSignType;
  }

  public void setPlatformSignType(String platformSignType) {
    this.platformSignType = platformSignType;
  }

  public String getPlatformUrl() {
    return this.platformUrl;
  }

  public void setPlatformUrl(String platformUrl) {
    this.platformUrl = platformUrl;
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

  public String getCardIssuer() {
    return this.cardIssuer;
  }

  public void setCardIssuer(String cardIssuer) {
    this.cardIssuer = cardIssuer;
  }

  public String getCardNum() {
    return this.cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public String getRemitType() {
    return this.remitType;
  }

  public void setRemitType(String remitType) {
    this.remitType = remitType;
  }

  public String getRemitCode() {
    return this.remitCode;
  }

  public void setRemitCode(String remitCode) {
    this.remitCode = remitCode;
  }

  public String getRedoFlag() {
    return this.redoFlag;
  }

  public void setRedoFlag(String redoFlag) {
    this.redoFlag = redoFlag;
  }

  public String getSubmitType() {
    return this.submitType;
  }

  public void setSubmitType(String submitType) {
    this.submitType = submitType;
  }

  public String getPlatformSignMsg() {
    return this.platformSignMsg;
  }

  public void setPlatformSignMsg(String platformSignMsg) {
    this.platformSignMsg = platformSignMsg;
  }

  public String getIp() {
    return this.ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getDeviceId() {
    return this.deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String generateSignContent()
  {
    StringBuilder builder = new StringBuilder();
    if (StringUtils.isNotEmpty(this.inputCharset)) {
      builder.append("inputCharset").append('=').append(this.inputCharset);
    }
    if (StringUtils.isNotEmpty(this.pageUrl)) {
      builder.append('&').append("pageUrl").append('=').append(this.pageUrl);
    }
    if (StringUtils.isNotEmpty(this.bgUrl)) {
      builder.append('&').append("bgUrl").append('=').append(this.bgUrl);
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
    if (StringUtils.isNotEmpty(this.merchantAcctId)) {
      builder.append('&').append("merchantAcctId").append('=').append(this.merchantAcctId);
    }
    if (StringUtils.isNotEmpty(this.merchantIdentityType)) {
      builder.append('&').append("merchantIdentityType").append('=').append(this.merchantIdentityType);
    }
    if (StringUtils.isNotEmpty(this.merchantIdentity)) {
      builder.append('&').append("merchantIdentity").append('=').append(this.merchantIdentity);
    }
    if (StringUtils.isNotEmpty(this.payerName)) {
      builder.append('&').append("payerName").append('=').append(this.payerName);
    }
    if (StringUtils.isNotEmpty(this.payerContactType)) {
      builder.append('&').append("payerContactType").append('=').append(this.payerContactType);
    }
    if (StringUtils.isNotEmpty(this.payerContact)) {
      builder.append('&').append("payerContact").append('=').append(this.payerContact);
    }
    if (StringUtils.isNotEmpty(this.payerIdType)) {
      builder.append('&').append("payerIdType").append('=').append(this.payerIdType);
    }
    if (StringUtils.isNotEmpty(this.payerId)) {
      builder.append('&').append("payerId").append('=').append(this.payerId);
    }
    if (StringUtils.isNotEmpty(this.orderId)) {
      builder.append('&').append("orderId").append('=').append(this.orderId);
    }
    if (StringUtils.isNotEmpty(this.orderAmount)) {
      builder.append('&').append("orderAmount").append('=').append(this.orderAmount);
    }
    if (StringUtils.isNotEmpty(this.orderTime)) {
      builder.append('&').append("orderTime").append('=').append(this.orderTime);
    }

    if (StringUtils.isNotEmpty(this.productName)) {
      builder.append('&').append("productName").append('=').append(this.productName);
    }

    if (StringUtils.isNotEmpty(this.productNum)) {
      builder.append('&').append("productNum").append('=').append(this.productNum);
    }

    if (StringUtils.isNotEmpty(this.productId)) {
      builder.append('&').append("productId").append('=').append(this.productId);
    }

    if (StringUtils.isNotEmpty(this.productDesc)) {
      builder.append('&').append("productDesc").append('=').append(this.productDesc);
    }

    if (StringUtils.isNotEmpty(this.platformId)) {
      builder.append('&').append("platformId").append('=').append(this.platformId);
    }

    if (StringUtils.isNotEmpty(this.platformSignType)) {
      builder.append('&').append("platformSignType").append('=').append(this.platformSignType);
    }

    if (StringUtils.isNotEmpty(this.platformUrl)) {
      builder.append('&').append("platformUrl").append('=').append(this.platformUrl);
    }

    if (StringUtils.isNotEmpty(this.ext1)) {
      builder.append('&').append("ext1").append('=').append(this.ext1);
    }
    if (StringUtils.isNotEmpty(this.ext2)) {
      builder.append('&').append("ext2").append('=').append(this.ext2);
    }
    if (StringUtils.isNotEmpty(this.payType)) {
      builder.append('&').append("payType").append('=').append(this.payType);
    }
    if (StringUtils.isNotEmpty(this.bankId)) {
      builder.append('&').append("bankId").append('=').append(this.bankId);
    }
    if (StringUtils.isNotEmpty(this.cardIssuer)) {
      builder.append('&').append("cardIssuer").append('=').append(this.cardIssuer);
    }
    if (StringUtils.isNotEmpty(this.cardNum)) {
      builder.append('&').append("cardNum").append('=').append(this.cardNum);
    }
    if (StringUtils.isNotEmpty(this.remitType)) {
      builder.append('&').append("remitType").append('=').append(this.remitType);
    }
    if (StringUtils.isNotEmpty(this.remitCode)) {
      builder.append('&').append("remitCode").append('=').append(this.remitCode);
    }
    if (StringUtils.isNotEmpty(this.redoFlag)) {
      builder.append('&').append("redoFlag").append('=').append(this.redoFlag);
    }
    if (StringUtils.isNotEmpty(this.pid)) {
      builder.append('&').append("pid").append('=').append(this.pid);
    }
    if (StringUtils.isNotEmpty(this.ip)) {
      builder.append('&').append("ip").append('=').append(this.ip);
    }
    if (StringUtils.isNotEmpty(this.deviceId)) {
      builder.append('&').append("deviceId").append('=').append(this.deviceId);
    }
    if (StringUtils.isNotEmpty(this.submitType)) {
      builder.append('&').append("submitType").append('=').append(this.submitType);
    }
    if (StringUtils.isNotEmpty(this.sharingFlag)) {
      builder.append('&').append("sharingFlag").append('=').append(this.sharingFlag);
    }
    if (StringUtils.isNotEmpty(this.sharingData)) {
      builder.append('&').append("sharingData").append('=').append(this.sharingData);
    }
    return builder.toString();
  }

  public void sign(String signMsg) {
  }

  public String getSharingFlag() {
    return this.sharingFlag;
  }

  public void setSharingFlag(String sharingFlag) {
    this.sharingFlag = sharingFlag;
  }

  public String getSharingData() {
    return this.sharingData;
  }

  public void setSharingData(String sharingData) {
    this.sharingData = sharingData;
  }

  public String getMerchantIdentity() {
    return this.merchantIdentity;
  }

  public void setMerchantIdentity(String merchantIdentity) {
    this.merchantIdentity = merchantIdentity;
  }

  public String getMerchantIdentityType() {
    return this.merchantIdentityType;
  }

  public void setMerchantIdentityType(String merchantIdentityType) {
    this.merchantIdentityType = merchantIdentityType;
  }

  public String toString()
  {
    return new StringBuilder().append("Request [inputCharset=").append(this.inputCharset).append(", pageUrl=").append(this.pageUrl).append(", bgUrl=").append(this.bgUrl).append(", version=").append(this.version).append(", language=").append(this.language).append(", signType=").append(this.signType).append(", merchantAcctId=").append(this.merchantAcctId).append(", merchantIdentityType=").append(this.merchantIdentityType).append(", merchantIdentity=").append(this.merchantIdentity).append(", payerName=").append(this.payerName).append(", payerContactType=").append(this.payerContactType).append(", payerContact=").append(this.payerContact).append(", payerIdType=").append(this.payerIdType).append(", payerId=").append(this.payerId).append(", orderId=").append(this.orderId).append(", orderAmount=").append(this.orderAmount).append(", orderTime=").append(this.orderTime).append(", productName=").append(this.productName).append(", productNum=").append(this.productNum).append(", productId=").append(this.productId).append(", productDesc=").append(this.productDesc).append(", platformId=").append(this.platformId).append(", platformSignType=").append(this.platformSignType).append(", platformUrl=").append(this.platformUrl).append(", ext1=").append(this.ext1).append(", ext2=").append(this.ext2).append(", payType=").append(this.payType).append(", bankId=").append(this.bankId).append(", cardIssuer=").append(this.cardIssuer).append(", cardNum=").append(this.cardNum).append(", remitType=").append(this.remitType).append(", remitCode=").append(this.remitCode).append(", redoFlag=").append(this.redoFlag).append(", pid=").append(this.pid).append(", submitType=").append(this.submitType).append(", signMsg=").append(this.signMsg).append(", platformSignMsg=").append(this.platformSignMsg).append(", ip=").append(this.ip).append(", deviceId=").append(this.deviceId).append(", sharingFlag=").append(this.sharingFlag).append(", sharingData=").append(this.sharingData).append("]").toString();
  }
}