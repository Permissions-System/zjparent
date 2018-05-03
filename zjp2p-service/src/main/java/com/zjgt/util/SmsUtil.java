package com.zjgt.util;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsUtil
{
  Logger logger;

  public SmsUtil()
  {
    this.logger = LoggerFactory.getLogger(SmsUtil.class);
  }

  public void sendbyweixin2(String phone, String content)
  {
    this.logger.info("sendbyweixin2 {},{}", phone, content);
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
    client.getParams().setContentCharset("UTF-8");
    method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

    NameValuePair[] data = { new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), new NameValuePair("mobile", phone), new NameValuePair("content", content) };

    method.setRequestBody(data);
    try {
      client.executeMethod(method);
      String SubmitResult = method.getResponseBodyAsString();
      this.logger.info(SubmitResult);
      Document doc = DocumentHelper.parseText(SubmitResult);
      Element root = doc.getRootElement();
      String code = root.elementText("code");
      String msg = root.elementText("msg");
      String smsid = root.elementText("smsid");
      if (code == "2")
        this.logger.info("短信发送成功");
    }
    catch (Exception e) {
      throw new RuntimeException("短信发送失败");
    }
  }

  public void sendbyweixin(String phone, String content)
    throws IOException
  {
    this.logger.info("sendbyweixin {},{}", phone, content);
    HttpClient client = new HttpClient();
    PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
    client.getParams().setContentCharset("UTF-8");
    method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

    String con = "您的手机验证码：【" + content + "】，有效时间10分钟，感谢使用百富网，如有疑问或非本人操作请联系400-9616-588。";
    NameValuePair[] data = { new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), new NameValuePair("mobile", phone), new NameValuePair("content", con) };

    method.setRequestBody(data);
    try {
      client.executeMethod(method);
      String SubmitResult = method.getResponseBodyAsString();
      this.logger.info(SubmitResult);
      Document doc = DocumentHelper.parseText(SubmitResult);
      Element root = doc.getRootElement();
      String code = root.elementText("code");
      String msg = root.elementText("msg");
      String smsid = root.elementText("smsid");
      if (code == "2")
        this.logger.info("短信发送成功");
    }
    catch (Exception e) {
      throw new RuntimeException("短信发送失败");
    }
  }

  public void sendbymandao(String mobile, String content)
    throws Exception
  {
    this.logger.info("sendbymandao {},{}", mobile, content);
    String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";

    List params = new ArrayList();
    params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));

    params.add(new NameValuePair("pwd", "32D67380AC09E360A7A99090AD63AB05"));
    params.add(new NameValuePair("mobile", mobile));
    params.add(new NameValuePair("content", URLEncoder.encode("您的验证码是:" + content + ",请不要把验证码泄露给其他人。【百富网】", "utf-8")));
    params.add(new NameValuePair("ext", ""));
    params.add(new NameValuePair("stime", ""));
    params.add(new NameValuePair("rrid", ""));
    params.add(new NameValuePair("msgfmt", ""));
    String result = request(url, (NameValuePair[])params.toArray(new NameValuePair[params.size()]));
    Document doc = DocumentHelper.parseText(result);
    Element root = doc.getRootElement();
    String code = root.elementText("code");
    String msg = root.elementText("msg");
    String smsid = root.elementText("smsid");
    if (code == "2") {
      System.out.println("短信提交成功");
      this.logger.info("短信发送成功");
    }
    System.out.println(result);
  }

  public void sendbymandao2(String mobile, String content)
    throws Exception
  {
    this.logger.info("sendbymandao2 {},{}", mobile, content);
    String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";

    List params = new ArrayList();
    params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));

    params.add(new NameValuePair("pwd", "32D67380AC09E360A7A99090AD63AB05"));
    params.add(new NameValuePair("mobile", mobile));
    params.add(new NameValuePair("content", URLEncoder.encode(content + "【百富网】", "utf-8")));
    params.add(new NameValuePair("ext", ""));
    params.add(new NameValuePair("stime", ""));
    params.add(new NameValuePair("rrid", ""));
    params.add(new NameValuePair("msgfmt", ""));
    String result = request(url, (NameValuePair[])params.toArray(new NameValuePair[params.size()]));
    Document doc = DocumentHelper.parseText(result);
    Element root = doc.getRootElement();
    String code = root.elementText("code");
    String msg = root.elementText("msg");
    String smsid = root.elementText("smsid");
    if (code == "2") {
      System.out.println("短信提交成功");
      this.logger.info("短信发送成功");
    }
    System.out.println(result);
  }

  public static void main(String[] args)
    throws Exception
  {
    String mobile = "13916594637";
    SmsUtil smsutil = new SmsUtil();
    smsutil.sendbymandao(mobile, "测试，你好,mandao");
    smsutil.sendbyweixin(mobile, "测试，你好,weixin");
  }

  public static String request(String url, NameValuePair[] params)
  {
    String result = null;

    HttpClient client = new HttpClient();

    PostMethod postMethod = new PostMethod(url);

    postMethod.setRequestBody(params);

    int statusCode = 0;
    try {
      statusCode = client.executeMethod(postMethod);
    } catch (HttpException e) {
    }
    catch (IOException e) {
    }
    try {
      if (statusCode == 200) {
        result = postMethod.getResponseBodyAsString();
        return result;
      }
    }
    catch (IOException e) {
    }
    postMethod.releaseConnection();
    return result;
  }

  public String getMD5(String sourceStr) throws UnsupportedEncodingException {
    String resultStr = "";
    try {
      byte[] temp = sourceStr.getBytes();
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      md5.update(temp);

      byte[] b = md5.digest();
      for (int i = 0; i < b.length; ++i) {
        char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        char[] ob = new char[2];
        ob[0] = digit[(b[i] >>> 4 & 0xF)];
        ob[1] = digit[(b[i] & 0xF)];
        resultStr = resultStr + new String(ob);
      }
      return resultStr;
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace(); }
    return null;
  }
}