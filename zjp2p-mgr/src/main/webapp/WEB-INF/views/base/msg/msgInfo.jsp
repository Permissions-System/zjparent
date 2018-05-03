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
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:20px 0px 10px 30px">
    	<form id="queryForm" method="post" novalidate>
			<table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px ">
				<tr class="itemMagin">
				    <td><label for="qyReceiver">姓名:</label></td>
	                <td><input id="qyReceiver" name="receiver" class="easyui-validatebox" data-option="required:true" ></td>
	                <td><label for="qyMsgStatus">发送状态:</label></td>
	                <td>
		                <select id="qyMsgStatus"  name="msgStatus" class="easyui-combobox" panelHeight="auto" style="width:192px;" data-option="editable:false,required:true">     
		                	<option value="">全部</option>
		                	<c:forEach items="${msgStatus}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	                <td><label for="qyReceiverMobile">手机号码:</label></td>
	                <td><input id="qyReceiverMobile" onkeyup="this.value=this.value.replace(/\D/g,'')" name="receiverMobile" style="width:160px;" class="easyui-validatebox" data-option="required:true" ></td>
	            </tr>
	            <tr class="itemMagin">
	            	<td><label for="qyReceiverEmail" >邮箱:</label></td>
	 				<td><input id="qyReceiverEmail" name="receiverEmail" class="easyui-validatebox" data-option="required:true" ></td>
	            	<td><label>发送时间:</label></td>
					<td>
						<div>
							<input id="qyTomqTimeBgn" name="tomqTimeBgn" style="width:90px;" class="easyui-datebox" data-option="editable:false,showSeconds:false" >
							<label>-</label>
							<input id="qyTomqTimeEnd" name="tomqTimeEnd" style="width:90px;" class="easyui-datebox" data-option="editable:false,showSeconds:false" >
						</div>
					</td>
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
        <table id="itMsgInfo">
        </table>
    </div>
</div>

<div id="msgInfoDlg" class="easyui-dialog" style="width:660px;height:580px;padding:10px 0px 10px 30px"
        data-options="resizable:false,modal:true" closed="true" buttons="#msginfo-dlg-buttons">
    <form id="msgForm" method="post" novalidate>
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr>
                <td><label for="idReceiver">姓名:</label></td>
                <td><input id="idReceiver" name="receiver" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td>
                <td><label for="idTomqTime">发送时间:</label></td>
                <td><input id="idTomqTime" name="tomqTime" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td>
            </tr>
            <tr>
                <td><label for="idReceiverMobile">手机:</label></td>
                <td><input id="idReceiverMobile" name="receiverMobile" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td>	
            	<td><label for="idProductCode">发送状态:</label></td>
         	    <td>
	                <select id="idMsgStatus" class="easyui-combobox" name="msgStatus" panelHeight="auto" style="width:155px;" data-option="editable:false,required:true">
		                <option value="">请选择...</option>      
		               	<c:forEach items="${msgStatus}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
	            </td>
	        </tr>
            <tr>  
                <td><label for="idReceiverEmail">邮箱:</label></td>
                <td><input id="idReceiverEmail" name="receiverEmail" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td>	      
				<td><label for="idMsgChannel">发送方式:</label></td>
         	    <td>
	                <select id="idMsgChannel" class="easyui-combobox" name="msgChannel" panelHeight="auto" style="width:155px;" data-option="editable:false,required:true">
		                <option value="">请选择...</option>      
		               	<c:forEach items="${msgChannel}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
	            </td>
            </tr>
            <tr>
            	<td><label for="idMsgSubject">消息主题:</label></td>
                <td colspan="3"><input id="idMsgSubject" name="msgSubject" class="easyui-validatebox" style="width:155px;" data-option="required:true" ></td>
            </tr>
            <tr>
            	<td colspan="4" style="width:100%">
	            	<div>
		            	<label>消息内容：</label>
	            	</div>
            	</td>
            </tr>	
        </tbody>
        </table>
    </form>
</div>
<div id="msginfo-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#msgInfoDlg').dialog('close')">关闭</a>
</div>
<div id="msginfo-detailsDlg" class="easyui-dialog" style="width:550px;height:380px;padding:10px 0px 10px 20px"
        data-options="resizable:false,modal:true" closed="true" buttons="#info-dlg-buttons">
	<form id="showMsgForm" method="post" novalidate>
	<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 13px">
		<tbody>
			<tr class="itemMagin">
				<td><label for="showReceiver">姓名:</label></td>
				<td><input type="text" style="width:150px;" id="showReceiver" name="receiver" readonly="readonly"></td>
				<td><label for="showTomqTime">发送时间:</label></td>
				<td><input type="text" style="width:150px;"  id="showTomqTime" name="tomqTime" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td><label for="showReceiverMobile">手机:</label></td>
				<td ><input type="text" style="width:150px;" id="showReceiverMobile" name="receiverMobile" readonly="readonly"></td>
				<td><label for="showMsgStatus">发送状态:</label></td>
				<td ><input type="text" style="width:150px;" id="showMsgStatus" name="msgStatus" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td><label for="showReceiverEmail">邮箱:</label></td>
				<td><input type="text" style="width:150px;" id="showReceiverEmail" name="receiverEmail" readonly="readonly"></td>
				<td><label for="showChannel">发送方式:</label></td>
				<td><input type="text" style="width:150px;" id="showChannel" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td><label for="showMsgSubject">消息主题:</label></td>
				<td colspan='3'><input type="text" style="width:400px;" id="showMsgSubject" name="msgSubject" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td colspan="4" ><label  for="showMsgContent">消息内容:</label></td>
			</tr>
			<tr class="itemMagin">
				<td colspan="4">
                <script type="text/plain" id="showMsgContent"></script>
				</td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
