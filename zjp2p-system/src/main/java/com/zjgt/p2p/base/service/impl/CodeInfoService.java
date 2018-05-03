package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.CodeInfoDao;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IErrorLogsService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CodeInfoService
  implements ICodeInfoService
{

  @Autowired
  private CodeInfoDao codeInfoDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  public CodeInfo getCodeInfo(String typeCode, String configCode)
    throws BusinessException
  {
    CodeInfo info = new CodeInfo();

    if ((StringUtils.isEmpty(typeCode)) || (StringUtils.isEmpty(typeCode))) {
      return info;
    }
    info.setTypeCode(typeCode);
    info.setConfigCode(configCode);
    return this.codeInfoDao.getCodeInfo(info);
  }

  public List<CodeInfo> getCodeInfoListByTypeCode(String typeCode)
    throws BusinessException
  {
    if (StringUtils.isEmpty(typeCode)) {
      return new ArrayList();
    }
    return this.codeInfoDao.getCodeInfoListByTypeCode(typeCode);
  }

  public void insert(CodeInfo codeInfo)
    throws BusinessException
  {
    validateCodeInfo(codeInfo);
    try {
      this.codeInfoDao.insert(codeInfo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPCDTJ01", null, e));
    }
  }

  public void update(CodeInfo codeInfo)
    throws BusinessException
  {
    validateCodeInfo(codeInfo);
    try {
      this.codeInfoDao.update(codeInfo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPCDXG01", null, e));
    }
  }

  public void updateCodeType(CodeInfo codeInfo)
    throws BusinessException
  {
    try
    {
      this.codeInfoDao.updateCodeType(codeInfo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPCDXG02", null, e));
    }
  }

  public void delete(String typeCode, String configCode)
    throws BusinessException
  {
    CodeInfo codeInfo = new CodeInfo();
    codeInfo.setTypeCode(typeCode);
    codeInfo.setConfigCode(configCode);
    try {
      this.codeInfoDao.delete(codeInfo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPCDSC01", null, e));
    }
  }

  private void validateCodeInfo(CodeInfo codeInfo)
  {
	  Set<ConstraintViolation<CodeInfo>> result = this.validator.validate(codeInfo, new Class[0]);

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

  public List<CodeInfo> getTypeCodeList()
    throws BusinessException
  {
    return this.codeInfoDao.getTypeCodeList();
  }

  public List<CodeInfo> getCodeInfoList(CodeInfo codeInfo)
    throws BusinessException
  {
    return this.codeInfoDao.getCodeInfoList(codeInfo);
  }

  public Page<CodeInfo> getTypeCodeListByPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.codeInfoDao.getTypeCodeListByPage(params));
    return page;
  }

  public Page<CodeInfo> getCodeDetailListByPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.codeInfoDao.getCodeDetailListByPage(params));
    return page;
  }

  public int getCountCodeInfo(String typeCode, String configCode)
    throws BusinessException
  {
    CodeInfo codeInfo = new CodeInfo();
    codeInfo.setTypeCode(typeCode);
    codeInfo.setConfigCode(configCode);
    return this.codeInfoDao.getCountCodeInfo(codeInfo);
  }

  public int getCountNotDel(String typeCode)
    throws BusinessException
  {
    return this.codeInfoDao.getCountNotDel(typeCode);
  }

  public Map<String, List<CodeInfo>> getCodeInfoListByTypeCodes(String[] typeCodes)
    throws BusinessException
  {
    Map<String, List<CodeInfo>> resultMap = new HashMap<String, List<CodeInfo>>();
    List<CodeInfo> codeList = null;
    Map<String, Object> params = new HashMap<String, Object>();
    if ((typeCodes != null) && (typeCodes.length > 0)) {
      params.put("typeCodes", typeCodes);
      List<CodeInfo>  resultList = this.codeInfoDao.getCodeInfoListByTypeCodes(params);
      for (int i = 0; i <= typeCodes.length - 1; ++i) {
        codeList = new ArrayList<CodeInfo>();
        for (CodeInfo code : resultList) {
          if (code.getTypeCode().equals(typeCodes[i])) {
            codeList.add(code);
          }
        }
        resultMap.put(typeCodes[i], codeList);
      }
    }
    return resultMap;
  }

  public Map<String, Map<String, String>> getCodeInfoMapByTypeCodes(String[] typeCodes)
    throws BusinessException
  {
    Map resultMap = new HashMap();
    Map codeMap = new HashMap();
    Map params = new HashMap();
    if ((typeCodes != null) && (typeCodes.length > 0)) {
      params.put("typeCodes", typeCodes);
      List<CodeInfo>  resultList = this.codeInfoDao.getCodeInfoListByTypeCodes(params);
      for (int i = 0; i <= typeCodes.length - 1; ++i) {
        codeMap = new HashMap();
        for (CodeInfo code : resultList) {
          if (code.getTypeCode().equals(typeCodes[i])) {
            codeMap.put(code.getConfigCode(), code.getConfigName());
          }
        }
        resultMap.put(typeCodes[i], codeMap);
      }
    }
    return resultMap;
  }

  public List<CodeInfo> getCascadeCodeInfoList(String typeCode, String lv, String superConfigCode)
  {
    Map params = new HashMap();

    params.put("typeCode", typeCode);
    params.put("lv", lv);
    params.put("superConfigCode", superConfigCode);
    List resultList = this.codeInfoDao.getCascadeCodeInfoList(params);
    return resultList;
  }

  public Map<String, String> getCodeMapsByTypeCodes(String[] typeCodes)
    throws BusinessException
  {
    Map resultMap = new HashMap();
    Map params = new HashMap();
    if ((typeCodes != null) && (typeCodes.length > 0)) {
      params.put("typeCodes", typeCodes);
      List<CodeInfo> resultList = this.codeInfoDao.getCodeInfoListByTypeCodes(params);
      for (CodeInfo code : resultList) {
        resultMap.put(code.getTypeCode() + code.getConfigCode(), code.getConfigName());
      }
    }
    return resultMap;
  }

  public List<CodeInfo> getCodeInfoListByTypeAndCodes(String typeCode, List<String> configCodes)
    throws BusinessException
  {
    Map params = new HashMap();
    params.put("typeCode", typeCode);
    if ((configCodes != null) && (configCodes.size() > 0)) {
      params.put("configCodes", configCodes);
    }
    return this.codeInfoDao.getCodeInfoListByTypeAndCodes(params);
  }

  public Page<CodeInfo> getCodeDetailInfoListByTypeAndCode(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.codeInfoDao.getCodeDetailInfoListByTypeAndCode(params));
    return page;
  }
}