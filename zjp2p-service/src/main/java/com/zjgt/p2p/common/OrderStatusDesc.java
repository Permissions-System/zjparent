package com.zjgt.p2p.common;

public enum OrderStatusDesc
{
  PreINTEREST, BEWAITED, REDEEMED, NORMAL, TRANSFERING, TRANSFERED, TRANSFERLOSE, TransFered, BadBID;

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