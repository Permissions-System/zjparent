package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.ActivityLog;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IActivityLogService
{
  public abstract void insert(ActivityLog paramActivityLog)
    throws BusinessException;
}