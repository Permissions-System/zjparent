<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head> 
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
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
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
	<!-- 模块树信息 begin -->
	<div data-options="region:'west',split:true,title:'模块树信息'" style="width: 300px">
		<ul id="moduleTree" data-options="url:'${ctx}/base/module/rootTree',checkbox:true"></ul>
	</div>
	<!-- end 模块树信息  -->
	
	<!-- 交易列表 begin -->
	<div data-options="region:'center',border:false,fit:true" title="交易列表" >		
		<table id="transTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"> 
		</table>     
		<div id="transTool">
			<a href="#" onclick="dataRefresh()" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
			<a href="#" onclick="addTrans()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加交易</a>
		</div>
	</div>
	<!-- end 交易列表 -->
	
	<!-- 交易列表_内容_弹窗 begin -->
	<div id="transPanel" style="width:400px;height:300px;padding:20px 0px 10px 20px" >
		<form id="transForm" method="post">
			<table style="width:100%;height:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 13px">
				<tr class="itemMagin">
		   			<td>交易代码:</td>
		   			<td>
		   				<input class="easyui-validatebox" type="text" id="transCode" onchange="checkOnly()" name="transCode" data-options="required:true,validType:['transCode[]','minLength[3]','maxLength[20]']" >
		   				</input>
		   			</td>
		   		</tr>
		   		<tr class="itemMagin">
		   			<td>交易名称:</td>
		   			<td>
		   				<input class="easyui-validatebox" type="text" id="transName" name="transName" data-options="required:true,validType:['transName[]','minLength[3]','maxLength[40]']" style="width: 200px;">
		   				</input>
		   			</td>
		   		</tr>
		   		<tr class="itemMagin">
		   			<td>交易URL:</td>
		   			<td>
		   				<input class="easyui-validatebox" type="text" id="url" name="url" data-options="required:true,validType:['url[]','minLength[3]','maxLength[150]']" style="width: 200px;">
		   				</input>
		   			</td>
		   		</tr>
		   		<tr class="itemMagin">
		   			<td>交易状态</td>
		   			<td>
                        <select id="transStatus" class="easyui-combobox" name="transStatus" style="width:200px;" panelHeight="auto" data-option="editable:false,required:true" >
			                <c:forEach items="${status}" var="type">
								<option value="${type.configCode}" selected="selected">${type.configName}</option>
							</c:forEach>    
	            		</select> 
            		</td>
		   		</tr>
		   		<tr id="transValidateFlag" class="itemMagin">
		   			<td>交易是否有效</td>
		   			<td>
			   			<select id="validateFlag" class="easyui-combobox" panelHeight="auto" name="validateFlag" style="width:155px;" data-option="editable:false,required:true" style="width: 200px;">
			                <option value="1">交易有效</option>    
			                <option value="0">交易无效</option>        
	            		</select> 
            		</td>
		   		</tr>
		   		<tr class="itemMagin">
		   			<td>交易所属模块:</td>
		   			<td>
		   				<input id="moduleCode" class="easyui-combotree" type="text" name="moduleCode" data-options="url:'${ctx}/base/module/rootTree',required:true" style="width: 200px;"/>
		   			</td>
		   		</tr>
			</table>
		</form>
	</div>
	<!-- end 交易列表_内容_弹窗 -->
	
	<!-- 查看角色列表 begin -->
	<div id="roleDialog" class="easyui-window" title="角色列表 " 
		data-options="closed: true,maximized:true,resizable:true,modal:true">
		<table id="roleTable" style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
		   	<tbody>
			   	<tr id="appendAfterThis">
			   	</tr>
			   	<tr id="appendBeforeThis">
			    </tr>
		   	<tbody>
		</table>
	</div>
	<!-- end 查看角色列表 -->
	
	<div id="orgTree"></div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	 // 分页当前显示页数文本框不可编辑 
	 $(".pagination-num").attr('disabled','disabled');
	 //初始化组织机构树
	$('#orgTree').tree({
		cascadeCheck: false, //不级联勾选，因为父级节点也有角色信息
		animate:false,
		url:'${ctx}/base/org/rootTree'
	});
});

