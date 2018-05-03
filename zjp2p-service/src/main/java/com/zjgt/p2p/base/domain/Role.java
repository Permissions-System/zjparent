package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Role
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="角色代码不能为空")
  @Size(max=10, message="角色代码长度不能长于10个字符")
  private String roleCode;

  @NotNull(message="角色名称不能为空")
  @Size(max=20, message="角色名称长度不能长于20个字符")
  private String roleName;

  @NotNull(message="组织机构代码不能为空")
  private String orgCode;

  @NotNull(message="角色类型不能为空")
  private String roleType;
  private Boolean checked;
  private Boolean disabled;

  public String getRoleCode()
  {
    return this.roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = ((roleCode == null) ? null : roleCode.trim());
  }

  public String getRoleName() {
    return this.roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = ((roleName == null) ? null : roleName.trim());
  }

  public String getOrgCode() {
    return this.orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = ((orgCode == null) ? null : orgCode.trim());
  }

  public String getRoleType() {
    return this.roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }

  public Boolean getChecked() {
    return this.checked;
  }

  public void setChecked(Boolean checked) {
    this.checked = checked;
  }

  public Boolean getDisabled() {
    return this.disabled;
  }

  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }
}