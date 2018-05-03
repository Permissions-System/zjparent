package com.zjgt.thirdpay.service;

import com.zjgt.thirdpay.domain.BatchRapidPayToBankcardResponse;
import com.zjgt.thirdpay.domain.SinaPayRequest;
import com.zjgt.thirdpay.domain.SinaPayResponse;
import java.math.BigDecimal;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PayService
{
  public abstract boolean fill(SinaPayRequest paramSinaPayRequest, Integer paramInteger)
    throws BusinessException;

  public abstract boolean fillRespond(SinaPayResponse paramSinaPayResponse)
    throws BusinessException;

  public abstract String withdraw(Long paramLong, boolean paramBoolean, BigDecimal paramBigDecimal, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    throws BusinessException;

  public abstract boolean withdrawRespond(BatchRapidPayToBankcardResponse paramBatchRapidPayToBankcardResponse)
    throws BusinessException;

  public abstract boolean closeTimeoutTrans(String paramString);
}