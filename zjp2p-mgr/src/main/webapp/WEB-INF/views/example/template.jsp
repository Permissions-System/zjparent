<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示区域管理-分块信息查询</title>
<%@include file="../pub/header.jsp"%>
<!-- 模块JS -->
<script type="text/javascript" src="${ctx}/static/js/pub/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery.form.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/example/example.js"></script>
</head>
<body>
	<!--工具条-->
	<div class="easyui-layout" data-options="fit:true,selected:true">
		<div data-options="region:'center',border:false,fit:true">
			<table id="blockTable" title="分块列表查询" class="easyui-datagrid" data-options=" rownumbers:false, fitColumns:true,	pagination:true, singleSelect:true, fit:true">
			   <!-- Grid -->
			</table>
		</div>
		<div id="blockToolbar">
			<a href="#" class="easyui-linkbutton" id="newBlock" data-options="iconCls:'icon-add', plain:true" onclick="editBlock('add')">新增</a> 
			<a href="#" class="easyui-linkbutton" id="editBlock" data-options="iconCls:'icon-edit', plain:true" onclick="editBlock('upd')">修改</a> 
			<a href="#" class="easyui-linkbutton" id="removeBlock" data-options="iconCls:'icon-remove', plain:true" onclick="removeBlock()">删除</a> 
			<a href="#" class="easyui-linkbutton" id="move_up" data-options="plain:true" onclick="upMove()">上移</a> 
			<a href="#" class="easyui-linkbutton" id="move_down" data-options="plain:true" onclick="downMove()">下移</a>
		</div>
	</div>
	<!-- 新增、修改 -->
	<div id="editBlockPanel" style="margin-left: 10px;">
		<form id="editBlockForm" method="post" style="margin: 0px;">
			<table style="width:100%; padding:5px;" border="1">
				<tr>
					<td style="height:30px;">分块编码:</td>
					<td style="height:30px;"  colspan="2"><input class="easyui-validatebox" type="text" id="blockNo" readonly="readonly" style="background-color: #E8E8E8;" name="blockNo" data-options="required:true,editable:false"></input></td>
				</tr>
				<tr>
					<td style="height:30px;">分块名称:</td>
					<td style="height:30px;"  colspan="2"><input class="easyui-validatebox" type="text" id="blockName" name="blockName" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="height:30px;">分块序号:</td>
					<td style="height:30px;"  colspan="2"><input class="easyui-validatebox" type="text" readonly="readonly" style="background-color: #E8E8E8;" id="blockOrder" name="blockOrder" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td style="height:30px;">是否显示分块</td>
					<td style="height:30px;" colspan="2">
						<div>
							<select id="blockShow" class="easyui-combobox" name="blockShow" style="width: 60px;" data-option="editable:false,required:true">
								<option value="1">是</option>
								<option value="0">否</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td style="height:30px;">分块描述信息A</td>
					<td style="height:30px;"><span id="fileUploadA" type="file" fileName="" fileNail=""></span></td>
					<td><input type="button" onclick="ajaxFileUpload('fileUploadA', 'img', fileUploadCallback);" value="上传"></input></td>
				</tr>
				<tr>
					<td style="height:30px;">分块描述信息B</td>
					<td style="height:30px;"><span id="fileUploadB" type="file" fileName="" fileNail=""></span></td>
					<td><input type="button" onclick="ajaxFileUpload('fileUploadB', 'img', fileUploadCallback);" value="上传"></input></td>
				</tr>
				<tr>
					<td style="height:30px;">分块描述信息C</td>
					<td style="height:30px;"><span id="fileUploadC" type="file" fileName="" fileNail=""></span></td>
					<td><input type="button" onclick="ajaxFileUpload('fileUploadC', 'img', fileUploadCallback);" value="上传"></input></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>