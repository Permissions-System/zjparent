package com.zjgt.thirdpay.sign;

import com.zjgt.thirdpay.util.Constants;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SignAndVerify
{
  private static final Logger logger = LoggerFactory.getLogger(SignAndVerify.class);
  public static final String alg = "SHA1withRSA";
  public static final String KEY_ALGORITHM = "RSA";
  private static transient PrivateKey privateKey;
  private static transient PublicKey publicKey;

  public void init()
  {
    logger.info("key is " + Constants.key);
    logger.info("signType is blank" + Constants.signType);
    if (!(Constants.signType.equals("4"))) return;
    try {
      if (privateKey == null) {
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(Constants.key));
        KeyFactory fact = KeyFactory.getInstance("RSA");
        privateKey = fact.generatePrivate(privateKeySpec);
      }
      if (publicKey == null)
        publicKey = PartnerKeyGenerator.getPublicKey(Constants.sinaCrtFilePath);
    }
    catch (NoSuchAlgorithmException e) {
      throw new UnsupportedOperationException(e);
    } catch (InvalidKeySpecException e) {
      throw new RuntimeException("invalid key", e);
    }
  }

  public String sign(String content)
    throws SignatureException, InvalidKeyException, NoSuchAlgorithmException
  {
    synchronized (SignAndVerify.class) {
      if (privateKey == null) {
        init();
      }
    }
    logger.trace("content will be signed:{}", content);
    Signature signalg = Signature.getInstance("SHA1withRSA");
    signalg.initSign(privateKey);
    signalg.update(content.getBytes(Charsets.UTF_8));
    byte[] signature = signalg.sign();
    return Base64.encodeBase64String(signature);
  }

  public boolean verify(String signature, String content) throws InvalidKeyException, SignatureException, NoSuchAlgorithmException {
    synchronized (SignAndVerify.class) {
      if (publicKey == null) {
        init();
      }
    }
    Signature verifyalg = Signature.getInstance("SHA1withRSA");
    verifyalg.initVerify(publicKey);
    verifyalg.update(content.getBytes(Charsets.UTF_8));
    return verifyalg.verify(Base64.decodeBase64(signature));
  }
}