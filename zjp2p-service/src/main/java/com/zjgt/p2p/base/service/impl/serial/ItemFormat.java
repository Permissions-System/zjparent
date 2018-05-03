package com.zjgt.p2p.base.service.impl.serial;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ItemFormat
{
  String key;
  int length;
  char type;
  char fillin;
  boolean fillBefore;

  public String getKey()
  {
    return this.key;
  }

  public int getLength() {
    return this.length;
  }

  public String format(Object value)
  {
    return format(value, this.fillin);
  }

  public String format(Object value, char fillin)
  {
    return format(value, fillin, true);
  }

  public String format(Object value, char fillin, boolean fillBefore)
  {
    if (value == null) {
      return "";
    }
    if (this.type == 'C') {
      FixedStringItem fsi = new FixedStringItem(String.valueOf(value));
      fsi.setLength(this.length, fillin, (fillBefore) ? 0 : 1);

      return fsi.getString(); }
    if (this.type == 'N') {
      Long num = Long.valueOf(String.valueOf(value));
      NumberItem ni = new NumberItem(num, this.length);
      return ni.getString(); }
    if (this.type == 'A') {
      return "";
    }
    return formatDate(value, this.type, this.length);
  }

  private String formatDate(Object date, char type, int len)
  {
    if (date == null) {
      return "";
    }
    if (date instanceof String)
      return ((String)date);
    char target;
    if ((type == 'M') || (type == 'H') || (type == 'm'))
      target = type;
    else {
      target = Character.toLowerCase(type);
    }
    String format = StringUtil.repeat(target, len);
    SimpleDateFormat sdf = new SimpleDateFormat(format);
    DateFormatSymbols symbols = new DateFormatSymbols(Locale.US);
    sdf.setDateFormatSymbols(symbols);
    SimpleStringItem ssi = new SimpleStringItem(sdf.format(date));
    return ssi.getString();
  }

  public static final ItemFormat parse(String str, boolean isFunction)
  {
    if (StringUtil.isEmpty(str)) {
      return null;
    }
    String[] arr = str.split(",");
    if (arr.length > 1) {
      ItemFormat iformat = new ItemFormat();
      if ((isFunction) && 
        ("DATE".equals(arr[0]))) {
        iformat = new ItemFormatDateFunction(arr[1]);
      }

      iformat.key = arr[0];
      iformat.type = arr[1].charAt(0);
      if (iformat.length == 0) {
        iformat.length = Integer.parseInt(arr[1].substring(1).trim());
      }
      return iformat;
    }
    return null;
  }
}