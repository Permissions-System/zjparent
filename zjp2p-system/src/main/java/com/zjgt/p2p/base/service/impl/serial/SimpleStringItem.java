/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ public class SimpleStringItem
/*    */   implements SerialItem
/*    */ {
/*    */   private String value;
/*    */ 
/*    */   public SimpleStringItem(String value)
/*    */   {
/* 19 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getString()
/*    */   {
/* 26 */     return ((this.value == null) ? "" : this.value);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.SimpleStringItem
 * JD-Core Version:    0.5.3
 */