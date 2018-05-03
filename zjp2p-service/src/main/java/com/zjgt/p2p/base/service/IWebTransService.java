package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.WebTrans;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface IWebTransService
{
  public abstract void insert(WebTrans paramWebTrans)
    throws BusinessException;

  public abstract void update(WebTrans paramWebTrans)
    throws BusinessException;

  public abstract void delete(String paramString)
    throws BusinessException;

  public abstract WebTrans getWebTransInfo(String paramString)
    throws BusinessException;

  public abstract int getCountWebTransInfo(String paramString)
    throws BusinessException;

  public abstract Integer getRecheckLevel(String paramString)
    throws BusinessException;

  public abstract String getRecheckDetailPage(String paramString)
    throws BusinessException;

  public abstract String getRecheckHandlePage(String paramString)
    throws BusinessException;

  public abstract List<WebTrans> getWebTransInfoListByProductCode(String paramString)
    throws BusinessException;

  public abstract Page<WebTrans> getWebTransInfoListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
}