package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class PaymentInfo
  implements Serializable
{
  private static final long serialVersionUID = 3889691306982576522L;
  private String version;
  private String oid_partner;
  private String user_id;
  private String sign_type;
  private String sign;
  private String busi_partner;
  private String no_order;
  private String dt_order;
  private String name_goods;
  private String info_order;
  private String money_order;
  private String notify_url;
  private String url_return;
  private String userreq_ip;
  private String url_order;
  private String valid_order;
  private String bank_code;
  private String pay_type;
  private String timestamp;
  private String risk_item;
  public String no_agree;
  private String id_type;
  private String id_no;
  private String acct_name;
  private String flag_modify;
  private String card_no;
  private String back_url;

  public String toString()
  {
    return new ToStringBuilder(this).append("version", this.version).append("oid_partner", this.oid_partner).append("user_id", this.user_id).append("sign_type", this.sign_type).append("sign", this.sign).append("busi_partner", this.busi_partner).append("no_order", this.no_order).append("dt_order", this.dt_order).append("name_goods", this.name_goods).append("info_order", this.info_order).append("money_order", this.money_order).append("notify_url", this.notify_url).append("url_return", this.url_return).append("userreq_ip", this.userreq_ip).append("url_order", this.url_order).append("valid_order", this.valid_order).append("bank_code", this.bank_code).append("pay_type", this.pay_type).append("timestamp", this.timestamp).append("risk_item", this.risk_item).append("no_agree", this.no_agree).append("id_type", this.id_type).append("id_no", this.id_no).append("acct_name", this.acct_name).append("flag_modify", this.flag_modify).append("card_no", this.card_no).append("back_url", this.back_url).toString();
  }

  public String getVersion()
  {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
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

  public String getBusi_partner() {
    return this.busi_partner;
  }

  public void setBusi_partner(String busi_partner) {
    this.busi_partner = busi_partner;
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

  public String getName_goods() {
    return this.name_goods;
  }

  public void setName_goods(String name_goods) {
    this.name_goods = name_goods;
  }

  public String getInfo_order() {
    return this.info_order;
  }

  public void setInfo_order(String info_order) {
    this.info_order = info_order;
  }

  public String getMoney_order() {
    return this.money_order;
  }

  public void setMoney_order(String money_order) {
    this.money_order = money_order;
  }

  public String getNotify_url() {
    return this.notify_url;
  }

  public void setNotify_url(String notify_url) {
    this.notify_url = notify_url;
  }

  public String getUrl_return() {
    return this.url_return;
  }

  public void setUrl_return(String url_return) {
    this.url_return = url_return;
  }

  public String getUserreq_ip() {
    return this.userreq_ip;
  }

  public void setUserreq_ip(String userreq_ip) {
    this.userreq_ip = userreq_ip;
  }

  public String getUrl_order() {
    return this.url_order;
  }

  public void setUrl_order(String url_order) {
    this.url_order = url_order;
  }

  public String getValid_order() {
    return this.valid_order;
  }

  public void setValid_order(String valid_order) {
    this.valid_order = valid_order;
  }

  public String getBank_code() {
    return this.bank_code;
  }

  public void setBank_code(String bank_code) {
    this.bank_code = bank_code;
  }

  public String getPay_type() {
    return this.pay_type;
  }

  public void setPay_type(String pay_type) {
    this.pay_type = pay_type;
  }

  public String getTimestamp() {
    return this.timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getRisk_item() {
    return this.risk_item;
  }

  public void setRisk_item(String risk_item) {
    this.risk_item = risk_item;
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

  public String getFlag_modify() {
    return this.flag_modify;
  }

  public void setFlag_modify(String flag_modify) {
    this.flag_modify = flag_modify;
  }

  public String getCard_no() {
    return this.card_no;
  }

  public void setCard_no(String card_no) {
    this.card_no = card_no;
  }

  public String getBack_url() {
    return this.back_url;
  }

  public void setBack_url(String back_url) {
    this.back_url = back_url;
  }
}