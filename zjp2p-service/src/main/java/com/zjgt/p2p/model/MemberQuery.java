package com.zjgt.p2p.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class MemberQuery
  implements Serializable
{
  private static final long serialVersionUID = 5689259285233975751L;
  private String email;
  private String username;
  private String realname;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date createDateStart;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date createDateEnd;
  private Short userstatus;
  private Long agentid;
  private String userSource;

  public String getUsername()
  {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getRealname() {
    return this.realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }

  public Date getCreateDateStart() {
    return this.createDateStart;
  }

  public void setCreateDateStart(Date createDateStart) {
    this.createDateStart = createDateStart;
  }

  public Date getCreateDateEnd() {
    return this.createDateEnd;
  }

  public void setCreateDateEnd(Date createDateEnd) {
    this.createDateEnd = createDateEnd;
  }

  public Short getUserstatus() {
    return this.userstatus;
  }

  public void setUserstatus(Short userstatus) {
    this.userstatus = userstatus;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getAgentid() {
    return this.agentid;
  }

  public void setAgentid(Long agentid) {
    this.agentid = agentid;
  }

  public String getUserSource() {
    return this.userSource;
  }

  public void setUserSource(String userSource) {
    this.userSource = userSource;
  }
}