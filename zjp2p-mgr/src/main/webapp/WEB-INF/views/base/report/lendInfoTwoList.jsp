<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>O2O市场部渠道投资详情</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

/*
 * 快速查询	
 */
function searchUserQ()
{
	/* var flag = true;
	var hasfuiou = $("input[name='hasfuiou']").val();
	var beginTime = $("input[name='beginTime']").val();
	var endTime = $("input[name='endTime']").val();
	var isjwd = $("input[name='isjwd']").val();
		
		if(endTime!=null && endTime!=''){
			endTime = endTime +" 23:59:59";
		}
		$('#datagrid').datagrid('reload',{
			hasfuiou: hasfuiou,
	 		beginTime: beginTime,
	 		endTime: endTime,
	 		isjwd: isjwd
		}); */
	var flag = true;
	var hasfuiou = $("input[name='hasfuiou']").val();
	var beginTime = $("input[name='beginTime']").val();
	var endTime = $("input[name='endTime']").val();
		
		if(endTime!=null && endTime!=''){
			var sear=new RegExp('23:59:59');
			if(!sear.test(endTime))
			{
			　　endTime = endTime +" 23:59:59";
			}
		}
		$('#datagrid').datagrid('reload',{
			hasfuiou: hasfuiou,
	 		beginTime: beginTime,
	 		endTime: endTime
		});
}
	
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
	$("#paramForm").submit();
}
	
/**
 * 清空查询条件
 */
function queryCancel(){
    $('#paramForm').form('clear');
}

/**
 * 格式化 是否开户 字段 
 *
 * @param num 数值(Number或者String)
 * @return 字符串,如0未开户,1已开户
 * @type String
 */
function formatHasfuiou(hasfuiou) 
{
	var result;
	if(hasfuiou==0)
	{
		result="未开户";
	}
	else if(hasfuiou==1)
	{
		result="已开户";
	}
	else
	{
		result="未知";
	}
	return result;
}


/**
 * 判断是否有经纬度 
 */
function isHavaLatitude(promoCode)
{
	var result;
　　var sear=new RegExp('_No');
　　if(sear.test(promoCode))
　　{
　　		result = "yes";
　　}else
	{
		result = "no";
	}
	return result;
}
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="O2O市场部渠道投资分析" class="easyui-datagrid" fit="true"
			url="${path}/lendInfo/two/datagrid"  pagination="true" toolbar="#tb" data-options="pageSize:50"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'mobile',width:100,align:'center'" >手机号</th>
					<th data-options="field:'temp1',width:100,align:'center'">注册时间</th>
					<th data-options="field:'hasfuiou',width:100,align:'center',formatter:formatHasfuiou">是否开户</th>
					<th data-options="field:'lendmoney',width:100,align:'center',formatter:formatCurrency">投资总金额</th>			
					<th data-options="field:'lenddate',width:100,align:'center',formatter:CEdit" >最后一次投资时间</th>
					<!-- <th data-options="field:'promoCode',width:100,align:'center',formatter:isHavaLatitude " >是否有经纬度</th> -->
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/lendInfo/two/exportExcel" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;
					注册时间  :  
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
<!-- 					&nbsp;&nbsp;&nbsp;
					推广渠道码：<input class="" style="width:100px" name="promoCode" > -->
					&nbsp;&nbsp;&nbsp;
					是否开户：
					<select class="easyui-combobox" name="hasfuiou" id="yearStr" panelHeight="auto" style="width:100px">
						<option value="">全部</option>
						<option value="1">已开户</option>
						<option value="0">未开户</option>
					</select>
					<!-- &nbsp;&nbsp;&nbsp;
					是否有经纬度：
					<select class="easyui-combobox" name="isjwd" id="isjwd" panelHeight="auto" style="width:100px">
						<option value="0">全部</option>
						<option value="1">yes</option>
						<option value="2">no</option>
					</select> -->
					<div style="float: right;margin-right: 50px;">
						<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:queryCancel();" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:redirectURL();" class="easyui-linkbutton" data-options="iconCls:'icon-print'" >导出Excel</a>
					</div>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
