package com.zjgt.util;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.TermStatus;
import com.zjgt.p2p.model.Yieldplan;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class YieldCalcUtil
{
  public static final String REPAYMEN_METHOD_LUMP = "3";
  public static final String REPAYMEN_METHOD_MONTHLY_INTRST_LUMP_CAP = "1";
  public static final String REPAYMEN_METHOD_AVG_CAP_INTRST = "2";
  public static final String TIANTIANFU = "4";
  public static final String TERM_TYPE_DAY = "D";
  public static final String TERM_TYPE_MONTH = "M";
  public static final String TERM_TYPE_YEAR = "Y";
  public static final int SCALE = 4;
  public static final int CALCULATE_SCALE = 10;
  public static final RoundingMode FLOOR = RoundingMode.FLOOR;
  public static final int DAYS_A_YEAR = 360;
  public static final int DAYS_YEAR_365 = 365;

  public static YieldInfo yieldCalc(String repaymentMethod, String termType, Date startDate, int speciRepayDay, BigDecimal principal, BigDecimal yearRate, int term, String bidtypeid, boolean istrans)
    throws Exception
  {
    if ((String.valueOf(BidType.YUEXIBAO.getKey()).equals(bidtypeid)) && 
      (!(istrans)))
    {
      term *= 30;
    }

    return yieldCalc(repaymentMethod, termType, startDate, speciRepayDay, principal, yearRate, term, 360, bidtypeid);
  }

  public static YieldInfo yieldCalc(String repaymentMethod, String termType, Date startDate, int speciRepayDay, BigDecimal principal, BigDecimal yearRate, int term, int daysAYear, String bidtypeid)
    throws Exception
  {
    if ((principal.scale() > 2) || (yearRate.scale() > 4)) {
      throw new Exception("输入金额或年利率小数位错误");
    }
    if ("4".equals(bidtypeid)) {
      return yieldCalc_asDays(principal, yearRate, 365);
    }
    if ("3".equals(repaymentMethod)) {
      return yieldCalc_lump(startDate, principal, yearRate, term, daysAYear);
    }

    if ("1".equals(repaymentMethod)) {
      return yieldCalc_monthlyIntrst_lumpCap(startDate, principal, yearRate, term);
    }

    if ("2".equals(repaymentMethod)) {
      return yieldCalc_avg_capIntrst(termType, startDate, principal, yearRate, term, daysAYear);
    }

    throw new Exception("计算还款数据异常");
  }

  public static BigDecimal overdueAIR(BigDecimal yearRate)
    throws Exception
  {
    return overdueAIR(yearRate, 360);
  }

  public static BigDecimal overdueAIR(BigDecimal yearRate, int daysAYear)
    throws Exception
  {
    if (yearRate.scale() > 4) {
      throw new Exception("输入年利率小数位错误");
    }
    return yearRate.multiply(BigDecimal.ONE.add(new BigDecimal("0.4")).divide(new BigDecimal(daysAYear), 4, FLOOR));
  }

  private static YieldInfo yieldCalc_avg_capIntrst(String termType, Date startDate, BigDecimal principal, BigDecimal yearRate, int term, int daysAYear)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, termType, daysAYear);
    YieldInfo yieldInfo = new YieldInfo();
    yieldInfo.setPerTermAmount(avgCapIntr_TermTotle(principal, termRate, term));

    yieldInfo.setTotalAmount(yieldInfo.getPerTermAmount().multiply(new BigDecimal(term)));

    yieldInfo.setTotalInterest(yieldInfo.getTotalAmount().subtract(principal));

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);

    List yieldDtls = new ArrayList();
    BigDecimal firstRepayAmount = BigDecimal.ZERO;
    BigDecimal remainPrincipal = principal;
    double repaidamount = 0.0D;
    double rate = 0.0D;
    double remaininterest = 0.0D;
    for (int i = 1; i <= term; ++i) {
      Yieldplan plan = new Yieldplan();
      plan.setTermnum(Integer.valueOf(i));
      if ("M".equals(termType))
        calendar.add(2, 1);
      else {
        throw new Exception("不支持的还款周期");
      }

      plan.setTermdate(calendar.getTime());

      BigDecimal accruedinterest = avgCapIntr_Interest(remainPrincipal, termRate);

      plan.setAccruedinterest(accruedinterest.setScale(2, FLOOR));
      BigDecimal termPrincipal = avgCapIntr_TermPrincipal(principal, termRate, term, remainPrincipal);

      plan.setPrincipalamount(termPrincipal.setScale(2, FLOOR));

      plan.setTermamount(yieldInfo.getPerTermAmount().setScale(2, FLOOR));
      plan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
      remainPrincipal = remainPrincipal.subtract(termPrincipal);

      plan.setRemainpriamount(remainPrincipal.setScale(2, FLOOR));
      repaidamount += yieldInfo.getPerTermAmount().doubleValue();
      rate += plan.getAccruedinterest().doubleValue();

      plan.setRepaidamount(new BigDecimal(repaidamount).setScale(2, FLOOR));

      if (i == 1) {
        remaininterest = yieldInfo.getTotalInterest().subtract(accruedinterest).doubleValue();
      }
      else if (i == term)
        remaininterest = 0.0D;
      else {
        remaininterest -= accruedinterest.doubleValue();
      }
      plan.setRemaininterest(new BigDecimal(remaininterest).setScale(2, FLOOR));

      if (i == 1) {
        firstRepayAmount = plan.getTermamount();
      }
      yieldDtls.add(plan);
      System.out.println("期次：" + plan.getTermnum() + "每期收益=" + plan.getTermamount() + "剩余本金=" + plan.getRemainpriamount() + "每期本金=" + plan.getPrincipalamount() + "每期利息=" + plan.getAccruedinterest() + "已还款金额" + plan.getRepaidamount() + "已还利息" + rate + "riqi" + plan.getTermdate() + "剩余利息" + plan.getRemaininterest());
    }

    yieldInfo.setFirstRepayAmount(firstRepayAmount);
    yieldInfo.setYieldDtls(yieldDtls);
    return yieldInfo;
  }

  private static YieldInfo yieldCalc_monthlyIntrst_lumpCap(Date startDate, BigDecimal principal, BigDecimal yearRate, int term)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, "M");
    YieldInfo yieldInfo = new YieldInfo();
    yieldInfo.setPerTermAmount(monthlyInterest(principal, termRate));
    yieldInfo.setTotalInterest(yieldInfo.getPerTermAmount().multiply(new BigDecimal(term)));

    yieldInfo.setTotalAmount(principal.add(yieldInfo.getTotalInterest()));
    yieldInfo.setFirstRepayAmount(yieldInfo.getPerTermAmount());

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    double repaidamount = 0.0D;
    double rate = 0.0D;
    List yieldDtls = new ArrayList();
    for (int i = 1; i <= term; ++i) {
      Yieldplan plan = new Yieldplan();
      plan.setTermnum(Integer.valueOf(i));
      plan.setPrincipalamount((i == term) ? principal : BigDecimal.ZERO);
      plan.setAccruedinterest(yieldInfo.getPerTermAmount());
      plan.setRemainpriamount((i == term) ? BigDecimal.ZERO : principal);
      plan.setRemaininterest(yieldInfo.getTotalInterest().subtract(plan.getAccruedinterest().multiply(new BigDecimal(i))));

      plan.setTermamount(plan.getPrincipalamount().add(plan.getAccruedinterest()));

      repaidamount += plan.getTermamount().doubleValue();
      rate += plan.getAccruedinterest().doubleValue();
      plan.setRepaidamount(new BigDecimal(repaidamount).setScale(4, FLOOR));

      calendar.add(2, 1);
      plan.setTermdate(calendar.getTime());
      plan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
      yieldDtls.add(plan);
      System.out.println("期次：" + plan.getTermnum() + "每期收益=" + plan.getTermamount() + "剩余本金=" + plan.getRemainpriamount() + "每期本金=" + plan.getPrincipalamount() + "每期利息=" + plan.getAccruedinterest() + "已还款金额" + plan.getRepaidamount() + "已还利息" + rate + "riqi" + plan.getTermdate() + "剩余利息" + plan.getRemaininterest());
    }

    yieldInfo.setYieldDtls(yieldDtls);
    return yieldInfo;
  }

  public static BigDecimal yieldCalc_day(BigDecimal principal, BigDecimal yearRate, int days, int daysAYear)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, "D", daysAYear);
    BigDecimal money = principal.multiply(termRate).multiply(new BigDecimal(days));

    return money.setScale(2, FLOOR);
  }

  public static BigDecimal yieldCalc_ttfRedem(BigDecimal principal, BigDecimal yearRate, int days, int daysAYear)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, "D", daysAYear);
    BigDecimal money = principal.multiply(BigDecimal.ONE.add(termRate).pow(days));

    return money.setScale(2, FLOOR);
  }

  public static YieldInfo yieldCalc_asDays(BigDecimal principal, BigDecimal yearRate, int daysAYear)
    throws Exception
  {
    Double val = Double.valueOf(principal.multiply(yearRate).doubleValue() / daysAYear);
    BigDecimal money = new BigDecimal(val.doubleValue()).setScale(2, FLOOR);
    YieldInfo info = new YieldInfo();
    info.setFirstRepayAmount(money.setScale(2, FLOOR));
    info.setPerTermAmount(money.setScale(2, FLOOR));
    info.setTotalInterest(money.setScale(2, FLOOR));
    List yieldDtls = new ArrayList();
    Yieldplan plan = new Yieldplan();
    plan.setTermnum(Integer.valueOf(1));
    plan.setRemainpriamount(principal);
    plan.setAccruedinterest(info.getPerTermAmount());
    plan.setTermamount(info.getPerTermAmount());
    yieldDtls.add(plan);
    info.setYieldDtls(yieldDtls);
    return info;
  }

  private static YieldInfo yieldCalc_lump(Date startDate, BigDecimal principal, BigDecimal yearRate, int term, int daysAYear)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, "D", daysAYear);
    YieldInfo yieldInfo = new YieldInfo();
    yieldInfo.setTotalAmount(totalamount(principal, termRate, term));
    yieldInfo.setFirstRepayAmount(yieldInfo.getTotalAmount().setScale(2, FLOOR));

    yieldInfo.setPerTermAmount(yieldInfo.getTotalAmount().setScale(2, FLOOR));

    yieldInfo.setTotalInterest(yieldInfo.getTotalAmount().subtract(principal).setScale(2, FLOOR));

    List yieldDtls = new ArrayList();
    Yieldplan plan = new Yieldplan();
    plan.setTermnum(Integer.valueOf(1));
    plan.setPrincipalamount(principal);
    plan.setRemainpriamount(BigDecimal.ZERO);
    plan.setRemaininterest(BigDecimal.ZERO);
    plan.setAccruedinterest(yieldInfo.getTotalInterest().setScale(2, FLOOR));

    plan.setTermamount(yieldInfo.getTotalAmount().setScale(2, FLOOR));

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    calendar.add(5, term);

    plan.setTermdate(calendar.getTime());
    plan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
    yieldDtls.add(plan);
    yieldInfo.setTotalAmount(yieldInfo.getTotalAmount().setScale(2, FLOOR));
    yieldInfo.setYieldDtls(yieldDtls);
    return yieldInfo;
  }

  private static YieldInfo yieldCalc_yueyuefuT(Date startDate, BigDecimal principal, BigDecimal yearRate, int term, int daysAYear)
    throws Exception
  {
    BigDecimal termRate = calcTermRate(yearRate, "M", daysAYear);
    YieldInfo yieldInfo = new YieldInfo();
    BigDecimal totalamount = principal.multiply(BigDecimal.ONE.add(termRate).pow(term));

    yieldInfo.setTotalAmount(totalamount.setScale(2, FLOOR));
    yieldInfo.setFirstRepayAmount(yieldInfo.getTotalAmount());
    yieldInfo.setPerTermAmount(yieldInfo.getTotalAmount());
    yieldInfo.setTotalInterest(yieldInfo.getTotalAmount().subtract(principal).setScale(2, FLOOR));

    List yieldDtls = new ArrayList();
    Yieldplan plan = new Yieldplan();
    plan.setTermnum(Integer.valueOf(1));
    plan.setPrincipalamount(principal);
    plan.setRemainpriamount(BigDecimal.ZERO);
    plan.setAccruedinterest(yieldInfo.getTotalInterest());

    plan.setTermamount(principal.add(yieldInfo.getTotalInterest()));

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(startDate);
    calendar.add(5, term);

    plan.setTermdate(calendar.getTime());
    plan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
    yieldDtls.add(plan);
    yieldInfo.setYieldDtls(yieldDtls);
    return yieldInfo;
  }

  private static BigDecimal calcTermRate(BigDecimal yearRate, String termType)
    throws Exception
  {
    return calcTermRate(yearRate, termType, 360);
  }

  private static BigDecimal calcTermRate(BigDecimal yearRate, String termType, int daysAYear) throws Exception
  {
    if ("D".equals(termType)) {
      return yearRate.divide(new BigDecimal(daysAYear), 10, FLOOR);
    }

    if ("M".equals(termType)) {
      return yearRate.divide(new BigDecimal(12), 10, FLOOR);
    }
    if ("Y".equals(termType)) {
      return yearRate;
    }

    throw new Exception("计算期利率异常");
  }

  private static BigDecimal lumpInterest(BigDecimal capital, BigDecimal dayRate, int days)
  {
    return capital.multiply(dayRate).multiply(new BigDecimal(days)).setScale(4, FLOOR);
  }

  private static BigDecimal lumpTotle(BigDecimal capital, BigDecimal dayRate, int days)
  {
    return capital.add(capital.multiply(dayRate).multiply(new BigDecimal(days))).setScale(4, FLOOR);
  }

  private static BigDecimal totalamount(BigDecimal capital, BigDecimal dayRate, int days)
  {
    return capital.multiply(BigDecimal.ONE.add(dayRate).pow(days)).setScale(4, FLOOR);
  }

  private static BigDecimal monthlyInterest(BigDecimal capital, BigDecimal monthRate)
  {
    return capital.multiply(monthRate).setScale(4, FLOOR);
  }

  private static BigDecimal avgCapIntr_TermTotle(BigDecimal capital, BigDecimal termRate, int termes)
  {
    return capital.multiply(BigDecimal.ONE.add(termRate).pow(termes)).multiply(termRate).divide(BigDecimal.ONE.add(termRate).pow(termes).subtract(BigDecimal.ONE), 4, FLOOR);
  }

  private static BigDecimal avgCapIntr_TermPrincipal(BigDecimal capital, BigDecimal termRate, int termes, BigDecimal remainCapital)
  {
    return capital.multiply(BigDecimal.ONE.add(termRate).pow(termes)).multiply(termRate).divide(BigDecimal.ONE.add(termRate).pow(termes).subtract(BigDecimal.ONE), 10, FLOOR).subtract(remainCapital.multiply(termRate)).setScale(10, FLOOR);
  }

  private static BigDecimal avgCapIntr_Interest(BigDecimal remainCapital, BigDecimal termRate)
  {
    return remainCapital.multiply(termRate).setScale(4, FLOOR);
  }

  public static int daysOfTwo(Date fDate, Date oDate) {
    Calendar aCalendar = Calendar.getInstance();
    aCalendar.setTime(new Date(fDate.getYear(), fDate.getMonth(), fDate.getDate()));

    long start = aCalendar.getTimeInMillis();
    aCalendar.setTime(new Date(oDate.getYear(), oDate.getMonth(), oDate.getDate()));

    long end = aCalendar.getTimeInMillis();
    long result = (end - start) / 86400000L;
    return (int)result;
  }

  public static void main(String[] args)
    throws Exception
  {
    System.out.println(yieldCalc_day(new BigDecimal("1000.00"), new BigDecimal("0.12"), 10, 360));

    System.out.println(totalamount(new BigDecimal("10000.00"), new BigDecimal(0.0003333333333333333D), 30));

    Calendar calendar = Calendar.getInstance();
    calendar.add(5, 245);
    System.out.println(calendar.getTime());
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(2, 3);
    int term = DateConverterUtil.daysBetween(new Date(), cal.getTime());
    System.out.println(term);
    System.out.println(new BigDecimal("1").multiply(new BigDecimal("0.06")));
    yieldCalc_asDays(new BigDecimal("1"), new BigDecimal("0.06"), 360);
  }
}