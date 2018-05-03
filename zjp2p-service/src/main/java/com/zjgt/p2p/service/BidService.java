package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.BidExample;
import com.zjgt.p2p.model.BidQuery;
import com.zjgt.p2p.viewbean.BidApprove;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface BidService
{
  public abstract String bidInfo(Bid paramBid);

  public abstract List<Bid> getAll();

  public abstract String delete(Long paramLong);

  public abstract Bid findById(Long paramLong);

  public abstract int update(Bid paramBid);

  public abstract List<Bid> getProducts(BidExample paramBidExample);

  public abstract com.zjgt.util.Page<Bid> getProductsByPage(Map<String, String> paramMap);

  public abstract com.zjgt.util.Page<BidApprove> getBadBidByPage(Map<String, String> paramMap);

  public abstract int addBid(Bid paramBid);

  public abstract com.zjgt.util.Page<Bid> queryBidList(Map<String, String> paramMap);

  public abstract BidApprove getApproveByBid(Map<String, String> paramMap);

  public abstract int updatePublishtime(Integer paramInteger);

  public abstract int updateRaiseEndDate(Integer paramInteger);

  public abstract int updateestdate(Integer paramInteger, Date paramDate1, Date paramDate2);

  public abstract void updateRaiseEndDate(Date paramDate)
    throws BusinessException;

  public abstract void updateRaiseEndDate()
    throws BusinessException;

  public abstract void updateestdate()
    throws BusinessException;

  public abstract void updateestdate(Date paramDate)
    throws BusinessException;

  public abstract Bid findByBidcode(String paramString);

  public abstract List<Bid> getBidsByProjectcode(String paramString);

  public abstract List<Bid> getBidsByInstcode(String paramString);

  public abstract Bid selecttransbid(String paramString);

  public abstract int bidlose(String paramString1, String paramString2)
    throws BusinessException;

  public abstract String payself(String paramString)
    throws BusinessException;

  public abstract String payToBorrower(String paramString)
    throws BusinessException;

  public abstract BigDecimal selectBidRestAmount(long paramLong);

  public abstract void updateLastTimeBid()
    throws BusinessException;

  public abstract void updateLastTimeBid(Date paramDate)
    throws BusinessException;

  public abstract Bid selectBidForUpdate(long paramLong)
    throws BusinessException;

  public abstract List<Bid> selectBidByBidtype(Integer paramInteger);

  public abstract Bid selectByOrdercode(String paramString);

  public abstract int applyLoseBid(String paramString1, String paramString2, String paramString3, String paramString4)
    throws BusinessException;

  public abstract Bid getBidByDate();

  public abstract Bid getBidByDateAndNofull();

  public abstract org.springfk.pancloud.paginator.vo.Page<Bid> findPayListByPage(BidQuery paramBidQuery, int paramInt1, int paramInt2)
    throws BusinessException;
}