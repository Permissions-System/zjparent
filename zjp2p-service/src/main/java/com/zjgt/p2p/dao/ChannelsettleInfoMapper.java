package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.ChannelsettleInfo;
import com.zjgt.p2p.model.ChannelsettleInfoExample;
import java.util.List;

public abstract interface ChannelsettleInfoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(ChannelsettleInfo paramChannelsettleInfo);

  public abstract int insertSelective(ChannelsettleInfo paramChannelsettleInfo);

  public abstract List<ChannelsettleInfo> selectByExample(ChannelsettleInfoExample paramChannelsettleInfoExample);

  public abstract ChannelsettleInfo selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ChannelsettleInfo paramChannelsettleInfo);

  public abstract int updateByPrimaryKey(ChannelsettleInfo paramChannelsettleInfo);
}