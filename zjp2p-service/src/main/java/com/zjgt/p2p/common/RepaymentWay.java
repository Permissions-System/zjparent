package com.zjgt.p2p.common;

public enum RepaymentWay
{
  MONTH, MONTHMONEY, FINISHED;

  private int key;
  private String value;

  public int getKey()
  {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }

  public static String getValue(int key) {
    if (key == MONTH.key)
      return MONTH.value;
    if (key == MONTHMONEY.key)
      return MONTHMONEY.value;
    if (key == FINISHED.key) {
      return FINISHED.value;
    }
    return null;
  }
}