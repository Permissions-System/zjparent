package com.zjgt.p2p.common;

import java.math.BigDecimal;

public class Const
{
  public static int XIN_SHOU_BIAO = 1;

  public static int DING_CUN_BAO = 2;

  public static int YUE_XI_BAO = 3;

  public static int PRODUCTS_PAGE_SIZE = 5;

  public static int BADBID_PAGE_SIZE = 5;

  public static int NEWS_PAGE_SIZE = 5;

  public static int INVESTORDER_PAGE_SIZE = 3;

  public static int RECORDS_PAGE_SIZE = 21;

  public static int BID_PAGE_SIZE = 8;

  public static int INVESTRECORD_PAGE_SIZE = 7;

  public static int BONUSRECORD_PAGE_SIZE = 10;

  public static int Message_PAGE_SIZE = 5;

  public static String CHANNEL = "channel";

  public static String CHANNEL2 = "channel2";

  public static class SETTLESTATUS
  {
    public static final int UNSETTLE = 0;
    public static final int SETTLED = 1;
    public static final int ENDING = 2;
  }

  public static class PROFITSTATUS
  {
    public static final int UNPROFIT = 0;
    public static final int PROFITING = 1;
    public static final int PROFITED = 2;
    public static final int ENDING = 3;
  }

  public static class APP_SIZE
  {
    public static final int BID = 10;
  }

  public static final class CPS_OPER
  {
    public static final String register = "register";
    public static final String login = "login";
    public static final String invest = "invest";
    public static final String browser = "browser";
  }

  public static final class IF_SUM
  {
    public static final int UNSUM = 0;
    public static final int SUM = 1;
  }

  public static final class BONUS_TYPE
  {
    public static final int ADD = 0;
    public static final int SUBTRACT = 1;
  }

  public static final class PAY_STATUS
  {
    public static final int UNPAY = 0;
    public static final int PAY = 1;
  }

  public static final class PERIOD_TYPE
  {
    public static final int MONTH = 0;
    public static final int DAY = 1;
    public static final int YEAR = 2;
  }

  public static final class MEMBER_TYPE
  {
    public static final int BUYER = 0;
    public static final int BORROWER = 1;
    public static final int PLATFORM = 2;
  }

  public static final class TRANS_STATUS
  {
    public static final int COMMON = 1;
    public static final int TRANS = 2;
  }

  public static final class PAY_GATEWAY
  {
    public static final int SINA = 1;
    public static final int LL = 2;
  }

  public static final class ACCOUNT_TYPE
  {
    public static final int PAYER = 0;
    public static final int PLATFORM = 1;
    public static final int THIRD = 2;
    public static final int PAYEE = 3;
    public static final int PLATFORMPAYER = 4;
    public static final String SINA_PAY = "微钱包";
    public static final String SINA_PAY_PLATFORM = "微钱包平台";
    public static final String LL_PAY = "连连";
    public static final String LL_PAY_PLATFORM = "连连平台";
  }

  public static final class FEES
  {
    public static final BigDecimal SINA_FROM_BIIFOO = new BigDecimal(2);
  }

  public static final class RECORD_TYPE
  {
    public static final String ADJUST_LOG = "AL";
    public static final String TRAN_LOG = "TL";
    public static final String REPAY_PLAN = "RP";
    public static final String YIELD_PLAN = "YP";
  }

  public static final class USER_STATUS
  {
    public static final Short NORMAL = Short.valueOf((short) 1);

    public static final Short FREEZE = Short.valueOf((short) 0);
  }

  public static final class TRANS_TYPE
  {
    public static final Integer WITHDRAW = Integer.valueOf(0);

    public static final Integer FILL = Integer.valueOf(1);
  }

  public static class CURRENCY_TYPE
  {
    public static final String CNY = "CNY";
  }

  public static class PAY_DEAL_STATUS
  {
    public static final int PROCESS = 0;
    public static final int SUCCESS = 1;
    public static final int PAY_FAIL = 2;
    public static final int SELT_FAIL = 3;
    public static final int VERIFY_FAIL = 4;
  }

  public static class PAY_DEAL_ID
  {
    public static final String SINA = "0";
    public static final String LIANLIAN = "1";
  }

  public static class TRAN_STATUS
  {
    public static final int PROCESS = 0;
    public static final int SUCCESS = 1;
    public static final int FAIL = 2;
  }

  public static final class IN_OR_OUT
  {
    public static final String INPUT = "I";
    public static final String OUTPUT = "O";
    public static final String DOUBLE = "D";
  }
}