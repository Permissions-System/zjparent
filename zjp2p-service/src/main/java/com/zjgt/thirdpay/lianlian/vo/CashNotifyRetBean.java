package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CashNotifyRetBean
  implements Serializable
{
  private static final long serialVersionUID = -1820506243213158235L;
  private String oid_partner;
  private String sign_type;
  private String sign;
  private String no_order;
  private String dt_order;
  private String money_order;
  private String oid_paybill;
  private String info_order;
  private String result_pay;
  private String settle_date;

  public String toString()
  {
    return new ToStringBuilder(this).append("oid_partner", this.oid_partner).append("sign_type", this.sign_type).append("sign", this.sign).append("no_order", this.no_order).append("dt_order", this.dt_order).append("money_order", this.money_order).append("oid_paybill", this.oid_paybill).append("info_order", this.info_order).append("result_pay", this.result_pay).append("settle_date", this.settle_date).toString();
  }

  public String getOid_partner()
  {
    return this.oid_partner;
  }

  public void setOid_partner(String oid_partner) {
    this.oid_partner = oid_partner;
  }

  public String getSign_type() {
    return this.sign_type;
  }

  public void setSign_type(String sign_type) {
    this.sign_type = sign_type;
  }

  public String getSign() {
    return this.sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getNo_order() {
    return this.no_order;
  }

  public void setNo_order(String no_order) {
    this.no_order = no_order;
  }

  public String getDt_order() {
    return this.dt_order;
  }

  public void setDt_order(String dt_order) {
    this.dt_order = dt_order;
  }

  public String getMoney_order() {
    return this.money_order;
  }

  public void setMoney_order(String money_order) {
    this.money_order = money_order;
  }

  public String getOid_paybill() {
    return this.oid_paybill;
  }

  public void setOid_paybill(String oid_paybill) {
    this.oid_paybill = oid_paybill;
  }

  public String getInfo_order() {
    return this.info_order;
  }

  public void setInfo_order(String info_order) {
    this.info_order = info_order;
  }

  public String getResult_pay() {
    return this.result_pay;
  }

  public void setResult_pay(String result_pay) {
    this.result_pay = result_pay;
  }

  public String getSettle_date() {
    return this.settle_date;
  }

  public void setSettle_date(String settle_date) {
    this.settle_date = settle_date;
  }
}