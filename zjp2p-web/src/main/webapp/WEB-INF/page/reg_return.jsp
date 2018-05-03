<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<title>注册成功 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>


<script type="text/javascript">
	$(function(){
		$("#nicknamea").click(function(){
			
			$("#nicknamea").attr("href","modifynickname.dao?id="+$("#id").val()+"&nickname="+$("#nickname"));
		});
		var hash={
		    'qq.com': 'http://mail.qq.com',
		    'gmail.com': 'http://mail.google.com',
		    'sina.com': 'http://mail.sina.com.cn',
		    '163.com': 'http://mail.163.com',
		    '126.com': 'http://mail.126.com',
		    'yeah.net': 'http://www.yeah.net/',
		    'sohu.com': 'http://mail.sohu.com/',
		    'tom.com': 'http://mail.tom.com/',
		    'sogou.com': 'http://mail.sogou.com/',
		    '139.com': 'http://mail.10086.cn/',
		    'hotmail.com': 'http://www.hotmail.com',
		    'live.com': 'http://login.live.com/',
		    'live.cn': 'http://login.live.cn/',
		    'live.com.cn': 'http://login.live.com.cn',
		    '189.com': 'http://webmail16.189.cn/webmail/',
		    'yahoo.com.cn': 'http://mail.cn.yahoo.com/',
		    'yahoo.cn': 'http://mail.cn.yahoo.com/',
		    'eyou.com': 'http://www.eyou.com/',
		    '21cn.com': 'http://mail.21cn.com/',
		    '188.com': 'http://www.188.com/',
		    'foxmail.coom': 'http://www.foxmail.com'
		};
		    $("#emailskip").click(function() {
		        var url = $("#emailvalue").html().split('@')[1];
		        window.open(hash[url]);
		    });
			$("#sendemail").click(function(){
				var $url=$("#sendemail").attr("href");
				$.get($url,function(date){
					alert(date.result);
				})
				return false;
			});
		
	});
</script>
<script type="text/javascript">
	$(function(){
		setTimeout(function(){
			window.location.href="${ctx}/member/investdoc.do";
		},10000);
		var i=4;
		time=9;
		setInterval(function(){
			if(time>0){
			$("#st").html(""+time--);
			}
		},1000);
		
		setTimeout(function(){
			$.get("${ctx}/marketingmsg.do",function(data){});
		},0);
	});

</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<%@include file="header.jsp"%>

<div class="login"><!--login  start-->
  <div class="reinf">恭喜，<span style="color:#3DB236;"><shiro:principal property="mobile"></shiro:principal></span> 已经注册成功!<br>
<span style="font-size:16px;">将在 <span style="color:#009CE4" id="st">10</span> 秒后自动跳转至会员中心</span>
</div>
  <div class="reinf2"><shiro:principal property="nickname"></shiro:principal>是我们为您定制的专属身份标识，有了它，走遍百富都不怕！</div>
  <div class="reinf3" style="font-size:20px;">走进百富网，让人闲着，钱忙着~
  </div>
  <div class="reinf4"><a href="${ctx }/member/investdoc.do"><button class="am-btn am-btn-secondary" >去会员中心</button></a></div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>

