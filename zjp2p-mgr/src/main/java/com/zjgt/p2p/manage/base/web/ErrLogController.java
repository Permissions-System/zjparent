/**
 * 软件著作权：百富金融技术部
 * 
 * 系统名称：互联网金融项目
 * 
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
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

import com.zjgt.p2p.base.domain.ErrLog;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.service.ICodeInfoService;

/**
 * 错误日志 分发控制器
 *
 */
@Controller
@RequestMapping(value = "/base/errorLog/log")
public class ErrLogController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IErrorLogsService errLogService;

	@Autowired
	private ICodeInfoService codeInfoService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	List<CodeInfo> codeList=codeInfoService.getCodeInfoListByTypeCode(
				BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);
		model.addAttribute("productCode",codeList);
    	return "base/errorLog/logList";
    }
	
	/**
	 * 分页 数据
	 * @param loginLog
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getLogByPage",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getInfoByPage(
			@RequestParam(value = "page" , required = false) Integer page,
			@RequestParam(value = "rows" , required = false) Integer rows,
			String startDate,String endDate,String productCode,
			@ModelAttribute("errLog") ErrLog errLog){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		// 分页查询
		Page<ErrLog> pageList = new Page<ErrLog>();
		// 分页查询数据
		if(errLog!=null){
			if(CommonUtil.isNotNull(errLog.getErrorCode())){
				params.put("errorCode", errLog.getErrorCode());
			}
			if(CommonUtil.isNotNull(errLog.getErrorDesc())){
				params.put("errorDesc", errLog.getErrorDesc());
			}
			if(CommonUtil.isNotNull(errLog.getSessionId())){
				params.put("sessionId", errLog.getSessionId());
			}
			if(CommonUtil.isNotNull(errLog.getExeClassName())){
				params.put("exeClassName", errLog.getExeClassName());
			}
		}
		if(CommonUtil.isNotNull(productCode)){
			params.put("productCode",productCode);
		}
		if(CommonUtil.isNotNull(startDate)){
			params.put("startDate", startDate);
		}
		if(CommonUtil.isNotNull(endDate)){
			params.put("endDate", endDate);
		}
		if(params.get("productCode")==null && params.get("errorCode")==null){
			map.put("status","failed");
			return map;
		}
		if(params.get("productCode")==null && params.get("errorCode")!=null){
			productCode=errLog.getErrorCode().substring(0, 2);
			params.put("productCode",productCode);
		}
		pageList= errLogService.getErrLog(params, page, rows);
		List<ErrLog> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		Map<String,String> maps = null;
		if(detailList!=null && detailList.size()>0){
			for(ErrLog info: detailList){
				maps = new HashMap<String,String>();
				maps.put("id", info.getId());
				maps.put("errorCode", info.getErrorCode());
				maps.put("logTime", info.getLogTimestamp());
				maps.put("sessionId", info.getSessionId());
				maps.put("errorDesc", info.getErrorDesc());
				maps.put("exeClassName", info.getExeClassName());
				rowList.add(maps);
			}
		}
		map.put("rows", rowList);
		return map;
	}
}
