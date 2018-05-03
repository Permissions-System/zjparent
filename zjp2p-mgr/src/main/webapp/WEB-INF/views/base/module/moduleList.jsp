<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.my_td_label {
    padding-left:10px;
    width: 100px;
    height: 30px;
    text-align: left;
    font-size: 13px;
    nowrap:nowrap;
    // font-weight: bold;
}
.my_td_text {
    padding-left:5px;
    width: 150px;
    height: 30px;
    text-align:left;
}
.readonly{
    cursor:not-allowed;
    background-color:#eee;
}
.required{
    background-color:#FFFF80;
}
.fitem{
    height: 30px;
    margin-bottom:5px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout"  data-options="fit:true">
    <div data-options="region:'west',title:'模块树',split:true,collapsible:false"
        style="width: 265px;">
        <table style="width:100%;height:100%;">
            <tr>
                <td style="text-align:center; height:30px;">
                    <a id="reload" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">刷新</a>
                    <a id="add" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">增加</a>
                    <a id="update" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">修改</a>
                    <a id="delete" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
                </td>
            </tr>
            <tr>
                <td style="height:10px;"><hr /></td>
            </tr>
            <tr>
                <td style="text-align:left;width:100%; height:100%;vertical-align: top;">
                    <div id="treeModule" class="easyui-menu" style="width:120px;">
                        <div onclick="reloadModuleList()" data-options="iconCls:'icon-reload'">刷新</div>
                        <div onclick="addRootNode()" data-options="iconCls:'icon-add'">新增根结点</div>
                        <div onclick="deleteModuleNode()" data-options="iconCls:'icon-remove'">删除</div>
                        <div onclick="expandNode()" data-options="iconCls:''">展开</div>
                        <div onclick="expandAllNode()" data-options="iconCls:''">全部展开</div>
                        <div onclick="collapseNode()" data-options="iconCls:''">折叠</div>
                        <div onclick="collapseAllNode()" data-options="iconCls:''">全部折叠</div>
                    </div>
                    <ul id="moduleTree" class="easyui-tree" data-options="lines:true,animate:true,url:'${ctx}/base/module/rootTree'" >
                    </ul>
                </td>
            </tr>
        </table>
    </div>
    <div data-options="region:'center',title:'模块明细信息'"
        style="padding: 5px; background: #FFF;">
        <table>
            <tbody>
                    <tr>
                        <td class="my_td_label">模块编号:</td>
                        <td class="my_td_text"><input id="moduleCode" readonly='readonly' disabled="disabled" class="easyui-validatebox"></td>
                        <td class="my_td_text"></td>
                        <td class="my_td_label">模块名称:</td>
                        <td class="my_td_text"><input id="moduleName" readonly='readonly' disabled="disabled" class="easyui-validatebox" style="width: 200px;"></td>
                    </tr>
                    <tr>
                        <td class="my_td_label">模块状态:</td>
                        <td class="my_td_text">
                            <select id="moduleStatus" panelHeight="auto" disabled='disabled' class="easyui-combobox" name="moduleStatus">
                                <option value=""></option>
                                <option value="1">启用</option>
                                <option value="2">停用</option>
                            </select>
                        </td>
                        <td class="my_td_text"><input type="hidden" id="treepath" class="easyui-validatebox"></td>
                        <td class="my_td_label">上级模块:</td>
                        <td class="my_td_text"><input type="hidden" id="parentModuleCode" class="easyui-validatebox">
                                               <input id="parentModuleName" readonly='readonly' disabled="disabled" class="easyui-validatebox" style="width: 200px;"></td>
                    </tr>
            <tbody>
        </table>
    </div>
    <!-- 新增 编辑 的统一弹出框 -->
    <div id="itModuleInfoDlg" class="easyui-dialog" style="width:400px;height:350px;padding:20px 10px 10px 50px"
        data-options="resizable:false,modal:true" closed="true" buttons="#dlg-buttons">
        <form id="moduleForm" method="post" novalidate>
            <div class="fitem">
                <label for="idModuleCode">模块编号:</label>
                <input id="idModuleCode" name="moduleCode" style="width:200px;" class="easyui-validatebox" data-option="required:true" >
            </div>
            <div class="fitem">
                <label for="idModuleName">模块名称:</label>
                <input id="idModuleName" name="moduleName" style="width:200px;" class="easyui-validatebox" data-option="required:true"  >
            </div>
            <div class="fitem">
                <label for="idModuleStatus">模块状态:</label>
                <select id="idModuleStatus" panelHeight="auto" class="easyui-combobox" style="width:200px;" name="moduleStatus" style="width:155px;" data-option="editable:false,required:true">
                     <option value="1">启用</option>
                     <option value="2">停用</option>
                </select>
            </div>
            <div class="fitem">
                <label for="idParentModuleCode">上级模块:</label>
                <input id="idParentModuleCode" name="parentModuleCode" style="width:200px;" class="easyui-combotree" ">
            </div>
            <div class="fitem">
                <label for="idTreepath"></label>
               <input id="idTreepath" type="hidden" name="treepath" class="easyui-validatebox" >
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="btnModuleSave" >保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="btnModuleCancel">取消</a>
    </div>
    
    <div id="itModuleRootInfoDlg" class="easyui-dialog" style="width:360px;height:350px;padding:20px 10px 10px 50px"
        data-options="resizable:false,modal:true" closed="true" buttons="#dlg-root-buttons">
        <form id="moduleRootForm" method="post" novalidate>
            <div class="fitem">
                <label for="rModuleCode">模块编号:</label>
                <input id="rModuleCode" name="moduleCode" style="width:160px;" class="easyui-validatebox" data-option="required:true" >
            </div>
            <div class="fitem">
                <label for="rModuleName">模块名称:</label>
                <input id="rModuleName" name="moduleName" style="width:160px;" class="easyui-validatebox" data-option="required:true" >
            </div>
            <div class="fitem">
                <label for="rModuleStatus">模块状态:</label>
                <select id="rModuleStatus" panelHeight="auto" class="easyui-combobox" style="width:160px;" name="moduleStatus" style="width:155px;" data-option="editable:false,required:true">
                     <option value="1">启用</option>
                     <option value="2">停用</option>
                </select>
            </div>
            <div class="fitem">
                <label for="rParentModuleCode">上级模块:</label>
                <input id="rParentModuleCode" name="parentModuleCode" style="width:160px;" disabled="disabled" class="easyui-validatebox" >
            </div>
            <div class="fitem">
                <label for="rTreepath"></label>
                <input id="rTreepath" type="hidden" name="treepath" class="easyui-validatebox" >
            </div>
        </form>
    </div>
    <div id="dlg-root-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="btnRootSave" >保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="btnRootCancel">取消</a>
    </div>
    
</div>
<script type="text/javascript">
// 全局变量 控制弹出框是否打开
var isOpenFlag = "0";

$(document).ready(function() {
       // 绑定模块名称的keyUp事件
   $("#moduleName").keyup( function() {
           var selected =  $("#moduleTree").tree('getSelected');
           if(selected){
               var moduleName = $("#moduleName").val();
               selected.attributes.moduleName = moduleName;
               selected.attributes._modify_flag = true;
               updateTreeNoteName(selected);
           }
    });
       
    // 弹出框 保存那妞 处理 新增或修改结点数据的保存处理
    $("#btnModuleSave").bind("click", function(){
        saveModuleNodeInfo();
    });
   
    $("#btnRootSave").bind("click", function(){
        saveRootNodeInfo();
    });
    
    
    // 取消按钮 关闭 弹出框 并 将窗口开启标志 归 "0"
    $("#btnModuleCancel").bind("click", function(){
    	$('#itModuleInfoDlg').dialog('close');
    	isOpenFlag = "0";
    });
    
    $("#btnRootCancel").bind("click", function(){
        $('#itModuleRootInfoDlg').dialog('close');
        isOpenFlag = "0";
    });
    
    // 模板代码 限制输入字符类型
    $("#idModuleCode").keyup( function() {
        toUpperCase_onKeyUp($("#idModuleCode"));
    });
    
    // 模块名称特殊字符禁止输入处理 
    $("#idModuleName").keyup( function() {
        inputNameValue_onKeyUp($("#idModuleName"));
    });
    
    $("#rModuleCode").keyup( function() {
        toUpperCase_onKeyUp($("#rModuleCode"));
    });
    
    // 模块名称特殊字符禁止输入处理 
    $("#rModuleName").keyup( function() {
        inputNameValue_onKeyUp($("#rModuleName"));
    });
    
    // 类型Dialog弹出框关闭处理
    $('#itModuleInfoDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
    // 新增根模块 绑定Enter事件
    $('#itModuleRootInfoDlg').dialog({
        onOpen:function(){
            isOpenFlag = "ROOT";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
    requiredBox();
});

function requiredBox(){
	
    $('#rModuleCode').validatebox({    
        required: true
    });
    $('#rModuleName').validatebox({    
        required: true
    });
    
    
    // 控制下拉框只能选择，不可编辑
    $("#idModuleStatus").combobox({
        editable:false,
        required: true
    });

    $("#rModuleStatus").combobox({
        editable:false,
        required: true
    });

    $('#rParentModuleCode').validatebox({    
        required: true
    });
    
    $('#idModuleCode').validatebox({    
        required: true
    });
    $('#idModuleName').validatebox({    
        required: true
    });
    $('#idParentModuleCode').combotree({    
        required: true
    });
}

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
	// 保存按钮OJBJECT
	var btnOjb = $("#btnModuleSave");
	
	var btnRootSave = $("#btnRootSave");
	// 点击 Enter按钮
	if(event.keyCode == 13 && isOpenFlag =="1"){
		btnOjb.click();
		event.returnValue = false;
	}
	
	if(event.keyCode == 13 && isOpenFlag =="ROOT"){
		btnRootSave.click();
        event.returnValue = false;
    }
}


/**
 * 新增根结点
 */
function addRootNode(){
	
    $('#itModuleRootInfoDlg').dialog('open').dialog('setTitle','新增根模块');
    $('#moduleRootForm').form('clear');
    // 默认新增 模块状态 选择启用
    $('#rModuleStatus').combobox('setValue', '1');
    
    $('#rParentModuleCode').val("ROOT");
}

/**
 * 保存跟结点
 */
function saveRootNodeInfo(){
   if(!ckNotNullRootInfo()){
        return;
    }

   jQuery.ajax({
       type : "POST",
       async: false,
       url : "${ctx}/base/module/insert",
       data : {
           moduleCode: $("#rModuleCode").val(),
           moduleName: $("#rModuleName").val(),
           moduleStatus: $("#rModuleStatus").combobox('getValue'),
           parentModuleCode:"ROOT",
           treepath:$("#rModuleCode").val()
       },
       success : function(data) {
          if(data.result=='exist'){
              showSlideMessage("模块代码已存在，请确认！");
          }else if(data.result=='success'){
              
              $('#itModuleRootInfoDlg').dialog('close'); 
              
              showSlideMessage("保存成功");
              $('#moduleTree').tree('reload');
              isOpenFlag = "0";
          }else{
              showSlideMessage("保存失败");
          }
       },
       error : function(data) {
           //承接来自Service抛出的JSR303 异常信息
           var jsonStr= eval("("+data.responseText+")");
           showSlideMessage("保存数据发生异常！"+jsonStr.string);
           isOpenFlag = "0";
       },
       datatype : "json"
   });
   
   
}

//单独校验跟结点
function ckNotNullRootInfo(){
    var val = "",ct=0;
    
    val = $("#rModuleCode").val();
    if(isNull(val)){
        showSlideMessage("请输入模块编号！");
        ct++;
        return false;
    }
    // 对于新增按钮 text自带的内容的处理
    // 对于输入的编码如果出现ROOT 则不允许提交
    if(val=="ROOT"){
        showSlideMessage(" ROOT 为根节点专用编码，请输入其他编码！");
        ct++;
        return false;
    }
    // 模块编号长度必须为1至10
    if(val.length<=0 || val.length>9){
        showSlideMessage("模块编号长度应不超过9个字符,请确认！");
        ct++;
        return false;
    }
    val = $("#rModuleName").val();
    if(isNull(val)){
        showSlideMessage("请输入 模块名称 ！");
        ct++;
        return false;
    }
    // 模块名称长度必须为1至32
    if(val.length<=0 || val.length>20){
        showSlideMessage("模块名称长度不应超过20个字符,请确认！");
        ct++;
        return false;
    }
    
    // 模块状态 
    val = $("#rModuleStatus").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择 模块状态 ！");
        ct++;
        return false;
    }
	
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}


/**
 * 保存按钮处理 新增或修改数据的保存
 */
function saveModuleNodeInfo(){

	if(!ckNotNullModuleInfo()){
		return;
	}
    
    var action = $('#btnModuleSave').data("action");
    if(action=='insert'){
        var parentModuleCode = $("#idParentModuleCode").combotree('getValue');
    	var treepath = $('#idTreepath').val();
    	
        // AJAX 提交
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/module/insert",
            data : {
                moduleCode: $("#idModuleCode").val(),
                moduleName: $("#idModuleName").val(),
                moduleStatus: $("#idModuleStatus").combobox('getValue'),
                parentModuleCode:parentModuleCode,
                treepath:treepath + $("#idModuleCode").val()
            },
            success : function(data) {
               if(data.result=='exist'){
                   showSlideMessage("模块代码已存在，请确认！");
               }else if(data.result=='success'){
                   // close dialog
                  
                   // 添加该结点数据到左边的树
                   moduleNodeData = {};
                   moduleNodeData.id = $('#idModuleCode').val();
                   moduleNodeData.text = $('#idModuleName').val();
                   moduleNodeData.attributes = {};
                   moduleNodeData.attributes.moduleCode = $('#idModuleCode').val();
                   moduleNodeData.attributes.moduleName = $('#idModuleName').val();
                   moduleNodeData.attributes.moduleStatus = $("#idModuleStatus").combobox('getValue');
                   moduleNodeData.attributes.treepath = treepath + $("#idModuleCode").val();
                   moduleNodeData.attributes.parentModuleCode = parentModuleCode;
                   moduleNodeData.attributes._modify_flag = false;
                   moduleNodeData.attributes._from_server_flag = true;
                   
                   addNodeToTree(moduleNodeData);
                   
                   $('#itModuleInfoDlg').dialog('close'); 
                   
                   showSlideMessage("保存成功");
                   isOpenFlag = "0";
               }else{
            	   showSlideMessage("保存失败");
               }
            },
            error : function(data) {
                //承接来自Service抛出的JSR303 异常信息
                var jsonStr= eval("("+data.responseText+")");
                showSlideMessage("保存数据发生异常！"+jsonStr.string);
                isOpenFlag = "0";
            },
            datatype : "json"
        });
    	
    }else{
    	// 修改
    	var selected =  $("#moduleTree").tree('getSelected');
    	if(!selected){
    		showSlideMessage("请选择需要修改的模块！");
    		return ;
    	}
    	
    	// 判断数据是否变更 考虑到 上级模块选择会导致
    	// 判断页面的数据 模块名称 moduleName,模块状态 moduleStatus,上级模块 parentModuleCode
    	// 和选中结点的 数据比较 是否发生边哈
    	if(!isModifiedModuleNodeData(selected)){
            showSlideMessage("模块信息没有修改，无需更新！");
            return ;
    	}
    	
    	// 对于变更内容，区分内容为 两组   模块名称和模块状态为一组，上级模块为一组 对其是否变化 独立判断
        var modParentCode = '0';
        var dlgModuleName = $('#idModuleName').val();
        var dlgModuleStatus = $('#idModuleStatus').combobox('getValue');
        var dlgParentModuleCode = $("#idParentModuleCode").combotree('getValue');
        if(selected.attributes.moduleName == dlgModuleName &&
        		selected.attributes.moduleStatus == dlgModuleStatus){
        	// 完全无变化
        	modNameStatus = '0';
        }else{
        	// 两者的数据 有变化
        	modNameStatus = '1';
        }
        
        // 上级结点是否发生变化
        if(selected.attributes.parentModuleCode==dlgParentModuleCode){
        	modParentCode = '0';
        }else{
        	modParentCode = '1';
        }
        
        if(modParentCode=='1'){
        	// 跟结点(parentModuleCode=='ROOT')不允许移动
        	if(selected.attributes.parentModuleCode=='ROOT'){
        		showSlideMessage("根节点的上级结点不可变更，请确认！");
        		return ;
        	}
        	
        	// 如果变更的代码是其本身 及 其子结点的选择，不支持做这样的上级结点的变更
        	if(selected.attributes.moduleCode==dlgParentModuleCode){
        		showSlideMessage("不能变更上级结点为模块本身，请确认！");
                return ;
        	}
        	var updFlag= "0";
        	// 如果 修改结点的上级结点选择了 该结点下的子结点获取更深层的结点，也不能支持其变更行为
            jQuery.ajax({
                type : "POST",
                async: false,
                url : "${ctx}/base/module/cracleUpdate",
                data : {
                	parentModuleCode :dlgParentModuleCode,
                    moduleCode: selected.attributes.moduleCode
                },
                success : function(data) {
                   if(data.message=='1'){
                	   updFlag = "1";
                   }
                },
                error : function(data) {
                     showSlideMessage("查询失败！");
                     updFlag = "2";
                },
                datatype : "json"
            });
        	
        	if(updFlag=="1"){
                showSlideMessage("修改结点的上级不能选择该结点的子孙结点，请确认");
                return ;
        		
        	}else if(updFlag=="2"){
        		showSlideMessage("数据访问异常，请刷新页面！");
        		return ;
        	}
        	
        }

        // AJAX 提交
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/module/update",
            data : {
            	modParentCode :modParentCode,
                moduleCode: $("#idModuleCode").val(),
                moduleName: $("#idModuleName").val(),
                moduleStatus: $("#idModuleStatus").combobox('getValue'),
                parentModuleCode:dlgParentModuleCode,
                treepath:$('#idTreepath').val()
            },
            success : function(data) {
                 if(data.result=='success'){
                   // close dialog
                   if(modParentCode=='0'){
                	   // 只修改了名称和状态的情况
                	   selected.text = $("#idModuleName").val();
                	   selected.attributes.moduleName = $("#idModuleName").val();
                	   selected.attributes.moduleStatus = $("#idModuleStatus").combobox('getValue');
                	   updateTreeNoteName(selected);
                	   moduleTree.tree('select', selected.target);
                   }else{
                	   // load整个树
                	   $('#moduleTree').tree('reload');
                	   // 该查询无效 查找不到结点
                	   var treeNode = $('#moduleTree').tree('find', selected.id);
	               	   if(treeNode){
	               	       $('#moduleTree').tree('expandTo', treeNode.target);
	               	       $('#moduleTree').tree('select', treeNode.target);
	               	   }
	               	   clearShowDetails();
                   }
                   
                   $('#itModuleInfoDlg').dialog('close'); 
                   showSlideMessage("修改成功");
               }else{
                   showSlideMessage("修改异常！");
               }
            },
            error : function(data) {
                //承接来自Service抛出的JSR303 异常信息
                var jsonStr= eval("("+data.responseText+")");
                showSlideMessage("修改数据发生异常！"+jsonStr.string);
            },
            datatype : "json"
        });
    }
}

