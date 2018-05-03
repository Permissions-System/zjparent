package com.zjgt.p2p.base.service.impl.serial;

import java.util.Map;

public abstract interface SerialFormater
{
  public abstract String format(Object paramObject, ItemFormat paramItemFormat);

  public abstract Map<String, ItemFormat> getTemplateFormats(String paramString);

  public abstract String format(Map<String, Object> paramMap, String paramString);
}