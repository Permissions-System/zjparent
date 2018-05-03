package com.zjgt.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils
{
  static Properties config = null;

  static Properties messageConfig = null;

  static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

  public static void load() {
    config = new Properties();

    InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
    try {
      config.load(in);
    } catch (IOException e) {
      logger.error("解析 config.properties 文件失败", e);
      e.printStackTrace();
    }

    messageConfig = new Properties();
    InputStream messageIn = PropertiesUtils.class.getClassLoader().getResourceAsStream("message.properties");
    try {
      messageConfig.load(messageIn);
    } catch (IOException e) {
      logger.error("解析 config.properties 文件失败", e);
      e.printStackTrace();
    }
  }

  public static String getProperties(String propertyName) {
    if (config.get(propertyName) == null) {
      return null;
    }
    return config.get(propertyName).toString();
  }

  public static String getPropertiesByMessage(String propertyName) {
    if (messageConfig.get(propertyName) == null) {
      return null;
    }
    return messageConfig.get(propertyName).toString();
  }

  public static String getEmail(String email) throws Exception {
    return getProperties(email);
  }

  public static String getBonus(String propertyName) throws Exception {
    return getProperties(propertyName);
  }
}