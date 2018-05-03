package com.zjgt.p2p.service.impl;

import com.zjgt.p2p.common.BidType;
import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.dao.PlatformAcctMapper;
import com.zjgt.p2p.model.PlatformAcct;
import com.zjgt.p2p.model.PlatformAcctExample;
import com.zjgt.p2p.model.PlatformAcctExample.Criteria;
import com.zjgt.p2p.model.PlatformAsset;
import com.zjgt.p2p.service.PlatformAcctService;
import com.zjgt.p2p.service.PlatformAssetService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("platformAcctService")
public class PlatformAcctServiceImpl
  implements PlatformAcctService
{

  @Autowired
  private PlatformAcctMapper pltacctdao;

  @Autowired
  private PlatformAssetService platformAssetService;

  public PlatformAcct findByacctid(Long acctid, String transName, int bidclassNo)
    throws BusinessException
  {
    if (bidclassNo == BidType.MINGXINGBIAO.getKey()) {
      acctid = Long.valueOf(11L);
    }
    else if ((transName == AcctTranDef.FILL.getTranName()) || (transName == AcctTranDef.WITHDRAW_FEE.getTranName()))
      acctid = Long.valueOf(30L);
    else if ((transName == AcctTranDef.FAILEDBID.getTranName()) || (transName == AcctTranDef.DEDUCT.getTranName()) || (transName == AcctTranDef.PAY_TO_BORROWER.getTranName()))
      acctid = Long.valueOf(10L);
    else if ((transName == AcctTranDef.REDEM_FEE.getTranName()) || (transName == AcctTranDef.PUB_FEE.getTranName()) || (transName == AcctTranDef.INFO_FEE.getTranName()) || (transName == AcctTranDef.OVERDUE_FEE.getTranName()) || (transName == AcctTranDef.UNPAID_FEE.getTranName()))
      acctid = Long.valueOf(30L);
    else if ((transName == AcctTranDef.REPAY.getTranName()) || (transName == AcctTranDef.ADJUST_SUBTRACT.getTranName()))
      acctid = Long.valueOf(50L);
    else if (transName == AcctTranDef.REDEM.getTranName()) {
      acctid = Long.valueOf(31L);
    }

    if (transName == AcctTranDef.COMMISS_RETURN.getTranName()) {
      acctid = Long.valueOf(20L);
    }
    PlatformAcctExample example = new PlatformAcctExample();
    example.createCriteria().andAcctidEqualTo(acctid);
    List list = this.pltacctdao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((PlatformAcct)list.get(0));
    }
    return null;
  }

  public PlatformAcct findByacctidForPlat(Long acctid)
    throws BusinessException
  {
    PlatformAcctExample example = new PlatformAcctExample();
    example.createCriteria().andAcctidEqualTo(acctid);
    List list = this.pltacctdao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return ((PlatformAcct)list.get(0));
    }
    return null;
  }

  public int save(PlatformAcct acct) throws BusinessException
  {
    int a = 0;
    if ((acct != null) && (acct.getId() != null))
      a = this.pltacctdao.updateByPrimaryKeySelective(acct);
    else {
      a = this.pltacctdao.insertSelective(acct);
    }
    return a;
  }

  public List<PlatformAcct> selectAll() throws BusinessException
  {
    PlatformAcctExample example = new PlatformAcctExample();
    List list = this.pltacctdao.selectByExample(example);
    if ((list != null) && (!(list.isEmpty()))) {
      return list;
    }
    return null;
  }

  @Transactional
  public void updateAccountHandle(Long acctid, BigDecimal money, String inorout) throws BusinessException
  {
    PlatformAcct acct = findByacctidForPlat(acctid);
    PlatformAsset asset = this.platformAssetService.findAsset();
    acct.setModifyDate(new Date());
    if ("I".equals(inorout)) {
      acct.setBlance(acct.getBlance().add(money));
      asset.setBlance(asset.getBlance().add(money));
      acct.setAccount(acct.getAccount().add(money));
      asset.setAccount(asset.getAccount().add(money));
    }
    else {
      if ((acctid.longValue() != 20L) && (acctid.longValue() != 30L) && (money.compareTo(acct.getBlance()) > 0)) {
        throw new BusinessException("平台" + acct.getAcctName() + "账户资金不足");
      }
      acct.setBlance(acct.getBlance().subtract(money));
      asset.setBlance(asset.getBlance().subtract(money));
      acct.setAccount(acct.getAccount().subtract(money));
      asset.setAccount(asset.getAccount().subtract(money));
    }
    save(acct);
    this.platformAssetService.save(asset);
  }
}