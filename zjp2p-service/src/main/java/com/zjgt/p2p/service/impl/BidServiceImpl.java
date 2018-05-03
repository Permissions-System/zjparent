package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.common.ApproveFlowStep;
import com.zjgt.p2p.common.ApproveMoudle;
import com.zjgt.p2p.common.ApproveStatus;
import com.zjgt.p2p.common.ApproveSubject;
import com.zjgt.p2p.common.BidStatus;
import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.BorrowStatus;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.OrderStatus;
import com.zjgt.p2p.common.OrderStatusDesc;
import com.zjgt.p2p.common.RaiseState;
import com.zjgt.p2p.common.RepaymentWay;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.BidApproveMapper;
import com.zjgt.p2p.dao.BidMapper;
import com.zjgt.p2p.model.AdvchannelInfo;
import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.BidExample;
import com.zjgt.p2p.model.BidExample.Criteria;
import com.zjgt.p2p.model.BidQuery;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.CpsCommissionrate;
import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.Cpssettlelog;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Investorderhistory;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.MemberProdIncome;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.service.AdvchannelInfoService;
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
import com.zjgt.p2p.service.YieldplanService;
import com.zjgt.p2p.service.YieldsumService;
import com.zjgt.p2p.viewbean.BidApprove;
import com.zjgt.p2p.viewbean.BidApproveExample;
import com.zjgt.util.CommissionCalcUtil;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.StringUtil;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bidService")
public class BidServiceImpl
  implements BidService
{
  private static final String PATTERN = "yyyy-MM-dd";
  Logger logger;

  @Autowired
  private BidMapper bidMapper;

  @Autowired
  private BidApproveMapper bidApproveMapper;

  @Autowired
  private YieldsumService yieldsumService;

  @Autowired
  private YieldplanService yieldplanService;

  @Autowired
  private InvestOrderService investorderService;

  @Autowired
  private InvestOrderHistoryService historyService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberAccountService accountService;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private ApproveService approveService;

  @Autowired
  private YieldBatchTransation yieldBatchTransation;

  @Autowired
  private MemberProdIncomeService memberProdIncomeService;

  @Autowired
  private BonusService bonusService;

  @Autowired
  private MessageService messageService;

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

  public BidServiceImpl()
  {
    this.logger = LoggerFactory.getLogger(BidServiceImpl.class);
  }

  public String delete(Long id)
  {
    if (this.bidMapper.deleteByPrimaryKey(id) == 1) {
      return "删除成功";
    }
    return "删除失败";
  }

  public Bid findById(Long id)
  {
    return this.bidMapper.selectByPrimaryKey(Long.valueOf(id.longValue()));
  }

  public String bidInfo(Bid bidInfo)
  {
    return null;
  }

  public List<Bid> getAll()
  {
    return this.bidMapper.selectByExample(null);
  }

  @Transactional
  public int update(Bid bidInfo) {
    return this.bidMapper.updateByPrimaryKeySelective(bidInfo);
  }

  public List<Bid> getProducts(BidExample bidExample) {
    return this.bidMapper.selectByExample(bidExample);
  }

  public com.zjgt.util.Page<Bid> getProductsByPage(Map<String, String> map)
  {
    com.zjgt.util.Page pages = null;

    List bids = null;
    BidExample exam = new BidExample();
    BidExample.Criteria crit = exam.createCriteria();
    BidExample.Criteria crit1 = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("bidtypeid".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidtypeidEqualTo(Integer.valueOf(value));
        crit1.andBidtypeidEqualTo(Integer.valueOf(value));
      }

      if (("instcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andInstcodeEqualTo(value);
        crit1.andInstcodeEqualTo(value);
      }

      if (("investperiod".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        System.out.println(Integer.valueOf(value));
        switch (Integer.valueOf(value).intValue())
        {
        case 1:
          crit.andInvestperiodtypeidEqualTo(Integer.valueOf(0));
          crit.andInvestperiodLessThanOrEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodtypeidEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodLessThanOrEqualTo(Integer.valueOf(30));
          break;
        case 2:
          crit.andInvestperiodtypeidEqualTo(Integer.valueOf(0));
          crit.andInvestperiodBetween(Integer.valueOf(1), Integer.valueOf(3));
          crit1.andInvestperiodtypeidEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodBetween(Integer.valueOf(30), Integer.valueOf(90));
          break;
        case 3:
          crit.andInvestperiodtypeidEqualTo(Integer.valueOf(0));
          crit.andInvestperiodBetween(Integer.valueOf(3), Integer.valueOf(6));
          crit1.andInvestperiodtypeidEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodBetween(Integer.valueOf(90), Integer.valueOf(180));
          break;
        case 4:
          crit.andInvestperiodtypeidEqualTo(Integer.valueOf(0));
          crit.andInvestperiodBetween(Integer.valueOf(6), Integer.valueOf(12));
          crit1.andInvestperiodtypeidEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodBetween(Integer.valueOf(180), Integer.valueOf(365));
          break;
        case 5:
          crit.andInvestperiodtypeidEqualTo(Integer.valueOf(0));
          crit.andInvestperiodGreaterThanOrEqualTo(Integer.valueOf(13));
          crit1.andInvestperiodtypeidEqualTo(Integer.valueOf(1));
          crit1.andInvestperiodGreaterThanOrEqualTo(Integer.valueOf(365));
        }

      }

      if (("annualizedrate".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        switch (Integer.valueOf(value).intValue())
        {
        case 1:
          crit.andAnnualizedrateLessThanOrEqualTo(new BigDecimal(6.5D));
          crit1.andAnnualizedrateLessThanOrEqualTo(new BigDecimal(6.5D));
          break;
        case 2:
          crit.andAnnualizedrateBetween(new BigDecimal(6.5D), new BigDecimal(9.1D));
          crit1.andAnnualizedrateBetween(new BigDecimal(6.5D), new BigDecimal(9.1D));
          break;
        case 3:
          crit.andAnnualizedrateBetween(new BigDecimal(9.1D), new BigDecimal(12));
          crit1.andAnnualizedrateBetween(new BigDecimal(9.1D), new BigDecimal(12));
          break;
        case 4:
          crit.andAnnualizedrateGreaterThanOrEqualTo(new BigDecimal(12));
          crit1.andAnnualizedrateGreaterThanOrEqualTo(new BigDecimal(12));
        }

      }

      if (("raisestate".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andRaisestateEqualTo(Integer.valueOf(value));
        crit1.andRaisestateEqualTo(Integer.valueOf(value));
      }

    }

    List list = new ArrayList();
    list.add(Integer.valueOf(BidStatus.UNPUBLISH.getKey()));
    list.add(Integer.valueOf(BidStatus.BADBID.getKey()));
    crit.andBidstatusNotIn(list);
    crit1.andBidstatusNotIn(list);
    exam.or(crit);
    exam.or(crit1);
    exam.setOrderByClause("raisestate ASC,pubdate DESC  ");
    int totalCount = (int)this.bidMapper.getProductsCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);
    int pageSize;
    if (map.get("pageSize") == null)
      pageSize = Const.PRODUCTS_PAGE_SIZE;
    else {
      pageSize = Integer.valueOf((String)map.get("pageSize")).intValue();
    }
    pages.setPageSize(pageSize);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(pageSize));

    bids = this.bidMapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(bids);
    return pages;
  }

  public com.zjgt.util.Page<BidApprove> getBadBidByPage(Map<String, String> map)
  {
    com.zjgt.util.Page pages = null;

    List bidApproval = null;
    BidApproveExample exam = new BidApproveExample();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("bidcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setBidcode(value);
      }

      if (("bidclassname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setBidclassname(value);
      }

      if (("appstatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        exam.setApproStatus(Integer.valueOf(value));
      }

    }

    int totalCount = (int)this.bidApproveMapper.getBidApproveCount(exam);
    System.out.println("count-----------" + totalCount);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);

    pages.setPageSize(Const.BADBID_PAGE_SIZE);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Const.BADBID_PAGE_SIZE));

    bidApproval = this.bidApproveMapper.getBidApprove(exam);
    System.out.println("size-------" + bidApproval.size());
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(bidApproval);
    return pages;
  }

  @Transactional
  public int addBid(Bid bid)
  {
    return this.bidMapper.insert(bid);
  }

  public com.zjgt.util.Page<Bid> queryBidList(Map<String, String> map)
  {
    com.zjgt.util.Page pages = null;

    List bids = null;
    BidExample exam = new BidExample();
    BidExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("bidclassname".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidclassnameEqualTo(value);
      }

      if (("bidcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidcodeEqualTo(value);
      }

      if (("bidtypeid".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidtypeidEqualTo(Integer.valueOf(value));
      }

      try
      {
        if (("bidstarttime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          crit.andPubdateGreaterThanOrEqualTo(new SimpleDateFormat("yyyy-MM-dd").parse(value));
        }

        if (("bidendtime".equals(key)) && 
          (StringUtil.isNotEmpty(value))) {
          Calendar cal = Calendar.getInstance();
          cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(value));
          cal.add(5, 1);
          crit.andPubdateLessThanOrEqualTo(cal.getTime());
        }
      }
      catch (ParseException e) {
        e.printStackTrace();
      }

      if (("bidstatus".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andBidstatusEqualTo(Integer.valueOf(value));
      }

      if (("projectcode".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andProjectcodeEqualTo(value);
      }
    }

    exam.setOrderByClause("pubdate desc");
    int totalCount = (int)this.bidMapper.getProductsCount(exam);
    int pageNow = 0;
    if (map.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf((String)map.get("pageNow")).intValue();
    }
    pages = new com.zjgt.util.Page(totalCount, pageNow);

    pages.setPageSize(Const.BID_PAGE_SIZE);
    exam.setStartPos(Integer.valueOf(pages.getStartPos()));
    exam.setPageSize(Integer.valueOf(Const.BID_PAGE_SIZE));

    bids = this.bidMapper.selectByExampleLimit(exam);
    pages.getPager(pageNow, pages.getTotalPageCount());
    pages.setResults(bids);
    return pages;
  }

  public BidApprove getApproveByBid(Map<String, String> map)
  {
    BidApprove bidApprove = null;
    BidApproveExample exam = new BidApproveExample();
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

    bidApprove = this.bidApproveMapper.getApproveByBid(exam);
    return bidApprove;
  }

  public int updatePublishtime(Integer id)
  {
    Bid bid = new Bid();
    bid.setId(id);
    bid.setBidstatus(Integer.valueOf(BidStatus.INVESTING.getKey()));
    bid.setRaisestate(Integer.valueOf(RaiseState.BUYING.getKey()));
    int a = 0;
    try {
      a = this.bidMapper.updateByPrimaryKeySelective(bid);
    } catch (Exception e) {
      a = 0;
      e.printStackTrace();
    }
    return a;
  }

  @Transactional
  public void updateRaiseEndDate() throws BusinessException {
    updateRaiseEndDate(new Date());
  }

  @Transactional
  public int updateRaiseEndDate(Integer id)
  {
    Bid bid = this.bidMapper.selectByPrimaryKey(Long.valueOf(id.intValue()));

    if (bid.getAmount().doubleValue() == bid.getRaisemoney().doubleValue()) {
      bid.setBidstatus(Integer.valueOf(BidStatus.INVESTED.getKey()));
      bid.setRaisestate(Integer.valueOf(RaiseState.BUYED.getKey()));
    } else {
      bid.setBidstatus(Integer.valueOf(BidStatus.UNFULL.getKey()));
      bid.setRaisestate(Integer.valueOf(RaiseState.BUYING.getKey()));
    }

    int a = 0;
    try {
      a = this.bidMapper.updateByPrimaryKeySelective(bid);
    } catch (Exception e) {
      a = 0;
      e.printStackTrace();
    }
    return a;
  }

  @Transactional
  public void updateRaiseEndDate(Date currentDate)
    throws BusinessException
  {
    BidExample bidexam = new BidExample();
    BidExample.Criteria criter = bidexam.createCriteria();

    List liststatus = new ArrayList();
    liststatus.add(Integer.valueOf(BidStatus.INVESTING.getKey()));
    liststatus.add(Integer.valueOf(BidStatus.INVESTED.getKey()));
    liststatus.add(Integer.valueOf(BidStatus.BADBIDING.getKey()));
    criter.andBidstatusIn(liststatus);

    criter.andBidtypeidNotEqualTo(Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    List<Bid>  list = this.bidMapper.selectByExample(bidexam);
    if ((list != null) && (!(list.isEmpty())))
      for (Bid bid : list) {
        if ((bid.getRaiseenddate() != null) && (DateConverterUtil.areSameDay(bid.getRaiseenddate(), currentDate))) {
          updateRaiseEndDate(bid.getId());
        }

        if (StringUtil.isNotEmpty(bid.getInvestordercode())) {
          bid.setInvestperiod(Integer.valueOf(DateConverterUtil.daysBetween2(currentDate, bid.getExptlastacctdate())));
          update(bid);
        }
      }
  }

  @Transactional
  public void updateestdate() throws BusinessException
  {
    updateestdate(new Date());
  }

  @Transactional
  public void updateestdate(Date currentDate)
    throws BusinessException
  {
    BidExample bidexam = new BidExample();
    BidExample.Criteria criter = bidexam.createCriteria();

    criter.andBidstatusEqualTo(Integer.valueOf(BidStatus.INVESTED.getKey()));
    List<Bid>  list = this.bidMapper.selectByExample(bidexam);
    if ((list != null) && (!(list.isEmpty())))
      for (Bid bid : list)
        if (bid.getExptinterestdate() != null)
          updateestdate(bid.getId(), bid.getExptinterestdate(), currentDate);
  }

  @Transactional
  public int updateestdate(Integer id, Date date, Date currentDate)
  {
    this.logger.info("标的id" + id);
    Bid bid = findById(Long.valueOf(id.intValue()));
    if ((bid.getBorrowstatus() == null) || (bid.getBorrowstatus().intValue() != BorrowStatus.Payed.getKey())) {
      return 0;
    }
    List<InvestOrder> list = this.investorderService.getOrderList(bid.getBidcode());
    if ((DateConverterUtil.areSameDay(currentDate, date)) && (BidType.MINGXINGBIAO.getKey() != bid.getBidtypeid().intValue())) {
      bid.setBidstatus(Integer.valueOf(BidStatus.INVESTED_ACCR.getKey()));
      for (InvestOrder order : list) {
        System.out.println(order.getInvestordercode());
        Yieldsum sum = this.yieldsumService.findByOrdercode(order.getInvestordercode());

        List<Yieldplan> listplans = this.yieldplanService.findPlans(currentDate, order.getInvestordercode(), null);
        Yieldplan plan = null;
        if ((listplans != null) && (!(listplans.isEmpty()))) {
          plan = (Yieldplan)listplans.get(0);
        }

        if ((sum == null) || (plan == null)) {
          this.logger.error("订单: " + order.getInvestordercode() + " 的还款记录 数据为空，请联系管理员核查数据!");
          throw new BusinessException("订单: " + order.getInvestordercode() + " 的还款记录 数据为空，请联系管理员核查数据!");
        }

        order.setOpdate(new Date());
        order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
        this.investorderService.updateOrder(order);

        Investorderhistory history = new Investorderhistory();
        history.setBidcode(order.getBidcode());
        history.setAmount(order.getAmount());
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
        this.historyService.addOrder(history);

        sum.setTermnum(Integer.valueOf(1));
        sum.setTermdate(plan.getTermdate());
        sum.setTermamount(plan.getTermamount());
        this.yieldsumService.update(sum);
      }

      return update(bid);
    }
    return 0;
  }

  public List<Bid> getBidsByProjectcode(String projectcode)
  {
    List bidList = null;
    BidExample example = new BidExample();
    example.createCriteria().andProjectcodeEqualTo(projectcode);
    example.createCriteria().andBidstatusNotEqualTo(Integer.valueOf(BidStatus.UNPUBLISH.getKey()));
    bidList = this.bidMapper.selectByExample(example);
    return bidList;
  }

  public Bid findByBidcode(String bidcode) {
    BidExample exam = new BidExample();
    BidExample.Criteria crit = exam.createCriteria();
    crit.andBidcodeEqualTo(bidcode);
    exam.or(crit);
    return ((Bid)this.bidMapper.selectByExample(exam).get(0));
  }

  public Bid selecttransbid(String ordercode)
  {
    return this.bidMapper.selectTransBidList(ordercode);
  }

  @Transactional
  public int bidlose(String id, String bidcode)
    throws BusinessException
  {
    Bid bidInfo = findById(Long.valueOf(id));
    int result = 0;

    if (bidInfo.getBidstatus().equals(Integer.valueOf(BidStatus.BADBID.getKey()))) {
      throw new BusinessException("标的已经流标 ，不能重复流标操作!");
    }

    if ((bidInfo.getBidstatus().equals(Integer.valueOf(BidStatus.INVESTED_ACCR.getKey()))) || (bidInfo.getBidstatus().equals(Integer.valueOf(BidStatus.FINISHED.getKey()))))
      throw new BusinessException("标的已计息或已兑付 ，不可以进行流标操作!");
    if (bidInfo.getBidtypeid().equals(Integer.valueOf(BidType.MINGXINGBIAO.getKey())))
      throw new BusinessException("天天富" + bidInfo.getBidclassname() + "，不可以进行流标操作!");
    PlatformAsset platformAsset;
    PlatformAcct platformAcct;
    if ((!(bidInfo.getBidtypeid().equals(Integer.valueOf(BidType.MINGXINGBIAO.getKey())))) && (bidInfo.getBidstatus().equals(Integer.valueOf(BidStatus.BADBIDING.getKey()))))
    {
      bidInfo.setBidstatus(Integer.valueOf(BidStatus.BADBID.getKey()));
      bidInfo.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
      result = update(bidInfo);

      Approve approve = new Approve();
      approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPROVE.getKey()));
      approve.setModulecode(String.valueOf(ApproveMoudle.LOSE.getKey()));
      approve.setSubject(String.valueOf(ApproveSubject.LOSE.getKey()));
      approve.setOpdate(new Date());
      approve.setServiceno(bidInfo.getBidcode());

      Subject subject = SecurityUtils.getSubject();
      ShiroStaff currUser = null;
      if (subject.isAuthenticated()) {
        currUser = (ShiroStaff)subject.getPrincipal();
      }
      approve.setStaffNo(currUser.getId());
      approve.setStaffName(currUser.getName());
      this.approveService.addOrder(approve);

      platformAsset = this.platformAssetService.findAsset();
      if (platformAsset.getAccount() == null) {
        platformAsset.setAccount(BigDecimal.ZERO);
      }
      if (platformAsset.getBlance() == null) {
        platformAsset.setBlance(BigDecimal.ZERO);
      }

      platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.FAILEDBID.getTranName(), 0);

      if (platformAsset.getBlance().subtract(bidInfo.getRaisemoney()).doubleValue() < 0.0D) {
        throw new BusinessException("平台余额不足 ，请联系管理员! 标的编号:" + bidInfo.getBidcode() + " 标的已募集金额:" + bidInfo.getRaisemoney());
      }

      if (platformAcct.getAccount().subtract(bidInfo.getRaisemoney()).doubleValue() < 0.0D) {
        this.logger.error("平台账户余额不足 ，请联系管理员! 平台账号:" + platformAcct.getAcctid() + " 平台账户金额:" + platformAcct.getAccount() + " 标的编号:" + bidInfo.getBidcode() + "  标的已募集金额:" + bidInfo.getRaisemoney());
      }

      List<InvestOrder> investOrders = this.investorderService.getOrderList(bidInfo.getBidcode(), OrderStatus.VALID.getKey());
      for (InvestOrder order : investOrders)
      {
        order.setOrderstatus(Integer.valueOf(OrderStatus.UNVALID.getKey()));

        order.setOrderstatusdesc(String.valueOf(OrderStatusDesc.BadBID.getKey()));

        order.setExptincome(BigDecimal.valueOf(0.0D));

        if (platformAsset.getAccount().subtract(order.getAmount()).doubleValue() < 0.0D) {
          throw new BusinessException("平台资产金额不足 ，请联系管理员! 订单编号:" + order.getInvestordercode() + " 订单金额:" + order.getAmount());
        }

        platformAsset.setAccount(platformAsset.getAccount().subtract(order.getAmount()));

        if (platformAsset.getBlance().subtract(order.getAmount()).doubleValue() < 0.0D) {
          throw new BusinessException("平台余额不足 ，请联系管理员! 订单编号:" + order.getInvestordercode() + " 订单金额:" + order.getAmount());
        }

        platformAsset.setBlance(platformAsset.getBlance().subtract(order.getAmount()));
        platformAsset.setModifyDate(new Date());
        this.platformAssetService.save(platformAsset);

        if (platformAcct.getAccount().subtract(order.getAmount()).doubleValue() < 0.0D) {
          this.logger.error("平台账户余额不足 ，请联系管理员! 平台账号:" + platformAcct.getAcctid() + " 平台账户金额:" + platformAcct.getAccount() + " 订单编号:" + order.getInvestordercode() + " 订单金额:" + order.getAmount());
        }
        platformAcct.setAccount(platformAcct.getAccount().subtract(order.getAmount()));

        if (platformAcct.getBlance().subtract(order.getAmount()).doubleValue() < 0.0D) {
          this.logger.error("平台账户余额不足 ，请联系管理员! 平台账号:" + platformAcct.getAcctid() + " 平台账户余额:" + platformAcct.getBlance() + " 订单编号:" + order.getInvestordercode() + " 订单金额:" + order.getAmount());
        }
        platformAcct.setBlance(platformAcct.getBlance().subtract(order.getAmount()));
        platformAcct.setModifyDate(new Date());
        this.platformAcctService.save(platformAcct);

        MemberAcct memberacct = this.memberAcctService.findByMemberIdForUpdate(order.getCustomerid());
        memberacct.setBlance(memberacct.getBlance().add(order.getAmount()));

        if (memberacct.getFreezeBlance() == null) {
          memberacct.setFreezeBlance(BigDecimal.ZERO);
        }

        if (memberacct.getFreezeBlance().subtract(order.getAmount()).doubleValue() < 0.0D) {
          throw new BusinessException("会员账户冻结金额小于订单金额,会员账户冻结金额为:" + memberacct.getFreezeBlance() + ",订单编号:" + order.getInvestordercode() + ", 订单金额:" + order.getAmount());
        }
        memberacct.setFreezeBlance(memberacct.getFreezeBlance().subtract(order.getAmount()));

        memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));
        memberacct.setModifyDate(new Date());
        this.memberAcctService.save(memberacct);

        MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(order.getCustomerid());

        memberAccount.setBlance(memberAccount.getBlance().add(order.getAmount()));

        if (memberAccount.getFreezeBlance() == null) {
          memberAccount.setFreezeBlance(BigDecimal.ZERO);
        }
        if (memberAccount.getFreezeBlance().subtract(order.getAmount()).doubleValue() < 0.0D) {
          throw new BusinessException("会员资产冻结金额数值错误 ，请联系管理员! 会员编号:" + memberAccount.getMemberid() + " 订单编号:" + order.getInvestordercode() + " 订单金额:" + order.getAmount());
        }

        memberAccount.setFreezeBlance(memberAccount.getFreezeBlance().subtract(order.getAmount()));

        Yieldsum yieldsum = this.yieldsumService.findByOrder(order.getInvestordercode(), Integer.valueOf(order.getCustomerid().intValue()));

        if (memberAccount.getIncome() == null) {
          memberAccount.setIncome(BigDecimal.ZERO);
        }

        memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));
        memberAccount.setModifyDate(new Date());
        this.accountService.save(memberAccount);

        Translog bonusTranslog = null;

        if ((order.getBonusamount() != null) && (order.getBonusamount().compareTo(BigDecimal.ZERO) > 0)) {
          bonusTranslog = this.bonusService.tranBonuse(order.getCustomerid(), order.getBonusamount(), AcctTranDef.BONUS_BIDLOSE_UNFROZEN);
        }

        MemberProdIncome income = this.memberProdIncomeService.selectBytype(order.getCustomerid().longValue(), bidInfo.getBidtypeid());
        if (income != null) {
          income.setIncome(income.getIncome().subtract(order.getAmount()).setScale(2, RoundingMode.FLOOR));

          income.setModifyDate(new Date());
          income.setBidtypeid(bidInfo.getBidtypeid());
        } else {
          income = new MemberProdIncome();
          income.setMemberid(order.getCustomerid());
          income.setIncome(order.getAmount().setScale(2, RoundingMode.FLOOR));

          income.setModifyDate(new Date());
          income.setBidtypeid(bidInfo.getBidtypeid());
          income.setBidclassname(bidInfo.getBidtype());
          income.setCreateDate(new Date());
        }
        this.memberProdIncomeService.addProductIncome(income);

        Capitaltrans capitalTrans = new Capitaltrans();
        capitalTrans.setTransno(order.getInvestordercode());
        capitalTrans.setTranstime(new Date());

        capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.FAILEDBID.getTranCode()));
        capitalTrans.setMemberAcctid(Integer.valueOf(memberacct.getMemberAcctid().intValue()));
        capitalTrans.setMemberid(Integer.valueOf(order.getCustomerid().intValue()));
        capitalTrans.setRealname(order.getCustomernickname());
        capitalTrans.setAmount(order.getAmount());

        capitalTrans.setCurrency("CNY");
        capitalTrans.setTransstatus(Integer.valueOf(1));

        capitalTrans.setPayaccountid(platformAcct.getAcctid());
        capitalTrans.setPayaccounttype(Integer.valueOf(1));

        capitalTrans.setPayeeaccountid(memberacct.getMemberAcctid());
        capitalTrans.setPayeename(order.getCustomername());
        capitalTrans.setPayeeaccounttype(Integer.valueOf(0));
        capitalTrans.setTransstatus(Integer.valueOf(1));

        List translogList = new ArrayList();
        Translog translog = new Translog();
        translog.setTranstime(capitalTrans.getTranstime());
        translog.setTranscode(AcctTranDef.LOSEREFUND.getTranCode());
        translog.setTransdesc(AcctTranDef.LOSEREFUND.getShowName());
        translog.setAmount(order.getAmount());
        translog.setAvailamount(memberAccount.getBlance());
        translog.setPlatavailamount(platformAsset.getBlance());
        translog.setCurrency("CNY");

        translog.setPayaccountid(platformAcct.getAcctid());
        translog.setPayaccounttype(Integer.valueOf(1));
        translog.setPayername(platformAcct.getAcctName());
        translog.setPaysubamount(platformAcct.getBlance());

        translog.setPayeeaccountid(memberacct.getMemberAcctid());
        translog.setPayeememberid(Integer.valueOf(order.getCustomerid().intValue()));
        translog.setPayeename(order.getCustomername());
        translog.setPayeesubamount(memberacct.getBlance());
        translog.setPayeeaccounttype(Integer.valueOf(0));
        translog.setTransstatus(Integer.valueOf(1));
        translogList.add(translog);

        if (bonusTranslog != null) {
          translogList.add(bonusTranslog);
        }

        capitalTrans.setTranLogs(translogList);
        this.capitalTransService.add(capitalTrans);

        this.yieldBatchTransation.deleteByOrderCode(order.getInvestordercode());

        this.investorderService.updateOrder(order);

        this.messageService.sendMessage("message.flow", order.getCustomerid().longValue(), new String[] { bidInfo.getBidclassname(), order.getAmount().toString() });
      }

    }

    List<CpsInvestinfo> list = this.cpsInvestInfoService.findInvestInfos(bidInfo.getBidcode());
    if ((list != null) && (!(list.isEmpty()))) {
      for (CpsInvestinfo info : list) {
        info.setProfitstatus(Integer.valueOf(3));
        this.cpsInvestInfoService.updateCpsInfo(info);
      }
    }
    List<Cpssettlelog> settlelogs = this.cpsSettlelogService.findByBidcode(bidInfo.getBidcode());
    if ((settlelogs != null) && (!(settlelogs.isEmpty()))) {
      for (Cpssettlelog log : settlelogs) {
        log.setCommission(BigDecimal.ZERO);
        log.setSettlestatus(Integer.valueOf(2));
        this.cpsSettlelogService.updatesettlelog(log);
      }
    }

    return result;
  }

  @Transactional
  public String payself(String id)
    throws BusinessException
  {
    Bid bidInfo = findById(Long.valueOf(id));

    bidInfo.setApprostatus(Integer.valueOf(ApproveStatus.APPROVED.getKey()));
    int result = update(bidInfo);

    Approve approve = new Approve();
    approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPROVE.getKey()));
    approve.setModulecode(String.valueOf(ApproveMoudle.LOSE.getKey()));
    approve.setSubject(String.valueOf(ApproveSubject.INCOME.getKey()));
    approve.setOpdate(new Date());
    approve.setServiceno(bidInfo.getBidcode());

    Subject subject = SecurityUtils.getSubject();
    ShiroStaff currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroStaff)subject.getPrincipal();
    }
    approve.setStaffNo(currUser.getId());
    approve.setStaffName(currUser.getName());
    int b = this.approveService.addOrder(approve);
    if ((result != 0) && (b != 0)) {
      return "1";
    }
    return null;
  }

  public List<Bid> getBidsByInstcode(String instcode)
  {
    List bidList = null;
    BidExample example = new BidExample();
    example.createCriteria().andInstcodeEqualTo(instcode);
    example.createCriteria().andBidstatusNotEqualTo(Integer.valueOf(BidStatus.UNPUBLISH.getKey()));
    bidList = this.bidMapper.selectByExample(example);
    return bidList;
  }

  @Transactional
  public String payToBorrower(String id)
    throws BusinessException
  {
    String status = null;

    Bid bid = findById(Long.valueOf(id));
    if ((bid.getBorrowstatus() != null) && (bid.getBorrowstatus().intValue() == BorrowStatus.Payed.getKey())) {
      throw new BusinessException("标的" + bid.getBidno() + "已经付款给借款人,请勿重复操作!");
    }

    if (bid.getAmount().compareTo(bid.getRaisemoney()) != 0) {
      return "3";
    }
    Calendar cal = Calendar.getInstance();
    cal.add(5, 1);

    Date interestdate = cal.getTime();
    bid.setExptinterestdate(interestdate);
    cal.add(2, bid.getInvestperiod().intValue());
    cal.add(5, -1);

    Date expiredate = cal.getTime();
    bid.setExptexpiredate(expiredate);
    cal.add(5, 1);

    Date lastacctdate = cal.getTime();
    bid.setExptlastacctdate(lastacctdate);

    bid.setBorrowstatus(Integer.valueOf(BorrowStatus.Payed.getKey()));

    int a = update(bid);

    List<InvestOrder> list = this.investorderService.getOrderList(bid.getBidcode());
    for (InvestOrder investOrder : list) {
    	List<Yieldplan> plans = this.yieldplanService.findByOrderCode(investOrder.getInvestordercode());
      Yieldsum yieldsum = this.yieldsumService.findByOrdercode(investOrder.getInvestordercode());
      if (yieldsum == null) {
        this.logger.error("标的编号:" + bid.getBidcode() + "投资订单编号:" + investOrder.getInvestordercode() + "未生成投资收益计划,请联系管理员");
        throw new BusinessException("标的编号:" + bid.getBidcode() + "投资订单编号:" + investOrder.getInvestordercode() + "未生成投资收益计划,请联系管理员");
      }
      yieldsum.setPaystatus(Integer.valueOf(1));

      MemberAcct memberacct = this.memberAcctService.findByMemberIdForUpdate(investOrder.getCustomerid());

      if (memberacct.getFreezeBlance() == null) {
        memberacct.setFreezeBlance(BigDecimal.ZERO);
      }

      if (memberacct.getFreezeBlance().subtract(investOrder.getAmount()).doubleValue() < 0.0D) {
        throw new BusinessException("会员的冻结金额小于订单金额,请核查会员账户数据!用户id" + memberacct.getMemberAcctid() + "冻结资金" + memberacct.getFreezeBlance() + "标的金额" + investOrder.getAmount() + "标的编号" + investOrder.getInvestordercode());
      }

      memberacct.setFreezeBlance(memberacct.getFreezeBlance().subtract(investOrder.getAmount()));

      memberacct.setAccount(memberacct.getBlance().add(memberacct.getFreezeBlance()));
      memberacct.setModifyDate(new Date());
      this.memberAcctService.save(memberacct);

      MemberAccount memberAccount = this.accountService.getByMemberIdForUpdate(investOrder.getCustomerid());

      if (memberAccount.getFreezeBlance() == null) {
        memberAccount.setFreezeBlance(BigDecimal.ZERO);
      }
      if (memberAccount.getFreezeBlance().subtract(investOrder.getAmount()).doubleValue() < 0.0D) {
        throw new BusinessException("会员编号:" + memberAccount.getMemberid() + "资产的冻结金额小于订单金额,请核查会员账户数据!");
      }
      memberAccount.setFreezeBlance(memberAccount.getFreezeBlance().subtract(investOrder.getAmount()));

      memberAccount.setRecvincome(memberAccount.getRecvincome().add(yieldsum.getAccruedinterestsum()));

      if (memberAccount.getIncome() == null) {
        memberAccount.setIncome(BigDecimal.ZERO);
      }
      memberAccount.setIncome(memberAccount.getIncome().add(investOrder.getAmount()));

      memberAccount.setAccount(memberAccount.getBlance().add(memberAccount.getFreezeBlance()).add(memberAccount.getIncome()).add(memberAccount.getRecvincome()));
      memberAccount.setModifyDate(new Date());
      this.accountService.save(memberAccount);

      for (int i = 0; i < plans.size(); ++i) {
        Calendar date = Calendar.getInstance();
        date.setTime(interestdate);
        if (Integer.valueOf(bid.getRepaymentway()).intValue() == RepaymentWay.FINISHED.getKey())
          date.add(2, bid.getInvestperiod().intValue());
        else {
          date.add(2, i + 1);
        }
        ((Yieldplan)plans.get(i)).setTermdate(date.getTime());
        this.yieldplanService.update((Yieldplan)plans.get(i));
        if (i == 0) {
          yieldsum.setTermdate(date.getTime());
          this.yieldsumService.update(yieldsum);
        }

      }

    }

    BigDecimal money = bid.getAmount().subtract(bid.getAmount().multiply(bid.getPubfee().add(bid.getRiskmgrfee()).divide(new BigDecimal("100"))));

    BigDecimal pubfee = bid.getAmount().multiply(bid.getPubfee().divide(new BigDecimal("100")));

    BigDecimal riskfee = bid.getAmount().multiply(bid.getRiskmgrfee().divide(new BigDecimal("100")));

    PlatformAsset platformAsset = this.platformAssetService.findAsset();
    if (platformAsset.getAccount() == null) {
      platformAsset.setAccount(BigDecimal.ZERO);
      throw new BusinessException("平台资产金额为空,请核查平台资产数据!");
    }
    if (platformAsset.getBlance() == null) {
      platformAsset.setBlance(BigDecimal.ZERO);
      throw new BusinessException("平台资产余额为空,请核查平台资产数据!");
    }
    if (platformAsset.getAccount().subtract(money).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产金额小于订单金额,请核查平台资产数据!");
    }
    platformAsset.setAccount(platformAsset.getAccount().subtract(money));

    if (platformAsset.getBlance().subtract(money).doubleValue() < 0.0D) {
      throw new BusinessException("平台资产余额小于订单金额,请核查平台资产数据!");
    }
    platformAsset.setBlance(platformAsset.getBlance().subtract(money));

    platformAsset.setModifyDate(new Date());
    this.platformAssetService.save(platformAsset);

    PlatformAcct platformAcct = this.platformAcctService.findByacctid(Long.valueOf(1L), AcctTranDef.PAY_TO_BORROWER.getTranName(), 0);
    if (platformAcct.getAccount().subtract(money).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户金额小于付款金额,请核查平台资产数据!");
    }
    platformAcct.setAccount(platformAcct.getAccount().subtract(money));

    if (platformAcct.getBlance().subtract(money).doubleValue() < 0.0D) {
      throw new BusinessException("平台账户余额小于付款金额,请核查平台资产数据!");
    }

    platformAcct.setBlance(platformAcct.getBlance().subtract(money));
    platformAcct.setModifyDate(new Date());
    this.platformAcctService.save(platformAcct);

    Capitaltrans capitalTrans = new Capitaltrans();
    capitalTrans.setTransno(bid.getBidcode());
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.PAY_TO_BORROWER.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(platformAcct.getAcctid().intValue()));

    capitalTrans.setAmount(money);

    capitalTrans.setCurrency("CNY");
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayername(platformAcct.getAcctName());
    capitalTrans.setPayaccounttype(Integer.valueOf(1));

    capitalTrans.setPayeename(bid.getBorrowername());
    capitalTrans.setPayeeaccounttype(Integer.valueOf(3));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.PAY_TO_BORROWER.getTranCode());
    translog.setTransdesc(AcctTranDef.PAY_TO_BORROWER.getShowName());
    translog.setAmount(money);

    translog.setPlatavailamount(platformAsset.getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccountid(platformAcct.getAcctid());
    translog.setPayaccounttype(Integer.valueOf(1));
    translog.setPayername(platformAcct.getAcctName());

    translog.setPaysubamount(platformAcct.getBlance());

    translog.setPayeename(bid.getBorrowername());
    translog.setPayeeaccounttype(Integer.valueOf(3));
    translog.setTransstatus(Integer.valueOf(1));

    Translog translog1 = new Translog();
    translog1.setTranstime(capitalTrans.getTranstime());
    translog1.setTranscode(AcctTranDef.PUB_FEE.getTranCode());
    translog1.setTransdesc(AcctTranDef.PUB_FEE.getShowName());
    translog1.setAmount(pubfee);

    translog1.setPlatavailamount(platformAsset.getBlance());
    translog1.setCurrency("CNY");

    translog1.setPayaccounttype(Integer.valueOf(3));
    translog1.setPayername(bid.getBorrowername());

    translog1.setPayeename(platformAcct.getAcctName());
    translog1.setPayeeaccountid(platformAcct.getAcctid());
    translog1.setPayeeaccounttype(Integer.valueOf(1));
    translog1.setPayeesubamount(platformAcct.getBlance());
    translog1.setTransstatus(Integer.valueOf(1));

    Translog translog2 = new Translog();
    translog2.setTranstime(capitalTrans.getTranstime());
    translog2.setTranscode(AcctTranDef.RISKMGR_FEE.getTranCode());
    translog2.setTransdesc(AcctTranDef.RISKMGR_FEE.getShowName());
    translog2.setAmount(riskfee);

    translog2.setPlatavailamount(platformAsset.getBlance());
    translog2.setCurrency("CNY");

    translog2.setPayaccounttype(Integer.valueOf(3));
    translog2.setPayername(bid.getBorrowername());

    translog2.setPayeename(platformAcct.getAcctName());
    translog2.setPayeeaccountid(platformAcct.getAcctid());
    translog2.setPayeeaccounttype(Integer.valueOf(1));
    translog2.setPayeesubamount(platformAcct.getBlance());
    translog2.setTransstatus(Integer.valueOf(1));

    translogList.add(translog);
    translogList.add(translog1);
    translogList.add(translog2);

    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    Calendar startdate;
    try
    {
    	List<CpsInvestinfo> infos = this.cpsInvestInfoService.findInvestInfos(bid.getBidcode());
      if ((infos != null) && (!(infos.isEmpty()))) {
        startdate = Calendar.getInstance();
        startdate.add(5, 1);
        for (CpsInvestinfo investinfo : infos) {
          AdvchannelInfo advchannelInfo = this.advchannelService.findInfo(investinfo.getChannel());
          CpsCommissionrate rate = this.commissionrateService.findCommissionrate(bid.getBidtypeid(), investinfo.getAmount(), investinfo.getChannel());

          List<Cpssettlelog> logs = CommissionCalcUtil.CommissionCalc(startdate.getTime(), bid.getExptlastacctdate(), advchannelInfo.getCooperiod(), investinfo.getAmount(), rate.getCommissionrate(), bid.getInvestperiod().intValue(), BidType.YUEXIBAO.getKey(), false);
          if ((logs != null) && (!(logs.isEmpty()))) {
            for (Cpssettlelog cpssettlelog : logs) {
              Cpssettlelog newlog = new Cpssettlelog();
              newlog.setAmount(investinfo.getAmount());
              newlog.setSettleamount(investinfo.getSettleamount());
              newlog.setBidcode(bid.getBidcode());
              newlog.setChannel(investinfo.getChannel());
              newlog.setChannel2(investinfo.getChannel2());
              newlog.setCommission(cpssettlelog.getCommission());
              newlog.setInvestordercode(investinfo.getOrderno());
              newlog.setMemberid(investinfo.getMemberid());
              newlog.setOpdate(startdate.getTime());
              newlog.setSettledate(cpssettlelog.getSettledate());
              newlog.setSettlestatus(cpssettlelog.getSettlestatus());
              newlog.setTermnum(cpssettlelog.getTermnum());
              this.cpsSettlelogService.insertsettlelog(newlog);
              investinfo.setLastsettledate(cpssettlelog.getSettledate());
            }
          }

          this.cpsInvestInfoService.updateCpsInfo(investinfo);
        }
      }
    } catch (Exception e) {
      throw new BusinessException();
    }

    if (a != 0) {
      status = "1";
    }

    return status;
  }

  public BigDecimal selectBidRestAmount(long id)
  {
    Bid bid = this.bidMapper.selectByidForUpdate(Long.valueOf(id));
    if (bid.getRaisemoney() == null) {
      bid.setRaisemoney(BigDecimal.valueOf(0.0D));
      return bid.getAmount();
    }
    return bid.getAmount().subtract(bid.getRaisemoney());
  }

  @Transactional
  public void updateLastTimeBid() throws BusinessException
  {
    updateLastTimeBid(new Date());
  }

  @Transactional
  public void updateLastTimeBid(Date currentDate) throws BusinessException
  {
    Calendar cdate = Calendar.getInstance();
    cdate.setTime(currentDate);
    cdate.set(11, 0);
    cdate.set(12, 0);
    cdate.set(13, 0);
    cdate.set(14, 0);

    Date tdate = cdate.getTime();
    cdate.add(5, 1);

    Date ndate = cdate.getTime();
    BidExample example = new BidExample();
    example.createCriteria().andExptlastacctdateGreaterThanOrEqualTo(tdate).andExptlastacctdateLessThan(ndate).andBidstatusEqualTo(Integer.valueOf(BidStatus.INVESTED_ACCR.getKey()));
    List<Bid>  list = this.bidMapper.selectByExample(example);
    if ((list == null) || (list.isEmpty()))
      return;
    for (Bid bid : list)
      if ((bid.getBidtypeid().intValue() != BidType.MINGXINGBIAO.getKey()) && (isInvestOrderFinished(bid.getBidcode()))) {
        bid.setBidstatus(Integer.valueOf(BidStatus.FINISHED.getKey()));
        update(bid);
      }
  }

  private boolean isInvestOrderFinished(String bidcode)
  {
    boolean istrue = false;
    List<InvestOrder> orders = this.investorderService.getOrderList(bidcode);
    if ((orders != null) && (!(orders.isEmpty()))) {
      for (InvestOrder order : orders)
      {
        if ((order.getOrderstatus().intValue() == OrderStatus.FINISHED.getKey()) || (order.getOrderstatus().intValue() == OrderStatus.UNVALID.getKey()))
          istrue = true;
        else {
          return false;
        }
      }
    }
    return istrue;
  }

  public Bid selectBidForUpdate(long id) throws BusinessException
  {
    return this.bidMapper.selectByidForUpdate(Long.valueOf(id));
  }

  public List<Bid> selectBidByBidtype(Integer bidtype)
  {
    BidExample example = new BidExample();
    example.createCriteria().andBidtypeidEqualTo(bidtype);
    return this.bidMapper.selectByExample(example);
  }

  public Bid selectByOrdercode(String ordercode)
  {
    BidExample example = new BidExample();
    example.createCriteria().andInvestordercodeEqualTo(ordercode);
    List list = this.bidMapper.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((Bid)list.get(0));
    }
    return null;
  }

  @Transactional
  public int applyLoseBid(String id, String bidcode, String subject, String appreason)
    throws BusinessException
  {
    Bid bid = findById(Long.valueOf(id));
    if (bid.getApprostatus() != null) {
      if (bid.getApprostatus().intValue() == 0) {
        throw new BusinessException("不符合流标条件，已申请过");
      }
      if (bid.getApprostatus().intValue() == 1) {
        throw new BusinessException("不符合流标条件，已审批过");
      }
    }
    bid.setBidstatus(Integer.valueOf(BidStatus.BADBIDING.getKey()));
    bid.setApprostatus(Integer.valueOf(ApproveStatus.UNAPPROVE.getKey()));
    int bb = update(bid);

    Approve approve = new Approve();
    approve.setModulecode(String.valueOf(ApproveMoudle.LOSE.getKey()));
    approve.setServiceno(bidcode);
    approve.setTransname(String.valueOf(ApproveMoudle.LOSE.getKey()));
    approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPLY.getKey()));
    approve.setSubject(subject);
    approve.setAppreason(appreason);
    approve.setOpdate(new Date());

    Subject subject_ = SecurityUtils.getSubject();
    ShiroStaff currUser = null;
    if (subject_.isAuthenticated()) {
      currUser = (ShiroStaff)subject_.getPrincipal();
    }
    approve.setStaffNo(currUser.getId());
    approve.setStaffName(currUser.getName());

    int app = this.approveService.addOrder(approve);
    if ((app != 0) && (bb != 0)) {
      return 1;
    }
    return 0;
  }

  public Bid getBidByDateAndNofull() {
    return this.bidMapper.selectBydateAndNofull();
  }

  public Bid getBidByDate() {
    BidExample exam = new BidExample();
    exam.createCriteria().andBidtypeidEqualTo(Integer.valueOf(4));
    exam.setOrderByClause("pubdate desc");
    exam.setPageSize(Integer.valueOf(1));
    exam.setStartPos(Integer.valueOf(1));
    List bids = this.bidMapper.selectByExample(exam);
    if (bids.size() != 0) {
      return ((Bid)bids.get(0));
    }
    return null;
  }

  public org.springfk.pancloud.paginator.vo.Page<Bid> findPayListByPage(BidQuery bidQuery, int pageNo, int pageSize)
    throws BusinessException
  {
    BidExample exam = new BidExample();
    BidExample.Criteria crite = exam.createCriteria();
    if (StringUtils.isNotEmpty(bidQuery.getBorrowername())) {
      crite.andBorrowernameLike(String.valueOf("%" + bidQuery.getBorrowername() + "%"));
    }
    if (StringUtils.isNotEmpty(bidQuery.getBidname())) {
      crite.andBidclassnameLike(String.valueOf("%" + bidQuery.getBidname() + "%"));
    }
    if (bidQuery.getBidtype() != null) {
      crite.andBidtypeidEqualTo(bidQuery.getBidtype());
    }
    if (bidQuery.getBorrowstatus() != null) {
      if (bidQuery.getBorrowstatus().intValue() == BorrowStatus.Payed.getKey())
        crite.andBorrowstatusEqualTo(bidQuery.getBorrowstatus());
      else {
        crite.andBorrowstatusIsNull();
      }
    }
    try
    {
      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date start;
      Date end;
      if ((bidQuery.getBorrowstatus() != null) && (bidQuery.getBorrowstatus().intValue() == BorrowStatus.Payed.getKey())) {
        if ((bidQuery.getPayDateStart() != null) && (bidQuery.getPayDateEnd() != null))
        {
          start = format.parse(DateUtils.getDateStr(bidQuery.getPayDateStart()) + " 00:00:00");

          end = format.parse(DateUtils.getDateStr(bidQuery.getPayDateEnd()) + " 23:59:59");

          crite.andExptinterestdateBetween(start, end);
        } else if (bidQuery.getPayDateStart() != null) {
          start = format.parse(DateUtils.getDateStr(bidQuery.getPayDateStart()) + " 00:00:00");

          crite.andExptinterestdateGreaterThanOrEqualTo(start);
        } else if (bidQuery.getPayDateEnd() != null) {
          end = format.parse(DateUtils.getDateStr(bidQuery.getPayDateEnd()) + " 23:59:59");

          crite.andExptinterestdateLessThanOrEqualTo(end);
        }
      }

      if ((bidQuery.getExptDateStart() != null) && (bidQuery.getExptDateEnd() != null))
      {
        end = format.parse(DateUtils.getDateStr(bidQuery.getExptDateStart()) + " 00:00:00");

        end = format.parse(DateUtils.getDateStr(bidQuery.getExptDateEnd()) + " 23:59:59");

        crite.andExptinterestdateBetween(end, end);
      } else if (bidQuery.getExptDateStart() != null) {
        end = format.parse(DateUtils.getDateStr(bidQuery.getExptDateStart()) + " 00:00:00");

        crite.andExptinterestdateGreaterThanOrEqualTo(end);
      } else if (bidQuery.getExptDateEnd() != null) {
        end = format.parse(DateUtils.getDateStr(bidQuery.getExptDateEnd()) + " 23:59:59");

        crite.andExptinterestdateLessThanOrEqualTo(end);
      }

      if ((bidQuery.getToAcctDateStart() != null) && (bidQuery.getToAcctDateEnd() != null))
      {
        end = format.parse(DateUtils.getDateStr(bidQuery.getToAcctDateStart()) + " 00:00:00");

        end = format.parse(DateUtils.getDateStr(bidQuery.getToAcctDateEnd()) + " 23:59:59");

        crite.andExptlastacctdateBetween(end, end);
      } else if (bidQuery.getToAcctDateStart() != null) {
        end = format.parse(DateUtils.getDateStr(bidQuery.getToAcctDateStart()) + " 00:00:00");

        crite.andExptlastacctdateGreaterThanOrEqualTo(end);
      } else if (bidQuery.getToAcctDateEnd() != null) {
        end = format.parse(DateUtils.getDateStr(bidQuery.getToAcctDateEnd()) + " 23:59:59");

        crite.andExptlastacctdateLessThanOrEqualTo(end);
      }
    } catch (Exception exception) {
      throw new BusinessException("解析日期出错 ", exception);
    }

    if (bidQuery.getRemovebidstatus() != null) {
      crite.andBidstatusNotEqualTo(bidQuery.getRemovebidstatus());
    }
    if (StringUtils.isNotEmpty(bidQuery.getInvestordercode())) {
      crite.andInvestordercodeEqualTo(bidQuery.getInvestordercode());
    }

    org.springfk.pancloud.paginator.vo.Page page = new org.springfk.pancloud.paginator.vo.Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    exam.setPage(page);
    exam.setOrderByClause("exptinterestdate DESC,exptexpiredate DESC");
    page.setResult(this.bidMapper.selectByExample(exam));
    return page;
  }
}