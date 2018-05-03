package com.zjgt.p2p.article.dao;

import java.util.List;

import com.zjgt.p2p.article.model.ArticletagExample;
import com.zjgt.p2p.article.model.ArticletagKey;

public interface ArticletagMapper {
    /**
     * This method:deleteByPrimaryKey
     *   articletag
     *
     * @ET
     */
    int deleteByPrimaryKey(ArticletagKey key);

    /**
     * This method:insert
     *   articletag
     *
     * @ET
     */
    int insert(ArticletagKey record);

    /**
     * This method:insertSelective
     *   articletag
     *
     * @ET
     */
    int insertSelective(ArticletagKey record);

    /**
     * This method:selectByExample
     *   articletag
     *
     * @ET
     */
    List<ArticletagKey> selectByExample(ArticletagExample example);
}