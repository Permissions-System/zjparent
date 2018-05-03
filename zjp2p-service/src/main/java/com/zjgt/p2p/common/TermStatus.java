package com.zjgt.p2p.common;

public enum TermStatus
{
  REPAYED, REPAYING, TRANSFER;

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