<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>投资管理</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	$("#submit_search").click(function () {
		alert("111");
        $("#form_search").submit();
    });
	
	//快速查询
 	function searchUserQ()
	{
 		var lendid = $("input[name='lendid']").val();
 		var lendproject = $("input[name='lendproject']").val();
 		var username = $("input[name='username']").val();
 		var promocode = $("input[name='promocode']").val();
 		var lendBeginTime = $("input[name='lendBeginTime']").val();
 		var lendEndTime = $("input[name='lendEndTime']").val();
 		var repayBeginTime = $("input[name='repayBeginTime']").val();
 		var repayEndTime = $("input[name='repayEndTime']").val();
 		
 		if(lendEndTime!=null && lendEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(lendEndTime))
			{
			　　endTime = lendEndTime +" 23:59:59";
			}
		}
 		if(repayEndTime!=null && repayEndTime!=''){
 			var sear=new RegExp('23:59:59');
			if(!sear.test(repayEndTime))
			{
			　　repayEndTime = repayEndTime +" 23:59:59";
			}
		} 
		
		
	 	$('#datagrid').datagrid('load',{
	 		lendid: lendid,
	 		lendproject: lendproject,
	 		username: username,
	 		promocode: promocode,
	 		lendBeginTime: lendBeginTime,
	 		lendEndTime: lendEndTime,
	 		repayBeginTime: repayBeginTime,
	 		repayEndTime: repayEndTime
		}); 
	}
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="投资管理数据分析" class="easyui-datagrid" fit="true"
			url="${path}/invest/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="false" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<!-- <th data-options="field:'username',width:100" >用户名</th>
					<th data-options="field:'regdate',width:100,formatter:CEdit">注册时间</th>
					<th data-options="field:'lenddate',width:100,formatter:CEdit" >投资时间</th>
					<th data-options="field:'lendmoney',width:100,formatter:formatCurrency">投资金额</th> -->
					
					
					<th data-options="field:'promocode',width:100,align:'center'" >渠道</th>
					<th data-options="field:'username',width:100,align:'center'" >投资人</th>
					<th data-options="field:'sex',width:100,align:'center'" >性别</th>
					<th data-options="field:'age',width:100,align:'center'" >年龄</th>
					<th data-options="field:'area',width:100,align:'center'" >地域</th>
					<th data-options="field:'lendid',width:100,align:'center'" >项目编号</th>
					<th data-options="field:'lendproject',width:350,align:'center'" >项目名称</th>
					<th data-options="field:'lendmoney',width:100,align:'center',formatter:formatCurrency" >投资本金</th>
					<th data-options="field:'realmoney',width:100,align:'center',formatter:formatCurrency" >实付金额</th>
					<th data-options="field:'deductmoney',width:100,align:'center',formatter:formatCurrency" >扣款金额</th>
					<th data-options="field:'yearrate',width:100,align:'center'" >年利率</th>
					<th data-options="field:'timelimit',width:100,align:'center'" >期限</th>
					<th data-options="field:'suminvestcnt',width:100,align:'center'" >累计投资次数</th>
					<th data-options="field:'lenddate',width:150,align:'center',formatter:CEdit" >投资日期</th>
					<th data-options="field:'previnvestdate',width:150,align:'center',formatter:CEdit" >上一次投资时间</th>
					<th data-options="field:'repaydate',width:150,align:'center',formatter:CEdit" >还款日期</th>
					<th data-options="field:'expiredate',width:150,align:'center',formatter:CEdit" >资金到期日期</th>
					<th data-options="field:'regdate',width:150,align:'center',formatter:CEdit" >注册时间</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;">
			<div >
				<form id="" action="" method="post">
					项目编号：<input class="" style="width:100px" name="lendid" >
					项目名称：<input class="" style="width:100px" name="lendproject" >
					会员名称：<input class="" style="width:100px" name="username" >
					渠道编码：<input class="" style="width:100px" name="promocode" >
					投资日期 : 
					<input class="easyui-datebox" style="width:100px" name=lendBeginTime>
					- 
					<input class="easyui-datebox" style="width:100px" name="lendEndTime">
					还款日期 : 
					<input class="easyui-datebox" style="width:100px" name="repayBeginTime">
					- 
					<input class="easyui-datebox" style="width:100px" name="repayEndTime">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
