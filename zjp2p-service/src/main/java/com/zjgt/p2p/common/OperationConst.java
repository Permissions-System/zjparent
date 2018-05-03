package com.zjgt.p2p.common;

public enum OperationConst
{
  Register, Invest, Login, Browser, BankCardTied;

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