package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.OrgState;
import com.zjgt.p2p.dao.BorrowerMapper;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.Borrower;
import com.zjgt.p2p.model.BorrowerExample;
import com.zjgt.p2p.model.BorrowerExample.Criteria;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.BorrowerService;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("borrowerService")
public class BorrowerServiceImpl
  implements BorrowerService
{
  private static final String PATTERN = "yyyy-MM-dd";

  @Autowired
  private BorrowerMapper orgMapper;

  @Autowired
  private BidService bidService;

  public Borrower findById(String id)
  {
    Borrower org = null;
    if (id != null) {
      org = this.orgMapper.selectByPrimaryKey(Integer.valueOf(id));
    }
    return org;
  }

  public List<Borrower> selectAll()
  {
    BorrowerExample example = new BorrowerExample();
    example.createCriteria().andOrgstateEqualTo(Integer.valueOf(OrgState.NORMAL.getKey()));
    return this.orgMapper.selectByExample(example);
  }

  public Page<Borrower> selectBorrowerByPage(Map<String, String> map)
  {
    Page pages = null;

    List borrowerList = null;
    BorrowerExample exam = new BorrowerExample();
    BorrowerExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);
      if (("instcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBorrowercodeEqualTo(value);
      }

      if (("instname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBorrowernameEqualTo(value);
      }

      if (("orgState".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andOrgstateEqualTo(Integer.valueOf(value));
      }

      if (("borrowtype".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBorrowtypeEqualTo(Integer.valueOf(value));
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andValiddateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andValiddateLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }

    exam.setOrderByClause("ValidDate desc ");
    int totalCount = this.orgMapper.getBorrowerCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page(totalCount, pageNow);

    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Integer.parseInt((String)map.get("pageSize"))));

    borrowerList = this.orgMapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(borrowerList);
    return pages;
  }

  public int addBorrower(Borrower vouchOrg)
  {
    return this.orgMapper.insertSelective(vouchOrg);
  }

  public int updateBorrower(Borrower vouchOrg)
  {
    return this.orgMapper.updateByPrimaryKeySelective(vouchOrg);
  }

  public int deleteByPrimaryKey(Integer id)
  {
    return this.orgMapper.deleteByPrimaryKey(id);
  }

  public Borrower findBybid(String id)
  {
    if (StringUtil.isEmpty(id)) {
      return null;
    }
    Bid bid = this.bidService.findById(Long.valueOf(id));
    BorrowerExample example = new BorrowerExample();
    example.createCriteria().andBorrowercodeEqualTo(bid.getInstcode());
    List list = this.orgMapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Borrower)list.get(0));
    }
    return null;
  }
}