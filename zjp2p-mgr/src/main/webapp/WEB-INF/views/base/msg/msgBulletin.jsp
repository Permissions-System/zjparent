<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:25px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:130px;padding:10px 0px 10px 30px">
    	<form id="queryForm" method="post" novalidate>
			<table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px">
				<tr class="itemMagin">
				    <td><label for="qyMsgSubject">公告主题:</label></td>
	                <td><input id="qyMsgSubject" name="msgSubject" style="width:155px;" class="easyui-validatebox" ></td>
	                <td><label for="qyMsgType">公告类型:</label></td>
	                <td>
		                <select id="qyMsgType" panelHeight="auto"  name="msgType" class="easyui-combobox" style="width:155px;" data-option="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${msgType}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	                <td><label for="qyProductCode">归属产品:</label></td>
	                <td>
		                <select id="qyProductCode" class="easyui-combobox"  name="productCode" panelHeight="auto" style="width:155px;" data-option="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${productCode}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	            </tr>
	            <tr class="itemMagin">
	            	<td><label for="qyStartDate" >显示日期（起）:</label></td>
	 				<td><input id="qyStartDate" name="startDate" class="easyui-datebox" style="width:155px;" data-option="editable:false,showSeconds:false" ></td>
	            	<td><label for="qyEndDate" >显示日期（止）:</label></td>
					<td><input id="qyEndDate" name="endDate" class="easyui-datebox"  style="width:155px;" data-option="editable:false,showSeconds:false" ></td>
	           		<td><label for="qyPublishStatus">发布状态:</label></td>
	                <td>
		                <select id="qyPublishStatus"  name="publishStatus"  class="easyui-combobox" panelHeight="auto" style="width:155px;" data-option="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${publishStatus}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	            </tr>
	            <tr class="itemMagin">
	            	<td colspan='5' ></td>
	            	<td>
	            		<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery">查询</a>
	    			    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
	            	</td>
	            </tr>
			</table>
		</form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itMsgBulletin">
        </table>
    </div>
</div>
<div id="msgMsgBulletinInfoDlg" class="easyui-dialog" style="width:660px;height:440px;padding:10px 0px 10px 30px"
        data-options="resizable:false,modal:true" closed="true" buttons="#msgbulletin-dlg-buttons">
    <form id="msgBulletinForm" method="post" novalidate>
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr class="itemMagin">
                <td><label for="idMsgSubject">公告主题:</label></td>
                <td colspan='3'><input id="idMsgSubject" name="msgSubject" required="true" class="easyui-validatebox" style="width:92%;" data-option="required:true" ></td>
            </tr>
            <tr class="itemMagin">
            	<td><label for="idProductCode">归属产品:</label></td>
         	    <td>
	                <select id="idProductCode" class="easyui-combobox" name="productCode" panelHeight="auto" required="true" style="width:155px;" data-option="editable:false">
		               	<c:forEach items="${productCode}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
	            </td>
				<td><label for="idMsgType">公告类型:</label></td>
         	    <td>
	                <select id="idMsgType" class="easyui-combobox" name="msgType" required="true" panelHeight="auto" style="width:155px;" data-option="editable:false,required:true">
		               	<c:forEach items="${msgType}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
	            </td>
            </tr>
            <tr class="itemMagin">
	            <td><label for="idStartDate" >显示日期（起）:</label></td>
	 			<td><input id="idStartDate" name="startDate" class="easyui-datebox" required="true" style="width:155px;" data-option="editable:false,showSeconds:false" ></td>
                <td><label for="idEndDate" >显示日期（止）:</label></td>
			    <td><input id="idEndDate" name="endDate" class="easyui-datebox" required="true" style="width:155px;" data-option="editable:false,showSeconds:false" ></td>
            </tr>
            <tr class="itemMagin">
            	<td colspan="4" style="width:100%">
	            	<div>
		            	<label>公告内容：</label>
		            	<script type="text/plain" id="idMsgContent"></script>
	            	</div>
            	</td>
            </tr>	
            <tr class="itemMagin">
            	<td><label>链接地址：</label></td>
            	<td colspan="3"><input id="idMsgUrl" name="msgUrl" class="easyui-validatebox" style="width:92%;" ></td>
            </tr>
        </tbody>
        </table>
    </form>
