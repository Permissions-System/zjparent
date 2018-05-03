package com.zjgt.util;

import java.io.PrintStream;
import java.math.BigDecimal;
import org.springfk.pancloud.utils.StringUtils;

public class NumberToCN
{
  private static final String[] CN_UPPER_NUMBER = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

  private static final String[] CN_UPPER_MONETRAY_UNIT = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
  private static final String CN_FULL = "整";
  private static final String CN_NEGATIVE = "负";
  private static final int MONEY_PRECISION = 2;
  private static final String CN_ZEOR_FULL = "零元整";
  static final String zhnum_0 = "零壹贰叁肆伍陆柒捌玖";
  static final String zhnum = "零一二三四五六七八九";
  static final String[] zhnum1 = { "", "十", "百", "千" };

  static final String[] zhnum1_0 = { "", "拾", "佰", "仟" };

  static final String[] zhnum2 = { "", "万", "亿", "万亿", "亿亿" };

  public static String number2CNMontrayUnit(BigDecimal numberOfMoney)
  {
    StringBuffer sb = new StringBuffer();

    int signum = numberOfMoney.signum();

    if (signum == 0) {
      return "零元整";
    }

    long number = numberOfMoney.movePointRight(2).setScale(0, 4).abs().longValue();

    long scale = number % 100L;
    int numUnit = 0;
    int numIndex = 0;
    boolean getZero = false;

    if (scale <= 0L) {
      numIndex = 2;
      number /= 100L;
      getZero = true;
    }
    if ((scale > 0L) && (scale % 10L <= 0L)) {
      numIndex = 1;
      number /= 10L;
      getZero = true;
    }
    int zeroSize = 0;

    while (number > 0L)
    {
      numUnit = (int)(number % 10L);
      if (numUnit > 0) {
        if ((numIndex == 9) && (zeroSize >= 3)) {
          sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
        }
        if ((numIndex == 13) && (zeroSize >= 3)) {
          sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
        }
        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
        sb.insert(0, CN_UPPER_NUMBER[numUnit]);
        getZero = false;
        zeroSize = 0;
      } else {
        ++zeroSize;
        if (!(getZero)) {
          sb.insert(0, CN_UPPER_NUMBER[numUnit]);
        }
        if (numIndex == 2) {
          if (number > 0L)
            sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
        }
        else if (((numIndex - 2) % 4 == 0) && (number % 1000L > 0L)) {
          sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
        }
        getZero = true;
      }

      number /= 10L;
      ++numIndex;
    }

    if (signum == -1) {
      sb.insert(0, "负");
    }

    if (scale <= 0L) {
      sb.append("整");
    }
    return sb.toString();
  }

  private static String numberToZH4(String s, boolean fan)
  {
    StringBuilder sb = new StringBuilder();
    if (s.length() != 4)
      return null;
    for (int i = 0; i < 4; ++i) {
      char c1 = s.charAt(i);
      if ((c1 == '0') && (i > 1) && (s.charAt(i - 1) == '0'))
        continue;
      if ((c1 != '0') && (i > 1) && (s.charAt(i - 1) == '0'))
        sb.append(38646);
      if (c1 != '0') {
        if (fan) {
          sb.append("零壹贰叁肆伍陆柒捌玖".charAt(c1 - '0'));
          sb.append(zhnum1_0[(4 - i - 1)]);
        } else {
          sb.append("零一二三四五六七八九".charAt(c1 - '0'));
          sb.append(zhnum1[(4 - i - 1)]);
        }
      }
    }
    return new String(sb);
  }

  public static String numberToZH(long n, boolean fan) {
    StringBuilder sb = new StringBuilder();
    String strN = new StringBuilder().append("000").append(n).toString();
    int strN_L = strN.length() / 4;
    strN = strN.substring(strN.length() - (strN_L * 4));
    for (int i = 0; i < strN_L; ++i) {
      String s1 = strN.substring(i * 4, i * 4 + 4);
      String s2 = numberToZH4(s1, fan);
      sb.append(s2);
      if (s2.length() != 0)
        sb.append(zhnum2[(strN_L - i - 1)]);
    }
    String s = new String(sb);
    if ((s.length() != 0) && (s.startsWith("零")))
      s = s.substring(1);
    return s;
  }

