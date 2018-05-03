package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IModuleService
{
  public abstract void addModule(Module paramModule)
    throws BusinessException;

  public abstract void updateModule(Module paramModule)
    throws BusinessException;

  public abstract void deleteModule(String paramString)
    throws BusinessException;

  public abstract Module getModuleByModuleCode(String paramString)
    throws BusinessException;

  public abstract int getCountModuleInfo(String paramString)
    throws BusinessException;

  /**
   * 获取根节点，及子节点集合
   */
  public abstract List<Module> getRootModuleList() throws BusinessException;

  public abstract Module getRootModule()
    throws BusinessException;

  public abstract List<Transaction> getTransByModuleCode(String paramString)
    throws BusinessException;

  public abstract int getCountTransByModuleCode(String paramString)
    throws BusinessException;

  public abstract List<Module> getModuleTree() throws BusinessException;
  
  /**
   * 根据moduleCode，获取子节点结合
   * @Title: getSubModuleTree 
   * @param moduleCode
   * @return
   * @return: List<Module>
   */
  public abstract List<Module> getSubModules(String paramString) throws BusinessException;

  public abstract void updateModuleTreePaths(Module paramModule1, Module paramModule2) throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IModuleService
 * JD-Core Version:    0.5.3
 */