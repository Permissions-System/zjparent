package com.zjgt.p2p.article.dao;

import com.zjgt.p2p.article.model.Tag;
import com.zjgt.p2p.article.model.TagExample;
import java.util.List;

public abstract interface TagMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Tag paramTag);

  public abstract int insertSelective(Tag paramTag);

  public abstract List<Tag> selectByExample(TagExample paramTagExample);

  public abstract Tag selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Tag paramTag);

  public abstract int updateByPrimaryKey(Tag paramTag);
}