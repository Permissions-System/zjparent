<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://ckfinder.com" prefix="ckfinder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="Stylesheet" type="text/css"
	href="${ctx}/static/assets/css/jquery.validity.css" />
<script type="text/javascript" src="${ctx}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${ctx}/static/ckfinder/ckfinder.js"></script>
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("input[name='aa']").click(function(){
		$("#idnum").toggle();
	});
	
	//是否上传标的图片
	$("#ischecked").html("未上传");
	$('.uploadButton').click(function() {
		var val = $("#imgfile").val();
		if(val === undefined || typeof val === 'undefined' || val == '' ){
			alert("请选择上传文件");
			return;
		}
		$.ajaxFileUpload({
			//跟具updateP得到不同的上传文本的ID
			url : '${ctx}/bid/upload.do', //需要链接到服务器地址
			secureuri : false,
			fileElementId : 'imgfile', //文件选择框的id属性（必须）
			dataType: 'text',
			success : function(data) {
				console.info(data);
				if(data.indexOf("/") == 0){
					$('#check').attr("checked", true);
					$("#ischecked").html("").html("已上传");
					$("#agreementimg").val(data);
					alert('上传成功');
				} else {
					$('#check').attr("checked", false);
					$("#ischecked").html("").html("未上传");
					alert('上传失败');
				}
				
			},
			error : function(data, status, e) {
				alert('上传失败');
			}
		});
	});
});
</script>
<script type="text/javascript">
        $(function() {
        	var rem="请输入，不能为空";
            $('form').validity(function() {
                $("#instname").require(rem);
            });
        });
</script>
</head> 
<body>

	<form action="saveVouchOrg.do" method="post">
	<input type="hidden" name="id" value="${vouchOrg.id}">
		<table>
			<tr>
				<td>担保机构编号：</td>
				<td>${vouchOrg.instcode}</td>
			</tr>
			<tr>
				<td>担保机构名称：</td>
				<td><input type="text" name="instname" value="${vouchOrg.instname}" id="instname"
				 	<c:if test='${! empty count }'>disabled="disabled"</c:if> /></td>
			</tr>
			<tr>
        		<td colspan="2">担保机构简介：</td>
	      	</tr>
	      	<tr>
	        	<td colspan="2">
	        	<textarea cols="80" id="editor1" name="instdesc" rows="10">${vouchOrg.instdesc}</textarea>
	        	<ckfinder:setupCKEditor basePath="ckfinder/" editor="editor1" />
				<ckeditor:replace replace="editor1" basePath="ckeditor/" />
				</td>
	        </tr>
	        <tr>
	        	<td>担保机构图片：</td>
	        	<td>
	        		<input type="file" id="imgfile" name="imgfile"/>
					<input type="button" class="uploadButton" value="上传" />
					<input id="check"  type="checkbox" name="check" disabled="disabled"><span id="ischecked"></span>
					<span style="color:#f00">上传的图片仅支持gif、jpg、jpeg、png等图片格式,像素高度不超过350，宽度不超过835。</span>
					<span id="imgurl" hidden="hidden"></span>  
					<input type="hidden" name="agreementimg" id="agreementimg" value="" />
	        	</td>
	        </tr>
	        <tr>
	        	<td><input type="submit" name="submit"   value="保存"></td>
	        	<td><button onclick="history.go(-1)" >取消</button></td>
	        </tr>
		</table>
	</form>
</body>
</html>