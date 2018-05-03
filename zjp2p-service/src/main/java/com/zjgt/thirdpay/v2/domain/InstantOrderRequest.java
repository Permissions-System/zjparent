package com.zjgt.thirdpay.v2.domain;

import java.util.HashMap;
import java.util.Map;
import org.springfk.pancloud.utils.StringUtils;

public class InstantOrderRequest extends BaseRequestParam
{
  private static final long serialVersionUID = -5861101580746487000L;
  public String amount;
  public String buyer_identity_id;
  public String buyer_identity_type;
  public String can_repeat;
  public String device_id;
  public String expired_time;
  public String extend_param;
  public String out_trade_no;
  public String pay_method;
  public String payer_ip;
  public String product_desc;
  public String seller_account_type;
  public String seller_identity_id;
  public String seller_identity_type;
  public String split_list;

  public String getAmount()
  {
    return this.amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getBuyer_identity_id() {
    return this.buyer_identity_id;
  }

  public void setBuyer_identity_id(String buyer_identity_id) {
    this.buyer_identity_id = buyer_identity_id;
  }

  public String getBuyer_identity_type() {
    return this.buyer_identity_type;
  }

  public void setBuyer_identity_type(String buyer_identity_type) {
    this.buyer_identity_type = buyer_identity_type;
  }

  public String getCan_repeat() {
    return this.can_repeat;
  }

  public void setCan_repeat(String can_repeat) {
    this.can_repeat = can_repeat;
  }

  public String getDevice_id() {
    return this.device_id;
  }

  public void setDevice_id(String device_id) {
    this.device_id = device_id;
  }

  public String getExpired_time() {
    return this.expired_time;
  }

  public void setExpired_time(String expired_time) {
    this.expired_time = expired_time;
  }

  public String getExtend_param() {
    return this.extend_param;
  }

  public void setExtend_param(String extend_param) {
    this.extend_param = extend_param;
  }

  public String getOut_trade_no() {
    return this.out_trade_no;
  }

  public void setOut_trade_no(String out_trade_no) {
    this.out_trade_no = out_trade_no;
  }

  public String getPay_method() {
    return this.pay_method;
  }

  public void setPay_method(String pay_method) {
    this.pay_method = pay_method;
  }

  public String getPayer_ip() {
    return this.payer_ip;
  }

  public void setPayer_ip(String payer_ip) {
    this.payer_ip = payer_ip;
  }

  public String getProduct_desc() {
    return this.product_desc;
  }

  public void setProduct_desc(String product_desc) {
    this.product_desc = product_desc;
  }

  public String getSeller_account_type() {
    return this.seller_account_type;
  }

  public void setSeller_account_type(String seller_account_type) {
    this.seller_account_type = seller_account_type;
  }

  public String getSeller_identity_id() {
    return this.seller_identity_id;
  }

  public void setSeller_identity_id(String seller_identity_id) {
    this.seller_identity_id = seller_identity_id;
  }

  public String getSeller_identity_type() {
    return this.seller_identity_type;
  }

  public void setSeller_identity_type(String seller_identity_type) {
    this.seller_identity_type = seller_identity_type;
  }

  public String getSplit_list() {
    return this.split_list;
  }

  public void setSplit_list(String split_list) {
    this.split_list = split_list;
  }

  public Map<String, String> generateSignContent()
  {
    Map builder = new HashMap();
    if (StringUtils.isNotEmpty(this._input_charset)) {
      builder.put("_input_charset", this._input_charset);
    }
    if (StringUtils.isNotEmpty(this.amount)) {
      builder.put("amount", this.amount);
    }
    if (StringUtils.isNotEmpty(this.buyer_identity_id)) {
      builder.put("buyer_identity_id", this.buyer_identity_id);
    }
    if (StringUtils.isNotEmpty(this.buyer_identity_type)) {
      builder.put("buyer_identity_type", this.buyer_identity_type);
    }
    if (StringUtils.isNotEmpty(this.can_repeat)) {
      builder.put("can_repeat", this.can_repeat);
    }
    if (StringUtils.isNotEmpty(this.device_id)) {
      builder.put("device_id", this.device_id);
    }
    if (StringUtils.isNotEmpty(this.encrypt_version)) {
      builder.put("encrypt_version", this.encrypt_version);
    }
    if (StringUtils.isNotEmpty(this.expired_time)) {
      builder.put("expired_time", this.expired_time);
    }
    if (StringUtils.isNotEmpty(this.extend_param)) {
      builder.put("extend_param", this.extend_param);
    }
    if (StringUtils.isNotEmpty(this.memo)) {
      builder.put("memo", this.memo);
    }
    if (StringUtils.isNotEmpty(this.notify_url)) {
      builder.put("notify_url", this.notify_url);
    }
    if (StringUtils.isNotEmpty(this.out_trade_no)) {
      builder.put("out_trade_no", this.out_trade_no);
    }
    if (StringUtils.isNotEmpty(this.partner_id)) {
      builder.put("partner_id", this.partner_id);
    }
    if (StringUtils.isNotEmpty(this.pay_method)) {
      builder.put("pay_method", this.pay_method);
    }
    if (StringUtils.isNotEmpty(this.payer_ip)) {
      builder.put("payer_ip", this.payer_ip);
    }
    if (StringUtils.isNotEmpty(this.product_desc)) {
      builder.put("product_desc", this.product_desc);
    }
    if (StringUtils.isNotEmpty(this.request_time)) {
      builder.put("request_time", this.request_time);
    }
    if (StringUtils.isNotEmpty(this.return_url)) {
      builder.put("return_url", this.return_url);
    }
    if (StringUtils.isNotEmpty(this.seller_account_type)) {
      builder.put("seller_account_type", this.seller_account_type);
    }
    if (StringUtils.isNotEmpty(this.seller_identity_id)) {
      builder.put("seller_identity_id", this.seller_identity_id);
    }
    if (StringUtils.isNotEmpty(this.seller_identity_type)) {
      builder.put("seller_identity_type", this.seller_identity_type);
    }
    if (StringUtils.isNotEmpty(this.service)) {
      builder.put("service", this.service);
    }
    if (StringUtils.isNotEmpty(this.split_list)) {
      builder.put("split_list", this.split_list);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.put("version", this.version);
    }
    return builder;
  }

  public String toString()
  {
    return "Request [_input_charset=" + this._input_charset + ",amount=" + this.amount + ",buyer_identity_id=" + this.buyer_identity_id + ",buyer_identity_type=" + this.buyer_identity_type + ",can_repeat=" + this.can_repeat + ",device_id=" + this.device_id + ",encrypt_version=" + this.encrypt_version + ",expired_time=" + this.expired_time + ",extend_param=" + this.extend_param + ",memo=" + this.memo + ",notify_url=" + this.notify_url + ",out_trade_no=" + this.out_trade_no + ",partner_id=" + this.partner_id + ",pay_method=" + this.pay_method + ",payer_ip=" + this.payer_ip + ",product_desc=" + this.product_desc + ",request_time=" + this.request_time + ",return_url=" + this.return_url + ",seller_account_type=" + this.seller_account_type + ",seller_identity_id=" + this.seller_identity_id + ",seller_identity_type=" + this.seller_identity_type + ",service=" + this.service + ",sign=" + this.sign + ",sign_type=" + this.sign_type + ",sign_version=" + this.sign_version + ",split_list=" + this.split_list + "]";
  }
}