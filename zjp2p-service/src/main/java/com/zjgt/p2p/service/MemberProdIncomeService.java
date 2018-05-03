package com.zjgt.p2p.service;

import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.viewbean.InvestdocView;
import java.math.BigDecimal;
import java.util.List;

public abstract interface MemberProdIncomeService
{
  public abstract List<InvestdocView> getMemberProdIncome(long paramLong);

  public abstract BigDecimal getAmount(long paramLong);

  public abstract void addProductIncome(MemberProdIncome paramMemberProdIncome);

  public abstract MemberProdIncome selectBytype(long paramLong, Integer paramInteger);
}