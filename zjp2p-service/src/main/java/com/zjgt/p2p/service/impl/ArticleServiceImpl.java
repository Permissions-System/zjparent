package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.article.dao.ArticleMapper;
import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.ArticleExample;
import com.zjgt.p2p.article.model.ArticleExample.Criteria;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.service.ArticleService;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("articleService")
public class ArticleServiceImpl
  implements ArticleService
{
  private static final String PATTERN = "yyyy-MM-dd";

  @Autowired
  private ArticleMapper articleMapper;

  public Page<Article> getArticleByPage(Map<String, Object> map)
  {
    Page pages = null;

    List orders = null;
    ArticleExample exam = new ArticleExample();
    ArticleExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      Object value = map.get(key);
      if (("categoryidList".equals(key)) && 
        (StringUtil.isNotEmpty(value.toString()))) {
        crit.andCategoryidIn((List)value);
      }

      if (("title".equals(key)) && 
        (StringUtil.isNotEmpty((String)value))) {
        crit.andTitleEqualTo((String)value);
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty((String)value))) {
          crit.andCreateDateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse((String)value));

          System.out.println("==============" + new SimpleDateFormat("yyyy-MM-dd").parse((String)value));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty((String)value))) {
          crit.andCreateDateLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse((String)value));
        }
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }
    exam.setOrderByClause("create_date DESC ");
    int totalCount = this.articleMapper.getNewsCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page(totalCount, pageNow);

    pages.setPageSize(Const.NEWS_PAGE_SIZE);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Const.NEWS_PAGE_SIZE));

    orders = this.articleMapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(orders);
    return pages;
  }

  public int addArticle(Article article)
  {
    return this.articleMapper.insertSelective(article);
  }

  public Article getArticle(Long id)
  {
    Article article = this.articleMapper.selectByPrimaryKey(id);
    if (article != null) {
      if (article.getHits() == null)
        article.setHits(Long.valueOf(1L));
      else {
        article.setHits(Long.valueOf(article.getHits().longValue() + 1L));
      }
    }
    return article;
  }

  public int updateArticle(Article article)
  {
    return this.articleMapper.updateByPrimaryKeySelective(article);
  }

  public int deleteByPrimaryKey(Long id)
  {
    return this.articleMapper.deleteByPrimaryKey(id);
  }
}