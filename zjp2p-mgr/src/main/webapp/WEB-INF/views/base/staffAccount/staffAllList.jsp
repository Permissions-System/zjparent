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

#staffForm {
	margin:10 30 0 10
}
#PWDPanel tr, #staffForm tr{
    height: 40px;
} 
#PWDPanel label, #staffForm td{
    padding-left:60px;
    padding-top:20px;
} 
    
#staffForm input, .easyui-combobox,.easyui-combotree{
 	width:180px;
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">

	
	<!-- begin 人员列表 -->
	<div data-options="region:'center',border:false,fit:true" title="人员列表" >		
		<!-- 列表页  -->
		<table id="staffTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"></table>
		
		<!-- begin 工具栏  -->
		<div id="staffTool">
			<a href="javascript:void(0)" id="staffRefresh" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
			<a href="javascript:void(0)" id="staffAdd" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">增加员工</a>
			<a href="javascript:void(0)" id="staffDelete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除员工</a>
			<!-- <input id="searchC" class="easyui-searchbox" data-options="prompt:'员工姓名',searcher:doSearch" style="width:200px;padding-top:10px"></input> -->		
			<input id="condition" class="easyui-validatebox" style="width:200px" placeholder="员工姓名" data-options="validType:['nameValid','length[0,20]']">
			<input id="ChannelCodeTwo" class="easyui-validatebox" style="width:200px" placeholder="渠道编号" data-options="validType:['nameValid','length[0,20]']">
	 		<a href="javascript:doSearchTwo();" id="search" class="easyui-linkbutton" iconCls="icon-search" data-options="plain:true">搜索</a>	
		</div>
		<!-- end 工具栏  -->
	</div>
	<!-- end 人员列表 --> 
	
	<!-- begin 添加修改员工信息 -->
	<div id="staffPanel">
		<form id="staffForm" method="post">
		<table>
			<tr style="display: none">
	   			<td><label>人员编号:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="staffNo" name="staffNo"></input></td>
	   		</tr>
	   		<tr>
	   			<td><label>用户姓名:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true,validType:'length[1,30]'"></input></td><!-- validType:['nameValid','length[1,20]'] -->
	   		</tr>
	   		<tr>
	   			<td><label>登陆名:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="identNo" name="identNo" data-options="required:true,validType:['id','idExist']" ></td>
	   		</tr>
	   		<tr id="inputPWD">
	   			<td><label>设置密码:</label></td>
	   			<td><input class="easyui-validatebox" type="password" id="plainPassword" name="plainPassword" data-options="required:true,validType:'length[6,20]'"></td><!--  -->
	   		</tr>
	   		<tr id="confirmPWD">
	   			<td><label>密码确认:</label></td>
	   			<td><input class="easyui-validatebox" type="password" id="plainPasswordConfirm" name="plainPasswordConfirm" data-options="required:true,validType:'length[6,20]'"></td><!--  -->
	   		</tr>
	   		<tr>
	   			<td><label>所属机构:</label></td>
	   			<td>
	   				<%-- <input class="easyui-combotree" type="text" id="orgCode" name="orgCode" data-options="url:'${ctx}/base/org/orgTree?timeid='+Math.random(),required:true,editable:true,disabled:false"> --%>
	   				<select id="orgCode" name="orgCode" panelHeight="auto" class="easyui-combobox" data-options="editable:false,disabled:true">
		   				<option value="014000" selected="selected">渠道商</option>
			   		</select>
	   			</td><!--  -->
	   		</tr>	   		
	   		<tr>
	   			<td><label>电话:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="tel" name="tel" data-options="validType:'checkPhoneNum'"></td><!-- 具体格式待改 -->
	   		</tr>
	   		<tr>
	   			<td><label>E-mail:</label></td>
	   			<td><input class="easyui-validatebox" type="text" id="email" name="email" data-options="validType:['email','length[0,32]']" ></td><!-- 具体格式待改-->
	   		</tr>
	   		<tr>
	   			<td><label>员工类型:</label></td>
	   			<td>
	   				<!-- editable:false,disabled:true 不可编辑并遮掩 -->
	   				<!-- required:true,editable:true,disabled:false 可编辑并不遮掩 -->
		   			<select id="staffType" name="staffType" panelHeight="auto" class="easyui-combobox" data-options="editable:false,disabled:true">
		   				<option value="4" selected="selected">市场部渠道商</option>
			   			<%-- <c:forEach items="${selects.STAFF_TYPE}" var="type"><!-- STAFF_TYPE -->
			   				<option value="${type.configCode}">${type.configName}</option>
			   			</c:forEach> --%>
			   		</select>	
		   		</td>
	   		</tr>
	   		<tr>
	   			<td><label>员工状态:</label></td>
	   			<td>
		   			<select id="staffStatus" name="staffStatus" panelHeight="auto" class="easyui-combobox" panelHeight="auto" data-options="required:true,editable:false">
			   			<c:forEach items="${selects.STAFF_STATUS}" var="type">
			   				<option value="${type.configCode}">${type.configName}</option>
			   			</c:forEach>
			   		</select>
		   		</td>
	   		</tr>
	   		<tr>
	   			<td><label>渠道编号:</label></td>
	   			<td>
	   				<!-- <input class="easyui-validatebox" type="text" id="channelCode" name="channelCode" data-options="validType:['channelCode','length[1,20]']" > -->
	   				<input class="easyui-validatebox" type="text" id="channelCode" name="channelCode" data-options="required:true,validType:['id','channelCode']" >
	   			</td>
	   		</tr>
	   		</table>
		</form>
	</div>
	<!-- end 添加修改员工信息 -->
	
	<!-- begin 重置密码 -->
	<div id="PWDPanel" style="width:350px;height:230px;padding:10px 0px 10px 30px">
		<form id="PWDForm">
		<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
			<tr style="display: none">
	   			<td><label>人员编号:</label></td>
	   			<td><input class="easyui-validatebox" style="width:155px;" type="text" id="staffNoPWD" name="staffNo" ></td>
	   		</tr>
	   		<tr>
	   			<td><label>设置密码:</label></td>
	   			<td><input class="easyui-validatebox" style="width:155px;" type="password" id="resetPWD" name="plainPassword" data-options="required:true,validType:'length[6,20]'" ></td>
	   		</tr>
	   		<tr>
	   			<td><label>密码确认:</label></td>
	   			<td><input class="easyui-validatebox" style="width:155px;" type="password" id="resetPWDConfirm" data-options="required:true,validType:'length[6,20]'" /></td>
	   		</tr>
	   	</table>
		</form>
	</div>
	<!-- end 重置密码 -->
	
	<!-- begin 设置角色 -->
	<div id="staffRightWindow" class="easyui-window" title="配置员工角色" data-options="maximized:true,modal:true,closed:true">
	    <div class="easyui-layout" data-options="fit:true">
		    <div data-options="region:'west',split:true, title:'组织机构'" style="width:300px">
				<ul id="orgTree"></ul>
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
		    		</tbody>
		    	</table>
		    </div>
	    </div>
    </div>
    <!-- end 设置角色 -->
	
	<!-- begin 查看权限 -->
    <div id="transDialog" class="easyui-window" title="权限列表 " 
		data-options="closed: true,maximized:true,resizable:true,modal:true">
		<table id="transTable" style="width: 100%;" border="0" cellpadding="2" cellspacing="3" align="center">
		   	<tbody>
			   	<tr id="appendAfterThis1">
			   	</tr>
			   	<tr id="appendBeforeThis1">
			    </tr>
		   	<tbody>
		</table>
	</div>
	 <!-- end 查看权限 -->
	 
	<!-- begin 查看角色人员信息 -->
	<div id="qudaoUser" class="easyui-dialog" style="width:900px;height:400px;"
        data-options="resizable:false,modal:true,title:'查看渠道用户信息'" closed="true">
		<table id="qudaoUserTable" ></table>
	</div>
	<!-- end 查看角色人员信息 -->
	
	<div id="moduleTree"></div>

