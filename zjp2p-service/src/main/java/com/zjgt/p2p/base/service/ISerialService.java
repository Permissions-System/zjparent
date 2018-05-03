package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.SerialTemplate;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface ISerialService
{
  public abstract String getSerial(String paramString, Map<String, Object> paramMap)
    throws BusinessException;

  public abstract void insertSerialTemplate(SerialTemplate paramSerialTemplate);

  public abstract List<SerialTemplate> getSerialTemplateList()
    throws BusinessException;

  public abstract SerialTemplate getSerialTemplate(String paramString)
    throws BusinessException;

  public abstract void deleteSerialTemplate(String paramString);
}