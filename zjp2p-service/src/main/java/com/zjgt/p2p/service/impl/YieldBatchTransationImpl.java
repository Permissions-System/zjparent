package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.OrderStatus;
import com.zjgt.p2p.common.OrderStatusDesc;
import com.zjgt.p2p.common.TermStatus;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.YieldplanMapper;
import com.zjgt.p2p.dao.YieldsumMapper;
import com.zjgt.p2p.model.AdvchannelInfo;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Investorderhistory;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.YieldplanExample;
import com.zjgt.p2p.model.YieldplanExample.Criteria;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.model.YieldsumExample;
import com.zjgt.p2p.service.AdvchannelInfoService;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.BonusService;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.CpsCommissionrateService;
import com.zjgt.p2p.service.CpsInvestInfoService;
import com.zjgt.p2p.service.CpsRegService;
import com.zjgt.p2p.service.CpsSettlelogService;
import com.zjgt.p2p.service.InvestOrderHistoryService;
import com.zjgt.p2p.service.InvestOrderService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberProdIncomeService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import com.zjgt.p2p.service.YieldBatchTransation;
import com.zjgt.p2p.service.YieldCommission;
import com.zjgt.util.CommissionCalcUtil;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.StringUtil;
import com.zjgt.util.YieldCalcUtil;
import com.zjgt.util.YieldInfo;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("yieldBatchTransation")
public class YieldBatchTransationImpl
  implements YieldBatchTransation
{

  @Autowired
  private ISerialService serialService;

  @Autowired
  private YieldplanMapper yieldplandao;

  @Autowired
  private YieldsumMapper yieldsumdao;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private MemberAccountService accountService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private InvestOrderService investorderService;

  @Autowired
  private InvestOrderHistoryService investorderhistoryService;

  @Autowired
  private BidService bidService;

  @Autowired
  private AgentService middlemanService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private MemberProdIncomeService memberProdIncomeService;

  @Autowired
  private YieldCommission yieldCommission;
  Logger logger;

  @Autowired
  private BonusService bonusService;

  @Autowired
  private CpsRegService cpsRecService;

  @Autowired
  private CpsInvestInfoService cpsInvestInfoService;

  @Autowired
  private CpsSettlelogService cpsSettlelogService;

  @Autowired
  private CpsCommissionrateService cpsCommissionrateService;

  @Autowired
  private AdvchannelInfoService advchannelService;

  public YieldBatchTransationImpl()
  {
    this.logger = LoggerFactory.getLogger(YieldBatchTransationImpl.class);
  }

  @Transactional
  public int generatorYieldplan(String investOrderCode, int memberid, YieldInfo info, boolean isTrans)
    throws BusinessException
  {
    Yieldsum record = new Yieldsum();
    record.setMemberid(Integer.valueOf(memberid));
    record.setInvestordercode(investOrderCode);
    record.setPrincipalamountsum(info.getTotalAmount().subtract(info.getTotalInterest()));

    record.setAccruedinterestsum(info.getTotalInterest());
    record.setRemainpriamount(info.getTotalAmount().subtract(info.getTotalInterest()).setScale(2, RoundingMode.FLOOR));

    record.setRemaininterestsum(info.getTotalInterest());
    record.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
    record.setPaystatus(Integer.valueOf(0));
    if (isTrans) {
      record.setPaystatus(Integer.valueOf(1));
    }
    int sum = this.yieldsumdao.insert(record);

    for (Yieldplan plan : info.getYieldDtls()) {
      plan.setMemberid(Integer.valueOf(memberid));
      plan.setInvestordercode(investOrderCode);
      sum += this.yieldplandao.insertSelective(plan);
    }
    return sum;
  }

  @Transactional
  public int selfRepay(String investOrderCode, int memberid, Date currentDate)
  {
    InvestOrder investorder = this.investorderService.findByOrdercode(investOrderCode);

    if (investorder == null)
      return 0;
    if ((investorder.getOrderstatus().intValue() == OrderStatus.FINISHED.getKey()) || (investorder.getOrderstatus().intValue() == OrderStatus.UNVALID.getKey()))
    {
      return 0;
    }
    YieldplanExample exam = new YieldplanExample();
    YieldplanExample.Criteria criteria2 = exam.createCriteria();
    criteria2.andMemberidEqualTo(Integer.valueOf(memberid));
    criteria2.andInvestordercodeEqualTo(investOrderCode);
    criteria2.andTermstatusEqualTo(String.valueOf(TermStatus.REPAYING.getKey()));

    criteria2.andTermdateLessThanOrEqualTo(currentDate);
    List yieldplans = this.yieldplandao.selectByExample(exam);
    Yieldplan yieldplan = null;
    if ((yieldplans != null) && (!(yieldplans.isEmpty()))) {
      yieldplan = (Yieldplan)yieldplans.get(0);
    }
    yieldplan.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
    yieldplan.setRepaydate(currentDate);

    YieldsumExample sumeExample = new YieldsumExample();
    sumeExample.createCriteria().andMemberidEqualTo(Integer.valueOf(memberid)).andInvestordercodeEqualTo(investOrderCode).andTermstatusEqualTo(String.valueOf(TermStatus.REPAYING.getKey()));

    Yieldsum yieldsum = null;
    List yieldsums = this.yieldsumdao.selectByExample(sumeExample);
    if ((yieldsums != null) && (!(yieldsums.isEmpty())))
      yieldsum = (Yieldsum)yieldsums.get(0);
    else {
      return 0;
    }

    if (yieldsum.getTranscode().equals(AcctTranDef.COMMISS_RETURN.getTranCode())) {
      return 0;
    }

    this.yieldplandao.updateByPrimaryKeySelective(yieldplan);

    YieldplanExample exam2 = new YieldplanExample();
    YieldplanExample.Criteria plancriteria = exam2.createCriteria();
    plancriteria.andMemberidEqualTo(Integer.valueOf(memberid));
    plancriteria.andInvestordercodeEqualTo(investOrderCode);
    plancriteria.andTermnumEqualTo(Integer.valueOf(yieldplan.getTermnum().intValue() + 1));
    List yieldplans2 = this.yieldplandao.selectByExample(exam2);
    Yieldplan yieldplan2 = null;
    if ((yieldplans2 != null) && (!(yieldplans2.isEmpty()))) {
      yieldplan2 = (Yieldplan)yieldplans2.get(0);
    }
    if (yieldplan2 != null) {
      yieldsum.setTermnum(yieldplan2.getTermnum());
      yieldsum.setTermdate(yieldplan2.getTermdate());
      yieldsum.setTermamount(yieldplan2.getTermamount());
      yieldsum.setRemainpriamount(yieldplan.getRemainpriamount());
      yieldsum.setRemaininterestsum(yieldplan.getRemaininterest());
      yieldsum.setRepaidamountsum(yieldplan.getRepaidamount());
      if (yieldsum.getRepaidinterestsum() == null) {
        yieldsum.setRepaidinterestsum(BigDecimal.ZERO);
      }
      yieldsum.setRepaidinterestsum(yieldsum.getRepaidinterestsum().add(yieldplan.getAccruedinterest()));
    }
    else
    {
      yieldsum.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
      InvestOrder order = this.investorderService.findByOrdercode(investOrderCode);

      order.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
      this.investorderService.updateOrder(order);
      Investorderhistory history = new Investorderhistory();
      history.setBidcode(order.getBidcode());
      history.setAmount(order.getAmount());
      history.setCustomernickname(order.getCustomernickname());
      history.setCustomername(order.getCustomername());
      history.setOrderdate(order.getOrderdate());
      history.setInvestordercode(order.getInvestordercode());
      history.setCustomerid(order.getCustomerid());
      history.setExptincome(order.getExptincome());
      history.setOpdate(order.getOpdate());
      history.setOrderstatus(order.getOrderstatus());
      history.setTransname(order.getTransname());
      history.setTransstatus(order.getTransstatus());
      history.setOrderstatusdesc(order.getOrderstatusdesc());
      history.setApprostatus(order.getApprostatus());
      this.investorderhistoryService.addOrder(history);
    }
    this.yieldsumdao.updateByPrimaryKeySelective(yieldsum);

    this.yieldCommission.updateCommissionPlan(yieldplan);
    this.yieldCommission.updateCommissionPlan(yieldsum);

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
      throw new BusinessException("平台资产金额为空,请核查平台资产数据!");
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
      throw new BusinessException("平台资产余额为空,请核查平台资产数据!");
    }
    if (platformAsset.getAccount().subtract(yieldplan.getTermamount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("平台资产金额小于还款金额,请核查平台资产数据!");
    }
    platformAsset.setAccount(platformAsset.getAccount().subtract(yieldplan.getTermamount()));

    if (platformAsset.getBlance().subtract(yieldplan.getTermamount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("平台资产余额小于还款金额,请核查平台资产数据!");
    }
    platformAsset.setBlance(platformAsset.getBlance().subtract(yieldplan.getTermamount()));

    platformAsset.setModifyDate(currentDate);
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.REPAY.getTranName(), 0);

    if (platformAcct.getAccount().subtract(yieldplan.getTermamount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("平台账户金额小于还款金额,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(yieldplan.getTermamount()));

    if (platformAcct.getBlance().subtract(yieldplan.getTermamount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("平台账户余额小于还款金额,请核查平台资产数据!");
    }
    platformAcct.setBlance(platformAcct.getBlance().subtract(yieldplan.getTermamount()));

    platformAcct.setModifyDate(currentDate);
    this.platformAcctService.save(platformAcct);

    MemberAcct memberacct = this.memberAcctService.findByMemberIdForUpdate(Long.valueOf(memberid));

    BigDecimal acctPri = memberacct.getBlance().add(yieldplan.getPrincipalamount());

    BigDecimal acctint = memberacct.getBlance().add(yieldplan.getTermamount());

    memberacct.setBlance(memberacct.getBlance().add(yieldplan.getTermamount()));

    memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));

    memberacct.setModifyDate(currentDate);
    this.memberAcctService.save(memberacct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(Long.valueOf(memberid));

    BigDecimal accountPri = memberAccount.getBlance().add(yieldplan.getPrincipalamount());

    BigDecimal accountint = memberAccount.getBlance().add(yieldplan.getTermamount());

    memberAccount.setBlance(memberAccount.getBlance().add(yieldplan.getTermamount()));

    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().subtract(yieldplan.getPrincipalamount()));

    if (memberAccount.getRecvincome() == null) {
      memberAccount.setRecvincome(BigDecimal.ZERO);
    }
    memberAccount.setRecvincome(memberAccount.getRecvincome().subtract(yieldplan.getAccruedinterest()));

    if (memberAccount.getTotalincome() == null) {
      memberAccount.setTotalincome(BigDecimal.ZERO);
    }
    memberAccount.setTotalincome(memberAccount.getTotalincome().add(yieldplan.getAccruedinterest()));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(currentDate);
    this.accountService.save(memberAccount);

    Translog bonusTranslog = null;

    if ((investorder.getBonusamount() != null) && (investorder.getBonusamount().compareTo(BigDecimal.ZERO) > 0)) {
      bonusTranslog = this.bonusService.tranBonuse(Long.valueOf(memberid), investorder.getBonusamount(), AcctTranDef.BONUS_DEDUCT);
    }

    Translog commissionTranslog = null;
    if ((investorder.getBonusamount() != null) && (investorder.getBonusamount().compareTo(BigDecimal.ZERO) > 0))
      commissionTranslog = this.middlemanService.batchCommissionReturn(Long.valueOf(memberid), investorder.getExptincome().add(investorder.getBonusamount()), AcctTranDef.REPAY);
    else {
      commissionTranslog = this.middlemanService.batchCommissionReturn(Long.valueOf(memberid), investorder.getExptincome(), AcctTranDef.REPAY);
    }

    Member member = this.memberService.findMemberByid(memberid);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(yieldplan.getInvestordercode());
    capitalTrans.setTranstime(currentDate);

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.REPAY.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(memberid));
    capitalTrans.setRealname(member.getRealname());
    capitalTrans.setAmount(yieldplan.getTermamount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayaccounttype(Integer.valueOf(1));

    capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
    capitalTrans.setPayeename(member.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    if (!(yieldplan.getPrincipalamount().equals(BigDecimal.ZERO))) {
      Translog translog = new Translog();
      translog.setTranstime(capitalTrans.getTranstime());
      translog.setTranscode(AcctTranDef.PRINCIPAL.getTranCode());
      translog.setTransdesc(AcctTranDef.PRINCIPAL.getShowName());
      translog.setAmount(yieldplan.getPrincipalamount());
      translog.setAvailamount(accountPri);
      translog.setPlatavailamount(platformAsset.getBlance());
      translog.setCurrency("CNY");

      translog.setPayaccountid(platformAcct.getAcctid());
      translog.setPaysubamount(platformAcct.getBlance());
      translog.setPayaccounttype(Integer.valueOf(1));
      translog.setPayername(platformAcct.getAcctName());

      translog.setPayeeaccountid(memberacct.getMemberAcctid());
      translog.setPayeememberid(Integer.valueOf(memberid));
      translog.setPayeesubamount(acctPri);
      translog.setPayeename(member.getRealname());
      translog.setPayeeaccounttype(Integer.valueOf(0));
      translog.setTransstatus(Integer.valueOf(1));
      translogList.add(translog);
    }

    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.INTEREST.getTranCode());
    translog1.setTransdesc(AcctTranDef.INTEREST.getShowName());
    translog1.setAmount(yieldplan.getAccruedinterest());
    translog1.setAvailamount(accountint);
    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccountid(platformAcct.getAcctid());
    translog1.setPaysubamount(platformAcct.getBlance());
    translog1.setPayaccounttype(Integer.valueOf(1));
    translog1.setPayername(platformAcct.getAcctName());

    translog1.setPayeeaccountid(memberacct.getMemberAcctid());
    translog1.setPayeememberid(Integer.valueOf(memberid));
    translog1.setPayeesubamount(acctint);
    translog1.setPayeename(member.getRealname());
    translog1.setPayeeaccounttype(Integer.valueOf(0));
    translog1.setTransstatus(Integer.valueOf(1));
    translogList.add(translog1);

    if (bonusTranslog != null) {
      translogList.add(bonusTranslog);
    }

    if (commissionTranslog != null) {
      translogList.add(commissionTranslog);
    }

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    InvestOrder investOrder = this.investorderService.findByOrdercode(yieldplan.getInvestordercode());
    Bid investOrderBid = this.bidService.findByBidcode(investOrder.getBidcode());
    this.messageService.sendMessage("message.paymentsuccess", memberid, new String[] { investOrderBid.getBidclassname(), String.valueOf(investOrder.getAmount()), String.valueOf(investOrder.getExptincome()) });

    return 1;
  }

  @Transactional
  public int tiantianRepay(String investOrderCode, int memberid, Date currentDate)
  {
    YieldplanExample exam = new YieldplanExample();
    YieldplanExample.Criteria criteria2 = exam.createCriteria();
    criteria2.andMemberidEqualTo(Integer.valueOf(memberid));
    criteria2.andInvestordercodeEqualTo(investOrderCode);
    List yieldplans = this.yieldplandao.selectByExample(exam);
    Yieldplan yieldplan = null;
    if ((yieldplans != null) && (!(yieldplans.isEmpty()))) {
      yieldplan = (Yieldplan)yieldplans.get(0);
    }
    YieldsumExample sumeExample = new YieldsumExample();
    sumeExample.createCriteria().andMemberidEqualTo(Integer.valueOf(memberid)).andInvestordercodeEqualTo(investOrderCode);

    Yieldsum yieldsum = null;
    try {
      List yieldsums = this.yieldsumdao.selectByExample(sumeExample);

      if ((yieldsums != null) && (!(yieldsums.isEmpty())))
        yieldsum = (Yieldsum)yieldsums.get(0);
    }
    catch (Exception e) {
      this.logger.error("会员编号: " + memberid + " 合同编号:" + investOrderCode + " 当前日期:" + currentDate);
    }
    if (yieldsum == null)
    {
      this.logger.error("yield sum is null. 会员编号: " + memberid + " 合同编号:" + investOrderCode + " 当前日期:" + currentDate);
    } else if ((DateConverterUtil.areSameDay(yieldsum.getTermdate(), currentDate)) && (String.valueOf(TermStatus.REPAYING.getKey()).equals(yieldsum.getTermstatus())))
    {
      Calendar cal = Calendar.getInstance();
      cal.setTime(yieldsum.getTermdate());
      cal.add(5, 1);
      if (yieldsum.getTermnum() == null) {
        yieldsum.setTermnum(Integer.valueOf(1));
      }
      yieldsum.setTermnum(Integer.valueOf(yieldsum.getTermnum().intValue() + 1));
      yieldsum.setTermdate(cal.getTime());

      yieldsum.setRemainpriamount(yieldplan.getRemainpriamount());
      if (yieldsum.getRepaidamountsum() == null) {
        yieldsum.setRepaidamountsum(BigDecimal.ZERO);
      }

      if (yieldsum.getRepaidinterestsum() == null) {
        yieldsum.setRepaidinterestsum(BigDecimal.ZERO);
      }
      yieldsum.setRepaidamountsum(yieldsum.getRepaidamountsum().add(yieldplan.getAccruedinterest()));

      yieldsum.setRepaidinterestsum(yieldsum.getRepaidinterestsum().add(yieldplan.getAccruedinterest()));

      this.yieldsumdao.updateByPrimaryKeySelective(yieldsum);

      AcctTranDef capitalDef = null;
      AcctTranDef translogDef = null;
      if ((yieldsum.getTranscode() == null) || (yieldsum.getTranscode().equals("0"))) {
        capitalDef = AcctTranDef.REPAY;
        translogDef = AcctTranDef.INTEREST;
      } else if (yieldsum.getTranscode().equals(AcctTranDef.COMMISS_RETURN.getTranCode())) {
        capitalDef = AcctTranDef.COMMISS_RETURN;
        translogDef = AcctTranDef.COMMISS_RETURN;
      }

      PlatformAsset platformAsset = this.platformAssetService.findAsset();

      PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), capitalDef.getTranName(), BidType.MINGXINGBIAO.getKey());

      this.platformAcctService.updateAccountHandle(platformAcct.getAcctid(), yieldplan.getTermamount(), "O");

      MemberAcct memberacct = null;
      MemberAccount memberAccount = null;
      if (capitalDef.getTranCode().equals(AcctTranDef.COMMISS_RETURN.getTranCode())) {
        memberacct = this.memberAcctService.findByMemberIdForUpdate(Long.valueOf(memberid), Integer.valueOf(AcctType.COMMISSION.getKey()));
        memberAccount = this.accountService.getByMemberIdForUpdate(Long.valueOf(memberid));
        BigDecimal commission = yieldplan.getTermamount();
        if (memberacct == null) {
          System.out.println(memberid + ":" + " acct is null ");
        } else if (memberacct.getAccount() == null) {
          System.out.println(memberid + ":" + " memberacct.getAccount() is null ");
        } else if (commission == null) {
          System.out.println(memberid + ":" + " memberacct.getAccount() is null ");
        } else {
          if (commission == BigDecimal.ZERO) {
            commission = BigDecimal.valueOf(0.0D);
            System.out.println(memberid + ":" + " commission is zero ");
          }
          memberacct.setAccount(memberacct.getAccount().add(commission));
          memberacct.setFreezeBlance(memberacct.getFreezeBlance().add(commission));
          memberacct.setModifyDate(new Date());
          this.memberAcctService.save(memberacct);
          memberAccount.setCommisionaccount(memberAccount.getCommisionaccount().add(commission));
          memberAccount.setCommisiontotalaccount(memberAccount.getCommisiontotalaccount().add(commission));
          memberAccount.setModifyDate(new Date());
          this.accountService.save(memberAccount);
        }
      }
      else {
        memberacct = this.memberAcctService.findByMemberIdForUpdate(Long.valueOf(memberid));

        memberacct.setBlance(memberacct.getBlance().add(yieldplan.getTermamount()));

        memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));

        memberacct.setModifyDate(currentDate);
        this.memberAcctService.save(memberacct);

        memberAccount = this.accountService.getByMemberIdForUpdate(Long.valueOf(memberid));

        memberAccount.setBlance(memberAccount.getBlance().add(yieldplan.getTermamount()));

        if (memberAccount.getFreezeBlance() == null) {
          memberAccount.setFreezeBlance(BigDecimal.ZERO);
        }

        if (memberAccount.getRecvincome() == null) {
          memberAccount.setRecvincome(BigDecimal.ZERO);
        }

        memberAccount.setTotalincome(memberAccount.getTotalincome().add(yieldplan.getAccruedinterest()));

        memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

        memberAccount.setModifyDate(currentDate);
        this.accountService.save(memberAccount);
      }
      Member member = this.memberService.findMemberByid(memberid);

      Capitaltrans capitalTrans = new Capitaltrans();
      capitalTrans.setTransno(yieldplan.getInvestordercode());
      capitalTrans.setTranstime(currentDate);

      capitalTrans.setTranstype(Integer.valueOf(capitalDef.getTranCode()));
      if (memberacct == null) {
        System.out.println("会员账户:" + memberid + " 为空.");
        this.logger.error("会员账户:" + memberid + " 为空.");
      } else if (memberacct.getMemberAcctid() == null) {
        capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));

        this.logger.error("会员账户:" + memberid + " memberacct.getMemberAcctid() 为空.");
      } else {
        capitalTrans.setMemberid(Integer.valueOf(memberid));
        capitalTrans.setRealname(member.getRealname());
        capitalTrans.setAmount(yieldplan.getTermamount());
        capitalTrans.setAvailamount(memberAccount.getBlance());

        capitalTrans.setCurrency("CNY");
        capitalTrans.setTransstatus(Integer.valueOf(1));

        capitalTrans.setPayaccountid(platformAcct.getAcctid());
        capitalTrans.setPayaccounttype(Integer.valueOf(1));

        if (memberacct == null)
          System.out.println("会员账户:" + memberid + " 为空.");
        else if (memberacct.getMemberAcctid() == null)
          System.out.println("会员账户:" + memberid + " memberacct.getMemberAcctid() 为空.");
        else {
          capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
        }
        capitalTrans.setPayeename(member.getRealname());
        capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
        capitalTrans.setTransstatus(Integer.valueOf(1));

        List translogList = new ArrayList();
        Translog translog1 = new Translog();
        translog1.setTranstime(capitalTrans.getTranstime());
        translog1.setTranscode(translogDef.getTranCode());
        translog1.setTransdesc(translogDef.getShowName());
        translog1.setAmount(yieldplan.getAccruedinterest());
        translog1.setAvailamount(memberAccount.getBlance());
        translog1.setPlatavailamount(platformAsset.getBlance());
        translog1.setCurrency("CNY");

        translog1.setPayaccountid(platformAcct.getAcctid());
        translog1.setPaysubamount(platformAcct.getBlance());
        translog1.setPayaccounttype(Integer.valueOf(1));
        translog1.setPayername(platformAcct.getAcctName());

        if (memberacct == null) {
          System.out.println("会员账户:" + memberid + " 为空.");
          this.logger.error("会员账户:" + memberid + " 为空.");
        } else if (memberacct.getMemberAcctid() == null) {
          System.out.println("会员账户:" + memberid + " memberacct.getMemberAcctid() 为空.");
          this.logger.error("会员账户:" + memberid + " memberacct.getMemberAcctid() 为空.");
        } else {
          translog1.setPayeeaccountid(memberacct.getMemberAcctid());
        }
        translog1.setPayeememberid(Integer.valueOf(memberid));
        if (memberacct == null) {
          System.out.println("会员账户:" + memberid + " 为空.");
          this.logger.error("会员账户:" + memberid + " 为空.");
        } else if (memberacct.getBlance() == null) {
          System.out.println("会员账户:" + memberid + " memberacct.getBlance() 为空.");
          this.logger.error("会员账户:" + memberid + " memberacct.getBlance() 为空.");
        } else {
          translog1.setPayeesubamount(memberacct.getBlance());
        }
        translog1.setPayeename(member.getRealname());
        translog1.setPayeeaccounttype(Integer.valueOf(0));
        translog1.setTransstatus(Integer.valueOf(1));
        translogList.add(translog1);

        capitalTrans.setTranLogs(translogList);
        this.capitalTransService.add(capitalTrans);
      }
    }
    return 1;
  }

  @Transactional
  public void batchRepay() throws BusinessException {
    batchRepay(new Date());
  }

  @Transactional
  public int batchRepay(Date currentDate) throws BusinessException
  {
    YieldplanExample exam = new YieldplanExample();
    List<Yieldplan>  list = this.yieldplandao.selectByExample(exam);
    if ((list != null) && (!(list.isEmpty()))) {
      for (Yieldplan plan : list) {
        if ((StringUtil.isEmpty(plan.getTermstatus())) || (!(String.valueOf(TermStatus.REPAYED.getKey()).equals(plan.getTermstatus()))))
        {
          if ((plan.getTermdate() == null) && (StringUtil.isEmpty(plan.getTermstatus())))
          {
            this.logger.info("ttf 天天富还款计划:" + plan.getId());
            tiantianRepay(plan.getInvestordercode(), plan.getMemberid().intValue(), currentDate);
          }
          else
          {
            this.logger.info(plan.getId() + "");
            if ((DateConverterUtil.areSameDay(plan.getTermdate(), currentDate)) && (String.valueOf(TermStatus.REPAYING.getKey()).equals(plan.getTermstatus())))
            {
              this.logger.info(plan.getInvestordercode());
              selfRepay(plan.getInvestordercode(), plan.getMemberid().intValue(), currentDate);
            }
          }
        }
      }
    }
    else {
      return 0;
    }
    return 1;
  }

  @Transactional
  public int rolloutTTF(String orderid, String outAmout) throws Exception
  {
    boolean isOver = false;
    Date currentdate = new Date();
    BigDecimal amount = new BigDecimal(outAmout);
    InvestOrder investOrder = this.investorderService.findById(Integer.valueOf(orderid));

    Bid bid = this.bidService.findByBidcode(investOrder.getBidcode());

    YieldplanExample exam = new YieldplanExample();
    YieldplanExample.Criteria criteria = exam.createCriteria();
    criteria.andMemberidEqualTo(Integer.valueOf(investOrder.getCustomerid().intValue()));
    criteria.andInvestordercodeEqualTo(investOrder.getInvestordercode());
    List yieldplans = this.yieldplandao.selectByExample(exam);
    Yieldplan yieldplan = null;
    if ((yieldplans != null) && (!(yieldplans.isEmpty()))) {
      yieldplan = (Yieldplan)yieldplans.get(0);
    }
    YieldsumExample sumeExample = new YieldsumExample();
    sumeExample.createCriteria().andMemberidEqualTo(Integer.valueOf(investOrder.getCustomerid().intValue())).andInvestordercodeEqualTo(investOrder.getInvestordercode());

    Yieldsum yieldsum = null;
    List yieldsums = this.yieldsumdao.selectByExample(sumeExample);
    if ((yieldsums != null) && (!(yieldsums.isEmpty()))) {
      yieldsum = (Yieldsum)yieldsums.get(0);
    }

    BigDecimal oldincome = yieldsum.getTermamount();
    investOrder.setOpdate(currentdate);

    System.out.println("收益汇总-订单编号:" + yieldsum.getInvestordercode());
    System.out.println("收益汇总-剩余本金:" + yieldsum.getRemainpriamount());
    System.out.println("转出金额:" + amount);
    System.out.println("order status:" + investOrder.getOrderstatus());
    if (yieldsum.getRemainpriamount().subtract(amount).doubleValue() == 0.0D) {
      isOver = true;
      System.out.println("全部转出天天富:" + amount);
      System.out.println("order status:" + investOrder.getOrderstatus());
      investOrder.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
      investOrder.setExptincome(BigDecimal.ZERO);
    } else if (yieldsum.getRemainpriamount().subtract(amount).doubleValue() < 0.0D) {
      System.out.println("天天富转出金额不能大于余额!" + amount);
      throw new BusinessException("天天富转出金额不能大于余额! 订单编号:" + yieldsum.getInvestordercode());
    }

    if (isOver) {
      yieldplan.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));

      yieldsum.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
    }

    YieldInfo info = YieldCalcUtil.yieldCalc_asDays(yieldsum.getRemainpriamount().subtract(amount), bid.getAnnualizedrate().divide(new BigDecimal("100")), 365);

    System.out.println("order status:" + investOrder.getOrderstatus());
    this.investorderService.updateOrder(investOrder);

    InvestOrder transOrder = investOrder;
    transOrder.setId(null);
    String investordercode = this.serialService.getSerial("BidOrderNo", null);
    transOrder.setInvestordercode(investordercode);
    transOrder.setAmount(amount);

    transOrder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.TransFered.getKey()));

    transOrder.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
    transOrder.setExptincome(new BigDecimal(0));

    this.investorderService.addOrder(transOrder);

    Investorderhistory history = new Investorderhistory();
    history.setBidcode(investOrder.getBidcode());
    history.setAmount(investOrder.getAmount());
    history.setCustomernickname(investOrder.getCustomernickname());
    history.setCustomername(investOrder.getCustomername());
    history.setOrderdate(currentdate);
    history.setOpdate(currentdate);
    history.setInvestordercode(investOrder.getInvestordercode());
    history.setCustomerid(investOrder.getCustomerid());
    history.setExptincome(investOrder.getExptincome());
    history.setOrderstatus(investOrder.getOrderstatus());
    history.setTransname(investOrder.getTransname());
    history.setTransstatus(investOrder.getTransstatus());
    history.setOrderstatusdesc(investOrder.getOrderstatusdesc());
    history.setApprostatus(investOrder.getApprostatus());
    this.investorderhistoryService.addOrder(history);

    yieldplan.setTermamount(info.getPerTermAmount());
    yieldplan.setAccruedinterest(info.getPerTermAmount());

    yieldplan.setRemainpriamount(yieldplan.getRemainpriamount().subtract(amount));

    yieldsum.setTermamount(info.getPerTermAmount());
    yieldsum.setPrincipalamountsum(yieldsum.getPrincipalamountsum().subtract(amount));

    yieldsum.setRemainpriamount(yieldsum.getRemainpriamount().subtract(amount));

    if (yieldsum.getRepaidamountsum() == null) {
      yieldsum.setRepaidamountsum(BigDecimal.ZERO);
    }
    yieldsum.setRepaidamountsum(yieldsum.getRepaidamountsum().add(amount));

    this.yieldplandao.updateByPrimaryKeySelective(yieldplan);
    this.yieldsumdao.updateByPrimaryKeySelective(yieldsum);

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
      throw new BusinessException("平台资产金额为空,请核查平台资产数据!");
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
      throw new BusinessException("平台资产余额为空,请核查平台资产数据!");
    }
    if (platformAsset.getAccount().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产金额小于转出金额,请核查平台资产数据!");
    }
    platformAsset.setAccount(platformAsset.getAccount().subtract(amount));

    if (platformAsset.getBlance().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产余额小于转出金额,请核查平台资产数据!");
    }
    platformAsset.setBlance(platformAsset.getBlance().subtract(amount));
    platformAsset.setModifyDate(currentdate);
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), null, BidType.MINGXINGBIAO.getKey());

    if (platformAcct.getAccount().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户金额小于转出金额,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(amount));

    if (platformAcct.getBlance().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户余额小于转出金额,请核查平台资产数据!");
    }
    platformAcct.setBlance(platformAcct.getBlance().subtract(amount));
    platformAcct.setModifyDate(currentdate);
    this.platformAcctService.save(platformAcct);

    MemberAcct memberacct = this.memberAcctService.findByMemberIdForUpdate(investOrder.getCustomerid());

    memberacct.setBlance(memberacct.getBlance().add(amount));

    memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));

    memberacct.setModifyDate(currentdate);
    this.memberAcctService.save(memberacct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(investOrder.getCustomerid());

    memberAccount.setBlance(memberAccount.getBlance().add(amount));
    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }
    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().subtract(amount));

    if (memberAccount.getRecvincome() == null) {
      memberAccount.setRecvincome(BigDecimal.ZERO);
    }
    memberAccount.setRecvincome(memberAccount.getRecvincome().subtract(oldincome).add(yieldplan.getAccruedinterest()));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(currentdate);
    this.accountService.save(memberAccount);
    Member member = this.memberService.findMemberByid(investOrder.getCustomerid().longValue());

    MemberProdIncome income = this.memberProdIncomeService.selectBytype(investOrder.getCustomerid().longValue(), bid.getBidtypeid());

    if (income != null) {
      income.setIncome(income.getIncome().subtract(amount).setScale(2, RoundingMode.FLOOR));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
    } else {
      income = new MemberProdIncome();
      income.setMemberid(investOrder.getCustomerid());
      income.setIncome(investOrder.getAmount().setScale(2, RoundingMode.FLOOR));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
      income.setBidclassname(bid.getBidtype());
      income.setCreateDate(new Date());
    }
    this.memberProdIncomeService.addProductIncome(income);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(yieldplan.getInvestordercode());
    capitalTrans.setTranstime(currentdate);

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.REDEM.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(investOrder.getCustomerid().intValue()));
    capitalTrans.setRealname(member.getRealname());
    capitalTrans.setAmount(yieldplan.getTermamount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayaccounttype(Integer.valueOf(1));

    capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
    capitalTrans.setPayeename(member.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.PRINCIPAL.getTranCode());
    translog1.setTransdesc(AcctTranDef.PRINCIPAL.getShowName());
    translog1.setAmount(amount);
    translog1.setAvailamount(memberAccount.getBlance());
    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccountid(platformAcct.getAcctid());
    translog1.setPaysubamount(platformAcct.getBlance());
    translog1.setPayaccounttype(Integer.valueOf(1));
    translog1.setPayername(platformAcct.getAcctName());

    translog1.setPayeeaccountid(memberacct.getMemberAcctid());
    translog1.setPayeememberid(Integer.valueOf(investOrder.getCustomerid().intValue()));
    translog1.setPayeename(member.getRealname());
    translog1.setPayeesubamount(memberacct.getBlance());
    translog1.setPayeeaccounttype(Integer.valueOf(0));
    translog1.setTransstatus(Integer.valueOf(1));
    translogList.add(translog1);

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    return 1;
  }

  @Transactional
  public void deleteByOrderCode(String orderCode) {
    YieldplanExample example = new YieldplanExample();
    example.createCriteria().andInvestordercodeEqualTo(orderCode);
    List<Yieldplan> list = this.yieldplandao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      for (Yieldplan plan : list) {
        this.yieldplandao.deleteByPrimaryKey(plan.getId());
      }
    }
    YieldsumExample yieldsumExample = new YieldsumExample();
    yieldsumExample.createCriteria().andInvestordercodeEqualTo(orderCode);
    List sumlist = this.yieldsumdao.selectByExample(yieldsumExample);
    if ((sumlist != null) && (!(sumlist.isEmpty())))
      this.yieldsumdao.deleteByPrimaryKey(((Yieldsum)sumlist.get(0)).getId());
  }

  @Transactional
  public int rolloutTTF2(Long memberid, String outAmout)
    throws Exception
  {
    boolean isOver = false;
    Date currentdate = new Date();
    BigDecimal amount = new BigDecimal(outAmout);
    InvestOrder sumOrder = this.investorderService.ttfSumOrder(memberid);
    Bid bid = this.bidService.findByBidcode(sumOrder.getBidcode());

    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    BigDecimal ttfamount = this.investorderService.sumTTF(sumOrder.getCustomerid(), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));

    Bid newbid = null;
    List<InvestOrder>  orders = this.investorderService.selectTTFOrder(memberid, desc);

    newbid = this.bidService.findByBidcode(((InvestOrder)orders.get(0)).getBidcode());

    YieldplanExample exam = new YieldplanExample();
    YieldplanExample.Criteria criteria = exam.createCriteria();
    criteria.andMemberidEqualTo(Integer.valueOf(sumOrder.getCustomerid().intValue()));
    criteria.andInvestordercodeEqualTo(sumOrder.getInvestordercode());
    List yieldplans = this.yieldplandao.selectByExample(exam);
    Yieldplan yieldplan = null;
    if ((yieldplans != null) && (!(yieldplans.isEmpty()))) {
      yieldplan = (Yieldplan)yieldplans.get(0);
    }
    YieldsumExample sumeExample = new YieldsumExample();
    sumeExample.createCriteria().andMemberidEqualTo(Integer.valueOf(sumOrder.getCustomerid().intValue())).andInvestordercodeEqualTo(sumOrder.getInvestordercode());

    Yieldsum yieldsum = null;
    List yieldsums = this.yieldsumdao.selectByExample(sumeExample);
    if ((yieldsums != null) && (!(yieldsums.isEmpty()))) {
      yieldsum = (Yieldsum)yieldsums.get(0);
    }
    sumOrder.setOpdate(currentdate);

    if (ttfamount.subtract(amount).doubleValue() == 0.0D) {
      isOver = true;
      sumOrder.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
      sumOrder.setExptincome(BigDecimal.ZERO);
    } else if (ttfamount.subtract(amount).doubleValue() < 0.0D) {
      System.out.println("天天富转出金额不能大于余额!" + amount);
      throw new BusinessException("天天富转出金额不能大于余额! 订单编号:" + yieldsum.getInvestordercode());
    }

    if (isOver) {
      yieldplan.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));

      yieldsum.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
    }

    List desc2 = new ArrayList();
    desc2.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    BigDecimal reciveamount = this.investorderService.sumTTF(sumOrder.getCustomerid(), desc2, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    if (reciveamount != null)
      reciveamount = ttfamount.subtract(reciveamount);
    else {
      reciveamount = ttfamount;
    }

    YieldInfo ttfinfo = YieldCalcUtil.yieldCalc_asDays(ttfamount.subtract(amount), newbid.getAnnualizedrate().divide(new BigDecimal("100")), 365);

    YieldInfo info = null;
    if (reciveamount.compareTo(amount) >= 0)
    {
      info = YieldCalcUtil.yieldCalc_asDays(yieldsum.getPrincipalamountsum(), newbid.getAnnualizedrate().divide(new BigDecimal("100")), 365);
    }
    else {
      info = ttfinfo;
      sumOrder.setAmount(ttfamount.subtract(amount));
      sumOrder.setExptincome(info.getPerTermAmount());

      yieldplan.setRemainpriamount(ttfamount.subtract(amount));
      yieldsum.setPrincipalamountsum(ttfamount.subtract(amount));
      yieldsum.setRemainpriamount(ttfamount.subtract(amount));
    }

    System.out.println("order status:" + sumOrder.getOrderstatus());
    this.investorderService.updateOrder(sumOrder);

    yieldplan.setTermamount(info.getPerTermAmount());
    yieldplan.setAccruedinterest(info.getPerTermAmount());

    yieldsum.setTermamount(info.getPerTermAmount());

    if (yieldsum.getRepaidamountsum() == null) {
      yieldsum.setRepaidamountsum(BigDecimal.ZERO);
    }
    yieldsum.setRepaidamountsum(yieldsum.getRepaidamountsum().add(amount));

    this.yieldplandao.updateByPrimaryKeySelective(yieldplan);
    this.yieldsumdao.updateByPrimaryKeySelective(yieldsum);

    this.yieldCommission.updateCommissionPlanByTiantianfu(yieldplan, yieldsum);
    BigDecimal restMoney;
    if ((orders != null) && (!(orders.isEmpty())))
    {
      restMoney = amount;
      for (InvestOrder order : orders)
      {
        YieldplanExample exam1 = new YieldplanExample();
        YieldplanExample.Criteria criteria1 = exam1.createCriteria();
        criteria1.andMemberidEqualTo(Integer.valueOf(order.getCustomerid().intValue()));
        criteria1.andInvestordercodeEqualTo(order.getInvestordercode());
        List yieldplans1 = this.yieldplandao.selectByExample(exam1);
        Yieldplan yieldplan1 = null;
        if ((yieldplans1 != null) && (!(yieldplans1.isEmpty()))) {
          yieldplan1 = (Yieldplan)yieldplans1.get(0);
        }
        YieldsumExample sumeExample1 = new YieldsumExample();
        sumeExample1.createCriteria().andMemberidEqualTo(Integer.valueOf(order.getCustomerid().intValue())).andInvestordercodeEqualTo(order.getInvestordercode());

        Yieldsum yieldsum1 = null;
        List yieldsums1 = this.yieldsumdao.selectByExample(sumeExample1);
        if ((yieldsums1 != null) && (!(yieldsums1.isEmpty()))) {
          yieldsum1 = (Yieldsum)yieldsums1.get(0);
        }
        order.setOpdate(currentdate);
        if (yieldsum1.getRemainpriamount().subtract(restMoney).doubleValue() >= 0.0D) {
          if (yieldsum1.getRemainpriamount().subtract(restMoney).doubleValue() == 0.0D) {
            order.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
            order.setExptincome(BigDecimal.ZERO);
            yieldplan1.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));

            yieldsum1.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
          }

          insertTransOrder(order, currentdate, restMoney);

          YieldInfo info1 = YieldCalcUtil.yieldCalc_asDays(yieldsum1.getRemainpriamount().subtract(restMoney), newbid.getAnnualizedrate().divide(new BigDecimal("100")), 365);

          yieldplan1.setTermamount(info1.getPerTermAmount());
          yieldplan1.setAccruedinterest(info1.getPerTermAmount());

          yieldplan1.setRemainpriamount(yieldplan1.getRemainpriamount().subtract(restMoney));

          yieldsum1.setTermamount(info1.getPerTermAmount());
          yieldsum1.setPrincipalamountsum(yieldsum1.getPrincipalamountsum().subtract(restMoney));

          yieldsum1.setRemainpriamount(yieldsum1.getRemainpriamount().subtract(restMoney));

          if (yieldsum1.getRepaidamountsum() == null) {
            yieldsum1.setRepaidamountsum(BigDecimal.ZERO);
          }
          yieldsum1.setRepaidamountsum(yieldsum1.getRepaidamountsum().add(restMoney));

          this.yieldplandao.updateByPrimaryKeySelective(yieldplan1);
          this.yieldsumdao.updateByPrimaryKeySelective(yieldsum1);

          this.yieldCommission.updateCommissionPlanByTiantianfu(yieldplan1, yieldsum1);
          break;
        }
        restMoney = restMoney.subtract(yieldsum1.getRemainpriamount());

        insertTransOrder(order, currentdate, yieldsum1.getRemainpriamount());

        yieldplan1.setRemainpriamount(BigDecimal.ZERO);

        yieldsum1.setRemainpriamount(BigDecimal.ZERO);

        if (yieldsum1.getRepaidamountsum() == null) {
          yieldsum1.setRepaidamountsum(BigDecimal.ZERO);
        }
        yieldsum1.setRepaidamountsum(yieldsum1.getRepaidamountsum().add(yieldsum1.getRemainpriamount()));

        this.yieldplandao.updateByPrimaryKeySelective(yieldplan1);
        this.yieldsumdao.updateByPrimaryKeySelective(yieldsum1);

        this.yieldCommission.updateCommissionPlanByTiantianfu(yieldplan1, yieldsum1);
      }

    }

    insertTransOrder(sumOrder, currentdate, amount);

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
      throw new BusinessException("平台资产金额为空,请核查平台资产数据!");
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
      throw new BusinessException("平台资产余额为空,请核查平台资产数据!");
    }
    if (platformAsset.getAccount().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产金额小于转出金额,请核查平台资产数据!");
    }
    platformAsset.setAccount(platformAsset.getAccount().subtract(amount));

    if (platformAsset.getBlance().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产余额小于转出金额,请核查平台资产数据!");
    }
    platformAsset.setBlance(platformAsset.getBlance().subtract(amount));
    platformAsset.setModifyDate(currentdate);
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), null, BidType.MINGXINGBIAO.getKey());

    if (platformAcct.getAccount().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户金额小于转出金额,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(amount));

    if (platformAcct.getBlance().subtract(amount).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户余额小于转出金额,请核查平台资产数据!");
    }
    platformAcct.setBlance(platformAcct.getBlance().subtract(amount));
    platformAcct.setModifyDate(currentdate);
    this.platformAcctService.save(platformAcct);

    MemberAcct memberacct = this.memberAcctService.findByMemberIdForUpdate(sumOrder.getCustomerid());

    memberacct.setBlance(memberacct.getBlance().add(amount));

    memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));

    memberacct.setModifyDate(currentdate);
    this.memberAcctService.save(memberacct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(sumOrder.getCustomerid());

    memberAccount.setBlance(memberAccount.getBlance().add(amount));
    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }
    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().subtract(amount));

    if (memberAccount.getRecvincome() == null) {
      memberAccount.setRecvincome(BigDecimal.ZERO);
    }

    YieldInfo suminfo = YieldCalcUtil.yieldCalc_asDays(ttfamount, newbid.getAnnualizedrate().divide(new BigDecimal("100")), 365);

    YieldInfo restinfo = YieldCalcUtil.yieldCalc_asDays(ttfamount.subtract(amount), newbid.getAnnualizedrate().divide(new BigDecimal("100")), 365);

    memberAccount.setRecvincome(memberAccount.getRecvincome().subtract(suminfo.getPerTermAmount()).add(restinfo.getPerTermAmount()));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(currentdate);
    this.accountService.save(memberAccount);
    Member member = this.memberService.findMemberByid(sumOrder.getCustomerid().longValue());

    MemberProdIncome income = this.memberProdIncomeService.selectBytype(sumOrder.getCustomerid().longValue(), bid.getBidtypeid());

    if (income != null) {
      income.setIncome(income.getIncome().subtract(amount).setScale(2, RoundingMode.FLOOR));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
    } else {
      income = new MemberProdIncome();
      income.setMemberid(sumOrder.getCustomerid());
      income.setIncome(sumOrder.getAmount().setScale(2, RoundingMode.FLOOR));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
      income.setBidclassname(bid.getBidtype());
      income.setCreateDate(new Date());
    }
    this.memberProdIncomeService.addProductIncome(income);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(yieldplan.getInvestordercode());
    capitalTrans.setTranstime(currentdate);

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.REDEM.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(sumOrder.getCustomerid().intValue()));
    capitalTrans.setRealname(member.getRealname());
    capitalTrans.setAmount(yieldplan.getTermamount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayaccounttype(Integer.valueOf(1));

    capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
    capitalTrans.setPayeename(member.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.PRINCIPAL.getTranCode());
    translog1.setTransdesc(AcctTranDef.PRINCIPAL.getShowName());
    translog1.setAmount(amount);
    translog1.setAvailamount(memberAccount.getBlance());
    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccountid(platformAcct.getAcctid());
    translog1.setPaysubamount(platformAcct.getBlance());
    translog1.setPayaccounttype(Integer.valueOf(1));
    translog1.setPayername(platformAcct.getAcctName());

    translog1.setPayeeaccountid(memberacct.getMemberAcctid());
    translog1.setPayeememberid(Integer.valueOf(sumOrder.getCustomerid().intValue()));
    translog1.setPayeename(member.getRealname());
    translog1.setPayeesubamount(memberacct.getBlance());
    translog1.setPayeeaccounttype(Integer.valueOf(0));
    translog1.setTransstatus(Integer.valueOf(1));
    translogList.add(translog1);

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    CpsInvestinfo cpsInvestinfo = this.cpsInvestInfoService.findByMemberid(memberid);
    if ((cpsInvestinfo != null) && (((cpsInvestinfo.getProfitstatus().intValue() == 0) || (cpsInvestinfo.getProfitstatus().intValue() == 1))))
    {
      Bid bid1 = this.bidService.findByBidcode(cpsInvestinfo.getBidcode());
      if (bid1.getBidtypeid().intValue() == BidType.MINGXINGBIAO.getKey()) {
        Cpssettlelog cpssettlelog = this.cpsSettlelogService.findSettlelog(memberid, cpsInvestinfo.getOrderno(), Integer.valueOf(0));
        if ((cpssettlelog != null) && (cpssettlelog.getSettleamount().compareTo(BigDecimal.ZERO) > 0)) {
          AdvchannelInfo advchannelInfo = this.advchannelService.findInfo(cpssettlelog.getChannel());
          Calendar calStart = Calendar.getInstance();
          calStart.setTime(cpssettlelog.getOpdate());
          calStart.set(11, 0);
          calStart.set(12, 0);
          calStart.set(13, 0);
          Calendar calEnd = Calendar.getInstance();
          calEnd.set(11, 0);
          calEnd.set(12, 0);
          calEnd.set(13, 0);
          int term = DateConverterUtil.daysBetween(calStart.getTime(), calEnd.getTime());
          CpsCommissionrate commissionrate = this.cpsCommissionrateService.findCommissionrate(Integer.valueOf(BidType.MINGXINGBIAO.getKey()), null, cpssettlelog.getChannel());
          BigDecimal newcommission = CommissionCalcUtil.ttfCommision(cpssettlelog.getSettleamount(), commissionrate.getCommissionrate(), term);
          cpssettlelog.setCommission(newcommission);
          this.cpsSettlelogService.updatesettlelog(cpssettlelog);
          Cpssettlelog newlog = cpssettlelog;
          newlog.setId(null);
          newlog.setTermnum(Integer.valueOf(cpssettlelog.getTermnum().intValue() + 1));
          BigDecimal settamount = BigDecimal.ZERO;
          if (cpssettlelog.getSettleamount().compareTo(amount) > 0) {
            settamount = cpssettlelog.getSettleamount().subtract(amount);
          }
          Date startdate = calEnd.getTime();
          calEnd.add(2, 1);
          calEnd.set(5, 1);
          List list = CommissionCalcUtil.CommissionCalc(startdate, calEnd.getTime(), advchannelInfo.getCooperiod(), settamount, commissionrate.getCommissionrate(), 0, BidType.MINGXINGBIAO.getKey(), false);
          if ((list != null) && (!(list.isEmpty()))) {
            newlog.setCommission(((Cpssettlelog)list.get(0)).getCommission());
            newlog.setSettledate(((Cpssettlelog)list.get(0)).getSettledate());
          }
          newlog.setSettleamount(settamount);
          newlog.setOpdate(currentdate);
          this.cpsSettlelogService.insertsettlelog(newlog);
        }
      }
    }
    return 1;
  }

  private void insertTransOrder(InvestOrder order, Date currentdate, BigDecimal amount)
  {
    InvestOrder transOrder = order;
    transOrder.setId(null);
    String investordercode = this.serialService.getSerial("BidOrderNo", null);
    transOrder.setInvestordercode(investordercode);

    transOrder.setAmount(amount);
    transOrder.setOrderdate(currentdate);

    transOrder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.TransFered.getKey()));

    transOrder.setOrderstatus(Integer.valueOf(OrderStatus.FINISHED.getKey()));
    transOrder.setExptincome(new BigDecimal(0));
    this.investorderService.addOrder(transOrder);

    Investorderhistory history = new Investorderhistory();
    history.setBidcode(order.getBidcode());
    history.setAmount(order.getAmount());
    history.setCustomernickname(order.getCustomernickname());
    history.setCustomername(order.getCustomername());
    history.setOrderdate(currentdate);
    history.setOpdate(currentdate);
    history.setInvestordercode(order.getInvestordercode());
    history.setCustomerid(order.getCustomerid());
    history.setExptincome(order.getExptincome());
    history.setOrderstatus(order.getOrderstatus());
    history.setTransname(order.getTransname());
    history.setTransstatus(order.getTransstatus());
    history.setOrderstatusdesc(order.getOrderstatusdesc());
    history.setApprostatus(order.getApprostatus());
    this.investorderhistoryService.addOrder(history);
  }
}