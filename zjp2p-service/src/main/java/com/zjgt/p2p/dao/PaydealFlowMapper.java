package com.zjgt.p2p.dao;

import com.zjgt.p2p.model.PaydealFlow;
import com.zjgt.p2p.model.PaydealFlowExample;
import java.util.List;
import java.util.Map;

public abstract interface PaydealFlowMapper
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(PaydealFlow paramPaydealFlow);

  public abstract int insertSelective(PaydealFlow paramPaydealFlow);

  public abstract List<PaydealFlow> selectByExample(PaydealFlowExample paramPaydealFlowExample);

  public abstract PaydealFlow selectByPrimaryKey(String paramString);

  public abstract PaydealFlow selectByPrimaryKeyForUpdate(String paramString);

  public abstract int updateByPrimaryKeySelective(PaydealFlow paramPaydealFlow);

  public abstract int updateByPrimaryKey(PaydealFlow paramPaydealFlow);

  public abstract List<Map<String, Object>> getTimeoutProcessTrans(String paramString);

  public abstract int closeTimeoutProcessTrans(List<String> paramList);

  public abstract List<Map<String, Object>> getProcessPayRequest(String paramString);
}