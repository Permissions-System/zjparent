<%@ page language="java" pageEncoding="UTF-8" %>
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
<table id="inEntTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true"></table>
<div id="toolbar" style="padding:15px">
	<div style="float:right">
		<input id="condition" class="easyui-validatebox" style="width:200px" placeholder="企业名称或组织机构代码" data-options="validType:'length[0,20]'">
	 	<a href="#" id="search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
	</div>
	所属商圈：
	<input id="groupCode" name="groupCode" class="easyui-combogrid" style="width:155px;"></input>
    <input id="idGroupCode" name="groupCode" type="hidden">
	
</div>
<div id="preview"></div>
<script type="text/javascript"> 
var CHINA_CODE="156";
$(document).ready(function() {
	// 初始化grid
	intiGroupEntGrid();
	
	// 搜索
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
	
	$('#registerCountry').combobox({onSelect:function(){
		if($('#registerCountry').combobox('getValue')!= CHINA_CODE){
			$('#registerArea').combobox('disable');
			$('#registerArea').combobox('setValue',"");
		}
		else
			$('#registerArea').combobox('enable');
	}});
	

	initComboGrid();
});

function intiGroupEntGrid(){
   $('#inEntTable').datagrid({    
        url:'${ctx}/base/inent/getGroupEntByGroup',
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
                    if(value!= null)
                        return value.busiGroupName;
                    
                }
            },
            {field:'opation',title:'操作',align:'center',width:80,
                formatter : function(value, row, index) {
                    var opt='';
                    opt+=' <input type="button" onclick="viewEntTab('+index +')" class="button" value="查看" />';
                    opt+=' <input type="button" onclick="editEntTab('+index +')" class="button" value="修改" />';
                    return opt;
                } 
            }
        ]]
    });
}

function selectFunction(){
	$('#inEntTable').datagrid('load',{
	    groupCode:$('#idGroupCode').val()==null ||$('#idGroupCode').val()==""?null:$('#idGroupCode').val(),
	    condition:$('#condition').val()
	});
}

function viewEntTab(rowId){
	$('#inEntTable').datagrid('selectRow', rowId);
	var node = $('#inEntTable').datagrid('getSelected');
	self.parent.openTab("查看:"+node.chineseFullname,"${ctx}/base/inent/info/"+node.entNo);
}

function editEntTab(rowId){
	$('#inEntTable').datagrid('selectRow', rowId);
	var node = $('#inEntTable').datagrid('getSelected');
	self.parent.openTab("修改:"+node.chineseFullname, "${ctx}/base/inent/edit/"+node.entNo);
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