package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Cpssettlelog;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface CpsSettlelogService
{
  public abstract List<Cpssettlelog> findSettlelog(Long paramLong)
    throws BusinessException;

  public abstract List<Cpssettlelog> findSettlelog(Long paramLong, Integer paramInteger)
    throws BusinessException;

  public abstract List<Cpssettlelog> findSettlelogs(Long paramLong, String paramString, Integer paramInteger)
    throws BusinessException;

  public abstract Cpssettlelog findSettlelog(Long paramLong, String paramString, Integer paramInteger)
    throws BusinessException;

  public abstract void updatesettlelog(Cpssettlelog paramCpssettlelog)
    throws BusinessException;

  public abstract void insertsettlelog(Cpssettlelog paramCpssettlelog)
    throws BusinessException;

  public abstract List<Cpssettlelog> findSettlelogs(Date paramDate)
    throws BusinessException;

  public abstract List<Cpssettlelog> selectLastTTFlog()
    throws BusinessException;

  public abstract List<Cpssettlelog> findByBidcode(String paramString)
    throws BusinessException;
}