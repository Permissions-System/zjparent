<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:110px;padding:20px 0px 10px 30px">
        <form id="queryForm" method="post" novalidate>
            <table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
                <tr class="itemMagin">
                    <td><label for="qyProductCode">归属产品:</label></td>
                    <td>
                        <select id="qyProductCode"  name="productCode" panelHeight="auto" class="easyui-combobox" style="width:155px;" >     
                            <option value="">全部</option>
                            <c:forEach items="${productCode}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><label for="qyErrorCode">错误码:</label></td>
                    <td><input id="qyErrorCode" name="errorCode" style="width:160px;" class="easyui-validatebox"></td>
                    <td><label for="qyAutoAdjustment">自适应类型:</label></td>
                    <td>
                        <select id="qyAutoAdjustment"  name="autoAdjustment" panelHeight="auto" class="easyui-combobox" style="width:155px;" data-option="editable:false">     
                            <option value="">全部</option>
                            <c:forEach items="${adjustmentType}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
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
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itErrorLogInfo" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
        </table>
    </div>
</div>

<div id="errorLogMonitorDlg" class="easyui-dialog" style="width:430px;height:250px;padding:10px 0px 10px 30px"
        data-options="resizable:false,modal:true" closed="true" buttons="#errorLogMonitor-dlg-buttons">
    <form id="errorLogMonitorForm" method="post">
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr class="itemMagin">
                <td><label for="idErrorCode">错误码:</label></td>
                <td><input id="idErrorCode" name="errorCode"  class="easyui-validatebox" style="width:155px;">
                <a href="#" class="easyui-linkbutton hidden-errorcode" id="findErrors" >选择</a></td> 
            </tr>
            <tr class="itemMagin">
                <td><label for="idCycleThreshold">周期阀值:</label></td>
                <td><input id="idCycleThreshold" name="cycleThreshold" class="easyui-validatebox" style="width:155px;"></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idDayThreshold">每日阀值:</label></td>
                <td><input id="idDayThreshold" name="dayThreshold" class="easyui-validatebox" style="width:155px;"  ></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idAutoAdjustment">自适应类型:</label></td>
                <td>
                    <select id="idAutoAdjustment" class="easyui-combobox" panelHeight="auto" name="autoAdjustment" style="width:155px;" data-option="editable:false">
                        <c:forEach items="${adjustmentType}" var="item">
                            <option value="${item.configCode}">${item.configName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idThresholdRate">阀值比率:</label></td>
                <td><input id="idThresholdRate" name="thresholdRate" class="easyui-validatebox" style="width:155px;" data-options="validType:['rateValid','length[0,5]']"></td>
            </tr>
        </tbody>
        </table>
    </form>
</div>
<div id="errorLogMonitor-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="errorLogSave" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#errorLogMonitorDlg').dialog('close')">关闭</a>
</div>

<div id="errorCodeInfoDlg" class="easyui-dialog" style="width:740px;height:500px;padding:0px 0px 0px 0px"
        data-options="resizable:false,modal:true" closed="true" buttons="#edit-errorInfo-dlg-buttons">
    <div class="easyui-layout" data-options="fit:true,selected:true">
	    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:80px;padding:10px 0px 10px 30px">
		    <form id="queryErrorCodeForm" method="post" novalidate>
		        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:10px 0px 10px 30px">
			        <tbody>
			            <tr class="fitem">
			                <td><label for="erProductCode">归属产品:</label></td>
			                <td>
			                    <select id="erProductCode"  name="productCode" panelHeight="auto" class="easyui-combobox" style="width:120px;" data-option="editable:false">
			                        <option value="">全部</option>
			                        <c:forEach items="${productCode}" var="item">
			                            <option value="${item.configCode}">${item.configName}</option>
			                        </c:forEach>
			                    </select>
			                </td>
			                <td><label for="erErrorCode">错误码:</label></td>
			                <td><input id="erErrorCode" style="width:140px;" name="errorCode" class="easyui-validatebox"></td>
			                <td><label for="erUserDesc">错误用户描述:</label></td>
			                <td><input id="erUserDesc" style="width:140px;"  name="errorUserDesc" class="easyui-validatebox"></td>
			                <td><a id="selectErrorCode" href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a></td>
			            </tr>
		            </tbody>
		        </table>
	        </form>
	    </div>
	    <div data-options="region:'center',border:true,title:'列表'">
	        <table id="queryErrorList" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
	        </table>
        </div>
    </div>
</div>
<div id="edit-errorInfo-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="addErrorCode">添加</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="addCancel">取消</a>
</div>

<script type="text/javascript">
var isOpenFlag = "0";


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
    
    // 弹出框 保存按钮处理事件
    $("#errorLogSave").bind("click", function(){
        saveErrorLogInfo();
    });
    
    // 绑定按钮 打开错误码列表供配置选择
    $("#findErrors").bind("click", function(){
    	openErrorList();
    });

    // 初始化页面Grid
    initErrorLogGrid();
    
    initQueryErrorListGrid();
    
    disPagelistOption();
    
    disEditableComboBox();
    
    // 类型Dialog弹出框关闭处理
    $('#errorLogMonitorDlg').dialog({
        onOpen:function(){
            isOpenFlag = "1";
        },
        onClose:function(){
            isOpenFlag = "0";
        }
    });
    
    // 周期阀值 限制只数字输入
    $("#idCycleThreshold").keyup( function() {
    	validateNum_onKeyUp($("#idCycleThreshold"));
    });
    
    // 每日阀值 限制只数字输入
    $("#idDayThreshold").keyup( function() {
        validateNum_onKeyUp($("#idDayThreshold"));
    });
    
    $("#idErrorCode").focus(function(){
        //openErrorList();
    });
    
    // 错误码查询DLG打开和关闭事件定义
    $('#errorCodeInfoDlg').dialog({
        onOpen:function(){
        	// 清空搜索条件
        	queryErrCodeCancel();
        	// 搜索框 搜索错误列表 支持Enter查询
        	isOpenFlag = "2";
        },
        onClose:function(){
        	// 错误码选择列表关闭 恢复 新增或修改弹出页面的 Enter查询
        	isOpenFlag = "1";
        }
    });
    
    // 错误码搜索DLG内的查询按钮绑定事件
    $("#selectErrorCode").bind("click", function(){
        queryErrorCodeInfo();
    });
    
    // 选择错误增加到新增DLG
    $("#addErrorCode").bind("click", function(){
    	addErrorLogInfo();
    	//saveErrorLogInfo();
    });
    // 新增错误取消按钮绑定事件 
    $("#addCancel").bind("click", function(){
    	$('#errorCodeInfoDlg').dialog('close');
    });
    
    requiredBox();
});


