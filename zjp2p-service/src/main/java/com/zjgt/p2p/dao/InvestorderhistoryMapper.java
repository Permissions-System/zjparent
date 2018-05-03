package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Investorderhistory;
import com.zjgt.p2p.model.InvestorderhistoryExample;
import java.util.List;

public abstract interface InvestorderhistoryMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(Investorderhistory paramInvestorderhistory);

  public abstract int insertSelective(Investorderhistory paramInvestorderhistory);

  public abstract List<Investorderhistory> selectByExample(InvestorderhistoryExample paramInvestorderhistoryExample);

  public abstract Investorderhistory selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(Investorderhistory paramInvestorderhistory);

  public abstract int updateByPrimaryKey(Investorderhistory paramInvestorderhistory);
}