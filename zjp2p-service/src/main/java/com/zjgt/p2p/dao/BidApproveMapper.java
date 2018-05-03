package com.zjgt.p2p.dao;

import com.zjgt.p2p.viewbean.BidApprove;
import com.zjgt.p2p.viewbean.BidApproveExample;
import java.util.List;

public abstract interface BidApproveMapper
{
  public abstract List<BidApprove> getBidApprove(BidApproveExample paramBidApproveExample);

  public abstract long getBidApproveCount(BidApproveExample paramBidApproveExample);

  public abstract BidApprove getApproveByBid(BidApproveExample paramBidApproveExample);
}