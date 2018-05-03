package com.zjgt.thirdpay.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="batchResult")
@XmlType(propOrder={"inputCharset", "version", "signType", "batchNumber", "payDate", "totalAmount", "totalQuantity", "result", "errorCode", "signMsg", "errorMessage"})
public class PayToBankSyncResult
{

  @XmlElement
  private String inputCharset;

  @XmlElement
  private String version;

  @XmlElement
  private String signType;

  @XmlElement
  private String batchNumber;

  @XmlElement
  private String payDate;

  @XmlElement
  private String totalAmount;

  @XmlElement
  private String totalQuantity;

  @XmlElement
  private String result;

  @XmlElement
  private String errorCode;

  @XmlElement
  private String signMsg;

  @XmlElement
  private String errorMessage;

  public String getInputCharset()
  {
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

  public String getResult() {
    return this.result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getSignMsg() {
    return this.signMsg;
  }

  public void setSignMsg(String signMsg) {
    this.signMsg = signMsg;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String toString()
  {
    return "Rsult [inputCharset=" + this.inputCharset + ", version=" + this.version + ", signType=" + this.signType + ", batchNumber=" + this.batchNumber + ", payDate=" + this.payDate + ", totalAmount=" + this.totalAmount + ", totalQuantity=" + this.totalQuantity + ", result=" + this.result + ", errorCode=" + this.errorCode + ", signMsg=" + this.signMsg + ", errorMessage=" + this.errorMessage + "]";
  }
}