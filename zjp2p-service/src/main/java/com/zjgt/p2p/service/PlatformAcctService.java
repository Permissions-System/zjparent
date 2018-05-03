package com.zjgt.p2p.service;

import com.zjgt.p2p.model.PlatformAcct;
import java.math.BigDecimal;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PlatformAcctService
{
  public abstract PlatformAcct findByacctid(Long paramLong, String paramString, int paramInt)
    throws BusinessException;

  public abstract PlatformAcct findByacctidForPlat(Long paramLong)
    throws BusinessException;

  public abstract int save(PlatformAcct paramPlatformAcct)
    throws BusinessException;

  public abstract List<PlatformAcct> selectAll()
    throws BusinessException;

  public abstract void updateAccountHandle(Long paramLong, BigDecimal paramBigDecimal, String paramString)
    throws BusinessException;
}