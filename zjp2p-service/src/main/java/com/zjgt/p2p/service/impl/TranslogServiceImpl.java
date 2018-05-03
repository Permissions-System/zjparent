package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.Const.FEES;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.TranslogMapper;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.TranslogExample;
import com.zjgt.p2p.model.TranslogExample.Criteria;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import com.zjgt.p2p.service.TranslogService;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.StringUtil;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.DateUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslogServiceImpl
  implements TranslogService
{
  private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

  @Autowired
  private TranslogMapper mapper;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private PlatformAssetService platformAssetService;

  public org.springfk.pancloud.paginator.vo.Page<Translog> getTranslogs(Map<String, String> map)
    throws BusinessException
  {
    int pageNow = 0;
    org.springfk.pancloud.paginator.vo.Page pages = null;
    TranslogExample exam = new TranslogExample();
    TranslogExample.Criteria crit = exam.createCriteria();
    TranslogExample.Criteria crit1 = exam.createCriteria();
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry entry = (Map.Entry)it.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("OperaStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value)))
      {
        if ("1".equals(value)) {
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }
        if ("2".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.FILL.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.FILL.getTranCode());
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("3".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.WITHDRAW.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.WITHDRAW.getTranCode());
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("4".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.DEDUCT.getTranCode());

          crit1.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("5".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.INTEREST.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.INTEREST.getTranCode());
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("6".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("7".equals(value)) {
          List list = new ArrayList();
          list.add(AcctTranDef.WITHDRAW_FEE.getTranCode());
          list.add(AcctTranDef.REDEM_FEE.getTranCode());
          crit.andTranscodeIn(list);
          crit1.andTranscodeIn(list);
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("8".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.COMMISS_RETURN.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.COMMISS_RETURN.getTranCode());
          crit.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

        if ("9".equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.COMMISS_APPROP.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.COMMISS_APPROP.getTranCode());
          crit.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }

      }

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value)))
      {
        if ("2".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(1));
          crit1.andTransstatusEqualTo(Integer.valueOf(1));
        }

        if ("3".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(2));
          crit1.andTransstatusEqualTo(Integer.valueOf(2));
        }

        if ("5".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(0));
          crit1.andTransstatusEqualTo(Integer.valueOf(0));
        }

      }

      if (("StartDate".endsWith(key)) && (StringUtils.isNotEmpty(value))) {
        try {
          crit.andTranstimeGreaterThanOrEqualTo(new Date(Long.parseLong(value)));
          crit1.andTranstimeGreaterThanOrEqualTo(new Date(Long.parseLong(value)));
        } catch (Exception e) {
          throw new BusinessException("startdate 日期解析失败 :" + value);
        }
      }
      if (("EndDate".endsWith(key)) && (StringUtils.isNotEmpty(value))) {
        try {
          crit.andTranstimeLessThanOrEqualTo(new Date(Long.parseLong(value)));
          crit1.andTranstimeLessThanOrEqualTo(new Date(Long.parseLong(value)));
        } catch (Exception e) {
          throw new BusinessException("enddate 日期解析失败 :" + value);
        }
      }
    }
    crit1.addCriterion("transcode !=", "1031", "transcode");
    crit1.addCriterion("transcode !=", "1032", "transcode");
    crit1.addCriterion("transcode !=", "1033", "transcode");
    crit1.addCriterion("transcode !=", "1034", "transcode");
    crit.addCriterion("transcode !=", "1031", "transcode");
    crit.addCriterion("transcode !=", "1032", "transcode");
    crit.addCriterion("transcode !=", "1033", "transcode");
    crit.addCriterion("transcode !=", "1034", "transcode");

    exam.or(crit1);
    exam.or(crit);
    exam.setOrderByClause("id desc");
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new org.springfk.pancloud.paginator.vo.Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setPage(pages);
    pages.setResult(this.mapper.selectByExample(exam));
    return pages;
  }

  public org.springfk.pancloud.paginator.vo.Page<Translog> getTranslogs2(String pageSize, String pageNow1, String startdate, String enddate, long memberid) throws BusinessException, ParseException {
    int pageNow = 0;
    org.springfk.pancloud.paginator.vo.Page pages = null;
    TranslogExample exam = new TranslogExample();
    TranslogExample.Criteria crit = exam.createCriteria();
    TranslogExample.Criteria crit1 = exam.createCriteria();
    crit.andTranstimeBetween(DateConverterUtil.parseDate(startdate), DateConverterUtil.parseDate(enddate));
    crit1.andTranstimeBetween(DateConverterUtil.parseDate(startdate), DateConverterUtil.parseDate(enddate));
    crit.andPayeememberidEqualTo(Integer.valueOf((int)memberid));
    crit1.andPaymemberidEqualTo(Integer.valueOf((int)memberid));
    exam.or(crit1);
    exam.or(crit);
    exam.setOrderByClause("transtime");
    if (pageNow1 == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf(pageNow1).intValue();
    }
    pages = new org.springfk.pancloud.paginator.vo.Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt(pageSize));
    exam.setPage(pages);
    pages.setResult(this.mapper.selectByExample(exam));
    return pages;
  }

  public org.springfk.pancloud.paginator.vo.Page<Translog> getCapitalTransByPage(Map<String, String> map)
  {
    int pageNow = 0;
    org.springfk.pancloud.paginator.vo.Page pages = null;
    TranslogExample exam = new TranslogExample();
    TranslogExample.Criteria crit = exam.createCriteria();
    TranslogExample.Criteria crit1 = exam.createCriteria();
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
            crit1.andTranstimeBetween(begindate, enddate);
          }
          if ("month".equals(value)) {
            begindate = DateConverterUtil.getDate(1);
            enddate = DateConverterUtil.getDate(-30);
            crit.andTranstimeBetween(enddate, begindate);
            crit1.andTranstimeBetween(enddate, begindate);
          }
          if ("trmonth".equals(value)) {
            begindate = DateConverterUtil.getDate(1);
            enddate = DateConverterUtil.getDate(-91);
            crit.andTranstimeBetween(enddate, begindate);
            crit1.andTranstimeBetween(enddate, begindate);
          }
          if ("year".equals(value)) {
            begindate = DateConverterUtil.getDate(-365);
            enddate = DateConverterUtil.getDate(-100000);
            crit.andTranstimeBetween(enddate, begindate);
            crit1.andTranstimeBetween(enddate, begindate);
          }
        } catch (ParseException e) {
          throw new BusinessException("begindate parseDate 失败 ," + e.getMessage());
        }
      }

      if (("OperaStatus".equals(key)) && (StringUtil.isNotEmpty(value))) {
        if ("FEE".equals(value)) {
          crit.addCriterion("def.tranType = ", "11", "tranType");
          crit1.addCriterion("def.tranType = ", "11", "tranType");
        }
        else if (AcctTranDef.DEDUCT.getTranCode().equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.DEDUCT.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        } else if (AcctTranDef.PRINCIPAL.getTranCode().equals(value)) {
          crit.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit1.andTranscodeEqualTo(AcctTranDef.PRINCIPAL.getTranCode());
          crit.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        } else {
          crit.andTranscodeEqualTo(value);
          crit1.andTranscodeEqualTo(value);
          crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
          crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt((String)map.get("Memberid"))));
        }
      }

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        if ("2".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(1));
          crit1.andTransstatusEqualTo(Integer.valueOf(1));
        }
        if ("3".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(2));
          crit1.andTransstatusEqualTo(Integer.valueOf(2));
        }
        if ("4".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(0));
          crit1.andTransstatusEqualTo(Integer.valueOf(0));
        }
        if ("5".equals(value)) {
          crit.andTransstatusEqualTo(Integer.valueOf(0));
          crit1.andTransstatusEqualTo(Integer.valueOf(0));
        }

      }

      if (("Memberid".equals(key)) && (StringUtils.isNotEmpty(value)) && (((map.get("OperaStatus") == null) || (StringUtils.isEmpty((String)map.get("OperaStatus")))))) {
        crit.andPaymemberidEqualTo(Integer.valueOf(Integer.parseInt(value)));
        crit1.andPayeememberidEqualTo(Integer.valueOf(Integer.parseInt(value)));
      }

      if (("startdate".endsWith(key)) && (StringUtils.isNotEmpty(value))) {
        crit.andTranstimeGreaterThanOrEqualTo(DateUtils.getString2LongDate(value));
        crit1.andTranstimeGreaterThanOrEqualTo(DateUtils.getString2LongDate(value));
      }
      if (("enddate".endsWith(key)) && (StringUtils.isNotEmpty(value))) {
        crit.andTranstimeLessThanOrEqualTo(DateUtils.getString2LongDate(value));
        crit1.andTranstimeLessThanOrEqualTo(DateUtils.getString2LongDate(value));
      }
      if (("capitalDirection".endsWith(key)) && (StringUtils.isNotEmpty(value))) {
        crit.addCriterion("def.direction =", value, "capitalDirection");
        crit1.addCriterion("def.direction =", value, "capitalDirection");
      }
    }

    crit1.addCriterion("transcode !=", "1031", "transcode");
    crit1.addCriterion("transcode !=", "1032", "transcode");
    crit1.addCriterion("transcode !=", "1033", "transcode");
    crit1.addCriterion("transcode !=", "1034", "transcode");
    crit.addCriterion("transcode !=", "1031", "transcode");
    crit.addCriterion("transcode !=", "1032", "transcode");
    crit.addCriterion("transcode !=", "1033", "transcode");
    crit.addCriterion("transcode !=", "1034", "transcode");
    exam.or(crit1);
    exam.or(crit);
    exam.setOrderByClause("id desc");
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new org.springfk.pancloud.paginator.vo.Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setPage(pages);
    pages.setResult(this.mapper.getCapitalTransByPage(exam));
    return pages;
  }

  public com.zjgt.util.Page<Translog> getTranslogplatByPage(Map<String, String> map) throws BusinessException
  {
    List list = new ArrayList();
    list.add(Integer.valueOf(1));

    com.zjgt.util.Page pages = null;
    List transloglist = null;
    TranslogExample exam = new TranslogExample();
    TranslogExample.Criteria crit = exam.createCriteria();
    TranslogExample.Criteria crit1 = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);
      if (("budgetType".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andTranscodeEqualTo(value);
        crit1.andTranscodeEqualTo(value);
      }

      if (("payerId".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andPayaccountidEqualTo(Long.valueOf(value));
        crit1.andPayaccountidEqualTo(Long.valueOf(value));
      }

      if (("payeeId".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andPayeeaccountidEqualTo(Long.valueOf(value));
        crit1.andPayeeaccountidEqualTo(Long.valueOf(value));
      }

      if ("capitalFlow".equals(key))
        if (StringUtil.isNotEmpty(value)) {
          if ("1".equals(value)) {
            crit.andPayaccounttypeNotIn(list);
            crit.andPayeeaccounttypeIn(list);
            crit1.andPayaccounttypeNotIn(list);
            crit1.andPayeeaccounttypeIn(list);
          } else if ("2".equals(value)) {
            crit.andPayaccounttypeIn(list);
            crit.andPayeeaccounttypeNotIn(list);
            crit1.andPayaccounttypeIn(list);
            crit1.andPayeeaccounttypeNotIn(list);
          } else if ("3".equals(value)) {
            crit.andPayaccounttypeIn(list);
            crit.andPayeeaccounttypeIn(list);
            crit1.andPayaccounttypeIn(list);
            crit1.andPayeeaccounttypeIn(list);
          } else {
            crit.andPayaccounttypeIn(list);
            crit1.andPayeeaccounttypeIn(list);
          }
        } else {
          crit.andPayaccounttypeIn(list);
          crit1.andPayeeaccounttypeIn(list);
        }
      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andTranstimeGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value + " 00:00:00"));
          crit1.andTranstimeGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value + " 00:00:00"));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andTranstimeLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value + " 23:59:59"));
          crit1.andTranstimeLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value + " 23:59:59"));
        }
      }
      catch (Exception e)
      {
        throw new BusinessException(" begindate parseDate 失败 ," + value, e);
      }
      if (("transStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andTransstatusEqualTo(Integer.valueOf(value));
        crit1.andTransstatusEqualTo(Integer.valueOf(value));
      }
    }

    exam.setOrderByClause("Id DESC");
    exam.or(crit);
    exam.or(crit1);
    int totalCount = this.mapper.getTranslogCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);

    pages.setPageSize(Const.BID_PAGE_SIZE);
    if (!("-1".equals(map.get("pageNow")))) {
      exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    }
    exam.setPageSize(Integer.valueOf(Const.BID_PAGE_SIZE));
    transloglist = this.mapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(transloglist);
    return pages;
  }

  public void updatePlatformTransLog(String transno)
  {
    Map param = new HashMap();
    param.put("transno", transno);
    param.put("transcode", AcctTranDef.WITHDRAW_FEE.getTranCode());
    List list = this.mapper.selectByTransNo(param);
    if ((list != null) && (!(list.isEmpty()))) {
      Translog feeTranslog = (Translog)list.get(0);
      PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(30L));
      PlatformAsset platformAsset = this.platformAssetService.findAsset();
      if ((feeTranslog != null) && (1 == feeTranslog.getPayaccounttype().intValue()))
      {
        feeTranslog.setPaysubamount(platformAcct.getBlance().subtract(Const.FEES.SINA_FROM_BIIFOO));

        feeTranslog.setPlatavailamount(platformAsset.getBlance().subtract(Const.FEES.SINA_FROM_BIIFOO));
      } else {
        feeTranslog.setPayeesubamount(platformAcct.getBlance().add(feeTranslog.getAmount()));
        feeTranslog.setPlatavailamount(platformAsset.getBlance().add(feeTranslog.getAmount()));
      }
      this.mapper.updateByPrimaryKeySelective(feeTranslog);
    }
  }

  public int add(Translog translog)
  {
    return this.mapper.insertSelective(translog);
  }

  public List<Translog> selectLastIncome(Long acctmemberid)
  {
    TranslogExample example = new TranslogExample();
    try {
      Calendar cal = Calendar.getInstance();
      cal.add(5, 1);
      cal.set(10, 0);
      cal.set(12, 0);
      cal.set(13, 0);
      cal.set(14, 0);
      example.createCriteria().andPayeeaccountidEqualTo(acctmemberid).andTranscodeEqualTo(AcctTranDef.INTEREST.getTranCode()).andTranstimeBetween(DateConverterUtil.parseDate(DateConverterUtil.currentDate()), cal.getTime());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    example.setOrderByClause("TransTime desc");
    List list = this.mapper.selectByExample(example);
    return list;
  }

  public int updateWithdrawFailDesc(Map<String, String> param)
  {
    return this.mapper.updateWithdrawFailDesc(param);
  }
}