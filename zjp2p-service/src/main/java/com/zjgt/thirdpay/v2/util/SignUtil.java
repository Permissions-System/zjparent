package com.zjgt.thirdpay.v2.util;

public class SignUtil
{
  public static boolean Check_sign(String content, String signMsg, String signType, String signKey, String charset)
    throws Exception
  {
    if ("MD5".equalsIgnoreCase(signType))
      return MD5.verify(content, signMsg, signKey, charset);
    if ("RSA".equalsIgnoreCase(signType)) {
      return RSA.verify(content, signMsg, signKey, charset);
    }
    return false;
  }

  public static String sign(String content, String signType, String signKey, String charset) throws Exception
  {
    if ("MD5".equalsIgnoreCase(signType))
      return MD5.sign(content, signKey, charset);
    if ("RSA".equalsIgnoreCase(signType)) {
      return RSA.sign(content, signKey, charset);
    }
    return "";
  }
}