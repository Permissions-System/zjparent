<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.itemMagin{
    height:24px;
}
.timeStyle{
    width:30px;
}

.queryStyle{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div class="datagrid-toolbar" data-options="region:'north',split:true,title:'查询'" style="height:150px;padding:20px 0px 10px 20px">
    	<form id="queryForm" method="post" novalidate>
			<table class="datagrid-toolbar" style="width:100%;height:70%;border:0px;font-size:12px">
				<tr class="queryStyle">
	                <td><label for="qyProductCode">归属产品:</label></td>
	                <td>
		                <select id="qyProductCode" class="easyui-combobox" name="productCode" panelHeight="auto" style="width:160px;" data-options="editable:false">     
		                	<option value="">全部</option>
		                	<c:forEach items="${productCode}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	                <td><label for="qyTemplateName">模板名称:</label></td>
	                <td><input id="qyTemplateName" name="templateName" class="easyui-validatebox" style="width:160px;" ></td>
	                <td><label for="qyTimeFlag">发送时间是否限制:</label></td>
	                <td>
		                <select id="qyTimeFlag" class="easyui-combobox" name="timeFlag" panelHeight="auto" style="width:160px;" data-options="editable:false">
			                <option value="">全部</option>      
			               	<c:forEach items="${timeFlag}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
		                </select>
	                </td>
	            </tr>
	            <tr  class="queryStyle">
	            	<td><label>消息优先级:</label></td>
	            	<td>
	            		<div>
     			        <select id="qySendLvBgn" class="easyui-combobox" panelHeight="auto" name="sendLvBgn" style="width:70px;" data-options="editable:false">
			                <option value="">不限</option>      
			               	<c:forEach items="${msgPriority}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
	                	</select>
	            		<label>到</label>
	            		<select id="qySendLvEnd" class="easyui-combobox" panelHeight="auto" name="sendLvEnd" style="width:70px;" data-options="editable:false">
			                <option value="">不限</option>      
			               	<c:forEach items="${msgPriority}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
	                	</select>	
	            		</div>
	            	</td>
	            	<td><label>消息显示级别:</label></td>
	            	<td>
	            		<div>
	            		<select id="qyDispLvBgn" class="easyui-combobox" panelHeight="auto" name="dispLvBgn" style="width:70px;" data-options="editable:false">
			                <option value="">不限</option>      
			               	<c:forEach items="${msgPriority}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
	                	</select>
	            		<label>到</label>
	            		<select id="qyDispLvEnd" class="easyui-combobox" panelHeight="auto" name="dispLvEnd" style="width:70px;" data-options="editable:false">
			                <option value="">不限</option>      
			               	<c:forEach items="${msgPriority}" var="item">
								<option value="${item.configCode}">${item.configName}</option>
							</c:forEach>
	                	</select>
	            		</div>
	            	</td>
	            	<td><label for="qyTransCode">交易编码:</label></td>
	            	<td><input id="qyTransCode" name="transCode" class="easyui-validatebox" style="width:160px;" ></td>
	            </tr>
	            <tr>
	            <td></td>
	            <td></td>
	            <td></td>
	            <td></td>
	            <td></td>
                <td>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-search" id="btnQuery" >查询</a>
                    <a href="#" class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
                </td>
	            </tr>
			</table>
		</form>
    </div>
    <div data-options="region:'center',border:true,title:'列表'">
        <table id="itMsgTemplates">
        </table>
    </div>
</div>

<div id="msgTemplateInfoDlg" class="easyui-dialog" style="width:900px;height:530px;padding:20px 20px 10px 45px"
        data-options="resizable:false,modal:true" closed="true" buttons="#msgtemplate-dlg-buttons">
    <form id="msgTemplateForm" method="post" novalidate>
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 12px">
        <tbody>
            <tr class="itemMagin">
                <td style="width:130px;"><label style="width:130px;" for="idProductCode">归属产品:</label></td>
         	    <td style="width:155px;">
	                <select id="idProductCode" class="easyui-combobox" panelHeight="auto" required="true" name="productCode" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${productCode}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
	            </td>
                <td style="width:150px;"><label style="width:130px;" for="idSendLevel">消息优先级：</label></td>
                <td style="width:155px;">
                    <select id="idSendLevel" class="easyui-combobox" panelHeight="auto" name="sendLevel" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${msgPriority}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idTemplateCode">消息模板代码：</label></td>
                <td><input id="idTemplateCode" name="templateCode" class="easyui-validatebox" required="true" style="width:155px;" data-options="required:true,validType:['digtalCharValid[]']" ></td>
                <td><label for="idDispLevel">消息显示排序级别:</label></td>
                <td>
                	<select id="idDispLevel" class="easyui-combobox" panelHeight="auto" name="dispLevel" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${msgPriority}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idTemplateName">消息模板名称:</label></td>
                <td><input id="idTemplateName" name="templateName" class="easyui-validatebox" required="true" style="width:155px;" data-options="required:true,validType:['nameValid[]','length[1,30]']" ></td>
                <td><label for="idTimeFlag">发送时间是否受限制:</label></td>
                <td>
	                <select id="idTimeFlag" class="easyui-combobox" panelHeight="auto" name="timeFlag" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${timeFlag}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label>发送时间段1：</label></td>
                <td>
            		<div>
            		<label>从</label>
            		<input id="idStartTime1" name="startTime1" style="width:60px;" class="easyui-timespinner" data-options="min:'08:00',showSeconds:false,editable:false" >
            		<label>到</label>
            		<input id="idEndTime1" name="endTime1" style="width:60px;" class="easyui-timespinner" data-options="min:'08:00',showSeconds:false,editable:false" >
            		</div>
	            </td>
                <td><label for="idWeekendFlag">周末是否发送:</label></td>
                <td>
	                <select id="idWeekendFlag" class="easyui-combobox" panelHeight="auto" name="weekendFlag" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${yesNoFlag}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label>发送时间段2：</label></td>
                <td>
            		<div>
            		<label>从</label>
            		<input id="idStartTime2" name="startTime2" style="width:60px;" class="easyui-timespinner" data-options="min:'08:00',showSeconds:false,editable:false" >
            		<label>到</label>
            		<input id="idEndTime2" name="endTime2" style="width:60px;" class="easyui-timespinner" data-options="min:'08:00',showSeconds:false,editable:false" >
            		</div>
	            </td>
                <td><label for="idHolidayFlag">节假日是否发送:</label></td>
                <td>
	                <select id="idHolidayFlag" class="easyui-combobox" panelHeight="auto" name="holidayFlag" style="width:155px;" data-options="editable:false">
		               	<c:forEach items="${yesNoFlag}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>
	                </select>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label for="idTransCode">交易编码:</label></td>
                <td><input id="idTransCode" name="transCode" class="easyui-validatebox" style="width:155px;" data-options="validType:['digtalCharValid[]','length[0,9]']"></td>
                <td><label for="idMsgChannel">消息渠道:</label></td>
                <td>
                    <select id="idMsgChannel" class="easyui-combobox" panelHeight="auto" name="msgChannel" style="width:155px;" data-options="editable:false">
                        <c:forEach items="${msgChannel}" var="item">
                            <option value="${item.configCode}">${item.configName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="itemMagin">
            	<td colspan="4"><label>发送场景描述：</label></td>
            </tr>
            <tr class="itemMagin">
            	<td colspan="4" style="width:100%">
	            	<textarea id="idDescription" name="description" wrap="physical" style="height:40px;width:93%">
	            	</textarea>
            	</td>
            </tr>
            <tr class="itemMagin">
            	<td><label>消息主题：</label></td>
            	<td><input id="idMsgSubject" name="msgSubject"  required="true" class="easyui-validatebox" style="width:155px;" data-options="validType:['nameValid[]','length[1,150]']"></td>
                <td><label for="idMsgType">消息类型:</label></td>
                <td>
                    <select id="idMsgType" class="easyui-combobox" name="msgType" panelHeight="auto" required="true" style="width:155px;" data-options="editable:false">
                        <c:forEach items="${msgType}" var="item">
                            <option value="${item.configCode}">${item.configName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr class="itemMagin">
            	<td colspan="4"><label>消息内容：</label></td>
            </tr>
            <tr class="itemMagin">
            	<td colspan="4" style="width:100%">
            	    <div style="width:100%">
            	     <script type="text/plain" id="idMsgContent"></script>
            	    </div>
            	</td>
            </tr>
        </tbody>
        </table>
    </form>
</div>
<div id="msgtemplate-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="msgTemplateSave" >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="msgTempCancel">取消</a>
</div>

<div id="templateinfo-detailsDlg" class="easyui-dialog" style="width:900px;height:530px;padding:20px 20px 10px 45px"
        data-options="resizable:false,modal:true" closed="true" buttons="#info-dlg-buttons">
    <form id="showMsgForm" method="post" novalidate>
    <table style="width:100%;magrin-top:1px;magrin-left:0px;magrin-right:0px;magrin-bottom:1px;padding:0px 0px 0px 0px;font-size: 13px">
        <tbody>
            <tr class="itemMagin">
                <td style="width:110px;"><label for="showProductCode">归属产品:</label></td>
                <td style="width:160px;"><input type="text" style="width:150px;" id="showProductCode" name="productCode" readonly="readonly"></td>
                <td style="width:140px;"><label for="showSendLevel">消息优先级:</label></td>
                <td style="width:160px;"><input type="text" style="width:150px;" id="showSendLevel" name="sendLevel" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="showTemplateCode">消息模板代码：</label></td>
                <td><input type="text" style="width:150px;" id="showTemplateCode" name="templateCode" readonly="readonly"></td>
                <td><label for="showDispLevel">消息显示排序级别:</label></td>
                <td><input type="text" style="width:150px;"  id="showDispLevel" name="dispLevel" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="showTemplateName">消息模板名称:</label></td>
                <td><input type="text" style="width:150px;" id="showTemplateName" name="templateName" readonly="readonly"></td>
                <td><label for="showTimeFlag">发送时间是否受限制:</label></td>
                <td><input type="text" style="width:150px;" id="showTimeFlag" name="timeFlag" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td><label >发送时间段1：</label></td>
                <td>
                    <div style="width:100%">
                        <table style="width:100%;padding:0px 0px 0px 0px;" >
                            <tr>
                                <td style="width:5px"><label>从</label></td>
                                <td style="width:40px;"><input type="text" style="width:80%;" id="showStartTime1" name="startTime1" readonly="readonly"></td>
                                <td style="width:5px"><label>到</label></td>
                                <td style="width:40px;"><input type="text" style="width:80%;" id="showEndTime1" name="endTime1" readonly="readonly"></td>
                            </tr>
                        </table>
                    </div>
                </td>
                <td><label for="showWeekendFlag">周末是否发送:</label></td>
                <td><input type="text" style="width:120px;" id="showWeekendFlag" name="weekendFlag" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td><label >发送时间段2：</label></td>
                <td>
                    <div style="width:100%">
                        <table style="width:100%">
                            <tr>
                                <td style="width:5px"><label>从</label></td>
                                <td style="width:40px;"><input type="text" style="width:80%;" id="showStartTime2" name="startTime2" readonly="readonly"></td>
                                <td style="width:5px"><label>到</label></td>
                                <td style="width:40px;"><input type="text" style="width:80%;" id="showEndTime2" name="endTime2" readonly="readonly"></td>
                            </tr>
                        </table>
                    </div>
                </td>
                <td><label for="showHolidayFlag">节假日是否发送:</label></td>
                <td><input type="text" style="width:120px;" id="showHolidayFlag" name="holidayFlag" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td><label for="showTransCode">交易编码:</label></td>
                <td><input type="text" style="width:150px;" id="showTransCode" name="transCode" readonly="readonly"></td>
                <td><label for="showMsgChannel">消息渠道:</label></td>
                <td><input type="text" style="width:150px;" id="showMsgChannel" name="msgChannel" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td colspan="4"><label>发送场景描述：</label></td>
            </tr>
            <tr class="itemMagin">
                <td colspan="4" style="width:100%">
                    <textarea id="showDescription" name="description" wrap="physical" style="height:80px;width:760px">
                    </textarea>
                </td>
            </tr>
            <tr class="itemMagin">
                <td><label>消息主题：</label></td>
                <td><input type="text" style="width:120px;"  id="showMsgSubject" name="msgSubject" readonly="readonly"></td>
                <td><label>消息类型：</label></td>
                <td><input type="text" style="width:120px;"  id="showMsgType" name="msgType" readonly="readonly"></td>
            </tr>
            <tr class="itemMagin">
                <td colspan="4"><label>消息内容：</label></td>
            </tr>
            <tr class="itemMagin" style="width:100%;">
                <td colspan="4">
                <div style="width:100%">
                    <script type="text/plain" id="showMsgContent"></script>
                </div>
                </td>
            </tr>
        </tbody>
    </table>
    </form>
</div>
<div id="info-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#templateinfo-detailsDlg').dialog('close')" >返回</a>
</div>
<script src="${ctx}/static/js/pub/ueditor/ueditor.config.js" type="text/javascript"></script>
<script src="${ctx}/static/js/pub/ueditor/ueditor.all.js" type="text/javascript"></script>
<script type="text/javascript">
var isOpenFlag ="";

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
	$("#msgTemplateSave").bind("click", function(){
		saveMsgTemplateInfo();
	});
	
    $("#msgTempCancel").bind("click", function(){
    	$('#msgTemplateInfoDlg').dialog('close');
    	isOpenFlag ="";
    });
	
	
	// 初始化页面Grid
	initMsgTemplateGrid();
	
	// js编辑器初始化
	initMsgContentEditor();
	
	initShowMsgContentEditor();
	
	// 查询模板名称限制输入字符处理
    $("#qyTemplateName").keyup( function() {
	   //inputNameQueryValue_onKeyUp($("#qyTemplateName"));
    });
	
    $("#qyTransCode").keyup( function() {
    	//inputCodeQueryValue_onKeyUp($("#qyTransCode"));
    });
    
	// 模板代码 限制输入字符类型
	$("#idTemplateCode").keyup( function() {
		//toUpperCase_onKeyUp($("#idTemplateCode"));
	});
	
    $("#idTransCode").keyup( function() {
        //toNotUpperCase_onKeyUp($("#idTransCode"));
    });
	
	// 限制名称输入字符的空值
    $("#idTemplateName").keyup( function() {
        //inputNameValue_onKeyUp($("#idTemplateName"));
    });
	
    $("#idMsgSubject").keyup( function() {
       //inputNameValue_onKeyUp($("#idMsgSubject"));
    });
	
	disPagelistOption();
	
	// 控制下拉框数据不可编辑
	disEditableComboBox();
	
    // 类型Dialog弹出框关闭处理
    $('#msgTemplateInfoDlg').dialog({
   	    onOpen:function(){
            isOpenFlag = "TEMP";
        },
        onClose:function(){
            isOpenFlag = "";
        }
    });
    
    specialHandler();
});


function toNotUpperCase_onKeyUp(jObject) {
    var val = jObject.val();
    // 代码类型 只能输入 英文字符，数字 下划线
    // 去除双字节字符(包括汉字在内)
    val = val.replace(/[\u4E00-\u9FA5]/g, '');

    val = val.replace(/[^a-zA-Z0-9_]/g, '');

    // 替换空格
    val = cgReplaceAll(val, ' ', '');
    // 新增特殊字符的校验
    jObject.val(val);
}


/**
 * 发送时间，周末是否发送，节假日是否发送 限制不能编辑
 * 发送时间不限制 默认值
 * 修改时间1013年12月24日 16:39:58
 */
function specialHandler(){

    $("#idHolidayFlag").combobox({
        editable:false,
        disabled:true
    });
    
}


/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnSave = $("#msgTemplateSave");
    var btnQuery = $("#btnQuery");
    
    // 点击 Enter按钮
    if(event.keyCode == 13 && isOpenFlag =="TEMP"){
    	btnSave.click();
        event.returnValue = false;
    }
    // 绑定 查询的 Enter
    if(event.keyCode == 13 && isOpenFlag ==""){
        btnQuery.click();
        event.returnValue = false;
    }
    prevent(event); //文本框、下拉框readonly、disabled时禁用退格键
}

