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

public  interface IStaffAccountService
{
  public  String getWorkBenchRoles();

  public  Staff getStaff(String paramString)
    throws BusinessException;

  public  Staff findStaffByIdentNo(String paramString)
    throws BusinessException;

  public  List<Staff> getStaffByOrg(String paramString)
    throws BusinessException;

  public  Page<Staff> getStaffByOrgList(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
  public  Page<Staff> getStaffByOrgListTwo(Map<String, Object> paramMap, int paramInt1, int paramInt2)
		    throws BusinessException;

  public  Page<Staff> getStaffBySearch(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;
  public  Page<Staff> getStaffBySearchTwo(Map<String, Object> paramMap, int paramInt1, int paramInt2)
		    throws BusinessException;

  public  List<Staff> selectStaffsByRoleId(String paramString)
    throws BusinessException;

  public  List<String> getRoles(String paramString)
    throws BusinessException;

  public  List<String> getPermissions(String paramString)
    throws BusinessException;

  public  List<String> getPermissionsForAdmin()
    throws BusinessException;

  public  void registerStaff(Staff paramStaff)
    throws BusinessException;

  public  Staff createOrUpdateCmStaff(Staff paramStaff, String paramString)
    throws BusinessException;

  public  void updateStaffBaseInfo(Staff paramStaff)
    throws BusinessException;

  public  void deleteStaff(String paramString)
    throws BusinessException;

  public  void updateStaffRoleRel(String paramString, List<StaffRoleRel> paramList)
    throws BusinessException;

  public  List<StaffRoleRel> getStaffRoleRel(String paramString)
    throws BusinessException;

  public  List<Role> getRoleByOrgCodeForStaff(String paramString1, String paramString2)
    throws BusinessException;

  public  List<Role> getRoleByOrgCodeForStaff(String paramString1, String paramString2, String paramString3)
    throws BusinessException;

  public  List<Organization> getAllStaffRoleRelForCheck(String paramString)
    throws BusinessException;

  public  List<Organization> getAllStaffRoleRelForCheck(String paramString1, String paramString2)
    throws BusinessException;

  public  void resetPassword(String paramString1, String paramString2)
    throws BusinessException;

  public  Page<Staff> findCustManager(int paramInt1, int paramInt2, Map<String, Object> paramMap)
    throws BusinessException;

  public  void removeStaffRoleRel(String paramString1, String paramString2)
    throws BusinessException;

  public  Staff createOrUpdateStaffWithRole(Staff paramStaff, String[] paramArrayOfString)
    throws BusinessException;

  public  Staff createOrUpdateLoanApproveStaff(Staff paramStaff)
    throws BusinessException;

  public  Staff createOrUpdateLoanManagerStaff(Staff paramStaff, String[] paramArrayOfString)
    throws BusinessException;

  public  Page<Staff> getStaffByRoleCode(int paramInt1, int paramInt2, String[] paramArrayOfString)
    throws BusinessException;

  public  String getSuccessUrl(String paramString)
    throws BusinessException;

  public  int updatePersonalStaffInfo(Staff paramStaff)
    throws BusinessException;

  public  int updatePersonalPassword(String paramString1, String paramString2, String paramString3)
    throws BusinessException;

  public  Boolean checkIdExist(String paramString)
    throws BusinessException;
  
  public  Boolean checkChannelCodeExist(String paramString)
		    throws BusinessException;

  public  List<Staff> getStaffs(Map<String, Object> paramMap)
    throws BusinessException;

  public  List<Staff> selectStaffs(Map<String, Object> paramMap)
    throws BusinessException;

  public  Map<String, Staff> getSelectStaffsMap(Map<String, Object> paramMap)
    throws BusinessException;

  public  List<String> getSelectStaffNos(Map<String, Object> paramMap)
    throws BusinessException;

  public  List<Transaction> getTransPermissions(String paramString)
    throws BusinessException;

  public  List<Transaction> getTransPermissionsForAdmin()
    throws BusinessException;

  public  List<Transaction> getTransPermissions2(String paramString)
    throws BusinessException;

  public  Page<Staff> selectStaffsByRoleIdPage(Map<String, Object> paramMap, int paramInt1, int paramInt2)
    throws BusinessException;

  public  void updateTranspwdByStaffNo(Staff paramStaff)
    throws BusinessException;
  
  public Staff selectByChannelCode(String ChannelCode)
		    throws BusinessException;
  
  public Map<String, String> selectByIdentNoAndPwd(String identNo,String pwd )  throws BusinessException;
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.service.IStaffAccountService
 * JD-Core Version:    0.5.3
 */