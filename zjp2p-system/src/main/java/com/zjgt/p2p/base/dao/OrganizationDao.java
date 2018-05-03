package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Organization;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface OrganizationDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Organization paramOrganization);
  
  /**
   * @Title: selectByPrimaryKey 
   * @Description: 根据组织编号ORG_CODE，获取组织对象
   * @param paramString	ORG_CODE
   * @return
   * @return: Organization
   */
  public abstract Organization selectByPrimaryKey(String paramString);
  
  /**
   * @Title: selectAllChildenOrgs 
   * @Description: 根据“上级组织结构代码PARENT_ORG_CODE”，获取“组织”列表
   * @param paramString ORG_CODE
   * @return
   * @return: List<Organization>
   */
  public abstract List<Organization> selectChildOrgs(String paramString);

  public abstract int updateByPrimaryKey(Organization paramOrganization);

  public abstract String getTreePath(String paramString);

  public abstract void updateTreePath(Map<String, String> paramMap);
  
  public abstract List<Organization> selectAllChildenOrgs(String paramString);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.OrganizationDao
 * JD-Core Version:    0.5.3
 */