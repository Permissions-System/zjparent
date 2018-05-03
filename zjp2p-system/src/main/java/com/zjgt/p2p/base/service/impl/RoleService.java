package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.RoleDao;
import com.zjgt.p2p.base.dao.StaffDao;
import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.RoleTransRel;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IRoleService;
import com.zjgt.util.UUIDUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RoleService
  implements IRoleService
{

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private StaffDao staffDao;

  @Autowired
  private Validator validator;

  @Autowired
  private IErrorLogsService errLogService;

  public List<Role> getRoleByOrg(String orgCode)
    throws BusinessException
  {
    List roleList = this.roleDao.selectByOrg(orgCode);
    return roleList;
  }

  public Page<Role> getRoleByOrgAndPage(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.roleDao.selectByOrgAndPage(params));
    return page;
  }

  public Page<Role> getRoleByOrgsAndPage(Map<String, Object> params, int pageNo, int pageSize)
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);

    if (params.get("orgCodes") == null) {
      page.setTotalCount(0L);
      page.setResult(new ArrayList());
      return page;
    }

    params.put("pageObject", page);
    page.setResult(this.roleDao.selectByOrgsAndPage(params));
    return page;
  }

  public Page<Role> getRoleByOrgs(List<String> orgCodes)
  {
    Page page = new Page();
    page.setPageNo(1);
    page.setPageSize(10);
    Map params = new HashMap();
    params.put("pageObject", page);
    Page roles = this.roleDao.selectByOrgs(params);
    return roles;
  }

  private void validateTask(Role role)
  {
    Set result = this.validator.validate(role, new Class[0]);
    if (!(result.isEmpty())) {
      BusinessException ex = new BusinessException("数据校验错误");
      ex.setErrorMessages(result);
      throw ex;
    }
  }

  public Boolean checkIdExist(String roleCode)
    throws BusinessException
  {
    Role check = this.roleDao.selectByPrimaryKey(roleCode);
    if (check != null) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }

  public void addRole(Role role)
    throws BusinessException
  {
    validateTask(role);
    if (!(checkIdExist(role.getRoleCode()).booleanValue()))
      throw new BusinessException("角色编码已存在！");
    try
    {
      this.roleDao.insert(role);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPROLE03", null, e));
    }
  }

  public void updateRole(Role role)
    throws BusinessException
  {
    validateTask(role);
    try {
      this.roleDao.updateByPrimaryKey(role);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPROLE03", null, e));
    }
  }

  public void deleteRole(String roleCode)
    throws BusinessException
  {
    List staff = this.staffDao.selectStaffsByRoleId(roleCode);
    if (staff.size() > 0)
      throw new BusinessException("该角色正在被用户使用，无法删除！");
    try
    {
      this.roleDao.deleteRoleTransByRoleCode(roleCode);
      this.roleDao.deleteByPrimaryKey(roleCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPROLE02", null, e));
    }
  }

  public List<RoleTransRel> getRoleTransRel(String roleCode)
    throws BusinessException
  {
    try
    {
      return this.roleDao.selectRoleTransByRoleCode(roleCode);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Module> findRoleModuleByRoleCode(String roleCode)
    throws BusinessException
  {
    try
    {
      return this.roleDao.findRoleModuleByRoleCode(roleCode);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Transaction> getTransByModuleCodeForRole(String staffNo, String moduleCode, String roleCode)
    throws BusinessException
  {
    try
    {
      Map map = new HashMap();
      map.put("moduleCode", moduleCode);
      map.put("roleCode", roleCode);
      map.put("staffNo", staffNo);

      List listA = this.roleDao.findTransByModuleCodeForAdminStaff(map);

      List<Transaction> listB = this.roleDao.findAvailableTransByModuleCodeForRole(map);

      if ((listB == null) || (listB.size() == 0))
        return listA;
      if ((listA == null) || (listA.size() == 0)) {
        for (Transaction b : listB) {
          b.setDisabled(Boolean.valueOf(true));
        }
        return listB;
      }
      int lenA = listA.size();
      int lenB = listB.size();
      int stepA = 0;
      int stepB = 0;
      List resultList = new ArrayList();
      while ((stepA < lenA) && (stepB < lenB)) {
        Transaction a = (Transaction)listA.get(stepA);
        Transaction b = (Transaction)listB.get(stepB);
        if (a.getTransCode().equals(b.getTransCode())) {
          resultList.add(b);
          ++stepA;
          ++stepB;
        } else {
          resultList.add(a);
          ++stepA;
        }
      }
      while (stepA < lenA) {
        resultList.add(listA.get(stepA));
        ++stepA;
      }
      while (stepB < lenB) {
        Transaction b = (Transaction)listB.get(stepB);
        b.setDisabled(Boolean.valueOf(true));
        resultList.add(b);
        ++stepB;
      }
      return resultList;
    }
    catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Transaction> getTransByModuleCodeForRole(String moduleCode, String roleCode)
    throws BusinessException
  {
    try
    {
      Map map = new HashMap();
      map.put("moduleCode", moduleCode);
      map.put("roleCode", roleCode);
      return this.roleDao.findTransByModuleCodeForRole(map);
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Module> getAllRoleTransRelForCheck(String roleCode)
    throws BusinessException
  {
    try
    {
    	List<Module>  resultList = findRoleModuleByRoleCode(roleCode);
      if (resultList != null) {
        for (Module module : resultList) {
          module.setTransactionList(getTransByModuleCodeForRole(module.getModuleCode(), roleCode));
        }
      }

      return resultList;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public List<Module> getAllRoleTransRelForCheck(String staffNo, String roleCode)
    throws BusinessException
  {
    try
    {
    	List<Module> resultList = findRoleModuleByRoleCode(roleCode);
      if (resultList != null) {
        for (Module module : resultList) {
          module.setTransactionList(getTransByModuleCodeForRole(staffNo, module.getModuleCode(), roleCode));
        }
      }

      return resultList;
    } catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPOTHER1", null, list, e));
    }
  }

  public void updateRoleTransRel(String roleCode, List<RoleTransRel> list)
    throws BusinessException
  {
    try
    {
      this.roleDao.deleteRoleTransByRoleCode(roleCode);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPROLE02", null, e));
    }

    try
    {
      if ((list != null) && (list.size() > 0))
        for (RoleTransRel rel : list)
          if (rel != null) {
            rel.setRecNo(UUIDUtils.generate());
            this.roleDao.insertRoleTransRel(rel);
          } else {
            System.out.println(" role is null. ");
          }
    }
    catch (Exception e)
    {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0002", null, e));
    }
  }

  public Role getRoleByRoleCode(String roleCode)
  {
    return this.roleDao.selectByPrimaryKey(roleCode);
  }

  public List<Role> getRoleByTransCode(String transCode)
    throws BusinessException
  {
    return this.roleDao.selectRoleByTranscode(transCode);
  }

  public List<String> getRoleTransByRoleCodes(List<String> roleCodes)
  {
    List transCodes = new ArrayList();
    if ((roleCodes == null) || (roleCodes.size() == 0)) {
      return transCodes;
    }

    List<Transaction>  transList = this.roleDao.getRoleTransByRoleCodes(roleCodes);
    if ((transList != null) && (transList.size() > 0)) {
      for (Transaction transaction : transList) {
        transCodes.add(transaction.getTransCode());
      }
    }
    return transCodes;
  }
}