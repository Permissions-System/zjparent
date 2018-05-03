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
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;

import com.zjgt.p2p.base.domain.CpErrorInfoComp;
import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IErrorCompInfoService;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.manage.common.BeanUtil;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.ErrStatictsInfo;
import com.zjgt.p2p.base.service.ICodeInfoService;

/**
 * 错误码信息维护
 * 
 * @author chenl
 * 
 */
@Controller
@RequestMapping(value = "/base/errorinfo")
public class ErrorCompInfoController {

	Logger logger = LoggerFactory.getLogger(ErrorCompInfoController.class);

	/**
	 * 错误码信息服务
	 */
	@Autowired
	private IErrorCompInfoService errorCompInfoService;
	
	/**
	 * 数据字典服务
	 */
	@Autowired
	private ICodeInfoService codeInfoService;

	/**
	 * 操作日志
	 */
	@Autowired
	private IMaintenanceLogService maintenanceLogService;
	
	/**
	 * 错误日志服务
	 */
	@Autowired
	private IErrorLogsService errorLogsService;
	
	/**
	 * 数据字典 Map集合
	 * 公用的产品类型 = PRODUCT_CODE
	 */
	private Map<String, String> productCodeMap = new HashMap<String, String>();
	
	/**
	 * 消息模板
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/errorinfo")
	public String init(Model model) {
		/*** 获取产品类别 ***/
		/*Map<String, List<CodeInfo>> resultMap = codeInfoService
				.getCodeInfoListByTypeCodes(
						BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE,
						BaseConstant.DICT_CODE_TYPE_MSG_CHANNEL);*/
		String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_DELETE_FLAG,BaseConstant.DICT_CODE_TYPE_READ_FLAG};
    	Map<String, List<CodeInfo>> resultMap 
		= codeInfoService.getCodeInfoListByTypeCodes(
				typeCodes);
		List<CodeInfo> codeList = new ArrayList<CodeInfo>();
		if (resultMap != null) {
			codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);
			model.addAttribute("productCode", codeList);
			
    		// 初始化产品代码 MAP
    		productCodeMap = convertCodeInfoListToMap(codeList);
		}
		return "base/errorinfo/errorinfo";
	}

	/**
	 * 新增错误码对照信息
	 * 
	 * @param CpErrorInfoComp
	 * @return Map
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertCodeInfo(
			@ModelAttribute("errorInfo") CpErrorInfoComp codeInfo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			errorCompInfoService.addErrorCompInfo(codeInfo);
			insertLog(null, codeInfo, BaseConstant.LOG_ERROR_ADD_CODE, 
					BaseConstant.LOG_ERROR_ADD_NAME);
			retMap.put("result", "success");
			return retMap;
		} catch (BusinessException err) {
			retMap.put("result", "failure");
			retMap.put("message", err.getMessage());
			logger.error("新增错误码对照信息失败，错误描述：" + err.getMessage());
			return retMap;
		}
	}

	/**
	 * 根据错误码修改错误对照信息
	 * 
	 * @param CpErrorInfoComp
	 * @return Map
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateCodeInfo(
			@ModelAttribute("errorInfo") CpErrorInfoComp codeInfo) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			CpErrorInfoComp oldValue=
					errorCompInfoService.qryErrorCompInfoByCode(codeInfo.getErrorCode());
			errorCompInfoService.updateErrorCompInfo(codeInfo);
			insertLog(oldValue, codeInfo, BaseConstant.LOG_ERROR_UPDATE_CODE, 
					BaseConstant.LOG_ERROR_UPDATE_NAME);
			retMap.put("result", "success");
			return retMap;
		} catch (BusinessException err) {
			retMap.put("result", "failure");
			retMap.put("message", err.getMessage());
			logger.error("修改错误码对照信息失败，错误描述：" + err.getMessage());
			return retMap;
		}
	}

	/**
	 * 根据错误码删除错误对照信息
	 * 
	 * @param
	 * @return Map
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteCodeInfo(
			@ModelAttribute("errorCode") String errorCode) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			CpErrorInfoComp oldValue=errorCompInfoService.qryErrorCompInfoByCode(errorCode);
			errorCompInfoService.deleteErrorCompInfo(errorCode);
			insertLog(oldValue, null, BaseConstant.LOG_ERROR_DELETE_CODE, 
					BaseConstant.LOG_ERROR_DELETE_NAME);
			retMap.put("result", "success");
			return retMap;
		} catch (BusinessException err) {
			retMap.put("result", "failure");
			retMap.put("message", err.getMessage());
			logger.error("删除错误码对照信息失败，错误描述：" + err.getMessage());
			return retMap;
		}
	}

	/**
	 * 分页查询错误码信息
	 * 
	 * @param Map
	 * @return Map<String,Object>
	 */
	@RequestMapping(value = "/qryByPage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getErrorCompInfo(Model model,
			@RequestParam Map<String, Object> params) {
		int pageNo = 1;
		int pageSize = 10;
		if (params.get("page") != null) {
			pageNo = Integer.parseInt((String) params.get("page"));
		}
		if (params.get("rows") != null) {
			pageSize = Integer.parseInt((String) params.get("rows"));
		}
		Map<String,Object> retMap = new HashMap<String,Object>();
		try {
			Page<CpErrorInfoComp> retPage = errorCompInfoService
					.qryErrorCompInfoByPage(params, pageNo, pageSize);
			List<Map<?, ?>> retList = new ArrayList<Map<?, ?>>();
			if (retPage != null) {
				for (CpErrorInfoComp errInfo : retPage.getResult()) {
					if (errInfo != null) {
						try {
							retList.add(BeanUtil.Bean2Map(errInfo));
						} catch (Exception e) {
							retMap.put("message", e.getMessage());
						}
					}
				}
			}
			retMap.put("rows", retList);
			retMap.put("total", retPage.getTotalCount());
			retMap.put("result", "success");
			return retMap;
		} catch (BusinessException err) {
			retMap.put("result", "failure");
			retMap.put("message", err.getMessage());
			logger.error("分页查询错误码对照信息失败，错误描述：" + err.getMessage());
			return retMap;
		}
	}
	
	/**
	 * 分页查询 错误码列表
	 * @param page
	 * @param rows
	 * @param errorLogMonitor
	 * @return
	 */
	@RequestMapping(value="/getErrorCodeInfoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getErrorCodeInfoList(
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@ModelAttribute("cpErrorInfoComp") CpErrorInfoComp cpErrorInfoComp){
		// page rows easyUi默认传值用于分页  errorLogMonitor用于封装查询条件
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		if(cpErrorInfoComp!=null){
			// 产品代码 查询列表使用
			if(CommonUtil.isNotNull(cpErrorInfoComp.getPrdType())){
				params.put("productCode", cpErrorInfoComp.getPrdType());
			}
			// 错误码 模糊查询
			if(CommonUtil.isNotNull(cpErrorInfoComp.getErrorCode())){
				params.put("errorCode", cpErrorInfoComp.getErrorCode());
			}
			// 用户提示
			if(CommonUtil.isNotNull(cpErrorInfoComp.getErrorUserDesc())){
				params.put("errorUserDesc", cpErrorInfoComp.getErrorUserDesc());
			}
			// 错误系统描述
			if(CommonUtil.isNotNull(cpErrorInfoComp.getErrorSysDesc())){
				params.put("errorSysDesc", cpErrorInfoComp.getErrorSysDesc());
			}
		}
		
		Page<CpErrorInfoComp> pageList = 
				errorCompInfoService.getErrorCodeInfoListByPage(params, page, rows);
		List<CpErrorInfoComp> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		Map<String,String> maps = null;
		for(CpErrorInfoComp info:detailList){
			maps = new HashMap<String,String>();
			maps.put("id", info.getErrorCode());
			// 错误码
			maps.put("errorCode", info.getErrorCode());
			// 错误格式规定其长度大于2 直接截取前两位 错误码所属产品代码
			maps.put("productCode", info.getErrorCode().substring(0, 2));
			maps.put("productName", productCodeMap.get(info.getErrorCode().substring(0, 2)));
			maps.put("errorSysDesc", info.getErrorSysDesc());
			maps.put("errorUserDesc", info.getErrorUserDesc());
			rowList.add(maps);
		}
		
		// 绑定数据集
		map.put("rows", rowList);
		return map;
	}
	
	/**
	 * 错误码数据存在性校验
	 * @param errorCode
	 * @return
	 */
	@RequestMapping(value="/getCountCodeInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getCountCodeInfo(
			@RequestParam(value="errorCode",required=false) String errorCode){
		Map<String,Object> map = new HashMap<String,Object>();
		CpErrorInfoComp comp = errorCompInfoService.qryErrorCompInfoByCode(errorCode);
		//数据已存在
		if(comp!=null){
			map.put("message", "Y");
		}else{
			map.put("message", "N");
		}
		return map;
	}
	
	/**
	 * 获取错误码 查询区间内的数据
	 * @param errStatictsInfo 错误码 errorCode 查询开始日期 可空  查询结束日期
	 * @return
	 */
	@RequestMapping(value="/getChartInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getChartInfo(
			@ModelAttribute("errStatictsInfo") ErrStatictsInfo errStatictsInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<ErrStatictsInfo> queryList = errorLogsService.getStatictsInfo(errStatictsInfo);
		
		/**
		 * 只在存在数据的时候处理
		 */
		if(queryList!=null && queryList.size()>0){
			// 有数据
			map.put("message", "show");
			// x轴
			String[] categories = new String[queryList.size()];
			// y轴
			Integer[] series = new Integer[queryList.size()];
			
			for(int i=0;i<queryList.size();i++){
				//yyyy-MM-dd
				categories[i] = queryList.get(i).getStatictDate();
				series[i] = queryList.get(i).getErrorCount().intValue();
			}
			// 返回
			map.put("categories", categories);
			map.put("errorCode", errStatictsInfo.getErrorCode());
			map.put("series", series);
		}else{
			// 没有数据
			map.put("message", "hiden");
		}
		
		return map;
	}
	
	/**
	 * 插入维护日志记录
	 * @param oldValue
	 * @param newValue
	 * @param operCode
	 * @param operName
	 */
	private void insertLog(CpErrorInfoComp oldValue, CpErrorInfoComp newValue, 
			String operCode, String operName) {
		StringBuffer oldInfo = new StringBuffer();
		StringBuffer newInfo = new StringBuffer();
		if(oldValue!=null){
			oldInfo.append("操作前信息：");
			oldInfo.append("errorCode："+oldValue.getErrorCode());
			oldInfo.append("|PrdTypeName："+oldValue.getPrdTypeName());
			oldInfo.append("|UserDesc："+oldValue.getErrorUserDesc());
			oldInfo.append("|SysDesc："+oldValue.getErrorSysDesc());
		}
		if(newValue!=null){
			newInfo.append("操作后信息：");
			newInfo.append("errorCode："+newValue.getErrorCode());
			newInfo.append("|PrdTypeName："+newValue.getPrdTypeName());
			newInfo.append("|UserDesc："+newValue.getErrorUserDesc());
			newInfo.append("|SysDesc："+newValue.getErrorSysDesc());
		}
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setOldInfo(oldInfo.toString());
		maintenanceLog.setOperCode(operCode);
		maintenanceLog.setOperDesc(operName);
		maintenanceLog.setOperName(operName);
		maintenanceLog.setIpAddress("localhost");
		
		maintenanceLogService.insert(maintenanceLog);
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