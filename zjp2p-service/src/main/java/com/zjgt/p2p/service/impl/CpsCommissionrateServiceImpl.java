package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.dao.CpsCommissionrateMapper;
import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsCommissionrateExample;
import com.zjgt.p2p.model.CpsCommissionrateExample.Criteria;
import com.zjgt.p2p.service.CpsCommissionrateService;
import java.math.BigDecimal;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cpsCommissionrateService")
public class CpsCommissionrateServiceImpl
  implements CpsCommissionrateService
{

  @Autowired
  private CpsCommissionrateMapper dao;

  public void insertCommissionrate(CpsCommissionrate rate)
    throws BusinessException
  {
    this.dao.insert(rate);
  }

  public CpsCommissionrate findCommissionrate(Integer bidtype, BigDecimal amount, String channel)
    throws BusinessException
  {
    CpsCommissionrate commissionrate = new CpsCommissionrate();
    CpsCommissionrateExample example = new CpsCommissionrateExample();
    CpsCommissionrateExample.Criteria criteria = example.createCriteria();
    criteria.andBidtypeEqualTo(bidtype).andChannelEqualTo(channel);

    if (BidType.YUEXIBAO.getKey() == bidtype.intValue()) {
      if (amount.compareTo(new BigDecimal("50000")) >= 0) {
        criteria.andInvestamtfEqualTo(new BigDecimal("50000"));
      } else if (amount.compareTo(new BigDecimal("20000")) >= 0) {
        criteria.andInvestamtfEqualTo(new BigDecimal("20000"));
        criteria.andInvestamttEqualTo(new BigDecimal("50000"));
      } else {
        criteria.andInvestamttEqualTo(new BigDecimal("20000"));
      }

    }

    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      commissionrate = (CpsCommissionrate)list.get(0);
    }
    return commissionrate;
  }
}