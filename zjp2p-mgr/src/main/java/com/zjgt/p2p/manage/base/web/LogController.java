package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springfk.pancloud.paginator.vo.Page;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.manage.common.CommonUtil;
import com.zjgt.p2p.base.domain.BaseConstant;

@Controller
@RequestMapping("/base/maintenancelog/log")
public class LogController {
    @Autowired
    private IMaintenanceLogService maintenancelogservice;

    /**
     * 查看日志
     * @param ModelAndView
     * @return mv
     */
    @RequestMapping("/lookloger")
    public ModelAndView lookloger(ModelAndView mv) {
        mv.setViewName("base/maintenance/lookloger");
        Map<String, String> operCodes = new HashMap<String, String>();
        operCodes.put(BaseConstant.OPER_CODE_LOCK_USER , BaseConstant.OPER_NAME_LOCK_USER);
        operCodes.put(BaseConstant.OPER_CODE_SAVE_BID , BaseConstant.OPER_NAME_SAVE_BID);
        operCodes.put(BaseConstant.OPER_CODE_SAVE_PUBLISH , BaseConstant.OPER_NAME_SAVE_PUBLISH);
        operCodes.put(BaseConstant.OPER_CODE_DEL_BID , BaseConstant.OPER_NAME_DEL_BID);
        operCodes.put(BaseConstant.OPER_CODE_PAY_TO_BORROWER , BaseConstant.OPER_NAME_PAY_TO_BORROWER);
        operCodes.put(BaseConstant.OPER_CODE_PLATFORM_RECHARGE , BaseConstant.OPER_NAME_PLATFORM_RECHARGE);
        operCodes.put(BaseConstant.OPER_CODE_PLATFORM_WITHDRAW , BaseConstant.OPER_NAME_PLATFORM_WITHDRAW);
        operCodes.put(BaseConstant.OPER_CODE_PLATFORM_ALLOT , BaseConstant.OPER_NAME_PLATFORM_ALLOT);
        //kaiyun add begin
        operCodes.put(BaseConstant.OPER_CODE_STAFF_INSERT , BaseConstant.OPER_NAME_STAFF_INSERT);//增加人员
        operCodes.put(BaseConstant.OPER_NAME_STAFF_DELETE , BaseConstant.OPER_NAME_STAFF_DELETE);//删除人员
        operCodes.put(BaseConstant.OPER_CODE_STAFF_UPDATE , BaseConstant.OPER_NAME_STAFF_UPDATE);//修改人员信息
        operCodes.put(BaseConstant.OPER_CODE_STAFF_RESETPWD , BaseConstant.OPER_NAME_STAFF_RESETPWD);//重置员工密码
        //kaiyun add end
        mv.addObject("operCodes", operCodes);
        return mv;
    }

    @RequestMapping("/getInfoByPage")
    @ResponseBody
    public Map ajaxlookloger(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows", required = false) Integer rows,
            @ModelAttribute("MaintenanceLog") MaintenanceLog maintenancelog, String startDate, String endDate) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        // 分页查询
        Page<MaintenanceLog> pageList = new Page<MaintenanceLog>();
        // 分页查询数据
        if (maintenancelog != null) {
            // 查询条件 opercode
            if (CommonUtil.isNotNull(maintenancelog.getOperCode())) {
                params.put("operCode", maintenancelog.getOperCode());
            }
            // 查询条件 operatorname
            if (CommonUtil.isNotNull(maintenancelog.getOperatorName())) {
                params.put("operatorName", maintenancelog.getOperatorName());
            }
            // 查询条件 operatorno
            if (CommonUtil.isNotNull(maintenancelog.getOperatorNo())) {
                params.put("operatorNo", maintenancelog.getOperatorNo());
            }

            if (CommonUtil.isNotNull(maintenancelog.getOperDesc())) {
                params.put("operDesc", maintenancelog.getOperDesc());
            }
        }
        // 日志的时间
        if (CommonUtil.isNotNull(startDate)) {
            params.put("operstarttime", startDate.replace("-", ""));
        }
        if (CommonUtil.isNotNull(endDate)) {
            params.put("operendtime", endDate.replace("-", ""));
        }
        pageList = maintenancelogservice.getSelectMaintenancelsByPage(params, page, rows);
        List<MaintenanceLog> detailList = pageList.getResult();
        // 分页总记录
        map.put("total", pageList.getTotalCount());
        List<Map<String, String>> rowList = new ArrayList<Map<String, String>>();
        Map<String, String> maps = null;
        if (detailList != null && detailList.size() > 0) {
            for (MaintenanceLog info : detailList) {
                maps = new HashMap<String, String>();
                // OperCode
                maps.put("operCode", info.getOperCode());
                // OperatorName
                maps.put("operatorName", info.getOperatorName());
                // OperatorCode
                maps.put("operatorNo", info.getOperatorNo());
                // OperTime
                maps.put("operTime", info.getOperTime());
                // OperDesc
                maps.put("operDesc", info.getOperDesc());
                // OperOldInfo
                maps.put("oldInfo", info.getOldInfo());
                // OperNewInfo
                maps.put("newInfo", info.getNewInfo());
                rowList.add(maps);
            }
        }
        // 绑定数据集
        map.put("rows", rowList);
        return map;

    }
}
