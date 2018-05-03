package com.zjgt.p2p.scheduler.impl;

import com.zjgt.p2p.service.BidService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.utils.SpringContextUtil;

public class SchedulerPublishBidJob
  implements Job
{
  Logger logger;

  public SchedulerPublishBidJob()
  {
    this.logger = LoggerFactory.getLogger(SchedulerPublishBidJob.class);
  }

  public void execute(JobExecutionContext context) throws JobExecutionException {
    String bid = context.getTrigger().getKey().getGroup();
    this.logger.info("定时发布任务:开始,bid=" + bid);
    BidService bidService = (BidService)SpringContextUtil.getBean(BidService.class);
    bidService.updatePublishtime(Integer.valueOf(bid));
    this.logger.info("定时发布任务:结束,bid=" + bid);
  }
}