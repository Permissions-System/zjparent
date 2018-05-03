package com.zjgt.p2p.base.service.impl.serial;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemFormatDateFunction extends ItemFormat
{
  private String format;

  public ItemFormatDateFunction(String format)
  {
    this.format = format;
    this.length = format.length();
  }

  public String getFormat() {
    return this.format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String format(Object value)
  {
    SimpleDateFormat df = new SimpleDateFormat(this.format);
    return df.format(new Date());
  }
}