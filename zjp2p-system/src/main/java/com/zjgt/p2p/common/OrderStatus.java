/*    */ package com.zjgt.p2p.common;
/*    */ 
/*    */ public enum OrderStatus
/*    */ {
/*  7 */   VALID, UNVALID, FINISHED;
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
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.OrderStatus
 * JD-Core Version:    0.5.3
 */