package com.zjgt.p2p.base.service.impl.serial;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultSerialFormater
  implements SerialFormater
{
  private String serialPattern;
  private char fillin;
  private boolean fillBefore;

  public DefaultSerialFormater()
  {
    this.serialPattern = "[\\[\\(](.+?)[\\]\\)]";
    this.fillin = '0';
    this.fillBefore = true;
  }

  public Map<String, ItemFormat> getTemplateFormats(String template)
  {
    Matcher matcher = getMatcher(template, this.serialPattern);
    Map formats = new HashMap();
    while (matcher.find()) {
      String item = matcher.group(1);
      String group = matcher.group();
      boolean isFunction = group.startsWith("(");
      ItemFormat format = ItemFormat.parse(item, isFunction);
      formats.put(format.key, format);
    }
    return formats;
  }

  public String format(Map<String, Object> formatedParams, String template)
  {
    Matcher matcher = getMatcher(template, this.serialPattern);
    StringBuffer buffer = new StringBuffer();
    while (matcher.find()) {
      String item = matcher.group(1);
      String group = matcher.group();
      boolean isFunction = group.startsWith("(");
      ItemFormat format = ItemFormat.parse(item, isFunction);
      format.fillin = this.fillin;
      Object value = formatedParams.get(format.key);
      matcher.appendReplacement(buffer, format.format(value));
    }
    matcher.appendTail(buffer);
    return buffer.toString();
  }

  public String format(Object value, ItemFormat fmt)
  {
    return fmt.format(value, this.fillin, this.fillBefore);
  }

  private Matcher getMatcher(String template, String patternStr)
  {
    Pattern pattern = Pattern.compile(patternStr);
    return pattern.matcher(template);
  }

  public void setFillin(char fillin) {
    this.fillin = fillin;
  }

  public void setFillBefore(boolean fillBefore) {
    this.fillBefore = fillBefore;
  }

  public void setSerialPattern(String serialPattern) {
    this.serialPattern = serialPattern;
  }
}