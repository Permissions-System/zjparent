package com.zjgt.p2p.common;

public enum AcctType
{
  BASIC, GIFT, COMMISSION;

  private int key;
  private String value;

  public int getKey()
  {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public static String getBidStatus(int key) {
    for (AcctType bidStatus : values()) {
      if (bidStatus.key == key)
        return bidStatus.value;
    }
    return null;
  }
}