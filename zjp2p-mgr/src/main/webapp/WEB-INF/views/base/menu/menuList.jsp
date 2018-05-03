<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="com.zjgt.p2p.base.domain.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.my_td_label {
	padding-left:10px;
	width: 100px;
	height: 30px;
	text-align: left;
	font-size: 13px;
	nowrap:nowrap;
	// font-weight: bold;
}
.my_td_text {
	padding-left:5px;
	width: 250px;
	height: 30px;
	text-align:left;
}
.readonly{
	cursor:not-allowed;
	background-color:#eee;
}
.required{
	background-color:#FFFF80;
}
</style>
</head>
<body>
	<div class="easyui-layout"  data-options="fit:true">
		<div data-options="region:'west',title:'菜单树',split:true,collapsible:false"
			style="width: 370px;">
			<table style="width: 100%;height:100%" border="0" 
				cellpadding="2" cellspacing="3" align="center">
				<tr>
					<td style="text-align:center; height:30px;">
						<a id="reload" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">刷新菜单树</a>
						<a id="add" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">增加菜单</a>
						<a id="edit" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">编辑</a>
						<a id="delete" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'">删除</a>
					</td>
				</tr>
				<tr>
					<td style="height:10px;"><hr /></td>
				</tr>
				<tr>
					<td style="text-align:left;width:100%; height:100%;vertical-align: top;">
						<div id="treeMenu" class="easyui-menu" style="width:120px;">
							<div onclick="reloadMenuTree()" data-options="iconCls:'icon-reload'">刷新菜单树</div>
							<div onclick="addSubMenuNode()" data-options="iconCls:'icon-add'">增加子菜单</div>
							<div onclick="addSiblingMenuNode()" data-options="iconCls:'icon-add'">增加兄弟菜单</div>
							<div onclick="editMenuNode()" data-options="iconCls:'icon-edit'">编辑</div>
							<div onclick="deleteMenuNode()" data-options="iconCls:'icon-remove'">删除</div>
							<div onclick="expandNode()" data-options="iconCls:''">展开</div>
							<div onclick="expandAllNode()" data-options="iconCls:''">全部展开</div>
							<div onclick="collapseNode()" data-options="iconCls:''">折叠</div>
							<div onclick="collapseAllNode()" data-options="iconCls:''">全部折叠</div>
						</div>
						<ul id="menuTree">
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<div data-options="region:'center',title:'菜单明细信息'"
			style="padding: 5px; background: #FFF;">
			<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="my_td_label">菜单编号</td>
						<td class="my_td_text"><input id="menuCodeR" class="easyui-validatebox" disabled="disabled" style="width:200px;"></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单名称</td>
						<td class="my_td_text"><input id="menuNameR" class="easyui-validatebox" disabled="disabled" style="width:200px;"></td>
					</tr>
					<tr>
						<td class="my_td_label">交易功能码</td>
						<td class="my_td_text"><input id="transCodeR" class="easyui-validatebox" disabled="disabled" style="width:200px;"></td>
					</tr>
					<tr id="treepathR_TR">
						<td class="my_td_label">TREEPATH</td>
						<td class="my_td_text"><input id="treepathR" class="easyui-validatebox" disabled="disabled" style="width:200px;"></td>
					</tr>
					<tr id="parentMenuCodeR_TR">
						<td class="my_td_label">上级菜单编码</td>
						<td class="my_td_text"><input id="parentMenuCodeR" class="easyui-validatebox" disabled="disabled" style="width:200px;"></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单顺序号</td>
						<td class="my_td_text"><input id="orderNumR" class="easyui-numberbox" data-options="min:0, precision:0" disabled="disabled"></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单状态</td>
						<td class="my_td_text">
							<input id="menuStatusR" >
		    			</td>
					</tr>
				<tbody>
			</table>
		</div>
		<div id="menuDialog" class="easyui-dialog" title="菜单信息" style="width:500px;height:350px;"
			data-options="resizable:true,modal:true,closed:true">
			<form id="menuForm" method="post">
				<table style="padding:20 30 0 50">
				<tbody>
					<tr>
						<td class="my_td_label">菜单编号</td>
						<td class="my_td_text"><input id="menuCode" class="easyui-validatebox"  data-options="required:true,validType:['menuCode[]','maxLength[10]']"></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单名称</td>
						<td class="my_td_text"><input id="menuName" style="width:200px;" class="easyui-validatebox"  data-options="required:true,validType:['menuName[]','maxLength[60]']"></td>
					</tr>
					<tr>
						<td class="my_td_label">交易功能码</td>
						<td class="my_td_text"><input id="transCode" style="width:200px;" class="easyui-validatebox" data-options="validType:['transCode[]','maxLength[10]']"></td>
					</tr>
					<tr id="treepath_TR">
						<td class="my_td_label">TREEPATH</td>
						<td class="my_td_text"><input id="treepath" class="easyui-validatebox" style="width:200px;" data-options="validType:['treepathLength[50]']"></td>
					</tr>
					<tr id="parentMenuCode_TR">
						<td class="my_td_label">上级菜单</td>
						<td class="my_td_text"><input id="parentMenuCode" class="easyui-combotree" style="width:250px;" data-options="required:true"></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单顺序号</td>
						<td class="my_td_text"><input id="orderNum" class="easyui-numberspinner"  style="width:200px;"></td>
					</tr>
					<tr>
						<td class="my_td_label">菜单状态</td>
						<td class="my_td_text">
							<input id="menuStatus" >
	    			</td>
				</tr>
			<tbody>
		</table>
		</form>
	</div>
	</div>
