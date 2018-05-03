package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface ModuleDao
{
  /**
   * 根据主键删除模块记录	
   * @Title: deleteByPrimaryKey 
   * @param paramString
   * @return
   * @return: int
   */
  public abstract int deleteByPrimaryKey(String paramString);

  /**
   * 新增数据
   * @Title: insert 
   * @param paramModule
   * @return
   * @return: int
   */
  public abstract int insert(Module paramModule);

  /**
   * 根据模块编号获取模块名称
   * @Title: selectByPrimaryKey 
   * @param paramString
   * @return
   * @return: Module
   */
  public abstract Module selectByPrimaryKey(String paramString);

  /**
   * 新增数据的 重复性校验使用 返回符合条件的记录数
   * @Title: getCountModuleInfo 
   * @param paramString
   * @return
   * @return: int
   */
  public abstract int getCountModuleInfo(String paramString);

  /**
   * 修改模块数据 
   * @Title: updateByPrimaryKey 
   * @param paramModule
   * @return
   * @return: int
   */
  public abstract int updateByPrimaryKey(Module paramModule);

  /**
   * 获取模块下子模块集合
   * @Title: getSubModules 
   * @param paramString
   * @return
   * @return: List<Module>
   */
  public abstract List<Module> getSubModules(String paramString);

  /**
   * 获取跟结点集合 
   * @Title: getRootModuleList 
   * @return
   * @return: List<Module>
   */
  public abstract List<Module> getRootModuleList();

  /**
   * 获取跟结点集合
   * @Title: getRootModule 
   * @return
   * @return: Module
   */
  public abstract Module getRootModule();

  /**
   * 获取模块下的交易信息
   * @Title: getTransByModuleCode 
   * @param paramString
   * @return
   * @return: List<Transaction>
   */
  public abstract List<Transaction> getTransByModuleCode(String paramString);

  /**
   * 根据模块编码 查询 交易信息中配置的交易记录数
   * @Title: getCountTransByModuleCode 
   * @param paramString
   * @return
   * @return: int
   */
  public abstract int getCountTransByModuleCode(String paramString);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.ModuleDao
 * JD-Core Version:    0.5.3
 */