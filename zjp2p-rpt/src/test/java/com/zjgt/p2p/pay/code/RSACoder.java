package com.zjgt.p2p.pay.code;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

/** */
/**  
* RSA安全编码组件  
*    
* @version 1.0  
* @since 1.0  
*/
public class RSACoder extends Coder {
    public static final String KEY_ALGORITHM = "RSA";

    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";

    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /** */
    /**  
    * 用私钥对信息生成数字签名  
    *    
    * @param data  
    *            加密数据  
    * @param privateKey  
    *            私钥  
    *    
    * @return  
    * @throws Exception  
    */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /** */
    /**  
    * 校验数字签名  
    *    
    * @param data  
    *            加密数据  
    * @param publicKey  
    *            公钥  
    * @param sign  
    *            数字签名  
    *    
    * @return 校验成功返回true 失败返回false  
    * @throws Exception  
    *    
    */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }

    /** */
    /**  
    * 解密<br>  
    * 用私钥解密 http://www.5a520.cn http://www.feng123.com 
    *    
    * @param data  
    * @param key  
    * @return  
    * @throws Exception  
    */
    public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /** */
    /**  
    * 解密<br>  
    * 用私钥解密  
    *    
    * @param data  
    * @param key  
    * @return  
    * @throws Exception  
    */
    public static byte[] decryptByPublicKey(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /** */
    /**  
    * 加密<br>  
    * 用公钥加密  
    *    
    * @param data  
    * @param key  
    * @return  
    * @throws Exception  
    */
    public static byte[] encryptByPublicKey(byte[] data, String key) throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        return cipher.doFinal(data);
    }

    /** */
    /**  
    * 加密<br>  
    * 用私钥加密  
    *    
    * @param data  
    * @param key  
    * @return  
    * @throws Exception  
    */
    public static byte[] encryptByPrivateKey(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(data);
    }

    /** */
    /**  
    * 取得私钥  
    *    
    * @param keyMap  
    * @return  
    * @throws Exception  
    */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return encryptBASE64(key.getEncoded());
    }

    /** */
    /**  
    * 取得公钥  
    *    
    * @param keyMap  
    * @return  
    * @throws Exception  
    */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /** */
    /**  
    * 初始化密钥  
    *    
    * @return  
    * @throws Exception  
    
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);

        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
     */

    public static Map<String, Object> initKey() throws Exception {
        String key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChjTMfd5UmQjMmNWH/AePHmvJ2joHC8903cM65mWkJfIiHQNNlgrY5/EfwHbD8baXNNa/l2TGYFpED7tlzbPv3Gm4IcwJ4GJVMSErAXZCcxowrdNgtRNLnb04sFVyhs9ofB+NRh22+umnHAJTDzgz/cDXyQh3SPUEn+NhsdzOWgLIbRPj7vWVOhwyHfe13z7T4IhVhUZzhi9+GsZmFgoEYqMG8GnstVoBUrE3Z5UEm0IJETn741yOG1bNufifeA2nfG898R6R70a85RkgxrbvYzYKYF12jgfYgs745Lrd/OiQY2su3J4SVaSKLBZdEZIsvL068stF4cjFlkUlNnfv9AgMBAAECggEAG3r1U0j4KgXgxYMXJFWh9XY6AEjFcfAhlSivQYsC/wYcA0XXr9DIRpzPb9zdGlNcfMfBIAwOD5znFhAvFR9YzPPF+9H0fZFQ9CTn8kj4LHLprQq3Kxwl9BBO79jCZQ8+70BcPqYW2PbEv4EtzRDjzR+9TXRJtlWNG8uMpQax08vTUFSVbI4RhJ9Q3yEu26WQ6NEciDY6SlssV+KqupoAXqxMTF2fL7O8PFYOYVlU8LeHsk3jxoZteV5KoUNi7P6raO4B2/WxVI/2cPLctIjo97tLdhNmHjyHijHp+bgZZH7/C70AJbZhY7u8FFfSWBiHDQF7mc/MCVcIRv33Fn6OgQKBgQDLwUOkMu6Y04M75wVuD/MGC7+A5weOQIwLlGt3RzoLfLyv90IM34ZYYafSnx8G6AOUZVKZFiR65D7QEjF0BNObBUlj2ni4kpKWy5vkJyKpYYohWr3SktgRDAy0lvbCzpu143RYm3FoYFbotoIRlCbaGNsrHbenzu8j8SV0F/XvZQKBgQDK+abQTaRQahgsJnCk9JMAtiTqDmNaB0rPvh9+ns5Q2gA1k8AxAZki5UdKGc4TEWnO366xJrY9uHTPWKvEpiuqTUBOj4oXrJeqpAOLRvJf4os6oQnmg+GEqYQg+ShcYW5PGUqexNmtv78Z9GPFQQfK3P+13tWNNPghbsQ90mpMuQKBgGMEzAN7APriJ2+wCLKBK8BvaySQodpewfBKs6MmyS2V8/ir97xb0GUZKD6yN5jangq65tYgrZ/PVjs17DSOt+spOY4+ONax3G1OC7dn0W9xSHiHKaKw3DIEohQNHWR0lbViEUOSXx2zW+kB8NnsHql01OXyLjNt3EeiRGpTzqAFAoGBALxxjbME8pGJ/ok24wvy2WwmrxzyYMEb1hQLUpgu/iNIUjtrwlp9PlyMe2RLkuxXFWHwf/KOm1GwKBq9GzQGhrGk6RhG4ZFbNrBBd9zd8HafEF5NVrDCLiUJcNdgG12xQ0WCmKnQ3rwWMmj5YYun9YEdLvb+PEvOKrR3bxBqgzBZAoGAec46nB+aOfaZfd8SCT2ACt+ahz1TwYIH2Iym1DasZ08VB0vAX4nIwGj7FvldVfPTFFosJfsIp3olxhRGmH76+CEPVpKHW5fW9wnGR+XjPcn+/JTZExVPoUprjXQfbdk3hLKhq7VQLPVFkJKOkvimjv06RCZolxo8q9+WpDXxats=";
        PublicKey publicKey = PartnerKeyGenerator.getPublicKey("biifoo.crt");

        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(key));
        KeyFactory fact = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = fact.generatePrivate(privateKeySpec);

        Map<String, Object> keyMap = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
}