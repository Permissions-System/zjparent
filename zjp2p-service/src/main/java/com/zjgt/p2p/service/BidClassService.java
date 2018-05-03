package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Bidclass;

public abstract interface BidClassService
{
  public abstract Bidclass selectByPrimaryKey(Long paramLong);
}