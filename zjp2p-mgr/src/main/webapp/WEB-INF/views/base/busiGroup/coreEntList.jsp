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
							<label for="busiGroupCode">商圈编号：</label>
						</td>
						<td class="tx_input">
							<input id="busiGroupCode" class="easyui-validatebox" data-options="required:false,validType:['busiGroupCode[]','maxLength[1,10]']"/>
						</td>
						<td class="tx_label">
							<label for="busiGroupName">商圈名称：</label>
						</td>
						<td class="tx_input">
							<input id="busiGroupName" class="easyui-validatebox" data-options="required:false,validType:['busiGroupName[]','maxLength[2,60]']" />
						</td>
						<td colspan="2" style="align:'center';">
							<a id="searchButton" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>&nbsp;&nbsp;
							<!-- 
							<a id="addButton" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
							 -->
						</td>
					</tr>
				</tbody>
		</table>
	</form>
</div>
<table id="coreEntDatagrid"></table>
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
	}
});
// 查看商圈详情
function view(index){
	$('#coreEntDatagrid').datagrid('selectRow', index);
	var gridNode = $('#coreEntDatagrid').datagrid('getSelected');
	self.parent.openTab('查看:'+gridNode.busiGroupName,'${ctx}/base/busiGroup/coreEntDetail/'+gridNode.busiGroupCode);
}
// 修改商圈信息
function edit(index){
	$('#coreEntDatagrid').datagrid('selectRow', index);
	var gridNode = $('#coreEntDatagrid').datagrid('getSelected');
	self.parent.openTab('修改:'+gridNode.busiGroupName, '${ctx}/base/busiGroup/coreEntEdit/'+gridNode.busiGroupCode);
}
// 调整商圈额度
function editLc(index){
	$('#coreEntDatagrid').datagrid('selectRow', index);
	var gridNode = $('#coreEntDatagrid').datagrid('getSelected');
	self.parent.openTab('调整商圈额度:'+gridNode.busiGroupName, '${ctx}/base/busiGroup/busiGroupEditLc/'+gridNode.busiGroupCode);
}

// 刷新当前页
function reloadData(){
	$('#coreEntDatagrid').datagrid('reload');
}

// "yyyyMMdd" -> "yyyy-MM-dd"
function dateTransferFormatter(value,row,index){
	if(isNull(value) || value.length!=8){
		return value;
	} else {
		return value.substring(0, 4) + '-' + value.substring(4,6) + '-' + value.substring(6,8);
	}
}

function formatNum(value){
	value = (value==null ? 0 : value);
	return $('<input />').numberbox({
		value: value,
		min:0,
		precision:0,
		decimalSeparator: '.',
		groupSeparator: ','
	}).get(0).value;
}

// 搜索方法动作
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	$('#coreEntDatagrid').datagrid('load', {
		busiGroupCode: $.trim($('#busiGroupCode').val()),
		busiGroupName: $.trim($('#busiGroupName').val())
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
	$('#searchButton').click(function(){
		search();
	});
	
	/*
	$('#addButton').click(function(){
		self.parent.openTab('新增:核心企业商圈', '${ctx}/base/busiGroup/coreEntAdd');
	});
	*/
	
	$("#coreEntDatagrid").datagrid({
		title: '核心企业（商圈）维护',
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
        url: '${ctx}/base/busiGroup/coreEntList/loadData',
		method: 'post',
		loadMsg: '加载数据，请稍候...',
		onLoadError: function(data){
			$.messager.alert('错误信息','商圈列表信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		},
        columns:[[
			{field:'busiGroupCode',title:'商圈编号',align:'center',width:100,rowspan:2,halign:'center'},
			{field:'busiGroupName',title:'商圈名称',align:'center',width:200,rowspan:2,halign:'center'},
			{field:'headEntNo',title:'核心企业<br/>是否已维护',align:'center',width:100,rowspan:2,halign:'center',
				formatter: function(value, row, index){
					if(value==row['busiGroupCode']){
						return '否';
					} else {
						return '是';
					}
				}
			},
			{field:'coreEntName',title:'核心企业名称',align:'center',width:200,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					if(row['headEntNo']==row['busiGroupCode']){
						return '';
					} else {
						return value;
					}
				}
			},
			{field:'coreEntOrgCode',title:'核心企业名称<br/>组织机构代码',align:'center',width:120,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					if(row['headEntNo']==row['busiGroupCode']){
						return '';
					} else {
						return value;
					}
				}
			},
			{field:'coreEntCorpName',title:'核心企业名称<br/>法人代表姓名',align:'center',width:100,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					if(row['headEntNo']==row['busiGroupCode']){
						return '';
					} else {
						return value;
					}
				}
			},
			/*
			{field:'totalLcAmt',title:'商圈总授信额度',align:'right',width:120,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					return formatNum(value);
				}
			},
			{field:'upLcAmt',title:'上游授信额度<br/>（万元）',align:'right',width:120,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					return formatNum(value);
				}
			},
			{field:'downLcAmt',title:'下游授信额度<br/>（万元）',align:'right',width:120,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					return formatNum(value);
				}	
			},
			{field:'upLcValiddate',title:'商圈授信到期日',align:'center',width:100,rowspan:2,halign:'center',
				formatter: function(value,row,index){
					return dateTransferFormatter(value,row,index);
				}
			},
			*/
			{field:'operation',title:'操作',align:'center',width:160,
				formatter: function(value,row,index){
					return '<button onclick="view('+index +')" class="easyui-linkbutton">详情>></button>&nbsp;'
							//+ '<button onclick="editLc('+index +')" class="easyui-linkbutton">调整额度</button>&nbsp;'
							+ '<button onclick="edit('+index +')" class="easyui-linkbutton">修改</button>';
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