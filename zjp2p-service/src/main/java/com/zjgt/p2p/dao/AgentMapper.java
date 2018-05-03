package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.AgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface AgentMapper
{
  public abstract int countByExample(AgentExample paramAgentExample);

  public abstract int deleteByExample(AgentExample paramAgentExample);

  public abstract int insert(Agent paramAgent);

  public abstract int insertSelective(Agent paramAgent);

  public abstract List<Agent> selectByExample(AgentExample paramAgentExample);

  public abstract int updateByExampleSelective(@Param("record") Agent paramAgent, @Param("example") AgentExample paramAgentExample);

  public abstract int updateByExample(@Param("record") Agent paramAgent, @Param("example") AgentExample paramAgentExample);

  public abstract int updateByPrimaryKeySelective(Agent paramAgent);

  public abstract int updateByPrimaryKey(Agent paramAgent);

  public abstract Agent selectByMemberid(Long paramLong);

  public abstract Agent selectByInvitee(Long paramLong);
}