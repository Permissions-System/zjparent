package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.LoginLocale;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface ILoginLocaleService
{
  public abstract void addLoginLocale(LoginLocale paramLoginLocale)
    throws BusinessException;

  public abstract boolean hasLogin(LoginLocale paramLoginLocale)
    throws BusinessException;

  public abstract void updateLoginLocale(LoginLocale paramLoginLocale)
    throws BusinessException;

  public abstract void recordLoginLocale(LoginLocale paramLoginLocale)
    throws BusinessException;

  public abstract LoginLocale getLoginLocaleByUserNoAndLocale(String paramString1, String paramString2)
    throws BusinessException;

  public abstract List<LoginLocale> getLoginLocaleByUserNo(String paramString)
    throws BusinessException;

  public abstract List<LoginLocale> getLoginLocaleGreaterThanThreshold(String paramString, int paramInt)
    throws BusinessException;
}