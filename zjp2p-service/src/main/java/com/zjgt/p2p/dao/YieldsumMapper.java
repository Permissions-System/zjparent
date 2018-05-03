package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.model.YieldsumExample;
import java.util.List;

public abstract interface YieldsumMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Yieldsum paramYieldsum);

  public abstract int insertSelective(Yieldsum paramYieldsum);

  public abstract List<Yieldsum> selectByExample(YieldsumExample paramYieldsumExample);

  public abstract Yieldsum selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Yieldsum paramYieldsum);

  public abstract int updateByPrimaryKey(Yieldsum paramYieldsum);

  public abstract Yieldsum findCommissionByParent(Long paramLong);
}