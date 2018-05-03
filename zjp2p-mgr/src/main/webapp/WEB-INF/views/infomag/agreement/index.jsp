<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>
<style type="text/css">
.my_td_label {
	padding-left: 10px;
	height: 25px;
	text-align: left;
	font-size: 13px;
	color: #3A316F;
	vertical-align: bottom;
	nowrap: nowrap;  
	font-weight: bold;
}

.my_td_text {
	font-size: 12px;
}

#infoForm {
	margin: 10 30 0 10
}
/*   #infoForm input,.easyui-combobox,.easyui-combotree {
	width: 180px;
}   */ 
.am-form-icon{
 width: 100%
}
</style>
</head>
<body>
<div style="width:100%;padding:10px;">
	<form id="infoForm" action="upload.do" method="post"
			ENCTYPE="multipart/form-data" style="padding: 20px; " />
		<table style="width:100%;">
			<tr>
				<td><label style="font-size: 20px;">协议书名称</label></td>
				<td><label style="font-size: 20px;">上传协议</label></td>
			</tr>
			<tr>
				<td>
					<div style="margin-left:18px; margin-top:15px; float:left;">
					  ${agrReg.agreementname} 
					</div>
				</td>
				<td>
					<input type="file" id="${agrReg.agreementno}_FILE" name="${agrReg.agreementno}_FILE" agreementno="${agrReg.agreementno }"  /> 
					<input type="button" class="uploadButton" value="上传" /> 
					<input id="${agrReg.agreementno}_CHECKBOX"  disabled="disabled" type="checkbox" ${(empty agrReg.fileurl || agrReg.fileurl=='') ? '':'checked'} name="check"> 
					<input  type="button" class="downloadButton" value="下载" />&nbsp;
					<input  type="button" class="previewButton"  value="预览" />&nbsp;
					<input type="button"  class="deleteButton" value="删除" />&nbsp;
			    </td>
			</tr>
			<tr>
				<td>
					<div style="margin-left:18px; margin-top:15px; float:left;">
					  ${serviceMag.agreementname} 
					</div>
				</td>
				<td>
					<input type="file" id="${serviceMag.agreementno}_FILE" name="${serviceMag.agreementno}_FILE" agreementno="${serviceMag.agreementno }"  /> 
					<input type="button" class="uploadButton" value="上传" /> 
					<input id="${serviceMag.agreementno}_CHECKBOX" disabled="disabled" type="checkbox" ${(empty serviceMag.fileurl || serviceMag.fileurl=='') ? '':'checked'} name="check"> 
					<input  type="button" class="downloadButton" value="下载" />&nbsp;
					<input  type="button" class="previewButton"  value="预览" />&nbsp;
					<input type="button"  class="deleteButton" value="删除" />&nbsp;
			    </td>
			</tr>
			<tr>
				<td>
					<div style="margin-left:18px; margin-top:15px; float:left;">
					  ${proTransfer.agreementname} 
					</div>
				</td>
				<td>
					<input type="file" id="${proTransfer.agreementno}_FILE" name="${proTransfer.agreementno}_FILE" agreementno="${proTransfer.agreementno }" /> 
					<input type="button" class="uploadButton" value="上传" /> 
					<input id="${proTransfer.agreementno}_CHECKBOX" disabled="disabled" type="checkbox" ${(empty proTransfer.fileurl || proTransfer.fileurl=='') ? '':'checked'} name="check"> 
					<input  type="button" class="downloadButton" value="下载" />&nbsp;
					<input  type="button" class="previewButton"  value="预览" />&nbsp;
					<input type="button"  class="deleteButton" value="删除" />&nbsp;
			    </td>
			</tr>
		</table>
	</form>
</div>
	<script type="text/javascript">
		$(document).ready(function() {

		});
		$('.uploadButton').click(function() {
			var agreementno = $(this).parent().children(':file').attr('agreementno');
			var fileId = $(this).parent().children(':file').attr('id');
			var val = $('#'+fileId).val();
			if(val === undefined || typeof val === 'undefined' || val == '' ){
				alert("请选择上传文件");
				return;
			}
			$.ajaxFileUpload({
				//跟具updateP得到不同的上传文本的ID
				url : 'upload.do?agreementNo=' + agreementno, //需要链接到服务器地址
				secureuri : false,
				fileElementId : '' + fileId + '', //文件选择框的id属性（必须）
				dataType : 'text',
				success : function(data) {
					$('#'+agreementno+'_CHECKBOX').attr("checked", true);
					alert('上传成功');
				},
				error : function(data, status, e) {
					alert('上传失败');
				}
			});
		});
		
		$('.downloadButton').click(function() {
			var agreementno = $(this).parent().children(':file').attr('agreementno');
			var val = $('#'+agreementno+'_CHECKBOX').attr("checked");
			if(val === undefined || typeof val === 'undefined'){
				alert('请先上传协议书');
				return;
			}
			var agreementno = $(this).parent().children(':file').attr('agreementno');
			window.location.href = 'download.do?agreementNo='+agreementno;
		});
		
		$('.previewButton').click(function() {
			var agreementno = $(this).parent().children(':file').attr('agreementno');
			var val = $('#'+agreementno+'_CHECKBOX').attr("checked");
			if(val === undefined || typeof val === 'undefined'){
				alert('请先上传协议书');
				return;
			}
			$.ajax({
				type : 'POST',
				async: false,
				//跟具updateP得到不同的上传文本的ID
				url : 'get.do', //需要链接到服务器地址
				data : {
					agreementNo:agreementno
				},
				success : function(data) {
					window.open (ctx+''+data.result.fileurl);
				},
				error : function(data, status, e) {
					alert('预览失败');
				}
			}); 
		});
		
		
		$('.deleteButton').click(function() {
			var agreementno = $(this).parent().children(':file').attr('agreementno');
			var val = $('#'+agreementno+'_CHECKBOX').attr("checked");
			if(val === undefined || typeof val === 'undefined'){
				alert('请先上传协议书');
				return;
			}
			$.ajax({
				type : 'POST',
				async: false,
				//跟具updateP得到不同的上传文本的ID
				url : 'delete.do', //需要链接到服务器地址
				data : {
					agreementNo:agreementno
				},
				success : function(data) {
					$('#'+agreementno+'_CHECKBOX').attr("checked", false);
				},
				error : function(data, status, e) {
					alert('上传失败');
				}
			});
		});
	</script>
</body>
</html>