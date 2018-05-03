package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.CpsLog;
import com.zjgt.p2p.model.CpsLogExample;
import java.util.List;

public abstract interface CpsLogMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(CpsLog paramCpsLog);

  public abstract int insertSelective(CpsLog paramCpsLog);

  public abstract List<CpsLog> selectByExample(CpsLogExample paramCpsLogExample);

  public abstract CpsLog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(CpsLog paramCpsLog);

  public abstract int updateByPrimaryKey(CpsLog paramCpsLog);
}