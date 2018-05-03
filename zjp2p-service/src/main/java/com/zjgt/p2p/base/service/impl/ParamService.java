package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.ParamDao;
import com.zjgt.p2p.base.domain.Param;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IParamService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ParamService
  implements IParamService
{

  @Autowired
  ParamDao paramDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  private void validateTask(Param param)
  {
    Set result = this.validator.validate(param, new Class[0]);
    if (!(result.isEmpty())) {
      BusinessException ex = new BusinessException("数据校验错误");
      ex.setErrorMessages(result);
      throw ex;
    }
  }

  public Param getParam(String productCode, String paramEnName)
    throws BusinessException
  {
    Param param = new Param();
    param.setProductCode(productCode);
    param.setParamEnName(paramEnName);
    try {
      return this.paramDao.getParam(param);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0004", null, e));
    }
  }

  public String getParamValue(String productCode, String paramEnName)
    throws BusinessException
  {
    Param param = getParam(productCode, paramEnName);

    if (null != param) {
      return param.getParamValue();
    }
    return null;
  }

  public void update(Param param)
    throws BusinessException
  {
    validateTask(param);
    try {
      this.paramDao.update(param);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0001", null, e));
    }
  }

  public void add(Param param)
    throws BusinessException
  {
    validateTask(param);
    try {
      this.paramDao.insert(param);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0003", null, e));
    }
  }

  public void delete(String productCode, String paramEnName)
    throws BusinessException
  {
    Param param = new Param();
    param.setProductCode(productCode);
    param.setParamEnName(paramEnName);
    try {
      this.paramDao.delete(param);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0002", null, e));
    }
  }

  public Page<Param> getParamListByPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    try {
      page.setResult(this.paramDao.getParamListByPage(params));
      return page;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0005", null, e));
    }
  }

  public Map<String, String> getParamByProductAndName(String productCode, String[] paramEnNameList)
    throws BusinessException
  {
    Map resultMap = new HashMap();

    Map params = new HashMap();
    params.put("productCode", productCode);
    try {
      if ((paramEnNameList != null) && (paramEnNameList.length > 0)) {
        params.put("paramEnNameList", paramEnNameList);
        List<Param> paramsList = this.paramDao.getParamByProductAndName(params);
        if ((paramsList != null) && (paramsList.size() > 0)) {
          for (Param param : paramsList) {
            resultMap.put(param.getParamEnName(), param.getParamValue());
          }
        }
      }
      return resultMap;
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPPA0006", null, e));
    }
  }
}