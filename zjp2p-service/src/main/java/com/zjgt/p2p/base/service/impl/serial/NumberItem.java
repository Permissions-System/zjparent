package com.zjgt.p2p.base.service.impl.serial;

import java.text.DecimalFormat;

public class NumberItem
  implements SerialItem
{
  private final String numberFormat;
  private final Long number;

  public NumberItem(Long number, int length)
  {
    this.number = number;
    this.numberFormat = StringUtil.repeat('0', length);
  }

  public String getString()
  {
    if (this.number == null) {
      return "";
    }
    if (this.numberFormat != null) {
      return new DecimalFormat(this.numberFormat).format(this.number);
    }
    return String.valueOf(this.number);
  }
}