<div id="info-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="infoReturn" onclick="javascript:$('#msginfo-detailsDlg').dialog('close')" >返回</a>
</div>
<script src="${ctx}/static/js/pub/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="${ctx}/static/js/pub/ueditor/ueditor.all.js" type="text/javascript"></script>
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

	// 初始化页面Grid
	initMsgInfoGrid();
	
	// 初始化查询框内日期选择 不可编辑
	$('#qyTomqTimeBgn').datebox({
		editable:false
	});
	$('#qyTomqTimeEnd').datebox({
		editable:false
	});
	
	//qyReceiver
	$("#qyReceiver").keyup( function() {
        inputNameQueryValue_onKeyUp($("#qyReceiver"));
    });
	
	disPagelistOption();
	
	disEditableComboBox();
	
	valideQueryEmail();
	
	initMsgContentEditor();
});


/**
 * 初始化 消息模板内容富文本编辑器
 */
function initMsgContentEditor(){
    //window.UEDITOR_HOME_URL = '/static/js/pub/ueditor/';
    //var editor = new UE.ui.Editor();
    //editor.render("showMsgContent");
    
    var option = {
        initialContent: '',//初始化编辑器的内容
        initialFrameWidth:450,  //初始化编辑器宽度,默认1000，可以设置成百分比
        initialFrameHeight:100,  //初始化编辑器高度,默认320
        autoClearinitialContent:true,  //是否自动清除编辑器初始内容
        
        toolbars:[]
        }
     
    UE.getEditor('showMsgContent',option);
}


function valideQueryEmail(){
	$('#qyReceiverEmail').keyup( function() {
        queryEmailonKeyUp($("#qyReceiverEmail"));
    });
}

