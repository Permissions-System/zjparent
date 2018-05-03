package com.zjgt.p2p.async.domain;

import java.io.Serializable;
import java.util.Map;

public class AsyncTask
  implements Serializable
{
  private static final long serialVersionUID = 1428166893152381384L;
  private Object serviceObject;
  private String method;
  private Object[] params;
  private Class<?>[] paramTypes;
  private Object callbackObject;
  private String callbackMethod;
  private Map<String, String> attachments;

  public Object getServiceObject()
  {
    return this.serviceObject;
  }

  public void setServiceObject(Object serviceObject)
  {
    this.serviceObject = serviceObject;
  }

  public String getMethod()
  {
    return this.method;
  }

  public void setMethod(String method)
  {
    this.method = method;
  }

  public Object[] getParams()
  {
    return this.params;
  }

  public void setParams(Object[] params)
  {
    this.params = params;
  }

  public Class<?>[] getParamTypes()
  {
    return this.paramTypes;
  }

  public void setParamTypes(Class<?>[] paramTypes)
  {
    this.paramTypes = paramTypes;
  }

  public Object getCallbackObject()
  {
    return this.callbackObject;
  }

  public void setCallbackObject(Object callbackObject)
  {
    this.callbackObject = callbackObject;
  }

  public String getCallbackMethod()
  {
    return this.callbackMethod;
  }

  public void setCallbackMethod(String callbackMethod)
  {
    this.callbackMethod = callbackMethod;
  }

  public boolean hasCallback()
  {
    return ((this.callbackObject != null) && (this.callbackMethod != null) && (this.callbackMethod.trim().length() != 0));
  }

  public Map<String, String> getAttachments() {
    return this.attachments;
  }

  public void setAttachments(Map<String, String> attachments) {
    this.attachments = attachments;
  }
}