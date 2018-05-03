/*    */ package com.zjgt.util;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ 
/*    */ public class PoundageUtil
/*    */ {
/*    */   public static double getPoundageForMember(int count, String withdrawal, int times)
/*    */   {
/* 21 */     Double with = Double.valueOf(Double.parseDouble(withdrawal));
/* 22 */     DecimalFormat df = new DecimalFormat("#0.00");
/* 23 */     if (count == 0) {
/* 24 */       return Double.parseDouble(df.format(with.doubleValue() * 0.006D + 2.0D));
/*    */     }
/* 26 */     if ((times > 0) && (times < 4)) {
/* 27 */       return 2.0D;
/*    */     }
/* 29 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   public static double getPoundageForTerrace(int times)
/*    */   {
/* 39 */     return (2 * times);
/*    */   }
/*    */ 
/*    */   public static int getRechargeForMember(int times)
/*    */   {
/* 49 */     return (0 * times);
/*    */   }
/*    */ 
/*    */   public static double getRechargeForTerrace(int withdrawal, int times)
/*    */   {
/* 59 */     return (withdrawal * 0.0025D * times);
/*    */   }
/*    */ 
/*    */   public static double getRechargeForTerraceTwo(int withdrawal, int times)
/*    */   {
/* 69 */     return (withdrawal * 0.006D * times);
/*    */   }
/*    */ 
/*    */   public static double getRechargeForTerraceTwo(int withdrawal)
/*    */   {
/* 79 */     return (withdrawal * 0.02D);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.PoundageUtil
 * JD-Core Version:    0.5.3
 */