package com.zjgt.thirdpay.lianlian.enums;

public enum PayResultEnum
{
  SUCCESS, PROCESSING, FAILURE, REFUND;

  private final String code = null;
  private final String msg = null;

  public static boolean isPayResult(String code)
  {
    for (PayResultEnum v : values())
    {
      if (v.getCode().equals(code))
      {
        return true;
      }
    }
    return false;
  }

  public static String getMsgByCode(String code)
  {
    for (PayResultEnum v : values())
    {
      if (v.getCode().equals(code))
      {
        return v.getMsg();
      }
    }
    return "未知结果";
  }

  public String getCode() {
    return this.code;
  }

  public String getMsg()
  {
    return this.msg;
  }
}