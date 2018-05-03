<%@ page language="java"   pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>密码重置成功 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp" %>
<meta charset="utf-8">
<link href="${ctx }/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link rel="stylesheet" href="${ctx }/static/css/amazeui.css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript">
	$(function(){
		var times=10;
		setInterval(function(){
			times--;
			$("#times").html(times+"");
		},1000);
		
		setTimeout(function(){
			window.location.href="${ctx}/login.do";
		},10000);
	});
</script>


</head>

<body>
<%@include file="header.jsp" %>

<div class="login"><!--login  start-->
  <div class="reinf">密码重置成功! （<span style="color:#009CE4" id="times">10</span>）</div>
  <div class="reinf2">为保障您的信息安全，请重新登录！</div>
  <div class="reinf3" style="font-size:20px;">走进百富网，让人闲着，钱忙着~
  </div>
  <div class="reinf4"><a href="${ctx }/login.do"><button class="am-btn am-btn-secondary" >去登录</button></a></div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>
