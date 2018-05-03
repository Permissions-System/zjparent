package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.MemberAccountMapper;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAccountExample;
import com.zjgt.p2p.model.MemberAccountExample.Criteria;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountServiceImpl
  implements MemberAccountService
{

  @Autowired
  private MemberAccountMapper memberAccountMapper;

  @Autowired
  private MemberAcctService acctService;
  private BigDecimal zeroDef;

  public MemberAccountServiceImpl()
  {
    this.zeroDef = BigDecimal.ZERO; }

  public void tranAccounting(Long memberid, AcctTranDef tran, BigDecimal tranAmount, String currencyType) throws BusinessException {
    if (tranAmount.compareTo(this.zeroDef) <= 0) {
      throw new BusinessException("金额不能小于或等于 0 :" + tranAmount);
    }
    if (memberid == null) {
      throw new BusinessException("账户号不能为空:" + memberid);
    }

    MemberAccount memberAccount = getByMemberIdForUpdate(memberid);

    MemberAcct memberAcct = this.acctService.findByMemberIdForUpdate(memberid);
    if (memberAccount == null) {
      throw new BusinessException("账户不存在:" + memberid);
    }

    if (tran.getiOrOut().equals("O")) {
      adjustOutAcccount(tran, memberAccount, memberAcct, tranAmount);
    }
    else if (tran.getiOrOut().equals("I"))
      adjustInAcccount(tran, memberAccount, memberAcct, tranAmount);
    else
      throw new BusinessException("this transaction direction is not fit for this function:" + tran.getTranName());
  }

  private void adjustOutAcccount(AcctTranDef tran, MemberAccount acctInfo, MemberAcct memberAcct, BigDecimal tranAmount)
    throws BusinessException
  {
    if (tranAmount.compareTo(this.zeroDef) <= 0) {
      throw new BusinessException("金额不能小于或等于0:" + tranAmount);
    }
    if (tran.getAmountFlag().equals("B"))
    {
      if (acctInfo.getBlance().compareTo(tranAmount) < 0) {
        throw new BusinessException("可用余额为" + acctInfo.getBlance() + ",无法转出 " + tranAmount);
      }
      acctInfo.setBlance(acctInfo.getBlance().subtract(tranAmount));

      if (!(tran.equals(AcctTranDef.FROZEN))) {
        acctInfo.setAccount(acctInfo.getAccount().subtract(tranAmount));
      }
      memberAcct.setBlance(memberAcct.getBlance().subtract(tranAmount));

      if (!(tran.equals(AcctTranDef.FROZEN)))
        memberAcct.setAccount(memberAcct.getAccount().subtract(tranAmount));
    }
    else {
      if (acctInfo.getFreezeBlance().compareTo(tranAmount) < 0) {
        throw new BusinessException("冻结金额为:" + acctInfo.getFreezeBlance() + ",小于预期金额 " + tranAmount);
      }
      acctInfo.setFreezeBlance(acctInfo.getFreezeBlance().subtract(tranAmount));
      acctInfo.setAccount(acctInfo.getAccount().subtract(tranAmount));
      memberAcct.setFreezeBlance(memberAcct.getFreezeBlance().subtract(tranAmount));
      memberAcct.setAccount(memberAcct.getAccount().subtract(tranAmount));
    }

    if (tran.equals(AcctTranDef.FROZEN)) {
      acctInfo.setFreezeBlance(acctInfo.getFreezeBlance().add(tranAmount));
      memberAcct.setFreezeBlance(memberAcct.getFreezeBlance().add(tranAmount));
    }
    save(acctInfo);
    this.acctService.save(memberAcct);
  }

  private void adjustInAcccount(AcctTranDef tran, MemberAccount acctInfo, MemberAcct memberAcct, BigDecimal tranAmount) throws BusinessException
  {
    if (tranAmount.compareTo(this.zeroDef) <= 0) {
      throw new BusinessException("金额不能小于或等于0:" + tranAmount);
    }

    acctInfo.setBlance(acctInfo.getBlance().add(tranAmount));
    memberAcct.setBlance(memberAcct.getBlance().add(tranAmount));

    if (tran.equals(AcctTranDef.UNFROZEN)) {
      if (acctInfo.getFreezeBlance().compareTo(tranAmount) < 0) {
        throw new BusinessException("解冻金额: " + tranAmount + ",实际冻结金额为:" + acctInfo.getFreezeBlance());
      }
      acctInfo.setFreezeBlance(acctInfo.getFreezeBlance().subtract(tranAmount));
      memberAcct.setFreezeBlance(memberAcct.getFreezeBlance().subtract(tranAmount));
    }
    else {
      acctInfo.setAccount(acctInfo.getAccount().add(tranAmount));
      memberAcct.setAccount(memberAcct.getAccount().add(tranAmount));
    }
    save(acctInfo);
    this.acctService.save(memberAcct);
  }

  public MemberAccount getById(Long id)
  {
    return this.memberAccountMapper.selectByPrimaryKey(id);
  }

  public MemberAccount getByMemberId(Long memberid)
  {
    MemberAccountExample accountExample = new MemberAccountExample();
    MemberAccountExample.Criteria crite = accountExample.createCriteria();
    crite.andMemberidEqualTo(memberid);
    List accounts = this.memberAccountMapper.selectByExample(accountExample);
    if ((accounts != null) && (!(accounts.isEmpty()))) {
      return ((MemberAccount)accounts.get(0));
    }
    return null;
  }

  public void save(MemberAccount memberAccount)
  {
    if ((memberAccount != null) && (memberAccount.getId() != null))
      this.memberAccountMapper.updateByPrimaryKeySelective(memberAccount);
    else
      this.memberAccountMapper.insertSelective(memberAccount);
  }

  public void updateAccountHandle(Long memberid, BigDecimal money, String inorout, int acctType) throws BusinessException
  {
    switch (acctType)
    {
    case 10:
      updateAccountHandleByBasic(memberid, money, inorout); break;
    case 20:
      updateAccountHandleByGift(memberid, money, inorout); break;
    case 30:
      updateAccountHandleByComm(memberid, money, inorout); break;
    default:
      updateAccountHandleByBasic(memberid, money, inorout);
    }
  }

  private void updateAccountHandleByBasic(Long memberid, BigDecimal money, String inorout) throws BusinessException
  {
    MemberAcct acct = this.acctService.findByMemberIdForUpdate(memberid);
    MemberAccount account = getByMemberIdForUpdate(memberid);
    acct.setModifyDate(new Date());
    if ("I".equals(inorout)) {
      acct.setBlance(acct.getBlance().add(money));
      account.setBlance(account.getBlance().add(money));
    } else {
      if (money.compareTo(acct.getBlance()) > 0) {
        throw new BusinessException("会员账户金额不足！");
      }
      acct.setBlance(acct.getBlance().subtract(money));
      account.setBlance(account.getBlance().subtract(money));
    }
    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
    account.setAccount(account.getBlance().add(account.getFreezeBlance()));
    this.acctService.save(acct);
    save(account);
  }

  private void updateAccountHandleByGift(Long memberid, BigDecimal money, String inorout) throws BusinessException
  {
    MemberAcct acct = this.acctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.GIFT.getKey()));
    MemberAccount account = getByMemberIdForUpdate(memberid);
    acct.setModifyDate(new Date());
    if ("I".equals(inorout)) {
      acct.setBlance(acct.getBlance().add(money));
      account.setGoldblance(account.getGoldblance().add(money));
    } else {
      if (money.compareTo(acct.getBlance()) > 0) {
        throw new BusinessException("会员账户金额不足！");
      }
      acct.setBlance(acct.getBlance().subtract(money));
      account.setGoldblance(account.getGoldblance().subtract(money));
    }
    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
    account.setGoldaccount(account.getGoldblance().add(account.getFreezegoldblance()));
    this.acctService.save(acct);
    save(account);
  }

  private void updateAccountHandleByComm(Long memberid, BigDecimal money, String inorout) throws BusinessException
  {
    MemberAcct acct = this.acctService.findByMemberIdForUpdate(memberid, Integer.valueOf(AcctType.COMMISSION.getKey()));
    MemberAccount account = getByMemberIdForUpdate(memberid);
    acct.setModifyDate(new Date());
    if ("I".equals(inorout)) {
      acct.setBlance(acct.getBlance().add(money));
      account.setCommisionaccount(account.getCommisionaccount().add(money));
      account.setCommisiontotalaccount(account.getCommisiontotalaccount().add(money));
    } else {
      if (money.compareTo(acct.getBlance()) > 0) {
        throw new BusinessException("会员账户金额不足！");
      }
      acct.setBlance(acct.getBlance().subtract(money));
      account.setCommisionaccount(account.getCommisionaccount().subtract(money));
      account.setCommisiontotalaccount(account.getCommisiontotalaccount().subtract(money));
    }
    acct.setAccount(acct.getBlance().add(acct.getFreezeBlance()));
    this.acctService.save(acct);
    save(account);
  }

  public Map<String, Object> selectAccountSummaryByMemberId(Long memberId)
  {
    Map paramMap = new HashMap();
    paramMap.put("memberId", memberId);
    return this.memberAccountMapper.selectAccountSummary(paramMap);
  }

  public MemberAccount getByMemberIdForUpdate(Long memberId) throws BusinessException
  {
    return this.memberAccountMapper.selectByMemberIdForUpdate(memberId);
  }

  public Map<String, Object> selectAccountSumByMemberId(Long memberId)
  {
    Map paramMap = new HashMap();
    paramMap.put("memberId", memberId);
    return this.memberAccountMapper.selectAccountSum(paramMap);
  }
}