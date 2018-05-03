package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Organization;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IOrganizationService
{
  public abstract Organization getOrganizationRootTree()
    throws BusinessException;
  
  /**
   * @Title: getOrganizationNodeTree 
   * @Description: 根据“上级组织结构代码PARENT_ORG_CODE”，获取“组织”列表
   * @param paramOrganization
   * @return
   * @throws BusinessException
   * @return: Organization
   */
  public abstract Organization getOrganizationNodeTree(Organization paramOrganization)
    throws BusinessException;

  /**
   * @Title: getOrganizationByUserId 
   * @Description: 根据组织编号ORG_CODE，获取组织对象
   * @param paramString 组织编号
   * @return
   * @throws BusinessException
   * @return: Organization
   */
  public abstract Organization getOrganizationByUserId(String paramString)
    throws BusinessException;

  public abstract Organization getOrganizationByOrgCode(String paramString)
    throws BusinessException;

  public abstract void addOrganization(Organization paramOrganization)
    throws BusinessException;

  public abstract void updateOrganization(Organization paramOrganization)
    throws BusinessException;

  public abstract void deleteOrganization(String paramString)
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IOrganizationService
 * JD-Core Version:    0.5.3
 */