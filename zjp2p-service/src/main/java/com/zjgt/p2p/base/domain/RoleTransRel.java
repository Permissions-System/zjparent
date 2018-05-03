package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class RoleTransRel
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String recNo;
  private String roleCode;
  private String transCode;

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

  public String getTransCode() {
    return this.transCode;
  }

  public void setTransCode(String transCode) {
    this.transCode = ((transCode == null) ? null : transCode.trim());
  }
}