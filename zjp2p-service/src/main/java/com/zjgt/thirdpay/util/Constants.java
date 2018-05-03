package com.zjgt.thirdpay.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class Constants
{
  public static String version;
  public static String language;
  public static String inputCharset;
  public static String merchantAcctId;
  public static String pid;
  public static String key;
  public static String signType = "4";
  public static String sinaCrtFilePath;
  public static String actionUrl;
  public static String formElementId;
  public static String rechargeBgUrl;
  public static String rechargeRedirectUrl;
  public static String rapidPayToBankUrl;
  public static String rapidPayToBankBackUrl;
  public static String rapidPayToBankVersion;
  public static String payToBankUrl;
  public static String payToBankBackUrl;
  public static String payToBankVersion;
  public static String isDebug;

  public static boolean isDebugProfile()
  {
    return ("true".equals(isDebug));
  }

  public String getVersion()
  {
    return version;
  }

  @Value("${pay.version}")
  public void setVersion(String version) {
    version = version;
  }

  public static String getLanguage() {
    return language;
  }

  @Value("${pay.language}")
  public void setLanguage(String language) {
    language = language;
  }

  public static String getInputCharset() {
    return inputCharset;
  }

  @Value("${pay.inputCharset}")
  public void setInputCharset(String inputCharset) {
    inputCharset = inputCharset;
  }

  public static String getMerchantAcctId() {
    return merchantAcctId;
  }

  @Value("${pay.merchantAcctId}")
  public void setMerchantAcctId(String merchantAcctId) {
    merchantAcctId = merchantAcctId;
  }

  public static String getPid() {
    return pid;
  }

  @Value("${pay.pid}")
  public void setPid(String pid) {
    pid = pid;
  }

  public static String getKey() {
    return key;
  }

  @Value("${pay.key}")
  public void setKey(String key) {
    key = key;
  }

  public static String getSignType() {
    return signType;
  }

  @Value("${pay.signType}")
  public void setSignType(String signType) {
    signType = signType;
  }

  public static String getSinaCrtFilePath() {
    return sinaCrtFilePath;
  }

  @Value("${pay.sinaCrtFilePath}")
  public void setSinaCrtFilePath(String sinaCrtFilePath) {
    sinaCrtFilePath = sinaCrtFilePath;
  }

  public static String getActionUrl() {
    return actionUrl;
  }

  @Value("${pay.actionUrl}")
  public void setActionUrl(String actionUrl) {
    actionUrl = actionUrl;
  }

  public static String getFormElementId() {
    return formElementId;
  }

  @Value("${pay.formElementId}")
  public void setFormElementId(String formElementId) {
    formElementId = formElementId;
  }

  public static String getRechargeBgUrl() {
    return rechargeBgUrl;
  }

  @Value("${pay.rechargeBgUrl}")
  public void setRechargeBgUrl(String rechargeBgUrl) {
    rechargeBgUrl = rechargeBgUrl;
  }

  public static String getRechargeRedirectUrl() {
    return rechargeRedirectUrl;
  }

  @Value("${pay.rechargeRedirectUrl}")
  public void setRechargeRedirectUrl(String rechargeRedirectUrl) {
    rechargeRedirectUrl = rechargeRedirectUrl;
  }

  public static String getRapidPayToBankUrl() {
    return rapidPayToBankUrl;
  }

  @Value("${pay.rapidPayToBankUrl}")
  public void setRapidPayToBankUrl(String rapidPayToBankUrl) {
    rapidPayToBankUrl = rapidPayToBankUrl;
  }

  public static String getRapidPayToBankBackUrl() {
    return rapidPayToBankBackUrl;
  }

  @Value("${pay.rapidPayToBankBackUrl}")
  public void setRapidPayToBankBackUrl(String rapidPayToBankBackUrl) {
    rapidPayToBankBackUrl = rapidPayToBankBackUrl;
  }

  public static String getRapidPayToBankVersion() {
    return rapidPayToBankVersion;
  }

  @Value("${pay.rapidPayToBankVersion}")
  public void setRapidPayToBankVersion(String rapidPayToBankVersion) {
    rapidPayToBankVersion = rapidPayToBankVersion;
  }

  public static String getPayToBankUrl() {
    return payToBankUrl;
  }

  @Value("${pay.payToBankUrl}")
  public void setPayToBankUrl(String payToBankUrl) {
    payToBankUrl = payToBankUrl;
  }

  public static String getPayToBankBackUrl() {
    return payToBankBackUrl;
  }

  @Value("${pay.payToBankBackUrl}")
  public void setPayToBankBackUrl(String payToBankBackUrl) {
    payToBankBackUrl = payToBankBackUrl;
  }

  public static String getPayToBankVersion() {
    return payToBankVersion;
  }

  @Value("${pay.payToBankVersion}")
  public void setPayToBankVersion(String payToBankVersion) {
    payToBankVersion = payToBankVersion;
  }

  public static String getIsDebug() {
    return isDebug;
  }

  @Value("${pay.isDebug}")
  public void setIsDebug(String isDebug) {
    isDebug = isDebug;
  }
}