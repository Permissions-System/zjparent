package com.zjgt.p2p.service;

import com.zjgt.p2p.model.Translog;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface TranslogService
{
  public abstract int add(Translog paramTranslog);

  public abstract org.springfk.pancloud.paginator.vo.Page<Translog> getTranslogs(Map<String, String> paramMap)
    throws BusinessException;

  public abstract org.springfk.pancloud.paginator.vo.Page<Translog> getTranslogs2(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    throws BusinessException, ParseException;

  public abstract org.springfk.pancloud.paginator.vo.Page<Translog> getCapitalTransByPage(Map<String, String> paramMap);

  public abstract com.zjgt.util.Page<Translog> getTranslogplatByPage(Map<String, String> paramMap)
    throws BusinessException;

  public abstract void updatePlatformTransLog(String paramString);

  public abstract List<Translog> selectLastIncome(Long paramLong);

  public abstract int updateWithdrawFailDesc(Map<String, String> paramMap);
}