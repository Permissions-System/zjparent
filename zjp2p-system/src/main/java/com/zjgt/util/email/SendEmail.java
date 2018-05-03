/*    */ package com.zjgt.util.email;
/*    */ 
/*    */ import org.apache.commons.mail.DefaultAuthenticator;
/*    */ import org.apache.commons.mail.Email;
/*    */ import org.apache.commons.mail.HtmlEmail;
/*    */ import org.apache.commons.mail.MultiPartEmail;
/*    */ 
/*    */ public class SendEmail
/*    */ {
/*    */   public static boolean sendHtmlEmail(EmailBean bean)
/*    */     throws Exception
/*    */   {
/* 23 */     System.setProperty("mail.smtp.ssl.enable", "");
/* 24 */     System.setProperty("mail.smtp.ssl.socketFactory.class", "");
/* 25 */     System.setProperty("mail.smtp.ssl.socketFactory.fallback", "");
/* 26 */     HtmlEmail email = new HtmlEmail();
/*    */ 
/* 28 */     email.setCharset("UTF-8");
/* 29 */     email.setHostName(bean.getHostName());
/* 30 */     email.setSmtpPort(bean.getSmtpPort().intValue());
/* 31 */     email.setAuthenticator(new DefaultAuthenticator(bean.getAuthName(), bean.getAuthPwd()));
/* 32 */     if (bean.getIsSSL().booleanValue())
/*    */     {
/* 34 */       email.setSslSmtpPort(bean.getSmtpSSLProt());
/* 35 */       System.setProperty("mail.smtp.ssl.enable", "true");
/* 36 */       System.setProperty("mail.smtp.ssl.socketFactory.class", "com.lume.DummySSLSocketFactory");
/* 37 */       System.setProperty("mail.smtp.ssl.socketFactory.fallback", "false");
/*    */     }
/* 39 */     email.setFrom(bean.getSendFrom());
/* 40 */     email.addTo(bean.getAddTo());
/* 41 */     email.setSubject(bean.getTitle());
/* 42 */     email.setHtmlMsg(bean.getContent());
/* 43 */     email.send();
/* 44 */     return true;
/*    */   }
/*    */ 
/*    */   public static boolean sendEmail(EmailBean bean)
/*    */     throws Exception
/*    */   {
/* 51 */     System.setProperty("mail.smtp.ssl.enable", "");
/* 52 */     System.setProperty("mail.smtp.ssl.socketFactory.class", "");
/* 53 */     System.setProperty("mail.smtp.ssl.socketFactory.fallback", "");
/* 54 */     Email email = new MultiPartEmail();
/* 55 */     email.setHostName(bean.getHostName());
/* 56 */     email.setSmtpPort(bean.getSmtpPort().intValue());
/* 57 */     email.setAuthenticator(new DefaultAuthenticator(bean.getAuthName(), bean.getAuthPwd()));
/* 58 */     if (bean.getIsSSL().booleanValue())
/*    */     {
/* 60 */       email.setSslSmtpPort(bean.getSmtpSSLProt());
/* 61 */       System.setProperty("mail.smtp.ssl.enable", "true");
/* 62 */       System.setProperty("mail.smtp.ssl.socketFactory.class", "com.lume.DummySSLSocketFactory");
/* 63 */       System.setProperty("mail.smtp.ssl.socketFactory.fallback", "false");
/*    */     }
/* 65 */     email.setFrom(bean.getSendFrom());
/* 66 */     email.setSubject(bean.getTitle());
/* 67 */     email.setMsg(bean.getContent());
/* 68 */     email.addTo(bean.getAddTo());
/*    */ 
/* 70 */     email.setDebug(true);
/*    */ 
/* 72 */     email.send();
/*    */ 
/* 74 */     return true;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.email.SendEmail
 * JD-Core Version:    0.5.3
 */