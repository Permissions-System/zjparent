<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input,select{
	width:180px;
}  
#editResource tr{
	height:40px;
}
#editResource td label
{
	text-align:right;
	padding-left:60px;	
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',title:'查询条件'" style="height:80px;padding:10px 0 10px 10px;" >
			<form id="queryForm">
				<table style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
				<tr class="queryStyle">
					<td><label for="qyChannelCodeLabel">归属渠道:</label></td>
	                <td>
		                <select id="qyChannelCode" class="easyui-combobox" name="channelCode" panelHeight="auto" style="width:160px;" data-options="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${channelCodes}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	                <td><label for="qyProductCode">归属产品:</label></td>
	                <td>
		                <select id="qyProductCode" class="easyui-combobox" name="productCode" panelHeight="auto" style="width:160px;" data-options="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${productCodes}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	                <td><label for="qyResourceNameLabelLabel">资源名称:</label></td>
	                <td><input id="qyResourceName" name="name" class="easyui-validatebox" style="width:160px;" data-options="validType:['nameValid','length[0,20]']"></td>
	                <td><label for="qyResourceValueLabel">资源URL:</label></td>
	               	<td><input id="qyResourceValue" name="value" class="easyui-validatebox" style="width:160px;" data-options="validType:['urlValid','length[0,60]']"></td>
	               	<td>
	                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="searchBtn" >查询</a>
	                    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="resetBtn">重置</a>
                    </td>
	            </tr>
			</table>
		</form>
    </div>
    <div data-options="region:'center'">
        <table id="listResource"></table>
    </div>
</div>
<div  id="resourceGroup">
	<div id="webGroupTableToolbar">
		<a id="saveBtn" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">保存</a>&nbsp;&nbsp;&nbsp;
		<a id="resetBtn2" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true">重置</a>&nbsp;&nbsp;&nbsp;
		<a id="closeBtn" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">关闭</a>
	</div>
    <table id="listGroup"></table>
</div>
<div id="editResource">
<form>
<table>
	<tr style="display:none">
		<td><label>id:</label></td>
		<td><input class="easyui-validatebox" type="text" id="id"/></td>
	</tr>
	<tr>
		<td><label>归属渠道:</label></td>
		<td>
		<select id="channelCode" name="channelCode" class="easyui-combobox" panelHeight="auto" data-options="required:true,editable:false">
   			<c:forEach items="${channelCodes}" var="item">
   				<option value="${item.configCode}">${item.configName}</option>
   			</c:forEach>
   		</select>	
		</td>
	</tr>
	<tr>
		<td><label>归属产品:</label></td>
		<td>
		<select id="productCode" name="productCode" class="easyui-combobox" panelHeight="auto" data-options="required:true,editable:false">
   			<c:forEach items="${productCodes}" var="item">
   				<option value="${item.configCode}">${item.configName}</option>
   			</c:forEach>
   		</select>	
		</td>
	</tr>
	<tr>
		<td><label>资源名称:</label></td>
		<td><input class="easyui-validatebox" type="text" id="name" data-options="required:true,validType:['nameValid','length[4,20]']"/></td>
	</tr>
	<tr>
		<td><label>资源类型:</label></td>
		<td>
		<select id="type" name="type" class="easyui-combobox" panelHeight="auto" data-options="required:true,editable:false">
   			<c:forEach items="${resourceTypes}" var="type">
   				<option value="${type.configCode}">${type.configName}</option>
   			</c:forEach>
   		</select>	
		</td>
	</tr>
	<tr>
		<td><label>资源url:</label></td>
		<td><input class="easyui-validatebox" type="text" id="value" data-options="validType:['urlValid','length[0,60]']"/></td>
	</tr>
	<tr>
		<td><label>访问允许:</label></td>
		<td><input class="easyui-validatebox" type="text" id="permission" data-options="validType:['permissionValid']"/></td>
	</tr>
	<tr>
		<td><label>顺序值:</label></td>
		<td><input class="easyui-numberspinner" missingMessage="该输入项为必输项" type="text" id="sort" data-options="required:true,min:1,validType:'numberValid'"/></td>
	</tr>
	<tr>
		<td><label>图标cls:</label></td>
		<td><input class="easyui-validatebox" type="text" id="icon" data-options="validType:'length[0,30]'"/></td>
	</tr>
	<tr>
		<td><label>所属父类:</label></td>
		<td>
			<select id="parentId" class="easyui-combobox" panelHeight="auto" data-options="editable:false">
				<c:forEach items="${resources}" var="resource">
					<option value="${resource.id}">${resource.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td><label>备注:</label></td>
		<td><input class="easyui-validatebox" type="text" id="remark" name="remark" data-options="validType:'length[0,50]'"/></td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
var allGroup = null; // 所有组信息
var stateList = null; //资源或组状态
var currentGroupResources = null; // 当前资源所属组

//解析Ajax请求失败的json错误信息
function getJsonErrorMsg(data){
	var errorMsg = '';
	if(data && data.responseText){
		errorMsg = (eval('('+data.responseText+')')).string;
	}
	return errorMsg;
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

$('#listResource').datagrid({    
	url:'${ctx}/base/webResource/getResourceList',  
	title:'资源管理',
	fit:true,
	rownumbers:true,
	fitColumns:true,
	singleSelect:true,
	checkOnSelect:false,
	pagination:true,
	columns:[[    
		{field:'channelCode',title:'归属渠道',width:140,
			formatter : function(value,row,index){
				var type = $('#channelCode').combobox('getData');
		    	for(var i in type){
		    		if(value == type[i].value)
		    			return type[i].text;
		    	}
		    }
		 },
		 {field:'productCode',title:'归属产品',width:80,align:'center',
		 	formatter : function(value,row,index){
		 		var type = $('#productCode').combobox('getData');
		     	for(var i in type){
		     		if(value == type[i].value)
		     			return type[i].text;
		     	}
		     }
		  },
         {field:'name',title:'资源名称',width:180},
         {field:'value',title:'资源URL',width:300}, 
         {field:'permission',title:'访问允许permission',width:250},
         {field:'type',title:'资源类型',width:80,align:'center',
        	formatter : function(value,row,index){
        		var type = $('#type').combobox('getData');
	        	for(var i in type){
	        		if(value == type[i].value)
	        			return type[i].text;
	        	}
	        }
         },
         {field:'parent',title:'所属父类',width:100,
        	formatter : function(value,row,index){
	        		if(value!= null)
	        			return value.name;
	        		
	        }
         },
         {field:'remark',title:'备注',width:150,hidden:true},
         {field:'opt',title:'操作',align:'right',halign:'center',
       		formatter:function(value, row, index) {
   				var opt='';
				opt += '<button onclick="saveOrUpdate('+index +')" class="easyui-linkbutton">修改</button>';
				opt += '<button onclick="getGroup('+index +')" class="easyui-linkbutton">查看所属组</button>';
				return opt;
    		} 
         }
    ]],
    toolbar: [{
    	text:'刷新',
		iconCls: 'icon-reload',
		handler:function(){$('#listResource').datagrid('reload');}
	},{
    	text:'增加',
		iconCls: 'icon-add',
		handler:function(){saveOrUpdate(-1);}
	},{
		text:'删除',
		iconCls: 'icon-remove',
		handler: function(){
			var node = $('#listResource').datagrid('getSelected');
			if(node){
				$.ajax({
					type:'POST',
					url:'${ctx}/base/webResource/delete',
					data:{
						id:node.id
					},
					success:function(data, status){
						if(data.status=="SUCCESS"){
							$.messager.show({
								title:'消息',
								msg:'删除成功！',
								timeout:5000,
								showType:'slide'
							});
							$('#listResource').datagrid('reload');
						} else {
							$.messager.alert('错误',data.result,'error');
						}
					}
				});
			}else{
				$.messager.alert('提示','请选择一条记录！','info');
			}
		}
	}]

});

function saveOrUpdate(rowId){
	var title;
	if(rowId >= 0){
		title='编辑资源';
	} else{
		title ='新增资源';
	}
	$('#editResource').dialog({
		title:title,
		width: 400,    
		height: 480,    
		modal: true,
		onBeforeClose:function(){
			$('#editResource').form('clear');
		},
		buttons:[{
			text:'保存',
			handler:submitData
		},{
			text:'取消',
			handler:function(){
				$('#editResource').dialog('close');
			}
		}]
	});
	
	if(rowId >= 0){
		$('#listResource').datagrid('selectRow', rowId);
		var node = $('#listResource').datagrid('getSelected');
		$('#id').val(node.id);
		$('#channelCode').combobox('setValue',node.channelCode);
		$('#productCode').combobox('setValue',node.productCode);
		$('#name').val(node.name);
		$('#type').combobox('setValue',node.type);
		$('#value').val(node.value);
		$('#permission').val(node.permission);
		$('#sort').numberspinner('setValue', node.sort);  
		$('#icon').val(node.icon);
		$('#parentId').combobox('setValue',node.parentId);
		$('#remark').val(node.remark);
		$('#editResource').form('validate');
	} else {
		$('#type').combobox('setValue','01');
	}
}

function submitData(){
	if(!$('#editResource').form('validate'))
		return;
	if($('#id').val()!=""&&$('#id').val()==$('#parentId').combobox('getValue')){
		$.messager.alert('出错啦！','所属父类不能为自己！','error');
		return;
	}
		
	$.ajax({
		type:'POST',
		url:'${ctx}/base/webResource/submit',
		data:{
			id:$('#id').val(),
			channelCode:$('#channelCode').combobox('getValue'),
			productCode:$('#productCode').combobox('getValue'),
			name:$('#name').val(),
			type:$('#type').combobox('getValue'),
			value:$('#value').val(),
			permission:$('#permission').val(),
			sort:$('#sort').val(),
			icon:$('#icon').val(),
			parentId:$('#parentId').combobox('getValue'),
			remark:$('#remark').val()
		},
		success: function(data, status){
			if(data.status=="SUCCESS"){
				$.messager.show({
					title:'消息',
					msg:'提交成功！',
					timeout:5000,
					showType:'slide'
				});
				$('#editResource').dialog('close');
				$('#listResource').datagrid('reload');
			} else {
				$.messager.alert('错误',data.result,'error');
			}
		}
	});
}

$.extend($.fn.validatebox.defaults.rules, {    
	permissionValid: {        
		validator: function(value){            
			var reg = /^perms\[\w*:\w*\]$|^authc$|^anon$/;
			return reg.test(value);
		},        
		message: '请按正确的格式输入！'    
	},
	numberValid:{
		validator: function(value, param){
			var p = new RegExp('^[0-9]{0,8}$');
			return p.test(value);
		},
		message: '请输入正确的顺序值！'
	},
	urlValid:{
		validator: function(value){
			var reg =  new RegExp('[^a-zA-Z0-9/]');
			return !reg.test(value);
		},
		message:'请输入正确的url'
	},
	nameValid: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）:]');
			return !p.test(value);
		},
		message: '名称应由数字、字母、中文字符、下划线或冒号组成'
	}
});

