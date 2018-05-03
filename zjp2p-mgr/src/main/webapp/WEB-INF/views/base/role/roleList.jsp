<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.my_td_label {
	padding-left:10px;
	height: 25px;
	text-align: left;
	font-size: 13px;
	color: #3A316F;
	vertical-align: bottom;
	nowrap:nowrap;
	//font-weight: bold;
}
.my_td_text {
	font-size: 12px;
}

#roleForm tr{
	height: 40px;
}

#roleForm td {
	padding-left:20px;
	padding-top:10px;
}
#roleForm td label{
	padding-left:50px;
	padding-top:10px;
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
	<div data-options="region:'west',split:true,title:'组织机构管理'" style="width: 200px">
		<ul id="roleOrg" data-options="url:'${ctx}/base/org/orgTree?timeid='+Math.random(),method:'post',checkbox:true"></ul><!--url后增加随机数，防止IE缓存造成的不刷新-->
	</div>
	
	<!-- begin 角色列表 -->
	<div data-options="region:'center',border:false,fit:true" title="角色列表" >		
		<table id="roleTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"></table>
		<div id="roleTool">
			<a href="javascript:void(0)" id="roleRefresh" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
			<a href="javascript:void(0)" id="roleAdd" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加角色</a>
			<a href="javascript:void(0)" id="roleDelete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除角色</a>
		</div>
	</div>
	<!-- end 角色列表 -->
	
	<div id="rolePanel">
		<form id="roleForm" method="post">
			<table style="padding:20 30 0 50">
			<tr>
	   			<td><label>角色代码:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="roleCode" name="roleCode" data-options="required:true,validType:['roleCodeValid','length[4,20]']"></input></td>
	   		</tr>
	   		<tr>
	   			<td><label>角色名称:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="roleName" name="roleName" data-options="required:true,validType:['nameValid','length[4,20]']"></input></td>
	   		</tr>
	   		<tr>
	   			<td><label>所属机构:</label></td>
	   			<td><input class="easyui-combotree" id="orgCode" name="orgCode" data-options="url:'${ctx}/base/org/orgTree?timeid='+Math.random(),required:true"></td>
	   		</tr>
	   		<tr>
	   			<td><label>角色类型:</label></td>
	   			<td>
	   			<select class="easyui-combobox" id="roleType" name="roleType" panelHeight="auto" data-options="required:true,editable:false">
		   			<c:forEach items="${ROLE_TYPE}" var="type">
		   				<option value="${type.configCode}">${type.configName}</option>
		   			</c:forEach>
		   		</select>
	   			</td>
	   		</tr>
		</table>
		</form>
	</div>
	
	<!-- begin 查看角色人员信息 -->
	<div id="stafforole" class="easyui-dialog" style="width:900px;height:400px;"
        data-options="resizable:false,modal:true,title:'查看角色人员信息'" closed="true">
		<table id="staffTable" ></table>
	</div>
	<!-- end 查看角色人员信息 -->
	
		<div id="roleRightWindow" class="easyui-window" title="角色权限管理" data-options="maximized:true,modal:true,closed:true">
	    <div class="easyui-layout" data-options="fit:true">
		    <div data-options="region:'west',split:true, title:'模块树'" style="width:300px">
				<ul id="moduleTree"></ul>
		    </div>
		    <div data-options="region:'center',title:'功能权限'">
		    	<table id="checkBoxTable" style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
		    		<tbody>
			    		<tr>
			    			<td colspan="4" align="right" style="height:25px;vertical-align: top;font-size:13px">
	   							<a id="checkAllBtn" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-ok'">全选</a>&nbsp;
								<a id="inverseBtn" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-undo'">反选</a>&nbsp;
								<a id="resetBtn" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">重置</a>&nbsp;
			    				<a id="saveBtn" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'">保存</a>&nbsp;
			    				<a id="cancelBtn" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'">关闭</a>
			    			</td>
			    		</tr>
			    		<tr id="appendAfterThis">
			    			<td colspan="4">
			    				<hr/>
			    			</td>
			    		</tr>
			    		<tr id="appendBeforeThis">
			    		</tr>
			    		<!-- 
			    		<tr>
			    			<td colspan="4" align="right" style="height:25px;vertical-align: top;font-size:13px">
	   							<a id="resetBtnB" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">重置</a>&nbsp;
			    				<a id="saveBtnB" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'">保存</a>&nbsp;
			    				<a id="cancelBtnB" href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'">关闭</a>
			    			</td>
			    		</tr>
			    		 -->
		    		</tbody>
		    	</table>
		    </div>
	    </div>
    </div>
