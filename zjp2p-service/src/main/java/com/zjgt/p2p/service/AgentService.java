package com.zjgt.p2p.service;

import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.Translog;
import java.math.BigDecimal;
import java.util.Date;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface AgentService
{
  public abstract void updateMiddlemanLevel(Date paramDate)
    throws BusinessException;

  public abstract void updateMiddlemanLevel()
    throws BusinessException;

  public abstract int becomeMiddleman(Long paramLong);

  public abstract void updateMiddlemanAcct()
    throws BusinessException;

  public abstract Translog batchCommissionReturn(Long paramLong, BigDecimal paramBigDecimal, AcctTranDef paramAcctTranDef);

  public abstract boolean isMiddleman(Long paramLong);

  public abstract Agent selectByMemberid(Long paramLong);

  public abstract Agent selectByInvitee(Long paramLong);

  public abstract void merchantActivity(Long paramLong);

  public abstract void updateMerchantAcct()
    throws BusinessException;

  public abstract void updateMerchantAcct(Date paramDate)
    throws BusinessException;
}