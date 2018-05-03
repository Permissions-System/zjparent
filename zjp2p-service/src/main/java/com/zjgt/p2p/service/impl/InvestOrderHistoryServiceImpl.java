package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.InvestorderhistoryMapper;
import com.zjgt.p2p.model.Investorderhistory;
import com.zjgt.p2p.service.InvestOrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("investOrderHistoryService")
public class InvestOrderHistoryServiceImpl
  implements InvestOrderHistoryService
{

  @Autowired
  private InvestorderhistoryMapper mapper;

  @Transactional
  public int addOrder(Investorderhistory order)
  {
    return this.mapper.insertSelective(order);
  }
}