</div>

<script type="text/javascript">              
/*注意：
	1、要求动态生成的页面元素id、name都以"ROLE_LIST_"开头，以便统一控制
	2、功能上还缺少模块交易按模块顺序插入的处理,可以考虑使用占位符的方式解决
	3、如果交易只能挂在模块的叶子节点，则应该修改模块数check事件，减少服务端查询次数
*/ 
var PREFIX_ROLE_LIST_MODULE = "ROLE_LIST_MODULE_";// 模块交易相关元素ID前缀
var SUFFIX_CHECK_BOX = "_CHECKBOX";// checkBox元素ID后缀
var SUFFIX_CHECK_ALL_BUTTON = "_CHECK_ALL_BUTTON";// 全选按钮元素后缀名
var SUFFIX_INVERSE_BUTTON = "_INVERSE_BUTTON";// 反选按钮元素后缀名
var ROLE_TYPE_INSIDE = 0;
var ROLE_TYPE_OPERATOR = 1;

$('#roleTable').datagrid({    
	toolbar: '#roleTool',
	columns:[[        
        {field:'roleCode',title:'角色编码',width:100},        
        {field:'roleName',title:'角色名称',width:180},        
        {field:'orgCode',title:'所属机构',width:180,
        	formatter : function(value, row, index) {
        		var node = $('#roleOrg').tree('find', value);
        		return node.text;

			} 	
        },
        {field:'opation',title:'操作',align:'center',
			formatter : function(value, row, index) {
				var opt='';
				opt += '<button onclick="updateRole('+index +')" class="easyui-linkbutton">修改信息</button>';
				opt += '<button onclick="getRoleUsers('+index +')" class="easyui-linkbutton">查看用户</button>';
				opt += '<button onclick="setRolePermission('+index +')" class="easyui-linkbutton">设置权限</button>';
				return opt;
			} 
        }
    ]]
});

$("#roleOrg").tree({
	onClick:function(node){	
		$('#roleTable').datagrid('load',{    
			orgCodes : node.id
		});
	},
	onCheck:function(node){
		var nodes = $('#roleOrg').tree('getChecked');
		var codes = "";
		for(var i=0; i<nodes.length; i++){
			codes = (codes + nodes[i].id) + (((i + 1)== nodes.length) ? '':','); 
		}
		
		if(codes==""){
			$('#roleTable').datagrid('loadData',[]);
			return; 
		}
			
		$('#roleTable').datagrid('options').url = '${ctx}/base/role/roleByOrgsAndPage';
		$('#roleTable').datagrid('load',{    
			orgCodes : codes,
			pagination:true,
			pageSize:10
		});
	}
});
		
$('#rolePanel').dialog({ 
	closed:true
}); 
   
$('#roleRefresh').click(function(){
	$('#roleTable').datagrid('reload');	
});


$.extend($.fn.validatebox.defaults.rules, {    
	roleCodeValid:{
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
	}
});

