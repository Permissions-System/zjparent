package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.YieldsumMapper;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.model.YieldsumExample;
import com.zjgt.p2p.model.YieldsumExample.Criteria;
import com.zjgt.p2p.service.YieldsumService;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("yieldsumService")
public class YieldsumServiceImpl
  implements YieldsumService
{

  @Autowired
  private YieldsumMapper dao;

  public int addPlan(Yieldsum plan)
    throws BusinessException
  {
    return this.dao.insert(plan);
  }

  public int saveYieldsum(Yieldsum yieldsum)
  {
    int a = 0;
    if ((yieldsum != null) && (yieldsum.getId() != null))
      a = this.dao.updateByPrimaryKeySelective(yieldsum);
    else {
      a = this.dao.insertSelective(yieldsum);
    }
    return a;
  }

  public Yieldsum calcIncome(Double money, Double yearRate, Integer period, Integer repaymentWay)
  {
    double termamount = 0.0D;
    double restamount = 0.0D;
    double rate = 0.0D;

    return null;
  }

  public int updateSumAttime(String investOrderCode, int memberid)
    throws BusinessException
  {
    return 0;
  }

  public Yieldsum findByOrder(String ordercode, Integer memberid)
  {
    YieldsumExample example = new YieldsumExample();
    example.createCriteria().andInvestordercodeEqualTo(ordercode).andMemberidEqualTo(memberid);

    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Yieldsum)list.get(0));
    }
    return null;
  }

  public int update(Yieldsum sum)
  {
    return this.dao.updateByPrimaryKey(sum);
  }

  public Yieldsum findByOrdercode(String ordercode)
  {
    YieldsumExample example = new YieldsumExample();
    example.createCriteria().andInvestordercodeEqualTo(ordercode);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Yieldsum)list.get(0));
    }
    return null;
  }
}