/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.httpclient.HttpClient;
/*     */ import org.apache.commons.httpclient.HttpException;
/*     */ import org.apache.commons.httpclient.NameValuePair;
/*     */ import org.apache.commons.httpclient.methods.PostMethod;
/*     */ import org.apache.commons.httpclient.params.HttpClientParams;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.DocumentHelper;
/*     */ import org.dom4j.Element;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class SmsUtil
/*     */ {
/*     */   Logger logger;
/*     */ 
/*     */   public SmsUtil()
/*     */   {
/*  26 */     this.logger = LoggerFactory.getLogger(SmsUtil.class);
/*     */   }
/*     */ 
/*     */   public void sendbyweixin2(String phone, String content)
/*     */   {
/*  36 */     this.logger.info("sendbyweixin2 {},{}", phone, content);
/*  37 */     HttpClient client = new HttpClient();
/*  38 */     PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
/*  39 */     client.getParams().setContentCharset("UTF-8");
/*  40 */     method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
/*     */ 
/*  42 */     NameValuePair[] data = { new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), new NameValuePair("mobile", phone), new NameValuePair("content", content) };
/*     */ 
/*  46 */     method.setRequestBody(data);
/*     */     try {
/*  48 */       client.executeMethod(method);
/*  49 */       String SubmitResult = method.getResponseBodyAsString();
/*  50 */       this.logger.info(SubmitResult);
/*  51 */       Document doc = DocumentHelper.parseText(SubmitResult);
/*  52 */       Element root = doc.getRootElement();
/*  53 */       String code = root.elementText("code");
/*  54 */       String msg = root.elementText("msg");
/*  55 */       String smsid = root.elementText("smsid");
/*  56 */       if (code == "2")
/*  57 */         this.logger.info("短信发送成功");
/*     */     }
/*     */     catch (Exception e) {
/*  60 */       throw new RuntimeException("短信发送失败");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendbyweixin(String phone, String content)
/*     */     throws IOException
/*     */   {
/*  72 */     this.logger.info("sendbyweixin {},{}", phone, content);
/*  73 */     HttpClient client = new HttpClient();
/*  74 */     PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
/*  75 */     client.getParams().setContentCharset("UTF-8");
/*  76 */     method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");
/*     */ 
/*  78 */     String con = "您的手机验证码：【" + content + "】，有效时间10分钟，感谢使用百富网，如有疑问或非本人操作请联系400-9616-588。";
/*  79 */     NameValuePair[] data = { new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), new NameValuePair("mobile", phone), new NameValuePair("content", con) };
/*     */ 
/*  84 */     method.setRequestBody(data);
/*     */     try {
/*  86 */       client.executeMethod(method);
/*  87 */       String SubmitResult = method.getResponseBodyAsString();
/*  88 */       this.logger.info(SubmitResult);
/*  89 */       Document doc = DocumentHelper.parseText(SubmitResult);
/*  90 */       Element root = doc.getRootElement();
/*  91 */       String code = root.elementText("code");
/*  92 */       String msg = root.elementText("msg");
/*  93 */       String smsid = root.elementText("smsid");
/*  94 */       if (code == "2")
/*  95 */         this.logger.info("短信发送成功");
/*     */     }
/*     */     catch (Exception e) {
/*  98 */       throw new RuntimeException("短信发送失败");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void sendbymandao(String mobile, String content)
/*     */     throws Exception
/*     */   {
/* 111 */     this.logger.info("sendbymandao {},{}", mobile, content);
/* 112 */     String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";
/*     */ 
/* 114 */     List params = new ArrayList();
/* 115 */     params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));
/*     */ 
/* 118 */     params.add(new NameValuePair("pwd", "32D67380AC09E360A7A99090AD63AB05"));
/* 119 */     params.add(new NameValuePair("mobile", mobile));
/* 120 */     params.add(new NameValuePair("content", URLEncoder.encode("您的验证码是:" + content + ",请不要把验证码泄露给其他人。【百富网】", "utf-8")));
/* 121 */     params.add(new NameValuePair("ext", ""));
/* 122 */     params.add(new NameValuePair("stime", ""));
/* 123 */     params.add(new NameValuePair("rrid", ""));
/* 124 */     params.add(new NameValuePair("msgfmt", ""));
/* 125 */     String result = request(url, (NameValuePair[])params.toArray(new NameValuePair[params.size()]));
/* 126 */     Document doc = DocumentHelper.parseText(result);
/* 127 */     Element root = doc.getRootElement();
/* 128 */     String code = root.elementText("code");
/* 129 */     String msg = root.elementText("msg");
/* 130 */     String smsid = root.elementText("smsid");
/* 131 */     if (code == "2") {
/* 132 */       System.out.println("短信提交成功");
/* 133 */       this.logger.info("短信发送成功");
/*     */     }
/* 135 */     System.out.println(result);
/*     */   }
/*     */ 
/*     */   public void sendbymandao2(String mobile, String content)
/*     */     throws Exception
/*     */   {
/* 146 */     this.logger.info("sendbymandao2 {},{}", mobile, content);
/* 147 */     String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";
/*     */ 
/* 149 */     List params = new ArrayList();
/* 150 */     params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));
/*     */ 
/* 153 */     params.add(new NameValuePair("pwd", "32D67380AC09E360A7A99090AD63AB05"));
/* 154 */     params.add(new NameValuePair("mobile", mobile));
/* 155 */     params.add(new NameValuePair("content", URLEncoder.encode(content + "【百富网】", "utf-8")));
/* 156 */     params.add(new NameValuePair("ext", ""));
/* 157 */     params.add(new NameValuePair("stime", ""));
/* 158 */     params.add(new NameValuePair("rrid", ""));
/* 159 */     params.add(new NameValuePair("msgfmt", ""));
/* 160 */     String result = request(url, (NameValuePair[])params.toArray(new NameValuePair[params.size()]));
/* 161 */     Document doc = DocumentHelper.parseText(result);
/* 162 */     Element root = doc.getRootElement();
/* 163 */     String code = root.elementText("code");
/* 164 */     String msg = root.elementText("msg");
/* 165 */     String smsid = root.elementText("smsid");
/* 166 */     if (code == "2") {
/* 167 */       System.out.println("短信提交成功");
/* 168 */       this.logger.info("短信发送成功");
/*     */     }
/* 170 */     System.out.println(result);
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 186 */     String mobile = "13916594637";
/* 187 */     SmsUtil smsutil = new SmsUtil();
/* 188 */     smsutil.sendbymandao(mobile, "测试，你好,mandao");
/* 189 */     smsutil.sendbyweixin(mobile, "测试，你好,weixin");
/*     */   }
/*     */ 
/*     */   public static String request(String url, NameValuePair[] params)
/*     */   {
/* 194 */     String result = null;
/*     */ 
/* 196 */     HttpClient client = new HttpClient();
/*     */ 
/* 198 */     PostMethod postMethod = new PostMethod(url);
/*     */ 
/* 200 */     postMethod.setRequestBody(params);
/*     */ 
/* 202 */     int statusCode = 0;
/*     */     try {
/* 204 */       statusCode = client.executeMethod(postMethod);
/*     */     } catch (HttpException e) {
/*     */     }
/*     */     catch (IOException e) {
/*     */     }
/*     */     try {
/* 210 */       if (statusCode == 200) {
/* 211 */         result = postMethod.getResponseBodyAsString();
/* 212 */         return result;
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/*     */     }
/* 217 */     postMethod.releaseConnection();
/* 218 */     return result;
/*     */   }
/*     */ 
/*     */   public String getMD5(String sourceStr) throws UnsupportedEncodingException {
/* 222 */     String resultStr = "";
/*     */     try {
/* 224 */       byte[] temp = sourceStr.getBytes();
/* 225 */       MessageDigest md5 = MessageDigest.getInstance("MD5");
/* 226 */       md5.update(temp);
/*     */ 
/* 228 */       byte[] b = md5.digest();
/* 229 */       for (int i = 0; i < b.length; ++i) {
/* 230 */         char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */ 
/* 232 */         char[] ob = new char[2];
/* 233 */         ob[0] = digit[(b[i] >>> 4 & 0xF)];
/* 234 */         ob[1] = digit[(b[i] & 0xF)];
/* 235 */         resultStr = resultStr + new String(ob);
/*     */       }
/* 237 */       return resultStr;
/*     */     } catch (NoSuchAlgorithmException e) {
/* 239 */       e.printStackTrace(); }
/* 240 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.SmsUtil
 * JD-Core Version:    0.5.3
 */