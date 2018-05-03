package com.zjgt.thirdpay.v2.domain;

import com.zjgt.thirdpay.v2.util.Tools;
import java.io.Serializable;
import java.util.Map;

public abstract class BaseResponseParam
  implements Serializable
{
  private static final long serialVersionUID = -4149462650513957009L;
  protected String notify_type;
  protected String notify_id;
  protected String _input_charset;
  protected String notify_time;
  protected String sign;
  protected String sign_type;
  protected String version;
  protected String memo;
  protected String error_code;
  protected String error_message;

  public abstract Map<String, String> generateSignContent();

  public String generateSign()
  {
    String content = Tools.createLinkString(generateSignContent(), false);
    return content;
  }

  public String getNotify_type() {
    return this.notify_type;
  }

  public void setNotify_type(String notify_type) {
    this.notify_type = notify_type;
  }

  public String getNotify_id() {
    return this.notify_id;
  }

  public void setNotify_id(String notify_id) {
    this.notify_id = notify_id;
  }

  public String get_input_charset() {
    return this._input_charset;
  }

  public void set_input_charset(String _input_charset) {
    this._input_charset = _input_charset;
  }

  public String getNotify_time() {
    return this.notify_time;
  }

  public void setNotify_time(String notify_time) {
    this.notify_time = notify_time;
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

  public String getVersion() {
    return this.version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getMemo() {
    return this.memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public String getError_code() {
    return this.error_code;
  }

  public void setError_code(String error_code) {
    this.error_code = error_code;
  }

  public String getError_message() {
    return this.error_message;
  }

  public void setError_message(String error_message) {
    this.error_message = error_message;
  }
}