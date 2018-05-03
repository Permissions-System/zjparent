package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.RoleTransRel;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface IRoleService
{
  public abstract List<Role> getRoleByOrg(String paramString)
    throws BusinessException;

  public abstract void addRole(Role paramRole)
    throws BusinessException;

  public abstract void updateRole(Role paramRole)
    throws BusinessException;

  public abstract void deleteRole(String paramString)
    throws BusinessException;

  public abstract void updateRoleTransRel(String paramString, List<RoleTransRel> paramList)
    throws BusinessException;

  public abstract List<RoleTransRel> getRoleTransRel(String paramString)
    throws BusinessException;

  public abstract List<Module> findRoleModuleByRoleCode(String paramString)
    throws BusinessException;

  public abstract List<Transaction> getTransByModuleCodeForRole(String paramString1, String paramString2)
    throws BusinessException;

  public abstract List<Transaction> getTransByModuleCodeForRole(String paramString1, String paramString2, String paramString3)
    throws BusinessException;

  public abstract List<Module> getAllRoleTransRelForCheck(String paramString)
    throws BusinessException;

  public abstract List<Module> getAllRoleTransRelForCheck(String paramString1, String paramString2)
    throws BusinessException;

  public abstract Page<Role> getRoleByOrgAndPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract Page<Role> getRoleByOrgsAndPage(Map<String, Object> paramMap, int paramInt1, int paramInt2);

  public abstract Page<Role> getRoleByOrgs(List<String> paramList);

  public abstract Role getRoleByRoleCode(String paramString);

  public abstract List<Role> getRoleByTransCode(String paramString);

  public abstract List<String> getRoleTransByRoleCodes(List<String> paramList)
    throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IRoleService
 * JD-Core Version:    0.5.3
 */