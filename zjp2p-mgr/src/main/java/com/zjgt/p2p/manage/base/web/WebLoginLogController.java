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

import com.zjgt.p2p.base.domain.WebLoginLog;
import com.zjgt.p2p.base.service.IWebLoginLogService;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.service.ICodeInfoService;

/**
 * 日志管理-前台用户登录日志 分发控制器
 * @author lutao
 *
 */
@Controller
@RequestMapping(value = "/base/loginLog/webLog")
public class WebLoginLogController {
    Logger logger = LoggerFactory.getLogger(WebLoginLogController.class);
    
	/**
	 * 码表服务
	 */
	@Autowired
	private ICodeInfoService codeInfoService;
	
	/**
	 * 邮箱域名配置 服务接口
	 */
	@Autowired
	private IWebLoginLogService webLoginLogService;
	
	/**
	 * UserAccount 服务接口
	 */
	/*@Autowired
	  private IUserAccountService userAccountService;*/
	
	/**
	 * 账户状态
	 */
	private Map<String, String> enableMap = new HashMap<String, String>();
	
	/**
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	List<CodeInfo> codeList =  codeInfoService.
    			getCodeInfoListByTypeCode(BaseConstant.DICT_CODE_TYPE_ENABLED);
    	enableMap = convertCodeInfoListToMap(codeList);
    	// 获取文件类型全部数据字典配置数据
    	return "base/loginLog/webLogList";
    }
	
	/**
	 * 加载数据字典类型 分页 数据
	 * @param webLoginLog
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getInfoByPage",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getInfoByPage(
			@RequestParam(value = "page" , required = false) Integer page,
			@RequestParam(value = "rows" , required = false) Integer rows,
			@ModelAttribute("webLoginLog") WebLoginLog webLoginLog){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		// 分页查询
		Page<WebLoginLog> pageList = new Page<WebLoginLog>();
		// 分页查询数据
		if(webLoginLog!=null){
			// 查询条件 ipAddress
			if(CommonUtil.isNotNull(webLoginLog.getIpAddress())){
				params.put("ipAddress", webLoginLog.getIpAddress());
			}
			// 查询条件 startDate yyyy-mm-dd HH:mm:ss
			if(CommonUtil.isNotNull(webLoginLog.getStartDate())){
				params.put("startDate", webLoginLog.getStartDate().replace("-", ""));
			}
			// 查询条件 endDate yyyy-mm-dd HH:mm:ss
			if(CommonUtil.isNotNull(webLoginLog.getEndDate())){
				params.put("endDate", webLoginLog.getEndDate().replace("-", ""));
			}
			// 查询条件 loginDesc 登录描述
			if(CommonUtil.isNotNull(webLoginLog.getLoginDesc())){
				params.put("loginDesc", webLoginLog.getLoginDesc());
			}
			// 查询条件 staffName identNo进行模糊查询 按名字进行模糊查询
			if(CommonUtil.isNotNull(webLoginLog.getLoginName()) || 
					CommonUtil.isNotNull(webLoginLog.getEmail()) || 
					CommonUtil.isNotNull(webLoginLog.getMobile())){
				// 查询条件 登录用户名
				if(CommonUtil.isNotNull(webLoginLog.getLoginName())){
					params.put("userName", webLoginLog.getLoginName());
				}
				// 查询条件 手机号
				if(CommonUtil.isNotNull(webLoginLog.getMobile())){
					params.put("mobile", webLoginLog.getMobile());
				}
				// 查询条件 邮箱
				if(CommonUtil.isNotNull(webLoginLog.getEmail())){
					params.put("email", webLoginLog.getEmail());
				}
				/*List<String> userNoList = userAccountService.getUserAccountFuzzy(params);
				if(userNoList==null || userNoList.size()==0){
					// 分页总记录 姓名和身份证查询不到 分页不进行查询
					map.put("total", 0);
					map.put("rows", new ArrayList<Map<String,String>>());
					return map;
				}else{
					// 查询有记录
					params.put("userNos",userNoList);
				}*/
			}
		}
		
		pageList= webLoginLogService.getLoginLogListByPage(params, page, rows);
		List<WebLoginLog> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		Map<String,String> maps = null;
		if(detailList!=null && detailList.size()>0){
			/*Map<String, UserAccount> staffMap = 
					userAccountService.getUserAccountMapsByUserNos(getPagedUserNos(detailList));
			UserAccount account = null;*/
			for(WebLoginLog info: detailList){
				maps = new HashMap<String,String>();
				// recNo
				maps.put("recNo", info.getRecNo());
				// IP地址
				maps.put("ipAddress", info.getIpAddress());
				// 登录时间
				maps.put("loginTime", formatDate(info.getLoginTime()));
				// 登录描述 
				maps.put("loginDesc", info.getLoginDesc());
				
				/*account = staffMap.get(info.getUserNo());
				if(staffMap!=null && account!=null){
					// 员工名
					maps.put("email", account.getEmail());
					// 身份证号
					maps.put("mobile", account.getMobile());
					// 登录用户名
					maps.put("userName", account.getUserName());
					if(enableMap!=null && enableMap.get(account.getEnabled())!=null){
						// 账户状态
						maps.put("statusDesc", enableMap.get(account.getEnabled()));
					}
				}*/
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
	private List<String> getPagedUserNos(List<WebLoginLog> list){
		List<String> resultList = new ArrayList<String>();
		for(WebLoginLog info: list){
			resultList.add(info.getUserNo());
		}
		return resultList;
	}
	
	/**
	 * List 转 Map 
	 * Key：CONFIG_CODE value：CONFIG_NAME
	 * @param codeinfos
	 * @return
	 */
	private Map<String,String> convertCodeInfoListToMap(List<CodeInfo> codeinfos){
		Map<String,String> resultMap = new HashMap<String,String>();
		if(codeinfos!=null&&codeinfos.size()>0){
			for(CodeInfo code:codeinfos){
				resultMap.put(code.getConfigCode(), code.getConfigName());
			}
		}
		return resultMap;
	}
}
