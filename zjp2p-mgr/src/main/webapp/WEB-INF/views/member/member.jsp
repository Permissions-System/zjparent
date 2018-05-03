<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
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
						<td><label for="qyemail">用户账号:</label></td>
						<td><input id="qyemail" name="email"
							class="easyui-validatebox" style="width: 155px;"></td>
						<td><label for="qyRealName">用户姓名:</label></td>
						<td><input id="qyRealName" name="realname"
							style="width: 160px;" class="easyui-validatebox"></td>
						<td><label for="">用户来源:</label></td>
						<td>
							<div>
							   <!-- 0-pc 1-mobile -->
								<select id="qySource" class="easyui-combobox" panelHeight="auto"
									name="userSource" style="width: 155px;">
									<option value="">全部</option>
									<option value="0">PC端</option>
									<option value="1">移动端</option>
								</select>
							</div>
						</td>
					</tr>
					<tr>
						<td><label for="qyCreateDateStart">注册时间:</label></td>
						<td colspan="3"><input id="qyCreateDateStart" name="createDateStart"
							class="easyui-datebox" style="width: 155px;"
							data-options="editable:false"> 
					        -- <input id="qyCreateDateEnd" name="createDateEnd"
							class="easyui-datebox" style="width: 160px;"
							data-options="editable:false"></td>
						<td><label for="qyUserStatus">用户状态:</label></td>
						<td>
							<div>
								<select id="qyUserStatus" class="easyui-combobox"
									panelHeight="auto" name="userstatus" style="width: 155px;">
									<option value="">全部</option>
									<option value="1">正常</option>
									<option value="0">冻结</option>
									<option value="2">未激活</option>
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
		<div id="infoPanel">
			<form id="infoForm" method="post">
				<table>
					<tr>
						<td><label>用户ID:</label></td>
						<td><input class="easyui-validatebox" type="text" id="id"
							disabled="disabled" name="id"></input></td>
					</tr>
					<tr>
						<td><label>用户名:</label></td>
						<td><input class="easyui-validatebox" type="text"
							id="email" disabled="disabled" name="email"></input></td>
					</tr>
					<tr>
						<td><label>注册时间:</label></td>
						<td><input class="easyui-validatebox" type="text"
							id="createDate" disabled="disabled" name="createDate"></input></td>
					</tr>
					<tr>
						<td><label>性别:</label></td>
						<td><input class="easyui-validatebox" type="text" id="gender"
							disabled="disabled" name="gender"></input></td>
					</tr>
					<tr>
						<td><label>年龄:</label></td>
						<td><input class="easyui-validatebox" id="age"
							disabled="disabled" type="text"></input></td>
					</tr>
					</tr>
					<tr>
						<td><label>邮箱:</label></td>
						<td><input class="easyui-validatebox" type="text" id="email"
							disabled="disabled" name="email"></input> <span id="emailverify"></span>
							</div></td>
					</tr>
					</tr>
					<tr>
						<td><label>手机:</label></td>
						<td><input class="easyui-validatebox" type="text" id="mobile"
							disabled="disabled" name="mobile"></input> <span
							id="mobileverify"></span></td>
					</tr>
					</tr>
					<tr>
						<td><label>身份证:</label></td>
						<td><input class="easyui-validatebox" type="text" id="idcard"
							disabled="disabled" name="idcard"></input> <span
							id="idcardverify"></span></td>
					</tr>
					</tr>
					<tr>
						<td><label>银行卡:</label></td>
						<td><span id="bankCard"></span></td>
					</tr>
					</tr>
					<tr>
						<td><label>交易密码:</label></td>
						<td><span id="tranPassword"></span></td>
					</tr>
					</tr>
					<tr>
						<td><label>帐号状态:</label></td>
						<td><span id="userstatus" name="userstatus"></span></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
<script type="text/javascript">	
	function butDisabled(but){
		but.linkbutton('disable');
    }
    
    function butEnabled(but){
    	but.linkbutton('enable');
    }
