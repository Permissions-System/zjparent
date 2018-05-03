package com.zjgt.p2p.article.dao;

import com.zjgt.p2p.article.model.ArticletagExample;
import com.zjgt.p2p.article.model.ArticletagKey;
import java.util.List;

public abstract interface ArticletagMapper
{
  public abstract int deleteByPrimaryKey(ArticletagKey paramArticletagKey);

  public abstract int insert(ArticletagKey paramArticletagKey);

  public abstract int insertSelective(ArticletagKey paramArticletagKey);

  public abstract List<ArticletagKey> selectByExample(ArticletagExample paramArticletagExample);
}