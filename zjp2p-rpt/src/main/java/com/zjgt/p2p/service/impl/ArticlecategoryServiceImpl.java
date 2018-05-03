package com.zjgt.p2p.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjgt.p2p.article.dao.ArticlecategoryMapper;
import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.article.model.ArticlecategoryExample;
import com.zjgt.p2p.service.ArticlecategoryService;

/**
 * @FileName:ArticlecategoryServiceImpl.java
 * @Function:TODO
 * @date:2014年12月22日 上午11:17:20
 * @author zhouyi
 * @since jdk1.7
 */
@Service("ArticlecategoryService")
public class ArticlecategoryServiceImpl implements ArticlecategoryService {

	@Autowired
	private ArticlecategoryMapper articlecategoryMapper;
	
	@Override
	public List<Articlecategory> getArticlecategoryByType(Long parent) {
		ArticlecategoryExample exam = new ArticlecategoryExample();
		ArticlecategoryExample.Criteria crit = exam.createCriteria();
		crit.andParentEqualTo(parent);
		exam.setOrderByClause("orders");
		return articlecategoryMapper.selectByExample(exam);
	}

	@Override
	public Articlecategory findArticlecategoryById(Long id) {
		return articlecategoryMapper.selectByPrimaryKey(id);
	}

}
