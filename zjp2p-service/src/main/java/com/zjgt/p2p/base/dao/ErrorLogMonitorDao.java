package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.ErrorLogMonitor;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ErrorLogMonitorDao
{
  public abstract int insert(ErrorLogMonitor paramErrorLogMonitor);

  public abstract int update(ErrorLogMonitor paramErrorLogMonitor);

  public abstract int delete(String paramString);

  public abstract ErrorLogMonitor selectByPrimaryKey(String paramString);

  public abstract List<ErrorLogMonitor> selectAll();

  public abstract int getCountLogMonitorInfo(String paramString);

  public abstract List<ErrorLogMonitor> getErrorLogMonitorListByPage(Map<String, Object> paramMap);
}