// 绑定按钮方法
$('#searchBtn').click(function(){
	search();
});

$('#resetBtn').click(function(){
	$('#qyChannelCode').combobox('setValue', '');
	$('#qyProductCode').combobox('setValue', '');
	$('#qyResourceName').val('');
	$('#qyResourceValue').val('');
});

//查询
function search(){
	if(!$('#queryForm').form('validate')){
		return;
	}
	channelCodeValue = $('#qyChannelCode').combobox('getValue');
	productCodeValue = $('#qyProductCode').combobox('getValue');
	// 查询数据
	$('#listResource').datagrid('load', {
			channelCode: channelCodeValue,
			productCode: productCodeValue,
			name: $.trim($('#qyResourceName').val()),
    		value: $.trim($('#qyResourceValue').val())
    });
}

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

function getGroup(rowId){
	$('#resourceGroup').dialog({ 
		title : '查看资源所属组信息',
		width:800,
		height:400,
		modal: true
	});

	$('#listResource').datagrid('selectRow', rowId);
	var node = $('#listResource').datagrid('getSelected');
	$('#listGroup').datagrid({
		url:'${ctx}/base/webResource/getGroup',
		queryParams: {
			id:node.id
		},
		rownumbers: true,
		fitColumns: true,
		singleSelect: false,
        checkOnSelect: true,
        selectOnCheck: true,
		columns:[[        
			{field:'checked',checkbox: true,align:'center'},
			{field:'id',title:'组代码',width:250,align:'center'},
			{field:'name',title:'组名称',width:150,align:'center'},
			{field:'state',title:'状态',width:200,align:'center',
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
			},
			{field:'type',title:'组类型',width:100,align:'center',
				formatter: function(value,row,index){
					var comboboxData = $('#listResource').datagrid('getData').typeCodes;
					if(comboboxData && comboboxData.length>0){
						for(var i in comboboxData){
							if(comboboxData[i].configCode==value){
								return comboboxData[i].configName;
							}
						}
					}
					return value;
				}
			}
	    ]],
	    onClickCell: function(index,field,value){
			if(field != 'state'){
				return;
			}
	 		$('#listGroup').datagrid('beginEdit', index);
	 		var ed = $('#listGroup').datagrid('getEditor', {index:index,field: 'state'});
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
		 		$('#listGroup').datagrid('beginEdit', index);
			 	var ed = $('#listGroup').datagrid('getEditor', {index:index,field: 'state'});
		 		$(ed.target).combobox('setValue','1');
		 	}
	     },
	     onUncheck: function(index,row){
	    	 $('#listGroup').datagrid('beginEdit', index);
	    	 var ed = $('#listGroup').datagrid('getEditor', {index:index,field: 'state'});
			 $(ed.target).combobox('setValue','');
			 $('#listGroup').datagrid('endEdit', index);
		 },
		 onLoadSuccess: function(data){
			 currentGroupResources=data;
			 var rowData = data.rows;
			 $.each(rowData,function(idx,val){
				 if(val.checked=="true"){
					 $('#listGroup').datagrid('checkRow', idx);
				 }
			 });
		 },
		 onLoadError: function(data){
			$.messager.show({
				title: '错误',
				msg: '所属组加载失败',
				timeout: 5000,
				showType: 'slide'
			}); 
		 }
	});
	//隐藏表头的checkbox
	$('.datagrid-header-check input').hide();
};
//绑定按钮方法
$('#saveBtn').click(function(){
	$('#listGroup').datagrid('acceptChanges');
	var node = $('#listResource').datagrid('getSelected');
	var ids = new Array();
	var nodes = $('#listGroup').datagrid('getSelections');
	if(nodes && nodes.length>0){
		for(var i in nodes){
			ids.push(nodes[i].id+"|"+nodes[i].state);
		}
	}
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/webResource/updateGroupResource',
		data : {
			resNo: node.id,
			groupIds: ids.toString()
		},
		success : function(data, status) {
			if(!data.status || data.status!='FAIL'){
				// 提示成功信息
				$.messager.show({
					title:'提示信息',
					msg:'资源组更新成功！',
					timeout:5000,
					showType:'slide'
				});
				$('#resourceGroup').dialog('close');
			} else {
				showValidateMessage(data.result);
			}
		},
		error : function(data, status) {
			$.messager.alert('错误信息','资源组更新失败！<br/>'+getJsonErrorMsg(data),'error');
		},
		datatype : "json"
	});
});

$('#resetBtn2').click(function(){
	$('#listGroup').datagrid('loadData', currentGroupResources);
});
$('#closeBtn').click(function(){
	$('#resourceGroup').dialog('close');
});

$(document).ready(function() {
	// 加载初始化数据
	getStateData();
    
});
</script>
</body>
</html>