</script>
	<script type="text/javascript">
		$(document).ready(function() {
			// 页面初始化
			// 查询按钮绑定事件

			$("#btnQuery").bind("click", function() {
				queryInfo();
			});
			// 查询取消按钮事件
			$("#btnCancel").bind("click", function() {
				queryCancel();
			});

			// 初始化页面Grid
			initDataGrid();

			disPagelistOption();
			
			// 导出按钮事件
			$("#btnExport").bind("click", function() {
				butDisabled($('#btnExport'));
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
						email : $('#qyemail').val(),
						realname : $('#qyRealName').val(),
						createDateStart : $('#qyCreateDateStart').datetimebox(
								'getValue'),
						createDateEnd : $('#qyCreateDateEnd').datetimebox(
								'getValue'),
						userstatus : $('#qyUserStatus').combobox('getValue'),
						userSource : $('#qySource').combobox('getValue')
					});
			disPagelistOption();
		}

		/**
		 * 清空查询条件
		 */
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
			var str=$('#queryForm').serialize();
			str=str.split("&");
			var dateStart=str[3];
			var dateEnd=str[4];
			if(dateStart.substring(16)==''&&dateEnd.substring(14)==''){
				alert('默认选取当日数据');
			}
			$.ajax({
				type : "post",
				url : '${ctx}/member/exportMemberExcel.do',
				data:$('#queryForm').serialize(),
				success:function(data){
					console.info(data.result);
					var url = "${ctx}/member/downExcle.do?path="+data.result;
					$("body").append("<iframe src='" + url +"' style='display: none;' ></iframe>");
					butEnabled($("#btnExport"));
				},
				error:function(data){
					butEnabled($("#btnExport"));
					showSlideMessage("导出失败！");
				}
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
								url : '${ctx}/member/getInfoByPage.do',
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : '邮箱',
											field : 'email',
											width : 120
										},
										{
											title : '用户姓名',
											field : 'realname',
											width : 100
										},
										{
											title : '手机号',
											field : 'mobile',
											width : 100
										},
										{
											title : '状态',
											field : 'userstatus',
											width : 100,
											formatter : function(value, rec) {
												var userStatus = '';
												if (value == '0') {
													userStatus = '冻结的';
												} else if (value == '1') {
													userStatus = '正常的';
												} else if (value == '2') {
													userStatus = '未激活';
												}
												return userStatus;
											}
										},
										{
											title : '注册时间',
											field : 'createDate',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}
										},
										{
											title : '最后登录时间',
											field : 'loginDate',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}
										},
										{
											title : '用户来源',
											field : 'regSource',
											width : 50,
											formatter : function(value, row,
													index) {
												 if(value == 0){
													 return "PC端";
												 }
												 return "移动端";
											}
										},
										{
											title : '是否加入体验计划',
											field : 'ifjoinexpence',
											align : 'center',
											width : 90,
											formatter : function(value, row,
													index) {
												 if(value){
													 return "是";
												 }
												 return "否";
											}
										},
										{
											field : 'opation',
											title : '操作',
											align : 'center',
											width : 120,
											formatter : function(value, row,
													index) {
												var opt = '';
												opt += '<a href="javascript:void(0)" onclick="jump('+index+');" class="easyui-linkbutton">进入</a>';
												opt += '&nbsp;&nbsp;<a href="javascript:void(0)" onclick="resetPw('+index+');" class="easyui-linkbutton">重置密码</a>';
												return opt;
											}
										} ] ]
							});
		}
		
		function jump(rowId){
			 $('#itLogInfo').datagrid('selectRow', rowId);
			 var node = $('#itLogInfo').datagrid('getSelected');
			 var url = '${ctx}/member/getMemberInfo.do?memberId='+node.id;
			 var username = '';
			 var realname = '';
			 if(node.email != null){
				 username = node.email;
			 }
			 if(node.realname != null){
				 realname = '('+node.realname+')';
			 }
			 self.parent.openTab('用户详情:'+username+''+realname+'', url);
			/*  var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
			 $('#tabs', parent.document).tabs('add', {
					title : '用户信息',
					content : content,
					closable : true
				}); */ 
			
		}
		function resetPw(rowId){
			 $('#itLogInfo').datagrid('selectRow', rowId);
			 var node = $('#itLogInfo').datagrid('getSelected');
			 $.messager.confirm('确认信息', '您确定要为该用户的重置密码？<br/> 1.密码重置后,原有的密码将失效 <br/> 2.重置后的密码将发送到该用户的邮箱<br/>', function(r){
					if(r){
						$.ajax({
							async : false,
							type : 'POST',
							url : '${ctx}/member/findPassword.do',
							data : {
								id : node.id , 
								email: node.email
							},
							success : function(data, status) {
								if (data.status == 'SUCCESS') {
									$.messager.alert('提示信息', '重置密码成功','info', function(){
									});
								}else{
									$.messager.alert('提示信息', data.msg,'info', function(){
									});
								}
							}
						});
					}
				});
			 
		}
		function updateInfo(rowId) {
			$('#itLogInfo').datagrid('selectRow', rowId);
			$('#infoPanel').dialog({
				title : '会员信息',
				modal : true,
				closed : false,
				width : 600,
				height : 520,
				onBeforeClose : function() {
					$('#infoForm').form('clear');
				},
				buttons : [ {
					text : '取消',
					handler : function() {
						$('#infoPanel').dialog('close');
					}
				} ]
			});

			var node = $('#itLogInfo').datagrid('getSelected');

			var memberSafety = '';
			$.ajax({
				async : false,
				type : 'POST',
				url : '${ctx}/member/getMemberSafety.do',
				data : {
					memberId : node.id
				},
				success : function(data, status) {
					if (data.status == 'SUCCESS') {
						memberSafety = data.result;
					}
				}
			});

			$('#id').val(node.id);
			$("#email").val(node.email);
			$('#createDate').val(
					new Date(node.createDate).format('yyyy-mm-dd HH:MM:ss'));
			var gender = '';
			if (node.gender == '1') {
				gender = '男';
			} else if (node.gender == '0') {
				gender = '女';
			}
			$('#gender').val(gender);
			$('#email').val(node.email);
			if (memberSafety.emailifverified == 1) {
				$('#emailverify').html(
						'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
								+ new Date(memberSafety.emailverifydate).format('yyyy-mm-dd HH:MM:ss'));
			} else {
				$('#emailverify').html('未验证');
			}

			$('#mobile').val(node.mobile);
			if (memberSafety.mobileifverified == 1) {
				$('#mobileverify').html(
						'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
								+ new Date(memberSafety.mobileifverifydate).format('yyyy-mm-dd HH:MM:ss'));
			} else {
				$('#mobileverify').html('未验证');
			}

			$('#idcard').val(node.idcard);
			if (memberSafety.idcardifverified == 1) {
				$('#idcardverify').html(
						'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
								+ new Date(memberSafety.idcardverifydate).format('yyyy-mm-dd HH:MM:ss'));
			} else {
				$('#idcardverify').html('未验证');
			}

			var userStatus = '';
			if (node.userstatus == '0') {
				userStatus = '冻结的';
			} else if (node.userstatus == '1') {
				userStatus = '正常的';
			} else if (node.userstatus == '2') {
				userStatus = '未激活';
			}
			$('#userstatus').html(userStatus);
			$('#age').html('age');
			$('#tranPassword').html('交易密码');
			$('#bankCard').html('');
		};
	</script>
</body>
</html>