/**
 * 清空右边展示区域的显示结果
 */
function clearShowDetails(){
    $('#moduleCode').val('');
    $('#moduleName').val('');
    $('#treepath').val('');
    $('#moduleStatus').combobox('setValue', '');
    $('#parentModuleCode').val('');
    $('#parentModuleName').val('');
}

/**
 * 用于判断 结点数据是否真正做了修改
 */
function isModifiedModuleNodeData(selectNode){
	var dlgModuleName = $('#idModuleName').val();
	var dlgModuleStatus = $('#idModuleStatus').combobox('getValue');
	var dlgParentModuleCode = $("#idParentModuleCode").combotree('getValue');
	
	if(selectNode.attributes.moduleName == dlgModuleName &&
			selectNode.attributes.moduleStatus == dlgModuleStatus &&
			selectNode.attributes.parentModuleCode == dlgParentModuleCode){
		// treepath 隐藏不做判断依据 只要parentModule未变化 treepath不变
		return false;
	}else{
		return true;
	}
}

//插入菜单树节点
function addNodeToTree(nodeData){
    if(!nodeData){
        return;
    }
    if(nodeData.attributes.parentModuleCode!='ROOT'){
        // 获取父节点
        var parentNode = $('#moduleTree').tree('find', nodeData.attributes.parentModuleCode);
        if(parentNode){
            $('#moduleTree').tree('append', {
                parent: parentNode.target,
                data: [nodeData]
            });
        } else {
        	showSlideMessage("请刷新模块树！");
        }
    } else {
        $('#moduleTree').tree('append', {
            data: [nodeData]
        });
    }
    // 定位到指定节点
    var treeNode = $('#moduleTree').tree('find', nodeData.attributes.moduleCode);
    if(treeNode){
        $('#moduleTree').tree('expandTo', treeNode.target);
        $('#moduleTree').tree('select', treeNode.target);
    }
}

