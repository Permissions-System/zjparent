package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Staff
  implements Serializable
{
  private static final long serialVersionUID = 2692847705593956558L;
  private String staffNo;

  @NotNull(message="组织机构代码不能为空")
  @Size(max=10, message="组织机构代码长度不能超过10个字符")
  private String orgCode;
  private String orgName;

  @NotNull(message="员工姓名不能为空")
  @Size(max=20, message="用户名长度不能超过20个字符")
  private String name;

  @NotNull(message="员工身份证号不能为空")
  @Size(max=18, message="身份证号长度不能超过18个字符")
  private String identNo;
  private String plainPassword;
  private String pwd;
  private String salt;

  @Size(max=16, message="电话长度不能超过16个字符")
  private String tel;

  @Size(max=64, message="email长度不能超过64个字符")
  private String email;

  @NotNull(message="员工类型不能为空")
  private String staffType;
  private String channelCode;

  @Size(max=32, message="C3中的组织机构号长度不能超过32个字符")
  private String c3OrgNo;

  @NotNull(message="员工状态不能为空")
  private String staffStatus;
  private String createDate;

  @Size(max=30, message="C3中的组织机构名称长度不能超过30个字符")
  private String c3OrgName;
  private String transpwd;
  private long totalByPromoCode;

  public String getStaffNo()
  {
    return this.staffNo;
  }

  public void setStaffNo(String staffNo) {
    this.staffNo = ((staffNo == null) ? null : staffNo.trim());
  }

  public String getOrgCode() {
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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = ((name == null) ? null : name.trim());
  }

  public String getIdentNo() {
    return this.identNo;
  }

  public void setIdentNo(String identNo) {
    this.identNo = ((identNo == null) ? null : identNo.trim());
  }

  public String getPlainPassword() {
    return this.plainPassword;
  }

  public void setPlainPassword(String plainPassword) {
    this.plainPassword = plainPassword;
  }

  public String getPwd() {
    return this.pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = ((pwd == null) ? null : pwd.trim());
  }

  public String getSalt() {
    return this.salt;
  }

  public void setSalt(String salt) {
    this.salt = ((salt == null) ? null : salt.trim());
  }

  public String getTel() {
    return this.tel;
  }

  public void setTel(String tel) {
    this.tel = ((tel == null) ? null : tel.trim());
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = ((email == null) ? null : email.trim());
  }

  public String getStaffType() {
    return this.staffType;
  }

  public void setStaffType(String staffType) {
    this.staffType = ((staffType == null) ? null : staffType.trim());
  }

  public String getC3OrgNo() {
    return this.c3OrgNo;
  }

  public void setC3OrgNo(String c3OrgNo) {
    this.c3OrgNo = ((c3OrgNo == null) ? null : c3OrgNo.trim());
  }

  public String getStaffStatus() {
    return this.staffStatus;
  }

  public void setStaffStatus(String staffStatus) {
    this.staffStatus = ((staffStatus == null) ? null : staffStatus.trim());
  }

  public String getCreateDate() {
    return this.createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = ((createDate == null) ? null : createDate.trim());
  }

  public String getC3OrgName() {
    return this.c3OrgName;
  }

  public void setC3OrgName(String c3OrgName) {
    this.c3OrgName = c3OrgName;
  }

  public String getTranspwd() {
    return this.transpwd;
  }

  public void setTranspwd(String transpwd) {
    this.transpwd = transpwd;
  }

  public String getChannelCode() {
    return this.channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public long getTotalByPromoCode()
  {
    return this.totalByPromoCode;
  }

  public void setTotalByPromoCode(long totalByPromoCode) {
    this.totalByPromoCode = totalByPromoCode;
  }
}