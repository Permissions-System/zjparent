<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input,select{
	width:180px;
}
#paramDlg tr{
	height:50px;
}
#paramDlg td label {
	text-align:right;
	padding-left:60px;	
}
.button{
	width:50px;
}
.itemMagin{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<!-- begin 查询刷选条件 -->
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post">
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label>参数中文名称:</label></td>
                    <td><input id="qryCnName" name="paramCnName" class="easyui-validatebox" style="width:155px;"></td>
                    <td><label>产品名称:</label></td>
                    <td>
                        <select id="qryProductCode" panelHeight="auto" name="productCode" class="easyui-combobox" style="width:155px;" data-option="required:false,editable:false">     
                            <option value="">全部</option>
                            <c:forEach items="${productCode}" var="item">
   								<option value="${item.configCode}">${item.configName}</option>
   							</c:forEach>
                        </select>
                    </td>
                    <td><label>参数英文名称:</label></td>
                    <td><input id="qryEnName" name="paramEnName" style="width:160px;" class="easyui-validatebox"></td>
                </tr>
                <tr class="itemMagin">
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="paramInfo">
        </table>
    </div>
</div>
<!-- end 查询刷选条件 -->

<!-- 新增修改页面 -->
<div id="paramDlg" class="easyui-dialog" style="width:400px;height:400px;padding:
10px 0px 10px 0px"
    data-options="resizable:false,modal:true" closed="true" buttons="#param-dlg-buttons">
	<form id="paramForm" method="post">
		<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
            <tbody>
				<tr>
					<td><label>产品名称:</label></td>
					<td>
						<select id="productCode" name="productCode" panelHeight="auto" style="width:200px;" class="easyui-combobox" data-options="required:true,editable:false">
							<c:forEach items="${productCode}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
				  			</select>	
				  		</td>
				</tr>
				<tr>
					<td><label>是否可编辑:</label></td>
					<td>
						<select id="readFlag" name="readFlag" panelHeight="auto" style="width:200px;" class="easyui-combobox" data-options="required:true,editable:false">
							<c:forEach items="${readFlags}" var="readFlag">
								<option value="${readFlag.configCode}">${readFlag.configName}</option>
							</c:forEach>
				   		</select>	
					</td>
				</tr>
				<tr>
					<td><label>参数中文名称:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="paramCnName" name="paramCnName" data-options="required:true,validType:['cnNameValid','length[0,20]']"/></td>
				</tr>
				<tr>
					<td><label>参数英文名称:</label></td>
					<td><input class="easyui-validatebox" type="text"  style="width:200px;" id="paramEnName" name="paramEnName" data-options="required:true,validType:['enNameValid','length[0,32]']"/></td>
				</tr>
				<tr>
					<td><label>参数值:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="paramValue" name="paramValue" data-options="required:true,validType:['length[0,200]']"/></td>
				</tr>
				<tr>
					<td><label>描述:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="description" name="description" data-options="validType:['cnNameValid','length[0,50]']"/></td>
				</tr>
				</tbody>
		</table>
	</form>
</div>
<div id="param-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="saveInfo" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#paramDlg').dialog('close')">关闭</a>
</div>
<div id="toolbar">
	<a href="#" id="addParamLink" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
	<a href="#" id="removeParamLink" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	<a href="#" id="removeParamLink" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
</div>
<script type="text/javascript">
var isOpenFlag = "0";

$(document).ready(function(){
    // 查询
    $("#btnQuery").bind("click", function(){
    	search();
    });
    
    // 清理查询内容
    $("#btnCancel").bind("click", function(){
        queryCancel();
    });

	$("#qryProductCode").combobox({
        editable:false
    });
	

    $("#readFlag").combobox({
        editable:false
    });
	
    $("#saveInfo").bind("click", function(){
        saveParamInfo();
    });
	
    // 类型Dialog弹出框关闭处理
    $('#paramDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
	// 初始化
	initParamInfoGrid();
	
	/**
	if(!${superVisor}){
		$('#removeParamLink').linkbutton('disable');
	}else{
		$('#removeParamLink').click(function(){
			removeParamInfo();
		});
	}
	**/
	requiredBox();
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#saveInfo");
    // 查询按钮
    var btnQuery = $("#btnQuery");
    // 点击 Enter按钮
    if(event.keyCode == 13 && isOpenFlag =="1"){
        btnOjb.click();
        event.returnValue = false;
    }
    
    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag =="0"){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}


/*必输项*/
function requiredBox(){
	// validType:['cnNameValid','length[0,20]'] 参数中文名称
    $('#paramCnName').validatebox({
        validType:['cnNameValid','length[1,32]']
    });
    
    // validType:['enNameValid','length[0,32] 参数英文名称
    $('#paramEnName').validatebox({
        validType:['enNameValid','length[1,32]']
    });
    
    // validType:['length[0,200]'] 参数值
    $('#paramValue').validatebox({
        validType:['length[0,200]']
    });
    
    // validType:['cnNameValid','length[0,50]'] description
    $('#description').validatebox({
    	validType:['cnNameValid','length[0,50]']
    });
}

// 初始化页面Grid
function initParamInfoGrid(){
	$('#paramInfo').datagrid({
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20],
	    nowrap: false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        loadMsg: '加载数据，请稍候...',
	    url:'${ctx}/base/param/getParamList',  
	    title:'参数管理列表',
	    columns:[[    
	         {field:'productName',title:'产品名称',width:$(this).width() * 0.1,align:'center',halign:'center'},
	         {field:'readFlagName',title:'是否可编辑',width:$(this).width() * 0.1,align:'center',halign:'center'}, 
	         {field:'paramCnName',title:'参数中文名称',width:$(this).width() * 0.2,align:'left',halign:'center'},
	         {field:'paramEnName',title:'参数英文名称',width:$(this).width() * 0.2,align:'left',halign:'center'},
	         {field:'paramValue',title:'参数值',width:$(this).width() * 0.2,align:'left',halign:'center'},
	         {field:'description',title:'描述',width:$(this).width() * 0.2,align:'left',halign:'center'}
	    ]],
	    onDblClickRow:function(rowIndex, rowData){
	        updateParamInfo();
	    },
	    //toolbar: '#toolbar',
	    onLoadSuccess: function(data){
			if(data.total==0){
				showSlideMessage("没有记录。");
			}
	    },
	    onLoadError: function(){
	        $.messager.alert('错误信息','信息查询失败!','error');
	    },
	    toolbar:[{
            text:'新增',
            iconCls:'icon-add',
            handler:function(){
            	addParamInfo();
            }
        },'-',{
            text:'修改',
            iconCls:'icon-edit',
            handler:function(){
            	updateParamInfo();
            }
        },'-',{
             text:'删除',
             iconCls:'icon-remove',
             handler:function(){
                // 处理明细记录的删除操作handler
                removeParamInfo();
		    }
		}]
	});
}

/**
 * 新增
 */
function addParamInfo(){
	
    $('#paramDlg').dialog('open').dialog('setTitle','新增');

    $("#productCode").combobox({
        editable:false,
        disabled:false,
        onSelect: function(){ 
            checkOnly();
        }
    });
    
    $('#paramEnName').removeAttr('readonly');
    $('#productCode').css("color", "#000000");
    $('#paramEnName').css("color", "#000000");
    
    $("#paramEnName").bind("blur", function(){
        checkOnly();
    });
    
    $('#paramForm').form('clear');
    $("#productCode").combobox('setValue','');
    $("#readFlag").combobox('setValue','');
    $('#saveInfo').data("action","insert");
	/**
	$('#paramDlg').dialog({
		title:'增加系统参数',
		width: 400,    
		height: 400,    
		modal: true,
		onBeforeOpen:function(){
			$('#paramEnName').removeAttr('disabled');
			$('#productCode').combobox('enable');
		},
		onBeforeClose:function(){
			$('#paramForm').form('clear');
		},
		buttons:[{
			text:'保存',
			handler: function(){
				if(!$('#paramForm').form('validate'))
					return;
				if(!checkNull()){
			        return ;
			    };
				$.ajax({
					type:'POST',
					url:'${ctx}/base/param/add',
					data:{
						productCode:$('#productCode').combobox('getValue'),
						readFlag:$('#readFlag').combobox('getValue'),
						paramCnName:$('#paramCnName').val(),
						paramEnName:$('#paramEnName').val(),
						paramValue:$('#paramValue').val(),
						description:$('#description').val()
					},
					success: function(data, status){
						if(data.status=="SUCCESS"){
							$.messager.show({
								title:'消息',
								msg:'提交成功！',
								timeout:5000,
								showType:'slide'
							});
							$('#paramDlg').dialog('close');
							$('#paramInfo').datagrid('reload');
						} else {
							$.messager.alert('错误',data.result,'error');
						}
					}
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#paramDlg').dialog('close');
			}
		}]
	});
	
	**/
}

/**
 * 修改
 */
function updateParamInfo(){
    var rows = $('#paramInfo').datagrid('getSelected');
    if(!rows){
        showSlideMessage("请选择需要编辑的记录！");
        return;
    }
    //不可编辑条目不能修改
    if(rows.readFlag==0){ 
    	$.messager.alert('温馨提示','不可编辑条目不能修改！','error');
        return;
    }
    $('#paramDlg').dialog('open').dialog('setTitle','修改');
    
    $('#paramEnName').attr('readonly','readonly');
    $('#productCode').css("color", "#9E9E9E");
    $('#paramEnName').css("color", "#9E9E9E");
   
    $("#productCode").combobox({
        editable:false,
        disabled:true
    });
    $('#paramForm').form('clear');
    $('#paramForm').form('load',rows);
    $("#productCode").combobox('setValue',rows.productCode);
    $("#readFlag").combobox('setValue',rows.readFlag);

    
    // 绑定处理 解除失去焦点的banding
    $("#paramEnName").unbind("blur");
    $('#saveInfo').data("action","update");
}

/**
 * 同时处理新增和修改数据的保存操作
 */
function saveParamInfo(){
	
    var isValid = $('#paramForm').form('validate');
    if(!isValid){
        return ;
    }
	   // 判断 新增或修改
    var action = $('#saveInfo').data('action');
	
	if(action=="insert"){
        $.ajax({
            type:'POST',
            async: false,
            url:'${ctx}/base/param/add',
            data:{
                productCode:$('#productCode').combobox('getValue'),
                readFlag:$('#readFlag').combobox('getValue'),
                paramCnName:$('#paramCnName').val(),
                paramEnName:$('#paramEnName').val(),
                paramValue:$('#paramValue').val(),
                description:$('#description').val()
            },
            success: function(data, status){
                if(data.status=="SUCCESS"){
                	showSlideMessage("提交成功！");
                    $('#paramDlg').dialog('close');
                    $('#paramInfo').datagrid('load');
                } else {
                    $.messager.alert('错误',data.result,'error');
                }
            }
        });
	}else{
	    $.ajax({
	        type:'POST',
	        async: false,
	        url:'${ctx}/base/param/update',
	        data:{
	            productCode:$('#productCode').combobox('getValue'),
	            readFlag:$('#readFlag').combobox('getValue'),
	            paramCnName:$('#paramCnName').val(),
	            paramEnName:$('#paramEnName').val(),
	            paramValue:$('#paramValue').val(),
	            description:$('#description').val()
	        },
	        success: function(data, status){
	            if(data.status=="SUCCESS"){
	                showSlideMessage("更新成功！");
	                $('#paramDlg').dialog('close');
	                $('#paramInfo').datagrid('reload');
	            } else {
	                $.messager.alert('错误',data.result,'error');
	            }
	        }
	    });
	}
}


/**
 * 修改数据提交到Controller
 */
function updateParams(){
    if(!$('#paramForm').form('validate')){
        return;
    }
    if(!checkNull()){
        return ;
    };
}

/**
 * 删除记录
 */
function removeParamInfo(){
	var node = $('#paramInfo').datagrid('getSelected');
	if(!node){
		showSlideMessage("请选择需要删除的系统参数！");
		return;
	}
	$.messager.confirm('确认信息', '确定删除该记录吗?', function(r){
		if(r){
			$.ajax({
				type:'POST',
				url:'${ctx}/base/param/delete',
				data:{
					productCode:node.productCode,
					paramEnName:node.paramEnName
				},
				success:function(data, status){
					if(data.status=="SUCCESS"){
						showSlideMessage("删除成功！");
						$('#paramInfo').datagrid('load');
					} else {
						$.messager.alert('错误',data.result,'error');
					}
				},
				error: function(){
					$.messager.alert('消息', '删除失败!','info');
				}
			});
		}
	});
}

/**
 * 新增时判断唯一约束，修改的页面无需做上述判断，修改页面改数据不可编辑
 */
function checkOnly() {
	
	var productCode = $("#productCode").combobox('getValue');
	var paramEnName= $('#paramEnName').val();
	if(isNull(productCode) || productCode=="" || $.trim(paramEnName)==""){
		return ;
	}
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/param/checkOnly',
		data : {
			productCode : productCode,
			paramEnName : paramEnName
		},
		success : function(data, status) {
			if("false"==data.status) {
				$.messager.alert('温馨提示','您输入的参数英文名称['+paramEnName+']已存在，请输入新的参数英文名称！');
				$("#paramEnName").val('');
				$("#paramEnName").focus();
			} else
				return null;
		},
		error : function(data, status) {
			$.messager.alert('温馨提示','交易编码唯一性校验错误！','info');
		},
		datatype : "json"
	});
}

