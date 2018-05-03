package com.zjgt.p2p.service;

import com.zjgt.util.YieldInfo;
import java.util.Date;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface YieldBatchTransation
{
  public abstract int generatorYieldplan(String paramString, int paramInt, YieldInfo paramYieldInfo, boolean paramBoolean)
    throws BusinessException;

  public abstract int selfRepay(String paramString, int paramInt, Date paramDate)
    throws BusinessException;

  public abstract int batchRepay(Date paramDate)
    throws BusinessException;

  public abstract void batchRepay()
    throws BusinessException;

  public abstract int rolloutTTF(String paramString1, String paramString2)
    throws Exception;

  public abstract void deleteByOrderCode(String paramString);

  public abstract int rolloutTTF2(Long paramLong, String paramString)
    throws Exception;
}