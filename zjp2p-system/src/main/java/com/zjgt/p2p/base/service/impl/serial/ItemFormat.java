/*     */ package com.zjgt.p2p.base.service.impl.serial;
/*     */ 
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class ItemFormat
/*     */ {
/*     */   String key;
/*     */   int length;
/*     */   char type;
/*     */   char fillin;
/*     */   boolean fillBefore;
/*     */ 
/*     */   public String getKey()
/*     */   {
/*  27 */     return this.key;
/*     */   }
/*     */ 
/*     */   public int getLength() {
/*  31 */     return this.length;
/*     */   }
/*     */ 
/*     */   public String format(Object value)
/*     */   {
/*  41 */     return format(value, this.fillin);
/*     */   }
/*     */ 
/*     */   public String format(Object value, char fillin)
/*     */   {
/*  51 */     return format(value, fillin, true);
/*     */   }
/*     */ 
/*     */   public String format(Object value, char fillin, boolean fillBefore)
/*     */   {
/*  70 */     if (value == null) {
/*  71 */       return "";
/*     */     }
/*  73 */     if (this.type == 'C') {
/*  74 */       FixedStringItem fsi = new FixedStringItem(String.valueOf(value));
/*  75 */       fsi.setLength(this.length, fillin, (fillBefore) ? 0 : 1);
/*     */ 
/*  77 */       return fsi.getString(); }
/*  78 */     if (this.type == 'N') {
/*  79 */       Long num = Long.valueOf(String.valueOf(value));
/*  80 */       NumberItem ni = new NumberItem(num, this.length);
/*  81 */       return ni.getString(); }
/*  82 */     if (this.type == 'A') {
/*  83 */       return "";
/*     */     }
/*  85 */     return formatDate(value, this.type, this.length);
/*     */   }
/*     */ 
/*     */   private String formatDate(Object date, char type, int len)
/*     */   {
/* 101 */     if (date == null) {
/* 102 */       return "";
/*     */     }
/* 104 */     if (date instanceof String)
/* 105 */       return ((String)date);
/*     */     char target;
/* 108 */     if ((type == 'M') || (type == 'H') || (type == 'm'))
/* 109 */       target = type;
/*     */     else {
/* 111 */       target = Character.toLowerCase(type);
/*     */     }
/* 113 */     String format = StringUtil.repeat(target, len);
/* 114 */     SimpleDateFormat sdf = new SimpleDateFormat(format);
/* 115 */     DateFormatSymbols symbols = new DateFormatSymbols(Locale.US);
/* 116 */     sdf.setDateFormatSymbols(symbols);
/* 117 */     SimpleStringItem ssi = new SimpleStringItem(sdf.format(date));
/* 118 */     return ssi.getString();
/*     */   }
/*     */ 
/*     */   public static final ItemFormat parse(String str, boolean isFunction)
/*     */   {
/* 128 */     if (StringUtil.isEmpty(str)) {
/* 129 */       return null;
/*     */     }
/* 131 */     String[] arr = str.split(",");
/* 132 */     if (arr.length > 1) {
/* 133 */       ItemFormat iformat = new ItemFormat();
/* 134 */       if ((isFunction) && 
/* 135 */         ("DATE".equals(arr[0]))) {
/* 136 */         iformat = new ItemFormatDateFunction(arr[1]);
/*     */       }
/*     */ 
/* 140 */       iformat.key = arr[0];
/* 141 */       iformat.type = arr[1].charAt(0);
/* 142 */       if (iformat.length == 0) {
/* 143 */         iformat.length = Integer.parseInt(arr[1].substring(1).trim());
/*     */       }
/* 145 */       return iformat;
/*     */     }
/* 147 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.ItemFormat
 * JD-Core Version:    0.5.3
 */