/**
 * 新增 或修改 弹出框 处理 空内容校验
 */
function ckNotNullModuleInfo(){
     var val = "",ct=0;
     
     val = $("#idModuleCode").val();
     if(isNull(val)){
         showSlideMessage("请输入模块编号！");
         ct++;
         return false;
     }
     // 对于新增按钮 text自带的内容的处理
     // 对于输入的编码如果出现ROOT 则不允许提交
     if(val=="ROOT"){
         showSlideMessage(" ROOT 为根节点专用编码，请输入其他编码！");
         ct++;
         return false;
     }
     // 模块编号长度必须为1至10
     if(val.length<=0 || val.length>9){
         showSlideMessage("模块编号长度应不超过9个字符,请确认！");
         ct++;
         return false;
     }
     val = $("#idModuleName").val();
     if(isNull(val)){
         showSlideMessage("请输入 模块名称 ！");
         ct++;
         return false;
     }
     // 模块名称长度必须为1至32
     if(val.length<=0 || val.length>20){
         showSlideMessage("模块名称长度不应超过20个字符,请确认！");
         ct++;
         return false;
     }
     
     // 模块状态 
     val = $("#idModuleStatus").combobox('getValue');
     if(isNull(val)){
         showSlideMessage("请选择 模块状态 ！");
         ct++;
         return false;
     }
     
     // 上级模块编码 选择控制
     val = $("#idParentModuleCode").combotree('getValue');
     if(isNull(val)){
         showSlideMessage("请选择 上级模块 ！");
         ct++;
         return false;
     }
     
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}

