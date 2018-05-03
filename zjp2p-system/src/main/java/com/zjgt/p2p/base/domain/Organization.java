package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Organization
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="组织机构代码不能为空")
  @Size(max=10, message="组织机构代码长度不能长于10个字符")
  private String orgCode;

  @NotNull(message="组织机构名称不能为空")
  @Size(max=20, message="组织机构名称长度不能长于20个字符")
  private String orgName;
  private BigDecimal orderNo;

  @Size(max=50, message="treepath长度不能长于50个字符，请联系系统管理员！")
  private String treepath;
  private String parentOrgCode;
  private List<Organization> childOrganizations;
  private List<Role> roleList;

  public String getOrgCode()
  {
    return this.orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = ((orgCode == null) ? null : orgCode.trim());
  }

  public String getOrgName() {
    return this.orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = ((orgName == null) ? null : orgName.trim());
  }

  public BigDecimal getOrderNo() {
    return this.orderNo;
  }

  public void setOrderNo(BigDecimal orderNo) {
    this.orderNo = orderNo;
  }

  public String getTreepath() {
    return this.treepath;
  }

  public void setTreepath(String treepath) {
    this.treepath = ((treepath == null) ? null : treepath.trim());
  }

  public List<Organization> getChildOrganizations() {
    return this.childOrganizations;
  }

  public void setChildOrganizations(List<Organization> childOrganizations) {
    this.childOrganizations = childOrganizations;
  }

  public String getParentOrgCode() {
    return this.parentOrgCode;
  }

  public void setParentOrgCode(String parentOrgCode) {
    this.parentOrgCode = parentOrgCode;
  }

  public List<Role> getRoleList() {
    return this.roleList;
  }

  public void setRoleList(List<Role> roleList) {
    this.roleList = roleList;
  }
}