package com.zjgt.p2p.service;

import com.zjgt.p2p.model.CpsCommissionrate;
import java.math.BigDecimal;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface CpsCommissionrateService
{
  public abstract void insertCommissionrate(CpsCommissionrate paramCpsCommissionrate)
    throws BusinessException;

  public abstract CpsCommissionrate findCommissionrate(Integer paramInteger, BigDecimal paramBigDecimal, String paramString)
    throws BusinessException;
}