</div>
<div id="msgbulletin-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="msgBulletinSave" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#msgMsgBulletinInfoDlg').dialog('close')">取消</a>
</div>
<div id="bulletin-detailsDlg" class="easyui-dialog" style="width:520px;height:390px;padding:10px 0px 10px 20px"
        data-options="resizable:false,modal:true" closed="true" buttons="#info-dlg-buttons">
	<form id="showMsgForm" method="post" novalidate>
	<table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 13px">
		<tbody>
			<tr class="itemMagin">
				<td><label style="width:80px;" for="showMsgSubject">公告主题:</label></td>
				<td colspan="3" style="text-align:left;">
				<input type="text" style="width:350px;" id="showMsgSubject" name="msgSubject" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td><label style="width:80px;" for="showProductCode">归属产品:</label></td>
				<td><input type="text" style="width:150px;" id="showProductCode" readonly="readonly"></td>
				<td><label style="width:80px;" for="showMsgType">公告类型:</label></td>
				<td><input type="text" style="width:150px;" id="showMsgType" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td><label for="showStartDate">发布日期（起）:</label></td>
				<td><input type="text" style="width:150px;" id="showStartDate" readonly="readonly"></td>
				<td><label for="showEndDate">发布日期（止）:</label></td>
				<td><input type="text" style="width:150px;" id="showEndDate" readonly="readonly"></td>
			</tr>
			<tr class="itemMagin">
				<td colspan='4'><label for="showMsgContent">公告内容:</label></td>
			</tr>
			<tr class="itemMagin">
				<td colspan='4'>
				    <script type="text/plain" id="showMsgContent"></script>
				</td>
			</tr>
			<tr class="itemMagin">
				<td><label for="showMsgUrl">链接地址：</label></td>
				<td colspan='3'><span id="showMsgUrl"></span></td>
			</tr>
		</tbody>
	</table>
	</form>
</div>
<div id="info-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="infoReturn" onclick="javascript:$('#bulletin-detailsDlg').dialog('close')" >返回</a>
</div>
<script src="${ctx}/static/js/pub/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="${ctx}/static/js/pub/ueditor/ueditor.all.js" type="text/javascript"></script>
<script type="text/javascript">
var isOpenFlag = "0";

$.extend($.fn.validatebox.defaults.rules, {
    idMsgSubject: {
        validator: function(value, param){
            var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）]');
            return !p.test(value);
        },
        message: '消息主题应由数字、字母、中文字符或括号组成'
    }
});


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
	$("#msgBulletinSave").bind("click", function(){
		saveMsgBulletinInfo();
	});
	
	// 初始化页面Grid
	initMsgBulletinGrid();
	
	// js编辑器初始化
	initMsgContentEditor();
	
	initShowMsgContentEditor();
	
	/*日期控件不可编辑*/
	disEditableDataBox();

	// 控制下拉框不可编辑
	disEditableComboBox();
	
	disPagelistOption();
	
    $("#qyMsgSubject").keyup( function() {
        inputNameQueryValue_onKeyUp($("#qyMsgSubject"));
    });
	
    $("#qyMsgSubject").keyup( function() {
        inputNameValue_onKeyUp($("#qyMsgSubject"));
    });
    
    // 验证banding
    $("#idMsgSubject").validatebox({
    	required: true,
    	validType: 'idMsgSubject[]'
    });
    
    $("#idMsgUrl").keyup( function() {
    	checkWebUrl($("#idMsgUrl"));
    });
    
    // 类型Dialog弹出框关闭处理
    $('#msgMsgBulletinInfoDlg').dialog({
    	onOpen:function(){
    		isOpenFlag = "1";
    	},
        onClose:function(){
            isOpenFlag = "0";
        }
    });
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnOjb = $("#msgBulletinSave");
    var btnQuery = $("#btnQuery");
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
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 控制日期控件不可编辑
 */
