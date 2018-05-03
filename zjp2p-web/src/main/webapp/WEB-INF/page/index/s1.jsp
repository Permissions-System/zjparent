<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>

<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<style type="text/css">
.banner {
	width: 100%;
	height: 479px;
	background-image: url(${ctx}/static/images/mm_banner.jpg);

}

.banner .banner_img {
	width:1200px;
	height:479px;
	margin-left:auto;
	margin-right:auto;
	background-image:url(${ctx}/static/images/mm.png);
	
	
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	font-size:20px;
	color:#FFF;
	font-family:"微软雅黑";
	text-align:center;
	line-height:40px;
}

.banner .banner_txt .txt span {
	font-size: 55px;
}


</style>

</head>

<body>
<jsp:include page="../header.jsp"/><!--网站logo 导航条  end-->

<div class="banner">
  <div class="banner_img"></div>
</div>

<div style="width:1200px; height:2600px; margin-left:auto; margin-right:auto; background-color:#fff;margin-bottom: -65px;">
<img src="${ctx}/static/images/s1-02.jpg"  alt=""/>
<img src="${ctx}/static/images/s1-03.jpg" style="margin-top:-7px;" alt=""/><img src="${ctx}/static/images/s1-04.jpg" style="margin-top:-7px;" alt=""/>
<img src="${ctx}/static/images/s1-05.jpg" style="margin-top:-7px;" alt=""/>
<div style="margin-left:auto; margin-right:auto; width:215px;height:90px;margin-top: 20px;"><shiro:authenticated><a href="${ctx}/queryBidAll.do?bidtypeid=3"><button type="button" class="am-btn am-btn-secondary" style="width:215px;height: 65px; font-size: 26px;">开始理财</button></a></shiro:authenticated>
															   <shiro:notAuthenticated><a href="${ctx}/queryBidAll.do?bidtypeid=3"><button type="button" class="am-btn am-btn-secondary" style="width:215px;height: 65px; font-size: 26px;">开始理财</button></a></shiro:notAuthenticated></div>
 </div>
<jsp:include page="../footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
