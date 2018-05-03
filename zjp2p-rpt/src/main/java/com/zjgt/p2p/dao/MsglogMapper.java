package com.zjgt.p2p.dao;

import java.util.List;

import com.zjgt.p2p.report.model.Msglog;
import com.zjgt.p2p.report.model.MsglogExample;

public interface MsglogMapper {
    /**
     * This method:deleteByPrimaryKey
     *   msglog
     *
     * @ET
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method:insert
     *   msglog
     *
     * @ET
     */
    int insert(Msglog record);

    /**
     * This method:insertSelective
     *   msglog
     *
     * @ET
     */
    int insertSelective(Msglog record);

    /**
     * This method:selectByExampleWithBLOBs
     *   msglog
     *
     * @ET
     */
    List<Msglog> selectByExampleWithBLOBs(MsglogExample example);

    /**
     * This method:selectByExample
     *   msglog
     *
     * @ET
     */
    List<Msglog> selectByExample(MsglogExample example);

    /**
     * This method:selectByPrimaryKey
     *   msglog
     *
     * @ET
     */
    Msglog selectByPrimaryKey(Long id);

    /**
     * This method:updateByPrimaryKeySelective
     *   msglog
     *
     * @ET
     */
    int updateByPrimaryKeySelective(Msglog record);

    /**
     * This method:updateByPrimaryKeyWithBLOBs
     *   msglog
     *
     * @ET
     */
    int updateByPrimaryKeyWithBLOBs(Msglog record);

    /**
     * This method:updateByPrimaryKey
     *   msglog
     *
     * @ET
     */
    int updateByPrimaryKey(Msglog record);
}