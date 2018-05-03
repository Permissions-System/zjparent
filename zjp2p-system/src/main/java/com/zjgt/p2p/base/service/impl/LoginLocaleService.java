/*    */ package com.zjgt.p2p.base.service.impl;
/*    */ 
/*    */ import com.zjgt.p2p.base.dao.LoginLocaleDao;
/*    */ import com.zjgt.p2p.base.domain.LoginLocale;
/*    */ import com.zjgt.p2p.base.service.IErrorLogsService;
/*    */ import com.zjgt.p2p.base.service.ILoginLocaleService;
/*    */ import com.zjgt.util.UUIDUtils;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springfk.pancloud.exception.BusinessException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class LoginLocaleService
/*    */   implements ILoginLocaleService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private LoginLocaleDao loginLocaleDao;
/*    */ 
/*    */   @Autowired
/*    */   private IErrorLogsService errorLogsService;
/*    */ 
/*    */   public void addLoginLocale(LoginLocale record)
/*    */     throws BusinessException
/*    */   {
/*    */     try
/*    */     {
/* 46 */       record.setRecNo(UUIDUtils.generate());
/* 47 */       this.loginLocaleDao.insert(record);
/*    */     } catch (Exception e) {
/* 49 */       throw new BusinessException(this.errorLogsService.writeErrorLog(super.getClass(), "CPLILG01", null, e));
/*    */     }
/*    */   }
/*    */ 
/*    */   public void updateLoginLocale(LoginLocale record)
/*    */     throws BusinessException
/*    */   {
/* 56 */     this.loginLocaleDao.update(record);
/*    */   }
/*    */ 
/*    */   public boolean hasLogin(LoginLocale record) throws BusinessException
/*    */   {
/* 61 */     return false;
/*    */   }
/*    */ 
/*    */   public void recordLoginLocale(LoginLocale record)
/*    */     throws BusinessException
/*    */   {
/*    */     SimpleDateFormat format;
/* 67 */     if (getLoginLocaleByUserNoAndLocale(record.getUserNo(), record.getLocale()) == null) {
/* 68 */       record.setRecNo(UUIDUtils.generate());
/* 69 */       record.setLoginTimes(1);
/* 70 */       format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
/* 71 */       record.setLastTime(format.format(new Date()));
/* 72 */       addLoginLocale(record);
/*    */     } else {
/* 74 */       record.setLoginTimes(record.getLoginTimes() + 1);
/* 75 */       format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
/* 76 */       record.setLastTime(format.format(new Date()));
/* 77 */       updateLoginLocale(record);
/*    */     }
/*    */   }
/*    */ 
/*    */   public LoginLocale getLoginLocaleByUserNoAndLocale(String userNo, String locale)
/*    */     throws BusinessException
/*    */   {
/* 85 */     return this.loginLocaleDao.getLoginLocaleByUserNoAndLocale(userNo, locale);
/*    */   }
/*    */ 
/*    */   public List<LoginLocale> getLoginLocaleByUserNo(String userNo) throws BusinessException
/*    */   {
/* 90 */     return this.loginLocaleDao.selectByUserNo(userNo);
/*    */   }
/*    */ 
/*    */   public List<LoginLocale> getLoginLocaleGreaterThanThreshold(String userNo, int threshold)
/*    */     throws BusinessException
/*    */   {
/* 96 */     return this.loginLocaleDao.getLoginLocaleGreaterThanThreshold(userNo, threshold);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.LoginLocaleService
 * JD-Core Version:    0.5.3
 */