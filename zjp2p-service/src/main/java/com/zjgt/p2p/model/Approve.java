package com.zjgt.p2p.model;

import java.util.Date;

public class Approve
{
  private Long id;
  private String modulecode;
  private String serviceno;
  private String transname;
  private Integer flowstep;
  private String subject;
  private String appreason;
  private Boolean appstatus;
  private String staffNo;
  private String staffName;
  private Date opdate;
  private String remark;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getModulecode()
  {
    return this.modulecode;
  }

  public void setModulecode(String modulecode)
  {
    this.modulecode = ((modulecode == null) ? null : modulecode.trim());
  }

  public String getServiceno()
  {
    return this.serviceno;
  }

  public void setServiceno(String serviceno)
  {
    this.serviceno = ((serviceno == null) ? null : serviceno.trim());
  }

  public String getTransname()
  {
    return this.transname;
  }

  public void setTransname(String transname)
  {
    this.transname = ((transname == null) ? null : transname.trim());
  }

  public Integer getFlowstep()
  {
    return this.flowstep;
  }

  public void setFlowstep(Integer flowstep)
  {
    this.flowstep = flowstep;
  }

  public String getSubject()
  {
    return this.subject;
  }

  public void setSubject(String subject)
  {
    this.subject = ((subject == null) ? null : subject.trim());
  }

  public String getAppreason()
  {
    return this.appreason;
  }

  public void setAppreason(String appreason)
  {
    this.appreason = ((appreason == null) ? null : appreason.trim());
  }

  public Boolean getAppstatus()
  {
    return this.appstatus;
  }

  public void setAppstatus(Boolean appstatus)
  {
    this.appstatus = appstatus;
  }

  public String getStaffNo()
  {
    return this.staffNo;
  }

  public void setStaffNo(String staffNo)
  {
    this.staffNo = ((staffNo == null) ? null : staffNo.trim());
  }

  public String getStaffName()
  {
    return this.staffName;
  }

  public void setStaffName(String staffName)
  {
    this.staffName = ((staffName == null) ? null : staffName.trim());
  }

  public Date getOpdate()
  {
    return this.opdate;
  }

  public void setOpdate(Date opdate)
  {
    this.opdate = opdate;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = ((remark == null) ? null : remark.trim());
  }
}