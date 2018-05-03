package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Translogplat;
import com.zjgt.p2p.model.TranslogplatExample;
import java.util.List;

public abstract interface TranslogplatMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Translogplat paramTranslogplat);

  public abstract int insertSelective(Translogplat paramTranslogplat);

  public abstract List<Translogplat> selectByExample(TranslogplatExample paramTranslogplatExample);

  public abstract Translogplat selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Translogplat paramTranslogplat);

  public abstract int updateByPrimaryKey(Translogplat paramTranslogplat);

  public abstract List<Translogplat> selectByExampleLimit(TranslogplatExample paramTranslogplatExample);

  public abstract int getTranslogplatCount(TranslogplatExample paramTranslogplatExample);
}