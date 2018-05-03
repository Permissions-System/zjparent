package com.zjgt.p2p.article.dao;

import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.ArticleExample;
import java.util.List;

public abstract interface ArticleMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Article paramArticle);

  public abstract int insertSelective(Article paramArticle);

  public abstract List<Article> selectByExampleWithBLOBs(ArticleExample paramArticleExample);

  public abstract List<Article> selectByExample(ArticleExample paramArticleExample);

  public abstract Article selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Article paramArticle);

  public abstract int updateByPrimaryKeyWithBLOBs(Article paramArticle);

  public abstract int updateByPrimaryKey(Article paramArticle);

  public abstract List<Article> selectByExampleLimit(ArticleExample paramArticleExample);

  public abstract int getNewsCount(ArticleExample paramArticleExample);
}