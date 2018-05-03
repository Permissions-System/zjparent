package com.zjgt.p2p.service;

import com.zjgt.p2p.common.dict.AcctTranDef;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface PlatformService
{
  public abstract int platformAcctAllot(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);

  public abstract int platformToMember(Long paramLong1, Long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, AcctTranDef paramAcctTranDef)
    throws BusinessException;
}