package com.zjgt.thirdpay.v2.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Tools
{
  public static final String SIGN_VERSION_NAME = "sign_version";
  public static final String SIGN_TYPE_NAME = "sign_type";
  public static final String SIGN_NAME = "sign";

  public static String createLinkString(Map<String, String> params, boolean encode)
  {
    List keys = new ArrayList(params.keySet());
    Collections.sort(keys);
    String prestr = "";
    String charset = (String)params.get("_input_charset");
    for (int i = 0; i < keys.size(); ++i) {
      String key = (String)keys.get(i);
      String value = (String)params.get(key);
      if (encode) {
        try {
          value = URLEncoder.encode(URLEncoder.encode(value, charset), charset);
        } catch (UnsupportedEncodingException e) {
          e.printStackTrace();
        }
      }
      if (i == keys.size() - 1)
        prestr = prestr + key + "=" + value;
      else {
        prestr = prestr + key + "=" + value + "&";
      }
    }

    return prestr;
  }
}