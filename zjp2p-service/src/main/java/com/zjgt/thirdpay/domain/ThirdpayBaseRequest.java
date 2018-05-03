package com.zjgt.thirdpay.domain;

import java.io.Serializable;

public class ThirdpayBaseRequest
  implements Serializable
{
  private static final long serialVersionUID = -315275299391545624L;
  private String payerId;
  private String orderId;
  private String orderAmount;

  public String getPayerId()
  {
    return this.payerId;
  }

  public void setPayerId(String payerId) {
    this.payerId = payerId;
  }

  public String getOrderId() {
    return this.orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getOrderAmount() {
    return this.orderAmount;
  }

  public void setOrderAmount(String orderAmount) {
    this.orderAmount = orderAmount;
  }
}