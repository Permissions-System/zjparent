package com.zjgt.thirdpay.lianlian.enums;

public enum SignTypeEnum
{
  RSA, MD5;

  private final String code = null;
  private final String msg = null;

  public String getCode()
  {
    return this.code;
  }

  public String getMsg()
  {
    return this.msg;
  }

  public static boolean isSignType(String code) {
    for (SignTypeEnum s : values())
    {
      if (s.getCode().equals(code))
      {
        return true;
      }
    }
    return false;
  }
}