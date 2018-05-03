/*     */ package com.zjgt.util.email;
/*     */ 
/*     */ public class EmailBean
/*     */ {
/*     */   private String hostName;
/*     */   private String authName;
/*     */   private String authPwd;
/*     */   private Integer smtpPort;
/*     */   private String smtpSSLProt;
/*     */   private Boolean isSSL;
/*     */   private String sendFrom;
/*     */   private String addTo;
/*     */   private String content;
/*     */   private String title;
/*     */ 
/*     */   public EmailBean()
/*     */   {
/*  17 */     this.isSSL = Boolean.FALSE;
/*     */   }
/*     */ 
/*     */   public String getAuthName()
/*     */   {
/*  28 */     return this.authName;
/*     */   }
/*     */ 
/*     */   public void setAuthName(String authName) {
/*  32 */     this.authName = authName;
/*     */   }
/*     */ 
/*     */   public String getAuthPwd() {
/*  36 */     return this.authPwd;
/*     */   }
/*     */ 
/*     */   public void setAuthPwd(String authPwd) {
/*  40 */     this.authPwd = authPwd;
/*     */   }
/*     */ 
/*     */   public Integer getSmtpPort() {
/*  44 */     return this.smtpPort;
/*     */   }
/*     */ 
/*     */   public void setSmtpPort(Integer smtpPort) {
/*  48 */     this.smtpPort = smtpPort;
/*     */   }
/*     */ 
/*     */   public String getSmtpSSLProt() {
/*  52 */     return this.smtpSSLProt;
/*     */   }
/*     */ 
/*     */   public void setSmtpSSLProt(String smtpSSLProt) {
/*  56 */     this.smtpSSLProt = smtpSSLProt;
/*     */   }
/*     */ 
/*     */   public Boolean getIsSSL() {
/*  60 */     return this.isSSL;
/*     */   }
/*     */ 
/*     */   public void setIsSSL(Boolean isSSL) {
/*  64 */     this.isSSL = isSSL;
/*     */   }
/*     */ 
/*     */   public String getSendFrom() {
/*  68 */     return this.sendFrom;
/*     */   }
/*     */ 
/*     */   public void setSendFrom(String sendFrom) {
/*  72 */     this.sendFrom = sendFrom;
/*     */   }
/*     */ 
/*     */   public String getAddTo() {
/*  76 */     return this.addTo;
/*     */   }
/*     */ 
/*     */   public void setAddTo(String addTo) {
/*  80 */     this.addTo = addTo;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/*  84 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/*  88 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  92 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  96 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getHostName() {
/* 100 */     return this.hostName;
/*     */   }
/*     */ 
/*     */   public void setHostName(String hostName) {
/* 104 */     this.hostName = hostName;
/*     */   }
/*     */ 
/*     */   public static EmailBean getbean(String email, String context) {
/* 108 */     return getbean("来自百富网的邮件", email, context);
/*     */   }
/*     */ 
/*     */   public static EmailBean getbean(String subject, String email, String context) {
/* 112 */     EmailBean bean = new EmailBean();
/* 113 */     bean.setHostName("smtp.exmail.qq.com");
/* 114 */     bean.setSmtpPort(Integer.valueOf(25));
/* 115 */     bean.setSmtpSSLProt("465");
/* 116 */     bean.setAuthName("service@baifu360.com");
/* 117 */     bean.setAuthPwd("biifoo12345");
/* 118 */     bean.setIsSSL(Boolean.valueOf(false));
/* 119 */     bean.setTitle(subject);
/* 120 */     bean.setContent(context);
/* 121 */     bean.setSendFrom("service@baifu360.com");
/* 122 */     bean.setAddTo(email);
/* 123 */     return bean;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.email.EmailBean
 * JD-Core Version:    0.5.3
 */