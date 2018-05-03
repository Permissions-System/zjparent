package com.zjgt.p2p.base.util;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;

public class CommonUtil
{
  public static final String DATABASE_TYPE = null;
  public static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static String date2Str(Date date, String format)
  {
    SimpleDateFormat sf = new SimpleDateFormat(format);

    String dateStr = sf.format(date);

    return dateStr;
  }

  public static String removeHTMLTags(String input)
  {
    if ((input == null) || (input.trim().equals(""))) {
      return "";
    }

    String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");

    str = str.replaceAll("[(/>)<]", "");

    return str;
  }

  public static String transform(String template, Map<String, Object> context)
  {
    if (context == null) {
      return template;
    }
    Iterator it = context.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      String name = new StringBuilder().append("${").append((String)entry.getKey()).append("}").toString();
      if (entry.getValue() != null)
        template = StringUtils.replace(template, name, entry.getValue().toString());
      else {
        template = StringUtils.replace(template, name, "");
      }
    }
    return template;
  }

  public static String cleanPersonName(String name)
  {
    char spacer = 183;
    if (!(StringUtils.isEmpty(name))) {
      name = name.replace('.', spacer);
      name = name.replace((char) 65294, spacer);
      name = name.replace((char) 12290, spacer);
    }
    return name;
  }

  public static String cgDateMonth(int nt, int mt, int it)
  {
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    GregorianCalendar cal = new GregorianCalendar();
    try {
      cal.setTime(ft.parse(new StringBuilder().append(nt).append("-").append(mt).append("-01").toString()));

      cal.add(2, it);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return new StringBuilder().append(cal.get(1)).append("-").append((cal.get(2) + 1 < 10) ? "0" : "").append(cal.get(2) + 1).toString();
  }

  public static String cgNull(String str, String defaultStr)
  {
    String vs = "";
    String tmp = new StringBuilder().append(str).append("").toString().trim();
    if (("".equals(tmp)) || (null == tmp) || ("null".equals(tmp.toLowerCase())))
      vs = defaultStr;
    else {
      vs = str;
    }
    return vs;
  }

  public static boolean isNull(String str)
  {
    return ((str == null) || (str.length() == 0) || ("undefined".equals(str)));
  }

  public static boolean isNotNull(String str)
  {
    return (!(isNull(str)));
  }

  public static String getItID()
  {
    Calendar td = Calendar.getInstance();

    int yea = td.get(1);
    int mon = td.get(2) + 1;
    int day = td.get(5);
    int hou = td.get(11);
    int min = td.get(12);
    int sec = td.get(13);
    int mil = td.get(14);

    String mons = new StringBuilder().append("").append(mon).toString();
    String days = new StringBuilder().append("").append(day).toString();
    String hous = new StringBuilder().append("").append(hou).toString();
    String mins = new StringBuilder().append("").append(min).toString();
    String secs = new StringBuilder().append("").append(sec).toString();
    String mils = new StringBuilder().append("").append(mil).toString();

    if (hou < 10) {
      hous = new StringBuilder().append("0").append(hou).toString();
    }
    if (min < 10) {
      mins = new StringBuilder().append("0").append(min).toString();
    }
    if (sec < 10) {
      secs = new StringBuilder().append("0").append(sec).toString();
    }
    if (mon < 10) {
      mons = new StringBuilder().append("0").append(mon).toString();
    }
    if (day < 10) {
      days = new StringBuilder().append("0").append(day).toString();
    }
    if (mil < 10) {
      mils = new StringBuilder().append("00").append(mil).toString();
    }
    else if (mil < 100)
      mils = new StringBuilder().append("0").append(mil).toString();
    else {
      mils = String.valueOf(mil);
    }

    String vs = "";
    for (int i = 0; i < 1000; ++i)
    {
      vs = String.valueOf(Math.round(Math.random() * 99999999.0D + 1.0D));

      int ft = vs.length();
      for (int t = 0; t < 8 - ft; ++t) {
        vs = new StringBuilder().append("0").append(vs).toString();
      }
    }
    return new StringBuilder().append("").append(yea).append("").append(mons).append("").append(days).append("").append(hous).append("").append(mins).append("").append(secs).append("").append(mils).append(vs).toString();
  }

  public static String getUUID()
  {
    return UUID.randomUUID().toString().replace("-", "");
  }

  public static String getItRandom(int it)
  {
    String[] itArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    String str = "";
    for (int i = 0; i < it; ++i) {
      str = new StringBuilder().append(str).append("").append(itArray[getInt(0, itArray.length - 1)]).toString();
    }
    return str;
  }

  public static int getInt(int min, int max)
  {
    Random random = new Random();

    int it = random.nextInt(max + 1);
    if (it < min) {
      it = getInt(min, max);
    }
    return it;
  }

  public static Double formatDouble(Double data, String ft)
  {
    return Double.valueOf(new DecimalFormat(ft).format(data));
  }

  public static BigDecimal formatDecimal(BigDecimal data)
  {
    if (data == null) {
      return null;
    }
    return BigDecimal.valueOf(Double.valueOf(new DecimalFormat("#,###.00").format(data)).doubleValue());
  }

  public static double formatDoubleExt(Double doubleValue, int s)
  {
    return new BigDecimal(doubleValue.toString()).setScale(s, 4).doubleValue();
  }

  public static float formatFloatExt(Double doubleValue, int s)
  {
    return new BigDecimal(doubleValue.toString()).setScale(s, 4).floatValue();
  }

  public static Date getSysDateTime()
  {
    return Calendar.getInstance().getTime();
  }

  public static String getLongSysDate()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
  }

  public static String getSysDate()
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
  }

  public static String getSysDate(String ft)
  {
    return new SimpleDateFormat(ft).format(Calendar.getInstance().getTime());
  }

  public static String getCtYearMonth()
  {
    return new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
  }

  public static String getCtYear()
  {
    return new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
  }

  public static String getCtMonth()
  {
    return new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
  }

  public static String getCtDay()
  {
    return new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());
  }

  public static String getFtDate(String dt)
  {
    if ((isNotNull(dt)) || (dt.length() > 10)) {
      return dt.substring(0, 10);
    }
    return "";
  }

  public static String getFtDate(Date dt)
  {
    return getFtDate(dt, "yyyy-MM-dd");
  }

  public static String getFtDate(Date dt, String ft)
  {
    if (dt != null) {
      return new SimpleDateFormat(ft).format(Long.valueOf(dt.getTime()));
    }
    return "";
  }

  public static Date getCtDate(String dt)
  {
    Date ft = null;
    if ((isNotNull(dt)) || (dt.length() > 10)) {
      try {
        ft = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(dt).getTime());
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return ft;
  }

  public static int cgNtDate(String a, String b)
  {
    int a1 = Integer.parseInt(a.split("-")[0], 10);
    int a2 = Integer.parseInt(a.split("-")[1], 10);
    int b1 = Integer.parseInt(b.split("-")[0], 10);
    int b2 = Integer.parseInt(b.split("-")[1], 10);
    return (a1 * 12 + a2 - (b1 * 12) - b2 + 1);
  }

  public static long getItDifferenceDate(Date date1, Date date2)
  {
    return ((date2.getTime() - date1.getTime()) / 86400000L);
  }

  public static long getItDifferenceSeconds(Date date1, Date date2)
  {
    return ((date2.getTime() - date1.getTime()) / 1000L);
  }

  public static int getItDifferenceDate(String a, String b)
  {
    int a1 = Integer.parseInt(a.split("-")[0], 10);
    int a2 = Integer.parseInt(a.split("-")[1], 10);
    int b1 = Integer.parseInt(b.split("-")[0], 10);
    int b2 = Integer.parseInt(b.split("-")[1], 10);
    return (a1 * 12 + a2 - (b1 * 12) - b2 + 1);
  }

  public static String[] getWeekDayDate(Date date)
  {
    Calendar cal = Calendar.getInstance(Locale.CHINA);

    if (null == date)
      cal.setTimeInMillis(System.currentTimeMillis());
    else {
      cal.setTimeInMillis(date.getTime());
    }
    return getMondayToSunday(cal);
  }

  public static String getAddMonthDate(String date, int ik, String flag)
  {
    Calendar cal = Calendar.getInstance();

    String[] dt = date.split("-", -1);

    cal.set(1, Integer.valueOf(dt[0]).intValue());
    cal.set(2, Integer.valueOf(dt[1]).intValue() + ik - 1);

    String sp = "";
    if ("0".equals(flag))
      sp = "yyyyMM";
    else {
      sp = "yyyy-MM";
    }
    return new SimpleDateFormat(sp).format(cal.getTime());
  }

  public static String formatDate(Date date, String ft)
  {
    return ((date == null) ? "" : new SimpleDateFormat(ft).format(date));
  }

  public static String[] getOtherWeeks(int week)
  {
    Calendar cal = Calendar.getInstance();
    cal.add(5, week * 7);
    return getMondayToSunday(cal);
  }

  public static String[] getOtherWeeks(int week, Date date)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(5, week * 7);
    return getMondayToSunday(cal);
  }

  public static int getLastDayOfMonth(int year, int month)
  {
    Calendar cal = Calendar.getInstance();
    cal.set(1, year);
    cal.set(2, month);

    return cal.getActualMaximum(5);
  }

  private static String[] getMondayToSunday(Calendar cal)
  {
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    cal.setFirstDayOfWeek(2);
    cal.set(7, 2);
    String monday = ft.format(cal.getTime());
    cal.set(7, 3);
    String tuesday = ft.format(cal.getTime());
    cal.set(7, 4);
    String wednesday = ft.format(cal.getTime());
    cal.set(7, 5);
    String thursday = ft.format(cal.getTime());
    cal.set(7, 6);
    String friday = ft.format(cal.getTime());
    cal.set(7, 7);
    String saturday = ft.format(cal.getTime());
    cal.set(7, 1);
    String sunday = ft.format(cal.getTime());
    return new String[] { monday, tuesday, wednesday, thursday, friday, saturday, sunday };
  }

  public static List<String> getCurrentMonthDays()
  {
    Calendar cal = Calendar.getInstance();
    int curMaxDay = cal.getActualMaximum(5);
    int curYear = cal.get(1);
    int curMonth = cal.get(2) + 1;
    return getMonthDays(curYear, curMonth, curMaxDay);
  }

  public static List<String> getLastMonthDays()
  {
    Calendar cale = Calendar.getInstance();

    cale.set(5, 1);

    cale.add(5, -1);
    int maxDay = cale.getActualMaximum(5);
    int year = cale.get(1);
    int month = cale.get(2) + 1;
    return getMonthDays(year, month, maxDay);
  }

  public static List<String> getMonthDays(int year, int month, int days)
  {
    List monthDays = new ArrayList();
    String formatMonth = new StringBuilder().append(month).append("").toString();
    if (month < 10) {
      formatMonth = new StringBuilder().append("0").append(month).toString();
    }
    for (int i = 1; i <= days; ++i) {
      String day = "";
      if (i < 10)
        day = new StringBuilder().append(year).append("-").append(formatMonth).append("-0").append(i).toString();
      else {
        day = new StringBuilder().append(year).append("-").append(formatMonth).append("-").append(i).toString();
      }
      monthDays.add(day);
    }
    return monthDays;
  }

  public static int getDaysBetween(Date date1, Date date2)
  {
    long n1 = date1.getTime();
    long n2 = date2.getTime();
    Long diff = Long.valueOf(Math.abs(n1 - n2));
    diff = Long.valueOf(diff.longValue() / 86400000L);
    return diff.intValue();
  }

  public static int getWeeksBetweenDates(Date startDate, Date endDate)
  {
    Calendar dateFrom = Calendar.getInstance();
    dateFrom.setFirstDayOfWeek(2);
    dateFrom.setTime(startDate);
    Calendar dateTo = Calendar.getInstance();
    dateTo.setFirstDayOfWeek(2);
    dateTo.setTime(endDate);
    int yearFrom = dateFrom.get(1);
    int yearTo = dateTo.get(1);
    int weeksBetween = 0;

    int weekFrom = dateFrom.get(3);
    if ((weekFrom == 1) && (dateFrom.get(2) == 11)) {
      dateFrom.set(yearFrom, 11, 25, 23, 59, 59);
      weeksBetween -= dateFrom.get(3);
    }
    weeksBetween -= weekFrom;

    for (int i = 1; i <= yearTo - yearFrom; ++i) {
      Calendar _lastDay = Calendar.getInstance();
      _lastDay.setFirstDayOfWeek(2);
      _lastDay.set(yearFrom + i, 11, 25, 23, 59, 59);
      weeksBetween += _lastDay.get(3);
    }

    int weekTo = dateTo.get(3);
    if ((weekTo == 1) && (dateTo.get(2) == 11)) {
      dateTo.set(yearTo, 11, 25, 23, 59, 59);
      weeksBetween += dateTo.get(3);
    }
    weeksBetween += weekTo;
    return weeksBetween;
  }

  public static List<Date[]> getStartEndDateOfWeekInMonth(int year, int month) {
    Locale.setDefault(Locale.CHINESE);
    List results = new ArrayList();
    Calendar calendarDate = Calendar.getInstance();
    calendarDate.set(1, year);
    calendarDate.set(2, month);
    calendarDate.set(5, 1);
    calendarDate.set(11, 0);
    calendarDate.set(12, 0);
    calendarDate.set(13, 0);
    Calendar firstDayOfWeek = (Calendar)calendarDate.clone();
    Calendar endDayOfWeek = (Calendar)calendarDate.clone();
    Date[] dates;
    do {
      Calendar weekDay = (Calendar)calendarDate.clone();

      weekDay.add(7, -1);

      if (weekDay.get(7) == 7) {
        endDayOfWeek = (Calendar)calendarDate.clone();
        dates = new Date[] { firstDayOfWeek.getTime(), endDayOfWeek.getTime() };
        results.add(dates);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(calendarDate.getTime());
        calendar.add(6, 1);
        firstDayOfWeek = (Calendar)calendar.clone();
      }
      calendarDate.add(6, 1); }
    while (calendarDate.get(2) == month);
    if ((calendarDate.get(2) != month) && 
      (firstDayOfWeek.get(2) == month)) {
      Calendar lastDayOfMonth = Calendar.getInstance();
      lastDayOfMonth.set(1, year);
      lastDayOfMonth.set(2, month);
      lastDayOfMonth.set(5, lastDayOfMonth.getActualMaximum(5));

      lastDayOfMonth.set(11, 23);
      lastDayOfMonth.set(12, 59);
      lastDayOfMonth.set(13, 59);
      dates = new Date[] { firstDayOfWeek.getTime(), lastDayOfMonth.getTime() };
      results.add(dates);
    }

    return results;
  }

  public static Date[] getStartEndDateOfLastWeek()
  {
    Calendar currentDate = Calendar.getInstance();
    Calendar startDate = (Calendar)currentDate.clone();
    startDate.add(3, -1);
    startDate.set(7, 1);
    startDate.add(6, 1);
    startDate.set(11, 0);
    startDate.set(12, 0);
    startDate.set(13, 0);
    Calendar endDate = (Calendar)currentDate.clone();
    endDate.add(3, -1);
    endDate.set(7, 7);
    endDate.add(6, 1);
    endDate.set(11, 23);
    endDate.set(12, 59);
    endDate.set(13, 59);
    return new Date[] { startDate.getTime(), endDate.getTime() };
  }

  public static Date[] getStartEndDateOfLastMonth()
  {
    Calendar currentDate = Calendar.getInstance();
    Calendar startDate = (Calendar)currentDate.clone();
    startDate.add(2, -1);
    startDate.set(5, 1);
    startDate.set(11, 0);
    startDate.set(12, 0);
    startDate.set(13, 0);
    Calendar endDate = (Calendar)currentDate.clone();
    endDate.add(2, -1);
    endDate.set(5, endDate.getActualMaximum(5));

    endDate.set(11, 23);
    endDate.set(12, 59);
    endDate.set(13, 59);
    return new Date[] { startDate.getTime(), endDate.getTime() };
  }

  public static Date[] getStartEndDateOfYear(int year)
  {
    Calendar currentDate = Calendar.getInstance();
    Calendar startDate = (Calendar)currentDate.clone();
    startDate.set(1, year);
    startDate.set(2, 0);
    startDate.set(5, 1);
    startDate.set(11, 0);
    startDate.set(12, 0);
    startDate.set(13, 0);
    Calendar endDate = (Calendar)currentDate.clone();
    endDate.set(1, year);
    endDate.set(2, 11);
    endDate.set(5, 31);
    endDate.set(11, 23);
    endDate.set(12, 59);
    endDate.set(13, 59);
    return new Date[] { startDate.getTime(), endDate.getTime() };
  }

  public static Date getFirstDayOfCurrentMonth()
  {
    Calendar currentDate = Calendar.getInstance();
    Calendar firstDate = (Calendar)currentDate.clone();
    firstDate.set(5, 1);
    firstDate.set(11, 0);
    firstDate.set(12, 0);
    firstDate.set(13, 0);
    return firstDate.getTime();
  }

  public static Date dateAddDays(Date beginDate, int days)
  {
    Calendar c = Calendar.getInstance();
    c.setTime(beginDate);
    c.add(6, days);
    return c.getTime();
  }

  public static List<String> getWeekends(int year)
  {
    List list = new ArrayList();
    Calendar cal = Calendar.getInstance(Locale.CHINA);
    cal.set(year, 0, 1);
    for (int day = 1; day <= cal.getActualMaximum(6); ++day) {
      cal.set(6, day);
      int weekDay = cal.get(7);
      if ((weekDay == 7) || (weekDay == 1)) {
        list.add(FORMAT.format(cal.getTime()));
      }
    }
    return list;
  }

  public static List<String> getDateBetween(String date1, String date2, boolean isInclude)
  {
    List dateList = new ArrayList();
    if (date1.equals(date2)) {
      return dateList;
    }
    String tmp = "";
    if (date1.compareTo(date2) > 0) {
      tmp = date1;
      date1 = date2;
      date2 = tmp;
    }

    if (isInclude) {
      dateList.add(date1);
    }

    tmp = FORMAT.format(Long.valueOf(str2Date(date1).getTime() + 86400000L));

    while (tmp.compareTo(date2) < 0) {
      dateList.add(tmp);
      tmp = FORMAT.format(Long.valueOf(str2Date(tmp).getTime() + 86400000L));
    }

    if (isInclude) {
      dateList.add(date2);
    }

    return dateList;
  }

  public static Date str2Date(String str)
  {
    if (str == null)
      return null;
    try
    {
      return FORMAT.parse(str);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Date str2Date(String str, String format)
    throws ParseException
  {
    SimpleDateFormat sf = new SimpleDateFormat(format);

    return sf.parse(str);
  }

  public static List<Date[]> getStartEndDateListOfMonthBeforeAMonth(Date date, int monthNum)
  {
    List dateList = new ArrayList();
    Calendar currentDate = Calendar.getInstance();
    currentDate.setTime(date);
    for (int i = monthNum; i > 0; --i) {
      Calendar startDate = (Calendar)currentDate.clone();
      startDate.add(2, -i);
      startDate.set(5, 1);
      startDate.set(11, 0);
      startDate.set(12, 0);
      startDate.set(13, 0);
      Calendar endDate = (Calendar)currentDate.clone();
      endDate.add(2, -i);
      endDate.set(5, endDate.getActualMaximum(5));

      endDate.set(11, 23);
      endDate.set(12, 59);
      endDate.set(13, 59);
      dateList.add(new Date[] { startDate.getTime(), endDate.getTime() });
    }
    return dateList;
  }

  public static List<Date[]> getStartEndDateListOfMonthAfterAMonth(Date date, int monthNum)
  {
    List dateList = new ArrayList();
    Calendar currentDate = Calendar.getInstance();
    currentDate.setTime(date);
    for (int i = 0; i < monthNum; ++i) {
      Calendar startDate = (Calendar)currentDate.clone();
      startDate.add(2, i);
      startDate.set(5, 1);
      startDate.set(11, 0);
      startDate.set(12, 0);
      startDate.set(13, 0);
      Calendar endDate = (Calendar)currentDate.clone();
      endDate.add(2, i);

      endDate.set(5, endDate.getActualMaximum(5));
      endDate.set(11, 23);
      endDate.set(12, 59);
      endDate.set(13, 59);
      dateList.add(new Date[] { startDate.getTime(), endDate.getTime() });
    }
    return dateList;
  }

  public static String getBirthDate(int age)
  {
    return new StringBuilder().append(Calendar.getInstance().get(1) - age).append("-").append(new SimpleDateFormat("MM-dd").format(Calendar.getInstance().getTime())).toString();
  }

  public static String changeToUpperCaseRMB(double value)
  {
    char[] hunit = { 25342, 20336, 20191 };

    String[] vunit = { "万", "亿", "万亿", "万万亿" };

    char[] digit = { 38646, 22777, 36144, 21441, 32902, 20237, 38470, 26578, 25420, 29590 };

    String valStr = String.valueOf((value * 100.0D));

    String digitPart = valStr.substring(0, valStr.length() - 2);
    if (digitPart.length() > 20) {
      return "数值溢出";
    }

    String decimalPart = valStr.substring(valStr.length() - 2);

    String prefix = "";

    String suffix = "";

    if ((decimalPart.equals("00")) || (decimalPart.equals("0")))
      suffix = "整";
    else {
      suffix = new StringBuilder().append(digit[(decimalPart.charAt(0) - '0')]).append("角").append(digit[(decimalPart.charAt(1) - '0')]).append("分").toString();
    }

    char[] chDig = digitPart.toCharArray();
    char zero = '0';

    int zeroSerNum = 0;

    int totalDivZero = 0;

    int divIdx = (chDig.length - 1) / 4;

    for (int i = 0; i < chDig.length; ++i)
    {
      int idx = (chDig.length - i - 1) % 4;

      int vidx = (chDig.length - i - 1) / 4;

      if (chDig[i] == '0') {
        zero = digit[0];
        ++zeroSerNum;
        if (zero == '0') {
          zero = digit[0];
        } else if ((idx == 0) && (vidx > 0) && (zeroSerNum < 4)) {
          prefix = new StringBuilder().append(prefix).append(vunit[(vidx - 1)]).toString();
          zero = '0';
        }

        if (divIdx == vidx) {
          ++totalDivZero;
        }
        else
        {
          divIdx = vidx;
          if (totalDivZero == 4) {
            zero = '0';
            totalDivZero = 1;
          }
        }

      }
      else
      {
        if (divIdx != vidx) {
          divIdx = vidx;
          if (totalDivZero == 4) {
            zero = '0';
            totalDivZero = 0;
          }
        }

        zeroSerNum = 0;

        if (zero != '0') {
          prefix = new StringBuilder().append(prefix).append(zero).toString();
          zero = '0';
        }

        prefix = new StringBuilder().append(prefix).append(digit[(chDig[i] - '0')]).toString();
        if (idx > 0) {
          prefix = new StringBuilder().append(prefix).append(hunit[(idx - 1)]).toString();
        }
        if ((idx != 0) || (vidx <= 0))
          continue;
        prefix = new StringBuilder().append(prefix).append(vunit[(vidx - 1)]).toString();
      }
    }

    if (prefix.length() > 0) {
      prefix = new StringBuilder().append(prefix).append(22278).toString();
    }

    return new StringBuilder().append(prefix).append(suffix).toString();
  }

  public static String subString(String input, int len, boolean addDots)
  {
    if (input == null) {
      return "";
    }

    int inputLen = input.length();

    int count = 0;
    int i = 0;
    for (i = 0; i < inputLen; ++i) {
      char c = input.charAt(i);

      if (String.valueOf(c).getBytes().length >= 2)
        count += 2;
      else {
        ++count;
      }

      if (count >= len) {
        break;
      }
    }

    if (i == inputLen) {
      i = inputLen - 1;
    }

    String rtn = input.substring(0, i + 1);

    if ((!(rtn.equals(input))) && (addDots)) {
      rtn = new StringBuilder().append(rtn).append("...").toString();
    }

    return rtn;
  }

  public static String getStrBylength(String str, int len)
  {
    if (null == str) {
      return "";
    }
    int sl = str.getBytes().length;
    if (sl > len * 2) {
      StringBuffer sb = new StringBuffer();
      char[] arr = str.toCharArray();
      int i = 0;
      int j = 0;
      i = 0; for (j = 0; (i < arr.length) && (j < len * 2); ++i) {
        if (String.valueOf(arr[i]).matches("[^x00-xff]"))
          j += 2;
        else {
          ++j;
        }
        if ((j == len * 2 - 1) && (String.valueOf(arr[i]).matches("[^x00-xff]"))) {
          continue;
        }
        sb.append(arr[i]);
      }

      return sb.toString();
    }
    return str;
  }

  public static int getDoubleByteLength(String str)
  {
    int j = 0;
    if (null == str) {
      return 0;
    }
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length; ++i) {
      if (String.valueOf(arr[i]).matches("[^x00-xff]"))
        j += 2;
      else {
        ++j;
      }
    }

    return j;
  }

  public static <F, S extends F> List<S> transferListFToS(List<F> fathers)
  {
    List sons = new ArrayList();
    Iterator i$;
    if (fathers != null) {
      for (i$ = fathers.iterator(); i$.hasNext(); ) { Object source = i$.next();
        sons.add(source);
      }
    }
    return sons;
  }

  public static <F, S extends F> List<F> transferListSToF(List<S> sons)
  {
    List fathers = new ArrayList();
    if (sons != null) {
      fathers.addAll(sons);
    }
    return fathers;
  }

  public static String genAcChk(String s)
  {
    int secret = 0;
    if ((s == null) || (s.length() == 0)) {
      return null;
    }
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (!(Character.isDigit(c))) {
        return null;
      }
      int digit = c - '0';
      if (i % 2 == 0) {
        secret += digit;
      } else {
        digit *= 2;
        secret += digit % 10;
        secret += digit / 10;
      }
    }
    secret = (10 - (secret % 10)) % 10;
    return new StringBuilder().append("").append(secret).toString();
  }

  public static String getItDigitRandom(int it)
  {
    String[] itArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

    String str = "";
    for (int i = 0; i < it; ++i) {
      str = new StringBuilder().append(str).append("").append(itArray[getInt(0, itArray.length - 1)]).toString();
    }
    return str;
  }
}