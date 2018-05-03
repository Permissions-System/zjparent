<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	background-position: center;
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

#wrap {
	background-image:url(${ctx}/static/images/redbg.jpg);
	background-repeat:no-repeat;
	width:100%;
	height:3442px;
	background-position:center;
}

#content {
	width:1200px;
	margin-left:auto;
	margin-right:auto;
}

</style>

</head>

<body>
<jsp:include page="../header.jsp"/><!--网站logo 导航条  end-->

<div id="wrap" style="margin-bottom: -65px;">
<div id="content">
<img src="${ctx}/static/images/redpacket1.png"  alt=""/>
<img style="margin-top:-7px;" src="${ctx}/static/images/redpacket2.png"  alt=""/>
<img src="${ctx}/static/images/redpacket3.png"  alt="" usemap="#Map" style="margin-top:-7px;"/>
<map name="Map">
  <area shape="rect" coords="496,29,716,89" href="${ctx}/register.do">
  <area shape="rect" coords="737,57,861,84" href="${ctx}/helpcenter.do" target="_blank">
</map>
<img style="margin-top:-7px;" src="${ctx}/static/images/redpacket4.png"  alt=""/>
<img src="${ctx}/static/images/redpacket5.png"  alt="" usemap="#Map2" style="margin-top:-7px;"/>
<map name="Map2">
  <area shape="rect" coords="497,21,714,80" href="${ctx}/register.do">
</map>
<img style="margin-top:-7px;" src="${ctx}/static/images/redpacket6.png"  alt=""/>
<img style="margin-top:-7px;" src="${ctx}/static/images/redpacket8.png"  alt=""/>
<img src="${ctx}/static/images/redpacket9.png"  alt="" usemap="#Map4" style="margin-top:-7px;"/>
<map name="Map4">
  <area shape="rect" coords="450,35,762,119" href="${ctx}/register.do">
</map>
</div>
</div>
<jsp:include page="../footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
