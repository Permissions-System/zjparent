package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class User
  implements Serializable
{
  private static final long serialVersionUID = 659499369112940644L;
  private String id;
  private String markId;
  private String name;
  private String userSource;
  private String sessionId;

  public User()
  {
  }

  public User(String id, String name, String userSource)
  {
    this.id = id;
    this.name = name;
    this.userSource = userSource;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getUserSource()
  {
    return this.userSource;
  }

  public void setUserSource(String userSource)
  {
    this.userSource = userSource;
  }

  public String getSessionId()
  {
    return this.sessionId;
  }

  public void setSessionId(String sessionId)
  {
    this.sessionId = sessionId;
  }

  public String getMarkId()
  {
    return this.markId;
  }

  public void setMarkId(String markId)
  {
    this.markId = markId;
  }
}