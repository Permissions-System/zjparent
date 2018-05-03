package com.zjgt.p2p.report.dao;

import com.alibaba.model.easyui.PageHelper;
import com.zjgt.p2p.report.model.Cardresult;
import com.zjgt.p2p.report.model.CardresultExample;
import com.zjgt.p2p.report.model.OpTranslog;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CardresultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    int insert(Cardresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    int insertSelective(Cardresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    List<Cardresult> selectByExample(CardresultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    Cardresult selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Cardresult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cardresult
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Cardresult record);

    /**
     * 考勤数据总数
     * @param cardresult
     * @return
     */
	Long getDatagridTotal(@Param("cardresult")Cardresult cardresult);
	/**
	 * 获取考勤数据
	 * @param page
	 * @param cardresult
	 * @return
	 */
	List<Cardresult> getGridForCardCheckData(@Param("page")PageHelper page,@Param("cardresult")Cardresult cardresult);
}