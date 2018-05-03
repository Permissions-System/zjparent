<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>代理人-渠道投资详情</title>
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
 		
 		/* if((beginTime==null && beginTime=='') || (beginTime==null && beginTime=='') ){
 			alert
 		}else{
 			endTime = endTime +" 23:59:59";
 			$('#datagrid').datagrid('reload',{
 		 		beginTime: beginTime,
 		 		endTime: endTime
 			});
 		} */
 		
 		if(endTime!=null && endTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(endTime))
			{
			　　endTime = endTime +" 23:59:59";
			}
 		}
 		$('#datagrid').datagrid('reload',{
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
	
/* 	//导出Excel 	
	function exportExcel()
	{
		$.get(path+"/lendInfo/exportExcel",{},function(result){
			if (result.success){
			} else {
				alert("error");
			} 						
		}); 
	}
*/	
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="投资管理数据分析（1首次投资 2剔除重复投资 3包含22%专项标、金钱包、债权转让 4不包含被邀请的 5定期 ）" class="easyui-datagrid" fit="true"
			url="${path}/lendInfo/three/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'temp2',width:100,align:'center'" >用户Id</th>
					<th data-options="field:'username',width:100,align:'center',formatter:formatMobile" >用户名</th>
					<th data-options="field:'temp3',width:100,align:'center'" >开户时间</th>
					<th data-options="field:'temp1',width:100,align:'center'">注册时间</th>
					<th data-options="field:'temp4',width:100,align:'center'">投资项目</th>
					<th data-options="field:'dateline',width:100,align:'center'">项目期限(月)</th>
					<th data-options="field:'incomecount',width:100,align:'center'">项目期限(天)</th>
					<th data-options="field:'lendmoney',width:100,align:'center',formatter:formatCurrency">投资金额</th>
					<th data-options="field:'lenddate',width:100,align:'center',formatter:CEdit" >投资时间</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/lendInfo/exportExcel/3" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					投资时间  :  
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
					<!-- <a href="javascript:exportExcel();" class="easyui-linkbutton" >导出</a> -->
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:queryCancel();" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" data-options="iconCls:'icon-print'" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
