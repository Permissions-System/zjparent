<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
#editCreditRule tr{
	height:40px;
}
#editCreditRule td label
{
	text-align:right;
	padding-left:70px;	
} 
.easyui-validatebox,.easyui-combobox,.easyui-datetimebox{
	width:150px;
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:110px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post">
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label>动作:</label></td>
                    <td><input id="actionSearch" name="actionSearch" class="easyui-validatebox" data-options="validType:['actionValid','length[1,20]']"/></td>
                    <td><label>规则名称:</label></td>
                    <td><input id="ruleNameSearch" name="ruleNameSearch" class="easyui-validatebox" data-options="validType:['nameValid','length[1,20]']"/></td>
                    <td><label>周期类型:</label></td>
                    <td>
                        <select id="cycleTypeSearch" panelHeight="auto" name="cycleTypeSearch" class="easyui-combobox" style="width:155px;" data-option="required:false,editable:false">     
                            <option value="">全部</option>
                            <c:forEach items="${selects.CYCLE_TYPE_OT}" var="type">
				   				<option value="${type.configCode}">${type.configName}</option>
				   			</c:forEach>
                        </select>
                    </td>
                    <td>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
        <table id="creditRuleList">
        </table>
    </div>
</div>
<div id="editCreditRule">
<form>
<table>
	<tr style="display:none">
		<td><label>ruleId:</label></td>
		<td><input class="easyui-validatebox" type="text" id="ruleId"/></td>
	</tr>
	<tr>
		<td><label>动作:</label></td>
		<td><input class="easyui-validatebox" type="text" id="action" data-options="required:true,validType:['actionValid','length[4,100]']"/></td>
	</tr>
	<tr>
		<td><label>规则名称:</label></td>
		<td><input class="easyui-validatebox" type="text" id="ruleName" data-options="required:true,validType:['nameValid','length[4,30]']"/></td>
	</tr>
	<tr>
		<td><label>周期类型:</label></td>
		<td>
		<select id="cycleType" name="cycleType" class="easyui-combobox" data-options="required:true,editable:false,panelHeight:'auto'">
   			<c:forEach items="${selects.CYCLE_TYPE_OT}" var="type">
   				<option value="${type.configCode}">${type.configName}</option>
   			</c:forEach>
   		</select>	
		</td>
	</tr>
	<tr>
		<td><label>周期最多奖励次数:</label></td>
		<td><input class="easyui-validatebox" type="text" id="rewardNum" data-options="required:true,validType:['numberValid','length[0,8]']"/></td>
	</tr>
	<tr>
		<td><label>规则限制表达式:</label></td>
		<td><input class="easyui-validatebox" type="text" id="ruleLimit" title="此处设定规则限制表达式，表达式需要返回true/false，参数需以params开头，例：params.expense>233" class="easyui-tooltip" data-options="validType:['limitValid','length[0,1000]']"/></td>
	</tr>
	<tr>
		<td><label>积分计算表达式:</label></td>
		<td><input class="easyui-validatebox" type="text" id="credit" title="此处设定积分计算表达式，表达式需要返回一个整形数值，参数需以params为开头，例：(params.expense-100)/2" class="easyui-tooltip" data-options="required:true,validType:['creditValid','length[0,1000]']"/></td>
	</tr>
	<tr>
		<td><label>规则是否启用:</label></td>
		<td>
		<select class="easyui-combobox"  id="ruleEnabled" name="ruleEnabled" data-options="required:true,editable:false,panelHeight:'auto'">
   			<c:forEach items="${selects.YES_NO_FLAG}" var="type">
   				<option value="${type.configCode}">${type.configName}</option>
   			</c:forEach>
   		</select>	
		</td>
	</tr>
	<tr>
		<td><label>规则生效开始时间:</label></td>
		<td><input class="easyui-datetimebox" type="text" id="startTime" required="required" data-options="editable:false"/></td>
	</tr>
	<tr>
		<td><label>规则失效时间:</label></td>
		<td><input class="easyui-datetimebox" type="text" id="endTime" data-options="reqiured:true,editable:false"/></td>
	</tr>
</table>
</form>
</div>
<script type="text/javascript">
$('#creditRuleList').datagrid({    
	url:'${ctx}/base/creditRule/ot/list',  
	toolbar: '#toolbar',
	title:'联机规则管理',
	fit:true,
	fitColumns:true,
	singleSelect:true,
	checkOnSelect:false,
	pagination:true,
	rownumbers:true,
	columns:[[   
		 {field:'ruleId',title:'规则ID',hidden:true}, 
         {field:'action',title:'动作'},
         {field:'ruleName',title:'规则名称'},
         {field:'cycleType',title:'周期类型',
        	 formatter:function(value, row, index){
        		var type = $('#cycleType').combobox('getData');
         		for(i in type){
         			if(type[i].value==value)
         				return type[i].text;
         		}
        	 }
         },
         {field:'rewardNum',title:'周期最多奖励次数'},
         {field:'ruleLimit',title:'规则限制表达式'},
         {field:'credit',title:'积分计算表达式'},
         {field:'ruleEnabled',title:'规则是否启用',
        	 formatter:function(value, row, index){
         		var type = $('#ruleEnabled').combobox('getData');
          		for(i in type){
          			if(type[i].value==value)
          				return type[i].text;
          		}
         	 } 
         },
         {field:'startTime',title:'规则生效开始时间'},
         {field:'endTime',title:'规则失效时间'},
         {field:'opt',title:'操作',align:'right',
       		formatter:function(value, row, index) {
   				return '<button onclick="updateOTRule('+index +')" class="easyui-linkbutton">修改</button>';
     		} 
         }
    ]],
    toolbar: [{
    	text:'刷新',
		iconCls: 'icon-reload',
		handler:function(){$('#creditRuleList').datagrid('reload');}
	},{
    	text:'增加',
		iconCls: 'icon-add',
		handler:function(){addOTRule();}
	},{
		text:'删除',
		iconCls: 'icon-remove',
		handler: function(){
			var node = $('#creditRuleList').datagrid('getSelected');
			if(node){
				$.messager.confirm('确认', '是否要删除规则"'+node.ruleName+'"?', function(result){
					if (result){
						$.ajax({
							type:'POST',
							url:'${ctx}/base/creditRule/ot/delete', 
							data:{
								action:node.action,
								ruleId:node.ruleId
							},
							success:function(data, status){
								if(data.status=="SUCCESS"){
									$.messager.show({
										title:'消息',
										msg:'删除成功！',
										timeout:5000,
										showType:'slide'
									});
									$('#creditRuleList').datagrid('reload');
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
		}
	}]

});

/**
 * 查询
 */
$("#btnQuery").bind("click", function(){
	$('#creditRuleList').datagrid('load',{
		action: $('#actionSearch').val(),
        cycleType: $('#cycleTypeSearch').combobox('getValue'),
        ruleName: $('#ruleNameSearch').val()
	});
	return false;
});

/**
 * 清空查询条件
 */
$("#btnCancel").bind("click", function(){
    $('#queryForm').form('clear');
    $('#cycleTypeSearch').combobox('setValue','');
});

function addOTRule(){
	$('#editCreditRule').dialog({
		title:'新增联机积分规则',
		width: 420,    
		height: 450,    
		modal: true,
		onBeforeClose:function(){
			$('#editCreditRule').form('clear');
		},
		buttons:[{
			text:'保存',
			handler:function(){
				submitData('${ctx}/base/creditRule/ot/add');
			}
		},{
			text:'取消',
			handler:function(){
				$('#editCreditRule').dialog('close');
			}
		}]
	});
	$('#ruleLimit').val(true);
	$('#ruleEnabled').combobox('setValue','1');
	var startTime = getCurrentTime();
	$('#startTime').datetimebox('setValue',startTime);
	var endTime = getDefaultEndTime(startTime);
	$('#endTime').datetimebox('setValue',endTime);
	$('#action').removeAttr('disabled');
}

function getCurrentTime(){
	var date=new Date();
	var month = date.getMonth() + 1;
	month = (month < 10) ? "0" + month : month;
	var day = date.getDate();
	day = (day < 10) ? "0" + day : day;
	var hour = date.getHours();
	hour = (hour < 10) ? "0" + hour : hour;
	var minute = date.getMinutes();
	minute = (minute < 10) ? "0" + minute : minute;
	var second = date.getSeconds();
	second = (second < 10) ? "0" + second : second;
	
	return date.getFullYear() + "" + month + day + " " 
		+ hour + ":" + minute + ":" + second;
}

function getDefaultEndTime(startTime){
	var year = parseInt(startTime.slice(0,4));
	year = year +1;
	return "" + year + startTime.slice(4);
}


function updateOTRule(rowId){
	$('#editCreditRule').dialog({
		title:'编辑联机积分规则',
		width: 420,    
		height: 450,    
		modal: true,
		onBeforeClose:function(){
			$('#editCreditRule').form('clear');
		},
		buttons:[{
			text:'保存',
			handler:function(){
				submitData('${ctx}/base/creditRule/ot/update');
			}
		},{
			text:'取消',
			handler:function(){
				$('#editCreditRule').dialog('close');
			}
		}]
	});
	
	$('#creditRuleList').datagrid('selectRow', rowId);
	var node = $('#creditRuleList').datagrid('getSelected');
	$('#ruleId').val(node.ruleId);
	$('#action').val(node.action);
	$('#ruleName').val(node.ruleName);
	$('#cycleType').combobox('setValue',node.cycleType);
	$('#rewardNum').val(node.rewardNum);
	$('#ruleLimit').val(node.ruleLimit);
	$('#credit').val(node.credit);
	$('#ruleEnabled').combobox('setValue',node.ruleEnabled);
	$('#startTime').datetimebox('setValue',node.startTime);
	$('#endTime').datetimebox('setValue',node.endTime);
	$('#editCreditRule').form('validate');
	$('#ruleId').attr('disabled','true');
	$('#action').attr('disabled','true');
}

function submitData(url){
	if(!$('#editCreditRule').form('validate'))
		return;
			
	$.ajax({
		type:'POST',
		url:url,
		data:{
			ruleId:$('#ruleId').val(),
			action:$('#action').val(),
			ruleName:$('#ruleName').val(),
			cycleType:$('#cycleType').combobox('getValue'),
			rewardNum:$('#rewardNum').val(),
			ruleLimit:$('#ruleLimit').val(),
			credit:$('#credit').val(),
			ruleEnabled:$('#ruleEnabled').combobox('getValue'),
			startTime:$('#startTime').datetimebox('getValue'),
			endTime:$('#endTime').datetimebox('getValue')
		},
		success: function(data, status){
			if(data.status=="SUCCESS"){
				$.messager.show({
					title:'消息',
					msg:'提交成功！',
					timeout:5000,
					showType:'slide'
				});
				$('#editCreditRule').dialog('close');
				$('#creditRuleList').datagrid('reload');
			} else {
				$.messager.alert('错误',data.result,'error');
			}
		}
	});
}
//设置datebox格式 
$.fn.datebox.defaults.formatter = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var mf = (m < 10) ? "0" + m : m;
	var d = date.getDate();
	var df = (d < 10) ? "0" + d : d;
	return "" + y + mf + df;
};
$.fn.datebox.defaults.parser = function(s) {  
	if (s) {  
		var d = new Date(parseInt(s.slice(0,4)), parseInt(s.slice(4,6)) - 1, parseInt(s.slice(6,8)));  
		return d;  
	} else {  
		return new Date();
	}  	  
}; 

//数据校验
$.extend($.fn.validatebox.defaults.rules, {    
	numberValid:{
		validator: function(value, param){
			var p = new RegExp('^[0-9]{0,8}$');
			return p.test(value);
		},
		message: '请输入正确的数值！'
	},
	actionValid:{
		validator: function(value){
			var reg =  /^\w+$/;
			return reg.test(value);
		},
		message:'名称应由数字、字母、下划线组成！'
	},
	nameValid: {
		validator: function(value, param){
			var p = /^[\w\u4e00-\u9fa5]+$/;
			return p.test(value);
		},
		message: '名称应由数字、字母、中文字符、下划线组成'
	},
	limitValid: {        
		validator: function(value){            
			var reg = /^[\w\!\%\^\&\(\)\-\+\/\,\.\<\>]+$/;
			return reg.test(value);
		},        
		message: '请按正确的格式输入！'
	},
	creditValid: {        
		validator: function(value){            
			var reg = /^[\w\!\%\^\&\(\)\-\+\/\,\.\<\>]+$/;
			return reg.test(value);
		},        
		message: '请按正确的格式输入！'
	}
});
</script>
</body>
</html>