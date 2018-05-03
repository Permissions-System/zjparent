package com.zjgt.p2p.scheduler.impl;

import com.zjgt.p2p.service.InvestOrderService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.utils.SpringContextUtil;

public class SchedulerTransfailJob
  implements Job
{
  Logger logger;

  public SchedulerTransfailJob()
  {
    this.logger = LoggerFactory.getLogger(SchedulerTransfailJob.class);
  }

  public void execute(JobExecutionContext context) throws JobExecutionException {
    String ordercode = context.getTrigger().getKey().getGroup();
    InvestOrderService investOrderService = (InvestOrderService)SpringContextUtil.getBean(InvestOrderService.class);

    if (!(investOrderService.isTransed(ordercode))) {
      investOrderService.doTransFail(ordercode);
    }
    this.logger.info("已执行任务");
  }
}