</div>


<script type="text/javascript">          
/* 注意：
1、要求动态生成的页面元素id、name都以"STAFF_LIST_ROLE_"开头，以便统一控制
2、功能上还缺少组织机构角色按组织机构顺序插入的处理,可以考虑使用占位符的方式解决
*/ 
var PREFIX_STAFF_LIST_ROLE = "STAFF_LIST_ROLE_";
var SUFFIX_CHECK_BOX = "_CHECKBOX";// checkBox元素ID后缀 
var SUFFIX_CHECK_ALL_BUTTON = "_CHECK_ALL_BUTTON";// 全选按钮元素后缀名
var SUFFIX_INVERSE_BUTTON = "_INVERSE_BUTTON";// 反选按钮元素后缀名
var STAFF_TYPE_DEFAULT = '4';//新增默认为市场部渠道商
var STAFF_STATUS_DEFAULT = '1';//默认已激活
var PREFIX_ROLE_LIST_MODULE = "ROLE_LIST_MODULE_";// 模块交易相关元素ID前缀

$('#staffTable').datagrid({ 
	width:300,
	toolbar: '#staffTool',
	pageSize:20,	
	columns:[[        
        {field:'name',title:'用户姓名'},
        {field:'identNo',title:'登陆名'},
        {field:'tel',title:'电话'}, 
        {field:'email',title:'邮箱'},
        {field:'channelCode',title:'渠道编号'},
        {field:'staffType',title:'员工类型',
        	formatter : function(value, row, index) 
        	{        	    
        		var type = $('#staffType').combobox('getData');
        		for(i in type)
        		{
        			if(type[i].value==value)
        				return type[i].text;
        		}
        		
			} 	 
        },
        {field:'staffStatus',title:'员工状态',
        	formatter : function(value, row, index) {        	    
        		var type = $('#staffStatus').combobox('getData');
        		for(i in type){
        			if(type[i].value==value)
        				return type[i].text;
        		}
			}  
        },
        {field:'createDate',title:'创建时间'},
        {field:'opation',title:'操作',align:'center',
			formatter : function(value, row, index) {
				var opt='';
				opt += '<button onclick="updateStaff('+index +')" class="easyui-linkbutton">修改信息</button>'; 
				opt += '<button onclick="resetPass('+index +')" class="easyui-linkbutton">重置密码</button>';
				/* opt += '<button onclick="setStaffRole('+index +')" class="easyui-linkbutton">设置角色</button>'; */
				/* opt += '<button onclick="getTrans('+index +')" class="easyui-linkbutton">查看权限</button>';  */
				/* opt += '<button onclick="getQuDaoUsers('+index +')" class="easyui-linkbutton">查看渠道用户</button>'; */
				/* opt += '<button onclick="setStaffRole('+index +')" class="easyui-linkbutton">设置角色</button>'; */
				opt += '<button onclick="getTrans('+index +')" class="easyui-linkbutton">查看权限</button>';
				opt += '<button onclick="getQuDaoUsers('+index +')" class="easyui-linkbutton">查看渠道用户</button>';
				return opt;
			} 
        }
    ]]
	
});

