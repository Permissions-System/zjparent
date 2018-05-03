package com.zjgt.p2p.base.dao;

import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.StaffRoleRel;
import com.zjgt.p2p.base.domain.Transaction;
import java.util.List;
import java.util.Map;
import org.springfk.pancloud.daoframework.support.PanCloudDaoRepository;

//@PanCloudDaoRepository
public  interface StaffDao
{
  public  int deleteByPrimaryKey(String paramString);

  public  int insert(Staff paramStaff);

  public  Staff selectByPrimaryKey(String paramString);

  /**
   * 根据“用户名IDENT_NO”获取“CP_STAFF”信息
   * @param paramString
   * 			用户名=身份（IDENT_NO ）
   * @return
   * @return: Staff
   */
  public  Staff selectByIdentNo(String paramString);

  public  int updateByPrimaryKey(Staff paramStaff);

  public  void updateStaffBaseInfo(Staff paramStaff);

  /**
   * 根据“员工编号STAFF_NO”获取“员工角色关系表CP_STAFF_ROLE_REL”中的“角色编号Role_CODE”
   * @param paramString
   * 			员工编号
   * @return
   * @return: List<String>
   */
  public  List<String> selectRolesByStaffNo(String paramString);

  public  List<String> selectPermissionsBy(String paramString);

  public  List<String> selectPermissionsForAdmin();

  public  List<Staff> selectByOrg(String paramString);

  public  List<Staff> selectByOrgList(Map<String, Object> paramMap);
  public  List<Staff> selectByOrgListTwo(Map<String, Object> paramMap);

  public  List<Staff> selectByNameSearch(Map<String, Object> paramMap);
  public  List<Staff> selectByNameSearchTwo(Map<String, Object> paramMap);

  public  List<Staff> selectStaffsByRoleId(String paramString);

  public  int deleteStaffRoleByStaffNo(String paramString);

  public  int insertStaffRoleRel(StaffRoleRel paramStaffRoleRel);

  public  List<StaffRoleRel> selectStaffRoleByStaffNo(String paramString);

  public  List<Role> findRoleByOrgCodeForStaff(Map<String, String> paramMap);

  public  List<Role> findRoleByOrgCodeForAdminStaff(Map<String, String> paramMap);

  public  List<Role> findAvailableRoleByOrgCodeForStaff(Map<String, String> paramMap);

  public  List<Organization> findRoleOrgByRoleCode(String paramString);

  public  int resetPassword(Staff paramStaff);

  public  List<Staff> findCustManager(Map<String, Object> paramMap);

  public  List<StaffRoleRel> selectStaffRole(Map<String, Object> paramMap);

  public  int deleteStaffRole(Map<String, Object> paramMap);

  public  List<Staff> findStaffByRoleCode(Map<String, Object> paramMap);

  /**
   * 根据“员工编号STAFF_NO”，获取“组织编号ORG_CODE”
   * @param paramString
   * 			员工编号		
   * @return
   * @return: String
   */
  public  String selectStaffOrg(String paramString);

  public  int updatePersonalStaffInfo(Staff paramStaff);

  public  List<Staff> selectStaffs(Map<String, Object> paramMap);

  /**
   * 根据“员工编号STAFF_NO”获取“cp_trans表中的url”
   * @param paramString
   * @return
   * @return: List<Transaction>
   */
  public  List<Transaction> selectTranPermissionsForStaff(String paramString);

  /**
   * 获取“交易列表cp_trans->url”
   * @return
   * @return: List<Transaction>
   */
  public  List<Transaction> selectTranPermissionsForAdmin();

  public  List<Transaction> selectTranPermissions(String paramString);

  public  List<Staff> selectStaffsByRoleIdPage(Map<String, Object> paramMap);

  public  void updateTranspwdByStaffNo(Staff paramStaff);
  
  public  Staff selectByChannelCode(String ChannelCode);
  
  public  Staff selectByIdentNoAndPwd(Map<String, Object> paramMap);
  //public  List<Staff> selectByOrgListTwo(Map<String, Object> paramMap);
  
}

/* Location:           C:\Users\kaiyun\Desktop\zjp2p-system-1.0-SNAPSHOT.jar
 * Qualified Name:     com.zjgt.p2p.base.dao.StaffDao
 * JD-Core Version:    0.5.3
 */