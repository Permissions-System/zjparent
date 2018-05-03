<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
</head>
<body>
<style type="text/css">
.blank_td {
	width: 10%;
}
.td_label {
	padding-left:10px;
	width: 100px;
	height: 30px;
	text-align: right;
	font-size: 12px;
	nowrap: nowrap;
}
.td_input {
	padding-left:5px;
	width: 200px;
	height: 30px;
	text-align: left;
}
.td_remark {
	padding-left:5px;
	height: 30px;
	text-align: left;
}
.tx_input {
	text-align: left;
	width: 120px;
}
.tx_label {
	text-align: right;
	width: 80px;
}
</style>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',title:'查询条件'" style="height:80px;padding:10px 0 10px 10px;" >
			<form id="queryForm">
				<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
					<tbody>
						<tr>
							<td class="tx_label">
								<label>组名称:</label>
							</td>
							<td class="tx_input">
								<input id="groupNameC" class="easyui-validatebox" data-options="required:false,validType:['groupName[]','maxLength[2,60]']" />
							</td>
							<td class="tx_label">
								<label>所属父类:</label>
							</td>
							<td class="tx_input">
								<input id="parentIdC" />
							</td>
							<td class="tx_label">
								<label>状态:</label>
							</td>
							<td class="tx_input">
								<input id="stateC" class="easyui-combobox" 
									data-options="panelHeight:'auto',required:false,multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/webGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>'">
							</td>
							<td style="align:left;padding-left:10px;">
								<a id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:false">查询</a>
								<a id="resetBtn" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:false">重置</a>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div data-options="region:'center'">
			<table id="webGroupTable"></table>
			<div id="webGroupTableToolbar">
				<a id="addBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>&nbsp;&nbsp;&nbsp;
				<a id="removeBtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			</div>
		</div>
	</div>
	<div id="editGroupDialog" class="easyui-dialog" title="编辑组 " 
		data-options="closed: true,iconCls:'icon-edit',maximized:true,resizable:true,modal:true">
		<form id="editGroupDialogForm">
			<table style="width: 100%;" border="0" 
					cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="blank_td"></td>
						<td class="td_label">
							<label>组名称:</label>
						</td>
						<td class="td_input">
							<input id="name" class="easyui-validatebox" data-options="required:true,validType:['groupName[]','maxLength[2,60]']">
						</td>
						<td class="td_label">
							<label>所属父类:</label>
						</td>
						<td class="td_input">
							<input id="parentId" />
						</td>
						<td class="blank_td"></td>
					</tr>
					<tr>
						<td class="blank_td"></td>
						<td class="td_label">
							<label>组类型:</label>
						</td>
						<td class="td_input">
							<input id="type" class="easyui-combobox" 
								data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/webGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_BG_FLAG%>'">
						</td>
						<td class="td_label">
							<label>状态:</label>
						</td>
						<td class="td_input">
							<input id="state" class="easyui-combobox" 
								data-options="panelHeight:'auto',multiple:false,editable:false,valueField:'configCode',textField:'configName',type:'post',url:'${ctx}/base/webGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>'">
						</td>
						<td class="blank_td"></td>
					</tr>
					<tr>
						<td class="blank_td"></td>
						<td class="td_label">
							<label>权限字符串:</label>
						</td>
						<td class="td_input">
							<input id="role" class="easyui-validatebox" data-options="validType:['role[]']">
						</td>
						<td class="td_label">
							<label>定义链接:</label>
						</td>
						<td class="td_input">
							<input id="value" class="easyui-validatebox" data-options="validType:['value[]','maxLength[1,256]']">
						</td>
						<td class="blank_td"></td>
					</tr>
					<tr>
						<td class="blank_td"></td>
						<td class="td_label">
							<label>岗位代码:</label>
						</td>
						<td class="td_input">
							<input id="positionCode" class="easyui-validatebox" data-options="required:true,validType:['positionCode[]','maxLength[1,32]']">
						</td>
						<td class="td_label">
							<label>岗位名称:</label>
						</td>
						<td class="td_input">
							<input id="positionName" class="easyui-validatebox" data-options="required:true,validType:['positionName[]','maxLength[2,32]']">
						</td>
						<td class="blank_td"></td>
					</tr>
					<tr>
						<td class="blank_td"></td>
						<td class="td_label">
							<label>备注:</label>
						</td>
						<td  class="td_remark" colspan="3">
							<input id="remark" class="easyui-validatebox" data-options="width:400" data-options="validType:['maxLength[2,300]']">
						</td>
						<td class="blank_td"></td>
					</tr>
					<tr style="display:none">
						<td class="td_label">
							<label>组编号:</label>
						</td>
						<td class="td_input">
							<input id="id" class="easyui-validatebox">
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<table id="webResourceTable"></table>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
<script type="text/javascript">
// 计算字符串长度,中文按照3个字符计算
function countCharNum(str){
	if(str==null){
		return 0;
	}
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
	groupName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
			return !p.test(value);
		},
		message: '组名称应由数字、字母、中文字符、下划线或括号组成'
	},
	role: {
		validator: function(value, param){
			var p = new RegExp('^roles\[[a-zA-Z]{0,57}\]$');
			return p.test(value);
		},
		message: '格式：roles[*]，*表示角色名称,最大长度64个字符'
	},
	positionCode: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9_]');
			return !p.test(value);
		},
		message: '岗位代码只能由数字、英文字母或下划线组成'
	},
	positionName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
			return !p.test(value);
		},
		message: '岗位名称应由数字、字母、中文字符、下划线或括号组成'
	},
	value: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\/_]');
			return !p.test(value);
		},
		message: '定义链接应是由字母数字或下划线斜杠组成的字符串'
	}
});

