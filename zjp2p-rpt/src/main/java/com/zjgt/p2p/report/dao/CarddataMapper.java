package com.zjgt.p2p.report.dao;

import com.zjgt.p2p.report.model.Carddata;
import com.zjgt.p2p.report.model.CarddataExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarddataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    int insert(Carddata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    int insertSelective(Carddata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    List<Carddata> selectByExample(CarddataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    Carddata selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Carddata record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carddata
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Carddata record);



	List<Carddata> getCardMinDataData(@Param("carddata")Carddata carddata);
	
	List<Carddata> getCardMaxDataData(@Param("carddata")Carddata carddata);
}