package com.zjgt.util;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateConverterUtil
{
  private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

  private static final SimpleDateFormat serialFormat = new SimpleDateFormat("yyMMddHHmm");

  public static java.util.Date getDate(int datas)
  {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.add(5, datas);
    String begin = new java.sql.Date(calendar.getTime().getTime()).toString();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date beginDate = null;
    try {
      beginDate = sdf.parse(begin);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return beginDate;
  }

  public static String currentDatetime()
  {
    return datetimeFormat.format(new java.util.Date());
  }

  public static String formatDatetime(java.util.Date date)
  {
    return datetimeFormat.format(date);
  }

  public static String formatDatetime(java.util.Date date, String pattern)
  {
    SimpleDateFormat customFormat = (SimpleDateFormat)datetimeFormat.clone();

    customFormat.applyPattern(pattern);
    return customFormat.format(date);
  }

  public static String currentDate()
  {
    return dateFormat.format(now());
  }

  public static String seriaTime()
  {
    return serialFormat.format(now());
  }

  public static String formatDate(java.util.Date date)
  {
    return dateFormat.format(date);
  }

  public static String currentTime()
  {
    return timeFormat.format(now());
  }

  public static String formatTime(java.util.Date date)
  {
    return timeFormat.format(date);
  }

  public static java.util.Date now()
  {
    return new java.util.Date();
  }

  public static Calendar calendar() {
    Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
    cal.setFirstDayOfWeek(2);
    return cal;
  }

  public static long millis()
  {
    return System.currentTimeMillis();
  }

  public static int month()
  {
    return (calendar().get(2) + 1);
  }

  public static int dayOfMonth()
  {
    return calendar().get(5);
  }

  public static int dayOfWeek()
  {
    return calendar().get(7);
  }

  public static int dayOfYear()
  {
    return calendar().get(6);
  }

  public static boolean isBefore(java.util.Date src, java.util.Date dst)
  {
    return src.before(dst);
  }

  public static boolean isAfter(java.util.Date src, java.util.Date dst)
  {
    return src.after(dst);
  }

  public static boolean isEqual(java.util.Date date1, java.util.Date date2)
  {
    return (date1.compareTo(date2) == 0);
  }

  public static boolean between(java.util.Date beginDate, java.util.Date endDate, java.util.Date src)
  {
    return ((beginDate.before(src)) && (endDate.after(src)));
  }

  public static java.util.Date lastDayOfMonth()
  {
    Calendar cal = calendar();
    cal.set(5, 0);
    cal.set(11, 0);
    cal.set(12, 0);
    cal.set(13, 0);
    cal.set(14, 0);
    cal.set(2, cal.get(2) + 1);
    cal.set(14, -1);
    return cal.getTime();
  }

  public static java.util.Date firstDayOfMonth()
  {
    Calendar cal = calendar();
    cal.set(5, 1);
    cal.set(11, 0);
    cal.set(12, 0);
    cal.set(13, 0);
    cal.set(14, 0);
    return cal.getTime();
  }

  private static java.util.Date weekDay(int week) {
    Calendar cal = calendar();
    cal.set(7, week);
    return cal.getTime();
  }

  public static java.util.Date friday()
  {
    return weekDay(6);
  }

  public static java.util.Date saturday()
  {
    return weekDay(7);
  }

  public static java.util.Date sunday()
  {
    return weekDay(1);
  }

  public static java.util.Date parseDatetime(String datetime)
    throws ParseException
  {
    return datetimeFormat.parse(datetime);
  }

  public static java.util.Date parseDate(String date)
    throws ParseException
  {
    return dateFormat.parse(date);
  }

  public static java.util.Date parseTime(String time)
    throws ParseException
  {
    return timeFormat.parse(time);
  }

  public static java.util.Date parseDatetime(String datetime, String pattern)
    throws ParseException
  {
    SimpleDateFormat format = (SimpleDateFormat)datetimeFormat.clone();
    format.applyPattern(pattern);
    return format.parse(datetime);
  }

  public static boolean areSameDay(java.util.Date dateA, java.util.Date dateB) {
    Calendar calDateA = Calendar.getInstance();
    calDateA.setTime(dateA);

    Calendar calDateB = Calendar.getInstance();
    calDateB.setTime(dateB);

    return ((calDateA.get(1) == calDateB.get(1)) && (calDateA.get(2) == calDateB.get(2)) && (calDateA.get(5) == calDateB.get(5)));
  }

  public static int daysBetween(java.util.Date date1, java.util.Date date2)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date1);
    long time1 = cal.getTimeInMillis();
    cal.setTime(date2);
    long time2 = cal.getTimeInMillis();
    long between_days = (time2 - time1) / 86400000L;

    return Integer.parseInt(String.valueOf(between_days));
  }

  public static int daysBetween2(java.util.Date date1, java.util.Date date2)
  {
    double days = 0.0D;

    double day = 0.0D;
    Calendar cal = Calendar.getInstance();
    cal.setTime(date1);
    int month = cal.get(2);
    Calendar cal2 = Calendar.getInstance();
    cal2.setTime(date2);
    int month2 = cal2.get(2);
    long time1 = cal.getTimeInMillis();
    long time2 = cal2.getTimeInMillis();
    long time3 = cal.getTimeInMillis();
    for (int i = month; i <= month2; ++i) {
      if (i == month2)
      {
        int dayofmonth = cal.get(5);
        int dayofmonth2 = cal2.get(5);
        time1 = cal.getTimeInMillis();
        time2 = cal2.getTimeInMillis();
        if (dayofmonth <= dayofmonth2) {
          day = (time2 - time1) / 86400000L;
          if (day > 30.0D) {
            day = 30.0D;
          }
          days += day;
        } else {
          day = (time1 - time2) / 86400000.0D;
          days -= day;
        }
      } else {
        cal.add(2, 1);
        time2 = cal.getTimeInMillis();
        day = (time2 - time3) / 86400000.0D;
        time3 = time2;
        if (day > 30.0D) {
          day = 30.0D;
        }
        days += day;
      }

    }

    return (int)days;
  }

  public static void main(String[] rgs) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
      java.util.Date plandate = dateFormat.parse(dateFormat.format(new java.util.Date()));
      Calendar cal = Calendar.getInstance();
      cal.setTime(plandate);
      cal.add(2, 1);
      System.out.println(plandate);
      System.out.println(cal.getTime());

      Calendar cal1 = Calendar.getInstance();
      cal1.set(2015, 5, 8);
      cal1.set(11, 0);
      cal1.set(12, 0);
      cal1.set(13, 0);
      System.out.println(cal1.getTime());
      Calendar cal2 = Calendar.getInstance();
      cal2.set(2015, 6, 1);
      cal2.set(11, 0);
      cal2.set(12, 0);
      cal2.set(13, 0);

      System.out.println(cal2.get(5));
      System.out.println(cal2.getTime());
      int day = daysBetween(cal1.getTime(), cal2.getTime());
      System.out.println(day);
      int day2 = daysBetween2(cal1.getTime(), cal2.getTime());
      System.out.println(day2);
    }
    catch (ParseException e) {
      e.printStackTrace();
    }
  }
}