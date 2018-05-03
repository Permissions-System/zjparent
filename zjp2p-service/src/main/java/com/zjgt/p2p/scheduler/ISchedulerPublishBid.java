package com.zjgt.p2p.scheduler;

import java.util.Date;
import org.quartz.SchedulerException;

public abstract interface ISchedulerPublishBid
{
  public abstract Date publishBid(Date paramDate, int paramInt)
    throws SchedulerException;

  public abstract Date dotrans(Date paramDate, String paramString)
    throws SchedulerException;
}