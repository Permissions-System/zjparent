package com.zjgt.util;

import java.text.DecimalFormat;

public class PoundageUtil
{
  public static double getPoundageForMember(int count, String withdrawal, int times)
  {
    Double with = Double.valueOf(Double.parseDouble(withdrawal));
    DecimalFormat df = new DecimalFormat("#0.00");
    if (count == 0) {
      return Double.parseDouble(df.format(with.doubleValue() * 0.006D + 2.0D));
    }
    if ((times > 0) && (times < 4)) {
      return 2.0D;
    }
    return 0.0D;
  }

  public static double getPoundageForTerrace(int times)
  {
    return (2 * times);
  }

  public static int getRechargeForMember(int times)
  {
    return (0 * times);
  }

  public static double getRechargeForTerrace(int withdrawal, int times)
  {
    return (withdrawal * 0.0025D * times);
  }

  public static double getRechargeForTerraceTwo(int withdrawal, int times)
  {
    return (withdrawal * 0.006D * times);
  }

  public static double getRechargeForTerraceTwo(int withdrawal)
  {
    return (withdrawal * 0.02D);
  }
}