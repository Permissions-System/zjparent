package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Organization;
import org.springfk.pancloud.exception.BusinessException;

public abstract interface IOrganizationService
{
  public abstract Organization getOrganizationRootTree()
    throws BusinessException;

  public abstract Organization getOrganizationNodeTree(Organization paramOrganization)
    throws BusinessException;

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