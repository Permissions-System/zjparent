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
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.utils.StringUtils;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.Module;
import com.zjgt.p2p.base.domain.Transaction;
import com.zjgt.p2p.base.domain.TreeNode;
import com.zjgt.p2p.base.service.IModuleService;

/**
 * 模块管理Controller
 * 
 * @author MacDancer
 */

@Controller
@RequestMapping(value = "/base/module")
public class ModuleController {

    Logger logger = LoggerFactory.getLogger(ModuleController.class);

    /**
     * 模块服务
     */
    @Autowired
    private IModuleService moduleService;
    
    /**
     * 后台维护日志记录服务接口
     */
    @Autowired
    private IMaintenanceLogService maintenanceLogService;
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return "/base/module/moduleList";
    }

    /**
     * ajax获取根模块节点
     * 
     * @return
     */
    @RequestMapping(value = "getRootModuleList", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getRootModule() {
        JsonResponse response = new JsonResponse();
        List<Module> module = moduleService.getRootModuleList();
        response.setResult(module);
        response.setStatus("SUCCESS");
        return response;
    }

    
    /**
     * 处理添加新Module的POST请求 处理模块数据的新增
     * @param module
     * @return
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertModuleInfo(@ModelAttribute("module") Module module) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(module!=null){
            int count = moduleService.getCountModuleInfo(module.getModuleCode()); 
            if(count>0){
                map.put("result", "exist");
            }else{
                // 插入类型记录主表
                moduleService.addModule(module);
                map.put("result", "success");
                
                // 调用记录行为日志方法
                saveModuleLog(module);
            }
        }else{
            map.put("result", "failure");
        }
        return map;
    }
    
    /**
     * 新增模块信息记录时，新增维护日志记录
     * @param module
     */
    private void saveModuleLog(Module module){
    	// 新增模块信息 保存 新增内容为 ： 操作模块名称|编号 
    	// field recNo 和 operTime 由接口赋值，其余应用逻辑赋值
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_MODULE_INSERT);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_MODULE_INSERT);
    	// 操作描述 格式 模块名称 | 模块编号
    	String operDesc = module.getModuleName() + "|" + module.getModuleCode();
    	maintenanceLog.setOperDesc(operDesc);
    	
    	// 新增记录 Objinfo 信息
    	StringBuffer newInfo = new StringBuffer();
    	if(!StringUtils.isEmpty(module.getModuleCode())){
        	// moduleCode
    		newInfo.append("moduleCode:"+module.getModuleCode()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getModuleName())){
        	// moduleName
    		newInfo.append("moduleName:"+module.getModuleName()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getTreepath())){
    		// treepath
    		newInfo.append("treepath:"+module.getTreepath()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getParentModuleCode())){
    		// parentModuleCode
    		newInfo.append("parentModuleCode:"+module.getParentModuleCode()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getModuleStatus())){
    		// moduleStatus
    		newInfo.append("moduleStatus:"+module.getModuleStatus()+"|");
    	}
    	// 赋值 newInfo
    	maintenanceLog.setNewInfo(newInfo.toString());
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
    }
    
    
    /**
     * 更新模块信息 记录用户操作行为日志
     * @param newModule
     * @param oldModule
     */
    private void updateModuleLog(Module newModule,Module oldModule){
    	// 新增模块信息 保存 修改内容为 ： 操作模块名称|编号 
    	// field recNo 和 operTime 由接口赋值，其余应用逻辑赋值
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_MODULE_UPDATE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_MODULE_UPDATE);
    	// 操作描述
    	StringBuffer operDesc = new StringBuffer();
    	operDesc.append("修改前: moduleCode:"+oldModule.getModuleCode()+"|");
    	operDesc.append("moduleName:"+oldModule.getModuleName()+"|");
     	operDesc.append("修改后: moduleCode:"+newModule.getModuleCode()+"|");
    	operDesc.append("moduleName:"+newModule.getModuleName()+"|");
    	maintenanceLog.setOperDesc(operDesc.toString());
    	// 旧值
    	maintenanceLog.setOldInfo(getModuleLogFromat(oldModule));
    	// 新值
    	maintenanceLog.setNewInfo(getModuleLogFromat(newModule));

    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
    }
    
    /**
     * 删除模块记录时 用户行为日志记录
     * @param moduleCode
     */
    private void deleteModuleLog(Module module){
    	// field recNo 和 operTime 由接口赋值，其余应用逻辑赋值
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_MODULE_DELETE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_MODULE_DELETE);
    	
    	StringBuffer operDesc = new StringBuffer();
    	operDesc.append("moduleCode:"+module.getModuleCode()+"|");
    	operDesc.append("moduleName:"+module.getModuleName()+"|");
    	maintenanceLog.setOperDesc(operDesc.toString());
    	// 旧值
    	maintenanceLog.setOldInfo(getModuleLogFromat(module));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
    }
    
    /**
     * 格式化处理 模块对象信息
     * @param module
     * @return
     */
    private String getModuleLogFromat(Module module){
    	// 旧值
    	StringBuffer val = new StringBuffer();
      	if(!StringUtils.isEmpty(module.getModuleCode())){
        	// moduleCode
      		val.append("moduleCode:"+module.getModuleCode()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getModuleName())){
        	// moduleName
    		val.append("moduleName:"+module.getModuleName()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getTreepath())){
    		// treepath
    		val.append("treepath:"+module.getTreepath()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getParentModuleCode())){
    		// parentModuleCode
    		val.append("parentModuleCode:"+module.getParentModuleCode()+"|");
    	}
    	if(!StringUtils.isEmpty(module.getModuleStatus())){
    		// moduleStatus
    		val.append("moduleStatus:"+module.getModuleStatus()+"|");
    	}
    	
    	return val.toString();
    }
    
    /**
     * 修改Module信息
     * @param module
     * @param modParentCode
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> modifyModuleInfo(@ModelAttribute("module") Module module,
    		@RequestParam(value="modParentCode",required=false) String modParentCode) {
        Map<String,Object> map = new HashMap<String,Object>();
        if(module!=null &&modParentCode!=null && !"".equals(modParentCode) ){
	            // 查询数据库旧值
	            Module oldVal = moduleService.getModuleByModuleCode(module.getModuleCode());
                // 插入类型记录主表
                moduleService.updateModule(module);
                
                // 记录修改 用户行为记录
                updateModuleLog(module,oldVal);
                
        	    if(modParentCode.equals("1")){
        			// 上级模块结点发生变化 ，需要处理原本在修改结点模块下的所有层级的子结点的ParentModuleCode
        	    	String parentModuleCode = module.getParentModuleCode();
        	    	Module parentModuleVO = moduleService.getModuleByModuleCode(parentModuleCode);
        	    	
        	    	String moduleCode = module.getModuleCode();
        	    	Module moduleVO = moduleService.getModuleByModuleCode(moduleCode);
        	    	
        	    	if(parentModuleVO!=null&&moduleVO!=null){
        	    		// 修改treepath
        	    		moduleService.updateModuleTreePaths(moduleVO, parentModuleVO);
        	    	}
        		}
                map.put("result", "success");
        }else{
            map.put("result", "failure");
        }
        return map;
    }
    
    /**
     * 在进行上级及诶单的转移时 用于判断 上级结点 是否是 修改结点的本来的下级及下级子节点的处理
     * @param moduleCode
     * @param parentModuleCode
     * @return
     */
    @RequestMapping(value = "cracleUpdate", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> isCircleUpdParentCode(
    		@RequestParam(value="moduleCode",required=false) String moduleCode,
    		@RequestParam(value="parentModuleCode",required=false) String parentModuleCode){
    	Map<String,Object> map = new HashMap<String,Object>();
    	if(moduleCode!=null && parentModuleCode!=null && 
    			!"".equals(parentModuleCode) && !"".equals(moduleCode)){
    		Module parent = moduleService.getModuleByModuleCode(parentModuleCode);
    		if(parent.getTreepath().indexOf(moduleCode)>0){
    			// 转移后的父结点 实际是 该结点的子孙结点
    			map.put("message", "1");
    		}else{
    			// 不是下级结点
    			map.put("message", "0");
    		}
    	}else{
    		map.put("message", "error");
    	}
    	
    	return map;
    }
    
    /**
     * ajax获取一级子模块列表
     * 
     * @param moduleCode
     * @return
     */
    @RequestMapping(value = "getSubModuleList", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getSubModuleList(@RequestParam String moduleCode) {
        JsonResponse response = new JsonResponse();
        List<Module> moduleList = moduleService.getSubModules(moduleCode);
        response.setResult(moduleList);
        response.setStatus("SUCCESS");
        return response;
    }
    
    /**
     * ajax获取单个模块下所有的交易
     * 
     * @param moduleCode
     * @return
     */
    @RequestMapping(value = "getTransByModuleCode", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getTransByModuleCode(@RequestParam String moduleCode,Model model) {
        JsonResponse response = new JsonResponse();
        List<Transaction> transactionList = moduleService.getTransByModuleCode(moduleCode);
        response.setResult(transactionList);
        response.setStatus("SUCCESS");
        model.addAttribute("transactions", transactionList);
        return response;
    }

    /**
     * 查询交易表中 该模块编码是否已经配置了交易信息
     * @param moduleCode
     * @author lutao
     * @return
     */
    @RequestMapping(value="/ckTransModuleCode",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> ckTransModuleCode(
            @RequestParam(value="moduleCode",required=false) String moduleCode){
        Map<String,Object> map = new HashMap<String,Object>();
        int count = moduleService.getCountTransByModuleCode(moduleCode);
        // 直接返回模块编码下配置的 交易数目
        map.put("count", count);
        return map;
    }
    
    /**
     * ajax保存菜单节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "saveModuleInfo", method = RequestMethod.POST)
    @ResponseBody
    public void saveModuleInfo(@Valid Module module) {
        moduleService.addModule(module);
        saveModuleLog(module);
    }

    /**
     * ajax更新模块节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "updateModuleInfo", method = RequestMethod.POST)
    @ResponseBody
    public void updateModuleInfo(@Valid Module module) {
        moduleService.updateModule(module);
        
        Module oldVal = moduleService.getModuleByModuleCode(module.getModuleCode());
        // 记录修改 用户行为记录
        updateModuleLog(module,oldVal);
    }

    /**
     * ajax删除菜单节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "deleteModuleInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteModuleInfo(@RequestParam String moduleCode) {
        Module oldVal = moduleService.getModuleByModuleCode(moduleCode);
        moduleService.deleteModule(moduleCode);
        // 删除模块信息 用户行为日志记录
        if(oldVal!=null){
        	deleteModuleLog(oldVal);
        }
    }

    /**
     * 获得模型树结构List
     * @return
     */
    @RequestMapping(value = "/rootTree")
    @ResponseBody
    public List<TreeNode<Module>> rootTree() {
        TreeNode<Module> treeNode = new TreeNode<Module>();
        List<TreeNode<Module>> tree = new ArrayList<TreeNode<Module>>();
        //Module rootModel = moduleService.getRootModule();
        //treeNode = convertToTreeNode(rootModel);
        //tree.add(treeNode);
        // 获取全部根节点
        List<Module> rootList = moduleService.getModuleTree();
        if(rootList!=null&&rootList.size()>0){
        	for(Module rootModule : rootList){
        		treeNode = convertToTreeNode(rootModule);
        		tree.add(treeNode);
        	}
        }
        return tree;
    }

    /**
     * 格式化 模块列表数据
     * @param module
     * @return
     */
    private TreeNode<Module> convertToTreeNode(Module module) {
        TreeNode<Module> treeNode = new TreeNode<Module>();
        treeNode.setId(module.getModuleCode());
        treeNode.setText(module.getModuleName());
        treeNode.setAttributes(module);
        List<TreeNode<Module>> treeNodes = new ArrayList<TreeNode<Module>>();
        if(module.getSubModuleList()!=null &&module.getSubModuleList().size() >0){
            for (Module childModule : module.getSubModuleList()) {
                TreeNode<Module> childNode = new TreeNode<Module>();
                childNode = convertToTreeNode(childModule);
                treeNodes.add(childNode);
            }
        }

        treeNode.setChildren(treeNodes);

        return treeNode;
    }

}