$.extend($.fn.validatebox.defaults.rules, {    
	/*id:{        
		validator : function(value) {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message : '身份证号码格式不正确'
	},*/
	nameValid: {
		validator: function(value, param){
			var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
			return !p.test(value);
		},
		message: '名称应由数字、字母、中文字符、下划线或括号组成'
	},
	checkPhoneNum: {
		validator: function(value, param){
			var p = /^1[3|4|5|8][0-9]\d{8}$/;
			return p.test(value);
		},
		message: '请输入正确的手机号码！'
	},
	idExist:{
		validator :function(value){
			var result;
			$.ajax({
				async:false,
				type:'POST',
				url:'${ctx}/base/staff/check',
				data:{
					identNo:$('#identNo').val()
				},
				success:function(data,status){
					result = data;
				}
			});
			return result;
		},
		message:'登陆名已存在'
	},
	channelCodeExist:{
		validator :function(value){
			var result;
			//var aa = $('#staffNo').val();
			//var bb = $('#channelCode').val();
			//alert('staffNo='+aa + "\t" + 'channelCode='+bb);
			$.ajax({
				async:false,
				type:'POST',
				url:'${ctx}/base/staff/updateCheckChannelCode',
				data:{
					channelCode:$('#channelCode').val(),
					staffNo:$('#staffNo').val()
				},
				success:function(data,status){
					result = data;
				}
			});
			return result;
		},
		message:'渠道商编号已存在'
	}
});

//页面加载
$(function() {
	var codes='014000';
	//var ChannelCode='';
	//选中组织结构中的菜单时，触发 
	$('#staffTable').datagrid('options').url = '${ctx}/base/staff/staffByOrgListTwo';
	$('#staffTable').datagrid('load',{    
		orgCode : codes
		//ChannelCode : ChannelCode
	});
}); 


/**
 * 查看通过渠道商注册的用户 
 */
 function getQuDaoUsers(rowId){
		$('#staffTable').datagrid('selectRow', rowId);
		var node = $('#staffTable').datagrid('getSelected');
		$('#qudaoUser').dialog('open');
		
		
		$('#qudaoUserTable').datagrid({
			url:'${ctx}/lendInfo/listByQuDaoPage',
			queryParams: {
				promoCode:node.channelCode
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
		        {field:'mobile',title:'手机号', width:120},        
		        {field:'temp1',title:'注册时间',width:120},
		        {field:'hasfuiou',title:'是否开户',width:120,
		        	formatter: function(value, row, index)
		        	{
		        		var result;
		        		if(value==0)
		        		{
		        			result="未开户";
		        		}
		        		else if(value==1)
		        		{
		        			result="已开户";
		        		}
		        		else
		        		{
		        			result="未知";
		        		}
		        		return result;
		        	}
		        },
		        {field:'lendmoney',title:'投资总金额',width:140,
		        	formatter: function(num, row, index)
		        	{
		        		var result;
		        		if(num!=null && num!='')
		        		{
		        			num = num.toString().replace(/\$|\,/g,'');
		        			if(isNaN(num))
		        			num = "0";
		        			sign = (num == (num = Math.abs(num)));
		        			num = Math.floor(num*100+0.50000000001);
		        			cents = num%100;
		        			num = Math.floor(num/100).toString();
		        			if(cents<10)
		        			cents = "0" + cents;
		        			for (var i = 0; i < Math.floor((num.length-(1+i))/3); i++)
		        			num = num.substring(0,num.length-(4*i+3))+','+
		        			num.substring(num.length-(4*i+3));
		        			 result = (((sign)?'':'-') + num + '.' + cents);
		        		}
		        		else
		        		{
		        			result = "0.00";
		        		}
		        		return result;
		        	}
		        },  
		        {field:'lenddate',title:'最后一次投资时间',width:100,
		        	formatter: function (val, row, index) 
		        	{
			        	if(val!=null && val!="")
			        	{
				        	var d =new Date(val).format('yyyy-MM-dd hh:mm:ss');
				        	return d;
			        	}
			        	else
			        	{
			        		return null;
		        		}	
		        	}
		        }
		    ]]
		});
	};
