package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.ActivityLog;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ActivityLogDao
{
  public abstract void insert(ActivityLog paramActivityLog);
}