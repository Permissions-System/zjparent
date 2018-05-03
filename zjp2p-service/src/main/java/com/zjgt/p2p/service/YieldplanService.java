package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Yieldplan;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface YieldplanService
{
  public abstract int addPlan(Yieldplan paramYieldplan);

  public abstract int savePlan(Yieldplan paramYieldplan);

  public abstract Page<Yieldplan> selectPlanbyPage(int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws BusinessException;

  public abstract Yieldplan findPlan(Date paramDate, String paramString, Integer paramInteger);

  public abstract List<Yieldplan> findPlans(Date paramDate, String paramString, Integer paramInteger);

  public abstract int update(Yieldplan paramYieldplan);

  public abstract BigDecimal getIncomeThisMonth(Long paramLong);

  public abstract List<Yieldplan> findByOrderCode(String paramString);
}