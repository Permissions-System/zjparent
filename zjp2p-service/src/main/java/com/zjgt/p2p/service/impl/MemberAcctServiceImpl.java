package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.dao.MemberAcctMapper;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberAcctExample;
import com.zjgt.p2p.model.MemberAcctExample.Criteria;
import com.zjgt.p2p.service.MemberAcctService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberAcctService")
public class MemberAcctServiceImpl
  implements MemberAcctService
{

  @Autowired
  private MemberAcctMapper dao;

  public int save(MemberAcct acct)
    throws BusinessException
  {
    int result = 0;

    if (this.dao.selectByPrimaryKey(acct.getMemberAcctid()) == null)
      result = this.dao.insert(acct);
    else {
      result = this.dao.updateByPrimaryKeySelective(acct);
    }
    return result;
  }

  public MemberAcct findByMemberId(Long id)
  {
    MemberAcctExample example = new MemberAcctExample();
    example.createCriteria().andMemberidEqualTo(id).andAcctTypeEqualTo(Integer.valueOf(AcctType.BASIC.getKey()));

    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((MemberAcct)list.get(0));
    }
    return null;
  }

  public MemberAcct findByacctid(Long id)
  {
    MemberAcctExample example = new MemberAcctExample();
    example.createCriteria().andMemberAcctidEqualTo(id);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((MemberAcct)list.get(0));
    }
    return null;
  }

  public MemberAcct findByMemberIdForUpdate(Long memberId)
  {
    Map paramMap = new HashMap();
    paramMap.put("memberId", memberId);
    paramMap.put("acctType", Integer.valueOf(AcctType.BASIC.getKey()));
    return this.dao.selectByMemberIdForUpdate(paramMap);
  }

  public MemberAcct findByacctidForUpdate(Long memberAcctId)
  {
    Map paramMap = new HashMap();
    paramMap.put("memberAcctid", memberAcctId);
    return this.dao.selectByacctidForUpdate(paramMap);
  }

  public MemberAcct findByMemberId(Long id, Integer acctType)
  {
    MemberAcctExample example = new MemberAcctExample();
    example.createCriteria().andMemberidEqualTo(id).andAcctTypeEqualTo(acctType);

    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((MemberAcct)list.get(0));
    }
    return null;
  }

  public MemberAcct findByMemberIdForUpdate(Long id, Integer acctType)
  {
    Map paramMap = new HashMap();
    paramMap.put("memberId", id);
    paramMap.put("acctType", acctType);
    return this.dao.selectByMemberIdForUpdate(paramMap);
  }
}