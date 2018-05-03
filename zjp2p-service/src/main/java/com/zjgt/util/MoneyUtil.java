package com.zjgt.util;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyUtil
{
  private static final Pattern AMOUNT_PATTERN = Pattern.compile("^(0|[1-9]\\d{0,11})\\.(\\d\\d)$");

  private static final char[] RMB_NUMS = "零壹贰叁肆伍陆柒捌玖".toCharArray();
  private static final String[] UNITS = { "元", "角", "分", "整" };
  private static final String[] U1 = { "", "拾", "佰", "仟" };
  private static final String[] U2 = { "", "万", "亿" };

  public static String convert(String amount)
    throws IllegalArgumentException
  {
    amount = amount.replace(",", "");

    if (amount.equals("0.00")) {
      throw new IllegalArgumentException("金额不能为零.");
    }
    Matcher matcher = AMOUNT_PATTERN.matcher(amount);
    if (!(matcher.find())) {
      throw new IllegalArgumentException("输入金额有误.");
    }

    String integer = matcher.group(1);
    String fraction = matcher.group(2);

    String result = "";
    if (!(integer.equals("0"))) {
      result = new StringBuilder().append(result).append(integer2rmb(integer)).append(UNITS[0]).toString();
    }
    if (fraction.equals("00"))
      result = new StringBuilder().append(result).append(UNITS[3]).toString();
    else if ((fraction.startsWith("0")) && (integer.equals("0")))
      result = new StringBuilder().append(result).append(fraction2rmb(fraction).substring(1)).toString();
    else {
      result = new StringBuilder().append(result).append(fraction2rmb(fraction)).toString();
    }

    return result;
  }

  private static String fraction2rmb(String fraction)
  {
    char jiao = fraction.charAt(0);
    char fen = fraction.charAt(1);
    return new StringBuilder().append(RMB_NUMS[(jiao - '0')]).append((jiao > '0') ? UNITS[1] : "").append((fen > '0') ? new StringBuilder().append(RMB_NUMS[(fen - '0')]).append(UNITS[2]).toString() : "").toString();
  }

  private static String integer2rmb(String integer)
  {
    StringBuilder buffer = new StringBuilder();

    int i = integer.length() - 1; for (int j = 0; i >= 0; ++j) {
      char n = integer.charAt(i);
      if (n == '0')
      {
        if ((i < integer.length() - 1) && (integer.charAt(i + 1) != '0')) {
          buffer.append(RMB_NUMS[0]);
        }

        if ((j % 4 == 0) && ((
          ((i > 0) && (integer.charAt(i - 1) != '0')) || ((i > 1) && (integer.charAt(i - 2) != '0')) || ((i > 2) && (integer.charAt(i - 3) != '0')))))
        {
          buffer.append(U2[(j / 4)]);
        }
      }
      else {
        if (j % 4 == 0) {
          buffer.append(U2[(j / 4)]);
        }
        buffer.append(U1[(j % 4)]);
        buffer.append(RMB_NUMS[(n - '0')]);
      }
      --i;
    }

    return buffer.reverse().toString();
  }

  public static String moneyFormat(String money)
  {
    StringBuffer sb = new StringBuffer();
    if (money == null) {
      return "0.00";
    }
    int index = money.indexOf(".");
    if (index == -1) {
      return new StringBuilder().append(money).append(".00").toString();
    }
    String s0 = money.substring(0, index);
    String s1 = money.substring(index + 1);
    if (s1.length() == 1)
      s1 = new StringBuilder().append(s1).append("0").toString();
    else if (s1.length() > 2) {
      s1 = s1.substring(0, 2);
    }
    sb.append(s0);
    sb.append(".");
    sb.append(s1);

    return sb.toString();
  }

  public static void main(String[] args)
  {
    System.out.println(convert("134567.12"));
  }
}