package com.zjgt.thirdpay.lianlian.security;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class TraderRSAUtil
{
  private static TraderRSAUtil instance;

  public static TraderRSAUtil getInstance()
  {
    if (null == instance)
      return new TraderRSAUtil();
    return instance;
  }

  public static String sign(String prikeyvalue, String sign_str)
  {
    try
    {
      PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getBytesBASE64(prikeyvalue));

      KeyFactory keyf = KeyFactory.getInstance("RSA");
      PrivateKey myprikey = keyf.generatePrivate(priPKCS8);

      Signature signet = Signature.getInstance("MD5withRSA");

      signet.initSign(myprikey);
      signet.update(sign_str.getBytes("UTF-8"));
      byte[] signed = signet.sign();
      return new String(org.apache.commons.codec.binary.Base64.encodeBase64(signed));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static boolean checksign(String pubkeyvalue, String oid_str, String signed_str)
  {
    try
    {
      X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(Base64.getBytesBASE64(pubkeyvalue));

      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey pubKey = keyFactory.generatePublic(bobPubKeySpec);
      byte[] signed = Base64.getBytesBASE64(signed_str);
      Signature signetcheck = Signature.getInstance("MD5withRSA");

      signetcheck.initVerify(pubKey);
      signetcheck.update(oid_str.getBytes("UTF-8"));
      return signetcheck.verify(signed);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}