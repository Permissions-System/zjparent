<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>复投状况信息</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<table id="datagrid" title="复投状况信息" class="easyui-datagrid" fit="true"
			url="${path}/afterVoting/datagrid"  
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false" data-options="pageSize:40">
			<thead>
				<tr>
					<th data-options="field:'next',width:100,align:'center'" >投资次数</th>
					<th data-options="field:'sumAmt',width:100,align:'center',formatter:formatCurrency" >投资金额(元)</th>
					<th data-options="field:'amtPercentage',width:100,align:'center'" >金额占比	</th>
					<th data-options="field:'countNumber',width:100,align:'center'" >投资人数</th>
					<th data-options="field:'numberPercentage',width:100,align:'center'" >人数占比</th>
				</tr>
			</thead>
		</table>

	</div>
</body>
</html>
