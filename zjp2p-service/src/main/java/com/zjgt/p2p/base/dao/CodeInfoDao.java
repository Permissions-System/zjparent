package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.CodeInfo;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface CodeInfoDao
{
  public abstract CodeInfo getCodeInfo(CodeInfo paramCodeInfo);

  public abstract List<CodeInfo> getCodeInfoList(CodeInfo paramCodeInfo);

  public abstract List<CodeInfo> getCodeInfoListByTypeCode(String paramString);

  public abstract void insert(CodeInfo paramCodeInfo);

  public abstract void update(CodeInfo paramCodeInfo);

  public abstract void updateCodeType(CodeInfo paramCodeInfo);

  public abstract void delete(CodeInfo paramCodeInfo);

  public abstract List<CodeInfo> getTypeCodeList();

  public abstract List<CodeInfo> getTypeCodeListByPage(Map<String, Object> paramMap);

  public abstract List<CodeInfo> getCodeDetailListByPage(Map<String, Object> paramMap);

  public abstract int getCountCodeInfo(CodeInfo paramCodeInfo);

  public abstract int getCountNotDel(String paramString);

  public abstract List<CodeInfo> getCodeInfoListByTypeCodes(Map<String, Object> paramMap);

  public abstract List<CodeInfo> getCascadeCodeInfoList(Map<String, Object> paramMap);

  public abstract List<CodeInfo> getCodeInfoListByTypeAndCodes(Map<String, Object> paramMap);

  public abstract List<CodeInfo> getCodeDetailInfoListByTypeAndCode(Map<String, Object> paramMap);
}