package com.zjgt.p2p.base.service.impl.serial;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public abstract class StringUtil
{
  public static String repeat(char chr, int times)
  {
    char[] chrs = new char[times];
    Arrays.fill(chrs, chr);
    return new String(chrs);
  }

  public static boolean isEmpty(String str)
  {
    return ((null == str) || ("".equals(str)) || ("null".equalsIgnoreCase(str)));
  }

  public static String subString(String input, int length, String encoding)
    throws UnsupportedEncodingException
  {
    int characterNum = input.length();

    int total = 0;

    int len = 0;

    for (int i = 0; i < characterNum; ++i)
    {
      String temp = input.substring(i, i + 1);
      int temp_len = temp.getBytes(encoding).length;

      total += temp_len;

      if (total > length) break;
      ++len;
    }

    return input.substring(0, len);
  }
}