var PREFIX_ROLE_LIST_MODULE = "ROLE_LIST_MODULE_";// 角色元素ID前缀

//交易编码 
function checkOnly() {
	var code = $("#transCode").val();
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/trans/checkTransCode/ajax',
		data : {
			transCode : code
		},
		success : function(data, status) {
			var exist = data.checkCodeResult;
			if(!exist) {
				$.messager.alert('温馨提示','您输入的交易编码('+ code+ ')已被占用，请输入新的交易码！');
 				$("#transCode").val(""); 
 				$("#transCode").focus();
			} else
				return null;
		},
		error : function(data, status) {
			$.messager.alert('温馨提示','交易编码唯一性校验错误！');
		},
		datatype : "json"
	});
}

//计算字符串长度
function countCharNum(str){
	if(str==null){
		return 0;
	}
	//中文按照3个字符计算方式
//	return str.replace(/([^\x00-\xff])/g,'aaa').length;
	return str.length;
}

//校验规则
$.extend($.fn.validatebox.defaults.rules, {
	maxLength: {
		validator: function(value, param){
			return countCharNum(value) <= param[0];
		},
		message: '最大长度为{0}个字符'
	},
	minLength: {
		validator: function(value, param){
			return countCharNum(value) >= param[0];
		},
		message: '最小长度为{0}个字符'
	},
	transCode: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9]');
			return !p.test(value);
		},
		message: '交易编号应由数字和字母组成'
	},
	transName: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）]');
			return !p.test(value);
		},
		message: '交易名称应由数字、字母、中文字符或括号组成'
	},
	url: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\/\{\}\*.]');
			return !p.test(value);
		},
		message: '交易URL应由数字、字母或者{}/*。组成'
	}
});

/*
校验交易的form表单，使用remote可以进行远程验证，用户输入相关信息后浏览器会自动将name=value进行参数传递
返回值必须是json，而且只能有true和false，true表示验证成功
*/
/* 
$(function(){
	$("#transForm").validate({
		rules:{
			transCode:{
				required:true,
				rangelength:[3,15],
				remote:"${ctx}/base/trans/checkTransCode/ajax"
			},
			transName:{
				required:true,
				rangelength:[1,20],
				remote:"${ctx}/base/trans/checkTransName/ajax"
			},
			url:{
				required:true,
				rangelength:[1,20]
			},
			transStatus:{
				required:true
			},
			validateFlag:{
				required:true
			},
			moduleCode:{
				required:true
			}
		},
		messages:{
			transCode:{
				required:"交易码不能为空",
				rangelength:"交易码长度在3到15之间",
				remote:"交易码已存在"
			},
			transName:{
				required:"请输入交易名",
				rangelength:"交易名长度1到20之间",
				remote:"交易名已存在"
			},
			url:{
				required:"请输入交易URL"
			},
			transStatus:{
				required:"请输入交易状态"
			},
			validateFlag:{
				required:"请输入交易有效标志"
			},
			moduleCode:{
				required:"请选择对应的模块编码"
			}
		}
	});
}); 
*/
 
 //初始化交易的datagrid列表
