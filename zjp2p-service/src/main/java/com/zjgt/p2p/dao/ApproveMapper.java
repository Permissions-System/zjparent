package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.ApproveExample;
import java.util.List;

public abstract interface ApproveMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Approve paramApprove);

  public abstract int insertSelective(Approve paramApprove);

  public abstract List<Approve> selectByExample(ApproveExample paramApproveExample);

  public abstract Approve selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Approve paramApprove);

  public abstract int updateByPrimaryKey(Approve paramApprove);
}