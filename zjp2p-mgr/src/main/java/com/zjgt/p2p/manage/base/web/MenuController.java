package com.zjgt.p2p.manage.base.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springfk.pancloud.domain.JsonResponse;
import org.springfk.pancloud.exception.BusinessException;

import com.zjgt.p2p.base.domain.MaintenanceLog;
import com.zjgt.p2p.base.service.IMaintenanceLogService;
import com.zjgt.p2p.base.domain.BaseConstant;
import com.zjgt.p2p.base.domain.CodeInfo;
import com.zjgt.p2p.base.domain.Menu;
import com.zjgt.p2p.base.domain.TreeNode;
import com.zjgt.p2p.base.service.ICodeInfoService;
import com.zjgt.p2p.base.service.IMenuService;

/**
 * 菜单管理功能
 * 
 * @author xrwang
 * 
 */
@Controller
@RequestMapping(value = "/base/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private ICodeInfoService codeInfoService;
    @Autowired
    private IMaintenanceLogService maintenanceLogService;

    /**
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        return "/base/menu/menuList";
    }

    /**
     * ajax获取菜单树
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "getMenuTree", method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode<Menu>> getMenuTreeForPost() {
        List<Menu> menuList = menuService.getMenuTreeListThroughTreepath();
        List<TreeNode<Menu>> menuTreeNodeList = new ArrayList<TreeNode<Menu>>();
        if (menuList != null) {
            for (Menu menu : menuList) {
                TreeNode<Menu> treeNode = new TreeNode<Menu>();
                treeNode.setId(menu.getMenuCode());
                treeNode.setText(menu.getMenuName());
                treeNode.setChildren(setSubMenuTreeNode(menu.getSubMenuList()));
                menu.setSubMenuList(null);// 清除list信息
                treeNode.setAttributes(menu);
                menuTreeNodeList.add(treeNode);
            }
        }
        return menuTreeNodeList;
    }

    /**
     * 递归构建菜单树
     * 
     * @param subMenuList
     * @return
     * @throws BusinessException
     */
    private List<TreeNode<Menu>> setSubMenuTreeNode(List<Menu> subMenuList)
            throws BusinessException {
        List<TreeNode<Menu>> result = new ArrayList<TreeNode<Menu>>();
        if (subMenuList != null) {
            for (Menu menu : subMenuList) {
                TreeNode<Menu> treeNode = new TreeNode<Menu>();
                treeNode.setId(menu.getMenuCode());
                treeNode.setText(menu.getMenuName());
                treeNode.setChildren(setSubMenuTreeNode(menu.getSubMenuList()));
                menu.setSubMenuList(null);// 清除list信息
                treeNode.setAttributes(menu);
                result.add(treeNode);
            }
        }
        return result;
    }

    /**
     * ajax保存菜单节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "saveMenuInfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse saveMenuInfo(@Valid Menu menu, BindingResult result) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        if (result.hasErrors()) {
            response.setStatus("FAIL");
            List<FieldError> errors = result.getFieldErrors();
            String err = "";
            for (FieldError error : errors) {
                err += error.getDefaultMessage() + ",";
            }
            response.setResult(err);
        } else {
            try {
                menu = menuService.saveMenuNode(menu);
                response.setResult(menu);
            } catch (BusinessException e) {
                response.setStatus("FAIL");
                if (e.getMessage() != null) {
                    response.setResult(e.getMessage());
                }
                if (e.getErrorMessages().size() != 0) {
                    e.addBindingResultTo(result);
                }
            }
            // 登记后台操作日志
            this.menuOperLog(BaseConstant.OPER_CODE_MENU_ADD, BaseConstant.OPER_NAME_MENU_ADD,
                    null, menu);
        }
        if (result.hasErrors()) {
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
     * ajax更新菜单节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "updateMenuInfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse updateMenuInfo(@Valid Menu menu, BindingResult result) {
        JsonResponse response = new JsonResponse();
        response.setStatus("SUCCESS");
        Menu oldMenu = null;
        if (result.hasErrors()) {
            response.setStatus("FAIL");
            List<FieldError> errors = result.getFieldErrors();
            String err = "";
            for (FieldError error : errors) {
                err += error.getDefaultMessage() + ",";
            }
            response.setResult(err);
        } else {
            try {
                oldMenu = menuService.getMenuInfo(menu.getMenuCode());
                menu = menuService.updateMenuNode(menu);
                response.setResult(menu);
            } catch (BusinessException e) {
                response.setStatus("FAIL");
                if (e.getMessage() != null) {
                    response.setResult(e.getMessage());
                }
                if (e.getErrorMessages().size() != 0) {
                    e.addBindingResultTo(result);
                }
            }
            // 登记后台操作日志
            this.menuOperLog(BaseConstant.OPER_CODE_MENU_UPDATE,
                    BaseConstant.OPER_NAME_MENU_UPDATE, oldMenu, menu);
        }
        if (result.hasErrors()) {
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
     * ajax删除菜单节点
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "deleteMenuInfo", method = RequestMethod.POST)
    @ResponseBody
    public void deleteMenuInfo(@RequestParam String menuCode) {
        Menu oldMenu = menuService.getMenuInfo(menuCode);
        menuService.deleteMenuNode(menuCode);
        // 登记后台操作日志
        this.menuOperLog(BaseConstant.OPER_CODE_MENU_DELETE, BaseConstant.OPER_NAME_MENU_DELETE,
                oldMenu, null);
    }

    /**
     * 获取码表信息
     */
    @RequestMapping(value = "getCodeInfo/{typeCode}", method = RequestMethod.POST)
    @ResponseBody
    public List<CodeInfo> getCodeInfo(@PathVariable(value = "typeCode") String typeCode) {
        if (StringUtils.isEmpty(typeCode)) {
            return null;
        }
        List<CodeInfo> list = codeInfoService.getCodeInfoListByTypeCode(typeCode);
        CodeInfo code = new CodeInfo();
        code.setConfigCode("");
        code.setConfigName("请选择");
        list.add(0, code);
        return list;
    }

    /**
     * 菜单管理操作日志
     * 
     * @param operCode
     * @param operName
     * @param oldMenu
     * @param newMenu
     */
    private void menuOperLog(String operCode, String operName, Menu oldMenu, Menu newMenu) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        StringBuffer oldInfo = new StringBuffer();
        StringBuffer newInfo = new StringBuffer();
        if (oldMenu != null) {
            oldInfo.append("menuCode:" + oldMenu.getMenuCode());
            oldInfo.append("|menuName:" + oldMenu.getMenuName());
            oldInfo.append("|transCode:" + oldMenu.getTransCode());
        }
        if (newMenu != null) {
            newInfo.append("menuCode:" + newMenu.getMenuCode());
            newInfo.append("|menuName:" + newMenu.getMenuName());
            newInfo.append("|transCode:" + newMenu.getTransCode());
        }

        maintenanceLog.setNewInfo(newInfo.toString());
        maintenanceLog.setOldInfo(oldInfo.toString());
        maintenanceLog.setOperCode(operCode);
        maintenanceLog.setOperName(operName);
        maintenanceLog.setOperDesc(operName);
        maintenanceLogService.insert(maintenanceLog);
    }
}
