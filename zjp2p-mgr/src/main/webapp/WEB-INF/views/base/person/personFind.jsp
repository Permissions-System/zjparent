<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.zjgt.p2p.BaseConstant"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
.itemMagin {
	height: 25px;
}
</style>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,selected:true">
		<div data-options="region:'center',border:false,fit:true" title="个人客户查询列表">
			<div id="personTool" class="datagrid-toolbar" style="background-color: #F2F2F2">
				<table class="datagrid-toolbar" style="width: 100%; height: 100%; border: 0px; font-size: 12px; height: 80px; margin: 10px 10px 10px 10px">
					<tr class="itemMagin">
						<td><label for="loginname">登录名:</label></td>
						<td><input id="loginname" name="loginname" style="width: 155px;" class="easyui-validatebox"></td>
						<td><label for="mobile">手机:</label></td>
						<td><input id="mobile" name="mobile" style="width: 155px;" class="easyui-validatebox"></td>
						<td><label for="email">邮箱:</label></td>
						<td><input id="email" name="email" style="width: 155px;" class="easyui-validatebox"></td>
						<td><label for="findName">姓名:</label></td>
						<td><input id="findName" name="findName" style="width: 155px;" class="easyui-validatebox"></td>
					</tr>
					<tr class="itemMagin">
						<td><label for="income">年收入范围:</label></td>
						<td align="left"><select id="income" class="easyui-combobox" panelHeight="auto" name="incomeScope" style="width: 155px" data-option="editable:false,required:true,multiple:false">
								<option value="-1" selected="selected">--请选择</option>
								<c:forEach items="${incomeScopes}" var="incomeScope">
									<option value="${incomeScope.configCode}">${incomeScope.configName}</option>
								</c:forEach>
						</select></td>
						<td><label for="year">工作时间:</label></td>
						<td align="left"><select id="year" class="easyui-combobox" panelHeight="auto" name="workYear" style="width: 155px" data-option="editable:false,required:true,multiple:false">
								<option value="-1" selected="selected">--请选择</option>
								<c:forEach items="${workYears}" var="workYear">
									<option value="${workYear.configCode}">${workYear.configName}</option>
								</c:forEach>
						</select></td>
						<td><label for="province">工作省市:</label></td>
						<td align="left"><select id="province" class="easyui-combobox" name="workProvince" style="width: 155px" data-option="editable:false,required:true,multiple:false">
								<option value="-1" selected="selected">--请选择</option>
								<c:forEach items="${provinces}" var="province">
									<option value="${province.areaCode}">${province.areaName}</option>
								</c:forEach>
						</select></td>
						<td></td>
						<td><a id="findByName" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜 索</a></td>
					</tr>
				</table>
			</div>
			<table id="personTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"></table>
		</div>
		<div id="resourceDialog" class="easyui-dialog" title="资源列表 " data-options="closed: true,maximized:true,resizable:true,modal:true">
			<table id="webResourceTable"></table>
		</div>
		<div id="groupDialog" class="easyui-dialog" style="width: 700px; height: 300px;" data-options="resizable:false,modal:true,title:'查看所属组'" closed="true">
			<table id="webGroupTable"></table>
		</div>
	</div>
