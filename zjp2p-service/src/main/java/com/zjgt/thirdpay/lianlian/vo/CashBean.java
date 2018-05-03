package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CashBean
  implements Serializable
{
  private static final long serialVersionUID = 5836906272938274366L;
  private String no_order;
  private String dt_order;
  private String money_order;
  private String flag_card;
  private String card_no;
  private String acct_name;
  private String bank_code;
  private String province_code;
  private String city_code;
  private String brabank_name;
  private String info_order;
  private String notify_url;
  private String prcptcd;
  private String api_version;
  private String platform;
  private String sign_type;
  private String sign;
  private String oid_partner;
  private String user_id;
  private String ret_code;
  private String ret_msg;

  public String toString()
  {
    return new ToStringBuilder(this).append("no_order", this.no_order).append("dt_order", this.dt_order).append("money_order", this.money_order).append("flag_card", this.flag_card).append("card_no", this.card_no).append("acct_name", this.acct_name).append("bank_code", this.bank_code).append("province_code", this.province_code).append("city_code", this.city_code).append("brabank_name", this.brabank_name).append("info_order", this.info_order).append("notify_url", this.notify_url).append("prcptcd", this.prcptcd).append("api_version", this.api_version).append("platform", this.platform).append("sign_type", this.sign_type).append("sign", this.sign).append("oid_partner", this.oid_partner).append("user_id", this.user_id).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).toString();
  }

  public String getNo_order()
  {
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

  public String getFlag_card() {
    return this.flag_card;
  }

  public void setFlag_card(String flag_card) {
    this.flag_card = flag_card;
  }

  public String getCard_no() {
    return this.card_no;
  }

  public void setCard_no(String card_no) {
    this.card_no = card_no;
  }

  public String getAcct_name() {
    return this.acct_name;
  }

  public void setAcct_name(String acct_name) {
    this.acct_name = acct_name;
  }

  public String getBank_code() {
    return this.bank_code;
  }

  public void setBank_code(String bank_code) {
    this.bank_code = bank_code;
  }

  public String getProvince_code() {
    return this.province_code;
  }

  public void setProvince_code(String province_code) {
    this.province_code = province_code;
  }

  public String getCity_code() {
    return this.city_code;
  }

  public void setCity_code(String city_code) {
    this.city_code = city_code;
  }

  public String getBrabank_name() {
    return this.brabank_name;
  }

  public void setBrabank_name(String brabank_name) {
    this.brabank_name = brabank_name;
  }

  public String getInfo_order() {
    return this.info_order;
  }

  public void setInfo_order(String info_order) {
    this.info_order = info_order;
  }

  public String getNotify_url() {
    return this.notify_url;
  }

  public void setNotify_url(String notify_url) {
    this.notify_url = notify_url;
  }

  public String getPrcptcd() {
    return this.prcptcd;
  }

  public void setPrcptcd(String prcptcd) {
    this.prcptcd = prcptcd;
  }

  public String getApi_version() {
    return this.api_version;
  }

  public void setApi_version(String api_version) {
    this.api_version = api_version;
  }

  public String getPlatform() {
    return this.platform;
  }

  public void setPlatform(String platform) {
    this.platform = platform;
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

  public String getOid_partner() {
    return this.oid_partner;
  }

  public void setOid_partner(String oid_partner) {
    this.oid_partner = oid_partner;
  }

  public String getUser_id() {
    return this.user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getRet_code() {
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
}