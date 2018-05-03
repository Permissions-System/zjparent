/*     */ package com.zjgt.p2p.async.domain;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class AsyncTask
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1428166893152381384L;
/*     */   private Object serviceObject;
/*     */   private String method;
/*     */   private Object[] params;
/*     */   private Class<?>[] paramTypes;
/*     */   private Object callbackObject;
/*     */   private String callbackMethod;
/*     */   private Map<String, String> attachments;
/*     */ 
/*     */   public Object getServiceObject()
/*     */   {
/*  60 */     return this.serviceObject;
/*     */   }
/*     */ 
/*     */   public void setServiceObject(Object serviceObject)
/*     */   {
/*  68 */     this.serviceObject = serviceObject;
/*     */   }
/*     */ 
/*     */   public String getMethod()
/*     */   {
/*  75 */     return this.method;
/*     */   }
/*     */ 
/*     */   public void setMethod(String method)
/*     */   {
/*  83 */     this.method = method;
/*     */   }
/*     */ 
/*     */   public Object[] getParams()
/*     */   {
/*  90 */     return this.params;
/*     */   }
/*     */ 
/*     */   public void setParams(Object[] params)
/*     */   {
/*  98 */     this.params = params;
/*     */   }
/*     */ 
/*     */   public Class<?>[] getParamTypes()
/*     */   {
/* 105 */     return this.paramTypes;
/*     */   }
/*     */ 
/*     */   public void setParamTypes(Class<?>[] paramTypes)
/*     */   {
/* 113 */     this.paramTypes = paramTypes;
/*     */   }
/*     */ 
/*     */   public Object getCallbackObject()
/*     */   {
/* 120 */     return this.callbackObject;
/*     */   }
/*     */ 
/*     */   public void setCallbackObject(Object callbackObject)
/*     */   {
/* 128 */     this.callbackObject = callbackObject;
/*     */   }
/*     */ 
/*     */   public String getCallbackMethod()
/*     */   {
/* 135 */     return this.callbackMethod;
/*     */   }
/*     */ 
/*     */   public void setCallbackMethod(String callbackMethod)
/*     */   {
/* 143 */     this.callbackMethod = callbackMethod;
/*     */   }
/*     */ 
/*     */   public boolean hasCallback()
/*     */   {
/* 152 */     return ((this.callbackObject != null) && (this.callbackMethod != null) && (this.callbackMethod.trim().length() != 0));
/*     */   }
/*     */ 
/*     */   public Map<String, String> getAttachments() {
/* 156 */     return this.attachments;
/*     */   }
/*     */ 
/*     */   public void setAttachments(Map<String, String> attachments) {
/* 160 */     this.attachments = attachments;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.async.domain.AsyncTask
 * JD-Core Version:    0.5.3
 */