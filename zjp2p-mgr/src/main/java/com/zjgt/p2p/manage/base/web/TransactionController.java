/**
 * 软件著作权：百富金融技术部
 * 
 * 系统名称：互联网银行
 * 
 * 类名：TransactionController.java
 * 
 * 版本历史：2013/12/10  1.0.0版
 */
package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.Role;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IRoleService;
import com.zjgt.p2p.base.service.ITransactionService;

/**
 * 交易管理Controller
 *  
 */
@Controller
@RequestMapping(value = "/base/trans")
public class TransactionController {
	
	Logger logger= LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired
    ICodeInfoService codeInfoService;
	/**
	 * 交易管理服务接口
	 */
	@Autowired
	private ITransactionService transactionService;
	
	@Autowired
	private IRoleService roleService;
	
	/**
	 * 后台操作记录日志
	 */
	@Autowired
	private IMaintenanceLogService maintenanceLogService;
		
	/**
	 * 显示交易的所有列表
	 * 
	 * @param model
	 * @return 进入transList.jsp页面
	 */
	@RequestMapping(value = "/list")
	public String list(Model model) {
		//List<CodeInfo> status = codeInfoService.getCodeInfoListByTypeCode(BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG);
		List<CodeInfo> status = codeInfoService.getCodeInfoListByTypeCode(BaseConstant.LB_PEOJPAY_TRANS_STATUS);
		model.addAttribute("status", status);
		return "base/trans/transList";
	}

