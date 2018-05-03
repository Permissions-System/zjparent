/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.regex.Matcher;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class DefaultSerialFormater
/*    */   implements SerialFormater
/*    */ {
/*    */   private String serialPattern;
/*    */   private char fillin;
/*    */   private boolean fillBefore;
/*    */ 
/*    */   public DefaultSerialFormater()
/*    */   {
/* 21 */     this.serialPattern = "[\\[\\(](.+?)[\\]\\)]";
/* 22 */     this.fillin = '0';
/* 23 */     this.fillBefore = true;
/*    */   }
/*    */ 
/*    */   public Map<String, ItemFormat> getTemplateFormats(String template)
/*    */   {
/* 34 */     Matcher matcher = getMatcher(template, this.serialPattern);
/* 35 */     Map formats = new HashMap();
/* 36 */     while (matcher.find()) {
/* 37 */       String item = matcher.group(1);
/* 38 */       String group = matcher.group();
/* 39 */       boolean isFunction = group.startsWith("(");
/* 40 */       ItemFormat format = ItemFormat.parse(item, isFunction);
/* 41 */       formats.put(format.key, format);
/*    */     }
/* 43 */     return formats;
/*    */   }
/*    */ 
/*    */   public String format(Map<String, Object> formatedParams, String template)
/*    */   {
/* 50 */     Matcher matcher = getMatcher(template, this.serialPattern);
/* 51 */     StringBuffer buffer = new StringBuffer();
/* 52 */     while (matcher.find()) {
/* 53 */       String item = matcher.group(1);
/* 54 */       String group = matcher.group();
/* 55 */       boolean isFunction = group.startsWith("(");
/* 56 */       ItemFormat format = ItemFormat.parse(item, isFunction);
/* 57 */       format.fillin = this.fillin;
/* 58 */       Object value = formatedParams.get(format.key);
/* 59 */       matcher.appendReplacement(buffer, format.format(value));
/*    */     }
/* 61 */     matcher.appendTail(buffer);
/* 62 */     return buffer.toString();
/*    */   }
/*    */ 
/*    */   public String format(Object value, ItemFormat fmt)
/*    */   {
/* 69 */     return fmt.format(value, this.fillin, this.fillBefore);
/*    */   }
/*    */ 
/*    */   private Matcher getMatcher(String template, String patternStr)
/*    */   {
/* 79 */     Pattern pattern = Pattern.compile(patternStr);
/* 80 */     return pattern.matcher(template);
/*    */   }
/*    */ 
/*    */   public void setFillin(char fillin) {
/* 84 */     this.fillin = fillin;
/*    */   }
/*    */ 
/*    */   public void setFillBefore(boolean fillBefore) {
/* 88 */     this.fillBefore = fillBefore;
/*    */   }
/*    */ 
/*    */   public void setSerialPattern(String serialPattern) {
/* 92 */     this.serialPattern = serialPattern;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.DefaultSerialFormater
 * JD-Core Version:    0.5.3
 */