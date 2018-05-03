/*    */ package com.zjgt.p2p.base.service.impl.serial;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class CachedSerialCounter
/*    */ {
/* 20 */   private List<Integer> counterList = new ArrayList();
/*    */   private String templateCode;
/*    */ 
/*    */   public CachedSerialCounter(String templateCode)
/*    */   {
/* 29 */     this.templateCode = templateCode;
/*    */   }
/*    */ 
/*    */   public String getTemplateCode() {
/* 33 */     return this.templateCode;
/*    */   }
/*    */ 
/*    */   public void add(int counter)
/*    */   {
/* 42 */     this.counterList.add(Integer.valueOf(counter));
/*    */   }
/*    */ 
/*    */   public Integer popFirst()
/*    */   {
/* 51 */     if (this.counterList.size() != 0) {
/* 52 */       return ((Integer)this.counterList.remove(0));
/*    */     }
/* 54 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.CachedSerialCounter
 * JD-Core Version:    0.5.3
 */