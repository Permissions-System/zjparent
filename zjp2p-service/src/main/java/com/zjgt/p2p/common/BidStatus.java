package com.zjgt.p2p.common;

public enum BidStatus
{
  INVESTING, INVESTED_ACCR, INVESTED, FINISHED, UNFULL, BADBIDING, BADBID, UNPUBLISH;

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
    for (BidStatus bidStatus : values()) {
      if (bidStatus.key == key)
        return bidStatus.value;
    }
    return null;
  }
}