package com.zjgt.thirdpay.service;

import com.zjgt.p2p.model.PaydealFlow;
import java.util.List;
import java.util.Map;

public abstract interface PayDealFlowService
{
  public abstract void add(PaydealFlow paramPaydealFlow);

  public abstract void update(PaydealFlow paramPaydealFlow);

  public abstract PaydealFlow get(String paramString);

  public abstract PaydealFlow getForUpdate(String paramString);

  public abstract List<Map<String, Object>> getTimeoutProcessTrans(String paramString);

  public abstract int closeTimeoutProcessTrans(List<String> paramList);

  public abstract List<Map<String, Object>> getProcessPayRequest(String paramString);
}