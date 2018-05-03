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

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;
import org.springfk.pancloud.paginator.vo.Page;
import org.springfk.pancloud.utils.StringUtils;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.Param;
import com.zjgt.p2p.base.domain.ShiroStaff;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IParamService;
/**
 * 
 * @author DELL
 *
 */
@Controller
@RequestMapping("/base/param")
public class ParamController {
    
    @Autowired
    private IParamService paramService;
    
    @Autowired
    private ICodeInfoService codeInfoService;
	
	/**
	 * 操作日志
	 */
	@Autowired
	private IMaintenanceLogService maintenanceLogService;
    
    /**
	 * 数据字典 Map集合
	 * 公用的产品类型 = PRODUCT_CODE
	 */
	private Map<String, String> productCodeMap = new HashMap<String, String>();
	/**
	 * 数据字典 Map集合
	 * 是否可编辑标志 = READ_FLAG
	 */
	private Map<String, String> readFlagMap = new HashMap<String, String>();
    /**
     * 获取参数列表页面
     * @return
     */
    @RequestMapping("/list")
    public String getParamPage(Model model){
    	/*Map<String, List<CodeInfo>> resultMap =codeInfoService.getCodeInfoListByTypeCodes(
				BaseConstant.DICT_CODE_TYPE_READ_FLAG, BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);*/
    	String[] typeCodes = {BaseConstant.DICT_CODE_TYPE_DELETE_FLAG,BaseConstant.DICT_CODE_TYPE_READ_FLAG};
    	Map<String, List<CodeInfo>> resultMap 
		= codeInfoService.getCodeInfoListByTypeCodes(
				typeCodes);
    	List<CodeInfo> codeList = new ArrayList<CodeInfo>();
    	if(resultMap!=null){
    		codeList=codeInfoService.getCodeInfoListByTypeCode(
    				BaseConstant.DICT_CODE_TYPE_READ_FLAG);
    		model.addAttribute("readFlags",codeList);
    		readFlagMap=convertCodeInfoListToMap(codeList);
    		codeList=codeInfoService.getCodeInfoListByTypeCode(
    				BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);
    		model.addAttribute("productCode",codeList);
    		productCodeMap=convertCodeInfoListToMap(codeList);
    	}
    	model.addAttribute("superVisor", checkSuperVisorStaff());
        return "/base/param/paramList";
    }
    
