<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
</head>
<body>
    <table id="aciveStatusTable" data-options="fit:true,columnfit:true,rownumbers:true,pagination:true"></table>
    <div id="toolbar" style="padding:15px">
        <div>
        	<div style="float:right">
	            <a href="#" id="sendCode" class="easyui-linkbutton" >发送邀请码</a>
	           	<input id="condition" class="easyui-validatebox" style="width:200px" placeholder="企业名称或组织机构代码" data-options="validType:'length[0,20]'" >
	            <a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
            </div>
                                    所属商圈：
		    <input id="groupCode" name="groupCode" class="easyui-combogrid" style="width:155px;"></input>
		    <input id="idGroupCode" name="groupCode" type="hidden">
        </div>
    </div>
    
<script type="text/javascript"> 
$(document).ready(function() {
    
    initComboGrid();
    
    initActiveGrid();
    
    $('#search').click(function(){
        selectFunction();
    });

    $("#sendCode").bind("click", function(){
        sendCode();
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
    
});

function initActiveGrid(){
	$('#aciveStatusTable').datagrid({    
	    url:'${ctx}/base/inent/getGroupEntInfoList',
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
	        {field:'ck',checkbox:true},
	        {field:'entNo',hidden:true},
	        {field:'orgCode',title:'组织机构代码',width:100,align:'center'},        
	        {field:'chineseFullname',title:'企业名称',width:180},        
	        {field:'businessGroup',title:'所属商圈',width:180,
	            formatter : function(value,row,index){
	                if(value!= null)
	                return value.busiGroupName;
	            }
	        },
	        {field:'corpIdentMobile',title:'法人代表手机号',width:100},
	        {field:'createTime',title:'最近发送时间',width:120,
	            formatter : function(value,row,index){
	                if(value!= null)
	                    return value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6);
	            }
	        },
	        {field:'activateTime',title:'激活时间',width:120,
	            formatter : function(value,row,index){
	                if(value!= null)
	                    return value.substring(0, 4) + "-" + value.substring(4, 6) + "-" + value.substring(6);
	            }
	        },
	        {field:'activateStatus',title:'状态'}
	        
	    ]]
	});
}

/**
 * 发送激活码
 */
function sendCode(){
    var selects = $('#aciveStatusTable').datagrid('getSelections');
    var entNos = "";
    if(selects.length == 0){
        $.messager.alert('错误','请选择一条记录！','error');
        return;
    }

    for(var i=0;i<selects.length;i++){
        if(selects[i].activateStatus=="已激活"){
            $.messager.alert('错误',selects[i].chineseFullname + "已激活，请勿重复发送！",'error');
            return;
        }
        if(selects[i].corpIdentMobile==null){
            $.messager.alert('错误',selects[i].chineseFullname + "法人代表手机号为空，无法发送！",'error');
            return;
        }
            
        entNos += selects[i].entNo;
        if(i+1!=selects.length)
            entNos += ",";
    }
    $.ajax({
        url:'${ctx}/base/inent/activateCode',
        type:'POST',
        data:{
            entNos:entNos
        },
        success:function(data, status){
            $.messager.show({
                title:'消息',
                msg:'发送成功！',
                timeout:5000,
                showType:'slide'
            });
            $('#aciveStatusTable').datagrid('reload');
        }
    });
}

function selectFunction(){
	$('#aciveStatusTable').datagrid('load',{
		//groupCode:$('#groupCode').combobox('getValue')=="-1"?null:$('#groupCode').combobox('getValue')
		groupCode:$('#idGroupCode').val()==null ||$('#idGroupCode').val()==""?null:$('#idGroupCode').val(),
		condition:$('#condition').val()
	});
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