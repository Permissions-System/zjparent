package com.zjgt.p2p.base.service.impl.serial;

import java.util.ArrayList;
import java.util.List;

public class CachedSerialCounter
{
  private List<Integer> counterList = new ArrayList();
  private String templateCode;

  public CachedSerialCounter(String templateCode)
  {
    this.templateCode = templateCode;
  }

  public String getTemplateCode() {
    return this.templateCode;
  }

  public void add(int counter)
  {
    this.counterList.add(Integer.valueOf(counter));
  }

  public Integer popFirst()
  {
    if (this.counterList.size() != 0) {
      return ((Integer)this.counterList.remove(0));
    }
    return null;
  }
}