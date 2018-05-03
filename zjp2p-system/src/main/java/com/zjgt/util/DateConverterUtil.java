/*     */ package com.zjgt.util;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class DateConverterUtil
/*     */ {
/*  12 */   private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */ 
/*  15 */   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/*  18 */   private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
/*     */ 
/*  21 */   private static final SimpleDateFormat serialFormat = new SimpleDateFormat("yyMMddHHmm");
/*     */ 
/*     */   public static java.util.Date getDate(int datas)
/*     */   {
/*  31 */     GregorianCalendar calendar = new GregorianCalendar();
/*  32 */     calendar.add(5, datas);
/*  33 */     String begin = new java.sql.Date(calendar.getTime().getTime()).toString();
/*     */ 
/*  35 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*  36 */     java.util.Date beginDate = null;
/*     */     try {
/*  38 */       beginDate = sdf.parse(begin);
/*     */     } catch (ParseException e) {
/*  40 */       e.printStackTrace();
/*     */     }
/*  42 */     return beginDate;
/*     */   }
/*     */ 
/*     */   public static String currentDatetime()
/*     */   {
/*  53 */     return datetimeFormat.format(new java.util.Date());
/*     */   }
/*     */ 
/*     */   public static String formatDatetime(java.util.Date date)
/*     */   {
/*  64 */     return datetimeFormat.format(date);
/*     */   }
/*     */ 
/*     */   public static String formatDatetime(java.util.Date date, String pattern)
/*     */   {
/*  77 */     SimpleDateFormat customFormat = (SimpleDateFormat)datetimeFormat.clone();
/*     */ 
/*  79 */     customFormat.applyPattern(pattern);
/*  80 */     return customFormat.format(date);
/*     */   }
/*     */ 
/*     */   public static String currentDate()
/*     */   {
/*  91 */     return dateFormat.format(now());
/*     */   }
/*     */ 
/*     */   public static String seriaTime()
/*     */   {
/* 102 */     return serialFormat.format(now());
/*     */   }
/*     */ 
/*     */   public static String formatDate(java.util.Date date)
/*     */   {
/* 113 */     return dateFormat.format(date);
/*     */   }
/*     */ 
/*     */   public static String currentTime()
/*     */   {
/* 124 */     return timeFormat.format(now());
/*     */   }
/*     */ 
/*     */   public static String formatTime(java.util.Date date)
/*     */   {
/* 135 */     return timeFormat.format(date);
/*     */   }
/*     */ 
/*     */   public static java.util.Date now()
/*     */   {
/* 144 */     return new java.util.Date();
/*     */   }
/*     */ 
/*     */   public static Calendar calendar() {
/* 148 */     Calendar cal = GregorianCalendar.getInstance(Locale.CHINESE);
/* 149 */     cal.setFirstDayOfWeek(2);
/* 150 */     return cal;
/*     */   }
/*     */ 
/*     */   public static long millis()
/*     */   {
/* 161 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public static int month()
/*     */   {
/* 170 */     return (calendar().get(2) + 1);
/*     */   }
/*     */ 
/*     */   public static int dayOfMonth()
/*     */   {
/* 179 */     return calendar().get(5);
/*     */   }
/*     */ 
/*     */   public static int dayOfWeek()
/*     */   {
/* 188 */     return calendar().get(7);
/*     */   }
/*     */ 
/*     */   public static int dayOfYear()
/*     */   {
/* 197 */     return calendar().get(6);
/*     */   }
/*     */ 
/*     */   public static boolean isBefore(java.util.Date src, java.util.Date dst)
/*     */   {
/* 208 */     return src.before(dst);
/*     */   }
/*     */ 
/*     */   public static boolean isAfter(java.util.Date src, java.util.Date dst)
/*     */   {
/* 219 */     return src.after(dst);
/*     */   }
/*     */ 
/*     */   public static boolean isEqual(java.util.Date date1, java.util.Date date2)
/*     */   {
/* 230 */     return (date1.compareTo(date2) == 0);
/*     */   }
/*     */ 
/*     */   public static boolean between(java.util.Date beginDate, java.util.Date endDate, java.util.Date src)
/*     */   {
/* 245 */     return ((beginDate.before(src)) && (endDate.after(src)));
/*     */   }
/*     */ 
/*     */   public static java.util.Date lastDayOfMonth()
/*     */   {
/* 254 */     Calendar cal = calendar();
/* 255 */     cal.set(5, 0);
/* 256 */     cal.set(11, 0);
/* 257 */     cal.set(12, 0);
/* 258 */     cal.set(13, 0);
/* 259 */     cal.set(14, 0);
/* 260 */     cal.set(2, cal.get(2) + 1);
/* 261 */     cal.set(14, -1);
/* 262 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   public static java.util.Date firstDayOfMonth()
/*     */   {
/* 273 */     Calendar cal = calendar();
/* 274 */     cal.set(5, 1);
/* 275 */     cal.set(11, 0);
/* 276 */     cal.set(12, 0);
/* 277 */     cal.set(13, 0);
/* 278 */     cal.set(14, 0);
/* 279 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   private static java.util.Date weekDay(int week) {
/* 283 */     Calendar cal = calendar();
/* 284 */     cal.set(7, week);
/* 285 */     return cal.getTime();
/*     */   }
/*     */ 
/*     */   public static java.util.Date friday()
/*     */   {
/* 296 */     return weekDay(6);
/*     */   }
/*     */ 
/*     */   public static java.util.Date saturday()
/*     */   {
/* 307 */     return weekDay(7);
/*     */   }
/*     */ 
/*     */   public static java.util.Date sunday()
/*     */   {
/* 318 */     return weekDay(1);
/*     */   }
/*     */ 
/*     */   public static java.util.Date parseDatetime(String datetime)
/*     */     throws ParseException
/*     */   {
/* 330 */     return datetimeFormat.parse(datetime);
/*     */   }
/*     */ 
/*     */   public static java.util.Date parseDate(String date)
/*     */     throws ParseException
/*     */   {
/* 343 */     return dateFormat.parse(date);
/*     */   }
/*     */ 
/*     */   public static java.util.Date parseTime(String time)
/*     */     throws ParseException
/*     */   {
/* 356 */     return timeFormat.parse(time);
/*     */   }
/*     */ 
/*     */   public static java.util.Date parseDatetime(String datetime, String pattern)
/*     */     throws ParseException
/*     */   {
/* 369 */     SimpleDateFormat format = (SimpleDateFormat)datetimeFormat.clone();
/* 370 */     format.applyPattern(pattern);
/* 371 */     return format.parse(datetime);
/*     */   }
/*     */ 
/*     */   public static boolean areSameDay(java.util.Date dateA, java.util.Date dateB) {
/* 375 */     Calendar calDateA = Calendar.getInstance();
/* 376 */     calDateA.setTime(dateA);
/*     */ 
/* 378 */     Calendar calDateB = Calendar.getInstance();
/* 379 */     calDateB.setTime(dateB);
/*     */ 
/* 381 */     return ((calDateA.get(1) == calDateB.get(1)) && (calDateA.get(2) == calDateB.get(2)) && (calDateA.get(5) == calDateB.get(5)));
/*     */   }
/*     */ 
/*     */   public static int daysBetween(java.util.Date date1, java.util.Date date2)
/*     */   {
/* 395 */     Calendar cal = Calendar.getInstance();
/* 396 */     cal.setTime(date1);
/* 397 */     long time1 = cal.getTimeInMillis();
/* 398 */     cal.setTime(date2);
/* 399 */     long time2 = cal.getTimeInMillis();
/* 400 */     long between_days = (time2 - time1) / 86400000L;
/*     */ 
/* 402 */     return Integer.parseInt(String.valueOf(between_days));
/*     */   }
/*     */ 
/*     */   public static int daysBetween2(java.util.Date date1, java.util.Date date2)
/*     */   {
/* 414 */     double days = 0.0D;
/*     */ 
/* 416 */     double day = 0.0D;
/* 417 */     Calendar cal = Calendar.getInstance();
/* 418 */     cal.setTime(date1);
/* 419 */     int month = cal.get(2);
/* 420 */     Calendar cal2 = Calendar.getInstance();
/* 421 */     cal2.setTime(date2);
/* 422 */     int month2 = cal2.get(2);
/* 423 */     long time1 = cal.getTimeInMillis();
/* 424 */     long time2 = cal2.getTimeInMillis();
/* 425 */     long time3 = cal.getTimeInMillis();
/* 426 */     for (int i = month; i <= month2; ++i) {
/* 427 */       if (i == month2)
/*     */       {
/* 429 */         int dayofmonth = cal.get(5);
/* 430 */         int dayofmonth2 = cal2.get(5);
/* 431 */         time1 = cal.getTimeInMillis();
/* 432 */         time2 = cal2.getTimeInMillis();
/* 433 */         if (dayofmonth <= dayofmonth2) {
/* 434 */           day = (time2 - time1) / 86400000L;
/* 435 */           if (day > 30.0D) {
/* 436 */             day = 30.0D;
/*     */           }
/* 438 */           days += day;
/*     */         } else {
/* 440 */           day = (time1 - time2) / 86400000.0D;
/* 441 */           days -= day;
/*     */         }
/*     */       } else {
/* 444 */         cal.add(2, 1);
/* 445 */         time2 = cal.getTimeInMillis();
/* 446 */         day = (time2 - time3) / 86400000.0D;
/* 447 */         time3 = time2;
/* 448 */         if (day > 30.0D) {
/* 449 */           day = 30.0D;
/*     */         }
/* 451 */         days += day;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 458 */     return (int)days;
/*     */   }
/*     */ 
/*     */   public static void main(String[] rgs) {
/* 462 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*     */     try {
/* 464 */       java.util.Date plandate = dateFormat.parse(dateFormat.format(new java.util.Date()));
/* 465 */       Calendar cal = Calendar.getInstance();
/* 466 */       cal.setTime(plandate);
/* 467 */       cal.add(2, 1);
/* 468 */       System.out.println(plandate);
/* 469 */       System.out.println(cal.getTime());
/*     */ 
/* 471 */       Calendar cal1 = Calendar.getInstance();
/* 472 */       cal1.set(2015, 5, 8);
/* 473 */       cal1.set(11, 0);
/* 474 */       cal1.set(12, 0);
/* 475 */       cal1.set(13, 0);
/* 476 */       System.out.println(cal1.getTime());
/* 477 */       Calendar cal2 = Calendar.getInstance();
/* 478 */       cal2.set(2015, 6, 1);
/* 479 */       cal2.set(11, 0);
/* 480 */       cal2.set(12, 0);
/* 481 */       cal2.set(13, 0);
/*     */ 
/* 483 */       System.out.println(cal2.get(5));
/* 484 */       System.out.println(cal2.getTime());
/* 485 */       int day = daysBetween(cal1.getTime(), cal2.getTime());
/* 486 */       System.out.println(day);
/* 487 */       int day2 = daysBetween2(cal1.getTime(), cal2.getTime());
/* 488 */       System.out.println(day2);
/*     */     }
/*     */     catch (ParseException e) {
/* 491 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.util.DateConverterUtil
 * JD-Core Version:    0.5.3
 */