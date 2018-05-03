<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
#queryForm tr{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:150px;padding:20px 0px 10px 20px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px">
                <tr>
	                <td><label for="qyUserName">登录名:</label></td>
	                <td><input id="qyUserName" name="userName" style="width: 155px;" class="easyui-validatebox"></td>
	                <td><label for="qyMobile">手机:</label></td>
	                <td><input id="qyMobile" name="mobile" style="width: 155px;" class="easyui-validatebox"></td>
	                <td><label for="qyEmail">邮箱:</label></td>
	                <td><input id="qyEmail" name="email" style="width: 155px;" class="easyui-validatebox"></td>
	                <td><label for="qyName">姓名:</label></td>
	                <td><input id="qyName" name="name" style="width: 155px;" class="easyui-validatebox"></td>
	            </tr>
                <tr>
                    <td><label for="qyIncomeScopes">年收入范围:</label></td>
                    <td align="left">
                        <select id="qyIncomeScopes" class="easyui-combobox" name="incomeScope" panelHeight="auto" style="width:160px;" data-options="editable:false">     
                            <option value="">全部</option>
	                        <c:forEach items="${incomeScopes}" var="item">
	                            <option value="${item.configCode}">${item.configName}</option>
	                        </c:forEach>
                        </select>
                    </td>
                    <td><label for="qrWorkYear">工作时间:</label></td>
                    <td align="left">
                        <select id="qrWorkYear" class="easyui-combobox" name="workYear" panelHeight="auto" style="width:160px;" data-options="editable:false">     
                            <option value="">全部</option>
                            <c:forEach items="${workYears}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label for="qyWorkProvince">工作省市:</label></td>
                    <td align="left">
                        <select id="qyWorkProvince" class="easyui-combobox" name="workProvince" style="width:160px;" data-options="editable:false">
                            <option value="">全部</option>      
                            <c:forEach items="${provinces}" var="item">
                                <option value="${item.areaCode}">${item.areaName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                    <td>
	                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery" >查询</a>
	                    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="employeeList">
        </table>
    </div>
</div>
<!-- 用户所在用户组 -->
<div id="groupDialog" class="easyui-dialog" style="width:700px;height:300px;"
    data-options="resizable:false,modal:true,title:'所属组'" closed="true">
        <table id="webGroupList"></table>
</div>
<div id="resourceDialog" class="easyui-dialog" title="资源列表 " 
    data-options="closed: true,maximized:true,resizable:true,modal:true">
        <table id="webResourceList"></table>
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

    
    initInfoGrid();
    
    initBelongGroupGrid();
    
    initBelongResourceGrid();
});

function queryInfo(){
    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#employeeList').datagrid('load',{
        // 登录名
    	username: $('#qyUserName').val(),
    	mobile: $('#qyMobile').val(),
    	email: $('#qyEmail').val(),
        name: $('#qyName').val(),
    	
        incomeScope: $('#qyIncomeScopes').combobox('getValue'),
        workYear:$('#qrWorkYear').combobox('getValue'),
        workProvince:$('#qyWorkProvince').combobox('getValue')

    });
}

function queryCancel(){
	   $('#queryForm').form('clear');
	    $('#qyIncomeScopes').combobox('setValue','');
	    $('#qrWorkYear').combobox('setValue','');
	    $('#qyWorkProvince').combobox('setValue','');
}

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
    prevent(event); 
}

/**
 * js初始化页面DataGrid
 */
