package com.zjgt.p2p.report.dao;

import com.alibaba.model.easyui.PageHelper;
import com.zjgt.p2p.report.model.OpTranslog;
import com.zjgt.p2p.report.model.Translog;
import com.zjgt.p2p.report.model.TranslogExample;
import com.zjgt.p2p.report.model.TranslogTemp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TranslogMapper {
    /**
     * This method:deleteByPrimaryKey
     *   translog
     *
     * @ET
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method:insert
     *   translog
     *
     * @ET
     */
    int insert(Translog record);

    /**
     * This method:insertSelective
     *   translog
     *
     * @ET
     */
    int insertSelective(Translog record);

    /**
     * This method:selectByExample
     *   translog
     *
     * @ET
     */
    List<Translog> selectByExample(TranslogExample example);

    /**
     * This method:selectByPrimaryKey
     *   translog
     *
     * @ET
     */
    Translog selectByPrimaryKey(Integer id);

    /**
     * This method:updateByPrimaryKeySelective
     *   translog
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Translog record);

    /**
     * This method:updateByPrimaryKey
     *   translog
     *
     * @ET
     */
    int updateByPrimaryKey(Translog record);
    
    /**
     * This method:czTxDataCheck
     *  translog
     *
     * @ET
     */
    List<Translog> czTxDataCheck(@Param("translog")Translog translog);
    /**
	 * Translog列表总数
	 * @param user
	 * @return
	 */
	public Long getTranslogTotal(@Param("translog")Translog translog);
    /**
     * 查询核对结果
     * translog
     *
     * @ET
     */
    List<Translog> queryCheckResult(@Param("page")PageHelper page,@Param("translog")Translog translog);
    
    
    
	/**
	 * 获取业务数据的总和
	 * @param translog
	 * @return
	 */
	public Long getSumForYw(@Param("translog")Translog translog);
	
	
	public List<Translog> queryByUserName(@Param("username")String username);
	
	/**
	 * 分组查询核算数据
	 * @param op
	 * @return
	 */
	public List<Translog> queryByGroup(@Param("ts")Translog ts);
	
	/**
	 * 分组回写核算状态
	 * @param ts
	 * @return
	 */
	int updateByGroup(@Param("ts")Translog ts);
}