<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#queryForm table td {
	padding-left:10px;
	font-size: 13px;
	nowrap:nowrap;
	height: 30px;
}
.tx_input {
	text-align: left;
	font-size: 13px;
	height: 30px;
}
.tx_label {
	text-align: right;
	font-size: 13px;
	height: 30px;
	width: 150px;
}
.datagrid-header .datagrid-cell {
  height: auto;
}
.datagrid-header .datagrid-cell span {
  font-size: 12px;
}
.span_required {
    color: red;
}
.readonly{
	background-color:#eee;
}
</style>
</head>
<body>
	<div style="text-align: center;padding: 10px;">
		<div id="p1" class="easyui-panel" title="商圈信息" style="height:60px" >
			<table style="width: 98%;" border="0" cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="tx_label">
							<label>商圈名称：</label>
						</td>
						<td id="busiGroupName" class="tx_input">
							${businessGroup.busiGroupName}
						</td>
						<td class="tx_label">
							<label>商圈编号：</label>
						</td>
						<td id="busiGroupCode" class="tx_input">
							${businessGroup.busiGroupCode}
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="p2" class="easyui-panel" title="商圈评级人员" style="height:138px" >
			<table id="busiGroupBgRatingManagerDatagrid"></table>
		</div>
		<div id="p3" class="easyui-panel" title="贷款审核人员" style="height:389px">
			<div id="toolbar" style="padding:0;padding-bottom: 0;">
				<form id="queryForm">
					<table style="width: 100%;" border="0" 
						cellpadding="2" cellspacing="3" align="center">
							<tbody>
								<tr>
									<td class="tx_label">
										<label for="managerNameC">员工姓名：</label>
									</td>
									<td class="tx_input">
										<input id="managerNameC" class="easyui-validatebox" data-options="required:false,validType:['managerName[]','maxLength[2,20]']"/>
									</td>
									<td class="tx_label">
										<label for="c3OrgNameC">C3机构名称：</label>
									</td>
									<td class="tx_input">
										<input id="c3OrgNameC" class="easyui-validatebox" data-options="required:false,validType:['cOrgName[]','maxLength[2,30]']" />
									</td>
									<td colspan="2" style="align:'center';">
										<a id="searchButton" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
										<a id="appointApproveManagerBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
										<!-- 样例代码
										<a id="testBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'">贷款审批人员列表</a>
										  -->
									</td>
								</tr>
							</tbody>
					</table>
				</form>
			</div>
			<table id="busiGroupManagerDatagrid"></table>
			<!-- 选定商圈员工 -->
			<div id="addBusiGroupManagerDialog"></div>
			<!-- 贷款复核人列表 -->
			<div id="approveManagerListDialog"></div>
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
	managerName: {
		validator: function(value, param){
			var p = new RegExp('^[a-zA-Z-_.．。·\u0391-\uFFE5]*$');
			return p.test(value);
		},
		message: '请输入正确的员工姓名'
	},
	cOrgName: {
		validator: function(value, param){
			var p = new RegExp('^[0-9a-zA-Z-_.．。·\u0391-\uFFE5]*$');
			return p.test(value);
		},
		message: '请输入正确的C3机构名称'
	}
});

//解析并显示异常信息
function showErrorMessage(prefixStr, data) {
	if(data && data.status && data.status=='FAIL'){
		var errorMsg = prefixStr;
		errorMsg += isNull(data.result.errorMsg) ? '' : ('<br/>'+data.result.errorMsg);
		var fieldErrors = isNull(data.result.fieldErrors)? [] : data.result.fieldErrors;
		for(var i in fieldErrors){
			errorMsg += '<br/>'+fieldErrors[i];
		}
		$.messager.alert('错误信息', errorMsg, 'error'); 
		return true;
	} else {
		return false;
	}
}

// 搜索方法动作
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	$('#busiGroupManagerDatagrid').datagrid('load', {
		busiGroupCode: $.trim($('#busiGroupCode').text()),
		managerName: $.trim($('#managerNameC').val()),
		c3OrgName: $.trim($('#c3OrgNameC').val())
    });
}

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