$('#roleAdd').click(function(){
	$('#rolePanel').dialog({
		title : '添加角色信息',
		modal : true,
		closed: false,
		width: 400,
		height: 300,			
		onBeforeClose:function(){
			$('#roleForm').form('clear');
		},
	 	buttons : [{
			text : '添加',
			handler : function(){
				if(!$('#roleForm').form('validate'))
				{
					$.messager.alert('提示','请按要求填写信息！','info');
					return ;
				} 
				
				$.ajax({
					type : 'POST',
					url:'${ctx}/base/role/add',    
					data:{
						roleCode:$("#roleCode").val(),
						roleName:$("#roleName").val(),
						orgCode:$("#orgCode").combotree('getValue'),
						roleType:$('#roleType').combobox('getValue')
					},
					success:function(data){
						if(data.status=="SUCCESS"){
							$('#rolePanel').dialog('close');
							$('#roleTable').datagrid('reload');
							$.messager.show({
								title:'消息',
								msg:'添加成功！',
								timeout:5000,
								showType:'slide'
							});  
						} else {
							$.messager.alert('错误',data.result,'error');
						}
						  
					}
				});
			}
		},{
			text : '取消',
			handler : function(){
				$('#rolePanel').dialog('close');
			}
		}]  
	});//end of dialog			
	
	var node = $('#roleOrg').tree('getSelected');
	if(node)
	{
		$("#orgCode").combotree('setValue', node.id);
	}
	$("#roleCode").removeAttr("disabled");
	$('#roleType').combobox('setValue', '1');//默认普通角色
	$('#roleForm').form('validate');
	
});

function updateRole(rowId){
	$('#roleTable').datagrid('selectRow', rowId);
	var node = $('#roleTable').datagrid('getSelected');
	if(node.roleType == ROLE_TYPE_INSIDE){
		$.messager.alert('错误','该角色不能修改','info');
	} else {
		$('#rolePanel').dialog({
			title : '修改角色信息',
			modal: true,
			closed:false,
			width: 400,
			height: 300,
			onBeforeClose:function(){
				$('#roleForm').form('clear');
			},
			buttons : [{
				text : '更新',
				handler : function() {
					if(!$('#roleForm').form('validate'))
					{	
						return false;
					}
					
					$.ajax({
						type : 'POST',  
						url:'${ctx}/base/role/update',  
						data:{
							roleCode:$("#roleCode").val(),
							roleName:$("#roleName").val(),
							orgCode:$("#orgCode").combotree('getValue'),
							roleType:$('#roleType').combobox('getValue')
						},
						success:function(data){
							if(data.status=='SUCCESS')
							{
								$.messager.show({
									title:'消息',
									msg:'更新成功！',
									timeout:5000,
									showType:'slide'
								});
								$('#rolePanel').dialog('close');
								$('#roleTable').datagrid('reload');
							} else {
								$.messager.alert('错误',data.result,'error');
							}
						}
					});
				}
			},{
				text:'取消',
				handler : function(){
					$('#rolePanel').dialog('close');
				}
			} ]
		});
		
		
		$("#roleCode").val(node.roleCode);
		$("#roleName").val(node.roleName);
		$("#orgCode").combotree('setValue', node.orgCode);
		$('#roleType').combobox('setValue', node.roleType);
		$('#roleForm').form('validate');
		$("#roleCode").attr('disabled','true');
	}
};

$('#roleDelete').click(function(){
	var node = $('#roleTable').datagrid('getSelected');
	if(node)
	{
		if(node.roleType == ROLE_TYPE_INSIDE){
			$.messager.alert('错误','该角色不能删除！','info');
		}else {
			$.messager.confirm('确认', '是否要删除角色"'+node.roleName+'"?', function(result){
				if (result){
					$.ajax({
						type : 'POST',
						async: true,
						url : '${ctx}/base/role/delete',
						data : {
							roleCode:node.roleCode
						},
						success : function(data, status) {
							if(data.status=='SUCCESS'){
								$('#roleTable').datagrid('reload');
								$.messager.show({
									title:'消息',
									msg:'删除成功！',
									timeout:5000,
									showType:'slide'
								});
							} else {
								$.messager.alert('错误',data.result,'error');
							}
						}//end of success
					});//end of ajax
				}
			});//end of confirm
		}
	}else
		$.messager.alert('提示','请选中一条记录！','info');
});

function getRoleUsers(rowId){
	$('#roleTable').datagrid('selectRow', rowId);
	var node = $('#roleTable').datagrid('getSelected');
	$('#stafforole').dialog('open');
	$('#staffTable').datagrid({
		url:'${ctx}/base/staff/listByRolePage',
		queryParams: {
			roleCode:node.roleCode
		},
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
		rownumbers: true,
		fitColumns: true,
        fit:true,
		columns:[[        
	        {field:'staffNo',title:'人员编号', width:120},        
	        {field:'orgCode',title:'所属机构',hidden:true},
	        {field:'orgName',title:'所属机构',width:140},  
	        {field:'name',title:'用户名',width:100},
	        {field:'identNo',title:'身份证号',width:200},
	        {field:'tel',title:'电话',width:140},        
	        {field:'email',title:'E-mail',width:200},        
	        {field:'staffStatus',title:'员工状态',width:60},
	        {field:'createDate',title:'创建时间', hidden:true}
	        
	    ]]
	});
};

