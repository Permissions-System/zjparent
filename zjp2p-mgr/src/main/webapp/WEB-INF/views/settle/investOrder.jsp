<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery.number.min.js"></script>
<style type="text/css">
.tabs-container {
	width: 100%;
	height: 100%;
}

.easyui-tabs {
	width: 100%;
	height: 100%;
}

.easyui-layout {
	width: 100%;
	height: 100%;
}

.easyui-panel {
	width: 300px;
	height: 400px;
	padding: 10px;
}
#infoForm td{
 padding-left: 30px;
 padding-bottom: 20px;
}
</style>

</head>
<body onkeydown="bindingEnterKey(event)">
	<div style="width: 100%; height: 100%;">
		<div class="easyui-layout" data-options="fit:true,selected:true"
			style="width: 100%; height: 500px;">
				<div class="datagrid-toolbar"
				data-options="region:'north',split:true,title:'查询'"
				style="height: 130px; padding: 20px 0px 10px 30px">
				<form id="queryForm" method="post" novalidate>
					<table class="datagrid-toolbar"
						style="width: 100%; height: 70%; border: 0px; font-size: 12px">
						<tr>
							<td><label for="qyBidtype">产品类型:</label></td>
							<td>
								<div>
									<select id="qyBidtype" class="easyui-combobox" panelHeight="auto"
										name="bidtype" style="width: 155px;">
										<option value="">全部</option>
										<option value="1">年年富</option>
										<option value="2">月月富</option>
										<option value="3">月月富T</option>
										<option value="4">天天富</option>
									</select>
								</div>
							</td>
							<td>&nbsp;</td>	
							<td>&nbsp;</td>	
							<td><label for="qyMembertype">账户类型:</label></td>							
							<td>
								<div>
									<select id="qyMembertype" class="easyui-combobox"
										panelHeight="auto" name="membertype" style="width: 155px;">
										<option value="">全部</option>
										<option value="1">内部投资账户</option>
										<option value="0">外部投资账户</option>
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td><label for="qyOrderDateStart">投资时间:</label></td>
							<td colspan="3"><input id="qyOrderDateStart" name="orderDateStart"
								class="easyui-datebox" style="width: 155px;"
								data-options="editable:false"> 
						        -- <input id="qyOrderDateEnd" name="orderDateEnd"
								class="easyui-datebox" style="width: 160px;"
								data-options="editable:false"></td>
							<td><label for="qyBonus">红包:</label></td>							
							<td>
								<div>
									<select id="qyBonus" class="easyui-combobox"
										panelHeight="auto" name="bonus" style="width: 155px;">
										<option value="">全部</option>
										<option value="1">使用红包</option>
										<option value="0">不使用红包</option>
									</select>
								</div>
							</td>

							<td><a href="#" class="easyui-linkbutton"
								iconCls="icon-search" id="btnQuery">查询</a> <a href="#"
								class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
								<a href="#"class="easyui-linkbutton" 
							iconCls="icon-undo" id="btnExport">导出Excel</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div data-options="region:'center',border:true,title:'列表'">
				<table id="info"
					data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		
		// 资金流水 start
		$("#btnQuery").bind("click", function() {
			queryInfo();
		});
		// 查询取消按钮事件
		$("#btnCancel").bind("click", function() {
			queryCancel();
		});
		
		// 导出按钮事件
		$("#btnExport").bind("click", function() {
			queryExport();
		});
		initDataGrid();
		// 资金流水 end
		disPagelistOption();
		
	});
	// 资金流水 start
		function initDataGrid() {
			$("#info")
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
								url : '${ctx}/settle/getOrderBySettle.do',
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : '统计日期',
											field : 'OrderDate',
											width : 150,
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}
										},
										{
											title : '产品类型',
											field : 'bidtype',
											width : 150
										},
										{
											title : '账户类型',
											field : 'membertype',
											width : 150
										},
										{
											title : '投资期限',
											field : 'investperiod',
											width : 100
										},
										{
											title : '投资金额',
											field : 'Amount',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										},
										{
											title : '使用红包金额',
											field : 'bonusamount',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										},
										{
											title : '预期收益',
											field : 'exptIncome',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										} ] ]
							});
		}
	
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
	
		function queryInfo() {
			// 为明细分页组件赋值
			// 根据查询组合条件，取记录当前的页面 取第一页数据 load
			$('#info').datagrid(
					'load',
					{
						orderDateStart : $('#qyOrderDateStart').datetimebox('getValue'),
						orderDateEnd : $('#qyOrderDateEnd').datetimebox('getValue'),
						bonus : $('#qyBonus').combobox('getValue'),
						bidtype : $('#qyBidtype').combobox('getValue'),
						membertype : $('#qyMembertype').combobox('getValue')
					});
			disPagelistOption();
		}
		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOption() {
			$(".pagination-num").attr('disabled', 'disabled');
		}
		
		function queryCancel() {
			$('#queryForm').form('clear');
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
		 * 导出
		 */
		function queryExport() {
			$.ajax({
				type : "post",
				url : '${ctx}/settle/investOrderExcel.do',
				data:{'query':$('#queryForm').serializeObject(),'title':$('#info').easyuiTitle(),
					'field':$('#info').easyuiField()},
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
	
	//EasyUI datagrid 动态导出Excel
/* 	function ExporterExcel() {
		var opts = $('#orderInfo').datagrid('getColumnFields'); //这是获取到所有的FIELD
		var colTitle=[];
		var colField=[];
		for(i=0;i<opts.length;i++)
		{
		var col = $('#orderInfo').datagrid( "getColumnOption" , opts[i] );
		colTitle.push(col.title);//把TITLEPUSH到数组里去
		colField.push(col.field);
		} 
	} */
	
</script>
</html>