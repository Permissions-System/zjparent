package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Bidclass;
import com.zjgt.p2p.model.BidclassExample;
import java.util.List;

public abstract interface BidclassMapper
{
  public abstract int countByExample(BidclassExample paramBidclassExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Bidclass paramBidclass);

  public abstract int insertSelective(Bidclass paramBidclass);

  public abstract List<Bidclass> selectByExample(BidclassExample paramBidclassExample);

  public abstract Bidclass selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Bidclass paramBidclass);

  public abstract int updateByPrimaryKey(Bidclass paramBidclass);
}