<%@ page language="java" pageEncoding="UTF-8" %>
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
	width: 200px;
}
.tx_label {
	text-align: right;
	width: 150px;
}
.datagrid-toolbar {
  background: white;
}
</style>
</head>
<body>
<table id="groupEntTable"></table>
<div id="toolbar" style="padding-top:10px;padding-bottom: 20px;">
	<form id="queryForm">
		<table style="width: 100%;" border="0" 
			cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="tx_label">
							<label for="busiGroupCode">所属商圈：</label>
						</td>
						<td class="tx_input">
							<input id="busiGroupCode" class="easyui-combobox" style="width:150px;"
								data-options="editable:false,valueField:'busiGroupCode',textField:'busiGroupName',method:'post',url:'${ctx}/base/busiGroup/entExitBG/bgSelector'">
						</td>
						<td class="tx_label">
							<label for="entName">企业名称：</label>
						</td>
						<td class="tx_input">
							<input id="entName" class="easyui-validatebox" style="width:150px;"
								data-options="required:false,validType:['entName[]','maxLength[2,100]']"/>
						</td>
						<td style="align:left;">
							<a id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						</td>
						<td style="align:left;">
							<a id="entExitBtn" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">批量剔除</a>
						</td>
					</tr>
				</tbody>
		</table>
	</form>
</div>
<div id="groupEntConfirmWin" class="easyui-window" title="确认信息" style="width:750px;" 
	data-options="closed:true,iconCls:'icon-tip',modal:true,collapsible:false,minimizable:false,maximizable:false,top:30">
	<div style="height:30px;">
		<p style="text-align:center;font-size:20px;padding-top: 5px;"><span>确认剔除客户?</span></p>
	</div>
	<div id="groupEntConfirmTable"></div>
	<div style="height:30px;text-align:center;">
		<a id="passBtn" class="easyui-linkbutton">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="cancelBtn" class="easyui-linkbutton">取消</a>
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
	entName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_ ]');
			return !p.test(value);
		},
		message: '企业名称应由数字、字母、中文字符、下划线或括号组成'
	}
});

var entToExit = null;
function viewEntInfo(rowId){
	$('#groupEntTable').datagrid('selectRow', rowId);
	var gridData = $('#groupEntTable').datagrid('getData');
	node = gridData.rows[rowId];
	var node = $('#groupEntTable').datagrid('getSelected');
	var url = "${ctx}/base/inent/info/"+node.entNo;
	self.parent.openTab("查看:"+node.entName, url);
}

function entExit(rowId){
	var gridData = $('#groupEntTable').datagrid('getData');
	entToExit = [gridData.rows[rowId]];
	$('#groupEntConfirmTable').datagrid({
        pagination: false,
        rownumbers: true,
        data: entToExit
	});
	$('#groupEntConfirmWin').window('open');
}

function changePageParam(pageNumber, pageSize){
	var start = (pageNumber-1)*pageSize;
	var end = pageNumber*pageSize;
	end = end>entToExit.length? entToExit.length : end;
	$('#groupEntConfirmTable').datagrid({
		pageNumber: pageNumber,
		pageSize: pageSize,
        pagination: true,
        rownumbers: true,
        data: entToExit.slice(start, end)
	});
	var pager = $('#groupEntConfirmTable').datagrid().datagrid('getPager');
	pager.pagination({
		showPageList: false,
		showRefresh: false,
		total: entToExit.length,
		onSelectPage: onSelectPage,
		onRefresh: onRefresh,
		onChangePageSize: onChangePageSize
	});
}
function onSelectPage(pageNumber, pageSize){
	changePageParam(pageNumber, pageSize);
}
function onRefresh(pageNumber, pageSize){
	changePageParam(pageNumber, pageSize);
}
function onChangePageSize(pageSize){
	changePageParam(1, pageSize);
}

