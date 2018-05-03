package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.Yieldsum;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface YieldCommission
{
  public abstract void generatorCommissionPlan(String paramString, Long paramLong)
    throws BusinessException;

  public abstract int updateCommissionPlan(List<Yieldplan> paramList, Yieldsum paramYieldsum);

  public abstract void updateCommissionPlan(Yieldsum paramYieldsum);

  public abstract void updateCommissionPlanByTiantianfu(Yieldplan paramYieldplan, Yieldsum paramYieldsum);

  public abstract int updateCommissionPlan(List<Yieldplan> paramList);

  public abstract int updateCommissionPlan(Yieldplan paramYieldplan);
}