package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.CpsInvestinfoExample;
import java.util.List;

public abstract interface CpsInvestinfoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(CpsInvestinfo paramCpsInvestinfo);

  public abstract int insertSelective(CpsInvestinfo paramCpsInvestinfo);

  public abstract List<CpsInvestinfo> selectByExample(CpsInvestinfoExample paramCpsInvestinfoExample);

  public abstract CpsInvestinfo selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(CpsInvestinfo paramCpsInvestinfo);

  public abstract int updateByPrimaryKey(CpsInvestinfo paramCpsInvestinfo);
}