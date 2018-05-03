package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.model.MembersafetyExample;
import java.util.List;

public abstract interface MembersafetyMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Membersafety paramMembersafety);

  public abstract int insertSelective(Membersafety paramMembersafety);

  public abstract List<Membersafety> selectByExample(MembersafetyExample paramMembersafetyExample);

  public abstract Membersafety selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Membersafety paramMembersafety);

  public abstract int updateByPrimaryKey(Membersafety paramMembersafety);
}