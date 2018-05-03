/**
 * 软件著作权：百富金融技术部
 * 项目名称：互联网金融项目
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.Organization;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.domain.TreeNode;
import com.zjgt.p2p.base.service.IOrganizationService;

/**
 * 组织机构路由控制类
 * 
 * @author yuewenjun
 * 
 */
@Controller
@RequestMapping(value = "/base/org")
public class OrganizationController {

	Logger logger = LoggerFactory.getLogger(OrganizationController.class);

	@Autowired
	private IOrganizationService organizationService;

	@Autowired
	private IMaintenanceLogService maintenanceLogService;

	/**
	 * 获取组织机构页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		return "base/org/orgList";
	}

	/**
	 * 获取完整机构树
	 * 
	 * @return
	 */
	@RequestMapping(value = "/rootTree")
	@ResponseBody
	public List<TreeNode<Organization>> rootTree() {
		TreeNode<Organization> treeNode = new TreeNode<Organization>();
		Organization orgTree = organizationService.getOrganizationRootTree();
		treeNode = convertToTreeNode(orgTree);
		List<TreeNode<Organization>> tree = new ArrayList<TreeNode<Organization>>();
		tree.add(treeNode);
		return tree;
	}

	/**
	 * 获取当前用户id
	 * 
	 * @return
	 */
	private String getCurrentUserId() {
		ShiroStaff userAccount = (ShiroStaff) SecurityUtils.getSubject().getPrincipal();
		return userAccount.getId();
	}

	/**
	 * 获取用户所属机构 树
	 * 
	 * @return
	 */
	@RequestMapping(value = "/orgTree")
	@ResponseBody
	public List<TreeNode<Organization>> orgTree() {
		String uid = getCurrentUserId();
		Organization org = organizationService.getOrganizationByUserId(uid);
		TreeNode<Organization> treeNode = new TreeNode<Organization>();
		Organization orgTree = organizationService.getOrganizationNodeTree(org);
		treeNode = convertToTreeNode(orgTree);
		List<TreeNode<Organization>> tree = new ArrayList<TreeNode<Organization>>();
		tree.add(treeNode);
		
		return tree;
	}

	/**
	 * 将机构树转换为前台树数据格式
	 * 
	 * @param org
	 * @return
	 */
	private TreeNode<Organization> convertToTreeNode(Organization org) {
		TreeNode<Organization> treeNode = new TreeNode<Organization>();
		treeNode.setId(org.getOrgCode());
		treeNode.setText(org.getOrgName());
		treeNode.setAttributes(org);
		List<TreeNode<Organization>> treeNodes = new ArrayList<TreeNode<Organization>>();
		for (Organization childOrg : org.getChildOrganizations()) {
			TreeNode<Organization> childNode = new TreeNode<Organization>();
			childNode = convertToTreeNode(childOrg);
			treeNodes.add(childNode);
		}
		if (treeNodes.size() > 1) {
			Collections.sort(treeNodes, new Comparator<TreeNode<Organization>>() {
				public int compare(TreeNode<Organization> arg0, TreeNode<Organization> arg1) {
					if (arg0.getAttributes().getOrderNo() != null && arg1.getAttributes().getOrderNo() != null) {
						return arg0.getAttributes().getOrderNo().compareTo(arg1.getAttributes().getOrderNo());
					} else if (arg0.getAttributes().getOrderNo() != null) {
						return -1;
					} else if (arg1.getAttributes().getOrderNo() != null) {
						return 1;
					} else {
						return 0;
					}
				}
			});
		}
		treeNode.setChildren(treeNodes);
		
		return treeNode;
	}

	/**
	 * 增加组织机构
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse add(@Valid Organization org, BindingResult result) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");

		if (result.hasErrors()) {
			response.setStatus("FAIL");
		}

		try {
			organizationService.addOrganization(org);

			//添加操作日志
			orgOperLog(BaseConstant.OPER_CODE_ORG_INSERT, BaseConstant.OPER_NAME_ORG_INSERT, org,
					null);

		} catch (BusinessException ex) {
			response.setStatus("FAIL");
			if (ex.getErrorMessages() != null && ex.getErrorMessages().size() != 0) {
				ex.addBindingResultTo(result);
			} else if (ex.getMessage() != null) {
				response.setResult(ex.getMessage());
			}
		}

		if (result.hasErrors()) {
			response.setResult(convertBingResultToString(result));
		}

		return response;
	}

	/**
	 * 修改组织机构信息
	 * 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse update(@Valid Organization org, BindingResult result) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");
		if (result.hasErrors()) {
			response.setStatus("FAIL");
		}

		try {
			Organization old = organizationService.getOrganizationByOrgCode(org.getOrgCode());

			organizationService.updateOrganization(org);

			//添加操作日志
			orgOperLog(BaseConstant.OPER_CODE_ORG_UPDATE, BaseConstant.OPER_NAME_ORG_UPDATE, old,
					org);
		} catch (BusinessException ex) {
			if (ex.getErrorMessages() != null && ex.getErrorMessages().size() != 0) {
				ex.addBindingResultTo(result);
			} else if (ex.getMessage() != null) {
				response.setResult(ex.getMessage());
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
	 * 删除组织机构
	 * 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(String orgCode) {
		JsonResponse response = new JsonResponse();
		response.setStatus("SUCCESS");
		try {
			Organization old = organizationService.getOrganizationByOrgCode(orgCode);
			
			organizationService.deleteOrganization(orgCode);
			
			//添加操作日志
			orgOperLog(BaseConstant.OPER_CODE_ORG_DELETE, BaseConstant.OPER_NAME_ORG_DELETE, null,
					old);

		} catch (BusinessException ex) {
			response.setStatus("FAIL");
			if (ex.getMessage() != null) {
				response.setResult(ex.getMessage());
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
	private void orgOperLog(String operCode, String operName, Organization oldOrg,
			Organization newOrg) {
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		StringBuffer oldInfo = new StringBuffer();
		StringBuffer newInfo = new StringBuffer();
		if (oldOrg != null) {
			oldInfo.append("orgName:" + oldOrg.getOrgName());
			oldInfo.append("|orgCode:" + oldOrg.getOrgCode());
			oldInfo.append("|parentOrgCode:" + oldOrg.getParentOrgCode());

		}
		if (newOrg != null) {
			newInfo.append("orgName:" + newOrg.getOrgName());
			newInfo.append("|orgCode:" + newOrg.getOrgCode());
			newInfo.append("|parentOrgCode:" + newOrg.getParentOrgCode());
		}

		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setOldInfo(oldInfo.toString());
		maintenanceLog.setOperCode(operCode);
		maintenanceLog.setOperName(operName);
		maintenanceLog.setOperDesc(operName);
		maintenanceLogService.insert(maintenanceLog);
	}
}