<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label for="qyTransName">交易名称:</label></td>
                    <td><input id="qyTransName" name="transName" class="easyui-validatebox" style="width:155px;" ></td>
                    <td><label for="qyProductCode">归属产品:</label></td>
                    <td>
                        <select id="qyProductCode"  name="productCode" panelHeight="auto" class="easyui-combobox" style="width:155px;" data-option="editable:false">     
                            <option value="">全部</option>
                            <c:forEach items="${productCode}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label for="qyModuleName">模块名称:</label></td>
                    <td><input id="qyModuleName" name="moduleName" style="width:160px;" class="easyui-validatebox"></td>
                </tr>
                <tr class="itemMagin">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itWebTransInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
</div>

<div id="webTransDlg" class="easyui-dialog" style="width:660px;height:280px;padding:10px 0px 10px 30px"
        data-options="resizable:false,modal:true" closed="true" buttons="#webtrans-dlg-buttons">
    <form id="webTransForm" method="post">
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr class="itemMagin">
                <td><label for="idTransCode">交易代码:</label></td>
                <td><input id="idTransCode" name="transCode" type="text" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td> 
                <td><label for="idTransName">交易名称:</label></td>
                <td><input id="idTransName" name="transName" type="text" class="easyui-validatebox" style="width:200px;" data-option="required:true" ></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idProductCode">归属产品:</label></td>
                <td>
                    <select id="idProductCode" class="easyui-combobox" panelHeight="auto" name="productCode" style="width:155px;" data-option="editable:false,required:true">
                        <c:forEach items="${productCode}" var="item">
                            <option value="${item.configCode}">${item.configName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tr class="itemMagin">  
                <td><label for="idRecheckLevel">复核级别:</label></td>
                <td><input id="idRecheckLevel" name="recheckLevel" class="easyui-numberspinner" style="width:155px;"  data-option="min:1,max:10,editable:false" ></td>
                <td><label for="idModuleName">模块名称:</label></td>
                <td><input id="idModuleName" name="moduleName" type="text" class="easyui-validatebox" style="width:200px;" data-option="required:true" ></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idRecheckDetailPage">详细信息页面:</label></td>
                <td colspan="3"><input id="idRecheckDetailPage" name="recheckDetailPage" class="easyui-validatebox" style="width:455px;" ></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idRecheckHandlePage">复核终核处理页面:</label></td>
                <td colspan="3"><input id="idRecheckHandlePage" name="recheckHandlePage" class="easyui-validatebox" style="width:455px;"  ></td>
            </tr>
        </tbody>
        </table>
    </form>
</div>
<div id="webtrans-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="webTransSave" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#webTransDlg').dialog('close')">关闭</a>
</div>
<script type="text/javascript">
var isOpenFlag = "0";

$(document).ready(function() {
    // 页面初始化
    // 查询按钮绑定事件
    
    $("#btnQuery").bind("click", function(){
        queryInfo();
    });
    // 查询取消按钮事件
    $("#btnCancel").bind("click", function(){
        queryCancel();
    });
    
    // 弹出框 保存按钮处理事件
    $("#webTransSave").bind("click", function(){
        saveWebTransInfo();
    });

    // 初始化页面Grid
    initWebTransGrid();
    
    disPagelistOption();
    
    disEditableComboBox();
    
    
    $("#idTransCode").keyup( function() {
    	toNotUpperCase_onKeyUp($("#idTransCode"));
    });
    
    $("#qyTransName").keyup( function() {
    	inputNameQueryValue_onKeyUp($("#qyTransName"));
    });
    
    $("#qyModuleName").keyup( function() {
        inputNameQueryValue_onKeyUp($("#qyModuleName"));
    });
    
    $("#idTransName").keyup( function() {
        inputNameValue_onKeyUp($("#idTransName"));
    });
    
    $("#idModuleName").keyup( function() {
        inputNameValue_onKeyUp($("#idModuleName"));
    });
    
    // 类型Dialog弹出框关闭处理
    $('#webTransDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
    requiredBox();
});



/*必输项*/
function requiredBox(){

    $('#idTransCode').validatebox({    
        required: true
    });

    $('#idTransName').validatebox({    
        required: true
    });
    
    $('#idProductCode').combobox({    
        required: true
    });
    
    $('#idModuleName').validatebox({    
        required: true
    });
    
}
/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#webTransSave");
    var btnQuery = $("#btnQuery");
    // 点击 Enter按钮
    if(event.keyCode == 13 && isOpenFlag =="1"){
        btnOjb.click();
        event.returnValue = false;
    }
    
    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag =="0"){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    //$(".pagination-page-list").attr('disabled','disabled');
    $(".pagination-num").attr('disabled','disabled');
}

function toNotUpperCase_onKeyUp(jObject) {
    var val = jObject.val();
    // 代码类型 只能输入 英文字符，数字 下划线
    // 去除双字节字符(包括汉字在内)
    val = val.replace(/[\u4E00-\u9FA5]/g, '');

    val = val.replace(/[^a-zA-Z0-9_]/g, '');

    // 替换空格
    val = cgReplaceAll(val, ' ', '');
    // 新增特殊字符的校验
    jObject.val(val);
}

/**
 * 控制页面内下拉不可编辑
 */
function disEditableComboBox(){
    $("#qyProductCode").combobox({
        editable:false
    });
    $("#idProductCode").combobox({
        editable:false
    });
    /**
    // 支持多选下拉 
    $("#idMsgChannel").combobox({
        multiple:true,
        editable:false
    });
   
    / 支持所选下拉 只能单选
    $("#qrMsgChannel").combobox({
        editable:false
    });
    **/
    
    // 数字选择器，不可编辑，不可选
    $("#idRecheckLevel").numberspinner({
    	disabled:true,
        editable:false
    });
}

/**
 * 组合查询
 * 条件： 归属产品 produceCode 模板名称 templateName 发送时间是否限制 timeFlag
 * 消息优先级: 
 *
 */
function queryInfo(){
    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#itWebTransInfo').datagrid('load',{
        transName: $('#qyTransName').val(),
        productCode: $('#qyProductCode').combobox('getValue'),
        moduleName: $('#qyModuleName').val()
    });
    disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
    $('#qyProductCode').combobox('setValue','');
}
 
