package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Transdef;
import com.zjgt.p2p.model.TransdefExample;
import java.util.List;

public abstract interface TransdefMapper
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Transdef paramTransdef);

  public abstract int insertSelective(Transdef paramTransdef);

  public abstract List<Transdef> selectByExample(TransdefExample paramTransdefExample);

  public abstract Transdef selectByPrimaryKey(String paramString);

  public abstract int updateByPrimaryKeySelective(Transdef paramTransdef);

  public abstract int updateByPrimaryKey(Transdef paramTransdef);
}