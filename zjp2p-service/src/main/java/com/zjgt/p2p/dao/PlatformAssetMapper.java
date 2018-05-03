package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.PlatformAssetExample;
import java.util.List;

public abstract interface PlatformAssetMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(PlatformAsset paramPlatformAsset);

  public abstract int insertSelective(PlatformAsset paramPlatformAsset);

  public abstract List<PlatformAsset> selectByExample(PlatformAssetExample paramPlatformAssetExample);

  public abstract PlatformAsset selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(PlatformAsset paramPlatformAsset);

  public abstract int updateByPrimaryKey(PlatformAsset paramPlatformAsset);
}