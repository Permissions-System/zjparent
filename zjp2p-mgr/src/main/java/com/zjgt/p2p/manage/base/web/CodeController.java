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
import org.springfk.pancloud.utils.StringUtils;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.service.ICodeInfoService;


/**
 * 数据字典分发控制器
 * @author lutao
 *
 */
@Controller
@RequestMapping(value = "/base/code")
public class CodeController {

    Logger logger = LoggerFactory.getLogger(CodeController.class);
    
    /**
     * 数据字典服务接口
     */
	@Autowired
	private ICodeInfoService codeInfoService;
	
    /**
     * 后台维护日志记录服务接口
     */
    @Autowired
    private IMaintenanceLogService maintenanceLogService;
    
	/**
	 * 数据字典 Map集合
	 * 删除标志 否是可删除 = DELETE_FLAG
	 */
	private Map<String, String> deleteFlagMap = new HashMap<String, String>();
	
	/**
	 * 数据字典 Map集合
	 * 编辑标志 否是可编辑 = READ_FLAG
	 */
	private Map<String, String> readFlagMap = new HashMap<String, String>();
    
    /**
     * 数据字典
     * @param model
     * @return
     */
    @RequestMapping(value="/code")
    public String roles(Model model) {
    	String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_DELETE_FLAG,BaseConstant.DICT_CODE_TYPE_READ_FLAG};
    	Map<String, List<CodeInfo>> resultMap 
		= codeInfoService.getCodeInfoListByTypeCodes(
				typeCodes);
    	List<CodeInfo> codeList = new ArrayList<CodeInfo>();
    	if(resultMap!=null){
    		//  否是可删除
    		codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_DELETE_FLAG);
    		model.addAttribute("deleteFlag",codeList);
    		// 初始化产品代码 MAP
    		deleteFlagMap = convertCodeInfoListToMap(codeList);
    		
