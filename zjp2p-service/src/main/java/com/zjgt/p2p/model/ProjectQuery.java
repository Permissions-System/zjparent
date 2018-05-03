package com.zjgt.p2p.model;

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class ProjectQuery
  implements Serializable
{
  private static final long serialVersionUID = 5689259285233975751L;
  private String projectcode;
  private String projectname;
  private String orgname;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date createDateStart;

  @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
  private Date createDateEnd;

  public String getProjectcode()
  {
    return this.projectcode;
  }

  public void setProjectcode(String projectcode) {
    this.projectcode = projectcode;
  }

  public String getProjectname() {
    return this.projectname;
  }

  public void setProjectname(String projectname) {
    this.projectname = projectname;
  }

  public String getOrgname() {
    return this.orgname;
  }

  public void setOrgname(String orgname) {
    this.orgname = orgname;
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
}