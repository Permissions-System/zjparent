<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
</head>
<body>
<div class="top_1"><!--顶部扫微信 登录 注册   start-->
  <div class="top_wrap">
  	<p class="pa">关注我们</p>
    <div class="top_img"><a href="#" class="am-biifoo-btn am-icon-weibo"></a> <a href="#" class="am-biifoo-btn am-icon-qq"></a></div>
    <div class="am-icon-wechat am-biifoo2-btn " ></div>
    <shiro:authenticated><p class="pb">欢迎您：<a href="${ctx }/member/investdoc.do"><shiro:principal property="nickname"/></a>　|　<a href="${ctx }/loginout.do">退出</a>　  <a href="${ctx }/member/message.do"><span class="am-icon-envelope-o" style="font-size:14px"></span></a><a href="${ctx }/member/message.do" class="am-numb-btn" style="color: #fff;"><shiro:principal property="unreadMessageCount"/></a>　<a href="${ctx }/helpcenter.do" target="_blank">帮助</a></p></shiro:authenticated>
    <shiro:notAuthenticated><p class="pb"><a href="${ctx }/login.do">登 录</a>　|　<a href="${ctx }/register.do">注 册</a></p></shiro:notAuthenticated>
  </div>
</div><!--顶部扫微信 登录 注册  end-->


<div class="nav2"><!--网站logo 导航条   start-->
  <div class="nav_wrap">
    <div class="logo"><a href="http://www.biifoo.com"><img src="${ctx}/static/images/biifoo_logo.png"  alt="biifoo logo"/></a></div>
    <div class="navi2">
      <ul>
        <li><img src="${ctx}/static/images/home.png" style="margin-top:4px;" /><a href="index.do"><span style="vertical-align:top"> 首 页</span></a></li>
        <li><a href="${ctx}/introduce.do" >关于百富</a></li>
        <li><a href="${ctx}/queryNewsAll.do">新闻&amp;报道</a></li>
        <li><a href="${ctx}/queryDeptAll.do?parent=3" >加入百富</a></li>
      </ul>
    </div>
  </div>
</div><!--网站logo 导航条  end-->
</body>
</html>