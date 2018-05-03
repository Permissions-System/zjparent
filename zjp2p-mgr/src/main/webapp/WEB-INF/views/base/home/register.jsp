<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>百富网后台管理系统</title>
	<%@include file="../../pub/header.jsp" %>
	<style type="text/css">
	.navlist{list-style-type:none;margin:0px; padding:10px;}
	.navlist li{ padding:0px;}
	.navlist li a{line-height:24px;}
	.navlist li div{margin:2px 0px;padding-left:10px;padding-top:2px; border:1px dashed #ffffff;}
	.navlist li div.hover{border:1px dashed #99BBE8; background:#E0ECFF;cursor:pointer;}
	.navlist li div.hover a{color:#416AA3;}
	.navlist li div.selected{border:1px solid #99BBE8; background:#E0ECFF;cursor:default;}
	.navlist li div.selected a{color:#416AA3; font-weight:bold;}
	.navlist_ul{ list-style-type:none;margin:0px; padding:0px; display:none;}
	</style>
</head>
<body>
<form method="post" action="${ctx}/home/register">
<input type="hidden" name="formtoken" value="${formtoken}"/>
<input type="text" name="username" />
<input type="submit" value="提交" />
</form>
</body>
</html>