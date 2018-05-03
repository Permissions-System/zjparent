<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>时段首次投资查询</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

//初始化输入日期框
$(function(){
	var today = getYmd();
	　　$('#beginTime').datebox('setValue', today);	
	　   $('#endTime').datebox('setValue', today);	
	}); 

//快速查询
function searchUserQ()
{
	var falg = true;
	var beginTime = $("input[name='beginTime']").val();
	var endTime = $("input[name='endTime']").val();
	if(beginTime==null || beginTime=='' ){
		alert("请选择开始时间 ");
		falg=false;
	}
	if(endTime==null || endTime=='' ){
		alert("请选择结束时间  ");
		falg=false;
	}
	if(falg==true){
		$('#datagrid').datagrid('reload',{
	 		beginTime: beginTime,
	 		endTime: endTime
		});
	}
}

//导出Excel 	
function redirectURL()
{
	$("#paramForm").submit();
}

function getYmd()
{
	var year,month,date;
	var myDate = new Date();  
    year = myDate.getFullYear();   //获取完整的年份(4位,1970-????)  
    month = myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)  
    date = myDate.getDate();       //获取当前日(1-31)  
    return year+"-"+month+"-"+date;
}

</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="时段首次投资查询" class="easyui-datagrid" fit="true"
			url="${path}/dailyHeadInvestment/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'name',width:100,align:'center'" >姓名</th>
					<th data-options="field:'userName',width:100,align:'center'">用户名</th>
					<th data-options="field:'mobile',width:100,align:'center'" >手机号</th>
					<th data-options="field:'lendmoney',width:100,align:'center'" >首次投资金额</th>
					<th data-options="field:'lenddate',width:100,align:'center'" >首次投资时间</th>
					<th data-options="field:'recommPerson',width:100,align:'center' ">推荐人</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/dailyHeadInvestment/exportExcel" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					选择日期: 
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime">
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
