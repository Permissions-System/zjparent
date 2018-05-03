package com.zjgt.p2p.async.util;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.SpringContextUtil;

public class AsyncReflectUtil
{
  public static final int PRIORITY_HIGH = 9;
  public static final int PRIORITY_DEFAULT = 4;
  public static final int PRIORITY_LOW = 1;
  private static final Map<MethodInfo, Class<?>[]> METHOD_CACHE_MAP = new ConcurrentHashMap();

  private static final Logger LOGGER = LoggerFactory.getLogger(AsyncReflectUtil.class);

  public static void printMethodCacheMap()
  {
    Iterator it = METHOD_CACHE_MAP.keySet().iterator();
    while (it.hasNext()) {
      MethodInfo methodInfo = (MethodInfo)it.next();
      LOGGER.info("------------------");
      LOGGER.info("hashCode:\t" + methodInfo.hashCode());
      LOGGER.info("clazz:\t" + methodInfo.clazz);
      LOGGER.info("methodName:\t" + methodInfo.methodName);
      for (Class clazz : methodInfo.paramTypes)
        LOGGER.info("paramType:\t" + clazz);
    }
  }

  public static boolean checkTargetMethod(Object targetObject, String methodName, Class<?>[] paramTypes)
  {
    MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);

    return checkTargetMethod(methodInfo);
  }

  private static boolean checkTargetMethod(MethodInfo methodInfo)
  {
    return (getTargetMethod(methodInfo) != null);
  }

  public static Method getTargetMethod(Object targetObject, String methodName, Class<?>[] paramTypes)
  {
    MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);

    return getTargetMethod(methodInfo);
  }

  private static Method getTargetMethod(MethodInfo methodInfo)
  {
    Method method = null;
    try {
      if (methodInfo.methodName.length() == 0) {
        return null;
      }
      method = methodInfo.clazz.getMethod(methodInfo.methodName, methodInfo.paramTypes);
      if (method == null)
        method = getMethod(methodInfo);
    }
    catch (Exception e) {
      method = getMethod(methodInfo);
    }
    return method;
  }

  public static Object getTargetObject(Object tagerObject)
  {
    if (tagerObject == null) {
      throw new BusinessException("异步处理服务对象不能为空");
    }

    Object target = null;
    if (tagerObject.getClass().isAssignableFrom(String.class)) {
      String beanName = tagerObject.toString();
      if ((beanName == null) || (beanName.trim().length() == 0)) {
        throw new BusinessException("异步处理服务对象不能为空");
      }

      target = SpringContextUtil.getBean(beanName);
    } else if (tagerObject instanceof Class) {
      Class className = (Class)tagerObject;

      target = SpringContextUtil.getBean(className);
    } else {
      target = tagerObject;
    }
    if (target == null) {
      throw new BusinessException("查无异步处理服务对象");
    }
    return target;
  }

  public static Class<?> getTargetClass(Object tagerObject)
  {
    if (tagerObject == null) {
      throw new BusinessException("异步处理服务对象不能为空");
    }

    Class target = null;
    if (tagerObject.getClass().isAssignableFrom(String.class)) {
      String beanName = tagerObject.toString();
      if ((beanName == null) || (beanName.trim().length() == 0)) {
        throw new BusinessException("异步处理服务对象不能为空");
      }

      target = SpringContextUtil.getBean(beanName).getClass();
    } else if (tagerObject instanceof Class) {
      target = (Class)tagerObject;
    } else {
      target = tagerObject.getClass();
    }
    if (target == null) {
      throw new BusinessException("异步处理服务对象不能为空");
    }
    return target;
  }

  public static Object covertToMsgInfo(Object tagerObject)
  {
    if (tagerObject == null) {
      throw new BusinessException("target service is null");
    }

    if (tagerObject.getClass().isAssignableFrom(String.class))
      return tagerObject;
    if (tagerObject instanceof Class) {
      return ((Class)tagerObject);
    }

    return tagerObject.getClass();
  }

  public static Class<?>[] getParamClassType(Object targetObject, String methodName, Object[] params)
  {
    if ((params == null) || (params.length == 0)) {
      return new Class[0];
    }
    Class[] paramTypes = new Class[params.length];
    for (int i = 0; i < params.length; ++i) {
      paramTypes[i] = ((params[i] == null) ? null : params[i].getClass());
    }

    MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);

    Class[] result = (Class[])METHOD_CACHE_MAP.get(methodInfo);
    if (result != null) {
      return result;
    }

    Method method = getTargetMethod(methodInfo);
    if (method == null) {
      throw new BusinessException("查无服务方法，未指定有效的参数类型");
    }
    return method.getParameterTypes();
  }

  private static Method getMethod(MethodInfo methodInfo)
  {
    Method[] methods = methodInfo.clazz.getMethods();
    Method ideaMethod = null;
    int hitCount = 0;
    for (Method method : methods) {
      Class[] methodParamTypes = method.getParameterTypes();
      methodParamTypes = (methodParamTypes == null) ? new Class[0] : methodParamTypes;

      if (!(method.getName().equals(methodInfo.methodName))) continue; if (methodInfo.paramTypes.length != methodParamTypes.length) {
        continue;
      }

      int i = 0;
      int localCount = 0;

      for (; i < methodInfo.paramTypes.length; ++i) {
        if ((methodInfo.paramTypes[i] == null) || (methodParamTypes[i] == methodInfo.paramTypes[i]))
        {
          ++localCount;
        } else if (!(methodParamTypes[i].isAssignableFrom(methodInfo.paramTypes[i]))) {
            break;
          }
      }

      if ((i == methodInfo.paramTypes.length) && (((ideaMethod == null) || (localCount > hitCount)))) {
        ideaMethod = method;
        hitCount = localCount;
      }
    }
    if (ideaMethod != null)
    {
      METHOD_CACHE_MAP.put(methodInfo, ideaMethod.getParameterTypes());

      MethodInfo info = new MethodInfo(ideaMethod.getDeclaringClass(), ideaMethod.getName(), ideaMethod.getParameterTypes());

      METHOD_CACHE_MAP.put(info, ideaMethod.getParameterTypes());
      return ideaMethod;
    }
    return null;
  }

  private static class MethodInfo
  {
    private final Class<?> clazz;
    private final String methodName;
    private final Class<?>[] paramTypes;

    public MethodInfo(Class<?> clazz, String methodName, Class<?>[] paramTypes)
    {
      this.clazz = clazz;
      this.methodName = methodName;
      this.paramTypes = paramTypes;
    }

    public int hashCode()
    {
      int hashCode = this.clazz.toString().hashCode() + this.methodName.hashCode();
      for (Class paramClazz : this.paramTypes) {
        hashCode += ((paramClazz == null) ? 0 : paramClazz.toString().hashCode());
      }
      return hashCode;
    }

    public boolean equals(Object obj)
    {
      if (this == obj) {
        return true;
      }
      if (obj instanceof MethodInfo) {
        MethodInfo anotherObj = (MethodInfo)obj;
        if ((this.clazz == anotherObj.clazz) && (this.methodName.equals(anotherObj.methodName)) && (this.paramTypes.length == anotherObj.paramTypes.length))
        {
          for (int i = 0; i < this.paramTypes.length; ++i) {
            if ((((this.paramTypes[i] != null) || (anotherObj.paramTypes[i] != null))) && (this.paramTypes[i] != anotherObj.paramTypes[i]))
            {
              return false;
            }
          }
          return true;
        }
      }
      return false;
    }
  }
}