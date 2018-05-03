<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
	<div data-options="region:'center',border:false,fit:true" title="个人客户待审核列表" >		
		<table id="personTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"> 
		</table>     
		<div id="personTool" width="100%"  style="background-color:#F2F2F2">
	        <br>
	        <div style="float:right">
	        	&nbsp;&nbsp;&nbsp;&nbsp;客户姓名:&nbsp;
				<input type="text" id="findName" value="" name="name" data-options="required:true" ></input>
			 	<a id="findByName" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
			 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
	        <div>
		        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审核状态：
		        <select id="infoStatus" class="easyui-combobox" panelHeight="auto" name="infoStatus" style="width:155px;" data-option="editable:false,required:true,multiple:false">
	                <option value="-1" selected="selected">--请选择</option> 
	                <c:forEach items="${infoStatuses}" var="infoStatus">
	                <option value="${infoStatus.configCode}">${infoStatus.configName}</option>
	                </c:forEach>
		        </select> 
	        </div>
	        <br>
		</div>
	</div>
</div>
<script type="text/javascript">
	/*初始化*/
	$(document).ready(function() {
	    
		$("#findByName").bind("click", function(){
	        queryFindByNameInfo();
	    });
	    // 初始化Grid
		initIndividualGrid();
	    
	    initCombobox();
	});

	/**
	 * js初始化法人代表页面查询列表DataGrid
	 */
	function initIndividualGrid(){
	    
	    //初始化个人客户的datagrid列表
	    $('#personTable').datagrid({    
	        url:'${ctx}/base/personal/getListByInfoStatus',
	        queryParams: {
	            page: 1,
	            rows: 10,
	            infoStatus:2
	        }, 
	        toolbar: '#personTool',
	        method:'post',
	        pageSize:10,
	        pageList:[10,20],
	        fitColumns:true,
	        onLoadSuccess: function(data){
				if(data.total==0){
					showSlideMessage("没有查询到相关的记录。");
				}
	        },
            onLoadError: function(){
               $.messager.alert('错误信息','信息查询失败!','error');
            },
	        columns:[[        
                {field:'name',title:'客户姓名',align:'center',width:100},   
                {field:'identType',title:'证件类型',align:'center',width:100, 
                    formatter:function(value,row, index){
                        if(value==null) {
                            return "";                          
                        } else {
                            var data = $('#personTable').datagrid('getData');
                            var result=0;
								for(var i=0;i<data.identTypeList.length;i++){
								    if(value==data.identTypeList[i].configCode){
								        result=i;
								        i=0;
								        break;
								    }
								}
                                return data.identTypeList[result].configName;
                            }
                        }}, 
                {field:'identNo',title:'证件号',align:'center',width:200},         
                {field:'infoStatus',title:'资料审核状态',align:'center',width:100, 
                    formatter:function(value,row, index){    
                        if(value==null) {
                            return "";
                        } else {
                            var data = $('#personTable').datagrid('getData');
                            var result=0;
							for(var i=0;i<data.statusList.length;i++){
							    if(value==data.statusList[i].configCode){
							        result=i;
							        i=0;
							        break;
							    }
							}
							return data.statusList[result].configName;
                        }
                    }},
                {field:'time',title:'上传时间',align:'center',width:100}, 
                {field:'opation',title:'操作',width:120,align:'center', 
                    formatter : function(value, row, index) {
                          var opt='';
                          opt += '<button onclick="infoList('+index +')" class="easyui-linkbutton">查看</button>';
                          opt += '<button onclick="auditPerson('+index +')" class="easyui-linkbutton">审核</button>';
                          return opt;
                      }
                }
	        ]] 
	    });
	}

    //点击查找Button进行模糊查找
	function queryFindByNameInfo() {
		var inputFind = $('#findName').attr("value");
		if(inputFind.length>8) {
			$.messager.alert('提示','您输入的搜索名过长，请控制在8位以内！');
			return;
		}
		var inputString = $.trim(inputFind);
		if($.trim(inputString) == "") {
			//$.messager.alert('提示','请输入相关的客户姓名进行查询！');
			$('#personTable').datagrid('options').url = '${ctx}/base/personal/firstPage';
			$('#personTable').datagrid('load',{
				page: 1,
				rows: 10
				});
		} else {
			$('#personTable').datagrid('options').url = '${ctx}/base/personal/getListByPersonName';
			$('#personTable').datagrid('load',{
			    personName : inputString
			});
		}
	}

	function initCombobox(){
		//根据审核状态infoStatus来查询该状态下的个人用户
		$('#infoStatus').combobox({
		    onSelect: function(rec){
		        var chooseStatus = $("#infoStatus").combobox('getValue'); 
		        if(chooseStatus != -1) {
		            $('#personTable').datagrid('options').url = '${ctx}/base/personal/getListByInfoStatus';
		            $('#personTable').datagrid('load',{    
		                infoStatus : chooseStatus
		            });
		        } else {
		            $('#personTable').datagrid('options').url = '${ctx}/base/personal/firstPage';
		            $('#personTable').datagrid('load');
		            $('#findName').attr("value",null);
		        }
		    },
		    editable:false
		});
		// 初始化时默认 查询 已提交待审核 
		$('#infoStatus').combobox('setValue','2');
	}


	//Enter键执行搜索功能
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	     if(e && e.keyCode==13){ 
	    	 stopDefault(e);
			var inputFind = $('#findName').attr("value");
			if(inputFind.length>8) {
				$.messager.alert('提示','您输入的搜索名过长，请控制在8位以内！');
				return;
			}
			var inputName = $.trim(inputFind);
	    	if($.trim(inputName) != "") {
	     		$('#personTable').datagrid('options').url = '${ctx}/base/personal/getListByPersonName';
	     		$('#personTable').datagrid('load',{    
	     			personName : inputName
	     		});
	    	} else {
	    		$('#personTable').datagrid('options').url = '${ctx}/base/personal/firstPage';
				$('#personTable').datagrid('load',{    
					page: 1,
					rows: 15
					});
	    	}
	    } else 
	    	return;
	}; 

	function stopDefault(e) {
		if(e && e.preventDefault) {
			e.preventDefault();
		} else {
			window.event.returnValue = false;
		}
		return false;
	}

	//查看个人客户详情
	function infoList(index) {
		$('#personTable').datagrid('selectRow', index);     //选中当前记录
		var gridNode = $('#personTable').datagrid('getSelected');
		var userNo = gridNode.userNo;
		var userName = gridNode.name;
		if(userName==null) {
			self.parent.openTab('查看','${ctx}/base/personal/info/'+ userNo);
		} else {
			self.parent.openTab('查看：'+userName,'${ctx}/base/personal/info/'+ userNo);
		}
	}

	//对个人客户进行审核
	function auditPerson(index) {
		$('#personTable').datagrid('selectRow', index);    //选中当前记录
		var gridNode = $('#personTable').datagrid('getSelected');
		var infoStatus = gridNode.infoStatus;
		var userNo = gridNode.userNo;
		var userName = gridNode.name;
	 	if(infoStatus == 3) {
			$.messager.alert('温馨提示','审核已通过，无需重新审核！');
			return;
		} else if(infoStatus == 1) {
			$.messager.alert('温馨提示','客户还未提交任何资料，无需进行审核！');
			return;
		} else if(infoStatus == 4) {
			$.messager.alert('温馨提示','审核不通过，无需审核！');
			return;
		} else {
			if(userName==null) {
				self.parent.openTab('审核','${ctx}/base/personal/audit/'+ userNo);
			} else
			self.parent.openTab('审核：'+userName,'${ctx}/base/personal/audit/'+ userNo);		
		}
	}

	//关闭Ajax相应的缓存,解决IE不刷新个人用户审核状态的bug
	$.ajaxSetup ({
		cache: false    
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