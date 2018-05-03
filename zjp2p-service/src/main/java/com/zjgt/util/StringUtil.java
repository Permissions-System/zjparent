package com.zjgt.util;

public class StringUtil
{
  public static String CheckEnter(String str)
  {
    return str.replaceAll("\r\n", "</br>");
  }

  public static boolean isEmpty(String str)
  {
    return ((str == null) || (str.isEmpty()));
  }

  public static boolean isNotEmpty(String str)
  {
    return (!(isEmpty(str)));
  }

  public static String dislodgeImage(String str) {
    while (str.indexOf("<img") != -1) {
      int begin = str.indexOf("<img");
      int end = str.indexOf(">", begin);
      String image = str.substring(begin, end + 1);
      str = str.replace(image, "");
      str = str.replace("&nbsp;", "");
    }
    return str;
  }

  public static boolean equalWith(String org, String[] orgs) {
    if (isEmpty(org)) {
      return false;
    }
    for (String org1 : orgs) {
      if (org.equals(org1)) {
        return true;
      }
    }
    return false;
  }
}