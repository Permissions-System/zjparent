/*    */ package com.zjgt.p2p.common;
/*    */ 
/*    */ public enum BidStatus
/*    */ {
/*  5 */   INVESTING, INVESTED_ACCR, INVESTED, FINISHED, UNFULL, BADBIDING, BADBID, UNPUBLISH;
/*    */ 
/*    */   private int key;
/*    */   private String value;
/*    */ 
/*    */   public int getKey()
/*    */   {
/* 36 */     return this.key;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 40 */     return this.value;
/*    */   }
/*    */ 
/*    */   public static String getBidStatus(int key) {
/* 44 */     for (BidStatus bidStatus : values()) {
/* 45 */       if (bidStatus.key == key)
/* 46 */         return bidStatus.value;
/*    */     }
/* 48 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.BidStatus
 * JD-Core Version:    0.5.3
 */