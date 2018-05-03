package com.zjgt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

public class SystemUtils
{
  private static final Logger logger = LoggerFactory.getLogger(SystemUtils.class);
  private static Properties props;
  private static String[] propertyFiles = { "config.properties" };
  private static boolean isDevMode = false;

  public static String getProp(String prop)
  {
    return getProp(prop, null);
  }

  public static String getProp(String prop, String defaultValue)
  {
    return props.getProperty(prop, defaultValue);
  }

  public static boolean getBooleanProp(String prop, boolean defaultValue)
  {
    String value = props.getProperty(prop);
    if (value != null) {
      return Boolean.parseBoolean(value);
    }
    return defaultValue;
  }

  public static boolean isDevMode()
  {
    return isDevMode;
  }

  static
  {
    InputStream ins = null;
    props = new Properties();

    for (String propertyFile : propertyFiles) {
      try {
        Properties props2 = new Properties();
        ins = SystemUtils.class.getResourceAsStream("/" + propertyFile);
        props2.load(ins);
        props.putAll(props2);
        if (logger.isDebugEnabled())
          logger.debug("Load " + propertyFile + " success!");
      }
      catch (IOException e) {
        logger.error("Load " + propertyFile + " from classes Fail!", e);
        try {
          File f = ResourceUtils.getFile("jar:" + propertyFile);
          if ((f != null) && (f.exists())) {
            ins = new FileInputStream(f);
          }
          props.load(ins);
        } catch (Exception e1) {
          logger.error("Load classpath system.properties Fail!", e1);
        }
      } finally {
        IOUtils.closeQuietly(ins);
      }
    }

    if (props.getProperty("system.devMode") != null)
      isDevMode = Boolean.parseBoolean(props.getProperty("system.devMode"));
  }
}