/**
 * 控制页面内下拉不可编辑
 */
function disEditableComboBox(){
	
    $("#qyProductCode").combobox({
        editable:false
    });
    $("#idProductCode").combobox({
        editable:false
    });
    $("#qyTimeFlag").combobox({
        editable:false
    });
    $("#qySendLvBgn").combobox({
        editable:false
    });
    $("#qySendLvEnd").combobox({
        editable:false
    });
    $("#qyDispLvBgn").combobox({
        editable:false
    });
    $("#qyDispLvEnd").combobox({
        editable:false
    });
    $("#idDispLevel").combobox({
        editable:false
    });
    $("#idSendLevel").combobox({
        editable:false
    });
   
    $("#idTimeFlag").combobox({
        editable:false
    });
    $("#idWeekendFlag").combobox({
        editable:false
    });
    $("#idHolidayFlag").combobox({
        editable:false
    });
    $("#idMsgType").combobox({
        editable:false
    });
    $("#idMsgChannel").combobox({
        editable:false
    });
}

/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
    //$(".pagination-page-list").attr('disabled','disabled');
    $(".pagination-num").attr('disabled','disabled');
}

/**
 * 初始化 消息模板内容富文本编辑器
 */
function initMsgContentEditor(){
    var option = {
        initialContent: '',//初始化编辑器的内容
        initialFrameWidth:760,  //初始化编辑器宽度,默认1000，可以设置成百分比
        initialFrameHeight:100,  //初始化编辑器高度,默认320
        autoClearinitialContent:true,  //是否自动清除编辑器初始内容
        zIndex : 9000,
        autoHeightEnabled:false,
        scaleEnabled:false,
        toolbars:[['source', '|', 'undo', 'redo', '|',
           'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 
           'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 
           'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
           'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
           'link','insertimage','fontfamily', 'fontsize', '|',
           'directionalityltr', 'directionalityrtl', 'indent', '|',
           'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 
           'horizontal', 'date', 'time', 'spechars'
        ]]
    };
     
    UE.getEditor('idMsgContent',option);
}

