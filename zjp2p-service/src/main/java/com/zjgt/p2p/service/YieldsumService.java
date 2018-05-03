package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Yieldsum;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface YieldsumService
{
  public abstract int addPlan(Yieldsum paramYieldsum);

  public abstract int saveYieldsum(Yieldsum paramYieldsum);

  public abstract Yieldsum calcIncome(Double paramDouble1, Double paramDouble2, Integer paramInteger1, Integer paramInteger2);

  public abstract int updateSumAttime(String paramString, int paramInt)
    throws BusinessException;

  public abstract Yieldsum findByOrder(String paramString, Integer paramInteger);

  public abstract int update(Yieldsum paramYieldsum);

  public abstract Yieldsum findByOrdercode(String paramString);
}