    /**
     * 判断是否是超级管理员
     * @return
     */
    private boolean checkSuperVisorStaff(){
    	ShiroStaff staff = (ShiroStaff) SecurityUtils.getSubject()
				.getPrincipal();
    	return BaseConstant.SUPERVISOR_STAFF_NO.equals(staff.getId());
    }
    /**
     * 获取所有参数列表
     * @return
     */
    @RequestMapping(value="/getParamList",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getParamList(
    		@ModelAttribute("param") Param param ,
    		@RequestParam(value="page",required=false) int page, 
    		@RequestParam(value="rows",required=false) int rows){
    	int pageNo = page;
		int pageSize = rows;
		Map<String, Object> params = new HashMap<String, Object>();
		if(param!=null){
			if(!StringUtils.isEmpty(param.getProductCode())){
				params.put("productCode", param.getProductCode());
			}
			if(!StringUtils.isEmpty(param.getParamCnName())){
				params.put("paramCnName", param.getParamCnName());
			}
			if(!StringUtils.isEmpty(param.getParamEnName())){
				params.put("paramEnName", param.getParamEnName());
			}
		}
        Page<Param> paramsPage= paramService.getParamListByPage(params, pageNo, pageSize);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", paramsPage.getTotalCount()) ;
        List<Param> lists= paramsPage.getResult();
        List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
		for (Param para : lists) {
			map = new HashMap<String, String>();
			map.put("productCode", para.getProductCode());
			map.put("productName",para.getProductCode()==null? "":
				productCodeMap.get(para.getProductCode())==null ?
						"":productCodeMap.get(para.getProductCode()));
			map.put("readFlag", para.getReadFlag());
			map.put("readFlagName",para.getReadFlag()==null? "":
				readFlagMap.get(para.getReadFlag())==null ?
						"":readFlagMap.get(para.getReadFlag()));
			map.put("paramEnName", para.getParamEnName());
			map.put("paramCnName", para.getParamCnName());
			map.put("paramValue", para.getParamValue());
			map.put("description", para.getDescription());
			rowList.add(map);
		}
		result.put("success", true);
		result.put("rows", rowList);
        return result;
    }
    
    /**
     * 增加参数信息
     * @param param
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public JsonResponse add(@Valid Param param,BindingResult result){
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        
        if(result.hasErrors()){
            response.setStatus("FAIL");
        } else {
        	try{
        		Param paramTest=paramService.getParam(param.getProductCode(), 
        				param.getParamEnName());
        		if(paramTest!=null){
        			response.setStatus("FAIL");
        			response.setResult("系统参数已存在！");
        			return response;
        		}
        		paramService.add(param);
        		insertLog(null, param, BaseConstant.LOG_PARAM_ADD_CODE, 
    					BaseConstant.LOG_PARAM_ADD_NAME);
	        }catch(BusinessException ex){
	            response.setStatus("FAIL");
	            if(ex.getErrorMessages()!= null){
	                ex.addBindingResultTo(result);
	            }
	        }
        }
        if(result.hasErrors()){
        	List<FieldError> errors = result.getFieldErrors();
            String err = "";
            for (FieldError error : errors) {
                err += error.getDefaultMessage() + ",";
            }
            response.setResult(err);
        }
        return response;
    }
    /**
     * 增加参数信息
     * @param param
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public JsonResponse update(@Valid Param param,BindingResult result){
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
//        Param paramTest=paramService.getParam(param.getProductCode(), param.getParamEnName());
//        
//        if(BaseConstant.READ_FLAG_N.equals(paramTest.getReadFlag())){
//        	response.setStatus("FAIL");
//        	response.setResult("该参数条目不可编辑！");
//        	return response;
//        }
        if(result.hasErrors()){
            response.setStatus("FAIL");
        } else {
        	try{
        		Param oldParam=paramService.getParam(param.getProductCode(),param.getParamEnName());
        		paramService.update(param);
        		insertLog(oldParam, param, BaseConstant.LOG_PARAM_UPDATE_CODE, 
    					BaseConstant.LOG_PARAM_UPDATE_NAME);
	        }catch(BusinessException ex){
	            response.setStatus("FAIL");
	            if(ex.getErrorMessages()!= null){
	                ex.addBindingResultTo(result);
	            }
	        }
        }
        if(result.hasErrors()){
        	List<FieldError> errors = result.getFieldErrors();
            String err = "";
            for (FieldError error : errors) {
                err += error.getDefaultMessage() + ",";
            }
            response.setResult(err);
        }
        return response;
    }
    /**
     * 删除参数信息
     * @param resource
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResponse deleteResource(String productCode, String paramEnName){
        JsonResponse response = new JsonResponse();
        if(!checkSuperVisorStaff()){
        	response.setStatus("FAIL");
        	response.setResult("只有超级管理员才能删除系统参数！");
        	return response;
        }
        response.setStatus("SUCCESS");
        try{
        	Param param=paramService.getParam(productCode, paramEnName);
            paramService.delete(productCode, paramEnName);
            insertLog(param, null, BaseConstant.LOG_PARAM_DELETE_CODE, 
					BaseConstant.LOG_PARAM_DELETE_NAME);
        }catch(BusinessException ex){
            response.setStatus("FAIL");
            if(ex.getErrorMessages()!= null){
                response.setResult(ex.getErrorMessages());
            }
        }
        return response;
    }
    /**
     * 检查产品编码及参数英文名是否存在
     * @param transCode
     * @return resultMap
     */
    @RequestMapping(value="/checkOnly",method=RequestMethod.POST)
    @ResponseBody
    public JsonResponse checkTransCode(@RequestParam(required = true) String productCode,
    		@RequestParam(required = true) String paramEnName) {
    	JsonResponse response=new JsonResponse();
    	Param param=paramService.getParam(productCode, paramEnName);
    	if(param==null){
    		response.setStatus("true");
    	}else{
    		response.setStatus("false");
    	}
    	return response;
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
	
	
	/**
	 * 插入记录日志
	 * @param oldParam
	 * @param newParam
	 * @param operCode
	 * @param operName
	 */
    private void insertLog(Param oldParam, Param newParam, String operCode, String operName) {
    	// 操作日志
		StringBuffer oldInfo = new StringBuffer();
		StringBuffer newInfo = new StringBuffer();
		if(oldParam!=null){
			oldInfo.append("操作前属性:");
			oldInfo.append("paramCnName:"+oldParam.getParamCnName());
			oldInfo.append("|paramEnName:"+oldParam.getParamEnName());
			oldInfo.append("|paramValue:"+oldParam.getParamValue());
		}
		if(newParam!=null){
			newInfo.append("操作后属性:");
			newInfo.append("paramCnName:"+newParam.getParamCnName());
			newInfo.append("|paramEnName:"+newParam.getParamEnName());
			newInfo.append("|paramValue:"+newParam.getParamValue());
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
}