/**
 * 绑定下拉框数据
 */
function bindingParentModuleCode(){
	var action = $('#btnModuleSave').data("action");
    $('#idParentModuleCode').combotree({
        lines:true,
        animate:true,
        url:'${ctx}/base/module/rootTree',
        onSelect: function(node){
            // 选中时，联动设置 $(idTreepath).val()
            // 新增页面 选择时间 idTreepath val 只绑定到 父一级结点 在保存时 增加输入框的数据
            if(action=='insert'){
                var selectParentTreepath = node.attributes.treepath + '/';
                $('#idTreepath').val(selectParentTreepath);
                // 选中时，取货选择父级模块结点编码 $(idParentModuleCode).val
            }else{
            	// 修改状态下 由于编辑弹出框的 的模块代码输入框不可编辑，变更treepath值直接改变到 模块代码自身
            	 var selectParentTreepath = node.attributes.treepath + '/';
                 $('#idTreepath').val(selectParentTreepath + $('#idModuleCode').val());
            }
        }
    });
}

/**
 * 新增弹出框 新增模块结点的dialog
 */
function addModuleNodeInfo(){
    $('#itModuleInfoDlg').dialog('open').dialog('setTitle','新增模块');
    $('#moduleForm').form('clear');
    // 默认新增 模块状态 选择启用
    $('#idModuleStatus').combobox('setValue', '1');
    // 保存按钮暂存数据 Insert
    $('#btnModuleSave').data("action","insert");
    // 下拉删除 只读属性
    $('#idModuleCode').removeAttr('readonly');
    //$('#idModuleCode').removeAttr('disabled');
    // 弹出页面打开 加载下拉tree数据
    bindingParentModuleCode();
    
    isOpenFlag = "1";
}

/**
 * 填出页面修改结点属性事件
 */
function updateModuleNodeInfo(){
    // 选择一个树节点
    var selected = $('#moduleTree').tree('getSelected');
    if(!selected){
        // 如果没有任何选中节点，请选择需要修改的模块信息
        showSlideMessage("请选择需要修改的模块信息!");
        return;
    }

    // 打开弹出框
    $('#itModuleInfoDlg').dialog('open').dialog('setTitle','修改模块');
    $('#btnModuleSave').data("action","update");
    $('#moduleForm').form('clear');
    // banding下来列表
    bindingParentModuleCode();

    //将选中的模块结点数据属性 赋值到弹出的Dialog
    $('#idModuleCode').val(selected.attributes.moduleCode);
    $('#idModuleCode').attr('readonly','readonly');
    //$('#idModuleCode').attr('disabled','disabled');
    $('#idModuleName').val(selected.attributes.moduleName);
    $('#idTreepath').val(selected.attributes.treepath);
   
    $('#idModuleStatus').combobox('setValue', selected.attributes.moduleStatus);
    $('#idParentModuleCode').combotree('setValue',selected.attributes.parentModuleCode);
    isOpenFlag = "1";
}
</script>

<script type="text/javascript">
var moduleTree = null;// 模块树对象
var treeNodeId = 0;//模块节点ID,为模块节点编号
var newTreeNodeCount = 0;//新建模块节点计数器
var eventSwitcher = true;// 事件开关,控制onchange事件，所有onchangge事件务必判断该字段
/**
 * 将前台VO转为tree能识别的Data
 * voArray为服务端返回的domain列表json数组，如List<Module>
 * param指定要设置为模块树显示值得字段  ，列如 ['moduleCode']
 */
function voToTreeNodeData(voArray, param){
    if(voArray==null || voArray.length<1){
        return null;
    }
    
    function treeNode(tree){
        this.id = treeNodeId++;// 节点ID自增
        this.text = null;
        this.state = "closed";// 默认来自服务端的节点都有子节点
        this.attributes = {};
    }
    
    var resultArray = new Array();
    for(var i in voArray){
        var a = new treeNode();
        a.text = voArray[i][param[0]];
        a.attributes = voArray[i];// 将domain数据添加到节点属性中
        a.attributes._from_server_flag = true;//标记数据是否来自服务端
        a.attributes._modify_flag = false;//标记数据是否被编辑
        resultArray.push(a);
    }
    return resultArray;
}

/**
 * 取出模块节点信息注入明细界面
 * 修改上级模块名称的取值，对于顶级根结点的的上级结点 其名称固定为ROOT
 */
function takeOutTreeNodeInfo(node){
    // 先关闭事件开关
    eventSwitcher = false;
    
    // 复制模块节点数据到模块明细
    if(node && node.attributes){
        $('#moduleCode').val(node.attributes.moduleCode);
        $('#moduleName').val(node.attributes.moduleName);
        $('#treepath').val(node.attributes.treepath);
        $('#moduleStatus').combobox('setValue', node.attributes.moduleStatus);
        $('#parentModuleCode').val(node.attributes.parentModuleCode);

        var parentNode = moduleTree.tree('getParent', node.target);
        if(parentNode){
            $('#parentModuleName').val(parentNode.attributes.moduleName);
            
        }else{
            // 若上级结点属于 结点根一级的结点 ，即parentModuleCode = "ROOT" 
            // 该数据在表中没有对应的记录，因此查不到其名字,所以指定名称为 ROOT
            $('#parentModuleName').val('ROOT');
        }
        //setReadonly('parentModuleName', true);
        
        if(node.attributes._from_server_flag){
            // 来自服务端的数据不允许修改模块编号
            //setRequired('moduleCode', false);
            //setReadonly('moduleCode', true);
        } else {
            //setReadonly('moduleCode', false);
            //setRequired('moduleCode', true);
        }
    } else {
        $('#moduleCode').val('');
        $('#moduleName').val('');
        $('#treepath').val('');
        $('#moduleStatus').combobox('setValue', '');
        $('#parentModuleCode').val('');
    }
    
    // 打开事件开关
    eventSwitcher = true;
}

