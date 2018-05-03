package com.zjgt.thirdpay.v2.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;

public class RSA
{
  public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
  public static final String KEY_ALGORITHM = "RSA";
  private static final int MAX_ENCRYPT_BLOCK = 117;
  private static final int MAX_DECRYPT_BLOCK = 128;
  private static final String PUBLIC_KEY = "RSAPublicKey";
  private static final String PRIVATE_KEY = "RSAPrivateKey";

  public static Map<String, Object> genKeyPair()
    throws Exception
  {
    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
    keyPairGen.initialize(1024);
    KeyPair keyPair = keyPairGen.generateKeyPair();
    RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();
    RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();
    Map keyMap = new HashMap(2);
    keyMap.put("RSAPublicKey", publicKey);
    keyMap.put("RSAPrivateKey", privateKey);
    return keyMap;
  }

  public static void main(String[] args) throws Exception
  {
    Map genKeyPair = genKeyPair();

    String base64publicKey = getPublicKey(genKeyPair);
    System.out.println("公钥 \n" + base64publicKey);
    String base64privateKey = getPrivateKey(genKeyPair);
    System.out.println("私钥\n" + base64privateKey);

    String passwd = "cat123113";
    String charsetName = "utf-8";

    String encryptByPublicKey = encryptByPublicKey(passwd, base64publicKey);

    System.out.println("加密\n" + encryptByPublicKey);

    byte[] decryptByPrivateKey = decryptByPrivateKey(org.apache.commons.codec.binary.Base64.decodeBase64(encryptByPublicKey), base64privateKey);

    String string = new String(decryptByPrivateKey, "utf-8");
    System.out.println("解密后\n" + string);
  }

  public static String sign(String text, String privateKey, String charset)
    throws Exception
  {
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(privateKey);
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
    Signature signature = Signature.getInstance("SHA1withRSA");
    signature.initSign(privateK);
    signature.update(getContentBytes(text, charset));
    byte[] result = signature.sign();
    return org.apache.commons.codec.binary.Base64.encodeBase64String(result);
  }

  public static String sign(String text, PrivateKey privateKey, String charset)
    throws SignatureException, InvalidKeyException
  {
    try
    {
      Signature signature = Signature.getInstance("SHA1withRSA");
      signature.initSign(privateKey);
      signature.update(getContentBytes(text, charset));
      byte[] result = signature.sign();
      return org.apache.commons.codec.binary.Base64.encodeBase64String(result);
    } catch (NoSuchAlgorithmException e) {
    }
    return null;
  }

  public static boolean verify(String text, String sign, String publicKey, String charset)
    throws Exception
  {
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey publicK = keyFactory.generatePublic(keySpec);

    Signature signature = Signature.getInstance("SHA1withRSA");
    signature.initVerify(publicK);
    signature.update(getContentBytes(text, charset));
    return signature.verify(org.apache.commons.codec.binary.Base64.decodeBase64(sign));
  }

  public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey)
    throws Exception
  {
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(privateKey);
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(2, privateK);
    int inputLen = encryptedData.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;

    int i = 0;

    while (inputLen - offSet > 0)
    {
      byte[] cache;
      if (inputLen - offSet > 128)
        cache = cipher.doFinal(encryptedData, offSet, 128);
      else {
        cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      ++i;
      offSet = i * 128;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
  }

  public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey)
    throws Exception
  {
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key publicK = keyFactory.generatePublic(x509KeySpec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(2, publicK);
    int inputLen = encryptedData.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;

    int i = 0;

    while (inputLen - offSet > 0)
    {
      byte[] cache;
      if (inputLen - offSet > 128)
        cache = cipher.doFinal(encryptedData, offSet, 128);
      else {
        cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      ++i;
      offSet = i * 128;
    }
    byte[] decryptedData = out.toByteArray();
    out.close();
    return decryptedData;
  }

  public static String encryptByPublicKey(String data, String publicKey)
    throws Exception
  {
    byte[] value = data.getBytes("utf-8");
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(publicKey);
    X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key publicK = keyFactory.generatePublic(x509KeySpec);

    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(1, publicK);
    int inputLen = value.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;

    int i = 0;

    while (inputLen - offSet > 0)
    {
      byte[] cache;
      if (inputLen - offSet > 117)
        cache = cipher.doFinal(value, offSet, 117);
      else {
        cache = cipher.doFinal(value, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      ++i;
      offSet = i * 117;
    }
    byte[] encryptedData = out.toByteArray();
    out.close();
    return Base64.encode(encryptedData);
  }

  public static byte[] encryptByPublicKey(byte[] data, Certificate cert)
    throws Exception
  {
    PublicKey uk = cert.getPublicKey();
    Cipher cipher = Cipher.getInstance(uk.getAlgorithm());
    cipher.init(1, uk);
    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;

    int i = 0;

    while (inputLen - offSet > 0)
    {
      byte[] cache;
      if (inputLen - offSet > 117)
        cache = cipher.doFinal(data, offSet, 117);
      else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      ++i;
      offSet = i * 117;
    }
    byte[] encryptedData = out.toByteArray();
    out.close();
    return encryptedData;
  }

  public static byte[] encryptByPrivateKey(byte[] data, String privateKey)
    throws Exception
  {
    byte[] keyBytes = org.apache.commons.codec.binary.Base64.decodeBase64(privateKey);
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
    Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
    cipher.init(1, privateK);
    int inputLen = data.length;
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int offSet = 0;

    int i = 0;

    while (inputLen - offSet > 0)
    {
      byte[] cache;
      if (inputLen - offSet > 117)
        cache = cipher.doFinal(data, offSet, 117);
      else {
        cache = cipher.doFinal(data, offSet, inputLen - offSet);
      }
      out.write(cache, 0, cache.length);
      ++i;
      offSet = i * 117;
    }
    byte[] encryptedData = out.toByteArray();
    out.close();
    return encryptedData;
  }

  private static byte[] getContentBytes(String content, String charset)
  {
    if ((charset == null) || ("".equals(charset)))
      return content.getBytes();
    try
    {
      return content.getBytes(charset);
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
    }
  }

  public static String getPrivateKey(Map<String, Object> keyMap)
    throws Exception
  {
    Key key = (Key)keyMap.get("RSAPrivateKey");
    return org.apache.commons.codec.binary.Base64.encodeBase64String(key.getEncoded());
  }

  public static String getPublicKey(Map<String, Object> keyMap)
    throws Exception
  {
    Key key = (Key)keyMap.get("RSAPublicKey");
    return org.apache.commons.codec.binary.Base64.encodeBase64String(key.getEncoded());
  }
}