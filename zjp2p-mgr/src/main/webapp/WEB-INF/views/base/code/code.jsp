<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp" %>
<style type="text/css">
.fitem{
    height:30px;
}
</style>
</head>
<body onkeydown="bindingEnterKey(event)">
<div class="easyui-layout" data-options="fit:true,selected:true">
    <div data-options="region:'west',split:true,title:'字典类别列表'" style="width: 530px">
		<table id="codetypeId">
		</table>
    </div>
    <div data-options="region:'center',border:true,title:'字典明细列表'">
        <table id="codeDetailId">
        </table>
    </div>
</div>
<div id="code_type_toolbar" style="padding:5px;height:auto">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="idTypeAdd">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="idTypeEdit">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="idTypeRemove">删除</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" id="idTypeReload">刷新</a>
    <input id="qytypeCodeName" name="typeCode" class="easyui-validatebox" style="width:80px;" >
    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" id="idTypeQuery">查询</a>
</div>
<div id="codeInfoDlg" class="easyui-dialog" style="width:360px;height:400px;padding:30px 10px 10px 40px"
        data-options="resizable:false,modal:true" closed="true" buttons="#dlg-buttons">
    <form id="codeForm" method="post" novalidate>
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:0px 0px 0px 0px">
            <tbody>
	        <tr class="fitem">
	            <td><label for="idConfigCode">字典编码:</label></td>
	            <td><input id="idConfigCode" name="configCode" required="true" class="easyui-validatebox" style="width:155px;" data-options="required:true" ></td>
	        </tr>
	        <tr class="fitem">
	            <td><label for="idConfigName">字典名称:</label></td>
	            <td><input id="idConfigName" name="configName" required="true" class="easyui-validatebox" style="width:155px;" data-options="required:true" ></td>
	        </tr>
            <tr class="fitem">
	            <td><label for="idReadFlag">编辑状态:</label></td>
	            <td>
	               <div>
		            <select id="idReadFlag" class="easyui-combobox" panelHeight="auto"  name="readFlag" style="width:155px;" data-options="editable:false,required:true">
		               	<c:forEach items="${readFlag}" var="item">
							<option value="${item.configCode}">${item.configName}</option>
						</c:forEach>     
		            </select>
		            </div>
	            </td>
            </tr>
            <tr class="fitem">
                <td><label for="idDeleteFlag">删除状态:</label></td>
                <td>
                   <div>
                        <select id="idDeleteFlag" class="easyui-combobox" panelHeight="auto" name="deleteFlag" style="width:155px;" data-options="editable:false,required:true">
                            <c:forEach items="${deleteFlag}" var="item">
                                <option value="${item.configCode}">${item.configName}</option>
                            </c:forEach>        
                        </select>
                    </div>
                </td>
            </tr>
            <tr class="fitem">
                <td><label for="idIndexNo">顺序号:</label></td>
                <td><input id="idIndexNo" name="indexNo" class="easyui-numberspinner" style="width:155px;" data-options="min:0,max:1000,editable:false"></td>
            </tr>
            <tr class="fitem">
                <td><label for="idTypeCode">类别编码:</label></td>
                <td><input id="idTypeCode" name="typeCode" class="easyui-validatebox" disabled="disabled" style="width:155px;" data-options="required:true"></td>
            </tr>
            <tr class="fitem">
                <td><label for="idTypeName">类别名称:</label></td>
                <td><input id="idTypeName" name="typeName" class="easyui-validatebox" disabled="disabled" style="width:155px;" data-options="required:true" ></td>
            </tr>
            <tr class="fitem">
                <td><label for="idDescription">描述:</label></td>
                <td><input id="idDescription" name="description" style="width:155px;" ></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="save"  >保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="cancelCodeInfo">取消</a>
