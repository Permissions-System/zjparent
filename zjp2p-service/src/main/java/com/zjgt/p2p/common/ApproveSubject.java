package com.zjgt.p2p.common;

public enum ApproveSubject
{
  LOSE, INCOME, PUBLISH, AGREE, REFUSE, TRANSFER;

  private int key;
  private String value;

  public int getKey()
  {
    return this.key;
  }

  public String getValue() {
    return this.value;
  }
}