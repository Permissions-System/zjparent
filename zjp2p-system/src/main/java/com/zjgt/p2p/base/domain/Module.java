package com.zjgt.p2p.base.domain;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Module
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  @Size(min=1, max=9, message="模块编码长度应为1~9个字符")
  @NotNull(message="模块编码不能为空")
  private String moduleCode;

  @Size(min=1, max=20, message="模块名称长度应为1~20个字符")
  @NotNull(message="模块名称不能为空")
  private String moduleName;

  @Size(min=1, max=50, message="模块路径长度应为50个字符")
  private String treepath;

  @NotNull(message="模块状态不能为空")
  private String moduleStatus;

  @Size(min=1, max=9, message="上级模块编码长度应为1~9个字符")
  private String parentModuleCode;
  private List<Module> subModuleList;
  private List<Transaction> transactionList;

  public String getModuleCode()
  {
    return this.moduleCode;
  }

  public void setModuleCode(String moduleCode)
  {
    this.moduleCode = ((moduleCode == null) ? null : moduleCode.trim());
  }

  public String getModuleName()
  {
    return this.moduleName;
  }

  public void setModuleName(String moduleName)
  {
    this.moduleName = ((moduleName == null) ? null : moduleName.trim());
  }

  public String getTreepath()
  {
    return this.treepath;
  }

  public void setTreepath(String treepath)
  {
    this.treepath = ((treepath == null) ? null : treepath.trim());
  }

  public String getModuleStatus()
  {
    return this.moduleStatus;
  }

  public void setModuleStatus(String moduleStatus)
  {
    this.moduleStatus = ((moduleStatus == null) ? null : moduleStatus.trim());
  }

  public String getParentModuleCode()
  {
    return this.parentModuleCode;
  }

  public void setParentModuleCode(String parentModuleCode)
  {
    this.parentModuleCode = ((parentModuleCode == null) ? null : parentModuleCode.trim());
  }

  public List<Module> getSubModuleList()
  {
    return this.subModuleList;
  }

  public void setSubModuleList(List<Module> subModuleList)
  {
    this.subModuleList = subModuleList;
  }

  public List<Transaction> getTransactionList()
  {
    return this.transactionList;
  }

  public void setTransactionList(List<Transaction> transactionList)
  {
    this.transactionList = transactionList;
  }
}