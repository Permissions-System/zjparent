package com.zjgt.thirdpay.v2.domain;

import java.util.HashMap;
import java.util.Map;
import org.springfk.pancloud.utils.StringUtils;

public class BatchPay2bankResponse extends BaseResponseParam
{
  private static final long serialVersionUID = -5193919234826853963L;
  private String batch_no;
  private String inner_batch_no;
  private String batch_amount;
  private String batch_quantity;
  private String batch_status;
  private String trade_list;
  private String gmt_create;
  private String gmt_finished;

  public Map<String, String> generateSignContent()
  {
    Map builder = new HashMap();
    if (StringUtils.isNotEmpty(this._input_charset)) {
      builder.put("_input_charset", this._input_charset);
    }
    if (StringUtils.isNotEmpty(this.batch_amount)) {
      builder.put("batch_amount", this.batch_amount);
    }
    if (StringUtils.isNotEmpty(this.batch_no)) {
      builder.put("batch_no", this.batch_no);
    }
    if (StringUtils.isNotEmpty(this.batch_quantity)) {
      builder.put("batch_quantity", this.batch_quantity);
    }
    if (StringUtils.isNotEmpty(this.batch_status)) {
      builder.put("batch_status", this.batch_status);
    }
    if (StringUtils.isNotEmpty(this.error_code)) {
      builder.put("error_code", this.error_code);
    }
    if (StringUtils.isNotEmpty(this.error_message)) {
      builder.put("error_message", this.error_message);
    }
    if (StringUtils.isNotEmpty(this.gmt_create)) {
      builder.put("gmt_create", this.gmt_create);
    }
    if (StringUtils.isNotEmpty(this.gmt_finished)) {
      builder.put("gmt_finished", this.gmt_finished);
    }
    if (StringUtils.isNotEmpty(this.inner_batch_no)) {
      builder.put("inner_batch_no", this.inner_batch_no);
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
    if (StringUtils.isNotEmpty(this.trade_list)) {
      builder.put("trade_list", this.trade_list);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.put("version", this.version);
    }
    return builder;
  }

  public String getBatch_no() {
    return this.batch_no;
  }

  public void setBatch_no(String batch_no) {
    this.batch_no = batch_no;
  }

  public String getInner_batch_no() {
    return this.inner_batch_no;
  }

  public void setInner_batch_no(String inner_batch_no) {
    this.inner_batch_no = inner_batch_no;
  }

  public String getBatch_amount() {
    return this.batch_amount;
  }

  public void setBatch_amount(String batch_amount) {
    this.batch_amount = batch_amount;
  }

  public String getBatch_quantity() {
    return this.batch_quantity;
  }

  public void setBatch_quantity(String batch_quantity) {
    this.batch_quantity = batch_quantity;
  }

  public String getBatch_status() {
    return this.batch_status;
  }

  public void setBatch_status(String batch_status) {
    this.batch_status = batch_status;
  }

  public String getTrade_list() {
    return this.trade_list;
  }

  public void setTrade_list(String trade_list) {
    this.trade_list = trade_list;
  }

  public String getGmt_create() {
    return this.gmt_create;
  }

  public void setGmt_create(String gmt_create) {
    this.gmt_create = gmt_create;
  }

  public String getGmt_finished() {
    return this.gmt_finished;
  }

  public void setGmt_finished(String gmt_finished) {
    this.gmt_finished = gmt_finished;
  }

  public String toString()
  {
    return "Response [_input_charset=" + this._input_charset + ",batch_amount=" + this.batch_amount + ",batch_no=" + this.batch_no + ",batch_quantity=" + this.batch_quantity + ",batch_status=" + this.batch_status + ",error_code=" + this.error_code + ",error_message=" + this.error_message + ",gmt_create=" + this.gmt_create + ",gmt_finished=" + this.gmt_finished + ",inner_batch_no=" + this.inner_batch_no + ",memo=" + this.memo + ",notify_id=" + this.notify_id + ",notify_time=" + this.notify_time + ",notify_type=" + this.notify_type + ",sign=" + this.sign + ",sign_type=" + this.sign_type + ",trade_list=" + this.trade_list + "]";
  }
}