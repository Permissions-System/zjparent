/*     */ package com.zjgt.p2p.base.service.impl;
/*     */ 
/*     */ import com.zjgt.p2p.base.dao.TransactionDao;
/*     */ import com.zjgt.p2p.base.domain.Transaction;
/*     */ import com.zjgt.p2p.base.service.IErrorLogsService;
/*     */ import com.zjgt.p2p.base.service.ITransactionService;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.validation.Validator;
/*     */ import org.springfk.pancloud.exception.BusinessException;
/*     */ import org.springfk.pancloud.paginator.vo.Page;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ 
/*     */ @Component
/*     */ @Transactional
/*     */ public class TransactionService
/*     */   implements ITransactionService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TransactionDao transactionDao;
/*     */ 
/*     */   @Autowired
/*     */   private Validator validator;
/*     */ 
/*     */   @Autowired
/*     */   private IErrorLogsService errLogService;
/*     */ 
/*     */   private void validateTransaction(Transaction transaction)
/*     */   {
/*  69 */     Set result = this.validator.validate(transaction, new Class[0]);
/*  70 */     if (result.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*  74 */     BusinessException ex = new BusinessException("数据校验错误");
/*  75 */     ex.setErrorMessages(result);
/*  76 */     throw ex;
/*     */   }
/*     */ 
/*     */   public void addTransaction(Transaction transaction)
/*     */     throws BusinessException
/*     */   {
/*  87 */     validateTransaction(transaction);
/*     */     try {
/*  89 */       System.out.println(" Transaction TransCode add: " + transaction.getTransCode());
/*  90 */       this.transactionDao.insert(transaction);
/*     */     } catch (Exception e) {
/*  92 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRTJ01", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void updateTransaction(Transaction transaction)
/*     */     throws BusinessException
/*     */   {
/* 104 */     validateTransaction(transaction);
/*     */     try {
/* 106 */       this.transactionDao.updateByPrimaryKey(transaction);
/*     */     } catch (Exception e) {
/* 108 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRXG01", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void deleteTransaction(String transCode)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 121 */       this.transactionDao.deleteByPrimaryKey(transCode);
/*     */     } catch (Exception e) {
/* 123 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRSC01", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Transaction getTransactionByTransCode(String transCode)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 136 */       Transaction transaction = new Transaction();
/* 137 */       transaction.setTransCode(transCode);
/* 138 */       transaction = this.transactionDao.selectByPrimaryKey(transCode);
/* 139 */       return transaction;
/*     */     } catch (Exception e) {
/* 141 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX03", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<Transaction> getTransByModuleCode(String moduleCode)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 154 */       List transList = new ArrayList();
/* 155 */       transList = this.transactionDao.selectTransByModuleCode(moduleCode);
/* 156 */       return transList;
/*     */     } catch (Exception e) {
/* 158 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX02", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean checkTransCode(String transCode)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 173 */       return (this.transactionDao.findCountByTransCode(transCode) <= 0);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 177 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCK01", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean checkTransName(String transName)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 192 */       return (this.transactionDao.findCountByTransName(transName) <= 0);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 196 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCK02", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Page<Transaction> getTransByPage(Map<String, Object> params, int pageNo, int pageSize)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 212 */       Page page = new Page();
/* 213 */       page.setPageNo(pageNo);
/* 214 */       page.setPageSize(pageSize);
/* 215 */       List result = this.transactionDao.getTransByPage(params, page);
/* 216 */       page.setResult(result);
/* 217 */       return page;
/*     */     } catch (Exception e) {
/* 219 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX05", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Page<Transaction> getTransByModuleCodePage(Map<String, Object> params, int pageNo, int pageSize)
/*     */     throws BusinessException
/*     */   {
/*     */     try
/*     */     {
/* 235 */       Page page = new Page();
/* 236 */       page.setPageNo(pageNo);
/* 237 */       page.setPageSize(pageSize);
/* 238 */       params.put("pageObject", page);
/* 239 */       List result = this.transactionDao.getTransByModuleCodePage(params);
/* 240 */       page.setResult(result);
/* 241 */       return page;
/*     */     } catch (Exception e) {
/* 243 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX06", null, e));
/*     */     }
/*     */   }
/*     */ 
/*     */   public Page<Transaction> getTransByModuleCodeAndPage(Map<String, Object> params, Integer pageNo, Integer pageSize)
/*     */   {
/*     */     try
/*     */     {
/* 259 */       Page page = new Page();
/* 260 */       page.setPageNo(pageNo.intValue());
/* 261 */       page.setPageSize(pageSize.intValue());
/* 262 */       params.put("pageObject", page);
/* 263 */       page.setResult(this.transactionDao.selectByModulesAndPage(params));
/* 264 */       return page;
/*     */     } catch (Exception e) {
/* 266 */       throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPTRCX07", null, e));
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.TransactionService
 * JD-Core Version:    0.5.3
 */