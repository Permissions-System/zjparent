package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.LoginLocaleDao;
import com.zjgt.p2p.base.domain.LoginLocale;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.ILoginLocaleService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginLocaleService
  implements ILoginLocaleService
{

  @Autowired
  private LoginLocaleDao loginLocaleDao;

  @Autowired
  private IErrorLogsService errorLogsService;

  public void addLoginLocale(LoginLocale record)
    throws BusinessException
  {
    try
    {
      record.setRecNo(UUIDUtils.generate());
      this.loginLocaleDao.insert(record);
    } catch (Exception e) {
      throw new BusinessException(this.errorLogsService.writeErrorLog(super.getClass(), "CPLILG01", null, e));
    }
  }

  public void updateLoginLocale(LoginLocale record)
    throws BusinessException
  {
    this.loginLocaleDao.update(record);
  }

  public boolean hasLogin(LoginLocale record) throws BusinessException
  {
    return false;
  }

  public void recordLoginLocale(LoginLocale record)
    throws BusinessException
  {
    SimpleDateFormat format;
    if (getLoginLocaleByUserNoAndLocale(record.getUserNo(), record.getLocale()) == null) {
      record.setRecNo(UUIDUtils.generate());
      record.setLoginTimes(1);
      format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
      record.setLastTime(format.format(new Date()));
      addLoginLocale(record);
    } else {
      record.setLoginTimes(record.getLoginTimes() + 1);
      format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
      record.setLastTime(format.format(new Date()));
      updateLoginLocale(record);
    }
  }

  public LoginLocale getLoginLocaleByUserNoAndLocale(String userNo, String locale)
    throws BusinessException
  {
    return this.loginLocaleDao.getLoginLocaleByUserNoAndLocale(userNo, locale);
  }

  public List<LoginLocale> getLoginLocaleByUserNo(String userNo) throws BusinessException
  {
    return this.loginLocaleDao.selectByUserNo(userNo);
  }

  public List<LoginLocale> getLoginLocaleGreaterThanThreshold(String userNo, int threshold)
    throws BusinessException
  {
    return this.loginLocaleDao.getLoginLocaleGreaterThanThreshold(userNo, threshold);
  }
}