/**
 * 必输项目的校验
 */
function checkNull(){
	var productCode=$('#productCode').combobox('getValue');
	if(isNull(productCode)){
		$.messager.alert('温馨提示','产品代码不能为空！','info');
		return false;
	}
	var readFlag=$('#readFlag').combobox('getValue');
	if(isNull(readFlag)){
		$.messager.alert('温馨提示','是否可编辑不能为空！','info');
		return false;
	}
	return true;
}

/**
 * 查询
 */
function search(){
	$('#paramInfo').datagrid('load',{
		paramCnName: $('#qryCnName').val(),
        productCode: $('#qryProductCode').combobox('getValue'),
        paramEnName: $('#qryEnName').val()
	});
	return false;
}
/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
    $('#qryProductCode').combobox('setValue','');
}

$.extend($.fn.validatebox.defaults.rules, {
	enNameValid: {        //[^a-zA-Z0-9\(\)\s/\_（\）\/.\/:]
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9_:]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、下划线或冒号组成'
	},
	valueValid: {
		validator: function(value, param){
			var p = new RegExp('[`~\\\\!@#\u4E00-\u9FA5\\%\^\*\(\)\+<>\"{},;\'\[\\]]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、下划线、空格、URL或冒号组成'
	},
	cnNameValid: {        
		validator: function(value, param){
			var p = new RegExp('[`~\\\\!@#\\$%\^&\*\+<>\"{},;_\'\[\\]]$');
			return !p.test(value);
		},
		message: '输入内容应由数字、字母、中文字符、下划线或冒号组成'
	}
});

/*
 * 统一弹出侧边消息提示
 */
function showSlideMessage(msg){
    $.messager.show({
        title:'提示',
        msg:msg,
        timeout:4000,
        showType:'slide'
    });
}
</script>
</body>
</html>