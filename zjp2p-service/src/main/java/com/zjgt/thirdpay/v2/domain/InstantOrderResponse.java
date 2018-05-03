package com.zjgt.thirdpay.v2.domain;

import java.util.HashMap;
import java.util.Map;
import org.springfk.pancloud.utils.StringUtils;

public class InstantOrderResponse extends BaseResponseParam
{
  private static final long serialVersionUID = -6477587096926109336L;
  public String fee;
  public String gmt_close;
  public String gmt_create;
  public String gmt_payment;
  public String inner_trade_no;
  public String out_trade_no;
  public String trade_amount;
  public String trade_status;

  public String getFee()
  {
    return this.fee;
  }

  public void setFee(String fee) {
    this.fee = fee;
  }

  public String getGmt_close() {
    return this.gmt_close;
  }

  public void setGmt_close(String gmt_close) {
    this.gmt_close = gmt_close;
  }

  public String getGmt_create() {
    return this.gmt_create;
  }

  public void setGmt_create(String gmt_create) {
    this.gmt_create = gmt_create;
  }

  public String getGmt_payment() {
    return this.gmt_payment;
  }

  public void setGmt_payment(String gmt_payment) {
    this.gmt_payment = gmt_payment;
  }

  public String getInner_trade_no() {
    return this.inner_trade_no;
  }

  public void setInner_trade_no(String inner_trade_no) {
    this.inner_trade_no = inner_trade_no;
  }

  public String getOut_trade_no() {
    return this.out_trade_no;
  }

  public void setOut_trade_no(String out_trade_no) {
    this.out_trade_no = out_trade_no;
  }

  public String getTrade_amount() {
    return this.trade_amount;
  }

  public void setTrade_amount(String trade_amount) {
    this.trade_amount = trade_amount;
  }

  public String getTrade_status() {
    return this.trade_status;
  }

  public void setTrade_status(String trade_status) {
    this.trade_status = trade_status;
  }

  public Map<String, String> generateSignContent()
  {
    Map builder = new HashMap();
    if (StringUtils.isNotEmpty(this._input_charset)) {
      builder.put("_input_charset", this._input_charset);
    }
    if (StringUtils.isNotEmpty(this.error_code)) {
      builder.put("error_code", this.error_code);
    }
    if (StringUtils.isNotEmpty(this.error_message)) {
      builder.put("error_message", this.error_message);
    }
    if (StringUtils.isNotEmpty(this.fee)) {
      builder.put("fee", this.fee);
    }
    if (StringUtils.isNotEmpty(this.gmt_close)) {
      builder.put("gmt_close", this.gmt_close);
    }
    if (StringUtils.isNotEmpty(this.gmt_create)) {
      builder.put("gmt_create", this.gmt_create);
    }
    if (StringUtils.isNotEmpty(this.gmt_payment)) {
      builder.put("gmt_payment", this.gmt_payment);
    }
    if (StringUtils.isNotEmpty(this.inner_trade_no)) {
      builder.put("inner_trade_no", this.inner_trade_no);
    }
    if (StringUtils.isNotEmpty(this.memo)) {
      builder.put("memo", this.memo);
    }
    if (StringUtils.isNotEmpty(this.notify_id)) {
      builder.put("notify_id", this.notify_id);
    }
    if (StringUtils.isNotEmpty(this.notify_time)) {
      builder.put("notify_time", this.notify_time);
    }
    if (StringUtils.isNotEmpty(this.notify_type)) {
      builder.put("notify_type", this.notify_type);
    }
    if (StringUtils.isNotEmpty(this.out_trade_no)) {
      builder.put("out_trade_no", this.out_trade_no);
    }
    if (StringUtils.isNotEmpty(this.trade_amount)) {
      builder.put("trade_amount", this.trade_amount);
    }
    if (StringUtils.isNotEmpty(this.trade_status)) {
      builder.put("trade_status", this.trade_status);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.put("version", this.version);
    }
    return builder;
  }

  public String toString()
  {
    return "Response [_input_charset=" + this._input_charset + ",error_code=" + this.error_code + ",error_message=" + this.error_message + ",fee=" + this.fee + ",gmt_close=" + this.gmt_close + ",gmt_create=" + this.gmt_create + ",gmt_payment=" + this.gmt_payment + ",inner_trade_no=" + this.inner_trade_no + ",memo=" + this.memo + ",notify_id=" + this.notify_id + ",notify_time=" + this.notify_time + ",notify_type=" + this.notify_type + ",out_trade_no=" + this.out_trade_no + ",sign=" + this.sign + ",sign_type=" + this.sign_type + ",trade_amount=" + this.trade_amount + ",trade_status=" + this.trade_status + "]";
  }
}