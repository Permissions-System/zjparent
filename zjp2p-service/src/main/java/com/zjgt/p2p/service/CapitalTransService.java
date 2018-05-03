package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Capitaltrans;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface CapitalTransService
{
  public abstract Page<Capitaltrans> getCapitaltrans(Map<String, String> paramMap)
    throws BusinessException;

  public abstract Capitaltrans getCapitaltransByTransNo(String paramString)
    throws BusinessException;

  public abstract int getTimes(long paramLong)
    throws BusinessException;

  public abstract void add(Capitaltrans paramCapitaltrans)
    throws BusinessException;

  public abstract void updateStatusByTransNo(String paramString, int paramInt)
    throws BusinessException;

  public abstract int getTimesAsInvest(long paramLong);

  public abstract Capitaltrans selectTTFLastIncome(String paramString, Long paramLong);

  public abstract List<Capitaltrans> selectLastRecord(Long paramLong);

  public abstract BigDecimal sumTTFRollOutMoney(String paramString, Long paramLong, Date paramDate);

  public abstract Page<Map<String, Object>> selectRechargeBySettle(Map<String, Object> paramMap);

  public abstract int selectCountRechargeBySettle(Map<String, Object> paramMap);

  public abstract Page<Map<String, Object>> selectWithdrawBySettle(Map<String, Object> paramMap);

  public abstract int getRechargeSuccessCount(Long paramLong);
}