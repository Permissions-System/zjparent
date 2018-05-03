/*    */ package com.zjgt.p2p.base.service.impl;
/*    */ 
/*    */ import com.zjgt.p2p.base.dao.ActivityLogDao;
/*    */ import com.zjgt.p2p.base.domain.ActivityLog;
/*    */ import com.zjgt.p2p.base.domain.User;
/*    */ import com.zjgt.p2p.base.service.IActivityLogService;
/*    */ import com.zjgt.p2p.common.UserContext;
/*    */ import com.zjgt.util.UUIDUtils;
/*    */ import java.text.Format;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springfk.pancloud.exception.BusinessException;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Component
/*    */ @Transactional
/*    */ public class ActivityLogService
/*    */   implements IActivityLogService
/*    */ {
/*    */   private final Logger logger;
/*    */ 
/*    */   @Autowired
/*    */   private ActivityLogDao activityLogDao;
/*    */ 
/*    */   public ActivityLogService()
/*    */   {
/* 35 */     this.logger = LoggerFactory.getLogger(super.getClass());
/*    */   }
/*    */ 
/*    */   public void insert(ActivityLog activityLog)
/*    */     throws BusinessException
/*    */   {
/* 47 */     activityLog.setRecNo(UUIDUtils.generate());
/* 48 */     Format format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
/* 49 */     activityLog.setOperTime(format.format(new Date()));
/* 50 */     User user = UserContext.getUser();
/* 51 */     String sessionId = ((user != null) && (user.getSessionId() != null)) ? user.getSessionId() : "";
/* 52 */     if (sessionId.equals("")) {
/* 53 */       sessionId = "no session";
/*    */     }
/* 55 */     activityLog.setSessionId(sessionId);
/* 56 */     this.activityLogDao.insert(activityLog);
/* 57 */     this.logger.debug("insert activity log successfully");
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.ActivityLogService
 * JD-Core Version:    0.5.3
 */