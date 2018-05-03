package com.zjgt.p2p.pay.lianlian.pay;

import com.zjgt.thirdpay.lianlian.utils.LLPayUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LLWebPayUtil extends LLPayUtil
{
  static Logger logger = LoggerFactory.getLogger(LLWebPayUtil.class);

  public static String getIpAddr(HttpServletRequest request)
  {
    String ip = request.getHeader("x-forwarded-for");
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
    {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
    {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
    {
      ip = request.getRemoteAddr();
    }
    if ((!(isnull(ip))) && (ip.contains(",")))
    {
      String[] ips = ip.split(",");
      ip = ips[(ips.length - 1)];
    }

    if (!(isnull(ip))) {
      ip = ip.replace(".", "_");
    }
    return ip;
  }

  public static String readReqStr(HttpServletRequest request)
  {
    BufferedReader reader = null;
    StringBuilder sb = new StringBuilder();
    try
    {
      reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));

      String line = null;

      while ((line = reader.readLine()) != null)
      {
        sb.append(line);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally
    {
      try {
        if (null != reader)
        {
          reader.close();
        }
      }
      catch (IOException e)
      {
      }
    }
    return sb.toString();
  }
}