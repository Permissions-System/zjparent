<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>每日实时数据分析</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<SCRIPT src= "${path}/static/js/kaiyun/Clock.js" type= text/javascript></SCRIPT >
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	function reload_dg(){
		$('#datagrid').datagrid('reload',{}); 
	}
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="每日实时数据分析" class="easyui-datagrid" fit="true"
			url="${path}/dailyRealTime/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th id="titleDate" data-options="field:'timeName',width:100,align:'center'" ></th>
					<th data-options="field:'regcnt',width:100,align:'center'" >注册人数</th>
					<th data-options="field:'openactnum',width:100,align:'center'" >开户人数</th>
					<th data-options="field:'investamount',width:100,align:'center',formatter:formatCurrency" >投资金额（万）	</th>
					<th data-options="field:'investpernum',width:100,align:'center'" >投资人数</th>
					<th data-options="field:'avgAmt',width:100,align:'center',formatter:formatCurrency" >人均投资金额（万）	</th>
					<th data-options="field:'platformrechargepernum',width:100,align:'center'" >平台充值人数</th>
					<th data-options="field:'platformrechargeamount',width:100,align:'center',formatter:formatCurrency" >平台充值金额（万）</th>
					<th data-options="field:'platformwithdrawpernumber',width:100,align:'center'" >平台提现人数	</th>
					<th data-options="field:'platformwithdrawamount',width:100,align:'center',formatter:formatCurrency" >平台提现金额（万）</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form action="" method="get">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					现在时间：
					<SPAN id= clock style ="color : blue;"></SPAN >
					<script type="text/javascript">
						var clock = new Clock();
						clock.display(document.getElementById("clock" ));
					</script>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:reload_dg()" id="submit_search" class="easyui-linkbutton" >刷新</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