var roleListModuleTreeEventSwitcher = true;// 模块树事件开关

function uncheckAllSubTreeNode(node){
	var children = $('#moduleTree').tree('getChildren', node.target);
	if(children && children.length>0){
		for(var i in children){
			uncheckAllSubTreeNode(children[i]);
			$('#moduleTree').tree('uncheck', children[i].target);
		}
	}
}
//配置角色权限	
function setRolePermission(rowId) {
	$('#roleTable').datagrid('selectRow', rowId);
	// 取消所有节点的勾选
	var roots = $('#moduleTree').tree('getRoots');
	for(var i in roots){
		// uncheckAllSubTreeNode(roots[i]);
		$('#moduleTree').tree('uncheck', roots[i].target);
	}
	
	// 清除原页面的信息
	$("[id^='"+PREFIX_ROLE_LIST_MODULE+"']").remove();
	//打开窗口
	$('#roleRightWindow').window('open');
	
	// 一次性查回角色拥有的所有权限信息
	var gridNode = $('#roleTable').datagrid('getSelected');
	if(true){
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/role/getAllRoleTransRelForCheck',
			data : {
				roleCode: gridNode.roleCode
			},
			success : function(data, status) {
				if(data.result && data.result.length>0){
					roleListModuleTreeEventSwitcher = false;
					for(var i in data.result){
						createCheckBox(data.result[i], data.result[i].transactionList);
						// 勾选模块树节点
						var node = $('#moduleTree').tree('find',data.result[i].moduleCode);
						if(node){
							$('#moduleTree').tree('check', node.target);
						}
					}
					roleListModuleTreeEventSwitcher = true;
					// 默认折叠所有模块节点
					var roots = $('#moduleTree').tree('getRoots');
					for(var i in roots){
						$('#moduleTree').tree('collapseAll', roots[i].target);
					}
				}
			},
			error : function(data, status) {
				$.messager.alert('错误信息','获取模块数据失败！'+getJsonErrorMsg(data),'error');
				// 关闭进度条
			},
			datatype : "json"
		});
	}
}

