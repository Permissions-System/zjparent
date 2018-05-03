<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#queryForm${radomId} table td {
	padding-left:10px;
	font-size: 13px;
	nowrap:nowrap;
	height: 30px;
}
.tx_input${radomId} {
	text-align: left;
	font-size: 13px;
	height: 30px;
}
.tx_label${radomId} {
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
</style>
</head>
<body>
	<div id="toolbar${radomId}" style="padding:0;padding-bottom: 0;">
		<form id="queryForm${radomId}">
			<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="tx_label">
							<label for="managerNameC${radomId}">员工姓名：</label>
						</td>
						<td class="tx_input">
							<input id="managerNameC${radomId}" class="easyui-validatebox" 
								data-options="required:false,validType:['managerName${radomId}[]','maxLength${radomId}[2,20]']"/>
						</td>
						<td class="tx_label">
							<label for="c3OrgNameC${radomId}">C3机构名称：</label>
						</td>
						<td class="tx_input">
							<input id="c3OrgNameC${radomId}" class="easyui-validatebox" 
								data-options="required:false,validType:['cOrgName_canNotUseNumberic[]','maxLength${radomId}[2,30]']" />
						</td>
						<td colspan="2" style="align:'center';">
							<a id="searchButton${radomId}" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<table id="loanApproveManagerListDatagrid"></table>
<script type="text/javascript">
//计算字符串长度,中文按照3个字符计算
function countCharNum${radomId}(str){
	if(str==null){
		return 0;
	}
	return str.replace(/([^\x00-\xff])/g,'aaa').length;
}
//校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength${radomId}: {
		validator: function(value, param){
			// param[0]字符串类型: 1-数字英文字符, 2-中文字符
			if(param[0]==2){
				return countCharNum${radomId}(value) <= param[1];
			} else {
				return value.length <= param[1];
			}
		},
		message: '最大长度为{1}个字符'
	},
	managerName${radomId}: {
		validator: function(value, param){
			var p = new RegExp('^[a-zA-Z-_.．。·\u0391-\uFFE5]*$');
			return p.test(value);
		},
		message: '请输入正确的员工姓名'
	},
	cOrgName_canNotUseNumberic: {
		validator: function(value, param){
			var p = new RegExp('^[0-9a-zA-Z-_.．。·\u0391-\uFFE5]*$');
			return p.test(value);
		},
		message: '请输入正确的C3机构名称'
	}
});

//解析并显示异常信息
function showErrorMessage${radomId}(prefixStr, data) {
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
function search${radomId}(){
	if(!$('#queryForm${radomId}').form('validate')){
		return;
	}
	$('#loanApproveManagerListDatagrid').datagrid('load', {
		busiGroupCode: '${businessGroup.busiGroupCode}',
		managerName: $.trim($('#managerNameC${radomId}').val()),
		c3OrgName: $.trim($('#c3OrgNameC${radomId}').val())
    });
}

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg${radomId}(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
}

// 页面初始化
$(document).ready(function(){	
	// 查询按钮
	$('#searchButton${radomId}').click(function(){
		search${radomId}();
	});
	
	
	// 贷款审批人列表
	$("#loanApproveManagerListDatagrid").datagrid({
		nowrap: false,
		pageNumber: 1,
        pageSize: 10,
        pageList: [10],
        pagination: true,
        rownumbers: true,
        singleSelect: true, //单选
        fit: true,
        toolbar: '#toolbar${radomId}',
        striped: true,
        url: '${ctx}/base/busiGroup/manager/approveManager/loadDataForCheck',
		method: 'post',
		queryParams: {
			busiGroupCode: '${businessGroup.busiGroupCode}'
		},
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','查询贷款审核人员列表失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'managerName',title:'员工姓名',align:'center',width:180,rowspan:2,halign:'center'},
			{field:'identNo',title:'身份证编号',align:'center',width:200,rowspan:2,halign:'center'},
			{field:'c3OrgCode',title:'C3机构编号',align:'center',width:200,rowspan:2,halign:'center'},
			{field:'c3OrgName',title:'C3机构名称',align:'center',width:245,rowspan:2,halign:'center'}
			]]
	});
});
</script>
</body>
</html>