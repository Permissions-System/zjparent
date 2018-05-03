/*     */ package com.zjgt.p2p.base.service.impl;
/*     */ 
/*     */ import com.zjgt.p2p.base.dao.AreaDao;
/*     */ import com.zjgt.p2p.base.domain.Area;
/*     */ import com.zjgt.p2p.base.service.IAreaService;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.springfk.pancloud.exception.BusinessException;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class AreaService
/*     */   implements IAreaService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private AreaDao areaDao;
/*     */ 
/*     */   public String getAreaName(String areaCode)
/*     */     throws BusinessException
/*     */   {
/*  41 */     if (StringUtils.isEmpty(areaCode)) {
/*  42 */       return null;
/*     */     }
/*     */ 
/*  45 */     return this.areaDao.getAreaByAreaCode(areaCode).getAreaName();
/*     */   }
/*     */ 
/*     */   public List<Area> getProvinceList()
/*     */     throws BusinessException
/*     */   {
/*  54 */     return this.areaDao.getProvinceList();
/*     */   }
/*     */ 
/*     */   public List<Area> getCityList(String proviceCode)
/*     */     throws BusinessException
/*     */   {
/*  66 */     if (StringUtils.isEmpty(proviceCode)) {
/*  67 */       return null;
/*     */     }
/*     */ 
/*  70 */     return this.areaDao.getCityList(proviceCode);
/*     */   }
/*     */ 
/*     */   public List<Area> getCountyList(String cityCode)
/*     */     throws BusinessException
/*     */   {
/*  82 */     if (StringUtils.isEmpty(cityCode)) {
/*  83 */       return null;
/*     */     }
/*     */ 
/*  86 */     return this.areaDao.getCountyList(cityCode);
/*     */   }
/*     */ 
/*     */   public List<Area> getFullArea(String areaCode)
/*     */     throws BusinessException
/*     */   {
/*  97 */     if (StringUtils.isEmpty(areaCode)) {
/*  98 */       return null;
/*     */     }
/* 100 */     return this.areaDao.getFullArea(areaCode);
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.AreaService
 * JD-Core Version:    0.5.3
 */