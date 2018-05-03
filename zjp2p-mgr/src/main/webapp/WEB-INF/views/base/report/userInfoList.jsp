<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>java_mgr_用户注册开户列表</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//快速查询
 	function searchUserQ()
	{
		var flag = true;
 		var regBeginTime = $("input[name='regBeginTime']").val();
 		var regEndTime = $("input[name='regEndTime']").val();
 		var accountBeginTime = $("input[name='accountBeginTime']").val();
 		var accountEndTime = $("input[name='accountEndTime']").val();
 		var isKH = $("input[name='isKH']").val();
 		//alert(isKH);
 		
 		if(regEndTime!=null && regEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(regEndTime))
			{
			　　regEndTime = regEndTime +" 23:59:59";
			}
 		}
 		if(accountEndTime!=null && accountEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(accountEndTime))
			{
			　　accountEndTime = accountEndTime +" 23:59:59";
			}
 		}
 		$('#datagrid').datagrid('reload',{
 				regBeginTime: regBeginTime,
		 		regEndTime: regEndTime,
		 		accountBeginTime: accountBeginTime,
		 		accountEndTime: accountEndTime,
		 		isKH: isKH,
			});
	}
	
	//导出Excel 	
	function redirectURL()
	{
 		var regEndTime = $("input[name='regEndTime']").val()	;
 		var accountEndTime = $("input[name='accountEndTime']").val();
 		
 		if(regEndTime!=null && regEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(regEndTime))
			{
			　　regEndTime = regEndTime +" 23:59:59";
			}
 		}
 		if(accountEndTime!=null && accountEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(accountEndTime))
			{
			　　accountEndTime = accountEndTime +" 23:59:59";
			}
 		}
 		$("input[name='regEndTime']").attr("value",regEndTime); 
 		$("input[name='accountEndTime']").attr("value",accountEndTime);  
		$("#paramForm").submit();
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
 		if(hasfuiou==0 )
 		{
 			result="未开户";
 		}
 		else if(hasfuiou==1)
		{
			result="已开户";
		}
		else
		{
			result="";
		}
 		return result;
 	}
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="根据渠道码获取注册用户" class="easyui-datagrid" fit="true"
			url="${path}/userInfo/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'id',width:100,align:'center'" >用户Id</th>
					<th data-options="field:'username',width:100,align:'center',formatter:formatMobile" >用户名</th>
					<th data-options="field:'isKH',width:100,align:'center',formatter:formatHasfuiou" >是否开户</th>
					<th data-options="field:'accountdate',width:100,align:'center',formatter:CEdit"" >开户时间</th>
					<th data-options="field:'registerdate',width:100,align:'center',formatter:CEdit"">注册时间</th>
					<!-- <th data-options="field:'hasfuiou',width:100,align:'center',formatter:formatHasfuiou" >富有开户</th>
					<th data-options="field:'sourcetype',width:100,align:'center',formatter:formatHasfuiou" >连连开户</th> -->
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/userInfo/exportExcel" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					注册时间  :  
					<input class="easyui-datebox" style="width:100px" name="regBeginTime" id="regBeginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="regEndTime" id="regEndTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					&nbsp;&nbsp;&nbsp;
					开户时间  :  
					<input class="easyui-datebox" style="width:100px" name="accountBeginTime" id="accountBeginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="accountEndTime" id="accountEndTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					&nbsp;&nbsp;&nbsp;
					开户：
					<select class="easyui-combobox" name="isKH" id="isKH" panelHeight="auto" style="width:100px">
						<option value="">全部</option>
						<option value="1">已开户</option>
						<option value="0">未开户</option>
					</select>
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
					<!-- <a href="javascript:exportExcel();" class="easyui-linkbutton" >导出</a> -->
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
