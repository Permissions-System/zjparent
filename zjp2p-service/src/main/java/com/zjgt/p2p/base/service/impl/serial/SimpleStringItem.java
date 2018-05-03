package com.zjgt.p2p.base.service.impl.serial;

public class SimpleStringItem
  implements SerialItem
{
  private String value;

  public SimpleStringItem(String value)
  {
    this.value = value;
  }

  public String getString()
  {
    return ((this.value == null) ? "" : this.value);
  }
}