function getQuDaoUsers2(rowId)
{
	var channelCode,str,node,channelCode;
	
	$('#staffTable').datagrid('selectRow', rowId);
	node = $('#staffTable').datagrid('getSelected');
	if(node!=null)
	{
		channelCode = node.channelCode;
		str = "/lendInfo/two/index";
		window.location.href=ctx+str+"?channelCode="+channelCode;
	}
	else
	{
		alert("node为空 ");
	}
}


/**
 * 关闭对话框 
 */
$('#staffPanel').dialog({ 
	closed:true
}); 

/**
 * 刷新
 */
$('#staffRefresh').click(function(){
	$('#staffTable').datagrid('reload');
});



/**
 * 搜索 
 */
function doSearch(value){
	var ChannelCode=''; 
	var a = $('#searchC').searchbox('textbox');
	a.validatebox({
		required:false,
		validType:['length[0,15]','nameValid']
	}); 
	if(!a.validatebox('isValid'))
		return;
	
	$('#staffTable').datagrid('options').url = '${ctx}/base/staff/searchTwo';
	$('#staffTable').datagrid('load',{
		condition:value,
		ChannelCode : ChannelCode 
	});
}
function doSearchTwo(){
	var condition,ChannelCode;
	condition = $("#condition").val();
	ChannelCode = $("#ChannelCodeTwo").val();
	$('#staffTable').datagrid('options').url = '${ctx}/base/staff/searchTwo';
	$('#staffTable').datagrid('load',{
		condition:condition,
		ChannelCode:ChannelCode
	});
}

$('#staffAdd').click(function(){
	$('#staffPanel').dialog({
		title : '添加员工信息',
		modal : true,
		closed: false,
		width: 530,
		height: 500,
		onBeforeClose:function(){
			$('#staffForm').form('clear');
		},
	 	buttons : [{
			text : '添加',
			handler : function(){
				if(!$('#staffForm').form('validate')){
					$.messager.alert('提示','请补充必填信息！','error');
					return;
				}  
				
				if(!($('#plainPassword').val()==$('#plainPasswordConfirm').val())){
					$.messager.alert('提示','两次密码不同，请重新输入！','error');
					return;
				}
				
				$.ajax({    
					url:'${ctx}/base/staff/add',    
					type : 'POST',
					data:{
						staffNo:$('#staffNo').val(),        
						orgCode:$("#orgCode").combobox('getValue'),
						name:$('#name').val(),
						identNo:$('#identNo').val(),
						tel:$('#tel').val(),    
						email:$('#email').val(),     
						staffStatus:$('#staffStatus').combobox('getValue'),
						staffType:$('#staffType').combobox('getValue'),
						createDate:$('#createDate').val(), 
						plainPassword:$("#plainPassword").val(),
						channelCode:$("#channelCode").val()
						
					},
					success:function(data){
						if(data.status=="SUCCESS"){
							$('#staffPanel').dialog('close');
							$('#staffTable').datagrid('reload');
							$.messager.show({
								title:'消息',
								msg:'添加成功！',
								timeout:5000,
								showType:'slide'
							});   
							if(data.msg!=null && data.msg!=''){
								$.messager.alert('.net错误', data.msg);
							}
						}else{
							var errMsgs="请修复以下错误：<br>";
							var err = data.result.split(',');
							for(var i in err)
								errMsgs += err[i] + '<br>';
							var height = 75 + err.length*25;
							$.messager.show({
								title:'错误',
								msg:errMsgs,
								height:height,
								timeout:5000,
								showType:'slide'
							}); 
						}
					}
				});
			}
		},{
			text : '取消',
			handler : function(){
				$('#staffPanel').dialog('close');
			}
		}]  
	});//end of dialog			
	
	var node = $('#staffOrg').tree('getSelected');
	/*
	所属机构为tree展示类型 
	if(node)
	{
		$("#orgCode").combotree('setValue', node.id);
	} */
	$('#orgCode').combobox('setValue', '014000');//所属机构 定死 
	$('#staffType').combobox('setValue', STAFF_TYPE_DEFAULT);
	$('#staffStatus').combobox('setValue', STAFF_STATUS_DEFAULT);
	$("#inputPWD").show();
    $("#confirmPWD").show();
    $("#plainPassword").removeAttr('disabled');
    $("#plainPasswordConfirm").removeAttr('disabled');
    $('#identNo').removeAttr('disabled');
    $('#plainPassword').validatebox({required: true,validType:['length[6,20]']});
    $('#plainPasswordConfirm').validatebox({required: true,validType:['length[6,20]']});
	$('#staffForm').form('validate');
	$('#identNo').validatebox({    
		required: true,    
    	validType: ['id','idExist']
	});		
	$('#channelCode').removeAttr('disabled');
	$('#channelCode').validatebox({    
		required: true,    
    	validType: ['id','channelCodeExist']
	});
});

