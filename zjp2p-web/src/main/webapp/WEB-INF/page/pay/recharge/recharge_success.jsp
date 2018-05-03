<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>充值成功 - 百富网小额投资理财平台</title>
<%@include file="../../../common/tdk.jsp"%>
<%@include file="../../../common/header.jsp"%>
<meta charset="utf-8">

<link href="images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script src="${ctx}/static/js/amazeui.js"></script>
 
</head>

<body>
<%@include file="../../header.jsp" %>
<div class="person_info">
  <%@include file="../../vip/left.jsp"%> 
  <div class="person_info_right">
    <div class="member_h"><span class="am-icon-cny" style="color:#009CE4;"> 充 值</span></div>
    <div class="personalinfo" style="margin-top:60px;">
      <div style="margin-left:33px; margin-top:40px;"><span style="font-size:20px; margin-top:5px;"><span class="am-icon-check" style="color:#8ABF1E"></span> 充值成功！</span>
        <br>
        <br>
      您还可以：<a href="${ctx}/member/recharge.do">继续充值</a>　<a href="${ctx}/member/dealhistory.do?status=2">查看充值记录</a>　<a href="${ctx}/member/investdoc.do">返回我的账户</a></div>
    </div>
  </div>
</div>
<%@include file="../../footer.jsp"%>
</body>
</html>
