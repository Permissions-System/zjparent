package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.CodeInfo;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface CodeInfoDao
{
  /**
   * @Title: getCodeInfo 
   * @Description: 根据联合主键 typeCode configCode 查询数据字典记录	
   * @param paramCodeInfo
   * @return
   * @return: CodeInfo
   */
  public abstract CodeInfo getCodeInfo(CodeInfo paramCodeInfo);
  
  /**
   * @Title: getCodeInfoList 
   * @Description: 组合查询 数据字典用 码表管理 根据字典类型 获取 数据字典明细列表
   * @param paramCodeInfo
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeInfoList(CodeInfo paramCodeInfo);
  
  /**
   * @Title: getCodeInfoListByTypeCode 
   * @Description: 数据字典用 码表管理 根据字典类型 获取 数据字典明细列表 不区分是否删除全部查出
   * @param paramString
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeInfoListByTypeCode(String paramString);
  
  /**
   * @Title: insert 
   * @Description: 新增数据字典
   * @param paramCodeInfo
   * @return: void
   */
  public abstract void insert(CodeInfo paramCodeInfo);
  
  /**
   * @Title: update 
   * @Description: 根据联合主键(type_code and config_code) 更新数据字典记录
   * @param paramCodeInfo
   * @return: void
   */
  public abstract void update(CodeInfo paramCodeInfo);
  
  /**
   * @Title: updateCodeType 
   * @Description: 批量修改 数据字典类别 的类别名称
   * @param paramCodeInfo
   * @return: void
   */
  public abstract void updateCodeType(CodeInfo paramCodeInfo);
  
  /**
   * @Title: delete 
   * @Description: 根据联合主键 typeCode configCode 删除 数据字典记录
   * @param paramCodeInfo
   * @return: void
   */
  public abstract void delete(CodeInfo paramCodeInfo);
  
  /**
   * @Title: getTypeCodeList 
   * @Description: 获取数据字典中配置的全部字典类型数据
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getTypeCodeList();
  
  /**
   * @Title: getTypeCodeListByPage 
   * @Description: 分页查询 数据字典类型数据  2013-12-14 15:50:59 增加筛选条件的判断条件
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getTypeCodeListByPage(Map<String, Object> paramMap);
  
  /**
   * @Title: getCodeDetailListByPage 
   * @Description: 分页查询 数据字典类型数据
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeDetailListByPage(Map<String, Object> paramMap);
  
  /**
   * @Title: getCountCodeInfo 
   * @Description: 新增数据的 重复性校验使用 返回符合条件的记录数
   * @param paramCodeInfo
   * @return
   * @return: int
   */
  public abstract int getCountCodeInfo(CodeInfo paramCodeInfo);
  
  /**
   * @Title: getCountNotDel 
   * @Description: 查询数据字典类型下删除标志为零的记录个数
   * @param paramString
   * @return
   * @return: int
   */
  public abstract int getCountNotDel(String paramString);
  
  /**
   * @Title: getCodeInfoListByTypeCodes 
   * @Description: 多类别编号查询数据字典明细记录
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeInfoListByTypeCodes(Map<String, Object> paramMap);
  
  /**
   * @Title: getCascadeCodeInfoList 
   * @Description: 用于解决联动下拉数据的查询，支持3级 级联数据查询 
   *    ADDED ON 2013-12-12 09:39:57
   *          例子：一级 数据 内资（不可选） 100
   *                	港、澳、台商投资（不可选）200
   *               二级 父节点 100 
   *                	数据    国有全资 110
   *                    股份合作（不可选） 130
   *               三级 父节点 130
   *                    数据  国有控股股份合作 131
   *                    集体控股股份合作 132
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCascadeCodeInfoList(Map<String, Object> paramMap);
  
  /**
   * @Title: getCodeInfoListByTypeAndCodes 
   * @Description: 查询特定需求下 数据字典编码 和有限多个configCode 获取相应数据字典列表
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeInfoListByTypeAndCodes(Map<String, Object> paramMap);
  
  /**
   * @Title: getCodeDetailInfoListByTypeAndCode 
   * @Description: 基于完全匹配类型 TYPE_CODE 和 CONFIG_CODE的模糊匹配的数据查询 分页查询
   * @param paramMap
   * @return
   * @return: List<CodeInfo>
   */
  public abstract List<CodeInfo> getCodeDetailInfoListByTypeAndCode(Map<String, Object> paramMap);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.CodeInfoDao
 * JD-Core Version:    0.5.3
 */