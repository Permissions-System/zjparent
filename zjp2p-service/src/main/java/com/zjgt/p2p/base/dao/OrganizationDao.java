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

  public abstract Organization selectByPrimaryKey(String paramString);

  public abstract List<Organization> selectChildOrgs(String paramString);

  public abstract int updateByPrimaryKey(Organization paramOrganization);

  public abstract String getTreePath(String paramString);

  public abstract void updateTreePath(Map<String, String> paramMap);

  public abstract List<Organization> selectAllChildenOrgs(String paramString);
}