$('#transTable').datagrid({    
	//url:'${ctx}/base/trans/transByMultiModuleAndPage',
	toolbar: '#transTool',
	pageSize:15,
    pageList:[10,15,20,30,40,50],
    fitColumns:true,
    nowrap: false,
	type : 'POST',
    queryParams : {
		moduleCode: "moduleCode"
    },
    onLoadSuccess: function(data){
     	 if(data.total==0){
     		 $.messager.show({
     				title:'消息',
     				msg:'没有相关的交易记录。',
     				timeout:5000,
     				showType:'slide'
     			});
     	 }
      },
      onLoadError: function(){
     	 $.messager.alert('错误信息','交易信息查询失败!','error');
      },
	columns:[[        
	          {field:'transCode',title:'交易编码',align:'center'},     
	          {field:'transName',title:'交易名称',align:'center'},    
	          {field:'url',title:'交易URL',align:'center'},          
	          {field:'moduleCode',title:'所属模块',align:'center',		
	          	formatter : function(value, row, index) {
	          		var node = $('#moduleTree').tree('find', value);
	          		return node.text;
	  			} 	            
	          },
	          {field:'transStatus',title:'交易状态',align:'center',     
	        	  formatter:function(value,rec){
                      if(value=='0'){
                          return '<span>停用</span>';
                      }else{
                          return '<span>启用</span>';
                      }
                  }},    
	        {field:'opation',title:'操作',align:'center',         
				formatter : function(value, row, index) {
					var opt='';
					opt += '<button onclick="updateTrans('+index +')" class="easyui-linkbutton">修改交易</button>';
					opt +='&nbsp;&nbsp;';
					opt += '<button onclick="deleteTrans('+index +')" class="easyui-linkbutton">删除交易</button>';
					opt +='&nbsp;&nbsp;';
					opt += '<button onclick="getRoles('+index +')" class="easyui-linkbutton">查看所属角色</button>';
					return opt;
				} 
	        }
    ]]
});

//根据模块树上节点的getChecked情况，获取所有被选中的模块节点下的交易并形成datagrid列表
$("#moduleTree").tree({
	onClick:function(node){	
		$('#transTable').datagrid('load',{    
			moduleCodes : node.id
		});
	},
	onCheck:function(node){
		var nodes = $('#moduleTree').tree('getChecked');
		var codes = "";
		if(nodes.length>0) {
			for(var i=0; i<nodes.length; i++){
				codes = (codes + nodes[i].id) + (((i + 1)== nodes.length) ? '':','); 
			}
			$('#transTable').datagrid('options').url = '${ctx}/base/trans/transByMultiModuleAndPage';
			$('#transTable').datagrid('load',{    
				moduleCodes : codes
			});
		} else {
			$('#transTable').datagrid('loadData', { total: 0, rows: [] });
		}
	}
});

//在Form表单中添加交易（现在版本采用ajax请求）
function addTrans()
{
	$('#transTable').datagrid('uncheckAll'); 
	$('#transPanel').dialog({
		title : '添加交易信息',
		modal : true,
		closed: false,		
		onBeforeClose:function(){
			$('#transForm').form('clear');
		}, 
	 	buttons : [{
			text : '保存',
			handler : function(){
				if(!$('#transForm').form('validate')){
					$.messager.alert('提示','请补充必填信息后方可添加交易！','error');
					return;
				}
				$.ajax({   
					url:'${ctx}/base/trans/add', 
					type : 'POST',
					data:{
						transCode:$('#transCode').val(),
						transName:$('#transName').val(),
				   		url:$('#url').val(),
				   		transStatus:$("#transStatus").combobox('getValue'),
				   		validateFlag:$("#validateFlag").combobox('getValue'),
				   		moduleCode:$("#moduleCode").combotree('getValue')
					},
					success : function(data, status) {
						$('#transPanel').dialog('close');
						$('#transTable').datagrid('reload');
						var result = data.status;
						if(result=="success") {
							$.messager.show({
								title:'消息',
								msg:'添加成功！',
								timeout:5000,
								showType:'slide'
							});  
						} else {
							$.messager.alert('温馨提示','添加交易失败，请检查相关的输入条件');
						}
 
					}
				});
			}
		},{
			text : '取消',
			handler : function(){
				$('#transPanel').dialog('close');
			}
		}]  
	});   //end of dialog	
	
	$("#transCode").removeAttr("disabled");
	$("#transStatus").combobox('setValue','1');
    $("#transStatus").combobox({
        editable:false
    });
	$("#validateFlag").combobox('setValue','1');
	
	//添加交易时把选中的左侧模块树叶子节点名带过来
	var node = $('#moduleTree').tree('getSelected');
	if(node && $('#moduleTree').tree('isLeaf',node.target)) {
		$("#moduleCode").combotree('setValue', node.id);
	} 
	$('#transForm').form('validate');
}
 
