/**
 * 软件著作权：百富金融技术部
 * 
 * 项目名称：互联网银行项目
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.RoleTransRel;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.domain.TreeNode;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IModuleService;
import com.zjgt.p2p.base.service.IRoleService;

/**
 * 角色路由控制类
 * 
 * @author yuewenjun
 * 
 */
@Controller
@RequestMapping(value = "/base/role")
public class RoleController {

	Logger logger = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IModuleService moduleService;
	@Autowired
	private ICodeInfoService codeInfoService;
	@Autowired
	private IMaintenanceLogService maintenanceLogService;

	/**
	 * 获取角色管理页面
	 * 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ROLE_TYPE", codeInfoService.getCodeInfoListByTypeCode(
						BaseConstant.DICT_CODE_TYPE_ROLE_TYPE));
		return "base/role/roleList";
	}

	/**
	 * 分页获取单个或多个机构的角色列表
	 * 
	 */
	@RequestMapping(value = "/roleByOrgsAndPage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getRoleByOrgsAndPage(String[] orgCodes,
			@RequestParam(required = true) Integer page, 
			@RequestParam(required = true) Integer rows) {
		Map<String, Object> maps = new HashMap<String, Object>();
		if (orgCodes == null || orgCodes.length == 0) {
			maps.put("total", 0);
			maps.put("rows", new ArrayList<Role>());
			return maps;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgCodes", orgCodes);
		Page<Role> role = roleService.getRoleByOrgsAndPage(params, page, rows);

		maps.put("total", role.getTotalCount());
		maps.put("rows", role.getResult());
		return maps;

	}

	/**
	 * 增加角色
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse add(@Valid Role role, BindingResult result) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");
		if (result.hasErrors()) {
			response.setStatus("FAIL");
		} else {
			try {
				roleService.addRole(role);
				roleOperLog(BaseConstant.OPER_CODE_ROLE_INSERT, BaseConstant.OPER_NAME_ROLE_INSERT,
						null, role);
			} catch (BusinessException ex) {
				response.setStatus("FAIL");
				if (ex.getErrorMessages() != null && ex.getErrorMessages().size() != 0) {
					ex.addBindingResultTo(result);
				} else if (ex.getMessage() != null) {
					response.setResult(ex.getMessage());
				} 
			}
		}

		if (result.hasErrors()) {
			response.setResult(convertBingResultToString(result));
		}
		return response;
	}

	/**
	 * 修改角色信息
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse update(@Valid Role role, BindingResult result) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");
		if (result.hasErrors()) {
			response.setStatus("FAIL");
		} else {
			try {
				Role old = roleService.getRoleByRoleCode(role.getRoleCode());
				roleService.updateRole(role);
				roleOperLog(BaseConstant.OPER_CODE_ROLE_UPDATE, BaseConstant.OPER_NAME_ROLE_UPDATE,
						old, role);
			} catch (BusinessException ex) {
				response.setStatus("FAIL");
				if (ex.getErrorMessages() != null && ex.getErrorMessages().size() != 0) {
					ex.addBindingResultTo(result);
				} else if (ex.getMessage() != null) {
					response.setResult(ex.getMessage());
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
	private String convertBingResultToString(BindingResult result) {
		List<FieldError> errors = result.getFieldErrors();
		String err = "";
		for (FieldError error : errors) {
			err += error.getDefaultMessage() + ",";
		}
		return err;
	}

	/**
	 * 删除角色
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(String roleCode) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");
		try {
			Role old = roleService.getRoleByRoleCode(roleCode);
			roleService.deleteRole(roleCode);
			roleOperLog(BaseConstant.OPER_CODE_ROLE_DELETE, BaseConstant.OPER_NAME_ROLE_DELETE,
					old, null);
		} catch (BusinessException ex) {
			response.setStatus("FAIL");
			if (ex.getMessage() != null) {
				response.setResult(ex.getMessage());
			}
		}
		return response;
	}

	/**
	 * ajax获取根模块节点列表
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "getModuleTree", method = RequestMethod.POST)
	@ResponseBody
	public List<TreeNode<Module>> getModuleTree() {
		List<Module> moduleList = moduleService.getModuleTree();
		List<TreeNode<Module>> moduleTreeNodeList = new ArrayList<TreeNode<Module>>();
		if (moduleList != null) {
			for (Module module : moduleList) {
				TreeNode<Module> treeNode = new TreeNode<Module>();
				treeNode.setId(module.getModuleCode());
				treeNode.setText(module.getModuleName());
				treeNode.setChildren(setSubModuleTreeNode(module.getSubModuleList()));
				module.setSubModuleList(null);
				treeNode.setAttributes(module);
				moduleTreeNodeList.add(treeNode);
			}
		}
		return moduleTreeNodeList;
	}

	/**
	 * 获取子模块节点
	 * 
	 * @param subModuleList
	 * @return
	 * @throws BusinessException
	 */
	private List<TreeNode<Module>> setSubModuleTreeNode(List<Module> subModuleList)
			throws BusinessException {
		List<TreeNode<Module>> result = new ArrayList<TreeNode<Module>>();
		if (subModuleList != null) {
			for (Module module : subModuleList) {
				TreeNode<Module> treeNode = new TreeNode<Module>();
				treeNode.setId(module.getModuleCode());
				treeNode.setText(module.getModuleName());
				treeNode.setChildren(setSubModuleTreeNode(module.getSubModuleList()));
				module.setSubModuleList(null);
				treeNode.setAttributes(module);
				result.add(treeNode);
			}
		}
		return result;
	}

	/**
	 * ajax获取模块下交易列表信息
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "getTransByModuleCodeForCheck", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse getTransByModuleCodeForCheck(String moduleCode, String roleCode) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
		List<Transaction> resultList = null;
		if (staff.isSupervisor()) {
			resultList = roleService.getTransByModuleCodeForRole(moduleCode, roleCode);
		} else {
			resultList = roleService.getTransByModuleCodeForRole(staff.getId(), moduleCode,
					roleCode);
		}
		JsonResponse response = new JsonResponse();
		response.setResult(resultList);
		response.setStatus("SUCCESS");
		return response;
	}

	/**
	 * ajax获取角色所有交易权限信息
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "getAllRoleTransRelForCheck", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse getAllRoleTransRelForCheck(String roleCode) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
		List<Module> resultList = null;
		if (staff.isSupervisor()) {
			resultList = roleService.getAllRoleTransRelForCheck(roleCode);
		} else {
			resultList = roleService.getAllRoleTransRelForCheck(staff.getId(), roleCode);
		}
		JsonResponse response = new JsonResponse();
		response.setResult(resultList);
		response.setStatus("SUCCESS");
		return response;
	}

	/**
	 * ajax更新角色交易关联信息
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "updateRoleTransRel", method = RequestMethod.POST)
	@ResponseBody
	public void updateRoleTransRel(String roleCode, String[] transCodeArray) {
		if (roleCode == null || roleCode.trim().isEmpty()) {
			throw new BusinessException("角色编号不能为空！", new Exception());
		}
		List<RoleTransRel> list = new ArrayList<RoleTransRel>();
		if (transCodeArray != null && transCodeArray.length > 0) {
			for (String transCode : transCodeArray) {
				if (transCode == null || transCode.isEmpty()) {
					continue;
				}
				RoleTransRel rel = new RoleTransRel();
				rel.setRoleCode(roleCode);
				rel.setTransCode(transCode);
				list.add(rel);
			}
		}
		roleService.updateRoleTransRel(roleCode, list);
		
		Role role = roleService.getRoleByRoleCode(roleCode);
		roleOperLog(BaseConstant.OPER_CODE_ROLE_PERMISSION, BaseConstant.OPER_NAME_ROLE_PERMISSION,
				null, role);
	}

	/**
	 * 操作日志
	 * 
	 * @param operCode
	 * @param operName
	 * @param oldOrg
	 * @param newOrg
	 */
	private void roleOperLog(String operCode, String operName, Role oldRole,
			Role newRole) {
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		StringBuffer oldInfo = new StringBuffer();
		StringBuffer newInfo = new StringBuffer();
		if (oldRole != null) {
			oldInfo.append("roleCode:" + oldRole.getRoleCode());
			oldInfo.append("|roleName:" + oldRole.getRoleName());
			oldInfo.append("|orgCode:" + oldRole.getOrgCode());
		}
		if (newRole != null) {
			newInfo.append("roleCode:" + newRole.getRoleCode());
			newInfo.append("|roleName:" + newRole.getRoleName());
			newInfo.append("|orgCode:" + newRole.getOrgCode());
		}

		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setOldInfo(oldInfo.toString());
		maintenanceLog.setOperCode(operCode);
		maintenanceLog.setOperName(operName);
		maintenanceLog.setOperDesc(operName);
		maintenanceLogService.insert(maintenanceLog);
	}
	
}
