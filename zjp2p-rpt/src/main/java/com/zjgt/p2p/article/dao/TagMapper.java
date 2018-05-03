package com.zjgt.p2p.article.dao;

import java.util.List;

import com.zjgt.p2p.article.model.Tag;
import com.zjgt.p2p.article.model.TagExample;

public interface TagMapper {
    /**
     * This method:deleteByPrimaryKey
     *   tag
     *
     * @ET
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method:insert
     *   tag
     *
     * @ET
     */
    int insert(Tag record);

    /**
     * This method:insertSelective
     *   tag
     *
     * @ET
     */
    int insertSelective(Tag record);

    /**
     * This method:selectByExample
     *   tag
     *
     * @ET
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method:selectByPrimaryKey
     *   tag
     *
     * @ET
     */
    Tag selectByPrimaryKey(Long id);

    /**
     * This method:updateByPrimaryKeySelective
     *   tag
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method:updateByPrimaryKey
     *   tag
     *
     * @ET
     */
    int updateByPrimaryKey(Tag record);
}