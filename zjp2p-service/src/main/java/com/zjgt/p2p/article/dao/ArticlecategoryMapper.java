package com.zjgt.p2p.article.dao;

import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.article.model.ArticlecategoryExample;
import java.util.List;

public abstract interface ArticlecategoryMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Articlecategory paramArticlecategory);

  public abstract int insertSelective(Articlecategory paramArticlecategory);

  public abstract List<Articlecategory> selectByExample(ArticlecategoryExample paramArticlecategoryExample);

  public abstract Articlecategory selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Articlecategory paramArticlecategory);

  public abstract int updateByPrimaryKey(Articlecategory paramArticlecategory);
}