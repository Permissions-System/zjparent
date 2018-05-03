/*     */ package com.zjgt.p2p.async.util;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springfk.pancloud.exception.BusinessException;
/*     */ import org.springfk.pancloud.utils.SpringContextUtil;
/*     */ 
/*     */ public class AsyncReflectUtil
/*     */ {
/*     */   public static final int PRIORITY_HIGH = 9;
/*     */   public static final int PRIORITY_DEFAULT = 4;
/*     */   public static final int PRIORITY_LOW = 1;
/*  34 */   private static final Map<MethodInfo, Class<?>[]> METHOD_CACHE_MAP = new ConcurrentHashMap();
/*     */ 
/*  36 */   private static final Logger LOGGER = LoggerFactory.getLogger(AsyncReflectUtil.class);
/*     */ 
/*     */   public static void printMethodCacheMap()
/*     */   {
/*  42 */     Iterator it = METHOD_CACHE_MAP.keySet().iterator();
/*  43 */     while (it.hasNext()) {
/*  44 */       MethodInfo methodInfo = (MethodInfo)it.next();
/*  45 */       LOGGER.info("------------------");
/*  46 */       LOGGER.info("hashCode:\t" + methodInfo.hashCode());
/*  47 */       LOGGER.info("clazz:\t" + methodInfo.clazz);
/*  48 */       LOGGER.info("methodName:\t" + methodInfo.methodName);
/*  49 */       for (Class clazz : methodInfo.paramTypes)
/*  50 */         LOGGER.info("paramType:\t" + clazz);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static boolean checkTargetMethod(Object targetObject, String methodName, Class<?>[] paramTypes)
/*     */   {
/*  68 */     MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);
/*     */ 
/*  71 */     return checkTargetMethod(methodInfo);
/*     */   }
/*     */ 
/*     */   private static boolean checkTargetMethod(MethodInfo methodInfo)
/*     */   {
/*  81 */     return (getTargetMethod(methodInfo) != null);
/*     */   }
/*     */ 
/*     */   public static Method getTargetMethod(Object targetObject, String methodName, Class<?>[] paramTypes)
/*     */   {
/*  97 */     MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);
/*     */ 
/* 100 */     return getTargetMethod(methodInfo);
/*     */   }
/*     */ 
/*     */   private static Method getTargetMethod(MethodInfo methodInfo)
/*     */   {
/* 117 */     Method method = null;
/*     */     try {
/* 119 */       if (methodInfo.methodName.length() == 0) {
/* 120 */         return null;
/*     */       }
/* 122 */       method = methodInfo.clazz.getMethod(methodInfo.methodName, methodInfo.paramTypes);
/* 123 */       if (method == null)
/* 124 */         method = getMethod(methodInfo);
/*     */     }
/*     */     catch (Exception e) {
/* 127 */       method = getMethod(methodInfo);
/*     */     }
/* 129 */     return method;
/*     */   }
/*     */ 
/*     */   public static Object getTargetObject(Object tagerObject)
/*     */   {
/* 146 */     if (tagerObject == null) {
/* 147 */       throw new BusinessException("异步处理服务对象不能为空");
/*     */     }
/*     */ 
/* 150 */     Object target = null;
/* 151 */     if (tagerObject.getClass().isAssignableFrom(String.class)) {
/* 152 */       String beanName = tagerObject.toString();
/* 153 */       if ((beanName == null) || (beanName.trim().length() == 0)) {
/* 154 */         throw new BusinessException("异步处理服务对象不能为空");
/*     */       }
/*     */ 
/* 157 */       target = SpringContextUtil.getBean(beanName);
/* 158 */     } else if (tagerObject instanceof Class) {
/* 159 */       Class className = (Class)tagerObject;
/*     */ 
/* 161 */       target = SpringContextUtil.getBean(className);
/*     */     } else {
/* 163 */       target = tagerObject;
/*     */     }
/* 165 */     if (target == null) {
/* 166 */       throw new BusinessException("查无异步处理服务对象");
/*     */     }
/* 168 */     return target;
/*     */   }
/*     */ 
/*     */   public static Class<?> getTargetClass(Object tagerObject)
/*     */   {
/* 178 */     if (tagerObject == null) {
/* 179 */       throw new BusinessException("异步处理服务对象不能为空");
/*     */     }
/*     */ 
/* 182 */     Class target = null;
/* 183 */     if (tagerObject.getClass().isAssignableFrom(String.class)) {
/* 184 */       String beanName = tagerObject.toString();
/* 185 */       if ((beanName == null) || (beanName.trim().length() == 0)) {
/* 186 */         throw new BusinessException("异步处理服务对象不能为空");
/*     */       }
/*     */ 
/* 189 */       target = SpringContextUtil.getBean(beanName).getClass();
/* 190 */     } else if (tagerObject instanceof Class) {
/* 191 */       target = (Class)tagerObject;
/*     */     } else {
/* 193 */       target = tagerObject.getClass();
/*     */     }
/* 195 */     if (target == null) {
/* 196 */       throw new BusinessException("异步处理服务对象不能为空");
/*     */     }
/* 198 */     return target;
/*     */   }
/*     */ 
/*     */   public static Object covertToMsgInfo(Object tagerObject)
/*     */   {
/* 208 */     if (tagerObject == null) {
/* 209 */       throw new BusinessException("target service is null");
/*     */     }
/*     */ 
/* 212 */     if (tagerObject.getClass().isAssignableFrom(String.class))
/* 213 */       return tagerObject;
/* 214 */     if (tagerObject instanceof Class) {
/* 215 */       return ((Class)tagerObject);
/*     */     }
/*     */ 
/* 218 */     return tagerObject.getClass();
/*     */   }
/*     */ 
/*     */   public static Class<?>[] getParamClassType(Object targetObject, String methodName, Object[] params)
/*     */   {
/* 230 */     if ((params == null) || (params.length == 0)) {
/* 231 */       return new Class[0];
/*     */     }
/* 233 */     Class[] paramTypes = new Class[params.length];
/* 234 */     for (int i = 0; i < params.length; ++i) {
/* 235 */       paramTypes[i] = ((params[i] == null) ? null : params[i].getClass());
/*     */     }
/*     */ 
/* 238 */     MethodInfo methodInfo = new MethodInfo(getTargetClass(targetObject), (methodName == null) ? "" : methodName.trim(), (paramTypes == null) ? new Class[0] : paramTypes);
/*     */ 
/* 242 */     Class[] result = (Class[])METHOD_CACHE_MAP.get(methodInfo);
/* 243 */     if (result != null) {
/* 244 */       return result;
/*     */     }
/*     */ 
/* 247 */     Method method = getTargetMethod(methodInfo);
/* 248 */     if (method == null) {
/* 249 */       throw new BusinessException("查无服务方法，未指定有效的参数类型");
/*     */     }
/* 251 */     return method.getParameterTypes();
/*     */   }
/*     */ 
/*     */   private static Method getMethod(MethodInfo methodInfo)
/*     */   {
/* 264 */     Method[] methods = methodInfo.clazz.getMethods();
/* 265 */     Method ideaMethod = null;
/* 266 */     int hitCount = 0;
/* 267 */     for (Method method : methods) {
/* 268 */       Class[] methodParamTypes = method.getParameterTypes();
/* 269 */       methodParamTypes = (methodParamTypes == null) ? new Class[0] : methodParamTypes;
/*     */ 
/* 271 */       if (!(method.getName().equals(methodInfo.methodName))) continue; if (methodInfo.paramTypes.length != methodParamTypes.length) {
/*     */         continue;
/*     */       }
/*     */ 
/* 275 */       int i = 0;
/* 276 */       int localCount = 0;
/*     */ 
/* 281 */       for (; i < methodInfo.paramTypes.length; ++i) {
/* 282 */         if ((methodInfo.paramTypes[i] == null) || (methodParamTypes[i] == methodInfo.paramTypes[i]))
/*     */         {
/* 284 */           ++localCount;
/*     */         } else if (!(methodParamTypes[i].isAssignableFrom(methodInfo.paramTypes[i]))) {
/*     */             break;
/*     */           }
/*     */       }
/*     */ 
/* 290 */       if ((i == methodInfo.paramTypes.length) && (((ideaMethod == null) || (localCount > hitCount)))) {
/* 291 */         ideaMethod = method;
/* 292 */         hitCount = localCount;
/*     */       }
/*     */     }
/* 295 */     if (ideaMethod != null)
/*     */     {
/* 297 */       METHOD_CACHE_MAP.put(methodInfo, ideaMethod.getParameterTypes());
/*     */ 
/* 299 */       MethodInfo info = new MethodInfo(ideaMethod.getDeclaringClass(), ideaMethod.getName(), ideaMethod.getParameterTypes());
/*     */ 
/* 301 */       METHOD_CACHE_MAP.put(info, ideaMethod.getParameterTypes());
/* 302 */       return ideaMethod;
/*     */     }
/* 304 */     return null;
/*     */   }
/*     */ 
/*     */   private static class MethodInfo
/*     */   {
/*     */     private final Class<?> clazz;
/*     */     private final String methodName;
/*     */     private final Class<?>[] paramTypes;
/*     */ 
/*     */     public MethodInfo(Class<?> clazz, String methodName, Class<?>[] paramTypes)
/*     */     {
/* 330 */       this.clazz = clazz;
/* 331 */       this.methodName = methodName;
/* 332 */       this.paramTypes = paramTypes;
/*     */     }
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 337 */       int hashCode = this.clazz.toString().hashCode() + this.methodName.hashCode();
/* 338 */       for (Class paramClazz : this.paramTypes) {
/* 339 */         hashCode += ((paramClazz == null) ? 0 : paramClazz.toString().hashCode());
/*     */       }
/* 341 */       return hashCode;
/*     */     }
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 346 */       if (this == obj) {
/* 347 */         return true;
/*     */       }
/* 349 */       if (obj instanceof MethodInfo) {
/* 350 */         MethodInfo anotherObj = (MethodInfo)obj;
/* 351 */         if ((this.clazz == anotherObj.clazz) && (this.methodName.equals(anotherObj.methodName)) && (this.paramTypes.length == anotherObj.paramTypes.length))
/*     */         {
/* 353 */           for (int i = 0; i < this.paramTypes.length; ++i) {
/* 354 */             if ((((this.paramTypes[i] != null) || (anotherObj.paramTypes[i] != null))) && (this.paramTypes[i] != anotherObj.paramTypes[i]))
/*     */             {
/* 356 */               return false;
/*     */             }
/*     */           }
/* 359 */           return true;
/*     */         }
/*     */       }
/* 362 */       return false;
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.async.util.AsyncReflectUtil
 * JD-Core Version:    0.5.3
 */