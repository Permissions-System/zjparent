package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.YieldplanMapper;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.YieldplanExample;
import com.zjgt.p2p.model.YieldplanExample.Criteria;
import com.zjgt.p2p.service.YieldplanService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("yieldplanService")
public class YieldplanServiceImpl
  implements YieldplanService
{

  @Autowired
  private YieldplanMapper dao;

  public int addPlan(Yieldplan plan)
    throws BusinessException
  {
    return this.dao.insert(plan);
  }

  public int savePlan(Yieldplan plan)
  {
    int a = 0;
    if ((plan != null) && (plan.getId() != null))
      a = this.dao.updateByPrimaryKeySelective(plan);
    else {
      a = this.dao.insertSelective(plan);
    }
    return a;
  }

  public Page<Yieldplan> selectPlanbyPage(int pageNo, int pageSize, int memberid, String investordercode)
    throws BusinessException
  {
    YieldplanExample example = new YieldplanExample();
    YieldplanExample.Criteria criteria = example.createCriteria();
    criteria.andMemberidEqualTo(Integer.valueOf(memberid));
    criteria.andInvestordercodeEqualTo(investordercode);
    example.setOrderByClause("termdate desc");
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    example.setPage(page);
    page.setResult(this.dao.selectByExample(example));
    return page;
  }

  public Yieldplan findPlan(Date date, String ordercode, Integer memberid)
  {
    YieldplanExample example = new YieldplanExample();
    example.createCriteria().andInvestordercodeEqualTo(ordercode).andMemberidEqualTo(memberid).andTermdateLessThanOrEqualTo(date);

    example.setOrderByClause("termnum desc");
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Yieldplan)list.get(0));
    }
    return null;
  }

  public List<Yieldplan> findPlans(Date date, String ordercode, Integer memberid)
  {
    YieldplanExample example = new YieldplanExample();
    YieldplanExample.Criteria criteria = example.createCriteria();
    criteria.andInvestordercodeEqualTo(ordercode);
    if (memberid != null) {
      criteria.andMemberidEqualTo(memberid);
    }
    criteria.andTermdateGreaterThanOrEqualTo(date);
    example.setOrderByClause("termnum");
    List list = this.dao.selectByExample(example);
    return list;
  }

  public int update(Yieldplan plan)
  {
    return this.dao.updateByPrimaryKey(plan);
  }

  public BigDecimal getIncomeThisMonth(Long memberid) {
    BigDecimal accruedinterest = new BigDecimal(0);
    YieldplanExample example = new YieldplanExample();
    example.createCriteria().andTermdateGreaterThanOrEqualTo(new Date()).andMemberidEqualTo(Integer.valueOf(memberid.intValue()));

    List<Yieldplan> yieldplans = this.dao.selectByExample(example);
    for (Yieldplan y : yieldplans) {
      accruedinterest = accruedinterest.add(y.getAccruedinterest());
    }
    return accruedinterest;
  }

  public List<Yieldplan> findByOrderCode(String orderCode)
  {
    YieldplanExample example = new YieldplanExample();
    example.createCriteria().andInvestordercodeEqualTo(orderCode);
    return this.dao.selectByExample(example);
  }
}