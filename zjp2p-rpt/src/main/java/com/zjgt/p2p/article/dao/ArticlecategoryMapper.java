package com.zjgt.p2p.article.dao;

import java.util.List;

import com.zjgt.p2p.article.model.Articlecategory;
import com.zjgt.p2p.article.model.ArticlecategoryExample;

public interface ArticlecategoryMapper {
    /**
     * This method:deleteByPrimaryKey
     *   articlecategory
     *
     * @ET
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method:insert
     *   articlecategory
     *
     * @ET
     */
    int insert(Articlecategory record);

    /**
     * This method:insertSelective
     *   articlecategory
     *
     * @ET
     */
    int insertSelective(Articlecategory record);

    /**
     * This method:selectByExample
     *   articlecategory
     *
     * @ET
     */
    List<Articlecategory> selectByExample(ArticlecategoryExample example);

    /**
     * This method:selectByPrimaryKey
     *   articlecategory
     *
     * @ET
     */
    Articlecategory selectByPrimaryKey(Long id);

    /**
     * This method:updateByPrimaryKeySelective
     *   articlecategory
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Articlecategory record);

    /**
     * This method:updateByPrimaryKey
     *   articlecategory
     *
     * @ET
     */
    int updateByPrimaryKey(Articlecategory record);
}