var allGroup = null; // 所有组信息
var allResources = null; // 所有资源信息
var currentGroupResources = null; // 当前操作组资源
var parentIdCValue = null;
var stateList = null; //资源或组状态

//未使用
function checkResources(groupResources){
	if(groupResources==null || groupResources.length==0){
		return;
	} else {
		var i=0;
		while(i<groupResources.length){
			if(groupResources[i].checked=="true"){
				$('#webResourceTable').datagrid('checkRow', i);
			}
			i++;
		}
		return;
	}
}

// 解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

// 获取所有资源
function getAllResource(){
	if(!allResources){
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/webGroup/getAllResources',
			data : {
			},
			success : function(data, status) {
				allResources = data;
			},
			error : function(data, status) {
				$.messager.show({
					title:'错误信息',
					msg: '获取资源信息失败:'+getJsonErrorMsg(data),
					timeout:5000,
					showType:'slide'
				});
			},
			datatype : "json"
		});
	}
	return allResources;
}

function getAllGroup(){
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/webGroup/getAllGroup',
		data : {
		},
		success : function(data, status) {
			allGroup = data;
			allGroup.unshift({id:'', name:'请选择' });
			// 为'所属父类'下拉框注入数据
			$('#parentIdC').combobox({
				panelHeight:'auto',
				value: parentIdCValue,
				valueField: 'id',
				textField: 'name',
				editable: false,
				required: false,
				multiple: false,
				data: allGroup
			});
		},
		error : function(data, status) {
			$.messager.show({
				title:'错误信息',
				msg: '获取组信息失败！<br/>'+getJsonErrorMsg(data),
				timeout:5000,
				showType:'slide'
			});
		},
		datatype : "json"
	});
	return allGroup;
}

/**
 * 编辑组信息及组资源权限
 */
