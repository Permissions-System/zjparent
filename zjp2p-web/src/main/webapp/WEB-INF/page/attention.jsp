<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<title>百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${ctx}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<style type="text/css">
.confirm {
	width:1000px;
	height:450px;
	margin-left:auto;
	margin-right:auto;
	margin-top:45px;
}
.bfcat {
	margin-top:60px;
	margin-left:90px;
	float:left;
}
.atte {
	margin-left:30px;
	margin-top:100px;
	float:left;
	font-size:24px;
	color:#565A5C;
}
.atte1 {
	width:100%;
	text-align:center;
	font-size:22px;
	color:#565A5C;
}
</style>

</head>

<body>
<!--顶部扫微信 登录 注册  end-->
<jsp:include page="header.jsp"/>

<!--网站logo 导航条  end-->

<div class="confirm">
  <div class="atte1">百富网<span style="color:#3DB236">提醒您！</span></div>
  <div class="bfcat"><img src="${ctx}/static/images/bfcat.png"  alt=""/></div>
  <div class="atte">融资方已还本付息，为保护融资方隐私，不再公示详情<br><span style="font-size:16px;">你可以返回<a href="${ctx}/queryBidAll.do">『我要投资』</a></span></div>
</div>
<jsp:include page="footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
