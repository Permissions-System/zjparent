package com.zjgt.p2p.base.util;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class JaxWsFactoryUtils
{
  private static JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();

  private static JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();

  private static Map<String, Client> clientMap = Maps.newHashMap();

  public static <T> T getProxyFactoryBean(Class<T> serviceClass, String address)
  {
    jaxWsProxyFactoryBean.setServiceClass(serviceClass);
    jaxWsProxyFactoryBean.setAddress(address);
    return (T) jaxWsProxyFactoryBean.create();
  }

  public static Object[] invoke(String wsdlUrl, String operationName, Object[] params)
    throws Exception
  {
    return createDynamicClient(wsdlUrl).invoke(operationName, params);
  }

  public static void refreshClient(String wsdlUrl)
  {
    clientMap.put(wsdlUrl, createDynamicClient(wsdlUrl));
  }

  public static void refreshClientMap()
  {
    for (Map.Entry entry : clientMap.entrySet())
      entry.setValue(createDynamicClient((String)entry.getKey()));
  }

  public static Client createDynamicClient(String wsdlUrl)
  {
    if (clientMap.containsKey(wsdlUrl)) {
      return ((Client)clientMap.get(wsdlUrl));
    }

    Client client = jaxWsDynamicClientFactory.createClient(wsdlUrl);
    clientMap.put(wsdlUrl, client);

    return client;
  }

  public static JaxWsProxyFactoryBean getJaxWsProxyFactoryBean()
  {
    return jaxWsProxyFactoryBean;
  }

  public static JaxWsDynamicClientFactory getJaxWsDynamicClientFactory()
  {
    return jaxWsDynamicClientFactory;
  }
}