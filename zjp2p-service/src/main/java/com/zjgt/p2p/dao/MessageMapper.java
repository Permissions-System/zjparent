package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Message;
import com.zjgt.p2p.model.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface MessageMapper
{
  public abstract int countByExample(MessageExample paramMessageExample);

  public abstract int deleteByExample(MessageExample paramMessageExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Message paramMessage);

  public abstract int insertSelective(Message paramMessage);

  public abstract List<Message> selectByExampleWithBLOBs(MessageExample paramMessageExample);

  public abstract List<Message> selectByExample(MessageExample paramMessageExample);

  public abstract Message selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") Message paramMessage, @Param("example") MessageExample paramMessageExample);

  public abstract int updateByExampleWithBLOBs(@Param("record") Message paramMessage, @Param("example") MessageExample paramMessageExample);

  public abstract int updateByExample(@Param("record") Message paramMessage, @Param("example") MessageExample paramMessageExample);

  public abstract int updateByPrimaryKeySelective(Message paramMessage);

  public abstract int updateByPrimaryKeyWithBLOBs(Message paramMessage);

  public abstract int updateByPrimaryKey(Message paramMessage);
}