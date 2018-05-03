package com.zjgt.p2p.model;

public class MemberActPwd
{
  private Integer id;
  private Integer memberid;
  private String pwduuid;
  private Boolean uuidisvalid;
  private String remark;

  public Integer getId()
  {
    return this.id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public Integer getMemberid()
  {
    return this.memberid;
  }

  public void setMemberid(Integer memberid)
  {
    this.memberid = memberid;
  }

  public String getPwduuid()
  {
    return this.pwduuid;
  }

  public void setPwduuid(String pwduuid)
  {
    this.pwduuid = ((pwduuid == null) ? null : pwduuid.trim());
  }

  public Boolean getUuidisvalid()
  {
    return this.uuidisvalid;
  }

  public void setUuidisvalid(Boolean uuidisvalid)
  {
    this.uuidisvalid = uuidisvalid;
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