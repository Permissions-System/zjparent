/**
 * 软件著作权：百富金融技术部
 * 项目名称：互联网银行项目
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.domain.StaffRoleRel;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.service.ISerialService;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * 人员管理路由控制类
 * 
 * @author yuewenjun
 * 
 */
@Controller
@RequestMapping(value = "/base/staff")
public class StaffController {

    Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private IStaffAccountService staffService;

    @Autowired
    private ISerialService serialService;

    @Autowired
    private ICodeInfoService codeInfoService;
    
    @Autowired
	private IMaintenanceLogService maintenanceLogService;
    
//    @Autowired
//	private LendInfoService lendInfoService;
    
    /**
	 * 获取当前用户id
	 * 
	 * @return
	 */
	private String getCurrentUserId() {
        ShiroStaff userAccount = (ShiroStaff) SecurityUtils.getSubject().getPrincipal();
        return userAccount.getIdentNo();
    }
	
	/**
	 * 获取当前用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getPersonalInfo")
    @ResponseBody
	public Staff getStaffByIdentNo(){
		return staffService.findStaffByIdentNo(getCurrentUserId());
	}
	
    /**
     * 更新登录员工个人信息
     * 
     * @param staff
     * @return
     */
    @RequestMapping(value = "/updatePersonalInfo")
    @ResponseBody
    public JsonResponse updatePersonalStaffInfo(String name, String tel, String email) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");

        try {
        	Staff staff = new Staff();
        	staff.setName(name);
        	staff.setEmail(email);
        	staff.setTel(tel);
        	staff.setIdentNo(getCurrentUserId());
        	staffService.updatePersonalStaffInfo(staff);
        } catch (BusinessException e) {
            response.setStatus("FAIL");
            if (e.getMessage() != null) {
            	 response.setResult(e.getMessage());
            } else {
                throw e;
            }
        }

