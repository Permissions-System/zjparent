<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
</head>
<style type="text/css">
.my_td_label {
	padding-left:10px;
	width: 100px;
	height: 30px;
	text-align: right;
	font-size: 13px;
	nowrap:nowrap;
}

.my_td_input {
	padding-left:10px;
	width: 150px;
	height: 30px;
	text-align: left;
	font-size: 13px;
	nowrap:nowrap;
}
.datagrid-toolbar {
  background: white;
}
</style>
<body>
	<div id="addCustManagerDialog"></div>
<div id="toolbar" style="padding:20px;padding-bottom: 20px;">
	<form id="queryForm">
		<table style="width:100%;" border="0" 
			cellpadding="2" cellspacing="3" align="center">
			<tbody>
				<tr>
					<td class="my_td_label">
						<label>身份证号码：</label>
					</td>
					<td class="my_td_input">
						<input id="identNo" class="easyui-validatebox" style="width:150px;" data-options="required:false,validType:['identNo[]','maxLength[1,18]']"/>
					</td>
					<td class="my_td_label">
						<label>客户经理名称：</label>
					</td>
					<td class="my_td_input">
						<input id="name" class="easyui-validatebox" style="width:150px;" data-options="required:false,validType:['name[]','maxLength[2,30]']" />
					</td>
					<td class="my_td_label">
						<a id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
					</td>
					<td class="my_td_input" style="align:center;">
						<a id="addBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
<table id="custManagerDatagrid"></table>
<script type="text/javascript">
//计算字符串长度,中文按照3个字符计算
function countCharNum(str){
	if(str==null){
		return 0;
	}
	// return str.replace(/([\u4E00-\u9FA5\uF900-\uFA2D])/g,'aaa').length
	return str.replace(/([^\x00-\xff])/g,'aaa').length;
}
//校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength: {
		validator: function(value, param){
			// param[0]字符串类型: 1-数字英文字符, 2-中文字符
			if(param[0]==2){
				return countCharNum(value) <= param[1];
			} else {
				return value.length <= param[1];
			}
		},
		message: '最大长度为{1}个字符'
	},
	identNo: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9]');
			return !p.test(value);
		},
		message: '身份证编号应由数字或字母组成'
	},
	name: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5 ]');
			return !p.test(value);
		},
		message: '客户经理名称名称应由中文字符或英文字母组成'
	}
});
function deleteCustManager(index){
	$('#custManagerDatagrid').datagrid('selectRow', index); //选中当前记录
	var gridNode = $('#custManagerDatagrid').datagrid('getSelected');
	if(gridNode && gridNode.staffNo){
		$.messager.confirm('确认信息', '确定移除['+gridNode.name+']核心企业客户经理权限?', function(r){
			if(r){
				$.ajax({
					type : 'POST',
					url:'${ctx}/base/busiGroup/coreEntCustManagerList/delete',    
					data:{
						staffNo: gridNode.staffNo
					},
					success:function(data){
						reloadCoreEntCustData();// 删除成功，刷新当前页面
						$.messager.show({
							title:'消息',
							msg:'删除成功！',
							timeout:5000,
							showType:'slide'
						});    
					},
					error : function(data, status) {
						$.messager.alert('错误信息','删除客户经理失败！<br/>'+getJsonErrorMsg(data),'error');
						// 关闭进度条
					}
				});
			}
		});
	}
}

// 刷新当前页
function reloadCoreEntCustData(){
	$('#custManagerDatagrid').datagrid('reload');
}

var staffStatuses = null;
function getStaffStatuses(){
	if(staffStatuses==null || staffStatuses.length==0){
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/busiGroup/coreEntCustManagerList/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_STAFF_STATUS%>',
			success : function(data, status) {
				staffStatuses = data;
			},
			error : function(data, status) {
				$.messager.show({
					title: '错误',
					msg: '获取员工状态数据失败',
					timeout: 5000,
					showType: 'slide'
				}); 
			},
			datatype : "json"
		});
	}
	return staffStatuses;
}