function initShowMsgContentEditor(){
    var option = {
            initialContent: '',//初始化编辑器的内容
            initialFrameWidth:760,  //初始化编辑器宽度,默认1000，可以设置成百分比
            initialFrameHeight:100,  //初始化编辑器高度,默认320
            autoClearinitialContent:true,  //是否自动清除编辑器初始内容
            toolbars:[]
            };
         
    UE.getEditor('showMsgContent',option);
}


/**
 * 组合查询
 * 条件： 归属产品 produceCode 模板名称 templateName 发送时间是否限制 timeFlag
 * 消息优先级: 
 *
 */
function queryInfo(){
	// 为明细分页组件赋值
	// 根据查询组合条件，取记录当前的页面 取第一页数据 load
	$('#itMsgTemplates').datagrid('load',{
        productCode: $('#qyProductCode').combobox('getValue'),
        templateName: $('#qyTemplateName').val(),
        transCode: $('#qyTransCode').val(),
        timeFlag: $('#qyTimeFlag').combobox('getValue'),
        sendLvBgn:$('#qySendLvBgn').combobox('getValue'),
        sendLvEnd:$('#qySendLvEnd').combobox('getValue'),
        dispLvBgn:$('#qyDispLvBgn').combobox('getValue'),
        dispLvEnd:$('#qyDispLvEnd').combobox('getValue')
	});
	disPagelistOption();
}

