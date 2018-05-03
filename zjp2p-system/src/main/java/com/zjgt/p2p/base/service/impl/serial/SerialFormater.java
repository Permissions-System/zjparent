package com.zjgt.p2p.base.service.impl.serial;

import java.util.Map;

public abstract interface SerialFormater
{
  public abstract String format(Object paramObject, ItemFormat paramItemFormat);

  public abstract Map<String, ItemFormat> getTemplateFormats(String paramString);

  public abstract String format(Map<String, Object> paramMap, String paramString);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.impl.serial.SerialFormater
 * JD-Core Version:    0.5.3
 */