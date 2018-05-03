package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.ActivityLog;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IActivityLogService
{
  public abstract void insert(ActivityLog paramActivityLog)
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IActivityLogService
 * JD-Core Version:    0.5.3
 */