/**
 * 清空查询条件，重新刷新页面数据到第一页
 */
function queryCancel(){
	$('#queryForm').form('clear');
	$('#qyProductCode').combobox('setValue','');
	$('#qyTimeFlag').combobox('setValue','');
	$('#qySendLvBgn').combobox('setValue','');
	$('#qySendLvEnd').combobox('setValue','');
	$('#qyDispLvBgn').combobox('setValue','');
	$('#qyDispLvEnd').combobox('setValue','');
	isOpenFlag ="";
}
 
/**
 * 新增模板记录
 */
function newTemplateInfo(){

    $('#msgTemplateInfoDlg').dialog('open').dialog('setTitle','新增消息模板');
    $('#msgTemplateForm').form('clear');
    $('#msgTemplateForm').find('[name=templateCode]').removeAttr('readonly');
    //$('#msgTemplateForm').find('[name=templateCode]').removeAttr('disabled');
    // 保存按钮暂存数据 Insert
    $('#idProductCode').combobox('setValue','');
    $('#idTemplateCode').css("color", "#000000");
    $('#msgTemplateSave').data("action","insert");
	var editor = UE.getEditor('idMsgContent');
	editor.setContent('');
	isOpenFlag ="TEMP";
	
}
 
 /**
  * 修改
  */
