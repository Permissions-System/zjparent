package com.zjgt.p2p.report.dao;

import com.zjgt.p2p.report.model.Province;
import com.zjgt.p2p.report.model.ProvinceExample;
import java.util.List;

public interface ProvinceMapper {
    /**
     * This method:deleteByPrimaryKey
     *   province
     *
     * @ET
     */
    int deleteByPrimaryKey(String proid);

    /**
     * This method:insert
     *   province
     *
     * @ET
     */
    int insert(Province record);

    /**
     * This method:insertSelective
     *   province
     *
     * @ET
     */
    int insertSelective(Province record);

    /**
     * This method:selectByExample
     *   province
     *
     * @ET
     */
    List<Province> selectByExample(ProvinceExample example);

    /**
     * This method:selectByPrimaryKey
     *   province
     *
     * @ET
     */
    Province selectByPrimaryKey(String proid);

    /**
     * This method:updateByPrimaryKeySelective
     *   province
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Province record);

    /**
     * This method:updateByPrimaryKey
     *   province
     *
     * @ET
     */
    int updateByPrimaryKey(Province record);
}