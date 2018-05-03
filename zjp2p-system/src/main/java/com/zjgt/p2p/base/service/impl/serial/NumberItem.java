/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ import java.text.DecimalFormat;
/*    */ 
/*    */ public class NumberItem
/*    */   implements SerialItem
/*    */ {
/*    */   private final String numberFormat;
/*    */   private final Long number;
/*    */ 
/*    */   public NumberItem(Long number, int length)
/*    */   {
/* 23 */     this.number = number;
/* 24 */     this.numberFormat = StringUtil.repeat('0', length);
/*    */   }
/*    */ 
/*    */   public String getString()
/*    */   {
/* 31 */     if (this.number == null) {
/* 32 */       return "";
/*    */     }
/* 34 */     if (this.numberFormat != null) {
/* 35 */       return new DecimalFormat(this.numberFormat).format(this.number);
/*    */     }
/* 37 */     return String.valueOf(this.number);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.NumberItem
 * JD-Core Version:    0.5.3
 */