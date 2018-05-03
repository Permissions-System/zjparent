<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
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
<body onkeydown="bindingEnterKey(event)">
	<div class="easyui-layout" data-options="fit:true,selected:true">
		<div class="datagrid-toolbar"
			data-options="region:'north',split:true,title:'查询'"
			style="height: 130px; padding: 20px 0px 10px 30px">
			<form id="queryForm" method="post" novalidate>
				<table class="datagrid-toolbar"
					style="width: 100%; height: 70%; border: 0px; font-size: 12px">
					<tr>
						<td><label for="qyborrowername">借款机构:</label></td>
						<td><input id="qyborrowername" name="borrowername"
							class="easyui-validatebox" style="width: 155px;"></td>
						<td><label for="">产品类型:</label></td>
						<td>
							<div>
							<select id="qybidtype" class="easyui-combobox" panelHeight="auto"
									name="bidtype" style="width: 155px;">
       							<option value="">全部</option>
      							<c:forEach items="${bidtypes}" var="b">
  								<option value="${b.key}">${b.value}</option>
  	 							</c:forEach>
      						</select>
							</div>
						</td>
					</tr>
					<tr>
						<td><label for="qypayDateStart">付款日期:</label></td>
						<td colspan="3"><input id="qypayDateStart" name="payDateStart"
							class="easyui-datebox" style="width: 155px;"
							data-options="editable:false"> 
					        -- <input id="qypayDateEnd" name="payDateEnd"
							class="easyui-datebox" style="width: 160px;"
							data-options="editable:false"></td>
						<td><label for="qyborrowstatus">付款状态:</label></td>
						<td>
							<div>
								<select id="qyborrowstatus" class="easyui-combobox"
									panelHeight="auto" name="borrowstatus" style="width: 155px;" value="2">
									<option value="0">未付款</option>
									<option value="2" selected>已付款</option>
								</select>
							</div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							iconCls="icon-search" id="btnQuery">查询</a> <a href="#"
								class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a><a href="#"
							class="easyui-linkbutton" iconCls="icon-undo" id="btnExport">导出Excel</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:true,title:'列表'">
			<table id="itLogInfo"
				data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			// 页面初始化
			// 查询按钮绑定事件
			$('#itLogInfo').datagrid(
					{queryParams:{
						borrowstatus : $('#qyborrowstatus').combobox('getValue')
					}
					});
			$("#btnQuery").bind("click", function() {
				queryInfo();
			});

			$("#btnCancel").bind("click", function() {
				queryCancel();
			});
			
			// 初始化页面Grid
			initDataGrid();

			disPagelistOption();
			
			// 导出按钮事件
			$("#btnExport").bind("click", function() {
				queryExport();
			});
		});

		/**
		 * 绑定 按钮 按回车 激发按钮单击事件
		 */
		function bindingEnterKey(event) {
			// 保存按钮OJBJECT
			var btnQuery = $("#btnQuery");

			// 绑定 查询的 Enter
			if (event.keyCode == 13) {
				btnQuery.click();
				event.returnValue = false;
			}
			prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
		}

		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOption() {
			//$(".pagination-page-list").attr('disabled','disabled');
			$(".pagination-num").attr('disabled', 'disabled');
		}

		/**
		 * 组合查询
		 * 消息优先级: 
		 *
		 */
		function queryInfo() {
			// 为明细分页组件赋值
			// 根据查询组合条件，取记录当前的页面 取第一页数据 load
			$('#itLogInfo').datagrid(
					'load',
					{
						borrowername : $('#qyborrowername').val(),
						bidtype : $('#qybidtype').combobox('getValue'),
						payDateStart : $('#qypayDateStart').datetimebox(
								'getValue'),
						payDateEnd : $('#qypayDateEnd').datetimebox(
								'getValue'),
						borrowstatus : $('#qyborrowstatus').combobox('getValue')
					});
			disPagelistOption();
		}

		function queryCancel() {
			$('#queryForm').form('clear');
// 			$("#qyborrowstatus").find("option[value='2']").attr("selected",true);
		}
		
		/**
		 * 导出
		 */
		function queryExport() {
			$.ajax({
				type : "post",
				url : '${ctx}/settle/exportPayAmountExcel.do',
				data:$('#queryForm').serialize(),
				success:function(data){
					console.info(data.result);
					var url = "${ctx}/settle/downExcle.do?path="+data.result;
					$("body").append("<iframe src='" + url +"' style='display: none;' ></iframe>");
				},
				error:function(data){
					showSlideMessage("导出失败！");
				}
			});
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
		function initDataGrid() {
			$("#itLogInfo")
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
								url : '${ctx}/settle/getPayAmountByPage.do',
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : '日期',
											field : 'exptinterestdate',
											width : 100,
											align : 'center',
											formatter : function(value, row) {
												if(row.borrowstatus!=2){
													return '--';
												}
												var date = new Date(value);
												return date.format('yyyy-mm-dd');
											}
										},
										{
											title : '标的编号',
											field : 'bidcode',
											width : 80
										},
										{
											title : '标的名称',
											field : 'bidclassname',
											width : 80
										},
										{
											title : '产品类型',
											field : 'bidtypeid',
											width : 50,
											formatter : function(value, rec) {
												var bidtype = '';
												if (value == '1') {
													bidtype = '年年富';
												} else if (value == '2') {
													bidtype = '月月富';
												} else if (value == '3') {
													bidtype = '月月富T';
												} else if (value == '4') {
													bidtype = '天天富';
												}
												return bidtype;
											}
										},
										{
											title : '借款机构',
											field : 'borrowername',
											width : 120
										},
										{
											title : '管理服务费',
											field : 'yearservicefee',
											width : 45,
											formatter : function(value, row) {
												return $.format.number(row.amount*value/100, '###,###.##');
											}										
										},
										{
											title : '发行服务费',
											field : 'pubfee',
											width : 45,
											formatter : function(value, row) {
												return $.format.number(row.amount*value/100, '###,###.##');
											}
										},
										{
											title : '风险保证金',
											field : 'riskmgrfee',
											width : 45,
											formatter : function(value, row) {
												return $.format.number(row.amount*value/100, '###,###.##');
											}
										},
										{
											title : '付款状态',
											field : 'borrowstatus',
											align : 'center',
											width : 50,
											formatter : function(value, row) {
												 if(value == '2'){
													 return "已付款";
												 }
												 return "未付款";
											}
										},
										{
											title : '付款金额',
											field : 'amount',
											align : 'center',
											width : 80,
											formatter : function(value, row) {
												var amount = '';
												if(value!=null&& row.pubfee!=null&&row.riskmgrfee!=null){
													amount = value-(value*row.pubfee/100+value*row.riskmgrfee/100);
												}
												return $.format.number(amount, '###,###.##');
											}
										} ] ]
							});
		}
	</script>
</body>
</html>