/**
 * 新增数据，修改数据，统一保存
 */
function saveWebTransInfo(){
    // 判断 新增或修改
    var action = $('#webTransSave').data('action');
    
    var isValid = $('#webTransForm').form('validate');
    if(!isValid){
        return ;
    }
    // 避暑校验不通过 新增或修改 对必输项进行校验
    if(!checkValiWebTrans()){
        return ;
    }
    
    // 获取多选下拉列表框
    /**
    var channelArray = $("#idMsgChannel").combobox('getValues');
    var channelValue = "";
    if(channelArray.length>0){
        channelValue = channelArray.join(',');
    }
    **/
    // 判断 新增  或 修改
    if(action=='insert'){
        // AJAX 提交
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/webtrans/insert",
            data : {
            	transCode: $("#idTransCode").val(),
            	transName: $("#idTransName").val(),
                productCode: $("#idProductCode").combobox('getValue'),
                moduleName: $("#idModuleName").val(),
                recheckLevel:$("#idRecheckLevel").numberspinner('getValue'),
                recheckDetailPage: $("#idRecheckDetailPage").val(),
                recheckHandlePage: $("#idRecheckHandlePage").val()//,
                //msgChannel: channelValue
            },
            success : function(data) {
               if(data.message=='exist'){
                   showSlideMessage("模块代码已存在，请确认！");
               }else if(data.message=='success'){
                   // close dialog
                   $('#webTransDlg').dialog('close'); 
                   showSlideMessage("保存成功");
                   $('#itWebTransInfo').datagrid('load');
                   disPagelistOption();
               }else{
                   showSlideMessage("保存异常！");
               }
            },
            error : function(data) {
                 showSlideMessage("保存失败！");
            },
            datatype : "json"
        });
    	
    }else{
    	
    	// 修改
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/webtrans/update",
            data : {
                transCode: $("#idTransCode").val(),
                transName: $("#idTransName").val(),
                productCode: $("#idProductCode").combobox('getValue'),
                moduleName: $("#idModuleName").val(),
                recheckLevel:$("#idRecheckLevel").numberspinner('getValue'),
                recheckDetailPage: $("#idRecheckDetailPage").val(),
                recheckHandlePage: $("#idRecheckHandlePage").val()//,
                //msgChannel: channelValue
            },
            success : function(data) {
               if(data.message=='success'){
                   // close dialog
                   $('#webTransDlg').dialog('close'); 
                   showSlideMessage("修改成功");
                   $('#itWebTransInfo').datagrid('reload');
                   disPagelistOption();
               }else{
                   showSlideMessage("保存异常！");
               }
            },
            error : function(data) {
                 showSlideMessage("修改失败！");
            },
            datatype : "json"
        });	
    }
}

/*
 * 统一弹出侧边消息提示
 */
function showSlideMessage(msg){
    $.messager.show({
        title:'提示',
        msg:msg,
        timeout:4000,
        showType:'slide'
    });
}

/**
 * 新增数据
 */
function newWebTransInfo(){
    $('#webTransDlg').dialog('open').dialog('setTitle','新增配置');
    $('#webTransForm').form('clear');
    
    $('#webTransForm').find('[name=transCode]').removeAttr('readonly');
    // 保存按钮暂存数据 Insert
    $('#idProductCode').combobox('setValue','');
    // 复核级别 暂定默认数据 1 
    $("#idRecheckLevel").numberspinner('setValue',1);
    // 保存按钮 暂存数据
    $('#webTransSave').data("action","insert");
    //$('#webTransForm').find('[name=transCode]').removeAttr('disabled');
	$('#idTransCode').css("color", "#000000");
    /**
    var result = $('#qrMsgChannel').combobox('getValues');
    var selectCodes = result.join(',');
    showSlideMessage(selectCodes);
    **/
    //initDialogValidate();
    //$('#webTransForm').form('validate');
    //$('#webTransForm').form('validate');
}

