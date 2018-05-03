package com.zjgt.thirdpay.service;

import com.zjgt.thirdpay.domain.ThirdpayBaseRequest;
import com.zjgt.thirdpay.v2.domain.BatchPay2bankResponse;
import com.zjgt.thirdpay.v2.domain.InstantOrderResponse;
import java.math.BigDecimal;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PayV2Service
{
  public abstract boolean fill(ThirdpayBaseRequest paramThirdpayBaseRequest, Float paramFloat)
    throws BusinessException;

  public abstract boolean fillRespond(InstantOrderResponse paramInstantOrderResponse)
    throws BusinessException;

  public abstract String withdraw(Long paramLong, boolean paramBoolean, BigDecimal paramBigDecimal, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws BusinessException;

  public abstract boolean withdrawRespond(BatchPay2bankResponse paramBatchPay2bankResponse)
    throws BusinessException;

  public abstract boolean closeTimeoutTrans(String paramString);
}