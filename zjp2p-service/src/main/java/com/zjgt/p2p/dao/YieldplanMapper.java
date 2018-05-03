package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.YieldplanExample;
import java.util.List;

public abstract interface YieldplanMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Yieldplan paramYieldplan);

  public abstract int insertSelective(Yieldplan paramYieldplan);

  public abstract List<Yieldplan> selectByExample(YieldplanExample paramYieldplanExample);

  public abstract Yieldplan selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Yieldplan paramYieldplan);

  public abstract int updateByPrimaryKey(Yieldplan paramYieldplan);

  public abstract Yieldplan findCommissionByParent(Long paramLong);
}