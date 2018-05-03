/**
 * 软件著作权：百富金融技术部
 * 
 * 系统名称：互联网金融项目
 * 
 */
package com.zjgt.p2p.manage.base.web;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.paginator.vo.Page;

import com.zjgt.p2p.base.domain.LoginLog;
import com.zjgt.p2p.base.service.ILoginLogService;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.Staff;
import com.zjgt.p2p.base.service.IStaffAccountService;

/**
 * 日志管理-后台用户登录日志 分发控制器
 * @author lutao
 *
 */
@Controller
@RequestMapping(value = "/base/loginLog/log")
public class LoginLogController {
    Logger logger = LoggerFactory.getLogger(LoginLogController.class);
    
	/**
	 * 邮箱域名配置 服务接口
	 */
	@Autowired
	private ILoginLogService loginLogService;
	
	/**
	 * StaffAccount 服务接口
	 */
	@Autowired
	private IStaffAccountService staffAccountService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	// 获取文件类型全部数据字典配置数据
    	return "base/loginLog/logList";
    }
	
	/**
	 * 加载数据字典类型 分页 数据
	 * @param loginLog
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getInfoByPage",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getInfoByPage(
			@RequestParam(value = "page" , required = false) Integer page,
			@RequestParam(value = "rows" , required = false) Integer rows,
			@ModelAttribute("loginLog") LoginLog loginLog){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		// 分页查询
		Page<LoginLog> pageList = new Page<LoginLog>();
		// 分页查询数据
		if(loginLog!=null){
			// 查询条件 staffNo
			if(CommonUtil.isNotNull(loginLog.getStaffNo())){
				params.put("staffNo", loginLog.getStaffNo());
			}
			// 查询条件 ipAddress
			if(CommonUtil.isNotNull(loginLog.getIpAddress())){
				params.put("ipAddress", loginLog.getIpAddress());
			}
			// 查询条件 startDate yyyy-mm-dd HH:mm:ss
			if(CommonUtil.isNotNull(loginLog.getStartDate())){
				params.put("startDate", loginLog.getStartDate().replace("-", ""));
			}
			// 查询条件 endDate yyyy-mm-dd HH:mm:ss
			if(CommonUtil.isNotNull(loginLog.getEndDate())){
				params.put("endDate", loginLog.getEndDate().replace("-", ""));
			}
			// 查询条件 loginDesc 登录描述
			if(CommonUtil.isNotNull(loginLog.getLoginDesc())){
				params.put("loginDesc", loginLog.getLoginDesc());
			}
			// 查询条件 staffName identNo进行模糊查询 按名字进行模糊查询
			if(CommonUtil.isNotNull(loginLog.getStaffName()) || 
					CommonUtil.isNotNull(loginLog.getIdentNo())){
				if(CommonUtil.isNotNull(loginLog.getStaffName())){
					params.put("name", loginLog.getStaffName());
				}
				if(CommonUtil.isNotNull(loginLog.getIdentNo())){
					params.put("identNo", loginLog.getIdentNo());
				}
				List<String> staffNoList = staffAccountService.getSelectStaffNos(params);
				if(staffNoList==null || staffNoList.size()==0){
					// 分页总记录 姓名和身份证查询不到 分页不进行查询
					map.put("total", 0);
					map.put("rows", new ArrayList<Map<String,String>>());
					return map;
				}else{
					// 查询有记录
					params.put("staffNos", staffNoList);
				}
			}
		}
		
		pageList= loginLogService.getLoginLogListByPage(params, page, rows);
		List<LoginLog> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		Map<String,String> maps = null;
		if(detailList!=null && detailList.size()>0){
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("staffNos", getPagedStaffNos(detailList));
			Map<String, Staff> staffMap = staffAccountService.getSelectStaffsMap(paramsMap);
			
			for(LoginLog info: detailList){
				maps = new HashMap<String,String>();
				// recNo
				maps.put("recNo", info.getRecNo());
				// 员工编号
				maps.put("staffNo", info.getStaffNo());
				// IP地址
				maps.put("ipAddress", info.getIpAddress());
				// 登录时间
				maps.put("loginTime", formatDate(info.getLoginTime()));
				// 登录描述 
				maps.put("loginDesc", info.getLoginDesc());
				
				if(staffMap.get(info.getStaffNo())!=null){
					// 员工名
					maps.put("staffName", staffMap.get(info.getStaffNo()).getName());
					// 身份证号
					maps.put("identNo", staffMap.get(info.getStaffNo()).getIdentNo());
				}
				
				rowList.add(maps);
			}
		}
		// 绑定数据集
		map.put("rows", rowList);
		return map;
	}
	
	/**
	 * 格式化日期字符串 20140625 13:34:56 --> 2014-06-25 13:34:56
	 * @param dateStr
	 * @return
	 */
	private String formatDate(String dateStr){
		if(dateStr==null || dateStr.length()<17){
			return "";
		}
		Date ft = null;
		try {
			ft = new Timestamp(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse(dateStr).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(ft.getTime());
	}
	
	/**
	 * 获取当前页的StaffNo列表
	 * @param list
	 * @return
	 */
	private List<String> getPagedStaffNos(List<LoginLog> list){
		List<String> resultList = new ArrayList<String>();
		for(LoginLog info: list){
			resultList.add(info.getStaffNo());
		}
		return resultList;
	}
}
