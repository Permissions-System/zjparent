<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>java_mgr_用户开户列表</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//快速查询
 	function searchUserQ()
	{
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
 		$('#datagrid').datagrid('reload',{
		 		beginTime: beginTime,
		 		endTime: endTime,
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
			url="${path}/userInfo/datagrid/kh"  pagination="true" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'id',width:100,align:'center'" >用户Id</th>
					<th data-options="field:'username',width:100,align:'center',formatter:formatMobile" >用户名</th>
					<th data-options="field:'registerdate',width:100,align:'center',formatter:CEdit"">注册时间</th>
					<th data-options="field:'isKH',width:100,align:'center',formatter:formatHasfuiou" >是否开户</th>
				</tr>
			</thead>
		</table>
		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/userInfo/exportExcel/kh" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					注册时间  :  
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
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
