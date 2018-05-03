package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Area;
import java.util.List;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface AreaDao
{
  public abstract Area getAreaByAreaCode(String paramString);

  public abstract List<Area> getProvinceList();

  public abstract List<Area> getCityList(String paramString);

  public abstract List<Area> getCountyList(String paramString);

  public abstract List<Area> getFullArea(String paramString);
}