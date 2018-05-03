/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Properties;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.util.ResourceUtils;
/*     */ 
/*     */ public class SystemUtils
/*     */ {
/*  23 */   private static final Logger logger = LoggerFactory.getLogger(SystemUtils.class);
/*     */   private static Properties props;
/*  25 */   private static String[] propertyFiles = { "config.properties" };
/*  26 */   private static boolean isDevMode = false;
/*     */ 
/*     */   public static String getProp(String prop)
/*     */   {
/*  69 */     return getProp(prop, null);
/*     */   }
/*     */ 
/*     */   public static String getProp(String prop, String defaultValue)
/*     */   {
/*  80 */     return props.getProperty(prop, defaultValue);
/*     */   }
/*     */ 
/*     */   public static boolean getBooleanProp(String prop, boolean defaultValue)
/*     */   {
/*  91 */     String value = props.getProperty(prop);
/*  92 */     if (value != null) {
/*  93 */       return Boolean.parseBoolean(value);
/*     */     }
/*  95 */     return defaultValue;
/*     */   }
/*     */ 
/*     */   public static boolean isDevMode()
/*     */   {
/* 100 */     return isDevMode;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  28 */     InputStream ins = null;
/*  29 */     props = new Properties();
/*     */ 
/*  31 */     for (String propertyFile : propertyFiles) {
/*     */       try {
/*  33 */         Properties props2 = new Properties();
/*  34 */         ins = SystemUtils.class.getResourceAsStream("/" + propertyFile);
/*  35 */         props2.load(ins);
/*  36 */         props.putAll(props2);
/*  37 */         if (logger.isDebugEnabled())
/*  38 */           logger.debug("Load " + propertyFile + " success!");
/*     */       }
/*     */       catch (IOException e) {
/*  41 */         logger.error("Load " + propertyFile + " from classes Fail!", e);
/*     */         try {
/*  43 */           File f = ResourceUtils.getFile("jar:" + propertyFile);
/*  44 */           if ((f != null) && (f.exists())) {
/*  45 */             ins = new FileInputStream(f);
/*     */           }
/*  47 */           props.load(ins);
/*     */         } catch (Exception e1) {
/*  49 */           logger.error("Load classpath system.properties Fail!", e1);
/*     */         }
/*     */       } finally {
/*  52 */         IOUtils.closeQuietly(ins);
/*     */       }
/*     */     }
/*     */ 
/*  56 */     if (props.getProperty("system.devMode") != null)
/*  57 */       isDevMode = Boolean.parseBoolean(props.getProperty("system.devMode"));
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.SystemUtils
 * JD-Core Version:    0.5.3
 */