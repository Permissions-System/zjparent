package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.ErrorLogMonitor;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface IErrorLogMonitorService
{
  public abstract void insert(ErrorLogMonitor paramErrorLogMonitor)
    throws BusinessException;

  public abstract void update(ErrorLogMonitor paramErrorLogMonitor)
    throws BusinessException;

  public abstract void delete(String paramString)
    throws BusinessException;

  public abstract ErrorLogMonitor getErrorLogMonitorInfo(String paramString)
    throws BusinessException;

  public abstract List<ErrorLogMonitor> selectAll()
    throws BusinessException;

  public abstract int getCountLogMonitorInfo(String paramString)
    throws BusinessException;

  public abstract Page<ErrorLogMonitor> getLogMonitorInfoListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
}