<script type="text/javascript">
	var resTypeData = null; //资源类型
	var stateData = null; //组状态
	var groupTypeData = null; //组类型

	//初始化个人客户的datagrid列表
	$('#personTable').datagrid({    
		url:'${ctx}/base/personal/firstPage',
		toolbar: '#personTool',
		pageSize:10,
		pageList:[10,20,30,40,50],
		nowrap:false,
		autoRowHeight:false,
		striped:true,
		border:false,
		fitColumns:true,
		method:'post',
		singleSelect:true,
		fit:true,
	    onLoadSuccess: function(data){
			if(data.total==0){
			 $.messager.show({
					title:'消息',
					msg:'没有相关的记录。',
					timeout:5000,
					showType:'slide'
				});
			}
	    },
	    onLoadError: function(){
	        $.messager.alert('错误信息','信息查询失败!','error');
	    },
		columns:[[        
			{field:'loginName',title:'登录名',width:80},
			{field:'mobile',title:'手机',width:80},
			{field:'email',title:'邮箱',width:120},
			{field:'name',title:'姓名',align:'center',width:100},
			{field:'incomeScope',title:'年收入范围',align:'center',width:60,
				formatter:function(value,row, index){
					if(value==null) {
					    return "";
					} else {
						var data = $('#personTable').datagrid('getData');
						var result=0;
						for(var i=0;i<data.incomeScopeList.length;i++){
							if(value==data.incomeScopeList[i].configCode){
								result=i;
								i=0;
								break;
							}
						}
					    return data.incomeScopeList[result].configName; 
					}
				}}, 
			{field:'workYear',title:'工作时间',align:'center',width:60,
				formatter:function(value,row, index){
					if(value==null) {
					    return "";
					} else {
						var data = $('#personTable').datagrid('getData');
						var result=0;
						for(var i=0;i<data.workYearList.length;i++){
							if(value==data.workYearList[i].configCode){
								result=i;
								i=0;
								break;
							}
						}
					return data.workYearList[result].configName;
				}
		    }}, 
			{field:'workProvince',title:'工作省市',align:'center',width:60,
				formatter:function(value,row, index){
					if(value==null) {
					    return "";
					} else {
						var data = $('#personTable').datagrid('getData');
						var result=0;
						for(var i=0;i<data.provinceList.length;i++){
							if(value==data.provinceList[i].areaCode){
								result=i;
								i=0;
								break;
							}
						}
					return data.provinceList[result].areaName;
					}
		    }}, 
			{field:'statusDesc',title:'用户状态',width:60,align:'center'},
			{field:'opation',title:'操作',width:250,align:'center',
				formatter : function(value, row, index) {
					var opt='';
					opt += '<button onclick="infoList('+index +')" class="easyui-linkbutton">详情>></button>';
					opt +='&nbsp;&nbsp;';
					opt += '<button onclick="resourceList('+index +')" class="easyui-linkbutton">资源列表>></button>';
					opt +='&nbsp;&nbsp;';
					opt += '<button onclick="groupList('+index +')" class="easyui-linkbutton">所属组列表>></button>';
					return opt;
				}
			}
	    ]] 
	});

	//点击查找Button进行查找
	$('#findByName').click(findPerson);

	//Enter键绑定查找Button执行筛选搜索功能
	document.onkeydown = function(event) {
		var e = event || window.event || arguments.callee.caller.arguments[0];
		if (e && e.keyCode == 13) {
			stopDefault(e);
			findPerson();
		} else
			return;
	};

	function stopDefault(e) {
		if (e && e.preventDefault) {
			e.preventDefault();
		} else {
			window.event.returnValue = false;
		}
		return false;
	}

	function findPerson() {
		var loginname = $("#loginname").val();
		var mobile = $("#mobile").val();
		var email = $("#email").val();
		
		var income = $("#income").combobox('getValue');
		var year = $("#year").combobox('getValue');
		var province = $("#province").combobox('getValue');

		var inputFind = $('#findName').val();
		var name = $.trim(inputFind);

		if (loginname!="" || mobile!="" || email!="") {
			$('#personTable').datagrid('options').url = '${ctx}/base/personal/getPersonByAccountInfo';
			$('#personTable').datagrid('load', {
				loginname : loginname,
				mobile : mobile,
				email : email,
				incomeScope : income,
				workYear : year,
				workProvince : province,
				name : name
			});
			return;
		}

		if (name.length > 8) {
			$.messager.alert('提示', '您输入的搜索名过长，请控制在8位以内！');
			return;
		}

		if (income == -1 && name == "" && year == -1 && province == -1) {
			//$.messager.alert('提示','请至少选择或输入一项条件进行联合查询！');
			$('#personTable').datagrid('options').url = '${ctx}/base/personal/firstPage';
			$('#personTable').datagrid('load', {
			});
		} else {
			$('#personTable').datagrid('options').url = '${ctx}/base/personal/getListByMultiCondition';
			$('#personTable').datagrid('load', {
				incomeScope : income,
				workYear : year,
				workProvince : province,
				name : name
			});
		}
	}

	//进入个人客户详情页面
	function infoList(index) {
		$('#personTable').datagrid('selectRow', index);
		var gridNode = $('#personTable').datagrid('getSelected');
		var userNo = gridNode.userNo;
		var userName = gridNode.name;
		if(userName!=null){
			self.parent.openTab('查看：' + userName, '${ctx}/base/personal/info/' + userNo);
		}else{
			self.parent.openTab('查看：', '${ctx}/base/personal/info/' + userNo);
		}
		
	}
	
	//进入资源列表页面
	function resourceList(index) {
		$('#personTable').datagrid('selectRow', index);
		var gridNode = $('#personTable').datagrid('getSelected');
		var userNo = gridNode.userNo;
		$('#resourceDialog').dialog('open');
		$.ajax({
			type : 'POST',
			async: false,
			url : '${ctx}/base/personal/getResources',
			data : {
				userNo: userNo
			},
			success : function(data, status) {
				$('#webResourceTable').datagrid('loadData', data);
			},
			error : function(data, status) {
				$('#webResourceTable').datagrid('loadData',{ total: 0, rows: [] });
				$.messager.alert('错误信息','资源信息查询失败:<br/>'+getJsonErrorMsg(data),'error');
				$('#resourceDialog').dialog('close');
			},
			datatype : "json"
		});
	}

	//收入范围Combobox不能编辑
	$("#income").combobox({
		editable : false
	});

	//工作年限Combobox不能编辑
	$("#year").combobox({
		editable : false
	});

	//省市Combobox不能编辑
	$("#province").combobox({
		editable : false
	});
	
	$('#webResourceTable').datagrid({
		//title: '拥有资源',
		nowrap: false,
        pagination: false,
        rownumbers: true,
        fit: true,
		columns : [[
			{field:'name',title:'资源名称',width:150,align:'center'},
			{field:'permission',title:'权限字符',width:350,align:'center'},
			{field:'type',title:'资源类型',width:100,align:'center',
				formatter: function(value,row,index){
					var typeData = getResTypeData();
					if(typeData && typeData.length>0){
						for(var i in typeData){
							if(typeData[i].configCode==value){
								return typeData[i].configName;
							}
						}
					}
					return value;
				}
			},
			{field:'remark',title:'描述',width:250,align:'center'}
		]],
		onLoadError: function(data){
			$.messager.alert('错误信息','资源信息查询失败！<br/>'+getJsonErrorMsg(data),'error');
		}
	});
	
	function getResTypeData(){
		if(resTypeData==null || resTypeData.length==0){
			$.ajax({
				type : 'POST',
				async: false,
				url : '${ctx}/base/personal/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_RES_TYPE%>',
				success : function(data, status) {
					resTypeData = data;
				},
				error : function(data, status) {
					$.messager.show({
						title: '错误',
						msg: '获取资源类型失败！<br/>',
						timeout: 5000,
						showType: 'slide'
					}); 
				},
				datatype : "json"
			});
		}
		return resTypeData;
	}
	function getStateData(){
		if(stateData==null || stateData.length==0){
			$.ajax({
				type : 'POST',
				async: false,
				url : '${ctx}/base/personal/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_START_STOP_FLAG%>',
				success : function(data, status) {
					stateData = data;
				},
				error : function(data, status) {
					$.messager.show({
						title: '错误',
						msg: '获取组状态失败！<br/>',
						timeout: 5000,
						showType: 'slide'
					}); 
				},
				datatype : "json"
			});
		}
		return stateData;
	}
	function getGroupTypeData(){
		if(groupTypeData==null || groupTypeData.length==0){
			$.ajax({
				type : 'POST',
				async: false,
				url : '${ctx}/base/personal/getCodeInfo/<%=BaseConstant.DICT_CODE_TYPE_BG_FLAG%>',
							success : function(data, status) {
								groupTypeData = data;
							},
							error : function(data, status) {
								$.messager.show({
									title : '错误',
									msg : '获取组类型失败！<br/>',
									timeout : 5000,
									showType : 'slide'
								});
							},
							datatype : "json"
						});
			}
			return groupTypeData;
		}
		//进入所属组列表页面
		function groupList(index) {
			$('#personTable').datagrid('selectRow', index);
			var gridNode = $('#personTable').datagrid('getSelected');
			var userNo = gridNode.userNo;
			$('#groupDialog').dialog('open');
			$.ajax({
				type : 'POST',
				async : false,
				url : '${ctx}/base/personal/getGroups',
				data : {
					userNo : userNo
				},
				success : function(data, status) {
					$('#webGroupTable').datagrid('loadData', data);
				},
				error : function(data, status) {
					$('#webGroupTable').datagrid('loadData', {
						total : 0,
						rows : []
					});
					$.messager.show({
						title : '错误信息',
						msg : '获取所属组信息失败！<br/>',
						timeout : 5000,
						showType : 'slide'
					});
				},
				datatype : "json"
			});
		}
		// 初始化
		$('#webGroupTable').datagrid(
				{
					nowrap : false,
					rownumbers : true,
					singleSelect : false, //非单选
					checkOnSelect : false,
					selectOnCheck : false,
					fit : true,
					loadMsg : '加载数据，请稍候...',
					onLoadError : function(data) {
						$.messager.alert('错误信息', '所属组信息查询失败:<br/>'
								+ getJsonErrorMsg(data), 'error');
					},
					columns : [ [ {
						field : 'id',
						title : '组代码',
						width : 250,
						align : 'center'
					}, {
						field : 'name',
						title : '组名称',
						width : 150,
						align : 'center'
					}, {
						field : 'state',
						title : '状态',
						width : 100,
						align : 'center',
						formatter : function(value, row, index) {
							var comboboxData = getStateData();
							if (comboboxData && comboboxData.length > 0) {
								for ( var i in comboboxData) {
									if (comboboxData[i].configCode == value) {
										return comboboxData[i].configName;
									}
								}
							}
							return value;
						}
					}, {
						field : 'type',
						title : '组类型',
						width : 100,
						align : 'center',
						formatter : function(value, row, index) {
							var comboboxData = getGroupTypeData();
							if (comboboxData && comboboxData.length > 0) {
								for ( var i in comboboxData) {
									if (comboboxData[i].configCode == value) {
										return comboboxData[i].configName;
									}
								}
							}
							return value;
						}
					} ] ]
				});

		// 解析Ajax请求失败的json错误信息
		function getJsonErrorMsg(data) {
			var errorMsg = '';
			if (data && data.responseText) {
				errorMsg = (eval('(' + data.responseText + ')')).string;
			}
			return errorMsg;
		}
	</script>
</body>
</html>