<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#busiGroupForm table td input {
	width: 180px;
}
#queryForm table td {
	padding-left:10px;
	font-size: 13px;
	nowrap:nowrap;
	height: 30px;
}
.tx_input {
	text-align: left;
}
.tx_label {
	text-align: right;
	width: 150px;
}
.datagrid-header .datagrid-cell {
  height: auto;
}
.datagrid-header .datagrid-cell span {
  font-size: 12px;
}
.datagrid-toolbar {
  background: white;
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
<div id="toolbar" style="padding:10px;padding-bottom: 20px;">
	<form id="queryForm">
		<table style="width: 100%;" border="0" 
			cellpadding="2" cellspacing="3" align="center">
				<tbody>
					<tr>
						<td class="tx_label">
							<label for="busiGroupCodeC">商圈编号：</label>
						</td>
						<td class="tx_input">
							<input id="busiGroupCodeC" class="easyui-validatebox" data-options="required:false,validType:['busiGroupCode[]','maxLength[1,10]']"/>
						</td>
						<td class="tx_label">
							<label for="busiGroupNameC">商圈名称：</label>
						</td>
						<td class="tx_input">
							<input id="busiGroupNameC" class="easyui-validatebox" data-options="required:false,validType:['busiGroupName[]','maxLength[2,60]']" />
						</td>
						<td colspan="2" style="align:'center';">
							<a id="searchButton" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
							<a id="addButton" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
						</td>
					</tr>
				</tbody>
		</table>
	</form>
</div>
<table id="busiGroupDatagrid"></table>
<!-- 商圈新增修改窗口 -->
<div id="busiGroupDialog" class="easyui-dialog" title="商圈信息" style="width:780px;height:270px;"
	data-options="resizable:true,modal:true,closed:true">
	<form id="busiGroupForm" method="post">
		<table style="padding:20 30 0 50">
			<tbody>
				<tr style="height:20px;"></tr>
				<tr>
					<td class="td_label">
						<label for="busiGroupName"><span class="span_required">*</span>商圈名称:</label>
					</td>
					<td class="td_input">
						<input id="busiGroupName" class="easyui-validatebox"
							data-options="required:true,validType:['maxLength[1, 60]']" />
					</td>
					<td id="busiGroupCode_TD1" class="td_label">
						<label>商圈编号:</label>
					</td>
					<td id="busiGroupCode_TD2" class="td_input">
						<input id="busiGroupCode" class="easyui-validatebox readonly" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="td_label">
						<a id="appointCmBtn" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'">选择核心企业客户经理</a>
					</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td class="td_label">
						<label><span class="span_required">*</span>核心企业客户经理姓名:</label>
					</td>
					<td class="td_input">
						<input id="cmName" class="easyui-validatebox readonly" readonly="readonly" data-options="required:true" />
					</td>
					<td class="td_label">
						<label><span class="span_required">*</span>核心企业客户经理身份证号:</label>
					</td>
					<td class="td_input">
						<input id="cmIdentNo" class="easyui-validatebox readonly" readonly="readonly" data-options="required:true" />
					</td>
				</tr>
				<tr>
					<td class="td_label">
						<label><span class="span_required">*</span>核心企业客户经理C3机构编号:</label>
					</td>
					<td class="td_input">
						<input id="cmC3OrgCode" class="easyui-validatebox readonly" readonly="readonly" data-options="required:true" />
					</td>
					<td class="td_label">
						<label>核心企业客户经理C3机构名称:</label>
					</td>
					<td class="td_input">
						<input id="cmC3OrgName" class="easyui-validatebox readonly" readonly="readonly" />
					</td>
				</tr>
				<tr>
					<td class="td_label">
						<label>核心企业客户经理手机号码:</label>
					</td>
					<td class="td_input">
						<input id="tel" class="easyui-validatebox readonly" readonly="readonly" />
					</td>
					<td class="td_label">
						<label>核心企业客户经理邮箱:</label>
					</td>
					<td class="td_input">
						<input id="email" class="easyui-validatebox readonly" readonly="readonly" />
					</td>
				</tr>
			<tbody>
		</table>
	</form>
</div>
<!-- 选定客户经理 -->
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
	busiGroupCode: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\-]');
			return !p.test(value);
		},
		message: '组织机构代码应为由字母、数字、中横线组成'
	},
	busiGroupName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
			return !p.test(value);
		},
		message: '商圈名称应由数字、字母、中文字符、下划线或括号组成'
	},
	busiGroupNameA: {
		validator: function(value, param){
			// 重复的商圈名称
			return true;
		},
		message: '该商圈名称已被使用'
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

// 查看商圈详情
function view(index){
	$('#busiGroupDatagrid').datagrid('selectRow', index);
	var gridNode = $('#busiGroupDatagrid').datagrid('getSelected');
	self.parent.openTab('查看:'+gridNode.busiGroupName,'${ctx}/base/busiGroup/coreEntDetail/'+gridNode.busiGroupCode);
}

// 管理商圈业务人员
function setBusiGroupManager(index){
	$('#busiGroupDatagrid').datagrid('selectRow', index);
	var gridNode = $('#busiGroupDatagrid').datagrid('getSelected');
	self.parent.openTab('商圈业务人员管理:'+gridNode.busiGroupName,'${ctx}/base/busiGroup/manager/detail/'+gridNode.busiGroupCode);
}

// 修改商圈信息
function edit(index){
	$('#busiGroupDatagrid').datagrid('selectRow', index);
	var gridNode = $('#busiGroupDatagrid').datagrid('getSelected');
	// 打开商圈信息页面
	$('#busiGroupDialog').dialog({
		title: '更新商圈信息',
		closed: false,
		cache: false,
		buttons:[{
			text:'更新',
			handler:function(){
				if(!$('#busiGroupForm').form('validate')){
					return;
				}
				$.messager.progress({
					title: '',
					msg: '正在更新商圈信息，请稍候...',
					text: ''
				});
				$.ajax({
					url:'${ctx}/base/busiGroup/busiGroupList/updateBusiGroup',
					type : 'POST',
					datatype : "json",
					async: true, // 如果为同步模式，则无法显示进度信息
					data : {
						// BusinessGroup
						busiGroupName: $('#busiGroupName').val(),// 商圈名称
						busiGroupCode: $('#busiGroupCode').val(),// 商圈编号
						// CustManager
						name: $('#cmName').val(),	// 客户经理姓名
						identNo: $('#cmIdentNo').val(), //客户经理身份证号码
						c3OrgNo: $('#cmC3OrgCode').val(), //客户经理C3机构编号
						c3OrgName: $('#cmC3OrgName').val(), //客户经理C3机构名称
						tel: $('#tel').val(),	//客户经理手机号码
						email: $('#email').val() //客户经理邮箱
					},
					success : function(data, status) {
						$.messager.progress('close');
						if(showErrorMessage('更新商圈失败！', data)){
							return;
						}
						$.messager.show({
							title: '提示信息',
							msg: '商圈信息更新成功！',
							timeout: 5000,
							showType: 'slide'
						});
						$('#busiGroupDatagrid').datagrid('reload');
						$('#busiGroupDialog').dialog('close');
					},
					error : function(data, status) {
						$.messager.progress('close');
						$.messager.alert('错误信息','创建商圈失败！<br/>'+getJsonErrorMsg(data),'error');
					}
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#busiGroupDialog').dialog('close');
			}
		}]
	});
	// 初始化页面数据
	$('#busiGroupForm').form('clear'); // 情况残余数据
	$('#busiGroupName').val(gridNode.busiGroupName);
	$('#busiGroupCode').val(gridNode.busiGroupCode);
	$('#cmName').val(gridNode.custManagerStaff.name);
	$('#cmIdentNo').val(gridNode.custManagerStaff.identNo);
	$('#cmC3OrgCode').val(gridNode.custManagerStaff.c3OrgNo);
	$('#cmC3OrgName').val(gridNode.custManagerStaff.c3OrgName);
	$('#tel').val(gridNode.custManagerStaff.tel);
	$('#email').val(gridNode.custManagerStaff.email);
	$('#busiGroupForm').form('validate');
	// 显示商圈编号
	$('[id^="busiGroupCode_TD"]').show();
}

// 搜索方法动作
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	$('#busiGroupDatagrid').datagrid('load', {
		busiGroupCode: $.trim($('#busiGroupCodeC').val()),
		busiGroupName: $.trim($('#busiGroupNameC').val())
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
	// 指派核心企业客户经理按钮
	$('#appointCmBtn').click(function(){
		$('#addCustManagerDialog').dialog('open');
	});
	// 查询按钮
	$('#searchButton').click(function(){
		search();
	});
	// 新增商圈
	$('#addButton').click(function(){
		$('#busiGroupDialog').dialog({
			title: '创建新的商圈',
			closed: false,
			cache: false,
			buttons:[{
				text:'保存',
				handler:function(){
					if(!$('#busiGroupForm').form('validate')){
						return;
					}
					$.messager.progress({
						title: '',
						msg: '正在处理商圈信息，请稍候...',
						text: ''
					});
					$.ajax({
						url:'${ctx}/base/busiGroup/busiGroupList/createBusiGroup',
						type : 'POST',
						datatype : "json",
						async: true, // 如果为同步模式，则无法显示进度信息
						data : {
							// BusinessGroup
							busiGroupName: $('#busiGroupName').val(),// 商圈名称
							// CustManager
							name: $('#cmName').val(),	// 客户经理姓名
							identNo: $('#cmIdentNo').val(), //客户经理身份证号码
							c3OrgNo: $('#cmC3OrgCode').val(), //客户经理C3机构编号
							c3OrgName: $('#cmC3OrgName').val(), //客户经理C3机构名称
							tel: $('#tel').val(), 		//客户经理电话
							email: $('#email').val() 	//客户经理邮箱
						},
						success : function(data, status) {
							$.messager.progress('close');
							if(showErrorMessage('创建商圈失败！', data)){
								return;
							}
							$.messager.show({
								title: '提示信息',
								msg: '商圈信息创建成功！',
								timeout: 5000,
								showType: 'slide'
							});
							$('#busiGroupDatagrid').datagrid('reload');
							$('#busiGroupDialog').dialog('close');
						},
						error : function(data, status) {
							$.messager.progress('close');
							$.messager.alert('错误信息','创建商圈失败！<br/>'+getJsonErrorMsg(data),'error');
						}
					});
				}
			},{
				text:'取消',
				handler:function(){
					$('#busiGroupDialog').dialog('close');
				}
			}]
		});
		// 情况残余数据
		$('#busiGroupForm').form('clear');
		// 隐藏商圈编号
		$('[id^="busiGroupCode_TD"]').hide();
	});
	
	$("#busiGroupDatagrid").datagrid({
		title: '商圈维护',
		nowrap: false,
		pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 50],
        pagination: true,
        rownumbers: true,
        singleSelect: true, //单选
        fit: true,
        toolbar: '#toolbar',
        striped: true,
        url: '${ctx}/base/busiGroup/busiGroupList/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','商圈列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'busiGroupCode',title:'商圈编号',align:'center',width:80,rowspan:2,halign:'center'},
			{field:'busiGroupName',title:'商圈名称',align:'center',width:150,rowspan:2,halign:'center'},
			{field:'headEntNo',title:'核心企业<br/>是否已维护',align:'center',width:80,rowspan:2,halign:'center',
				formatter: function(value, row, index){
					if(value==row['busiGroupCode']){
						return '否';
					} else {
						return '是';
					}
				}
			},
			{field:'custManagerStaffName',title:'核心企业客户经理<br/>姓名',align:'center',width:100,rowspan:2,halign:'center',
				formatter: function(value, row, index){
					if(row.custManagerStaff && row.custManagerStaff.name) {
						return row.custManagerStaff.name;
					} else {
						return '';
					}
				}
			},
			{field:'custManagerStaffIdentNo',title:'核心企业客户经理<br/>身份证号',align:'center',width:150,rowspan:2,halign:'center',
				formatter: function(value, row, index){
					if(row.custManagerStaff && row.custManagerStaff.identNo) {
						return row.custManagerStaff.identNo;
					} else {
						return '';
					}
				}
			},
			{field:'custManagerStaffC3OrgName',title:'核心企业客户经理<br/>C3机构',align:'center',width:150,rowspan:2,halign:'center',
				formatter: function(value, row, index){
					if(row.custManagerStaff && row.custManagerStaff.c3OrgNo) {
						return row.custManagerStaff.c3OrgName;
					} else {
						return '';
					}
				}
			},
			{field:'operation',title:'操作',align:'center',width:250,
				formatter: function(value, row, index){
					return '<button onclick="view('+index +')" class="easyui-linkbutton">详情>></button>&nbsp;'
							+ '<button onclick="edit('+index +')" class="easyui-linkbutton">修改</button>&nbsp;'
							+ '<button onclick="setBusiGroupManager('+index +')" class="easyui-linkbutton">管理业务人员</button>';
				}
			}
			]]
	});
	
	$('#addCustManagerDialog').dialog({
		title: '指派核心企业客户经理',
		closed: true,
		cache: true,
		href: '${ctx}/loan/preloan/instuserinfo',
		modal: true,
		fit: true,
		buttons:[{
			text:'指派为核心企业客户经理',
			handler:function(){
				// 获取弹出页面数据
				var dataNode = $('#roleTable').datagrid('getSelected');
				if(isNull(dataNode) || isNull(dataNode.certno)){
					$.messager.show({
						title: '提示信息',
						msg: '请选择核心企业客户经理信息！',
						timeout: 5000,
						showType: 'slide'
					});
					return;
				}
				// 数据写入页面
				$('#cmName').val(dataNode.username);
				$('#cmIdentNo').val(dataNode.certno);
				$('#cmC3OrgCode').val(dataNode.userinstcode);
				$('#cmC3OrgName').val(dataNode.userinstname);
				$('#tel').val(dataNode.userormobile);
				$('#email').val(dataNode.useroreaddr);
				$('#addCustManagerDialog').dialog('close');
				$('#busiGroupForm').form('validate');
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