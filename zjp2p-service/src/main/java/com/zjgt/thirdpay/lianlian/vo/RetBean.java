package com.zjgt.thirdpay.lianlian.vo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public class RetBean
  implements Serializable
{
  private static final long serialVersionUID = 394608337569196793L;
  private String ret_code;
  private String ret_msg;

  public String toString()
  {
    return new ToStringBuilder(this).append("ret_code", this.ret_code).append("ret_msg", this.ret_msg).toString();
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

  public static RetBean getErrorObj() {
    RetBean bean = new RetBean();
    bean.setError();
    return bean;
  }

  public static RetBean getSuccessObj() {
    RetBean bean = new RetBean();
    bean.setSuccess();
    return bean;
  }

  public void setError() {
    setRet_code("9999");
    setRet_msg("交易失败");
  }

  public void setSuccess() {
    setRet_code("0000");
    setRet_msg("交易成功");
  }
}