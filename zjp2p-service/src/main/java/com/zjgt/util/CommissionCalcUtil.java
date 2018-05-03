package com.zjgt.util;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.model.Cpssettlelog;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommissionCalcUtil
{
  public static final int SCALE = 2;
  public static final RoundingMode FLOOR = RoundingMode.FLOOR;
  private static final int DAYS_YEAR_365 = 365;

  public static List<Cpssettlelog> CommissionCalc(Date startDate, Date endDate, Date coopDate, BigDecimal principal, BigDecimal yearRate, int term, int bidtypeid, boolean istrans)
    throws Exception
  {
    Calendar calStart = Calendar.getInstance();
    calStart.setTime(startDate);
    calStart.set(11, 0);
    calStart.set(12, 0);
    calStart.set(13, 0);
    Calendar calEnd = Calendar.getInstance();
    calEnd.setTime(endDate);
    calEnd.set(11, 0);
    calEnd.set(12, 0);
    calEnd.set(13, 0);
    Calendar calCoop = Calendar.getInstance();
    calCoop.setTime(coopDate);

    calCoop.set(11, 0);
    calCoop.set(12, 0);
    calCoop.set(13, 0);

    if ((BidType.YUEXIBAO.getKey() == bidtypeid) && 
      (!(istrans))) {
      term *= 30;
    }

    return Calc(calStart.getTime(), calEnd.getTime(), calCoop.getTime(), principal, yearRate, term, bidtypeid, istrans);
  }

  private static List<Cpssettlelog> Calc(Date startDate, Date endDate, Date coopDate, BigDecimal principal, BigDecimal yearRate, int term, int bidtypeid, boolean istrans)
    throws Exception
  {
    if ((principal.scale() > 3) || (yearRate.scale() > 4)) {
      throw new Exception("输入金额或年利率小数位错误");
    }

    if (BidType.MINGXINGBIAO.getKey() == bidtypeid) {
      return calc_ttf(startDate, endDate, coopDate, principal, yearRate);
    }
    if (BidType.YUEXIBAO.getKey() == bidtypeid) {
      return calc_yyfT(startDate, endDate, coopDate, principal, yearRate, term, istrans);
    }
    throw new Exception("计算还款数据异常");
  }

  private static List<Cpssettlelog> calc_yyfT(Date startDate, Date endDate, Date coopDate, BigDecimal principal, BigDecimal yearRate, int term, boolean istrans)
    throws Exception
  {
    List list = new ArrayList();
    int commissiondate = term;
    int num = term / 30;

    Calendar start = Calendar.getInstance();
    start.setTime(startDate);
    Calendar end = Calendar.getInstance();
    end.setTime(endDate);

    if ((end.get(5) != 1) || (start.get(5) != 1)) {
      num += 1;
    }

    if (istrans) {
      int e = end.get(2);
      int s = start.get(2);
      num = e - s + 1;
      if ((end.get(5) == 1) && (start.get(5) == 1)) {
        num = e - s;
      }

    }

    for (int i = 0; i < num; ++i) {
      Cpssettlelog cpssettlelog = new Cpssettlelog();
      cpssettlelog.setTermnum(Integer.valueOf(i + 1));

      Calendar calSettle = Calendar.getInstance();
      calSettle.setTime(startDate);
      calSettle.set(5, 1);
      calSettle.add(2, i + 1);
      cpssettlelog.setSettledate(calSettle.getTime());
      cpssettlelog.setSettleamount(principal);

      int days = 30;
      if ((i == 0) && (num - 1 > 0)) {
        days = DateConverterUtil.daysBetween2(startDate, calSettle.getTime());
      }
      else if (i == num - 1) {
        days = commissiondate;
      }

      BigDecimal commission = yyftCommision(principal, yearRate, days);
      cpssettlelog.setCommission(commission);
      cpssettlelog.setSettlestatus(Integer.valueOf(0));

      if ((calSettle.getTime().after(coopDate)) || (DateConverterUtil.areSameDay(coopDate, calSettle.getTime()))) {
        calSettle.add(2, -1);
        days = DateConverterUtil.daysBetween2(calSettle.getTime(), coopDate);
        if (i == 0) {
          days = DateConverterUtil.daysBetween2(startDate, coopDate);
        }
        commission = yyftCommision(principal, yearRate, days);
        cpssettlelog.setCommission(commission);
        list.add(cpssettlelog);
        break;
      }
      list.add(cpssettlelog);
      commissiondate -= days;
    }
    return list;
  }

  public static BigDecimal yyftCommision(BigDecimal principal, BigDecimal yearRate, int term)
  {
    Double val = Double.valueOf(principal.doubleValue() * yearRate.doubleValue() * term / 30.0D / 100.0D / 12.0D);

    BigDecimal amount = new BigDecimal(val.doubleValue());
    return amount.setScale(2, FLOOR);
  }

  private static List<Cpssettlelog> calc_ttf(Date startDate, Date endDate, Date coopDate, BigDecimal principal, BigDecimal yearRate) throws Exception
  {
    List list = new ArrayList();
    Cpssettlelog cpssettlelog = new Cpssettlelog();
    cpssettlelog.setTermnum(Integer.valueOf(1));

    Calendar calSettle = Calendar.getInstance();
    calSettle.setTime(startDate);
    calSettle.set(5, 1);
    calSettle.add(2, 1);
    cpssettlelog.setSettledate(calSettle.getTime());
    cpssettlelog.setSettleamount(principal);

    int days = DateConverterUtil.daysBetween(startDate, endDate);

    if ((calSettle.getTime().after(coopDate)) || (DateConverterUtil.areSameDay(calSettle.getTime(), coopDate))) {
      days = DateConverterUtil.daysBetween(startDate, coopDate);
    }
    if (DateConverterUtil.areSameDay(startDate, endDate)) {
      days = 1;
    }

    BigDecimal commission = ttfCommision(principal, yearRate, days);
    cpssettlelog.setCommission(commission);
    cpssettlelog.setSettlestatus(Integer.valueOf(0));
    list.add(cpssettlelog);
    return list;
  }

  public static BigDecimal ttfCommision(BigDecimal principal, BigDecimal yearRate, int term)
    throws Exception
  {
    Double val = Double.valueOf(principal.doubleValue() * yearRate.doubleValue() * term / 100.0D / 365.0D);
    BigDecimal amount = new BigDecimal(val.doubleValue());
    return amount.setScale(2, FLOOR);
  }

  public static void main(String[] args) throws Exception {
    System.out.println(new BigDecimal("1").compareTo(BigDecimal.ZERO) > 0);
    System.out.println(yyftCommision(new BigDecimal("30000"), new BigDecimal("0.35"), 3));
    Calendar cal = Calendar.getInstance();
    cal.set(2015, 6, 1);
    System.out.println(cal.getTime());
    Calendar cal1 = Calendar.getInstance();
    cal1.set(2015, 8, 12);
    System.out.println(cal1.getTime());
    Calendar cal2 = Calendar.getInstance();
    cal2.set(2015, 9, 12);
    List<Cpssettlelog> list = CommissionCalc(cal.getTime(), cal1.getTime(), cal2.getTime(), new BigDecimal("5000"), new BigDecimal("0.4"), DateConverterUtil.daysBetween2(cal.getTime(), cal1.getTime()), 3, true);
    for (Cpssettlelog log : list)
      System.out.println("num:" + log.getTermnum() + ",settleamount:" + log.getSettleamount() + ",commision:" + log.getCommission() + ",settledate:" + log.getSettledate());
  }
}