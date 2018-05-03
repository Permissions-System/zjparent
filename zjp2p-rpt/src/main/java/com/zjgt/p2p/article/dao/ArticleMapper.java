package com.zjgt.p2p.article.dao;

import java.util.List;

import com.zjgt.p2p.article.model.Article;
import com.zjgt.p2p.article.model.ArticleExample;

public interface ArticleMapper {
    /**
     * This method:deleteByPrimaryKey
     *   article
     *
     * @ET
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method:insert
     *   article
     *
     * @ET
     */
    int insert(Article record);

    /**
     * This method:insertSelective
     *   article
     *
     * @ET
     */
    int insertSelective(Article record);

    /**
     * This method:selectByExampleWithBLOBs
     *   article
     *
     * @ET
     */
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * This method:selectByExample
     *   article
     *
     * @ET
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method:selectByPrimaryKey
     *   article
     *
     * @ET
     */
    Article selectByPrimaryKey(Long id);

    /**
     * This method:updateByPrimaryKeySelective
     *   article
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method:updateByPrimaryKeyWithBLOBs
     *   article
     *
     * @ET
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * This method:updateByPrimaryKey
     *   article
     *
     * @ET
     */
    int updateByPrimaryKey(Article record);
    
    List<Article> selectByExampleLimit(ArticleExample example);
	
	int getNewsCount(ArticleExample example);
}