package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.dao.TranslogplatMapper;
import com.zjgt.p2p.model.Translogplat;
import com.zjgt.p2p.model.TranslogplatExample;
import com.zjgt.p2p.model.TranslogplatExample.Criteria;
import com.zjgt.p2p.service.TranslogplatService;
import com.zjgt.util.Page;
import com.zjgt.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("translogplatService")
public class TranslogplatServiceImpl
  implements TranslogplatService
{

  @Autowired
  private TranslogplatMapper mapper;

  public Page<Translogplat> getTranslogplatByPage(Map<String, String> map)
    throws BusinessException
  {
    List list = new ArrayList();
    list.add(Integer.valueOf(1));
    list.add(Integer.valueOf(4));

    Page pages = null;
    List translogplatlist = null;
    TranslogplatExample exam = new TranslogplatExample();
    TranslogplatExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if ((("budgetType".equals(key)) && 
        (StringUtil.isNotEmpty(value))) || (
        ("capitalFlow".equals(key)) && 
        (StringUtil.isNotEmpty(value)))) {
        if ("1".equals(value)) {
          crit.andPayaccounttypeNotIn(list);
          crit.andPayeeaccounttypeIn(list);
        } else if ("2".equals(value)) {
          crit.andPayaccounttypeIn(list);
          crit.andPayeeaccounttypeNotIn(list);
        } else if ("3".equals(value)) {
          crit.andPayaccounttypeIn(list);
          crit.andPayeeaccounttypeIn(list);
        }
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andTranstimeGreaterThanOrEqualTo(new Date(Long.parseLong(value)));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andTranstimeLessThanOrEqualTo(new Date(Long.parseLong(value)));
        }
      }
      catch (Exception e)
      {
        throw new BusinessException(" 日期解析失败 :" + value);
      }
    }
    exam.setOrderByClause("TransTime DESC ");
    int totalCount = this.mapper.getTranslogplatCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page(totalCount, pageNow);

    pages.setPageSize(Const.BID_PAGE_SIZE);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Const.BID_PAGE_SIZE));
    translogplatlist = this.mapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(translogplatlist);
    return pages;
  }
}