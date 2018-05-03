package com.zjgt.p2p.service;

import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.MemberAccount;
import java.math.BigDecimal;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface MemberAccountService
{
  public abstract void tranAccounting(Long paramLong, AcctTranDef paramAcctTranDef, BigDecimal paramBigDecimal, String paramString)
    throws BusinessException;

  public abstract void save(MemberAccount paramMemberAccount)
    throws BusinessException;

  public abstract MemberAccount getById(Long paramLong)
    throws BusinessException;

  public abstract MemberAccount getByMemberId(Long paramLong)
    throws BusinessException;

  public abstract MemberAccount getByMemberIdForUpdate(Long paramLong)
    throws BusinessException;

  public abstract void updateAccountHandle(Long paramLong, BigDecimal paramBigDecimal, String paramString, int paramInt)
    throws BusinessException;

  public abstract Map<String, Object> selectAccountSummaryByMemberId(Long paramLong);

  public abstract Map<String, Object> selectAccountSumByMemberId(Long paramLong);
}