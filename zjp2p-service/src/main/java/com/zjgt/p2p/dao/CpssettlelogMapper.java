package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.model.CpssettlelogExample;
import java.util.List;

public abstract interface CpssettlelogMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Cpssettlelog paramCpssettlelog);

  public abstract int insertSelective(Cpssettlelog paramCpssettlelog);

  public abstract List<Cpssettlelog> selectByExample(CpssettlelogExample paramCpssettlelogExample);

  public abstract Cpssettlelog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Cpssettlelog paramCpssettlelog);

  public abstract int updateByPrimaryKey(Cpssettlelog paramCpssettlelog);

  public abstract List<Cpssettlelog> selectLastTTFlog();
}