package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Transaction
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="交易码不能为空")
  @Size(min=3, max=20, message="交易码长度在2到20之间")
  private String transCode;

  @NotNull(message="交易名不能为空")
  @Size(min=3, max=40, message="交易名长度在2到40之间")
  private String transName;

  @NotNull(message="交易URL不能为空")
  @Size(min=3, max=150, message="交易URL长度在3到150之间")
  private String url;

  @NotNull(message="交易状态不能为空")
  private String transStatus;

  @NotNull(message="交易的有效标志不能为空")
  private String validateFlag;

  @NotNull(message="交易所属模块码不能为空")
  private String moduleCode;
  private Boolean checked;
  private Boolean disabled;

  public String getTransCode()
  {
    return this.transCode;
  }

  public void setTransCode(String transCode) {
    this.transCode = ((transCode == null) ? null : transCode.trim());
  }

  public String getTransName() {
    return this.transName;
  }

  public void setTransName(String transName) {
    this.transName = ((transName == null) ? null : transName.trim());
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = ((url == null) ? null : url.trim());
  }

  public String getTransStatus() {
    return this.transStatus;
  }

  public void setTransStatus(String transStatus) {
    this.transStatus = ((transStatus == null) ? null : transStatus.trim());
  }

  public String getValidateFlag() {
    return this.validateFlag;
  }

  public void setValidateFlag(String validateFlag) {
    this.validateFlag = ((validateFlag == null) ? null : validateFlag.trim());
  }

  public String getModuleCode() {
    return this.moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = ((moduleCode == null) ? null : moduleCode.trim());
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