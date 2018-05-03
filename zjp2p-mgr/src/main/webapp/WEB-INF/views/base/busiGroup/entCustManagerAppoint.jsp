<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#queryForm td.my_td_label{
	padding-left:10px;
	width: 120px;
	height: 30px;
	text-align: right;
	font-size: 13px;
	nowrap:nowrap;
}
#queryForm td.td_text{
	padding-left:5px;
	width: 200px;
	height: 30px;
	text-align: left;
	font-size: 13px;
	nowrap:nowrap;
}
.my_td_labelA {
	text-align: right;
	width: 50%;
}
.my_td_labelB {
	text-align: center;
	width: 50%;
}
.datagrid-toolbar {
  background: white;
}
</style>
</head>
<body>
	<div id="toolbar" style="padding:10px;padding-bottom: 20px;">
		<form id="queryForm">
			<table style="width:100%;" border="0" 
				cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="my_td_label">
							<label>客户经理指派状态：</label>
						</td>
						<td class="td_text">
							<input id="appointFlag" style="width:180px;">
						</td>
						<td class="my_td_label">
							<label>贷前客户经理名称：</label>
						</td>
						<td class="td_text">
							<input id="erpCmName" style="width:180px;" class="easyui-validatebox" data-options="required:false,validType:['cmName[]','maxLength[2,60]']" />
						</td>
						<td class="my_td_label">
							<label>贷后客户经理名称：</label>
						</td>
						<td class="td_text">
							<input id="postLoanCmName" style="width:180px;" class="easyui-validatebox" data-options="required:false,validType:['cmName[]','maxLength[2,60]']" />
						</td>
					</tr>
					<tr>
						<td class="my_td_label">
							<label>商圈名称或编号：</label>
						</td>
						<td class="td_text">
							<input id="busiGroupName" style="width:180px;" class="easyui-validatebox" data-options="required:false,validType:['busiGroupName[]','maxLength[2,60]']" />
						</td>
						<td class="my_td_label">
							<label>客户名称：</label>
						</td>
						<td class="td_text">
							<input id="entName" style="width:180px;" class="easyui-validatebox" data-options="required:false,validType:['entName[]','maxLength[2,60]']" />
						</td>
						<td class="my_td_label">
							<a id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<table id="entCustManagerDatagrid"></table>
	<div id="addCustManagerDialog"></div>
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
	},
	busiGroupName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_ ]');
			return !p.test(value);
		},
		message: '商圈名称或编号应由数字、字母、中文字符、下划线或括号组成'
	},
	cmName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5 ]');
			return !p.test(value);
		},
		message: '客户经理名称或编号应由数字、字母、中文字符组成'
	}
});
// 刷新当前页
function reloadEntCustData(){
	$('#entCustManagerDatagrid').datagrid('reload');
}
// 指派ERP客户经理
function appointERPCustManager(index){
	$('#entCustManagerDatagrid').datagrid('selectRow', index); //选中当前记录
	var gridNode = $('#entCustManagerDatagrid').datagrid('getSelected');
	if(isNull(gridNode) || isNull(gridNode.entNo)){
		return;
	}
	$('#addCustManagerDialog').dialog({
		title: '指派贷前客户经理',
		width: 900,
		height: 500,
		closed: false,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为贷前客户经理',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请先选择贷前客户经理信息！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				$.messager.progress({
					title: '',
					msg: '正在指派贷前客户经理信息，请稍候...',
					text: ''
				}); 
				// 保存数据
				$.ajax({
					type : 'POST',
					url:'${ctx}/base/busiGroup/entCustManagerAppoint/createERPCustManager',    
					data:{
						identNo: dataNode.certno,
						name: dataNode.username,
						c3OrgNo: dataNode.userinstcode,
						c3OrgName: dataNode.userinstname,
						tel: dataNode.userormobile,
						email: dataNode.useroreaddr,
						entNo: gridNode.entNo
					},
					success:function(data, status){
						$.messager.progress('close');
						reloadEntCustData();// 保存成功，刷新当前页面
						$('#addCustManagerDialog').dialog('close');
						$.messager.show({
							title: '消息',
							msg: '贷前客户经理指派成功！',
							timeout: 5000,
							showType: 'slide'
						});
					},
					error : function(data, status) {
						$.messager.progress('close');
						$.messager.alert('错误信息','指派贷前客户经理失败！<br/>'+getJsonErrorMsg(data),'error');
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
}
//指派贷后客户经理
function appointPostLoanCustManager(index){
	$('#entCustManagerDatagrid').datagrid('selectRow', index); //选中当前记录
	var gridNode = $('#entCustManagerDatagrid').datagrid('getSelected');
	if(isNull(gridNode) || isNull(gridNode.entNo)){
		return;
	}
	$('#addCustManagerDialog').dialog({
		title: '指派贷后客户经理',
		width: 900,
		height: 500,
		closed: false,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为贷后客户经理',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请先选择贷后客户经理信息！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				$.messager.progress({
					title: '',
					msg: '正在指派贷后客户经理信息，请稍候...',
					text: ''
				}); 
				// 保存数据
				$.ajax({
					type : 'POST',
					url:'${ctx}/base/busiGroup/entCustManagerAppoint/createPostLoanCustManager',    
					data:{
						identNo: dataNode.certno,
						name: dataNode.username,
						c3OrgNo: dataNode.userinstcode,
						c3OrgName: dataNode.userinstname,
						tel: dataNode.userormobile,
						email: dataNode.useroreaddr,
						entNo: gridNode.entNo
					},
					success:function(data, status){
						$.messager.progress('close');
						reloadEntCustData();// 保存成功，刷新当前页面
						$('#addCustManagerDialog').dialog('close');
						$.messager.show({
							title: '消息',
							msg: '贷后客户经理指派成功！',
							timeout: 5000,
							showType: 'slide'
						});
					},
					error : function(data, status) {
						$.messager.progress('close');
						$.messager.alert('错误信息','指派贷后客户经理失败！<br/>'+getJsonErrorMsg(data),'error');
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
}

// 搜索方法
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	var appointFlagA = '';
	var appointFlagB = '';
	var appointFlag = $('#appointFlag').combobox('getValue');
	if(isNull(appointFlag)){
	}if(appointFlag=='0'){
		appointFlagA = appointFlag;
	} else if(appointFlag=='1'){
		appointFlagB = appointFlag;
	}
	$('#entCustManagerDatagrid').datagrid('load', {
		        	busiGroupName: $.trim($('#busiGroupName').val()),
		        	entName: $.trim($('#entName').val()),
		        	appointFlagA: appointFlagA,
		        	appointFlagB: appointFlagB,
		        	erpCmName: $.trim($('#erpCmName').val()),
		        	postLoanCmName: $.trim($('#postLoanCmName').val())
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

$(document).ready(function(){
	$('#appointFlag').combobox({
		editable: false,
		data: [{id: "", text: "全部"},
		      {id: "0", text: "未指派"},
		      {id: "1", text: "已指派"}],
		valueField: 'id',
		textField: 'text',
		required: false,
		multiple: false,
		panelHeight: 'auto',
		onSelect: function(record){
			/*
			if(record.id=='0'){
				$('#erpCmName').val('');
				$('#erpCmName').attr("disabled", "disabled");
				$('#postLoanCmName').val('');
				$('#postLoanCmName').attr("disabled", "disabled");
			} else {
				$('#erpCmName').removeAttr("disabled");
				$('#postLoanCmName').removeAttr("disabled");
			}
			*/
		}
	});
	$('#searchBtn').click(function(){
		search();
	});
	
	$("#entCustManagerDatagrid").datagrid({
		title: '指派ERP企业客户经理',
		striped: true,
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50],
        pagination: true,
        rownumbers: true,
        singleSelect: true, //单选
        border: true,
        fit: true,
        toolbar: '#toolbar',
        url: '${ctx}/base/busiGroup/entCustManagerAppoint/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		nowrap: false,
		onLoadError: function(data){
			$.messager.alert('错误信息','企业列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'entNo',title:'企业编号',width:150,align:'center', hidden:true},
			{field:'orgCode',title:'组织机构代码',width:145,align:'center'},
			// {field:'busiLicense',title:'营业执照号码',width:130,align:'center'},
			{field:'entName',title:'客户名称',width:180,align:'center'},
			{field:'busiGroupCode',title:'所属商圈编号',width:150,align:'center'},
			{field:'busiGroupName',title:'所属商圈名称',width:180,align:'center'},
			{field:'erpCmName',title:'贷前客户经理',width:180,align:'center',
				formatter: function(value,row,index){
					if(isNull(value)){
						value = '';
					}
					return '<table style="width: 180px;height:100%" ><tr><td style="border:none;" class="my_td_labelA">'+value+'</td><td style="border:none;" class="my_td_labelB"><button onclick="appointERPCustManager('+index +')" class="easyui-linkbutton">指派</button></td></tr></table>';
				}
			},
			{field:'postLoanCmName',title:'贷后客户经理',width:180,align:'center',
				formatter: function(value,row,index){
					if(isNull(value)){
						value = '';
					}
					return '<table style="width: 180px;height:100%" ><tr><td style="border:none;" class="my_td_labelA">'+value+'</td><td style="border:none;" class="my_td_labelB"><button onclick="appointPostLoanCustManager('+index +')" class="easyui-linkbutton">指派</button></td></tr></table>';
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