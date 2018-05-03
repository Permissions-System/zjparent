package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.ActivityLog;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ActivityLogDao
{
  public abstract void insert(ActivityLog paramActivityLog);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.ActivityLogDao
 * JD-Core Version:    0.5.3
 */