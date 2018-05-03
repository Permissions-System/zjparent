/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public abstract class StringUtil
/*    */ {
/*    */   public static String repeat(char chr, int times)
/*    */   {
/* 24 */     char[] chrs = new char[times];
/* 25 */     Arrays.fill(chrs, chr);
/* 26 */     return new String(chrs);
/*    */   }
/*    */ 
/*    */   public static boolean isEmpty(String str)
/*    */   {
/* 34 */     return ((null == str) || ("".equals(str)) || ("null".equalsIgnoreCase(str)));
/*    */   }
/*    */ 
/*    */   public static String subString(String input, int length, String encoding)
/*    */     throws UnsupportedEncodingException
/*    */   {
/* 59 */     int characterNum = input.length();
/*    */ 
/* 61 */     int total = 0;
/*    */ 
/* 63 */     int len = 0;
/*    */ 
/* 65 */     for (int i = 0; i < characterNum; ++i)
/*    */     {
/* 67 */       String temp = input.substring(i, i + 1);
/* 68 */       int temp_len = temp.getBytes(encoding).length;
/*    */ 
/* 70 */       total += temp_len;
/*    */ 
/* 72 */       if (total > length) break;
/* 73 */       ++len;
/*    */     }
/*    */ 
/* 80 */     return input.substring(0, len);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.StringUtil
 * JD-Core Version:    0.5.3
 */