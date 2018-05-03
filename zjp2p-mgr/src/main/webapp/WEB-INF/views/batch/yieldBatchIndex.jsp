<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet"
	type="text/css">
<link rel="Stylesheet" type="text/css"
	href="${ctx}/static/assets/css/jquery.validity.css" />
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#yieldBatchOneDay").on("click",function(){
		$.ajax({
            type: "POST",
            dataType:"json",
            url: "yieldBatchOneDay.do",
            data:{date:$("#date").val()},
            success: function(data){
				alert(data.result);
            },
            error: function(data){
            	alert(getJsonErrorMsg(data));
            }
        });
	});
	
	
	
	$("#yieldBatchDays").on("click",function(){
		$.ajax({
            type: "POST",
            dataType:"json",
            url: "yieldBatchDays.do",
            data:{date1:$("#date1").val(),date2:$("#date2").val()},
            success: function(data){
            	alert(data.result);
            },
            error: function(data){
            	alert(getJsonErrorMsg(data));
            }
        });
	});
});
</script>
</head>
<body>

	<div class="backcontent">
		<div class="breadcrumb">
			<ol class="am-breadcrumb am-breadcrumb-slash">
				<li>批处理</li>
			</ol>
		</div>
		<div class="tagcontent">
				<div class="tagcontent_f am-form-horizontal"
					style="padding-top: 30px;">

					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">指定某天执行：</label>
					</div>
					<div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">执行日期：</label>
						<div class="am-u-sm-10">
							<input type="date" class="am-input-sm" id="date"
								name="date" style="float: left; width: 25%;">　
							<button type="button" id="yieldBatchOneDay" class="am-btn am-btn-secondary">提交</button>
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">指定某段时间执行：</label>
					</div>
					<div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">执行日期：</label>
						<div class="am-u-sm-10">
						<input type=date class="am-input-sm" id="date1"
								name="date1" style="float: left; width: 25%;"> 
							<span style="float:left; height:40px; line-height:40px; margin-left:10px;"> - </span>
      						<input type="date" class="am-input-sm" id="date2" name="date2" style="float:left; width: 25%; margin-left:10px;">　
							<button type="button" id="yieldBatchDays" class="am-btn am-btn-secondary">提交</button>
						</div>
					</div>
					
				</div>
		</div>
	</div>
	<footer>
		<p class="am-padding-left"></p>
	</footer>


	<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