function requiredBox(){
	$('#idErrorCode').validatebox({    
		required: true
	});
	$('#idCycleThreshold').validatebox({    
        required: true
    });
	$('#idDayThreshold').validatebox({    
        required: true
    });
    $('#idAutoAdjustment').combobox({    
        required: true
    });
	
}

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#errorLogSave");
    var btnQuery = $("#btnQuery");
    var btnErrorQuery = $("#selectErrorCode");
    // 点击 Enter按钮
    if(event.keyCode == 13 && isOpenFlag =="1"){
        btnOjb.click();
        event.returnValue = false;
    }
    
    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag =="0"){
        btnQuery.click();
        event.returnValue = false;
    }
    
    // 查询错误码的 Enter
    if(event.keyCode == 13 && isOpenFlag =="2"){
    	btnErrorQuery.click();
        event.returnValue = false;
    }
    
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    $(".pagination-num").attr('disabled','disabled');
}

/**
 * 键入弹出 错误码选择页面
 */
function openErrorList(){
	$('#errorCodeInfoDlg').dialog('open').dialog('setTitle','错误码列表');
	queryErrorCodeInfo();
}

/**
 * 控制页面内下拉不可编辑
 */
function disEditableComboBox(){
    $("#qyProductCode").combobox({
        editable:false
    });
    
    $("#qyAutoAdjustment").combobox({
        editable:false
    });
   
    $("#idAutoAdjustment").combobox({
        editable:false
    });
}

/**
 * 组合查询
 *
 */