function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	$('#custManagerDatagrid').datagrid('load', {
    	identNo: $.trim($('#identNo').val()),
		name: $.trim($('#name').val())
    });
}

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		// errorMsg = JSON.parse(data.responseText).string;
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

$(document).ready(function(){
	$('#searchBtn').click(function(){
		search();
	});
	
	$('#addBtn').click(function(){
		$('#addCustManagerDialog').dialog('open');
	});
	getStaffStatuses();
	
	$("#custManagerDatagrid").datagrid({
		title: '核心企业客户经理维护',
		toolbar: '#toolbar',
		pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50],
        pagination: true,
        rownumbers: true,
        singleSelect: true, //单选
        border: true,
        fit: true,
        striped: true,
        url: '${ctx}/base/busiGroup/coreEntCustManagerList/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','核心企业客户经理列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'staffNo',title:'员工编号',width:200,align: 'center', hidden:true},
			{field:'identNo',title:'身份证号码/登录名',width:200,align: 'center'},
			{field:'name',title:'客户经理名称',width:200,align: 'center'},
			{field:'c3OrgNo',title:'客户经理所属行编号',width:150,align: 'center'},
			{field:'c3OrgName',title:'客户经理所属行',width:280,align: 'center'},
			{field:'staffStatus',title:'员工状态',width:80,align: 'center',
				formatter: function(value,row,index){
					var selectors = staffStatuses;
					for(var i in selectors){
						if(value == selectors[i].configCode){
							return selectors[i].configName;
						}
					}
					return value;
				}
			},
			{field:'operation',title:'操作',align:'center',
				formatter: function(value,row,index){
					return '<button onclick="deleteCustManager('+index +')" class="easyui-linkbutton">删除</button>';
				}
			}
			]]
	});
	
	$('#addCustManagerDialog').dialog({
			title: '添加客户经理',
			width: 900,
			height: 500,
			closed: true,
			cache: true,
			href: '${ctx}/loan/preloan/instuserinfo',
			modal: true,
			fit: true,
			buttons:[{
				text:'确定',
				handler:function(){
					// 获取弹出页面数据
					var dataNode = $('#roleTable').datagrid('getSelected');
					if(isNull(dataNode) || isNull(dataNode.certno)){
						$.messager.show({
							title: '提示信息',
							msg: '请先选择客户经理信息！',
							timeout: 5000,
							showType: 'slide'
						});
						return;
					}
					$.messager.progress({
						title: '',
						msg: '正在创建客户经理信息，请稍候...',
						text: ''
					}); 
					// 保存数据
					$.ajax({
						type : 'POST',
						url:'${ctx}/base/busiGroup/coreEntCustManagerList/createCoreCustManager',    
						data:{
							identNo: dataNode.certno,
							name: dataNode.username,
							c3OrgNo: dataNode.userinstcode,
							c3OrgName: dataNode.userinstname
						},
						success:function(data, status){
							$.messager.progress('close');
							reloadCoreEntCustData();// 保存成功，刷新当前页面
							$('#addCustManagerDialog').dialog('close');
							$.messager.show({
								title: '消息',
								msg: '客户经理创建成功！',
								timeout: 5000,
								showType: 'slide'
							});
						},
						error : function(data, status) {
							$.messager.progress('close');
							$.messager.alert('错误信息','创建客户经理失败！<br/>'+getJsonErrorMsg(data),'error');
						}
					});
				}
			},{
				text:'取消',
				handler:function(){
					$('#addCustManagerDialog').dialog('close');
				}
			}]
		});
	
	//Enter键执行搜索功能
	document.onkeydown = function(event){
		var e = event || window.event || arguments.callee.caller.arguments[0];
		if(e && e.keyCode==13){ 
			if(e && e.preventDefault) {
				e.preventDefault();
			} else {
				window.event.returnValue = false;
			}
	    	search();
	    }
	};
});
</script>
</body>
</html>