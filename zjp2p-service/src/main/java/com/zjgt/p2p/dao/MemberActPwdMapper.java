package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.MemberActPwd;
import com.zjgt.p2p.model.MemberActPwdExample;
import java.util.List;

public abstract interface MemberActPwdMapper
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract int insert(MemberActPwd paramMemberActPwd);

  public abstract int insertSelective(MemberActPwd paramMemberActPwd);

  public abstract List<MemberActPwd> selectByExample(MemberActPwdExample paramMemberActPwdExample);

  public abstract MemberActPwd selectByPrimaryKey(Integer paramInteger);

  public abstract int updateByPrimaryKeySelective(MemberActPwd paramMemberActPwd);

  public abstract int updateByPrimaryKey(MemberActPwd paramMemberActPwd);
}