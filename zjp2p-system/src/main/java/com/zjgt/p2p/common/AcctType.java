/*    */ package com.zjgt.p2p.common;
/*    */ 
/*    */ public enum AcctType
/*    */ {
/*  5 */   BASIC, GIFT, COMMISSION;
/*    */ 
/*    */   private int key;
/*    */   private String value;
/*    */ 
/*    */   public int getKey()
/*    */   {
/* 26 */     return this.key;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 30 */     return this.value;
/*    */   }
/*    */ 
/*    */   public static String getBidStatus(int key) {
/* 34 */     for (AcctType bidStatus : values()) {
/* 35 */       if (bidStatus.key == key)
/* 36 */         return bidStatus.value;
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.AcctType
 * JD-Core Version:    0.5.3
 */