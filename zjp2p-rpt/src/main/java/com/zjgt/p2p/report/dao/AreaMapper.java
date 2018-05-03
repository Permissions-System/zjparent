package com.zjgt.p2p.report.dao;

import com.zjgt.p2p.report.model.Area;
import com.zjgt.p2p.report.model.AreaExample;
import java.util.List;

public interface AreaMapper {
    /**
     * This method:deleteByPrimaryKey
     *   area
     *
     * @ET
     */
    int deleteByPrimaryKey(String areaid);

    /**
     * This method:insert
     *   area
     *
     * @ET
     */
    int insert(Area record);

    /**
     * This method:insertSelective
     *   area
     *
     * @ET
     */
    int insertSelective(Area record);

    /**
     * This method:selectByExample
     *   area
     *
     * @ET
     */
    List<Area> selectByExample(AreaExample example);

    /**
     * This method:selectByPrimaryKey
     *   area
     *
     * @ET
     */
    Area selectByPrimaryKey(String areaid);

    /**
     * This method:updateByPrimaryKeySelective
     *   area
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Area record);

    /**
     * This method:updateByPrimaryKey
     *   area
     *
     * @ET
     */
    int updateByPrimaryKey(Area record);
}