<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
.button{
    	width:50px;
    	height: 100%;
    }
</style>
</head>
<body>
<table id="unauditedEntTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"></table>
<div id="toolbar" style="padding:15px">
    <div>
    	<div style="float:right">
	       	<input id="condition" class="easyui-validatebox" style="width:200px" placeholder="企业名称或组织机构代码" data-options="validType:'length[0,20]'">
	        <a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search" >搜索</a>
        </div>
                         资料状态：
    	<select id="fileStatus" class="easyui-combobox" data-options="panelHeight:'auto',onSelect:selectFunction,editable:false">
    		<option value='-1'>请选择</option>
   			<c:forEach items="${fileStatus}" var="file">
   				<c:choose>
	   				<c:when test="${file.configCode==2}">
	   					<option value="${file.configCode}" selected="selected">${file.configName}</option>
	   				</c:when>
	   				<c:otherwise>
	   					<option value="${file.configCode}">${file.configName}</option>
	   				</c:otherwise>
   				</c:choose>
   				
   			</c:forEach>
   		</select>				        
                       所属商圈：
        <input id="groupCode" name="groupCode" class="easyui-combogrid" style="width:155px;"></input>
   		<input id="idGroupCode" name="groupCode" type="hidden">
    </div>
</div>

<script type="text/javascript"> 
$(document).ready(function() {
	
	initEntGrid();
	
    $("#search").bind("click", function(){
    	selectFunction();
    });
	
	//enter键搜索
	$('#condition').bind('keypress',function(event){
		if(event.keyCode == "13"){
			selectFunction();
	    }
	    else{
			 return;
	    }
	});

	// 初始化combogrid
	initComboGrid();
	
});

function initEntGrid(){
    $('#unauditedEntTable').datagrid({    
        url:'${ctx}/base/inent/getGroupEntByComboxCon',
        queryParams:{
            fileStatus:'2'
        },
        toolbar: '#toolbar',
        pagination:true,
        rownumbers:true,
        pageSize:10,
        pageList:[10,20,50],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        onLoadSuccess:function(data){
            if(data.total == 0){
                $.messager.alert('提示',"没有符合条件的记录！",'info');
            } 
        },
        columns:[[        
            {field:'orgCode',title:'组织机构代码',width:80,align:'center'},        
            {field:'chineseFullname',title:'企业名称',width:200},        
            {field:'businessGroup',title:'所属商圈',width:200,
                formatter : function(value,row,index){
                    if(value!= null)  return value.busiGroupName;
                }
            },
            {field:'infoStatus',title:'状态',width:80,align:'center',
                formatter : function(value,row,index){
                    var type = $('#fileStatus').combobox('getData'); 
                    for(i in type){
                        if(type[i].value==value)
                            return type[i].text;
                    }
                }
            },
            {field:'opation',title:'操作',align:'center',width:80,
                formatter : function(value, row, index) {
                    var opt='';
                    opt+=' <input type="button" onclick="viewEntTab('+index + ',' + false + ')"  class="button" value="查看" />';
                    opt+=' <input type="button" onclick="viewEntTab('+index + ',' + true + ')"  class="button" value="审核" />';
                    return opt;
                } 
            }
        ]]
    });
}


function selectFunction(){
	$('#unauditedEntTable').datagrid('load',{
		fileStatus:$('#fileStatus').combobox('getValue')=="-1" ? null:$('#fileStatus').combobox('getValue'),
	    groupCode:$('#idGroupCode').val()==null ||$('#idGroupCode').val()=="" ? null:$('#idGroupCode').val(),
	    condition:$('#condition').val()
	});
}

function viewEntTab(rowId,flag){
	$('#unauditedEntTable').datagrid('selectRow', rowId);
	var node = $('#unauditedEntTable').datagrid('getSelected');
	if(flag==true){
		switch(node.infoStatus){
		case '1':
			$.messager.alert('提示','资料尚未提交！','info');
			break;
		case '3':
			$.messager.alert('提示','该企业已审核通过！','info');
			break;
		default:
			self.parent.openTab("审核:"+node.chineseFullname, "${ctx}/base/inent/auditPage/"+node.entNo);
			break;
		}
	} else {
		self.parent.openTab("查看:"+node.chineseFullname, "${ctx}/base/inent/info/"+node.entNo);
	}
}

/**
 * 不提供输入式查询
 * 初始化ComboGrid
 */
function initComboGrid(){
    $('#groupCode').combogrid({    
        panelWidth:500,         
        idField:'busiGroupCode',    
        textField:'busiGroupName',    
        url:'${ctx}/base/inent/getBusiGroupInfo',
        fitColumns:true,
        striped:true,
        editable:false,
        pagination:true,
        collapsible:false,
        fit:true,
        pageSize:5,
        pageList:[5],
        onSelect:function(rowIndex, rowData){
            //执行处理当行选中时候 分页加载数据字典明细数据列表
            var groupCode = rowData.busiGroupCode;
            // 具体加载明细记录的js操作
            setGroupCodeValue(groupCode);
            selectFunction();
        },
        columns:[[        
                  {field:'busiGroupCode',title:'商圈编号',width:80},           
                  {field:'busiGroupName',title:'商圈名称',width:150}    
        ]],
        keyHandler:{
            up:function(){},
            down:function(){},
            enter:function(){},
            query:function(q){
                //$('#idSeFileType').combogrid("grid").datagrid("load",{'q':q});
                //$('#idSeFileType').combogrid("setValue",q);
            }
        }
    });
}

function setGroupCodeValue(groupCode){
	$('#idGroupCode').val(groupCode);
}
</script>
</body>
</html>