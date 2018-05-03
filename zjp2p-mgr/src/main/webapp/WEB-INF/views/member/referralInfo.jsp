<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery.number.min.js"></script>
<style type="text/css">
.my_td_label {
	padding-left: 10px;
	height: 25px;
	text-align: left;
	font-size: 13px;
	color: #3A316F;
	vertical-align: bottom;
	nowrap: nowrap; //
	font-weight: bold;
}

.my_td_text {
	font-size: 12px;
}

#infoForm {
	margin: 10 30 0 10
}

#PWDPanel tr,#infoForm tr {
	height: 40px;
}

#PWDPanel label,#infoForm td {
	padding-left: 60px;
	padding-top: 20px;
}

/* #infoForm input,.easyui-combobox,.easyui-combotree {
	width: 180px;
}  */
</style>
</head>
<body >
	<div class="easyui-layout" data-options="fit:true,selected:true">
		<div class="datagrid-toolbar"
						data-options="region:'north',split:true,title:'查询'"
						style="height: 130px; padding: 20px 0px 10px 30px">
			<table cellpadding="5">
				<tr>
					<td>用户id: </td>
					<td>${member.id}</td>
				</tr>
				<tr>
					<td>用户账号: </td>
					<td>${member.email}</td>
				</tr>
				<tr>
					<td>用户姓名: </td>
					<td>${member.realname}</td>
				</tr>
			</table>
		</div>
		<div data-options="region:'center',border:true,title:'列表'">
			<table id="invesTransInfo"
				data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
			</table>
		</div>
	</div>
	<script type="text/javascript">
	var memberId = '${memberId}';
		$(document).ready(function() {
			// 页面初始化

			// 初始化页面Grid
			initDataGridInvestTrans();

			disPagelistOption();
		});


		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOption() {
			//$(".pagination-page-list").attr('disabled','disabled');
			$(".pagination-num").attr('disabled', 'disabled');
		}


		/*
		 * 统一弹出侧边消息提示
		 */
		function showSlideMessage(msg) {
			$.messager.show({
				title : '提示',
				msg : msg,
				timeout : 4000,
				showType : 'slide'
			});
		}

		/**
		 * js初始化页面DataGrid
		 */
			function initDataGridInvestTrans() {
				$("#invesTransInfo")
						.datagrid(
								{
									pagination : true,
									rownumbers : true,
									pageSize : 10,
									pageList : [ 10, 20 ],
									nowrap : false,
									autoRowHeight : false,
									striped : true,
									border : false,
									fitColumns : true,
									method : 'post',
									singleSelect : true,
									fit : true,
									url : '${ctx}/member/getInvertTrans.do?memberId='+memberId,
									onSelect : function(rowIndex, rowData) {
									},
									onLoadError : function() {
										showSlideMessage("信息查询失败!");
									},
									columns : [ [
											{
												title : '订单号',
												field : 'investordercode',
												width : 190
											},
											{
												title : '标的名称',
												field : 'bidclassname',
												width : 100
											},
											{
												title : '标的编号',
												field : 'bidcode',
												width : 170
											},
											{
												title : '交易时间',
												field : 'orderdate',
												width : 150,
												formatter : function(value, rec) {
													var date = new Date(value);
													return date.format('yyyy-mm-dd HH:MM:ss');
												}
											},
											
											{
												title : '年化收益率%',
												field : 'annualizedrate',
												width : 70
											},
											{
												title : '每份金额',
												field : 'mininvestamount',
												width : 80,
												formatter : function(value, rec) {
													return $.number(value,2);
												}
											},
											{
												title : '份数',
												field : 'sharenumber',
												width : 50
											},
											{
												title : '交易金额(元)',
												field : 'amount',
												width : 100,
												formatter : function(value, rec) {
													return $.number(value,2);
												}
											},
											{
												title : '使用红包金额',
												field : 'bonusamount',
												width : 100,
												formatter : function(value, rec) {
													return $.number(value,2);
												}
											} ] ]
								});
			}


	</script>
</body>
</html>