// Ajax查询，获取模块根节点列表
function getRootModuleList(sucessFunc, errorFunc, showProcessBar) {
    // 开启进度条
    if(showProcessBar==true){
        
    }
    jQuery.ajax({
        type : 'POST',
        async: true,//注意：异步查询
        url : '${ctx}/base/module/getRootModuleList',
        data : {
        },
        success : function(data, status) {
            sucessFunc(data, status);
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        error : function(data, status) {
            errorFunc(data, status);
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        datatype : "json"
    });
}
// Ajax查询，获取指定模块的子节点列表
function getSubModuleList(moduleCode, sucessFunc, errorFunc, showProcessBar) {
    // 开启进度条
    if(showProcessBar==true){
        
    }
    jQuery.ajax({
        type : 'POST',
        async: false,//务必使用同步请求，否则模块展开会有问题
        url : '${ctx}/base/module/getSubModuleList',
        data : {
            moduleCode: moduleCode
        },
        success : function(data, status) {
            if(sucessFunc){
                sucessFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        error : function(data, status) {
            if(sucessFunc){
                errorFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        datatype : "json"
    });
}

// Ajax请求, 保存模块信息
function saveModuleInfo(moduleNode, sucessFunc, errorFunc, showProcessBar) {
    // 开启进度条
    if(showProcessBar==true){
        
    }
    jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/module/saveModuleInfo",
        data : {
            moduleCode: moduleNode.attributes.moduleCode,
            moduleName: moduleNode.attributes.moduleName,
            treepath: moduleNode.attributes.treepath,
            moduleStatus: moduleNode.attributes.moduleStatus,
            parentModuleCode: moduleNode.attributes.parentModuleCode
        },
        success : function(data, status) {
            if(sucessFunc){
                sucessFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        error : function(data, status) {
            if(errorFunc){
                errorFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        datatype : "json"
    });
}
// Ajax请求，更新模块信息
function updateModuleInfo(moduleNode, sucessFunc, errorFunc, showProcessBar) {
    // 开启进度条
    if(showProcessBar==true){
        
    }
    jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/module/updateModuleInfo",
        data : {
            moduleCode: moduleNode.attributes.moduleCode,
            moduleName: moduleNode.attributes.moduleName,
            treepath: moduleNode.attributes.treepath,
            moduleStatus: moduleNode.attributes.moduleStatus,
            parentModuleCode: moduleNode.attributes.parentModuleCode
        },
        success : function(data, status) {
            if(sucessFunc){
                sucessFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        error : function(data, status) {
            if(errorFunc){
                errorFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        datatype : "json"
    });
}
// Aiax请求， 删除模块信息
function deleteModuleInfo(moduleCode, sucessFunc, errorFunc, showProcessBar) {
    // 开启进度条
    if(showProcessBar==true){
        
    }
    jQuery.ajax({
        type : 'POST',
        url : '${ctx}/base/module/deleteModuleInfo',
        data : {
            moduleCode: moduleCode
        },
        success : function(data, status) {
            if(sucessFunc){
                sucessFunc(data, status);
                clearInputNoteDetails();
            }
            $.messager.show({
				title:'提示信息',
				msg:'删除成功！',
				timeout:5000,
				showType:'slide'
			}); 
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        error : function(data, status) {
            if(sucessFunc){
                errorFunc(data, status);
            }
            // 关闭进度条
            if(showProcessBar==true){
                
            }
        },
        datatype : "json"
    });
}

/**
 * 清楚数据
 */
function clearInputNoteDetails(){
    $('#moduleCode').val('');
    $('#moduleName').val('');
    $('#treepath').val('');
    $('#moduleStatus').combobox('setValue', '');
    $('#parentModuleCode').val('');
    $('#parentModuleName').val('');
    //setReadonly('moduleCode', false);
    //setRequired('moduleCode', true);
    //setReadonly('parentModuleName', false);
}

// 新增兄弟模块节点
function addSiblingModuleNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        // 如果没有任何选中节点，则默认创建模块根节点
        addRootModuleNode();
        return;
    }
    // 获取父节点,如果父节点不存在则直接新增根节点，否则新增兄弟节点
    var parentNode = moduleTree.tree('getParent', selected.target);
    if(parentNode){
        addSubModuleNodeSpecParent(parentNode);
    } else {
        addRootModuleNode();
    }
}

// 新增根模块节点
function addRootModuleNode(){
    var newId = treeNodeId++;
    newTreeNodeCount++;
    moduleTree.tree('append', {
        data: [{
            id: newId,
            text: '新建模块节点('+newTreeNodeCount+')',
            state: 'open',// 手动新增节点默认为叶子节点
            attributes:{
                moduleCode:'',
                moduleName: '新建模块节点('+newTreeNodeCount+')',
                treepath: '',
                moduleStatus :'1',
                parentModuleCode: 'ROOT',//根节点必须指定该父节点编号为ROOT
                _from_server_flag: false,
                _modify_flag: true //手动新增节点默认为已编辑节点
            }
        }]
    });
    // 跳转本次新增节点
    var newNode = moduleTree.tree('find', newId);
    moduleTree.tree('select', newNode.target);
}

/**
 * 新增子模块节点
 * parentNode 父模块节点
 */
function addSubModuleNodeSpecParent(parentNode){
    if(!parentNode){
        return;
    }
    // 要求保存父节点后才能新增子节点
    if(!parentNode.attributes._from_server_flag){
        showSlideMessage("请先保存当前模块节点！");
        //jQuery.messager.alert('警告信息','请先保存当前模块节点！','warning');
        return;
    }
    // 如果父节点没有展开,且尚未加载数据，则从服务端下载子模块数据
    if(parentNode.state=='closed'){
        var children = moduleTree.tree('getChildren', parentNode.target);
        if(!children || children.length==0){
            loadSubModuleList(parentNode);
        }
    }
    var newId = treeNodeId++;
    newTreeNodeCount++;
    moduleTree.tree('append', {
        parent: parentNode.target,
        data: [{
            id: newId,
            text: '新建模块节点('+newTreeNodeCount+')',
            state: 'open',
            attributes:{
                moduleCode:'',
                moduleName: '新建模块节点('+newTreeNodeCount+')',
                moduleStatus :'1',
                parentModuleCode: parentNode.attributes.moduleCode,
                _from_server_flag: false,
                _modify_flag: true
            }
        }]
    });
    // 展开父节点
    moduleTree.tree('expand', parentNode.target);
    // 选中本次新增节点
    var newNode = moduleTree.tree('find', newId);
    moduleTree.tree('select', newNode.target);
}

// 新增子模块节点
function addSubModuleNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择模块节点！");
        //jQuery.messager.alert('提示信息','请选择模块节点!','info');
        return;
    }
    addSubModuleNodeSpecParent(selected);
}

// 展开节点
function expandNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择模块节点！");
        //jQuery.messager.alert('提示信息','请选择模块节点!','info');
        return;
    } else {
        moduleTree.tree('expand', selected.target);
    }
}

//展开所有节点
function expandAllNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择模块节点！");
        //jQuery.messager.alert('提示信息','请选择模块节点!','info');
        return;
    } else {
        expandAllNodeRecur(selected);
        moduleTree.tree('expandAll', selected.target);
    }
}

/**
 * 递归加载子模块数据并展开模块树
 * 
 * 如果模块下已有子模块，则不再从服务器端下载数据,减少数据查询次数
 */
function expandAllNodeRecur(node){
    // 叶子节点无需处理
    if(moduleTree.tree('isLeaf', node.target)){
        return;
    }
    var children = moduleTree.tree('getChildren', node.target);
    if(!children || !children.length || children.length<1){
        loadSubModuleList(node);
        children = moduleTree.tree('getChildren', node.target);
        if(!children || !children.length || children.length<1){
            return;
        }
    }
    for(var i in children){
        // 只有来自服务端的节点才展开，前提条件是：所有节点在添加子节点前必须保存到服务端
        if(children[i].attributes._from_server_flag){
            expandAllNodeRecur(children[i]);
        }
    }
}

// 折叠节点
function collapseNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择模块节点！");
        //jQuery.messager.alert('提示信息','请选择模块节点!','info');
        return;
    } else {
        moduleTree.tree('collapse', selected.target);
    }
}

//折叠所有节点
function collapseAllNode(){
    var selected = $('moduleTree').tree('getSelected');
    if(!selected){
    	 var roots = $('#moduleTree').tree('getRoots');
         for(var i in roots){
             $('#moduleTree').tree('collapseAll', roots[i].target);
         }
    } else {
        moduleTree.tree('collapseAll', selected.target);
    }
}

// 删除模块节点
function deleteModuleNode(){
    // 判断是否提交到服务器端
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择需要删除的模块节点！");
        //jQuery.messager.alert('提示信息','请选择需要删除的模块节点！','info');
        return;
    }
    // 如果还有模块子节点，则不允许删除
    var children = moduleTree.tree('getChildren', selected.target);
    if(children && children.length>0){
        showSlideMessage("模块下还有子节点，不允许删除！");
        //jQuery.messager.alert('警告信息','模块下还有子节点，不允许删除！','warning');
        return;
    } else {
        // 到服务端查询子模块列表
        getSubModuleList(selected.attributes.moduleCode, 
            function(data, status) {
                if(data && data.result && data.result.length>0){
                    reloadData(voToTreeNodeData(data.result, ['moduleName']), selected);
                    showSlideMessage("模块下还有子节点，不允许删除！");
                    //jQuery.messager.alert('警告信息','模块下还有子节点，不允许删除！','warning');
                    return;
                } else {
                     var exitFlag = true; 
                     $.ajax({
                      type:"GET",
                      url:"${ctx}/base/module/ckTransModuleCode",
                      async:false,
                      data:{
                          moduleCode:selected.attributes.moduleCode
                     },
                     success:function(data){
                         if(data.count>0){
                             exitFlag = true;
                         }else{
                             exitFlag = false;
                         }
                     }
                  });
                    // 根据模块编码获取该模块下配置的 交易信息
                    if(exitFlag){
                         showSlideMessage("该模块已配置交易信息，如需删除，请先删除关联的交易信息！");
                         return;
                    }
                    
                    jQuery.messager.confirm('确认信息','确定删除模块节点?',function(event){
                        if(event){
                             deleteModuleInfo(selected.attributes.moduleCode,
                                 function(data, status){
                                     moduleTree.tree('remove', selected.target);
                                 },
                                 function(data, status){
                                     showSlideMessage("模块节点删除失败: " + data.responseText.string);
                                     //jQuery.messager.alert('错误信息','模块节点删除失败:'+data.responseText.string,'error');
                                 });
                        }
                    });
                }
            },
            function(data, status) {
                showSlideMessage("获取模块数据失败: " + data.responseText.string);
                //jQuery.messager.alert('错误信息','获取模块数据失败:'+data.responseText.string,'error');
            });
    }
}