//对选中的交易进行修改更新
function updateTrans(rowId)
{
	$('#transTable').datagrid('selectRow', rowId);
	var node = $('#transTable').datagrid('getSelected');
	$('#transPanel').dialog({
		title : '修改交易信息',
		modal: true,
		closed:false,	
		url : '${ctx}/base/trans/update',
		onBeforeClose:function(){
			$('#transForm').form('clear');
		},
		buttons : [{
			text : '更新',
			handler : function() {
				if(!$('#transForm').form('validate')){
					$.messager.alert('提示','请按要求填写信息！','error');
					return ;
				}
				$.ajax({     
					url:'${ctx}/base/trans/update',
					type: 'POST',
					data:{
						transCode:$('#transCode').val(),
						transName:$('#transName').val(),
				   		url:$('#url').val(),
				   		transStatus:$("#transStatus").combobox('getValue'),
				   		validateFlag:$("#validateFlag").combobox('getValue'),
				   		moduleCode:$("#moduleCode").combotree('getValue')
					},
					success:function(data){
						$('#transPanel').dialog('close');
						$('#transTable').datagrid('reload');
						var result = data.status;
						if(result=="success") {
							$.messager.show({
								title:'消息',
								msg:'更新成功！',
								timeout:5000,
								showType:'slide'
							});  
						} else {
							$.messager.alert('温馨提示','交易更新失败，请检查相关的输入条件');
						}
 
					}
				});
			}
		},{
			text:'取消',
			handler : function(){
				$('#transPanel').dialog('close');
			}
		} ]
	});
	$("#transCode").val(node.transCode);
	$("#transName").val(node.transName);
	$("#url").val(node.url);
	$("#transStatus").combobox('setValue',node.transStatus);
	$("#validateFlag").combobox('setValue',node.validateFlag);
	$("#moduleCode").combotree('setValue', node.moduleCode);
	$('#transForm').form('validate');
	$("#transCode").attr('disabled','disabled');
};

//删除交易
function deleteTrans(rowId)
{
	$('#transTable').datagrid('selectRow', rowId);
	var node = $('#transTable').datagrid('getSelected');
	if(node) {
		$.messager.confirm('确认','确定删除当前选择的交易信息?',function(r){   
	        if (r) {
	            $.ajax({
	                type : 'POST',
	                async: true,
	                url : '${ctx}/base/trans/delete',
	                data : {
	                    transCode:node.transCode
	                },
	                success : function(data, status) {
	                	var result = data.status; 
	                	if(result == 'success') {
	                		$.messager.show({
		                        title:'消息',
		                        msg:'删除成功！',
		                        timeout:5000,
		                        showType:'slide'
		                    });
		                    $('#transTable').datagrid('reload');
	                	} else {
	                		$.messager.alert('温馨提示','删除交易失败！');
	                	}
	                }
	            });
	        } else {
	        	return;
	        }
		});  
	} else
		$.messager.alert('提示','请选中一条记录！','error');
}

//添加交易时需选择相应的模块，用来验证选中模块是否为叶节点，且只有叶节点才能进行交易的添加操作
$('#moduleCode').combotree({
	onClick: function(node){
		modulecode=null;
		var table = $('#transTable').datagrid('getSelected');
		if(table!=null){
			moduleCode=table.moduleCode;
		}
		else{
			moduleCode=null;
		}
		if($('#transModule').tree('isLeaf',node.target)){
		}
		else{
			$.messager.alert('提示','&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择叶子模块节点，'
					+ '<br>'+'&nbsp;&nbsp;&nbsp;&nbsp;非叶子模块节点不能添加交易！','warning');
			$('#moduleCode').combotree('setValue',moduleCode);
			moduleCode=null;
			table=null;
		}
	}
});

