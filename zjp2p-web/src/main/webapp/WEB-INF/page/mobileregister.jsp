<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html class="no-js">
<head>
 <title>要想富，上百富！1000块红包免费拿，见者有份，抢！- 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="keywords" content="">
  <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<link href="${ctx }/static/M_images/biifoo_icon.png" rel="shortcut icon" />
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
<link rel="apple-touch-icon-precomposed" href="${ctx }/static/M_images/1-04.png"/>
  <link rel="stylesheet" href="${ctx }/static/assets/css/amazeui.css">
  <link rel="stylesheet" href="${ctx }/static/assets/css/app.css">
  <script src="${ctx }/static/assets/js/sweet-alert.js"></script> 
  <link rel="stylesheet" type="text/css" href="${ctx }/static/assets/css/sweet-alert.css">
  <!--[if (gte IE 9)|!(IE)]><!-->
<script src="${ctx }/static/assets/js/jquery.min.js"></script>
<script src="${ctx }/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
	$(function(){
			$("#a1").click(function(){
				$("#img1").attr("src","mobiledraw.do?date="+new Date());
				});
			$("#img1").click(function(){
				$("#img1").attr("src","mobiledraw.do?date="+new Date());
				});
			$("#s1").click(function(){
			
				var $email=$.trim($("#doc-vld-email-1").val());
			var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if($email==""){
				sweetAlert("邮箱注册", "邮箱不能为空!", "error");
				return;
			}else if(!reg.test($email)){
				sweetAlert("邮箱注册", "邮箱格式错误!", "error");
				return;
			}else{
				$.get("emailajax.do?email="+$email,function(date){
					if(date.result=="E-mail不可用"){
						sweetAlert("邮箱注册", "邮箱已被注册!", "warning");
						return;
					}else{
						var $password=$.trim($("#doc-vld-pwd-1").val());
			 			var reg=/^[a-zA-Z0-9]\w{5,19}$/;
				 		if($password==""){
				 			sweetAlert("密码", "密码不能为空!", "error");
			 			}else if(!reg.test($password)){
			 				sweetAlert("密码", "密码的格式在6到20个字符", "error");		 		
			 			}else{
						 	 var $repassword=$.trim($("#doc-vld-pwd-2").val());
			 
			 				if($repassword==""){
			 					sweetAlert("确定密码", "确定密码不能为空", "error");
						 } else if($repassword!=$password){
							 	sweetAlert("确定密码", "两次输入的密码不相同", "error");	
						 }else{
						 $.get("imgcheck.do?msg="+$("#your-form").val(),function(data){
						if(data.status=="1"){
							sweetAlert("验证码", "验证码错误", "error");
						}else{
							$("#formid").submit();
						}
			});
			 }
			 			}
					}
				})
			}
				
				});
		
		})
</script>
</head>
<body>
<div class="wrap">
  <div class="am-g topbgc">
    <div class="am-u-sm-8 pdl"><a href="${ctx }/index.do"><img src="${ctx }/static/M_images/logo_1.png"  alt=""/></a></div>
    <div class="am-u-sm-4"></div>
  </div>
  <div class="am-g tbg">
    <div class="am-u-sm-11 am-u-sm-centered"><img src="${ctx }/static/M_images/money_1.png"  alt=""/></div>  </div>
  
  <div class="register">
   <form id="formid" action="mobileregister.do" method="post" class="am-form" data-am-validator>
   <fieldset>    
    <input type="email" id="doc-vld-email-1" name="email" class="am-form-field am-radius interval" placeholder="电子邮件" required/>
    <input type="password" id="doc-vld-pwd-1" name="password"class="am-form-field am-radius interval" placeholder="输入密码 " pattern="^[A-Za-z0-9]{6,18}$" onkeyup="value=value.replace(/[\W]/g,'') " 
      onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" required/>
    <input type="password" id="doc-vld-pwd-2" class="am-form-field am-radius interval" placeholder="确认密码" data-equal-to="#doc-vld-pwd-1" required/>
    <div class="am-g interval">
      <div class="am-u-sm-6" style="padding-left:0px;padding-right:0px;"><input type="text" id="your-form" class="am-form-field am-radius interva3" placeholder="验证码 "  /></div>
      <div class="am-u-sm-6"><img src="mobiledraw.do"  id="img1" alt=""/></div>
      
    </div>
    <button type="button" id="s1" class="btn interval2"><img src="${ctx }/static/M_images/btn.png"  alt=""/></button>
   </fieldset>
   </form>
   </div>
   <div class="am-g">
     <div class="am-u-sm-11 am-u-sm-centered bifo">@biifoo.com</div>
   </div>
     <div class="am-g">
     <div class="content"><img src="${ctx }/static/M_images/content.jpg"  alt=""/></div>
   </div>
   <div class="am-g">
     <div class="am-u-sm-11 am-u-sm-centered" id="navi"><a href="${ctx }/index.do">首页</a>　<a href="${ctx }/queryBidAll.do">我要投资</a>　<a href="${ctx }/helpcenter.do"  target="_blank">服务专区</a>　<a href="${ctx }/safeguard.do">安全保障</a>　<a href="${ctx }/introduce.do" target="_blank">百富故事</a></div>
   </div>
   <div class="am-g">
     <div class="logo"><a href="${ctx }/index.do"><img src="${ctx }/static/M_images/logo.png"  alt=""/></a></div>
   </div>
</div>








<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<![endif]-->
</body>
</html>