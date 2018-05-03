package com.zjgt.p2p.service;

import java.util.List;

import com.zjgt.p2p.article.model.Articlecategory;

/**
 * @FileName:ArticlecategoryService.java
 * @Function:TODO
 * @date:2014年12月22日 上午11:15:30
 * @author zhouyi
 * @since jdk1.7
 */
public interface ArticlecategoryService {

	public List<Articlecategory> getArticlecategoryByType(Long parent);
	
	public Articlecategory findArticlecategoryById(Long id);
}
