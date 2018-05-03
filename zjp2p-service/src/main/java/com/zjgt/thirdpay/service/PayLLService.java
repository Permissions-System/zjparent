package com.zjgt.thirdpay.service;

import com.zjgt.thirdpay.lianlian.vo.CashNotifyRetBean;
import com.zjgt.thirdpay.lianlian.vo.PaymentInfo;
import com.zjgt.thirdpay.lianlian.vo.PaymentNotifyRetBean;
import java.math.BigDecimal;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PayLLService
{
  public abstract boolean fill(PaymentInfo paramPaymentInfo, Float paramFloat)
    throws BusinessException;

  public abstract boolean fillRespond(PaymentNotifyRetBean paramPaymentNotifyRetBean, String paramString)
    throws BusinessException;

  public abstract String withdraw(Long paramLong, boolean paramBoolean, BigDecimal paramBigDecimal, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    throws BusinessException;

  public abstract boolean withdrawRespond(CashNotifyRetBean paramCashNotifyRetBean, String paramString)
    throws BusinessException;

  public abstract Map<String, String> getAuthPayBank();

  public abstract String getBankCodeByName(String paramString);

  public abstract boolean scheduledProcessPayResponse(String paramString);
}