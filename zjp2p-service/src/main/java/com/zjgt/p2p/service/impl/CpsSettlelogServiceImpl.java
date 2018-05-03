package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.CpssettlelogMapper;
import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.model.CpssettlelogExample;
import com.zjgt.p2p.model.CpssettlelogExample.Criteria;
import com.zjgt.p2p.service.CpsSettlelogService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cpsSettlelogService")
public class CpsSettlelogServiceImpl
  implements CpsSettlelogService
{

  @Autowired
  private CpssettlelogMapper dao;

  public List<Cpssettlelog> findSettlelog(Long memberid)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    example.createCriteria().andMemberidEqualTo(memberid);
    example.setOrderByClause("termnum desc");
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public List<Cpssettlelog> findSettlelog(Long memberid, Integer settlestatus)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    example.createCriteria().andMemberidEqualTo(memberid).andSettlestatusEqualTo(settlestatus);

    example.setOrderByClause("termnum desc");
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public List<Cpssettlelog> findSettlelogs(Long memberid, String ordercode, Integer settlestatus)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    example.createCriteria().andMemberidEqualTo(memberid).andInvestordercodeEqualTo(ordercode).andSettlestatusEqualTo(settlestatus);

    example.setOrderByClause("termnum desc");
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public Cpssettlelog findSettlelog(Long memberid, String ordercode, Integer settlestatus)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    example.createCriteria().andMemberidEqualTo(memberid).andInvestordercodeEqualTo(ordercode).andSettlestatusEqualTo(settlestatus);

    example.setOrderByClause("opdate desc");
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Cpssettlelog)list.get(0));
    }
    return null;
  }

  @Transactional
  public void updatesettlelog(Cpssettlelog cpssettlelog) throws BusinessException
  {
    this.dao.updateByPrimaryKeySelective(cpssettlelog);
  }

  @Transactional
  public void insertsettlelog(Cpssettlelog cpssettlelog) throws BusinessException
  {
    this.dao.insert(cpssettlelog);
  }

  public List<Cpssettlelog> findSettlelogs(Date date)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    CpssettlelogExample.Criteria criteria = example.createCriteria();
    Calendar start = Calendar.getInstance();
    start.setTime(date);
    start.set(11, 0);
    start.set(12, 0);
    start.set(13, 0);
    start.set(14, 0);
    criteria.andSettledateGreaterThanOrEqualTo(start.getTime());
    Calendar end = Calendar.getInstance();
    end.setTime(date);
    end.add(5, 1);
    end.set(11, 0);
    end.set(12, 0);
    end.set(13, 0);
    end.set(14, 0);
    criteria.andSettledateLessThan(end.getTime());
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public List<Cpssettlelog> selectLastTTFlog() throws BusinessException
  {
    List list = this.dao.selectLastTTFlog();
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public List<Cpssettlelog> findByBidcode(String bidcode)
    throws BusinessException
  {
    CpssettlelogExample example = new CpssettlelogExample();
    example.createCriteria().andBidcodeEqualTo(bidcode);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }
}