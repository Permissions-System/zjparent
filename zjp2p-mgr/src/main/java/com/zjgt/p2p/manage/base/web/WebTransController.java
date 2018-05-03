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
import com.zjgt.p2p.base.domain.WebTrans;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IWebTransService;


/**
 * 公共管理-复核操作配置 分发控制器
 * @author lutao
 *
 */
@Controller
@RequestMapping(value = "/base/webtrans")
public class WebTransController {

    Logger logger = LoggerFactory.getLogger(WebTransController.class);
    
    /**
     *  交易配置 服务接口
     */
	@Autowired
	private IWebTransService webTransService;
	
	/**
	 * 数据字典 服务接口
	 */
	@Autowired
	private ICodeInfoService codeInfoService;
	
    /**
     * 后台维护日志记录 服务接口
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
	 * 消息发送方式  = MSG_CHANNEL
	 */
	private Map<String, String> msgChannelMap = new HashMap<String, String>();
	
	/**
	 * 消息模板
	 * @param model
	 * @return
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
    	// 公用的产品类型 = PRODUCT_CODE,
    	// 消息发送方式 = MSG_CHANNEL
    	// 初始化 数据字典信息
    	String[] typeCodes={BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE,BaseConstant.DICT_CODE_TYPE_MSG_CHANNEL};
    	Map<String, List<CodeInfo>> resultMap 
    		= codeInfoService.getCodeInfoListByTypeCodes(typeCodes);
    	List<CodeInfo> codeList = new ArrayList<CodeInfo>();
    	if(resultMap!=null){
    		// 公用的产品类型
    		codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_PRODUCT_CODE);
    		model.addAttribute("productCode",codeList);
    		// 初始化产品代码 MAP
    		productCodeMap = convertCodeInfoListToMap(codeList);
    		// 消息发送方式  MSG_CHANNEL
    		codeList = resultMap.get(BaseConstant.DICT_CODE_TYPE_MSG_CHANNEL);
    		model.addAttribute("msgChannel",codeList);
    		// 初始化消息发送方式 MAP
    		msgChannelMap = convertCodeInfoListToMap(codeList);
    	}
        return "base/webtrans/webtrans";
    }
    
    /**
     * 消息模板 展现页面
     * @param model
     * @return
     */
    @RequestMapping(value="/list")
    public String webTransInfo(Model model) {
        return "base/webtrans/webtrans";
    }
    
	/**
	 * 提交TRANS_CODE校验新增数据的存在性校验
	 * @param transCode
	 * @return
	 */
	@RequestMapping(value="/ckExistWebTransInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> ckExistWebTransInfo(
			@RequestParam(value="transCode",required=false) String transCode){
		Map<String,Object> map = new HashMap<String,Object>();
		int count = webTransService.getCountWebTransInfo(transCode);
		map.put("count", count);
		return map;
	}
	
