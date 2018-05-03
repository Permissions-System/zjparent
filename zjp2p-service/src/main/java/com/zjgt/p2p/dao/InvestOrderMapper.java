package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.InvestOrderExample;
import com.zjgt.p2p.viewbean.InvestOrderAndBid;
import com.zjgt.p2p.viewbean.InvestOrderAndBidExample;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public abstract interface InvestOrderMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(InvestOrder paramInvestOrder);

  public abstract int insertSelective(InvestOrder paramInvestOrder);

  public abstract List<InvestOrder> selectByExample(InvestOrderExample paramInvestOrderExample);

  public abstract InvestOrder selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(InvestOrder paramInvestOrder);

  public abstract int updateByPrimaryKey(InvestOrder paramInvestOrder);

  public abstract List<InvestOrder> selectByExampleLimit(InvestOrderExample paramInvestOrderExample);

  public abstract int getProductsCount(InvestOrderExample paramInvestOrderExample);

  public abstract int getInvestOrderCount(InvestOrderAndBidExample paramInvestOrderAndBidExample);

  public abstract List<InvestOrderAndBid> getInvestOrderPage(InvestOrderAndBidExample paramInvestOrderAndBidExample);

  public abstract List<Map<String, Object>> selectInvertTrans(Map<String, Object> paramMap);

  public abstract BigDecimal sumttf(InvestOrderExample paramInvestOrderExample);

  public abstract BigDecimal sumttfincome(InvestOrderExample paramInvestOrderExample);

  public abstract List<InvestOrder> selectTTFOrder(InvestOrderExample paramInvestOrderExample);

  public abstract List<InvestOrder> getInvestOrderByReferral(Long paramLong);

  public abstract List<Map<String, Object>> selectOrderBySettle(Map<String, Object> paramMap);

  public abstract List<Map<String, Object>> selectRepayBySettle(Map<String, Object> paramMap);
}