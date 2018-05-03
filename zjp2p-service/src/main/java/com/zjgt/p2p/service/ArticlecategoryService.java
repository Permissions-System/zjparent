package com.zjgt.p2p.service;

import com.zjgt.p2p.article.model.Articlecategory;
import java.util.List;

public abstract interface ArticlecategoryService
{
  public abstract List<Articlecategory> getArticlecategoryByType(Long paramLong);

  public abstract Articlecategory findArticlecategoryById(Long paramLong);
}