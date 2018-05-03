package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.model.MemberProdIncomeExample;
import java.math.BigDecimal;
import java.util.List;

public abstract interface MemberProdIncomeMapper
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MemberProdIncome paramMemberProdIncome);

  public abstract int insertSelective(MemberProdIncome paramMemberProdIncome);

  public abstract List<MemberProdIncome> selectByExample(MemberProdIncomeExample paramMemberProdIncomeExample);

  public abstract MemberProdIncome selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(MemberProdIncome paramMemberProdIncome);

  public abstract int updateByPrimaryKey(MemberProdIncome paramMemberProdIncome);

  public abstract BigDecimal getSumAmount(long paramLong);
}