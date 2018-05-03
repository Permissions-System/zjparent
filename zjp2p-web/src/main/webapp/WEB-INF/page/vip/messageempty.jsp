<%@page import="com.zjgt.util.DateConverterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>交易详情 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript">

</script>
<script type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
</head>

<%@include file="../header.jsp" %>
<!--网站logo 导航条  end-->

<div class="person_info">
<%@include file="left.jsp" %>
  <div class="person_info_right">
    <div class="member_h"><span class="am-icon-comment-o am-icon-sm" style="color:#009CE4"> 消息中心</span></div>
    <div class="personalinfo">
      <div class="message_empty"><span style="color:#009CE4;">hi ! </span>你还没有任何消息...</div>
    
    </div>
      
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