  public static String numberToZH(String str, boolean fan)
  {
    StringBuilder sb = new StringBuilder();
    int dot = str.indexOf(".");
    if (dot < 0) {
      dot = str.length();
    }
    String zhengshu = str.substring(0, dot);
    sb.append(numberToZH(Long.parseLong(zhengshu), fan));
    if (dot != str.length()) {
      sb.append("点");
      String xiaoshu = str.substring(dot + 1);
      for (int i = 0; i < xiaoshu.length(); ++i) {
        if (fan) {
          sb.append("零壹贰叁肆伍陆柒捌玖".charAt(Integer.parseInt(xiaoshu.substring(i, i + 1))));
        }
        else {
          sb.append("零一二三四五六七八九".charAt(Integer.parseInt(xiaoshu.substring(i, i + 1))));
        }
      }
    }

    String s = new String(sb);
    if (s.startsWith("零"))
      s = s.substring(1);
    if (s.startsWith("一十"))
      s = s.substring(1);
    while (s.endsWith("零")) {
      s = s.substring(0, s.length() - 1);
    }
    if (s.endsWith("点"))
      s = s.substring(0, s.length() - 1);
    return s;
  }

  public static String numberToZH(double d, boolean fan) {
    return numberToZH(new StringBuilder().append("").append(d).toString(), fan);
  }

  public static String[] convertLoanRMBTable2CN(double value)
  {
    String[] str = convertLoanRMBTable(value);
    String[] chStr = new String[str.length];
    for (int i = 0; i < str.length; ++i) {
      if (str[i].equals("-")) {
        chStr[i] = "";
      } else {
        chStr[i] = numberToZH(str[i], true);
        if (StringUtils.isEmpty(chStr[i])) {
          chStr[i] = "零";
        }
      }
    }
    return chStr;
  }

  public static String[] convertLoanRMBTable(double value)
  {
    String million = ""; String lakh = ""; String tenThousand = ""; String thousand = ""; String hundred = ""; String ten = ""; String one = ""; String dime = ""; String cent = "";
    long midVal = (long) ((value + 1.0E-006D) * 1000.0D / 10.0D);
    String valStr = String.valueOf(midVal);

    if (valStr.length() == 1) {
      valStr = new StringBuilder().append("0").append(valStr).toString();
    }
    String head = valStr.substring(0, valStr.length() - 2);
    String rail = valStr.substring(valStr.length() - 2);
    int headLen = head.length();
    dime = new StringBuilder().append(rail.charAt(0)).append("").toString();
    cent = new StringBuilder().append(rail.charAt(1)).append("").toString();

    if (headLen < 7) {
      head = new StringBuilder().append("-").append(head).toString();
      int headLen2 = head.length();
      if (headLen2 < 7) {
        String added = "";
        for (int i = 0; i < 7 - headLen2; ++i) {
          added = new StringBuilder().append(added).append("-").toString();
        }
        head = new StringBuilder().append(added).append(head).toString();
      }
      million = ("-".equals(Character.valueOf(head.charAt(0)))) ? "" : new StringBuilder().append(head.charAt(0)).append("").toString();
      lakh = ("-".equals(Character.valueOf(head.charAt(1)))) ? "" : new StringBuilder().append(head.charAt(1)).append("").toString();
      tenThousand = ("-".equals(Character.valueOf(head.charAt(2)))) ? "" : new StringBuilder().append(head.charAt(2)).append("").toString();
      thousand = ("-".equals(Character.valueOf(head.charAt(3)))) ? "" : new StringBuilder().append(head.charAt(3)).append("").toString();
      hundred = ("-".equals(Character.valueOf(head.charAt(4)))) ? "" : new StringBuilder().append(head.charAt(4)).append("").toString();
      ten = ("-".equals(Character.valueOf(head.charAt(5)))) ? "" : new StringBuilder().append(head.charAt(5)).append("").toString();
      one = ("-".equals(Character.valueOf(head.charAt(6)))) ? "" : new StringBuilder().append(head.charAt(6)).append("").toString();
    } else if (headLen == 7) {
      million = new StringBuilder().append(head.charAt(0)).append("").toString();
      lakh = new StringBuilder().append(head.charAt(1)).append("").toString();
      tenThousand = new StringBuilder().append(head.charAt(2)).append("").toString();
      thousand = new StringBuilder().append(head.charAt(3)).append("").toString();
      hundred = new StringBuilder().append(head.charAt(4)).append("").toString();
      ten = new StringBuilder().append(head.charAt(5)).append("").toString();
      one = new StringBuilder().append(head.charAt(6)).append("").toString();
    }

    return new String[] { ("-".equals(million)) ? lakh : new StringBuilder().append(million).append(lakh).toString(), tenThousand, thousand, hundred, ten, one, dime, cent };
  }

  public static void main(String[] args)
  {
    String[] ints = convertLoanRMBTable(1265800.25D);
    for (int i = 0; i < ints.length; ++i) {
      System.out.print(new StringBuilder().append(ints[i]).append(",").toString());
    }

    String[] ints2 = convertLoanRMBTable2CN(1265800.25D);
    for (int i = 0; i < ints2.length; ++i)
      System.out.print(new StringBuilder().append(ints2[i]).append(",").toString());
  }
}