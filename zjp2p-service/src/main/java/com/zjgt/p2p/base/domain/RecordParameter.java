package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class RecordParameter
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private String value;
  private OperatingRecord record;

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public OperatingRecord getRecord()
  {
    return this.record;
  }

  public void setRecord(OperatingRecord record)
  {
    this.record = record;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }
}