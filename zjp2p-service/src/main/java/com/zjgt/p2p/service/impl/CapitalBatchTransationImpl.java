package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.Const;
import com.zjgt.p2p.common.Const.FEES;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.Capitaltrans;
import com.zjgt.p2p.model.Member;
import com.zjgt.p2p.model.MemberAccount;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.model.Translog;
import com.zjgt.p2p.service.CapitalBatchTransation;
import com.zjgt.p2p.service.CapitalTransService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.MemberService;
import com.zjgt.p2p.service.MessageService;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import com.zjgt.p2p.service.PlatformService;
import com.zjgt.p2p.service.TranslogService;
import com.zjgt.thirdpay.util.PayLogUtil;
import com.zjgt.util.PropertiesUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("capitalBatchTransation")
public class CapitalBatchTransationImpl
  implements CapitalBatchTransation
{

  @Autowired
  private MemberService memberService;

  @Autowired
  private MemberAcctService acctService;

  @Autowired
  private MemberAccountService accountingService;

  @Autowired
  private CapitalTransService capitalTransService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private PlatformAssetService platformAssetService;

  @Autowired
  private TranslogService translogService;

  @Autowired
  private MessageService messageService;

  @Autowired
  private PlatformService platformService;

  public int initMemberAccount(int memberid)
  {
    int result = 0;

    return result;
  }

  public int dealCapitalTrans(String transCode, int memberid)
  {
    return 0;
  }

  public int fillCapital(String memberid, BigDecimal account, String transNo, int payGateway)
  {
    MemberAcct acctInfo = this.acctService.findByMemberId(Long.valueOf(memberid));
    PlatformAsset platformAsset = this.platformAssetService.findAsset();

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.FILL.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(acctInfo.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(acctInfo.getMemberid().intValue()));
    capitalTrans.setRealname(acctInfo.getAcctName());
    capitalTrans.setAmount(account);
    capitalTrans.setAvailamount(acctInfo.getBlance().add(capitalTrans.getAmount()));

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(null);
    capitalTrans.setTransstatus(Integer.valueOf(0));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(String.valueOf(AcctTranDef.FILL.getTranCode()));
    translog.setTransdesc(String.valueOf(AcctTranDef.FILL.getShowName()));
    translog.setAmount(account);
    translog.setAvailamount(acctInfo.getBlance().add(translog.getAmount()));
    translog.setCurrency("CNY");
    translog.setPlatavailamount(platformAsset.getBlance());
    translog.setPayaccounttype(Integer.valueOf(2));
    translog.setPayaccountid(null);
    translog.setPayaccountno(null);
    if (payGateway == 1)
      translog.setPayername("微钱包");
    else {
      translog.setPayername("连连");
    }
    translog.setPaycardnum(null);
    translog.setPaysubamount(null);

    translog.setPayeeaccounttype(Integer.valueOf(0));
    translog.setPayeememberid(Integer.valueOf(memberid));
    translog.setPayeeaccountid(acctInfo.getMemberAcctid());
    translog.setPayeeaccountno(null);
    translog.setPayeename(acctInfo.getAcctName());
    translog.setPayeecardnum(null);
    translog.setPayeesubamount(acctInfo.getBlance().add(translog.getAmount()));

    translog.setTransstatus(Integer.valueOf(0));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int fillCapitalRespond(String memberid, BigDecimal account, String transNo, Integer status)
  {
    if (1 == status.intValue())
    {
      this.accountingService.tranAccounting(Long.valueOf(memberid), AcctTranDef.FILL, account, "CNY");
      if ("true".equals(PropertiesUtils.getProperties("activity.recharge.switch")))
      {
        long currTimeLong = Long.valueOf(DateUtils.getCurrentFormatDate("yyyyMMddHHmmss")).longValue();
        String activityStartTime = PropertiesUtils.getProperties("activity.recharge.startTime");
        String activityEndTime = PropertiesUtils.getProperties("activity.recharge.endTime");
        if ((activityStartTime != null) && (currTimeLong > Long.valueOf(activityStartTime).longValue()) && (activityEndTime != null) && (currTimeLong < Long.valueOf(activityEndTime).longValue()))
        {
          String thresholdAmount = PropertiesUtils.getProperties("activity.recharge.thresholdAmount");

          if ((account.compareTo(new BigDecimal(thresholdAmount)) != -1) && (this.capitalTransService.getRechargeSuccessCount(Long.valueOf(memberid)) == 0))
          {
            String activityTranAmount = PropertiesUtils.getProperties("activity.recharge.giveAmount");
            this.platformService.platformToMember(Long.valueOf(20L), Long.valueOf(memberid), "10", activityTranAmount, "现场充值1元即可再获得5元现金，可投资可提现", transNo, AcctTranDef.FILL);
          }
        }
      }
    }

    this.capitalTransService.updateStatusByTransNo(transNo, status.intValue());
    return 0;
  }

  public int withdrawal(String memberid, BigDecimal withdrawalAccount, BigDecimal fees, String transNo, int payGateway) throws BusinessException
  {
    Member oldmember = this.memberService.findMemberByid(Long.valueOf(memberid).longValue());
    MemberAccount accountInfo = this.accountingService.getByMemberId(Long.valueOf(memberid));
    MemberAcct acctInfo = this.acctService.findByMemberId(Long.valueOf(memberid));
    BigDecimal acctInfoBlance = acctInfo.getBlance();

    this.accountingService.tranAccounting(Long.valueOf(memberid), AcctTranDef.FROZEN, withdrawalAccount, "CNY");

    PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(30L));
    PlatformAsset platformAsset = this.platformAssetService.findAsset();

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.WITHDRAW.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(accountInfo.getId().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(accountInfo.getMemberid().intValue()));
    capitalTrans.setRealname(oldmember.getRealname());
    capitalTrans.setAmount(withdrawalAccount);

    capitalTrans.setFees(fees);
    capitalTrans.setFeerate(null);

    capitalTrans.setAvailamount(acctInfoBlance.subtract(capitalTrans.getAmount()));

    capitalTrans.setTransstatus(Integer.valueOf(0));

    List translogList = new ArrayList();

    Translog drawalTranslog = new Translog();
    drawalTranslog.setTranstime(capitalTrans.getTranstime());
    drawalTranslog.setTranscode(String.valueOf(AcctTranDef.WITHDRAW.getTranCode()));
    drawalTranslog.setTransdesc(String.valueOf(AcctTranDef.WITHDRAW.getShowName()));
    drawalTranslog.setAmount(withdrawalAccount.subtract(fees));
    drawalTranslog.setAvailamount(acctInfoBlance.subtract(drawalTranslog.getAmount()));
    drawalTranslog.setCurrency("CNY");

    drawalTranslog.setPlatavailamount(platformAsset.getBlance());

    drawalTranslog.setPayaccounttype(Integer.valueOf(0));
    drawalTranslog.setPaymemberid(Integer.valueOf(memberid));
    drawalTranslog.setPayaccountid(accountInfo.getId());
    drawalTranslog.setPayaccountno(null);
    drawalTranslog.setPayername(oldmember.getRealname());
    drawalTranslog.setPaycardnum(null);
    drawalTranslog.setPaysubamount(acctInfoBlance.subtract(drawalTranslog.getAmount()));

    drawalTranslog.setPayeeaccounttype(null);
    drawalTranslog.setPayeememberid(null);
    drawalTranslog.setPayeeaccountno(null);
    if (payGateway == 1)
      drawalTranslog.setPayeename("微钱包");
    else {
      drawalTranslog.setPayeename("连连");
    }
    drawalTranslog.setPayeecardnum(null);
    drawalTranslog.setPayeesubamount(platformAcct.getBlance());

    drawalTranslog.setPayeeaccounttype(Integer.valueOf(2));
    drawalTranslog.setTransstatus(Integer.valueOf(0));
    translogList.add(drawalTranslog);

    Translog feeTranslog = new Translog();
    feeTranslog.setTranstime(capitalTrans.getTranstime());
    feeTranslog.setTranscode(String.valueOf(AcctTranDef.WITHDRAW_FEE.getTranCode()));
    feeTranslog.setTransdesc(String.valueOf(AcctTranDef.WITHDRAW_FEE.getShowName()));
    feeTranslog.setCurrency("CNY");

    if (fees.compareTo(BigDecimal.ZERO) > 0) {
      feeTranslog.setAmount(fees);

      feeTranslog.setPlatavailamount(platformAsset.getBlance().add(fees));
      feeTranslog.setAvailamount(acctInfoBlance.subtract(withdrawalAccount));

      feeTranslog.setPayaccounttype(Integer.valueOf(0));
      feeTranslog.setPaymemberid(Integer.valueOf(memberid));
      feeTranslog.setPayaccountid(accountInfo.getId());
      feeTranslog.setPayaccountno(null);
      feeTranslog.setPayername(oldmember.getRealname());
      feeTranslog.setPaycardnum(null);
      feeTranslog.setPaysubamount(acctInfoBlance.subtract(withdrawalAccount));

      feeTranslog.setPayeeaccounttype(Integer.valueOf(1));
      feeTranslog.setPayeememberid(null);
      feeTranslog.setPayeeaccountid(platformAcct.getAcctid());
      feeTranslog.setPayeeaccountno(null);
      feeTranslog.setPayeename(platformAcct.getAcctName());
      feeTranslog.setPayeecardnum(null);
      feeTranslog.setPayeesubamount(platformAcct.getBlance().add(fees));
    }
    else
    {
      feeTranslog.setAmount(Const.FEES.SINA_FROM_BIIFOO);

      feeTranslog.setPlatavailamount(platformAsset.getBlance().subtract(Const.FEES.SINA_FROM_BIIFOO));
      feeTranslog.setAvailamount(acctInfoBlance.subtract(withdrawalAccount));

      feeTranslog.setPayaccounttype(Integer.valueOf(1));
      feeTranslog.setPaymemberid(null);
      feeTranslog.setPayaccountid(platformAcct.getAcctid());
      feeTranslog.setPayaccountno(null);
      feeTranslog.setPayername(platformAcct.getAcctName());
      feeTranslog.setPaycardnum(null);
      feeTranslog.setPaysubamount(platformAcct.getBlance().subtract(Const.FEES.SINA_FROM_BIIFOO));

      feeTranslog.setPayeeaccounttype(Integer.valueOf(2));
      feeTranslog.setPayeememberid(null);
      feeTranslog.setPayeeaccountid(null);
      feeTranslog.setPayeeaccountno(null);
      if (payGateway == 1)
        feeTranslog.setPayeename("微钱包平台");
      else {
        feeTranslog.setPayeename("连连平台");
      }
      feeTranslog.setPayeecardnum(null);
      feeTranslog.setPayeesubamount(null);
    }
    feeTranslog.setTransstatus(Integer.valueOf(0));
    translogList.add(feeTranslog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int withdrawalRespond(String memberid, String transNo, Integer status, Integer dealFlowStatus) throws BusinessException {
    Capitaltrans capitaltrans = this.capitalTransService.getCapitaltransByTransNo(transNo);

    if (1 == status.intValue()) {
      BigDecimal tranAmount = capitaltrans.getAmount();

      if (2 == dealFlowStatus.intValue()) {
        PayLogUtil.log("第一次返回失败,后面返回成功,直接修改可用余额账户总资产,{},{},{}", new Object[] { transNo, status, dealFlowStatus });

        MemberAccount memberAccount = this.accountingService.getByMemberIdForUpdate(Long.valueOf(memberid));

        MemberAcct memberAcct = this.acctService.findByMemberIdForUpdate(Long.valueOf(memberid));
        PayLogUtil.log("{},memberAcct.account{},memberAcct.blance{}", new Object[] { tranAmount, memberAcct.getAccount(), memberAcct.getBlance() });
        memberAcct.setAccount(memberAcct.getAccount().subtract(tranAmount));
        memberAcct.setBlance(memberAcct.getBlance().subtract(tranAmount));
        memberAccount.setAccount(memberAccount.getAccount().subtract(tranAmount));
        memberAccount.setBlance(memberAccount.getBlance().subtract(tranAmount));
        PayLogUtil.log("{},memberAccount.Account{},memberAccount.Blance{}", new Object[] { tranAmount, memberAccount.getAccount(), memberAccount.getBlance() });
        this.acctService.save(memberAcct);
        this.accountingService.save(memberAccount);
      } else {
        this.accountingService.tranAccounting(Long.valueOf(memberid), AcctTranDef.WITHDRAW, tranAmount, "CNY");
      }
      this.translogService.updatePlatformTransLog(transNo);

      if (capitaltrans.getFees().compareTo(BigDecimal.ZERO) == 0)
      {
        this.platformAcctService.updateAccountHandle(Long.valueOf(30L), Const.FEES.SINA_FROM_BIIFOO, "O");
      }
      else {
        this.platformAcctService.updateAccountHandle(Long.valueOf(30L), capitaltrans.getFees(), "I");
      }

      MemberAcct memberAcct = this.acctService.findByMemberIdForUpdate(Long.valueOf(memberid));

      this.messageService.sendMessage("message.takecash", Long.valueOf(memberid).longValue(), new String[] { String.valueOf(tranAmount), String.valueOf(memberAcct.getBlance()) });
    } else {
      PayLogUtil.log("交易{}提现出错,为用户{}解冻{}", new Object[] { transNo, memberid, capitaltrans.getAmount() });

      this.accountingService.tranAccounting(Long.valueOf(memberid), AcctTranDef.UNFROZEN, capitaltrans.getAmount(), "CNY");
    }

    this.capitalTransService.updateStatusByTransNo(transNo, status.intValue());
    return 0;
  }

  public int fillCapitalByPlatform(Long platformid, BigDecimal account, String transNo)
  {
    PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(platformid);

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.PLATFILL.getTranCode()));

    capitalTrans.setMemberAcctid(null);
    capitalTrans.setMemberid(null);
    capitalTrans.setRealname(null);
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(null);

    capitalTrans.setPayaccounttype(Integer.valueOf(-1));
    capitalTrans.setPayaccountid(null);
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(null);
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(1));
    capitalTrans.setPayeeaccountid(platformAcct.getAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(platformAcct.getAcctName());
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.PLATFILL.getTranCode());
    translog.setTransdesc(AcctTranDef.PLATFILL.getShowName());
    translog.setAmount(account);
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(-1));
    translog.setPayaccountid(null);
    translog.setPayaccountno(null);
    translog.setPayername(null);
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(1));
    translog.setPayeememberid(null);
    translog.setPayeesubamount(platformAcct.getBlance());
    translog.setPayeeaccountid(platformAcct.getAcctid());
    translog.setPayeeaccountno(null);
    translog.setPayeename(platformAcct.getAcctName());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int withdrawalByPlatform(Long platformid, BigDecimal account, BigDecimal fees, String transNo) throws BusinessException {
    PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(platformid);

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.PLATWITHDRAW.getTranCode()));
    capitalTrans.setMemberAcctid(null);
    capitalTrans.setMemberid(null);
    capitalTrans.setRealname(null);
    capitalTrans.setAmount(account);

    capitalTrans.setFees(fees);
    capitalTrans.setFeerate(null);

    capitalTrans.setPayaccounttype(Integer.valueOf(1));
    capitalTrans.setPayaccountid(platformAcct.getAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(platformAcct.getAcctName());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccountid(null);
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(null);
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setPayeeaccounttype(Integer.valueOf(-1));
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();

    Translog drawalTranslog = new Translog();
    drawalTranslog.setTranstime(capitalTrans.getTranstime());
    drawalTranslog.setTranscode(AcctTranDef.PLATWITHDRAW.getTranCode());
    drawalTranslog.setTransdesc(AcctTranDef.PLATWITHDRAW.getShowName());
    drawalTranslog.setAmount(account);
    drawalTranslog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    drawalTranslog.setCurrency("CNY");

    drawalTranslog.setPayaccounttype(Integer.valueOf(1));
    drawalTranslog.setPaymemberid(null);
    drawalTranslog.setPayaccountid(platformAcct.getAcctid());
    drawalTranslog.setPaysubamount(platformAcct.getBlance());
    drawalTranslog.setPayaccountno(null);
    drawalTranslog.setPayername(platformAcct.getAcctName());
    drawalTranslog.setPaycardnum(null);

    drawalTranslog.setPayeeaccountid(null);
    drawalTranslog.setPayeeaccountno(null);
    drawalTranslog.setPayeename(null);
    drawalTranslog.setPayeecardnum(null);
    drawalTranslog.setPayeeaccounttype(Integer.valueOf(-1));
    drawalTranslog.setTransstatus(Integer.valueOf(1));

    translogList.add(drawalTranslog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int platformToPlatform(String formAcctid, String toAcctid, BigDecimal account, String transNo, String remark) {
    PlatformAcct formAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(formAcctid));
    PlatformAcct toAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(toAcctid));

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.ALLOT.getTranCode()));
    capitalTrans.setMemberAcctid(null);
    capitalTrans.setMemberid(null);
    capitalTrans.setRealname(null);
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(remark);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    capitalTrans.setPayaccounttype(Integer.valueOf(1));
    capitalTrans.setPayaccountid(formAcct.getAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(formAcct.getAcctName());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(1));
    capitalTrans.setPayeeaccountid(toAcct.getAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(toAcct.getAcctName());
    capitalTrans.setPayeecardnum(null);

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.ALLOT.getTranCode());
    translog.setTransdesc(AcctTranDef.ALLOT.getShowName());
    translog.setAmount(account);
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(1));
    translog.setPaymemberid(Integer.valueOf(formAcct.getId().intValue()));
    translog.setPayaccountid(formAcct.getAcctid());
    translog.setPaysubamount(formAcct.getBlance());
    translog.setPayaccountno(null);
    translog.setPayername(formAcct.getAcctName());
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(1));
    translog.setPayeememberid(Integer.valueOf(toAcct.getId().intValue()));
    translog.setPayeeaccountid(toAcct.getAcctid());
    translog.setPayeesubamount(toAcct.getBlance());
    translog.setPayeeaccountno(null);
    translog.setPayeename(toAcct.getAcctName());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int platmemToPlatform(String memberId, String toAcctid, BigDecimal account, String transNo, String remark) {
    MemberAcct formAcct = this.acctService.findByMemberId(Long.valueOf(memberId));
    PlatformAcct toAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(toAcctid));
    Member formMember = this.memberService.findMemberByid(Long.valueOf(memberId).longValue());
    MemberAccount formAccount = this.accountingService.getByMemberId(Long.valueOf(memberId));

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.ALLOT.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(formAcct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(formAcct.getMemberid().intValue()));
    capitalTrans.setAvailamount(formAcct.getBlance());
    capitalTrans.setRealname(formMember.getRealname());
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(remark);

    capitalTrans.setPayaccounttype(Integer.valueOf(4));
    capitalTrans.setPayaccountid(formAcct.getMemberAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(formMember.getRealname());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(1));
    capitalTrans.setPayeeaccountid(toAcct.getAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(toAcct.getAcctName());
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.ALLOT.getTranCode());
    translog.setTransdesc(AcctTranDef.ALLOT.getShowName());
    translog.setAmount(account);
    translog.setAvailamount(formAccount.getBlance());
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(4));
    translog.setPaymemberid(Integer.valueOf(formAcct.getMemberid().intValue()));
    translog.setPayaccountid(formAcct.getMemberAcctid());
    translog.setPaysubamount(formAcct.getBlance());
    translog.setPayaccountno(null);
    translog.setPayername(formMember.getRealname());
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(1));
    translog.setPayeememberid(Integer.valueOf(toAcct.getId().intValue()));
    translog.setPayeeaccountid(toAcct.getAcctid());
    translog.setPayeesubamount(toAcct.getBlance());
    translog.setPayeeaccountno(null);
    translog.setPayeename(toAcct.getAcctName());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  @Deprecated
  public int platformToPlatmem(String formAcctid, String memberId, BigDecimal account, String transNo, String remark) {
    PlatformAcct formAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(formAcctid));
    MemberAcct toAcct = this.acctService.findByMemberIdForUpdate(Long.valueOf(memberId));
    Member toMember = this.memberService.findMemberByid(Long.valueOf(memberId).longValue());
    MemberAccount toAccount = this.accountingService.getByMemberId(Long.valueOf(memberId));

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.ALLOT.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(toAcct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(toAcct.getMemberid().intValue()));
    capitalTrans.setRealname(toMember.getRealname());
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(remark);

    capitalTrans.setPayaccounttype(Integer.valueOf(1));
    capitalTrans.setPayaccountid(formAcct.getAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(formAcct.getAcctName());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(4));
    capitalTrans.setPayeeaccountid(toAcct.getMemberAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(toMember.getRealname());
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.ALLOT.getTranCode());
    translog.setTransdesc(AcctTranDef.ALLOT.getShowName());
    translog.setAmount(account);
    translog.setAvailamount(toAccount.getBlance());
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(1));
    translog.setPaymemberid(Integer.valueOf(formAcct.getId().intValue()));
    translog.setPayaccountid(formAcct.getAcctid());
    translog.setPaysubamount(formAcct.getBlance());
    translog.setPayaccountno(null);
    translog.setPayername(formAcct.getAcctName());
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(4));
    translog.setPayeememberid(Integer.valueOf(toAcct.getMemberid().intValue()));
    translog.setPayeeaccountid(toAcct.getMemberAcctid());
    translog.setPayeesubamount(toAcct.getBlance());
    translog.setPayeeaccountno(null);
    translog.setPayeename(toMember.getRealname());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int platformToPlatmem(Long formAcctid, Long toAcctid, BigDecimal account, String transNo, String remark, AcctTranDef tran)
  {
    PlatformAcct formAcct = this.platformAcctService.findByacctidForPlat(formAcctid);
    MemberAcct toAcct = this.acctService.findByacctidForUpdate(toAcctid);
    Member toMember = this.memberService.findMemberByid(toAcct.getMemberid().longValue());
    MemberAccount toAccount = this.accountingService.getByMemberId(toAcct.getMemberid());

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(tran.getTranCode()));
    capitalTrans.setMemberAcctid(Integer.valueOf(toAcct.getMemberAcctid().intValue()));
    capitalTrans.setMemberid(Integer.valueOf(toAcct.getMemberid().intValue()));
    capitalTrans.setRealname(toMember.getRealname());
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(remark);

    capitalTrans.setPayaccounttype(Integer.valueOf(1));
    capitalTrans.setPayaccountid(formAcct.getAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(formAcct.getAcctName());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(3));
    capitalTrans.setPayeeaccountid(toAcct.getMemberAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(toMember.getRealname());
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(tran.getTranCode());
    translog.setTransdesc(tran.getShowName());
    translog.setAmount(account);
    translog.setAvailamount(toAccount.getBlance());
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(1));
    translog.setPaymemberid(Integer.valueOf(formAcct.getId().intValue()));
    translog.setPayaccountid(formAcct.getAcctid());
    translog.setPaysubamount(formAcct.getBlance());
    translog.setPayaccountno(null);
    translog.setPayername(formAcct.getAcctName());
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(3));
    translog.setPayeememberid(Integer.valueOf(toAcct.getMemberid().intValue()));
    translog.setPayeeaccountid(toAcct.getMemberAcctid());
    translog.setPayeesubamount(toAcct.getBlance());
    translog.setPayeeaccountno(null);
    translog.setPayeename(toMember.getRealname());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }

  public int platmemToPlatmem(String formMemberId, String toMemberId, BigDecimal account, String transNo, String remark) {
    MemberAcct formAcct = this.acctService.findByMemberId(Long.valueOf(formMemberId));
    MemberAcct toAcct = this.acctService.findByMemberId(Long.valueOf(toMemberId));
    Member formMember = this.memberService.findMemberByid(formAcct.getMemberid().longValue());
    Member toMember = this.memberService.findMemberByid(toAcct.getMemberid().longValue());
    MemberAccount formAccount = this.accountingService.getByMemberId(formAcct.getMemberid());
    MemberAccount toAccount = this.accountingService.getByMemberId(toAcct.getMemberid());

    Capitaltrans capitalTrans = new Capitaltrans();

    capitalTrans.setTransno(transNo);
    capitalTrans.setTranstime(new Date());

    capitalTrans.setTranstype(Integer.valueOf(AcctTranDef.ALLOT.getTranCode()));
    capitalTrans.setMemberAcctid(null);
    capitalTrans.setMemberid(null);
    capitalTrans.setRealname(formMember.getRealname());
    capitalTrans.setAmount(account);

    capitalTrans.setFees(null);
    capitalTrans.setFeerate(null);
    capitalTrans.setRemark(remark);

    capitalTrans.setPayaccounttype(Integer.valueOf(4));
    capitalTrans.setPayaccountid(formAcct.getMemberAcctid());
    capitalTrans.setPayaccountno(null);
    capitalTrans.setPayername(formMember.getRealname());
    capitalTrans.setPaycardnum(null);

    capitalTrans.setPayeeaccounttype(Integer.valueOf(4));
    capitalTrans.setPayeeaccountid(toAcct.getMemberAcctid());
    capitalTrans.setPayeeaccountno(null);
    capitalTrans.setPayeename(toMember.getRealname());
    capitalTrans.setPayeecardnum(null);
    capitalTrans.setTransstatus(Integer.valueOf(1));

    List translogList = new ArrayList();
    Translog translog = new Translog();
    translog.setTranstime(capitalTrans.getTranstime());
    translog.setTranscode(AcctTranDef.ALLOT.getTranCode());
    translog.setTransdesc(AcctTranDef.ALLOT.getShowName());
    translog.setAmount(account);
    translog.setAvailamount(formAccount.getBlance());
    translog.setPlatavailamount(this.platformAssetService.findAsset().getBlance());
    translog.setCurrency("CNY");

    translog.setPayaccounttype(Integer.valueOf(4));
    translog.setPaymemberid(Integer.valueOf(formAcct.getMemberid().intValue()));
    translog.setPayaccountid(formAcct.getMemberAcctid());
    translog.setPaysubamount(formAcct.getBlance());
    translog.setPayaccountno(null);
    translog.setPayername(formMember.getRealname());
    translog.setPaycardnum(null);

    translog.setPayeeaccounttype(Integer.valueOf(4));
    translog.setPayeememberid(Integer.valueOf(toAcct.getMemberid().intValue()));
    translog.setPayeeaccountid(toAcct.getMemberAcctid());
    translog.setPayeesubamount(toAcct.getBlance());
    translog.setPayeeaccountno(null);
    translog.setPayeename(toMember.getRealname());
    translog.setPayeecardnum(null);
    translog.setTransstatus(Integer.valueOf(1));
    translogList.add(translog);
    capitalTrans.setTranLogs(translogList);
    this.capitalTransService.add(capitalTrans);
    return 0;
  }
}