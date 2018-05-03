/*    */ package com.zjgt.p2p.common;
/*    */ 
/*    */ import com.alibaba.dubbo.rpc.Filter;
/*    */ import com.alibaba.dubbo.rpc.Invocation;
/*    */ import com.alibaba.dubbo.rpc.Invoker;
/*    */ import com.alibaba.dubbo.rpc.Result;
/*    */ import com.alibaba.dubbo.rpc.RpcException;
/*    */ import com.zjgt.p2p.base.domain.User;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.session.Session;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ import org.apache.shiro.util.ThreadContext;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class ReferenceFilter
/*    */   implements Filter
/*    */ {
/*    */   Logger logger;
/*    */ 
/*    */   public ReferenceFilter()
/*    */   {
/* 25 */     this.logger = LoggerFactory.getLogger(ReferenceFilter.class);
/*    */   }
/*    */ 
/*    */   public Result invoke(Invoker<?> invoker, Invocation invocation)
/*    */     throws RpcException
/*    */   {
/* 31 */     User user = null;
/* 32 */     if (ThreadContext.getSecurityManager() == null) {
/* 33 */       user = new User();
/* 34 */       user.setId("WEB99999");
/* 35 */       user.setName("互联网系统初始化");
/* 36 */       user.setUserSource("1");
/*    */     } else {
/* 38 */       user = (User)SecurityUtils.getSubject().getPrincipal();
/* 39 */       if (user == null) {
/* 40 */         user = new User();
/* 41 */         user.setId("WEB00000");
/* 42 */         user.setName("互联网普通访客");
/* 43 */         user.setUserSource("1");
/*    */       } else {
/* 45 */         user.setSessionId(SecurityUtils.getSubject().getSession().getId().toString());
/*    */       }
/*    */     }
/* 48 */     user.setMarkId(user.getName());
/* 49 */     UserContext.setUser(user);
/*    */ 
/* 51 */     Result result = invoker.invoke(invocation);
/* 52 */     UserContext.removeUser();
/* 53 */     return result;
/*    */   }
/*    */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.common.ReferenceFilter
 * JD-Core Version:    0.5.3
 */