//交易的添加修改窗口是可关闭的
$('#transPanel').dialog({ 
	closed:true
}); 

//添加或者删除交易后，刷新交易列表
function dataRefresh(){
	$('#transTable').datagrid('reload');
}

//隐藏交易有效标志位，默认该项插入数据库中的值全部为1
$('#transValidateFlag').hide();

//获取角色列表
function getRoles(row){
	$('#transTable').datagrid('selectRow', row);
	var node = $('#transTable').datagrid('getSelected');
	$("[id^='"+PREFIX_ROLE_LIST_MODULE+"']").remove();
	$('#roleDialog').window('open');
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/trans/getRoles',
		data : {
			transCode: node.transCode
		},
		success : function(data, status) {
			if(data && data.length>0){
				createContent(data);
			}else{
				$.messager.show({
					title:'提示信息',
					msg: '角色信息列表为空！<br/>',
					timeout:5000,
					showType:'slide'
				});
			}
		},
		error : function(data, status) {
			$.messager.show({
				title:'错误信息',
				msg: '获取角色信息列表失败！<br/>',
				timeout:5000,
				showType:'slide'
			});
		},
		datatype : "json"
	});
}

function createContent(data){
	if(!data){
		return;
	}
	var i=0;
	var j=0;
	while(j<data.length){
		if(data[i].orgCode==data[j].orgCode){
			j++;
		}else{
			create(data,i,j);
			i=j;
		}
	}
	create(data,i,j);
	return;	
}
function create(data,i,j){
	var prefix1 = PREFIX_ROLE_LIST_MODULE+data[i].orgCode;
	
	var treeNode = $('#orgTree').tree('find', data[i].orgCode);
	var orgName = "";
	if(treeNode){
		 orgName = getOrgName(treeNode);
	}
	if(orgName==null || orgName=='') {
		orgName = data[i].orgCode;
	}
	var trId = prefix1 + 'TR';
	var part1 = '<tr id="'+trId+'" style="height:40px;">'
					+'<td id="'+prefix1+'_TD" colspan="4" class="my_td_label">'
						+orgName+'&nbsp;'
					+'</td></tr>';
	if(!$('#'+trId).length>0){
		$('#appendBeforeThis').before(part1);
	} else {
		$('#'+trId).replaceWith(part1);
	}
	var part2 = '';
	var count = 0;
	var length = j-i;
	while(i<j){
		trId = prefix1+'TR'+(count/4);
		if(count==0){
			part2 = '<tr id="'+trId+'">';
		} else if(count%4==0){
			part2 += '</tr>';
			if(!$('#'+trId).length>0){
				$('#appendBeforeThis').before(part2);
			} else {
				$('#'+trId).replaceWith(part2);
			}
			part2 = '<tr id="'+trId+'">';
		}
		part2 += '<td id="'+prefix1+'_TD'+i+'" style="width:25%; font-size:13px">'
		+'<input type="checkbox" value="on" checked="checked" disabled="disabled" />'+ data[i].roleName + '</td>';
		count++;
		i++;
	}
	if(length%4 != 0){
		trId = prefix1 + 'TR' + (length/4);
		while(length%4!=0){
			part2 += '<td id="' + prefix1 + '_TD' + length + '" style="width:25%; font-size:13px" ></td>';
			length++;
		}
	}
	part2 += '</tr>';
	if(!$('#'+trId).length>0){
		$('#appendBeforeThis').before(part2);
	} else {
		$('#'+trId).replaceWith(part2);
	}
	// 展现内容
	$("[id^='"+prefix1+"']").show();
}

//获取组织机构名称
function getOrgName(node){
	var parentNode = $('#orgTree').tree('getParent', node.target);
	if(parentNode){
		return getOrgName(parentNode)+"->"+node.attributes.orgName;
	} else {
		return node.attributes.orgName;
	}
}

</script>
</body>
</html>