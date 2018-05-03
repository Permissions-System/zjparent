package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.BonusDetailType;
import com.zjgt.p2p.common.BonusType;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.BonusMapper;
import com.zjgt.p2p.dao.MembersafetyMapper;
import com.zjgt.p2p.model.Bonus;
import com.zjgt.p2p.model.BonusExample;
import com.zjgt.p2p.model.BonusExample.Criteria;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.Membersafety;
import com.zjgt.p2p.model.MembersafetyExample;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.service.BonusService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import com.zjgt.p2p.service.TranslogService;
import com.zjgt.util.StringUtil;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BonusServiceImpl
  implements BonusService
{

  @Autowired
  private BonusMapper mapper;

  @Autowired
  private MemberAcctService memberAcctService;

  @Autowired
  private MembersafetyMapper safedao;

  @Autowired
  private MemberService memberService;

  @Autowired
  private ISerialService serialService;
  private BigDecimal zeroDef;

  @Autowired
  private MemberAccountService accountingService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private TranslogService translogService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private MessageService messageService;
  Logger logger;

  public BonusServiceImpl()
  {
    this.zeroDef = BigDecimal.ZERO;

    this.logger = LoggerFactory.getLogger(BonusServiceImpl.class);
  }

  public Page<Bonus> getBonusesByPage(Map<String, String> map)
  {
    int pageNow = 0;
    Page pages = null;
    BonusExample exam = new BonusExample();
    BonusExample.Criteria crit = exam.createCriteria();
    Iterator i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry entry = (Map.Entry)i.next();
      String key = (String)entry.getKey();
      String value = (String)map.get(key);

      if (("BonusStatus".equals(key)) && 
        (StringUtil.isNotEmpty(value)) && 
        (!("0".equals(value)))) {
        crit.andStatusEqualTo(Integer.valueOf(Integer.parseInt(value)));
      }

      if (("BonusType".equals(key)) && 
        (StringUtil.isNotEmpty(value)) && 
        (!("0".equals(value)))) {
        crit.andBonustypeEqualTo(Integer.valueOf(Integer.parseInt(value)));
      }

      if (("Memberid".equals(key)) && 
        (StringUtil.isNotEmpty(value))) {
        crit.andMemberidEqualTo(Long.valueOf(Long.parseLong(value)));
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
    pages.setResult(this.mapper.selectByExample(exam));
    return pages;
  }

  @Transactional
  public Translog tranBonuse(Long memberId, BigDecimal tranAmount, AcctTranDef tran)
  {
    if ((tranAmount == null) || (tranAmount.compareTo(this.zeroDef) <= 0)) {
      throw new BusinessException("金额不能小于或等于 0 :" + tranAmount);
    }
    if ((!(tran.equals(AcctTranDef.BONUS_BIDLOSE_UNFROZEN))) && (!(tran.equals(AcctTranDef.BONUS_DEDUCT))) && (!(tran.equals(AcctTranDef.BONUS_FROZEN))) && (!(tran.equals(AcctTranDef.BONUS_RANSOM_UNFROZEN)))) {
      throw new BusinessException("无效的交易码:" + tran.getTranName());
    }

    Member member = this.memberService.findMemberByid(memberId.longValue());
    MemberAcct acctBonus = this.memberAcctService.findByMemberIdForUpdate(memberId, Integer.valueOf(AcctType.GIFT.getKey()));
    MemberAcct basicAcctInfo = this.memberAcctService.findByMemberId(memberId);

    MemberAccount memberAccount = this.accountingService.getByMemberIdForUpdate(memberId);

    PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(20L));

    Translog translog = new Translog();

    if (tran.getiOrOut().equals("O"))
    {
      if (tran.equals(AcctTranDef.BONUS_FROZEN)) {
        if (acctBonus.getBlance().compareTo(tranAmount) < 0) {
          throw new BusinessException("红包账户可用余额为" + acctBonus.getBlance() + ",无法使用 " + tranAmount);
        }

        acctBonus.setFreezeBlance(acctBonus.getFreezeBlance().add(tranAmount));

        acctBonus.setBlance(acctBonus.getBlance().subtract(tranAmount));
      }
      else if (tran.equals(AcctTranDef.BONUS_DEDUCT)) {
        if (acctBonus.getAccount().compareTo(tranAmount) < 0) {
          throw new BusinessException("红包账户金额为" + acctBonus.getBlance() + ",无法扣除 " + tranAmount);
        }

        acctBonus.setFreezeBlance(acctBonus.getFreezeBlance().subtract(tranAmount));

        acctBonus.setAccount(acctBonus.getAccount().subtract(tranAmount));

        platformAcct.setBlance(platformAcct.getBlance().subtract(tranAmount));
        platformAcct.setAccount(platformAcct.getAccount().subtract(tranAmount));
        memberAccount.setUsedgoldaccount(memberAccount.getUsedgoldaccount().add(tranAmount));
      }

    }
    else if ((tran.getiOrOut().equals("I")) && ((
      (tran.equals(AcctTranDef.BONUS_BIDLOSE_UNFROZEN)) || (tran.equals(AcctTranDef.BONUS_RANSOM_UNFROZEN))))) {
      if (acctBonus.getFreezeBlance().compareTo(tranAmount) < 0) {
        throw new BusinessException("红包账户冻结金额为" + acctBonus.getFreezeBlance() + ",无法解冻 " + tranAmount);
      }

      acctBonus.setFreezeBlance(acctBonus.getFreezeBlance().subtract(tranAmount));

      acctBonus.setBlance(acctBonus.getBlance().add(tranAmount));
    }

    this.memberAcctService.save(acctBonus);
    memberAccount.setGoldaccount(acctBonus.getAccount());
    memberAccount.setGoldblance(acctBonus.getBlance());
    memberAccount.setFreezegoldblance(acctBonus.getFreezeBlance());
    this.accountingService.save(memberAccount);

    if (tran.equals(AcctTranDef.BONUS_DEDUCT)) {
      this.platformAcctService.updateAccountHandle(Long.valueOf(20L), tranAmount, "O");
    }

    translog.setTranstime(DateUtils.getCurrentDate());
    translog.setTranscode(String.valueOf(tran.getTranCode()));
    translog.setTransdesc(String.valueOf(tran.getShowName()));
    translog.setAmount(tranAmount);

    translog.setAvailamount(basicAcctInfo.getBlance());
    translog.setCurrency("CNY");
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setTransstatus(Integer.valueOf(1));
    if (tran.equals(AcctTranDef.BONUS_DEDUCT))
    {
      translog.setPayaccounttype(Integer.valueOf(1));
      translog.setPaymemberid(null);
      translog.setPayaccountid(platformAcct.getAcctid());
      translog.setPayaccountno(null);
      translog.setPayername(platformAcct.getAcctName());
      translog.setPaycardnum(null);
      translog.setPaysubamount(platformAcct.getBlance());

      translog.setPayeeaccounttype(Integer.valueOf(0));
      translog.setPayeememberid(Integer.valueOf(memberId.intValue()));
      translog.setPayeeaccountid(memberAccount.getId());
      translog.setPayeeaccountno(null);
      translog.setPayeename(member.getRealname());
      translog.setPayeecardnum(null);
      translog.setPayeesubamount(acctBonus.getBlance());
    }
    else {
      translog.setPayaccounttype(Integer.valueOf(0));
      translog.setPaymemberid(Integer.valueOf(memberId.intValue()));
      translog.setPayaccountid(memberAccount.getId());
      translog.setPayaccountno(null);
      translog.setPayername(member.getRealname());
      translog.setPaycardnum(null);
      translog.setPaysubamount(acctBonus.getBlance());
    }

    return translog;
  }

  @Transactional
  public void addRegBonus(Long memberId)
  {
    BigDecimal regBonusAmount = new BigDecimal(1000);

    Bonus bonus = new Bonus();
    bonus.setBonustype(Integer.valueOf(1));
    Map serialParams = new HashMap();
    serialParams.put("HOUR", DateUtils.getCurrentFormatDate("HH"));
    bonus.setBonusno(this.serialService.getSerial("regBonusNo", serialParams));
    bonus.setMemberid(memberId);
    bonus.setBegindate(new Date());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date enddate = format.parse("2018-01-01");
      bonus.setEnddate(enddate);
    } catch (ParseException e) {
      this.logger.warn("解析enddate错误", e);
    }
    bonus.setAccount(regBonusAmount);
    bonus.setSource(Integer.valueOf(1));
    bonus.setBlance(regBonusAmount);
    bonus.setSubject("可在购买时加息0.5%（天天富产品除外）");

    Map paramMap = new HashMap();
    paramMap.put("bonustype", bonus.getBonustype());
    paramMap.put("memberid", bonus.getMemberid());
    List bonusList = this.mapper.selectByMap(paramMap);

    if ((bonusList == null) || (bonusList.isEmpty())) {
      save(bonus);

      MemberAcct macct = new MemberAcct();
      macct.setAccount(regBonusAmount);
      macct.setAcctName(AcctType.GIFT.getValue());
      macct.setAcctType(Integer.valueOf(AcctType.GIFT.getKey()));
      macct.setCreateDate(new Date());
      macct.setBlance(regBonusAmount);
      macct.setMemberid(memberId);
      macct.setModifyDate(new Date());
      macct.setUpdateDate(new Date());
      macct.setMembertype(Integer.valueOf(0));
      this.memberAcctService.save(macct);

      MemberAccount memberAccount = this.accountingService.getByMemberIdForUpdate(memberId);
      memberAccount.setGoldaccount(macct.getAccount());
      memberAccount.setGoldblance(macct.getBlance());
      this.accountingService.save(memberAccount);

      this.messageService.sendMessage("message.bonus", memberId.longValue(), new String[] { "注册", String.valueOf(regBonusAmount) });
    }
  }

  public int save(Bonus bonus)
  {
    int result = 0;
    if ((bonus != null) && (bonus.getId() != null))
      result = this.mapper.updateByPrimaryKeySelective(bonus);
    else {
      result = this.mapper.insertSelective(bonus);
    }
    return result;
  }

  @Transactional
  public void addReferralBonus(Long memberid)
  {
    BonusExample example = new BonusExample();
    example.createCriteria().andBonusdetailtypeEqualTo(BonusDetailType.BYREFERRAL.getKey() + "").andRelativenoEqualTo(memberid.toString());
    int size = this.mapper.selectByExample(example).size();

    Member member = this.memberService.findMemberByid(memberid.longValue());
    Long agentid = member.getAgentid();

    Bonus bonus = new Bonus();
    bonus.setBonustype(Integer.valueOf(BonusType.TUIJIANHONGBAO.getKey()));
    Map serialParams = new HashMap();
    serialParams.put("HOUR", DateUtils.getCurrentFormatDate("HH"));
    bonus.setBonusno(this.serialService.getSerial("recommendBonusNo", serialParams));
    bonus.setMemberid(agentid);
    bonus.setBegindate(new Date());
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date enddate = format.parse("2018-01-01");
      bonus.setEnddate(enddate);
    } catch (ParseException e) {
      this.logger.warn("解析enddate错误", e);
    }
    bonus.setAccount(new BigDecimal(50));
    bonus.setSource(Integer.valueOf(2));
    bonus.setBlance(new BigDecimal(50));
    bonus.setBonusdetailtype(BonusDetailType.BYREFERRAL.getKey() + "");
    bonus.setRelativeno(memberid.toString());
    bonus.setSubject("可在购买时加息0.5%（天天富产品除外）");

    MembersafetyExample exam = new MembersafetyExample();
    exam.createCriteria().andMemberidEqualTo(memberid);
    Membersafety membersafety = (Membersafety)this.safedao.selectByExample(exam).get(0);

    if ((size == 0) && (agentid != null) && (agentid.longValue() != 0L) && (membersafety.getMobileifverified().intValue() == 1) && (membersafety.getEmailifverified().intValue() == 1) && (membersafety.getIdcardifverified().intValue() == 1)) {
      save(bonus);

      MemberAcct macct = this.memberAcctService.findByMemberId(agentid, Integer.valueOf(AcctType.GIFT.getKey()));
      macct.setAccount(macct.getAccount().add(bonus.getAccount()));
      macct.setBlance(macct.getBlance().add(bonus.getBlance()));
      macct.setModifyDate(new Date());
      macct.setUpdateDate(new Date());
      this.memberAcctService.save(macct);

      MemberAccount memberAccount = this.accountingService.getByMemberIdForUpdate(agentid);
      memberAccount.setGoldaccount(macct.getAccount());
      memberAccount.setGoldblance(macct.getBlance());
      this.accountingService.save(memberAccount);

      this.messageService.sendMessage("message.bonus", agentid.longValue(), new String[] { "推荐好友", "50" });
    }
  }

  public List<Bonus> getBonusCountInfo(Map<String, Object> paramMap)
  {
    List list = new ArrayList();
    list = this.mapper.selectByMap(paramMap);
    return list;
  }

  public Page<Map<String, Object>> getBonusUseListByPage(Map<String, Object> paramMap)
  {
    int pageNow = 0;
    if (paramMap.get("pageNow") == null)
      pageNow = 1;
    else {
      pageNow = Integer.valueOf(paramMap.get("pageNow").toString()).intValue();
    }
    Page pages = new Page();
    pages.setPageNo(pageNow);
    pages.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
    paramMap.put("pageObject", pages);
    pages.setResult(this.mapper.selectUseList(paramMap));
    return pages;
  }
}