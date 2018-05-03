package com.zjgt.p2p.report.dao;

import com.zjgt.p2p.report.model.City;
import com.zjgt.p2p.report.model.CityExample;
import java.util.List;

public interface CityMapper {
    /**
     * This method:deleteByPrimaryKey
     *   city
     *
     * @ET
     */
    int deleteByPrimaryKey(String cityid);

    /**
     * This method:insert
     *   city
     *
     * @ET
     */
    int insert(City record);

    /**
     * This method:insertSelective
     *   city
     *
     * @ET
     */
    int insertSelective(City record);

    /**
     * This method:selectByExample
     *   city
     *
     * @ET
     */
    List<City> selectByExample(CityExample example);

    /**
     * This method:selectByPrimaryKey
     *   city
     *
     * @ET
     */
    City selectByPrimaryKey(String cityid);

    /**
     * This method:updateByPrimaryKeySelective
     *   city
     *
     * @ET
     */
    int updateByPrimaryKeySelective(City record);

    /**
     * This method:updateByPrimaryKey
     *   city
     *
     * @ET
     */
    int updateByPrimaryKey(City record);
}