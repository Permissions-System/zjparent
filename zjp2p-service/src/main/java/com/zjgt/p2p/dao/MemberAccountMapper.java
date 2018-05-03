package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAccountExample;
import java.util.List;
import java.util.Map;

public abstract interface MemberAccountMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MemberAccount paramMemberAccount);

  public abstract int insertSelective(MemberAccount paramMemberAccount);

  public abstract List<MemberAccount> selectByExample(MemberAccountExample paramMemberAccountExample);

  public abstract MemberAccount selectByMemberIdForUpdate(Long paramLong);

  public abstract MemberAccount selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(MemberAccount paramMemberAccount);

  public abstract int updateByPrimaryKey(MemberAccount paramMemberAccount);

  public abstract Map<String, Object> selectAccountSummary(Map<String, Object> paramMap);

  public abstract Map<String, Object> selectAccountSum(Map<String, Object> paramMap);
}