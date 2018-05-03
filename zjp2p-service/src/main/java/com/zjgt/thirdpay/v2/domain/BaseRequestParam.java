package com.zjgt.thirdpay.v2.domain;

import com.zjgt.thirdpay.domain.ThirdpayBaseRequest;
import com.zjgt.thirdpay.v2.util.Tools;
import java.util.Map;

public abstract class BaseRequestParam extends ThirdpayBaseRequest
{
  private static final long serialVersionUID = 7390393501981498470L;
  public String _input_charset;
  public String encrypt_version;
  public String memo;
  public String notify_url;
  public String partner_id;
  public String request_time;
  public String return_url;
  public String service;
  public String sign;
  public String sign_type;
  public String sign_version;
  public String version;

  public abstract Map<String, String> generateSignContent();

  public String generateSign()
  {
    String content = Tools.createLinkString(generateSignContent(), false);
    return content;
  }

  public String get_input_charset() {
    return this._input_charset;
  }

  public void set_input_charset(String _input_charset) {
    this._input_charset = _input_charset;
  }

  public String getEncrypt_version() {
    return this.encrypt_version;
  }

  public void setEncrypt_version(String encrypt_version) {
    this.encrypt_version = encrypt_version;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getNotify_url() {
    return this.notify_url;
  }

  public void setNotify_url(String notify_url) {
    this.notify_url = notify_url;
  }

  public String getPartner_id() {
    return this.partner_id;
  }

  public void setPartner_id(String partner_id) {
    this.partner_id = partner_id;
  }

  public String getRequest_time() {
    return this.request_time;
  }

  public void setRequest_time(String request_time) {
    this.request_time = request_time;
  }

  public String getReturn_url() {
    return this.return_url;
  }

  public void setReturn_url(String return_url) {
    this.return_url = return_url;
  }

  public String getService() {
    return this.service;
  }

  public void setService(String service) {
    this.service = service;
  }

  public String getSign() {
    return this.sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }

  public String getSign_type() {
    return this.sign_type;
  }

  public void setSign_type(String sign_type) {
    this.sign_type = sign_type;
  }

  public String getSign_version() {
    return this.sign_version;
  }

  public void setSign_version(String sign_version) {
    this.sign_version = sign_version;
  }

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}