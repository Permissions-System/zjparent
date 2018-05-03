package com.zjgt.p2p.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;
import com.zjgt.p2p.article.dao.ArticleMapper;
import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.ArticleExample;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.service.ArticleService;

/**
 * @FileName:ArticleServiceImpl.java
 * @Function:TODO
 * @date:2014年12月17日 下午2:30:17
 * @author zhouyi
 * @since jdk1.7
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private static final String PATTERN = "yyyy-MM-dd";
	
	@Autowired
	private ArticleMapper articleMapper;


	/**
	 * 条件分页查询
	 */
	@Override
	public Page<Article> getArticleByPage(Map<String, Object> map) {

		Page<Article> pages = null;

		List<Article> orders = null;
		ArticleExample exam = new ArticleExample();
		ArticleExample.Criteria crit = exam.createCriteria();
		Iterator i = map.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry entry = (Entry) i.next();
			String key = (String) entry.getKey();
			Object value =  map.get(key);
			if("categoryidList".equals(key)){
				if(StringUtil.isNotEmpty( value.toString())){
					crit.andCategoryidIn((List<Long>) value);
				}
			}
			if("title".equals(key)){
				if(StringUtil.isNotEmpty( (String) value)){
					crit.andTitleEqualTo((String) value);
				}
			}
			try {
				// 新闻发布时间(开始)
				if ("beginTime".equals(key)) {
					if (StringUtil.isNotEmpty((String) value)) {
						crit.andCreateDateGreaterThanOrEqualTo(new SimpleDateFormat(PATTERN)
								.parse((String) value));
						System.out.println("=============="+new SimpleDateFormat(PATTERN)
								.parse((String) value));
					}
				}
				// 新闻发布时间(结束)
				if ("endTime".equals(key)) {
					if (StringUtil.isNotEmpty((String) value)) {
						crit.andCreateDateLessThanOrEqualTo(new SimpleDateFormat(PATTERN)
								.parse((String) value));
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		exam.setOrderByClause("create_date DESC ");
		int totalCount = articleMapper.getNewsCount(exam);
		int pageNow = 0;
		if (map.get("pageNow") == null) {
			pageNow = 1;
		} else {
			pageNow = Integer.valueOf((String) map.get("pageNow"));
		}
		pages = new Page<Article>(totalCount, pageNow);

		pages.setPageSize(Const.NEWS_PAGE_SIZE);
		exam.setStartPos(pages.getStartPos());
		exam.setPageSize(Const.NEWS_PAGE_SIZE);

		orders = articleMapper.selectByExampleLimit(exam);
		pages.getPager(pageNow, pages.getTotalPageCount());
		pages.setResults(orders);
		return pages;

	}


	@Override
	public int addArticle(Article article) {
		return articleMapper.insertSelective(article);
	}


	//查询时增加新闻点击量
	@Override
	public Article getArticle(Long id) {
		Article article=articleMapper.selectByPrimaryKey(id);
		if(article!=null){
			if(article.getHits()==null){
				article.setHits(1l);
			}else{
				article.setHits(article.getHits()+1);
			}
		}
		return article;
	}


	@Override
	public int updateArticle(Article article) {
		return articleMapper.updateByPrimaryKeySelective(article);
	}


	@Override
	public int deleteByPrimaryKey(Long id) {
		return articleMapper.deleteByPrimaryKey(id);
	}
	
	

}
