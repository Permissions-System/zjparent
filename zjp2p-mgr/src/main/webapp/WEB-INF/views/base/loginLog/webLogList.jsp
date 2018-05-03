<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
#queryForm table tr {
    height:30px;
}
#logInfoForm table tr {
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr>
                   <td><label for="qyLoginName">用户名:</label></td>
                   <td><input id="qyLoginName" name="loginName" class="easyui-validatebox" style="width:155px;" ></td>
                   <td><label for="qyEmail">邮箱:</label></td>
                   <td><input id="qyEmail" name="email" style="width:160px;" class="easyui-validatebox"></td>
                   <td><label for="qyMobile">手机号:</label></td>
                   <td><input id="qyMobile" name="mobile" style="width:160px;" class="easyui-validatebox"></td>
                   <td><label for="qyIpAddress">IP地址:</label></td>
                   <td><input id="qyIpAddress" name="ipAddress" style="width:160px;" class="easyui-validatebox"></td>
                </tr>
                <tr>
                   <td><label for="qyStartDate">开始日期:</label></td>
                   <td><input id="qyStartDate" name="startDate" class="easyui-datetimebox" style="width:155px;" data-options="editable:false" ></td>
                   <td><label for="qyEndDate">结束日期:</label></td>
                   <td><input id="qyEndDate" name="endDate" class="easyui-datetimebox" style="width:160px;" data-options="editable:false"></td>
                   <td><label for="qyLoginDesc">登录描述:</label></td>
                   <td><input id="qyLoginDesc" name="loginDesc" style="width:160px;" class="easyui-validatebox"></td>
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
        <table id="itLogInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
</div>
<script type="text/javascript">
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
    
    // 初始化页面Grid
    initDataGrid();
    
    disPagelistOption();
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnQuery = $("#btnQuery");

    // 绑定 查询的 Enter
    if(event.keyCode == 13){
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
    $('#itLogInfo').datagrid('load',{
        loginName: $('#qyLoginName').val(),
        email:$('#qyEmail').val(),
        mobile:$('#qyMobile').val(),
        ipAddress: $('#qyIpAddress').val(),
        startDate:$('#qyStartDate').datetimebox('getValue'),
        endDate:$('#qyEndDate').datetimebox('getValue'),
        loginDesc:$('#qyLoginDesc').val()
    });
    disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
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
  * js初始化页面DataGrid
  */
function initDataGrid(){
    $("#itLogInfo").datagrid({
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
        url: '${ctx}/base/loginLog/webLog/getInfoByPage',
        onSelect:function(rowIndex, rowData){
        },
        onLoadError: function(){
        	showSlideMessage("信息查询失败!");
        },
        columns:[[
            {title:'主键',field:'recNo',width:60,hidden:true},
            {title:'用户名',field:'userName',width:100},
            {title:'邮箱',field:'email',width:200},
            {title:'手机号',field:'mobile',width:100},
            {title:'账户状态',field:'statusDesc',width:60,align:'center'},
            {title:'IP地址',field:'ipAddress',width:80,align:'center'},
            {title:'登录时间',field:'loginTime',width:120},
            {title:'登录描述',field:'loginDesc',width:150}
        ]]
    });
}
</script>
</body>
</html>