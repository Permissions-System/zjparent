package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class Area
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private String areaCode;
  private String areaName;

  public String getAreaCode()
  {
    return this.areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = ((areaCode == null) ? null : areaCode.trim());
  }

  public String getAreaName() {
    return this.areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = ((areaName == null) ? null : areaName.trim());
  }
}