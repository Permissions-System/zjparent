package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Area;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IAreaService
{
  public abstract String getAreaName(String paramString)
    throws BusinessException;

  public abstract List<Area> getProvinceList()
    throws BusinessException;

  public abstract List<Area> getCityList(String paramString)
    throws BusinessException;

  public abstract List<Area> getCountyList(String paramString)
    throws BusinessException;

  public abstract List<Area> getFullArea(String paramString)
    throws BusinessException;
}