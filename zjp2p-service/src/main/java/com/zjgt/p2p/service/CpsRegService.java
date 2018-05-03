package com.zjgt.p2p.service;

import com.zjgt.p2p.model.CpsInvestinfo;
import com.zjgt.p2p.model.CpsLog;
import com.zjgt.p2p.model.Cpsrec;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface CpsRegService
{
  public abstract void cpsRec(Cpsrec paramCpsrec, String paramString)
    throws BusinessException;

  public abstract void cpsinvestrec(CpsInvestinfo paramCpsInvestinfo)
    throws BusinessException;

  public abstract void cpslog(CpsLog paramCpsLog)
    throws BusinessException;

  public abstract void insertCpsRec(Cpsrec paramCpsrec)
    throws BusinessException;

  public abstract List<Cpsrec> findByMemberid(Long paramLong, String paramString)
    throws BusinessException;

  public abstract void CommisionTrans()
    throws BusinessException;

  public abstract void CommisionTrans(Date paramDate)
    throws BusinessException;
}