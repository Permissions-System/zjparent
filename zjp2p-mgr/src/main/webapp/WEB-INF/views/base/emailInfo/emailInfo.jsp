<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
#mailInfoFrom table tr {
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:100px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr >
                    <td><label for="qyMailDomain">邮箱域名:</label></td>
                    <td><input id="qyMailDomain" name="mailDomain" class="easyui-validatebox" style="width:155px;" ></td>
                    <td><label for="qyMailUrl">邮箱访问地址:</label></td>
                    <td><input id="qyMailUrl" name="emailUrl" style="width:160px;" class="easyui-validatebox"></td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itEmailInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
</div>
<!-- 新增修改页面 -->
<div id="emailInfoDlg" class="easyui-dialog" style="width:350px;height:230px;padding:10px 0px 10px 30px"
        data-options="resizable:false,modal:true" closed="true" buttons="#email-dlg-buttons">
    <form id="mailInfoFrom" method="post">
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr >
                <td><label for="idMailDomain">邮箱域名:</label></td>
                <td><input id="idMailDomain" name="mailDomain" type="text" class="easyui-validatebox" style="width:155px;" data-options="required:true,validType:['emailValid','length[0,32]']" ></td> 
            </tr>
            <tr >
                <td><label for="idMailUrl">邮箱访问地址:</label></td>
                <td>
                <input id="idMailUrl" name="mailUrl" class="easyui-validatebox" style="width:155px;"  data-options="required:true,validType:['emailValid','length[0,64]']" ></input>
                </td>
            </tr>
            <tr >
                <td><label for="idIndexNo">顺序号:</label></td>
                <td><input id="idIndexNo" name="indexNo" class="easyui-numberspinner"  style="width:155px;" data-options="min:0,editable:false" ></td>
            </tr>
            <tr >
                <td><label for="idDescription">描述:</label></td>
                <td><input id="idDescription" name="description" class="easyui-validatebox" style="width:155px;" data-options="validType:['length[0,20]']" ></td>
            </tr>
        </tbody>
        </table>
        <!-- 实际保存RecNo  始终hidden -->
        <input id="idRecNo" name="recNo" type="hidden">
    </form>
</div>
<div id="email-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="saveEmailInfo" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#emailInfoDlg').dialog('close')">关闭</a>
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
    $("#saveEmailInfo").bind("click", function(){
    	saveEmailInfo();
    });
    

    // 初始化页面Grid
    initEmailGrid();
    
    disPagelistOption();
    
        
    // 类型Dialog弹出框关闭处理
    $('#emailInfoDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
    $('#idIndexNo').numberspinner({
        min: 0,
        editable: true
    });
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#saveEmailInfo");
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

/**
 * 组合查询
 * 消息优先级: 
 *
 */
function queryInfo(){
    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#itEmailInfo').datagrid('load',{
        mailDomain: $('#qyMailDomain').val(),
        mailUrl: $('#qyMailUrl').val()
    });
    disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
}
 
/**
 * 新增数据，修改数据，统一保存
 */