function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnQuery = $("#btnQuery");

    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag =="0"){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 校验查询用邮箱输入框 控制双字节 和空格字符
 */
function queryEmailonKeyUp(jObject){
    var val = jObject.val();
    // 去除双字节字符(包括汉字在内) (\)\
    val = val.replace(/[\u4E00-\u9FA5]/g, '');
    // ^a-zA-Z0-9\u4E00-\u9FA5\(\)\

    // 替换空格
    val = cgReplaceAll(val, ' ', '');
    jObject.val(val);
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    //$(".pagination-page-list").attr('disabled','disabled');
    $(".pagination-num").attr('disabled','disabled');
}

/**
 * 控制页面内下拉不可编辑
 */
function disEditableComboBox(){

	$("#qyMsgStatus").combobox({
	    editable:false
	});
}


/**
 * 组合查询
 * 条件： 归属产品 produceCode 模板名称 templateName 发送时间是否限制 timeFlag
 * 消息优先级: 
 *
 */
function queryInfo(){
	 
	 var tomqTimeBgn = $('#qyTomqTimeBgn').datebox('getValue');
	 var tomqTimeEnd = $('#qyTomqTimeEnd').datebox('getValue');
	 if(isNotNull(tomqTimeBgn) && isNotNull(tomqTimeEnd)){
		 tomqTimeBgn = cgReplaceAll(tomqTimeBgn,'-','');
		 tomqTimeEnd = cgReplaceAll(tomqTimeEnd,'-','');
		 if(tomqTimeBgn>tomqTimeEnd){
			 showSlideMessage("查询发送截止时间不应小于查询开始时间！");
		     return;
		 }
	 }
	 
	// 为明细分页组件赋值
	// 根据查询组合条件，取记录当前的页面 取第一页数据 load
	$('#itMsgInfo').datagrid('load',{
        receiver: $('#qyReceiver').val(),
        msgStatus: $('#qyMsgStatus').combobox('getValue'),
        receiverMobile: $('#qyReceiverMobile').val(),
        receiverEmail: $('#qyReceiverEmail').val(),
        tomqTimeBgn:cgReplaceAll($('#qyTomqTimeBgn').datebox('getValue'),'-',''),
        tomqTimeEnd:cgReplaceAll($('#qyTomqTimeEnd').datebox('getValue'),'-','')
	});
	disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
	$('#queryForm').form('clear');
	$('#qyMsgStatus').combobox('setValue','');
	$('#qyTomqTimeBgn').datebox('setValue','');
	$('#qyTomqTimeEnd').datebox('setValue','');
}
 
/**
 * 重发消息
 */
function rePublishMsgInfo(){
	var rows = $('#itMsgInfo').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要重发的消息！");
		return;
	}
	
    if(rows.length>1){
        showSlideMessage("一次只能重发一条消息，请确认！");
        return;
    }
	
	var recCodes = [];
	for(var i = 0;i<rows.length;i++){
		recCodes.push(rows[i].recNo);
	}
	// 拼接需要发布
	var recNos = recCodes.join(',');
	
	$.messager.confirm('确认','确定重新发布当前选择的消息?',function(r){
        if (r){
        	jQuery.ajax({
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgInfo/rePublishMsgInfo",
    	        data : {
    	        	ids:recNos
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("发送成功");
    	        	   // 重新加载
    	        	   $('#itMsgInfo').datagrid('reload');
    	           }else{
    	        	   showSlideMessage("发送失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("重发消息过程中发生异常，请确认！");
    	        },
    	        datatype : "json"
        	});
        }
    });
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
 * 传入记录主键 查询明细数据
 */
function showDetails(val){
	var editor = UE.getEditor('showMsgContent');
	editor.setDisabled();

	// 取消
	$("input",$("#showMsgForm")).css("border","0px")
	//$(".edui-editor-toolbarboxouter",$("#showMsgForm")).remove();
	
	$('#msginfo-detailsDlg').dialog('open').dialog('setTitle','消息详情');
	
	jQuery.ajax({
		
		type : "POST",
        async: false,
        url : "${ctx}/base/msgInfo/getMsgInfo",
        data : {
        	id:val
        },
        success : function(data) {
          if(data.message=='success'){
        	  /**$("span[id=showReceiver]").text(data.receiver);
        	  $("span[id=showTomqTime]").text(data.tomqTime);
        	  $("span[id=showReceiverMobile]").text(data.receiverMobile);
        	  $("span[id=showMsgStatus]").text(data.msgStatusDesc);
        	  $("span[id=showReceiverEmail]").text(data.receiverEmail);
        	  $("span[id=showChannel]").text(data.msgChannelDesc);
        	  $("span[id=showMsgSubject]").text(data.msgSubject);
        	  $("span[id=showMsgContent]").html(data.msgContent);
        	  **/
        	  $("#showReceiver").val(data.receiver);
        	  $("#showTomqTime").val(data.tomqTime);
        	  $("#showReceiverMobile").val(data.receiverMobile);
        	  $("#showMsgStatus").val(data.msgStatusDesc);
        	  $("#showReceiverEmail").val(data.receiverEmail);
        	  $("#showChannel").val(data.msgChannelDesc);
        	  $("#showMsgSubject").val(data.msgSubject);
        	  editor.setContent(data.msgContent);
        	  
           }else{
        	   showSlideMessage("加载数据失败！");
           }
        },
        error : function(data) {
        	 showSlideMessage("加载数据过程发生异常，请确认！");
        },
        datatype : "json"
	});
}

 /**
  * js初始化页面DataGrid
  */
function initMsgInfoGrid(){
	$("#itMsgInfo").datagrid({
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
		singleSelect:false,
		fit:true,
		url: '${ctx}/base/msgInfo/getMsgInfoList',
		onDblClickRow:function(rowIndex, rowData){

		},
		columns:[[
				  {title:'主键',field:'recNo',width:100,checkbox:true},
				  {title:'姓名',field:'receiver',width:100},
				  {title:'手机',field:'receiverMobile',width:100},
				  {title:'邮箱',field:'receiverEmail',width:100},
				  {title:'消息主题',field:'msgSubject',width:100},
				  {title:'消息内容',field:'msgContent',width:150,hidden:true},
				  {title:'发送时间',field:'tomqTime',width:100},
		          {title:'发送方式',field:'msgChannel',width:40,hidden:true},
		          {title:'发送方式',field:'msgChannelDesc',width:40},
		          {title:'发送状态',field:'msgStatus',width:60,hidden:true},
		          {title:'发送状态',field:'msgStatusDesc',width:60},
		          {title:'操作',field:'id',width:35,align:'center',
		  			formatter : function(value, row, index) {
		  				var opt='';
		  				opt += '<a href="javascript:void(0);" val="'+value+'" onclick="showDetails(\''+value +'\')" class="easyui-linkbutton">查看>></a>';
		  				return opt;
		  			} 
		          }
		      ]],
		toolbar:[{
				text:'重发',
		           iconCls:'icon-edit',
		           handler:function(){
		           	  rePublishMsgInfo();
		        }
			}
		]
	});
}
</script>
</body>
</html>