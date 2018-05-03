package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.CountryDao;
import com.zjgt.p2p.base.domain.Country;
import com.zjgt.p2p.base.service.ICountryService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryService
  implements ICountryService
{

  @Autowired
  private CountryDao countryDao;

  public List<Country> getCountryList()
    throws BusinessException
  {
    return this.countryDao.getCountryList();
  }

  public Country selectByContryCode(String countryCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(countryCode)) {
      return null;
    }

    return this.countryDao.selectByContryCode(countryCode);
  }
}