package com.zjgt.p2p.manage.common;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 常用工具类
 * 
 * @author emore
 * 
 */
public class CommonUtil {
	public static Logger					logger			= LoggerFactory.getLogger(CommonUtil.class);
	public static final SimpleDateFormat	FORMAT			= new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
    /**
     * 读Json对象
     * @param json
     * @return
     */
	public static Object readJson(String json) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			if (null != json && !"".equals(json)){
				return mapper.readValue(json, Object.class);
			}	
		} catch (JsonParseException e) {
			logger.error("readJson error! JsonParseException", e);
		} catch (JsonMappingException e) {
			logger.error("readJson error! JsonMappingException", e);
		} catch (IOException e) {
			logger.error("readJson error! IOException", e);
		}

		return null;
	}
    /**
     * 写Json对象
     * @param object
     * @return
     */
	public static String writeJson(Object object) {
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.error("writeJson error! JsonGenerationException", e);
		} catch (JsonMappingException e) {
			logger.error("writeJson error! JsonMappingException", e);
		} catch (IOException e) {
			logger.error("writeJson error! IOException", e);
		}
		return json;
	}

	/**
	 * 增加年月
	 * 
	 * @param nt
	 * @param mt
	 * @param it
	 * @return
	 */

	public static String cgDateMonth(int nt, int mt, int it) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(ft.parse(nt + "-" + mt + "-01"));

			cal.add(GregorianCalendar.MONTH, it);// 在月份上加1
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal.get(Calendar.YEAR) + "-" + ((cal.get(Calendar.MONTH) + 1 < 10) ? "0" : "") + (cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * 判断字符串是否为空，为空时给予默认值
	 * 
	 * @param str
	 *            字符串
	 * @return 字符串
	 */
	public static String cgNull(String str, String defaultStr) {
		String vs = "";
		String tmp = (str + "").trim();
		if ("".equals(tmp) || null == tmp || "null".equals(tmp.toLowerCase())) {
			vs = defaultStr;
		} else {
			vs = str;
		}
		return vs;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return 布尔值
	 */
	public static boolean isNull(String str) {
		return str == null || str.length() == 0 || "undefined".equals(str);
	}

	/**
	 * 判断字符串是否为非空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * 返回一个ID，格式：时间戳+8位随机数
	 */
	public static String getItID() {
		Calendar td = Calendar.getInstance();
		// 时间戳
		int yea = td.get(1);
		int mon = td.get(2) + 1;
		int day = td.get(5);
		int hou = td.get(Calendar.HOUR_OF_DAY);
		int min = td.get(Calendar.MINUTE);
		int sec = td.get(Calendar.SECOND);
		int mil = td.get(Calendar.MILLISECOND);

		String mons = "" + mon;
		String days = "" + day;
		String hous = "" + hou;
		String mins = "" + min;
		String secs = "" + sec;
		String mils = "" + mil;

		if (hou < 10) {
			hous = "0" + hou;
		}
		if (min < 10) {
			mins = "0" + min;
		}
		if (sec < 10) {
			secs = "0" + sec;
		}
		if (mon < 10) {
			mons = "0" + mon;
		}
		if (day < 10) {
			days = "0" + day;
		}
		if (mil < 10) {
			mils = "00" + mil;
		} else {
			if (mil < 100) {
				mils = "0" + mil;
			} else {
				mils = String.valueOf(mil);
			}
		}
		// 随机数
		String vs = "";
		for (int i = 0; i < 1000; i++) {
			/* 生成8位随机数 */
			vs = String.valueOf(Math.round(Math.random() * 99999999 + 1));
			/* 补零 */
			int ft = vs.length();
			for (int t = 0; t < 8 - ft; t++) {
				vs = "0" + vs;
			}
		}
		return "" + yea + "" + mons + "" + days + "" + hous + "" + mins + "" + secs + "" + mils + vs;
	}

	/**
	 * 返回一个UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 产生一个长度为it的随机字符串
	 * 
	 * @param it
	 *            长度
	 * @return
	 */
	public static String getItRandom(int it) {
		String[] itArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z" };
		/* 返回 */
		String str = "";
		for (int i = 0; i < it; i++) {
			str += "" + itArray[getInt(0, itArray.length - 1)];
		}
		return str;
	}

	/**
	 * 产生随机数
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getInt(int min, int max) {
		Random random = new Random();
		/* 取小于或等于max的一个随机数 */
		int it = random.nextInt(max + 1);
		if (it < min) {
			it = getInt(min, max);// 如果随机数小于min，则递归
		}
		return it;
	}

	/**
	 * 格式化Double类型小数
	 * 
	 * @return
	 */
	public static Double formatDouble(Double data, String ft) {
		return Double.valueOf(new DecimalFormat(ft).format(data));
	}

	/**
	 * 格式化Double类型小数 new DecimalFormat("#,###.00")
	 * 
	 * @return
	 */
	public static BigDecimal formatDecimal(BigDecimal data) {
		if (data == null) {
			return null;
		} else {
			return BigDecimal.valueOf(Double.valueOf(new DecimalFormat("#,###.00").format(data)));
		}
	}

	/**
	 * 格式化Double类型小数(保存指定小数位)
	 * 
	 * @return
	 */
	public static double formatDoubleExt(Double doubleValue, int s) {
		return new BigDecimal(doubleValue.toString()).setScale(s, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 格式化Float类型小数(保存指定小数位)
	 * 
	 * @return
	 */
	public static float formatFloatExt(Double doubleValue, int s) {
		return new BigDecimal(doubleValue.toString()).setScale(s, BigDecimal.ROUND_HALF_UP).floatValue();
	}

	/**
	 * 获取日期时间
	 * 
	 * @return
	 */
	public static Date getSysDateTime() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 功能描述: 获取系统时间 yyyy-MM-dd HH:mm:ss
	 */
	public static String getLongSysDate() {
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述: 获取系统时间 yyyy-MM-dd
	 */
	public static String getSysDate() {
		return (new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述：
	 * 
	 * @param ft
	 * @return
	 */
	public static String getSysDate(String ft) {
		return (new SimpleDateFormat(ft)).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述: 获取系统时间 yyyy-MM
	 */
	public static String getCtYearMonth() {
		return (new SimpleDateFormat("yyyy-MM")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述: 获取系统时间 yyyy
	 */
	public static String getCtYear() {
		return (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述: 获取系统时间 MM
	 */
	public static String getCtMonth() {
		return (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 功能描述: 获取系统时间 dd
	 */
	public static String getCtDay() {
		return (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 截取日期
	 */
	public static String getFtDate(String dt) {
		if (isNotNull(dt) || dt.length() > 10) {
			return dt.substring(0, 10);
		} else {
			return "";
		}
	}

	/**
	 * 格式化日期
	 * 
	 * @param dt
	 * @return
	 */
	public static String getFtDate(Date dt) {
		return getFtDate(dt, "yyyy-MM-dd");
	}

	/**
	 * 格式化日期
	 * 
	 * @param dt
	 * @param ft
	 * @return
	 */
	public static String getFtDate(Date dt, String ft) {
		if (dt != null) {
			return (new SimpleDateFormat(ft)).format(dt.getTime());
		} else {
			return "";
		}
	}

	/**
	 * 格式化日期
	 */
	public static Date getCtDate(String dt) {
		Date ft = null;
		if (isNotNull(dt) || dt.length() > 10) {
			try {
				ft = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(dt).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return ft;
	}

	/**
	 * 两个年月差
	 * 
	 * @param a
	 * @param b
	 * @return i
	 */
	public static int cgNtDate(String a, String b) {
		int a1 = Integer.parseInt(a.split("-")[0], 10);
		int a2 = Integer.parseInt(a.split("-")[1], 10);
		int b1 = Integer.parseInt(b.split("-")[0], 10);
		int b2 = Integer.parseInt(b.split("-")[1], 10);
		return a1 * 12 + a2 - b1 * 12 - b2 + 1;
	}

	/**
	 * 两个日期差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getItDifferenceDate(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
	}

	/**
	 * 两个日期差
	 * 
	 * @param a
	 * @param b
	 * @return i
	 */
	public static int getItDifferenceDate(String a, String b) {
		int a1 = Integer.parseInt(a.split("-")[0], 10);
		int a2 = Integer.parseInt(a.split("-")[1], 10);
		int b1 = Integer.parseInt(b.split("-")[0], 10);
		int b2 = Integer.parseInt(b.split("-")[1], 10);
		return a1 * 12 + a2 - b1 * 12 - b2 + 1;
	}

	/**
	 * 获取指定时间所在周的周一至周日的日期，传入null值，则返回当前日期所在的周一至周日
	 * 
	 * @param date
	 *            指定的日期值
	 * @return String[] 数组第一个值至第六个值分别为周一至周日的日期
	 */
	public static String[] getWeekDayDate(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		// 设定每周的起始日。
		if (null == date) {
			cal.setTimeInMillis(System.currentTimeMillis());// 当前时间
		} else {
			cal.setTimeInMillis(date.getTime());// 指定日期
		}
		return getMondayToSunday(cal);
	}

	/**
	 * 得到新增某个月之后几个月2012-02 +5 2012-07
	 * 
	 * @return
	 */
	public static String getAddMonthDate(String date, int ik, String flag) {
		Calendar cal = Calendar.getInstance();
		/* 年月 */
		String[] dt = date.split("-", -1);

		cal.set(Calendar.YEAR, Integer.valueOf(dt[0]));// 年
		cal.set(Calendar.MONTH, Integer.valueOf(dt[1]) + ik - 1);// 月

		String sp = "";
		if ("0".equals(flag)) {
			sp = "yyyyMM";
		} else {
			sp = "yyyy-MM";
		}
		return (new SimpleDateFormat(sp)).format(cal.getTime());
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            需要格式化的日期值
	 * @return 格式为yyyy-MM-dd
	 */
	public static String formatDate(Date date, String ft) {
		return date == null ? "" : (new SimpleDateFormat(ft)).format(date);
	}

	/**
	 * 从当前日期向前或向后周的每天日期
	 * 
	 * @param week
	 *            向前或向后推的周数：0本周，-1向前推迟一周，1下周，依次类推
	 */
	public static String[] getOtherWeeks(int week) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, week * 7);
		return getMondayToSunday(cal);
	}

	/**
	 * 从指定日期向前或向后周的每天日期
	 * 
	 * @param week
	 *            向前或向后推的周数：0本周，-1向前推迟一周，0下周，依次类推
	 */
	public static String[] getOtherWeeks(int week, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, week * 7);
		return getMondayToSunday(cal);
	}

	/**
	 * 某年某月的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);

		return cal.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 返回周一至周日日期数组
	 * 
	 * @param cal
	 * @return
	 */
	private static String[] getMondayToSunday(Calendar cal) {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周一为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String monday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		String tuesday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		String wednesday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		String thursday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		String friday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String saturday = ft.format(cal.getTime());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String sunday = ft.format(cal.getTime());
		return new String[] { monday, tuesday, wednesday, thursday, friday, saturday, sunday };
	}

	/**
	 * 获得本月日期值数组
	 * 
	 * @return
	 */
	public static List<String> getCurrentMonthDays() {
		Calendar cal = Calendar.getInstance();
		int curMaxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);// 获取本月的天数
		int curYear = cal.get(Calendar.YEAR);
		int curMonth = cal.get(Calendar.MONTH) + 1;
		return getMonthDays(curYear, curMonth, curMaxDay);
	}

	/**
	 * 获得上月日期值数组
	 * 
	 * @return
	 */
	public static List<String> getLastMonthDays() {
		Calendar cale = Calendar.getInstance();
		// 取得系统当前时间所在月第一天时间对象
		cale.set(Calendar.DAY_OF_MONTH, 1);
		// 日期减一,取得上月最后一天时间对象
		cale.add(Calendar.DAY_OF_MONTH, -1);// 上一个月
		int maxDay = cale.getActualMaximum(Calendar.DAY_OF_MONTH);// 获取上个月的天数
		int year = cale.get(Calendar.YEAR);
		int month = cale.get(Calendar.MONTH) + 1;
		return getMonthDays(year, month, maxDay);
	}

	/**
	 * 根据年月及该月最大天数，获得该月的日期值数组，格式为：yyyy-MM-dd
	 * 
	 * @param year
	 * @param month
	 * @param days
	 * @return
	 */
	public static List<String> getMonthDays(int year, int month, int days) {
		List<String> monthDays = new ArrayList<String>();
		String formatMonth = month + "";
		if (month < 10) {
			formatMonth = "0" + month;
		}
		for (int i = 1; i <= days; i++) {
			String day = "";
			if (i < 10) {
				day = year + "-" + formatMonth + "-0" + i;
			} else {
				day = year + "-" + formatMonth + "-" + i;
			}
			monthDays.add(day);
		}
		return monthDays;
	}

	/**
	 * 计算两日期之间相隔的天数
	 * 
	 * @param date1
	 *            开始日期
	 * @param date2
	 *            结束日期
	 * @return
	 */
	public static int getDaysBetween(Date date1, Date date2) {
		long n1 = date1.getTime();
		long n2 = date2.getTime();
		Long diff = Math.abs(n1 - n2);
		diff /= 3600 * 1000 * 24;
		return diff.intValue();
	}

	/**
	 * 计算两个日期间相隔的周数
	 * 
	 * @param startDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return
	 */
	public static int getWeeksBetweenDates(Date startDate, Date endDate) {
		Calendar dateFrom = Calendar.getInstance();
		dateFrom.setFirstDayOfWeek(Calendar.MONDAY);
		dateFrom.setTime(startDate);
		Calendar dateTo = Calendar.getInstance();
		dateTo.setFirstDayOfWeek(Calendar.MONDAY);
		dateTo.setTime(endDate);
		int yearFrom = dateFrom.get(Calendar.YEAR);
		int yearTo = dateTo.get(Calendar.YEAR);
		int weeksBetween = 0;
		// the year of dateFrom
		int weekFrom = dateFrom.get(Calendar.WEEK_OF_YEAR);
		if (weekFrom == 1 && dateFrom.get(Calendar.MONTH) == Calendar.DECEMBER) {// 腊月
			dateFrom.set(yearFrom, Calendar.DECEMBER, 25, 23, 59, 59);
			weeksBetween -= dateFrom.get(Calendar.WEEK_OF_YEAR);
		}
		weeksBetween -= weekFrom;
		// years between dates
		for (int i = 1; i <= yearTo - yearFrom; i++) {
			Calendar _lastDay = Calendar.getInstance();
			_lastDay.setFirstDayOfWeek(Calendar.MONDAY);
			_lastDay.set(yearFrom + i, 11, 25, 23, 59, 59);
			weeksBetween += _lastDay.get(Calendar.WEEK_OF_YEAR);
		}
		// the year of dateTo
		int weekTo = dateTo.get(Calendar.WEEK_OF_YEAR);
		if (weekTo == 1 && dateTo.get(Calendar.MONTH) == Calendar.DECEMBER) {// 腊月
			dateTo.set(yearTo, Calendar.DECEMBER, 25, 23, 59, 59);
			weeksBetween += dateTo.get(Calendar.WEEK_OF_YEAR);
		}
		weeksBetween += weekTo;
		return weeksBetween;
	}

	/**
	 * 获得一个月中所有周的开始和结束日期
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static List<Date[]> getStartEndDateOfWeekInMonth(int year, int month) {// 获得月中每周的开始结束日期
		Locale.setDefault(Locale.CHINESE);
		List<Date[]> results = new ArrayList<Date[]>();
		Calendar calendarDate = Calendar.getInstance();
		calendarDate.set(Calendar.YEAR, year);
		calendarDate.set(Calendar.MONTH, month);
		calendarDate.set(Calendar.DAY_OF_MONTH, 1);// 设置为本月第一天
		calendarDate.set(Calendar.HOUR_OF_DAY, 0);
		calendarDate.set(Calendar.MINUTE, 0);
		calendarDate.set(Calendar.SECOND, 0);
		Calendar firstDayOfWeek = (Calendar) calendarDate.clone();
		Calendar endDayOfWeek = (Calendar) calendarDate.clone();
		do {
			Calendar weekDay = (Calendar) calendarDate.clone();
			// 星期日为一周的第一天 转化为 星期一为一周的第一天 MON TUE WED THU FRI SAT SUN DAY_OF_WEEK返回值 1 2 3 4
			weekDay.add(Calendar.DAY_OF_WEEK, -1);
			// 5 6 7
			if (weekDay.get(Calendar.DAY_OF_WEEK) == 7) {// 一周的最后一天
				endDayOfWeek = (Calendar) calendarDate.clone();
				Date[] dates = new Date[] { firstDayOfWeek.getTime(), endDayOfWeek.getTime() };
				results.add(dates);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(calendarDate.getTime());
				calendar.add(Calendar.DAY_OF_YEAR, 1);// 下一周开始
				firstDayOfWeek = (Calendar) calendar.clone();
			}
			calendarDate.add(Calendar.DAY_OF_YEAR, 1);// 加一天
		} while (calendarDate.get(Calendar.MONTH) == month);// 本月继续循环
		if (calendarDate.get(Calendar.MONTH) != month) {
			if (firstDayOfWeek.get(Calendar.MONTH) == month) {// 最后一周第一天是本月
				Calendar lastDayOfMonth = Calendar.getInstance();
				lastDayOfMonth.set(Calendar.YEAR, year);
				lastDayOfMonth.set(Calendar.MONTH, month);
				lastDayOfMonth.set(Calendar.DAY_OF_MONTH, lastDayOfMonth.getActualMaximum(Calendar.DAY_OF_MONTH));// 设置为本月最后一天
				lastDayOfMonth.set(Calendar.HOUR_OF_DAY, 23);
				lastDayOfMonth.set(Calendar.MINUTE, 59);
				lastDayOfMonth.set(Calendar.SECOND, 59);
				Date[] dates = new Date[] { firstDayOfWeek.getTime(), lastDayOfMonth.getTime() };
				results.add(dates);
			}
		}
		return results;
	}

	/**
	 * 得到上一周开始结束日期
	 * 
	 * @return
	 */
	public static Date[] getStartEndDateOfLastWeek() {
		Calendar currentDate = Calendar.getInstance();
		Calendar startDate = (Calendar) currentDate.clone();
		startDate.add(Calendar.WEEK_OF_YEAR, -1);// 上一周
		startDate.set(Calendar.DAY_OF_WEEK, 1);// 一周的第一天,星期日
		startDate.add(Calendar.DAY_OF_YEAR, 1);// 星期一为一周第一天
		startDate.set(Calendar.HOUR_OF_DAY, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);
		Calendar endDate = (Calendar) currentDate.clone();
		endDate.add(Calendar.WEEK_OF_YEAR, -1);// 上一周
		endDate.set(Calendar.DAY_OF_WEEK, 7);// 一周的第一天,星期日
		endDate.add(Calendar.DAY_OF_YEAR, 1);// 星期日为一周最后一天
		endDate.set(Calendar.HOUR_OF_DAY, 23);
		endDate.set(Calendar.MINUTE, 59);
		endDate.set(Calendar.SECOND, 59);
		return new Date[] { startDate.getTime(), endDate.getTime() };
	}

	/**
	 * 得到上一月的开始结束日期
	 * 
	 * @return
	 */
	public static Date[] getStartEndDateOfLastMonth() {
		Calendar currentDate = Calendar.getInstance();
		Calendar startDate = (Calendar) currentDate.clone();
		startDate.add(Calendar.MONTH, -1);// 上一月
		startDate.set(Calendar.DAY_OF_MONTH, 1);// 设置为月第一天
		startDate.set(Calendar.HOUR_OF_DAY, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);
		Calendar endDate = (Calendar) currentDate.clone();
		endDate.add(Calendar.MONTH, -1);// 上一月
		endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		// 设置为月最后一天
		endDate.set(Calendar.HOUR_OF_DAY, 23);
		endDate.set(Calendar.MINUTE, 59);
		endDate.set(Calendar.SECOND, 59);
		return new Date[] { startDate.getTime(), endDate.getTime() };
	}

	/**
	 * 得到一年的开始结束日期
	 * 
	 * @return
	 */
	public static Date[] getStartEndDateOfYear(int year) {
		Calendar currentDate = Calendar.getInstance();
		Calendar startDate = (Calendar) currentDate.clone();
		startDate.set(Calendar.YEAR, year);// 年
		startDate.set(Calendar.MONTH, 0);// 1月
		startDate.set(Calendar.DAY_OF_MONTH, 1);// 设置为月第一天
		startDate.set(Calendar.HOUR_OF_DAY, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);
		Calendar endDate = (Calendar) currentDate.clone();
		endDate.set(Calendar.YEAR, year);// 年
		endDate.set(Calendar.MONTH, 11);// 12月
		endDate.set(Calendar.DAY_OF_MONTH, 31);// 最后一天
		endDate.set(Calendar.HOUR_OF_DAY, 23);
		endDate.set(Calendar.MINUTE, 59);
		endDate.set(Calendar.SECOND, 59);
		return new Date[] { startDate.getTime(), endDate.getTime() };
	}

	/**
	 * 日期加天数得到新日期
	 * 
	 * @param beginDate
	 * @param days
	 * @return
	 */
	public static Date dateAddDays(Date beginDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(beginDate);
		c.add(Calendar.DAY_OF_YEAR, days);
		return c.getTime();
	}

	/**
	 * 根据年份得到该年所有双休日的日期集合
	 * 
	 * @param year
	 * @return
	 */
	public static List<String> getWeekends(int year) {
		List<String> list = new ArrayList<String>();
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(year, 0, 1);
		for (int day = 1; day <= cal.getActualMaximum(Calendar.DAY_OF_YEAR); day++) {
			cal.set(Calendar.DAY_OF_YEAR, day);
			int weekDay = cal.get(Calendar.DAY_OF_WEEK);
			if (weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY) {
				list.add(FORMAT.format(cal.getTime()));
			}
		}
		return list;
	}

	/**
	 * 获得两日期间的所有日期
	 * 
	 * @param date1
	 * @param date2
	 */
	public static List<String> getDateBetween(String date1, String date2) {
		List<String> dateList = new ArrayList<String>();
		if (date1.equals(date2)) {
			return dateList;
		}
		String tmp;
		if (date1.compareTo(date2) > 0) { // 确保 date1的日期不晚于date2
			tmp = date1;
			date1 = date2;
			date2 = tmp;
		}
		tmp = FORMAT.format(str2Date(date1).getTime() + 3600 * 24 * 1000);
		while (tmp.compareTo(date2) < 0) {
			dateList.add(tmp);
			tmp = FORMAT.format(str2Date(tmp).getTime() + 3600 * 24 * 1000);
		}
		return dateList;
	}

	/**
	 * 日期串转换为日期
	 * 
	 * @param str
	 * @return
	 */
	public static Date str2Date(String str) {
		if (str == null) {
			return null;
		}
		try {
			return FORMAT.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 方法说明 :将日期转换成字符串
	 * 
	 * @author 宋杰 2013年12月6日下午3:45:56
	 * 
	 * @param date
	 *            java.util.Date类型的日期
	 * @param format
	 *            格式字符串
	 * @return
	 */
	public static String date2Str(Date date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);

		String dateStr = sf.format(date);

		return dateStr;
	}

	/**
	 * 得到某月前n个月的开始结束日期
	 * 
	 * @param monthNum
	 * @return
	 */
	public static List<Date[]> getStartEndDateListOfMonthBeforeAMonth(Date date, int monthNum) {
		List<Date[]> dateList = new ArrayList<Date[]>();
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(date);
		for (int i = monthNum; i > 0; i--) {
			Calendar startDate = (Calendar) currentDate.clone();
			startDate.add(Calendar.MONTH, -i);// 上n月
			startDate.set(Calendar.DAY_OF_MONTH, 1);// 设置为月第一天
			startDate.set(Calendar.HOUR_OF_DAY, 0);
			startDate.set(Calendar.MINUTE, 0);
			startDate.set(Calendar.SECOND, 0);
			Calendar endDate = (Calendar) currentDate.clone();
			endDate.add(Calendar.MONTH, -i);// 上n月
			endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			// 设置为月最后一天
			endDate.set(Calendar.HOUR_OF_DAY, 23);
			endDate.set(Calendar.MINUTE, 59);
			endDate.set(Calendar.SECOND, 59);
			dateList.add(new Date[] { startDate.getTime(), endDate.getTime() });
		}
		return dateList;
	}

	/**
	 * 得到某月后n个月的开始结束日期（包括本月）
	 * 
	 * @param monthNum
	 * @return
	 */
	public static List<Date[]> getStartEndDateListOfMonthAfterAMonth(Date date, int monthNum) {
		List<Date[]> dateList = new ArrayList<Date[]>();
		Calendar currentDate = Calendar.getInstance();
		currentDate.setTime(date);
		for (int i = 0; i < monthNum; i++) {
			Calendar startDate = (Calendar) currentDate.clone();
			startDate.add(Calendar.MONTH, i);// 后n月
			startDate.set(Calendar.DAY_OF_MONTH, 1);// 设置为月第一天
			startDate.set(Calendar.HOUR_OF_DAY, 0);
			startDate.set(Calendar.MINUTE, 0);
			startDate.set(Calendar.SECOND, 0);
			Calendar endDate = (Calendar) currentDate.clone();
			endDate.add(Calendar.MONTH, i);// 后n月
			// 设置为月最后一天
			endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			endDate.set(Calendar.HOUR_OF_DAY, 23);
			endDate.set(Calendar.MINUTE, 59);
			endDate.set(Calendar.SECOND, 59);
			dateList.add(new Date[] { startDate.getTime(), endDate.getTime() });
		}
		return dateList;
	}

	/**
	 * 根据年龄和当前日期推算其出生日期
	 * 
	 * @param age
	 * @return
	 */
	public static String getBirthDate(int age) {
		return (Calendar.getInstance().get(Calendar.YEAR) - age) + "-" + (new SimpleDateFormat("MM-dd")).format(Calendar.getInstance().getTime());
	}

	/**
	 * 金额数字转人民币大写 最大展示数据 千万万亿级别数据 9999 9999 9999 9999 9999.99 不应超出数据合法范围
	 * 
	 * @param value
	 * @return
	 */
	public static String changeToUpperCaseRMB(double value) {
		// 段内位置表示
		char[] hunit = { '拾', '佰', '仟' };
		// 段名表示 更大范围的数值展示 需扩展该数组
		String[] vunit = { "万", "亿", "万亿", "万万亿" };
		// 数字表示
		char[] digit = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
		// 转化成字符串数字 *100 后转换为 String
		String valStr = String.valueOf((long) (value * 100));
		// 取整数部分
		String digitPart = valStr.substring(0, valStr.length() - 2);
		if (digitPart.length() > 20) {
			return "数值溢出";
		}

		// 取小数部分
		String decimalPart = valStr.substring(valStr.length() - 2);

		// 整数部分转化的结果
		String prefix = "";
		// 小数部分转化的结果
		String suffix = "";
		// 处理小数点后面的数 // 如果小数部分为0
		if (decimalPart.equals("00")) {
			suffix = "整";
		} else {
			suffix = digit[decimalPart.charAt(0) - '0'] + "角" + digit[decimalPart.charAt(1) - '0'] + "分"; // 否则把角分转化出来
		}
		// 处理小数点前面的数 // 把整数部分转化成字符数组
		char[] chDig = digitPart.toCharArray();
		char zero = '0'; // 标志'0'表示出现过0

		// 记录区间内连续出现0的次数 如果去年内全部为零 1 0000 1234
		int zeroSerNum = 0;

		// 用于统计区段内零出现的个数
		int totalDivZero = 0;
		// 用户记录循环进行到那个段内的记录 默认取最外层区段的段下标
		int divIdx = (chDig.length - 1) / 4;

		for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
			// 取段内位置
			int idx = (chDig.length - i - 1) % 4;
			// 取段位置
			int vidx = (chDig.length - i - 1) / 4;

			if (chDig[i] == '0') { // 如果当前字符是0
				zero = digit[0];
				zeroSerNum++; // 连续0次数递增
				if (zero == '0') { // 标志
					zero = digit[0];
				} else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
					prefix += vunit[vidx - 1];
					zero = '0';
				}
				/* 维护增加代码 当前位置的数字为零 并且其段位置等于全局统计的段位置 */
				if (divIdx == vidx) {
					totalDivZero++;
				} else {
					// 当前位置的数字还是零，且已经切换了层位置，则变更计算金额层位置为当前位置
					// 比较上一个区段内0的个数是否为4，如为4，则该段不出现零
					divIdx = vidx;
					if (totalDivZero == 4) {
						zero = '0';
						totalDivZero = 1;
					}
				}
				continue;
			}
			// 当前数字所在段位和前一位不一样 及金额段位发生变化，修改统计段位为当前段位
			// 比价前一段位的0统计的个数为4，则该段的 零 字 不出现
			if (divIdx != vidx) {
				divIdx = vidx;
				if (totalDivZero == 4) {
					zero = '0';
					totalDivZero = 0;
				}
			}
			// 连续0次数清零
			zeroSerNum = 0;
			// 如果标志不为0,则加上,例如万,亿什么的
			if (zero != '0') {
				prefix += zero;
				zero = '0';
			}
			// 转化该数字表示
			prefix += digit[chDig[i] - '0'];
			if (idx > 0) {
				prefix += hunit[idx - 1];
			}
			if (idx == 0 && vidx > 0) {
				// 段结束位置应该加上段名如万,亿,万亿,万万亿...
				prefix += vunit[vidx - 1];
			}
		}
		// 如果整数部分存在,则有圆的字样
		if (prefix.length() > 0) {
			prefix += '圆';
		}
		// 返回正确表示 整数部分 小数部分
		return prefix + suffix;
	}
	
	/**
	 * 手机号中间四位替换为*
	 * @param mobile
	 * @return
	 */
	public static String formatPhone(String mobile)
	{
		String result = mobile ;
		boolean flag = isMobileNO(mobile);
		if(flag==true)
		{
			String str = mobile;
			result = str.substring(0,str.length()-(str.substring(3)).length())+"****"+str.substring(7);
		}
        return result;
	}
	
	/**
	 * 判断是否是手机号
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles)
	{  
		Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		return m.matches();    
    } 
}