function updateStaff(rowId){
	$('#staffTable').datagrid('selectRow', rowId);
	$('#staffPanel').dialog({
		title : '修改员工信息',
		modal: true,
		closed:false,
		width: 530,
		height: 500,
		onBeforeClose:function(){
			$('#staffForm').form('clear');
		},
		buttons : [{
			text : '更新',
			handler : function() {
				if(!$('#staffForm').form('validate')){
					$.messager.alert('提示','请补充必填信息！','error');
					return;
				}	
				
				$.ajax({    
					url:'${ctx}/base/staff/update',
					type:'POST',
					data:{
						staffNo:$('#staffNo').val(),        
						orgCode:$("#orgCode").combobox('getValue'),
						name:$('#name').val(),
						identNo:$('#identNo').val(),
						tel:$('#tel').val(),    
						email:$('#email').val(),     
						staffStatus:$('#staffStatus').combobox('getValue'),
						staffType:$('#staffType').combobox('getValue'),
						channelCode:$("#channelCode").val()
					},
					success:function(data){
						if(data.status=="SUCCESS"){
							$.messager.show({
								title:'消息',
								msg:'更新成功！',
								timeout:5000,
								showType:'slide'
							});
							if(data.msg!=null && data.msg!=''){
								$.messager.alert('.net错误', data.msg);
							}
							$('#staffPanel').dialog('close');
							$('#staffTable').datagrid('reload');
						} else {
							$.messager.alert('错误',data.result,'error');
						}
						
					}
				});
			}
		},{
			text:'取消',
			handler : function(){
				$('#staffPanel').dialog('close');
			}
		}]
	});
	
	var node = $('#staffTable').datagrid('getSelected');
	$('#staffNo').val(node.staffNo);        
	$("#orgCode").combobox('setValue', node.orgCode);
    $('#name').val(node.name);
    $('#identNo').val(node.identNo);
    $('#tel').val(node.tel);    
    $('#email').val(node.email);        
    $('#staffStatus').combobox('setValue', node.staffStatus);
    $('#staffType').combobox('setValue', node.staffType);
    $('#createDate').val(node.createDate);
    $('#staffNoPWD').val(node.staffNo); 
    $('#channelCode').val(node.channelCode);
    $('#identNo').validatebox({    required: false,    
    	validType: []});
    $('#channelCode').validatebox({    required: false,    
    	validType: []});
    $('#plainPassword').validatebox({required: false});
    $('#plainPasswordConfirm').validatebox({required: false});
    $('#staffForm').form('validate'); 
    $("#plainPasswordConfirm").attr('disabled','true');
    $("#plainPassword").attr('disabled','true');
    $("#inputPWD").hide();
    $("#confirmPWD").hide();
    $('#identNo').attr('disabled','true');	
    //$('#channelCode').attr('disabled','true');
    $('#channelCode').validatebox({    
		required: true,    
    	validType: ['id','channelCodeExist']
	});
};

