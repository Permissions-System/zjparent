/*     */ package com.zjgt.p2p.base.service.impl;
/*     */ 
/*     */ import com.zjgt.p2p.base.dao.SerialDao;
/*     */ import com.zjgt.p2p.base.domain.SerialTemplate;
/*     */ import com.zjgt.p2p.base.service.ISerialService;
/*     */ import com.zjgt.p2p.base.service.impl.serial.CachedSerialCounter;
/*     */ import com.zjgt.p2p.base.service.impl.serial.DefaultSerialFormater;
/*     */ import com.zjgt.p2p.base.service.impl.serial.ItemFormat;
/*     */ import com.zjgt.p2p.base.service.impl.serial.SerialFormater;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springfk.pancloud.exception.BusinessException;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ import org.springframework.transaction.PlatformTransactionManager;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.DefaultTransactionDefinition;
/*     */ 
/*     */ @Component
/*     */ public class SerialService
/*     */   implements ISerialService
/*     */ {
/*     */   protected String defaultSerialTemplate;
/*  34 */   private final Logger logger = LoggerFactory.getLogger(super.getClass());
/*     */ 
/*     */   @Autowired
/*     */   private SerialDao serialDao;
/*     */ 
/*     */   @Autowired
/*     */   private PlatformTransactionManager transactionManager;
/*  42 */   private SerialFormater serialFormater = new DefaultSerialFormater();
/*     */ 
/*  44 */   private Map<String, CachedSerialCounter> serialCounterMap = new HashMap();
/*     */ 
/*  47 */   private Map<String, SerialTemplate> templateMap = new HashMap();
/*     */ 
/*     */   public String getDefaultSerialTemplate()
/*     */   {
/*  53 */     return this.defaultSerialTemplate;
/*     */   }
/*     */ 
/*     */   public void setDefaultSerialTemplate(String defaultSerialTemplate) {
/*  57 */     this.defaultSerialTemplate = defaultSerialTemplate;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getFormatedParams(Map<String, Object> params, Map<String, ItemFormat> formats)
/*     */   {
/*  69 */     Map formatedParams = new HashMap();
/*  70 */     for (Map.Entry entry : params.entrySet()) {
/*  71 */       String key = (String)entry.getKey();
/*  72 */       Object value = entry.getValue();
/*  73 */       ItemFormat format = (ItemFormat)formats.get(key);
/*  74 */       if (format != null)
/*  75 */         formatedParams.put(format.getKey(), this.serialFormater.format(value, format));
/*     */       else {
/*  77 */         formatedParams.put(key, value);
/*     */       }
/*     */     }
/*  80 */     return formatedParams;
/*     */   }
/*     */ 
/*     */   public void setSerialFormater(SerialFormater serialFormater) {
/*  84 */     this.serialFormater = serialFormater;
/*     */   }
/*     */ 
/*     */   public String getSerial(String templateCode, Map<String, Object> params)
/*     */     throws BusinessException
/*     */   {
/*  95 */     if (params == null) {
/*  96 */       params = new HashMap();
/*     */     }
/*     */ 
/*  99 */     SerialTemplate template = null;
/*     */ 
/* 101 */     synchronized (this.templateMap) {
/* 102 */       template = getSerialTemplate(templateCode);
/*     */     }
/* 104 */     if (template == null)
/* 105 */       throw new BusinessException("模板 " + templateCode + " 未定义");
/*     */     String sn;
/* 108 */     synchronized (template)
/*     */     {
/*     */       try {
/* 111 */         Map formats = this.serialFormater.getTemplateFormats(template.getTemplate());
/*     */ 
/* 114 */         Map formatedParams = getFormatedParams(params, formats);
/* 115 */         sn = getSerialInfo(template, formatedParams);
/*     */       } catch (Exception e) {
/* 117 */         throw new BusinessException(e);
/*     */       }
/*     */     }
/*     */ 
/* 121 */     return sn;
/*     */   }
/*     */ 
/*     */   private String getSerialInfo(SerialTemplate template, Map<String, Object> formatedParams)
/*     */     throws Exception
/*     */   {
/* 134 */     Integer next = getNextCounter(template);
/* 135 */     formatedParams.put(SerialTemplate.SERIAL, String.valueOf(next));
/* 136 */     return this.serialFormater.format(formatedParams, template.getTemplate());
/*     */   }
/*     */ 
/*     */   private Integer getNextCounter(SerialTemplate template)
/*     */     throws Exception
/*     */   {
/* 146 */     String templateCode = template.getTemplateCode();
/*     */ 
/* 148 */     CachedSerialCounter counters = (CachedSerialCounter)this.serialCounterMap.get(templateCode);
/* 149 */     if (counters == null) {
/* 150 */       counters = new CachedSerialCounter(templateCode);
/* 151 */       this.serialCounterMap.put(templateCode, counters);
/*     */     }
/* 153 */     Integer counter = counters.popFirst();
/* 154 */     if (counter != null) {
/* 155 */       return counter;
/*     */     }
/*     */ 
/* 161 */     DefaultTransactionDefinition def = new DefaultTransactionDefinition();
/* 162 */     def.setPropagationBehavior(3);
/* 163 */     def.setIsolationLevel(2);
/* 164 */     TransactionStatus ts = this.transactionManager.getTransaction(def);
/*     */     int currentCounter;
/*     */     int cachedCount;
/*     */     try
/*     */     {
/* 169 */       SerialTemplate serialCounter = getSerialTemplateForUpdate(templateCode);
/* 170 */       currentCounter = serialCounter.getCounter();
/* 171 */       cachedCount = serialCounter.getCachedCount();
/* 172 */       int newCounter = currentCounter + cachedCount;
/* 173 */       int counterSize = template.getCounterSize();
/* 174 */       int newCounterSize = String.valueOf(newCounter).length();
/* 175 */       if (counterSize < newCounterSize) {
/* 176 */         newCounter = Integer.parseInt(String.valueOf(newCounter).substring(1));
/*     */       }
/* 178 */       serialCounter.setCounter(newCounter);
/* 179 */       this.serialDao.updateSerialTemplate(serialCounter);
/* 180 */       this.transactionManager.commit(ts);
/*     */     } catch (Exception e) {
/* 182 */       this.logger.error(e.getMessage());
/* 183 */       this.transactionManager.rollback(ts);
/* 184 */       throw e;
/*     */     }
/*     */ 
/* 187 */     for (int i = 0; i < cachedCount; ++i) {
/* 188 */       int next = currentCounter + 1;
/* 189 */       counters.add(next);
/* 190 */       currentCounter = next;
/*     */     }
/* 192 */     counter = counters.popFirst();
/* 193 */     return counter;
/*     */   }
/*     */ 
/*     */   public SerialTemplate getSerialTemplate(String templateCode)
/*     */   {
/* 205 */     SerialTemplate template = (SerialTemplate)this.templateMap.get(templateCode);
/* 206 */     if (template == null) {
/* 207 */       template = getSerialTemplateFromDb(templateCode);
/* 208 */       if (template != null) {
/* 209 */         this.templateMap.put(templateCode, template);
/*     */       }
/*     */     }
/* 212 */     return template;
/*     */   }
/*     */ 
/*     */   private SerialTemplate getSerialTemplateForUpdate(String templateCode)
/*     */   {
/* 222 */     SerialTemplate serialTemplate = this.serialDao.getSerialTemplateForUpdate(templateCode);
/* 223 */     return serialTemplate;
/*     */   }
/*     */ 
/*     */   public SerialTemplate getSerialTemplateFromDb(String templateCode)
/*     */   {
/* 233 */     SerialTemplate serialTemplate = this.serialDao.getSerialTemplate(templateCode);
/* 234 */     return serialTemplate;
/*     */   }
/*     */ 
/*     */   public void insertSerialTemplate(SerialTemplate template)
/*     */   {
/* 241 */     this.serialDao.insertSerialTemplate(template);
/*     */   }
/*     */ 
/*     */   public List<SerialTemplate> getSerialTemplateList()
/*     */     throws BusinessException
/*     */   {
/* 249 */     return this.serialDao.getSerialTemplateList();
/*     */   }
/*     */ 
/*     */   public void deleteSerialTemplate(String templateCode)
/*     */   {
/* 257 */     this.serialDao.deleteSerialTemplate(templateCode);
/*     */   }
/*     */ 
/*     */   public void clearCache()
/*     */   {
/* 264 */     this.templateMap = new HashMap();
/* 265 */     this.serialCounterMap = new HashMap();
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.SerialService
 * JD-Core Version:    0.5.3
 */