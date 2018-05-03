/*     */ package com.zjgt.p2p.common.dict;
/*     */ 
/*     */ public enum AcctTranDef
/*     */ {
/*   6 */   FILL, WITHDRAW, FROZEN, DEDUCT, LOAN, REPAY, YIELD, UNFROZEN, TRANS, ADJUST_ADD, ADJUST_SUBTRACT, PREPAY, COMPENSATE, INCOME, PRINCIPAL, INTEREST, REDEM, FAILEDBID, ALLOT, PLATFILL, PLATWITHDRAW, SELFPRINCIPAL, SELFINTEREST, TRANSPRINCIPAL, TRANSINTEREST, DISBURSEMENTS, BONUS, EVERYINTEREST, LOSEREFUND, PAY_TO_BORROWER, FILL_FEE, WITHDRAW_FEE, REDEM_FEE, PUB_FEE, INFO_FEE, OVERDUE_FEE, UNPAID_FEE, MANAGER_FEE, RISKMGR_FEE, BONUS_FROZEN, BONUS_BIDLOSE_UNFROZEN, BONUS_RANSOM_UNFROZEN, BONUS_DEDUCT, COMMISS_APPROP, COMMISS_RETURN, COMPENSATION, MERCHANT_PROMOTION;
/*     */ 
/*     */   private String tranCode;
/*     */   private String tranName;
/*     */   private String showName;
/*     */   private String amountFlag;
/*     */   private String iOrOut;
/*     */ 
/*     */   public static AcctTranDef tranName(String tranName)
/*     */   {
/*  74 */     if (FILL.tranName.equals(tranName))
/*  75 */       return FILL;
/*  76 */     if (WITHDRAW.tranName.equals(tranName))
/*  77 */       return WITHDRAW;
/*  78 */     if (FROZEN.tranName.equals(tranName))
/*  79 */       return FROZEN;
/*  80 */     if (UNFROZEN.tranName.equals(tranName))
/*  81 */       return UNFROZEN;
/*  82 */     if (DEDUCT.tranName.equals(tranName))
/*  83 */       return DEDUCT;
/*  84 */     if (LOAN.tranName.equals(tranName))
/*  85 */       return LOAN;
/*  86 */     if (REPAY.tranName.equals(tranName))
/*  87 */       return REPAY;
/*  88 */     if (YIELD.tranName.equals(tranName))
/*  89 */       return YIELD;
/*  90 */     if (ADJUST_ADD.tranName.equals(tranName))
/*  91 */       return ADJUST_ADD;
/*  92 */     if (ADJUST_SUBTRACT.tranName.equals(tranName))
/*  93 */       return ADJUST_SUBTRACT;
/*  94 */     if (PREPAY.tranName.equals(tranName))
/*  95 */       return PREPAY;
/*  96 */     if (COMPENSATE.tranName.equals(tranName))
/*  97 */       return COMPENSATE;
/*  98 */     if (INCOME.tranName.equals(tranName))
/*  99 */       return INCOME;
/* 100 */     if (PRINCIPAL.tranName.equals(tranName))
/* 101 */       return PRINCIPAL;
/* 102 */     if (INTEREST.tranName.equals(tranName))
/* 103 */       return INTEREST;
/* 104 */     if (ALLOT.tranName.equals(tranName))
/* 105 */       return ALLOT;
/* 106 */     if (PLATFILL.tranName.equals(tranName))
/* 107 */       return PLATFILL;
/* 108 */     if (PLATWITHDRAW.tranName.equals(tranName))
/* 109 */       return PLATWITHDRAW;
/* 110 */     if (SELFPRINCIPAL.tranName.equals(tranName))
/* 111 */       return SELFPRINCIPAL;
/* 112 */     if (SELFINTEREST.tranName.equals(tranName))
/* 113 */       return SELFINTEREST;
/* 114 */     if (TRANSPRINCIPAL.tranName.equals(tranName))
/* 115 */       return TRANSPRINCIPAL;
/* 116 */     if (TRANSINTEREST.tranName.equals(tranName))
/* 117 */       return TRANSINTEREST;
/* 118 */     if (DISBURSEMENTS.tranName.equals(tranName))
/* 119 */       return DISBURSEMENTS;
/* 120 */     if (BONUS.tranName.equals(tranName))
/* 121 */       return BONUS;
/* 122 */     if (EVERYINTEREST.tranName.equals(tranName))
/* 123 */       return EVERYINTEREST;
/* 124 */     if (LOSEREFUND.tranName.equals(tranName))
/* 125 */       return LOSEREFUND;
/* 126 */     if (FILL_FEE.tranName.equals(tranName))
/* 127 */       return FILL_FEE;
/* 128 */     if (WITHDRAW_FEE.tranName.equals(tranName))
/* 129 */       return WITHDRAW_FEE;
/* 130 */     if (REDEM_FEE.tranName.equals(tranName))
/* 131 */       return REDEM_FEE;
/* 132 */     if (PUB_FEE.tranName.equals(tranName))
/* 133 */       return PUB_FEE;
/* 134 */     if (INFO_FEE.tranName.equals(tranName))
/* 135 */       return INFO_FEE;
/* 136 */     if (OVERDUE_FEE.tranName.equals(tranName))
/* 137 */       return OVERDUE_FEE;
/* 138 */     if (UNPAID_FEE.tranName.equals(tranName))
/* 139 */       return UNPAID_FEE;
/* 140 */     if (MANAGER_FEE.tranName.equals(tranName))
/* 141 */       return MANAGER_FEE;
/* 142 */     if (RISKMGR_FEE.tranName.equals(tranName)) {
/* 143 */       return RISKMGR_FEE;
/*     */     }
/* 145 */     return null;
/*     */   }
/*     */ 
/*     */   public static AcctTranDef tranCode(String tranCode) {
/* 149 */     if (FILL.tranCode.equals(tranCode))
/* 150 */       return FILL;
/* 151 */     if (WITHDRAW.tranCode.equals(tranCode))
/* 152 */       return WITHDRAW;
/* 153 */     if (FROZEN.tranCode.equals(tranCode))
/* 154 */       return FROZEN;
/* 155 */     if (UNFROZEN.tranCode.equals(tranCode))
/* 156 */       return UNFROZEN;
/* 157 */     if (DEDUCT.tranCode.equals(tranCode))
/* 158 */       return DEDUCT;
/* 159 */     if (LOAN.tranCode.equals(tranCode))
/* 160 */       return LOAN;
/* 161 */     if (REPAY.tranCode.equals(tranCode))
/* 162 */       return REPAY;
/* 163 */     if (YIELD.tranCode.equals(tranCode))
/* 164 */       return YIELD;
/* 165 */     if (ADJUST_ADD.tranCode.equals(tranCode))
/* 166 */       return ADJUST_ADD;
/* 167 */     if (ADJUST_SUBTRACT.tranCode.equals(tranCode))
/* 168 */       return ADJUST_SUBTRACT;
/* 169 */     if (PREPAY.tranCode.equals(tranCode))
/* 170 */       return PREPAY;
/* 171 */     if (COMPENSATE.tranCode.equals(tranCode))
/* 172 */       return COMPENSATE;
/* 173 */     if (INCOME.tranCode.equals(tranCode))
/* 174 */       return INCOME;
/* 175 */     if (PRINCIPAL.tranCode.equals(tranCode))
/* 176 */       return PRINCIPAL;
/* 177 */     if (INTEREST.tranCode.equals(tranCode))
/* 178 */       return INTEREST;
/* 179 */     if (ALLOT.tranCode.equals(tranCode))
/* 180 */       return ALLOT;
/* 181 */     if (PLATFILL.tranCode.equals(tranCode))
/* 182 */       return PLATFILL;
/* 183 */     if (PLATWITHDRAW.tranCode.equals(tranCode))
/* 184 */       return PLATWITHDRAW;
/* 185 */     if (SELFPRINCIPAL.tranCode.equals(tranCode))
/* 186 */       return SELFPRINCIPAL;
/* 187 */     if (SELFINTEREST.tranCode.equals(tranCode))
/* 188 */       return SELFINTEREST;
/* 189 */     if (TRANSPRINCIPAL.tranCode.equals(tranCode))
/* 190 */       return TRANSPRINCIPAL;
/* 191 */     if (TRANSINTEREST.tranCode.equals(tranCode))
/* 192 */       return TRANSINTEREST;
/* 193 */     if (DISBURSEMENTS.tranCode.equals(tranCode))
/* 194 */       return DISBURSEMENTS;
/* 195 */     if (BONUS.tranCode.equals(tranCode))
/* 196 */       return BONUS;
/* 197 */     if (EVERYINTEREST.tranCode.equals(tranCode))
/* 198 */       return EVERYINTEREST;
/* 199 */     if (LOSEREFUND.tranCode.equals(tranCode))
/* 200 */       return LOSEREFUND;
/* 201 */     if (FILL_FEE.tranCode.equals(tranCode))
/* 202 */       return FILL_FEE;
/* 203 */     if (WITHDRAW_FEE.tranCode.equals(tranCode))
/* 204 */       return WITHDRAW_FEE;
/* 205 */     if (REDEM_FEE.tranCode.equals(tranCode))
/* 206 */       return REDEM_FEE;
/* 207 */     if (PUB_FEE.tranCode.equals(tranCode))
/* 208 */       return PUB_FEE;
/* 209 */     if (INFO_FEE.tranCode.equals(tranCode))
/* 210 */       return INFO_FEE;
/* 211 */     if (OVERDUE_FEE.tranCode.equals(tranCode))
/* 212 */       return OVERDUE_FEE;
/* 213 */     if (UNPAID_FEE.tranCode.equals(tranCode))
/* 214 */       return UNPAID_FEE;
/* 215 */     if (MANAGER_FEE.tranCode.equals(tranCode))
/* 216 */       return MANAGER_FEE;
/* 217 */     if (RISKMGR_FEE.tranCode.equals(tranCode)) {
/* 218 */       return RISKMGR_FEE;
/*     */     }
/* 220 */     return null;
/*     */   }
/*     */ 
/*     */   public String getTranCode() {
/* 224 */     return this.tranCode;
/*     */   }
/*     */ 
/*     */   public void setTranCode(String tranCode) {
/* 228 */     this.tranCode = tranCode;
/*     */   }
/*     */ 
/*     */   public String getTranName() {
/* 232 */     return this.tranName;
/*     */   }
/*     */ 
/*     */   public void setTranName(String tranName) {
/* 236 */     this.tranName = tranName;
/*     */   }
/*     */ 
/*     */   public String getAmountFlag() {
/* 240 */     return this.amountFlag;
/*     */   }
/*     */ 
/*     */   public void setAmountFlag(String amountFlag) {
/* 244 */     this.amountFlag = amountFlag;
/*     */   }
/*     */ 
/*     */   public String getiOrOut()
/*     */   {
/* 251 */     return this.iOrOut;
/*     */   }
/*     */ 
/*     */   public void setiOrOut(String iOrOut)
/*     */   {
/* 258 */     this.iOrOut = iOrOut;
/*     */   }
/*     */ 
/*     */   public String getShowName() {
/* 262 */     return this.showName;
/*     */   }
/*     */ 
/*     */   public void setShowName(String showName) {
/* 266 */     this.showName = showName;
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.dict.AcctTranDef
 * JD-Core Version:    0.5.3
 */