/**
 * 编辑数据
 */
function editWebTransInfo(){
	var rows = $('#itWebTransInfo').datagrid('getSelected');
    if(!rows){
        showSlideMessage("请选择需要编辑的配置记录！");
        return;
    }
    
    $('#webTransDlg').dialog('open').dialog('setTitle','修改配置');
    $('#webTransForm').find('[name=transCode]').attr('readonly','readonly');
    //$('#webTransForm').find('[name=transCode]').attr('disabled','disabled');
    $('#webTransForm').form('clear');
    $('#webTransForm').form('load',rows);
    
    /**
    var msgVal = rows.msgChannel;
    var resArray = [];
    if(isNotNull(msgVal)){
    	resArray = msgVal.split(",");
    }
    **/
    // 数字选择器赋值
    $('#idRecheckLevel').numberspinner('setValue', rows.recheckLevel);  
    // 为 多选 下拉框 赋值
    //$('#idMsgChannel').combobox('setValues',resArray);
    $('#idTransCode').css("color", "#9E9E9E");
    // 保存操作类型数据 
    $("#webTransSave").data("action","update");
}

/**
 * 删除数据
 */
function removeWebTransInfo(){
	var row = $('#itWebTransInfo').datagrid('getSelected');
    if(!row){
        // 未选择记录，给出侧边栏提示 需要选择记录
        showSlideMessage("请选择数据需要删除的记录！");
        return;
    }
    $.messager.confirm('确认','确定删除当前选择的配置信息?',function(r){
        if (r){
            jQuery.ajax({
                
                type : "POST",
                async: false,
                url : "${ctx}/base/webtrans/delete",
                data : {
                	transCode:row.transCode
                },
                success : function(data) {
                  if(data.message=='success'){
                       showSlideMessage("删除成功!");
                       // 重新加载
                       $('#itWebTransInfo').datagrid('load');
                       disPagelistOption();
                   }else{
                       showSlideMessage("删除失败！");
                   }
                },
                error : function(data) {
                     showSlideMessage("删除过程发生异常！");
                },
                datatype : "json"
            });
        }
    });
}

/**
 * 展示明细数据
 */
function showWebTransInfo(){
	editWebTransInfo();
}


/**
 * 新增和修改 对必输项做校验控制
 * 归属产品，模板代码，模板名称，模板主题，模板内容
 */
function checkValiWebTrans(){
    var val = "",ct=0;
    
    
    // 模块编码 
    val = $("#idTransCode").val();
    if(isNull(val)){
        showSlideMessage("请输入 交易代码！");
        return false;
        c++;
    }
    
    /*长度校验*/
    if(val.length<=0 || val.length>10){
        showSlideMessage("交易代码不应超过10个字符,请确认！");
        return false;
        c++;
    }
    
    // 交易名称
    val = $("#idTransName").val();
    if(isNull(val)){
        showSlideMessage("请输入 交易名称！");
        return false;
        c++;
    }
    
    /*长度校验*/
    if(val.length<=0 || val.length>20){
        showSlideMessage("交易名称不应超过20个字符,请确认！");
        return false;
        c++;
    }
    
    // 归属产品
    val = $("#idProductCode").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择归属产品！");
        return false;
        c++;
    }
    
    // 模块名称
    val = $("#idModuleName").val();
    if(isNull(val)){
        showSlideMessage("请输入 模块名称！");
        return false;
        c++;
    }
    
    if(val.length<=0 || val.length>20){
        showSlideMessage("模块名称不应超过20个字符,请确认！");
        return false;
        c++;
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}
 /**
  * js初始化页面DataGrid
  */
function initWebTransGrid(){
    $("#itWebTransInfo").datagrid({
        pagination:true,
        rownumbers:true,
        pageSize:10,
        pageList:[10,20,50],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        url: '${ctx}/base/webtrans/getWebTransInfoList',
        onDblClickRow:function(rowIndex, rowData){
        	editWebTransInfo();
        },
        columns:[[
                  {title:'主键',field:'id',width:100,hidden:true},
                  {title:'交易代码',field:'transCode',width:60},
                  {title:'交易名称',field:'transName',width:100},
                  {title:'归属产品',field:'productCode',width:100,hidden:true},
                  {title:'归属产品',field:'productName',width:100},
                  {title:'模块名称',field:'moduleName',width:150},
                  {title:'复核级别',field:'recheckLevel',width:100,hidden:true},
                  {title:'复核详细信息页面',field:'recheckDetailPage',width:150,hidden:true},
                  {title:'复核终核处理页面',field:'recheckHandlePage',width:150,hidden:true}
              ]],
        toolbar:[{
            text:'新增',
            iconCls:'icon-add',
            handler:function(){
            	newWebTransInfo();
            }},'-',{
                text:'修改',
                   iconCls:'icon-edit',
                   handler:function(){
                	   editWebTransInfo();
                   }
            },'-',{
                     text:'删除',
                     iconCls:'icon-remove',
                     handler:function(){
                        // 处理明细记录的删除操作handler
                        removeWebTransInfo();
                     }
            }
        ]
    });
}
</script>
</body>
</html>