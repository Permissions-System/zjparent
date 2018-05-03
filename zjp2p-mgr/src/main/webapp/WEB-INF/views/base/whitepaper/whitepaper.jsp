<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#editWhitePaper tr{
	height:50px;
}
#editWhitePaper td label
{
	text-align:right;
	padding-left:100px;	
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:110px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post">
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label>用户姓名:</label></td>
                    <td><input id="nameSearch" name="nameSearch" class="easyui-validatebox" data-options="validType:['nameValid','length[1,20]']"/></td>
                    <td><label>手机号:</label></td>
                    <td><input id="mobileSearch" name="mobileSearch" class="easyui-validatebox" data-options="validType:['mobile','mobileExist']"/></td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="whitePaperList">
        </table>
    </div>
</div>
<div id="tool">
	<a href="javascript:void(0)" id="refresh" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
	<a href="javascript:void(0)" id="addUser" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加</a>
	<a href="javascript:void(0)" id="deleteUser" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
</div>
<div id="editWhitePaper">
<form>
<table>
	<tr style="display:none">
		<td><label>id:</label></td>
		<td><input class="easyui-validatebox" type="text" id="recNo"/></td>
	</tr>
	<tr>
		<td><label>姓名:</label></td>
		<td><input class="easyui-validatebox" type="text" id="name" data-options="required:true,validType:['nameValid','length[2,20]']"/></td>
	</tr>
	<tr>
		<td><label>电话:</label></td>
		<td><input class="easyui-validatebox" type="text" id="mobile" data-options="required:true,validType:['mobile','mobileExist']"/></td>
	</tr>
	<tr>
		<td><label>备注:</label></td>
		<td><input class="easyui-validatebox" type="text" id="remark" data-options="validType:['length[0,60]']"/></td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
$(function(){
	$('#whitePaperList').datagrid({    
		url:'${ctx}/base/whitepaper/list',  
		title:'用户白名单管理',
		fit:true,
		rownumbers:true,
		fitColumns:true,
		singleSelect:true,
		checkOnSelect:false,
		pagination:true,
		toolbar: '#tool',
		columns:[[    
	         {field:'name',title:'用户姓名',width:200},
	         {field:'mobile',title:'用户手机号',width:200}, 
	         {field:'remark',title:'备注信息',width:300},
	         {field:'opt',title:'操作',align:'right',
	       		formatter:function(value, row, index) {
	   				return '<button onclick="update('+index +')" class="easyui-linkbutton">修改</button>';
	    		} 
	         }
	    ]]
	});
	
	$('#refresh').click(function(){
		$('#whitePaperList').datagrid('reload');
	});
	
	$('#addUser').click(function(){
		$('#editWhitePaper').dialog({
			title:'增加白名单用户',
			width: 400,    
			height: 250,    
			modal: true,
			onBeforeClose:function(){
				$('#editWhitePaper').form('clear');
			},
			buttons:[{
				text:'保存',
				handler:function(){
					submitData('${ctx}/base/whitepaper/add');
				}
			},{
				text:'取消',
				handler:function(){
					$('#editWhitePaper').dialog('close');
				}
			}]
		});
	});
	
	$('#deleteUser').click(function(){
		var node = $('#whitePaperList').datagrid('getSelected');
		if(node){
			$.messager.confirm('确认', '是否要删除白名单用户"'+node.name+'"?', function(result){
				if (result){
					$.ajax({
						type:'POST',
						url:'${ctx}/base/whitepaper/delete',
						data:{
							recNo:node.recNo
						},
						success:function(data, status){
							if(data.status=="SUCCESS"){
								$.messager.show({
									title:'消息',
									msg:'删除成功！',
									timeout:5000,
									showType:'slide'
								});
								$('#whitePaperList').datagrid('reload');
							} else {
								$.messager.alert('错误',data.result,'error');
							}
						}
					});
				}
			});
		}else{
			$.messager.alert('提示','请选择一条记录！','info');
		}
	});
	
	/**
	 * 查询
	 */
	$("#btnQuery").bind("click", function(){
		$('#whitePaperList').datagrid('load',{
			name: $('#nameSearch').val(),
	        mobile: $('#mobileSearch').val()
		});
		return false;
	});

	/**
	 * 清空查询条件
	 */
	$("#btnCancel").bind("click", function(){
	    $('#queryForm').form('clear');
	});
});

function update(row){
	$('#editWhitePaper').dialog({
		title:'修改白名单用户',
		width: 400,    
		height: 250,    
		modal: true,
		onBeforeClose:function(){
			$('#editWhitePaper').form('clear');
		},
		buttons:[{
			text:'保存',
			handler:function(){
				submitData('${ctx}/base/whitepaper/update');
			}
		},{
			text:'取消',
			handler:function(){
				$('#editWhitePaper').dialog('close');
			}
		}]
	});
	$('#whitePaperList').datagrid('selectRow', row);
	var node = $('#whitePaperList').datagrid('getSelected');
	$('#recNo').val(node.recNo);
	$('#name').val(node.name);
	$('#mobile').val(node.mobile);
	$('#remark').val(node.remark);
	$('#editWhitePaper').form('validate');
}

function submitData(url){
	if(!$('#editWhitePaper').form('validate'))
		return;
			
	$.ajax({
		type:'POST',
		url:url,
		data:{
			recNo:$('#recNo').val(),
			name:$('#name').val(),
			mobile:$('#mobile').val(),
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
				$('#editWhitePaper').dialog('close');
				$('#whitePaperList').datagrid('reload');
			} else {
				$.messager.alert('错误',data.result,'error');
			}
		}
	});
}

$.extend($.fn.validatebox.defaults.rules, {    
	nameValid: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5_]');
			return !p.test(value);
		},
		message: '名称应由数字、字母、中文字符、下划线组成'
	},
	mobile: {
		validator: function(value, param){
			var p = /^1[3|4|5|8][0-9]\d{8}$/;
			return p.test(value);
		},
		message: '请输入正确的手机号码！'
	},
	mobileExist:{
		validator :function(value){
			var result;
			$.ajax({
				async:false,
				type:'POST',
				url:'${ctx}/base/whitepaper/checkMobile',
				data:{
					recNo:$('#recNo').val(),
					mobile:$('#mobile').val()
				},
				success:function(data,status){
					result = data;
				}
			});
			return result;
		},
		message:'手机号已被使用'
	}
});
</script>
</body>
</html>