        return response;
    }
    
    /**
     * 更新登录员工密码信息
     * 
     * @param staff
     * @return
     */
    @RequestMapping(value = "/updatePersonalPassword")
    @ResponseBody
	public JsonResponse updatePersonalPassword(String staffNo, String plainPassword,
			String oldPassword) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        
        try {
        	staffService.updatePersonalPassword(staffNo, plainPassword, oldPassword);
        } catch (BusinessException e) {
            response.setStatus("FAIL");
            if (e.getMessage() != null) {
                response.setResult(e.getMessage());
            } else {
                throw e;
            }
        }
        return response;
    }
    

    /**
     * 获取人员管理页面
     * 
     * @param
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
    	//String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_DELETE_FLAG,BaseConstant.DICT_CODE_TYPE_READ_FLAG};
    	String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_STAFF_TYPE,BaseConstant.DICT_CODE_TYPE_STAFF_STATUS};
    	Map<String, List<CodeInfo>> resultMap 
		= codeInfoService.getCodeInfoListByTypeCodes(
				typeCodes);
        model.addAttribute("selects", resultMap);
        return "base/staffAccount/staffList";
    }
    //type:1渠道商经理管理权限 2美联社管理权限
	@RequestMapping(value = "/listTwo/{type}",method = RequestMethod.GET)
    public String investIndex(@PathVariable int type,Model model,HttpSession session,String beginTime,String endTime) {
		String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_STAFF_TYPE,BaseConstant.DICT_CODE_TYPE_STAFF_STATUS};
    	Map<String, List<CodeInfo>> resultMap = codeInfoService.getCodeInfoListByTypeCodes(typeCodes);
        model.addAttribute("selects", resultMap);
        String  result = getReturnStrByType(type);
        //return "base/staffAccount/staffAllList";
        return result;
    }
	
	public String getReturnStrByType(int type){
		String  result = null;
		switch ( type )
		{
			case 1:	result="base/staffAccount/staffAllList";	break;
			case 2:	result="base/staffAccount/staffAllList2";	break;
			default:	result="base/staffAccount/staffAllList";	break;
		}
		return result;
	}

    /**
     * 根据角色获取人员信息
     * 
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "/listByRole")
    @ResponseBody
    public List<Staff> listByRole(String roleCode) {
        List<Staff> staff = staffService.selectStaffsByRoleId(roleCode);
        String[] typeCodes ={BaseConstant.DICT_CODE_TYPE_STAFF_STATUS};
        Map<String, String> map = codeInfoService.getCodeMapsByTypeCodes(typeCodes);
        for(Staff t : staff){
        	t.setStaffStatus(map.get(
        			BaseConstant.DICT_CODE_TYPE_STAFF_STATUS + t.getStaffStatus()));
        }
        return staff;
    }

    /**
     * 获取单个机构人员信息
     * 
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "/listByOrg")
    @ResponseBody
    public List<Staff> listByOrg(String orgCode) {
        List<Staff> staff = staffService.getStaffByOrg(orgCode);
        return staff;
    }
    
    /**
	 * 分页获取单个或多个机构的人员列表
	 * 
	 */
	@RequestMapping(value = "/staffByOrgList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStaffByOrgsAndPage(String[] orgCode,
			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer rows) {
		Map<String, Object> maps = new HashMap<String, Object>();
		if (orgCode == null || orgCode.length == 0) {
			maps.put("total", 0);
			maps.put("rows", new ArrayList<Staff>());
			return maps;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgCode", orgCode);
		Page<Staff> staff = staffService.getStaffByOrgList(params, page, rows);

		maps.put("total", staff.getTotalCount());
		maps.put("rows", staff.getResult());
		return maps;
	}
	@RequestMapping(value = "/staffByOrgListTwo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStaffByOrgsAndPageTwo(String[] orgCode,
			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer rows,
			HttpSession session) {
		String channelCode = null;
		channelCode=(String) session.getAttribute("channelCode");
		Map<String, Object> maps = new HashMap<String, Object>();
		if (orgCode == null || orgCode.length == 0) {
			maps.put("total", 0);
			maps.put("rows", new ArrayList<Staff>());
			return maps;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgCode", orgCode);
		params.put("ChannelCode", channelCode);		
		Page<Staff> staff = staffService.getStaffByOrgListTwo(params, page, rows);
		
		maps.put("total", staff.getTotalCount());
		maps.put("rows", staff.getResult());
		
//		//市场部_根据渠道编号查询用户投资的总数
//		LendInfo lendInfo = null;
//		List<Staff> staffList = null;
//		long totalByPromoCode = 0;
//		long totalByPromoCodeLike = 0;
//		staffList = staff.getResult();
//		lendInfo = new LendInfo();
//		for(Staff sta :staffList )
//		{
//			lendInfo.setPromoCode(sta.getChannelCode());
//			totalByPromoCode = lendInfoService.getDatagridTwoTotal(lendInfo);
//			sta.setTotalByPromoCode(totalByPromoCode);
//		}
//		//市场部_根据渠道编号"模糊"查询用户投资的总数
//		lendInfo.setPromoCode(channelCode);
//		totalByPromoCodeLike = lendInfoService.getlendTotalByPromoCode(lendInfo);
//		maps.put("totalByPromoCodeLike", totalByPromoCodeLike );
		return maps;
	}
	
	/**
	 * 根据姓名搜索获取员工信息
	 * 
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStaffBySearch(String condition,String ChannelCode,String staffType,
			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer rows) {
		Map<String, Object> maps = new HashMap<String, Object>();
		String currentUID = getCurrentUserId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentUID", currentUID);
		params.put("condition", condition.trim());
		params.put("ChannelCode", ChannelCode.trim());
		params.put("staffType", staffType.trim());
		Page<Staff> staff = staffService.getStaffBySearch(params, page, rows);
		
		maps.put("total", staff.getTotalCount());
		maps.put("rows", staff.getResult());
		return maps;
	}
	@RequestMapping(value = "/searchTwo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getStaffBySearchTwo(String condition,String ChannelCode,
			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer rows) {
		Map<String, Object> maps = new HashMap<String, Object>();
		//当前用户的登入名
		String currentUID = getCurrentUserId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("currentUID", currentUID);
		params.put("condition", condition.trim());
		params.put("ChannelCode", ChannelCode.trim());
		params.put("staffType", 4);//员工类型为“渠道商”
		Page<Staff> staff = staffService.getStaffBySearchTwo(params, page, rows);
		
		maps.put("total", staff.getTotalCount());
		maps.put("rows", staff.getResult());
		
		
//		//市场部_根据渠道编号查询用户投资的总数
//		LendInfo lendInfo = null;
//		List<Staff> staffList = null;
//		long totalByPromoCode = 0;
//		long totalByPromoCodeLike = 0;
//		staffList = staff.getResult();
//		lendInfo = new LendInfo();
//		for(Staff sta :staffList )
//		{
//			lendInfo.setPromoCode(sta.getChannelCode());
//			totalByPromoCode = lendInfoService.getDatagridTwoTotal(lendInfo);
//			sta.setTotalByPromoCode(totalByPromoCode);
//		}
//		//市场部_根据渠道编号"模糊"查询用户投资的总数
//		lendInfo.setPromoCode(ChannelCode);
//		totalByPromoCodeLike = lendInfoService.getlendTotalByPromoCode(lendInfo);
//		maps.put("totalByPromoCodeLike", totalByPromoCodeLike );
		return maps;
	}
    
    /**
     * 身份证校验
     * 
     * @param identNo
     * @return
     */
    @RequestMapping(value = "/check")
    @ResponseBody
    public Boolean checkId(String identNo) {
        return staffService.checkIdExist(identNo);
    }
    
    /**
     * 渠道商编号校验
     * 
     * @param channelCode
     * @return
     */
    @RequestMapping(value = "/checkChannelCode")
    @ResponseBody
    public Boolean checkChannelCodeExist(String channelCode, Staff staff) {
        return staffService.checkChannelCodeExist(channelCode);
    }
    
    /**
     * 渠道商编号校验（更新时）
     * 
     * @param channelCode
     * @return
     */
    @RequestMapping(value = "/updateCheckChannelCode")
    @ResponseBody
    public Boolean updateCheckChannelCodeExist(String channelCode, Staff staff) {
    	
    	boolean bl = Boolean.valueOf(false);
    	String staffNo = staff.getStaffNo();
    	if(staffNo!=null && !"".equals(staffNo) )
    	{
    		Staff old = staffService.getStaff(staffNo);
        	String channelCode_old = old.getChannelCode();
        	
        	if(channelCode!=null && !"".equals(channelCode) && channelCode.equals(channelCode_old) )
        	{
        		bl = Boolean.valueOf(true);
        	}
        	else
        	{
        		bl = staffService.checkChannelCodeExist(channelCode);
        	}
    	}
    	else
    	{
    		bl = staffService.checkChannelCodeExist(channelCode);
    	}
    	
    	
        return bl;
    }

    /**
     * 添加员工
     * 
     * @param staff
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public JsonResponse addStaff(@Valid Staff staff, BindingResult result) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        
        if (result.hasErrors()) {
            response.setStatus("FAIL");
        } else {
            try {
               
            	staffService.registerStaff(staff);  
            	
            	
//            	//是否调用.net的webservice
//            	if(PropertiesUtils.getProperties("ONOFF").equals("on"))
//            	{
//            		//调用.netwebservice接口，插入员工信息
//                    String name = staff.getName();
//                    String staffNo = staff.getStaffNo();
//                    String channelCode = staff.getChannelCode();
//                    if( (name!=null && !"".equals(name)) && (staffNo!=null && !"".equals(staffNo)) && (channelCode!=null && !"".equals(channelCode))   )
//                    {
//                    	 //////////////////////////////////////////
//                    	 String j_resultMsg = null;
//                         if(StaffWsdl.getWSStatus())
//                         {
//                         	String jsonStr = StaffWsdl.getJsonStringAddStaff(staff);
//                         	//将Json字符串转为java对象
//                             JSONObject obj = JSONObject.fromObject(jsonStr);
//                             boolean j_result = obj.getBoolean("result");
//                             
//                             //获取Object中的UserName
//                             if (j_result==false) 
//                             {
//                             	j_resultMsg = obj.getString("message");
//                             }
//                         }
//                         else
//                         {
//                        	String URLStr = PropertiesUtils.getProperties("URLStr");
//                         	j_resultMsg = ".net webservice接口连接不上->["+"\n"+URLStr+"]" ;
//                         }
//                         response.setMsg(j_resultMsg);
//                    }
//            	}
                
                
                
				staffOperLog(BaseConstant.OPER_CODE_STAFF_INSERT,
						BaseConstant.OPER_NAME_STAFF_INSERT, null, staff);
				
            } catch (BusinessException e) {
                response.setStatus("FAIL");
                if(e.getErrorMessages() != null && e.getErrorMessages().size()!=0){
                	e.addBindingResultTo(result);
                } else if (e.getMessage() != null) {
                    response.setResult(e.getMessage());
                } 
            }
        }
        
        if (result.hasErrors()) {
        	response.setResult(convertBingResultToString(result));
        }
        
        return response;
    }
    
    
    /**
     * 更新员工基本信息
     * 
     * @param staff
     * @return
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public JsonResponse updateStaffBaseInfo(@Valid Staff staff, BindingResult result) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        
        if (result.hasErrors()) {
            response.setStatus("FAIL");
        } else {
            try {
            	Staff old = staffService.getStaff(staff.getStaffNo());
            	
                staffService.updateStaffBaseInfo(staff);    
                
//                //调用.netwebservice接口，插入员工信息
//                String j_resultMsg = null;
//                //是否调用.net的webservice
//            	if(PropertiesUtils.getProperties("ONOFF").equals("on"))
//            	{
//            		if(StaffWsdl.getWSStatus())
//                    {
//                    	String jsonStr = StaffWsdl.getJsonStringUpdateStaff(staff);
//                    	//将Json字符串转为java对象
//                        JSONObject obj = JSONObject.fromObject(jsonStr);
//                        boolean j_result = obj.getBoolean("result");
//                        
//                        //获取Object中的UserName
//                        if (j_result==false) 
//                        {
//                        	j_resultMsg = obj.getString("message");
//                        }
//                    }
//                    else
//                    {
//                    	String URLStr = PropertiesUtils.getProperties("URLStr");
//                     	j_resultMsg = ".net webservice接口连接不上->["+"\n"+URLStr+"]" ;
//                    }
//            	}
//                
//                response.setMsg(j_resultMsg);
                
                
                //添加操作日志
                staffOperLog(BaseConstant.OPER_CODE_STAFF_UPDATE,
						BaseConstant.OPER_NAME_STAFF_UPDATE, old, staff);
                
                
            } catch (BusinessException e) {
                response.setStatus("FAIL");
                if(e.getErrorMessages() != null && e.getErrorMessages().size()!=0){
                	e.addBindingResultTo(result);
                } else if (e.getMessage() != null) {
                    response.setResult(e.getMessage());
                } 
            }
        }
        
        if (result.hasErrors()) {
            response.setResult(convertBingResultToString(result));
        }
        return response;
    }
    
    /**
     * 将校验错误转为String
     * 
     * @param result
     * @return
     */
    private String convertBingResultToString(BindingResult result){
    	List<FieldError> errors = result.getFieldErrors();
        String err = "";
        for (FieldError error : errors) {
            err += error.getDefaultMessage() + ",";
        }
        return err;
    }

    /**
     * 删除员工
     * 
     * @param staffNo
     *            员工编号
     * @return
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public JsonResponse deleteStaff(String staffNo) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");

        try {
        	Staff old = staffService.getStaff(staffNo);
        	
            staffService.deleteStaff(staffNo);      
            
//          //调用.netwebservice接口，插入员工信息
//            String j_resultMsg = null;
//            //是否调用.net的webservice
//        	if("on".equals(PropertiesUtils.getProperties("ONOFF")) )
//        	{
//        		if(StaffWsdl.getWSStatus())
//                {
//                	String jsonStr = StaffWsdl.getJsonStringDeleteStaff(old.getStaffNo());
//                	//将Json字符串转为java对象
//                    JSONObject obj = JSONObject.fromObject(jsonStr);
//                    boolean j_result = obj.getBoolean("result");
//                    
//                    //获取Object中的UserName
//                    if (j_result==false) 
//                    {
//                    	j_resultMsg = obj.getString("message");
//                    }
//                }
//                else
//                {
//                	String URLStr = PropertiesUtils.getProperties("URLStr");
//                 	j_resultMsg = ".net webservice接口连接不上->["+"\n"+URLStr+"]" ;
//                }
//        	}
//            
//            response.setMsg(j_resultMsg);
            
            staffOperLog(BaseConstant.OPER_CODE_STAFF_DELETE,
					BaseConstant.OPER_NAME_STAFF_DELETE, old, null);
            
        } catch (BusinessException e) {
            response.setStatus("FAIL");
            if (e.getMessage() != null) {
                response.setResult(e.getMessage());
            } 
        }
        
        return response;
        
    }

    /**
     * ajax更新员工角色信息
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "updateStaffRoleRel", method = RequestMethod.POST)
    @ResponseBody
    public void updateStaffRoleRel(String staffNo, String[] roleCodeArray) {
        if (staffNo == null || staffNo.trim().isEmpty()) {
            throw new BusinessException("员工编号不能为空！", new Exception());
        }
        Subject currentUser = SecurityUtils.getSubject();
        ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
        if (staff.getId().equals(staffNo)) {
            throw new BusinessException("不允许管理员为自己配置角色！", new Exception());
        }
        List<StaffRoleRel> list = new ArrayList<StaffRoleRel>();
        String newRoleInfo = "";
        if (roleCodeArray != null && roleCodeArray.length > 0) {
            for (String roleCode : roleCodeArray) {
                if (roleCode == null || roleCode.isEmpty()) {
                    continue;
                }
                StaffRoleRel rel = new StaffRoleRel();
                rel.setRoleCode(roleCode);
                rel.setStaffNo(staffNo);
                list.add(rel);
                newRoleInfo += roleCode + ",";
            }
        }
        staffService.updateStaffRoleRel(staffNo, list);
        
        Staff staffInfo = staffService.getStaff(staffNo);
        MaintenanceLog maintenanceLog = new MaintenanceLog();
		StringBuffer newInfo = new StringBuffer();
		newInfo.append("name:" + staffInfo.getName());
		newInfo.append("|identNo:" + staffInfo.getIdentNo());
		newInfo.append("|orgCode:" + staffInfo.getOrgCode());
		if(newRoleInfo.length() > 0){
			newRoleInfo = newRoleInfo.substring(0, newRoleInfo.length()-1);
		}
		newInfo.append("|roleCode:" + newRoleInfo);

		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setOperCode(BaseConstant.OPER_CODE_STAFF_ROLE);
		maintenanceLog.setOperName(BaseConstant.OPER_NAME_STAFF_ROLE);
		maintenanceLogService.insert(maintenanceLog);
    }

    /**
     * ajax获取员工所有角色信息
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "getAllStaffRoleRelForCheck", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getAllStaffRoleRelForCheck(String staffNo) {
        Subject currentUser = SecurityUtils.getSubject();
        ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
        List<Organization> resultList = null;
        if (staff.isSupervisor()) {
            resultList = staffService.getAllStaffRoleRelForCheck(staffNo);
        } else {
            resultList = staffService.getAllStaffRoleRelForCheck(staff.getId(),
                    staffNo);
        }
        JsonResponse response = new JsonResponse();
        response.setResult(resultList);
        response.setStatus("SUCCESS");
        return response;
    }

    /**
     * ajax获取模块下交易列表信息
     * 
     * @param orgCode
     * @param staffNo
     * @return
     */
    @RequestMapping(value = "getRoleByOrgCodeForCheck", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getRoleByOrgCodeForCheck(String orgCode, String staffNo) {
        Subject currentUser = SecurityUtils.getSubject();
        ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
        List<Role> resultList = null;
        if (staff.isSupervisor()) {
            resultList = staffService
                    .getRoleByOrgCodeForStaff(orgCode, staffNo);
        } else {
            resultList = staffService.getRoleByOrgCodeForStaff(staff.getId(),
                    orgCode, staffNo);
        }
        JsonResponse response = new JsonResponse();
        response.setResult(resultList);
        response.setStatus("SUCCESS");
        return response;
    }

    /**
     * 重置员工密码
     * 
     * @param
     * @return
     */
    @RequestMapping(value = "resetPWD")
    @ResponseBody
	public JsonResponse resetPassword(@RequestParam("staffNo") String staffNo,
			@RequestParam("plainPassword") String plainPassword) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");

        try {
        	Staff old = staffService.getStaff(staffNo);
        	
            staffService.resetPassword(staffNo, plainPassword);  
            
//           //调用.netwebservice接口，插入员工信息
//            String j_resultMsg = null;
//            //是否调用.net的webservice
//        	if(PropertiesUtils.getProperties("ONOFF").equals("on"))
//        	{
//        		if(StaffWsdl.getWSStatus())
//                {
//                	String jsonStr = StaffWsdl.getJsonStringUpdateStaff(staffService.getStaff(staffNo));
//                	//将Json字符串转为java对象
//                    JSONObject obj = JSONObject.fromObject(jsonStr);
//                    boolean j_result = obj.getBoolean("result");
//                    
//                    //获取Object中的UserName
//                    if (j_result==false) 
//                    {
//                    	j_resultMsg = obj.getString("message");
//                    }
//                }
//                else
//                {
//                	String URLStr = PropertiesUtils.getProperties("URLStr");
//                 	j_resultMsg = ".net webservice接口连接不上->["+"\n"+URLStr+"]" ;
//                }
//        	}
//            
//            response.setMsg(j_resultMsg);
            
            staffOperLog(BaseConstant.OPER_CODE_STAFF_RESETPWD,
					BaseConstant.OPER_NAME_STAFF_RESETPWD, old, null);
            
        } catch (BusinessException e) {
            response.setStatus("FAIL");
            if (e.getMessage() != null) {
                response.setResult(e.getMessage());
            } else {
                throw e;
            }
        }
        
        return response;
    }
    
    /**
	 * 操作日志
	 * 
	 * @param operCode
	 * @param operName
	 * @param oldOrg
	 * @param newOrg
	 */
	private void staffOperLog(String operCode, String operName, Staff oldStaff,
			Staff newStaff) {
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		StringBuffer oldInfo = new StringBuffer();
		StringBuffer newInfo = new StringBuffer();
		if (oldStaff != null) {
			oldInfo.append("name:" + oldStaff.getName());
			oldInfo.append("|identNo:" + oldStaff.getIdentNo());
			oldInfo.append("|orgCode:" + oldStaff.getOrgCode());
			oldInfo.append("|staffType:" + oldStaff.getStaffType());
			oldInfo.append("|staffStatus:" + oldStaff.getStaffStatus());
			oldInfo.append("|channelCode:" + oldStaff.getChannelCode());

		}
		if (newStaff != null) {
			newInfo.append("name:" + newStaff.getName());
			newInfo.append("|identNo:" + newStaff.getIdentNo());
			newInfo.append("|orgCode:" + newStaff.getOrgCode());
			newInfo.append("|staffType:" + newStaff.getStaffType());
			newInfo.append("|staffStatus:" + newStaff.getStaffStatus());
			newInfo.append("|channelCode:" + newStaff.getChannelCode());
		}

		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setOldInfo(oldInfo.toString());
		maintenanceLog.setOperCode(operCode);
		maintenanceLog.setOperName(operName);
		maintenanceLog.setOperDesc(operName);
		maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
     * 根据staffNo获取交易列表
     * 
     * @param  staffNo
     * @return
     */
    @RequestMapping(value = "getTrans")
    @ResponseBody
	public List<Transaction> getTrans(@RequestParam("staffNo") String staffNo) {
        List<Transaction> list = null;
        try {
        	list = staffService.getTransPermissions2(staffNo);
        } catch (BusinessException e) {
            if (e.getMessage() != null) {
                e.getMessage();
            } else {
                throw e;
            }
        }
        return list;
    }
    
    /**
     * 根据角色分页获取人员信息
     * 
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "/listByRolePage")
    @ResponseBody
    public Map<String, Object> listByRolePage(String roleCode,
    		@RequestParam(value="page",required=false) int page, 
    		@RequestParam(value="rows",required=false) int rows) {
    	int pageNo = page;
		int pageSize = rows;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleCode", roleCode);
		
        Page<Staff> pageStaff = staffService.selectStaffsByRoleIdPage(param,pageNo,pageSize);
        String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_STAFF_STATUS};
        Map<String, String> codeMap = codeInfoService.getCodeMapsByTypeCodes(typeCodes);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", pageStaff.getTotalCount()) ;
        List<Staff> lists= pageStaff.getResult();
        List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
		for (Staff staff : lists) {
			map = new HashMap<String, String>();
			map.put("staffNo", staff.getStaffNo());
			map.put("orgCode", staff.getOrgCode());
			map.put("orgName", staff.getOrgName());
			map.put("name", staff.getName());
			map.put("identNo", staff.getIdentNo());
			map.put("tel", staff.getTel());
			map.put("email", staff.getEmail());
			map.put("staffStatus", codeMap.get(
        			BaseConstant.DICT_CODE_TYPE_STAFF_STATUS + staff.getStaffStatus()));
			map.put("createDate", staff.getCreateDate());
			rowList.add(map);
		}
		result.put("success", true);
		result.put("rows", rowList);
        return result;
    }
    
    /**
     * .net webservice 接口 插入员工信息
     * @param staff
     * @return
     */
    /*public String getJsonStringAddStaff(Staff staff)
    {
    	String result = null;
    	String key = "A8CAA975-6912-4069-A8C7-40861A44979B";
    	
    	try
		{
    		MerchantAPILocator service = new MerchantAPILocator();
            java.net.URL url = new java.net.URL("http://192.168.1.33:125/?wsdl");
            MerchantAPISoapStub stub = new MerchantAPISoapStub(url, service);
            String jStr = JSONObject.fromObject(staff).toString();
            System.out.println(jStr);
            
            result = stub.push(jStr, key );
		} catch (Exception e)
		{
			e.printStackTrace();
		}
        return result;
    }*/
    
    /**
     * .net webservice 接口 更新员工信息
     * @param staff
     * @return
     */
    /*public String getJsonStringUpdateStaff(Staff staff)
    {
    	String result = null;
    	String key = "A8CAA975-6912-4069-A8C7-40861A44979B";
    	
    	try
		{
    		MerchantAPILocator service = new MerchantAPILocator();
            java.net.URL url = new java.net.URL("http://192.168.1.33:125/?wsdl");
            MerchantAPISoapStub stub = new MerchantAPISoapStub(url, service);
            String jStr = JSONObject.fromObject(staff).toString();
            result = stub.update(jStr, key);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
        return result;
    }*/
    
}
