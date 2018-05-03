package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.CapitaltransExample;
import java.util.List;
import java.util.Map;

public abstract interface CapitaltransMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Capitaltrans paramCapitaltrans);

  public abstract int insertSelective(Capitaltrans paramCapitaltrans);

  public abstract List<Capitaltrans> selectByExample(CapitaltransExample paramCapitaltransExample);

  public abstract Capitaltrans selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Capitaltrans paramCapitaltrans);

  public abstract int updateByPrimaryKey(Capitaltrans paramCapitaltrans);

  public abstract int updateStatusByTransNo(Map<String, Object> paramMap);

  public abstract List<Capitaltrans> selectByExampleLimitBySettle(CapitaltransExample paramCapitaltransExample);

  public abstract long getCapitaltransCountBySettle(CapitaltransExample paramCapitaltransExample);

  public abstract int selectCountRechargeBySettle(Map<String, Object> paramMap);

  public abstract List<Map<String, Object>> selectRechargeBySettle(Map<String, Object> paramMap);

  public abstract List<Map<String, Object>> selectWithdrawBySettle(Map<String, Object> paramMap);

  public abstract int getRechargeSuccessCount(Long paramLong);
}