	/**
	 * 处理添加新WebTrans的POST请求 
	 * @param webTrans
	 * @return
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> insertWebTransInfo(
			@ModelAttribute("webTrans") WebTrans webTrans) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(webTrans!=null){
			int count = 0;
			count = webTransService.getCountWebTransInfo(webTrans.getTransCode());
			if(count>0){
				// 存在性校验 若存在 返回 给页面 提示
				map.put("message", "exist");
			}else{
				// 插入数据
				webTransService.insert(webTrans);
				map.put("message", "success");
				// 用户行为日志记录
				saveWebTransLog(webTrans);
			}
		}else{
			// 异常
			map.put("message", "exception");
		}
		return map;
	}
	
	/**
	 * 新增配置记录时，用户行为日志记录
	 * @param webTrans
	 */
	private void saveWebTransLog(WebTrans webTrans){
		// 新增配置记录 日志描述记录 交易代码|交易名称|归属产品|复核级别|详细页面
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_WBTS_INSERT);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_WBTS_INSERT);
    	
    	// 操作描述 格式交易代码|交易名称|归属产品|复核级别|详细页面
    	String operDesc = "transCode:"+webTrans.getTransCode() + 
    			"|transName:" + webTrans.getTransName()+
    			"|productCode:"+webTrans.getProductCode()+
    			"|recheckLevel:"+webTrans.getRecheckLevel().intValue()+
    			"|recheckDetailPage:"+webTrans.getRecheckDetailPage();
    	maintenanceLog.setOperDesc(operDesc);
    	maintenanceLog.setNewInfo(getWebTransLogFromat(webTrans));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 格式化复核配置信息
	 * @param webTrans
	 * @return
	 */
	private String getWebTransLogFromat(WebTrans webTrans){
		// 旧值
    	StringBuffer val = new StringBuffer();
      	if(!StringUtils.isEmpty(webTrans.getTransCode())){
        	// transCode
      		val.append("transCode:"+webTrans.getTransCode()+"|");
    	}
      	if(!StringUtils.isEmpty(webTrans.getTransName())){
        	// transName
      		val.append("transName:"+webTrans.getTransName()+"|");
    	}
      	if(!StringUtils.isEmpty(webTrans.getProductCode())){
        	// productCode
      		val.append("productCode:"+webTrans.getProductCode()+"|");
    	}
      	if(!StringUtils.isEmpty(webTrans.getModuleName())){
        	// moduleName
      		val.append("moduleName:"+webTrans.getModuleName()+"|");
    	}
      	if(webTrans.getRecheckLevel()!=null){
      		//recheckLevel
      		val.append("recheckLevel:"+webTrans.getRecheckLevel().intValue()+"|");
      	}
    	if(!StringUtils.isEmpty(webTrans.getRecheckDetailPage())){
        	// recheckDetailPage
      		val.append("recheckDetailPage:"+webTrans.getRecheckDetailPage()+"|");
    	}
    	if(!StringUtils.isEmpty(webTrans.getRecheckHandlePage())){
        	// recheckHandlePage
      		val.append("recheckHandlePage:"+webTrans.getRecheckHandlePage()+"|");
    	}
      	
    	return val.toString();
	}
	/**
	 * 处理编辑MsgTemplate的POST请求
	 * @param msgTemplate
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateWebTransInfo(
			@ModelAttribute("webTrans") WebTrans webTrans) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(webTrans!=null){
			WebTrans oldInfo = webTransService.getWebTransInfo(webTrans.getTransCode());
			webTransService.update(webTrans);
			map.put("message", "success");
			// 用户行为日志记录
			if(oldInfo!=null){
				updateWebTransLog(webTrans,oldInfo);
			}
		}else{
			map.put("message", "exception");
		}
		return map;
	}
	
	/**
	 * 更新信息 记录用户操作行为日志
	 * @param newInfo
	 * @param oldInfo
	 */
	private void updateWebTransLog(WebTrans newInfo,WebTrans oldInfo){
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_WBTS_UPDATE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_WBTS_UPDATE);
    	// 操作描述
    	StringBuffer operDesc = new StringBuffer();
    	operDesc.append("修改前: transCode:"+oldInfo.getTransCode()+"|");
    	operDesc.append("transName:"+oldInfo.getTransName()+"|");
    	operDesc.append("productCode:"+oldInfo.getProductCode()+"|");
    	operDesc.append("recheckLevel:"+oldInfo.getRecheckLevel().intValue()+"|");
    	operDesc.append("recheckDetailPage:"+oldInfo.getRecheckDetailPage()+"|");
     	operDesc.append("修改后: typeCode:"+newInfo.getTransCode()+"|");
     	operDesc.append("transName:"+newInfo.getTransName()+"|");
    	operDesc.append("productCode:"+newInfo.getProductCode()+"|");
    	operDesc.append("recheckLevel:"+newInfo.getRecheckLevel().intValue()+"|");
    	operDesc.append("recheckDetailPage:"+newInfo.getRecheckDetailPage()+"|");
    	//maintenanceLog.setOperDesc(operDesc.toString());
    	// 旧值
    	maintenanceLog.setOldInfo(getWebTransLogFromat(oldInfo));
    	// 新值
    	maintenanceLog.setNewInfo(getWebTransLogFromat(newInfo));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 处理删除一条消息模板的Post请求
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteWebTransInfo(
			@RequestParam("transCode") String transCode) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(transCode !=null){
			WebTrans oldInfo = webTransService.getWebTransInfo(transCode);
			webTransService.delete(transCode);
			map.put("message", "success");
			// 用户行为日志记录
			if(oldInfo!=null){
				deleteWebTransLog(oldInfo);
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
	private void deleteWebTransLog(WebTrans webTrans){
    	MaintenanceLog maintenanceLog = new MaintenanceLog();
    	// 操作代码
    	maintenanceLog.setOperCode(BaseConstant.OPER_CODE_WBTS_DELETE);
    	// 操作名称
    	maintenanceLog.setOperName(BaseConstant.OPER_NAME_WBTS_DELETE);
    	
    	// 操作描述
    	StringBuffer operDesc = new StringBuffer();
    	operDesc.append("transCode:"+webTrans.getTransCode()+"|");
    	operDesc.append("transName:"+webTrans.getTransName()+"|");
    	operDesc.append("productCode:"+webTrans.getProductCode()+"|");
    	operDesc.append("recheckLevel:"+webTrans.getRecheckLevel().intValue()+"|");
    	operDesc.append("recheckDetailPage:"+webTrans.getRecheckDetailPage()+"|");
    	//maintenanceLog.setOperDesc(operDesc.toString());
    	
    	// 旧值
    	maintenanceLog.setOldInfo(getWebTransLogFromat(webTrans));
    	
    	// 记录行为日志
    	maintenanceLogService.insert(maintenanceLog);
	}
	
	/**
	 * 分页获取 根据数据字典类型获取 类型下配置的明细字典明细列表
	 * @param page
	 * @param rows
	 * @param typeCode
	 * @return
	 */
	@RequestMapping(value="/getWebTransInfoList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getWebTransInfoList(
			@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows,
			@ModelAttribute("webTrans") WebTrans webTrans){
		// page rows easyUi默认传值用于分页  msgTemplate用于封装查询条件
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		List<Map<String,String>> rowList = new ArrayList<Map<String,String>>();

		if(webTrans!=null){
			// 查询条件 产品代码
			if(!StringUtils.isEmpty(webTrans.getProductCode())){
				params.put("productCode", webTrans.getProductCode());
			}
			if(!StringUtils.isEmpty(webTrans.getTransName())){
				params.put("transName", webTrans.getTransName());
			}
			if(!StringUtils.isEmpty(webTrans.getModuleName())){
				params.put("moduleName", webTrans.getModuleName());
			}
//			if(!StringUtils.isEmpty(webTrans.getMsgChannel())){
//				params.put("msgChannel", webTrans.getMsgChannel());
//			}
		}
		
		// 分页查询
		Page<WebTrans> pageList = 
				webTransService.getWebTransInfoListByPage(params, page, rows);
		List<WebTrans> detailList = pageList.getResult();
		// 分页总记录
		map.put("total", pageList.getTotalCount());
		
		Map<String,String> maps = null;
		//String msgChannelDesc ="";
		for(WebTrans info: detailList){
			maps = new HashMap<String,String>();
			// 页面新增CheckBox专列 值等同于模板代码
			maps.put("id", info.getTransCode());
			maps.put("transCode", info.getTransCode());
			maps.put("transName", info.getTransName());
			maps.put("productCode", info.getProductCode());
			// 展现 产品名称
			maps.put("productName",info.getProductCode()==null? "":
				productCodeMap.get(info.getProductCode())==null ?
						"":productCodeMap.get(info.getProductCode()));
			maps.put("moduleName", info.getModuleName());
			maps.put("recheckLevel", info.getRecheckLevel()==null
					?"":String.valueOf(info.getRecheckLevel().intValue()));
			
			// 显示 复核详细信息页面
			maps.put("recheckDetailPage", info.getRecheckDetailPage());
			//  复核终核处理页面
			maps.put("recheckHandlePage", info.getRecheckHandlePage());
//			maps.put("msgChannel", info.getMsgChannel()==null?"":info.getMsgChannel());
//			msgChannelDesc ="";
//			if(info.getMsgChannel()!=null){
//				String[] msgChannel = info.getMsgChannel().split(",");
//				for(int i = 0;i<msgChannel.length;i++){
//					msgChannelDesc += msgChannelMap.get(msgChannel[i]) + ",";
//				}
//				
//				msgChannelDesc = msgChannelDesc.substring(0,msgChannelDesc.length()-1);
//			}
//			maps.put("msgChannelDesc", info.getMsgChannel()==null?"":msgChannelDesc);
			rowList.add(maps);
		}
		// 绑定数据集
		map.put("rows", rowList);
		return map;
	}
	
	/**
	 * 根据主键获取 配置记录
	 * @param transCode
	 * @return
	 */
	@RequestMapping(value="/getWebTransInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getWebTransInfo(
			@RequestParam(value="transCode",required=false) String transCode){
		Map<String,Object> maps = new HashMap<String,Object>();
		if(transCode!=null&&!"".equals(transCode)){
			WebTrans info = webTransService.getWebTransInfo(transCode);
			if(info!=null){
				// 页面新增CheckBox专列 值等同于模板代码
				maps.put("id", info.getTransCode());
				maps.put("transCode", info.getTransCode());
				maps.put("transName", info.getTransName());
				maps.put("productCode", info.getProductCode());
				// 展现 产品名称
				maps.put("productName",info.getProductCode()==null? "":
					productCodeMap.get(info.getProductCode())==null ?
							"":productCodeMap.get(info.getProductCode()));
				maps.put("moduleName", info.getModuleName());
				maps.put("recheckLevel", info.getRecheckLevel()==null
						?"":String.valueOf(info.getRecheckLevel().intValue()));
				// 显示 复核详细信息页面
				maps.put("recheckDetailPage", info.getRecheckDetailPage());
				//  复核终核处理页面
				maps.put("recheckHandlePage", info.getRecheckHandlePage());
//				maps.put("msgChannel", info.getMsgChannel()==null? "":info.getMsgChannel());
//				String msgChannelDesc ="";
//				if(info.getMsgChannel()!=null){
//					String[] msgChannel = info.getMsgChannel().split(",");
//					for(int i = 0;i<msgChannel.length;i++){
//						msgChannelDesc += msgChannelMap.get(msgChannel[i]) + ",";
//					}
//					
//					msgChannelDesc = msgChannelDesc.substring(0,msgChannelDesc.length()-1);
//				}
//				maps.put("msgChannelDesc", info.getMsgChannel()==null?"":msgChannelDesc);
				maps.put("message", "success");
			}else{
				maps.put("message", "failure");
			}
		}
		return maps;
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