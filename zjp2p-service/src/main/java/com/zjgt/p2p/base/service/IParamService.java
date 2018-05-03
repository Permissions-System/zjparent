package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Param;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface IParamService
{
  public abstract Param getParam(String paramString1, String paramString2)
    throws BusinessException;

  public abstract String getParamValue(String paramString1, String paramString2)
    throws BusinessException;

  public abstract void update(Param paramParam)
    throws BusinessException;

  public abstract void add(Param paramParam)
    throws BusinessException;

  public abstract void delete(String paramString1, String paramString2)
    throws BusinessException;

  public abstract Page<Param> getParamListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract Map<String, String> getParamByProductAndName(String paramString, String[] paramArrayOfString)
    throws BusinessException;
}