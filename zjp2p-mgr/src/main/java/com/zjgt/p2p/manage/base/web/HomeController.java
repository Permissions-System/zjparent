/**
 * 软件著作权：百富金融技术部
 * 
 * 系统名称：互联网金融项目
 * 
 */
package com.zjgt.p2p.manage.base.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.domain.JsonResponse;

import com.zjgt.p2p.manage.common.TokenInject;
import com.zjgt.p2p.manage.common.TokenValidate;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.service.IMenuService;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * Home 分发控制器
 * 
 * @author xiaohui
 * 
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IStaffAccountService staffAccountService;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
		String successUrl = staffAccountService.getSuccessUrl(staff.getId());
		return "redirect:" + successUrl;

	}

	/**
	 * 索引
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index")
	public String index(Model model) {
		String workBenchRoles = staffAccountService.getWorkBenchRoles();
		model.addAttribute("workBenchRoles", workBenchRoles);
		return "base/home/index";
	}

	/**
	 * 员工
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/staff")
	public String staff(Model model) {
		return "base/home/staff";
	}

	/**
	 * 角色
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/roles")
	public String roles(Model model) {
		return "base/home/roles";
	}

	/**
	 * 员工菜单树
	 */
	@RequestMapping(value = "getStaffMenuTree", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse getStaffMenuTree() {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroStaff staff = (ShiroStaff) currentUser.getPrincipal();
		JsonResponse response = new JsonResponse();
		if (staff.isSupervisor()) {
			response.setResult(menuService.getAdminMenus());
		} else {
			response.setResult(menuService.getStaffMenus(staff.getId()));
		}
		response.setStatus("SUCCESS");
		return response;
	}

	/**
	 * 注册
	 * 
	 * @param username
	 * @return
	 */
	@TokenInject
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(String username) {
		return "base/home/register";
	}

	/**
	 * 再注册
	 * 
	 * @param username
	 * @return
	 */
	@TokenInject
	@TokenValidate
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(String username) {
		if (!username.equals("xiaohui")) {
			return "base/home/register";
		} else {
			return "base/home/success";
		}

	}

	/**
	 * 模拟POST
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String post(Model model,@PathVariable("id") String id) {
		model.addAttribute("sid", id);
		return "base/home/post";
	}

}