package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.CodeInfo;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface ICodeInfoService
{
  public abstract CodeInfo getCodeInfo(String paramString1, String paramString2)
    throws BusinessException;

  public abstract List<CodeInfo> getCodeInfoListByTypeCode(String paramString)
    throws BusinessException;

  public abstract List<CodeInfo> getCodeInfoList(CodeInfo paramCodeInfo)
    throws BusinessException;

  public abstract void insert(CodeInfo paramCodeInfo)
    throws BusinessException;

  public abstract void update(CodeInfo paramCodeInfo)
    throws BusinessException;

  public abstract void updateCodeType(CodeInfo paramCodeInfo)
    throws BusinessException;

  public abstract void delete(String paramString1, String paramString2)
    throws BusinessException;

  public abstract List<CodeInfo> getTypeCodeList()
    throws BusinessException;

  public abstract Page<CodeInfo> getTypeCodeListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract Page<CodeInfo> getCodeDetailListByPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract int getCountCodeInfo(String paramString1, String paramString2)
    throws BusinessException;

  public abstract int getCountNotDel(String paramString)
    throws BusinessException;

  public abstract Map<String, List<CodeInfo>> getCodeInfoListByTypeCodes(String[] paramArrayOfString)
    throws BusinessException;

  public abstract Map<String, Map<String, String>> getCodeInfoMapByTypeCodes(String[] paramArrayOfString)
    throws BusinessException;

  public abstract List<CodeInfo> getCascadeCodeInfoList(String paramString1, String paramString2, String paramString3);

  public abstract Map<String, String> getCodeMapsByTypeCodes(String[] paramArrayOfString)
    throws BusinessException;

  public abstract List<CodeInfo> getCodeInfoListByTypeAndCodes(String paramString, List<String> paramList)
    throws BusinessException;

  public abstract Page<CodeInfo> getCodeDetailInfoListByTypeAndCode(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
}