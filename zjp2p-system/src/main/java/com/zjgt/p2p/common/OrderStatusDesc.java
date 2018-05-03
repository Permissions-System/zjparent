package com.zjgt.p2p.common;

 public enum OrderStatusDesc
 {
  PreINTEREST, BEWAITED, REDEEMED, NORMAL, TRANSFERING, TRANSFERED, TRANSFERLOSE, TransFered, BadBID;
 
   private int key;
   private String value;
 
   public int getKey()
   {
     return this.key;
   }
 
   public String getValue() {
    return this.value;
   }
 }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.OrderStatusDesc
 * JD-Core Version:    0.5.3
 */