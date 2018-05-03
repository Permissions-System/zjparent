package com.zjgt.p2p.base.domain;

import java.io.Serializable;

public class SerialTemplate
  implements Serializable
{
  private static final long serialVersionUID = -4041613648626867307L;
  public static String SERIAL = "SERIAL";
  private String templateCode;
  private String description;
  private String template;
  private int cachedCount;
  private int counter;
  private int counterSize;

  public SerialTemplate()
  {
    this.cachedCount = 100;
  }

  public int getCounter()
  {
    return this.counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

  public int getCachedCount() {
    return this.cachedCount;
  }

  public void setCachedCount(int cachedCount) {
    this.cachedCount = cachedCount;
  }

  public String getTemplateCode() {
    return this.templateCode;
  }

  public void setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTemplate() {
    return this.template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public int getCounterSize()
  {
    if (this.counterSize != 0) {
      return this.counterSize;
    }

    String key = SERIAL + ",";
    String temp = this.template.substring(this.template.indexOf(key) + key.length());
    temp = temp.substring(0, temp.indexOf(")"));
    temp = temp.substring(1).trim();
    return Integer.parseInt(temp);
  }
}