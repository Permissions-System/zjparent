package com.zjgt.thirdpay.sign;

import com.zjgt.thirdpay.util.Constants;
import com.zjgt.thirdpay.v2.util.RSA;
import com.zjgt.util.PropertiesUtils;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SignAndVerifyV2
{
  private static final Logger logger = LoggerFactory.getLogger(SignAndVerifyV2.class);
  public static final String alg = "SHA1withRSA";
  public static final String KEY_ALGORITHM = "RSA";
  private static transient PrivateKey privateKey;
  private static transient PublicKey publicKey;
  private static transient String encryptPublicKey;

  @PostConstruct
  public void init()
  {
    logger.info("signType is blank" + Constants.signType);
    encryptPublicKey = PropertiesUtils.getProperties("pay.v2.encryptPublicKey");
    if (!(Constants.signType.equals("4"))) return;
    try {
      if (privateKey == null) {
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(PropertiesUtils.getProperties("pay.v2.private.sign_key")));
        KeyFactory fact = KeyFactory.getInstance("RSA");
        privateKey = fact.generatePrivate(privateKeySpec);
      }
      if (publicKey == null)
        if ("false".equals(PropertiesUtils.getProperties("pay.v2.isCrt"))) {
          byte[] keyBytes = Base64.decodeBase64(PropertiesUtils.getProperties("pay.v2.public.sign_key"));
          X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
          KeyFactory keyFactory = KeyFactory.getInstance("RSA");
          publicKey = keyFactory.generatePublic(keySpec);
        } else {
          publicKey = PartnerKeyGenerator.getPublicKey(PropertiesUtils.getProperties("pay.v2.crt"));
        }
    }
    catch (NoSuchAlgorithmException e) {
      throw new UnsupportedOperationException(e);
    } catch (InvalidKeySpecException e) {
      throw new RuntimeException("invalid key", e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String sign(String content)
    throws SignatureException, InvalidKeyException, NoSuchAlgorithmException
  {
    synchronized (SignAndVerifyV2.class) {
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
    synchronized (SignAndVerifyV2.class) {
      if (publicKey == null) {
        init();
      }
    }
    Signature verifyalg = Signature.getInstance("SHA1withRSA");
    verifyalg.initVerify(publicKey);
    verifyalg.update(content.getBytes(Charsets.UTF_8));
    return verifyalg.verify(Base64.decodeBase64(signature));
  }

  public String create_detail_list_like(String str)
    throws Exception
  {
    String detail_list_like = "";

    String reg = "[|]";

    Map data = new HashMap();

    String[] arys = str.split(reg);
    String arys1 = "";
    int i = 0;

    for (String item : arys) {
      data.put(Integer.valueOf(i), item);
      ++i;
    }
    Iterator s = data.entrySet().iterator();
    String data2 = "";
    while (s.hasNext())
    {
      Map.Entry e = (Map.Entry)s.next();
      String regs = "\\^";
      String split = (String)e.getValue();
      String[] splitarray = split.split(regs);
      int b = 0;

      for (String item1 : splitarray) {
        if ((b == 1) || (b == 2) || (b == 3)) {
          if ((item1 == "") || (item1 == null)) break;
          item1 = RSA.encryptByPublicKey(item1, encryptPublicKey);
          data2 = data2 + "^" + item1;
        }
        else if (b == 0) {
          data2 = data2 + "|" + item1;
        } else {
          data2 = data2 + "^" + item1;
        }

        ++b;
      }
    }
    detail_list_like = data2.substring(1);
    return detail_list_like;
  }
}