function queryInfo(){
    // 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#itErrorLogInfo').datagrid('load',{
        productCode: $('#qyProductCode').combobox('getValue'),
        errorCode: $('#qyErrorCode').val(),
        autoAdjustment: $('#qyAutoAdjustment').combobox('getValue')
    });
    disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
    $('#queryForm').form('clear');
    $('#qyProductCode').combobox('setValue','');
    $('#qyAutoAdjustment').combobox('setValue','');
}
 
/**
 * 新增数据，修改数据，统一保存
 */
function saveErrorLogInfo(){
    // 判断 新增或修改
    var action = $('#errorLogSave').data('action');
    // 避暑校验不通过 新增或修改 对必输项进行校验
    if(!checkValiErrorMont()){
        return ;
    }
    // 判断 新增  或 修改
    if(action=='insert'){
        // AJAX 提交
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/errorlogMonitor/insert",
            data : {
            	// 错误码
            	errorCode: $("#idErrorCode").val(),
            	// 周期阀值
            	cycleThreshold: $("#idCycleThreshold").val(),
            	// 每日阀值
            	dayThreshold: $("#idDayThreshold").val(),
            	// 周期出错数 必输项 默认值零
            	cycleNum: '0',
            	// 当日累计出错数  必输项 默认值零
            	dayNum:'0',
            	// 统计次数 必输项 默认值零
            	totalTimes:'0',
            	// 是否自适应
            	autoAdjustment:$("#idAutoAdjustment").combobox('getValue'),
            	//时间
            	// 统计天数 必输项 默认值零
            	totalDays:'0',
            	//阀值比率,非必输
            	thresholdRate:$("#idThresholdRate").val()
            	
            },
            success : function(data) {
               if(data.message=='exist'){
                   showSlideMessage("监控错误码已配置，请确认！");
               }else if(data.message=='success'){
                   // close dialog
                   $('#errorLogMonitorDlg').dialog('close'); 
                   showSlideMessage("保存成功");
                   $('#itErrorLogInfo').datagrid('load');
                   disPagelistOption();
               }else{
                   showSlideMessage("保存异常！");
               }
            },
            error : function(data) {
                 showSlideMessage("保存失败！");
            },
            datatype : "json"
        });
    	
    }else{
    	
    	// 修改
        jQuery.ajax({
            type : "POST",
            async: false,
            url : "${ctx}/base/errorlogMonitor/update",
            data : {
            	// 错误码
                errorCode: $("#idErrorCode").val(),
                // 周期阀值
                cycleThreshold: $("#idCycleThreshold").val(),
                // 每日阀值
                dayThreshold: $("#idDayThreshold").val(),
                // 是否自适应
                autoAdjustment:$("#idAutoAdjustment").combobox('getValue'),
             	// 阀值比率
                thresholdRate: $("#idThresholdRate").val()
            },
            success : function(data) {
               if(data.message=='success'){
                   // close dialog
                   $('#errorLogMonitorDlg').dialog('close'); 
                   showSlideMessage("修改成功");
                   $('#itErrorLogInfo').datagrid('reload');
                   disPagelistOption();
               }else{
                   showSlideMessage("保存异常！");
               }
            },
            error : function(data) {
                 showSlideMessage("修改失败！");
            },
            datatype : "json"
        });	
    }
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

/**
 * 新增数据
 */
function newErrorLogInfo(){
    $('#errorLogMonitorDlg').dialog('open').dialog('setTitle','新增配置');
    $('#errorLogMonitorForm').form('clear');
    $('#errorLogMonitorForm').find('[name=errorCode]').attr('readonly','readonly');
    // 保存按钮 暂存数据
    $('#errorLogSave').data("action","insert");
    //$('#errorLogMonitorForm').find('[name=errorCode]').attr('disabled','disabled');
	$('#idErrorCode').css("color", "#000000");
    $(".hidden-errorcode").css("display","none").css("display","inline-block");
}

/**
 * 编辑数据
 */
