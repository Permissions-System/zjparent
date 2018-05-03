package com.zjgt.p2p.report.dao;

import com.alibaba.model.easyui.PageHelper;
import com.zjgt.p2p.report.model.Sms_lcinfos;
import com.zjgt.p2p.report.model.Sms_lcinfosExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Sms_lcinfosMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int insert(Sms_lcinfos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int insertSelective(Sms_lcinfos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    List<Sms_lcinfos> selectByExampleWithBLOBs(Sms_lcinfosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    List<Sms_lcinfos> selectByExample(Sms_lcinfosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    Sms_lcinfos selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Sms_lcinfos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Sms_lcinfos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sms_lcinfos
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Sms_lcinfos record);
    

    Long getDatagridTotal(@Param("lc")Sms_lcinfos lc);

  	List<Sms_lcinfos> getlcinfosData(@Param("page")PageHelper page,@Param("lc")Sms_lcinfos lc);
}