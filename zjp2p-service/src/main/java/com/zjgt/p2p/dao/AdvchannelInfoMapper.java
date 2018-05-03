package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.AdvchannelInfo;
import com.zjgt.p2p.model.AdvchannelInfoExample;
import java.util.List;

public abstract interface AdvchannelInfoMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(AdvchannelInfo paramAdvchannelInfo);

  public abstract int insertSelective(AdvchannelInfo paramAdvchannelInfo);

  public abstract List<AdvchannelInfo> selectByExample(AdvchannelInfoExample paramAdvchannelInfoExample);

  public abstract AdvchannelInfo selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(AdvchannelInfo paramAdvchannelInfo);

  public abstract int updateByPrimaryKey(AdvchannelInfo paramAdvchannelInfo);
}