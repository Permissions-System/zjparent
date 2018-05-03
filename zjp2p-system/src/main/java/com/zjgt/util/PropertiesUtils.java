/*    */ package com.zjgt.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class PropertiesUtils
/*    */ {
/* 21 */   static Properties config = null;
/*    */ 
/* 23 */   static Properties messageConfig = null;
/*    */ 
/* 25 */   static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
/*    */ 
/*    */   public static void load() {
/* 28 */     config = new Properties();
/*    */ 
/* 35 */     InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
/*    */     try {
/* 37 */       config.load(in);
/*    */     } catch (IOException e) {
/* 39 */       logger.error("解析 config.properties 文件失败", e);
/* 40 */       e.printStackTrace();
/*    */     }
/*    */ 
/* 43 */     messageConfig = new Properties();
/* 44 */     InputStream messageIn = PropertiesUtils.class.getClassLoader().getResourceAsStream("message.properties");
/*    */     try {
/* 46 */       messageConfig.load(messageIn);
/*    */     } catch (IOException e) {
/* 48 */       logger.error("解析 config.properties 文件失败", e);
/* 49 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static String getProperties(String propertyName) {
/* 54 */     if (config.get(propertyName) == null) {
/* 55 */       return null;
/*    */     }
/* 57 */     return config.get(propertyName).toString();
/*    */   }
/*    */ 
/*    */   public static String getPropertiesByMessage(String propertyName) {
/* 61 */     if (messageConfig.get(propertyName) == null) {
/* 62 */       return null;
/*    */     }
/* 64 */     return messageConfig.get(propertyName).toString();
/*    */   }
/*    */ 
/*    */   public static String getEmail(String email) throws Exception {
/* 68 */     return getProperties(email);
/*    */   }
/*    */ 
/*    */   public static String getBonus(String propertyName) throws Exception {
/* 72 */     return getProperties(propertyName);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.PropertiesUtils
 * JD-Core Version:    0.5.3
 */