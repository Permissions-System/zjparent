package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.OrganizationDao;
import com.zjgt.p2p.base.dao.RoleDao;
import com.zjgt.p2p.base.dao.StaffDao;
import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IOrganizationService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrganizationService
  implements IOrganizationService
{
  public static final String ROOT_ORG_CODE = "000000";
  private OrganizationDao organizationDao;

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private StaffDao staffDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  @Autowired
  public void setOrganizationDao(OrganizationDao organizationDao)
  {
    this.organizationDao = organizationDao;
  }

  public Organization getOrganizationRootTree()
    throws BusinessException
  {
    Organization rootNode = this.organizationDao.selectByPrimaryKey("000000");
    return getOrganizationNodeTree(rootNode);
  }
  
  public Organization getOrganizationNodeTree(Organization org)
    throws BusinessException
  {
	  List<Organization>  childNodes = this.organizationDao.selectChildOrgs(org.getOrgCode());
    for (Organization organization : childNodes) {
      organization = getOrganizationNodeTree(organization);
    }
    org.setChildOrganizations(childNodes);
    return org;
  }
  
  public Organization getOrganizationByUserId(String uid) throws BusinessException
  {
    String orgCode = this.staffDao.selectStaffOrg(uid);
    return this.organizationDao.selectByPrimaryKey(orgCode);
  }

  public Organization getOrganizationByOrgCode(String orgCode)
    throws BusinessException
  {
    return this.organizationDao.selectByPrimaryKey(orgCode);
  }

  private void validateTask(Organization org)
  {
    Set result = this.validator.validate(org, new Class[0]);
    if (!(result.isEmpty())) {
      BusinessException ex = new BusinessException("数据校验错误");
      ex.setErrorMessages(result);
      throw ex;
    }
  }

  public void addOrganization(Organization org)
    throws BusinessException
  {
    validateTask(org);

    Organization check = this.organizationDao.selectByPrimaryKey(org.getOrgCode());
    if (check != null) {
      throw new BusinessException("机构编码已使用，请重新输入");
    }

    String treepath = "";
    if (null != org.getParentOrgCode()) {
      treepath = this.organizationDao.getTreePath(org.getParentOrgCode());
    }
    org.setTreepath(treepath + "/" + org.getOrgCode());
    try
    {
      this.organizationDao.insert(org);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPORG001", null, e));
    }
  }

  public void updateOrganization(Organization org)
    throws BusinessException
  {
    validateTask(org);

    Organization orign = new Organization();
    orign = this.organizationDao.selectByPrimaryKey(org.getOrgCode());
    if (!(org.getParentOrgCode().equals(orign.getParentOrgCode()))) {
      Map map = new HashMap();
      map.put("oldTreePath", orign.getTreepath());
      String treepath = "";
      if (null != org.getParentOrgCode()) {
        treepath = this.organizationDao.getTreePath(org.getParentOrgCode());
      }
      org.setTreepath(treepath + "/" + org.getOrgCode());
      map.put("newTreePath", org.getTreepath());
      try {
        this.organizationDao.updateTreePath(map);
      }
      catch (Exception e) {
        throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPORG004", null, e));
      }

    }

    try
    {
      this.organizationDao.updateByPrimaryKey(org);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPORG002", null, e));
    }
  }

  public void deleteOrganization(String orgCode)
    throws BusinessException
  {
    String orgTreePath = this.organizationDao.getTreePath(orgCode);

    Organization org = this.organizationDao.selectByPrimaryKey(orgCode);

    List childrenOrg = this.organizationDao.selectAllChildenOrgs(orgTreePath + "/");
    childrenOrg.add(org);

    for (Iterator i$ = childrenOrg.iterator(); i$.hasNext(); ) { Organization child = (Organization)i$.next();

      List staff = this.staffDao.selectByOrg(child.getOrgCode());
      if (staff.size() > 0) {
        throw new BusinessException("当前机构或其子机构\"" + child.getOrgName() + "\"正在被用户使用，无法删除！");
      }

      List role = this.roleDao.selectByOrg(child.getOrgCode());
      if (role.size() > 0) {
        throw new BusinessException("当前机构或其子机构\"" + child.getOrgName() + "\"正在被角色使用，无法删除！");
      }
    }
    Organization child;
    try
    {
      for (Iterator i$ = childrenOrg.iterator(); i$.hasNext(); ) { child = (Organization)i$.next();
        this.organizationDao.deleteByPrimaryKey(child.getOrgCode());
      }
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPORG003", null, e));
    }
  }
}