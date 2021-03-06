package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class OrderQueryResponse
  implements Serializable
{
  private static final long serialVersionUID = -4182566399066461554L;
  private String ret_code;
  private String ret_msg;
  private String sign_type;
  private String sign;
  private String result_pay;
  private String oid_partner;
  private String dt_order;
  private String no_order;
  private String oid_paybill;
  private String money_order;
  private String settle_date;
  private String info_order;
  private String pay_type;
  private String bank_code;
  private String bank_name;
  private String memo;

  public String toString()
  {
    return new ToStringBuilder(this).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).append("sign_type", this.sign_type).append("sign", this.sign).append("result_pay", this.result_pay).append("oid_partner", this.oid_partner).append("dt_order", this.dt_order).append("no_order", this.no_order).append("oid_paybill", this.oid_paybill).append("money_order", this.money_order).append("settle_date", this.settle_date).append("info_order", this.info_order).append("pay_type", this.pay_type).append("bank_code", this.bank_code).append("bank_name", this.bank_name).append("memo", this.memo).toString();
  }

  public String getRet_code()
  {
    return this.ret_code;
  }

  public void setRet_code(String ret_code) {
    this.ret_code = ret_code;
  }

  public String getRet_msg() {
    return this.ret_msg;
  }

  public void setRet_msg(String ret_msg) {
    this.ret_msg = ret_msg;
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

  public String getResult_pay() {
    return this.result_pay;
  }

  public void setResult_pay(String result_pay) {
    this.result_pay = result_pay;
  }

  public String getOid_partner() {
    return this.oid_partner;
  }

  public void setOid_partner(String oid_partner) {
    this.oid_partner = oid_partner;
  }

  public String getDt_order() {
    return this.dt_order;
  }

  public void setDt_order(String dt_order) {
    this.dt_order = dt_order;
  }

  public String getNo_order() {
    return this.no_order;
  }

  public void setNo_order(String no_order) {
    this.no_order = no_order;
  }

  public String getOid_paybill() {
    return this.oid_paybill;
  }

  public void setOid_paybill(String oid_paybill) {
    this.oid_paybill = oid_paybill;
  }

  public String getMoney_order() {
    return this.money_order;
  }

  public void setMoney_order(String money_order) {
    this.money_order = money_order;
  }

  public String getSettle_date() {
    return this.settle_date;
  }

  public void setSettle_date(String settle_date) {
    this.settle_date = settle_date;
  }

  public String getInfo_order() {
    return this.info_order;
  }

  public void setInfo_order(String info_order) {
    this.info_order = info_order;
  }

  public String getPay_type() {
    return this.pay_type;
  }

  public void setPay_type(String pay_type) {
    this.pay_type = pay_type;
  }

  public String getBank_code() {
    return this.bank_code;
  }

  public void setBank_code(String bank_code) {
    this.bank_code = bank_code;
  }

  public String getBank_name() {
    return this.bank_name;
  }

  public void setBank_name(String bank_name) {
    this.bank_name = bank_name;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }
}