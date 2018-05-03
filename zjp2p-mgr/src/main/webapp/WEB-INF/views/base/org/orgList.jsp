<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#orgForm tr{
    height: 40px;
}
#orgForm td {
	padding-left:20px;
	padding-top:10px;
}
#orgForm td label{
	padding-left:50px;
	padding-top:10px;
}

</style>
</head>
<body>
<!-- 工具栏 begin -->
<div style="margin:5px">  
	<a href="javascript:void(0)" id="orgRefresh" class="easyui-linkbutton" iconCls="icon-reload" plain="true">刷新</a>  
	<a href="javascript:void(0)" id="orgAdd" class="easyui-linkbutton" iconCls="icon-add" plain="true">增加</a>    
	<a href="javascript:void(0)" id="orgUpdate" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>    
	<a href="javascript:void(0)" id="orgDelete" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>       
</div>
<!-- end 工具栏 -->

<table id="orgTable" data-options="fit:true"></table>

<!-- 添加/修改_组织_弹窗 begin -->
<div id ="orgPanel">
	<form id="orgForm" method="post">
		<table style="padding:15 30 0 50">
			<tr>
	   			<td><label>组织机构代码:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="orgCode" name="orgCode" data-options="required:true,validType:['orgCodeValid','length[4,10]']"></input></td>
	   		</tr>
	   		<tr>
	   			<td><label>组织机构名称:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="orgName" name="orgName" data-options="required:true,validType:['nameValid','length[2,20]']"></input></td>
	   		</tr>
	   		<tr>
	   			<td><label>机构顺序:</label></td>
	   			<td><input class="easyui-numberspinner" type="text" id="orderNo" name="orderNo"  data-options="min:1,validType:['positive','length[0,10]']" ></input></td>
	   		</tr> 
	   		<tr>
	   			<td><label>上级机构:</label></td>
	   			<td><input class="easyui-combotree" type="text" id="parentOrgCode" name="parentOrgCode" data-options="url:'${ctx}/base/org/orgTree?timeid='+Math.random(),required:true,multiple:false,checkbox:false"></td>
	   		</tr>
	   		<tr style="display: none">
	   			<td>TreePath:</td>
	   			<td><input class="easyui-validatebox" type="text" id="treepath" name="treepath"></td>
	   		</tr>
		</table>	
	 </form> 
</div> 
<!-- end 添加/修改_组织_弹窗 -->

<script type="text/javascript">
//初始化树形表格
$('#orgTable').treegrid({    
	url:'${ctx}/base/org/orgTree?timeid='+Math.random(),//url后增加随机数，防止IE缓存造成的不刷新
	method:'post',
	treeField: 'text',
	rownumbers: true,
	fitColumns: true,
	idField: 'id',
	columns:[[        
        {field:'text',title:'组织机构名称',width:200},        
        {field:'id',title:'组织机构代码',width:200},
        {field:'attributes',title:'组织机构顺序',width:200,
        	formatter:function(value){
        		return value.orderNo;
        	}//treegrid继承自datagrid，无法使用attributes.orderNo来获取数据
        }
    ]]
});

//关闭组织添加修改的弹窗 
$('#orgPanel').dialog({ 
	closed:true
});

//验证规则 
$.extend($.fn.validatebox.defaults.rules, {    
	orgCodeValid:{
		validator : function(value) {
			return /^[A-Za-z0-9]+$/.test(value);
		},
		message : '请按照正确的格式输入'
	},
	nameValid: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
			return !p.test(value);
		},
		message: '组名称应由数字、字母、中文字符、下划线或括号组成'
	},
	positive:{
		validator:function(value, param){
			return value>0?true:false;
		},
		message:'机构顺序应为正数'
	}
});

