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
<title>新闻 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/news_detail.css" rel="stylesheet" type="text/css">
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/information-04.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1000px;
	height:310px;
	margin-left:auto;
	margin-right:auto;
	padding-top:35px;
	
}

.banner .banner_txt .news_h {
	width:350px;
	height:310px;
	background:#60446F;
	filter:alpha(opacity=80);  
    -moz-opacity:0.8;  
    -khtml-opacity: 0.8;  
    opacity: 0.8;
	padding-top:55px;
	padding-left:38px;
	padding-right:35px;
}

.banner .banner_txt .news_h .news_dt {
	font-family:"微软雅黑";
	font-size:26px;
	color:#FFF;
	line-height:45px;
}
.banner .banner_txt .news_h .news_dt2 {
	height:28px;
	font-family:"微软雅黑";
	font-size:13px;
	color:#FFF;
	line-height:29px;
	text-indent:30px;
	margin-top:70px;
	background-image:url(${ctx}/static/images/share.png);
	background-repeat:no-repeat;
}

</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>


</head>

<body >
<jsp:include page="informationHeader.jsp"/><!--网站logo 导航条  end-->
<div class="banner">
  <div class="banner_txt">
    <div class="news_h">
      <div class="news_dt">${title}</div>
      <div class="news_dt2"><fmt:formatDate value="${news.createDate}"  type="both" pattern="yyyy-MM-dd"/> </div>
    </div>
  </div>
</div>
<div style="width:100%;min-width:1200px;">
<div class="content" style="height: auto;">
  <div class="subnav"><a href="queryNewsAll.do">新闻&报道</a> > <a href="queryNewsAll.do?categoryid=${news.categoryid}">${articlecategory.name}</a> > 新闻详情</div>
  <div class="news_titles">${news.title}</div>
  <div class="news_time"><fmt:formatDate value="${news.createDate}"  type="both" pattern="yyyy-MM-dd"/></div>
  <div class="news_content">${news.content}</div>
</div></div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
