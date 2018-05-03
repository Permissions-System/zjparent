package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Param;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ParamDao
{
  public abstract Param getParam(Param paramParam);

  public abstract void update(Param paramParam);

  public abstract void insert(Param paramParam);

  public abstract void delete(Param paramParam);

  public abstract List<Param> getParamListByPage(Map<String, Object> paramMap);

  public abstract List<Param> getParamByProductAndName(Map<String, Object> paramMap);
}