function editErrorLogInfo(){
	
	var rows = $('#itErrorLogInfo').datagrid('getSelected');
    if(!rows){
        showSlideMessage("请选择需要编辑的配置记录！");
        return;
    }
    if(isNull(rows.thresholdRate)){
    	rows.thresholdRate='';
    }
    
    $('#errorLogMonitorDlg').dialog('open').dialog('setTitle','修改配置');
    $('#errorLogMonitorForm').find('[name=errorCode]').attr('readonly','readonly');
    //$('#errorLogMonitorForm').find('[name=errorCode]').attr('disabled','disabled');
    $('#errorLogMonitorForm').form('clear');
    $('#errorLogMonitorForm').form('load',rows);
    $('#errorLogMonitorForm').find('[name=errorCode]').val(rows.errorCode);
    $('#idErrorCode').val(rows.errorCode);
    $(".hidden-errorcode").css("display","inline-block").css("display","none");
    
    $('#idErrorCode').css("color", "#9E9E9E");
    // 保存操作类型数据 
    $("#errorLogSave").data("action","update");
    
}

/**
 * 删除数据
 */
function rmErrorLogInfo(){
	var row = $('#itErrorLogInfo').datagrid('getSelected');
    if(!row){
        // 未选择记录，给出侧边栏提示 需要选择记录
        showSlideMessage("请选择数据需要删除的记录！");
        return;
    }
    $.messager.confirm('确认','确定删除当前选择的配置信息?',function(r){
        if (r){
            jQuery.ajax({
                
                type : "POST",
                async: false,
                url : "${ctx}/base/errorlogMonitor/delete",
                data : {
                	errorCode:row.errorCode
                },
                success : function(data) {
                  if(data.message=='success'){
                       showSlideMessage("删除成功!");
                       // 重新加载
                       $('#itErrorLogInfo').datagrid('load');
                       disPagelistOption();
                   }else{
                       showSlideMessage("删除失败！");
                   }
                },
                error : function(data) {
                     showSlideMessage("删除过程发生异常！");
                },
                datatype : "json"
            });
        }
    });
}

/**
 * 新增和修改 对必输项做校验控制
 * 归属产品，模板代码，模板名称，模板主题，模板内容
 */
function checkValiErrorMont(){
	
    var val = "",ct=0;
    
    // 错误码
    val = $("#idErrorCode").val();
    if(isNull(val)){
        showSlideMessage("请选择 错误码！");
        return false;
    }
    
    /*长度校验*/
    if(val.length!=8){
        showSlideMessage("错误码应为8个字符,请确认！");
        return false;
    }
    
    // 交易名称
    val = $("#idCycleThreshold").val();
    if(isNull(val)){
        showSlideMessage("请输入 周期阀值！");
        return false;
    }
    
    // 每日阀值
    val = $("#idDayThreshold").val();
    if(isNull(val)){
        showSlideMessage("请输入 每日阀值！");
        return false;
    }
    
    // 是否自适应
    val = $("#idAutoAdjustment").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选消是否自适应！");
        return false;
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}

/**
 * js初始化页面DataGrid
 */
function initErrorLogGrid(){
    $("#itErrorLogInfo").datagrid({
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
        url: '${ctx}/base/errorlogMonitor/getLogMonitorInfoList',
        onDblClickRow:function(rowIndex, rowData){
        	editErrorLogInfo();
        },
        columns:[[
                  {title:'归属产品',field:'productName',width:100},
                  {title:'错误码',field:'errorCode',width:100},
                  {title:'归属产品',field:'productCode',width:100,hidden:true},
                  {title:'周期阀值',field:'cycleThreshold',width:100},
                  {title:'每日阀值',field:'dayThreshold',width:100},
                  {title:'是否自适应',field:'autoAdjustment',width:100,hidden:true},
                  {title:'自适应类型',field:'autoAdjustmentDesc',width:100},
                  {title:'阀值比率',field:'thresholdRate',width:100,
                	  formatter: function(value,row,index){
      					if(isNull(value)){
      						return '';
      					}
      					return value;
      				}  
                  }
              ]],
        toolbar:[{
	            text:'新增',
	            iconCls:'icon-add',
	            handler:function(){
	            	   newErrorLogInfo();
            }},'-',{
                   text:'修改',
                   iconCls:'icon-edit',
                   handler:function(){
                	   editErrorLogInfo();
                   }
            },'-',{
                     text:'删除',
                     iconCls:'icon-remove',
                     handler:function(){
                        rmErrorLogInfo();
                     }
            }
        ]
    });
}
 
