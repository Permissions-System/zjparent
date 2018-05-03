package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.PaydealFlowMapper;
import com.zjgt.p2p.model.PaydealFlow;
import com.zjgt.thirdpay.service.PayDealFlowService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayDealFlowServiceImpl
  implements PayDealFlowService
{

  @Autowired
  private PaydealFlowMapper dao;

  public void add(PaydealFlow paydealFlow)
  {
    this.dao.insertSelective(paydealFlow);
  }

  public void update(PaydealFlow paydealFlow)
  {
    this.dao.updateByPrimaryKeySelective(paydealFlow);
  }

  public PaydealFlow get(String id)
  {
    return this.dao.selectByPrimaryKey(id);
  }

  public PaydealFlow getForUpdate(String id)
  {
    return this.dao.selectByPrimaryKeyForUpdate(id);
  }

  public List<Map<String, Object>> getTimeoutProcessTrans(String currTime)
  {
    return this.dao.getTimeoutProcessTrans(currTime);
  }

  public int closeTimeoutProcessTrans(List<String> ids)
  {
    return this.dao.closeTimeoutProcessTrans(ids);
  }

  public List<Map<String, Object>> getProcessPayRequest(String currTime)
  {
    return this.dao.getProcessPayRequest(currTime);
  }
}