package com.zjgt.p2p.base.service.impl;

import com.zjgt.p2p.base.dao.StaffDao;
import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.StaffRoleRel;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.base.service.IStaffAccountService;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.Validator;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.DigestUtils;
import org.springfk.pancloud.utils.EncodesUtils;
import org.springfk.pancloud.utils.StringUtils;
import org.springfk.pancloud.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StaffAccountService
  implements IStaffAccountService
{
  public static final String HASH_ALGORITHM = "SHA-1";
  public static final int HASH_INTERATIONS = 1024;
  private static final int SALT_SIZE = 8;
  private static final String WORKBENCH_ROLES = "WB001,WB002,WB003,WB004,WB005,WB006";

  @Autowired
  private StaffDao staffDao;

  @Autowired
  private ISerialService serialService;

  @Autowired
  private IErrorLogsService errLogService;

  @Autowired
  private Validator validator;

  public String getWorkBenchRoles()
  {
    return "WB001,WB002,WB003,WB004,WB005,WB006";
  }

  public Staff getStaff(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectByPrimaryKey(staffNo);
  }

  public Staff findStaffByIdentNo(String identNo)
    throws BusinessException
  {
    return this.staffDao.selectByIdentNo(identNo);
  }

  public Boolean checkIdExist(String identNo)
    throws BusinessException
  {
    Staff st = this.staffDao.selectByIdentNo(identNo);
    if (st != null) {
      return Boolean.valueOf(false);
    }

    return Boolean.valueOf(true);
  }

  private void validateStaff(Staff staff)
  {
    try
    {
      Set result = this.validator.validate(staff, new Class[0]);
      if (!(result.isEmpty()))
        throw new BusinessException("数据校验错误");
    }
    catch (BusinessException be) {
      throw be;
    } catch (Exception e) {
      List list = new ArrayList();
      list.add(e.getMessage());
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPEI0018", null, list, e));
    }
  }

  public void registerStaff(Staff staff)
  {
    validateStaff(staff);
    if ((staff.getPlainPassword() == null) || (staff.getPlainPassword().equals(""))) {
      throw new BusinessException("密码不能为空！");
    }
    if (!(checkIdExist(staff.getIdentNo()).booleanValue())) {
      throw new BusinessException("身份证号已被使用！");
    }

    Map staffMap = new HashMap();
    staffMap.put("ABC", "ABC");
    staff.setStaffNo(this.serialService.getSerial("StaffNo", staffMap));

    entryptPassword(staff);

    Format format = new SimpleDateFormat("yyyyMMdd");
    staff.setCreateDate(format.format(new Date()));
    try
    {
      this.staffDao.insert(staff);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0003", null, e));
    }
  }

  public List<Staff> getStaffByOrg(String orgCode)
    throws BusinessException
  {
    List staff = this.staffDao.selectByOrg(orgCode);
    return staff;
  }

  public Page<Staff> getStaffByOrgList(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.staffDao.selectByOrgList(params));
    return page;
  }

  public Page<Staff> getStaffBySearch(Map<String, Object> params, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    params.put("pageObject", page);
    page.setResult(this.staffDao.selectByNameSearch(params));
    return page;
  }

  public List<Staff> selectStaffsByRoleId(String roleCode)
    throws BusinessException
  {
    List staff = this.staffDao.selectStaffsByRoleId(roleCode);
    return staff;
  }

  public String getSuccessUrl(String staffNo)
  {
	  List<String> roles = this.staffDao.selectRolesByStaffNo(staffNo);
    if (roles.size() == 0) {
      return "/home/index";
    }
    String[] workbenchRoles = StringUtils.split("WB001,WB002,WB003,WB004,WB005,WB006", ",");
    List wbRoles = new ArrayList();
    for (String wbRole : workbenchRoles) {
      wbRoles.add(wbRole);
    }
    for (String role : roles) {
      if (!(wbRoles.contains(role)))
      {
        return "/home/index";
      }
    }

    return "/workbench";
  }

  private void entryptPassword(Staff staff)
  {
    byte[] salt = DigestUtils.generateSalt(8);
    staff.setSalt(EncodesUtils.encodeHex(salt));

    byte[] hashPassword = DigestUtils.sha1(staff.getPlainPassword().getBytes(), salt, 1024);
    staff.setPwd(EncodesUtils.encodeHex(hashPassword));
  }

  @Autowired
  public void setStaffDao(StaffDao staffDao) {
    this.staffDao = staffDao;
  }

  public List<String> getRoles(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectRolesByStaffNo(staffNo);
  }

  public List<String> getPermissions(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectPermissionsBy(staffNo);
  }

  public List<String> getPermissionsForAdmin()
    throws BusinessException
  {
    return this.staffDao.selectPermissionsForAdmin();
  }

  public List<Transaction> getTransPermissions(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectTranPermissionsForStaff(staffNo);
  }

  public List<Transaction> getTransPermissionsForAdmin()
    throws BusinessException
  {
    return this.staffDao.selectTranPermissionsForAdmin();
  }

  public void updateStaffBaseInfo(Staff staff)
    throws BusinessException
  {
    validateStaff(staff);
    try {
      this.staffDao.updateStaffBaseInfo(staff);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0007", null, e));
    }
  }

  public void deleteStaff(String staffNo)
    throws BusinessException
  {
    try
    {
      this.staffDao.deleteStaffRoleByStaffNo(staffNo);
      this.staffDao.deleteByPrimaryKey(staffNo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0002", null, e));
    }
  }

  public void updateStaffRoleRel(String staffNo, List<StaffRoleRel> list)
    throws BusinessException
  {
    try
    {
      this.staffDao.deleteStaffRoleByStaffNo(staffNo);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0004", null, e));
    }

    if ((list != null) && (list.size() > 0))
      for (StaffRoleRel rel : list) {
        rel.setRecNo(UUIDUtils.generate());
        try {
          this.staffDao.insertStaffRoleRel(rel);
        } catch (Exception e) {
          throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0005", null, e));
        }
      }
  }

  public List<StaffRoleRel> getStaffRoleRel(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectStaffRoleByStaffNo(staffNo);
  }

  public List<Role> getRoleByOrgCodeForStaff(String orgCode, String staffNo)
    throws BusinessException
  {
    Map map = new HashMap();
    map.put("orgCode", orgCode);
    map.put("staffNo", staffNo);
    return this.staffDao.findRoleByOrgCodeForStaff(map);
  }

  public List<Role> getRoleByOrgCodeForStaff(String adminNo, String orgCode, String staffNo)
    throws BusinessException
  {
    Map map = new HashMap();
    map.put("adminNo", adminNo);
    map.put("orgCode", orgCode);
    map.put("staffNo", staffNo);

    List listA = this.staffDao.findRoleByOrgCodeForAdminStaff(map);

    List<Role> listB = this.staffDao.findAvailableRoleByOrgCodeForStaff(map);

    if ((listB == null) || (listB.size() == 0))
      return listA;
    if ((listA == null) || (listA.size() == 0)) {
      for (Role b : listB) {
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
      Role a = (Role)listA.get(stepA);
      Role b = (Role)listB.get(stepB);
      if (a.getRoleCode().equals(b.getRoleCode())) {
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
      Role b = (Role)listB.get(stepB);
      b.setDisabled(Boolean.valueOf(true));
      resultList.add(b);
      ++stepB;
    }
    return resultList;
  }

  public List<Organization> getAllStaffRoleRelForCheck(String staffNo)
    throws BusinessException
  {
	  List<Organization> resultList = this.staffDao.findRoleOrgByRoleCode(staffNo);
    if (resultList != null) {
      for (Organization org : resultList) {
        org.setRoleList(getRoleByOrgCodeForStaff(org.getOrgCode(), staffNo));
      }
    }
    return resultList;
  }

  public List<Organization> getAllStaffRoleRelForCheck(String adminNo, String staffNo)
    throws BusinessException
  {
	  List<Organization> resultList = this.staffDao.findRoleOrgByRoleCode(staffNo);
    if (resultList != null) {
      for (Organization org : resultList) {
        org.setRoleList(getRoleByOrgCodeForStaff(adminNo, org.getOrgCode(), staffNo));
      }
    }
    return resultList;
  }

  public void resetPassword(String staffNo, String plainPassword)
    throws BusinessException
  {
    Staff staff = new Staff();
    staff.setStaffNo(staffNo);
    staff.setPlainPassword(plainPassword);

    entryptPassword(staff);
    try
    {
      this.staffDao.resetPassword(staff);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0006", null, e));
    }
  }

  public Page<Staff> findCustManager(int pageNo, int pageSize, Map<String, Object> paramMap)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    paramMap.put("pageObject", page);
    paramMap.put("staffType", "2");
    page.setResult(this.staffDao.findCustManager(paramMap));
    return page;
  }

  public void removeStaffRoleRel(String staffNo, String roleCode)
    throws BusinessException
  {
    Map map = new HashMap();
    map.put("staffNo", staffNo);
    map.put("roleCode", roleCode);
    try {
      this.staffDao.deleteStaffRole(map);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0004", null, e));
    }
  }

  public Staff createOrUpdateStaffWithRole(Staff staff, String[] roleCodes)
    throws BusinessException
  {
    Staff existStaff = this.staffDao.selectByIdentNo(staff.getIdentNo());
    if (existStaff == null) {
      registerStaff(staff);
      if ((roleCodes != null) && (roleCodes.length > 0)) {
        for (String roleCode : roleCodes) {
          StaffRoleRel staffRoleRel = new StaffRoleRel();
          staffRoleRel.setRecNo(UUIDUtils.generate());
          staffRoleRel.setRoleCode(roleCode);
          staffRoleRel.setStaffNo(staff.getStaffNo());
          this.staffDao.insertStaffRoleRel(staffRoleRel);
        }
      }
      return staff;
    }

    if (!(StringUtils.isEmpty(staff.getName()))) {
      existStaff.setName(staff.getName());
    }

    if (!(StringUtils.isEmpty(staff.getC3OrgNo()))) {
      existStaff.setC3OrgNo(staff.getC3OrgNo());
      existStaff.setC3OrgName(staff.getC3OrgName());
    }

    if (StringUtils.isEmpty(existStaff.getTel())) {
      existStaff.setTel(staff.getTel());
    }
    if (StringUtils.isEmpty(existStaff.getEmail())) {
      existStaff.setEmail(staff.getEmail());
    }
    this.staffDao.updateByPrimaryKey(existStaff);
    if ((roleCodes != null) && (roleCodes.length > 0)) {
      List list = this.staffDao.selectStaffRoleByStaffNo(existStaff.getStaffNo());
      if ((list != null) && (list.size() > 0)) {
        int listSize = list.size();
        for (String roleCode : roleCodes) {
          int i = 0;
          while (i < listSize) {
            if (((StaffRoleRel)list.get(i)).getRoleCode().equals(roleCode)) {
              break;
            }
            ++i;
          }
          if (i == listSize) {
            StaffRoleRel staffRoleRel = new StaffRoleRel();
            staffRoleRel.setRecNo(UUIDUtils.generate());
            staffRoleRel.setRoleCode(roleCode);
            staffRoleRel.setStaffNo(existStaff.getStaffNo());
            this.staffDao.insertStaffRoleRel(staffRoleRel);
          }
        }
      } else {
        for (String roleCode : roleCodes) {
          StaffRoleRel staffRoleRel = new StaffRoleRel();
          staffRoleRel.setRecNo(UUIDUtils.generate());
          staffRoleRel.setRoleCode(roleCode);
          staffRoleRel.setStaffNo(existStaff.getStaffNo());
          this.staffDao.insertStaffRoleRel(staffRoleRel);
        }
      }
    }
    return existStaff;
  }

  public Page<Staff> getStaffByRoleCode(int pageNo, int pageSize, String[] roleCodes)
    throws BusinessException
  {
    Map paramMap = new HashMap();
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    paramMap.put("pageObject", page);
    paramMap.put("roleCodes", roleCodes);
    page.setResult(this.staffDao.findStaffByRoleCode(paramMap));
    return page;
  }

  public Staff createOrUpdateLoanApproveStaff(Staff staff)
    throws BusinessException
  {
    staff.setOrgCode("011000");
    staff.setStaffStatus("1");
    staff.setStaffType("2");
    staff.setPlainPassword("12345678");
    return createOrUpdateStaffWithRole(staff, new String[] { "LN006" });
  }

  public Staff createOrUpdateLoanManagerStaff(Staff staff, String[] roleCodes)
    throws BusinessException
  {
    staff.setOrgCode("011000");
    staff.setStaffStatus("1");
    staff.setStaffType("2");
    staff.setPlainPassword("12345678");
    return createOrUpdateStaffWithRole(staff, roleCodes);
  }

  public Staff createOrUpdateCmStaff(Staff staff, String cmFixedRoleType)
    throws BusinessException
  {
    staff.setOrgCode("011000");
    staff.setStaffStatus("1");
    staff.setStaffType("2");
    staff.setPlainPassword("12345678");
    return createOrUpdateStaffWithRole(staff, new String[] { cmFixedRoleType });
  }

  public int updatePersonalStaffInfo(Staff staff)
    throws BusinessException
  {
    try
    {
      return this.staffDao.updatePersonalStaffInfo(staff);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0007", null, e));
    }
  }

  public int updatePersonalPassword(String staffNo, String plainPassword, String oldPassword)
    throws BusinessException
  {
    Staff staff = new Staff();
    staff.setStaffNo(staffNo);
    staff.setPlainPassword(plainPassword);

    Staff tmp = this.staffDao.selectByPrimaryKey(staffNo);
    String salt = tmp.getSalt();
    String rightPwd = tmp.getPwd();
    byte[] hashPwd = DigestUtils.sha1(oldPassword.getBytes(), EncodesUtils.decodeHex(salt), 1024);
    String inputPwd = EncodesUtils.encodeHex(hashPwd);

    if (!(rightPwd.equals(inputPwd))) {
      throw new BusinessException("密码错误！");
    }

    entryptPassword(staff);
    try
    {
      return this.staffDao.resetPassword(staff);
    } catch (Exception e) {
      throw new BusinessException(this.errLogService.writeErrorLog(super.getClass(), "CPSA0006", null, e));
    }
  }

  public List<Staff> getStaffs(Map<String, Object> map)
    throws BusinessException
  {
    if ((map == null) || (!(map.containsKey("staffNos")))) {
      return null;
    }
    List staffNos = (List)map.get("staffNos");
    if ((staffNos == null) || (staffNos.size() == 0)) {
      staffNos = new ArrayList();
      staffNos.add("");
      map.put("staffNos", staffNos);
    }

    return this.staffDao.selectStaffs(map);
  }

  public List<Transaction> getTransPermissions2(String staffNo)
    throws BusinessException
  {
    return this.staffDao.selectTranPermissions(staffNo);
  }

  public Page<Staff> selectStaffsByRoleIdPage(Map<String, Object> param, int pageNo, int pageSize)
    throws BusinessException
  {
    Page page = new Page();
    page.setPageNo(pageNo);
    page.setPageSize(pageSize);
    param.put("pageObject", page);
    List staff = this.staffDao.selectStaffsByRoleIdPage(param);
    page.setResult(staff);
    return page;
  }

  public List<Staff> selectStaffs(Map<String, Object> map)
    throws BusinessException
  {
    return this.staffDao.selectStaffs(map);
  }

  public List<String> getSelectStaffNos(Map<String, Object> map)
    throws BusinessException
  {
    List staffNoList = new ArrayList();
    List<Staff>  resultList = this.staffDao.selectStaffs(map);
    if ((resultList == null) || (resultList.size() == 0)) {
      return staffNoList;
    }
    for (Staff staff : resultList) {
      staffNoList.add(staff.getStaffNo());
    }
    return staffNoList;
  }

  public Map<String, Staff> getSelectStaffsMap(Map<String, Object> map)
    throws BusinessException
  {
    Map resultMap = new HashMap();
    List<Staff>  staffList = selectStaffs(map);
    if ((staffList != null) && (staffList.size() > 0)) {
      for (Staff info : staffList) {
        resultMap.put(info.getStaffNo(), info);
      }
    }
    return resultMap;
  }

  public void updateTranspwdByStaffNo(Staff staff) throws BusinessException
  {
    this.staffDao.updateTranspwdByStaffNo(staff);
  }
}