function disEditableDataBox(){
	   // 初始化查询框内日期选择 不可编辑
    $('#qyStartDate').datebox({
        editable:false
    });
    $('#qyEndDate').datebox({
        editable:false
    });
    
    // 初始化 dlg的日期控件
    $('#idStartDate').datebox({
        editable:false
    });
    $('#idEndDate').datebox({
        editable:false
    });
	
}

/**
 * 控制页面内下拉不可编辑
 */
function disEditableComboBox(){
	$("#qyMsgType").combobox({
	    editable:false
	});
	
	
    $("#idMsgType").combobox({
        editable:false
    });
    
    $("#qyProductCode").combobox({
        editable:false
    });
    
    $("#idProductCode").combobox({
        editable:false
    });
    
    $("#qyPublishStatus").combobox({
        editable:false
    });
}

/**
 * 初始化 消息模板内容富文本编辑器
 */
function initMsgContentEditor(){
    var option = {
        initialContent: '',//初始化编辑器的内容
        initialFrameWidth:580,  //初始化编辑器宽度,默认1000，可以设置成百分比
        initialFrameHeight:100,  //初始化编辑器高度,默认320
        autoClearinitialContent:true,  //是否自动清除编辑器初始内容
        zIndex : 9000,
        autoHeightEnabled:false,
        scaleEnabled:false,
        toolbars:[['source', '|', 'undo', 'redo', '|',
           'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
           'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
           'fontfamily', 'fontsize', '|',
           'directionalityltr', 'directionalityrtl', 'indent', '|',
           'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 
           'horizontal', 'date', 'time', 'spechars'
        ]]
        }
     
    UE.getEditor('idMsgContent',option);
}

function initShowMsgContentEditor(){
    var option = {
        initialContent: '',//初始化编辑器的内容
        initialFrameWidth:450,  //初始化编辑器宽度,默认1000，可以设置成百分比
        initialFrameHeight:100,  //初始化编辑器高度,默认320
        autoClearinitialContent:true,  //是否自动清除编辑器初始内容
        
        toolbars:[]
        }
     
    UE.getEditor('showMsgContent',option);

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
 * 条件： 归属产品 produceCode 模板名称 templateName 发送时间是否限制 timeFlag
 * 消息优先级: 
 *
 */
function queryInfo(){
	 // 查询新增校验 如果显示日期 起 日期 》 显示日期止 则不允许提交
	 var bgnDate = $('#qyStartDate').datebox('getValue');
	 var endDate = $('#qyEndDate').datebox('getValue');
	 if(isNotNull(bgnDate)&&isNotNull(endDate)){
		 bgnDate = cgReplaceAll(bgnDate,'-','');
		 endDate = cgReplaceAll(endDate,'-','');
		 if(bgnDate>endDate){
	         showSlideMessage("查询日期(止)应不早于查询日期(起)！");
	         return;
		 }
	 }
	 
	// 为明细分页组件赋值
	// 根据查询组合条件，取记录当前的页面 取第一页数据 load
	$('#itMsgBulletin').datagrid('load',{
        productCode: $('#qyProductCode').combobox('getValue'),
        msgSubject: $('#qyMsgSubject').val(),
        msgType: $('#qyMsgType').combobox('getValue'),
        startDate:cgReplaceAll($('#qyStartDate').datebox('getValue'),'-',''),
        endDate:cgReplaceAll($('#qyEndDate').datebox('getValue'),'-',''),
        publishStatus: $('#qyPublishStatus').combobox('getValue')
	});
	disPagelistOption();
}

/**
 * 清空查询条件
 */
function queryCancel(){
	$('#queryForm').form('clear');
	$('#qyProductCode').combobox('setValue','');
	$('#qyMsgType').combobox('setValue','');
	$('#qyStartDate').datebox('setValue','');
	$('#qyEndDate').datebox('setValue','');
	$('#publishStatus').combobox('setValue','');
}
 
/**
 * 新增 公告
 */
function newBulletinInfo(){

    $('#msgMsgBulletinInfoDlg').dialog('open').dialog('setTitle','新增公告');
    $('#msgBulletinForm').form('clear');
    
    $('#idProductCode').combobox('setValue','');
    $('#idMsgType').combobox('setValue','');
    
    // 保存按钮暂存数据 Insert
    $('#msgBulletinSave').data("action","insert");
	var editor = UE.getEditor('idMsgContent');
	editor.setContent('');
}
 
 /**
  * 修改 公告
  */
function editBulletinInfo(){

	var rows = $('#itMsgBulletin').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择修改修改的公告信息！");
		return;
	}else if(rows.length>1){
		showSlideMessage("请选择一条的需要修改的公告记录！");
		return;
	}else{
		//只选择一条的情况
		var row = $('#itMsgBulletin').datagrid('getSelected');
		if(row){
		 // 双击事件中处理具体修改事项
		 onDblClickGrid(row);
		}
	}
}

