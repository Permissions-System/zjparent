package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.SerialTemplate;
import java.util.List;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface SerialDao
{
  public abstract List<SerialTemplate> getSerialTemplateList();

  public abstract SerialTemplate getSerialTemplate(String paramString);

  public abstract SerialTemplate getSerialTemplateForUpdate(String paramString);

  public abstract void insertSerialTemplate(SerialTemplate paramSerialTemplate);

  public abstract void deleteSerialTemplate(String paramString);

  public abstract void updateSerialTemplate(SerialTemplate paramSerialTemplate);
}