// 将贷款审批人员移除列表
function deleteApproveManager(recNo){
	$.messager.confirm('确认信息','确定移除贷款审批人员?',function(r){
		if (r){
			$.messager.progress({
				title: '',
				msg: '正在移除贷款审批人员信息，请稍候...',
				text: ''
			});
			$.ajax({
				type : 'POST',
				async: false,
				url : ctx + '/base/busiGroup/manager/approveManager/delete',
				data : {
					recNo: recNo
				},
				success : function(data, status) {
					$.messager.progress('close');
					// 刷新列表
					$('#busiGroupManagerDatagrid').datagrid('reload');
				},
				error : function(data, status) {
					$.messager.progress('close');
					$.messager.alert('错误信息','移除贷款审批人员信息失败！<br/>'+getJsonErrorMsg(data),'error');
				},
				datatype : "json"
			});   
		}
	});
}

// Ajax创建商圈业务人员信息
function createOrUpdatManager(reqUrl, managerData, sucessFunc, errorFunc){
	if(!managerData || isNull($('#busiGroupCode').text())){
		return;
	}
	$.messager.progress({
		title: '',
		msg: '正在处理商圈业务人员信息，请稍候...',
		text: ''
	});
	$.ajax({
		type : 'POST',
		async: false,
		url : ctx + reqUrl,
		data : {
			// 商圈信息
			busiGroupCode: $.trim($('#busiGroupCode').text()),
			// 业务人员信息
			name: managerData.username,
			identNo: managerData.certno,
			c3OrgNo: managerData.userinstcode,
			c3OrgName: managerData.userinstname,
			tel: managerData.userormobile,
			email: managerData.useroreaddr
		},
		success : function(data, status) {
			$.messager.progress('close');
			if(sucessFunc){
				sucessFunc(data, status);
			}
		},
		error : function(data, status) {
			$.messager.progress('close');
			if(errorFunc){
				errorFunc(data, status);
			} else {
				$.messager.alert('错误信息','更新或创建商圈业务人员失败！<br/>'+getJsonErrorMsg(data),'error');
			}
		},
		datatype : "json"
	});
}

// 选定商圈评级发起人
function appointBgRatingManager(){
	$('#addBusiGroupManagerDialog').dialog({
		title: '选择商圈评级发起人',
		closed: false,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为商圈评级发起人',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请选择商圈评级发起人！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				// 创建或更新商圈评级发起人
				createOrUpdatManager('/base/busiGroup/manager/bgRatingManager/add', dataNode, function(data, status){
					// 刷新列表
					$('#busiGroupBgRatingManagerDatagrid').datagrid('reload');
					// 关闭弹出页面
					$('#addBusiGroupManagerDialog').dialog('close');
				}, 
				function(data, status){
					$.messager.alert('错误信息','创建或更新商圈评级发起人失败！<br/>'+getJsonErrorMsg(data),'error');
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#addBusiGroupManagerDialog').dialog('close');
			}
		}]
	});
}

// 选择商圈评级审核人
function appointBgRatingApproveManager(){
	$('#addBusiGroupManagerDialog').dialog({
		title: '选择商圈评级审核人',
		closed: false,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为商圈评级审核人',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请选择商圈评级审核人！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				// 创建或更新商圈评级发起人
				createOrUpdatManager('/base/busiGroup/manager/bgRatingApproveManager/add', dataNode, function(data, status){
					// 刷新列表
					$('#busiGroupBgRatingManagerDatagrid').datagrid('reload');
					// 关闭弹出页面
					$('#addBusiGroupManagerDialog').dialog('close');
				}, 
				function(data, status){
					$.messager.alert('错误信息','创建或更新商圈评级审核人失败！<br/>'+getJsonErrorMsg(data),'error');
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#addBusiGroupManagerDialog').dialog('close');
			}
		}]
	});
}

// 选择商圈评级认定人
function appointBgRatingIdentifyManager(){
	$('#addBusiGroupManagerDialog').dialog({
		title: '选择商圈评级认定人',
		closed: false,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为商圈评级认定人',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请选择商圈评级认定人！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				// 创建或更新商圈评级发起人
				createOrUpdatManager('/base/busiGroup/manager/bgRatingIdentifyManager/add', dataNode, function(data, status){
					// 刷新列表
					$('#busiGroupBgRatingManagerDatagrid').datagrid('reload');
					// 关闭弹出页面
					$('#addBusiGroupManagerDialog').dialog('close');
				}, 
				function(data, status){
					$.messager.alert('错误信息','创建或更新商圈评级认定人失败！<br/>'+getJsonErrorMsg(data),'error');
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#addBusiGroupManagerDialog').dialog('close');
			}
		}]
	});
}

