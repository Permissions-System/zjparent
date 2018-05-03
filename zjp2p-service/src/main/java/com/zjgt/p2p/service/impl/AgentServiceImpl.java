package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.service.impl.SerialService;
import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.AgentMapper;
import com.zjgt.p2p.dao.InvestOrderMapper;
import com.zjgt.p2p.dao.MemberMapper;
import com.zjgt.p2p.dao.MembersafetyMapper;
import com.zjgt.p2p.model.Agent;
import com.zjgt.p2p.model.AgentExample;
import com.zjgt.p2p.model.AgentExample.Criteria;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.model.MembersafetyExample;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.InvestOrderService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import com.zjgt.p2p.service.PlatformService;
import com.zjgt.util.DateConverterUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentService")
public class AgentServiceImpl
  implements AgentService
{

  @Autowired
  private AgentMapper agentMapper;

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberMapper memberMapper;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private InvestOrderService investOrderService;

  @Autowired
  private InvestOrderMapper investOrderMapper;

  @Autowired
  private MembersafetyMapper membersafetyMapper;

  @Autowired
  private MemberAccountService memberAccountService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private PlatformService platformService;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private SerialService serialService;
  private BigDecimal zeroDef;

  public AgentServiceImpl()
  {
    this.zeroDef = BigDecimal.ZERO;
  }

  @Transactional
  public Translog batchCommissionReturn(Long memberid, BigDecimal accruedInterest, AcctTranDef tran)
  {
    Agent agent = this.agentMapper.selectByInvitee(memberid);
    Translog translog = null;

    BigDecimal commission = this.zeroDef;

    if ((agent != null) && (accruedInterest.compareTo(new BigDecimal("0.1")) > 0)) {
      Long agentid = agent.getMemberid();

      Member midmember = this.memberService.findMemberByid(agentid.longValue());
      if (midmember != null)
      {
        MemberAcct memberAcct = this.memberAcctService.findByMemberIdForUpdate(agentid, Integer.valueOf(AcctType.COMMISSION.getKey()));
        MemberAccount memberAccount = this.memberAccountService.getByMemberIdForUpdate(agentid);
        commission = accruedInterest.multiply(agent.getCommissionrate()).setScale(2, 1);
        if (commission.compareTo(this.zeroDef) < 1) {
          return translog;
        }
        memberAcct.setAccount(memberAcct.getAccount().add(commission));
        memberAcct.setFreezeBlance(memberAcct.getFreezeBlance().add(commission));
        memberAcct.setModifyDate(new Date());
        this.memberAcctService.save(memberAcct);
        memberAccount.setCommisionaccount(memberAccount.getCommisionaccount().add(commission));
        memberAccount.setCommisiontotalaccount(memberAccount.getCommisiontotalaccount().add(commission));
        memberAccount.setModifyDate(new Date());
        this.memberAccountService.save(memberAccount);

        PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(20L));
        this.platformAcctService.updateAccountHandle(Long.valueOf(20L), commission, "O");

        translog = new Translog();
        translog.setTranstime(DateUtils.getCurrentDate());
        translog.setTranscode(AcctTranDef.COMMISS_RETURN.getTranCode());
        translog.setTransdesc(AcctTranDef.COMMISS_RETURN.getShowName());
        translog.setAmount(commission);
        translog.setRemark(tran.getShowName());

        translog.setAvailamount(memberAccount.getBlance());
        translog.setCurrency("CNY");
        translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
        translog.setTransstatus(Integer.valueOf(1));

        translog.setPayaccounttype(Integer.valueOf(1));
        translog.setPaymemberid(null);
        translog.setPayaccountid(platformAcct.getAcctid());
        translog.setPayaccountno(null);
        translog.setPayername(platformAcct.getAcctName());
        translog.setPaycardnum(null);
        translog.setPaysubamount(platformAcct.getBlance());

        translog.setPayeeaccounttype(Integer.valueOf(0));
        translog.setPayeememberid(Integer.valueOf(agentid.intValue()));
        translog.setPayeeaccountid(memberAcct.getMemberAcctid());
        translog.setPayeeaccountno(null);
        translog.setPayeename(midmember.getRealname());
        translog.setPayeecardnum(null);
        translog.setPayeesubamount(memberAccount.getBlance());
      }
    }
    return translog;
  }

  @Transactional
  public int becomeMiddleman(Long memberid)
    throws BusinessException
  {
    MembersafetyExample exam = new MembersafetyExample();
    exam.createCriteria().andMemberidEqualTo(memberid);
    Membersafety membersafety = (Membersafety)this.membersafetyMapper.selectByExample(exam).get(0);
    int authentication = 0;
    authentication += membersafety.getBankcardifverified().intValue();
    authentication += membersafety.getEmailifverified().intValue();
    authentication += membersafety.getIdcardifverified().intValue();
    authentication += membersafety.getMobileifverified().intValue();
    authentication += membersafety.getTranspasswdverified().intValue();

    Map paramMap = new HashMap();
    paramMap.put("pageSize", "4");
    paramMap.put("memberid", memberid);
    int size = this.memberService.getReferralByPage(paramMap).getResult().size();

    MemberAccount memberAccount = this.memberAccountService.getByMemberId(memberid);
    if (authentication < 5) {
      throw new BusinessException("身份没有认证完全");
    }
    if (size < 2) {
      throw new BusinessException("被推荐人不足2人");
    }
    if (memberAccount.getUsedaccount().compareTo(new BigDecimal(3000)) < 0) {
      throw new BusinessException("投资额不足3000");
    }

    if ((authentication >= 5) && (size >= 2) && (memberAccount.getUsedaccount().compareTo(new BigDecimal(3000)) >= 0))
    {
      Agent middleman = new Agent();
      middleman.setIscompany(Integer.valueOf(0));
      middleman.setMemberid(memberid);
      middleman.setLevel(Integer.valueOf(1));
      middleman.setIsMerchant(Integer.valueOf(0));
      middleman.setCommissionrate(new BigDecimal(0.025D));
      this.agentMapper.insertSelective(middleman);
      MemberAcct macct = new MemberAcct();
      macct.setAccount(this.zeroDef);
      macct.setAcctName(AcctType.COMMISSION.getValue());
      macct.setAcctType(Integer.valueOf(AcctType.COMMISSION.getKey()));
      macct.setCreateDate(new Date());
      macct.setBlance(this.zeroDef);
      macct.setMemberid(memberid);
      macct.setModifyDate(new Date());
      macct.setUpdateDate(new Date());
      macct.setMembertype(Integer.valueOf(0));
      this.memberAcctService.save(macct);
      return 1;
    }
    return 0;
  }

  @Transactional
  public void updateMiddlemanLevel()
    throws BusinessException
  {
    updateMiddlemanLevel(new Date());
  }

  @Transactional
  public void updateMiddlemanLevel(Date currentDate) throws BusinessException
  {
    AgentExample example = new AgentExample();

    example.createCriteria().andIscompanyEqualTo(Integer.valueOf(0)).andIsMerchantEqualTo(Integer.valueOf(0));
    List<Agent> middlemanList = this.agentMapper.selectByExample(example);

    BigDecimal investment = this.zeroDef;

    Long memberid = null;

    int day = 0;

    long activeNum = 0L;
    for (Agent middleman : middlemanList) {
      memberid = middleman.getMemberid();
      activeNum = this.memberMapper.getActiveNum(memberid).longValue();
      List<InvestOrder> investOrderList = this.investOrderMapper.getInvestOrderByReferral(memberid);
      for (InvestOrder investOrder : investOrderList) {
        if (DateConverterUtil.isAfter(currentDate, investOrder.getExpiredate()))
          day = DateConverterUtil.daysBetween(investOrder.getOrderdate(), investOrder.getExpiredate());
        else {
          day = DateConverterUtil.daysBetween(investOrder.getOrderdate(), currentDate);
        }
        investment = investment.add(investOrder.getAmount().multiply(new BigDecimal(day)).divide(new BigDecimal(90)));
      }

      if ((activeNum >= 5L) && (investment.divide(new BigDecimal(activeNum)).compareTo(new BigDecimal(3000)) > 0))
      {
        middleman.setLevel(Integer.valueOf(2));
        middleman.setCommissionrate(new BigDecimal(0.05D));
      }
      else {
        middleman.setLevel(Integer.valueOf(1));
        middleman.setCommissionrate(new BigDecimal(0.025D));
      }
      this.agentMapper.updateByPrimaryKeySelective(middleman);
    }
  }

  @Transactional
  public void updateMiddlemanAcct() throws BusinessException
  {
    AgentExample example = new AgentExample();
    List<Agent> middlemanList = this.agentMapper.selectByExample(example);
    Long memberid = null;
    Member member = null;
    MemberAccount memberAccount = null;

    BigDecimal amount = null;

    MemberAcct memberAcct = null;

    MemberAcct memberacct = null;
    for (Agent middleman : middlemanList) {
      memberid = middleman.getMemberid();
      member = this.memberService.findMemberByid(memberid.longValue());

      memberAcct = this.memberAcctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.COMMISSION.getKey()));

      memberacct = this.memberAcctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.BASIC.getKey()));
      amount = memberAcct.getFreezeBlance();
      memberAccount = this.memberAccountService.getByMemberIdForUpdate(memberid);
      if (amount.compareTo(this.zeroDef) > 0)
      {
        memberAcct.setFreezeBlance(this.zeroDef);
        memberAcct.setAccount(this.zeroDef);
        this.memberAcctService.save(memberAcct);

        memberacct.setAccount(memberacct.getAccount().add(amount));
        memberacct.setBlance(memberacct.getBlance().add(amount));
        this.memberAcctService.save(memberacct);

        memberAccount.setBlance(memberAccount.getBlance().add(amount));
        memberAccount.setAccount(memberAccount.getAccount().add(amount));
        memberAccount.setCommisionaccount(this.zeroDef);
        memberAccount.setModifyDate(new Date());
        this.memberAccountService.save(memberAccount);

        Capitaltrans capitalTrans = new Capitaltrans();

        capitalTrans.setTransno(null);
        capitalTrans.setTranstime(new Date());

        capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.COMMISS_APPROP.getTranCode()));
        capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
        capitalTrans.setMemberid(Integer.valueOf(memberid.intValue()));
        capitalTrans.setRealname(member.getRealname());
        capitalTrans.setAmount(amount);

        capitalTrans.setFees(null);
        capitalTrans.setFeerate(null);
        capitalTrans.setRemark(null);

        capitalTrans.setPayaccounttype(Integer.valueOf(0));
        capitalTrans.setPayaccountid(memberAcct.getMemberAcctid());
        capitalTrans.setPayaccountno(null);
        capitalTrans.setPayername(memberAcct.getAcctName());
        capitalTrans.setPaycardnum(null);

        capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
        capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
        capitalTrans.setPayeeaccountno(null);
        capitalTrans.setPayeename(memberacct.getAcctName());
        capitalTrans.setPayeecardnum(null);
        capitalTrans.setTransstatus(Integer.valueOf(1));

        List translogList = new ArrayList();
        Translog translog = new Translog();
        translog.setTranstime(capitalTrans.getTranstime());
        translog.setTranscode(AcctTranDef.COMMISS_APPROP.getTranCode());
        translog.setTransdesc(AcctTranDef.COMMISS_APPROP.getShowName());
        translog.setAmount(amount);
        translog.setAvailamount(memberAccount.getBlance());
        translog.setPlatavailamount(null);
        translog.setCurrency("CNY");

        translog.setPayaccounttype(Integer.valueOf(0));
        translog.setPaymemberid(Integer.valueOf(memberAcct.getMemberid().intValue()));
        translog.setPayaccountid(memberAcct.getMemberAcctid());
        translog.setPaysubamount(memberAcct.getBlance());
        translog.setPayaccountno(null);
        translog.setPayername(memberAcct.getAcctName());
        translog.setPaycardnum(null);

        translog.setPayeeaccounttype(Integer.valueOf(0));
        translog.setPayeememberid(Integer.valueOf(memberacct.getMemberid().intValue()));
        translog.setPayeeaccountid(memberacct.getMemberAcctid());
        translog.setPayeesubamount(memberacct.getBlance());
        translog.setPayeeaccountno(null);
        translog.setPayeename(memberacct.getAcctName());
        translog.setPayeecardnum(null);
        translog.setTransstatus(Integer.valueOf(1));
        translogList.add(translog);
        capitalTrans.setTranLogs(translogList);
        this.capitalTransService.add(capitalTrans);
      }
    }
  }

  public boolean isMiddleman(Long memberid)
  {
    boolean flag = false;
    Agent middleman = this.agentMapper.selectByMemberid(memberid);
    if (middleman != null) {
      flag = true;
    }
    return flag;
  }

  public Agent selectByInvitee(Long memberid)
  {
    return this.agentMapper.selectByInvitee(memberid);
  }

  public Agent selectByMemberid(Long memberid)
  {
    Agent agent = null;
    agent = this.agentMapper.selectByMemberid(memberid);
    return agent;
  }

  public void merchantActivity(Long memberid)
  {
    Agent agent = this.agentMapper.selectByInvitee(memberid);
    if ((agent == null) || (agent.getIsMerchant().intValue() == 0)) {
      return;
    }

    this.platformService.platformToMember(Long.valueOf(20L), agent.getMemberid(), AcctType.COMMISSION.getKey() + "", "3", "用户绑卡金", this.serialService.getSerial("platNo", null), AcctTranDef.MERCHANT_PROMOTION);
  }

  @Transactional
  public void updateMerchantAcct()
    throws BusinessException
  {
    updateMerchantAcct(new Date());
  }

  @Transactional
  public void updateMerchantAcct(Date date) throws BusinessException
  {
    AgentExample example = new AgentExample();
    example.createCriteria().andIsMerchantEqualTo(Integer.valueOf(1));
    List<Agent> middlemanList = this.agentMapper.selectByExample(example);
    Long memberid = null;
    Member member = null;
    MemberAccount memberAccount = null;

    BigDecimal amount = null;

    MemberAcct memberAcct = null;

    MemberAcct memberacct = null;
    for (Agent middleman : middlemanList) {
      memberid = middleman.getMemberid();
      member = this.memberService.findMemberByid(memberid.longValue());

      memberAcct = this.memberAcctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.COMMISSION.getKey()));

      memberacct = this.memberAcctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.BASIC.getKey()));
      amount = memberAcct.getFreezeBlance();
      memberAccount = this.memberAccountService.getByMemberIdForUpdate(memberid);
      if (amount.compareTo(this.zeroDef) > 0)
      {
        memberAcct.setFreezeBlance(this.zeroDef);
        memberAcct.setAccount(this.zeroDef);
        this.memberAcctService.save(memberAcct);

        memberacct.setAccount(memberacct.getAccount().add(amount));
        memberacct.setBlance(memberacct.getBlance().add(amount));
        this.memberAcctService.save(memberacct);

        memberAccount.setBlance(memberAccount.getBlance().add(amount));
        memberAccount.setAccount(memberAccount.getAccount().add(amount));
        memberAccount.setCommisionaccount(this.zeroDef);
        memberAccount.setModifyDate(new Date());
        this.memberAccountService.save(memberAccount);

        Capitaltrans capitalTrans = new Capitaltrans();

        capitalTrans.setTransno(null);
        capitalTrans.setTranstime(new Date());

        capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.COMMISS_APPROP.getTranCode()));
        capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
        capitalTrans.setMemberid(Integer.valueOf(memberid.intValue()));
        capitalTrans.setRealname(member.getRealname());
        capitalTrans.setAmount(amount);

        capitalTrans.setFees(null);
        capitalTrans.setFeerate(null);
        capitalTrans.setRemark(null);

        capitalTrans.setPayaccounttype(Integer.valueOf(0));
        capitalTrans.setPayaccountid(memberAcct.getMemberAcctid());
        capitalTrans.setPayaccountno(null);
        capitalTrans.setPayername(memberAcct.getAcctName());
        capitalTrans.setPaycardnum(null);

        capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
        capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
        capitalTrans.setPayeeaccountno(null);
        capitalTrans.setPayeename(memberacct.getAcctName());
        capitalTrans.setPayeecardnum(null);
        capitalTrans.setTransstatus(Integer.valueOf(1));

        List translogList = new ArrayList();
        Translog translog = new Translog();
        translog.setTranstime(capitalTrans.getTranstime());
        translog.setTranscode(AcctTranDef.COMMISS_APPROP.getTranCode());
        translog.setTransdesc(AcctTranDef.COMMISS_APPROP.getShowName());
        translog.setAmount(amount);
        translog.setAvailamount(memberAccount.getBlance());
        translog.setPlatavailamount(null);
        translog.setCurrency("CNY");

        translog.setPayaccounttype(Integer.valueOf(0));
        translog.setPaymemberid(Integer.valueOf(memberAcct.getMemberid().intValue()));
        translog.setPayaccountid(memberAcct.getMemberAcctid());
        translog.setPaysubamount(memberAcct.getBlance());
        translog.setPayaccountno(null);
        translog.setPayername(memberAcct.getAcctName());
        translog.setPaycardnum(null);

        translog.setPayeeaccounttype(Integer.valueOf(0));
        translog.setPayeememberid(Integer.valueOf(memberacct.getMemberid().intValue()));
        translog.setPayeeaccountid(memberacct.getMemberAcctid());
        translog.setPayeesubamount(memberacct.getBlance());
        translog.setPayeeaccountno(null);
        translog.setPayeename(memberacct.getAcctName());
        translog.setPayeecardnum(null);
        translog.setTransstatus(Integer.valueOf(1));
        translogList.add(translog);
        capitalTrans.setTranLogs(translogList);
        this.capitalTransService.add(capitalTrans);
      }
    }
  }
}