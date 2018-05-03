package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsCommissionrateExample;
import java.util.List;

public abstract interface CpsCommissionrateMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(CpsCommissionrate paramCpsCommissionrate);

  public abstract int insertSelective(CpsCommissionrate paramCpsCommissionrate);

  public abstract List<CpsCommissionrate> selectByExample(CpsCommissionrateExample paramCpsCommissionrateExample);

  public abstract CpsCommissionrate selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(CpsCommissionrate paramCpsCommissionrate);

  public abstract int updateByPrimaryKey(CpsCommissionrate paramCpsCommissionrate);
}