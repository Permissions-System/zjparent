package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.BidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface BidMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Bid paramBid);

  public abstract int insertSelective(Bid paramBid);

  public abstract List<Bid> selectByExample(BidExample paramBidExample);

  public abstract Bid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Bid paramBid);

  public abstract int updateByPrimaryKey(Bid paramBid);

  public abstract Bid selectTransBidList(@Param("ordercode") String paramString);

  public abstract List<Bid> selectProductsByPage(@Param("startPos") Integer paramInteger1, @Param("pageSize") Integer paramInteger2);

  public abstract long getProductsCount(BidExample paramBidExample);

  public abstract List<Bid> selectByExampleLimit(BidExample paramBidExample);

  public abstract Bid selectByidForUpdate(Long paramLong);

  public abstract Bid selectBydateAndNofull();
}