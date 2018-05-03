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
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:100px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label for="qyInfStatus">审核状态:</label></td>
                    <td>
                        <select id="qyInfStatus" class="easyui-combobox" panelHeight="auto" name="infStatus" style="width:160px;" data-option="editable:false">
                            <c:forEach items="${infoStatus}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label for="qyEmpName">客户名称:</label></td>
                    <td><input id="qyEmpName" name="name" style="width:160px;" class="easyui-validatebox"></td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itEmployeeInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
</div>
<script type="text/javascript">
    var isOpenFlag = "0";
	/*初始化*/
	$(document).ready(function() {
	    $("#btnQuery").bind("click", function(){
	        queryInfo();
	    });
	    // 查询取消按钮事件
	    $("#btnCancel").bind("click", function(){
	        queryCancel();
	    });
	    initFileGroupGrid();
	
	    disEditCombobox();
	    
	    //默认查询 已提交待审核 的下拉列表数据 为2 
	    $('#qyInfStatus').combobox('setValue','2');
	});

/**
 * 编辑下拉框不可编辑，选择时间
 */
function disEditCombobox(){
	
    $("#qyInfStatus").combobox({
        editable:false,
        onSelect: function(rec){
        	$("#btnQuery").click();
    	}
    });
}

/**
 * 查询分页数据
 */
function queryInfo(){
	//alert($('#qyInfStatus').combobox('getValue'));

    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#itEmployeeInfo').datagrid('load',{
        infoStatus: $('#qyInfStatus').combobox('getValue'),
        name: $('#qyEmpName').val()
    });
    disPagelistOption();
}

/**
 * 清空查询结果
 */
function queryCancel(){
	// 默认查询 已提交 待审核
    $('#qyInfStatus').combobox('setValue','2');
    $('#qyEmpName').val("");
    $("#btnQuery").click();
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    //$(".pagination-page-list").attr('disabled','disabled');
    $(".pagination-num").attr('disabled','disabled');
}

/**
 * js初始化法人代表页面查询列表DataGrid
 */
function initFileGroupGrid(){
    $("#itEmployeeInfo").datagrid({
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
        url: '${ctx}/base/employee/getEmpInfoByPage',
        onLoadSuccess: function(data){
            if(data.total==0){
                showSlideMessage("没有查询到相关的记录");
            }
        },
        onLoadError: function(){
             $.messager.alert('错误信息','信息查询失败!','error');
        },
        onDblClickRow:function(rowIndex, rowData){

        },
        columns:[[
            {field:'name',title:'客户姓名',align:'center',width:100},   
            {field:'identType',title:'证件类型',align:'center',width:100,hidden:true},
            {field:'identTypeDesc',title:'证件类型',align:'center',width:100},
            {field:'identNo',title:'证件号',align:'center',width:200},
            {field:'infoStatus',title:'资料审核状态',align:'center',width:100,hidden:true},
            {field:'infoStatusDesc',title:'资料审核状态',align:'center',width:100}, 
            {field:'time',title:'上传时间',align:'center',width:100}, 
            {field:'userNo',title:'操作',width:80,align:'center', 
                formatter : function(value, row, index) {
                    var opt='';
                    //opt += '<a href="javascript:void(0);" val="'+value+'" onclick="detailInfo(\''+index +'\')" class="easyui-linkbutton">查看</a>';
                    opt += '<button onclick="detailInfo('+index +')" class="easyui-linkbutton">查看</button>';
                    opt += '<button onclick="auditEmployee('+index +')" class="easyui-linkbutton">审核</button>';
                    opt +='&nbsp;&nbsp;&nbsp;&nbsp;';
                    //opt += '<a href="javascript:void(0);" val="'+value+'" onclick="auditEmployee(\''+index +'\')" class="easyui-linkbutton">审核</a>';
                    return opt;
                }
             }
        ]]
    });
}

/**
 * 显示法人明细信息
 */
function detailInfo(index){
	
	// 选中当前记录
	$('#itEmployeeInfo').datagrid('selectRow', index);     
	var data = $('#itEmployeeInfo').datagrid('getSelected');
	if(data.name==null) {
		self.parent.openTab('查看','${ctx}/base/employee/info/'+ data.userNo);
	} else {
		self.parent.openTab('查看：'+data.name,'${ctx}/base/employee/info/'+ data.userNo);
	}
}
/**
 * 审核明细
 */
function auditEmployee(index){
	// 选中当前记录
	$('#itEmployeeInfo').datagrid('selectRow', index);     
	var data = $('#itEmployeeInfo').datagrid('getSelected');
	var infoStatus = data.infoStatus;
	var userNo = data.userNo;
	var name = data.name;
	
 	if(infoStatus == 3) {
		$.messager.alert('温馨提示','审核已通过，无需重新审核！');
		return;
	} else if(infoStatus == 1) {
		$.messager.alert('温馨提示','客户还未提交任何资料，无需进行审核！');
		return;
	} else if(infoStatus == 4) {
		$.messager.alert('温馨提示','审核不通过，无需审核！');
		return;
	} else {
		if(name==null) {
			self.parent.openTab('审核','${ctx}/base/employee/audit/'+ userNo);
		} else{
			self.parent.openTab('审核：'+name,'${ctx}/base/employee/audit/'+ userNo);		
		}
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

	//关闭Ajax相应的缓存,解决IE不刷新个人用户审核状态的bug
$.ajaxSetup ({
	cache: false
});
	
/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnQuery = $("#btnQuery");
    
    // 点击 查询 按钮
    if(event.keyCode == 13 && isOpenFlag =="0"){
    	btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}
</script>
</body>
</html>