</div>
<div id="editCodeTypeInfoDlg" class="easyui-dialog" style="width:300px;height:200px;padding:20px 10px 10px 20px"
        data-options="resizable:false,modal:true" closed="true" buttons="#edit-type-dlg-buttons">
    <form id="editCodeTypeForm" method="post" novalidate>
        <table style="width:100%;magrin-top:1px;magrin-left:5px;magrin-right:5px;magrin-bottom:1px;padding:20px 10px 10px 10px">
        <tbody>
            <tr class="fitem">
                <td><label for="idTypeCodeEdit">类别编码:</label></td>
                <td><input id="idTypeCodeEdit" style="width:160px;" required="true" name="typeCode" class="easyui-validatebox" data-options="required:true"></td>
             </tr>
            <tr class="fitem">
                <td><label for="idTypeNameEdit">类别名称:</label></td>
                <td><input id="idTypeNameEdit" style="width:160px;" required="true" name="typeName" class="easyui-validatebox" data-options="required:true" ></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div id="edit-type-dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="editTypeSave">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="editTypeCancel">取消</a>
</div>
<script type="text/javascript">
//定义全局 编辑索引，限制编辑列最多只有一行
var editIndex = undefined;

//全局变量 控制弹出框是否打开 该页面有两个保存按钮 同一时间内容只存在一个弹出框
var isOpenFlag = "";
/**
 * 页面初始化
 */
$(document).ready(function() {
	//初始化 类型列表Grid
	initCodeTypeGrid();
	
	// 初始化 字典明细列表Grid
	initCodeInfoGrid();
	
	// 明细新增 单击事件
    $("#save").bind("click", function(){
    	saveCodeInfo();
    });
	
	// 取消处理
    $("#cancelCodeInfo").bind("click", function(){
    	cancelCodeInfo();
    	isOpenFlag = "";
    });
	
    // 弹出框 保存按钮处理事件
    $("#editTypeSave").bind("click", function(){
    	saveEditCodeTypeInfo();
    });
    
    $("#editTypeCancel").bind("click", function(){
    	$('#editCodeTypeInfoDlg').dialog('close');
    	isOpenFlag = "";
    });
    
    // 类别新增 事件绑定
    $("#idTypeAdd").bind("click", function(){
    	newCodeTypeInfo();
    });
    
    // 类别修改 事件绑定
    $("#idTypeEdit").bind("click", function(){
    	editCodeTypeInfo();

    });
    
    // 列表删除 事件绑定
    $("#idTypeRemove").bind("click", function(){
    	removeCodeTypeInfo();
    });
    
    $("#idTypeQuery").bind("click", function(){
        queryTypeInfo();
    });
    
    // 类别列表刷新
    $("#idTypeReload").bind("click", function(){
    	reflashCodeTypeInfo();
    });
    
	// 绑定 码表类型编码的 keyup事件
	$("#idTypeCodeEdit").keyup( function() {
		//toUpperCase_onKeyUp($("#idTypeCodeEdit"));
	});
	// 字典编码 限制输入字符类型
	$("#idConfigCode").keyup( function() {
		//toUpperCase_onKeyUp($("#idConfigCode"));
	});
	
	// 码表明细名称特殊字符禁止输入处理
    $("#idConfigName").keyup( function() {
    	//inputNameValue_onKeyUp($("#idConfigName"));
    });
    
	// 码表类别名称特殊字符输入禁止处理
    $("#idTypeNameEdit").keyup( function() {
        //inputNameValue_onKeyUp($("#idTypeNameEdit"));
    });
    
	/**
    $("#qytypeCodeName").keyup( function() {
    	inputNameQueryValue_onKeyUp($("#qytypeCodeName"));
    });
	**/
	disPagelistOption();
    
    // 类型Dialog弹出框关闭处理
    $('#editCodeTypeInfoDlg').dialog({
        onOpen:function(){
            isOpenFlag = "typeCode";
        },
    	onClose:function(){
    		isOpenFlag = "";
    	}
    });
    
    $('#codeInfoDlg').dialog({
        onOpen:function(){
            isOpenFlag = "configCode";
        },
        onClose:function(){
            isOpenFlag = "";
        }
    });
});

