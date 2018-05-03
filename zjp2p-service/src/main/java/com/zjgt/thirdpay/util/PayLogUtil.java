package com.zjgt.thirdpay.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayLogUtil
{
  static Logger logger = LoggerFactory.getLogger(PayLogUtil.class);

  public static void log(String msg) {
    logger.info(msg);
  }

  public static void log(String format, Object[] arguments) {
    logger.info(format, arguments);
  }

  public static void log(String msg, Throwable t) {
    logger.info(msg, t);
  }
}