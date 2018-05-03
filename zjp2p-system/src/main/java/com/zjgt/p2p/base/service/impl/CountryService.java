/*    */ package com.zjgt.p2p.base.service.impl;
/*    */ 
/*    */ import com.zjgt.p2p.base.dao.CountryDao;
/*    */ import com.zjgt.p2p.base.domain.Country;
/*    */ import com.zjgt.p2p.base.service.ICountryService;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.springfk.pancloud.exception.BusinessException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component
/*    */ public class CountryService
/*    */   implements ICountryService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private CountryDao countryDao;
/*    */ 
/*    */   public List<Country> getCountryList()
/*    */     throws BusinessException
/*    */   {
/* 38 */     return this.countryDao.getCountryList();
/*    */   }
/*    */ 
/*    */   public Country selectByContryCode(String countryCode)
/*    */     throws BusinessException
/*    */   {
/* 45 */     if (StringUtils.isEmpty(countryCode)) {
/* 46 */       return null;
/*    */     }
/*    */ 
/* 49 */     return this.countryDao.selectByContryCode(countryCode);
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.CountryService
 * JD-Core Version:    0.5.3
 */