function saveEmailInfo(){
	
    var isValid = $('#mailInfoFrom').form('validate');
    if(!isValid){
        return ;
    }
    
    var action = $('#saveEmailInfo').data('action');

    if(action=="insert"){
        // AJAX 提交
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/emailInfo/insert",
            data : {
                mailDomain: $("#idMailDomain").val(),
                mailUrl: $("#idMailUrl").val(),
                indexNo:$("#idIndexNo").numberspinner('getValue'),
                description:$("#idDescription").val()
            },
            success : function(data) {
               if(data.message=='domain'){
                   showSlideMessage("邮箱域名已存在，请确认！");
               }else if(data.message=='url'){
            	   showSlideMessage("邮箱访问地址已存在，请确认！");
               }else if(data.message=='all'){
                   showSlideMessage("邮箱域名,邮箱访问地址已存在，请确认！");
               }else if(data.message=='success'){
                   // close dialog
                   $('#emailInfoDlg').dialog('close'); 
                   showSlideMessage("保存成功");
                   $('#itEmailInfo').datagrid('load');
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
            url : "${ctx}/base/emailInfo/update",
            data : {
                recNo:$("#idRecNo").val(),
                mailDomain: $("#idMailDomain").val(),
                mailUrl: $("#idMailUrl").val(),
                indexNo:$("#idIndexNo").numberspinner('getValue'),
                description:$("#idDescription").val()
            },
            success : function(data) {
            	if(data.message=='domain'){
                    showSlideMessage("邮箱域名已存在，请确认！");
                }else if(data.message=='url'){
                    showSlideMessage("邮箱访问地址已存在，请确认！");
                }else if(data.message=='all'){
                    showSlideMessage("邮箱域名,邮箱访问地址已存在，请确认！");
                }else if(data.message=='success'){
                   // close dialog
                   $('#emailInfoDlg').dialog('close'); 
                   showSlideMessage("修改成功");
                   $('#itEmailInfo').datagrid('reload');
                   disPagelistOption();
               }else{
                   showSlideMessage("修改错误！");
               }
            },
            error : function(data) {
                 showSlideMessage("修改异常！");
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
function newEmailInfo(){
    $('#emailInfoDlg').dialog('open').dialog('setTitle','新增');
    $('#mailInfoFrom').form('clear');
    
    var indexNo = 0;
    // 修改
    jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/emailInfo/getMaxIndexNo",
        data : {
        },
        success : function(data) {
        	if(data.message=='success'){
                // close dialog
        		indexNo = data.maxIndexNo;
            }
        },
        error : function(data) {
             showSlideMessage("新增加载数据异常！");
             indexNo = 0;
        },
        datatype : "json"
    }); 
    
    $("#idIndexNo").numberspinner('setValue',indexNo);
    // 保存按钮 暂存数据
    $('#saveEmailInfo').data("action","insert");
}

/**
 * 编辑数据
 */
function editEmailInfo(){
    var rows = $('#itEmailInfo').datagrid('getSelected');
    if(!rows){
        showSlideMessage("请选择需要编辑的记录！");
        return;
    }
    
    $('#emailInfoDlg').dialog('open').dialog('setTitle','修改配置');
    $('#mailInfoFrom').form('clear');
    $('#mailInfoFrom').form('load',rows);
    
    // 数字选择器赋值
    $('#idIndexNo').numberspinner('setValue', rows.indexNo);  
    // 保存操作类型数据 
    $("#saveEmailInfo").data("action","update");
}

/**
 * 删除数据
 */
function removeEmailInfo(){
    var row = $('#itEmailInfo').datagrid('getSelected');
    if(!row){
        // 未选择记录，给出侧边栏提示 需要选择记录
        showSlideMessage("请选择需要删除的记录！");
        return;
    }
    $.messager.confirm('确认','确定删除当前选择的记录?',function(r){
        if (r){
            jQuery.ajax({
                
                type : "POST",
                async: false,
                url : "${ctx}/base/emailInfo/delete",
                data : {
                    recNo:row.recNo
                },
                success : function(data) {
                  if(data.message=='success'){
                       showSlideMessage("删除成功!");
                       // 重新加载
                       $('#itEmailInfo').datagrid('load');
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
  * js初始化页面DataGrid
  */
function initEmailGrid(){
    $("#itEmailInfo").datagrid({
        pagination:true,
        rownumbers:true,
        pageSize:10,
        pageList:[10,20],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        url: '${ctx}/base/emailInfo/getInfoByPage',
        onSelect:function(rowIndex, rowData){
            // 具体加载明细记录的js操作
            setRecNoValue(rowData.recNo);
        },
        onDblClickRow:function(rowIndex, rowData){
            // 具体加载明细记录的js操作
            setRecNoValue(rowData.recNo);
            editEmailInfo();
        },
        onLoadError: function(){
            $.messager.alert('错误信息','信息查询失败!','error');
        },
        columns:[[
                  {title:'主键',field:'recNo',width:60,hidden:true},
                  {title:'邮箱域名',field:'mailDomain',width:100},
                  {title:'邮箱访问地址',field:'mailUrl',width:150},
                  {title:'顺序号',field:'indexNo',width:50},
                  {title:'描述',field:'description',width:60}
              ]],
        toolbar:[{
                    text:'新增',
                    iconCls:'icon-add',
                    handler:function(){
                        newEmailInfo();
                    }
                },'-',{
                    text:'修改',
                    iconCls:'icon-edit',
                    handler:function(){
                        editEmailInfo();
                    }
                },'-',{
                     text:'删除',
                     iconCls:'icon-remove',
                     handler:function(){
                        // 处理明细记录的删除操作handler
                        removeEmailInfo();
                }
            }
        ]
    });
}
 
/**
 * 新增记录为 文件类型赋值
 */
function setRecNoValue(recNo){
    $('#idRecNo').val(recNo);
}

// 扩展输入字段的格式化定义 
$.extend($.fn.validatebox.defaults.rules, {
    emailValid: {        
        validator: function(value, param){
            var p = new RegExp('[^a-zA-Z0-9\s/\_\/.\/:\-]');
            return !p.test(value);
        },
        message: '输入内容应由数字、字母、下划线或冒号组成'
    },
    fileTypeValid: {        
        validator: function(value, param){
            var p = new RegExp('[^a-zA-Z0-9]');
            return !p.test(value);
        },
        message: '输入内容应仅由数字、字母组成'
    }
});   
</script>
</body>
</html>