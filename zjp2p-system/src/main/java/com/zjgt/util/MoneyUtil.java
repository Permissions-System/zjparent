/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class MoneyUtil
/*     */ {
/*   9 */   private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");
/*     */ 
/*  11 */   private static final char[] RMB_NUMS = "零壹贰叁肆伍陆柒捌玖".toCharArray();
/*  12 */   private static final String[] UNITS = { "元", "角", "分", "整" };
/*  13 */   private static final String[] U1 = { "", "拾", "佰", "仟" };
/*  14 */   private static final String[] U2 = { "", "万", "亿" };
/*     */ 
/*     */   public static String convert(String amount)
/*     */     throws IllegalArgumentException
/*     */   {
/*  24 */     amount = amount.replace(",", "");
/*     */ 
/*  27 */     if (amount.equals("0.00")) {
/*  28 */       throw new IllegalArgumentException("金额不能为零.");
/*     */     }
/*  30 */     Matcher matcher = AMOUNT_PATTERN.matcher(amount);
/*  31 */     if (!(matcher.find())) {
/*  32 */       throw new IllegalArgumentException("输入金额有误.");
/*     */     }
/*     */ 
/*  35 */     String integer = matcher.group(1);
/*  36 */     String fraction = matcher.group(2);
/*     */ 
/*  38 */     String result = "";
/*  39 */     if (!(integer.equals("0"))) {
/*  40 */       result = new StringBuilder().append(result).append(integer2rmb(integer)).append(UNITS[0]).toString();
/*     */     }
/*  42 */     if (fraction.equals("00"))
/*  43 */       result = new StringBuilder().append(result).append(UNITS[3]).toString();
/*  44 */     else if ((fraction.startsWith("0")) && (integer.equals("0")))
/*  45 */       result = new StringBuilder().append(result).append(fraction2rmb(fraction).substring(1)).toString();
/*     */     else {
/*  47 */       result = new StringBuilder().append(result).append(fraction2rmb(fraction)).toString();
/*     */     }
/*     */ 
/*  50 */     return result;
/*     */   }
/*     */ 
/*     */   private static String fraction2rmb(String fraction)
/*     */   {
/*  55 */     char jiao = fraction.charAt(0);
/*  56 */     char fen = fraction.charAt(1);
/*  57 */     return new StringBuilder().append(RMB_NUMS[(jiao - '0')]).append((jiao > '0') ? UNITS[1] : "").append((fen > '0') ? new StringBuilder().append(RMB_NUMS[(fen - '0')]).append(UNITS[2]).toString() : "").toString();
/*     */   }
/*     */ 
/*     */   private static String integer2rmb(String integer)
/*     */   {
/*  63 */     StringBuilder buffer = new StringBuilder();
/*     */ 
/*  66 */     int i = integer.length() - 1; for (int j = 0; i >= 0; ++j) {
/*  67 */       char n = integer.charAt(i);
/*  68 */       if (n == '0')
/*     */       {
/*  70 */         if ((i < integer.length() - 1) && (integer.charAt(i + 1) != '0')) {
/*  71 */           buffer.append(RMB_NUMS[0]);
/*     */         }
/*     */ 
/*  74 */         if ((j % 4 == 0) && ((
/*  75 */           ((i > 0) && (integer.charAt(i - 1) != '0')) || ((i > 1) && (integer.charAt(i - 2) != '0')) || ((i > 2) && (integer.charAt(i - 3) != '0')))))
/*     */         {
/*  78 */           buffer.append(U2[(j / 4)]);
/*     */         }
/*     */       }
/*     */       else {
/*  82 */         if (j % 4 == 0) {
/*  83 */           buffer.append(U2[(j / 4)]);
/*     */         }
/*  85 */         buffer.append(U1[(j % 4)]);
/*  86 */         buffer.append(RMB_NUMS[(n - '0')]);
/*     */       }
/*  66 */       --i;
/*     */     }
/*     */ 
/*  89 */     return buffer.reverse().toString();
/*     */   }
/*     */ 
/*     */   public static String moneyFormat(String money)
/*     */   {
/*  97 */     StringBuffer sb = new StringBuffer();
/*  98 */     if (money == null) {
/*  99 */       return "0.00";
/*     */     }
/* 101 */     int index = money.indexOf(".");
/* 102 */     if (index == -1) {
/* 103 */       return new StringBuilder().append(money).append(".00").toString();
/*     */     }
/* 105 */     String s0 = money.substring(0, index);
/* 106 */     String s1 = money.substring(index + 1);
/* 107 */     if (s1.length() == 1)
/* 108 */       s1 = new StringBuilder().append(s1).append("0").toString();
/* 109 */     else if (s1.length() > 2) {
/* 110 */       s1 = s1.substring(0, 2);
/*     */     }
/* 112 */     sb.append(s0);
/* 113 */     sb.append(".");
/* 114 */     sb.append(s1);
/*     */ 
/* 116 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 124 */     System.out.println(convert("134567.12"));
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.MoneyUtil
 * JD-Core Version:    0.5.3
 */