function resetPass(row){
	$('#staffTable').datagrid('selectRow', row);
	var node = $('#staffTable').datagrid('getSelected');
	$('#staffNoPWD').val(node.staffNo); 
	$('#PWDPanel').dialog({
		title : '重置密码',
		modal: true,
		closed:false,
		width: 350,
		height: 200,
		onBeforeClose:function(){
			$('#PWDForm').form('clear');
		},
		buttons : [{
			text : '提交',
			handler : function() {
				if(!$('#PWDForm').form('validate')){
					$.messager.alert('提示','请补充必填信息！','error');
					return;
				}	
				if(!($('#resetPWD').val()==$('#resetPWDConfirm').val())){
					$.messager.alert('提示','两次密码不同，请重新输入！','error');
					return;
				}
				
				$.ajax({   
					type : 'POST',
					url: '${ctx}/base/staff/resetPWD',
					data:{
						staffNo:$('#staffNoPWD').val(),
						plainPassword:$("#resetPWD").val()
					},
					success:function(data){
						if(data.status=="SUCCESS"){
							$.messager.show({
								title:'消息',
								msg:'更新成功！',
								timeout:5000,
								showType:'slide'
							});
							$('#PWDPanel').dialog('close');
							$('#resetPWD').attr('disable','true');
							$("#resetPWDConfirm").attr('disable','true');
						} else {
							$.messager.alert('错误',data.result,'error');
						}
						
					}
				});
			}
		},{
			text:'取消',
			handler : function(){
				$('#PWDPanel').dialog('close');
			}
		}]
	});
	$('#resetPWD').removeAttr('disable');
	$("#resetPWDConfirm").removeAttr('disable');
}

$('#staffDelete').click(function(){
	var node = $('#staffTable').datagrid('getSelected');
	if(node)
	{
		$.messager.confirm('确认', '是否要删除员工"'+node.name+'"?', function(result){
			if (result){
				$.ajax({
					type : 'POST',
					async: true,
					url : '${ctx}/base/staff/delete',
					data : {
						staffNo:node.staffNo
					},
					success : function(data, status) {
							var selected = $('#staffTable').datagrid('getSelected'); 
							var index = $('#staffTable').datagrid('getRowIndex', selected);
							$('#staffTable').datagrid('deleteRow',index);
							$.messager.show({
								title:'消息',
								msg:'删除成功！',
								timeout:5000,
								showType:'slide'
							});
							if(data.msg!=null && data.msg!=''){
								$.messager.alert('.net错误', data.msg);
							}
					}//end of success
				});//end of ajax
			}
		});//end of confirm
	}else
		$.messager.alert('提示','请选中一条记录！','error');
});

//设置员工角色
function setStaffRole(rowId){
	// 选中当前点击员工记录	
	$('#staffTable').datagrid('selectRow', rowId);
	// 取消所有节点的勾选
	function uncheckAllSubTreeNode(node){
		var children = $('#orgTree').tree('getChildren', node.target);
		if(children && children.length>0){
			for(var i in children){
				uncheckAllSubTreeNode(children[i]);
				$('#orgTree').tree('uncheck', children[i].target);
			}
		}
	}
	var roots = $('#orgTree').tree('getRoots');
	for(var i in roots){
		uncheckAllSubTreeNode(roots[i]);
		$('#orgTree').tree('uncheck', roots[i].target);
	}
	// 清除原页面的信息
	$("[id^='"+PREFIX_STAFF_LIST_ROLE+"']").remove();
	//打开窗口
	$('#staffRightWindow').window('open');
	
	// 一次性查回角色拥有的所有权限信息
	var gridNode = $('#staffTable').datagrid('getSelected');
	if(true){
		jQuery.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/staff/getAllStaffRoleRelForCheck',
			data : {
				staffNo: gridNode.staffNo
			},
			success : function(data, status) {
				if(data.result && data.result.length>0){
					staffListOrgTreeEventSwitcher = false;
					for(var i in data.result){
						createCheckBox(data.result[i], data.result[i].roleList);
						// 勾选组织机构树节点
						var node = $('#orgTree').tree('find',data.result[i].orgCode);
						if(node){
							$('#orgTree').tree('check', node.target);
						}
					}
					staffListOrgTreeEventSwitcher = true;
					// 关闭进度条
				}
			},
			error : function(data, status) {
				jQuery.messager.alert('错误信息','获取员工角色数据失败！'+data.responseText,'error');
				// 关闭进度条
			},
			datatype : "json"
		});
	}
}

