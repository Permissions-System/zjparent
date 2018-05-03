package com.zjgt.thirdpay.lianlian.vo.wap;

import com.zjgt.thirdpay.lianlian.vo.PaymentNotifyRetBean;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class WapPaymentNotifyRetBean extends PaymentNotifyRetBean
  implements Serializable
{
  private static final long serialVersionUID = -4135530116501475188L;
  private String oid_partner;
  private String sign_type;
  private String sign;
  private String dt_order;
  private String no_order;
  private String oid_paybill;
  private String money_order;
  private String result_pay;
  private String settle_date;
  private String info_order;
  private String pay_type;
  private String bank_code;
  private String no_agree;
  private String id_type;
  private String id_no;
  private String acct_name;
  private String card_no;

  public String toString()
  {
    return new ToStringBuilder(this).append("oid_partner", this.oid_partner).append("sign_type", this.sign_type).append("sign", this.sign).append("dt_order", this.dt_order).append("no_order", this.no_order).append("oid_paybill", this.oid_paybill).append("money_order", this.money_order).append("result_pay", this.result_pay).append("settle_date", this.settle_date).append("info_order", this.info_order).append("pay_type", this.pay_type).append("bank_code", this.bank_code).append("no_agree", this.no_agree).append("id_type", this.id_type).append("id_no", this.id_no).append("acct_name", this.acct_name).append("card_no", this.card_no).toString();
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

  public String getNo_agree() {
    return this.no_agree;
  }

  public void setNo_agree(String no_agree) {
    this.no_agree = no_agree;
  }

  public String getId_type() {
    return this.id_type;
  }

  public void setId_type(String id_type) {
    this.id_type = id_type;
  }

  public String getId_no() {
    return this.id_no;
  }

  public void setId_no(String id_no) {
    this.id_no = id_no;
  }

  public String getAcct_name() {
    return this.acct_name;
  }

  public void setAcct_name(String acct_name) {
    this.acct_name = acct_name;
  }

  public String getCard_no() {
    return this.card_no;
  }

  public void setCard_no(String card_no) {
    this.card_no = card_no;
  }
}