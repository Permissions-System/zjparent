<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<title>安全保障 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<style type="text/css">
.banner {
	width: 100%;
	min-width: 1200px;
	height: 490px;
	background-image: url(${ctx}/static/images/safebanner.jpg);
	background-position: center;

}
</style>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
		$("#security_check").attr("class","current");
	});

</script>
</head>

<body>
<jsp:include page="../header.jsp"/><!--网站logo 导航条  end-->


<div class="banner">
</div>

<div style="width:1200px; height:1865px; margin-left:auto; margin-right:auto; background-color:#fff; margin-bottom: -65px;">
<img src="${ctx}/static/images/safeguard1.jpg"  alt=""/>
<img src="${ctx}/static/images/safeguard2.jpg"  alt=""/><img src="${ctx}/static/images/safeguard3.jpg"  alt=""/><img src="${ctx}/static/images/safeguard4.jpg"  alt=""/>
<img src="${ctx}/static/images/safeguard5.jpg"  alt=""/>
<img src="${ctx}/static/images/safeguard6.jpg"  alt=""/>
<div style="margin-left:auto; margin-right:auto; width:215px;margin-top: -50px;"><shiro:notAuthenticated><a href="${ctx }/register.do"><button type="button" class="am-btn am-btn-secondary" style="width:215px;height: 65px; font-size: 26px; ">立即注册!</button></a></shiro:notAuthenticated></div>
 </div>

<jsp:include page="../footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
