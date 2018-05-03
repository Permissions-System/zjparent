<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>根据手机号查归属地</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//快速查询
 	function searchUserQ()
	{
		/* var flag = true;
 		var beginTime = $("input[name='beginTime']").val();
 		var endTime = $("input[name='endTime']").val();
 		var city = $("input[name='city']").val();
 		
 		if(endTime!=null && endTime!=''){
 			endTime = endTime +" 23:59:59";
 		}
 		$('#datagrid').datagrid('reload',{
		 		beginTime: beginTime,
		 		endTime: endTime,
		 		city: city
			}); */
 		var flag = true;
 		var city = $("input[name='city']").val();
 		
 		$('#datagrid').datagrid('reload',{
		 		city: city
			});
	}
	
 	//导出Excel 	
	function redirectURL()
	{
 		/* var endTime = $("input[name='endTime']").val()	;
 		if(endTime!=null && endTime!=''){
 			endTime = endTime +" 23:59:59";
 		}
 		$("input[name='endTime']").attr("value",endTime);  
		$("#paramForm").submit(); */
		$("#paramForm").submit();
	}
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="根据手机号查归属地" class="easyui-datagrid" fit="true"
			url="${path}/mobileGuiShu/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true" 
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'id',width:100,align:'center'" >Id</th>
					<th data-options="field:'mobile',width:100,align:'center'" >手机号</th>
					<th data-options="field:'province',width:100,align:'center'" >省份</th>
					<th data-options="field:'city',width:100,align:'center'" >城市</th>
					<th data-options="field:'areacode',width:100,align:'center'" >区号</th>
					<th data-options="field:'zip',width:100,align:'center'" >邮编</th>
					<th data-options="field:'company',width:100,align:'center'" >运营商</th>
					<th data-options="field:'card',width:100,align:'center'" >卡类型</th>
					<th data-options="field:'errorcode',width:100,align:'center'" >返回码</th>
					<th data-options="field:'reason',width:100,align:'center'" >返回说明</th>
					<th data-options="field:'username',width:100,align:'center'" >用户名</th>
					<th data-options="field:'createtime',width:100,align:'center',formatter:CEdit" >创建时间</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/mobileGuiShu/exportExcel" method="get">
					<!-- 省会：
					<select class="easyui-combobox" name="province" id="province" panelHeight="auto" style="width:100px">
						<option value="">全部</option>
						<option value="1">已开户</option>
						<option value="0">未开户</option>
					</select> -->
					城市：
					<select class="easyui-combobox" name="city" id="city" panelHeight="auto" style="width:100px">
						<option value="">全部</option>
						<option value="1">北京</option>
						<option value="2">上海</option>
						<option value="3">广州</option>
					</select>
					<!-- &nbsp;&nbsp;&nbsp;&nbsp;
					注册时间  :  
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime" > --><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
