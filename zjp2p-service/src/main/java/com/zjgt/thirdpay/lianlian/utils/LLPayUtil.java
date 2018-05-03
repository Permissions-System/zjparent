package com.zjgt.thirdpay.lianlian.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zjgt.thirdpay.lianlian.enums.SignTypeEnum;
import com.zjgt.thirdpay.lianlian.security.Md5Algorithm;
import com.zjgt.thirdpay.lianlian.security.TraderRSAUtil;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LLPayUtil
{
  static Logger logger = LoggerFactory.getLogger(LLPayUtil.class);

  public static boolean isnull(String str)
  {
    return ((null == str) || (str.equalsIgnoreCase("null")) || (str.equals("")));
  }

  public static String getCurrentDateTimeStr()
  {
    SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    Date date = new Date();
    String timeString = dataFormat.format(date);
    return timeString;
  }

  public static String genSignData(JSONObject jsonObject)
  {
    StringBuffer content = new StringBuffer();

    List keys = new ArrayList(jsonObject.keySet());
    Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < keys.size(); ++i) {
      String key = (String)keys.get(i);
      if ("sign".equals(key)) {
        continue;
      }
      String value = jsonObject.getString(key);

      if (isnull(value)) {
        continue;
      }
      content.append(new StringBuilder().append((i == 0) ? "" : "&").append(key).append("=").append(value).toString());
    }

    String signSrc = content.toString();
    if (signSrc.startsWith("&")) {
      signSrc = signSrc.replaceFirst("&", "");
    }
    return signSrc;
  }

  public static String genOrderQuerySignData(JSONObject jsonObject)
  {
    StringBuffer content = new StringBuffer();

    List keys = new ArrayList(jsonObject.keySet());
    Collections.sort(keys, String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < keys.size(); ++i) {
      String key = (String)keys.get(i);
      if (("sign".equals(key)) || ("bank_name".equals(key))) continue; if ("card_no".equals(key)) {
        continue;
      }
      String value = jsonObject.getString(key);

      if (isnull(value)) {
        continue;
      }
      content.append(new StringBuilder().append((i == 0) ? "" : "&").append(key).append("=").append(value).toString());
    }

    String signSrc = content.toString();
    if (signSrc.startsWith("&")) {
      signSrc = signSrc.replaceFirst("&", "");
    }
    return signSrc;
  }

  public static String addSign(JSONObject reqObj, String rsa_private, String md5_key)
  {
    if (reqObj == null) {
      return "";
    }
    String sign_type = reqObj.getString("sign_type");
    if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
      return addSignMD5(reqObj, md5_key);
    }
    return addSignRSA(reqObj, rsa_private);
  }

  public static boolean checkSign(String reqStr, String rsa_public, String md5_key)
  {
    JSONObject reqObj = JSON.parseObject(reqStr);
    if (reqObj == null) {
      return false;
    }
    String sign_type = reqObj.getString("sign_type");
    if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
      return checkSignMD5(reqObj, md5_key);
    }
    return checkSignRSA(reqObj, rsa_public);
  }

  public static boolean checkOrderQuerySign(String reqStr, String rsa_public, String md5_key)
  {
    JSONObject reqObj = JSON.parseObject(reqStr);
    if (reqObj == null) {
      return false;
    }
    String sign_type = reqObj.getString("sign_type");
    if (SignTypeEnum.MD5.getCode().equals(sign_type)) {
      return checkSignMD5(reqObj, md5_key);
    }
    return checkOrderQuerySignRSA(reqObj, rsa_public);
  }

  private static boolean checkSignRSA(JSONObject reqObj, String rsa_public)
  {
    logger.info(new StringBuilder().append("进入商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证").toString());
    if (reqObj == null) {
      return false;
    }
    String sign = reqObj.getString("sign");

    String sign_src = genSignData(reqObj);
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]待签名原串").append(sign_src).toString());
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]签名串").append(sign).toString());
    try {
      if (TraderRSAUtil.checksign(rsa_public, sign_src, sign)) {
        logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证通过").toString());
        return true;
      }
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证未通过").toString());
      return false;
    }
    catch (Exception e) {
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证异常").append(e.getMessage()).toString()); }
    return false;
  }

  private static boolean checkOrderQuerySignRSA(JSONObject reqObj, String rsa_public)
  {
    logger.info(new StringBuilder().append("进入商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证").toString());
    if (reqObj == null) {
      return false;
    }
    String sign = reqObj.getString("sign");

    String sign_src = genOrderQuerySignData(reqObj);
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]待签名原串").append(sign_src).toString());
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]签名串").append(sign).toString());
    try {
      if (TraderRSAUtil.checksign(rsa_public, sign_src, sign)) {
        logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证通过").toString());
        return true;
      }
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证未通过").toString());
      return false;
    }
    catch (Exception e) {
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA签名验证异常").append(e.getMessage()).toString()); }
    return false;
  }

  private static boolean checkSignMD5(JSONObject reqObj, String md5_key)
  {
    logger.info(new StringBuilder().append("进入商户[").append(reqObj.getString("oid_partner")).append("]MD5签名验证").toString());
    if (reqObj == null) {
      return false;
    }
    String sign = reqObj.getString("sign");

    String sign_src = genSignData(reqObj);
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]待签名原串").append(sign_src).toString());
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]签名串").append(sign).toString());
    sign_src = new StringBuilder().append(sign_src).append("&key=").append(md5_key).toString();
    try {
      if (sign.equals(Md5Algorithm.getInstance().md5Digest(sign_src.getBytes("utf-8")))) {
        logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]MD5签名验证通过").toString());
        return true;
      }
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]MD5签名验证未通过").toString());
      return false;
    }
    catch (UnsupportedEncodingException e) {
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]MD5签名验证异常").append(e.getMessage()).toString()); }
    return false;
  }

  private static String addSignRSA(JSONObject reqObj, String rsa_private)
  {
    logger.info(new StringBuilder().append("进入商户[").append(reqObj.getString("oid_partner")).append("]RSA加签名").toString());
    if (reqObj == null) {
      return "";
    }

    String sign_src = genSignData(reqObj);
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]加签原串").append(sign_src).toString());
    try {
      return TraderRSAUtil.sign(rsa_private, sign_src);
    } catch (Exception e) {
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]RSA加签名异常").append(e.getMessage()).toString()); }
    return "";
  }

  private static String addSignMD5(JSONObject reqObj, String md5_key)
  {
    logger.info(new StringBuilder().append("进入商户[").append(reqObj.getString("oid_partner")).append("]MD5加签名").toString());
    if (reqObj == null) {
      return "";
    }

    String sign_src = genSignData(reqObj);
    logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]加签原串").append(sign_src).toString());
    sign_src = new StringBuilder().append(sign_src).append("&key=").append(md5_key).toString();
    try {
      return Md5Algorithm.getInstance().md5Digest(sign_src.getBytes("utf-8"));
    } catch (Exception e) {
      logger.info(new StringBuilder().append("商户[").append(reqObj.getString("oid_partner")).append("]MD5加签名异常").append(e.getMessage()).toString()); }
    return "";
  }
}