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
import org.springfk.pancloud.utils.DateUtils;

import com.zjgt.p2p.base.domain.CpErrorInfoComp;
import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IErrorCompInfoService;
import com.zjgt.p2p.base.service.IErrorLogsService;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.ErrorLogMonitor;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IErrorLogMonitorService;

/**
 * 错误信息监控配置分发控制器
 * @author lutao
 */
@Controller
@RequestMapping(value = "/base/errorlogMonitor")
public class ErrorLogMonitorController {
	Logger logger = LoggerFactory.getLogger(ErrorLogMonitorController.class);
	 
	/**
	 * 数据字典服务
	 */
	@Autowired
	private ICodeInfoService codeInfoService;
	
	/**
	 * 错误信息监控配置服务
	 */
	@Autowired
	private IErrorLogMonitorService errorLogMonitorService;
	
	/**
	 * 错误码管理服务
	 */
	@Autowired
	private IErrorCompInfoService errorCompInfoService;
	
    /**
     * 后台维护日志记录 服务接口
     */
    @Autowired
    private IMaintenanceLogService maintenanceLogService;
    
    /**
     * 错误日志服务 模拟插入数据使用
     */
	@Autowired
	private IErrorLogsService errLogService;
    
	/**
	 * 数据字典 Map集合
	 * 公用的产品类型 = PRODUCT_CODE
	 */
	private Map<String, String> productCodeMap = new HashMap<String, String>();
	
	/**
	 * 数据字典 Map集合
	 * 错误码监控自适应类型 = ERRORLOG_MONITOR_ADJUSTMENT
	 */
	private Map<String, String> adjustmentMap = new HashMap<String, String>();
	
