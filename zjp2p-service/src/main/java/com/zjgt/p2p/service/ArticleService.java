package com.zjgt.p2p.service;

import com.zjgt.p2p.article.model.Article;
import com.zjgt.util.Page;
import java.util.Map;

public abstract interface ArticleService
{
  public abstract Page getArticleByPage(Map<String, Object> paramMap);

  public abstract int addArticle(Article paramArticle);

  public abstract Article getArticle(Long paramLong);

  public abstract int updateArticle(Article paramArticle);

  public abstract int deleteByPrimaryKey(Long paramLong);
}