var currentEditNode = null;//当期编辑行
function editGroup(index){
	// 列表允许多选，本处不可再使用getSelected获取当期记录
	var gridData = $('#webGroupTable').datagrid('getData');
	currentEditNode = gridData.rows[index];
	if(currentEditNode){
		// 初始化组信息
		$('#id').val(currentEditNode.id);
		$('#name').val(currentEditNode.name);
		$('#role').val(currentEditNode.role);
		$('#value').val(currentEditNode.value);
		$('#positionCode').val(currentEditNode.positionCode);
		$('#positionName').val(currentEditNode.positionName);
		$('#remark').val(currentEditNode.remark);
		$('#state').combobox('setValue',isNull(currentEditNode.state)?'':currentEditNode.state);
		$('#type').combobox('setValue',isNull(currentEditNode.type)?'':currentEditNode.type);
		$('#parentId').combobox({
			panelHeight:'auto',
			multiple:false,
			value: isNull(currentEditNode.parentId)?'':currentEditNode.parentId,
			valueField: 'id',
			textField: 'name',
			editable: false,
			data: allGroup
		});
		
		// 初始化组拥有资源信息
		//getAllResource();
		//$('#webResourceTable').datagrid('loadData', allResources);
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/webGroup/getResources',
			data : {
				id: currentEditNode.id
			},
			success : function(data, status) {
				currentGroupResources = data;
				$('#webResourceTable').datagrid('loadData', currentGroupResources);
				//checkResources(currentGroupResources);
			},
			error : function(data, status) {
				$.messager.show({
					title:'错误信息',
					msg: '获取组资源信息失败！<br/>'+getJsonErrorMsg(data),
					timeout:5000,
					showType:'slide'
				});
			},
			datatype : "json"
		});

		$('#editGroupDialog').dialog({
			title: '编辑组',
			closed: false,
			fit: true,
			buttons:[{
				text: '保存',
				iconCls: 'icon-ok',
				handler: function(){
					$('#webResourceTable').datagrid('acceptChanges');
					if(!$('#editGroupDialogForm').form('validate')){
						return;
					}
					var ids = new Array();
					var nodes = $('#webResourceTable').datagrid('getSelections');
					if(nodes && nodes.length>0){
						for(var i in nodes){
							ids.push(nodes[i].id+"|"+nodes[i].state);
						}
					}
					$.ajax({
						type : 'POST',
						async: false,
						url : '${ctx}/base/webGroup/updateGroup',
						data : {
							id: $('#id').val(),
							name: $('#name').val(),
							role: $('#role').val(),
							value: $('#value').val(),
							parentId:$('#parentId').combobox('getValue'),
							positionCode: $('#positionCode').val(),
							positionName: $('#positionName').val(),
							remark: $('#remark').val(),
							state:$('#state').combobox('getValue'),
							type:$('#type').combobox('getValue'),
							resIds: ids.toString()
						},
						success : function(data, status) {
							if(!data.status || data.status!='FAIL'){
								// 刷新当前组列表信息
								$('#webGroupTable').datagrid('reload');
								getAllGroup();
								// 关闭弹出框
								$('#editGroupDialog').dialog('close');
								// 提示成功信息
								$.messager.show({
									title:'提示信息',
									msg:'组信息更新成功！',
									timeout:5000,
									showType:'slide'
								});
							} else {
								showValidateMessage(data.result);
							}
						},
						error : function(data, status) {
							$.messager.alert('错误信息','组信息更新失败！<br/>'+getJsonErrorMsg(data),'error');
						},
						datatype : "json"
					});
				}
			},{
				text: '重置',
				iconCls: 'icon-undo',
				handler: function(){
					$('#name').val(currentEditNode.name);
					$('#role').val(currentEditNode.role);
					$('#value').val(currentEditNode.value);
					$('#positionCode').val(currentEditNode.positionCode);
					$('#positionName').val(currentEditNode.positionName);
					$('#remark').val(currentEditNode.remark);
					$('#state').combobox('setValue',currentEditNode.state);
					$('#type').combobox('setValue',currentEditNode.type);
					$('#parentId').combobox({
						value: currentEditNode.parentId,
						valueField: 'id',
						textField: 'name',
						editable: false,
						data: allGroup
					});
					$('#webResourceTable').datagrid('loadData', currentGroupResources);
					//checkResources(currentGroupResources);
				}
			},{
				text: '返回',
				iconCls: 'icon-cancel',
				handler: function(){
					$('#editGroupDialogForm').form('clear');
					$('#editGroupDialog').dialog('close');
				}
			}]
		});
	}
	$('#editGroupDialogForm').form('validate');
}

