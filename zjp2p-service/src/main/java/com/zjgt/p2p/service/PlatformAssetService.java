package com.zjgt.p2p.service;

import com.zjgt.p2p.model.PlatformAsset;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PlatformAssetService
{
  public abstract PlatformAsset findAsset()
    throws BusinessException;

  public abstract int save(PlatformAsset paramPlatformAsset)
    throws BusinessException;
}