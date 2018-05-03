<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input,select{
	width:180px;
}
#appDlg tr{
	height:50px;
}
#appDlg td label {
	text-align:right;
	padding-left:60px;	
}
.button{
	width:50px;
}
.itemMagin{
    height:30px;
}
</style>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post">
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label>操作系统:</label></td>
                    <td>
                        <select id="qrymobos" panelHeight="auto" name="qrymobos" class="easyui-combobox" style="width:155px;" data-option="required:false,editable:false">     
                            <option value="">全部</option>
                            <option value="iOS">iOS</option>
                            <option value="Android">Android</option>
                        </select>
                    </td>
                    <td><label>APP名称:</label></td>
                    <td>
                        <select id="qryappname" panelHeight="auto" name="appname" class="easyui-combobox" style="width:155px;" data-option="required:false,editable:false">     
                            <option value="">全部</option>
                            <option value="0">个人版</option>
                            <option value="1">企业版</option>
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
        <table id="appupdaterecordTab"></table>
    </div>
</div>
<!-- 新增修改页面 -->
<div id="appDlg" class="easyui-dialog" style="width:400px;height:500px;padding:10px 0px 10px 0px"
    data-options="resizable:false,modal:true" closed="true" buttons="#app-dlg-buttons">
	<form id="appForm" method="post">
		<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
            <tbody>
				<tr>
					<td><label>手机操作系统:</label></td>
					<td>
						<select id="mobos" class="easyui-combobox" panelHeight="auto" name="mobos" style="width:200px;" data-option="editable:false,required:true,multiple:false"> 
		                <option value="iOS" >iOS</option>
		                <option value="Android">Android</option>
			        	</select>
					</td>
				</tr>
				<tr>
					<td><label>APP名称:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="appname" name="appname" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label>APP版本:</label></td>
					<td><input class="easyui-validatebox" type="text"  style="width:200px;" id="appver" name="appver" data-options="required:true"/></td>
				</tr>
				<tr>
					<td><label>上线日期:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="issuedate" name="issuedate"/></td>
				</tr>
				<tr>
					<td><label>上线时间:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="issuetime" name="issuetime" /></td>
				</tr>
				<tr>
					<td><label>更新描述:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="uptdesc" name="uptdesc"/></td>
				</tr>
				<tr>
					<td><label>是否强制更新:</label></td>
					<td><input class="easyui-validatebox" type="text" style="width:200px;" id="uptflg" name="uptflg"/></td>
				</tr>
				</tbody>
		</table>
	</form>
</div>
<div id="app-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="saveInfo" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#appDlg').dialog('close')">关闭</a>
</div>
<script type="text/javascript">
$(document).ready(function() {
	
	// 查询
    $("#btnQuery").bind("click", function(){
    	search();
    });
 	// 清理查询内容
    $("#btnCancel").bind("click", function(){
        queryCancel();
    });
    $("#qrymobos").combobox({
        editable:false
    });
    $("#qryappname").combobox({
        editable:false
    });
	$('#saveInfo').bind("click",function(){
		saveappInfo();
	});
	init_datagrid();
});

function init_datagrid(){
	$('#appupdaterecordTab').datagrid({
		url:'${ctx}/base/app/appupdaterecord',
		pagination:true,
		rownumbers:true,
		pageSize:10,
		pageList:[10,20],
	    nowrap: false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        loadMsg: '加载数据，请稍候...',
		title:"APP更新记录表",
		columns:[[
		          {field:'mobos',title:'操作系统',width:100},
		          {field:'appname',title:'App名称',width:100},
		          {field:'appver',title:'APP版本',width:100},
		          {field:'issuedate',title:'上线日期',width:100},
		          {field:'issuetime',title:'上线时间',width:100},
		          {field:'uptdesc',title:'更新描述',width:100},
		          {field:'uptflg',title:'是否强制更新',width:100},
		          {field:'modifydate',title:'修改日期',width:100},
		          {field:'modifytime',title:'修改时间',width:100}
		]]
		/*toolbar:[{
            text:'新增',
            iconCls:'icon-add',
            handler:function(){
            	add();
            }
		},'-',{
        	text:'修改',
            iconCls:'icon-edit',
            handler:function(){
        	    update();
            }
    	},'-',{
             text:'删除',
             iconCls:'icon-remove',
             handler:function(){
                del();
        }
    }
]*/
	});
};


