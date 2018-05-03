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
<title>关于百富 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/info.css" rel="stylesheet" type="text/css">
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/information-01.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1000px;
	height:240px;
	margin-left:auto;
	margin-right:auto;
	padding-top:135px;
	
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	font-size:38px;
	color:#FFF;
	font-family:"微软雅黑";
	text-align:center;
	line-height:40px;
}



</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>


</head>
<body>

<jsp:include page="informationHeader.jsp"/><!--网站logo 导航条  end-->

<div class="banner">
  <div class="banner_txt">
    <div class="txt">信任　责任　专业　创新</div>
  </div>
</div>
<div style="width:100%;min-width:1200px;">
<div class="content" style="height:960px;">
  <div class="content_left">
    <div class="content_title"><strong>关于百富</strong></div>
    <div class="content_menu">
     <ul>
       <li><a href="${ctx}/introduce.do">百富网介绍</a></li>
       <li><a href="${ctx}/team.do">精英团队</a></li>
       <li><a href="${ctx}/investor.do">投资人关系</a></li>
       <li class="current" style="color: #349cd8;">政策法规</li>
     </ul>
    </div>
  </div>
  <div class="content_right"  style="height:780px;">
     ${information.content}
  </div>
</div></div>

<jsp:include page="../footer.jsp"/>
</body>
</html>