//搜索方法动作
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	// 重新查询列表数据
	$('#groupEntTable').datagrid('load', {
		busiGroupCode: $('#busiGroupCode').combobox("getValue"),
		entName: $.trim($('#entName').val())
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

$(function(){
	$('#groupEntTable').datagrid({    
		title: '客户出圈',
		nowrap: false,
		pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50],
        pagination: true,
        rownumbers: true,
        singleSelect: false,
        striped: true,
        fit: true,
        url: '${ctx}/base/busiGroup/entExitBG/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		toolbar: '#toolbar',
		checkOnSelect : false,
		striped: true,
		onLoadSuccess: function(data){
			$(this).datagrid('uncheckAll');
		},
		onLoadError: function(data){
			$.messager.alert('错误信息','圈内企业列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
		columns:[[     
					{field:'checked',checkbox:true,align:'center'},
					{field:'orgCode',title:'组织机构代码',width:150,align:'center'},        
			        {field:'entName',title:'企业名称',width:250,align:'center'},
			        {field:'busiGroupCode',title:'商圈编号',width:150,align:'center'},
			        {field:'busiGroupName',title:'所属商圈',width:250,align:'center'},
			        {field:'opation',title:'操作',width:180,align:'center',
						formatter : function(value, row, index) {
							var opt='';
							opt += '<button onclick="viewEntInfo('+index +')" class="easyui-linkbutton">详情>></button>&nbsp;';
							opt += '<button onclick="entExit('+index +')" class="easyui-linkbutton">剔除</button>';
							return opt;
						} 
			        }
			    ]]
	});
	
	$('#groupEntConfirmTable').datagrid({
		striped: true,
		rownumbers: true,
		singleSelect: true,
		columns:[[
			        {field:'orgCode',title:'组织机构代码',width:150,align:'center'},        
			        {field:'entName',title:'企业名称',width:180,align:'center'},
			        {field:'busiGroupCode',title:'商圈编号',width:150,align:'center'},
			        {field:'busiGroupName',title:'所属商圈',width:180,align:'center'}
			    ]]
	});
	
	// 绑定按钮点击方法
	$('#searchBtn').click(function(){
		search();
	});
	$('#entExitBtn').click(function(){
		var nodes = $('#groupEntTable').datagrid('getSelections');
		if(nodes && nodes.length>0){
			entToExit = nodes;
			if(entToExit.length<15){
				$('#groupEntConfirmTable').datagrid({
			        pagination: false,
			        rownumbers: true,
			        data: entToExit
				});
			} else {
				// 分页显示
				$('#groupEntConfirmTable').datagrid({
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
			        pagination: true,
			        rownumbers: true,
			        data: entToExit.slice(0,10)
				});
				var pager = $('#groupEntConfirmTable').datagrid('getPager');
				pager.pagination({
					showPageList: false,
					showRefresh: false,
					total: entToExit.length,
					onSelectPage: onSelectPage,
					onRefresh: onRefresh,
					onChangePageSize: onChangePageSize
				});	
			}
			$('#groupEntConfirmWin').window('open');
		}
	});
	$('#passBtn').click(function(){
		var entNos = new Array();
		for(var i in entToExit){
			entNos.push(entToExit[i].entNo);
		}
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/busiGroup/entExitBG/entExitBusiGroup',
			data : {
				entNos: entNos.toString()
			},
			success : function(data, status) {
				// 刷新当前组列表信息
				$('#groupEntTable').datagrid('reload');
				$('#groupEntConfirmWin').window('close');
				entToExit = null;
				$.messager.show({
					title:'提示信息',
					msg:'所选企业出圈成功！',
					timeout:5000,
					showType:'slide'
				});
				// 刷新入圈页面
				self.parent.reloadTabGrid("客户选定","#selectCustomerList");
			},
			error : function(data, status) {
				$.messager.alert('错误信息','企业出圈失败！<br/>'+getJsonErrorMsg(data),'error');
			},
			datatype : "json"
		});
	});
	$('#cancelBtn').click(function(){
		$('#groupEntConfirmWin').window('close');
		entToExit = null;
		
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