function editTemplateInfo(){

	var rows = $('#itMsgTemplates').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择修改修改的消息模板！");
		return;
	}else if(rows.length>1){
		showSlideMessage("请选择一条的消息模板,或双击需要修改的消息模板！");
		return;
	}else{
		//只选择一条的情况
		var row = $('#itMsgTemplates').datagrid('getSelected');
		if(row){
		 // 双击事件中处理具体修改事项
		 onDblClickGrid(row);
		}
	}
}

/**
 * 删除一条或者同时删除多条记录
 */
function removeTemplateInfo(){
	var rows = $('#itMsgTemplates').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要删除的消息模板！");
		return;
	}
	
	var templateCodes = [];
	for(var i = 0;i<rows.length;i++){
		templateCodes.push(rows[i].id);
	}
	var deleteCodes = templateCodes.join(',');
    $.messager.confirm('确认','确定删除当前选择的'+rows.length+'条消息模板信息?',function(r){
        if (r){
        	jQuery.ajax({
        		
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgTemplate/deleteBatch",
    	        data : {
    	        	deleteCodes:deleteCodes
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("删除成功");
    	        	   // 重新加载
    	        	   $('#itMsgTemplates').datagrid('load');
    	        	   disPagelistOption();
    	           }else{
    	        	   showSlideMessage("删除失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("删除失败！");
    	        },
    	        datatype : "json"
        	});
        }
    });
} 
 
/**
 * 新增消息模板，修改消息模板，统一保存
 */
function saveMsgTemplateInfo(){
    var isValid = $('#msgTemplateForm').form('validate');
    if(!isValid){
        return ;
    }
	
	var editor = UE.getEditor('idMsgContent');

	// 判断 新增或修改
	var action = $('#msgTemplateSave').data('action');
		// 避暑校验不通过 新增或修改 对必输项进行校验
	if(!checkValiMsgTemplate()){
		return ;
	}
	// 新增数据 $('#msgTemplateForm').find('[name=msgContent]').val(),
	if(action=='insert'){
		// AJAX 提交
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : "${ctx}/base/msgTemplate/insert",
	        data : {
	        	templateCode: $("#idTemplateCode").val(),
	        	templateName: $("#idTemplateName").val(),
	        	msgSubject: $("#idMsgSubject").val(),
	        	msgContent: editor.getContent(),
	        	productCode: $("#idProductCode").combobox('getValue'),
	        	sendLevel:$("#idSendLevel").combobox('getValue'),
	        	dispLevel:$("#idDispLevel").combobox('getValue'),
	        	timeFlag:$("#idTimeFlag").combobox('getValue'),
	        	startTime1:$("#idStartTime1").timespinner('getValue'),
	        	endTime1:$("#idEndTime1").timespinner('getValue'),
	        	startTime2:$("#idStartTime2").timespinner('getValue'),
	        	endTime2:$("#idEndTime2").timespinner('getValue'),
	        	weekendFlag:$("#idWeekendFlag").combobox('getValue'),
	        	holidayFlag:$("#idHolidayFlag").combobox('getValue'),
	        	msgType:$("#idMsgType").combobox('getValue'),
	        	description:$('#msgTemplateForm').find('[name=description]').val(),
	        	templateStatus:'1',
	        	transCode:$("#idTransCode").val(),
	        	msgChannel:$("#idMsgChannel").combobox('getValue')
	        },
	        success : function(data) {
	           if(data.result=='exist'){
	        	   showSlideMessage("消息模块代码已存在，请确认！");
	           }else if(data.result=='success'){
	        	   // close dialog
	        	   $('#msgTemplateInfoDlg').dialog('close'); 
	        	   showSlideMessage("保存成功");
	        	   $('#itMsgTemplates').datagrid('load');
	        	   disPagelistOption();
	        	   isOpenFlag ="";
	           }else{
	        	   showSlideMessage("保存异常！");
	        	   isOpenFlag ="";
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("保存失败！");
	        	 isOpenFlag ="";
	        },
	        datatype : "json"
		});
	}else{
		// 修改数据
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : "${ctx}/base/msgTemplate/update",
	        data : {
	        	templateCode: $("#idTemplateCode").val(),
	        	templateName: $("#idTemplateName").val(),
	        	msgSubject: $("#idMsgSubject").val(),
	        	msgContent: editor.getContent(),
	        	productCode: $("#idProductCode").combobox('getValue'),
	        	sendLevel:$("#idSendLevel").combobox('getValue'),
	        	dispLevel:$("#idDispLevel").combobox('getValue'),
	        	timeFlag:$("#idTimeFlag").combobox('getValue'),
	        	startTime1:$("#idStartTime1").timespinner('getValue'),
	        	endTime1:$("#idEndTime1").timespinner('getValue'),
	        	startTime2:$("#idStartTime2").timespinner('getValue'),
	        	endTime2:$("#idEndTime2").timespinner('getValue'),
	        	weekendFlag:$("#idWeekendFlag").combobox('getValue'),
	        	holidayFlag:$("#idHolidayFlag").combobox('getValue'),
	        	msgType:$("#idMsgType").combobox('getValue'),
	        	description:$('#msgTemplateForm').find('[name=description]').val(),
	        	msgChannel:$("#idMsgChannel").combobox('getValue'),
	        	transCode:$("#idTransCode").val()
	        },
	        success : function(data) {
	           if(data.result=='success'){
	        	   // close dialog
	        	   $('#msgTemplateInfoDlg').dialog('close'); 
	        	   showSlideMessage("修改成功");
	        	   $('#itMsgTemplates').datagrid('reload');
	        	   disPagelistOption();
	        	   isOpenFlag ="";
	           }else{
	        	   showSlideMessage("保存异常！");
	        	   isOpenFlag ="";
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("修改失败！");
	        	 isOpenFlag ="";
	        },
	        datatype : "json"
		});
	}
}
 