    		// 否是可编辑
    		codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_READ_FLAG);
    		model.addAttribute("readFlag",codeList);
    		// 初始化产品代码 MAP
    		readFlagMap = convertCodeInfoListToMap(codeList);
    	}
        return "base/code/code";
    }
    
	
	/**
	 * 加载数据字典类型 分页 数据
	 * @param codeInfo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/typeInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> findTypeCodeList(
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@ModelAttribute("codeInfo") CodeInfo codeInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		// 分页查询数据
		if(codeInfo!=null){
			// 查询条件 字典分类编码
			if(!StringUtils.isEmpty(codeInfo.getTypeCode())){
				params.put("typeCode", codeInfo.getTypeCode());
			}
			// 查询条件 字典分类名称
			if(!StringUtils.isEmpty(codeInfo.getTypeName())){
				params.put("typeName", codeInfo.getTypeName());
			}
		}
		
		// 分页查询
		Page<CodeInfo> pageList = codeInfoService.getTypeCodeListByPage(params,page,rows);
		List<CodeInfo> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		Map<String,String> maps = null;
		for(CodeInfo code: detailList){
			maps = new HashMap<String,String>();
			maps.put("typeCode", code.getTypeCode());
			maps.put("typeName", code.getTypeName());
			rowList.add(maps);
		}
		
		// 绑定数据集
		map.put("rows", rowList);
		return map;
	}
	
	/**
	 * 分页获取 根据数据字典类型获取 类型下配置的明细字典明细列表
	 * @param page
	 * @param rows
	 * @param typeCode
	 * @return
	 */
	@RequestMapping(value="/codeDetailInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> findTypeCodeList(
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@RequestParam(value="typeCode",required=false) String typeCode){
		// page rows easyUi默认传值用于分页 typeCode用于记录已选择的数据字典类型
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
		// 如空值 不再访问数据库，直接返回
		if(typeCode!=null){
			params.put("typeCode", typeCode);
			// 分页查询
			Page<CodeInfo> pageList =  codeInfoService.getCodeDetailListByPage(params, page, rows);
			List<CodeInfo> detailList = pageList.getResult();
			map.put("total", pageList.getTotalCount());
			
			Map<String,String> maps = null;
			for(CodeInfo code: detailList){
				maps = new HashMap<String,String>();
				maps.put("typeCode", code.getTypeCode());
				maps.put("typeName", code.getTypeName());
				maps.put("configCode", code.getConfigCode());
				maps.put("configName", code.getConfigName());
				maps.put("deleteFlag", code.getDeleteFlag());
				maps.put("deleteFlagDesc", deleteFlagMap.get(code.getDeleteFlag()));
				maps.put("readFlag", code.getReadFlag());
				maps.put("readFlagDesc", readFlagMap.get(code.getReadFlag()));
				maps.put("description", code.getDescription());
				maps.put("indexNo", String.valueOf(code.getIndexNo()));
				rowList.add(maps);
			}
		}else{
			map.put("total", 0);
		}
		// 绑定数据集
		map.put("rows", rowList);
		
		return map;
	}
	
	/**
	 * 提交typeCode configCode 校验新增数据的存在性校验
	 * @param typeCode
	 * @param configCode
	 * @return
	 */
	@RequestMapping(value="/checkExistCodeInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> checkExistCodeInfo(
			@RequestParam(value="typeCode",required=false) String typeCode,
			@RequestParam(value="configCode",required=false) String configCode){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = codeInfoService.getCountCodeInfo(typeCode, configCode);
		//数据已存在
		if(count>0){
			map.put("existFlag", "Y");
		}else{
			map.put("existFlag", "N");
		}
		return map;
	}
	
	/**
	 * 新增数据字典类别 对新增的该类型 存在性校验
	 * @param typeCode
	 * @param configCode
	 * @return
	 */
	@RequestMapping(value="/checkExistCodeType",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> checkExistCodeType(
			@RequestParam(value="typeCode",required=false) String typeCode){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = codeInfoService.getCountCodeInfo(typeCode, null);
		//数据已存在
		if(count>0){
			map.put("existFlag", "Y");
			map.put("count", count + 1);
		}else{
			map.put("existFlag", "N");
			map.put("count", 0);
		}
		return map;
	}
	
	/**
	 * 提交typeCode configCode 校验新增数据的存在性校验
	 * @param typeCode
	 * @param configCode
	 * @return
	 */
	@RequestMapping(value="/checkNotDelCodeInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> checkNotDelCodeInfo(
			@RequestParam(value="typeCode",required=false) String typeCode){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = codeInfoService.getCountNotDel(typeCode);
		map.put("count", count);
		// 返回不可删除的记录条数
		return map;
	}
	
	/**
	 * 处理添加新CodeTable的POST请求 处理码表类型的码表数据的插入
	 * @param codeTable
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertCodeInfo(@ModelAttribute("codeInfo") CodeInfo codeInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(codeInfo!=null){
			int count = 0;
			count = codeInfoService.getCountCodeInfo(
					codeInfo.getTypeCode(), codeInfo.getConfigCode());
			if(count>0){
				map.put("result", "exist");
			}else{
				// 插入类型记录主表
				codeInfoService.insert(codeInfo);
				map.put("result", "success");
				// 用户行为日志记录
				saveModuleLog(codeInfo);
			}
		}else{
			map.put("result", "failure");
		}
		return map;
	}
	
	
	/**
     * 新增一条数据字典记录时，新增维护日志记录
     * @param module
     */
    private void saveModuleLog(CodeInfo codeInfo){
    	// 新增数据字典记录 日志描述记录 字典类别，字典编码，字典名称
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_DICT_INSERT);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_DICT_INSERT);
    	// 操作描述 格式 模块名称 | 模块编号
    	@SuppressWarnings("unused")
		String operDesc = "typeCode:"+codeInfo.getTypeCode() + 
    			"|typeName:" + codeInfo.getTypeName()+
    			"|configCode:"+codeInfo.getConfigCode()+
    			"|configName:"+codeInfo.getConfigName();
    	// 可空 不记录
    	//maintenanceLog.setOperDesc(operDesc);
    	// 新纪录字段
    	maintenanceLog.setNewInfo(getCodeInfoLogFromat(codeInfo));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
    }
	
    
    /**
     * 格式化处理 模块对象信息
     * @param module
     * @return
     */
    private String getCodeInfoLogFromat(CodeInfo codeInfo){
    	// 旧值
    	StringBuffer val = new StringBuffer();
      	if(!StringUtils.isEmpty(codeInfo.getTypeCode())){
        	// typeCode./
      		val.append("typeCode:"+codeInfo.getTypeCode()+"|");
    	}
    	if(!StringUtils.isEmpty(codeInfo.getTypeName())){
        	// typeName
    		val.append("typeName:"+codeInfo.getTypeName()+"|");
    	}
    	if(!StringUtils.isEmpty(codeInfo.getConfigCode())){
    		// configCode
    		val.append("configCode:"+codeInfo.getConfigCode()+"|");
    	}
    	if(!StringUtils.isEmpty(codeInfo.getConfigName())){
    		// configName
    		val.append("configName:"+codeInfo.getConfigName()+"|");
    	}
    	if(codeInfo.getIndexNo()!=null){
    		// indexNo
    		val.append("indexNo:"+codeInfo.getIndexNo().toString());
    	}
    	if(!StringUtils.isEmpty(codeInfo.getReadFlag())){
    		//readFlag
    		val.append("readFlag:"+codeInfo.getReadFlag()+"|");
    	}
    	if(!StringUtils.isEmpty(codeInfo.getDeleteFlag())){
    		//deleteFlag
    		val.append("deleteFlag:"+codeInfo.getDeleteFlag()+"|");
    	}
    	if(!StringUtils.isEmpty(codeInfo.getDescription())){
    		// description
    		val.append("description:"+codeInfo.getDescription()+"|");
    	}
    	
    	return val.toString();
    }
    
	/**
	 * 处理编辑CodeTable的POST请求
	 * @param codeTable
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateCodeInfo(@ModelAttribute("codeInfo") CodeInfo codeInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(codeInfo!=null){
			// 更新前查询旧值
			CodeInfo oldVal = codeInfoService.
					getCodeInfo(codeInfo.getTypeCode(), codeInfo.getConfigCode());
			codeInfoService.update(codeInfo);
			// 修改数据字典 用户行为日志记录
			updateCodeInfoLog(codeInfo,oldVal);
			map.put("result", "success");
		}else{
			map.put("result", "failure");
		}
		return map;
	}
	
	/**
	 * 更新数据字典信息 记录用户操作行为日志
	 * @param newCode
	 * @param oldCode
	 */
	private void updateCodeInfoLog(CodeInfo newCode,CodeInfo oldCode){
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_DICT_UPDATE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_DICT_UPDATE);
    	
    	// 操作描述
    	StringBuffer operDesc = new StringBuffer();
    	operDesc.append("修改前: typeCode:"+oldCode.getTypeCode()+"|");
    	operDesc.append("typeName:"+oldCode.getTypeName()+"|");
    	operDesc.append("configCode:"+oldCode.getConfigCode()+"|");
    	operDesc.append("configName:"+oldCode.getConfigName()+"|");
     	operDesc.append("修改后: typeCode:"+newCode.getTypeCode()+"|");
    	operDesc.append("typeName:"+newCode.getTypeName()+"|");
    	operDesc.append("configCode:"+newCode.getConfigCode()+"|");
    	operDesc.append("configName:"+newCode.getConfigName()+"|");
    	//maintenanceLog.setOperDesc(operDesc.toString());
    	// 旧值
    	maintenanceLog.setOldInfo(getCodeInfoLogFromat(oldCode));
    	// 新值
    	maintenanceLog.setNewInfo(getCodeInfoLogFromat(newCode));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
	}
	/**
	 * 批量修改数据字典类型 名称
	 * @param codeInfo
	 * @return
	 */
	@RequestMapping(value = "updateTypeCode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateTypeCode(@ModelAttribute("codeInfo") CodeInfo codeInfo) {
		Map<String,Object> map = new HashMap<String,Object>();
			if(codeInfo != null && 
					!StringUtils.isEmpty(codeInfo.getTypeCode()) 
					&& !StringUtils.isEmpty(codeInfo.getTypeName())){
				codeInfoService.updateCodeType(codeInfo);
				map.put("message", "success");
			}else{
				map.put("message", "failure");
			}
		return map;
	}
	/**
	 * 处理删除用户的Post请求
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteCodeInfo(@RequestParam("typeCode") String typeCode,
			@RequestParam("configCode") String configCode ) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(typeCode !=null && configCode != null){
			CodeInfo delVal = codeInfoService.getCodeInfo(typeCode, configCode);
			codeInfoService.delete(typeCode, configCode);
			map.put("message", "success");
			if(delVal!=null){
				deleteCodeInfoLog(delVal);
			}
		}else{
			map.put("message", "failure");
		}
		return map;
	}
	
	/**
	 * 删除数据字典 用户行为日志记录
	 * @param codeInfo
	 */
	@SuppressWarnings("unused")
	private void deleteCodeInfoLog(CodeInfo codeInfo){
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_DICT_DELETE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_DICT_DELETE);
    	// 操作描述 格式 模块名称 | 模块编号
    	String operDesc = "typeCode:"+codeInfo.getTypeCode() + 
    			"|typeName:" + codeInfo.getTypeName()+
    			"|configCode:"+codeInfo.getConfigCode()+
    			"|configName:"+codeInfo.getConfigName();
    	//maintenanceLog.setOperDesc(operDesc);
    	// 旧值
    	maintenanceLog.setOldInfo(getCodeInfoLogFromat(codeInfo));

    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 处理删除用户的Post请求
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "deleteType", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteType(@RequestParam("typeCode") String typeCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(typeCode !=null){
			codeInfoService.delete(typeCode, null);
			map.put("message", "success");
		}else{
			map.put("message", "failure");
		}
		return map;
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