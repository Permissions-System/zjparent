package com.zjgt.p2p.dao;

import java.util.List;

import com.zjgt.p2p.report.model.MsgInfo;
import com.zjgt.p2p.report.model.MsgInfoExample;

public interface MsgInfoMapper {
    /**
     * This method:deleteByPrimaryKey
     *   msginfo
     *
     * @ET
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method:insert
     *   msginfo
     *
     * @ET
     */
    int insert(MsgInfo record);

    /**
     * This method:insertSelective
     *   msginfo
     *
     * @ET
     */
    int insertSelective(MsgInfo record);

    /**
     * This method:selectByExampleWithBLOBs
     *   msginfo
     *
     * @ET
     */
    List<MsgInfo> selectByExampleWithBLOBs(MsgInfoExample example);

    /**
     * This method:selectByExample
     *   msginfo
     *
     * @ET
     */
    List<MsgInfo> selectByExample(MsgInfoExample example);

    /**
     * This method:selectByPrimaryKey
     *   msginfo
     *
     * @ET
     */
    MsgInfo selectByPrimaryKey(Long id);

    /**
     * This method:updateByPrimaryKeySelective
     *   msginfo
     *
     * @ET
     */
    int updateByPrimaryKeySelective(MsgInfo record);

    /**
     * This method:updateByPrimaryKeyWithBLOBs
     *   msginfo
     *
     * @ET
     */
    int updateByPrimaryKeyWithBLOBs(MsgInfo record);

    /**
     * This method:updateByPrimaryKey
     *   msginfo
     *
     * @ET
     */
    int updateByPrimaryKey(MsgInfo record);
    
    /**
     * 注册后7天未绑卡开户
     * @param mo
     * @return
     */
    List<MsgInfo> registerSevenNoCardInfo(String mo);
    
    
    
    /**
     * 绑卡后3天未投资充值
     * @param mo
     * @return
     */
    List<MsgInfo> bingCardNoInvestInfo(String mo);

}