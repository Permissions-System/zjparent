package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.dao.CpsInvestinfoMapper;
import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.CpsInvestinfoExample;
import com.zjgt.p2p.model.CpsInvestinfoExample.Criteria;
import com.zjgt.p2p.service.CpsInvestInfoService;
import com.zjgt.util.StringUtil;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cpsInvestInfoService")
public class CpsInvestInfoServiceImpl
  implements CpsInvestInfoService
{

  @Autowired
  private CpsInvestinfoMapper dao;

  public void insertCpsInfo(CpsInvestinfo info)
    throws BusinessException
  {
    this.dao.insert(info);
  }

  public void calccommission()
  {
  }

  public void updateCpsInfo(CpsInvestinfo info) throws BusinessException
  {
    this.dao.updateByPrimaryKeySelective(info);
  }

  public CpsInvestinfo findByMemberid(Long memberid)
    throws BusinessException
  {
    CpsInvestinfoExample example = new CpsInvestinfoExample();
    example.createCriteria().andMemberidEqualTo(memberid);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((CpsInvestinfo)list.get(0));
    }
    return null;
  }

  public List<CpsInvestinfo> findInvestInfos(String bidcode)
    throws BusinessException
  {
    CpsInvestinfoExample example = new CpsInvestinfoExample();
    example.createCriteria().andBidcodeEqualTo(bidcode);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  public CpsInvestinfo findByOrderCode(String ordercode)
    throws BusinessException
  {
    CpsInvestinfoExample example = new CpsInvestinfoExample();
    example.createCriteria().andOrdernoEqualTo(ordercode);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((CpsInvestinfo)list.get(0));
    }
    return null;
  }

  public List<CpsInvestinfo> findInfos(String status)
    throws BusinessException
  {
    CpsInvestinfoExample example = new CpsInvestinfoExample();
    CpsInvestinfoExample.Criteria criteria = example.createCriteria();
    if (StringUtil.isNotEmpty(status)) {
      criteria.andProfitstatusEqualTo(Integer.valueOf(status));
    }
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }
}