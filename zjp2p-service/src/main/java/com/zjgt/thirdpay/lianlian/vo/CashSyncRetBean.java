package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CashSyncRetBean
  implements Serializable
{
  private static final long serialVersionUID = -3211377967051725928L;
  private String ret_code;
  private String ret_msg;
  private String sign_type;
  private String sign;

  public String toString()
  {
    return new ToStringBuilder(this).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).append("sign_type", this.sign_type).append("sign", this.sign).toString();
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
}