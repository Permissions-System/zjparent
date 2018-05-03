package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.ApproveFlowStep;
import com.zjgt.p2p.common.ApproveMoudle;
import com.zjgt.p2p.common.ApproveStatus;
import com.zjgt.p2p.common.ApproveSubject;
import com.zjgt.p2p.common.BidStatus;
import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.OrderStatus;
import com.zjgt.p2p.common.OrderStatusDesc;
import com.zjgt.p2p.common.OrderTrans;
import com.zjgt.p2p.common.RaiseState;
import com.zjgt.p2p.common.TermStatus;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.BidMapper;
import com.zjgt.p2p.dao.InvestOrderApproveMapper;
import com.zjgt.p2p.dao.InvestOrderMapper;
import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.BidExample;
import com.zjgt.p2p.model.BidExample.Criteria;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.InvestOrderExample;
import com.zjgt.p2p.model.Investorderhistory;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.scheduler.ISchedulerPublishBid;
import com.zjgt.p2p.service.AdvchannelInfoService;
import com.zjgt.p2p.service.AgentService;
import com.zjgt.p2p.service.ApproveService;
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
import com.zjgt.p2p.service.YieldplanService;
import com.zjgt.p2p.service.YieldsumService;
import com.zjgt.p2p.viewbean.InvestOrderAndBid;
import com.zjgt.p2p.viewbean.InvestOrderAndBidExample;
import com.zjgt.p2p.viewbean.InvestOrderApprove;
import com.zjgt.p2p.viewbean.InvestOrderApproveExample;
import com.zjgt.util.CommissionCalcUtil;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.StringUtil;
import com.zjgt.util.YieldCalcUtil;
import com.zjgt.util.YieldInfo;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("investOrderService")
public class InvestOrderServiceImpl
  implements InvestOrderService
{
  private static final String PATTERN = "yyyy-MM-dd";
  Logger logger;

  @Autowired
  private InvestOrderMapper mapper;

  @Autowired
  private InvestOrderApproveMapper investOrderApproveMapper;

  @Autowired
  private MemberService memberservice;

  @Autowired
  private MemberAcctService memberacctservice;

  @Autowired
  private MemberAccountService accountService;

  @Autowired
  private BidService bidService;

  @Autowired
  private InvestOrderHistoryService historyService;

  @Autowired
  private ISerialService serialService;

  @Autowired
  private YieldsumService yieldsumService;

  @Autowired
  private YieldplanService yieldplanService;

  @Autowired
  private YieldBatchTransation batchTransation;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private ApproveService approveService;

  @Autowired
  private MemberProdIncomeService memberProdIncomeService;

  @Autowired
  private ISchedulerPublishBid scheduler;

  @Autowired
  private BonusService bonusService;

  @Autowired
  private BidMapper bidmapper;

  @Autowired
  private AgentService agentService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private YieldCommission yieldCommission;

  @Autowired
  private CpsInvestInfoService cpsInvestInfoService;

  @Autowired
  private CpsCommissionrateService commissionrateService;

  @Autowired
  private CpsRegService cpsRegService;

  @Autowired
  private CpsSettlelogService cpsSettlelogService;

  @Autowired
  private CpsCommissionrateService cpsCommissionrateService;

  @Autowired
  private AdvchannelInfoService advchannelService;

  public InvestOrderServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(InvestOrderServiceImpl.class);
  }

  public com.zjgt.util.Page<InvestOrder> getProductsByPage(Map<String, String> map)
  {
    com.zjgt.util.Page pages = null;

    List orders = null;
    InvestOrderExample exam = new InvestOrderExample();
    InvestOrderExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);
      if (("BidCode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidcodeEqualTo(value);
      }

      if (("CustomerNickName".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andCustomernicknameEqualTo(value);
      }

      if (("CustomerName".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andCustomernameEqualTo(value);
      }

      if (("OrderStatusDesc".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andOrderstatusdescEqualTo(value);
      }

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andOrderstatusEqualTo(Integer.valueOf(value));
      }

      if (("transname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andTransnameEqualTo(value);
      }

      try
      {
        if (("bidstarttime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOrderdateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("bidendtime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOrderdateLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("applystarttime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOpdateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("applyendtime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andOpdateLessThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }
      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }
    int totalCount = this.mapper.getProductsCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);

    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Integer.parseInt((String)map.get("pageSize"))));
    exam.setOrderByClause("orderdate desc");

    orders = this.mapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(orders);
    return pages;
  }

  public int addOrder(InvestOrder order)
  {
    return this.mapper.insertSelective(order);
  }

  public int getCount(InvestOrder order)
  {
    InvestOrderExample exam = new InvestOrderExample();
    InvestOrderExample.Criteria crit = exam.createCriteria();
    if (StringUtil.isNotEmpty(order.getBidcode())) {
      crit.andBidcodeEqualTo(order.getBidcode());
    }

    return (((!(StringUtil.isNotEmpty(order.getTransname()))) || 
      (this.mapper.getProductsCount(exam) == 0)) ? 
      0 : this.mapper.getProductsCount(exam));
  }

  @Transactional
  public int updateOrder(InvestOrder order)
  {
    return this.mapper.updateByPrimaryKeySelective(order);
  }

  public com.zjgt.util.Page<InvestOrderApprove> getInvestOrderApproveByPage(Map<String, String> map)
  {
    com.zjgt.util.Page pages = null;
    List orders = null;
    InvestOrderApproveExample exam = new InvestOrderApproveExample();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("username".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setUsername(value);
      }

      if (("name".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setName(value);
      }

      if (("orderStatusDesc".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setOrderstatusdesc(value);
      }

    }

    int totalCount = (int)this.investOrderApproveMapper.getInvestOrderApproveCount(exam);

    int pageNow = 0;
    if (StringUtil.isEmpty((String)map.get("pageNow")))
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);

    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Integer.parseInt((String)map.get("pageSize"))));

    orders = this.investOrderApproveMapper.getInvestOrderApprove(exam);
    System.out.println("----totalCount--" + totalCount);
    System.out.println("++++size++++" + orders.size());
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(orders);
    return pages;
  }

  public com.zjgt.util.Page<InvestOrderAndBid> getInvestOrderAndBid(Map<String, String> map)
  {
    int pageNow = 0;
    com.zjgt.util.Page pages = null;
    List orders = null;
    InvestOrderAndBidExample exam = new InvestOrderAndBidExample();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        if (value.equals("2")) {
          exam.setOrderstatusdesc(OrderStatusDesc.NORMAL.getKey() + "");

          exam.setOrderstatus(OrderStatus.VALID.getKey() + "");
        }
        if (value.equals("3")) {
          exam.setOrderstatusdesc(OrderStatusDesc.BEWAITED.getKey() + "");
        }

        if (value.equals("4")) {
          exam.setOrderstatusdesc(OrderStatusDesc.BEWAITED.getKey() + "");
        }

        if (value.equals("5")) {
          exam.setOrderstatus(OrderStatus.FINISHED.getKey() + "");
        }
        if (value.equals("0")) {
          exam.setOrderstatusdesc(OrderStatusDesc.REDEEMED.getKey() + "");
        }

        if (value.equals("6")) {
          exam.setOrderstatusdesc(OrderStatusDesc.PreINTEREST.getKey() + "");
        }

      }

      if (("BidType".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        List list = new ArrayList();

        if (!(value.equals("0"))) {
          list.add(value);
          exam.setBidtypeids(list);
        } else {
          list.add("1");
          list.add("2");
          list.add("3");
          exam.setBidtypeids(list);
        }

      }

      if (("memberid".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setMemberid(Integer.parseInt(value));
      }

      if (("bidclassname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setBidclassname(value);
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          exam.setInvestOrderstarttime(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          exam.setInvestOrderendtime(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }

    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    int totalCount = this.mapper.getInvestOrderCount(exam);
    pages = new com.zjgt.util.Page(totalCount, pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Integer.parseInt((String)map.get("pageSize"))));
    orders = this.mapper.getInvestOrderPage(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(orders);
    return pages;
  }

  public InvestOrder findById(Integer id)
  {
    return this.mapper.selectByPrimaryKey(id);
  }

  public InvestOrderApprove getApproveByInvestOrder(Map<String, String> map)
  {
    InvestOrderApprove InvestOrderApprove = null;
    InvestOrderApproveExample exam = new InvestOrderApproveExample();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("id".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setId(value);
      }

      if (("flowstep".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setFlowstep(Integer.valueOf(value));
      }
    }

    InvestOrderApprove = this.investOrderApproveMapper.getInvestOrderApproveByInvestOrder(exam);

    return InvestOrderApprove;
  }

  public void updateApprostatus(int id) {
    InvestOrder io = new InvestOrder();
    io.setId(Integer.valueOf(id));
    io.setOrderstatusdesc("1");
    io.setApprostatus(Integer.valueOf(0));
    io.setTransname("2");
    this.mapper.updateByPrimaryKeySelective(io);
  }

  public List<InvestOrder> getOrderList(String bidcode)
    throws BusinessException
  {
    InvestOrderExample example = new InvestOrderExample();
    InvestOrderExample.Criteria criteria = example.createCriteria();
    criteria.andBidcodeEqualTo(bidcode);
    List investOrders = this.mapper.selectByExample(example);
    return investOrders;
  }

  public List<InvestOrder> getOrderList(String bidcode, int orderstatus)
    throws BusinessException
  {
    InvestOrderExample example = new InvestOrderExample();
    InvestOrderExample.Criteria criteria = example.createCriteria();
    criteria.andBidcodeEqualTo(bidcode);
    criteria.andOrderstatusEqualTo(Integer.valueOf(OrderStatus.VALID.getKey()));
    List investOrders = this.mapper.selectByExample(example);
    return investOrders;
  }

  public InvestOrder getInvestOrderByOrderDate(long id)
  {
    InvestOrderExample exam = new InvestOrderExample();
    exam.createCriteria().andCustomeridEqualTo(Long.valueOf(id));
    exam.setOrderByClause("orderdate desc");
    List investorders = this.mapper.selectByExampleLimit(exam);
    if (investorders.size() == 0) {
      return null;
    }
    return ((InvestOrder)investorders.get(0));
  }

  @Transactional
  public String buyBidOper(String memberid, String id, String bidCode, String buymoney, String memberacctid, YieldInfo info, String investordercode, BigDecimal usebonus)
    throws BusinessException
  {
    int result = 0;
    Bid bidInfo = this.bidService.selectBidForUpdate(Long.valueOf(id).longValue());

    if ((BidStatus.INVESTING.getKey() == bidInfo.getBidstatus().intValue()) || (BidStatus.BADBIDING.getKey() == bidInfo.getBidstatus().intValue()) || (BidStatus.UNFULL.getKey() == bidInfo.getBidstatus().intValue()))
    {
      if (bidInfo.getAmount().subtract(bidInfo.getRaisemoney()).compareTo(new BigDecimal(buymoney)) < 0)
      {
        throw new BusinessException("购买金额大于标的剩余金额!请重新购买操作!"); }
      if (RaiseState.BUYED.getKey() == bidInfo.getRaisestate().intValue()) {
        throw new BusinessException("已满标 ，请关注其他标的新推信息!");
      }
      if (memberid == null) {
        throw new BusinessException("登陆超时,请重新登录!");
      }

      Member member = this.memberservice.findMemberByid(Long.valueOf(memberid).longValue());

      if (member == null) {
        throw new BusinessException("登陆超时或无此用户,请重新登录或注册新用户,重新购买此标!");
      }
      InvestOrder order = new InvestOrder();
      order.setBidcode(bidCode);
      order.setAmount(new BigDecimal(buymoney));
      order.setCustomernickname(member.getNickname());
      order.setCustomername(member.getRealname());
      order.setOrderdate(new Date());
      order.setInvestordercode(investordercode);
      order.setOpdate(new Date());
      order.setCustomerid(Long.valueOf(Long.parseLong(memberid)));
      order.setExptincome(info.getTotalInterest());
      if (usebonus != null) {
        order.setBonusamount(usebonus);
      }

      if (BidType.YUEXIBAO.getKey() == bidInfo.getBidtypeid().intValue()) {
        order.setBonustype(Integer.valueOf(0));
      }
      order.setOrderstatus(Integer.valueOf(OrderStatus.VALID.getKey()));
      order.setTransname(String.valueOf(OrderTrans.BUY.getKey()));
      order.setTransstatus(Integer.valueOf(1));
      order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));

      order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
      int a = addOrder(order);

      Investorderhistory history = insertInvestOrderHistory(order);
      int b = this.historyService.addOrder(history);

      PlatformAsset platAsset = this.platformAssetService.findAsset();
      if (platAsset.getAccount() == null) {
        platAsset.setAccount(BigDecimal.ZERO);
      }
      if (platAsset.getBlance() == null) {
        platAsset.setBlance(BigDecimal.ZERO);
      }
      platAsset.setAccount(platAsset.getAccount().add(new BigDecimal(buymoney)));

      platAsset.setBlance(platAsset.getBlance().add(new BigDecimal(buymoney)));

      platAsset.setModifyDate(new Date());
      this.platformAssetService.save(platAsset);

      PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.DEDUCT.getTranName(), 0);

      platformAcct.setAccount(platformAcct.getAccount().add(new BigDecimal(buymoney)));

      platformAcct.setBlance(platformAcct.getBlance().add(new BigDecimal(buymoney)));

      platformAcct.setModifyDate(new Date());
      this.platformAcctService.save(platformAcct);

      MemberAcct acct = this.memberacctservice.findByacctidForUpdate(Long.valueOf(memberacctid));

      if (acct == null) {
        throw new BusinessException("未建立会员账户,请联系管理员新建会员资金账户!");
      }

      if (acct.getBlance().compareTo(new BigDecimal(buymoney)) < 0) {
        throw new BusinessException("账户余额不能小于购买金额,请充值!");
      }
      acct.setBlance(acct.getBlance().subtract(new BigDecimal(buymoney)));

      acct.setModifyDate(new Date());

      if (acct.getFreezeBlance() == null) {
        acct.setFreezeBlance(BigDecimal.ZERO);
      }
      acct.setFreezeBlance(acct.getFreezeBlance().add(new BigDecimal(buymoney)));

      acct.setFreezeDate(new Date());
      acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
      int c = this.memberacctservice.save(acct);

      MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(Long.valueOf(memberid));

      if (memberAccount == null) {
        throw new BusinessException("未建立会员资产账户,请联系管理员新建会员资产账户!");
      }
      if (memberAccount.getBlance().compareTo(new BigDecimal(buymoney)) < 0)
      {
        throw new BusinessException("账户资产余额不能小于购买金额,请联系管理员咨询!");
      }

      memberAccount.setBlance(memberAccount.getBlance().subtract(new BigDecimal(buymoney)).setScale(2, RoundingMode.FLOOR));

      if (memberAccount.getFreezeBlance() == null) {
        memberAccount.setFreezeBlance(BigDecimal.ZERO);
      }
      memberAccount.setFreezeBlance(memberAccount.getFreezeBlance().add(new BigDecimal(buymoney)));

      memberAccount.setUsedaccount(memberAccount.getUsedaccount().add(new BigDecimal(buymoney)));

      memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

      memberAccount.setModifyDate(new Date());
      this.accountService.save(memberAccount);

      if (bidInfo.getRaisemoney() == null) {
        bidInfo.setRaisemoney(BigDecimal.ZERO);
      }
      bidInfo.setRaisemoney(bidInfo.getRaisemoney().add(new BigDecimal(buymoney)));

      if (bidInfo.getAmount().compareTo(bidInfo.getRaisemoney()) == 0) {
        bidInfo.setBidstatus(Integer.valueOf(BidStatus.INVESTED.getKey()));
        bidInfo.setRaisestate(Integer.valueOf(RaiseState.BUYED.getKey()));
      }
      int d = this.bidService.update(bidInfo);

      Translog bonusTranslog = null;
      if ((usebonus != null) && (usebonus.compareTo(BigDecimal.ZERO) > 0)) {
        bonusTranslog = this.bonusService.tranBonuse(Long.valueOf(memberid), usebonus, AcctTranDef.BONUS_FROZEN);
      }

      MemberProdIncome income = this.memberProdIncomeService.selectBytype(Long.valueOf(memberid).longValue(), bidInfo.getBidtypeid());

      if (income != null) {
        income.setIncome(income.getIncome().add(new BigDecimal(buymoney)).setScale(2, RoundingMode.FLOOR));

        income.setRecvincome(income.getRecvincome().add(info.getTotalInterest()));

        income.setModifyDate(new Date());
        income.setBidtypeid(bidInfo.getBidtypeid());
      } else {
        income = new MemberProdIncome();
        income.setMemberid(Long.valueOf(memberid));
        income.setIncome(new BigDecimal(buymoney).setScale(2, RoundingMode.FLOOR));

        income.setModifyDate(new Date());
        income.setBidtypeid(bidInfo.getBidtypeid());
        income.setBidclassname(bidInfo.getBidtype());
        income.setCreateDate(new Date());
      }
      this.memberProdIncomeService.addProductIncome(income);

      int e = this.batchTransation.generatorYieldplan(order.getInvestordercode(), Integer.valueOf(memberid).intValue(), info, false);

      this.yieldCommission.generatorCommissionPlan(order.getInvestordercode(), Long.valueOf(memberid));

      Capitaltrans capitalTrans = new Capitaltrans();
      capitalTrans.setTransno(order.getInvestordercode());
      capitalTrans.setTranstime(new Date());

      capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.DEDUCT.getTranCode()));

      capitalTrans.setMemberAcctid(Integer.valueOf(memberacctid));
      capitalTrans.setMemberid(Integer.valueOf(memberid));
      capitalTrans.setRealname(member.getRealname());
      capitalTrans.setAmount(new BigDecimal(buymoney));
      capitalTrans.setAvailamount(memberAccount.getBlance());

      capitalTrans.setCurrency("CNY");
      capitalTrans.setTransstatus(Integer.valueOf(1));

      capitalTrans.setPayaccountid(Long.valueOf(memberacctid));
      capitalTrans.setPayername(member.getRealname());
      capitalTrans.setPayaccounttype(Integer.valueOf(0));

      capitalTrans.setPayeeaccountid(platformAcct.getAcctid());
      capitalTrans.setPayeeaccounttype(Integer.valueOf(1));
      capitalTrans.setTransstatus(Integer.valueOf(1));

      List translogList = new ArrayList();

      Translog translog = new Translog();
      translog.setTranstime(capitalTrans.getTranstime());
      translog.setTranscode(AcctTranDef.DEDUCT.getTranCode());
      translog.setTransdesc(AcctTranDef.DEDUCT.getShowName());
      translog.setAmount(new BigDecimal(buymoney));
      translog.setAvailamount(memberAccount.getBlance());
      translog.setPlatavailamount(platAsset.getBlance());
      translog.setCurrency("CNY");

      translog.setPayaccountid(Long.valueOf(memberacctid));
      translog.setPaysubamount(acct.getBlance());
      translog.setPaymemberid(Integer.valueOf(memberid));
      translog.setPayername(member.getRealname());
      translog.setPayaccounttype(Integer.valueOf(0));

      translog.setPayeeaccountid(platformAcct.getAcctid());
      translog.setPayeeaccounttype(Integer.valueOf(1));
      translog.setPayeesubamount(platformAcct.getBlance());
      translog.setPayeename(platformAcct.getAcctName());
      translog.setTransstatus(Integer.valueOf(1));
      translogList.add(translog);

      if (bonusTranslog != null) {
        translogList.add(bonusTranslog);
      }

      capitalTrans.setTranLogs(translogList);
      this.capitalTransService.add(capitalTrans);

      if ((a != 0) && (b != 0) && (c != 0) && (d != 0) && (e != 0))
      {
        this.messageService.sendMessage("message.buybid", Long.valueOf(memberid).longValue(), new String[] { bidInfo.getBidclassname(), buymoney, memberAccount.getBlance().toString() });

        result = 1;
      }
    }
    else {
      throw new BusinessException("该标的:" + bidInfo.getBidcode() + "未发标，已流标或已满标，请关注百富网最新产品!");
    }

    return String.valueOf(result);
  }

  private Investorderhistory insertInvestOrderHistory(InvestOrder order) {
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
    history.setBonusamount(order.getBonusamount());
    history.setBonustype(order.getBonustype());
    return history;
  }

  public Map<String, BigDecimal> redeemNum(String bidcode)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andTransnameEqualTo(String.valueOf(OrderTrans.REDEEM.getKey())).andApprostatusEqualTo(Integer.valueOf(ApproveStatus.APPROVED.getKey())).andBidcodeEqualTo(bidcode);

    Integer num = Integer.valueOf(this.mapper.getProductsCount(example));
    List list = this.mapper.selectByExample(example);
    Double amount = Double.valueOf(0.0D);
    for (int i = 0; i < list.size(); ++i) {
      amount = Double.valueOf(amount.doubleValue() + ((InvestOrder)list.get(i)).getAmount().doubleValue());
    }
    Map map = new HashMap();
    map.put("num", new BigDecimal(num.intValue()).setScale(0, RoundingMode.HALF_UP));
    map.put("amount", new BigDecimal(amount.doubleValue()).setScale(2, RoundingMode.HALF_UP));

    return map;
  }

  public com.zjgt.util.Page<InvestOrderAndBid> getInvestOrderByMember(Map<String, String> map)
  {
    int pageNow = 0;
    com.zjgt.util.Page pages = null;
    List orders = null;
    InvestOrderAndBidExample exam = new InvestOrderAndBidExample();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("OrderStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        if (value.equals("2")) {
          exam.setOrderstatus("1");
        }
        if (value.equals("3")) {
          exam.setOrderstatusdesc("4");
        }
        if (value.equals("4")) {
          exam.setOrderstatusdesc("4");
        }
        if (value.equals("5")) {
          exam.setOrderstatus("0");
        }
        if (value.equals("0")) {
          exam.setOrderstatusdesc("4");
        }

      }

      if (("memberid".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setMemberid(Integer.parseInt(value));
      }

      if (("bidclassname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setBidclassname(value);
      }

      try
      {
        if (("beginTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          exam.setInvestOrderstarttime(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("endTime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          exam.setInvestOrderendtime(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

      }
      catch (ParseException e)
      {
        e.printStackTrace();
      }
    }

    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    int totalCount = this.mapper.getInvestOrderCount(exam);
    pages = new com.zjgt.util.Page(totalCount, pageNow);
    pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Integer.parseInt((String)map.get("pageSize"))));
    orders = this.mapper.getInvestOrderPage(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(orders);
    return pages;
  }

  @Transactional
  public String redeemhandle(String id)
    throws Exception
  {
    InvestOrder order = findById(Integer.valueOf(Integer.parseInt(id)));
    Bid bid = this.bidService.findByBidcode(order.getBidcode());

    Yieldsum yieldsum = this.yieldsumService.findByOrder(order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    Yieldplan yieldplan = this.yieldplanService.findPlan(order.getOpdate(), order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    if (yieldplan == null) {
      yieldplan = new Yieldplan();
      yieldplan.setRemainpriamount(order.getAmount());
      yieldplan.setTermdate(bid.getExptinterestdate());
      yieldplan.setRemaininterest(yieldsum.getRemaininterestsum());
    }

    List listmember = this.memberservice.selectPlatformMember(yieldplan.getRemainpriamount());

    Member member = null;

    if ((listmember != null) && (!(listmember.isEmpty())))
      member = (Member)listmember.get(0);
    else {
      throw new BusinessException("平台自充会员金额不足或未设置平台自充会员!请联系管理员");
    }

    List list = this.yieldplanService.findPlans(order.getOpdate(), order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    BigDecimal redemfee = order.getAmount().multiply(bid.getRedeemfee().divide(new BigDecimal("100.00"))).setScale(2, RoundingMode.FLOOR);

    order.setOpdate(new Date());

    order.setAmount(yieldplan.getRemainpriamount());

    order.setOrderstatus(Integer.valueOf(OrderStatus.UNVALID.getKey()));
    order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.REDEEMED.getKey()));

    updateOrder(order);

    Investorderhistory history = insertInvestOrderHistory(order);
    this.historyService.addOrder(history);

    Approve approve = new Approve();
    approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPROVE.getKey()));
    approve.setModulecode(String.valueOf(ApproveMoudle.REDEEM.getKey()));
    approve.setSubject(String.valueOf(ApproveSubject.AGREE.getKey()));
    approve.setOpdate(new Date());
    approve.setServiceno(order.getInvestordercode());

    Subject subject = SecurityUtils.getSubject();
    ShiroStaff currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroStaff)subject.getPrincipal();
    }
    approve.setStaffNo(currUser.getId());
    approve.setStaffName(currUser.getName());
    this.approveService.addOrder(approve);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date plandate = dateFormat.parse(dateFormat.format(yieldplan.getTermdate()));

    Date orderdate = dateFormat.parse(dateFormat.format(order.getOpdate()));

    YieldInfo yieldinfo = new YieldInfo();
    List listplans = new ArrayList();

    int payedday = DateConverterUtil.daysBetween2(plandate, orderdate);

    BigDecimal totalamount = null;
    BigDecimal totalInterest = null;
    BigDecimal repaidamount = null;
    BigDecimal oldamount = null;
    BigDecimal oldInterest = null;
    BigDecimal platforminterest = null;

    Member oldmember = this.memberservice.findMemberByid(order.getCustomerid().longValue());
    MemberAcct oldacct = this.memberacctservice.findByMemberIdForUpdate(order.getCustomerid());

    for (int i = 0; i < list.size(); ++i) {
      Yieldplan yieldplan2 = new Yieldplan();
      yieldplan2.setTermnum(Integer.valueOf(i + 1));
      yieldplan2.setTermdate(((Yieldplan)list.get(i)).getTermdate());
      yieldplan2.setPrincipalamount(((Yieldplan)list.get(i)).getPrincipalamount());
      yieldplan2.setRemainpriamount(((Yieldplan)list.get(i)).getRemainpriamount());
      yieldplan2.setRemaininterest(((Yieldplan)list.get(i)).getRemaininterest());
      yieldplan2.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));

      if (i == 0) {
        Date nextdate = ((Yieldplan)list.get(i)).getTermdate();

        int unpayday = DateConverterUtil.daysBetween2(orderdate, nextdate);

        BigDecimal intest = YieldCalcUtil.yieldCalc_day(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), payedday, 360);

        BigDecimal intest2 = YieldCalcUtil.yieldCalc_day(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), unpayday, 360);

        if (BidType.YUEXIBAO.getKey() == bid.getBidtypeid().intValue()) {
          intest = YieldCalcUtil.yieldCalc_ttfRedem(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), payedday, 360).subtract(yieldsum.getPrincipalamountsum()).setScale(2, RoundingMode.FLOOR);

          intest2 = YieldCalcUtil.yieldCalc_ttfRedem(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), unpayday, 360).subtract(yieldsum.getPrincipalamountsum()).setScale(2, RoundingMode.FLOOR);
        }

        yieldplan2.setAccruedinterest(intest2);
        yieldplan2.setTermamount(yieldplan2.getPrincipalamount().add(yieldplan2.getAccruedinterest()));

        repaidamount = yieldplan2.getTermamount();
        yieldplan2.setRepaidamount(repaidamount);

        yieldinfo.setFirstRepayAmount(yieldplan2.getTermamount());
        totalInterest = yieldplan2.getAccruedinterest();
        totalamount = yieldplan2.getTermamount();
        oldInterest = ((Yieldplan)list.get(i)).getAccruedinterest();

        ((Yieldplan)list.get(i)).setAccruedinterest(intest);

        ((Yieldplan)list.get(i)).setTermamount(((Yieldplan)list.get(i)).getRemainpriamount().add(((Yieldplan)list.get(i)).getPrincipalamount()).add(((Yieldplan)list.get(i)).getAccruedinterest()));

        ((Yieldplan)list.get(i)).setRemaininterest(BigDecimal.ZERO);
        ((Yieldplan)list.get(i)).setRemainpriamount(BigDecimal.ZERO);
        if (((Yieldplan)list.get(i)).getRepaidamount() == null) {
          ((Yieldplan)list.get(i)).setRepaidamount(BigDecimal.ZERO);
        }
        ((Yieldplan)list.get(i)).setRepaidamount(((Yieldplan)list.get(i)).getRepaidamount().add(((Yieldplan)list.get(i)).getTermamount()));

        ((Yieldplan)list.get(i)).setRepaydate(new Date());
        ((Yieldplan)list.get(i)).setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));

        oldamount = ((Yieldplan)list.get(i)).getTermamount();
        platforminterest = oldInterest.subtract(yieldplan2.getAccruedinterest().add(((Yieldplan)list.get(i)).getAccruedinterest()));

        oldInterest = ((Yieldplan)list.get(i)).getAccruedinterest();
        yieldsum.setTermamount(((Yieldplan)list.get(i)).getTermamount());
        if (yieldsum.getRepaidamountsum() == null) {
          yieldsum.setRepaidamountsum(BigDecimal.ZERO);
        }
        if (yieldsum.getRepaidinterestsum() == null) {
          yieldsum.setRepaidinterestsum(BigDecimal.ZERO);
        }
        yieldsum.setRepaidamountsum(yieldsum.getRepaidamountsum().add(yieldsum.getTermamount()));

        yieldsum.setRepaidinterestsum(yieldsum.getRepaidinterestsum().add(((Yieldplan)list.get(i)).getAccruedinterest()));
      }
      else
      {
        yieldplan2.setAccruedinterest(((Yieldplan)list.get(i)).getAccruedinterest());
        yieldplan2.setTermamount(((Yieldplan)list.get(i)).getTermamount());
        repaidamount = repaidamount.add(((Yieldplan)list.get(i)).getTermamount());
        yieldplan2.setRepaidamount(repaidamount);
        yieldinfo.setPerTermAmount(((Yieldplan)list.get(i)).getTermamount());
        totalamount = totalamount.add(((Yieldplan)list.get(i)).getTermamount());
        totalInterest = totalInterest.add(((Yieldplan)list.get(i)).getAccruedinterest());

        ((Yieldplan)list.get(i)).setTermstatus(String.valueOf(TermStatus.TRANSFER.getKey()));
      }

      listplans.add(yieldplan2);

      this.yieldplanService.update((Yieldplan)list.get(i));

      this.yieldCommission.updateCommissionPlan((Yieldplan)list.get(i));
    }
    yieldinfo.setTotalAmount(totalamount);
    yieldinfo.setTotalInterest(totalInterest);
    yieldinfo.setYieldDtls(listplans);

    yieldsum.setTermdate(order.getOpdate());
    yieldsum.setRemaininterestsum(BigDecimal.ZERO);
    yieldsum.setRemainpriamount(BigDecimal.ZERO);
    this.yieldsumService.update(yieldsum);

    this.yieldCommission.updateCommissionPlan(yieldsum);

    BigDecimal oldacctPri = oldacct.getBlance().add(order.getAmount());

    BigDecimal oldacctfee = oldacctPri.subtract(redemfee);

    BigDecimal oldacctint = oldacct.getBlance().add(oldamount.subtract(redemfee));

    oldacct.setBlance(oldacct.getBlance().add(oldamount.subtract(redemfee)));
    oldacct.setModifyDate(new Date());

    oldacct.setAccount(oldacct.getBlance().add(oldacct.getFreezeBlance()));
    this.memberacctservice.save(oldacct);

    MemberAccount oldAccount = this.accountService.getByMemberIdForUpdate(order.getCustomerid());

    BigDecimal oldacctountPri = oldAccount.getBlance().add(order.getAmount());

    BigDecimal oldaccountfee = oldacctountPri.subtract(redemfee);

    BigDecimal oldaccountint = oldAccount.getBlance().add(oldamount.subtract(redemfee));

    oldAccount.setBlance(oldAccount.getBlance().add(oldamount.subtract(redemfee)));

    if (oldAccount.getFreezeBlance() == null) {
      oldAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    if (oldAccount.getIncome() == null) {
      oldAccount.setIncome(BigDecimal.ZERO);
    }

    if (oldAccount.getIncome().subtract(yieldplan.getRemainpriamount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("原会员的待收本金-剩余本金如果小于0，请核查数据");
    }
    oldAccount.setIncome(oldAccount.getIncome().subtract(yieldplan.getRemainpriamount()));

    if (oldAccount.getRecvincome() == null) {
      oldAccount.setRecvincome(BigDecimal.ZERO);
    }

    if (oldAccount.getRecvincome().subtract(yieldplan.getRemaininterest()).doubleValue() < 0.0D)
    {
      throw new BusinessException("原会员总的待收利息-剩余利息-已收利息小于0，请核查数据");
    }
    oldAccount.setRecvincome(oldAccount.getRecvincome().subtract(yieldplan.getRemaininterest()));

    if (oldAccount.getTotalincome() == null) {
      oldAccount.setTotalincome(BigDecimal.ZERO);
    }
    oldAccount.setTotalincome(oldAccount.getTotalincome().add(oldInterest));

    oldAccount.setAccount(oldAccount.getBlance().add(oldAccount.getFreezeBlance()).add(oldAccount.getIncome()).add(oldAccount.getRecvincome()));

    oldAccount.setModifyDate(new Date());
    this.accountService.save(oldAccount);

    InvestOrder newOrder = new InvestOrder();
    newOrder.setInvestordercode(this.serialService.getSerial("BidOrderNo", null));
    newOrder.setPreordercode(order.getInvestordercode());
    newOrder.setBidcode(order.getBidcode());
    newOrder.setCustomerid(member.getId());
    newOrder.setCustomernickname(member.getNickname());
    newOrder.setCustomername(member.getRealname());
    newOrder.setAmount(order.getAmount());
    newOrder.setExptincome(yieldinfo.getTotalInterest());
    newOrder.setTransname(String.valueOf(OrderTrans.BUY.getKey()));
    newOrder.setTransstatus(Integer.valueOf(2));
    newOrder.setOrderstatus(Integer.valueOf(OrderStatus.VALID.getKey()));
    newOrder.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    newOrder.setOrderdate(new Date());
    newOrder.setOpdate(new Date());
    newOrder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

    addOrder(newOrder);

    Investorderhistory newhistory = insertInvestOrderHistory(newOrder);
    this.historyService.addOrder(newhistory);

    this.batchTransation.generatorYieldplan(newOrder.getInvestordercode(), member.getId().intValue(), yieldinfo, true);

    this.yieldCommission.generatorCommissionPlan(newOrder.getInvestordercode(), member.getId());

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
    }
    platformAsset.setAccount(platformAsset.getAccount().add(redemfee).add(platforminterest));

    platformAsset.setBlance(platformAsset.getBlance().add(redemfee).add(platforminterest));

    platformAsset.setIncome(platformAsset.getIncome().add(redemfee));
    platformAsset.setModifyDate(new Date());
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.REDEM.getTranName(), 0);

    if (platformAcct.getAccount().subtract(oldInterest).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户金额小于应付用户利息,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(oldInterest));

    if (platformAcct.getBlance().subtract(oldInterest).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户余额小于应付用户利息,请核查平台资产数据!");
    }
    platformAcct.setBlance(platformAcct.getBlance().subtract(oldInterest));

    platformAcct.setModifyDate(new Date());
    this.platformAcctService.save(platformAcct);

    PlatformAcct platformAcct2 = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.REDEM_FEE.getTranName(), 0);

    platformAcct2.setAccount(platformAcct2.getAccount().add(redemfee).add(platforminterest));

    platformAcct2.setBlance(platformAcct2.getBlance().add(redemfee).add(platforminterest));

    platformAcct2.setModifyDate(new Date());
    this.platformAcctService.save(platformAcct2);

    MemberAcct acct = this.memberacctservice.findByMemberIdForUpdate(member.getId());

    if (acct.getBlance().subtract(newOrder.getAmount()).doubleValue() < 0.0D) {
      throw new BusinessException("自充会员编号:" + member.getId() + "的余额小于赎回订单金额，请核查数据");
    }

    acct.setBlance(acct.getBlance().subtract(newOrder.getAmount()));
    acct.setModifyDate(new Date());

    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
    this.memberacctservice.save(acct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(member.getId());

    if (memberAccount.getBlance().subtract(newOrder.getAmount()).doubleValue() < 0.0D)
    {
      throw new BusinessException("自充会员编号:" + member.getId() + "的资产余额小于赎回订单金额，请核查数据");
    }

    memberAccount.setBlance(memberAccount.getBlance().subtract(newOrder.getAmount()));

    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    memberAccount.setUsedaccount(memberAccount.getUsedaccount().add(newOrder.getAmount()));

    if (memberAccount.getTotalincome() == null) {
      memberAccount.setTotalincome(BigDecimal.ZERO);
    }

    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().add(yieldinfo.getTotalAmount().subtract(yieldinfo.getTotalInterest())));

    if (memberAccount.getRecvincome() == null) {
      memberAccount.setRecvincome(BigDecimal.ZERO);
    }
    memberAccount.setRecvincome(memberAccount.getRecvincome().add(yieldinfo.getTotalInterest()));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(new Date());
    this.accountService.save(memberAccount);

    MemberProdIncome income = this.memberProdIncomeService.selectBytype(member.getId().longValue(), bid.getBidtypeid());

    if (income != null) {
      income.setIncome(income.getIncome().add(order.getAmount()));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
    } else {
      income = new MemberProdIncome();
      income.setMemberid(member.getId());
      income.setIncome(order.getAmount());

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
      income.setBidclassname(bid.getBidtype());
      income.setCreateDate(new Date());
    }
    this.memberProdIncomeService.addProductIncome(income);

    Translog unfrozenBonusTranslog = null;
    if ((order.getBonusamount() != null) && (order.getBonusamount().compareTo(BigDecimal.ZERO) > 0))
    {
      unfrozenBonusTranslog = this.bonusService.tranBonuse(order.getCustomerid(), order.getBonusamount(), AcctTranDef.BONUS_RANSOM_UNFROZEN);
    }

    Translog commissionTranslog = null;
    commissionTranslog = this.agentService.batchCommissionReturn(Long.valueOf(oldmember.getId().longValue()), oldInterest.subtract(redemfee), AcctTranDef.REDEM);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(newOrder.getInvestordercode());
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.REDEM.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(oldacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(oldmember.getId().intValue()));
    capitalTrans.setRealname(oldmember.getRealname());
    capitalTrans.setAmount(newOrder.getAmount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setFees(redemfee);
    capitalTrans.setFeerate(bid.getRedeemfee());
    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(acct.getMemberAcctid());
    capitalTrans.setPayername(member.getUsername());
    capitalTrans.setPayaccounttype(Integer.valueOf(0));

    capitalTrans.setPayeeaccountid(oldacct.getMemberAcctid());
    capitalTrans.setPayeename(oldmember.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();

    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.PRINCIPAL.getTranCode());
    translog.setTransdesc(AcctTranDef.PRINCIPAL.getShowName());
    translog.setAmount(newOrder.getAmount());
    translog.setAvailamount(oldacctountPri);
    translog.setCurrency("CNY");

    translog.setPayaccountid(acct.getMemberAcctid());
    translog.setPaymemberid(Integer.valueOf(member.getId().intValue()));
    translog.setPayername(member.getUsername());
    translog.setPaysubamount(acct.getBlance());
    translog.setPayaccounttype(Integer.valueOf(0));

    translog.setPayeeaccountid(oldacct.getMemberAcctid());
    translog.setPayeememberid(Integer.valueOf(oldmember.getId().intValue()));
    translog.setPayeename(oldmember.getRealname());
    translog.setPayeesubamount(oldacctPri);
    translog.setPayeeaccounttype(Integer.valueOf(0));
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);

    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.REDEM_FEE.getTranCode());
    translog1.setTransdesc(AcctTranDef.REDEM_FEE.getShowName());
    translog1.setAmount(redemfee);
    translog1.setAvailamount(oldaccountfee);
    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccountid(oldacct.getMemberAcctid());
    translog1.setPaymemberid(Integer.valueOf(oldmember.getId().intValue()));
    translog1.setPayername(oldmember.getRealname());
    translog1.setPaysubamount(oldacctfee);
    translog1.setPayaccounttype(Integer.valueOf(0));

    translog1.setPayeeaccountid(platformAcct2.getAcctid());
    translog1.setPayeeaccounttype(Integer.valueOf(1));
    translog1.setPayeename(platformAcct2.getAcctName());
    translog1.setPayeesubamount(platformAcct2.getBlance());
    translog1.setTransstatus(Integer.valueOf(1));
    translogList.add(translog1);

    Translog translog2 = new Translog();
    translog2.setTranstime(capitalTrans.getTranstime());
    translog2.setTranscode(AcctTranDef.INTEREST.getTranCode());
    translog2.setTransdesc(AcctTranDef.INTEREST.getShowName());
    translog2.setAmount(oldInterest);
    translog2.setAvailamount(oldaccountint);
    translog2.setPlatavailamount(platformAsset.getBlance());
    translog2.setCurrency("CNY");

    translog2.setPayaccountid(platformAcct.getAcctid());
    translog2.setPayaccounttype(Integer.valueOf(1));
    translog2.setPaysubamount(platformAcct.getBlance());
    translog2.setPayername(platformAcct.getAcctName());

    translog2.setPayeeaccountid(oldacct.getMemberAcctid());
    translog2.setPayeememberid(Integer.valueOf(oldmember.getId().intValue()));
    translog2.setPayeesubamount(oldacctint);
    translog2.setPayeename(oldmember.getRealname());
    translog2.setPayeeaccounttype(Integer.valueOf(0));
    translog2.setTransstatus(Integer.valueOf(1));
    translogList.add(translog2);

    if (unfrozenBonusTranslog != null) {
      translogList.add(unfrozenBonusTranslog);
    }

    if (commissionTranslog != null) {
      translogList.add(commissionTranslog);
    }

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    this.messageService.sendMessage("message.redeem.success", order.getCustomerid().longValue(), new String[] { this.bidService.findByBidcode(order.getBidcode()).getBidclassname(), order.getAmount().toString() });
    try
    {
      commisionEnd(order.getInvestordercode(), bid.getBidtypeid());
    } catch (Exception e) {
      this.logger.error("赎回时佣金发生错误" + e);
    }
    return "1";
  }

  private void commisionEnd(String ordercode, Integer bidtype) {
    CpsInvestinfo cpsInvestinfo = this.cpsInvestInfoService.findByOrderCode(ordercode);
    if (cpsInvestinfo != null) {
      List logs = this.cpsSettlelogService.findSettlelogs(cpsInvestinfo.getMemberid(), cpsInvestinfo.getOrderno(), Integer.valueOf(0));
      if ((logs != null) && (!(logs.isEmpty()))) {
        for (int i = 0; i < logs.size(); ++i) {
          if (i == logs.size() - 1) {
            CpsCommissionrate rate = this.commissionrateService.findCommissionrate(bidtype, cpsInvestinfo.getAmount(), cpsInvestinfo.getChannel());

            Calendar cal = Calendar.getInstance();
            cal.setTime(((Cpssettlelog)logs.get(i)).getOpdate());
            cal.set(11, 0);
            cal.set(12, 0);
            cal.set(13, 0);
            Calendar calEnd = Calendar.getInstance();
            calEnd.set(11, 0);
            calEnd.set(12, 0);
            calEnd.set(13, 0);

            if (cal.get(2) != calEnd.get(2)) {
              cal.set(2, calEnd.get(2));
              cal.set(5, 1);
            }
            int term = DateConverterUtil.daysBetween2(cal.getTime(), calEnd.getTime());
            BigDecimal commission = CommissionCalcUtil.yyftCommision(((Cpssettlelog)logs.get(i)).getSettleamount(), rate.getCommissionrate(), term);
            ((Cpssettlelog)logs.get(i)).setCommission(commission);
            cpsInvestinfo.setLastsettledate(((Cpssettlelog)logs.get(i)).getSettledate());
          } else {
            ((Cpssettlelog)logs.get(i)).setSettleamount(BigDecimal.ZERO);
            ((Cpssettlelog)logs.get(i)).setCommission(BigDecimal.ZERO);
            ((Cpssettlelog)logs.get(i)).setSettlestatus(Integer.valueOf(2));
          }
          ((Cpssettlelog)logs.get(i)).setOpdate(new Date());
          this.cpsSettlelogService.updatesettlelog((Cpssettlelog)logs.get(i));
        }
        this.cpsInvestInfoService.updateCpsInfo(cpsInvestinfo);
      }
    }
  }

  public InvestOrder findByOrdercode(String ordercode)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andInvestordercodeEqualTo(ordercode);
    List list = this.mapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((InvestOrder)list.get(0));
    }
    return null;
  }

  @Transactional
  public String buyTransHandle(String memberid, String ordercode, String newInvestOrderCode, String id, Boolean usebonus)
    throws Exception
  {
    Date currentdate = new Date();

    InvestOrder order = findByOrdercode(ordercode);
    Bid bid = this.bidService.selectBidForUpdate(Long.valueOf(id).longValue());

    if (RaiseState.BUYED.getKey() == bid.getRaisestate().intValue()) {
      throw new BusinessException("转让标" + bid.getBidcode() + "已卖完!");
    }

    Yieldsum yieldsum = this.yieldsumService.findByOrder(order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    Yieldplan yieldplan = this.yieldplanService.findPlan(currentdate, order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    List list = this.yieldplanService.findPlans(currentdate, order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

    if (yieldplan == null) {
      yieldplan = new Yieldplan();
      yieldplan.setRemainpriamount(order.getAmount());
      yieldplan.setTermdate(bid.getExptinterestdate());
      yieldplan.setRemaininterest(yieldsum.getRemaininterestsum());
    }

    BigDecimal redemfee = null;
    if (bid.getRedeemfee() != null) {
      redemfee = order.getAmount().multiply(bid.getRedeemfee().divide(new BigDecimal("100.00"))).setScale(2, RoundingMode.FLOOR);
    }

    order.setOpdate(currentdate);

    order.setAmount(yieldplan.getRemainpriamount());

    order.setOrderstatus(Integer.valueOf(OrderStatus.UNVALID.getKey()));
    order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.TRANSFERED.getKey()));

    updateOrder(order);
    Investorderhistory history = insertInvestOrderHistory(order);
    this.historyService.addOrder(history);

    bid.setBidstatus(Integer.valueOf(BidStatus.INVESTED_ACCR.getKey()));
    bid.setRaisestate(Integer.valueOf(RaiseState.BUYED.getKey()));
    bid.setRaisemoney(order.getAmount());
    this.bidService.update(bid);

    Member member = this.memberservice.findMemberByid(Long.valueOf(memberid).longValue());

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date plandate = dateFormat.parse(dateFormat.format(yieldplan.getTermdate()));

    Date orderdate = dateFormat.parse(dateFormat.format(order.getOpdate()));

    YieldInfo yieldinfo = new YieldInfo();
    List listplans = new ArrayList();

    int payedday = DateConverterUtil.daysBetween2(plandate, orderdate);

    BigDecimal totalamount = null;
    BigDecimal totalInterest = null;
    BigDecimal repaidamount = null;
    BigDecimal oldamount = null;
    BigDecimal oldInterest = null;
    BigDecimal platforminterest = null;

    Member oldmember = this.memberservice.findMemberByid(order.getCustomerid().longValue());
    MemberAcct oldacct = this.memberacctservice.findByMemberIdForUpdate(order.getCustomerid());

    MemberAccount oldAccount = this.accountService.getByMemberIdForUpdate(order.getCustomerid());

    for (int i = 0; i < list.size(); ++i) {
      Yieldplan yieldplan2 = new Yieldplan();
      yieldplan2.setTermnum(Integer.valueOf(i + 1));
      yieldplan2.setTermdate(((Yieldplan)list.get(i)).getTermdate());
      yieldplan2.setPrincipalamount(((Yieldplan)list.get(i)).getPrincipalamount());
      yieldplan2.setRemainpriamount(((Yieldplan)list.get(i)).getRemainpriamount());
      yieldplan2.setRemaininterest(((Yieldplan)list.get(i)).getRemaininterest());
      yieldplan2.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));

      if (i == 0) {
        Date nextdate = ((Yieldplan)list.get(i)).getTermdate();

        Calendar cal = Calendar.getInstance();
        cal.setTime(orderdate);
        cal.add(5, 1);
        int unpayday = DateConverterUtil.daysBetween2(cal.getTime(), nextdate);

        BigDecimal intest = YieldCalcUtil.yieldCalc_day(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), payedday, 360);

        BigDecimal intest2 = YieldCalcUtil.yieldCalc_day(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), unpayday, 365);

        if (BidType.YUEXIBAO.getKey() == bid.getBidtypeid().intValue())
        {
          intest = YieldCalcUtil.yieldCalc_ttfRedem(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), payedday, 360).subtract(yieldsum.getPrincipalamountsum()).setScale(2, RoundingMode.FLOOR);

          if (intest.doubleValue() < 0.0D) {
            throw new BusinessException("转让标的" + bid.getBidclassintro() + "的应还利息" + intest + "+为负");
          }

          intest2 = YieldCalcUtil.yieldCalc_ttfRedem(yieldsum.getPrincipalamountsum(), bid.getAnnualizedrate().divide(new BigDecimal("100.00")), unpayday, 360).subtract(yieldsum.getPrincipalamountsum()).setScale(2, RoundingMode.FLOOR);

          if (intest2.doubleValue() < 0.0D) {
            throw new BusinessException("转让标的" + bid.getBidclassintro() + "的利息" + intest2 + "+为负");
          }

        }

        yieldplan2.setAccruedinterest(intest2);
        yieldplan2.setTermamount(yieldplan2.getPrincipalamount().add(yieldplan2.getAccruedinterest()));

        repaidamount = yieldplan2.getTermamount();
        yieldplan2.setRepaidamount(repaidamount);

        yieldinfo.setFirstRepayAmount(yieldplan2.getTermamount());
        totalInterest = yieldplan2.getAccruedinterest();
        totalamount = yieldplan2.getTermamount();
        oldInterest = ((Yieldplan)list.get(i)).getAccruedinterest();

        ((Yieldplan)list.get(i)).setAccruedinterest(intest);

        ((Yieldplan)list.get(i)).setTermamount(((Yieldplan)list.get(i)).getRemainpriamount().add(((Yieldplan)list.get(i)).getPrincipalamount()).add(((Yieldplan)list.get(i)).getAccruedinterest()));

        ((Yieldplan)list.get(i)).setRemaininterest(BigDecimal.ZERO);
        ((Yieldplan)list.get(i)).setRemainpriamount(BigDecimal.ZERO);
        if (((Yieldplan)list.get(i)).getRepaidamount() == null) {
          ((Yieldplan)list.get(i)).setRepaidamount(BigDecimal.ZERO);
        }
        ((Yieldplan)list.get(i)).setRepaidamount(((Yieldplan)list.get(i)).getRepaidamount().add(((Yieldplan)list.get(i)).getTermamount()));

        ((Yieldplan)list.get(i)).setRepaydate(new Date());
        ((Yieldplan)list.get(i)).setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));

        oldamount = ((Yieldplan)list.get(i)).getTermamount();
        platforminterest = oldInterest.subtract(yieldplan2.getAccruedinterest().add(((Yieldplan)list.get(i)).getAccruedinterest()));

        oldInterest = ((Yieldplan)list.get(i)).getAccruedinterest();
        yieldsum.setTermamount(((Yieldplan)list.get(i)).getTermamount());
        if (yieldsum.getRepaidamountsum() == null) {
          yieldsum.setRepaidamountsum(BigDecimal.ZERO);
        }
        if (yieldsum.getRepaidinterestsum() == null) {
          yieldsum.setRepaidinterestsum(BigDecimal.ZERO);
        }
        yieldsum.setRepaidamountsum(yieldsum.getRepaidamountsum().add(yieldsum.getTermamount()));

        yieldsum.setRepaidinterestsum(yieldsum.getRepaidinterestsum().add(((Yieldplan)list.get(i)).getAccruedinterest()));
      }
      else
      {
        yieldplan2.setAccruedinterest(((Yieldplan)list.get(i)).getAccruedinterest());
        yieldplan2.setTermamount(((Yieldplan)list.get(i)).getTermamount());
        repaidamount = repaidamount.add(((Yieldplan)list.get(i)).getTermamount());
        yieldplan2.setRepaidamount(repaidamount);
        yieldinfo.setPerTermAmount(((Yieldplan)list.get(i)).getTermamount());
        totalamount = totalamount.add(((Yieldplan)list.get(i)).getTermamount());
        totalInterest = totalInterest.add(((Yieldplan)list.get(i)).getAccruedinterest());

        ((Yieldplan)list.get(i)).setTermstatus(String.valueOf(TermStatus.TRANSFER.getKey()));
      }

      listplans.add(yieldplan2);

      this.yieldplanService.update((Yieldplan)list.get(i));

      this.yieldCommission.updateCommissionPlan((Yieldplan)list.get(i));
    }
    yieldinfo.setTotalAmount(totalamount);
    yieldinfo.setTotalInterest(totalInterest);
    yieldinfo.setYieldDtls(listplans);

    yieldsum.setTermdate(order.getOpdate());
    yieldsum.setRemaininterestsum(BigDecimal.ZERO);
    yieldsum.setRemainpriamount(BigDecimal.ZERO);
    this.yieldsumService.update(yieldsum);

    this.yieldCommission.updateCommissionPlan(yieldsum);

    BigDecimal bonusTotalInterest = null;

    if (usebonus.booleanValue()) {
      Bid preBid = this.bidService.findByBidcode(order.getBidcode());

      BigDecimal useBonusPreTotalInterest = null;
      BigDecimal annualizedrate = preBid.getAnnualizedrate();
      BigDecimal annualizedrateBd = annualizedrate.divide(new BigDecimal("100")).setScale(4, RoundingMode.FLOOR);
      String repaymentway = preBid.getRepaymentway();
      Date exptinterestdate = preBid.getExptinterestdate();

      BigDecimal buymoney = order.getAmount();

      Integer investperiod = preBid.getInvestperiod();
      String bidtypeid = String.valueOf(preBid.getBidtypeid());

      YieldInfo useBonusPreYieldInfo = YieldCalcUtil.yieldCalc(repaymentway, "M", exptinterestdate, 12, buymoney, annualizedrateBd, investperiod.intValue(), bidtypeid, false);
      useBonusPreTotalInterest = useBonusPreYieldInfo.getTotalInterest();

      annualizedrateBd = annualizedrateBd.add(new BigDecimal("0.005"));

      YieldInfo useBonusAfterYieldInfo = YieldCalcUtil.yieldCalc(repaymentway, "M", exptinterestdate, 12, buymoney, annualizedrateBd, investperiod.intValue(), bidtypeid, false);

      MemberAcct acctBonus = this.memberacctservice.findByMemberIdForUpdate(Long.valueOf(memberid), Integer.valueOf(AcctType.GIFT.getKey()));

      bonusTotalInterest = useBonusAfterYieldInfo.getTotalInterest().subtract(useBonusPreTotalInterest);

      if (acctBonus.getBlance().compareTo(bonusTotalInterest) < 0)
      {
        bonusTotalInterest = acctBonus.getBlance();
      }

      if (yieldinfo.getFirstRepayAmount() != null) {
        yieldinfo.setFirstRepayAmount(yieldinfo.getFirstRepayAmount().add(bonusTotalInterest));
      }
      if (yieldinfo.getPerTermAmount() != null) {
        yieldinfo.setPerTermAmount(yieldinfo.getPerTermAmount().add(bonusTotalInterest));
      }
      if (yieldinfo.getTotalAmount() != null) {
        yieldinfo.setTotalAmount(yieldinfo.getTotalAmount().add(bonusTotalInterest));
      }
      if (yieldinfo.getTotalInterest() != null) {
        yieldinfo.setTotalInterest(yieldinfo.getTotalInterest().add(bonusTotalInterest));
      }
      Yieldplan bonusYieldplan = (Yieldplan)yieldinfo.getYieldDtls().get(0);
      if (bonusYieldplan.getTermamount() != null) {
        bonusYieldplan.setTermamount(bonusYieldplan.getTermamount().add(bonusTotalInterest));
      }
      if (bonusYieldplan.getAccruedinterest() != null) {
        bonusYieldplan.setAccruedinterest(bonusYieldplan.getAccruedinterest().add(bonusTotalInterest));
      }

    }

    BigDecimal oldacctPri = oldacct.getBlance().add(order.getAmount());

    BigDecimal oldacctfee = oldacctPri.subtract(redemfee);

    BigDecimal oldacctint = oldacct.getBlance().add(oldamount.subtract(redemfee));

    oldacct.setBlance(oldacct.getBlance().add(oldamount.subtract(redemfee)));
    oldacct.setModifyDate(new Date());

    oldacct.setAccount(oldacct.getBlance().add(oldacct.getFreezeBlance()));
    this.memberacctservice.save(oldacct);

    BigDecimal oldaccountPri = oldAccount.getBlance().add(order.getAmount());

    BigDecimal oldaccountfee = oldaccountPri.subtract(redemfee);

    BigDecimal oldaccountint = oldAccount.getBlance().add(oldamount.subtract(redemfee));

    oldAccount.setBlance(oldAccount.getBlance().add(oldamount.subtract(redemfee)));

    if (oldAccount.getFreezeBlance() == null) {
      oldAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    if (oldAccount.getIncome() == null) {
      oldAccount.setIncome(BigDecimal.ZERO);
    }
    oldAccount.setIncome(oldAccount.getIncome().subtract(yieldplan.getRemainpriamount()));

    if (oldAccount.getRecvincome() == null) {
      oldAccount.setRecvincome(BigDecimal.ZERO);
    }
    oldAccount.setRecvincome(oldAccount.getRecvincome().subtract(yieldplan.getRemaininterest()));

    if (oldAccount.getTotalincome() == null) {
      oldAccount.setTotalincome(BigDecimal.ZERO);
    }
    oldAccount.setTotalincome(oldAccount.getTotalincome().add(oldInterest));

    oldAccount.setAccount(oldAccount.getBlance().add(oldAccount.getFreezeBlance()).add(oldAccount.getIncome()).add(oldAccount.getRecvincome()));

    oldAccount.setModifyDate(new Date());
    this.accountService.save(oldAccount);

    InvestOrder neworder = new InvestOrder();
    neworder.setBidcode(bid.getBidcode());
    neworder.setAmount(order.getAmount());
    neworder.setCustomernickname(member.getNickname());
    neworder.setCustomername(member.getRealname());
    neworder.setPreordercode(order.getInvestordercode());
    neworder.setOrderdate(currentdate);
    neworder.setInvestordercode(newInvestOrderCode);
    neworder.setOpdate(currentdate);

    if (bonusTotalInterest != null) {
      neworder.setBonusamount(bonusTotalInterest);
    }
    neworder.setCustomerid(Long.valueOf(Long.parseLong(memberid)));
    neworder.setExptincome(yieldinfo.getTotalInterest());

    if (BidType.YUEXIBAO.getKey() == bid.getBidtypeid().intValue()) {
      neworder.setBonustype(Integer.valueOf(0));
    }
    neworder.setOrderstatus(Integer.valueOf(OrderStatus.VALID.getKey()));
    neworder.setTransname(String.valueOf(OrderTrans.BUY.getKey()));
    neworder.setTransstatus(Integer.valueOf(2));
    neworder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

    neworder.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    addOrder(neworder);

    Investorderhistory newhistory = insertInvestOrderHistory(neworder);
    this.historyService.addOrder(newhistory);

    this.batchTransation.generatorYieldplan(neworder.getInvestordercode(), member.getId().intValue(), yieldinfo, true);

    this.yieldCommission.generatorCommissionPlan(neworder.getInvestordercode(), member.getId());

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
    }
    platformAsset.setAccount(platformAsset.getAccount().add(redemfee).add(platforminterest));

    platformAsset.setBlance(platformAsset.getBlance().add(redemfee).add(platforminterest));

    platformAsset.setModifyDate(new Date());
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.REDEM.getTranName(), 0);

    if (platformAcct.getAccount().subtract(oldInterest).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户金额小于应付用户利息,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(oldInterest));

    if (platformAcct.getBlance().subtract(oldInterest).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户余额小于应付用户利息,请核查平台资产数据!");
    }
    platformAcct.setBlance(platformAcct.getBlance().subtract(oldInterest));

    platformAcct.setModifyDate(currentdate);
    this.platformAcctService.save(platformAcct);

    PlatformAcct platformAcct2 = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.REDEM_FEE.getTranName(), 0);

    platformAcct2.setAccount(platformAcct2.getAccount().add(redemfee).add(platforminterest));

    platformAcct2.setBlance(platformAcct2.getBlance().add(redemfee).add(platforminterest));

    platformAcct2.setModifyDate(new Date());
    this.platformAcctService.save(platformAcct2);

    MemberAcct acct = this.memberacctservice.findByMemberIdForUpdate(member.getId());
    if ((acct.getBlance().compareTo(BigDecimal.ZERO) < 0) || (acct.getBlance().compareTo(neworder.getAmount()) < 0))
    {
      throw new BusinessException("会员:" + acct.getMemberid() + "账户余额:" + acct.getBlance() + "小于标的金额:" + neworder.getAmount());
    }

    acct.setBlance(acct.getBlance().subtract(neworder.getAmount()));
    acct.setModifyDate(new Date());

    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));

    this.memberacctservice.save(acct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(member.getId());

    memberAccount.setBlance(memberAccount.getBlance().subtract(neworder.getAmount()));

    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    memberAccount.setUsedaccount(memberAccount.getUsedaccount().add(neworder.getAmount()));

    if (memberAccount.getTotalincome() == null) {
      memberAccount.setTotalincome(BigDecimal.ZERO);
    }

    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().add(yieldinfo.getTotalAmount().subtract(yieldinfo.getTotalInterest())));

    if (memberAccount.getRecvincome() == null) {
      memberAccount.setRecvincome(BigDecimal.ZERO);
    }
    memberAccount.setRecvincome(memberAccount.getRecvincome().add(yieldinfo.getTotalInterest()));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(new Date());
    this.accountService.save(memberAccount);

    MemberProdIncome income = this.memberProdIncomeService.selectBytype(Long.valueOf(memberid).longValue(), bid.getBidtypeid());

    if (income != null) {
      income.setIncome(income.getIncome().add(order.getAmount()));

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
    } else {
      income = new MemberProdIncome();
      income.setMemberid(Long.valueOf(memberid));
      income.setIncome(order.getAmount());

      income.setModifyDate(new Date());
      income.setBidtypeid(bid.getBidtypeid());
      income.setBidclassname(bid.getBidtype());
      income.setCreateDate(new Date());
    }
    this.memberProdIncomeService.addProductIncome(income);

    Translog unfrozenBonusTranslog = null;
    if ((order.getBonusamount() != null) && (order.getBonusamount().compareTo(BigDecimal.ZERO) > 0)) {
      unfrozenBonusTranslog = this.bonusService.tranBonuse(order.getCustomerid(), order.getBonusamount(), AcctTranDef.BONUS_RANSOM_UNFROZEN);
    }

    Translog frozenBonusTranslog = null;
    if ((neworder.getBonusamount() != null) && (neworder.getBonusamount().compareTo(BigDecimal.ZERO) > 0)) {
      frozenBonusTranslog = this.bonusService.tranBonuse(neworder.getCustomerid(), neworder.getBonusamount(), AcctTranDef.BONUS_FROZEN);
    }

    Translog commissionTranslog = null;
    commissionTranslog = this.agentService.batchCommissionReturn(Long.valueOf(oldmember.getId().longValue()), oldInterest.subtract(redemfee), AcctTranDef.REDEM);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(neworder.getInvestordercode());
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.REDEM.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(oldacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(oldmember.getId().intValue()));
    capitalTrans.setRealname(oldmember.getRealname());
    capitalTrans.setAmount(neworder.getAmount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setFees(redemfee);
    capitalTrans.setFeerate(bid.getRedeemfee());
    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(acct.getMemberAcctid());
    capitalTrans.setPayername(member.getUsername());
    capitalTrans.setPayaccounttype(Integer.valueOf(0));

    capitalTrans.setPayeeaccountid(oldacct.getMemberAcctid());
    capitalTrans.setPayeename(oldmember.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.PRINCIPAL.getTranCode());
    translog.setTransdesc(AcctTranDef.PRINCIPAL.getShowName());
    translog.setAmount(neworder.getAmount());
    translog.setAvailamount(oldaccountPri);
    translog.setCurrency("CNY");

    translog.setPayaccountid(acct.getMemberAcctid());
    translog.setPaymemberid(Integer.valueOf(member.getId().intValue()));
    translog.setPayername(member.getUsername());
    translog.setPaysubamount(acct.getBlance());
    translog.setPayaccounttype(Integer.valueOf(0));

    translog.setPayeeaccountid(oldacct.getMemberAcctid());
    translog.setPayeememberid(Integer.valueOf(oldmember.getId().intValue()));
    translog.setPayeename(oldmember.getRealname());
    translog.setPayeesubamount(oldacctPri);
    translog.setPayeeaccounttype(Integer.valueOf(0));
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);

    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.REDEM_FEE.getTranCode());
    translog1.setTransdesc(AcctTranDef.REDEM_FEE.getShowName());
    translog1.setAmount(redemfee);
    translog1.setAvailamount(oldaccountfee);
    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccountid(oldacct.getMemberAcctid());
    translog1.setPaymemberid(Integer.valueOf(oldmember.getId().intValue()));
    translog1.setPayername(oldmember.getRealname());
    translog1.setPaysubamount(oldacctfee);
    translog1.setPayaccounttype(Integer.valueOf(0));

    translog1.setPayeeaccountid(platformAcct2.getAcctid());
    translog1.setPayeeaccounttype(Integer.valueOf(1));
    translog1.setPayeesubamount(platformAcct2.getBlance());
    translog1.setPayeename(platformAcct2.getAcctName());
    translog1.setTransstatus(Integer.valueOf(1));
    translogList.add(translog1);

    Translog translog2 = new Translog();
    translog2.setTranstime(capitalTrans.getTranstime());
    translog2.setTranscode(AcctTranDef.INTEREST.getTranCode());
    translog2.setTransdesc(AcctTranDef.INTEREST.getShowName());
    translog2.setAmount(oldInterest);
    translog2.setAvailamount(oldaccountint);
    translog2.setPlatavailamount(platformAsset.getBlance());
    translog2.setCurrency("CNY");

    translog2.setPayaccountid(platformAcct.getAcctid());
    translog2.setPayaccounttype(Integer.valueOf(1));
    translog2.setPaysubamount(platformAcct.getBlance());
    translog2.setPayername(platformAcct.getAcctName());

    translog2.setPayeeaccountid(oldacct.getMemberAcctid());
    translog2.setPayeememberid(Integer.valueOf(oldmember.getId().intValue()));
    translog2.setPayeename(oldmember.getRealname());
    translog2.setPayeesubamount(oldacctint);
    translog2.setPayeeaccounttype(Integer.valueOf(0));
    translog2.setTransstatus(Integer.valueOf(1));
    translogList.add(translog2);

    if (unfrozenBonusTranslog != null) {
      translogList.add(unfrozenBonusTranslog);
    }
    if (frozenBonusTranslog != null) {
      translogList.add(frozenBonusTranslog);
    }

    if (commissionTranslog != null) {
      translogList.add(commissionTranslog);
    }

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    this.messageService.sendMessage("message.buybid", Long.valueOf(memberid).longValue(), new String[] { this.bidService.findByBidcode(order.getBidcode()).getBidclassname(), order.getAmount().toString(), memberAccount.getBlance().toString() });

    this.messageService.sendMessage("message.redeem.success", order.getCustomerid().longValue(), new String[] { this.bidService.findByBidcode(order.getBidcode()).getBidclassname(), order.getAmount().toString() });
    try
    {
      commisionEnd(ordercode, bid.getBidtypeid());
    } catch (Exception e) {
      this.logger.error("转让标修改佣金计划时发生错误" + e);
    }
    return "1";
  }

  public org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectInvertTrans(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    org.springfk.pancloud.paginator.vo.Page page = new org.springfk.pancloud.paginator.vo.Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));

    paramMap.put("pageObject", page);
    page.setResult(this.mapper.selectInvertTrans(paramMap));
    return page;
  }

  @Transactional
  public void doTransFail(String ordercode) throws BusinessException {
    Date currentdate = new Date();
    InvestOrder order = findByOrdercode(ordercode);

    order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    order.setOpdate(currentdate);
    updateOrder(order);
    Investorderhistory history = new Investorderhistory();
    history.setBidcode(order.getBidcode());
    history.setAmount(order.getAmount());
    history.setCustomernickname(order.getCustomernickname());
    history.setCustomername(order.getCustomername());
    history.setOrderdate(order.getOrderdate());
    history.setInvestordercode(order.getInvestordercode());
    history.setCustomerid(order.getCustomerid());
    history.setOpdate(order.getOpdate());
    history.setOrderstatus(order.getOrderstatus());
    history.setTransname(order.getTransname());
    history.setTransstatus(order.getTransstatus());
    history.setOrderstatusdesc(order.getOrderstatusdesc());
    order.setApprostatus(order.getApprostatus());
    this.historyService.addOrder(history);

    Bid bid = this.bidService.selectByOrdercode(ordercode);
    bid.setBidstatus(Integer.valueOf(BidStatus.BADBID.getKey()));
    this.bidService.update(bid);

    this.messageService.sendMessage("message.redeem.fail", order.getCustomerid().longValue(), new String[] { bid.getBidclassname() });
  }

  public boolean isTransed(String ordercode)
  {
    InvestOrder order = findByOrdercode(ordercode);

    return ((order != null) && (order.getOrderstatus().intValue() == OrderStatus.UNVALID.getKey()) && (String.valueOf(OrderStatusDesc.TRANSFERED.getKey()).equals(order.getOrderstatusdesc())));
  }

  @Transactional
  public String buyTianTianFu(String memberid, String id, String bidCode, String buymoney, String memberacctid, YieldInfo info, String investordercode)
    throws BusinessException
  {
    int aa = 0;
    Bid bidInfo = this.bidService.selectBidForUpdate(Long.valueOf(id).longValue());

    if (bidInfo.getAmount().subtract(bidInfo.getRaisemoney()).compareTo(new BigDecimal(buymoney)) < 0)
    {
      throw new BusinessException("购买金额大于标的剩余金额!请重新购买操作!"); }
    if (RaiseState.BUYED.getKey() == bidInfo.getRaisestate().intValue()) {
      throw new BusinessException("已满标 ，请关注其他标的新推信息!");
    }
    if (memberid == null) {
      throw new BusinessException("登陆超时,请重新登录!");
    }
    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

    BigDecimal oldamount = sumTTF(Long.valueOf(memberid), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));

    InvestOrder ttfSumOrder = ttfSumOrder(Long.valueOf(Long.parseLong(memberid)));

    YieldInfo oldinfo = null;
    List desc3 = new ArrayList();
    desc3.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));

    List preorders = selectTTFOrder(Long.valueOf(Long.parseLong(memberid)), desc3);
    try
    {
      if (oldamount != null)
      {
        Bid bid;
        if (ttfSumOrder != null) {
          bid = this.bidService.findByBidcode(ttfSumOrder.getBidcode());
          oldinfo = YieldCalcUtil.yieldCalc_asDays(oldamount, bid.getAnnualizedrate().divide(new BigDecimal("100")), 365); }
        if ((preorders != null) && (!(preorders.isEmpty()))) {
          bid = this.bidService.findByBidcode(((InvestOrder)preorders.get(0)).getBidcode());
          oldinfo = YieldCalcUtil.yieldCalc_asDays(oldamount, bid.getAnnualizedrate().divide(new BigDecimal("100")), 365);
        }
      }
    } catch (Exception e2) {
      throw new BusinessException();
    }

    Member member = this.memberservice.findMemberByid(Long.valueOf(memberid).longValue());
    InvestOrder order = new InvestOrder();
    order.setBidcode(bidCode);
    order.setAmount(new BigDecimal(buymoney));
    order.setCustomernickname(member.getNickname());
    order.setCustomername(member.getRealname());
    order.setOrderdate(new Date());
    order.setInvestordercode(investordercode);
    order.setOpdate(new Date());
    order.setCustomerid(Long.valueOf(Long.parseLong(memberid)));

    order.setExptincome(info.getTotalInterest());
    order.setOrderstatus(Integer.valueOf(OrderStatus.VALID.getKey()));
    order.setTransname(String.valueOf(OrderTrans.BUY.getKey()));
    order.setTransstatus(Integer.valueOf(1));
    order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));

    order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));

    int a = addOrder(order);
    Investorderhistory history = insertInvestOrderHistory(order);

    int b = this.historyService.addOrder(history);

    BigDecimal reciveIncome = null;

    if (ttfSumOrder == null)
    {
      reciveIncome = info.getPerTermAmount();

      ttfSumOrder = order;
      ttfSumOrder.setId(Integer.valueOf(0));

      ttfSumOrder.setInvestordercode(this.serialService.getSerial("BidOrderNo", null));
      ttfSumOrder.setIfsum(Integer.valueOf(1));
      addOrder(ttfSumOrder);

      Yieldsum sumplan = new Yieldsum();
      sumplan.setTermnum(Integer.valueOf(1));
      sumplan.setMemberid(Integer.valueOf(memberid));
      sumplan.setInvestordercode(ttfSumOrder.getInvestordercode());
      sumplan.setPrincipalamountsum(new BigDecimal(buymoney));
      sumplan.setAccruedinterestsum(info.getPerTermAmount());
      sumplan.setRemainpriamount(new BigDecimal(buymoney));
      sumplan.setTermamount(info.getPerTermAmount());

      Calendar termdate = Calendar.getInstance();
      termdate.set(11, 0);
      termdate.set(12, 0);
      termdate.set(13, 0);
      termdate.set(14, 0);

      termdate.add(5, 2);
      sumplan.setTermdate(termdate.getTime());
      sumplan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
      sumplan.setPaystatus(Integer.valueOf(1));
      this.yieldsumService.addPlan(sumplan);
      List listPlans = info.getYieldDtls();
      Yieldplan yieldplan = null;
      if ((listPlans != null) && (!(listPlans.isEmpty()))) {
        yieldplan = (Yieldplan)listPlans.get(0);
      }
      yieldplan.setMemberid(Integer.valueOf(memberid));
      yieldplan.setInvestordercode(ttfSumOrder.getInvestordercode());
      this.yieldplanService.addPlan(yieldplan);

      this.yieldCommission.generatorCommissionPlan(ttfSumOrder.getInvestordercode(), Long.valueOf(memberid));
    }
    else
    {
      try {
        BigDecimal allamount = sumTTF(Long.valueOf(memberid), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));

        YieldInfo allinfo = YieldCalcUtil.yieldCalc_asDays(allamount, bidInfo.getAnnualizedrate().divide(new BigDecimal("100")), 365);

        reciveIncome = allinfo.getPerTermAmount().subtract(oldinfo.getPerTermAmount());
      } catch (Exception e1) {
        throw new BusinessException();
      }

    }

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
    }
    platformAsset.setAccount(platformAsset.getAccount().add(new BigDecimal(buymoney)));

    platformAsset.setBlance(platformAsset.getBlance().add(new BigDecimal(buymoney)));

    platformAsset.setModifyDate(new Date());
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.DEDUCT.getTranName(), BidType.MINGXINGBIAO.getKey());

    platformAcct.setAccount(platformAcct.getAccount().add(new BigDecimal(buymoney)));

    platformAcct.setBlance(platformAcct.getBlance().add(new BigDecimal(buymoney)));

    platformAcct.setModifyDate(new Date());
    this.platformAcctService.save(platformAcct);

    MemberAcct acct = this.memberacctservice.findByacctidForUpdate(Long.valueOf(memberacctid));

    if (acct.getBlance().compareTo(new BigDecimal(buymoney)) < 0) {
      throw new BusinessException();
    }
    acct.setBlance(acct.getBlance().subtract(new BigDecimal(buymoney)));

    acct.setModifyDate(new Date());

    if (acct.getFreezeBlance() == null) {
      acct.setFreezeBlance(BigDecimal.ZERO);
    }

    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
    int c = this.memberacctservice.save(acct);

    MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(Long.valueOf(memberid));

    memberAccount.setBlance(memberAccount.getBlance().subtract(new BigDecimal(buymoney)).setScale(2, RoundingMode.FLOOR));

    if (memberAccount.getFreezeBlance() == null) {
      memberAccount.setFreezeBlance(BigDecimal.ZERO);
    }

    memberAccount.setUsedaccount(memberAccount.getUsedaccount().add(new BigDecimal(buymoney)));

    if (memberAccount.getIncome() == null) {
      memberAccount.setIncome(BigDecimal.ZERO);
    }
    memberAccount.setIncome(memberAccount.getIncome().add(new BigDecimal(buymoney)).setScale(2, RoundingMode.FLOOR));

    memberAccount.setRecvincome(memberAccount.getRecvincome().add(reciveIncome));

    memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));

    memberAccount.setModifyDate(new Date());
    this.accountService.save(memberAccount);

    if (bidInfo.getRaisemoney() == null) {
      bidInfo.setRaisemoney(BigDecimal.ZERO);
    }
    bidInfo.setRaisemoney(bidInfo.getRaisemoney().add(new BigDecimal(buymoney)));

    if (bidInfo.getAmount().compareTo(bidInfo.getRaisemoney()) == 0) {
      bidInfo.setBidstatus(Integer.valueOf(BidStatus.INVESTED.getKey()));
      bidInfo.setRaisestate(Integer.valueOf(RaiseState.BUYED.getKey()));
    }
    int d = this.bidService.update(bidInfo);

    MemberProdIncome income = this.memberProdIncomeService.selectBytype(Long.valueOf(memberid).longValue(), bidInfo.getBidtypeid());

    if (income != null) {
      income.setIncome(income.getIncome().add(new BigDecimal(buymoney)).setScale(2, RoundingMode.FLOOR));

      income.setRecvincome(income.getRecvincome().add(info.getTotalInterest()));

      income.setModifyDate(new Date());
      income.setBidtypeid(bidInfo.getBidtypeid());
    } else {
      income = new MemberProdIncome();
      income.setMemberid(Long.valueOf(memberid));
      income.setIncome(new BigDecimal(buymoney).setScale(2, RoundingMode.FLOOR));

      income.setModifyDate(new Date());
      income.setBidtypeid(bidInfo.getBidtypeid());
      income.setBidclassname(bidInfo.getBidtype());
      income.setCreateDate(new Date());
    }
    this.memberProdIncomeService.addProductIncome(income);

    Yieldsum sumplan1 = new Yieldsum();
    sumplan1.setTermnum(Integer.valueOf(1));
    sumplan1.setMemberid(Integer.valueOf(memberid));
    sumplan1.setInvestordercode(investordercode);
    sumplan1.setPrincipalamountsum(new BigDecimal(buymoney));
    sumplan1.setAccruedinterestsum(info.getPerTermAmount());
    sumplan1.setRemainpriamount(new BigDecimal(buymoney));
    sumplan1.setTermamount(info.getPerTermAmount());

    Calendar termdate = Calendar.getInstance();
    termdate.set(11, 0);
    termdate.set(12, 0);
    termdate.set(13, 0);
    termdate.set(14, 0);

    termdate.add(5, 2);
    sumplan1.setTermdate(termdate.getTime());
    sumplan1.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
    sumplan1.setPaystatus(Integer.valueOf(1));
    int e = this.yieldsumService.addPlan(sumplan1);
    List listPlans = info.getYieldDtls();
    Yieldplan yieldplan1 = null;
    if ((listPlans != null) && (!(listPlans.isEmpty()))) {
      yieldplan1 = (Yieldplan)listPlans.get(0);
    }
    yieldplan1.setMemberid(Integer.valueOf(memberid));
    yieldplan1.setInvestordercode(investordercode);
    yieldplan1.setTermstatus(String.valueOf(TermStatus.REPAYED.getKey()));
    this.yieldplanService.addPlan(yieldplan1);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(order.getInvestordercode());
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.DEDUCT.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(memberacctid));
    capitalTrans.setMemberid(Integer.valueOf(memberid));
    capitalTrans.setRealname(member.getRealname());
    capitalTrans.setAmount(new BigDecimal(buymoney));
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(Long.valueOf(memberacctid));
    capitalTrans.setPayername(member.getRealname());
    capitalTrans.setPayaccounttype(Integer.valueOf(0));

    capitalTrans.setPayeeaccountid(platformAcct.getAcctid());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(1));
    capitalTrans.setPayeename(platformAcct.getAcctName());
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.DEDUCT.getTranCode());
    translog.setTransdesc(AcctTranDef.DEDUCT.getShowName());
    translog.setAmount(new BigDecimal(buymoney));
    translog.setAvailamount(memberAccount.getBlance());
    translog.setPlatavailamount(platformAsset.getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccountid(Long.valueOf(memberacctid));
    translog.setPaymemberid(Integer.valueOf(memberid));
    translog.setPayername(member.getRealname());
    translog.setPaysubamount(acct.getBlance());
    translog.setPayaccounttype(Integer.valueOf(0));

    translog.setPayeeaccountid(platformAcct.getAcctid());
    translog.setPayeeaccounttype(Integer.valueOf(1));
    translog.setPayeename(platformAcct.getAcctName());
    translog.setPayeesubamount(platformAcct.getBlance());
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    if ((a != 0) && (b != 0) && (c != 0) && (d != 0) && (e != 0))
    {
      this.messageService.sendMessage("message.buybid", Long.valueOf(memberid).longValue(), new String[] { bidInfo.getBidclassname(), buymoney, memberAccount.getBlance().toString() });

      aa = 1;
    }
    return String.valueOf(aa);
  }

  public String tiantianfuIn(BigDecimal money, String ordercode, String inOrOut)
  {
    String aa = "";

    return aa;
  }

  @Transactional
  public int betrans(String id) throws BusinessException {
    int num = 0;
    int orderid = 0;
    try {
      orderid = Integer.parseInt(id);
    } catch (Exception ex) {
      this.logger.error("异常操作,订单编号" + id + "不能为非整型数值!");
    }

    if ((StringUtil.isNotEmpty(id)) && (orderid > 0))
    {
      Date currentdate = new Date();

      InvestOrder order = findById(Integer.valueOf(orderid));
      order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.TRANSFERING.getKey()));

      order.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
      order.setOpdate(currentdate);
      num = updateOrder(order);

      Investorderhistory history = new Investorderhistory();
      history.setBidcode(order.getBidcode());
      history.setAmount(order.getAmount());
      history.setCustomernickname(order.getCustomernickname());
      history.setCustomername(order.getCustomername());
      history.setOrderdate(currentdate);
      history.setInvestordercode(order.getInvestordercode());
      history.setCustomerid(order.getCustomerid());
      history.setExptincome(order.getExptincome());
      history.setOrderstatus(order.getOrderstatus());
      history.setTransname(order.getTransname());
      history.setOrderstatusdesc(order.getOrderstatusdesc());
      history.setOpdate(order.getOpdate());
      this.historyService.addOrder(history);

      Approve approve = new Approve();
      approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPROVE.getKey()));
      approve.setModulecode(String.valueOf(ApproveMoudle.REDEEM.getKey()));
      approve.setSubject(String.valueOf(ApproveSubject.TRANSFER.getKey()));
      approve.setOpdate(currentdate);
      approve.setServiceno(order.getInvestordercode());

      Subject subject = SecurityUtils.getSubject();
      ShiroStaff currUser = null;
      if (subject.isAuthenticated()) {
        currUser = (ShiroStaff)subject.getPrincipal();
      }
      approve.setStaffNo(currUser.getId());
      approve.setStaffName(currUser.getName());
      this.approveService.addOrder(approve);

      Bid bid = this.bidService.selecttransbid(order.getInvestordercode());

      System.out.println("bid trans id:" + bid.getId());

      bid.setId(Integer.valueOf(0));
      bid.setAmount(order.getAmount());
      bid.setRaisemoney(BigDecimal.ZERO);
      bid.setBidclassno(this.serialService.getSerial("BidClassNo", null));
      bid.setBidcode(this.serialService.getSerial("BidNo", null));
      bid.setInvestperiodtypeid(Integer.valueOf(1));

      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Calendar cal = null;
      try {
        cal = Calendar.getInstance();
        cal.setTime(dateFormat.parse(dateFormat.format(currentdate)));
        cal.add(5, 1);
        bid.setInvestperiod(Integer.valueOf(DateConverterUtil.daysBetween2(cal.getTime(), bid.getExptlastacctdate())));
      }
      catch (ParseException e1) {
        throw new BusinessException("日期不正确");
      }
      bid.setPubdate(currentdate);
      bid.setBidstatus(Integer.valueOf(BidStatus.INVESTING.getKey()));
      bid.setRaisestate(Integer.valueOf(RaiseState.BUYING.getKey()));
      this.bidService.addBid(bid);

      Calendar cal2 = Calendar.getInstance();
      cal2.setTime(currentdate);
      cal2.add(5, 3);
      try {
        this.scheduler.dotrans(cal2.getTime(), order.getInvestordercode());
      } catch (SchedulerException e) {
        this.logger.error("调用定时发布异常," + e);
      }
    }
    return num;
  }

  @Transactional
  public String unvalidInvestOrder(Integer id) throws BusinessException
  {
    int aa = 0;

    InvestOrder order = findById(Integer.valueOf(id.intValue()));
    order.setOpdate(new Date());
    order.setOrderstatus(Integer.valueOf(OrderStatus.UNVALID.getKey()));

    Long memberid = order.getCustomerid();
    Member member = this.memberservice.findMemberByid(memberid.longValue());
    MemberAcct memberacct = this.memberacctservice.findByMemberId(memberid);
    MemberAccount memberAccount = this.accountService.getByMemberId(memberid);
    int a = addOrder(order);

    Investorderhistory history = new Investorderhistory();
    history.setBidcode(order.getBidcode());
    history.setAmount(order.getAmount());
    history.setCustomernickname(order.getCustomernickname());
    history.setCustomernickname(member.getNickname());
    history.setCustomername(member.getRealname());
    history.setOrderdate(new Date());
    history.setOpdate(new Date());
    history.setInvestordercode(order.getInvestordercode());
    history.setCustomerid(memberid);
    history.setExptincome(order.getExptincome());
    history.setOrderstatus(Integer.valueOf(OrderStatus.UNVALID.getKey()));
    history.setTransname(String.valueOf(OrderTrans.BUY.getKey()));
    history.setTransstatus(Integer.valueOf(1));
    history.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

    history.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    int b = this.historyService.addOrder(history);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.DEDUCT.getTranName(), 0);

    this.platformAcctService.updateAccountHandle(platformAcct.getAcctid(), order.getAmount(), "O");

    this.accountService.updateAccountHandle(memberid, order.getAmount(), "I", AcctType.BASIC.getKey());

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(order.getInvestordercode());
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.LOSEREFUND.getTranCode()));

    capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(memberid.intValue()));
    capitalTrans.setRealname(member.getRealname());
    capitalTrans.setAmount(order.getAmount());
    capitalTrans.setAvailamount(memberAccount.getBlance());

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayername(platformAcct.getAcctName());
    capitalTrans.setPayaccounttype(Integer.valueOf(1));

    capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
    capitalTrans.setPayeename(member.getRealname());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(0));

    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.LOSEREFUND.getTranCode());
    translog.setTransdesc(AcctTranDef.LOSEREFUND.getShowName());
    translog.setAmount(order.getAmount());
    translog.setAvailamount(memberAccount.getBlance());
    translog.setPlatavailamount(this.platformAssetService.findAsset().getAccount());

    translog.setCurrency("CNY");

    translog.setPayaccountid(platformAcct.getAcctid());
    translog.setPayername(platformAcct.getAcctName());
    translog.setPayaccounttype(Integer.valueOf(1));

    translog.setPayaccountid(memberacct.getMemberAcctid());
    translog.setPaymemberid(Integer.valueOf(memberid.intValue()));
    translog.setPayaccounttype(Integer.valueOf(0));

    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);

    if ((a != 0) && (b != 0)) {
      aa = 1;
    }
    return String.valueOf(aa);
  }

  @Transactional
  public void updateTTFByTime() throws BusinessException {
    updateTTFByTime(new Date());
  }

  @Transactional
  public void updateTTFByTime(Date currentdate) throws BusinessException {
	  List<Bid> list = this.bidService.selectBidByBidtype(Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    Iterator i$;
    if ((list != null) && (!(list.isEmpty())))
      for (i$ = list.iterator(); i$.hasNext(); ) { 
    	  Bid bid = (Bid)i$.next();
        InvestOrderExample example = new InvestOrderExample();
        example.createCriteria().andOrderstatusdescEqualTo(String.valueOf(OrderStatusDesc.PreINTEREST.getKey())).andOrderdateLessThan(currentdate).andBidcodeEqualTo(bid.getBidcode()).andIfsumNotEqualTo(Integer.valueOf(1));

        List<InvestOrder> orders = this.mapper.selectByExample(example);
        if ((orders != null) && (!(orders.isEmpty())))
          for (InvestOrder order : orders) {
            order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

            order.setOpdate(currentdate);
            updateOrder(order);
            Investorderhistory history = insertInvestOrderHistory(order);
            this.historyService.addOrder(history);

            InvestOrder ttfSumOrder = ttfSumOrder(order.getCustomerid());

            if (ttfSumOrder == null) {
              this.logger.info("更新失败，天天富汇总订单用户ID：" + order.getCustomerid());
              return;
            }
            this.logger.info("天天富汇总订单编号：" + ttfSumOrder.getInvestordercode());

            List desc = new ArrayList();
            desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));

            ttfSumOrder.setOpdate(currentdate);
            ttfSumOrder.setBidcode(order.getBidcode());
            ttfSumOrder.setAmount(sumTTF(order.getCustomerid(), desc, bid.getBidtypeid()));

            ttfSumOrder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
            YieldInfo info = null;
            try {
              info = YieldCalcUtil.yieldCalc_asDays(ttfSumOrder.getAmount(), bid.getAnnualizedrate().divide(new BigDecimal("100")), 365);
            }
            catch (Exception e)
            {
              throw new BusinessException();
            }
            ttfSumOrder.setExptincome(info.getTotalInterest());
            updateOrder(ttfSumOrder);

            Yieldsum sumplan = this.yieldsumService.findByOrdercode(ttfSumOrder.getInvestordercode());
            Yieldsum plan1 = this.yieldsumService.findByOrdercode(order.getInvestordercode());
            if (plan1 != null) {
              sumplan.setTermdate(plan1.getTermdate());
            }
            sumplan.setPrincipalamountsum(ttfSumOrder.getAmount());
            sumplan.setAccruedinterestsum(info.getPerTermAmount());
            sumplan.setRemainpriamount(ttfSumOrder.getAmount());
            sumplan.setTermamount(info.getPerTermAmount());
            sumplan.setTermstatus(String.valueOf(TermStatus.REPAYING.getKey()));
            this.yieldsumService.update(sumplan);
            List plans = this.yieldplanService.findByOrderCode(ttfSumOrder.getInvestordercode());
            Yieldplan yieldplan = null;
            if ((plans != null) && (!(plans.isEmpty()))) {
              yieldplan = (Yieldplan)plans.get(0);
            }
            List listPlans = info.getYieldDtls();
            if ((listPlans != null) && (!(listPlans.isEmpty()))) {
              yieldplan.setTermamount(((Yieldplan)listPlans.get(0)).getTermamount());
              yieldplan.setAccruedinterest(((Yieldplan)listPlans.get(0)).getAccruedinterest());
              yieldplan.setRemainpriamount(((Yieldplan)listPlans.get(0)).getRemainpriamount());
              yieldplan.setTermstatus(null);
            }
            this.yieldplanService.update(yieldplan);

            this.yieldCommission.updateCommissionPlanByTiantianfu(yieldplan, sumplan);
          }
      }
    Bid bid;
  }

  public InvestOrder ttfSumOrder(Long memberid)
  {
    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andCustomeridEqualTo(memberid).andOrderstatusdescIn(desc).andIfsumEqualTo(Integer.valueOf(1));
    List list = this.mapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((InvestOrder)list.get(0));
    }
    return null;
  }

  public BigDecimal sumTTF(Long customerid, List<String> orderstatusdesc, Integer bidtypeid)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andCustomeridEqualTo(customerid).andOrderstatusdescIn(orderstatusdesc).andIfsumNotEqualTo(Integer.valueOf(1));
    example.setBidtypeid(bidtypeid);

    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.TransFered.getKey()));
    InvestOrderExample example2 = new InvestOrderExample();
    example2.createCriteria().andCustomeridEqualTo(customerid).andOrderstatusdescIn(desc).andIfsumNotEqualTo(Integer.valueOf(1));
    example2.setBidtypeid(bidtypeid);

    BigDecimal outamount = this.mapper.sumttf(example2);

    if (this.mapper.sumttf(example) == null) {
      return null;
    }
    return ((outamount == null) ? this.mapper.sumttf(example) : this.mapper.sumttf(example).subtract(outamount));
  }

  public BigDecimal sumTTFIncome(Long customerid, String orderstatusdesc, Integer bidtypeid)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andCustomeridEqualTo(customerid).andOrderstatusdescEqualTo(orderstatusdesc).andIfsumNotEqualTo(Integer.valueOf(1));
    example.setBidtypeid(bidtypeid);
    return this.mapper.sumttfincome(example);
  }

  public List<InvestOrder> selectTTFOrder(Long customerid, List<String> orderstatusdesc)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andCustomeridEqualTo(customerid).andOrderstatusdescIn(orderstatusdesc).andIfsumNotEqualTo(Integer.valueOf(1));
    example.setBidtypeid(Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    return this.mapper.selectTTFOrder(example);
  }

  public org.springfk.pancloud.paginator.vo.Page<InvestOrder> selectInvestOrderByPage(Map<String, String> map)
  {
    BidExample exam = new BidExample();
    exam.createCriteria().andBidtypeidEqualTo(Integer.valueOf(4));
    List<Bid> bids = this.bidmapper.selectByExample(exam);
    List bidcodes = new ArrayList();
    if ((bids != null) && (bids.size() != 0)) {
      for (Bid b : bids) {
        bidcodes.add(b.getBidcode());
      }

      int pageNow = 0;
      org.springfk.pancloud.paginator.vo.Page pages = null;
      InvestOrderExample ioexam = new InvestOrderExample();
      InvestOrderExample.Criteria crit = ioexam.createCriteria();
      InvestOrderExample.Criteria crit1 = ioexam.createCriteria();
      List list = new ArrayList();
      Iterator i = map.entrySet().iterator();
      while (i.hasNext()) {
        Map.Entry entry = (Map.Entry)i.next();
        String key = (String)entry.getKey();
        String value = (String)map.get(key);
        if (("orderStatusDesc".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          if (value.equals("0")) {
            list.add(OrderStatusDesc.PreINTEREST.getKey() + "");
            list.add(OrderStatusDesc.NORMAL.getKey() + "");
            crit.andOrderstatusdescIn(list);
            crit1.andOrderstatusdescEqualTo(OrderStatusDesc.TransFered.getKey() + "");
            crit.andBidcodeIn(bidcodes);
            crit1.andBidcodeIn(bidcodes);
            crit.andCustomeridEqualTo(Long.valueOf(Long.parseLong((String)map.get("memberid"))));
            crit1.andCustomeridEqualTo(Long.valueOf(Long.parseLong((String)map.get("memberid"))));
            crit.andIfsumEqualTo(Integer.valueOf(0));
            crit1.andIfsumEqualTo(Integer.valueOf(1));
            if (map.get("pageNow") == null)
              pageNow = 1;
            else {
              pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
            }
            pages = new org.springfk.pancloud.paginator.vo.Page();
            pages.setPageNo(pageNow);
            pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
            ioexam.setPage(pages);
            ioexam.setOrderByClause("orderdate DESC");
            ioexam.or(crit1);
            pages.setResult(this.mapper.selectByExample(ioexam));
            return pages;
          }
          if (value.equals("1")) {
            list.add(OrderStatusDesc.PreINTEREST.getKey() + "");
            list.add(OrderStatusDesc.NORMAL.getKey() + "");
            crit.andOrderstatusdescIn(list);
            crit.andIfsumEqualTo(Integer.valueOf(0));
          }
          if (value.endsWith("2")) {
            list.add(OrderStatusDesc.TransFered.getKey() + "");
            crit.andOrderstatusdescIn(list);
            crit.andIfsumEqualTo(Integer.valueOf(1));
          }
        }

        if (("memberid".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andCustomeridEqualTo(Long.valueOf(Long.parseLong(value)));
        }
      }

      crit.andBidcodeIn(bidcodes);
      if (map.get("pageNow") == null)
        pageNow = 1;
      else {
        pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
      }
      pages = new org.springfk.pancloud.paginator.vo.Page();
      pages.setPageNo(pageNow);
      pages.setPageSize(Integer.parseInt((String)map.get("pageSize")));
      ioexam.setPage(pages);
      ioexam.setOrderByClause("orderdate DESC");
      pages.setResult(this.mapper.selectByExample(ioexam));
      return pages;
    }
    return null;
  }

  public org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectOrderBySettle(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    org.springfk.pancloud.paginator.vo.Page page = new org.springfk.pancloud.paginator.vo.Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));

    paramMap.put("pageObject", page);
    page.setResult(this.mapper.selectOrderBySettle(paramMap));
    return page;
  }

  public org.springfk.pancloud.paginator.vo.Page<Map<String, Object>> selectRepayBySettle(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)paramMap.get("pageNow")).intValue();
    }
    org.springfk.pancloud.paginator.vo.Page page = new org.springfk.pancloud.paginator.vo.Page(pageNow, Integer.parseInt((String)paramMap.get("pageSize")));

    paramMap.put("pageObject", page);
    page.setResult(this.mapper.selectRepayBySettle(paramMap));
    return page;
  }

  public boolean isFirstInvest(Long memberid)
  {
    InvestOrderExample example = new InvestOrderExample();
    example.createCriteria().andCustomeridEqualTo(memberid);
    List list = this.mapper.selectByExample(example);

    return ((list == null) || (list.isEmpty()));
  }
}