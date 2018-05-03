/*    */ package com.zjgt.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class SafeUtil
/*    */ {
/* 15 */   private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
/*    */ 
/*    */   public static String generatePassword(String inputString)
/*    */   {
/* 20 */     return encodeByMD5(inputString);
/*    */   }
/*    */ 
/*    */   public static boolean validatePassword(String password, String inputString)
/*    */   {
/* 33 */     return (password.equals(encodeByMD5(inputString)));
/*    */   }
/*    */ 
/*    */   public static String returnEncodeByMde(String originString)
/*    */   {
/* 40 */     return encodeByMD5(originString);
/*    */   }
/*    */ 
/*    */   private static String encodeByMD5(String originString)
/*    */   {
/* 45 */     if (originString != null) {
/*    */       try {
/* 47 */         MessageDigest md = MessageDigest.getInstance("MD5");
/*    */ 
/* 49 */         byte[] results = md.digest(originString.getBytes());
/*    */ 
/* 51 */         String resultString = byteArrayToHexString(results);
/* 52 */         String pass = resultString.toUpperCase();
/* 53 */         return pass;
/*    */       } catch (Exception ex) {
/* 55 */         ex.printStackTrace();
/*    */       }
/*    */     }
/* 58 */     return null;
/*    */   }
/*    */ 
/*    */   private static String byteArrayToHexString(byte[] b) {
/* 62 */     StringBuffer resultSb = new StringBuffer();
/* 63 */     for (int i = 0; i < b.length; ++i) {
/* 64 */       resultSb.append(byteToHexString(b[i]));
/*    */     }
/* 66 */     return resultSb.toString();
/*    */   }
/*    */ 
/*    */   private static String byteToHexString(byte b)
/*    */   {
/* 71 */     int n = b;
/* 72 */     if (n < 0)
/* 73 */       n = 256 + n;
/* 74 */     int d1 = n / 16;
/* 75 */     int d2 = n % 16;
/* 76 */     return hexDigits[d1] + hexDigits[d2];
/*    */   }
/*    */ 
/*    */   public static void main(String[] args) {
/* 80 */     String pwd1 = "123";
/* 81 */     String pwd2 = "";
/* 82 */     SafeUtil cipher = new SafeUtil();
/* 83 */     System.out.println("未加密的密码:" + pwd1);
/*    */ 
/* 85 */     pwd2 = generatePassword(pwd1);
/* 86 */     System.out.println("加密后的密码:" + pwd2);
/*    */ 
/* 88 */     System.out.print("验证密码是否下确:");
/* 89 */     if (validatePassword(pwd2, pwd1))
/* 90 */       System.out.println("正确");
/*    */     else
/* 92 */       System.out.println("错误");
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.SafeUtil
 * JD-Core Version:    0.5.3
 */