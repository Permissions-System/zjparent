<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cps-cpa渠道数据分析</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

//快速查询
function searchUserQ()
{
	var cpscode = $("input[name='cpscode']").val();
	var beginTime = $("input[name='beginTime']").val();
	var endTime = $("input[name='endTime']").val();
		
	/* if(endTime!=null && endTime!=''){
			endTime = endTime +" 23:59:59";
		} */
	
 	$('#datagrid').datagrid('reload',{
 		cpscode: cpscode,
 		beginTime: beginTime,
 		endTime: endTime
	}); 
}
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="cps-cpa渠道数据分析" class="easyui-datagrid" fit="true"
			url="${path}/cps/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th field="id" width="30" align="center">编号</th>
					<!-- <th data-options="field:'curdate',width:100,align:'center',formatter:CEdit">日期</th> -->
					<th field="cpscode" width="100" align="center">渠道编号</th>
					<th field="cpsname" width="100" align="center">渠道名称</th>
					<th field="regcnt" width="30" align="center">注册数</th>
					<th field="openaccnt" width="30" align="center">开户数</th>
					<th data-options="field:'investamount',width:100,align:'center',formatter:formatCurrency">投资金额</th>
					<th field="investcnt" width="30" align="center">投资人数</th>
					<th data-options="field:'avginvestamount',width:100,align:'center',formatter:formatCurrency">人均投资额</th>
					<th field="investrate" width="50" align="center">投资转化率</th>
					<th field="remark" width="100" align="center">备注</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="toolbar">
			<a href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="addUser();">新增用户</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true" onclick="editUser();">编辑用户</a> <a
				href="javascript:void(0);" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true" onclick="deleteUser();">删除用户</a>
		</div>
		<div id="tb" style="padding:5px;height:auto">
			<!-- <div style="margin-bottom:5px">
				<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
			</div> -->
			<div>
				<form id="form_search" action="${path}/cps/datagrid" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;
					渠道数据: <input class="easyui-datebox" style="width:100px" name="beginTime">
					-
					<input class="easyui-datebox" style="width:100px" name="endTime">
					&nbsp;&nbsp;&nbsp;
					渠道编号: <input class="easyui-textbox"  style="width:100px" name="cpscode"> 
					<!-- <select class="easyui-combobox" panelHeight="auto" style="width:100px">
						<option value="java">Java</option>
						<option value="c">C</option>
						<option value="basic">Basic</option>
						<option value="perl">Perl</option>
						<option value="python">Python</option>
					</select> -->
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">统计</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- <a href="#" class="easyui-linkbutton" >导入</a>
					<a href="#" class="easyui-linkbutton" >导出</a> -->
				</form>
			</div>
		</div>

		<!-- 对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">新增用户</div>
			<form id="fm" method="post" novalidate>
				<div class="fitem">
					<label>用户名:</label> <input name="username" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>密码:</label> <input name="password" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>Email:</label> <input name="email" class="easyui-textbox"
						validType="email">
				</div>
			</form>
		</div>

		<!-- 对话框按钮 -->
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton c6"
				iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
				style="width:90px">取消</a>
		</div>
	</div>
</body>
</html>
