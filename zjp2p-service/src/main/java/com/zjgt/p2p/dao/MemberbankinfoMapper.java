package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Memberbankinfo;
import com.zjgt.p2p.model.MemberbankinfoExample;
import java.util.List;

public abstract interface MemberbankinfoMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Memberbankinfo paramMemberbankinfo);

  public abstract int insertSelective(Memberbankinfo paramMemberbankinfo);

  public abstract List<Memberbankinfo> selectByExample(MemberbankinfoExample paramMemberbankinfoExample);

  public abstract Memberbankinfo selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Memberbankinfo paramMemberbankinfo);

  public abstract int updateByPrimaryKey(Memberbankinfo paramMemberbankinfo);
}