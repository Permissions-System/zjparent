package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.RoleTransRel;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;
import org.springfk.pancloud.paginator.vo.Page;

@PanCloudDaoRepository
public abstract interface RoleDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Role paramRole);

  public abstract Role selectByPrimaryKey(String paramString);

  public abstract int updateByPrimaryKey(Role paramRole);

  public abstract List<Role> selectByOrg(String paramString);

  public abstract int insertRoleTransRel(RoleTransRel paramRoleTransRel);

  public abstract List<RoleTransRel> selectRoleTransByRoleCode(String paramString);

  public abstract int deleteRoleTransByRoleCode(String paramString);

  public abstract List<Module> findRoleModuleByRoleCode(String paramString);

  public abstract List<Transaction> findRoleTransByRoleCode(String paramString);

  public abstract List<Transaction> findTransByModuleCodeForRole(Map<String, String> paramMap);

  public abstract List<Transaction> findAvailableTransByModuleCodeForRole(Map<String, String> paramMap);

  public abstract List<Transaction> findTransByModuleCodeForAdminStaff(Map<String, String> paramMap);

  public abstract List<Role> selectByOrgsAndPage(Map<String, Object> paramMap);

  public abstract List<Role> selectByOrgAndPage(Map<String, Object> paramMap);

  public abstract Page<Role> selectByOrgs(Map<String, Object> paramMap);

  public abstract List<Role> selectRoleByTranscode(String paramString);

  public abstract List<Transaction> getRoleTransByRoleCodes(List<String> paramList);
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.RoleDao
 * JD-Core Version:    0.5.3
 */