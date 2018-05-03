package com.zjgt.p2p.base.domain;

import com.google.common.collect.Lists;
import java.util.List;

public class OperatingRecord extends BasicRecordProperty
{
  private static final long serialVersionUID = 1L;
  private String ip;
  private String method;
  private List<RecordParameter> recordParametersList;
  private Integer state;
  private String module;
  private String function;
  private String remark;

  public OperatingRecord()
  {
    this.recordParametersList = Lists.newArrayList();
  }

  public String getIp()
  {
    return this.ip;
  }

  public void setIp(String ip)
  {
    this.ip = ip;
  }

  public String getMethod()
  {
    return this.method;
  }

  public void setMethod(String method)
  {
    this.method = method;
  }

  public List<RecordParameter> getRecordParametersList()
  {
    return this.recordParametersList;
  }

  public void setRecordParametersList(List<RecordParameter> recordParametersList)
  {
    this.recordParametersList = recordParametersList;
  }

  public Integer getState()
  {
    return this.state;
  }

  public void setState(Integer state)
  {
    this.state = state;
  }

  public String getModule()
  {
    return this.module;
  }

  public void setModule(String module)
  {
    this.module = module;
  }

  public String getFunction()
  {
    return this.function;
  }

  public void setFunction(String function)
  {
    this.function = function;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = remark;
  }
}