/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ public class FixedStringItem
/*    */   implements SerialItem
/*    */ {
/*    */   public static final int BEFORE = 0;
/*    */   public static final int AFTER = 1;
/*    */   private String value;
/*    */   private Integer length;
/*    */   private char fill;
/*    */   private int type;
/*    */ 
/*    */   public FixedStringItem(String value)
/*    */   {
/* 23 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getString()
/*    */   {
/* 30 */     if (this.value == null) {
/* 31 */       this.value = "";
/*    */     }
/* 33 */     if (this.length == null) {
/* 34 */       return this.value;
/*    */     }
/* 36 */     char[] source = this.value.toCharArray();
/* 37 */     int len = source.length;
/* 38 */     if (len == this.length.intValue()) {
/* 39 */       return this.value;
/*    */     }
/* 41 */     char[] target = new char[this.length.intValue()];
/* 42 */     if (len < this.length.intValue())
/*    */     {
/*    */       int i;
/* 43 */       if (this.type == 0) {
/* 44 */         for (i = 0; i < this.length.intValue() - len; ++i) {
/* 45 */           target[i] = this.fill;
/*    */         }
/* 47 */         System.arraycopy(source, 0, target, this.length.intValue() - len, len);
/*    */       } else {
/* 49 */         for (i = this.length.intValue() - len; i < this.length.intValue(); ++i) {
/* 50 */           target[i] = this.fill;
/*    */         }
/* 52 */         System.arraycopy(source, 0, target, 0, len);
/*    */       }
/* 54 */       return new String(target);
/*    */     }
/* 56 */     if (this.type == 0) {
/* 57 */       return this.value.substring(len - this.length.intValue());
/*    */     }
/* 59 */     return this.value.substring(0, this.length.intValue());
/*    */   }
/*    */ 
/*    */   public void setLength(int length, char fill, int type)
/*    */   {
/* 71 */     this.length = Integer.valueOf(length);
/* 72 */     this.fill = fill;
/* 73 */     this.type = type;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.FixedStringItem
 * JD-Core Version:    0.5.3
 */