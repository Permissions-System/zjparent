package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Country;
import java.util.List;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface CountryDao
{
  public abstract List<Country> getCountryList();

  public abstract Country selectByContryCode(String paramString);
}