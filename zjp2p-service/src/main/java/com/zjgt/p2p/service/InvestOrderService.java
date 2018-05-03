package com.zjgt.p2p.service;

import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.viewbean.InvestOrderAndBid;
import com.zjgt.p2p.viewbean.InvestOrderApprove;
import com.zjgt.util.YieldInfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface InvestOrderService
{
  public abstract com.zjgt.util.Page<InvestOrder> getProductsByPage(Map<String, String> paramMap);

  public abstract int addOrder(InvestOrder paramInvestOrder);

  public abstract int getCount(InvestOrder paramInvestOrder);

  public abstract int updateOrder(InvestOrder paramInvestOrder);

  public abstract com.zjgt.util.Page<InvestOrderApprove> getInvestOrderApproveByPage(Map<String, String> paramMap);

  public abstract InvestOrder findById(Integer paramInteger);

  public abstract com.zjgt.util.Page<InvestOrderAndBid> getInvestOrderAndBid(Map<String, String> paramMap);

  public abstract com.zjgt.util.Page<InvestOrderAndBid> getInvestOrderByMember(Map<String, String> paramMap);

  public abstract InvestOrderApprove getApproveByInvestOrder(Map<String, String> paramMap);

  public abstract void updateApprostatus(int paramInt);

  public abstract List<InvestOrder> getOrderList(String paramString)
    throws BusinessException;

  public abstract List<InvestOrder> getOrderList(String paramString, int paramInt)
    throws BusinessException;

  public abstract String buyBidOper(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, YieldInfo paramYieldInfo, String paramString6, BigDecimal paramBigDecimal)
    throws BusinessException;

  public abstract InvestOrder getInvestOrderByOrderDate(long paramLong);

  public abstract Map<String, BigDecimal> redeemNum(String paramString);

  public abstract String redeemhandle(String paramString)
    throws Exception;

  public abstract InvestOrder findByOrdercode(String paramString);

  public abstract org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectInvertTrans(Map<String, Object> paramMap);

  public abstract String buyTransHandle(String paramString1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean)
    throws Exception;

  public abstract void doTransFail(String paramString)
    throws BusinessException;

  public abstract boolean isTransed(String paramString);

  public abstract String buyTianTianFu(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, YieldInfo paramYieldInfo, String paramString6)
    throws BusinessException;

  public abstract int betrans(String paramString)
    throws BusinessException;

  public abstract String unvalidInvestOrder(Integer paramInteger)
    throws BusinessException;

  public abstract void updateTTFByTime()
    throws BusinessException;

  public abstract void updateTTFByTime(Date paramDate)
    throws BusinessException;

  public abstract InvestOrder ttfSumOrder(Long paramLong);

  public abstract BigDecimal sumTTF(Long paramLong, List<String> paramList, Integer paramInteger);

  public abstract BigDecimal sumTTFIncome(Long paramLong, String paramString, Integer paramInteger);

  public abstract List<InvestOrder> selectTTFOrder(Long paramLong, List<String> paramList);

  public abstract org.springfk.pancloud.paginator.vo.Page<InvestOrder> selectInvestOrderByPage(Map<String, String> paramMap);

  public abstract org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectOrderBySettle(Map<String, Object> paramMap);

  public abstract org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectRepayBySettle(Map<String, Object> paramMap);

  public abstract boolean isFirstInvest(Long paramLong);
}