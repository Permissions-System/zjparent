package com.zjgt.p2p.service;

import com.zjgt.p2p.common.dict.AcctTranDef;
import com.zjgt.p2p.model.Bonus;
import com.zjgt.p2p.model.Translog;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface BonusService
{
  public abstract Page<Bonus> getBonusesByPage(Map<String, String> paramMap);

  public abstract List<Bonus> getBonusCountInfo(Map<String, Object> paramMap);

  public abstract Translog tranBonuse(Long paramLong, BigDecimal paramBigDecimal, AcctTranDef paramAcctTranDef);

  public abstract void addRegBonus(Long paramLong);

  public abstract int save(Bonus paramBonus);

  public abstract void addReferralBonus(Long paramLong);

  public abstract Page<Map<String, Object>> getBonusUseListByPage(Map<String, Object> paramMap);
}