<script type="text/javascript">
//计算字符串长度,中文按照3个字符计算
function countCharNum(str){
	if(str==null){
		return 0;
	}
	return str.replace(/([^\x00-\xff])/g,'aaa').length;
}
// 校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength: {
		validator: function(value, param){
			return countCharNum(value) <= param[0];
		},
		message: '最大长度为{0}个字符'
	},
	menuCode: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9]');
			return !p.test(value);
		},
		message: '菜单编号应由数字字母组成'
	},
	menuName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）]');
			return !p.test(value);
		},
		message: '菜单名称应由数字、字母、中文字符或括号组成'
	},
	transCode: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9]');
			return !p.test(value);
		},
		message: '交易功能码应由数字或字母组成'
	},
	treepathLength: {
		validator: function(value, param){
			var pass = (value.length <= param[0]);
			if(!pass){
				$.messager.show({
					title:'提示信息',
					msg:'超过系统菜单层级深度限制，无法处理！',
					timeout:5000,
					showType:'slide'
				}); 
			}
			return pass;
		},
		message: ''
	}
});
var selectedMenuNode = null;
var menuNodeData = null;
var changeParentMenuCodeFlag = false;

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

// Ajax查询，获取菜单根节点列表
function getMenuTreeList(sucessFunc, errorFunc) {
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/menu/getMenuTree',
		data : {
		},
		success : function(data, status) {
			sucessFunc(data, status);
		},
		error : function(data, status) {
			errorFunc(data, status);
		},
		datatype : "json"
	});
}

// Ajax请求, 保存菜单信息
function saveMenuInfo(data, sucessFunc, errorFunc) {
	$.ajax({
		type : "POST",
		async: false,
		url : "${ctx}/base/menu/saveMenuInfo",
		data : {
			menuCode: data.menuCode,
			menuName: data.menuName,
			transCode: data.transCode,
			treepath: data.treepath,
			orderNum: data.orderNum,
			menuStatus: data.menuStatus,
			parentMenuCode: data.parentMenuCode
		},
		success : function(data, status) {
			if(sucessFunc){
				sucessFunc(data, status);
			}
		},
		error : function(data, status) {
			if(errorFunc){
				errorFunc(data, status);
			}
		},
		datatype : "json"
	});
}
// Ajax请求，更新菜单信息
function updateMenuInfo(data, sucessFunc, errorFunc) {
	$.ajax({
		type : "POST",
		async: false,
		url : "${ctx}/base/menu/updateMenuInfo",
		data : {
			menuCode: data.menuCode,
			menuName: data.menuName,
			transCode: data.transCode,
			treepath: data.treepath,
			orderNum: data.orderNum,
			menuStatus: data.menuStatus,
			parentMenuCode: data.parentMenuCode
		},
		success : function(data, status) {
			if(sucessFunc){
				sucessFunc(data, status);
			}
		},
		error : function(data, status) {
			if(errorFunc){
				errorFunc(data, status);
			}
		},
		datatype : "json"
	});
}
// Aiax请求， 删除菜单信息
function deleteMenuInfo(menuCode, sucessFunc, errorFunc) {
	$.ajax({
		type : 'POST',
		url : '${ctx}/base/menu/deleteMenuInfo',
		data : {
			menuCode: menuCode
		},
		success : function(data, status) {
			if(sucessFunc){
				sucessFunc(data, status);
			}
		},
		error : function(data, status) {
			if(sucessFunc){
				errorFunc(data, status);
			}
		},
		datatype : "json"
	});
}


