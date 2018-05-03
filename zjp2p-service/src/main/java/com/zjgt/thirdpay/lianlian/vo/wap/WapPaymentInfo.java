package com.zjgt.thirdpay.lianlian.vo.wap;

import com.zjgt.thirdpay.lianlian.vo.PaymentInfo;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class WapPaymentInfo extends PaymentInfo
  implements Serializable
{
  private static final long serialVersionUID = 21706060291260786L;
  private String version;
  private String oid_partner;
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
  private String app_request;
  private String valid_order;
  private String user_id;
  private String risk_item;
  private String card_no;
  private String no_agree;
  private String acct_name;
  private String id_no;
  private String pay_type;
  private String bank_code;
  private String cardno;
  private String bind_mob;
  private String validate;
  private String cvv2;
  private String idno;
  private String agreeno;
  private String custname;
  private String isrecord;
  private String bank_name;
  private String oid_paybill;
  private String name_trader;
  private String rsa_public;
  private String rsa_private;
  private String key_md5;
  private String flag_bankshow;
  public String user_login;
  public String oid_userno;
  public String result_pay;
  public String settle_date;
  private String trade_state;
  private String ret_code;
  private String ret_msg;
  private String lasttime_sendmsg;
  private String lastmobile_sendmsg;
  private String smscode_locked;
  private String ip_request;
  private String pay_key;
  private String correlationID;
  private String support_bank_map;
  private String historycard;
  private String pay_mode;
  private String shareing_data;
  private String support_mode_list;
  private String support_ebank_map;
  private String support_bankcard_map;
  private String support_bankcard_json;
  private String sms_template;
  private String type_card;
  private String errorCode;
  private String errorMessage;
  private String flag_modify;
  private String flag_sms_verify;
  private String local_network;
  private String local_disk;
  private String local_nic;
  private String hidden_realname;
  private String hidden_idcard;
  private String hidden_mobile;
  private String signElementsFlag;
  private String pre_card_mode;
  private String bg_color;

  public String toString()
  {
    return new ToStringBuilder(this).append("version", this.version).append("oid_partner", this.oid_partner).append("sign_type", this.sign_type).append("sign", this.sign).append("busi_partner", this.busi_partner).append("no_order", this.no_order).append("dt_order", this.dt_order).append("name_goods", this.name_goods).append("info_order", this.info_order).append("money_order", this.money_order).append("notify_url", this.notify_url).append("url_return", this.url_return).append("app_request", this.app_request).append("valid_order", this.valid_order).append("user_id", this.user_id).append("risk_item", this.risk_item).append("card_no", this.card_no).append("no_agree", this.no_agree).append("acct_name", this.acct_name).append("id_no", this.id_no).append("pay_type", this.pay_type).append("bank_code", this.bank_code).append("cardno", this.cardno).append("bind_mob", this.bind_mob).append("validate", this.validate).append("cvv2", this.cvv2).append("idno", this.idno).append("agreeno", this.agreeno).append("custname", this.custname).append("isrecord", this.isrecord).append("bank_name", this.bank_name).append("oid_paybill", this.oid_paybill).append("name_trader", this.name_trader).append("rsa_public", this.rsa_public).append("rsa_private", this.rsa_private).append("key_md5", this.key_md5).append("flag_bankshow", this.flag_bankshow).append("user_login", this.user_login).append("oid_userno", this.oid_userno).append("result_pay", this.result_pay).append("settle_date", this.settle_date).append("trade_state", this.trade_state).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).append("lasttime_sendmsg", this.lasttime_sendmsg).append("lastmobile_sendmsg", this.lastmobile_sendmsg).append("smscode_locked", this.smscode_locked).append("ip_request", this.ip_request).append("pay_key", this.pay_key).append("correlationID", this.correlationID).append("support_bank_map", this.support_bank_map).append("historycard", this.historycard).append("pay_mode", this.pay_mode).append("shareing_data", this.shareing_data).append("support_mode_list", this.support_mode_list).append("support_ebank_map", this.support_ebank_map).append("support_bankcard_map", this.support_bankcard_map).append("support_bankcard_json", this.support_bankcard_json).append("sms_template", this.sms_template).append("type_card", this.type_card).append("errorCode", this.errorCode).append("errorMessage", this.errorMessage).append("flag_modify", this.flag_modify).append("flag_sms_verify", this.flag_sms_verify).append("local_network", this.local_network).append("local_disk", this.local_disk).append("local_nic", this.local_nic).append("hidden_realname", this.hidden_realname).append("hidden_idcard", this.hidden_idcard).append("hidden_mobile", this.hidden_mobile).append("signElementsFlag", this.signElementsFlag).append("pre_card_mode", this.pre_card_mode).append("bg_color", this.bg_color).toString();
  }

  public String getFlag_sms_verify()
  {
    return this.flag_sms_verify;
  }

  public void setFlag_sms_verify(String flag_sms_verify) {
    this.flag_sms_verify = flag_sms_verify;
  }

  public String getLasttime_sendmsg() {
    return this.lasttime_sendmsg;
  }

  public void setLasttime_sendmsg(String lasttime_sendmsg) {
    this.lasttime_sendmsg = lasttime_sendmsg;
  }

  public String getTrade_state() {
    return this.trade_state;
  }

  public void setTrade_state(String trade_state) {
    this.trade_state = trade_state;
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

  public String getName_trader() {
    return this.name_trader;
  }

  public void setName_trader(String name_trader) {
    this.name_trader = name_trader;
  }

  public String getRsa_public() {
    return this.rsa_public;
  }

  public void setRsa_public(String rsa_public) {
    this.rsa_public = rsa_public;
  }

  public String getRsa_private() {
    return this.rsa_private;
  }

  public void setRsa_private(String rsa_private) {
    this.rsa_private = rsa_private;
  }

  public String getKey_md5() {
    return this.key_md5;
  }

  public void setKey_md5(String key_md5) {
    this.key_md5 = key_md5;
  }

  public String getUser_login() {
    return this.user_login;
  }

  public void setUser_login(String user_login) {
    this.user_login = user_login;
  }

  public String getOid_userno() {
    return this.oid_userno;
  }

  public void setOid_userno(String oid_userno) {
    this.oid_userno = oid_userno;
  }

  public String getCardno() {
    return this.cardno;
  }

  public void setCardno(String cardno) {
    this.cardno = cardno;
  }

  public String getBind_mob() {
    return this.bind_mob;
  }

  public void setBind_mob(String bind_mob) {
    this.bind_mob = bind_mob;
  }

  public String getValidate() {
    return this.validate;
  }

  public void setValidate(String validate) {
    this.validate = validate;
  }

  public String getCvv2() {
    return this.cvv2;
  }

  public void setCvv2(String cvv2) {
    this.cvv2 = cvv2;
  }

  public String getIdno() {
    return this.idno;
  }

  public void setIdno(String idno) {
    this.idno = idno;
  }

  public String getOid_paybill() {
    return this.oid_paybill;
  }

  public void setOid_paybill(String oid_paybill) {
    this.oid_paybill = oid_paybill;
  }

  public String getOid_partner() {
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

  public String getApp_request() {
    return this.app_request;
  }

  public void setApp_request(String app_request) {
    this.app_request = app_request;
  }

  public String getValid_order() {
    return this.valid_order;
  }

  public void setValid_order(String valid_order) {
    this.valid_order = valid_order;
  }

  public String getLastmobile_sendmsg() {
    return this.lastmobile_sendmsg;
  }

  public void setLastmobile_sendmsg(String lastmobile_sendmsg) {
    this.lastmobile_sendmsg = lastmobile_sendmsg;
  }

  public String getUser_id() {
    return this.user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getRisk_item() {
    return this.risk_item;
  }

  public void setRisk_item(String risk_item) {
    this.risk_item = risk_item;
  }

  public String getIp_request() {
    return this.ip_request;
  }

  public void setIp_request(String ip_request) {
    this.ip_request = ip_request;
  }

  public String getPay_key() {
    return this.pay_key;
  }

  public void setPay_key(String pay_key) {
    this.pay_key = pay_key;
  }

  public String getFlag_bankshow() {
    return this.flag_bankshow;
  }

  public void setFlag_bankshow(String flag_bankshow) {
    this.flag_bankshow = flag_bankshow;
  }

  public String getAgreeno() {
    return this.agreeno;
  }

  public void setAgreeno(String agreeno) {
    this.agreeno = agreeno;
  }

  public String getCorrelationID() {
    return this.correlationID;
  }

  public void setCorrelationID(String correlationID) {
    this.correlationID = correlationID;
  }

  public String getSupport_bank_map() {
    return this.support_bank_map;
  }

  public void setSupport_bank_map(String support_bank_map) {
    this.support_bank_map = support_bank_map;
  }

  public String getCustname() {
    return this.custname;
  }

  public void setCustname(String custname) {
    this.custname = custname;
  }

  public String getIsrecord() {
    return this.isrecord;
  }

  public void setIsrecord(String isrecord) {
    this.isrecord = isrecord;
  }

  public String getHistorycard() {
    return this.historycard;
  }

  public void setHistorycard(String historycard) {
    this.historycard = historycard;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getPay_mode() {
    return this.pay_mode;
  }

  public void setPay_mode(String pay_mode) {
    this.pay_mode = pay_mode;
  }

  public String getShareing_data() {
    return this.shareing_data;
  }

  public void setShareing_data(String shareing_data) {
    this.shareing_data = shareing_data;
  }

  public String getCard_no() {
    return this.card_no;
  }

  public void setCard_no(String card_no) {
    this.card_no = card_no;
  }

  public String getNo_agree() {
    return this.no_agree;
  }

  public void setNo_agree(String no_agree) {
    this.no_agree = no_agree;
  }

  public String getSmscode_locked() {
    return this.smscode_locked;
  }

  public void setSmscode_locked(String smscode_locked) {
    this.smscode_locked = smscode_locked;
  }

  public String getSupport_mode_list() {
    return this.support_mode_list;
  }

  public void setSupport_mode_list(String support_mode_list) {
    this.support_mode_list = support_mode_list;
  }

  public String getSupport_ebank_map() {
    return this.support_ebank_map;
  }

  public void setSupport_ebank_map(String support_ebank_map) {
    this.support_ebank_map = support_ebank_map;
  }

  public String getSupport_bankcard_map() {
    return this.support_bankcard_map;
  }

  public void setSupport_bankcard_map(String support_bankcard_map) {
    this.support_bankcard_map = support_bankcard_map;
  }

  public String getSms_template() {
    return this.sms_template;
  }

  public void setSms_template(String sms_template) {
    this.sms_template = sms_template;
  }

  public String getBank_name() {
    return this.bank_name;
  }

  public void setBank_name(String bank_name) {
    this.bank_name = bank_name;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getSupport_bankcard_json() {
    return this.support_bankcard_json;
  }

  public void setSupport_bankcard_json(String support_bankcard_json) {
    this.support_bankcard_json = support_bankcard_json;
  }

  public String getFlag_modify() {
    return this.flag_modify;
  }

  public void setFlag_modify(String flag_modify) {
    this.flag_modify = flag_modify;
  }

  public String getType_card() {
    return this.type_card;
  }

  public void setType_card(String type_card) {
    this.type_card = type_card;
  }

  public String getLocal_network() {
    return this.local_network;
  }

  public void setLocal_network(String local_network) {
    this.local_network = local_network;
  }

  public String getLocal_disk() {
    return this.local_disk;
  }

  public void setLocal_disk(String local_disk) {
    this.local_disk = local_disk;
  }

  public String getLocal_nic() {
    return this.local_nic;
  }

  public void setLocal_nic(String local_nic) {
    this.local_nic = local_nic;
  }

  public String getHidden_mobile() {
    return this.hidden_mobile;
  }

  public void setHidden_mobile(String hidden_mobile) {
    this.hidden_mobile = hidden_mobile;
  }

  public String getSignElementsFlag() {
    return this.signElementsFlag;
  }

  public void setSignElementsFlag(String signElementsFlag) {
    this.signElementsFlag = signElementsFlag;
  }

  public String getHidden_realname() {
    return this.hidden_realname;
  }

  public void setHidden_realname(String hidden_realname) {
    this.hidden_realname = hidden_realname;
  }

  public String getHidden_idcard() {
    return this.hidden_idcard;
  }

  public void setHidden_idcard(String hidden_idcard) {
    this.hidden_idcard = hidden_idcard;
  }

  public String getPre_card_mode() {
    return this.pre_card_mode;
  }

  public void setPre_card_mode(String pre_card_mode) {
    this.pre_card_mode = pre_card_mode;
  }

  public String getAcct_name() {
    return this.acct_name;
  }

  public void setAcct_name(String acct_name) {
    this.acct_name = acct_name;
  }

  public String getId_no() {
    return this.id_no;
  }

  public void setId_no(String id_no) {
    this.id_no = id_no;
  }

  public String getBg_color() {
    return this.bg_color;
  }

  public void setBg_color(String bg_color) {
    this.bg_color = bg_color;
  }
}