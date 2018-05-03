package com.zjgt.p2p.scheduler.impl;

import com.zjgt.p2p.scheduler.ISchedulerPublishBid;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SchedulerPublishBid
  implements ISchedulerPublishBid
{
  Logger logger;
  final SimpleDateFormat dateFormat;

  public SchedulerPublishBid()
  {
    this.logger = LoggerFactory.getLogger(SchedulerPublishBid.class);

    this.dateFormat = new SimpleDateFormat("yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒"); }

  public Date publishBid(Date publishDate, int bidId) throws SchedulerException {
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();
    JobDetail job = JobBuilder.newJob(SchedulerPublishBidJob.class).withIdentity("SchedulerPublishBidJob:" + bidId, String.valueOf(bidId)).build();
    SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("SchedulerPublishBidTrigger:" + bidId, String.valueOf(bidId)).startAt(publishDate).build();

    Date ft = sched.scheduleJob(job, trigger);
    this.logger.info(job.getKey().getName() + " 将在 : " + this.dateFormat.format(ft) + " 时运行.并且重复: " + trigger.getRepeatCount() + " 次, 每次间隔 " + (trigger.getRepeatInterval() / 1000L) + " 秒");
    return ft;
  }

  public Date dotrans(Date enddate, String ordercode) throws SchedulerException {
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();
    JobDetail job = JobBuilder.newJob(SchedulerTransfailJob.class).withIdentity("SchedulerTransfailJob:" + ordercode, ordercode).build();
    SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("SchedulerTransfailTrigger:" + ordercode, ordercode).startAt(enddate).build();

    Date ft = sched.scheduleJob(job, trigger);
    this.logger.info(job.getKey().getName() + " 将在 : " + this.dateFormat.format(ft) + " 时运行.并且重复: " + trigger.getRepeatCount() + " 次, 每次间隔 " + (trigger.getRepeatInterval() / 1000L) + " 秒");
    return ft;
  }
}