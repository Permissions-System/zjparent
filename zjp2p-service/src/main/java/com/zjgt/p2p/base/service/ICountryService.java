package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Country;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface ICountryService
{
  public abstract List<Country> getCountryList()
    throws BusinessException;

  public abstract Country selectByContryCode(String paramString)
    throws BusinessException;
}