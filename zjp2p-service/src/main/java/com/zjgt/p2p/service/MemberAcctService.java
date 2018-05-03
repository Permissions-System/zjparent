package com.zjgt.p2p.service;

import com.zjgt.p2p.model.MemberAcct;

public abstract interface MemberAcctService
{
  public abstract int save(MemberAcct paramMemberAcct);

  public abstract MemberAcct findByMemberId(Long paramLong);

  public abstract MemberAcct findByMemberIdForUpdate(Long paramLong);

  public abstract MemberAcct findByacctid(Long paramLong);

  public abstract MemberAcct findByacctidForUpdate(Long paramLong);

  public abstract MemberAcct findByMemberId(Long paramLong, Integer paramInteger);

  public abstract MemberAcct findByMemberIdForUpdate(Long paramLong, Integer paramInteger);
}