function findNeighborNode(node){
	if(!node){
		return false;
	}
	
}
function createCheckBox(module, data){
	if(!module || !data || data.length==0){
		return;
	}
	var prefix1 = PREFIX_ROLE_LIST_MODULE+module.moduleCode;
	
	var treeNode = $('#moduleTree').tree('find', module.moduleCode);
	var moduleFullName = "";
	if(treeNode){
		 moduleFullName = getModuleFullName(treeNode);
	}
	if(moduleFullName==null || moduleFullName=='') {
		moduleFullName = module.moduleName;
	}
	var prefix2 = prefix1 + '_TRANS_';
	var trId = prefix1 + 'TR';
	var part1 = '<tr id="'+trId+'" style="height:40px;">'
					+'<td id="'+prefix1+'_TD" colspan="4" class="my_td_label">'
						+'<a id="'+prefix1+'" href="#'+prefix1+'" />'+moduleFullName+'&nbsp;'
						+'<a id="'+prefix1+SUFFIX_CHECK_ALL_BUTTON+'" style="font-size:13px" >全选</a>'
						+'<a id="'+prefix1+SUFFIX_INVERSE_BUTTON+'" style="font-size:13px" >反选</a>'
					+'</td></tr>';
	if(!$('#'+trId).length>0){
		// $('#checkBoxTable tbody').append(part1);
		$('#appendBeforeThis').before(part1);
	} else {
		$('#'+trId).replaceWith(part1);
	}
	var part2 = '';
	for(var i in data){
		trId = prefix1+'TR'+(i/4);
		if(i==0){
			part2 = '<tr id="'+trId+'">';
		} else if(i%4==0){
			part2 += '</tr>';
			if(!$('#'+trId).length>0){
				//$('#checkBoxTable tbody').append(part2);
				$('#appendBeforeThis').before(part2);
			} else {
				$('#'+trId).replaceWith(part2);
			}
			part2 = '<tr id="'+trId+'">';
		}
		part2 += '<td id="'+prefix1+'_TD'+i+'" style="width:25%; font-size:13px" >'
					+'<input type="checkbox" id="' + prefix2 + data[i].transCode + SUFFIX_CHECK_BOX+'" value="' + data[i].transCode + '"';
		if(data[i].checked==true){
			part2 = part2+' checked="checked"';
		} else {
			// 默认不选中
		}
		if(data[i].disabled==true){
			part2 = part2+' disabled="disabled" alt="您没有该交易分配权限" ';
		}
		part2 += '/>' + data[i].transName + '</td>';
	}
	if(data.length%4 != 0){
		var len = data.length;
		trId = prefix1 + 'TR' + (len/4);
		while(len%4!=0){
			part2 += '<td id="' + prefix1 + '_TD' + len + '" style="width:25%; font-size:13px" ></td>';
			len++;
		}
	}
	part2 += '</tr>';
	if(!$('#'+trId).length>0){
		//$('#checkBoxTable tbody').append(part2);
		$('#appendBeforeThis').before(part2);
	} else {
		$('#'+trId).replaceWith(part2);
	}
	// 展现内容
	$("[id^='"+prefix1+"']").show();
	
	$('#'+prefix1+SUFFIX_CHECK_ALL_BUTTON).linkbutton({
		plain:true,
		iconCls: 'icon-ok'
	});
	// 绑定全选方法
	$('#'+prefix1+SUFFIX_CHECK_ALL_BUTTON).click(function(){
		var all = $("[id^="+prefix2+"]");
		for(var i in all){
			// 无权处理的交易必须屏蔽反选全选
			if(!all[i].disabled){
				all[i].checked = true;	
			}
		}
	});
	// 绑定反选方法
	$('#'+prefix1+SUFFIX_INVERSE_BUTTON).linkbutton({
		plain:true,
		iconCls: 'icon-undo'
	});
	$('#'+prefix1+SUFFIX_INVERSE_BUTTON).click(function(){
		var all = $("[id^="+prefix2+"]");
		for(var i in all){
			// 无权处理的交易必须屏蔽反选全选
			if(!all[i].disabled){
				all[i].checked = !all[i].checked;
			}
		}
	});
}