/**
 * 双击多选Grid事 做编辑前的判断
 * 修改获得明细记录的方式 改为调用时查询方式获得
 */
function onDblClickGrid(rowData){
	// 获取当前选择的记录的主键
	var recNo = rowData.id;
	
	// 修改标题 模块代码不可编辑
	$('#msgTemplateInfoDlg').dialog('open').dialog('setTitle','修改消息模板');
	$('#msgTemplateForm').find('[name=templateCode]').attr('readonly','readonly');
	//$('#msgTemplateForm').find('[name=templateCode]').attr('disabled','disabled');
	$('#msgTemplateForm').form('clear');
	$('#msgTemplateForm').form('load',rowData);

	//清空旧值
    $("#idStartTime1").timespinner('setValue','');
    $("#idEndTime1").timespinner('setValue','');
    $("#idStartTime2").timespinner('setValue','');
    $("#idEndTime2").timespinner('setValue','');
	
	$("#idStartTime1").timespinner('setValue',rowData.startTime1);
	$("#idEndTime1").timespinner('setValue',rowData.endTime1);
	$("#idStartTime2").timespinner('setValue',rowData.startTime2);
	$("#idEndTime2").timespinner('setValue',rowData.endTime2);
	
	// 保存操作类型数据
	$("#msgTemplateSave").data("action","update");
	isOpenFlag ="TEMP";
	var editor = UE.getEditor('idMsgContent');
	editor.setContent("");
	
    jQuery.ajax({
        type : "POST",
        async: false,
        url : "${ctx}/base/msgTemplate/getMsgTemplateInfo",
        data : {
            templateCode:recNo
        },
        success : function(data) {
          if(data.message=='success'){
              //模板内容
              editor.setContent(data.msgContent);
           }else{
               showSlideMessage("加载消息内容失败！");
           }
        },
        error : function(data) {
             showSlideMessage("加载消息内容数据过程发生异常，请确认！");
        },
        datatype : "json"
    });
    $('#idTemplateCode').css("color", "#9E9E9E");
}
 
//计算字符串长度,中文按照3个字符计算
function countCharNum(str){
    if(str==null){
        return 0;
    }
    return str.replace(/([^\x00-\xff])/g,'aaa').length;
}
 
/**
 * 新增和修改 对必输项做校验控制
 * 归属产品，模板代码，模板名称，模板主题，模板内容
 */
