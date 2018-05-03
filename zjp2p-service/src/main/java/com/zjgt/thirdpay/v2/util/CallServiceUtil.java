package com.zjgt.thirdpay.v2.util;

import com.weihui.gateway.httpclient.HttpProtocolHandler;
import com.weihui.gateway.httpclient.HttpRequest;
import com.weihui.gateway.httpclient.HttpResponse;
import com.weihui.gateway.httpclient.HttpResultType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.NameValuePair;

public class CallServiceUtil
{
  public static String sendGet(String url, String param)
  {
    String result = "";
    BufferedReader in = null;
    try {
      String urlNameString = url + "?" + param;
      URL realUrl = new URL(urlNameString);

      URLConnection connection = realUrl.openConnection();

      connection.setRequestProperty("accept", "*/*");
      connection.setRequestProperty("connection", "Keep-Alive");
      connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

      connection.connect();

      Map<String, List<String>> map = connection.getHeaderFields();

      for (String key : map.keySet()) {
        System.out.println(key + "--->" + map.get(key));
      }

      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      String line = null;
      while ((line = in.readLine()) != null)
      {
        result = result + line;
      }
    } catch (Exception e) {
      System.out.println("发送GET请求出现异常！" + e);
      e.printStackTrace();
    }
    finally
    {
      try {
        if (in != null)
          in.close();
      }
      catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    return result;
  }

  public static String sendPost(String url, String param)
  {
    PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
      URL realUrl = new URL(url);

      URLConnection conn = realUrl.openConnection();

      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

      conn.setDoOutput(true);
      conn.setDoInput(true);

      out = new PrintWriter(conn.getOutputStream());

      out.print(param);

      out.flush();

      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String line = null;
      while ((line = in.readLine()) != null)
      {
        result = result + line;
      }
    } catch (Exception e) {
      System.out.println("发送 POST 请求出现异常！" + e);
      e.printStackTrace();
    }
    finally
    {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null)
          in.close();
      }
      catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }

  public static String post(Map<String, String> singled, String url, String charset)
    throws Exception
  {
    HttpRequest request = new HttpRequest(HttpResultType.BYTES);
    request.setCharset(charset);
    request.setMethod("POST");
    request.setParameters(generatNameValuePair(singled, charset));
    request.setUrl(url);

    HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

    HttpResponse response = httpProtocolHandler.execute(request, null, null);

    if (response == null) {
      return null;
    }
    return response.getStringResult();
  }

  private static NameValuePair[] generatNameValuePair(Map<String, String> properties, String charset)
    throws Exception
  {
    NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
    int i = 0;
    for (Map.Entry entry : properties.entrySet()) {
      nameValuePair[(i++)] = new NameValuePair((String)entry.getKey(), URLEncoder.encode((String)entry.getValue(), charset));
    }

    return nameValuePair;
  }
}