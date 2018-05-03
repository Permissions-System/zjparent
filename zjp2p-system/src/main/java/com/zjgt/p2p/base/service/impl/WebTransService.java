package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.WebTransDao;
import com.zjgt.p2p.base.domain.WebTrans;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IWebTransService;
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
public class WebTransService
  implements IWebTransService
{

  @Autowired
  private WebTransDao webTransDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  public void insert(WebTrans webTrans)
    throws BusinessException
  {
    validateWebTrans(webTrans);
    try {
      this.webTransDao.insert(webTrans);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPWRTJ01", null, e));
    }
  }

  public void update(WebTrans webTrans)
    throws BusinessException
  {
    try
    {
      this.webTransDao.update(webTrans);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPWRXG01", null, e));
    }
  }

  public void delete(String transCode)
    throws BusinessException
  {
    try
    {
      this.webTransDao.delete(transCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPWRSC01", null, e));
    }
  }

  public WebTrans getWebTransInfo(String transCode)
    throws BusinessException
  {
    return this.webTransDao.getWebTransInfo(transCode);
  }

  public int getCountWebTransInfo(String transCode)
    throws BusinessException
  {
    return this.webTransDao.getCountWebTransInfo(transCode);
  }

  public Integer getRecheckLevel(String transCode)
    throws BusinessException
  {
    return ((this.webTransDao.getRecheckLevel(transCode) == null) ? new Integer(1) : this.webTransDao.getRecheckLevel(transCode));
  }

  public String getRecheckDetailPage(String transCode)
    throws BusinessException
  {
    return this.webTransDao.getRecheckDetailPage(transCode);
  }

  public String getRecheckHandlePage(String transCode)
    throws BusinessException
  {
    return this.webTransDao.getRecheckHandlePage(transCode);
  }

  private void validateWebTrans(WebTrans webTrans)
  {
	  Set<ConstraintViolation<WebTrans>>  result = this.validator.validate(webTrans, new Class[0]);

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

  public List<WebTrans> getWebTransInfoListByProductCode(String productCode)
    throws BusinessException
  {
    return this.webTransDao.getWebTransInfoListByProductCode(productCode);
  }

  public Page<WebTrans> getWebTransInfoListByPage(Map<String, Object> map, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    map.put("pageObject", page);
    page.setResult(this.webTransDao.getWebTransInfoListByPage(map));
    return page;
  }
}