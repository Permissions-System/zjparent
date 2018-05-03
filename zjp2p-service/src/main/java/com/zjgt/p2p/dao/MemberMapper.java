package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberExample;
import com.zjgt.p2p.model.MemberExcleExample;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface MemberMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(Member paramMember);

  public abstract int insertSelective(Member paramMember);

  public abstract List<Member> selectByExample(MemberExample paramMemberExample);

  public abstract Member selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Member paramMember);

  public abstract int updateByPrimaryKey(Member paramMember);

  public abstract List<Map<String, Object>> getReferralByPage(Map<String, Object> paramMap);

  public abstract Map<String, Object> getSumAccount(Long paramLong);

  public abstract Long getActiveNum(Long paramLong);

  public abstract List<Map<String, Object>> findMembersForExcle(MemberExcleExample paramMemberExcleExample)
    throws BusinessException;
}