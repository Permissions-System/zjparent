package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.StaffRoleRel;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

@PanCloudDaoRepository
public abstract interface StaffDao
{
  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(Staff paramStaff);

  public abstract Staff selectByPrimaryKey(String paramString);

  public abstract Staff selectByIdentNo(String paramString);

  public abstract int updateByPrimaryKey(Staff paramStaff);

  public abstract void updateStaffBaseInfo(Staff paramStaff);

  public abstract List<String> selectRolesByStaffNo(String paramString);

  public abstract List<String> selectPermissionsBy(String paramString);

  public abstract List<String> selectPermissionsForAdmin();

  public abstract List<Staff> selectByOrg(String paramString);

  public abstract List<Staff> selectByOrgList(Map<String, Object> paramMap);

  public abstract List<Staff> selectByNameSearch(Map<String, Object> paramMap);

  public abstract List<Staff> selectStaffsByRoleId(String paramString);

  public abstract int deleteStaffRoleByStaffNo(String paramString);

  public abstract int insertStaffRoleRel(StaffRoleRel paramStaffRoleRel);

  public abstract List<StaffRoleRel> selectStaffRoleByStaffNo(String paramString);

  public abstract List<Role> findRoleByOrgCodeForStaff(Map<String, String> paramMap);

  public abstract List<Role> findRoleByOrgCodeForAdminStaff(Map<String, String> paramMap);

  public abstract List<Role> findAvailableRoleByOrgCodeForStaff(Map<String, String> paramMap);

  public abstract List<Organization> findRoleOrgByRoleCode(String paramString);

  public abstract int resetPassword(Staff paramStaff);

  public abstract List<Staff> findCustManager(Map<String, Object> paramMap);

  public abstract List<StaffRoleRel> selectStaffRole(Map<String, Object> paramMap);

  public abstract int deleteStaffRole(Map<String, Object> paramMap);

  public abstract List<Staff> findStaffByRoleCode(Map<String, Object> paramMap);

  public abstract String selectStaffOrg(String paramString);

  public abstract int updatePersonalStaffInfo(Staff paramStaff);

  public abstract List<Staff> selectStaffs(Map<String, Object> paramMap);

  public abstract List<Transaction> selectTranPermissionsForStaff(String paramString);

  public abstract List<Transaction> selectTranPermissionsForAdmin();

  public abstract List<Transaction> selectTranPermissions(String paramString);

  public abstract List<Staff> selectStaffsByRoleIdPage(Map<String, Object> paramMap);

  public abstract void updateTranspwdByStaffNo(Staff paramStaff);
}