/**
 * js初始化弹出框页面DataGrid
 */
function initQueryErrorListGrid(){
    $("#queryErrorList").datagrid({
        pagination:true,
        rownumbers:true,
        pageSize:10,
        pageNumber:1,
        pageList:[10],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        url: '${ctx}/base/errorlogMonitor/getErrorCodeInfoList',
        onDblClickRow:function(rowIndex, rowData){
            addErrorLogInfo();
        },
        columns:[[
                  {title:'归属产品',field:'productName',width:50},
                  {title:'错误码',field:'errorCode',width:60},
                  {title:'归属产品',field:'productCode',width:100,hidden:true},
                  {title:'错误系统描述',field:'errorSysDesc',width:150},
                  {title:'错误用户描述',field:'errorUserDesc',width:150}//,
                  // Start 测试模拟数据添加 测试完成后 改部分代码删除
                  /**{title:'模拟插入错误码',field:'id',width:100,align:'center',
                      formatter : function(value, row, index) {
                          var opt='';
                          opt += '<a href="javascript:void(0);" val="'+value+'" onclick="showDetails(\''+value +'\')" class="easyui-linkbutton">插入模拟数据>></a>';
                          return opt;
                          } 
                  }**/
                  // End 模拟测试数据添加 测试完成后 改部分代码删除
              ]]
    });
}

// Start 测试模拟数据添加 测试完成后 改部分代码删除
function showDetails(errorCode){
	jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/errorlogMonitor/moniInsertCode",
        data : {
            errorCode:errorCode
        },
        success : function(data) {
        	showSlideMessage(errorCode  + "插入模拟错误日志成功");
        },
        error : function(data) {
            showSlideMessage("插入模拟错误日志过程发生异常，请确认！");
        },
        datatype : "json"
    });
}
// End 模拟测试数据添加 测试完成后 改部分代码删除

/**
 * 错误码Dlg关闭 或者取消关闭时，清空搜索框的内的可能存在的数据
 */
function queryErrCodeCancel(){
    $('#queryErrorCodeForm').form('clear');
    $('#erProductCode').combobox('setValue','');

}

/**
 * 选择的错误新增到新增列表中
 */
function addErrorLogInfo(){
    var row = $('#queryErrorList').datagrid('getSelected');
    if (!row) {
        showSlideMessage("请选择需要监控的错误码！");
        return;
    }
    
    // 当前选择的错误码
    var errorCode = row.errorCode;
    // 首先ajax判断 错误码是否已配置，已配置的不增加，选择DLG依然保留，如果不存在，DLG关闭，将该值填入新增的错误码文本框内
    // 默认数据不存在
    var valiFlag = false;
    jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/errorlogMonitor/getCountCodeInfo",
        data : {
        	errorCode:errorCode
        },
        success : function(data) {
          if(data.message=='Y'){
              //模板内容
        	  showSlideMessage("错误码"+errorCode+"已配置，请确认！");
              
           }else{
        	   // 选择错误DLG关闭
        	   $('#errorCodeInfoDlg').dialog('close');
        	   
        	   // 复制 错误到 新增页面
        	   $('#idErrorCode').val(errorCode);
           }
        },
        error : function(data) {
            showSlideMessage("加载消息内容数据过程发生异常，请确认！");
        },
        datatype : "json"
    });	
}

/**
 * 错误码列表 查询按钮
 */
function queryErrorCodeInfo(){
    $('#queryErrorList').datagrid('load',{
    	prdType: $('#erProductCode').combobox('getValue'),
        errorCode: $('#erErrorCode').val(),
        errorUserDesc: $('#erUserDesc').val()
    });
    disPagelistOption();
}

function validateNum_onKeyUp(jObject) {
    var val = jObject.val();
    // 代码类型数字 
    val = val.replace(/[^0-9]/g, '');
    // 替换空格
    val = cgReplaceAll(val, ' ', '');
    jObject.val(val);
}

$.extend($.fn.validatebox.defaults.rules, {    
	rateValid: {        
		validator: function(value, param){
			return isFloat(value);
		},
		message: '输入内容应为正整数或浮点数'
	}
});
</script>
</body>
</html>