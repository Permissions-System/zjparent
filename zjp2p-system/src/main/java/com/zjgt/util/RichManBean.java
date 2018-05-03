/*     */ package com.zjgt.util;
/*     */ 
/*     */ public class RichManBean
/*     */ {
/*     */   private double monthIn;
/*     */   private double monthIncrease;
/*     */   private double investRate;
/*     */   private int year;
/*     */   private double incomeRate;
/*     */   private double deposit;
/*     */ 
/*     */   public RichManBean()
/*     */   {
/*  18 */     this.monthIncrease = 5.0D;
/*     */   }
/*     */ 
/*     */   public double getMonthIn()
/*     */   {
/*  40 */     return this.monthIn;
/*     */   }
/*     */ 
/*     */   public void setMonthIn(double monthIn)
/*     */   {
/*  47 */     this.monthIn = monthIn;
/*     */   }
/*     */ 
/*     */   public double getMonthIncrease()
/*     */   {
/*  54 */     return this.monthIncrease;
/*     */   }
/*     */ 
/*     */   public void setMonthIncrease(double monthIncrease)
/*     */   {
/*  61 */     this.monthIncrease = monthIncrease;
/*     */   }
/*     */ 
/*     */   public double getInvestRate()
/*     */   {
/*  68 */     return this.investRate;
/*     */   }
/*     */ 
/*     */   public void setInvestRate(double investRate)
/*     */   {
/*  75 */     this.investRate = investRate;
/*     */   }
/*     */ 
/*     */   public int getYear()
/*     */   {
/*  82 */     return this.year;
/*     */   }
/*     */ 
/*     */   public void setYear(int year)
/*     */   {
/*  89 */     this.year = year;
/*     */   }
/*     */ 
/*     */   public double getIncomeRate()
/*     */   {
/*  96 */     return this.incomeRate;
/*     */   }
/*     */ 
/*     */   public void setIncomeRate(double incomeRate)
/*     */   {
/* 103 */     this.incomeRate = incomeRate;
/*     */   }
/*     */ 
/*     */   public double getDeposit()
/*     */   {
/* 110 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(double deposit)
/*     */   {
/* 117 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public static void countWorth()
/*     */   {
/*     */   }
/*     */ 
/*     */   public double annualInvestAmount()
/*     */   {
/* 136 */     return (this.monthIn * 12.0D * this.investRate / 100.0D);
/*     */   }
/*     */ 
/*     */   public double incomeNYear()
/*     */   {
/* 146 */     return (annualInvestAmount() * Math.pow(1.0D + this.monthIncrease / 100.0D, this.year - 1));
/*     */   }
/*     */ 
/*     */   public double investNYear(int year)
/*     */   {
/* 157 */     return (annualInvestAmount() * this.monthIncrease / 100.0D * Math.pow(1.0D + this.monthIncrease / 100.0D, year - 2));
/*     */   }
/*     */ 
/*     */   public double sum(int year)
/*     */   {
/* 169 */     return (annualInvestAmount() * (1.0D + this.incomeRate / 100.0D) * (Math.pow(1.0D + this.incomeRate / 100.0D, year) - 1.0D) / this.incomeRate / 100.0D);
/*     */   }
/*     */ 
/*     */   public double sumNYeat(int n)
/*     */   {
/* 182 */     return (investNYear(n) * (1.0D + this.incomeRate / 100.0D) * (Math.pow(1.0D + this.incomeRate / 100.0D, this.year - n + 1) - 1.0D) / this.incomeRate / 100.0D);
/*     */   }
/*     */ 
/*     */   public double sumEveryYear()
/*     */   {
/* 195 */     double sum = 0.0D;
/* 196 */     for (int i = 1; i <= this.year; ++i) {
/* 197 */       if (i == 1)
/* 198 */         sum += sum(i);
/* 199 */       else if (i == this.year) {
/* 200 */         sum += investNYear(i) * (1.0D + this.incomeRate / 100.0D) * (1.0D + this.incomeRate / 100.0D - 1.0D) / this.incomeRate / 100.0D;
/*     */       }
/*     */       else {
/* 203 */         sum += sumNYeat(i);
/*     */       }
/*     */     }
/* 206 */     return sum;
/*     */   }
/*     */ 
/*     */   public double saveNYear()
/*     */   {
/* 218 */     return (this.deposit * Math.pow(1.0D + this.incomeRate / 100.0D, this.year - 1));
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.RichManBean
 * JD-Core Version:    0.5.3
 */