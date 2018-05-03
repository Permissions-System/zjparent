/*    */ package com.zjgt.p2p.common;
/*    */ 
/*    */ public enum RepaymentWay
/*    */ {
/*  6 */   MONTH, MONTHMONEY, FINISHED;
/*    */ 
/*    */   private int key;
/*    */   private String value;
/*    */ 
/*    */   public int getKey()
/*    */   {
/* 25 */     return this.key;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 29 */     return this.value;
/*    */   }
/*    */ 
/*    */   public static String getValue(int key) {
/* 33 */     if (key == MONTH.key)
/* 34 */       return MONTH.value;
/* 35 */     if (key == MONTHMONEY.key)
/* 36 */       return MONTHMONEY.value;
/* 37 */     if (key == FINISHED.key) {
/* 38 */       return FINISHED.value;
/*    */     }
/* 40 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.RepaymentWay
 * JD-Core Version:    0.5.3
 */