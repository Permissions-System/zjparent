package com.zjgt.p2p.controller;

import com.zjgt.p2p.common.ApproveFlowStep;
import com.zjgt.p2p.common.ApproveStatus;
import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.OrderStatus;
import com.zjgt.p2p.common.OrderStatusDesc;
import com.zjgt.p2p.common.OrderTrans;
import com.zjgt.p2p.common.TermStatus;
import com.zjgt.p2p.dao.YieldsumMapper;
import com.zjgt.p2p.model.Approve;
import com.zjgt.p2p.model.Bid;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.InvestOrder;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.model.Yieldplan;
import com.zjgt.p2p.model.Yieldsum;
import com.zjgt.p2p.model.YieldsumExample;
import com.zjgt.p2p.model.YieldsumExample.Criteria;
import com.zjgt.p2p.service.ApproveService;
import com.zjgt.p2p.service.BidService;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.InvestOrderService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.service.TranslogService;
import com.zjgt.p2p.service.YieldBatchTransation;
import com.zjgt.p2p.service.YieldplanService;
import com.zjgt.p2p.viewbean.InvestOrderAndBid;
import com.zjgt.shiro.ShiroMember;
import com.zjgt.util.DateConverterUtil;
import com.zjgt.util.SafeUtil;
import com.zjgt.util.StringUtil;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/member"})
public class InvestOrderController
{

  @Autowired
  private InvestOrderService investorderservice;

  @Autowired
  private MemberService memberservice;

  @Autowired
  private ApproveService approveserive;

  @Autowired
  private YieldsumMapper yieldsumdao;

  @Autowired
  private YieldplanService yieldplanservice;

  @Autowired
  private BidService bidservice;

  @Autowired
  private CapitalTransService capitaltransservice;

  @Autowired
  private TranslogService translogservice;

  @Autowired
  private YieldBatchTransation batchTransation;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private MessageService messageService;
  Logger logger;

  public InvestOrderController()
  {
    this.logger = LoggerFactory.getLogger(super.getClass());
  }

  @RequestMapping({"/investmentrecord"})
  public ModelAndView showOrder(ModelAndView mv, HttpServletRequest request)
  {
    mv.addObject("bidtype", BidType.values());
    mv.setViewName("vip/investmentrecord");
    return mv;
  }

