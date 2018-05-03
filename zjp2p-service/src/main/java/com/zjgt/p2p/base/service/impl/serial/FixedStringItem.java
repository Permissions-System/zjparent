package com.zjgt.p2p.base.service.impl.serial;

public class FixedStringItem
  implements SerialItem
{
  public static final int BEFORE = 0;
  public static final int AFTER = 1;
  private String value;
  private Integer length;
  private char fill;
  private int type;

  public FixedStringItem(String value)
  {
    this.value = value;
  }

  public String getString()
  {
    if (this.value == null) {
      this.value = "";
    }
    if (this.length == null) {
      return this.value;
    }
    char[] source = this.value.toCharArray();
    int len = source.length;
    if (len == this.length.intValue()) {
      return this.value;
    }
    char[] target = new char[this.length.intValue()];
    if (len < this.length.intValue())
    {
      int i;
      if (this.type == 0) {
        for (i = 0; i < this.length.intValue() - len; ++i) {
          target[i] = this.fill;
        }
        System.arraycopy(source, 0, target, this.length.intValue() - len, len);
      } else {
        for (i = this.length.intValue() - len; i < this.length.intValue(); ++i) {
          target[i] = this.fill;
        }
        System.arraycopy(source, 0, target, 0, len);
      }
      return new String(target);
    }
    if (this.type == 0) {
      return this.value.substring(len - this.length.intValue());
    }
    return this.value.substring(0, this.length.intValue());
  }

  public void setLength(int length, char fill, int type)
  {
    this.length = Integer.valueOf(length);
    this.fill = fill;
    this.type = type;
  }
}