/**
 * 解析并显示数据校验错误信息
 * messages 数据校验错误信息，要求以','分隔多个错误信息
 */
function showValidateMessage(messages) {
	 var errMsgs="请修复以下错误：<br>";
		var err = messages.split(',');
		for(var i in err)
			errMsgs += err[i] + '<br>';
		$.messager.show({
			title: '错误',
			msg: errMsgs,
			timeout: 5000,
			showType: 'slide'
		}); 
}

var resTypeData = null;
function getResTypeData(){
	if(resTypeData==null || resTypeData.length==0){
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/webGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_RES_TYPE%>',
			success : function(data, status) {
				resTypeData = data;
			},
			error : function(data, status) {
				$.messager.show({
					title: '错误',
					msg: '获取资源类型失败！<br/>'+getJsonErrorMsg(data),
					timeout: 5000,
					showType: 'slide'
				}); 
			},
			datatype : "json"
		});
	}
	return resTypeData;
}

function getStateData(){
	if(stateList==null || stateList.length==0){
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/webGroup/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>',
			success : function(data, status) {
				stateList = data;
			},
			error : function(data, status) {
				$.messager.show({
					title: '错误',
					msg: '获取状态类型失败！<br/>'+getJsonErrorMsg(data),
					timeout: 5000,
					showType: 'slide'
				}); 
			},
			datatype : "json"
		});
	}
	return stateList;
}

// 查询
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	parentIdCValue = $('#parentIdC').combobox('getValue'),
	// 查询数据
	$('#webGroupTable').datagrid('load', {
			name: $.trim($('#groupNameC').val()),
    		parentId: parentIdCValue,
    		state: $('#stateC').combobox('getValue')
    });
}