function checkValiMsgTemplate(){
    var val = "",ct=0;
    // 归属产品代码
    val = $("#idProductCode").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选择归属产品！");
        return false;
        ct++;
    }
 
    // 模块编码 
    val = $("#idTemplateCode").val();
    if(isNull(val)){
        showSlideMessage("请输入 消息模板代码！");
        return false;
        ct++;
    }
    
    if(val.length<=0 || val.length>10){
        showSlideMessage("消息模板代码长度不超过10个字符,请确认！");
        return false;
        ct++;
    }
    
    val = $("#idTemplateName").val();
    if(isNull(val)){
        showSlideMessage("请输入 消息模板名称！");
        return false;
        ct++;
    }
    
    if(val.length<=0 || val.length>30){
        showSlideMessage("消息模板名称不应超过30个字符,请确认！");
        return false;
        ct++;
    }
    
    var bgnTime1 = $("#idStartTime1").timespinner('getValue');
    var endTime1 = $("#idEndTime1").timespinner('getValue');

    // 发送时段1 都不为空 开始值  小于 结束值
    if(isNotNull(bgnTime1) && isNotNull(endTime1)){
    	bgnTime1 = bgnTime1.replace(/:/g,'');//去除:号
    	endTime1 = endTime1.replace(/:/g,'');//去除:号
		if(bgnTime1 >= endTime1){
			showSlideMessage("发送时段1 结束时间 应大于 开始时间！");
			ct++;
			return false;
		}
    }
    
    // 发送时段2 都不为空 开始值  小于 结束值
  	var bgnTime2 = $("#idStartTime2").timespinner('getValue');
    var endTime2 = $("#idEndTime2").timespinner('getValue');
    if(isNotNull(bgnTime2) && isNotNull(endTime2)){
    	bgnTime2 = bgnTime2.replace(/:/g,'');//去除:号
    	endTime2 = endTime2.replace(/:/g,'');//去除:号
		if(bgnTime2 >= endTime2){
			showSlideMessage("发送时段2 结束时间 应大于 开始时间！");
			ct++;
			return false;
		}
    }
   
    // 消息主题
    val = $("#idMsgSubject").val();
    if(isNull(val)){
        showSlideMessage("请输入 消息主题！");
        return false;
        ct++;
    }
    
    // 长度校验
    if(val.length<=0 || val.length>150){
        showSlideMessage("消息主题不应超过150个字符,请确认！");
        return false;
        ct++;
    }
    
    val = $("#idMsgType").combobox('getValue');
    if(isNull(val)){
        showSlideMessage("请选消息类型！");
        return false;
        ct++;
    }
    
    var editor = UE.getEditor('idMsgContent');
    // 消息内容
    //val = $("#idMsgContent").html();
    //val = //$('#msgTemplateForm').find('[name=msgContent]').val();
	val = editor.getContent();
    
    if(isNull(val)){
        showSlideMessage("请输入 消息内容！");
        return false;
        ct++;
    }
    
    // 消息内容改字段类型之后，不再限制其最大长度
    /**
    var count = countCharNum(val);
    if(count>4000){
        showSlideMessage("你输入的消息内容字符个数已经超出最大允许值,请确认！");
        return false;
        ct++;
    }
    ***/
    val = $("#idTransCode").val();
    // 若改字段存在记录则 字段长度超过最大长度限制
    if(isNotNull(val) && val.length>9){
        showSlideMessage("交易编码不应超过9个字符！");
        return false;
        ct++;
    }
    
    // 描述符 如有内容校验其最大长度
    val = $('#msgTemplateForm').find('[name=description]').val();
    if(isNotNull(val)){
		if(val.length<=0 || val.length>100){
			showSlideMessage("发送场景描述不应超过100个字符,请确认！");
			return false;
			ct++;
		}
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
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
 * 启用模板  启用标志 ： 1
 */
function startTemplateInfo(){
	var rows = $('#itMsgTemplates').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要启用的消息模板！");
		return;
	}
	
	var ckStatus = true;
	var recCodes = [];
	for(var i = 0;i<rows.length;i++){
		// 发布状态未已发布 不能再次发布
		if(rows[i].templateStatus=='1'){
			// 找到启用的记录，校验不通过
			ckStatus = false;
			break;
		}
	}
	// 只选择一条的情况
	if(!ckStatus){
		if(rows.length==1){
			showSlideMessage("该模板已启用，无需再次启用,请确认!");
		}else{
			showSlideMessage("选择的模板中存在已启用的消息模板，已启用模板无需再次启用，请确认！");
		}
		return;
	}
	
	for(var i = 0;i<rows.length;i++){
		recCodes.push(rows[i].templateCode);
	}
	
	// 拼接需要发布
	var recNos = recCodes.join(',');
	
	$.messager.confirm('确认','确定启用当前选择的消息模板?',function(r){
        if (r){
        	jQuery.ajax({
        		
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgTemplate/updateBatch",
    	        data : {
    	        	templateCodes:recNos,
    	        	templateStatus:'1'
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("启用成功");
    	        	   // 重新加载
    	        	   $('#itMsgTemplates').datagrid('reload');
    	        	   disPagelistOption();
    	           }else{
    	        	   showSlideMessage("启用失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("模板启用过程发生异常，请确认！");
    	        },
    	        datatype : "json"
        	});
        }
    });
}

/**
 * 停用模板 停用标志 ： 0
 */
function stopTemplateInfo(){
	var rows = $('#itMsgTemplates').datagrid('getSelections');
	if(rows.length==0){
		showSlideMessage("请选择需要停用的消息模板！");
		return;
	}
	
	var ckStatus = true;
	var recCodes = [];
	for(var i = 0;i<rows.length;i++){
		// 停用的记录 不能再次停用
		if(rows[i].templateStatus=='0'){
			// 找到停用的记录，校验不通过
			ckStatus = false;
			break;
		}
	}
	// 只选择一条的情况
	if(!ckStatus){
		if(rows.length==1){
			showSlideMessage("该模板已停用，无需再次停用,请确认!");
		}else{
			showSlideMessage("选择的模板中存在已停用的消息模板，已停用模板无需再次停用，请确认！");
		}
		return;
	}
	
	for(var i = 0;i<rows.length;i++){
		recCodes.push(rows[i].templateCode);
	}
	
	// 拼接需要发布
	var recNos = recCodes.join(',');
	
	$.messager.confirm('确认','确定停用当前选择的消息模板?',function(r){
        if (r){
        	jQuery.ajax({
        		
    			type : "POST",
    	        async: false,
    	        url : "${ctx}/base/msgTemplate/updateBatch",
    	        data : {
    	        	templateCodes:recNos,
    	        	templateStatus:'0'
    	        },
    	        success : function(data) {
    	          if(data.message=='success'){
    	        	   showSlideMessage("停用成功");
    	        	   // 重新加载
    	        	   $('#itMsgTemplates').datagrid('reload');
    	        	   disPagelistOption();
    	           }else{
    	        	   showSlideMessage("停用失败！");
    	           }
    	        },
    	        error : function(data) {
    	        	 showSlideMessage("模板停用过程发生异常，请确认！");
    	        },
    	        datatype : "json"
        	});
        }
    });	
}

 /**
  * js初始化页面DataGrid
  */
function initMsgTemplateGrid(){
	// 删除Grid不显示的列
	$("#itMsgTemplates").datagrid({
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
		singleSelect:false,
		fit:true,
		url: '${ctx}/base/msgTemplate/getMsgTemplateInfoList',
		onDblClickRow:function(rowIndex, rowData){
			onDblClickGrid(rowData);
		},
		columns:[[
                  {title:'模板代码',field:'id',width:100,checkbox:true},
                  {title:'归属产品',field:'productCode',width:100,hidden:true},
                  {title:'归属产品',field:'productName',width:60},
                  {title:'模板代码',field:'templateCode',width:100},
                  {title:'模板名称',field:'templateName',width:150},
                  {title:'消息优先级',field:'sendLevel',width:40,hidden:true},
                  {title:'消息优先级',field:'sendLevelDesc',width:60},
                  {title:'消息显示级别',field:'dispLevel',width:60,hidden:true},
                  {title:'消息显示级别',field:'dispLevelDesc',width:60},
                  {title:'发送时间是否限制',field:'timeFlag',width:80,hidden:true},
                  {title:'发送时间是否限制',field:'timeFlagDesc',width:80},
                  {title:'模板状态',field:'templateStatus',width:80,hidden:true},
                  {title:'模板状态',field:'templateStatusDesc',width:80},
                  {title:'消息主题',field:'msgSubject',width:120,hidden:true},
                  {title:'交易编码',field:'transCode',width:100},
                  {title:'可发送开始时间1',field:'startTime1',width:150,hidden:true},
                  {title:'可发送结束时间1',field:'endTime1',width:150,hidden:true},
                  {title:'可发送开始时间2',field:'startTime2',width:150,hidden:true},
                  {title:'可发送结束时间2',field:'endTime2',width:150,hidden:true},
                  {title:'周末是否发送',field:'weekendFlag',width:150,hidden:true},
                  {title:'节假日是否发送',field:'holidayFlag',width:150,hidden:true},
                  {title:'发送场景描述',field:'description',width:100,hidden:true},
                  {title:'操作',field:'operId',width:35,align:'center',
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
				newTemplateInfo();
			}},'-',{
				text:'修改',
		           iconCls:'icon-edit',
		           handler:function(){
		           	editTemplateInfo();
		           }
			},'-',{
		             text:'删除',
		             iconCls:'icon-remove',
		             handler:function(){
		             	// 处理明细记录的删除操作handler
		             	removeTemplateInfo();
		             }
		    },'-',{
		    	 text:'启用',
	             iconCls:'icon-add',
	             handler:function(){
	             	// 处理明细记录的删除操作handler
	             	startTemplateInfo();
	             }
	        },'-',{
	        	 text:'停用',
	             iconCls:'icon-remove',
	             handler:function(){
	             	// 处理明细记录的删除操作handler
	             	stopTemplateInfo();
	             }
	        }
		]
	});
}
 
/**
 * 传入记录主键 查询明细数据
 */
function showDetails(val){
    var editor = UE.getEditor('showMsgContent');
    editor.setDisabled();
    editor.setContent('');

    // 取消
    $("input",$("#showMsgForm")).css("border","0px");
    //$(".edui-editor-toolbarboxouter",$("#showMsgForm")).remove();
    
    $('#templateinfo-detailsDlg').dialog('open').dialog('setTitle','模板详情');
    
    jQuery.ajax({
        
        type : "POST",
        async: false,
        url : "${ctx}/base/msgTemplate/getMsgTemplateInfo",
        data : {
        	templateCode:val
        },
        success : function(data) {
          if(data.message=='success'){

        	  $("#showProductCode").val(data.productName);
        	  $("#showSendLevel").val(data.sendLevelDesc);
        	  $("#showTemplateCode").val(data.templateCode);
        	  $("#showDispLevel").val(data.dispLevelDesc);
        	  $("#showTemplateName").val(data.templateName);
        	  $("#showTimeFlag").val(data.timeFlagDesc);
        	  $("#showStartTime1").val(data.startTime1);
        	  $("#showEndTime1").val(data.endTime1);
        	  $("#showStartTime2").val(data.startTime2);
        	  $("#showEndTime2").val(data.endTime2);
        	  $("#showWeekendFlag").val(data.weekendFlagDesc);
        	  $("#showHolidayFlag").val(data.holidayFlagDesc);
        	  $('#showMsgForm').find('[name=description]').val(data.description);
        	  $("#showMsgSubject").val(data.msgSubject);
        	  $("#showTransCode").val(data.transCode);
              $("#showMsgChannel").val(data.msgChannelDesc);
              $("#showMsgType").val(data.msgTypeDesc);
              
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

//扩展输入字段的格式化定义 
$.extend($.fn.validatebox.defaults.rules, {
    nameValid: {        
        validator: function(value, param){
            var p = new RegExp('[^a-zA-Z0-9_\u4E00-\u9FA5\(\)\（\）]');
            return !p.test(value);
        },
        message: '输入内容应由中文字符、数字、字母、下划线组成'
    },
    digtalCharValid: {        
        validator: function(value, param){
            var p = new RegExp('[^a-zA-Z0-9_]');
            return !p.test(value);
        },
        message: '输入内容应仅由数字、字母和下划线组成'
    }
});   
</script>
</body>
</html>