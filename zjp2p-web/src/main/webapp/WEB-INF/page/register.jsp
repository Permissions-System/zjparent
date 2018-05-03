<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>注册 - 百富网小额投资理财平台</title>
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
<script type="text/javascript" src="${ctx}/static/js/mobile-common.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>
<script type="text/javascript">
	$(function(){
		var emailisuseful=true;
		$("#a1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		$("#img1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		//倒计时
		 function showtime(o,wait) {
		        if (wait == 0) {
		        	$.cookie("time",0,{ expires: 1/1440 });
		        	o.removeAttr("disabled");          
		            o.html("短信验证");
		            wait = 60;
		        } else {
		            o.attr({"disabled":"disabled"});
		            o.html("重新发送(" + wait + ")");
		            wait--;
		            $.cookie("time",wait,{ expires: 1/1440 });
		            setTimeout(function() {
		                showtime(o,wait)
		            },
		            1000)
		        }
		    }
		//手机验证
		$("#mobile").focus(function(){
			$("#mobileJS").html("<font>可作为登录账号，并用于找回密码</font>");
		});
		$("#mobile").blur(function(){
			var reg=/^0?1[3|4|5|8][0-9]\d{8}$/;
			if($("#mobile").val()==""){
				$("#mobileJS").html("<font color='red'>手机号码不能为空</font>");
				return ;
			}else if(!reg.test($("#mobile").val())){
				$("#mobileJS").html("<font color='red'>手机号格式有误</font>");
				return;
			}
			 $.post("${ctx}/ismobilereg.do",{mobile:$("#mobile").val()},function(data){
				 if(data.status=="0"){
	 				 $("#mobileJS").html("<font color='red'>该手机号已被注册</font>");
	 			   }else {
	 				  $("#mobileJS").html("<font>可作为登录账号，并用于找回密码</font>");  
	 			   }
			 });
		});
		
		//邮箱验证
		$("#email").focus(function(){
			$("#emailJS").html("<font>可作为登录账号，并用于找回密码</font>");
		});
		$("#email").blur(function(){
			var $email=$.trim($("#email").val());
			var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if($email==""){
				$("#emailJS").html("<font>可作为登录账号，并用于找回密码</font>");
				emailisuseful=true;
			}else if(!reg.test($email)){
				$("#emailJS").html("<font color='red'>邮箱格式有误</font>")
				emailisuseful=false;
			}else{
				$.get("emailajax.do?email="+$email,function(date){
					if(date.result=="E-mail不可用"){
						$("#emailJS").html("<font color='red'>此邮箱已被注册</font>");
						emailisuseful=false;
					}else{
						$("#emailJS").html("<font color='green'>恭喜，该邮箱可用</font>");
						emailisuseful=true;
					}
				})
			}
		});
		
		function request(paras){ 
			var url = location.href;  
			var paraString = url.substring(url.indexOf("?")+1,url.length).split("&");  
			var paraObj = {}  
			for (i=0; j=paraString[i]; i++){  
			paraObj[j.substring(0,j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=")+1,j.length);  
			}  
			var returnValue = paraObj[paras.toLowerCase()];  
			if(typeof(returnValue)=="undefined"){  
			return "";  
			}else{  
			return returnValue; 
			}
			}
		
		//密码设置
		$("#password").blur(function(){
			 var $password=$.trim($("#password").val());
			 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
			 if($password==""){
				 $("#passwordJS").html("<font color='red'>密码不能为空</font>");
				 passwordisuseful=false;
			 }else if(!reg.test($password)){
				 $("#passwordJS").html("<font color='red'>密码长度为6~20位字符，可为数字、字母、符号</font>");
				 passwordisuseful=false;
			 }else{
				 $("#passwordJS").html(" ");
				 passwordisuseful=true;
			 }
		});
		//重复密码
		$("#repassword").blur(function(){
			 var $repassword=$.trim($("#repassword").val());
			 var $password=$.trim($("#password").val());
			 if($repassword==""){
				 $("#repasswordJS").html("<font color='red'>确认密码不能为空</font>");
				 repasswordisuseful=false;
			 } else if($repassword!=$password){
				 $("#repasswordJS").html("<font color='red'>密码与确认密码不一致</font>");
				 repasswordisuseful=false;
			 }else{
				 $("#repasswordJS").html(" ");
				 repasswordisuseful=true;
			 }
		 });
		//验证码校验
		$("#sendmsg").click(function(){
 			// 禁用按钮 
 			$(this).attr({"disabled":"disabled"});
 			if($("#mobile").val()==""){
 				$(this).removeAttr("disabled");
 				$("#mobileJS").html("<font color='red'>手机号码不能为空</font>");
				return ;
 	  	 	}
 			var reg=/^0?1[3|4|5|8][0-9]\d{8}$/;
 	 	 	 if(!reg.test($("#mobile").val())){
 	 	 		$(this).removeAttr("disabled");
 	 	 		$("#mobileJS").html("<font color='red'>手机号格式有误</font>");
				return ;
 	 	  }
 	 	 	 $("#sendmsg").removeAttr("disabled");
 	 	  $.post("${ctx}/ismobilereg.do",{mobile:$("#mobile").val()},function(data){
 	 		   
 			   if(data.status=="0"){
 	 	 	 		$("#mobileJS").html("<font color='red'>该手机号已被注册</font>");
					return ;
 			   }else {
					  //showtime($("#sendmsg"),60);
 				   $.get("${ctx}/sendMobilcode.do?mobile="+$("#mobile").val(),function(){
 				   
					});
 		 		  }
 	  		 })
   		});     
		function butDisabled1(but){
	    	but.attr({"disabled":"disabled"});
			but.css("background-color","#C0C0C0");
			but.css("border-color","#C0C0C0");
			but.html("<i class='am-icon-spinner am-icon-spin'></i>注册中");
	    }
 		 function butEnabled(but , butHtml){
 	    	but.removeAttr("disabled");
 	    	but.css("background-color","#009CE4");
 	    	but.css("border-color","#009CE4");
 	    	but.html(butHtml);
 	    	but.val(butHtml);
 	    }
		$("#submit").click(function(){
			butDisabled1($("#submit"));
			var reg=/^0?1[3|4|5|8][0-9]\d{8}$/;
			var falg=$("#checkbox").is(":checked");
			if(!emailisuseful){
				return;
			}
			if(!falg) {
				alert("同意百富条款才能注册");
 		 		butEnabled($("#submit"),"注册");
				return ;
			}
			if($("#mobile").val()==""){
				$("#mobileJS").html("<font color='red'>手机号不能为空</font>");
 				butEnabled($("#submit"),"注册");
 			   return;
 	  	 	}
			else if(!reg.test($("#mobile").val())){
				$("#mobileJS").html("<font color='red'>手机号格式有误</font>");
 		 		butEnabled($("#submit"),"注册");
 		 	  return ;
 	 		}else{
 	 		  $.post("${ctx}/ismobilereg.do",{mobile:$("#mobile").val()},function(data){
 	 			   if(data.status=="0"){
 	 	 	 	 		$("#mobileJS").html("<font color='red'>该手机号已被注册</font>");
 	 	 	 	 	    butEnabled($("#submit"),"注册");
 	 	 	 	 		return ;
 	 			   }else {
 	 			 var $password=$.trim($("#password").val());
				 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
				 if($password==""){
					 $("#passwordJS").html("<font color='red'>密码不能为空</font>");
					 butEnabled($("#submit"),"注册");
					 return;
				 }else if(!reg.test($password)){
					 $("#passwordJS").html("<font color='red'>密码格式有误</font>");
					 butEnabled($("#submit"),"注册");
					 return;
				 }else{
					 var $repassword=$.trim($("#repassword").val());
					 var $password=$.trim($("#password").val());
					 if($repassword==""){
						 $("#passwordJS").html("<font color='red'>确定密码不能为空</font>");
						 butEnabled($("#submit"),"注册");
						 return;
					 } else if($repassword!=$password){
						 $("#passwordJS").html("<font color='red'>两次输入密码不相同</font>");
						 butEnabled($("#submit"),"注册");
						 return;
					 }else{
						 $.post("${ctx}/mobilecodeisright.do",{code:$("#code").val()},function(data){
							 if(data.result=="验证码正确"){
								 $.post("${ctx}/registerAjax.do",{mobile:$("#mobile").val(),password:$("#password").val(),email:$("#email").val(),agentid:request('agentid'),code:$("#code").val()},function(data){
										if(data.status=="1"){
											setTimeout(function(){
												window.location.href="${ctx}/member/reg_return.do";
											}, 3000);
											
										}else{
											butEnabled($("#submit"),"注册");
											 alert(data.result);
										}
									});
							 }else{
								 $("#msgJS").html("<font color='red'>"+data.result+"</font>");
								 butEnabled($("#submit"),"注册");
							 }	
						 });
 	 		 		 }
				 }
 	 		 		  }
 	 	  		 });
			}	
		});
		 $(this).keydown( function(e) {
             var key = window.event?e.keyCode:e.which;
            //alert(key.toString());
             if(key.toString() == "13"){
                         return false;
             }
     });
	});
</script>
<script type="text/javascript">
	$(function(){
		$("#imglogin").click(function(){
			window.location.href="login.do";
		});
	});

</script>
<script type="text/javascript">
	$(function(){
		var time=parseInt($.cookie("time"));
		 function showtime(o,wait) {
		        if (wait == 0) {
		        	$.cookie("time",0,{ expires: 1/1440 });
		        	o.removeAttr("disabled");          
		            o.html("获取验证码");
		            wait = 60;
		        } else {
		            o.attr({"disabled":"disabled"});
		            o.html("重新发送(" + wait + ")");
		            wait--;
		            $.cookie("time",wait,{ expires: 1/1440 });
		            setTimeout(function() {
		                showtime(o,wait)
		            },
		            1000)
		        }
		    }
		if(time>0){
		showtime($("#sendmsg"),time);
		}
	});
</script>
<style type="text/css">
.iconp {
	position: absolute;
	left: 1px;
	bottom: 0.3em;
	background-color: #fff;
	top: 5px;
}
.code {
	position: absolute;
	right: 1px;
	bottom: 0.75em;
	border-left-color: #CCC;
	border-left-style: solid;
	border-left-width: 1px;
	text-align: center;
	padding-left: 5%;
	padding-right: 5%;
	font-size: 1.4rem;
	background-color: #fff;
	border-bottom: #fff;
	border-top: #fff;
	border-right: #fff;
	border-right-width: 0px;
}
</style>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<jsp:include page="headerV2.jsp"/>
<!--网站logo 导航条  end-->
<div class="login"><!--login  start-->
  <div class="login_left"><a href="${ctx }/redadv.do"><img src="${ctx }/static/images/login.png" width="325" height="284"  alt=""/></a></div>
  <div class="login_right">
    <div class="login_h">
      <div class="login_hh">注册百富</div>
      <div class="login_pull"><a href="#" id="imglogin"><img src="${ctx }/static/images/log_in.png" width="66" height="64"  alt=""/></a></div>
      <div class="login_input" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; ">
        <div class="am-g" style="background-color:#f0f0f0;margin-top:3%;">
          <div class="am-u-sm-11 am-u-sm-centered" style="padding:0">
            <div style="position:relative;">
              <input type="text" class="am-form-field am-radius"  id="mobile" style="padding-left:55px;height:45px;" placeholder="请填写常用手机号" />
              <div class="iconp"><img src="${ctx }/static/images/phone-1.png"  alt=""/></div>
            </div>
            <div style="font-size:12px;height:25px" id="mobileJS">&nbsp;</div>
            <div style="position:relative;">
              <input type="text" id="code" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请输入手机短信验证码" />
              <div class="iconp"><img src="${ctx }/static/images/code-1.png"  alt=""/></div>
              <button class="code" id="sendmsg">
              		短信验证
              </button>
            </div>
            <div style="color:#f00;font-size:12px;height:25px" id="msgJS">&nbsp;</div>
            <div style="position:relative;">
              <input type="password" id="password" class="am-form-field am-radius inputi1" style="padding-left:55px;height:45px;" placeholder="请设置登录密码" />
              <div class="iconp"><img src="${ctx }/static/images/pwd-1.png"  alt=""/></div>
            </div>
            <div style="color:#f00;font-size:12px;height:25px" id="passwordJS">&nbsp;</div>
            <div style="position:relative;">
              <input type="password" id="repassword" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请再次输入您的登录密码" />
              <div class="iconp"><img src="${ctx }/static/images/pwd-1.png"  alt=""/></div>
            </div>
            <div style="color:#f00;font-size:12px;height:25px" id="repasswordJS">&nbsp;</div>
            <div style="position:relative;">
              <input type="text" id="email" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请填写常用邮箱" />
              <div class="iconp"><img src="${ctx }/static/images/mail-1.png"  alt=""/></div>
            </div>
            <div style="font-size:12px;height:25px" id="emailJS">&nbsp;</div>
            
            <div class="fc">
              <label class="am-checkbox">
                <input type="checkbox" checked="checked" id="checkbox" value="" data-am-ucheck checked>
                我已阅读并同意 <a href="${ctx }/static/protocol/registerprotocol.pdf">《百富网注册协议》</a><br>　　　　　　 　<a href="${ctx }/static/protocol/manageprotocol.pdf">《百富网投资咨询与管理服务协议》</a> </label>
            </div>
            <button type="button" id="submit" class="am-btn am-btn-secondary am-radius check1" style="width:100%; font-size:1.8rem; margin-bottom:5%">注 册</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="footerV2.jsp"/>
</body>
</html>


