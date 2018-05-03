package com.zjgt.p2p.dao;

public abstract interface LLPayMapper
{
  public abstract String getBankCodeByName(String paramString);

  public abstract String getProvinceIdByName(String paramString);

  public abstract String getCityIdByName(String paramString);
}