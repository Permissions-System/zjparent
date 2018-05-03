package com.zjgt.p2p.manage.base.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.paginator.vo.Page;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * 核心企业客户经理列表
 * 
 * @author xrwang
 * 
 */
@Controller
@RequestMapping(value = "/base/busiGroup/coreEntCustManagerList")
public class CoreEntCustManagerListController {
    @Autowired
    private ICodeInfoService codeInfoService;
    @Autowired
    private IStaffAccountService staffService;
    @Autowired
    private IMaintenanceLogService maintenanceLogService;

    /**
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        return "/base/busiGroup/coreEntCustManagerList";
    }

    /**
     * 客户经理列表数据
     * 
     * @param page
     * @param rows
     * @param identNo
     * @param name
     * @return
     */
    @RequestMapping(value = "loadData", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loadData(
            @RequestParam(value = "page", required = false) Integer pageNo,
            @RequestParam(value = "rows", required = false) Integer pageSize,
            @RequestParam(value = "identNo", required = false) String identNo,
            @RequestParam(value = "name", required = false) String name) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("identNo", identNo);
        params.put("name", name);
        params.put("roleCode", BaseConstant.CM_FIXED_ROLE_COREENT_CM);// 核心企业
        Page<Staff> pageList = staffService.findCustManager(pageNo, pageSize, params);
        resultMap.put("total", pageList.getTotalCount()); // 总记录数
        // 绑定数据集
        resultMap.put("rows", pageList.getResult());// 本次查询结果
        return resultMap;
    }

    /**
     * 移除核心企业客户经理角色权限
     * 
     * @param staffNo
     *            员工编号
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteStaff(String staffNo) {
        Staff staff = staffService.getStaff(staffNo);
        staffService.removeStaffRoleRel(staffNo, BaseConstant.CM_FIXED_ROLE_COREENT_CM);
        // 登记用户行为日志
        this.coreEntCmOperLog(BaseConstant.OPER_CODE_CORE_CM_DELETE,
                BaseConstant.OPER_NAME_CORE_CM_DELETE, null, staff);
    }

    /**
     * 创建员工(核心企业客户经理)
     */
    @RequestMapping(value = "createCoreCustManager", method = RequestMethod.POST)
    @ResponseBody
    public void createCoreCustManager(Staff staff) {
        staffService.createOrUpdateCmStaff(staff, BaseConstant.CM_FIXED_ROLE_COREENT_CM);
        // 登记用户行为日志
        this.coreEntCmOperLog(BaseConstant.OPER_CODE_CORE_CM_ADD,
                BaseConstant.OPER_NAME_CORE_CM_ADD, staff, null);
    }

    /**
     * 获取码表信息
     */
    @RequestMapping(value = "getCodeInfo/{typeCode}", method = RequestMethod.POST)
    @ResponseBody
    public List<CodeInfo> getCodeInfo(@PathVariable(value = "typeCode") String typeCode) {
        if (StringUtils.isEmpty(typeCode)) {
            return null;
        }
        List<CodeInfo> list = codeInfoService.getCodeInfoListByTypeCode(typeCode);
        CodeInfo code = new CodeInfo();
        code.setConfigCode("");
        code.setConfigName("请选择");
        list.add(0, code);
        return list;
    }

    /**
     * 核心企业客户经理管理行为日志
     * 
     * @param operCode
     * @param operName
     * @param addStaff
     * @param deleteStaff
     */
    private void coreEntCmOperLog(String operCode, String operName, Staff addStaff,
            Staff deleteStaff) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        StringBuffer oldInfo = new StringBuffer();
        StringBuffer newInfo = new StringBuffer();
        if (deleteStaff != null) {
            oldInfo.append("identNo:" + deleteStaff.getIdentNo());
            oldInfo.append("|name:" + deleteStaff.getName());
            oldInfo.append("|c3OrgNo:" + deleteStaff.getC3OrgNo());
            oldInfo.append("|c3OrgName:" + deleteStaff.getC3OrgName());
        }
        if (addStaff != null) {
            newInfo.append("identNo:" + addStaff.getIdentNo());
            newInfo.append("|name:" + addStaff.getName());
            newInfo.append("|c3OrgNo:" + addStaff.getC3OrgNo());
            newInfo.append("|c3OrgName:" + addStaff.getC3OrgName());
        }

        maintenanceLog.setNewInfo(newInfo.toString());
        maintenanceLog.setOldInfo(oldInfo.toString());
        maintenanceLog.setOperCode(operCode);
        maintenanceLog.setOperName(operName);
        maintenanceLog.setOperDesc(operName);
        maintenanceLogService.insert(maintenanceLog);
    }
}