  @RequestMapping({"/ajaxinvestmentrecord"})
  @ResponseBody
  public com.zjgt.util.Page<InvestOrderAndBid> showOrder(String pageNow, String orderstatus, String bidtypeid)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    System.out.println(pageNow);
    System.out.println(orderstatus);
    System.out.println(bidtypeid);
    Map map = new HashMap();
    map.put("memberid", currUser.getId() + "");
    map.put("pageNow", pageNow);
    map.put("OrderStatus", orderstatus);
    map.put("BidType", bidtypeid);
    map.put("pageSize", String.valueOf(Const.INVESTRECORD_PAGE_SIZE));
    return this.investorderservice.getInvestOrderAndBid(map);
  }

  @RequestMapping({"/searchdetail"})
  public ModelAndView searchDetail(ModelAndView mv, String id)
  {
    mv.setViewName("vip/dealdetail");
    InvestOrder io = this.investorderservice.findById(Integer.valueOf(Integer.parseInt(id)));
    if (io == null) {
      throw new BusinessException("订单id:" + id + "为空");
    }
    mv.addObject("io", io);
    Bid bid = this.bidservice.findByBidcode(io.getBidcode());
    mv.addObject("bid", bid);

    List list = this.yieldplanservice.findByOrderCode(io.getInvestordercode());

    int repaid = 0;
    double point = 0.0D;
    if ((list != null) && (!(list.isEmpty()))) {
      for (int i = 0; i < list.size(); ++i) {
        if ((!(String.valueOf(TermStatus.REPAYED.getKey()).equals(((Yieldplan)list.get(i)).getTermstatus()))) && (!(String.valueOf(TermStatus.TRANSFER.getKey()).equals(((Yieldplan)list.get(i)).getTermstatus())))) {
          continue;
        }

        ++repaid;
      }

      point = repaid / list.size();
    }

    mv.addObject("point", Integer.valueOf((int)(point * 100.0D)));

    return mv;
  }

  @RequestMapping({"/ajaxdealdetail"})
  @ResponseBody
  public org.springfk.pancloud.paginator.vo.Page<Yieldplan> ajaxDealdetail(String investordercode, String pageNow)
  {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    int memberid = currUser.getId().intValue();
    return this.yieldplanservice.selectPlanbyPage(Integer.parseInt(pageNow), 6, memberid, investordercode);
  }

  @RequestMapping({"/ajaxdetailhistory"})
  @ResponseBody
  public org.springfk.pancloud.paginator.vo.Page<Translog> ajaxDetailhistory(String pageNow, String enddate, String startdate, String operastatusvalue, String orderstatusvalue)
  {
    if ((startdate == null) && (enddate == null)) {
      return null;
    }
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    Map map = new HashMap();
    map.put("pageNow", pageNow);
    if (!("NaN".equals(startdate))) {
      map.put("StartDate", startdate);
    }
    if (!("NaN".equals(enddate))) {
      map.put("EndDate", enddate);
    }
    map.put("OperaStatus", operastatusvalue);
    map.put("OrderStatus", orderstatusvalue);
    map.put("pageSize", String.valueOf(Const.INVESTRECORD_PAGE_SIZE));
    map.put("Memberid", currUser.getId() + "");
    org.springfk.pancloud.paginator.vo.Page translogs;
    try {
      translogs = this.translogservice.getTranslogs(map);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return translogs;
  }

  @RequestMapping({"/dealhistory"})
  public ModelAndView dealHistory(ModelAndView mv, String status)
  {
    mv.setViewName("vip/dealrecord");
    mv.addObject("nowdate", DateConverterUtil.currentDate());
    if ("2".equals(status)) {
      mv.addObject("status", Integer.valueOf(2));
    }
    return mv;
  }

  @RequestMapping({"/redeem"})
  @ResponseBody
  public JsonResponse aplyRedeem(String dealpassword, String id, String investordercode)
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if (dealpassword == null) {
      jsonResponse.setResult("交易密码不能为空");
      return jsonResponse;
    }
    String realdealpassword = this.memberservice.findMemberByid(currUser.getId().longValue()).getTranspasswd();

    if (realdealpassword == null) {
      jsonResponse.setResult("交易密码未设置");
      return jsonResponse;
    }
    if (!(SafeUtil.generatePassword(dealpassword).equals(realdealpassword))) {
      jsonResponse.setResult("交易密码输入错误");
      return jsonResponse;
    }

    InvestOrder investOrder = this.investorderservice.findById(Integer.valueOf(Integer.parseInt(id)));

    Bid bid = this.bidservice.findByBidcode(investOrder.getBidcode());

    if ((bid.getLockupperiod() != null) && (DateConverterUtil.daysBetween(bid.getExptinterestdate(), new Date()) + 1 <= bid.getLockupperiod().intValue())) {
      jsonResponse.setResult("锁定期内不能赎回");
      return jsonResponse;
    }

    if (DateConverterUtil.daysBetween(new Date(), bid.getExptexpiredate()) < 2) {
      jsonResponse.setResult("距离标的结束不足3天，不能赎回");
      return jsonResponse;
    }
    investOrder.setOpdate(new Date());
    investOrder.setTransname(String.valueOf(OrderTrans.REDEEM.getKey()));
    investOrder.setTransstatus(Integer.valueOf(1));
    investOrder.setApprostatus(Integer.valueOf(ApproveStatus.UNAPPROVE.getKey()));
    investOrder.setOrderstatus(Integer.valueOf(OrderStatus.VALID.getKey()));
    investOrder.setOrderstatusdesc(String.valueOf(OrderStatusDesc.BEWAITED.getKey()));

    this.investorderservice.updateOrder(investOrder);
    Approve approve = new Approve();
    approve.setModulecode("2");
    approve.setServiceno(investordercode);
    approve.setFlowstep(Integer.valueOf(ApproveFlowStep.APPLY.getKey()));
    approve.setStaffNo(currUser.getId() + "");
    approve.setStaffName(currUser.getRealname());
    approve.setOpdate(new Date());
    this.approveserive.addOrder(approve);
    jsonResponse.setResult("申请成功");

    this.messageService.sendMessage("message.redeem", currUser.getId().longValue(), new String[0]);
    return jsonResponse;
  }

  @RequestMapping({"/ttfRollout"})
  @ResponseBody
  public JsonResponse ttfRollout(String dealpassword, String id, String outAmout)
    throws Exception
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    InvestOrder order = this.investorderservice.findById(Integer.valueOf(id));
    String pattern = "^[1-9]+\\d*$";
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    if (StringUtil.isEmpty(outAmout)) {
      jsonResponse.setResult("转出金额不能为空");
      return jsonResponse; }
    if (!(outAmout.matches(pattern))) {
      jsonResponse.setResult("请输入正整数");
      return jsonResponse; }
    if (order.getAmount().compareTo(new BigDecimal(outAmout)) == -1) {
      jsonResponse.setResult("转出金额不能大于订单金额");
      return jsonResponse;
    }
    YieldsumExample sumeExample = new YieldsumExample();
    sumeExample.createCriteria().andMemberidEqualTo(Integer.valueOf(order.getCustomerid().intValue())).andInvestordercodeEqualTo(order.getInvestordercode());

    Yieldsum yieldsum = null;
    List yieldsums = this.yieldsumdao.selectByExample(sumeExample);
    if ((yieldsums != null) && (!(yieldsums.isEmpty()))) {
      yieldsum = (Yieldsum)yieldsums.get(0);
    }
    if (yieldsum.getRemainpriamount().subtract(new BigDecimal(outAmout)).doubleValue() < 0.0D) {
      jsonResponse.setResult("天天富转出金额不能大于余额!");
      return jsonResponse;
    }

    if (dealpassword == null) {
      jsonResponse.setResult("交易密码不能为空");
      return jsonResponse;
    }
    String realdealpassword = this.memberservice.findMemberByid(currUser.getId().longValue()).getTranspasswd();

    if (realdealpassword == null) {
      jsonResponse.setResult("交易密码未设置");
      return jsonResponse;
    }
    if (!(SafeUtil.generatePassword(dealpassword).equals(realdealpassword))) {
      jsonResponse.setResult("交易密码输入错误");
      return jsonResponse;
    }

    jsonResponse.setResult("申请成功");

    this.batchTransation.rolloutTTF(id, outAmout);
    return jsonResponse;
  }

  @RequestMapping({"/dealrecord"})
  public ModelAndView dealrecode(ModelAndView mv) {
    mv.setViewName("vip/dealrecord");
    return mv;
  }

  @RequestMapping({"/ttfrolloutIndex"})
  public ModelAndView ttfrolloutIndex(ModelAndView mv) {
    BigDecimal maxmoney = new BigDecimal("50000");
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    BigDecimal money = this.investorderservice.sumTTF(currUser.getId(), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    mv.addObject("amount", money);

    MemberAcct acct = this.memberAcctService.findByMemberId(currUser.getId());
    InvestOrder order = this.investorderservice.ttfSumOrder(currUser.getId());
    BigDecimal outmoney;
    try {
      outmoney = this.capitaltransservice.sumTTFRollOutMoney(order.getInvestordercode(), acct.getMemberAcctid(), DateConverterUtil.parseDate(DateConverterUtil.currentDate()));
    } catch (ParseException e) {
      throw new BusinessException();
    }
    if (outmoney == null) {
      if (money.compareTo(maxmoney) <= 0)
        mv.addObject("canoutamount", money);
      else {
        mv.addObject("canoutamount", maxmoney);
      }
    }
    else if (money.compareTo(maxmoney.subtract(outmoney)) <= 0)
      mv.addObject("canoutamount", money);
    else {
      mv.addObject("canoutamount", maxmoney.subtract(outmoney));
    }

    mv.setViewName("vip/ttfrollout");
    return mv;
  }

  @RequestMapping({"/ttfSumRollout"})
  @ResponseBody
  public JsonResponse ttfSumRollout(String dealpassword, String outAmout, String canoutamount)
    throws Exception
  {
    JsonResponse jsonResponse = new JsonResponse();
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }

    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    BigDecimal money = this.investorderservice.sumTTF(currUser.getId(), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    String pattern = "^[1-9]+\\d*$";
    if (StringUtil.isEmpty(outAmout)) {
      jsonResponse.setResult("转出金额不能为空");
      return jsonResponse; }
    if (!(outAmout.matches(pattern))) {
      jsonResponse.setResult("请输入正整数");
      return jsonResponse; }
    if (money.compareTo(new BigDecimal(outAmout)) == -1) {
      jsonResponse.setResult("转出金额不能大于订单金额");
      return jsonResponse;
    }
    if (money.subtract(new BigDecimal(outAmout)).doubleValue() < 0.0D) {
      jsonResponse.setResult("天天富转出金额不能大于余额!");
      return jsonResponse;
    }

    if (new BigDecimal(outAmout).compareTo(new BigDecimal(canoutamount)) > 0) {
      jsonResponse.setResult("天天富转出金额当日不能超过50000!");
      return jsonResponse;
    }

    if (StringUtil.isEmpty(dealpassword)) {
      jsonResponse.setResult("交易密码不能为空");
      return jsonResponse;
    }
    String realdealpassword = this.memberservice.findMemberByid(currUser.getId().longValue()).getTranspasswd();

    if (StringUtil.isEmpty(realdealpassword)) {
      jsonResponse.setResult("交易密码未设置");
      return jsonResponse;
    }
    if (!(SafeUtil.generatePassword(dealpassword).equals(realdealpassword))) {
      jsonResponse.setResult("交易密码输入错误");
      return jsonResponse;
    }

    jsonResponse.setResult("申请成功");

    this.batchTransation.rolloutTTF2(currUser.getId(), outAmout);
    return jsonResponse;
  }

  @RequestMapping({"/ttfrecord"})
  public ModelAndView ttfrecord(ModelAndView mv) {
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    List desc = new ArrayList();
    desc.add(String.valueOf(OrderStatusDesc.PreINTEREST.getKey()));
    desc.add(String.valueOf(OrderStatusDesc.NORMAL.getKey()));
    BigDecimal amount = this.investorderservice.sumTTF(currUser.getId(), desc, Integer.valueOf(BidType.MINGXINGBIAO.getKey()));
    if (amount != null)
      mv.addObject("amount", amount);
    else {
      mv.addObject("amount", "0.00");
    }
    MemberAcct acct = this.memberAcctService.findByMemberId(currUser.getId());
    InvestOrder order = this.investorderservice.ttfSumOrder(currUser.getId());
    if (order != null) {
      Capitaltrans cptrans = this.capitaltransservice.selectTTFLastIncome(order.getInvestordercode(), acct.getMemberAcctid());
      if (cptrans != null)
        mv.addObject("lastincome", cptrans.getAmount());
      else
        mv.addObject("lastincome", "0.00");
    }
    else {
      mv.addObject("lastincome", "0.00");
    }
    mv.setViewName("vip/ttfrecord");
    return mv;
  }

  @RequestMapping({"/ajaxttfrecord"})
  @ResponseBody
  public org.springfk.pancloud.paginator.vo.Page<InvestOrder> ttfrecord(String pageNow, String orderstatusdesc) {
    this.logger.info("pageNow:" + pageNow + "orderstatusdesc" + orderstatusdesc);
    Subject subject = SecurityUtils.getSubject();
    ShiroMember currUser = null;
    if (subject.isAuthenticated()) {
      currUser = (ShiroMember)subject.getPrincipal();
    }
    Map map = new HashMap();
    map.put("memberid", currUser.getId() + "");
    map.put("pageNow", pageNow);
    map.put("orderStatusDesc", orderstatusdesc);
    map.put("pageSize", Const.INVESTORDER_PAGE_SIZE + "");
    return this.investorderservice.selectInvestOrderByPage(map);
  }
}