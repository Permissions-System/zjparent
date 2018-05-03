package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class StaffRoleRel
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String recNo;
  private String roleCode;
  private String staffNo;

  public String getRecNo()
  {
    return this.recNo;
  }

  public void setRecNo(String recNo) {
    this.recNo = ((recNo == null) ? null : recNo.trim());
  }

  public String getRoleCode() {
    return this.roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = ((roleCode == null) ? null : roleCode.trim());
  }

  public String getStaffNo() {
    return this.staffNo;
  }

  public void setStaffNo(String staffNo) {
    this.staffNo = staffNo;
  }
}