//折叠节点
function expandNode(){
	var selected = $('#menuTree').tree('getSelected');
	if(!selected){
		$.messager.show({
			title:'提示信息',
			msg:'请选择菜单节点！',
			timeout:5000,
			showType:'slide'
		}); 
		return;
	} else {
		$('#menuTree').tree('expand', selected.target);
	}
}
//展开所有节点
function expandAllNode(){
	var selected = $('#menuTree').tree('getSelected');
	if(!selected){
		var roots = $('#menuTree').tree('getRoots');
		for(var i in roots){
			$('#menuTree').tree('expandAll', roots[i].target);
		}
	} else {
		$('#menuTree').tree('expandAll', selected.target);
	}
}

// 折叠节点
function collapseNode(){
	var selected = $('#menuTree').tree('getSelected');
	if(!selected){
		$.messager.show({
			title:'提示信息',
			msg:'请选择菜单节点！',
			timeout:5000,
			showType:'slide'
		}); 
		return;
	} else {
		$('#menuTree').tree('collapse', selected.target);
	}
}

//折叠所有节点
function collapseAllNode(){
	var selected = $('#menuTree').tree('getSelected');
	if(!selected){
		var roots = $('#menuTree').tree('getRoots');
		for(var i in roots){
			$('#menuTree').tree('collapseAll', roots[i].target);
		}
	} else {
		$('#menuTree').tree('collapseAll', selected.target);
	}
}

// 删除菜单节点
function deleteMenuNode(){
	// 判断是否提交到服务器端
	var selected = $('#menuTree').tree('getSelected');
	if(!selected){
		$.messager.show({
			title:'提示信息',
			msg:'请选择需要删除的菜单节点！',
			timeout:5000,
			showType:'slide'
		}); 
		return;
	}
	// 如果不是叶子节点，则不允许删除
	if(!$('#menuTree').tree('isLeaf', selected.target)){
		$.messager.alert('警告信息','菜单下还有子节点，不允许删除！','warning');
		return;
	} else {
		$.messager.confirm('确认信息', '确定删除菜单"'+selected.attributes.menuName+'"?', function(r){
			if(r){
				if(selected.attributes._from_server_flag!=false){
					deleteMenuInfo(selected.attributes.menuCode, function(){
						$.messager.show({
							title:'提示信息',
							msg:'删除成功！',
							timeout:5000,
							showType:'slide'
						}); 
						$('#menuTree').tree('remove', selected.target);
					},function(){
						$.messager.alert('警告信息','菜单删除失败！<br/>'+getJsonErrorMsg(data),'warning');
					});
				} else {
					$('#menuTree').tree('remove', selected.target);
				}
			}
		});
	}
}

// 设置只读显示
function setReadonly(target, flag){
	if(flag){
		// 只读
		// $('#'+target).addClass('readonly');
		$('#'+target).attr('disabled','disabled');
	} else {
		// 非只读
		$('#'+target).removeAttr('disabled');
		// $('#'+target).removeClass('readonly');
	}
}
// 设置必输项显示
function setRequired(target, flag){
	if(flag){
		// 必输
		$('#'+target).addClass('required');
		$('#'+target).attr('data-options',"required:true");
	} else {
		// 选输
		$('#'+target).removeClass('required');
		$('#'+target).attr('data-options',"required:false");
	}
}

// 刷新菜单树
function reloadMenuTree(neadToCollapse){
	getMenuTreeList(function(data, status){
		$('#menuTree').tree('loadData',data);
		if(neadToCollapse){
			collapseAllNode();
		}
	}, function(data, status){
		$.messager.alert('错误信息','获取菜单数据失败！<br/>'+getJsonErrorMsg(data),'error');
	});
}

