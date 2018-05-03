<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">
<head>
<title>手机注册- 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <!-- Set render engine for 360 browser -->
  <meta name="renderer" content="webkit">

  <!-- No Baidu Siteapp-->
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <!-- Add to homescreen for Chrome on Android -->
  <meta name="mobile-web-app-capable" content="yes">
  
  <!-- Add to homescreen for Safari on iOS -->
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-title" content=""/>
  

  <!-- Tile icon for Win8 (144x144 + tile color) -->
  <meta name="msapplication-TileColor" content="#0e90d2">

  <link rel="stylesheet" href="${ctx }/static/assets/css/amazeui.css">
  <link rel="stylesheet" href="${ctx }/static/assets/css/app.css">
  <script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
 <script type="text/javascript">
 	$(function(){
 		$("#a1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		$("#img1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		$("#submit").click(function(){
		
			var $email=$.trim($("#doc-vld-email-1").val());
			var reg1=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			
			if($email==""){
				return;
			}
			if(!reg1.test($email)){
				return;
			}
			$.get("emailajax.do?email="+$email,function(date){
				if(date.result=="E-mail不可用"){
					//邮箱已被注册
					alert("邮箱被注册");
				}else{
					 var $password=$.trim($("#doc-vld-pwd-1").val());
					 var reg=/^[a-zA-Z0-9]\w{5,17}$/;
					 if($password==""){
						 return;
					 }
					 if(!reg.test($password)){
						 return;
					 }
					 var $repassword=$.trim($("#doc-vld-pwd-2").val());
					 if($repassword!=$password){
						 return;
					 }
					$.get("imgcheck.do?msg="+$("#check").val(),function(data){
							if(data.status=="1"){
								//加css样式
								alert("验证码错误");
								return;
							}else{
								$("#s1").submit();
							}
						});
				}
			});
			
		});
 	});
  </script>
</head>
<body>
<div class="wrap">
  <div class="bcat"><img src="${ctx }/static/images/bcat.png"  alt=""/></div>
  <div class="am-g top">
    <img src="${ctx }/static/images/money.png"  alt=""/> 
  </div>
  
  <div class="middle">
    <img src="${ctx }/static/images/middle.png" style="margin-top:-5%;" alt=""/>
  </div>
  
  <div class="register">
  <form action="register.do" id="s1" method="post" class="am-form" data-am-validator>
   <fieldset>
    <input type="email" name="email" id="doc-vld-email-1" class="am-form-field am-radius interval" placeholder="电子邮件" required/>
    <input type="password" name="password" id="doc-vld-pwd-1" class="am-form-field am-radius interval" placeholder="输入密码(6-18)位" pattern="^\d{6,18}$" required/>
    <input type="password" id="doc-vld-pwd-2" class="am-form-field am-radius interval" placeholder="确认密码" data-equal-to="#doc-vld-pwd-1" required/>
    <div class="am-g interval">
      <div class="am-u-sm-5" style="padding-left:0px;padding-right:0px;"><input type="text" id="check" name="msg" class="am-form-field am-radius interval3" placeholder="验证码" /></div>
      <div class="am-u-sm-3"><img src="draw.do" id="img1"  style="height: 50%;width: 100%" alt=""/></div>
      <div class="am-u-sm-4 change"><a href="#" id="a1">换一换</a></div>
    </div>
   </fieldset>
     </form>
     <button type="submit" id="submit" class="btn interval2"><img src="${ctx }/static/images/btn.png"  alt=""/></button>
  <img src="${ctx }/static/images/content.png" style="max-width:110%; margin-left:-5%" alt=""/> </div>
  
  <div class="corner"><img src="${ctx }/static/images/corner.png"  alt=""/></div>
</div>
<div id="navi"><a href="#">首页</a> | <a href="#">我要投资</a> | <a href="#">服务专区</a> | <a href="#">安全保障</a> | <a href="#">百富故事</a></div>







<!--[if (gte IE 9)|!(IE)]><!-->
<script src="${ctx }/static/assets/js/jquery.min.js"></script>
<script src="${ctx }/static/assets/js/amazeui.js"></script>

<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<![endif]-->
</body>
</html>	