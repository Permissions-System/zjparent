package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.AcctType;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.MemberAcct;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.service.CapitalBatchTransation;
import com.zjgt.p2p.service.InvestOrderService;
import com.zjgt.p2p.service.MemberAccountService;
import com.zjgt.p2p.service.MemberAcctService;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformService;
import java.math.BigDecimal;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("platformService")
public class PlatformServiceImpl
  implements PlatformService
{

  @Autowired
  private CapitalBatchTransation capitalBatchTransation;

  @Autowired
  private MemberAccountService memberAccountService;

  @Autowired
  private PlatformAcctService platformAcctService;

  @Autowired
  private InvestOrderService investOrderService;

  @Autowired
  private MemberAcctService memberAcctService;

  @Transactional
  public int platformAcctAllot(String fromAcct, String toAcct, String allotAmount, String allotRemark, String platNo)
  {
    PlatformAcct fromPlatformAcct;
    if ((fromAcct.contains("platform")) && (toAcct.contains("platform"))) {
      fromAcct = fromAcct.substring(8);
      fromPlatformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(fromAcct));
      if (new BigDecimal(allotAmount).compareTo(fromPlatformAcct.getAccount()) > 0) {
        return -1;
      }
      fromPlatformAcct.setAccount(fromPlatformAcct.getAccount().subtract(new BigDecimal(allotAmount)));
      fromPlatformAcct.setBlance(fromPlatformAcct.getBlance().subtract(new BigDecimal(allotAmount)));
      this.platformAcctService.save(fromPlatformAcct);
      toAcct = toAcct.substring(8);
      PlatformAcct toPlatformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(toAcct));
      toPlatformAcct.setAccount(toPlatformAcct.getAccount().add(new BigDecimal(allotAmount)));
      toPlatformAcct.setBlance(toPlatformAcct.getBlance().add(new BigDecimal(allotAmount)));
      this.platformAcctService.save(toPlatformAcct);
      this.capitalBatchTransation.platformToPlatform(fromAcct, toAcct, new BigDecimal(allotAmount), platNo, allotRemark);
      return 1;
    }
    if ((fromAcct.contains("platform")) && (toAcct.contains("member"))) {
      fromAcct = fromAcct.substring(8);
      fromPlatformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(fromAcct));
      if (new BigDecimal(allotAmount).compareTo(fromPlatformAcct.getAccount()) > 0) {
        return -1;
      }

      this.platformAcctService.updateAccountHandle(fromPlatformAcct.getAcctid(), new BigDecimal(allotAmount), "O");
      toAcct = toAcct.substring(6);
      this.memberAccountService.updateAccountHandle(Long.valueOf(toAcct), new BigDecimal(allotAmount), "I", AcctType.BASIC.getKey());
      this.capitalBatchTransation.platformToPlatmem(fromAcct, toAcct, new BigDecimal(allotAmount), platNo, allotRemark);
      return 1; }
    if ((fromAcct.contains("member")) && (toAcct.contains("platform"))) {
      fromAcct = fromAcct.substring(6);
      this.memberAccountService.updateAccountHandle(Long.valueOf(fromAcct), new BigDecimal(allotAmount), "O", AcctType.BASIC.getKey());
      toAcct = toAcct.substring(8);
      PlatformAcct toPlatformAcct = this.platformAcctService.findByacctidForPlat(Long.valueOf(toAcct));

      this.platformAcctService.updateAccountHandle(toPlatformAcct.getAcctid(), new BigDecimal(allotAmount), "I");
      this.capitalBatchTransation.platmemToPlatform(fromAcct, toAcct, new BigDecimal(allotAmount), platNo, allotRemark);
      return 1; }
    if ((fromAcct.contains("member")) && (toAcct.contains("member"))) {
      fromAcct = fromAcct.substring(6);
      this.memberAccountService.updateAccountHandle(Long.valueOf(fromAcct), new BigDecimal(allotAmount), "O", AcctType.BASIC.getKey());
      toAcct = toAcct.substring(6);
      this.memberAccountService.updateAccountHandle(Long.valueOf(toAcct), new BigDecimal(allotAmount), "I", AcctType.BASIC.getKey());
      this.capitalBatchTransation.platmemToPlatmem(fromAcct, toAcct, new BigDecimal(allotAmount), platNo, allotRemark);
      return 1;
    }
    return 0;
  }

  @Transactional
  public int platformToMember(Long platAcct, Long memberID, String acctType, String amount, String remark, String transNo, AcctTranDef tran)
    throws BusinessException
  {
    PlatformAcct platformAcct = this.platformAcctService.findByacctidForPlat(platAcct);
    this.platformAcctService.updateAccountHandle(platformAcct.getAcctid(), new BigDecimal(amount), "O");
    MemberAcct memAcct = this.memberAcctService.findByMemberIdForUpdate(Long.valueOf(memberID.longValue()), Integer.valueOf(acctType));
    if (memAcct == null) {
      throw new BusinessException("账户不存在");
    }
    this.memberAccountService.updateAccountHandle(Long.valueOf(memberID.longValue()), new BigDecimal(amount), "I", Integer.valueOf(acctType).intValue());
    this.capitalBatchTransation.platformToPlatmem(Long.valueOf(platAcct.longValue()), memAcct.getMemberAcctid(), new BigDecimal(amount), transNo, remark, tran);
    return 1;
  }
}