//新增子菜单节点
function addSubMenuNode(){
	addMenuNode();
	var selected = $('#menuTree').tree('getSelected');
	if(selected){
		$('#parentMenuCode').combotree('setValue', selected.attributes.menuCode);
		$('#treepath').val(selected.attributes.treepath + selected.attributes.menuCode + '/');
	}
}

// 新增兄弟菜单
function addSiblingMenuNode(){
	addMenuNode();
	var selected = $('#menuTree').tree('getSelected');
	if(selected){
		var parentNode = $('#menuTree').tree('getParent', selected.target);
		if(parentNode){
			$('#parentMenuCode').combotree('setValue', parentNode.attributes.menuCode);
			$('#treepath').val(parentNode.attributes.treepath + parentNode.attributes.menuCode + '/');
		} else {
			$('#parentMenuCode').combotree('setValue', 'ROOT');
			$('#treepath').val('/');
		}
	}
}

// 增加菜单节点
function addMenuNode(){
	// 加载菜单树数据
	var dataArray = new Array();
	var roots = $('#menuTree').tree('getRoots');
	if(roots && roots.length>0){
		$.each(roots, function(i, rootNode){
			dataArray.push($('#menuTree').tree('getData', rootNode.target));
		});
	}
	var rootNode = {};
	rootNode.id = 'ROOT';
	rootNode.text = '菜单树根节点';
	rootNode.checked = false;
	rootNode.state = dataArray.length>0? 'closed' : 'open';
	rootNode.attributes = {};
	rootNode.attributes.treepath = '';
	rootNode.attributes.menuCode = 'ROOT';
	rootNode.attributes.menuName = '菜单树根节点';
	rootNode.children = dataArray;
	$('#parentMenuCode').combotree({
		data: [rootNode],
		lines: true,
		animate: false,
		//panelHeight: 'auto',
		multiple: false,
		onSelect: function(node){
			// 选中时，联动设置treepath
			var treepath = '';
			if(node.attributes.menuCode=='ROOT'){
				treepath = '/';
			} else {
				treepath = node.attributes.treepath + node.attributes.menuCode + '/';
			}
			$('#treepath').val(treepath);
		}
	});
	
	// 设置必输项
	setReadonly('menuCode', false);
	setRequired('menuCode', true);
	setRequired('menuName', true);
	setRequired('parentMenuCode', true);
	$('#treepath_TR').hide();
	// 初始化页面值
	<%--  <%=BaseConstant.START_STOP_FLAG_YES%>  1 --%>
	$('#menuStatus').combobox('setValue', '<%=BaseConstant.START_STOP_FLAG_YES%>');//菜单状态默认:启用 
	$('#menuForm').form('validate');
	
	// 打开弹出页面
	$('#menuDialog').dialog({
		title: '新增菜单',
		iconCls:'icon-add',
		closed: false,
		cache: false,
		
		onBeforeClose:function(){
			$('#menuForm').form('clear');
		},
		
	 	buttons : [{
			text : '保存',
			handler : function(){
				menuNodeData = {};
				menuNodeData.id = $('#menuCode').val();
				menuNodeData.text = $('#menuName').val();
				menuNodeData.attributes = {};
				menuNodeData.attributes.menuCode = $('#menuCode').val();
				menuNodeData.attributes.menuName = $('#menuName').val();
				menuNodeData.attributes.treepath = $('#treepath').val();
				menuNodeData.attributes.transCode = $('#transCode').val();
				menuNodeData.attributes.parentMenuCode = $('#parentMenuCode').combotree('getValue');
				menuNodeData.attributes.orderNum = $('#orderNum').numberspinner('getValue');
				menuNodeData.attributes.menuStatus = $('#menuStatus').combobox('getValue');
				if(!$('#menuForm').form('validate')){
					return;
				}
				saveMenuInfo(menuNodeData.attributes, function(data, status){
					if(!data.status || data.status!='FAIL'){
						$.messager.show({
							title:'提示信息',
							msg:'菜单信息保存成功！',
							timeout:5000,
							showType:'slide'
						});
						reloadMenuTree();
						var addNode = $('#menuTree').tree('find', menuNodeData.attributes.menuCode);
						if(addNode){
							$('#menuTree').tree('expandTo', addNode.target);
						}
						$('#menuDialog').dialog('close');
					} else {
						showValidateMessage(data.result);
					}
				}, function(data, status){
					$.messager.alert('错误信息', '菜单信息保存失败！<br/>'+getJsonErrorMsg(data), 'error');
				});
			}
		},{
			text : '取消',
			handler : function(){
				$('#menuDialog').dialog('close');
			}
		}]  
	});//end of dialog	
}

