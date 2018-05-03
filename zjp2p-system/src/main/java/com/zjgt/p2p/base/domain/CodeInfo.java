package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CodeInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @NotNull(message="编码不能为空")
  @Size(min=1, max=32, message="编码长度不应超过32个字符")
  private String configCode;

  @NotNull(message="编码名称不能为空")
  @Size(min=1, max=20, message="编码名称长度不应超过20个字符")
  private String configName;
  private BigDecimal indexNo;

  @NotNull(message="是否可编辑 不能为空")
  private String readFlag;

  @NotNull(message="是否可删除 不能为空")
  private String deleteFlag;

  @NotNull(message="分类编码不能为空")
  @Size(min=1, max=32, message="分类编码长度不应超过32个字符")
  private String typeCode;

  @NotNull(message="分类名称不能为空")
  @Size(min=1, max=20, message="分类名称长度不应超过20个字符")
  private String typeName;

  @Size(max=65, message="描述长度不应超过65个字符")
  private String description;

  public String getConfigCode()
  {
    return this.configCode;
  }

  public void setConfigCode(String configCode)
  {
    this.configCode = configCode;
  }

  public String getConfigName()
  {
    return this.configName;
  }

  public void setConfigName(String configName)
  {
    this.configName = configName;
  }

  public BigDecimal getIndexNo()
  {
    return this.indexNo;
  }

  public void setIndexNo(BigDecimal indexNo)
  {
    this.indexNo = indexNo;
  }

  public String getReadFlag()
  {
    return this.readFlag;
  }

  public void setReadFlag(String readFlag)
  {
    this.readFlag = readFlag;
  }

  public String getDeleteFlag()
  {
    return this.deleteFlag;
  }

  public void setDeleteFlag(String deleteFlag)
  {
    this.deleteFlag = deleteFlag;
  }

  public String getTypeCode()
  {
    return this.typeCode;
  }

  public void setTypeCode(String typeCode)
  {
    this.typeCode = typeCode;
  }

  public String getTypeName()
  {
    return this.typeName;
  }

  public void setTypeName(String typeName)
  {
    this.typeName = typeName;
  }

  public String getDescription()
  {
    return this.description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}