//添加 
$('#orgAdd').click(function(){
	var node = $('#orgTable').treegrid('getSelected');
	//alert(node.id);
	if(node)
	{
		$('#orgPanel').dialog({    
			title: '增加新机构',    
			modal: true,
			width: 400,
			height: 300,
			closed:false,
			onBeforeClose:function(){
				$('#orgForm').form('clear');
			},
			buttons : [{
				text : '添加',
				handler : function() {
					if(!$('#orgForm').form('validate')){
						$.messager.alert('提示','请补充必填信息！','info');
						return;
					}
						
					$.ajax({   
						url:'${ctx}/base/org/add', 
						type : 'POST',
						data:{
							orgCode:$('#orgCode').val(),
							orgName:$('#orgName').val(),
					   		orderNo:$('#orderNo').val(),
					   		parentOrgCode:$("#parentOrgCode").combotree('getValue')
						},
						success : function(data, status) {
							if(data.status=="SUCCESS"){						
								$('#orgPanel').dialog('close');
								$('#orgTable').treegrid('reload');
								$.messager.show({
									title:'消息',
									msg:'添加成功！',
									timeout:5000,
									showType:'slide'
								});
							}else{
								$.messager.alert('提示',data.result,'error');
							}
						}
					});
				}
			},{
				text:'取消',
				handler: function(){
					$('#orgPanel').dialog('close');
				}
			}]
		});//end of dialog
		
		//在上级机构文本框中显示选中的组织结构 
		var node = $('#orgTable').datagrid('getSelected');
		$("#parentOrgCode").combotree('setValue', node.id);
		//使组织结构代码可编辑
		$("#orgCode").removeAttr("disabled");
	}else{
		$.messager.alert('提示','请选中上级机构！','info');
	}
});

//更新 
$('#orgUpdate').click(function(){
	var node = $('#orgTable').treegrid('getSelected');
	
	if(node)
	{
		$('#orgPanel').dialog({    
			title: '修改机构信息',    
			modal: true,
			closed:false,
			width: 400,
			height: 300,
			onBeforeClose:function(){
				$('#orgForm').form('clear');
			},
			buttons : [{
				text : '更新',
				handler : function() {
					if(!$('#orgForm').form('validate')){
						$.messager.alert('提示','请按要求填写信息！','info');
						return ;
					}
					if($('#orgCode').val()!=""&&$('#orgCode').val()==$('#parentOrgCode').combobox('getValue')){
						$.messager.alert('提示','所属父类不能为自己！','info');
						return;
					}
					
					$.ajax({     
						url:'${ctx}/base/org/update',
						type: 'POST',
						data:{
							orgCode:$('#orgCode').val(),
							orgName:$('#orgName').val(),
					   		orderNo:$('#orderNo').val(),
					   		parentOrgCode:$("#parentOrgCode").combotree('getValue'),
					   		treepath:$("#treepath").val()
						},
						success:function(data, status){
							if(data.status=="SUCCESS"){		
								$('#orgPanel').dialog('close');
								$('#orgTable').treegrid('reload');
								$.messager.show({
									title:'消息',
									msg:'更新成功！',
									timeout:5000,
									showType:'slide'
								});   
							} else {
								$.messager.alert('提示',data.result,'error');
							}
						}
					});
				}
			},{
				text:'取消',
				handler: function(){
					$('#orgPanel').dialog('close');
				}
			}]
		});
				
		$("#orgCode").val(node.id);
		$("#orgName").val(node.text);
		$('#orderNo').numberspinner('setValue', node.attributes.orderNo);  
		$("#treepath").val(node.attributes.treepath);
		$("#parentOrgCode").combotree('setValue', node.attributes.parentOrgCode);
		$('#orgForm').form('validate');
		$("#orgCode").attr('disabled','disabled');
		
		
	}else
		$.messager.alert('提示','请选中一条记录！','info');
});

//删除 
$('#orgDelete').click(function(){
	var node = $('#orgTable').treegrid('getSelected');
	if(node)
	{
		$.messager.confirm('确认', '是否要删除机构"'+node.text+'"?', function(result){
			if (result){
				$.ajax({
					type : 'POST',
					async: true,
					url : '${ctx}/base/org/delete',
					data : {
						orgCode:node.id
					},
					success : function(data, status) {
						if(data.status=='SUCCESS'){
							$('#orgTable').treegrid('reload');
							$.messager.show({
								title:'消息',
								msg:'删除成功！',
								timeout:5000,
								showType:'slide'
							});
						} else{
							$.messager.alert('错误',data.result,'error');
						}					
					}
				});//end of ajax
			}else
			{
				$.messager.show({
					title:'消息',
					msg:'取消删除！',
					timeout:5000,
					showType:'slide'
				});
			}
		});
		
	}else
		$.messager.alert('提示','请选中一条记录！','info');
});

$('#orgRefresh').click(function(){
	$('#orgTable').treegrid('reload');
});
</script>
</body>
</html>