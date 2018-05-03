package com.zjgt.thirdpay.domain;

public abstract class SinaBaseRequest extends ThirdpayBaseRequest
{
  private static final long serialVersionUID = 1L;
  protected String pid;
  protected String version;
  protected String orderId;
  protected String signType;
  protected String signMsg;

  public abstract String generateSignContent();

  public String md5KeyProperty()
  {
    return "key";
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

  public String getSignMsg() {
    return this.signMsg;
  }

  public void setSignMsg(String signMsg) {
    this.signMsg = signMsg;
  }

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }
}