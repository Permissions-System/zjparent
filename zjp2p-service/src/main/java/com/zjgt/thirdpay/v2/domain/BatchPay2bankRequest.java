package com.zjgt.thirdpay.v2.domain;

import java.util.HashMap;
import java.util.Map;
import org.springfk.pancloud.utils.StringUtils;

public class BatchPay2bankRequest extends BaseRequestParam
{
  private static final long serialVersionUID = -1497257908433931242L;
  private String batch_no;
  private String detail_list;
  private String payto_type;
  private String extend_param;

  public String getBatch_no()
  {
    return this.batch_no;
  }

  public void setBatch_no(String batch_no) {
    this.batch_no = batch_no;
  }

  public String getDetail_list() {
    return this.detail_list;
  }

  public void setDetail_list(String detail_list) {
    this.detail_list = detail_list;
  }

  public String getPayto_type() {
    return this.payto_type;
  }

  public void setPayto_type(String payto_type) {
    this.payto_type = payto_type;
  }

  public String getExtend_param() {
    return this.extend_param;
  }

  public void setExtend_param(String extend_param) {
    this.extend_param = extend_param;
  }

  public Map<String, String> generateSignContent()
  {
    Map builder = new HashMap();
    if (StringUtils.isNotEmpty(this._input_charset)) {
      builder.put("_input_charset", this._input_charset);
    }
    if (StringUtils.isNotEmpty(this.batch_no)) {
      builder.put("batch_no", this.batch_no);
    }
    if (StringUtils.isNotEmpty(this.detail_list)) {
      builder.put("detail_list", this.detail_list);
    }
    if (StringUtils.isNotEmpty(this.encrypt_version)) {
      builder.put("encrypt_version", this.encrypt_version);
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
    if (StringUtils.isNotEmpty(this.partner_id)) {
      builder.put("partner_id", this.partner_id);
    }
    if (StringUtils.isNotEmpty(this.payto_type)) {
      builder.put("payto_type", this.payto_type);
    }
    if (StringUtils.isNotEmpty(this.request_time)) {
      builder.put("request_time", this.request_time);
    }
    if (StringUtils.isNotEmpty(this.return_url)) {
      builder.put("return_url", this.return_url);
    }
    if (StringUtils.isNotEmpty(this.service)) {
      builder.put("service", this.service);
    }
    if (StringUtils.isNotEmpty(this.version)) {
      builder.put("version", this.version);
    }
    return builder;
  }

  public String toString()
  {
    return "Request [_input_charset=" + this._input_charset + ",batch_no=" + this.batch_no + ",detail_list=" + this.detail_list + ",encrypt_version=" + this.encrypt_version + ",extend_param=" + this.extend_param + ",memo=" + this.memo + ",notify_url=" + this.notify_url + ",partner_id=" + this.partner_id + ",payto_type=" + this.payto_type + ",request_time=" + this.request_time + ",return_url=" + this.return_url + ",service=" + this.service + ",sign=" + this.sign + ",sign_type=" + this.sign_type + ",sign_version=" + this.sign_version + "]";
  }
}