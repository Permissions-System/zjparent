package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.dao.CpsrecMapper;
import com.zjgt.p2p.model.AdvchannelInfo;
import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.CpsLog;
import com.zjgt.p2p.model.Cpsrec;
import com.zjgt.p2p.model.CpsrecExample;
import com.zjgt.p2p.model.CpsrecExample.Criteria;
import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.service.AdvchannelInfoService;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.CpsCommissionrateService;
import com.zjgt.p2p.service.CpsInvestInfoService;
import com.zjgt.p2p.service.CpsRegService;
import com.zjgt.p2p.service.CpsSettlelogService;
import com.zjgt.util.CommissionCalcUtil;
import com.zjgt.util.DateConverterUtil;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cpsRegService")
public class CpsRegServiceImpl
  implements CpsRegService
{

  @Autowired
  private CpsrecMapper dao;

  @Autowired
  private CpsInvestInfoService cpsInvestInfoService;

  @Autowired
  private CpsSettlelogService cpsSettlelogService;

  @Autowired
  private CpsCommissionrateService cpsCommissionrateService;

  @Autowired
  private AdvchannelInfoService advchannelService;

  @Autowired
  private BidService bidService;

  public void cpsRec(Cpsrec cpsrec, String url)
    throws BusinessException
  {
    if ("registerAjax.do".equals(url)) {
      cpsrec.setPagename("register");
      cpsrec.setOperation("register");
    }
    else if ("login.do".equals(url)) {
      cpsrec.setPagename("login");
      cpsrec.setOperation("login");
    }
    else if (("buyBidHandle.do".equals(url)) || ("buyBidTrans.do".equals(url))) {
      cpsrec.setPagename("bidDetail");
      cpsrec.setOperation("invest");
    }
    else {
      cpsrec.setOperation("browser");
    }
    insertCpsRec(cpsrec);
  }

  public void cpsinvestrec(CpsInvestinfo cpsInvestinfo)
    throws BusinessException
  {
  }

  public void cpslog(CpsLog cpsLog)
    throws BusinessException
  {
  }

  public void insertCpsRec(Cpsrec cpsrec)
    throws BusinessException
  {
    this.dao.insert(cpsrec);
  }

  public List<Cpsrec> findByMemberid(Long memberid, String operation)
    throws BusinessException
  {
    CpsrecExample example = new CpsrecExample();
    example.createCriteria().andMemberidEqualTo(memberid).andOperationEqualTo(operation);
    List list = this.dao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  @Transactional
  public void CommisionTrans() throws BusinessException {
    CommisionTrans(new Date()); }

  @Transactional
  public void CommisionTrans(Date currentdate) throws BusinessException {
	  List<Cpssettlelog> list;
    try {
    	 list  = this.cpsSettlelogService.findSettlelogs(currentdate);
      if ((list != null) && (!(list.isEmpty())))
      {
        for (Cpssettlelog cpssettlelog : list)
          if (cpssettlelog.getSettlestatus().intValue() == 0) {
            cpssettlelog.setOpdate(currentdate);
            cpssettlelog.setSettlestatus(Integer.valueOf(1));
            this.cpsSettlelogService.updatesettlelog(cpssettlelog);
          }
      }
    }
    catch (Exception e) {
      throw new BusinessException();
    }
    Calendar cal;
    try {
      cal = Calendar.getInstance();
      cal.setTime(currentdate);
      cal.add(2, 1);
      cal.set(5, 1);

      List<Cpssettlelog> ttlist = this.cpsSettlelogService.selectLastTTFlog();
      if ((ttlist != null) && (!(ttlist.isEmpty())))
        for (Cpssettlelog log : ttlist) {
          CpsInvestinfo cpsInvestinfo = this.cpsInvestInfoService.findByOrderCode(log.getInvestordercode());
          if ((cpsInvestinfo == null) || 
            (cpsInvestinfo.getProfitstatus().intValue() == 3)) continue; if (cpsInvestinfo.getProfitstatus().intValue() == 2)
          {
            continue;
          }

          if (log.getSettleamount().compareTo(BigDecimal.ZERO) == 0) {
            cpsInvestinfo.setProfitstatus(Integer.valueOf(3));
            this.cpsInvestInfoService.updateCpsInfo(cpsInvestinfo);
          }

          AdvchannelInfo advchannelInfo = this.advchannelService.findInfo(log.getChannel());
          CpsCommissionrate rate = this.cpsCommissionrateService.findCommissionrate(Integer.valueOf(BidType.MINGXINGBIAO.getKey()), log.getAmount(), log.getChannel());

          Cpssettlelog newlog = new Cpssettlelog();
          newlog.setTermnum(Integer.valueOf(log.getTermnum().intValue() + 1));
          newlog.setBidcode(log.getBidcode());
          newlog.setInvestordercode(log.getInvestordercode());
          newlog.setMemberid(log.getMemberid());
          newlog.setChannel(log.getChannel());
          newlog.setChannel2(log.getChannel2());
          newlog.setOpdate(currentdate);
          newlog.setAmount(log.getAmount());
          newlog.setSettleamount(log.getSettleamount());

          if ((cal.getTime().after(advchannelInfo.getCooperiod())) || (DateConverterUtil.areSameDay(cal.getTime(), advchannelInfo.getCooperiod())))
          {
            cpsInvestinfo.setProfitstatus(Integer.valueOf(2));
            this.cpsInvestInfoService.updateCpsInfo(cpsInvestinfo);
          }

          List ttfplan = CommissionCalcUtil.CommissionCalc(currentdate, cal.getTime(), advchannelInfo.getCooperiod(), log.getSettleamount(), rate.getCommissionrate(), 0, BidType.MINGXINGBIAO.getKey(), false);
          if ((ttfplan != null) && (!(ttfplan.isEmpty()))) {
            newlog.setCommission(((Cpssettlelog)ttfplan.get(0)).getCommission());
            newlog.setSettledate(((Cpssettlelog)ttfplan.get(0)).getSettledate());
            Calendar cudate = Calendar.getInstance();
            cudate.setTime(log.getSettledate());
            Calendar sedate = Calendar.getInstance();
            sedate.setTime(((Cpssettlelog)ttfplan.get(0)).getSettledate());

            if (cudate.get(2) == sedate.get(2)) {
              continue;
            }
          }
          newlog.setSettlestatus(Integer.valueOf(0));
          this.cpsSettlelogService.insertsettlelog(newlog);
        }
    }
    catch (Exception e) {
      throw new BusinessException();
    }
    try
    {
    	List<CpsInvestinfo> e = this.cpsInvestInfoService.findInfos(null);
      if ((e != null) && (!(e.isEmpty())))
      {
        for (CpsInvestinfo info : e)
          if ((info.getLastsettledate() != null) && (DateConverterUtil.areSameDay(info.getLastsettledate(), currentdate))) {
            info.setProfitstatus(Integer.valueOf(2));
            this.cpsInvestInfoService.updateCpsInfo(info);
          }
      }
    }
    catch (Exception e) {
      throw new BusinessException();
    }
  }
}