function getModuleFullName(node){
	var parentNode = $('#moduleTree').tree('getParent', node.target);
	if(parentNode){
		return getModuleFullName(parentNode)+"->"+node.attributes.moduleName;
	} else {
		return node.attributes.moduleName;
	}
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
	// 按钮动作
	$("#checkAllBtn").click(function(){
		// 将checkbox值重置为原始值
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(!allCheckBox[i].disabled){
					allCheckBox[i].checked = true;
				}
			}
		}
	});
	$("#inverseBtn").click(function(){
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(!allCheckBox[i].disabled){
					allCheckBox[i].checked = !allCheckBox[i].checked;
				}
			}
		}
	});
	$("[id^='resetBtn']").click(function(){
		// 将checkbox值重置为原始值
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(!allCheckBox[i].disabled){
					allCheckBox[i].checked = allCheckBox[i].defaultChecked;
				}
			}
		}
		
		// 显示所有模块
		$("[id^='"+PREFIX_ROLE_LIST_MODULE+"']").show();
	});
	$("[id^='saveBtn']").click(function(){
		var transCodeArray = new Array();
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']:checkbox:checked");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(allCheckBox[i].checked && allCheckBox[i].checked==true){
					transCodeArray.push(allCheckBox[i].value);
				}
			}
		}
		var gridNode = $('#roleTable').datagrid('getSelected');
		// 提交数据
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/role/updateRoleTransRel',
			data : {
				roleCode: gridNode.roleCode,
				transCodeArray: transCodeArray.toString()
			},
			success : function(data, status) {
				// $.messager.alert('提示信息','保存成功！','info');
				$.messager.show({
					title:'提示信息',
					msg:'角色权限保存成功！',
					timeout:5000,
					showType:'slide'
				});
				$('#roleRightWindow').window('close');
			},
			error : function(data, status) {
				$.messager.alert('错误信息','保存失败:'+getJsonErrorMsg(data),'error');
			}
		});
	});
	$("[id^='cancelBtn']").click(function(){
		$('#roleRightWindow').window('close');
	});
	
	
	$('#moduleTree').tree({
		checkbox: true,
		cascadeCheck: true, //级联勾选
		animate:false,
		url:'${ctx}/base/role/getModuleTree',
		method:'post',
		onDblClick : function(node){
			// 叶子节点无需处理
			if($('#moduleTree').tree('isLeaf', node.target)){
				return;
			}
			if(!node.state){
				
			} else if(node.state=='open'){
				$('#moduleTree').tree('collapse', node.target);
			} else if(node.state=='closed') {
				$('#moduleTree').tree('expand', node.target);
			}
		},
		
		onBeforeCheck: function(node, checked){
			var isLeaf = $('#moduleTree').tree('isLeaf', node.target);
			// 如果事件控制器关闭，则不处理
			if(roleListModuleTreeEventSwitcher){
				var trId = PREFIX_ROLE_LIST_MODULE+node.attributes.moduleCode;
				if(checked){
					// 勾选时，先检查模块下的交易是否已经查询到页面，如果已经查询到，则展现模块，否则从服务端加载数据并展现
					if($('#'+trId).length>0){
						$("[id^='"+trId+"']").show();
						// 回复原始勾选状态
						var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"'][id^='"+trId+"']");
						if(allCheckBox){
							for(var i in allCheckBox){
								if(!allCheckBox[i].disabled){
									allCheckBox[i].checked = allCheckBox[i].defaultChecked;
								}
							}
						}
					} else if(isLeaf){ // 特别注明：交易只能挂在模块叶子节点
						var gridNode = $('#roleTable').datagrid('getSelected');
						// 数据库加载数据并显示
						$.ajax({
							type : 'POST',
							async: false,
							url : '${ctx}/base/role/getTransByModuleCodeForCheck',
							data : {
								roleCode: gridNode.roleCode,
								moduleCode: node.attributes.moduleCode
							},
							success : function(data, status) {
								// 关闭进度条
								
								if(data.result && data.result.length>0){
									createCheckBox(node.attributes, data.result);
									// 激活按钮绑定动作
								}
							},
							error : function(data, status) {
								$.messager.alert('错误信息','获取模块数据失败！<br/>'+getJsonErrorMsg(data),'error');
								// 关闭进度条
							},
							datatype : "json"
						});
					} 
					if(!isLeaf) {
						var children = $('#moduleTree').tree('getChildren',node.target);
						if(children && children.length>0){
							for(var i in children){
								$('#moduleTree').tree('check',children[i].target);
							}
						}
					}
					// 如果从服务端加载数据来展现，则应按照正确的顺序插入 页面
				} else {
					// 取消勾选状态
					var needToHide = true;
					var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"'][id^='"+trId+"']");
					if(allCheckBox){
						for(var i in allCheckBox){
							if(!allCheckBox[i].disabled){
								allCheckBox[i].checked = false;
							} else {
								needToHide = false;
							}
						}
					}
					// 解除勾选时，隐藏指定位置的交易信息
					if(needToHide && $('#'+trId).length>0){
						$("[id^='"+trId+"']").hide();
					}
					if(!isLeaf){
						var children = $('#moduleTree').tree('getChildren',node.target);
						if(children && children.length>0){
							for(var i in children){
								$('#moduleTree').tree('uncheck',children[i].target);
							}
						}
					}
				}
			}
		},
		
		onSelect: function(node){
			// 使用隐藏点击动作
			if($('#'+PREFIX_ROLE_LIST_MODULE+node.attributes.moduleCode).length>0){
				$('#'+PREFIX_ROLE_LIST_MODULE+node.attributes.moduleCode).get(0).click();
			}
		}
	});
});
</script>
</body>
</html>