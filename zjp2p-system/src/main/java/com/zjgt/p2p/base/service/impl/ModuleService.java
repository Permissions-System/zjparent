package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.ModuleDao;
import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IModuleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ModuleService
  implements IModuleService
{

  @Autowired
  private ModuleDao moduleDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  public void addModule(Module module)
    throws BusinessException
  {
    validateModule(module);
    try {
      this.moduleDao.insert(module);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMDTJ01", null, e));
    }
  }

  private void validateModule(Module module)
  {
	  Set<ConstraintViolation<Module>> result = this.validator.validate(module, new Class[0]);

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

  public void updateModule(Module module)
    throws BusinessException
  {
    validateModule(module);
    try {
      this.moduleDao.updateByPrimaryKey(module);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMDXG01", null, e));
    }
  }

  public void deleteModule(String moduleCode)
    throws BusinessException
  {
    try
    {
      this.moduleDao.deleteByPrimaryKey(moduleCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPMDSC01", null, e));
    }
  }

  public Module getModuleByModuleCode(String moduleCode)
    throws BusinessException
  {
    Module module = new Module();
    module = this.moduleDao.selectByPrimaryKey(moduleCode);
    return module;
  }

  public List<Module> getSubModules(String moduleCode)
    throws BusinessException
  {
    List list = new ArrayList();
    list = this.moduleDao.getSubModules(moduleCode);
    return list;
  }

  public List<Module> getRootModuleList()
    throws BusinessException
  {
    List rootModuleList = this.moduleDao.getRootModuleList();
    return rootModuleList;
  }

  /**
   * 获取根节点，及子节点集合（Module）
   */
  public Module getRootModule() throws BusinessException
  {
    Module rootModule = this.moduleDao.getRootModule();
    return getModuleNodeTree(rootModule);
  }

  /**
   * 将子节点集合，set到Module对象中
   * @Title: getModuleNodeTree 
   * @param module
   * @return
   * @return: Module
   */
  private Module getModuleNodeTree(Module module)
  {
	List<Module> childNodes = this.moduleDao.getSubModules(module.getModuleCode());
	for (Module mod : childNodes) {
	  mod = getModuleNodeTree(mod);
	}
	module.setSubModuleList(childNodes);
	return module;
  }

  public List<Transaction> getTransByModuleCode(String moduleCode) throws BusinessException
  {
    List list = new ArrayList();
    list = this.moduleDao.getTransByModuleCode(moduleCode);
    return list;
  }

  /**
   * 获取根节点，及子节点集合（List）
   */
  public List<Module> getModuleTree()
    throws BusinessException
  {
	  //获取跟结点集合 
	  List<Module>  moduleList = this.moduleDao.getRootModuleList();
    if ((moduleList != null) && (moduleList.size() > 0)) {
      for (Module module : moduleList) {
    	//将子节点集合存放到父集合中
        module.setSubModuleList(getSubModuleTree(module.getModuleCode()));
      }
    }

    return moduleList;
  }

  /**
   * 根据moduleCode，获取子节点结合
   * @Title: getSubModuleTree 
   * @param moduleCode
   * @return
   * @return: List<Module>
   */
  private List<Module> getSubModuleTree(String moduleCode)
  {
	  //获取模块下子模块集合
	  List<Module>  moduleList = this.moduleDao.getSubModules(moduleCode);
    if ((moduleList != null) && (moduleList.size() > 0)) {
      for (Module module : moduleList) {
        module.setSubModuleList(getSubModuleTree(module.getModuleCode()));
      }
    }

    return moduleList;
  }

  public int getCountTransByModuleCode(String moduleCode)
    throws BusinessException
  {
    return this.moduleDao.getCountTransByModuleCode(moduleCode);
  }

  public void updateModuleTreePaths(Module module, Module superModule)
    throws BusinessException
  {
    if ((module != null) && (superModule != null)) {
      module.setTreepath(superModule.getTreepath() + "/" + module.getModuleCode());
      module.setParentModuleCode(superModule.getModuleCode());
      updateModule(module);

      List<Module> subModules = getSubModules(module.getModuleCode());
      if ((subModules != null) && (subModules.size() > 0))
        for (Module subModule : subModules)
        {
          updateModuleTreePaths(subModule, module);
        }
    }
  }

  public int getCountModuleInfo(String moduleCode)
    throws BusinessException
  {
    return this.moduleDao.getCountModuleInfo(moduleCode);
  }
}