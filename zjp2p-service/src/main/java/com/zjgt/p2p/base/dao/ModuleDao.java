package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ModuleDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Module paramModule);

  public abstract Module selectByPrimaryKey(String paramString);

  public abstract int getCountModuleInfo(String paramString);

  public abstract int updateByPrimaryKey(Module paramModule);

  public abstract List<Module> getSubModules(String paramString);

  public abstract List<Module> getRootModuleList();

  public abstract Module getRootModule();

  public abstract List<Transaction> getTransByModuleCode(String paramString);

  public abstract int getCountTransByModuleCode(String paramString);
}