// 页面初始化
$(document).ready(function(){
	/* 样例代码
	$('#testBtn').click(function(){
		$('#approveManagerListDialog').dialog({
			title: '选择贷款审批人',
			closed: false,
			cache: true,
			href: '${ctx}/base/busiGroup/manager/approveManager/list/${businessGroup.busiGroupCode}',
			modal: true,
			width: 900,
			height: 420,
			buttons:[{
				text:'指派为贷款审批人',
				handler:function(){
					// 获取弹出页面数据
					var dataNode = $('#loanApproveManagerListDatagrid').datagrid('getSelected');
				}
			},{
				text:'取消',
				handler:function(){
					$('#approveManagerListDialog').dialog('close');
				}
			}]
		});
	});
	*/
	// 选择贷款审批人
	$('#appointApproveManagerBtn').click(function(){
		$('#addBusiGroupManagerDialog').dialog({
			title: '选择贷款审批人',
			closed: false,
			cache: true,
			href: '${ctx}/loan/preloan/instuserinfo',
			modal: true,
			fit: true,
			buttons:[{
				text:'指派为贷款审批人',
				handler:function(){
					// 获取弹出页面数据
					var dataNode = $('#roleTable').datagrid('getSelected');
					if(isNull(dataNode) || isNull(dataNode.certno)){
						$.messager.show({
							title: '提示信息',
							msg: '请选择贷款审批人！',
							timeout: 5000,
							showType: 'slide'
						});
						return;
					}
					// 创建或更新贷款审批人
					createOrUpdatManager('/base/busiGroup/manager/approveManager/add', dataNode, function(data, status){
						// 刷新列表
						$('#busiGroupManagerDatagrid').datagrid('reload');
						// 关闭弹出页面
						$('#addBusiGroupManagerDialog').dialog('close');
					}, 
					function(data, status){
						$.messager.alert('错误信息','创建或更新贷款审批人失败！<br/>'+getJsonErrorMsg(data),'error');
					});
				}
			},{
				text:'取消',
				handler:function(){
					$('#addBusiGroupManagerDialog').dialog('close');
				}
			}]
		});
	});
	
	// 查询按钮
	$('#searchButton').click(function(){
		search();
	});
	
	// 贷款审批人列表
	$("#busiGroupManagerDatagrid").datagrid({
		nowrap: false,
		pageNumber: 1,
        pageSize: 10,
        pageList: [10],
        pagination: true,
        rownumbers: true,
        singleSelect: true, //单选
        fit: true,
        toolbar: '#toolbar',
        striped: true,
        url: '${ctx}/base/busiGroup/manager/approveManager/loadData',
		method: 'post',
		queryParams: {
			busiGroupCode: '${businessGroup.busiGroupCode}'
		},
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','查询贷款审核人员列表失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'managerName',title:'员工姓名',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'identNo',title:'身份证编号',align:'center',width:200,rowspan:2,halign:'center'},
			{field:'c3OrgCode',title:'C3机构编号',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'c3OrgName',title:'C3机构名称',align:'center',width:250,rowspan:2,halign:'center'},
			{field:'operation',title:'操作',align:'center',width:180,
				formatter: function(value, row, index){
					return '<button onclick="deleteApproveManager(\''+row['recNo']+'\')" class="easyui-linkbutton">从列表移除</button>&nbsp;';
				}
			}
			]]
	});
	
	// 商圈评级人员列表
	$("#busiGroupBgRatingManagerDatagrid").datagrid({
		nowrap: false,
        singleSelect: true, //单选
        fit: true,
        striped: true,
        url: '${ctx}/base/busiGroup/manager/bgRatingManager/loadData',
		method: 'post',
		queryParams: {
			busiGroupCode: '${businessGroup.busiGroupCode}'
		},
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','查询贷款审核人员列表失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'managerType',title:'人员类型',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'managerName',title:'员工姓名',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'identNo',title:'身份证编号',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'c3OrgCode',title:'C3机构编号',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'c3OrgName',title:'C3机构名称',align:'center',width:200,rowspan:2,halign:'center'},
			{field:'operation',title:'操作',align:'center',width:180,
				formatter: function(value, row, index){
					switch(index){
					case 0:
						return '<button onclick="appointBgRatingManager()" class="easyui-linkbutton">'+row['managerType']+'</button>';
					case 1:
						return '<button onclick="appointBgRatingApproveManager()" class="easyui-linkbutton">'+row['managerType']+'</button>';
					case 2:
						return '<button onclick="appointBgRatingIdentifyManager()" class="easyui-linkbutton">'+row['managerType']+'</button>';
					}
				}
			}
			]]
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