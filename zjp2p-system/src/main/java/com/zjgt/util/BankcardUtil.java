/*    */ package com.zjgt.util;
/*    */ 
/*    */ public class BankcardUtil
/*    */ {
/*    */   public static boolean checkBankCard(String cardId)
/*    */   {
/* 10 */     char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
/* 11 */     if (bit == 'N') {
/* 12 */       return false;
/*    */     }
/* 14 */     return (cardId.charAt(cardId.length() - 1) == bit);
/*    */   }
/*    */ 
/*    */   public static char getBankCardCheckCode(String nonCheckCodeCardId)
/*    */   {
/* 23 */     if ((nonCheckCodeCardId == null) || (nonCheckCodeCardId.trim().length() == 0) || (!(nonCheckCodeCardId.matches("\\d+"))))
/*    */     {
/* 26 */       return 'N';
/*    */     }
/* 28 */     char[] chs = nonCheckCodeCardId.trim().toCharArray();
/* 29 */     int luhmSum = 0;
/* 30 */     int i = chs.length - 1; for (int j = 0; i >= 0; ++j) {
/* 31 */       int k = chs[i] - '0';
/* 32 */       if (j % 2 == 0) {
/* 33 */         k *= 2;
/* 34 */         k = k / 10 + k % 10;
/*    */       }
/* 36 */       luhmSum += k;
/*    */ 
/* 30 */       --i;
/*    */     }
/*    */ 
/* 38 */     return ((luhmSum % 10 == 0) ? '0' : (char)(10 - (luhmSum % 10) + 48));
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.BankcardUtil
 * JD-Core Version:    0.5.3
 */