/**
 * 新增
 */
function add(){
	
    $('#appDlg').dialog('open').dialog('setTitle','新增');
	$('#appForm').form('clear');
	//向保存按钮传递参数用于判断
	$('#saveInfo').data("action","add");
};
/*
 * 修改
 */
function update(){
	var row=$('#appupdaterecordTab').datagrid('getSelected');
	if(!row){
		showSlideMessage("请选择一条需要编辑的记录");
		return ;
	}
	
	$('#appDlg').dialog('open').dialog('setTitle','更新');
	$('#appForm').form('clear');
	$('#appForm').form('load',row);
	$('#mobos').attr('readonly','readonly');
	$('#appname').attr('readonly','readonly');
	$('#appver').attr('readonly','readonly');
	
	//向保存按钮传递参数用于判断
    $('#saveInfo').data("action","update");
}


function saveappInfo(){
	var isValid = $('#appForm').form("validate");
	if(!isValid){
		return ;
	}
	var action= $('#saveInfo').data('action');
	
	if(action=='add'){
		$.ajax({
			type:'POST',
			async: false,
	        url:'${ctx}/base/app/addupdaterecord',
	        data:{
	        	mobos:$('#mobos').combobox('getValue'),
	        	appname:$('#appname').val(),
	        	appver:$('#appver').val(),
		        issuedate:$('#issuedate').val(),
		        issuetime:$('#issuetime').val(),
		        uptdesc:$('#uptdesc').val(),
		        uptflg:$('#uptflg').val(),
	        },
			success: function(data, status){
	        if(data.status=="SUCCESS"){
	            showSlideMessage("更新成功！");
	            $('#appDlg').dialog('close');
	            $('#appupdaterecordTab').datagrid('reload');
	        } else {
	            $.messager.alert('错误',data.result,'error');
	        }
	    }
		});
	}else{
		$.ajax({
			type:'POST',
			async: false,
	        url:'${ctx}/base/app/updateappupdaterecord',
	        data:{
	        	mobos:$('#mobos').combobox('getValue'),
	        	appname:$('#appname').val(),
	        	appver:$('#appver').val(),
		        issuedate:$('#issuedate').val(),
		        issuetime:$('#issuetime').val(),
		        uptdesc:$('#uptdesc').val(),
		        uptflg:$('#uptflg').val(),
	        },
			success: function(data, status){
	        if(data.status=="SUCCESS"){
	            showSlideMessage("更新成功！");
	            $('#appDlg').dialog('close');
	            $('#appupdaterecordTab').datagrid('reload');
	        } else {
	            $.messager.alert('错误',data.result,'error');
	        }
	    }
		});
	}
};
/**
 * 删除记录
 */
function del(){
	var node = $('#appupdaterecordTab').datagrid('getSelected');
	if(!node){
		showSlideMessage("请选择需要删除的系统参数！");
		return;
	}
	$.messager.confirm('确认信息', '确定删除该记录吗?', function(r){
		if(r){
			$.ajax({
				type:'POST',
				url:'${ctx}/base/app/delappupdaterecord',
				data:{
					mobos:node.mobos,
					appname:node.appname,
					appver:node.appver
				},
				success:function(data, status){
					if(data.status=="SUCCESS"){
						showSlideMessage("删除成功！");
						$('#appupdaterecordTab').datagrid('load');
					} else {
						$.messager.alert('错误',data.result,'error');
					}
				},
				error: function(){
					$.messager.alert('消息', '删除失败!','info');
				}
			});
		}
	});
}

/**
 * 查询
 */
function search(){
	$('#appupdaterecordTab').datagrid('load',{
		mobos: $('#qrymobos').combobox('getValue'),
        appname: $('#qryappname').combobox('getValue')
	});
	return false;
}
/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
    $('#qrymobos').combobox('setValue','');
    $('#qryappname').combobox('setValue','');
}
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