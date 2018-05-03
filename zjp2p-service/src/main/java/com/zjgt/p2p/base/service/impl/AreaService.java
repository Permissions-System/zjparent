package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.AreaDao;
import com.zjgt.p2p.base.domain.Area;
import com.zjgt.p2p.base.service.IAreaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaService
  implements IAreaService
{

  @Autowired
  private AreaDao areaDao;

  public String getAreaName(String areaCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(areaCode)) {
      return null;
    }

    return this.areaDao.getAreaByAreaCode(areaCode).getAreaName();
  }

  public List<Area> getProvinceList()
    throws BusinessException
  {
    return this.areaDao.getProvinceList();
  }

  public List<Area> getCityList(String proviceCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(proviceCode)) {
      return null;
    }

    return this.areaDao.getCityList(proviceCode);
  }

  public List<Area> getCountyList(String cityCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(cityCode)) {
      return null;
    }

    return this.areaDao.getCountyList(cityCode);
  }

  public List<Area> getFullArea(String areaCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(areaCode)) {
      return null;
    }
    return this.areaDao.getFullArea(areaCode);
  }
}