function initInfoGrid(){
   $("#employeeList").datagrid({
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
       url: '${ctx}/base/employeeFind/getEmployeeInfoByPage',
       onDblClickRow:function(rowIndex, rowData){
       },
       onLoadError: function(){
           $.messager.alert('错误信息','信息查询失败!','error');
       },
       columns:[[
           {title:'登录名',field:'loginName',width:80},
           {title:'手机',field:'mobile',width:80},
           {title:'邮箱',field:'email',width:120},
           {title:'姓名',field:'name',width:100},
           {title:'年收入范围',field:'incomeScope',width:60,hidden:true},
           {title:'年收入范围',field:'incomeScopeDesc',width:60,align:'center'},
           {title:'工作时间',field:'workYear',width:60,hidden:true},
           {title:'工作时间',field:'workYearDesc',width:60,align:'center'},
           {title:'工作时间',field:'workProvince',width:60,hidden:true},
           {title:'工作省市',field:'workProvinceDesc',width:60,align:'center'},
           {title:'用户状态',field:'statusDesc',width:60,align:'center'},
           {title:'操作',field:'operId',width:240,align:'center',
               formatter : function(value, row, index) {
                   var opt='';
                   opt += '<button val="'+value+'" onclick="detailInfo(\''+index +'\')" class="easyui-linkbutton">详情>></button>';
                   opt +='&nbsp;&nbsp;';
                   opt += '<button val="'+value+'" onclick="resourceList(\''+value +'\')" class="easyui-linkbutton">资源类表>></button>';
                   opt +='&nbsp;&nbsp;';
                   opt += '<button val="'+value+'" onclick="groupList(\''+value +'\')" class="easyui-linkbutton">所属组列表>></button>';
                   return opt;
               }
           }
       ]]
   });
}

/**
 * 初始化 用户所属组Grid
 */
function initBelongGroupGrid(){
	   // 初始化
    $('#webGroupList').datagrid({
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        rownumbers: true,
        checkOnSelect: false,
        selectOnCheck: false,
        singleSelect:true,
        fitColumns:true,
        method:'post',
        fit:true,
        loadMsg: '加载数据，请稍候...',
        columns : [[
            {field:'id',title:'组代码',width:250,align:'center'},
            {field:'name',title:'组名称',width:150,align:'center'},
            {field:'state',title:'状态',width:100,align:'center'},
            {field:'type',title:'组类型',width:100,align:'center'}
        ]]
    });
}

/**
 * 打开详情页面
 */
function detailInfo(index){
	$('#employeeList').datagrid('selectRow', index);
    var gridNode = $('#employeeList').datagrid('getSelected');
    var userNo = gridNode.userNo;
    var userName = gridNode.name;
    if(userName!=null){
    	self.parent.openTab('查看：' + userName, '${ctx}/base/employeeFind/info/' + userNo);
    }else{
    	self.parent.openTab('查看：', '${ctx}/base/employeeFind/info/' + userNo);
    }
    
}

/**
 * 获取归属资源列表
 */
function initBelongResourceGrid(){
    $('#webResourceList').datagrid({
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        rownumbers: true,
        singleSelect:true,
        fitColumns:true,
        method:'post',
        fit:true,
        loadMsg: '加载数据，请稍候...',
        columns : [[
            {field:'name',title:'资源名称',width:150,align:'center'},
            {field:'permission',title:'权限字符',width:350,align:'center'},
            {field:'type',title:'资源类型',width:100,align:'center'},
            {field:'remark',title:'描述',width:250,align:'center'}
        ]]
    });
}

/**
 * 资源列表
 */
function resourceList(userNo){
	$('#resourceDialog').dialog('open');
	   $.ajax({
	        type : 'POST',
	        async: false,
	        url : '${ctx}/base/employeeFind/getResources',
	        data : {
	            userNo: userNo
	        },
	        success : function(data, status) {
	            $('#webResourceList').datagrid('loadData', data);
	        },
	        error : function(data, status) {
	            $('#webResourceList').datagrid('loadData', { total: 0, rows: [] });
	            showSlideMessage("获取资源信息失败！");
	        },
	        datatype : "json"
	    });
	
}

//进入所属组列表页面
function groupList(userNo) {

	$('#groupDialog').dialog('open');
	$.ajax({
        type : 'POST',
        async: false,
        url : '${ctx}/base/employeeFind/getGroups',
        data : {
            userNo: userNo
        },
        success : function(data, status) {
            $('#webGroupList').datagrid('loadData', data);
        },
        error : function(data, status) {
            $('#webGroupList').datagrid('loadData', { total: 0, rows: [] });
            showSlideMessage("获取组信息失败！");
        },
        datatype : "json"
    });
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

</script>
</body>
</html>