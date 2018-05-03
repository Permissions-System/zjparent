package com.zjgt.thirdpay.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.springfk.pancloud.utils.StringUtils;

public class MapToBean
{
  public static Object getBean(Map<String, Object> resultMap, Class c)
  {
    try
    {
      Object obj = c.newInstance();
      BeanUtils.copyProperties(obj, resultMap);
      return obj;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Object getBeanV2(Map<String, String> resultMap, Class c) {
    try {
      Object obj = c.newInstance();
      BeanUtils.copyProperties(obj, resultMap);
      return obj;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Map<String, String> getMap(Object obj) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Map objectAsMap = new HashMap();
    BeanInfo info = Introspector.getBeanInfo(obj.getClass());
    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
      Method reader = pd.getReadMethod();
      if (reader != null) {
        Object invokeObj = reader.invoke(obj, new Object[0]);
        if ((invokeObj != null) && (invokeObj instanceof String) && (StringUtils.isNotEmpty((String)invokeObj))) {
          objectAsMap.put(pd.getName(), String.valueOf(invokeObj));
        }
      }
    }
    return objectAsMap;
  }
}