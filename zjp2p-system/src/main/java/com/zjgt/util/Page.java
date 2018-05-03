/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Page<T>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3198048449643774660L;
/*     */   private List<T> results;
/*  15 */   private int pageNow = 1;
/*     */   private int pageSize;
/*     */   private int totalCount;
/*     */   private int totalPageCount;
/*     */   private int begin;
/*     */   private int end;
/*     */   private int startPos;
/*     */   private boolean hasFirst;
/*     */   private boolean hasPre;
/*     */   private boolean hasNext;
/*     */   private boolean hasLast;
/*     */ 
/*     */   public int getBegin()
/*     */   {
/*  28 */     return this.begin;
/*     */   }
/*     */ 
/*     */   public void setBegin(int begin) {
/*  32 */     this.begin = begin;
/*     */   }
/*     */ 
/*     */   public int getEnd() {
/*  36 */     return this.end;
/*     */   }
/*     */ 
/*     */   public void setEnd(int end) {
/*  40 */     this.end = end;
/*     */   }
/*     */ 
/*     */   public Page(int totalCount, int pageNow)
/*     */   {
/*  66 */     this.totalCount = totalCount;
/*  67 */     this.pageNow = pageNow;
/*     */   }
/*     */ 
/*     */   public List<T> getResults() {
/*  71 */     return this.results;
/*     */   }
/*     */ 
/*     */   public void setResults(List<T> results) {
/*  75 */     this.results = results;
/*     */   }
/*     */ 
/*     */   public int getTotalPageCount()
/*     */   {
/*  84 */     this.totalPageCount = (getTotalCount() / getPageSize());
/*  85 */     return ((this.totalCount % this.pageSize == 0) ? this.totalPageCount : this.totalPageCount + 1);
/*     */   }
/*     */ 
/*     */   public void setTotalPageCount(int totalPageCount)
/*     */   {
/*  90 */     this.totalPageCount = totalPageCount;
/*     */   }
/*     */ 
/*     */   public int getPageNow() {
/*  94 */     return this.pageNow;
/*     */   }
/*     */ 
/*     */   public void setPageNow(int pageNow) {
/*  98 */     this.pageNow = pageNow;
/*     */   }
/*     */ 
/*     */   public int getPageSize() {
/* 102 */     return this.pageSize;
/*     */   }
/*     */ 
/*     */   public void setPageSize(int pageSize) {
/* 106 */     this.pageSize = pageSize;
/*     */   }
/*     */ 
/*     */   public int getTotalCount() {
/* 110 */     return this.totalCount;
/*     */   }
/*     */ 
/*     */   public void setTotalCount(int totalCount) {
/* 114 */     this.totalCount = totalCount;
/*     */   }
/*     */ 
/*     */   public int getStartPos()
/*     */   {
/* 123 */     return ((this.pageNow - 1) * this.pageSize);
/*     */   }
/*     */ 
/*     */   public void setStartPos(int startPos) {
/* 127 */     this.startPos = startPos;
/*     */   }
/*     */ 
/*     */   public boolean isHasFirst()
/*     */   {
/* 136 */     return (this.pageNow != 1);
/*     */   }
/*     */ 
/*     */   public void setHasFirst(boolean hasFirst) {
/* 140 */     this.hasFirst = hasFirst;
/*     */   }
/*     */ 
/*     */   public boolean isHasPre()
/*     */   {
/* 150 */     return (isHasFirst());
/*     */   }
/*     */ 
/*     */   public void setHasPre(boolean hasPre) {
/* 154 */     this.hasPre = hasPre;
/*     */   }
/*     */ 
/*     */   public boolean isHasNext()
/*     */   {
/* 164 */     return (isHasLast());
/*     */   }
/*     */ 
/*     */   public void setHasNext(boolean hasNext) {
/* 168 */     this.hasNext = hasNext;
/*     */   }
/*     */ 
/*     */   public boolean isHasLast()
/*     */   {
/* 178 */     return (this.pageNow != getTotalCount());
/*     */   }
/*     */ 
/*     */   public void setHasLast(boolean hasLast) {
/* 182 */     this.hasLast = hasLast;
/*     */   }
/*     */ 
/*     */   public void getPager(int pageNum, int totalPage)
/*     */   {
/* 187 */     if (pageNum - 3 < 1)
/* 188 */       this.begin = 1;
/*     */     else {
/* 190 */       this.begin = (pageNum - 3);
/*     */     }
/* 192 */     if (totalPage < pageNum + 3)
/* 193 */       this.end = totalPage;
/*     */     else
/* 195 */       this.end = (pageNum + 3);
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.Page
 * JD-Core Version:    0.5.3
 */