	/**
	 * 添加交易
	 * 
	 * @param transaction
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResponse add(@Valid Transaction transaction,BindingResult result){
		String ipAddress = "127.0.0.1";
		JsonResponse response=new JsonResponse();
		if(result.hasErrors()){
			response.setStatus("failure");
			return response;
		}
		try{
			transactionService.addTransaction(transaction);
			insertAddTransLog(transaction, ipAddress);
			response.setStatus("success");
		}catch(BusinessException exception){
			if(exception.getErrorMessages()!=null){
				exception.addBindingResultTo(result);
				response.setStatus("failure");
			}else{
				response.setStatus(exception.getMessage());
			}
		}
		return response;
	}
	
	/**
	 * 增加交易时插入后台日志
	 * @param transaction
	 */
	private void insertAddTransLog(
			Transaction transaction,String ipAddress) {
		StringBuffer newInfo = new StringBuffer();
		newInfo.append("TransCode:" + transaction.getTransCode());
		newInfo.append(" || TransName:" + transaction.getTransName());
		newInfo.append(" || URL:" + transaction.getUrl());
		newInfo.append(" || ModuleCode:" + transaction.getModuleCode());
		
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		maintenanceLog.setOperCode(BaseConstant.OPER_CODE_TRANSACTION_ADD);
		maintenanceLog.setOperName(BaseConstant.OPER_NAME_TRANSACTION_ADD);
		maintenanceLog.setOperDesc(BaseConstant.OPER_NAME_TRANSACTION_ADD);
		maintenanceLog.setOldInfo(null);
		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setIpAddress(ipAddress);
		maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 更新交易
	 * 
	 * @param transaction
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse update(@Valid Transaction transaction,BindingResult result){
		String ipAddress = "127.0.0.1";
		JsonResponse response=new JsonResponse();
		if(result.hasErrors()){
			response.setStatus("failure");
			return response;
		}
		try{
			String transCode = transaction.getTransCode();
			Transaction oldTransaction = transactionService.getTransactionByTransCode(transCode);
			transactionService.updateTransaction(transaction);
			insertUpdateTransLog(transaction, oldTransaction, ipAddress);
			response.setStatus("success");
		}catch(BusinessException exception){
			if(exception.getErrorMessages()!=null){
				exception.addBindingResultTo(result);
				response.setStatus("lose");
			}else{
				response.setStatus(exception.getMessage());
			}
		}
		return response;
	}
	
	/**
	 * 更新交易时插入后台日志
	 * @param transaction 新交易实体
	 * @param oldTransaction 原交易实体
	 */
	private void insertUpdateTransLog(Transaction transaction,Transaction oldTransaction,
			String ipAddress) {
		StringBuffer oldInfo = new StringBuffer();
		oldInfo.append("TransCode:" + oldTransaction.getTransCode());
		oldInfo.append(" || TransName:" + oldTransaction.getTransName());
		oldInfo.append(" || URL:" + oldTransaction.getUrl());
		oldInfo.append(" || ModuleCode:" + oldTransaction.getModuleCode());
		
		StringBuffer newInfo = new StringBuffer();
		newInfo.append("TransCode:" + transaction.getTransCode());
		newInfo.append(" || TransName:" + transaction.getTransName());
		newInfo.append(" || URL:" + transaction.getUrl());
		newInfo.append(" || ModuleCode:" + transaction.getModuleCode());
		
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		maintenanceLog.setOperCode(BaseConstant.OPER_CODE_TRANSACTION_UPDATE);
		maintenanceLog.setOperName(BaseConstant.OPER_NAME_TRANSACTION_UPDATE);
		maintenanceLog.setOperDesc(BaseConstant.OPER_NAME_TRANSACTION_UPDATE);
		maintenanceLog.setOldInfo(oldInfo.toString());
		maintenanceLog.setNewInfo(newInfo.toString());
		maintenanceLog.setIpAddress(ipAddress);
		maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 处理删除交易的Post请求
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse delete(String transCode) {
		String ipAddress = "127.0.0.1";
		Transaction transaction = transactionService.getTransactionByTransCode(transCode);
		JsonResponse response=new JsonResponse();
		try {
			transactionService.deleteTransaction(transCode);
			insertDeleteTransLog(transaction, ipAddress);
			response.setStatus("success");
		} catch (BusinessException exception) {
			if(exception.getErrorMessages()!=null){
				response.setStatus("failure");
			}else{
				response.setStatus(exception.getMessage());
			}
		}
		return response;
	}
	
	/**
	 * 删除交易时插入后台日志
	 * @param transaction
	 */
	private void insertDeleteTransLog(
			Transaction transaction,String ipAddress) {
		StringBuffer Info = new StringBuffer();
		Info.append("TransCode:" + transaction.getTransCode());
		Info.append(" || TransName:" + transaction.getTransName());
		Info.append(" || URL:" + transaction.getUrl());
		Info.append(" || ModuleCode:" + transaction.getModuleCode());
		
		MaintenanceLog maintenanceLog = new MaintenanceLog();
		maintenanceLog.setOperCode(BaseConstant.OPER_CODE_TRANSACTION_DELETE);
		maintenanceLog.setOperName(BaseConstant.OPER_NAME_TRANSACTION_DELETE);
		maintenanceLog.setOperDesc(BaseConstant.OPER_NAME_TRANSACTION_DELETE);
		maintenanceLog.setOldInfo(Info.toString());
		maintenanceLog.setNewInfo(null);
		maintenanceLog.setIpAddress(ipAddress);
		maintenanceLogService.insert(maintenanceLog);
	}
	
    /**
     * 获取单个或多个模块的交易列表并分页
     * 
     * @param moduleCodes 多个模块编码字符串数组
     * @return maps
     * 
     */
    @RequestMapping(value = "/transByMultiModuleAndPage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getTransByMultiModule(String[] moduleCodes,
    		@RequestParam(required = true) Integer page,
    		@RequestParam(required = true) Integer rows) {
       	Map<String,Object> params = new HashMap<String,Object>();
       	int moduleCount = moduleCodes.length;
       	if(moduleCount==0) {
       		return null;
       	}
    	params.put("moduleCodes", moduleCodes);
        Page<Transaction> trans = transactionService.
        		getTransByModuleCodeAndPage(params, page, rows);
        Map<String,Object> maps=new HashMap<String, Object>();
        maps.put("total", trans.getTotalCount());
        maps.put("rows", trans.getResult());
        return maps;
    }
    
    /**
     * 检查交易编码是否存在
     * @param transCode
     * @return resultMap
     */
    @RequestMapping(value="/checkTransCode/ajax",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkTransCode(@RequestParam(required = true) String transCode) {
    	Map<String,Object> resultMap = new HashMap<String,Object>();
    	Boolean checkCodeResult = transactionService.checkTransCode(transCode);
    	resultMap.put("checkCodeResult", checkCodeResult);
    	return resultMap;
    }

    /**
     * 检查交易名称是否存在
     * @param transName
     * @return resultMap
     */
    @RequestMapping(value="/checkTransName/ajax",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkTransName(@RequestParam(required = true) String transName) {    	
    	Map<String,Object> resultMap = new HashMap<String,Object>();
		Boolean checkNameResult = transactionService.checkTransName(transName);
		resultMap.put("checkNameResult", checkNameResult);
		return resultMap;
    }
    
    /**
     * 获取单个模块的交易列表   <<该方法在该版本中未被用到>>
     * @param moduleCode
     */
    @RequestMapping(value = "/transBySingleModule",method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> getTransBySingleModule(String moduleCode) {
        List<Transaction> transList = transactionService.getTransByModuleCode(moduleCode);
        return transList;
    }
    
    /**
     * 根据Page来实现交易的分页查询      <<该方法在该版本中未被用到>>
     * @param model
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value="/byPage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listByPageJson(Model model, int page,int rows) {
         int pageno = page;
         int pagesize = rows;
       
         Map<String,Object> maps = new HashMap<String,Object>();
 		 List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
         Page<Transaction> transactions = transactionService.getTransByPage(null,pageno, pagesize);
         List<Transaction> lists=transactions.getResult();
         maps.put("total", transactions.getTotalCount());
         Map<String,String> map=null;
         for(Transaction trans : lists){
        	 map=new HashMap<String,String>();
        	 map.put("moduleCode", trans.getModuleCode());
        	 map.put("transCode", trans.getTransCode());	
        	 map.put("transName", trans.getTransName());
        	 map.put("transStatus", trans.getTransStatus());
        	 map.put("url", trans.getUrl());
        	 map.put("validateFlag", trans.getValidateFlag());
        	 rowList.add(map);
	         }
	         maps.put("success", true);
	         maps.put("rows", rowList);
	         return maps;
    }
    
    /**
     * 根据模块编码来实现交易的分页查询      <<该方法在该版本中未被用到>>
     * @param model
     * @param page
     * @param rows
     * @param moduleCode
     * @return
     */
    @RequestMapping(value="/byCodePage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listByPageModuleCode(
    		Model model, int page,int rows,String moduleCode) {
         int pageno = page;
         int pagesize = rows;
         Map<String,Object> maps = new HashMap<String,Object>();
         Map<String,Object> param = new HashMap<String,Object>();
         param.put("moduleCode", moduleCode);
 		 List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();
         Page<Transaction> transactions = transactionService.
        		 getTransByModuleCodePage(param,pageno, pagesize);
         List<Transaction> lists=transactions.getResult();
         
         maps.put("total", transactions.getTotalCount());
         Map<String,String> map=null;
         for(Transaction trans : lists){
        	 map=new HashMap<String,String>();
        	 map.put("moduleCode", trans.getModuleCode());
        	 map.put("transCode", trans.getTransCode());	
        	 map.put("transName", trans.getTransName());
        	 map.put("transStatus", trans.getTransStatus());
        	 map.put("url", trans.getUrl());
        	 map.put("validateFlag", trans.getValidateFlag());
        	 rowList.add(map);
         }
         maps.put("success", true);
         maps.put("rows", rowList);
         return maps;
    }
    
	/**
     * 根据transCode获取角色列表
     * @param  transCode
     * @return
     */
    @RequestMapping(value = "getRoles")
    @ResponseBody
	public List<Role> getTrans(@RequestParam("transCode") String transCode) {
        List<Role> list = null;
        try {
        	list = roleService.getRoleByTransCode(transCode);
        } catch (BusinessException e) {
            if (e.getMessage() != null) {
                e.getMessage();
            } else {
                throw e;
            }
        }
        return list;
    }
}
