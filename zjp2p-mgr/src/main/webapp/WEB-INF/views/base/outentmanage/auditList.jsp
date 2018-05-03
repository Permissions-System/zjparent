<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#find {
	width: 150px;
}

.button {
	width: 50px;
	height: 100%;
}
</style>
</head>
<body class="easyui-layout">
	<div id="north" data-options="region:'north',split:false" style="height: 40px;">
		<div id="status" style="float: left; margin-left: 3%; padding-top: 10px;">
			资料状态:&nbsp; <select id="entStatus" class="easyui-combobox" panelHeight="auto" data-options="editable:false" name="资料状态">
				<option value="-1">请选择</option>
				<c:forEach var="status" items="${statusList}">
					<c:choose>
						<c:when test="${status.configCode==2}">
							<option value="${status.configCode}" selected="selected">${status.configName}</option>
						</c:when>
						<c:otherwise>
							<option value="${status.configCode}">${status.configName}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			<div style="display: none;">
				<select id="entStatus" class="easyui-combobox" data-options="editable:false" name="资料状态">
					<c:forEach var="type" items="${typeList}">
						<option value="${type.configCode}">${type.configName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div style="float: right; margin-right: 3%; padding-top: 10px;">
			<input type="text" class="easyui-validatebox" id="find" placeholder="企业名称或组织机构代码" /> 
			<a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
	</div>
	<div data-options="region:'center',title:'待审核客户列表'" style="padding: 5px; background: #eee;">
		<table id="entTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true" style="width: 100%">
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#entStatus").combobox({
				editable : false,
				onSelect : function() {
					search();
				}
			});

			$('#find').click(function() {
				$('#find').val("");
			});
			$('#find').blur(function() {
				if ($.trim($('#find').val()) == "") {
					//$('#find').val("企业名称或组织机构代码");
				}
			});
			$.ajaxSetup({
				cache : false
			//关闭AJAX响应的缓存
			});

			$("#search").bind("click", function() {
				search();
			});
			//enter键搜索
			$('#find').bind('keypress', function(event) {
				if (event.keyCode == "13") {
					search();
				} else {
					return;
				}
			});

			initEntGrid();
		});

		function initEntGrid() {
			$('#entTable')
					.datagrid(
							{
								url : '${ctx}/base/outent/byStatus',
								loadMsg : '加载数据，请稍候...',
								nowrap : false,
								autoRowHeight : true,
								pagination : true,
								rownumbers : true,
								pageSize : 10,
								pageList : [ 10, 20, 50 ],
								striped : true,
								border : false,
								fitColumns : true,
								method : 'post',
								singleSelect : true,
								fit : true,
								queryParams : {
									infoStatus : '2'
								},
								columns : [ [
										{
											field : 'orgCode',
											title : '组织机构代码',
											width : 80,
											align : 'center',
											halign : 'center'
										},
										{
											field : 'chineseFullName',
											title : '企业名称',
											width : 250,
											align : 'left',
											halign : 'center'
										},
										{
											field : 'entType',
											title : '单位类型',
											width : 100,
											align : 'center',
											halign : 'center',
											formatter : function(value, row,
													index) {
												if (value) {
													var data = $('#entTable')
															.datagrid('getData');
													var result = 0;
													for ( var i = 0; i < data.typeList.length; i++) {
														if (value == data.typeList[i].configCode) {
															result = i;
															i = 0;
															break;
														}
													}
													return data.typeList[result].configName;
												} else {
													return "";
												}
											}
										},
										{
											field : 'infoStatus',
											title : '状态',
											width : 100,
											align : 'center',
											halign : 'center',
											formatter : function(value, row,
													index) {
												if (value) {
													var data = $('#entTable')
															.datagrid('getData');
													var result = 0;
													for ( var i = 0; i < data.statusList.length; i++) {
														if (value == data.statusList[i].configCode) {
															result = i;
															i = 0;
															break;
														}
													}
													return data.statusList[result].configName;
												} else {
													return "";
												}
											}
										},
										{
											field : 'time',
											title : '上传时间',
											width : 80,
											align : 'center',
											halign : 'center',
											formatter : function(value, row,
													index) {
												return dateTransferFormatter(
														value, row, index);
											}
										},
										{
											field : 'opetation',
											title : '操作',
											width : 120,
											align : 'center',
											halign : 'center',
											formatter : function(value, row,
													index) {
												var opt = '';
												opt += ' <input type="button" onclick="entDetail('
														+ index
														+ ')" class="button" value="查看"/>';
												opt += ' <input type="button" onclick="entAudit('
														+ index
														+ ')" class="button" value="审核"/>';
												return opt;
											}
										}, ] ],
								onLoadSuccess : function(data) {
									if (data.total == 0) {
										$.messager.show({
											title : '消息',
											msg : '没有记录。',
											timeout : 5000,
											showType : 'slide'
										});
									}
								},
								onLoadError : function() {
									$.messager
											.alert('错误信息', '信息查询失败!', 'error');
								}
							});
		}

		//查看
		function entDetail(index) {
			$('#entTable').datagrid('selectRow', index); //选中当前记录
			var gridNode = $('#entTable').datagrid('getSelected');
			var entNo = gridNode.entNo;
			self.parent.openTab("查看-" + gridNode.chineseFullName,
					'${ctx}/base/outent/info/' + entNo);
		}
		//审核
		function entAudit(index) {
			$('#entTable').datagrid('selectRow', index); //选中当前记录
			var gridNode = $('#entTable').datagrid('getSelected');
			var entStatus = gridNode.infoStatus;
			if (entStatus != "2") { //状态为已提交，待审核的圈外企业才能进行审核操作!
				if (entStatus == 3) {
					$.messager.alert('温馨提示', '审核已通过，无需重新审核！', 'info');
					return;
				} else if (entStatus == 1) {
					$.messager.alert('温馨提示', '客户还未提交任何资料，无需进行审核！', 'info');
					return;
				} else if (entStatus == 4) {
					$.messager.alert('温馨提示', '客户审核不通过，无法进行审核！', 'info');
					return;
				}
			}
			var entNo = gridNode.entNo;
			self.parent.openTab("审核-" + gridNode.chineseFullName,
					'${ctx}/base/outent/audit/' + entNo);
		}
		// "yyyyMMdd" -> "yyyy-MM-dd"
		function dateTransferFormatter(value, row, index) {
			if (isNull(value) || value.length != 8) {
				return value;
			} else {
				return value.substring(0, 4) + '-' + value.substring(4, 6)
						+ '-' + value.substring(6, 8);
			}
		}

		function search() {
			var inputString = $('#find').val();
			var entStatus = $('#entStatus').combobox('getValue') == "-1" ? null
					: $('#entStatus').combobox('getValue');
			$('#entTable').datagrid('load', {
				infoStatus : entStatus,
				param : $.trim(inputString)
			});
		}
	</script>
</body>
</html>