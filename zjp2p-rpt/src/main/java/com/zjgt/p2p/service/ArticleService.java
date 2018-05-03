package com.zjgt.p2p.service;

import java.util.Map;

import com.zjgt.util.Page;
import com.zjgt.p2p.article.model.Article;

/**
 * @FileName:ArticleService.java
 * @Function:TODO
 * @date:2014年12月17日 下午2:28:52
 * @author zhouyi
 * @since jdk1.7
 */
public interface ArticleService {

	public Page<Article> getArticleByPage(Map<String, Object> map);
	
	public int addArticle(Article article);
	
	public Article getArticle(Long id);
	
	public int updateArticle(Article article);
	
	public int deleteByPrimaryKey(Long id);
}
