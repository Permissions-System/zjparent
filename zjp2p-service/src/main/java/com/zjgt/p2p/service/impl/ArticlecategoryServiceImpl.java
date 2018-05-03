package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.article.dao.ArticlecategoryMapper;
import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.article.model.ArticlecategoryExample;
import com.zjgt.p2p.article.model.ArticlecategoryExample.Criteria;
import com.zjgt.p2p.service.ArticlecategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ArticlecategoryService")
public class ArticlecategoryServiceImpl
  implements ArticlecategoryService
{

  @Autowired
  private ArticlecategoryMapper articlecategoryMapper;

  public List<Articlecategory> getArticlecategoryByType(Long parent)
  {
    ArticlecategoryExample exam = new ArticlecategoryExample();
    ArticlecategoryExample.Criteria crit = exam.createCriteria();
    crit.andParentEqualTo(parent);
    exam.setOrderByClause("orders");
    return this.articlecategoryMapper.selectByExample(exam);
  }

  public Articlecategory findArticlecategoryById(Long id)
  {
    return this.articlecategoryMapper.selectByPrimaryKey(id);
  }
}