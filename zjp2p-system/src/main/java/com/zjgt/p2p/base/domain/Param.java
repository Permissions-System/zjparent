package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class Param
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="产品代码不能为空")
  private String productCode;

  @NotNull(message="是否可编辑不能为空")
  private String readFlag;

  @NotNull(message="参数中文名称不能为空")
  private String paramCnName;

  @NotNull(message="参数英文名称不能为空")
  private String paramEnName;

  @NotNull(message="参数值不能为空")
  private String paramValue;
  private String description;

  public String getProductCode()
  {
    return this.productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getReadFlag() {
    return this.readFlag;
  }

  public void setReadFlag(String readFlag) {
    this.readFlag = readFlag;
  }

  public String getParamCnName() {
    return this.paramCnName;
  }

  public void setParamCnName(String paramCnName) {
    this.paramCnName = paramCnName;
  }

  public String getParamEnName() {
    return this.paramEnName;
  }

  public void setParamEnName(String paramEnName) {
    this.paramEnName = paramEnName;
  }

  public String getParamValue() {
    return this.paramValue;
  }

  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}