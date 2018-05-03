package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.ErrorLogMonitorDao;
import com.zjgt.p2p.base.domain.ErrorLogMonitor;
import com.zjgt.p2p.base.service.IErrorLogMonitorService;
import com.zjgt.p2p.base.service.IErrorLogsService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ErrorLogMonitorService
  implements IErrorLogMonitorService
{

  @Autowired
  private ErrorLogMonitorDao errorLogMonitorDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  private void validateErrorLogMonitor(ErrorLogMonitor errorLogMonitor)
  {
	  Set<ConstraintViolation<ErrorLogMonitor>>  result = this.validator.validate(errorLogMonitor, new Class[0]);

    if (!(result.isEmpty())) {
      String errMessage = "";
      for (ConstraintViolation constraintViolation : result) {
        errMessage = errMessage + constraintViolation.getMessageTemplate() + ";";
      }

      BusinessException ex = new BusinessException(errMessage);
      ex.setErrorMessages(result);
      throw ex;
    }
  }

  public void insert(ErrorLogMonitor errorLogMonitor)
    throws BusinessException
  {
    validateErrorLogMonitor(errorLogMonitor);
    try {
      this.errorLogMonitorDao.insert(errorLogMonitor);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMOTJ01", null, e));
    }
  }

  public void update(ErrorLogMonitor errorLogMonitor)
    throws BusinessException
  {
    try
    {
      this.errorLogMonitorDao.update(errorLogMonitor);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMOXG01", null, e));
    }
  }

  public void delete(String errorCode)
    throws BusinessException
  {
    try
    {
      this.errorLogMonitorDao.delete(errorCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMOSC01", null, e));
    }
  }

  public ErrorLogMonitor getErrorLogMonitorInfo(String errorCode)
    throws BusinessException
  {
    return this.errorLogMonitorDao.selectByPrimaryKey(errorCode);
  }

  public List<ErrorLogMonitor> selectAll()
    throws BusinessException
  {
    return this.errorLogMonitorDao.selectAll();
  }

  public int getCountLogMonitorInfo(String errorCode)
    throws BusinessException
  {
    return this.errorLogMonitorDao.getCountLogMonitorInfo(errorCode);
  }

  public Page<ErrorLogMonitor> getLogMonitorInfoListByPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.errorLogMonitorDao.getErrorLogMonitorListByPage(params));
    return page;
  }
}