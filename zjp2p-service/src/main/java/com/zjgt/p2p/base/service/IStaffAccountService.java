package com.zjgt.p2p.base.service;

import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.StaffRoleRel;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

public abstract interface IStaffAccountService
{
  public abstract String getWorkBenchRoles();

  public abstract Staff getStaff(String paramString)
    throws BusinessException;

  public abstract Staff findStaffByIdentNo(String paramString)
    throws BusinessException;

  public abstract List<Staff> getStaffByOrg(String paramString)
    throws BusinessException;

  public abstract Page<Staff> getStaffByOrgList(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract Page<Staff> getStaffBySearch(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract List<Staff> selectStaffsByRoleId(String paramString)
    throws BusinessException;

  public abstract List<String> getRoles(String paramString)
    throws BusinessException;

  public abstract List<String> getPermissions(String paramString)
    throws BusinessException;

  public abstract List<String> getPermissionsForAdmin()
    throws BusinessException;

  public abstract void registerStaff(Staff paramStaff)
    throws BusinessException;

  public abstract Staff createOrUpdateCmStaff(Staff paramStaff, String paramString)
    throws BusinessException;

  public abstract void updateStaffBaseInfo(Staff paramStaff)
    throws BusinessException;

  public abstract void deleteStaff(String paramString)
    throws BusinessException;

  public abstract void updateStaffRoleRel(String paramString, List<StaffRoleRel> paramList)
    throws BusinessException;

  public abstract List<StaffRoleRel> getStaffRoleRel(String paramString)
    throws BusinessException;

  public abstract List<Role> getRoleByOrgCodeForStaff(String paramString1, String paramString2)
    throws BusinessException;

  public abstract List<Role> getRoleByOrgCodeForStaff(String paramString1, String paramString2, String paramString3)
    throws BusinessException;

  public abstract List<Organization> getAllStaffRoleRelForCheck(String paramString)
    throws BusinessException;

  public abstract List<Organization> getAllStaffRoleRelForCheck(String paramString1, String paramString2)
    throws BusinessException;

  public abstract void resetPassword(String paramString1, String paramString2)
    throws BusinessException;

  public abstract Page<Staff> findCustManager(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws BusinessException;

  public abstract void removeStaffRoleRel(String paramString1, String paramString2)
    throws BusinessException;

  public abstract Staff createOrUpdateStaffWithRole(Staff paramStaff, String[] paramArrayOfString)
    throws BusinessException;

  public abstract Staff createOrUpdateLoanApproveStaff(Staff paramStaff)
    throws BusinessException;

  public abstract Staff createOrUpdateLoanManagerStaff(Staff paramStaff, String[] paramArrayOfString)
    throws BusinessException;

  public abstract Page<Staff> getStaffByRoleCode(int paramInt1, int paramInt2, String[] paramArrayOfString)
    throws BusinessException;

  public abstract String getSuccessUrl(String paramString)
    throws BusinessException;

  public abstract int updatePersonalStaffInfo(Staff paramStaff)
    throws BusinessException;

  public abstract int updatePersonalPassword(String paramString1, String paramString2, String paramString3)
    throws BusinessException;

  public abstract Boolean checkIdExist(String paramString)
    throws BusinessException;

  public abstract List<Staff> getStaffs(Map<String, Object> paramMap)
    throws BusinessException;

  public abstract List<Staff> selectStaffs(Map<String, Object> paramMap)
    throws BusinessException;

  public abstract Map<String, Staff> getSelectStaffsMap(Map<String, Object> paramMap)
    throws BusinessException;

  public abstract List<String> getSelectStaffNos(Map<String, Object> paramMap)
    throws BusinessException;

  public abstract List<Transaction> getTransPermissions(String paramString)
    throws BusinessException;

  public abstract List<Transaction> getTransPermissionsForAdmin()
    throws BusinessException;

  public abstract List<Transaction> getTransPermissions2(String paramString)
    throws BusinessException;

  public abstract Page<Staff> selectStaffsByRoleIdPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public abstract void updateTranspwdByStaffNo(Staff paramStaff)
    throws BusinessException;
}