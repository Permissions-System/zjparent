<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>代理人-渠道投资详情</title>
<%@include file="../../pub/header.jsp"%>
<!-- 引入自己的js -->
<script src="${ctx}/static/js/kaiyun/main.js" type="text/javascript"></script>
<style type="text/css">
input,select{
	width:180px;
}
.itemMagin{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<!-- begin 查询刷选条件 -->
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="get" action="${ctx}/lendInfo/exportExcel/5">
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin" >
                    <td align="center" width="80px;"><label>投资时间  : </label></td >
                    <td width="500px;"> 
						<input class="easyui-datebox"  name="beginTime" id="beginTime" >
						-
						<input class="easyui-datebox"  name="endTime" id="endTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					</td>
                    <td></td>
                    <td> 
                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                        <a href="javascript:redirectURL();" class="easyui-linkbutton" data-options="iconCls:'icon-print'" id="btnImport">导出Excel</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
		        <table id="paramInfo">
        		</table>
    </div>
</div>
<!-- end 查询刷选条件 -->
<script type="text/javascript">
var isOpenFlag = "0";

$(document).ready(function(){
    // 查询
    $("#btnQuery").bind("click", function(){
    	search();
    });
    
    // 清理查询内容
    $("#btnCancel").bind("click", function(){
        queryCancel();
    });
    
    // 导出
    $("#btnImport").bind("click", function(){
    	redirectURL();
    });   


    // 类型Dialog弹出框关闭处理
    $('#paramDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
	// 初始化
	initParamInfoGrid();
	
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#saveInfo");
    // 查询按钮
    var btnQuery = $("#btnQuery");
    // 点击 Enter按钮
    /* if(event.keyCode == 13 && isOpenFlag =="1"){
        //btnOjb.click();
        event.returnValue = false;
    }  */
    
    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag =="0"){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

// 初始化页面Grid
function initParamInfoGrid(){
	$('#paramInfo').datagrid({
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20,30,40,50],
	    nowrap: false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        loadMsg: '加载数据，请稍候...',
	    url:'${ctx}/lendInfo/five/datagrid',  
	    title:'投资管理数据分析（1首次投资 2剔除重复投资 3不包含被邀请的 ）',
	    columns:[[    
	         {field:'temp2',title:'用户Id',width:$(this).width() * 0.1,align:'center',halign:'center'},
	         {field:'username',title:'用户名',width:$(this).width() * 0.1,align:'center',halign:'center',
	        	 formatter: function(num, row, index)
	        	 {
	        		  var str = num ;
	        			var reg = /1(\d{2})\d{4}(\d{4})/g;
	        			str = str.replace(reg,"1$1****$2");
	        			return str;
	        	 }}, 
	         {field:'temp3',title:'开户时间',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center'},
	         {field:'temp1',title:'注册时间',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center'},
	         {field:'temp4',title:'投资项目',width:$(this).width() * 0.2,align:'left',halign:'center'},
	         {field:'dateline',title:'项目期限(月)',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center'},
	         {field:'incomecount',title:'项目期限(天)',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center'},
	         {field:'lendmoney',title:'投资金额',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center',formatter:formatCurrency},
	         {field:'lenddate',title:'投资时间',width:$(this).width() * 0.2,align:'left',halign:'center',align:'center',formatter:CEdit}
	    ]],
	    //toolbar: '#toolbar',
	    onLoadSuccess: function(data){
			if(data.total==0){
				showSlideMessage("没有记录。");
			}
	    },
	    onLoadError: function(){
	        $.messager.alert('错误信息','信息查询失败!','error');
	    }
	});
}


/**
 * 必输项目的校验
 */
function checkNull(){
	var productCode=$('#productCode').combobox('getValue');
	if(isNull(productCode)){
		$.messager.alert('温馨提示','产品代码不能为空！','info');
		return false;
	}
	var readFlag=$('#readFlag').combobox('getValue');
	if(isNull(readFlag)){
		$.messager.alert('温馨提示','是否可编辑不能为空！','info');
		return false;
	}
	return true;
}

/**
 * 查询
 */
function search(){
	var flag = true;
		var beginTime = $("input[name='beginTime']").val();
		var endTime = $("input[name='endTime']").val();
		
		if(endTime!=null && endTime!=''){
			var sear=new RegExp('23:59:59');
			if(!sear.test(endTime))
			{
			　　endTime = endTime +" 23:59:59";
			}
		}
		$('#paramInfo').datagrid('reload',{
	 		beginTime: beginTime,
	 		endTime: endTime
		});
	return false;
}
/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
}

$.extend($.fn.validatebox.defaults.rules, {
	enNameValid: {        //[^a-zA-Z0-9\(\)\s/\_（\）\/.\/:]
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9_:]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、下划线或冒号组成'
	},
	valueValid: {
		validator: function(value, param){
			var p = new RegExp('[`~\\\\!@#\u4E00-\u9FA5\\%\^\*\(\)\+<>\"{},;\'\[\\]]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、下划线、空格、URL或冒号组成'
	},
	cnNameValid: {        
		validator: function(value, param){
			var p = new RegExp('[`~\\\\!@#\\$%\^&\*\+<>\"{},;_\'\[\\]]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、中文字符、下划线或冒号组成'
	}
});
//导出Excel 	
function redirectURL()
{
		var endTime = $("input[name='endTime']").val()	;
		
		if(endTime!=null && endTime!=''){
			var sear=new RegExp('23:59:59');
		if(!sear.test(endTime))
		{
		　　endTime = endTime +" 23:59:59";
		}
		}
		$("input[name='endTime']").attr("value",endTime);  
	$("#queryForm").submit();
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
