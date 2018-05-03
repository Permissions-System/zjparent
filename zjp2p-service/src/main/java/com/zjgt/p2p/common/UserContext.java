package com.zjgt.p2p.common;

import com.zjgt.p2p.base.domain.User;
import org.springfk.pancloud.exception.BusinessException;

public class UserContext
{
  public static final String USER_ID = "userId";
  public static final String USER_NAME = "userName";
  public static final String USER_SOURCE = "userSource";
  public static final String SESSION_ID = "sessionId";
  public static final String MARD_ID = "markId";

  public static void setUser(User user)
    throws BusinessException
  {
  }

  public static User getUser()
  {
    User user = new User("ABC00000000", "admin", "1");
    user.setSessionId("JSESSION_ID");
    user.setMarkId("markId");
    return user;
  }

  public static void removeUser()
  {
  }
}