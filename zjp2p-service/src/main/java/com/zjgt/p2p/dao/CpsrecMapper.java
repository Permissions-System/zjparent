package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Cpsrec;
import com.zjgt.p2p.model.CpsrecExample;
import java.util.List;

public abstract interface CpsrecMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Cpsrec paramCpsrec);

  public abstract int insertSelective(Cpsrec paramCpsrec);

  public abstract List<Cpsrec> selectByExample(CpsrecExample paramCpsrecExample);

  public abstract Cpsrec selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Cpsrec paramCpsrec);

  public abstract int updateByPrimaryKey(Cpsrec paramCpsrec);
}