package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAcctExample;
import java.util.List;

public abstract interface PlatformAcctMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(PlatformAcct paramPlatformAcct);

  public abstract int insertSelective(PlatformAcct paramPlatformAcct);

  public abstract List<PlatformAcct> selectByExample(PlatformAcctExample paramPlatformAcctExample);

  public abstract PlatformAcct selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(PlatformAcct paramPlatformAcct);

  public abstract int updateByPrimaryKey(PlatformAcct paramPlatformAcct);
}