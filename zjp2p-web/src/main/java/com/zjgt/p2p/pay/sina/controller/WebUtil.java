package com.zjgt.p2p.pay.sina.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

public class WebUtil
{
  public static Map<String, String> getParameterMap(HttpServletRequest request, boolean isFilter)
  {
    Map properties = request.getParameterMap();
    Map returnMap = new HashMap();
    Iterator entries = properties.entrySet().iterator();
    String name = "";
    String value = "";
    Object valueObj = null;
    
    while (entries.hasNext()) {
      Map.Entry entry = (Map.Entry)entries.next();
      name = (String)entry.getKey();
      String[] values;
      int i;
      if (isFilter) {
        if ((!(name.equals("sign"))) && (!(name.equals("sign_type"))) && (!(name.equals("sign_version"))));
        valueObj = entry.getValue();
        if (null == valueObj) {
          value = "";
        } else if (valueObj instanceof String[]) {
          values = (String[])(String[])valueObj;
          for (i = 0; i < values.length; ++i) {
            value = values[i] + ",";
          }
          value = value.substring(0, value.length() - 1);
        } else {
          value = valueObj.toString();
        }
        returnMap.put(name, value);
      }

      valueObj = entry.getValue();
      if (null == valueObj) {
        value = "";
      } else if (valueObj instanceof String[]) {
        values = (String[])(String[])valueObj;
        for (i = 0; i < values.length; ++i) {
          value = values[i] + ",";
        }
        value = value.substring(0, value.length() - 1);
      } else {
        value = valueObj.toString();
      }
      returnMap.put(name, value);
    }

    return returnMap;
  }
}