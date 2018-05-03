package com.zjgt.p2p.dao;

import com.zjgt.p2p.viewbean.InvestOrderApprove;
import com.zjgt.p2p.viewbean.InvestOrderApproveExample;
import java.util.List;

public abstract interface InvestOrderApproveMapper
{
  public abstract List<InvestOrderApprove> getInvestOrderApprove(InvestOrderApproveExample paramInvestOrderApproveExample);

  public abstract long getInvestOrderApproveCount(InvestOrderApproveExample paramInvestOrderApproveExample);

  public abstract InvestOrderApprove getInvestOrderApproveByInvestOrder(InvestOrderApproveExample paramInvestOrderApproveExample);
}