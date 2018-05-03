package com.zjgt.thirdpay.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil
{
  static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

  public static String sendSSLPostRequest(String reqURL, Map<String, String> params)
    throws Exception
  {
    long responseLength = 0L;
    String responseContent = null;
    HttpClient httpClient = new DefaultHttpClient();
    X509TrustManager xtm = new X509TrustManager() {
      public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
      }

      public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
      }

      public X509Certificate[] getAcceptedIssuers() {
        return null;
      }
    };
    try
    {
      SSLContext ctx = SSLContext.getInstance("TLS");

      ctx.init(null, new TrustManager[] { xtm }, null);

      SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);

      httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));

      HttpPost httpPost = new HttpPost(reqURL);
      List formParams = new ArrayList();
      for (Map.Entry entry : params.entrySet()) {
        formParams.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue()));
      }
      httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));

      HttpResponse response = httpClient.execute(httpPost);
      HttpEntity entity = response.getEntity();
      if (null != entity) {
        responseLength = entity.getContentLength();
        responseContent = EntityUtils.toString(entity, "UTF-8");
        EntityUtils.consume(entity);
      }
      PayLogUtil.log("请求地址: " + httpPost.getURI());
      PayLogUtil.log("响应状态: " + response.getStatusLine());
      PayLogUtil.log("响应长度: " + responseLength);
    } catch (Exception e) {
    }
    finally {
      httpClient.getConnectionManager().shutdown();
    }
    return responseContent;
  }
}