package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.ActivityLogDao;
import com.zjgt.p2p.base.domain.ActivityLog;
import com.zjgt.p2p.base.domain.User;
import com.zjgt.p2p.base.service.IActivityLogService;
import com.zjgt.p2p.common.UserContext;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ActivityLogService
  implements IActivityLogService
{
  private final Logger logger;

  @Autowired
  private ActivityLogDao activityLogDao;

  public ActivityLogService()
  {
    this.logger = LoggerFactory.getLogger(super.getClass());
  }

  public void insert(ActivityLog activityLog)
    throws BusinessException
  {
    activityLog.setRecNo(UUIDUtils.generate());
    Format format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    activityLog.setOperTime(format.format(new Date()));
    User user = UserContext.getUser();
    String sessionId = ((user != null) && (user.getSessionId() != null)) ? user.getSessionId() : "";
    if (sessionId.equals("")) {
      sessionId = "no session";
    }
    activityLog.setSessionId(sessionId);
    this.activityLogDao.insert(activityLog);
    this.logger.debug("insert activity log successfully");
  }
}