/**
 * 绑定 按钮 按回车 激发按钮单击事件
 */
function bindingEnterKey(event){
    // 保存按钮OJBJECT
    var btnType = $("#editTypeSave");
    var btnCode = $("#save");
    var btnQuery = $("#idTypeQuery");
    
    // 点击 Enter按钮
    if(event.keyCode == 13 && isOpenFlag =="typeCode"){
    	btnType.click();
        event.returnValue = false;
    }
    if(event.keyCode == 13 && isOpenFlag =="configCode"){
    	btnCode.click();
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
 * 查询数据字典列表数据
 */
function queryTypeInfo(){
	// 为明细分页组件赋值
    // 根据查询组合条件，取记录当前的页面 取第一页数据 load
    $('#codetypeId').datagrid('unselectAll');
    $('#codetypeId').datagrid('load',{
    	typeCode: $('#qytypeCodeName').val().toUpperCase()
    });
    $('#codeDetailId').datagrid('loadData', { total: 0, rows: [] });
    disPagelistOption();
}
/**
 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
 */
function disPagelistOption(){
	$(".pagination-page-list").attr('disabled','disabled');
	$("input[class=pagination-num]").attr('disabled','disabled');
}

//结束编辑方法
function endEditing(){
	if (editIndex == undefined){
	 return true;
	}
	return false;
}
   
// 新增行记录 追加到数据集的最后一行 未启用
function appendRow(typeCode,typeName){
	if(endEditing()){
		$('#codetypeId').datagrid('appendRow',{
		 typeCode:typeCode,
		 typeName:typeName
		});
		editIndex = $('#codetypeId').datagrid('getRows').length-1;
		// 选中新增加的数据列
		$('#codetypeId').datagrid('selectRow', editIndex);
	}
}
   
//J检验弹出框的输入数据notNull验证
// 明细列表检验使用
function checkValidateData(){
	var val = "",ct=0;
	// 校验字典编码
	val = $('#codeForm').find('[name=configCode]').val();
	if(isNull(val)){
		showSlideMessage("字典编码 不可为空！");
		ct++;
		return false;
	}
	
	// 模块编号长度必须为1至32
    if(val.length<=0 || val.length>32){
        showSlideMessage("字典编码 不应超过32个字符,请确认！");
        ct++;
        return false;
    }
	
	// 字典名称
	val = $('#codeForm').find('[name=configName]').val();
    if(isNull(val)){
        showSlideMessage("字典名称 不可为空！");
        ct++;
        return false;
    }
    if(val.length<=0 || val.length>20){
        showSlideMessage("字典名称不应超过20个字符,请确认！");
        ct++;
        return false;
        
    }
    
    // 编辑状态
    val = $('#codeForm').find('[name=readFlag]').val();
    if(isNull(val)){
        showSlideMessage("请选择 编辑状态！");
        ct++;
        return false;
    }
    
    // 删除状态
    val = $('#codeForm').find('[name=deleteFlag]').val();
    if(isNull(val)){
        showSlideMessage("请选择 删除状态！");
        ct++;
        return false;
       
    }
    
    // 顺序号
    val = $('#codeForm').find('[name=indexNo]').val();
    if(isNull(val)){
        showSlideMessage("顺序号 不可为空！");
        ct++;
        return false;
    }
    
    // 类别编码
    val = $('#codeForm').find('[name=typeCode]').val();
    if(isNull(val)){
        showSlideMessage("类别编码 不可为空！");
        ct++;
        return false;
    }
    
    // 模块编号长度必须为1至32
    if(val.length<=0 || val.length>32){
        showSlideMessage("类别编码 不应超过32个字符,请确认！");
        ct++;
        return false;
    }
    
    
    // 类别名称 
    val = $('#codeForm').find('[name=typeName]').val();
    if(isNull(val)){
        showSlideMessage("类别名称 不可为空！");
        ct++;
        return false;
    }
    
    if(val.length<=0 || val.length>20){
        showSlideMessage("类别名称不应超过20个字符,请确认！");
        ct++;
        return false;
    }
    
    // 描述校验最长60字符
    val = $('#codeForm').find('[name=description]').val();
    if(isNotNull(val)){
		if(val.length>65){
			showSlideMessage("描述不应超过65个字符,请确认！");
			ct++;
			return false;
		}
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}

/**类别修改时校验 名称不为空**/
function checkValidateTypeEditData(){
    var val = "",ct=0;
    // 类别编码
    val = $('#editCodeTypeForm').find('[name=typeCode]').val();
    if(isNull(val)){
        showSlideMessage("类别编码 不可为空！");
        ct++;
        return false;
    }
    
	// 模块编号长度必须为1至32
    if(val.length<=0 || val.length>32){
        showSlideMessage("类别编码 不应超过32个字符,请确认！");
        ct++;
        return false;
    }
    
    // 类别名称 
    val = $('#editCodeTypeForm').find('[name=typeName]').val();
    if(isNull(val)){
        showSlideMessage("类别名称 不可为空！");
        ct++;
        return false;
    }
    
    if(val.length<=0 || val.length>20){
        showSlideMessage("类别名称 长度不应超过20个字符,请确认！");
        ct++;
        return false;
    }
    
    if (ct > 0) {
        return false;
    } else {
        return true;
    }
}
   
// 修改类型 名称
function saveEditCodeTypeInfo(){
	// 新增类型和修改类型名称统一改保存方法处理，
	// 其中新增的方法中该方法仅提供向 类别列表中中新增一条记录，然后自动弹出新增明细页面的输入框
	// 弹出的输入框中 类型编码和类型编码 的值 为该新增的 类别名称和 类别编码 
    var isValid = $('#editCodeTypeForm').form('validate');
    if(!isValid){
        return ;
    }
	
	var action = $("#editTypeSave").data("action");
	// 新增和修改都进行NOTNULL的验证
	if(!checkValidateTypeEditData()){
	    return false;
	}
    
	// 修改类别名称的处理逻辑
	if(action=='update'){
	    var url = "${ctx}/base/code/updateTypeCode";
		// AJAX 提交
		jQuery.ajax({
			type : "POST",
			async: false,
			url : url,
			data : {
				typeCode: $("#idTypeCodeEdit").val(),
				typeName: $("#idTypeNameEdit").val()
			},
			success : function(data) {
			   if(data.message=='success'){
				   $('#editCodeTypeInfoDlg').dialog('close');
				   showSlideMessage("修改成功");
				   $('#codetypeId').datagrid('reload');
			   }else{
				   showSlideMessage("修改失败！");
			   }
			   isOpenFlag = "";
			},
			error : function(data) {
				 showSlideMessage("修改数字字典发生异常！");
				 isOpenFlag = "";
			},
     		datatype : "json"
		});
	}else{
		// 新增类型的存在性校验
		var typeCode = $('#editCodeTypeForm').find('[name=typeCode]').val();
		var valiFlag = true;
		$.ajax({
			type:"GET",
			url:"${ctx}/base/code/checkExistCodeType",
			async:false,
			data:{
			    typeCode:typeCode
			},
			success:function(data){
				if(data.existFlag=='Y'){
				    showSlideMessage("字典类别 = ["+typeCode+"] 已配置，请确认！");
				    valiFlag = false;
				}else{
				    valiFlag = true;
				}
			}
		});
        
        // 验证通过 弹出新增明细的弹出框
        if(valiFlag){
        	var typeName = $('#editCodeTypeForm').find('[name=typeName]').val();
        	// 将新增的类别名称和类别编码 作为一条新记录插入到 码表类型表当前页的最后一行
        	// 弹出新增数据字典明细记录的的页面
        	$.messager.confirm('确认','新增类别信息需继续增加一条字典明细记录,是否继续?',function(r){
        		 if (r){
                     appendRow(typeCode,typeName);
                     $('#editCodeTypeInfoDlg').dialog('close');
                     isOpenFlag = "";
                     editIndex = undefined;
                     newCodeinfo();
        		 }
        	});
        }
	}
}
   
  //保存操作，新增 和修改 
  function saveCodeInfo(){
  	var url = "";
  	var action = $('#save').data('action');
  	
    var isValid = $('#codeForm').form('validate');
    if(!isValid){
        return ;
    }
	// 避暑校验不通过 新增或修改 对必输项进行校验
  	if(!checkValidateData()){
  		return ;
  	}
  	
    if(action=='update'){
        url="${ctx}/base/code/update";
		// AJAX 提交
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : url,
	        data : {
	        	configCode: $("#idConfigCode").val(),
	        	configName: $("#idConfigName").val(),
	        	readFlag: $("#idReadFlag").combobox('getValue'),
	        	deleteFlag:$("#idDeleteFlag").combobox('getValue'),
	        	indexNo:$("#idIndexNo").numberspinner('getValue'),
	        	typeCode:$("#idTypeCode").val(),
	        	typeName:$("#idTypeName").val(),
	        	description:$("#idDescription").val()
	        },
	        success : function(data) {
	          if(data.result=='success'){
	        	   $('#codeInfoDlg').dialog('close'); 
	        	   showSlideMessage("修改成功");
	        	   $('#codeDetailId').datagrid('reload');
	        	   isOpenFlag = "";
	           }else{
	        	   showSlideMessage("修改失败！");
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("修改数据字典记录发生异常！");
	        	 isOpenFlag = "";
	        },
	        datatype : "json"
		});  
    }else{
        url="${ctx}/base/code/insert";
        var typeCode = $("#idTypeCode").val();
        var configCode = $("#idConfigCode").val();
		// AJAX 提交
		jQuery.ajax({
			type : "POST",
	        async: false,
	        url : url,
	        data : {
	        	configCode: $("#idConfigCode").val(),
	        	configName: $("#idConfigName").val(),
	        	readFlag: $("#idReadFlag").combobox('getValue'),
	        	deleteFlag:$("#idDeleteFlag").combobox('getValue'),
	        	indexNo:$("#idIndexNo").numberspinner('getValue'),
	        	typeCode:$("#idTypeCode").val(),
	        	typeName:$("#idTypeName").val(),
	        	description:$("#idDescription").val()
	        },
	        success : function(data) {
	           if(data.result=='exist'){
	        	   showSlideMessage("字典类别= ["+typeCode+"],字典编码=["+configCode+"] 已配置，请确认！");
	           }else if(data.result=='success'){
                   // close dialog
	        	   $('#codeInfoDlg').dialog('close'); 
	        	   showSlideMessage("保存成功");
                // 刷新明细列表的数据 
                var typeRow = $('#codetypeId').datagrid('getSelected');
                if(typeRow){
                    showCodeDetailInfo(typeRow.typeCode);
                }
                
                isOpenFlag = "";
	           }else{
	        	   showSlideMessage("保存异常！");
	           }
	        },
	        error : function(data) {
	        	 showSlideMessage("保存数据字典信息异常！");
	        	 isOpenFlag = "";
	        },
	        datatype : "json"
		 });     
      }
  }

// 根据数据字典类型 分页加载 字典明细列表集合数据
function showCodeDetailInfo(typeCode){
	// 为明细分页组件赋值
	// 记录当前的页面 取第一页数据 load
	$('#codeDetailId').datagrid('load',{
		typeCode: typeCode
	});
}

/**
 *创建数据字典明细纪录
 */
function newCodeinfo(){
    var row = $('#codetypeId').datagrid('getSelected');
    if(!row){
        showSlideMessage("请选择数据字典类别!");
        return;
    }
    // 默认 是否删除，是否可编辑的数据。从页面上新增的数据，默认可以编辑，可以修改。
    $('#codeInfoDlg').dialog('open').dialog('setTitle','新增明细');
    $('#codeForm').form('clear');
    $('#codeForm').find('[name=typeCode]').val(row.typeCode);
    $('#codeForm').find('[name=typeName]').val(row.typeName);
    // div的功用 消除保存时增加的限制输入的只读属性
    $('#codeForm').find('[name=configCode]').removeAttr('readonly');
    $('#codeForm').find('[name=configCode]').removeAttr('disabled');
    $('#codeForm').find('[name=typeCode]').attr('readonly','readonly');
    //$('#codeForm').find('[name=typeCode]').attr('disabled','disabled');
    $('#codeForm').find('[name=typeName]').attr('readonly','readonly');
    //$('#codeForm').find('[name=typeName]').attr('disabled','disabled');
    // 默认可编辑，可删除
    $('#idReadFlag').combobox('setValue', '1');
    $('#idDeleteFlag').combobox('setValue', '1');
    
    var num = 0;
    $.ajax({
        type:"GET",
        url:"${ctx}/base/code/checkExistCodeType",
        async:false,
        data:{
            typeCode:row.typeCode
       },
       success:function(data){
    	   num = data.count;
       }
    });
    $('#idIndexNo').numberspinner('setValue', num);  
    
    // 默认值
    // 取得昨天类别选择的类型记录
    // 提交标志
    $("#save").data("action","insert");
    
    isOpenFlag = "configCode";
}

// 统一弹出侧边消息提示
function showSlideMessage(msg){
    $.messager.show({
        title:'提示',
        msg:msg,
        timeout:4000,
        showType:'slide'
    });
}

// 新增类型记录 ，同时增加一条明细记录 作为一条记录保存到数据库
function newCodeTypeInfo(){
	$('#editCodeTypeInfoDlg').dialog('open').dialog('setTitle','新增类别');
	$('#editCodeTypeForm').form('clear');
	// div的功用 消除保存时增加的限制输入的只读属性
	$('#editCodeTypeForm').find('[name=typeCode]').removeAttr('disabled');
	$('#editCodeTypeForm').find('[name=typeCode]').removeAttr('readonly');
	$("#editTypeSave").data("action","insert");
	isOpenFlag = "typeCode";
}

//类型 可修改 只能修改 类型名称数据
function editCodeTypeInfo(){
    // 取得类型列表选择行
    var row = $('#codetypeId').datagrid('getSelected');
    if(row){    
    	$('#editCodeTypeInfoDlg').dialog('open').dialog('setTitle','修改类别');
    	$('#editCodeTypeForm').form('clear');
        $('#editCodeTypeForm').form('load',row);
        //编辑状态 typeCode 以及 configCode 应不可编辑
        $('#editCodeTypeForm').find('[name=typeCode]').attr('readonly','readonly');
        $('#editCodeTypeForm').find('[name=typeCode]').attr('disabled','disabled');
        $("#editTypeSave").data("action","update");
        
        isOpenFlag = "typeCode";
    }else{
        // 未选择记录，给出侧边栏提示 需要选择类型记录
        showSlideMessage("请选择数据字典类别记录！");
    }
}

//编辑纪录
function editCodeInfo(){
	// 取得明细列表选择行
    var row = $('#codeDetailId').datagrid('getSelected');
    if (row){
    	var readFlag = row.readFlag;
    	if(readFlag=="0"){
    		showSlideMessage("该记录不可编辑,请确认！");
    	}else{
            $('#codeInfoDlg').dialog('open').dialog('setTitle','修改明细');
            $('#codeForm').form('load',row);
            //编辑状态 typeCode 以及 configCode 应不可编辑
            $('#codeForm').find('[name=configCode]').attr('readonly','readonly');
            $('#codeForm').find('[name=configCode]').attr('disabled','disabled');
            $('#codeForm').find('[name=typeCode]').attr('readonly','readonly');
            $('#codeForm').find('[name=typeName]').attr('readonly','readonly');
            $("#save").data("action","update");
            isOpenFlag = "configCode";
    	}
    }else{
    	// 未选择记录，给出侧边栏提示 需要选择记录
    	showSlideMessage("请选择数据字典记录！");
    }
}

// 类型列表下的删除功能
function removeCodeTypeInfo(){
	var row = $('#codetypeId').datagrid('getSelected');
	if(!row){
        // 未选择记录，给出侧边栏提示 需要选择记录
        showSlideMessage("请选择数据需要删除的字典记录！");
        return;
	}
	var valiFlag = true;
	var typeCode = row.typeCode;
    $.ajax({
        type:"GET",
        url:"${ctx}/base/code/checkNotDelCodeInfo",
        async:false,
        data:{
            typeCode:typeCode
       },
       success:function(data){
           if(data.count>0){
               showSlideMessage("字典类别= ["+row.typeName+"] 已配置"+data.count+"条不可删除的记录，请确认！");
               valiFlag = false;
           }else{
               valiFlag = true;
           }
       }
    });
    // 返回为false 不在执行删除确认的操作
    if(!valiFlag){
    	return;
    }
    $.messager.confirm('确认','是否删除该数据字典类型及其已配置的全部明细信息?',function(r){
        if (r){
            $.post(
            '${ctx}/base/code/deleteType',
             {
                 typeCode:typeCode
             },
             function(result){
                 if(result.message=='success'){
                 //删除需要增加判断异常的处理
                 $('#codetypeId').datagrid('load');
                 $('#codeDetailId').datagrid('load');
                     showSlideMessage("记录已删除！");
                 }else{
                     showSlideMessage("记录删除异常！");
              }
            },
            'json'
            );
            // 清空类别列表的删除状态
            $('#codetypeId').datagrid('unselectAll');
        }
    });
}

/**
 *删除数据字典明细记录
 */
function removeCodeInfo(){
    var row = $('#codeDetailId').datagrid('getSelected');
    if (row){
    	//该数据属于不可删除的不提供删除
    	var deleteFlag = row.deleteFlag;
    	if(deleteFlag=="0"){
            showSlideMessage("该记录不可删除，请确认！");
    	}else{
            $.messager.confirm('确认','是否删除该数据字典信息?',function(r){
                if (r){
                    $.post(
                   		'${ctx}/base/code/delete',
                           {
                               typeCode:row.typeCode,
                               configCode:row.configCode
                           },
                           function(result){
                               if(result.message=='success'){
                                //删除需要增加判断异常的处理
                                //$('#codetypeId').datagrid('unselectAll');
                                // 若删除该记录之后，类型下还有记录，则对于类型选择不请空，
                                // 记录删除后，类型不存在，则，清空选择状态
                                $.ajax({
                                    type:"GET",
                                    url:"${ctx}/base/code/checkExistCodeType",
                                    async:false,
                                    data:{
                                        typeCode:row.typeCode
                                   },
                                   success:function(data){
                                       if(data.existFlag=='Y'){
                                       }else{
                                    	   // 只有当类型下数据全部删除 才刷新类别列表
                                    	   $('#codetypeId').datagrid('unselectAll');
                                    	   $('#codetypeId').datagrid('load');
                                       }
                                   }
                                });
                                
                                $('#codeDetailId').datagrid('load');
                                showSlideMessage("记录已删除！");
                          }else{
                          	showSlideMessage("记录删除异常！");
                          }
                    },
                    'json'
                    );
                }
            });
    	}
    }else{
        // 未选择记录，给出侧边栏提示 需要选择记录
        showSlideMessage("请选择数据需要删除的字典记录！");
    }
}

//刷新数据字典类别列表
function reflashCodeTypeInfo(){
	$('#codetypeId').datagrid('reload');
	$('#codetypeId').datagrid('unselectAll');
	// 刷新 右边明细列表
	showCodeDetailInfo(null);
}

// 在新增字典类型的情况下打开了 明细页面，
// 其取消按钮需要承担 关闭自身弹出框，删除类型列表下新增的记录，并将列表的选中改为 所有记录都未选中
// 和 明细的新增需要区别开，已记录 的typeCode 在数据库中是否存在区分
function cancelCodeInfo(){
	$('#codeInfoDlg').dialog('close');
	var typeRow = $('#codetypeId').datagrid('getSelected');
	if(typeRow){
		// 该数据是否是已存在的数据
		var valiFlag = true;
           $.ajax({
               type:"GET",
               url:"${ctx}/base/code/checkExistCodeType",
               async:false,
               data:{
                   typeCode:typeRow.typeCode
              },
              success:function(data){
                  if(data.existFlag=='Y'){
               	   // 存在记录
                      valiFlag = false;
                  }else{
                      valiFlag = true;
                  }
              }
           });
		
		if(valiFlag){
			$('#codetypeId').datagrid('unselectAll');
            $('#codetypeId').datagrid('deleteRow',$('#codetypeId').datagrid('getRows').length-1);
		}
	}
}

/**
 * 初始化页面Grid
 */
function initCodeTypeGrid(){
	//绑定保存 处理新增 或修改的保存
	// 初始化数据字典分页加载数据
	$("#codetypeId").datagrid({
		pagination:true,
        rownumbers:true,
		height:'auto',
        pageSize:10,
        pageList:[10],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        fit:true,
        method:'post',
        sortName:'typeCode',
        sortOrder:'asc',
        remoteSort:false,
        loadMsg:"正在加载数据...",
        url: '${ctx}/base/code/typeInfo',
        idField:'typeCode',
        toolbar: '#code_type_toolbar',
        singleSelect:true, 
        onSelect:function(rowIndex, rowData){
        	//执行处理当行选中时候 分页加载数据字典明细数据列表
        	var typeCode = rowData.typeCode;
        	// 具体加载明细记录的js操作
        	showCodeDetailInfo(typeCode);
        	disPagelistOption();
        },
        columns:[[
                  {title:'名称',field:'typeName',width:150,required:true},
                  {title:'编码',field:'typeCode',width:150,required:true}
              ]]
	});
}

/**
 * 初始化页面Grid
 */
function initCodeInfoGrid(){
	// 码表明细绑定工具条 增删改按钮 以及对应处理事件
    $("#codeDetailId").datagrid({
    	pagination:true,
    	rownumbers:true,
        pageSize:10,
        pageList:[10],
        nowrap:false,
        autoRowHeight:false,
        striped:true,
        border:false,
        fitColumns:true,
        method:'post',
        singleSelect:true,
        fit:true,
        url: '${ctx}/base/code/codeDetailInfo',
        onDblClickRow:function(rowIndex, rowData){
        	editCodeInfo();
        },
        columns:[[
                  {title:'编码',field:'configCode',width:120},
                  {title:'名称',field:'configName',width:150},
                  {title:'顺序号',field:'indexNo',width:80},
                  {title:'是否可编辑',field:'readFlag',width:120,hidden:true},
                  {title:'是否可编辑',field:'readFlagDesc',width:120},
                  {title:'是否可删除',field:'deleteFlag',width:120,hidden:true},
                  {title:'是否可删除',field:'deleteFlagDesc',width:120},
                  {title:'类别编码',field:'typeCode',width:120,hidden:true},
                  {title:'类别名称',field:'typeName',width:150,hidden:true},
                  {title:'描述',field:'description',width:100}
              ]],
    	toolbar:[{
    		text:'新增',
    		iconCls:'icon-add',
    		handler:function(){
    			newCodeinfo();
    		}},'-',{
    			text:'修改',
                iconCls:'icon-edit',
                handler:function(){
                	editCodeInfo();
                }
    			
    		},'-',{
                text:'删除',
                iconCls:'icon-remove',
                handler:function(){
                	// 处理明细记录的删除操作handler
                	removeCodeInfo();
                }
                   
            }
    	]
    });
}
</script>
</body>
</html>