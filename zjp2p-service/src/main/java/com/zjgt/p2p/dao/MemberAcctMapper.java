package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberAcctExample;
import java.util.List;
import java.util.Map;

public abstract interface MemberAcctMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MemberAcct paramMemberAcct);

  public abstract int insertSelective(MemberAcct paramMemberAcct);

  public abstract List<MemberAcct> selectByExample(MemberAcctExample paramMemberAcctExample);

  public abstract MemberAcct selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(MemberAcct paramMemberAcct);

  public abstract int updateByPrimaryKey(MemberAcct paramMemberAcct);

  public abstract MemberAcct selectByMemberIdForUpdate(Map<String, Object> paramMap);

  public abstract MemberAcct selectByMap(Map<String, Object> paramMap);

  public abstract MemberAcct selectByacctidForUpdate(Map<String, Object> paramMap);
}