	/**
	 * 消息模板
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	// 公用的产品类型 = PRODUCT_CODE,
    	String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE,BaseConstant.ERRORLOG_MONITOR_ADJUSTMENT};
    	Map<String, List<CodeInfo>> resultMap 
    		= codeInfoService.getCodeInfoListByTypeCodes(typeCodes);
    	List<CodeInfo> codeList = new ArrayList<CodeInfo>();
    	if(resultMap!=null){
    		// 公用的产品类型
    		codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);
    		model.addAttribute("productCode",codeList);
    		// 初始化产品代码 MAP
    		productCodeMap = convertCodeInfoListToMap(codeList);
    		
    		// 错误码监控自适应类型
    		codeList = resultMap.get(BaseConstant.ERRORLOG_MONITOR_ADJUSTMENT);
    		model.addAttribute("adjustmentType",codeList);
    		adjustmentMap = convertCodeInfoListToMap(codeList);
    		
    	}
    	
        return "base/errorlogMonitor/errorlogMonitor";
    }
	
	/**
	 * 处理添加新ErrorLogMonitor的POST请求 处理配置数据的插入
	 * @param codeTable
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertErrorLogMonitorInfo(
			@ModelAttribute("errorLogMonitor") ErrorLogMonitor errorLogMonitor) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(errorLogMonitor!=null){
			int count = 0;
			count = errorLogMonitorService.getCountLogMonitorInfo(errorLogMonitor.getErrorCode());
			if(count>0){
				// 存在性校验 若存在 返回 给页面 提示
				map.put("message", "exist");
			}else{
				// 插入 新增日期时间戳
				errorLogMonitor.setLogTimestamp(DateUtils.getCurrentFormatDateLong());
				errorLogMonitorService.insert(errorLogMonitor);
				map.put("message", "success");
				// 用户行为日志记录
				errorLogMonitorOperLog(BaseConstant.OPER_CODE_LOGMONTIOR_INSERT,
						BaseConstant.OPER_NAME_LOGMONTIOR_INSERT,null,errorLogMonitor);
			}
		}else{
			// 异常
			map.put("result", "exception");
		}
		return map;
	}
    
	/**
	 * 处理编辑ErrorLogMonitor的POST请求
	 * @param errorLogMonitor
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateErrorLogMonitorInfo(
			@ModelAttribute("errorLogMonitor") ErrorLogMonitor errorLogMonitor) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(errorLogMonitor!=null){
			ErrorLogMonitor oldVal = 
					errorLogMonitorService.getErrorLogMonitorInfo(errorLogMonitor.getErrorCode());
			errorLogMonitorService.update(errorLogMonitor);
			map.put("message", "success");
			if(oldVal!=null){
				// 用户行为日志记录
				errorLogMonitorOperLog(BaseConstant.OPER_CODE_LOGMONTIOR_UPDATE,
						BaseConstant.OPER_NAME_LOGMONTIOR_UPDATE,oldVal,errorLogMonitor);
			}
		}else{
			map.put("message", "exception");
		}
		return map;
	}
	
	
	/**
	 * 处理删除一条系统公告的Post请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteErrorLogMonitorInfo(
			@RequestParam("errorCode") String errorCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(errorCode !=null){
			ErrorLogMonitor oldVal = 
					errorLogMonitorService.getErrorLogMonitorInfo(errorCode);
			errorLogMonitorService.delete(errorCode);
			map.put("message", "success");
			if(oldVal!=null){
				// 用户行为日志记录
				errorLogMonitorOperLog(BaseConstant.OPER_CODE_LOGMONTIOR_DELETE,
						BaseConstant.OPER_NAME_LOGMONTIOR_DELETE,oldVal,null);
			}
		}else{
			map.put("message", "failure");
		}
		return map;
	}
	
	/**
	 * 分页获取 组合条件 查询系统公告 列表
	 * @param page
	 * @param rows
	 * @param msgBulletin
	 * @return
	 */
	@RequestMapping(value="/getLogMonitorInfoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getLogMonitorInfoList(
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@ModelAttribute("errorLogMonitor") ErrorLogMonitor errorLogMonitor){
		// page rows easyUi默认传值用于分页  errorLogMonitor用于封装查询条件
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		
		// 分页查询参数
		if(errorLogMonitor!=null){
			// 产品代码 查询列表使用
			if(CommonUtil.isNotNull(errorLogMonitor.getProductCode())){
				params.put("productCode", errorLogMonitor.getProductCode());
			}
			// ERROR_CODE 错误码 模糊查询
			if(CommonUtil.isNotNull(errorLogMonitor.getErrorCode())){
				params.put("errorCode", errorLogMonitor.getErrorCode());
			}
			// AUTO_ADJUSTMENT 是否自适应
			if(CommonUtil.isNotNull(errorLogMonitor.getAutoAdjustment())){
				params.put("autoAdjustment", errorLogMonitor.getAutoAdjustment());
			}
			
		}
		
		// 分页查询
		Page<ErrorLogMonitor> pageList = 
				errorLogMonitorService.getLogMonitorInfoListByPage(params, page, rows);
		List<ErrorLogMonitor> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		Map<String,String> maps = null;
		for(ErrorLogMonitor info:detailList){
			maps = new HashMap<String,String>();
			// 查询配置参数相关字段的值
			// 错误码
			maps.put("errorCode", info.getErrorCode());
			// 错误格式规定其长度大于2 直接截取前两位 错误码所属产品代码
			maps.put("productCode", info.getErrorCode().substring(0, 2));
			maps.put("productName", productCodeMap.get(info.getErrorCode().substring(0, 2)));
			
			// 周期阀值
			maps.put("cycleThreshold", String.valueOf(info.getCycleThreshold()));
			// 每日阀值
			maps.put("dayThreshold", String.valueOf(info.getDayThreshold()));
			// 是否自适应
			maps.put("autoAdjustment", info.getAutoAdjustment());
			// 是否自适应 说明
			maps.put("autoAdjustmentDesc", 
					info.getAutoAdjustment()==null? "":
						adjustmentMap.get(info.getAutoAdjustment())==null? "":
							adjustmentMap.get(info.getAutoAdjustment()));
			//阀值比率
			maps.put("thresholdRate", String.valueOf(info.getThresholdRate()));
			
			rowList.add(maps);
		}
		// 绑定数据集
		map.put("rows", rowList);
		return map;
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
	 * 
	 * @param errorCode
	 * @return
	 */
	@RequestMapping(value="/getCountCodeInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getCountCodeInfo(
			@RequestParam(value="errorCode",required=false) String errorCode){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = errorLogMonitorService.getCountLogMonitorInfo(errorCode);
		//数据已存在
		if(count>0){
			map.put("message", "Y");
		}else{
			map.put("message", "N");
		}
		return map;
	}
	
	/**
	 * 模拟插入错误日志（仅测试人员造数据使用）
	 * @param errorCode
	 * @param timedate
	 * @return
	 */
	@RequestMapping(value="/moniInsertCode",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> moniInsertCode(
			@RequestParam(value="errorCode",required=true) String errorCode){
		Map<String,Object> map = new HashMap<String,Object>();
		
		BusinessException e = new BusinessException("错误日志监控 模拟数据插入测试");
		errLogService.writeErrorLog(
				IErrorLogMonitorService.class, errorCode, null, e);
		return map;
	}
	
	
    /**
     * 菜单管理操作日志
     * 
     * @param operCode
     * @param operName
     * @param oldMonitor
     * @param newMonitor
     */
    private void errorLogMonitorOperLog(String operCode, String operName, 
    		ErrorLogMonitor oldMonitor, ErrorLogMonitor newMonitor) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        StringBuffer oldInfo = new StringBuffer();
        StringBuffer newInfo = new StringBuffer();
        if (oldMonitor != null) {
        	// 错误码
            oldInfo.append("errorCode:" + oldMonitor.getErrorCode());
            // 周期阀值
            oldInfo.append("|cycleThreshold:" + oldMonitor.getCycleThreshold());
            // 每日阀值
            oldInfo.append("|dayThreshold:" + oldMonitor.getDayThreshold());
            // 是否自适应
            oldInfo.append("|autoAdjustment:" + oldMonitor.getAutoAdjustment());
            //阀值比率
            oldInfo.append("|thresholdRate:" + oldMonitor.getThresholdRate());
        }
        if (newMonitor != null) {
        	// 错误码
        	newInfo.append("errorCode:" + newMonitor.getErrorCode());
            // 周期阀值
        	newInfo.append("|cycleThreshold:" + newMonitor.getCycleThreshold());
            // 每日阀值
        	newInfo.append("|dayThreshold:" + newMonitor.getDayThreshold());
            // 是否自适应
        	newInfo.append("|autoAdjustment:" + newMonitor.getAutoAdjustment());
        	//阀值比率
            oldInfo.append("|thresholdRate:" + newMonitor.getThresholdRate());
        }
        maintenanceLog.setNewInfo(newInfo.toString());
        maintenanceLog.setOldInfo(oldInfo.toString());
        maintenanceLog.setOperCode(operCode);
        maintenanceLog.setOperName(operName);
        maintenanceLog.setOperDesc(operName);
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