// 刷新 
function reloadModuleList(){
	$('#moduleTree').tree('reload');
	/**
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        // 获取模块root列表
        //loadRootModuleList();
        // 整个树reload
    	$('#moduleTree').tree('reload');
    } else {
        // 刷新模块子节点
        loadSubModuleList(selected);
    }
    **/
}

// 刷新模块列表
function reloadData(data, node){
    if(data){
        if(node){
            var children = moduleTree.tree('getChildren', node.target);
            if(children && children.length && children.length>0){
                for(var i in children){
                    //删除所有来自服务端的子节点,保留客户端新增未保存的子节点
                    if(children[i].attributes._from_server_flag){
                        moduleTree.tree('remove', children[i].target);
                    }
                }
            }
            moduleTree.tree('append', {
                        parent: node.target,
                        data: data
                        });
            // 如果节点没有展开，则展开父节点
            // moduleTree.tree('expand', node.target);
        } else {
            moduleTree.tree('loadData', data);
        }
    } else {
        // 没有子模块数据,则将展开图标去除,通过增加节点、删除节点实现
        var newId = treeNodeId++;
        moduleTree.tree('append', {
            parent: node.target,
            data: [{
                id: newId,
                text: 'temp'
            }]
        });
        var newNode = moduleTree.tree('find', newId);
        moduleTree.tree('remove', newNode.target);
    }
}

// 加载根模块节点
function loadRootModuleList(){
    getRootModuleList(function(data, status) {
            reloadData(voToTreeNodeData(data.result, ['moduleName']), null);
        },
        function(data, status) {
            showSlideMessage("获取根模块数据失败: "+ data.responseText.string);
            //jQuery.messager.alert('错误信息','获取根模块数据失败:'+data.responseText.string,'error');
        });
}

// 加载子模块列表，从服务端获取数据
function loadSubModuleList(node){
    if(!node || !node.attributes || !node.attributes.moduleCode){
        return;
    }
    getSubModuleList(node.attributes.moduleCode,
            function(data, status) {
                reloadData(voToTreeNodeData(data.result, ['moduleName']), node);
            },
            function(data, status) {
                showSlideMessage("获取根模块数据失败: "+ data.responseText.string);
                //jQuery.messager.alert('错误信息','获取模块数据失败:'+data.responseText.string,'error');
            });
}

// 统一弹出侧边消息提示
function showSlideMessage(msg){
    $.messager.show({
        title:'提示',
        msg:msg,
        timeout:4000,
        showType:'slide'
    });
}

/**
 * 验证右边数据非空
 */
