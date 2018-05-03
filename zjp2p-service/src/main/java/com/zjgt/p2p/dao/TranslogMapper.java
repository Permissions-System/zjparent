package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.TranslogExample;
import java.util.List;
import java.util.Map;

public abstract interface TranslogMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Translog paramTranslog);

  public abstract int insertSelective(Translog paramTranslog);

  public abstract List<Translog> selectByExample(TranslogExample paramTranslogExample);

  public abstract List<Translog> selectByTransNo(Map<String, Object> paramMap);

  public abstract Translog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Translog paramTranslog);

  public abstract int updateByPrimaryKey(Translog paramTranslog);

  public abstract int updateStatusByTransNo(Map<String, Object> paramMap);

  public abstract int updateWithdrawFailDesc(Map<String, String> paramMap);

  public abstract List<Translog> getCapitalTransByPage(TranslogExample paramTranslogExample);

  public abstract List<Translog> selectByExampleLimit(TranslogExample paramTranslogExample);

  public abstract int getTranslogCount(TranslogExample paramTranslogExample);
}