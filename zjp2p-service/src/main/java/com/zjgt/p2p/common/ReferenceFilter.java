package com.zjgt.p2p.common;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.zjgt.p2p.base.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferenceFilter
  implements Filter
{
  Logger logger;

  public ReferenceFilter()
  {
    this.logger = LoggerFactory.getLogger(ReferenceFilter.class);
  }

  public Result invoke(Invoker<?> invoker, Invocation invocation)
    throws RpcException
  {
    User user = null;
    if (ThreadContext.getSecurityManager() == null) {
      user = new User();
      user.setId("WEB99999");
      user.setName("互联网系统初始化");
      user.setUserSource("1");
    } else {
      user = (User)SecurityUtils.getSubject().getPrincipal();
      if (user == null) {
        user = new User();
        user.setId("WEB00000");
        user.setName("互联网普通访客");
        user.setUserSource("1");
      } else {
        user.setSessionId(SecurityUtils.getSubject().getSession().getId().toString());
      }
    }
    user.setMarkId(user.getName());
    UserContext.setUser(user);

    Result result = invoker.invoke(invocation);
    UserContext.removeUser();
    return result;
  }
}