function checkIsModiNodeAttr(){
    var val = "",ct=0;
    // 模块编码 非空 模块编码 内容 不是默认的 “新建模块”等内容
    val = $("#moduleCode").val();
    if(isNull(val)){
        showSlideMessage("请输入 模块编号 ！");
        ct++;
        return false;
    }
    // 对于新增按钮 text自带的内容的处理
    // 对于输入的编码如果出现ROOT 则不允许提交
    if(val=="ROOT"){
        showSlideMessage(" ROOT 为根节点专用编码，请输入其他编码！");
        ct++;
        return false;
    }
    // 模块编号长度必须为1至10
    if(val.length<=0 || val.length>9){
        showSlideMessage("模块编号长度必须为1至9,请确认！");
        ct++;
        return false;
    }
    val = $("#moduleName").val();
    if(isNull(val)){
        showSlideMessage("请输入 模块名称 ！");
        ct++;
        return false;
    }

    
    // 模块名称长度必须为1至32
    if(val.length<=0 || val.length>=32){
        showSlideMessage("模块名称长度必须为1至32,请确认！");
        ct++;
        return false;
    }
    
    val = $("#moduleStatus").val();

    if(isNull(val)){
        showSlideMessage("请选择 模块状态 ！");
        ct++;
        return false;
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}

/*检测 选择节点的各项属性
 *   moduleName, moduleStatus ,treepath
 *   与右边输入部分的 数据是否一致
     id与
 */
function checkIsModifiedNodeAttrs(node){

    // 新增记录 无 是否修改标志  false
    // 该节点是服务器端数据，即非新增 比较 
    if(node.attributes._from_server_flag){
        // 模块名称
        var fModuleName = $("#moduleName").val();
        // 模块路径
        var fTreepath = $("#treepath").val();
        var fModuleStatus = $("#moduleStatus").val();
        if(node.attributes._modify_flag){
            return false;
        }
        //三者完全一致 内容未修改
        if(fModuleName==node.attributes.moduleName 
                && fTreepath== node.attributes.treepath
                && fModuleStatus== node.attributes.moduleStatus){
            // 数据没有发生变化
            return true;
        }
    }
    return false;
} 

// 保存前检查数据
function checkBeforeSave(node){

    /**
    if(!node || node.attributes){
        jQuery.messager.alert('警告信息','保存失败:模块信息为空，不能保存！','warning');
        return false;
    }
    **/
    return checkIsModiNodeAttr();
    // 校验数据的数据来源 更改为取自 右边 文本框的内容
    
    
    /**
    var moduleCode = node.attributes.moduleCode;
    if(moduleCode==null || moduleCode.length==0 || moduleCode.indexOf('新建模块节点', 0)>=0){
        jQuery.messager.alert('警告信息','保存失败:模块编号未填写，不能保存！','warning');
        return false;
    } else if(moduleCode.length<=0 || moduleCode.length>=10){
        jQuery.messager.alert('警告信息','保存失败:模块编号长度必须为1至10！','warning');
        return false;
    }
    var moduleName = node.attributes.moduleName;
    if(!moduleName || moduleName.length==0 || moduleName.indexOf('新建模块节点', 0)>=0){
        jQuery.messager.alert('警告信息','保存失败:模块名称未填写，不能保存！','warning');
        return false;
    } else if(moduleName.length<=0 || moduleName.length>=32){
        jQuery.messager.alert('警告信息','保存失败:模块名称长度必须为1至32！','warning');
        return false;
    }
    var moduleStatus = node.attributes.moduleStatus;
    if(!moduleStatus || moduleStatus.length==0){
        jQuery.messager.alert('警告信息','保存失败:模块状态必输设置！','warning');
        return false;
    }

    return true;
     **/
}

// 保存模块信息
function saveModuleNode(){
    var selected = moduleTree.tree('getSelected');
    if(!selected){
        showSlideMessage("请选择需要保存的节点！");
        //jQuery.messager.alert('提示信息','请选择需要保存的节点！','info');
        return;
    }
    if(!checkBeforeSave(selected)){
        return;
    }
    // 数据来自服务器，即是已经存在数据，区分页面新增加的数据
    if(selected.attributes._from_server_flag){
        if(checkIsModifiedNodeAttrs(selected)){
            showSlideMessage("模块信息没有修改，无需更新！");
            //jQuery.messager.alert('提示信息','模块信息没有修改，无需更新！','info');
            return;
        }
        
        // 将变更数据添加到SelectedNoote 结点上  涉及字段 模块名称,模块状态, 模块路径
        selected.attributes.moduleName = $("#moduleName").val();
        selected.attributes.moduleStatus = $("#moduleStatus").val();
        selected.attributes.treepath = $("#treepath").val();

        updateModuleInfo(selected,
                function(data, status) {
                    selected.attributes._modify_flag = false;
                    selected.attributes._from_server_flag = true;
                    showSlideMessage("更新成功！");
                    updateTreeNoteName(selected);
                    //jQuery.messager.alert('提示信息','更新成功！','info');
                },
                function(data, status) {
                    showSlideMessage("更新失败！");
                    //jQuery.messager.alert('错误信息','更新失败！'+data.responseText.string,'error');
                });
    } else {
        
        selected.attributes.moduleCode = $("#moduleCode").val();
        selected.attributes.moduleName = $("#moduleName").val();
        selected.attributes.moduleStatus = $("#moduleStatus").val();
        // treepath 路径 取上级结点 的treepath 如果 上级结点的 treepath属性 为空 则 取隐藏的 页面 moduleCode值
        var parentNode = moduleTree.tree('getParent', selected.target);
        if(parentNode){
            // 能找到上级结点的
            if(isNotNull(parentNode.attributes.treepath)){
                $("#treepath").val(parentNode.attributes.treepath +'/' + $("#moduleCode").val());
            }else{
                $("#treepath").val($("#moduleCode").val());
            }
        }else{
            // 本身结点是 跟结点 取treepath 为本身的moduleCode
            $("#treepath").val($("#moduleCode").val());
        }
        
        selected.attributes.treepath = $("#treepath").val();
        selected.attributes.parentModuleCode = $("#parentModuleCode").val();

        saveModuleInfo(selected, 
                function(data, status) {
                    selected.attributes._modify_flag = false;
                    selected.attributes._from_server_flag = true;
                    // 模块编号不可修改
                    setRequired('moduleCode', false);
                    setReadonly('moduleCode', true);
                    showSlideMessage("保存成功！");
                    updateTreeNoteName(selected);
                    //jQuery.messager.alert('提示信息','保存成功！','info');
                    // 修改 结点显示名称
                    
                },
                function(data, status) {
                    var jsonStr= eval("("+data.responseText+")");
                    showSlideMessage("保存失败！"+jsonStr.string);
                    //jQuery.messager.alert('错误信息','保存失败:'+data.responseText,'error');
                });
    }
}

/**
 * 保存或者修改完毕之后 改变左侧选择结点的数据展现，可能涉及名字变更
 */
function updateTreeNoteName(node){
    moduleTree.tree('update', {
        target: node.target,
        text: node.attributes.moduleName
    });
}

var onchangeFunc = function copyDetailDataToTreeNode(event){
    // 事件开关关闭，无需处理事件
    if(!eventSwitcher){
        return;
    }
    var eventId = $(this).attr('id');
    if(!eventId){
        return;
    }
    var selected = moduleTree.tree('getSelected');
    if(!selected || selected==undefined || selected==''){
        return;
    }
    if(eventId=='moduleCode'){
        var value = $('#moduleCode').val();
        if(!value || value.length==0 || value.indexOf('新建模块节点', 0)>=0){
            showSlideMessage("保存失败:模块编号未填写，不能保存！");
            //jQuery.messager.alert('警告信息','保存失败:模块编号未填写，不能保存！','warning');
            $('#moduleCode').val(selected.attributes.moduleCode);
            return;
        } else if(value.length<=0 || value.length>=10){
            showSlideMessage("保存失败:模块编号长度必须为1至9！");
            //jQuery.messager.alert('警告信息','保存失败:模块编号长度必须为1至10！','warning');
            $('#moduleCode').val(selected.attributes.moduleCode);
            return;
        }
    } else if(eventId=='moduleName'){
        var value = $('#moduleName').val();
        if(!value || value.length==0 || value.indexOf('新建模块节点', 0)>=0){
            showSlideMessage("保存失败:模块名称未填写，不能保存！");
            //jQuery.messager.alert('警告信息','保存失败:模块名称未填写，不能保存！','warning');
            $('#moduleName').val(selected.attributes.moduleName);
            return;
        } else if(value.length<=0 || value.length>=32){
            showSlideMessage("保存失败:模块名称长度必须为1至32！");
            //jQuery.messager.alert('警告信息','保存失败:模块名称长度必须为1至32！','warning');
            $('#moduleName').val(selected.attributes.moduleName);
            return;
        }
        selected.text = value;
        moduleTree.tree('update', {
            target: selected.target,
            text: value
        });
    }
    if(selected.attributes){
        selected.attributes.moduleCode = $('#moduleCode').val();
        selected.attributes.moduleName = $('#moduleName').val();
        selected.attributes.treepath = $('#treepath').val();
        selected.attributes.parentModuleCode = $('#parentModuleCode').val();
        selected.attributes._modify_flag = true;//标记修改
    }
};

// 设置只读显示
function setReadonly(target, flag){
    if(flag){
        // 只读
        $('#'+target).attr('readonly','readonly');
        $('#'+target).addClass('readonly');
    } else {
        // 非只读
        $('#'+target).removeAttr('readonly');
        $('#'+target).removeClass('readonly');
    }
}
// 设置必输项显示
function setRequired(target, flag){
    if(flag){
        // 必输
        $('#'+target).addClass('required');
        $('#'+target).attr('data-options',"required:true");
    } else {
        // 选输
        $('#'+target).removeClass('required');
        $('#'+target).attr('data-options',"required:false");
    }
}

var fisrtUnSaveNode = null;
var getUnSaveNode = false;
function findNoneSaveNode(){
    fisrtUnSaveNode = null;
    getUnSaveNode = false;
    var result = findNoneSaveNodeRecur(null);
    // 如果有未保保存的节点，则跳转节点
    if(result && fisrtUnSaveNode){
        ModuleTree.tree('select', fisrtUnSaveNode.target);
    }
    return result;
}
    
// 遍历搜索未保存节点,展开其父节点
function findNoneSaveNodeRecur(node){
    var hasUnsaveNode = false;
    if(node && node!=undefined && node.attributes){
        if(node.attributes._modify_flag || node.attributes._modify_flag){
            if(!fisrtUnSaveNode){
                fisrtUnSaveNode = node;
                hasUnsaveNode = true;
            }
        }
        // 遍历普通节点
        var children = moduleTree.tree('getChildren', node.target);
        if(children && children.length>0){
            for(var i in children){
                // 未保存修改节点或未保存新增节点
                if(children[i].attributes._modify_flag || children[i].attributes._modify_flag){
                    if(!fisrtUnSaveNode){
                        fisrtUnSaveNode = children[i];
                        hasUnsaveNode = true;
                    }
                }
                if(!moduleTree.tree('isLeaf', children[i].target)){
                    //非叶子节点需继续遍历其子节点,如果叶子节点存在未保存数据，则展开父节点
                    var result = findNoneSaveNodeRecur(children[i]);
                    if(result){
                        hasUnsaveNode = true;
                        moduleTree.tree('expand', children[i].target);
                    }
                }
            }
        }
    } else {
        // 遍历根节点
        var roots = moduleTree.tree('getRoots');
        if(roots && roots.length>0){
            for(var i in roots){
                hasUnsaveNode = (hasUnsaveNode || findNoneSaveNodeRecur(roots[i]));
                moduleTree.tree('expand', roots[i].target);
            }
        }
    }
    return hasUnsaveNode;
}

// 跳转未保存节点
$(document).ready(function(){
    // 绑定按钮点击响应方法
    $("#reload").click(function(){
        reloadModuleList();
    });
    $("#add").click(function(){
        // MODIFIED on 2013-12-06 09:35:07
        // 弹出框处理 新增
        //addSubModuleNode();
        addModuleNodeInfo();
    });
    
    $("#update").click(function(){
        // ADDED on 2013-12-06 09:35:07
        // 弹出框处理 新增
        //addSubModuleNode();
        updateModuleNodeInfo();
    });
    
    $("#delete").click(function(){
        deleteModuleNode();
    });
    $("#save").click(function(){
        saveModuleNode();
    });
    
    // 绑定树方法
    moduleTree = $('#moduleTree').tree({
        checkbox: false,
        cascadeCheck: false,
        onLoadSuccess: function(node, data){
            collapseAllNode();
        },
        onDblClick : function(node){
            // 叶子节点无需处理
            if(moduleTree.tree('isLeaf', node.target)){
                return;
            }
            if(!node.state){
                
            } else if(node.state=='open'){
                moduleTree.tree('collapse', node.target);
            } else if(node.state=='closed') {
                moduleTree.tree('expand', node.target);
            }
        },
        
/**        onBeforeExpand: function(node){
            // 如果数据已经有加载过，则，不再重新加载数据
            var children = moduleTree.tree('getChildren', node.target);
            if(children && children.length && children.length>0){
                for(var i in children){
                    if(children[i] && children[i].attributes 
                            && children[i].attributes._from_server_flag){
                        return;
                    }
                }
            }
            // 加载子模块节点数据
            loadSubModuleList(node);
        },
**/
        onContextMenu: function(e, node){
            e.preventDefault();
            // select the node
            moduleTree.tree('select', node.target);
            $('#treeModule').menu('show', {
                left: e.pageX,
                top: e.pageY
            });
        },
        
        onSelect: function(node){
            // 选中当前节点，将当前节点信息显示到明细界面供查看编辑
            takeOutTreeNodeInfo(node);
        }
    });
    
    //绑定明细页面数据变化事件
    $("[class='easyui-validatebox']").change(onchangeFunc);

    $('#moduleStatus').combobox({
        onSelect: function(record){
            // 事件开关关闭，无需处理事件
            if(!eventSwitcher){
                return;
            }
            var selected = moduleTree.tree('getSelected');
            if(!selected || !selected.attributes){
                return;
            }
            selected.attributes.moduleStatus = record.value;
            selected.attributes._modify_flag = true;//标记修改
        }
    });

    $('#orderNum').numberbox({
        onChange: function(newValue,oldValue){
            // 事件开关关闭，无需处理事件
            if(!eventSwitcher){
                return;
            }
            var selected = moduleTree.tree('getSelected');
            if(!selected || !selected.attributes){
                return;
            }
            if(newValue && newValue<0){
                showSlideMessage("保存失败:模块顺序必须为大于0的整数！");
                //jQuery.messager.alert('警告信息','保存失败:模块顺序必须为大于0的整数！','warning');
                return oldValue;
            }
            selected.attributes.orderNum = newValue;
            selected.attributes._modify_flag = true;//标记修改
        }
    });
    
    // 绑定tab页面关闭事件
    $('#tabs').tabs({
        onBeforeClose: function(title,index){
            var target = this;
            if(findNoneSaveNode()){
                jQuery.messager.confirm('确认信息','还有未保存的修改信息，是否关闭页面?',function(event){
                    if(event){
                        var opts = $(target).tabs('options');
                        opts.onBeforeClose = function(){};  // 清除本页面绑定在tabs的关闭事件,存在后遗症，会导致统一设置的关闭事件被覆盖
                        $(target).tabs('close',index);
                    }
                });
                return false;// prevent from closing
            }
        }
    });
    
    // 页面初始化后，获取模块根节点信息
    //loadRootModuleList();
    // 设置只读输入项
    //setReadonly('parentModuleCode', true);
    //setReadonly('treepath', true);
    // 设置必输输入项
    //setRequired('moduleCode', true);
    //setRequired('moduleName', true);
    //setRequired('moduleStatus', true);
});
</script>
</body>
</html>