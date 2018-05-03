package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.MemberAcctAttri;
import com.zjgt.p2p.model.MemberAcctAttriExample;
import java.util.List;

public abstract interface MemberAcctAttriMapper
{
  public abstract int insert(MemberAcctAttri paramMemberAcctAttri);

  public abstract int insertSelective(MemberAcctAttri paramMemberAcctAttri);

  public abstract List<MemberAcctAttri> selectByExample(MemberAcctAttriExample paramMemberAcctAttriExample);
}