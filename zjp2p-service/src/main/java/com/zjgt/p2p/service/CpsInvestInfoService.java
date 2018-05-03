package com.zjgt.p2p.service;

import com.zjgt.p2p.model.CpsInvestinfo;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface CpsInvestInfoService
{
  public abstract void insertCpsInfo(CpsInvestinfo paramCpsInvestinfo)
    throws BusinessException;

  public abstract void updateCpsInfo(CpsInvestinfo paramCpsInvestinfo)
    throws BusinessException;

  public abstract CpsInvestinfo findByMemberid(Long paramLong)
    throws BusinessException;

  public abstract List<CpsInvestinfo> findInvestInfos(String paramString)
    throws BusinessException;

  public abstract CpsInvestinfo findByOrderCode(String paramString)
    throws BusinessException;

  public abstract List<CpsInvestinfo> findInfos(String paramString)
    throws BusinessException;
}