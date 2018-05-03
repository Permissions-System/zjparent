/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ItemFormatDateFunction extends ItemFormat
/*    */ {
/*    */   private String format;
/*    */ 
/*    */   public ItemFormatDateFunction(String format)
/*    */   {
/* 22 */     this.format = format;
/* 23 */     this.length = format.length();
/*    */   }
/*    */ 
/*    */   public String getFormat() {
/* 27 */     return this.format;
/*    */   }
/*    */ 
/*    */   public void setFormat(String format) {
/* 31 */     this.format = format;
/*    */   }
/*    */ 
/*    */   public String format(Object value)
/*    */   {
/* 38 */     SimpleDateFormat df = new SimpleDateFormat(this.format);
/* 39 */     return df.format(new Date());
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.ItemFormatDateFunction
 * JD-Core Version:    0.5.3
 */