/**
 * 删除一条或者同时删除多条记录
 */
function removeBulletinInfo(){
	var rows = $('#itMsgBulletin').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要删除的公告信息！");
		return;
	}
	
	var recCodes = [];
	for(var i = 0;i<rows.length;i++){
		recCodes.push(rows[i].recNo);
	}
	var deleteCodes = recCodes.join(',');
    $.messager.confirm('确认','确定删除当前选择的'+rows.length+'条公告信息?',function(r){
        if (r){
        	jQuery.ajax({
        		
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgBulletin/deleteBatch",
    	        data : {
    	        	ids:deleteCodes
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("删除成功");
    	        	   // 重新加载
    	        	   $('#itMsgBulletin').datagrid('load');
    	        	   disPagelistOption();
    	           }else{
    	        	   showSlideMessage("删除失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("删除过程发生异常，请确认！");
    	        },
    	        datatype : "json"
        	});
        }
    });
} 
 
/**
 * 新增消息模板，修改消息模板，统一保存
 */
function saveMsgBulletinInfo(){
	var editor = UE.getEditor('idMsgContent');

	// 判断 新增或修改
	var action = $('#msgBulletinSave').data('action');
		// 必输项 校验不通过 新增或修改 对必输项进行校验
	if(!ckValiMsgBulletin()){
		return ;
	}
	// 新增数据 
	if(action=='insert'){
		// AJAX 提交 PUBLISH_CHANNEL = '1'
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : "${ctx}/base/msgBulletin/insert",
	        data : {
	        	msgSubject: $("#idMsgSubject").val(),
	        	productCode: $("#idProductCode").combobox('getValue'),
	        	msgType: $("#idMsgType").combobox('getValue'),
	        	startDate: cgReplaceAll($("#idStartDate").datebox('getValue'),'-',''),
	        	endDate: cgReplaceAll($("#idEndDate").datebox('getValue'),'-',''),
	        	publishStatus:'0',
	        	publishChannel:'1',
	        	msgContent: editor.getContent(),
	        	msgUrl: $("#idMsgUrl").val()
	        },
	        success : function(data) {
	           if(data.message=='success'){
	        	   // close dialog
	        	   $('#msgMsgBulletinInfoDlg').dialog('close'); 
	        	   showSlideMessage("保存成功");
	        	   $('#itMsgBulletin').datagrid('load');
	        	   disPagelistOption();
	           }else{
	        	   showSlideMessage("保存失败！");
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("保存失败！");
	        },
	        datatype : "json"
		});
	}else{
		var row = $('#itMsgBulletin').datagrid('getSelected');
		
		// 修改数据
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : "${ctx}/base/msgBulletin/update",
	        data : {
	        	recNo:row.recNo,
	        	msgSubject: $("#idMsgSubject").val(),
	        	productCode: $("#idProductCode").combobox('getValue'),
	        	msgType: $("#idMsgType").combobox('getValue'),
	        	startDate: cgReplaceAll($("#idStartDate").datebox('getValue'),'-',''),
	        	endDate: cgReplaceAll($("#idEndDate").datebox('getValue'),'-',''),
	        	publishStatus:row.publishStatus,
	        	publishChannel:row.publishChannel,
	        	msgContent: editor.getContent(),
	        	msgUrl: $("#idMsgUrl").val()
	        },
	        success : function(data) {
	           if(data.message=='success'){
	        	   // close dialog
	        	   $('#msgMsgBulletinInfoDlg').dialog('close'); 
	        	   showSlideMessage("修改成功");
	        	   $('#itMsgBulletin').datagrid('reload');
	        	   disPagelistOption();
	           }else{
	        	   showSlideMessage("修改失败！");
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("修改失败！");
	        },
	        datatype : "json"
		});
	}
}
 
