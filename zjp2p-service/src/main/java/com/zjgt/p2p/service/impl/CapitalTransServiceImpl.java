package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.CapitaltransMapper;
import com.zjgt.p2p.dao.TranslogMapper;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.CapitaltransExample;
import com.zjgt.p2p.model.CapitaltransExample.Criteria;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.StringUtil;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("capitaltransservice")
public class CapitalTransServiceImpl
  implements CapitalTransService
{

  @Autowired
  private CapitaltransMapper ctmapper;

  @Autowired
  private TranslogMapper translogMapper;
  Logger logger;

  public CapitalTransServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(CapitalTransServiceImpl.class);
  }

  public Page<Capitaltrans> getCapitaltrans(Map<String, String> map)
    throws BusinessException
  {
    int pageNow = 0;
    Page pages = null;
    CapitaltransExample exam = new CapitaltransExample();
    CapitaltransExample.Criteria crit = exam.createCriteria();
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);
      if (("Date".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        String today = DateConverterUtil.currentDate();
        try
        {
          Date begindate;
          Date enddate;
          if ("today".equals(value)) {
            begindate = DateConverterUtil.parseDate(today);
            enddate = new Date(begindate.getTime() + 86400000L - 1L);
            crit.andTranstimeBetween(begindate, enddate);
          }
          if ("month".equals(value)) {
            begindate = DateConverterUtil.parseDate(today);
            enddate = DateConverterUtil.getDate(-30);
            crit.andTranstimeBetween(enddate, begindate);
          }
          if ("trmonth".equals(value)) {
            begindate = DateConverterUtil.parseDate(today);
            enddate = DateConverterUtil.getDate(-91);
            crit.andTranstimeBetween(enddate, begindate);
          }
          if ("year".equals(value)) {
            begindate = DateConverterUtil.parseDate(today);
            enddate = DateConverterUtil.getDate(-365);
            crit.andTranstimeBetween(enddate, begindate);
            System.out.println(enddate);
            System.out.println();
          }
        } catch (ParseException e) {
          throw new BusinessException("begindate parseDate 失败 ," + e.getMessage());
        }
      }

      if (("OperaStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        if ("2".equals(value)) {
          crit.andTranstypeEqualTo(Integer.valueOf(1));
        }
        if ("3".equals(value)) {
          crit.andTranstypeEqualTo(Integer.valueOf(0));
        }
        if ("4".equals(value)) {
          crit.andTranstypeEqualTo(Integer.valueOf(2));
        }
        if ("5".equals(value)) {
          crit.andTranstypeEqualTo(Integer.valueOf(3));
        }

      }

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        if ("2".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(1));
        }
        if ("3".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(2));
        }
        if ("4".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(0));
        }
        if ("5".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(0));
        }
      }

      if ("Memberid".equals(key)) {
        crit.andMemberidEqualTo(Integer.valueOf(Integer.parseInt(value)));
      }
    }
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setPage(pages);
    pages.setResult(this.ctmapper.selectByExample(exam));
    return pages;
  }

  public void add(Capitaltrans capitalTrans)
  {
    this.ctmapper.insertSelective(capitalTrans);
    for (Translog translog : capitalTrans.getTranLogs())
      if (translog != null) {
        translog.setTransno(String.valueOf(capitalTrans.getId()));
        this.translogMapper.insertSelective(translog);
      }
  }

  public int getTimes(long memberid)
    throws BusinessException
  {
    String today = DateConverterUtil.currentDate();
    Date begindate = null;
    try {
      begindate = DateConverterUtil.parseDate(today);
    } catch (ParseException e) {
      throw new BusinessException("begindate parseDate 失败 ," + e.getMessage());
    }
    Date enddate = new Date(begindate.getTime() + 86400000L - 1L);
    CapitaltransExample exam = new CapitaltransExample();
    exam.createCriteria().andMemberidEqualTo(Integer.valueOf((int)memberid)).andTranstimeBetween(begindate, enddate).andTranstypeEqualTo(Integer.valueOf(Integer.parseInt(AcctTranDef.WITHDRAW.getTranCode()))).andTransstatusNotEqualTo(Integer.valueOf(2));

    List capitaltranses = this.ctmapper.selectByExample(exam);
    return capitaltranses.size();
  }

  public int getTimesAsInvest(long memberid)
  {
    CapitaltransExample exam = new CapitaltransExample();
    exam.createCriteria().andMemberidEqualTo(Integer.valueOf((int)memberid)).andTranstypeEqualTo(Integer.valueOf(AcctTranDef.DEDUCT.getTranCode()));
    List capitaltranses = this.ctmapper.selectByExample(exam);
    return capitaltranses.size();
  }

  public void updateStatusByTransNo(String transNo, int status) throws BusinessException
  {
    Map paramMap = new HashMap();
    paramMap.put("transStatus", Integer.valueOf(status));
    paramMap.put("transNo", transNo);

    int updateCapitaltrans = this.ctmapper.updateStatusByTransNo(paramMap);
    Capitaltrans capitaltrans = getCapitaltransByTransNo(transNo);
    if (capitaltrans != null) {
      paramMap.put("transNo", capitaltrans.getId());
      this.translogMapper.updateStatusByTransNo(paramMap);
    } else {
      this.logger.info("transNo : " + transNo + " , updateCapitaltrans count : " + updateCapitaltrans + "" + paramMap.toString());
    }
  }

  public Capitaltrans getCapitaltransByTransNo(String transNo) throws BusinessException
  {
    CapitaltransExample exam = new CapitaltransExample();
    exam.createCriteria().andTransnoEqualTo(transNo);
    List capitaltranses = this.ctmapper.selectByExample(exam);
    if ((capitaltranses != null) && (!(capitaltranses.isEmpty()))) {
      return ((Capitaltrans)capitaltranses.get(0));
    }
    return null;
  }

  public Capitaltrans selectTTFLastIncome(String investordercode, Long acctmemberid)
  {
    CapitaltransExample example = new CapitaltransExample();
    try {
      Calendar cal = Calendar.getInstance();
      cal.add(5, 1);
      cal.set(10, 0);
      cal.set(12, 0);
      cal.set(13, 0);
      cal.set(14, 0);
      example.createCriteria().andTransnoEqualTo(investordercode).andPayeeaccountidEqualTo(acctmemberid).andTranstypeEqualTo(Integer.valueOf(AcctTranDef.REPAY.getTranCode())).andTranstimeBetween(DateConverterUtil.parseDate(DateConverterUtil.currentDate()), cal.getTime());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    example.setOrderByClause("TransTime desc");
    List list = this.ctmapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Capitaltrans)list.get(0));
    }
    return null;
  }

  public List<Capitaltrans> selectLastRecord(Long acctmemberid)
  {
    CapitaltransExample example = new CapitaltransExample();
    try {
      Calendar cal = Calendar.getInstance();
      cal.add(5, 1);
      cal.set(10, 0);
      cal.set(12, 0);
      cal.set(13, 0);
      cal.set(14, 0);
      example.createCriteria().andPayeeaccountidEqualTo(acctmemberid).andTranstypeEqualTo(Integer.valueOf(AcctTranDef.REPAY.getTranCode())).andTranstimeBetween(DateConverterUtil.parseDate(DateConverterUtil.currentDate()), cal.getTime());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    example.setOrderByClause("TransTime desc");
    List list = this.ctmapper.selectByExample(example);
    return list;
  }

  public BigDecimal sumTTFRollOutMoney(String investordercode, Long acctmemberid, Date currentdate)
  {
    CapitaltransExample example = new CapitaltransExample();
    example.createCriteria().andTransnoEqualTo(investordercode).andPayeeaccountidEqualTo(acctmemberid).andTranstypeEqualTo(Integer.valueOf(AcctTranDef.REDEM.getTranCode())).andTranstimeEqualTo(currentdate);

    List list = this.ctmapper.selectByExample(example);
    BigDecimal money = null;
    if ((list != null) && (!(list.isEmpty()))) {
      for (int i = 0; i < list.size(); ++i) {
        money = money.add(((Capitaltrans)list.get(i)).getAmount());
      }
    }
    return money;
  }

  public Page<Map<String, Object>> selectRechargeBySettle(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = ((Integer)paramMap.get("pageNow")).intValue();
    }
    Page page = new Page(pageNow, ((Integer)paramMap.get("pageSize")).intValue());
    paramMap.put("pageObject", page);
    page.setResult(this.ctmapper.selectRechargeBySettle(paramMap));
    return page;
  }

  public int selectCountRechargeBySettle(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    Page page = new Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));
    paramMap.put("pageObject", page);

    int pageCnt = this.ctmapper.selectCountRechargeBySettle(paramMap);
    return pageCnt;
  }

  public Page<Map<String, Object>> selectWithdrawBySettle(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    Page page = new Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));
    paramMap.put("pageObject", page);
    page.setResult(this.ctmapper.selectWithdrawBySettle(paramMap));
    return page;
  }

  public int getRechargeSuccessCount(Long memberId)
  {
    return this.ctmapper.getRechargeSuccessCount(memberId);
  }
}