package com.zjgt.p2p.service;

import com.zjgt.p2p.common.dict.AcctTranDef;
import java.math.BigDecimal;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface CapitalBatchTransation
{
  public abstract int initMemberAccount(int paramInt)
    throws BusinessException;

  public abstract int dealCapitalTrans(String paramString, int paramInt)
    throws BusinessException;

  public abstract int fillCapital(String paramString1, BigDecimal paramBigDecimal, String paramString2, int paramInt)
    throws BusinessException;

  public abstract int fillCapitalRespond(String paramString1, BigDecimal paramBigDecimal, String paramString2, Integer paramInteger)
    throws BusinessException;

  public abstract int withdrawal(String paramString1, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, String paramString2, int paramInt)
    throws BusinessException;

  public abstract int withdrawalRespond(String paramString1, String paramString2, Integer paramInteger1, Integer paramInteger2)
    throws BusinessException;

  public abstract int fillCapitalByPlatform(Long paramLong, BigDecimal paramBigDecimal, String paramString);

  public abstract int withdrawalByPlatform(Long paramLong, BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, String paramString)
    throws BusinessException;

  public abstract int platmemToPlatmem(String paramString1, String paramString2, BigDecimal paramBigDecimal, String paramString3, String paramString4);

  public abstract int platmemToPlatform(String paramString1, String paramString2, BigDecimal paramBigDecimal, String paramString3, String paramString4);

  @Deprecated
  public abstract int platformToPlatmem(String paramString1, String paramString2, BigDecimal paramBigDecimal, String paramString3, String paramString4);

  public abstract int platformToPlatmem(Long paramLong1, Long paramLong2, BigDecimal paramBigDecimal, String paramString1, String paramString2, AcctTranDef paramAcctTranDef);

  public abstract int platformToPlatform(String paramString1, String paramString2, BigDecimal paramBigDecimal, String paramString3, String paramString4);
}