/**
 * 双击多选Grid事 做编辑前的判断
 */
function onDblClickGrid(rowData){
	var editor = UE.getEditor('idMsgContent');
	// 修改标题 模块代码不可编辑
	$('#msgMsgBulletinInfoDlg').dialog('open').dialog('setTitle','修改公告');
	$('#msgBulletinForm').form('clear');
	editor.setContent('');
	
	
	
	$('#msgBulletinForm').form('load',rowData);
	editor.setContent(rowData.msgContent);
	
	// 保存操作类型数据
	$("#msgBulletinSave").data("action","update");
}

/**
 * 发布公告
 */
function publishBulletinInfo(){
	var rows = $('#itMsgBulletin').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要发布的公告信息！");
		return;
	}
	
	var ckStatus = true;
	 
	var recCodes = [];
	for(var i = 0;i<rows.length;i++){
		// 发布状态未已发布 不能再次发布
		if(rows[i].publishStatus=='1'){
			// 找到已发布的记录，校验不通过
			ckStatus = false;
			break;
		}
	}
	// 只选择一条的情况
	if(!ckStatus){
		if(rows.length==1){
			showSlideMessage("该公告已发布，无需再次发布,请确认!");
		}else{
			showSlideMessage("选择的公告中存在已发布的公告，已发布公告无需再次发布，请确认！");
		}
		return;
	}
	
	for(var i = 0;i<rows.length;i++){
		recCodes.push(rows[i].recNo);
	}
	// 拼接需要发布
	var recNos = recCodes.join(',');
	
	$.messager.confirm('确认','确定发布当前选择的公告信息?',function(r){
        if (r){
        	jQuery.ajax({
        		
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgBulletin/updateBatch",
    	        data : {
    	        	recNos:recNos
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("发布成功");
    	        	   // 重新加载
    	        	   $('#itMsgBulletin').datagrid('reload');
    	        	   disPagelistOption();
    	           }else{
    	        	   showSlideMessage("发布失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("发布过程发生异常，请确认！");
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
function ckValiMsgBulletin(){
    var val = "",ct=0;
    
    // 消息主题
    val = $("#idMsgSubject").val();
    if(isNull(val)){
        showSlideMessage("请输入 公告主题！");
        return false;
        ct++;
    }
    
    var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）]');
    if(p.test(val)){
        showSlideMessage("消息主题应由数字、字母、中文字符或括号组成！");
        return false;
    }
    
    if(val.length<=0 || val.length>100){
        showSlideMessage("公告主题不应超过100个字符,请确认！");
        return false;
        ct++;
    }
    
    // 归属产品代码
    val = $("#idProductCode").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择 归属产品！");
        return false;
        ct++;
    }
 
    // 公告类型
    val = $("#idMsgType").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择 公告类型！");
        return false;
        ct++;
    }
    
    
    val = $("#idStartDate").datebox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择 显示起始日期！");
        return false;
        ct++;
    }
    
    val = $("#idEndDate").datebox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择 显示结束日期！");
        return false;
        ct++;
    }
    
    var bgnDate = $('#idStartDate').datebox('getValue');
    var endDate = $('#idEndDate').datebox('getValue');
    if(isNotNull(bgnDate)&&isNotNull(endDate)){
        bgnDate = cgReplaceAll(bgnDate,'-','');
        endDate = cgReplaceAll(endDate,'-','');
        if(bgnDate>endDate){
            showSlideMessage("显示日期(止) 应不早于 显示日期(起)！");
            return false;
            ct++;
        }
    }
    
    var editor = UE.getEditor('idMsgContent');
	val = editor.getContent();
    
    if(isNull(val)){
        showSlideMessage("请编辑 公告内容！");
        return false;
        ct++;
    }
    
    if(val.length<=0 || val.length>1300){
        showSlideMessage("消息主题不应超过1300个字符,请确认！");
        return false;
        ct++;
    }
    
    // URL长度校验
    
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}
 
 
function checkWebUrl(jObject){
    var val = jObject.val();
    val = val.replace(/[^a-zA-Z0-9_&\.%\u4E00-\u9FA5]/g, '');
    val = cgReplaceAll(val, ' ', '');
    jObject.val(val);
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
	
	
	$('#bulletin-detailsDlg').dialog('open').dialog('setTitle','公告详情');
	
	jQuery.ajax({
		
		type : "POST",
        async: false,
        url : "${ctx}/base/msgBulletin/getMsgBulletinInfo",
        data : {
        	id:val
        },
        success : function(data) {
          if(data.message=='success'){
        	  
        	  /**$("span[id=showMsgSubject]").text(data.msgSubject);
        	  $("span[id=showProductCode]").text(data.productName);
        	  $("span[id=showMsgType]").text(data.msgTypeDesc);
        	  $("span[id=showStartDate]").text(data.startDateDesc);
        	  $("span[id=showEndDate]").text(data.endDateDesc);
        	  $("span[id=showMsgContent]").html(data.msgContent);
        	  // 链接地址
        	  $("span[id=showMsgUrl]").html('<a href="'+data.msgUrl+'">'+data.msgUrl+'</a>');
        	  **/
        	  $("#showMsgSubject").val(data.msgSubject);
        	  $("#showProductCode").val(data.productName);
        	  $("#showMsgType").val(data.msgTypeDesc);
        	  $("#showStartDate").val(data.startDateDesc);
        	  $("#showEndDate").val(data.endDateDesc);
        	  editor.setContent(data.msgContent);
        	  $("span[id=showMsgUrl]").html('<a href="'+data.msgUrl+'">'+data.msgUrl+'</a>');
        	  
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
function initMsgBulletinGrid(){
	$("#itMsgBulletin").datagrid({
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
		url: '${ctx}/base/msgBulletin/getMsgBulletinInfoList',
		onDblClickRow:function(rowIndex, rowData){

		},
		columns:[[
				  {title:'主键',field:'recNo',width:100,checkbox:true},
				  {title:'公告主题',field:'msgSubject',width:120},
		          {title:'公告类型',field:'msgType',width:60,hidden:true},
		          {title:'公告类型',field:'msgTypeDesc',width:100},
		          {title:'归属产品',field:'productCode',width:100,hidden:true},
		          {title:'归属产品',field:'productName',width:60},
		          {title:'公告内容',field:'msgContent',width:150,hidden:true},
		          {title:'链接地址',field:'msgUrl',width:40,hidden:true},
		          {title:'发布状态',field:'publishStatus',width:60,hidden:true},
		          {title:'发布状态',field:'publishStatusDesc',width:100},
		          {title:'显示日期(起)',field:'startDate',width:40,hidden:true},
		          {title:'显示日期(起)',field:'startDateDesc',width:40},
		          {title:'显示日期(止)',field:'endDate',width:40,hidden:true},
		          {title:'显示日期(止)',field:'endDateDesc',width:40},
		          {title:'发布方式',field:'publishChannel',width:40,hidden:true},
		          {title:'发布方式',field:'publishChannelDesc',width:40,hidden:true},
		          {title:'操作',field:'id',width:35,align:'center',
		  			formatter : function(value, row, index) {
		  				var opt='';
		  				opt += '<a href="javascript:void(0);" val="'+value+'" onclick="showDetails(\''+value +'\')" class="easyui-linkbutton">查看>></a>';
		  				return opt;
		  			} 
		          }
		      ]],
		toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){
				newBulletinInfo();
			}},'-',{
				text:'发布',
		           iconCls:'icon-edit',
		           handler:function(){
		           	publishBulletinInfo();
		           }
			},'-',{
				text:'修改',
		           iconCls:'icon-edit',
		           handler:function(){
		           	editBulletinInfo();
		           }
			},'-',{
		             text:'删除',
		             iconCls:'icon-remove',
		             handler:function(){
		             	// 处理明细记录的删除操作handler
		             	removeBulletinInfo();
		             }
		         }
		]
	});
}
</script>
</body>
</html>