$(document).ready(function() {
	// 加载初始化数据
	getAllGroup();
	getStateData();
	
	// 初始化
	$('#webGroupTable').datagrid({
		title: '组管理',
		nowrap: false,
		pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50],
        pagination: true,
        rownumbers: true,
        singleSelect: false, //非单选
        checkOnSelect: true,
        selectOnCheck: true,
        fit: true,
        url: '${ctx}/base/webGroup/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		toolbar: '#webGroupTableToolbar',
		onLoadError: function(data){
			$.messager.alert('错误信息','组列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
		columns : [[
			{field:'checked',checkbox:true,align:'center'},
			{field:'id',title:'组代码',width:250,align:'center'},
			{field:'name',title:'组名称',width:150,align:'center'},
			{field:'state',title:'状态',width:100,align:'center',
				formatter: function(value,row,index){
					var comboboxData = $('#state').combobox('getData');
					if(comboboxData && comboboxData.length>0){
						for(var i in comboboxData){
							if(comboboxData[i].configCode==value){
								return comboboxData[i].configName;
							}
						}
					}
					return value;
				}
			},
			{field:'type',title:'组类型',width:100,align:'center',
				formatter: function(value,row,index){
					var comboboxData = $('#type').combobox('getData');
					if(comboboxData && comboboxData.length>0){
						for(var i in comboboxData){
							if(comboboxData[i].configCode==value){
								return comboboxData[i].configName;
							}
						}
					}
					return value;
				}
			},
			{field:'parentId',title:'所属父类',width:200,align:'center',
				formatter: function(value,row,index){
					if(allGroup && allGroup.length>0){
						for(var i in allGroup){
							if(allGroup[i].id==value){
								return allGroup[i].name;
							}
						}
					}
					return value;
				}
			},
			{field:'operation',title:'操作',width:150,align:'center',
				formatter: function(value,row,index){
					return '<button onclick="editGroup('+index +')" class="easyui-linkbutton">编辑</button>';
				}
			}
		]]
	});
	$('#webResourceTable').datagrid({
		title: '拥有资源',
		nowrap: false,
        pagination: false,
        rownumbers: true,
        singleSelect: false, //单选
        checkOnSelect: true,
        selectOnCheck: true,
        height: 300, // 此处大小需考虑
        fit: false,// 此处使用true有排版问题
		columns : [[
			{field:'checked',checkbox: true,align:'center'},
			{field:'name',title:'资源名称',width:150,align:'center'},
			{field:'permission',title:'权限字符',width:350,align:'center'},
			{field:'type',title:'资源类型',width:100,align:'center',
				formatter: function(value,row,index){
					var typeData = getResTypeData();
					if(typeData && typeData.length>0){
						for(var i in typeData){
							if(typeData[i].configCode==value){
								return typeData[i].configName;
							}
						}
					}
					return value;
				}
			},
			{field:'remark',title:'描述',width:250,align:'center'}
			,{field:'state',title:'状态',width:250,align:'center',
				formatter: function(value,row,index){
					var typeData = stateList;
					if(typeData && typeData.length>0){
						for(var i in typeData){
							if(typeData[i].configCode==value){
								return typeData[i].configName;
							}
						}
					}
					return typeData[0].configName;
				},
				editor:{
					type:'combobox',
					options:{
						valueField: 'configCode',
						textField: 'configName',
						editable:false,
						multiple:false,
						data: stateList,
						"panelHeight":'auto'
					}
				}
			}
		]],
		onClickCell: function(index,field,value){
			if(field != 'state'){
				return;
			}
	 		$('#webResourceTable').datagrid('beginEdit', index);
	 		var ed = $('#webResourceTable').datagrid('getEditor', {index:index,field: 'state'});
	 		$(ed.target).combobox({
	 			onSelect: function(record){
	 				if(record.configCode==""){//选中“请选择”，则提醒用户重新选择！
						$.messager.alert('错误信息','请选择分配资源的状态!','info', function(r){
			 				$(ed.target).combobox('setValue','1');
						});
			 			return;
					}
	 			}
	 		});
	 		$(ed.target).combobox('setValue',value);
	     },
	     onCheck: function(index,row){
		 	if(row.state==""){
		 		$('#webResourceTable').datagrid('beginEdit', index);
			 	var ed = $('#webResourceTable').datagrid('getEditor', {index:index,field: 'state'});
		 		$(ed.target).combobox('setValue','1');
		 	}
	     },
	     onUncheck: function(index,row){
	    	 $('#webResourceTable').datagrid('beginEdit', index);
	    	 var ed = $('#webResourceTable').datagrid('getEditor', {index:index,field: 'state'});
			 $(ed.target).combobox('setValue','');
			 $('#webResourceTable').datagrid('endEdit', index);
		 },
		 onLoadSuccess: function(data){
			 var rowData = data.rows;
			 $.each(rowData,function(idx,val){
				 if(val.checked=="true"){
					 $('#webResourceTable').datagrid('checkRow', idx);
				 }
			 });
		 }
	});
	
	// 绑定按钮方法
	$('#searchBtn').click(function(){
		search();
	});
	$('#resetBtn').click(function(){
		$('#groupNameC').val('');
		$('#stateC').combobox('setValue', '');
		$('#parentIdC').combobox('setValue', '');
	});
	$('#addBtn').click(function(){
		getAllResource();
		// 初始化归属父类下拉框
		$('#state').combobox('setValue', '1'); // 默认启用
		$('#parentId').combobox({
			panelHeight:'auto',
			multiple:false,
			value: '',
			valueField: 'id',
			textField: 'name',
			editable: false,
			data: allGroup
		});
		$('#editGroupDialogForm').form('clear');
		// 初始化资源列表信息
		$('#webResourceTable').datagrid('loadData', allResources);

		$('#editGroupDialog').dialog({
			title: '增加组',
			closed: false,
			buttons:[{
				text: '保存',
				iconCls: 'icon-ok',
				handler: function(){
					$('#webResourceTable').datagrid('acceptChanges');
					if(!$('#editGroupDialogForm').form('validate')){
						return;
					}
					if(isNull($('#state').combobox('getValue'))){
						$.messager.show({
							title:'提示信息',
							msg:'请选择状态',
							timeout:5000,
							showType:'slide'
						});
						return;
					}
					var ids = new Array();
					var nodes = $('#webResourceTable').datagrid('getSelections');
					if(nodes && nodes.length>0){
						for(var i in nodes){
							ids.push(nodes[i].id+"|"+nodes[i].state);
						}
					}
					$.ajax({
						type : 'POST',
						async: false,
						url : '${ctx}/base/webGroup/createGroup',
						data : {
							name: $('#name').val(),
							role: $('#role').val(),
							value: $('#value').val(),
							parentId:$('#parentId').combobox('getValue'),
							positionCode: $('#positionCode').val(),
							positionName: $('#positionName').val(),
							remark: $('#remark').val(),
							state:$('#state').combobox('getValue'),
							type:$('#type').combobox('getValue'),
							resIds: ids.toString()
						},
						success : function(data, status) {
							if(!data.status || data.status!='FAIL'){
								// 刷新当前组列表信息
								$('#webGroupTable').datagrid('reload');
								getAllGroup();
								// 关闭弹出框
								$('#editGroupDialog').dialog('close');
								// 提示成功信息
								$.messager.show({
									title:'提示信息',
									msg:'组信息添加成功！',
									timeout:5000,
									showType:'slide'
								});
							} else {
								showValidateMessage(data.result);
							}
						},
						error : function(data, status) {
							$.messager.alert('错误信息','组信息添加失败！<br/>'+getJsonErrorMsg(data),'error');
						},
						datatype : "json"
					});
				}
			},{
				text: '重置',
				iconCls: 'icon-undo',
				handler: function(){
					$('#editGroupDialogForm').form('reset');
					$('#webResourceTable').datagrid('uncheckAll');
				}
			},{
				text: '返回',
				iconCls: 'icon-cancel',
				handler: function(){
					$('#editGroupDialogForm').form('clear');
					$('#editGroupDialog').dialog('close');
				}
			}]
		});
		
	});
	$('#removeBtn').click(function(){
		var selectList = $('#webGroupTable').datagrid('getSelections');
		if(!selectList || selectList.length==0){
			// 无需处理
			return;
		}
		$.messager.confirm('确认信息', '确定删除选定的组信息?', function(r){
			if(r){
				if(selectList && selectList.length>0){
					var ids = new Array();
					for(var i in selectList){
						ids.push(selectList[i].id);
					}
					$.ajax({
						type : 'POST',
						async: false,
						url : '${ctx}/base/webGroup/deleteGroups',
						data : {
							ids: ids.toString()
						},
						success : function(data, status) {
							// 刷新当前组列表信息
							$('#webGroupTable').datagrid('reload');
							getAllGroup();
							$.messager.show({
								title:'提示信息',
								msg:'组信息删除成功！',
								timeout:5000,
								showType:'slide'
							});
						},
						error : function(data, status) {
							$.messager.alert('错误信息','删除组信息失败！<br/>'+getJsonErrorMsg(data),'error');
						},
						datatype : "json"
					});
				}
			}
		});
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
	//隐藏表头的checkbox
	$('#editGroupDialog .datagrid-header-check input').hide();
});
</script>
</body>
</html>