// 修改菜单节点信息
function editMenuNode(){
	selectedMenuNode = $('#menuTree').tree('getSelected');
	if(!selectedMenuNode){
		$.messager.show({
			title:'提示信息',
			msg:'请选择需要修改的菜单节点！',
			timeout:5000,
			showType:'slide'
		});
		return;
	}
	
	// 标记初始化
	changeParentMenuCodeFlag = false; // 父节点修改标记
	// 加载菜单树数据
	var dataArray = new Array();
	var roots = $('#menuTree').tree('getRoots');
	if(roots && roots.length>0){
		$.each(roots, function(i, rootNode){
			dataArray.push($('#menuTree').tree('getData', rootNode.target));
		});
	}
	var rootNode = {};
	rootNode.id = 'ROOT';
	rootNode.text = '菜单树根节点';
	rootNode.checked = false;
	rootNode.state = dataArray.length>0? 'closed' : 'open';
	rootNode.attributes = {};
	rootNode.attributes.treepath = '';
	rootNode.attributes.menuCode = 'ROOT';
	rootNode.attributes.menuName = '菜单树根节点';
	rootNode.children = dataArray;
	$('#parentMenuCode').combotree({
		data: [rootNode],
		lines:true,
		animate: false,
		onSelect: function(node){
			// 选中时，联动设置treepath
			var treepath = '';
			if(node.attributes.menuCode=='ROOT'){
				treepath = '/';
			} else {
				treepath = node.attributes.treepath + node.attributes.menuCode + '/';
			}
			$('#treepath').val(treepath);
			if(selectedMenuNode.attributes.parentMenuCode!=node.attributes.menuCode){
				changeParentMenuCodeFlag = true;
			}
		}
		});
	var combotree = $('#parentMenuCode').combotree('tree');	// get the tree object
	var selfNode = combotree.tree('find', selectedMenuNode.id);
	combotree.tree('remove', selfNode.target);
	
	// 设置页面初始值
	$('#menuCode').val(selectedMenuNode.attributes.menuCode);
	$('#menuName').val(selectedMenuNode.attributes.menuName);
	$('#treepath').val(selectedMenuNode.attributes.treepath);
	$('#transCode').val(selectedMenuNode.attributes.transCode);
	$('#parentMenuCode').combotree('setValue', selectedMenuNode.attributes.parentMenuCode);
	$('#orderNum').numberspinner('setValue', selectedMenuNode.attributes.orderNum);
	$('#menuStatus').combobox('setValue', selectedMenuNode.attributes.menuStatus);
	$('#menuForm').form('validate');
	
	// 设置必输项
	setRequired('menuCode', false);
	setReadonly('menuCode', true);
	setRequired('menuName', true);
	setRequired('parentMenuCode', true);
	$('#treepath_TR').hide();
	
	// 打开弹出页面
	$('#menuDialog').dialog({
		title: '编辑菜单',
		iconCls:'icon-edit',
		closed: false,
		cache: false,
		
		onBeforeClose:function(){
			$('#menuForm').form('clear');
		},
		
	 	buttons : [{
			text : '更新',
			handler : function(){
				menuNodeData = {};
				menuNodeData.id = $('#menuCode').val();
				menuNodeData.text = $('#menuName').val();
				menuNodeData.attributes = {};
				menuNodeData.attributes.menuCode = $('#menuCode').val();
				menuNodeData.attributes.menuName = $('#menuName').val();
				menuNodeData.attributes.treepath = $('#treepath').val();
				menuNodeData.attributes.transCode = $('#transCode').val();
				menuNodeData.attributes.parentMenuCode = $('#parentMenuCode').combotree('getValue');
				menuNodeData.attributes.orderNum = $('#orderNum').numberspinner('getValue');
				menuNodeData.attributes.menuStatus = $('#menuStatus').combobox('getValue');
				if(!$('#menuForm').form('validate')){
					return;
				}
				updateMenuInfo(menuNodeData.attributes, function(data, status){
					if(!data.status || data.status!='FAIL'){
						reloadMenuTree();
						var editNode = $('#menuTree').tree('find', menuNodeData.attributes.menuCode);
						if(editNode){
							$('#menuTree').tree('expandTo', editNode.target);
						}
						$('#menuDialog').dialog('close');
						$.messager.show({
							title:'提示信息',
							msg:'菜单信息更新成功！',
							timeout:5000,
							showType:'slide'
						});
						$('#menuDialog').dialog('close');
					} else{
						showValidateMessage(data.result);
					}
				}, function(data, status){
					$.messager.alert('错误信息', '菜单信息更新失败！'+getJsonErrorMsg(data), 'error');
				});
			}
		},{
			text : '取消',
			handler : function(){
				$('#menuDialog').dialog('close');
			}
		}]  
	});//end of dialog	
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

$(document).ready(function(){
	$('#treepathR_TR').hide();
	$('#parentMenuCodeR_TR').hide();
	
	$('#orderNum').numberspinner({
		min: 0,
		max: 9999999,
		editable: true
	});
	
	// 绑定按钮点击响应方法
	$("#reload").click(function(){
		reloadMenuTree();
	});
	$("#add").click(function(){
		addMenuNode();
	});
	$("#edit").click(function(){
		editMenuNode();
	});
	$("#delete").click(function(){
		deleteMenuNode();
	});
	
	$('#menuStatus').combobox({
		multiple:false,
		panelHeight: 'auto',
		valueField:'configCode',
		textField:'configName',
		type:'post',
		url:'${ctx}/base/menu/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>'
	}); <%-- <%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%> START_STOP_FLAG  --%>
	$('#menuStatusR').combobox({
		multiple:false,
		disabled:true,
		valueField:'configCode',
		textField:'configName',
		type:'post',
		url:'${ctx}/base/menu/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>'
	});<%-- <%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG %>   START_STOP_FLAG --%>
	
	// 绑定树方法
	$('#menuTree').tree({
		checkbox: false,
		cascadeCheck: false,
		lines:true,
		animate:false,
		url: '${ctx}/base/menu/getMenuTree',
		method: 'post',
		onLoadSuccess: function(node, data){
			collapseAllNode();
		},
		onDblClick : function(node){
			// 叶子节点无需处理
			if($('#menuTree').tree('isLeaf', node.target)){
				return;
			}
			if(!node.state){
				
			} else if(node.state=='open'){
				$('#menuTree').tree('collapse', node.target);
			} else if(node.state=='closed') {
				$('#menuTree').tree('expand', node.target);
			}
		},

		onContextMenu: function(e, node){
			e.preventDefault();
			// select the node
			$('#menuTree').tree('select', node.target);
			$('#treeMenu').menu('show', {
				left: e.pageX,
				top: e.pageY
			});
		},
		
		onSelect: function(node){
			// 选中当前节点，将当前节点信息显示到明细界面供查看
			// 复制菜单节点数据到菜单明细
			if(node && node.attributes){
				$('#menuCodeR').val(node.attributes.menuCode);
				$('#menuNameR').val(node.attributes.menuName);
				$('#transCodeR').val(node.attributes.transCode);
				$('#treepathR').val(node.attributes.treepath);
				$('#orderNumR').numberbox('setValue', node.attributes.orderNum);
				$('#menuStatusR').combobox('setValue', node.attributes.menuStatus);
				$('#parentMenuCodeR').val(node.attributes.parentMenuCode);
			} else {
				$('#menuCodeR').val('');
				$('#menuNameR').val('');
				$('#transCodeR').val('');
				$('#treepathR').val('');
				$('#orderNumR').numberbox('setValue', null);
				$('#menuStatusR').combobox('setValue', '');
				$('#parentMenuCodeR').val('');
			}
		}
	});
});
</script>
</body>
</html>