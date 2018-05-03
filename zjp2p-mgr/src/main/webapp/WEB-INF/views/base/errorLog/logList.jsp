<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
#queryForm table tr {
    height:30px;
}
#logInfoForm table tr {
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr>
                   <td><label for="qyProductCode">产品名称:</label></td>
                   <td>
                   		<select id="qyProductCode" panelHeight="auto" name="productCode" class="easyui-combobox" style="width:155px;" data-option="required:false,editable:false">     
                            <option value="">未选择</option>
                            <c:forEach items="${productCode}" var="item">
   								<option value="${item.configCode}">${item.configName}</option>
   							</c:forEach>
                        </select>
                   </td>
                   <td><label for="qyErrorCode">错误码:</label></td>
                   <td><input id="qyErrorCode" name="errorCode" style="width:155px;" class="easyui-validatebox"></td>
                   <td><label for="qySessionId">SESSION_ID:</label></td>
                   <td><input id="qySessionId" name="sessionId" style="width:220px;" class="easyui-validatebox"></td>
                   <td><label for="qyExeClassName">执行类名:</label></td>
                   <td><input id="qyExeClassName" name="exeClassName" style="width:220px;" class="easyui-validatebox"></td>
                </tr>
                <tr>
                   <td><label for="qyStartDate">开始日期:</label></td>
                   <td><input id="qyStartDate" name="startDate" class="easyui-datetimebox" style="width:155px;" data-options="editable:false" ></td>
                   <td><label for="qyEndDate">结束日期:</label></td>
                   <td><input id="qyEndDate" name="endDate" class="easyui-datetimebox" style="width:155px;" data-options="editable:false"></td>
                   <td><label for="qyErrorDesc">错误描述:</label></td>
                   <td><input id="qyErrorDesc" name="errorDesc" style="width:220px;" class="easyui-validatebox"></td>
                   <td></td>
                   <td>
                       <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
                       <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                   </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="errLogInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
    <div id="errorDescDialog" class="easyui-dialog" title="错误详情" style="width:800px;height:400px;"
        data-options="iconCls:'icon-close',resizable:true,modal:true,closed:true">
        <div id="text"></div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    // 页面初始化
    // 查询按钮绑定事件
    
    $("#btnQuery").bind("click", function(){
        queryInfo();
    });
    // 查询取消按钮事件
    $("#btnCancel").bind("click", function(){
        queryCancel();
    });
    $("#qyProductCode").combobox({
        editable:false
    });
    $('#qyProductCode').combobox('setValue','CP');
    // 初始化页面Grid
    initDataGrid();
    
    disPagelistOption();
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnQuery = $("#btnQuery");

    // 绑定 查询的 Enter
    if(event.keyCode == 13){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    //$(".pagination-page-list").attr('disabled','disabled');
    $(".pagination-num").attr('disabled','disabled');
}

/**
 * 组合查询
 *
 */
function queryInfo(){
	var productCode =$('#qyProductCode').combobox('getValue');
	if(isNull(productCode)&&isNull($('#qyErrorCode').val())){
		showSlideMessage("产品名称和错误码两者不能同时为空！");
		$('#errLogInfo').datagrid('loadData', { rows: [] });
		return;
	}
    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#errLogInfo').datagrid('load',{
        productCode: productCode,
        errorCode:$('#qyErrorCode').val(),
        sessionId: $('#qySessionId').val(),
        exeClassName:$('#qyExeClassName').val(),
        startDate:$('#qyStartDate').datetimebox('getValue'),
        endDate:$('#qyEndDate').datetimebox('getValue'),
        errorDesc:$('#qyErrorDesc').val()
    });
    disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
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

$("#errorDescDialog").dialog({
	onClose:function(){
		$("#text").empty();
	}
});

 /**
  * js初始化页面DataGrid
  */
function initDataGrid(){
    $("#errLogInfo").datagrid({
        pagination:true,
        rownumbers:true,
        pageSize:10,
        pageList:[10,20],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        url: '${ctx}/base/errorLog/log/getLogByPage',
        queryParams: {
        	productCode: 'CP'
    	},
        onSelect:function(rowIndex, rowData){
        },
        onLoadError: function(){
        	showSlideMessage("信息查询失败!");
        },
        columns:[[
            {title:'主键',field:'id',width:60,hidden:true},
            {title:'错误码',field:'errorCode',width:40},
            {title:'SESSION_ID',field:'sessionId',width:100},
            {title:'错误时间',field:'logTime',width:70},
            {title:'错误描述',field:'errorDesc',width:100,
            	formatter : function(value, row, index) {
                    if(value){
                    	if(value.length>20){
                    		var data = value.substr(0,30)+"...";
                    		return data;
                    	}else{
                    		return value;
                    	}
                    }else{
                        return "";
                    }
            	}
            },
            {title:'执行类',field:'exeClassName',width:140},
        ]],
        onLoadSuccess: function(data){
			if(data.total==0){
				showSlideMessage("没有记录。");
			}
			if(data.status=="failed"){
				showSlideMessage("产品名称和错误码两者不能同时为空！");
			}
	    },
        onClickCell: function(index,field,value){
			if(field != 'errorDesc'){
				return;
			}
	 		$("#errorDescDialog").dialog("open");
	 		$("#text").append(value);
	     }
    });
}
</script>
</body>
</html>