function createCheckBox(org, data){
	if(!org || !data || data.length==0){
		return;
	}
	var prefix1 = PREFIX_STAFF_LIST_ROLE+org.orgCode;
	
	var treeNode = $('#orgTree').tree('find', org.orgCode);
	var orgFullName = "";
	if(treeNode){
		 orgFullName = getModuleFullName(treeNode);
	}
	if(orgFullName==null || orgFullName=='') {
		orgFullName = org.orgName;
	}
	var prefix2 = prefix1+'_ROLE_';
	var trId = prefix1+'TR';
	var part1 = '<tr id="'+trId+'" style="height:40px;">'
				+'<td id="'+prefix1+'_TD" colspan="4" class="my_td_label">'
					+'<a id="'+prefix1+'" href="#'+prefix1+'" />'+orgFullName+'&nbsp;'
					+'<a id="'+prefix1+SUFFIX_CHECK_ALL_BUTTON+'" style="font-size:13px" >全选</a>'
					+'<a id="'+prefix1+SUFFIX_INVERSE_BUTTON+'" style="font-size:13px" >反选</a>'
				+'</td></tr>';
	if(!$('#'+trId).length>0){
		$('#appendBeforeThis').before(part1);
	} else {
		$("#"+trId).replaceWith(part1);
	}
	var part2 = "";
	for(var i in data){
		trId = prefix1 + 'TR' + (i/4);
		if(i==0){
			part2 = '<tr id="'+trId+'\">';
		} else if(i%4==0){
			part2 += "</tr>";
			if(!$('#'+trId).length>0){
				$('#appendBeforeThis').before(part2);
			} else {
				$('#'+trId).replaceWith(part2);
			}
			part2 = '<tr id="'+trId+'">';
		}
		part2 += '<td id="'+prefix1+'_TD'+i+'" style="width:25%; font-size:13px" >'
							+'<input type="checkbox" id="' + prefix2 + data[i].roleCode + SUFFIX_CHECK_BOX+'" value="' + data[i].roleCode + '"';
		if(data[i].checked==true){
			part2 += ' checked="checked"';
		}
		if(data[i].disabled==true){
			part2 += ' disabled="disabled" alt="您没有该角色分配权限" ';
		}
		part2 += '/>' + data[i].roleName + '</td>';
	}
	part2 += '</tr>';
	if(!$('#'+trId).length>0){
		//$('#checkBoxTable tbody').append(part2);
		$('#appendBeforeThis').before(part2);
	} else {
		$("#"+trId).replaceWith(part2);
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
	var parentNode = $('#orgTree').tree('getParent', node.target);
	if(parentNode){
		return getModuleFullName(parentNode)+"->"+node.attributes.orgName;
	} else {
		return node.attributes.orgName;
	}
}

function rightClickEventHandler(event){
	if(event.button==2){
		event.preventDefault();
		$('#checkBoxMenu').menu('show', {
			left: event.pageX,
			top: event.pageY
		});
	}
}

//组织机构树事件开关
var staffListOrgTreeEventSwitcher = true;

/**
 * 获取人员权限
 */
function getTrans(row){
	$('#staffTable').datagrid('selectRow', row);
	var node = $('#staffTable').datagrid('getSelected');
	$("[id^='"+PREFIX_ROLE_LIST_MODULE+"']").remove();
	$('#transDialog').window('open');
	$.ajax({
		type : 'POST',
		async: false,
		url : '${ctx}/base/staff/getTrans',
		data : {
			staffNo: node.staffNo
		},
		success : function(data, status) {
			if(data && data.length>0){
				createContent(data);
			}else{
				$.messager.show({
					title:'提示信息',
					msg: '人员权限信息为空！<br/>',
					timeout:5000,
					showType:'slide'
				});
			}
		},
		error : function(data, status) {
			$.messager.show({
				title:'错误信息',
				msg: '获取人员权限信息失败！<br/>',
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
		if(data[i].moduleCode==data[j].moduleCode){
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
	var prefix1 = PREFIX_ROLE_LIST_MODULE+data[i].moduleCode;
	
	var treeNode = $('#moduleTree').tree('find', data[i].moduleCode);
	var moduleName = "";
	if(treeNode){
		 moduleName = getModuleName(treeNode);
	}
	if(moduleName==null || moduleName=='') {
		moduleName = data[i].moduleCode;
	}
	var trId = prefix1 + 'TR';
	var part1 = '<tr id="'+trId+'" style="height:40px;">'
					+'<td id="'+prefix1+'_TD" colspan="4" class="my_td_label">'
						+moduleName+'&nbsp;'
					+'</td></tr>';
	if(!$('#'+trId).length>0){
		$('#appendBeforeThis1').before(part1);
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
				$('#appendBeforeThis1').before(part2);
			} else {
				$('#'+trId).replaceWith(part2);
			}
			part2 = '<tr id="'+trId+'">';
		}
		part2 += '<td id="'+prefix1+'_TD'+i+'" style="width:25%; font-size:13px">'
		+'<input type="checkbox" value="on" checked="checked" disabled="disabled" />'+ data[i].transName + '</td>';
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
		$('#appendBeforeThis1').before(part2);
	} else {
		$('#'+trId).replaceWith(part2);
	}
	// 展现内容
	$("[id^='"+prefix1+"']").show();
}

//获取模块名称
function getModuleName(node){
	var parentNode = $('#moduleTree').tree('getParent', node.target);
	if(parentNode){
		return getModuleName(parentNode)+"->"+node.attributes.moduleName;
	} else {
		return node.attributes.moduleName;
	}
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
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(!allCheckBox[i].disabled){
					allCheckBox[i].checked = allCheckBox[i].defaultChecked;
				}
			}
		}
	});
	$("[id^='saveBtn']").click(function(){
		var roleCodeArray = new Array();
		var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']:checkbox:checked");
		if(allCheckBox){
			for(var i in allCheckBox){
				if(allCheckBox[i].checked && allCheckBox[i].checked==true){
					roleCodeArray.push(allCheckBox[i].value);
				}
			}
		}
		var gridNode = $('#staffTable').datagrid('getSelected');
		// 提交数据
		jQuery.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/staff/updateStaffRoleRel',
			data : {
				staffNo: gridNode.staffNo,
				roleCodeArray: roleCodeArray.toString()
			},
			success : function(data, status) {
				$.messager.show({
					title:'提示信息',
					msg:'员工角色信息保存成功！',
					timeout:5000,
					showType:'slide'
				});
				$('#staffRightWindow').window('close');
			},
			error : function(data, status) {
				
				if(data && data.responseText){
				    jQuery.messager.alert('错误信息','保存失败:'+ (eval('('+data.responseText+')')).string,'error');
				}else{
					jQuery.messager.alert('错误信息','保存失败:','error');
				}
			}
		});
	});
	$("[id^='cancelBtn']").click(function(){
		$('#staffRightWindow').window('close');
	});
	
	$('#orgTree').tree({
		checkbox: true,
		cascadeCheck: false, //不级联勾选，因为父级节点也有角色信息
		animate:false,
		url:'${ctx}/base/org/orgTree',
		method:'post',
		onDblClick : function(node){
			// 叶子节点无需处理
			if($('#orgTree').tree('isLeaf', node.target)){
				return;
			}
			if(!node.state){
				
			} else if(node.state=='open'){
				$('#orgTree').tree('collapse', node.target);
			} else if(node.state=='closed') {
				$('#orgTree').tree('expand', node.target);
			}
		},
		
		onBeforeCheck: function(node, checked){
			var isLeaf = $('#orgTree').tree('isLeaf', node.target);
			// 如果事件控制器关闭，则不处理
			if(staffListOrgTreeEventSwitcher){
				var trId = PREFIX_STAFF_LIST_ROLE+node.attributes.orgCode;
				if(checked){
					// 勾选时，先检查组织机构下的交易是否已经查询到页面，如果已经查询到，则展现组织机构，否则从服务端加载数据并展现
					if($('#'+trId).length>0){
						$("[id^='"+trId+"']").show();
						// 回复原始勾选状态
						var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']", $("[id^='"+trId+"']"));
						if(allCheckBox){
							for(var i in allCheckBox){
								if(!allCheckBox[i].disabled){
									allCheckBox[i].checked = allCheckBox[i].defaultChecked;
								}
							}
						}
					} else { // if(isLeaf){ 
						var gridNode = $('#staffTable').datagrid('getSelected');
						// 数据库加载数据并显示
						jQuery.ajax({
							type : 'POST',
							async: false,
							url : '${ctx}/base/staff/getRoleByOrgCodeForCheck',
							data : {
								staffNo: gridNode.staffNo,
								orgCode: node.attributes.orgCode
							},
							success : function(data, status) {
								// 关闭进度条
								
								if(data.result && data.result.length>0){
									createCheckBox(node.attributes, data.result);
									// 激活按钮绑定动作
								}
							},
							error : function(data, status) {
								jQuery.messager.alert('错误信息','获取组织机构数据失败！'+data.responseText,'error');
								// 关闭进度条
							},
							datatype : "json"
						});
					} 
					if(!isLeaf) {
						var children = $('#orgTree').tree('getChildren',node.target);
						if(children && children.length>0){
							for(var i in children){
								$('#orgTree').tree('check',children[i].target);
							}
						}
					}
					// 如果从服务端加载数据来展现，则应按照正确的顺序插入 页面
				} else {
					// 取消勾选状态
					var needToHide = true;
					var allCheckBox = $("[id$='"+SUFFIX_CHECK_BOX+"']", $("[id^='"+trId+"']"));
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
						var children = $('#orgTree').tree('getChildren',node.target);
						if(children && children.length>0){
							for(var i in children){
								$('#orgTree').tree('uncheck',children[i].target);
							}
						}
					}
				}
			}
		},
		
		onSelect: function(node){
			// 使用隐藏点击动作
			if($('#'+PREFIX_STAFF_LIST_ROLE+node.attributes.orgCode).length>0){
				$('#'+PREFIX_STAFF_LIST_ROLE+node.attributes.orgCode).get(0).click();
			}
		}
	});
	
	$('#moduleTree').tree({
		checkbox: false,
		cascadeCheck: false, //级联勾选
		animate:false,
		url:'${ctx}/base/role/getModuleTree',
		method:'post'
	});
});

</script>
</body>
</html>