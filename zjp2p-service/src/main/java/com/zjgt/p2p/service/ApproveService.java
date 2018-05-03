package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.ApproveExample;
import java.util.List;

public abstract interface ApproveService
{
  public abstract Approve selectByPrimaryKey(Long paramLong);

  public abstract List<Approve> selectByExample(ApproveExample paramApproveExample);

  public abstract int addOrder(Approve paramApprove);
}