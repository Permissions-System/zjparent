/*    */ package com.zjgt.util;
/*    */ 
/*    */ public class StringUtil
/*    */ {
/*    */   public static String CheckEnter(String str)
/*    */   {
/* 15 */     return str.replaceAll("\r\n", "</br>");
/*    */   }
/*    */ 
/*    */   public static boolean isEmpty(String str)
/*    */   {
/* 20 */     return ((str == null) || (str.isEmpty()));
/*    */   }
/*    */ 
/*    */   public static boolean isNotEmpty(String str)
/*    */   {
/* 26 */     return (!(isEmpty(str)));
/*    */   }
/*    */ 
/*    */   public static String dislodgeImage(String str) {
/* 30 */     while (str.indexOf("<img") != -1) {
/* 31 */       int begin = str.indexOf("<img");
/* 32 */       int end = str.indexOf(">", begin);
/* 33 */       String image = str.substring(begin, end + 1);
/* 34 */       str = str.replace(image, "");
/* 35 */       str = str.replace("&nbsp;", "");
/*    */     }
/* 37 */     return str;
/*    */   }
/*    */ 
/*    */   public static boolean equalWith(String org, String[] orgs) {
/* 41 */     if (isEmpty(org)) {
/* 42 */       return false;
/*    */     }
/* 44 */     for (String org1 : orgs) {
/* 45 */       if (org.equals(org1)) {
/* 46 */         return true;
/*    */       }
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.StringUtil
 * JD-Core Version:    0.5.3
 */