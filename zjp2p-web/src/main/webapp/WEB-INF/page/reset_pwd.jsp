<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<title>重置密码 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${ctx}/static/css/amazeui.css">
  <link rel="stylesheet" href="${ctx}/static/css/app.css">
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

.code2 {
	position: absolute;
	right: 1px;
	top:1px;
	background-color:#CCC;
	height:43px;
	width:100px;
}
.reset {
	width:600px;
	margin-left:auto;
	margin-right:auto;
	margin-top:50px;
	height:500px;
}
</style>


<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>

<script type="text/javascript">
	$(function(){
		var imgcodeable=false;
		$("#img").click(function(){
			$(this).attr("src","${ctx}/draw.do?time="+new Date());
		});
		
		//邮箱验证
		$("#email").focus(function(){
			$("#emailJS").html("");
		});
		$("#email").blur(function(){
			var $email=$.trim($("#email").val());
			var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if($email==""){
				return;
			}else if(!reg.test($email)){
				$("#emailJS").html("<font color='red'>邮箱格式有误</font>");
				return;
			}else{
				$.get("emailajax.do?email="+$email,function(date){
					if(date.result=="E-mail不可用"){
						return;
					}else{
						$("#emailJS").html("<a color='red' href='${ctx}/register.do'>没有此用户,现在去注册</a>");
						return ;
					}
				})
			}
		});
		
		$("#imgcode").focus(function(){
			$("#imgcodeJS").html("");
		});
		
		$("#imgcode").blur(function(){
			$.get("${ctx}/imgcheck.do",{msg:$("#imgcode").val()},function(data){
				if(data.status=="1"){
					$("#imgcodeJS").html("<font color='red'>验证码错误</font>");
				}else{
					imgcodeable=true;
				}
			});
		})
		var i;
		$("#submit2").click(function(){
			i=4;
			$(this).attr({"disabled":"disabled"});
			var $email=$.trim($("#email").val());
			var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if(!imgcodeable){
				$(this).removeAttr("disabled");
				$("#imgcodeJS").html("<font color='red'>验证码错误</font>");
				return ;
			}
			if($email==""){
				$(this).removeAttr("disabled");
				return;
			}else if(!reg.test($email)){
				$(this).removeAttr("disabled");
				$("#emailJS").html("<font color='red'>邮箱格式有误</font>");
				return ;
			}else{
				$(this).removeAttr("disabled");
				$.get("${ctx}/emailajax.do?email="+$email,function(date){
					if(date.result=="E-mail不可用"){
						$("#go").html($("#email").val().split('@')[1]);
						$("#doc-modal-1").modal("open");
						$("#times").html("5");
						var s=setInterval(function(){
							if(i>0){
							$("#times").html(""+i--);
							}else{
								$("#doc-modal-1").modal("close");
								clearInterval(s);
							}
						},1000);
						$.get("find.do?email="+$("#email").val(),function(data){
							
							setTimeout(function(){
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
								var url = $("#email").val().split('@')[1];
								window.open(hash[url]);
							},5000);
						
						});		
					}else{
						$("#emailJS").html("<font color='red'><a color='red' href='${ctx}/register.do'>没有此用户,现在去注册</a></font>");
					}
				})
			}
			
		});
		$("#a1").click(function(){
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
			var url = $("#email").val().split('@')[1];
			window.open(hash[url]);
			return false;
		})
	});
</script>
<script type="text/javascript">
	$(function(){
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
		$("#mobile").focus(function(){
			$("#mobileJS").html("");
		});
		//密码设置
		$("#password").focus(function(){
			$("#passwordJS").html("密码长度为6-20位字符,可以字母、数字、符号");
		});
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
		$("#repassword").focus(function(){
			$("#repasswordJS").html("");
		});
		
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
		$("#code").focus(function(){
			$("#codeJS").html("");
		});
		$("#sendmsg").click(function(){
 			// 禁用按钮 
 			$(this).attr({"disabled":"disabled"});
 			if($("#mobile").val()==""){
 				$(this).removeAttr("disabled");
 				return;
 	  	 	}
 			var reg=/^0?1[3|4|5|8][0-9]\d{8}$/;
 	 	 	 if(!reg.test($("#mobile").val())){
 	 	 		$(this).removeAttr("disabled");
 	 	 		$("#mobileJS").html("<font color='red'>手机号码格式不正确</font>");
 		 	  return ;
 	 	  }
 	 	 	$(this).removeAttr("disabled");
 	 	  $.post("${ctx}/ismobilereg.do",{mobile:$("#mobile").val()},function(data){
 			   if(data.status=="0"){
 				  $("#mobileJS").html("");
 				  showtime($("#sendmsg"),60);
 				  $.get("${ctx}/sendMobilcode.do?mobile="+$("#mobile").val(),function(){
					});
 			   }else {
 				  $("#mobileJS").html("<font color='red'><a href='${ctx}/register.do'>没有此用户，现在去注册？</a></font>");
 		   }
 	   })
    });  
		function butDisabled1(but){
	    	but.attr({"disabled":"disabled"});
			but.css("background-color","#C0C0C0");
			but.css("border-color","#C0C0C0");
			but.html("<i class='am-icon-spinner am-icon-spin'></i>修改中");
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
			if($("#mobile").val()==""){
 				butEnabled($("#submit"),"确 定");
 			   return;
 	  	 	}
			else if(!reg.test($("#mobile").val())){
 		 	$("#mobileJS").html("<font color='red'>手机号码格式不正确</font>");
 		 		butEnabled($("#submit"),"确 定");
 		 	  return ;
 	 		}else{
 	 			 var $password=$.trim($("#password").val());
				 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
				 if($password==""){
					 butEnabled($("#submit"),"确 定");
					 return;
				 }else if(!reg.test($password)){
					 $("#passwordJS").html("<font color='red'>密码长度为6-20位字符,可以字母、数字、符号</font>");
					 butEnabled($("#submit"),"确 定");
					 return;
				 }else{
					 var $repassword=$.trim($("#repassword").val());
					 var $password=$.trim($("#password").val());
					 if($repassword==""){
						 $("#passwordJS").html("<font color='red'>确定密码不能为空</font>");
						 butEnabled($("#submit"),"确 定");
						 return;
					 } else if($repassword!=$password){
						 $("#repassword").html("<font color='red'>两次输入密码不相同</font>");
						 butEnabled($("#submit"),"确 定");
						 return;
					 }else{
						 $.post("${ctx}/mobilecodeisright.do",{code:$("#code").val()},function(data){
							 if(data.result=="验证码正确"){
								 $.post("${ctx}/mpwd.do",{mobile:$("#mobile").val(),password:$("#password").val(),code:$("#code").val()},function(data){
										if(data.status=="1"){
												window.location.href="${ctx}/mresetsuc.do";
										}else{
												butEnabled($("#submit"),"确 定");
										}
									});
							 }else{
								 $("#msgJS").html("<font color='red'>"+data.result+"</font>");
								 	butEnabled($("#submit"),"确 定");
							 }	
						 });
 	 		 		 }
				 }
 	 		}
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
		if(time>0){
		showtime($("#sendmsg"),time);
		}
	});
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body style="background-color:#f1f1f1">
<jsp:include page="header.jsp"/>
<!--网站logo 导航条  end-->

 <div class="reset">
    <div class="login_h">
      
      <div class="login_input" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; ">
        <div class="am-tabs" data-am-tabs>
          <ul class="am-tabs-nav am-nav am-nav-tabs" style="border-color:#fff">
            <li class="am-active"><a href="#tab1" style="border-color:#fff;font-size:16px">通过手机找回密码</a></li>
            <li><a href="#tab2" style="border-color:#fff;font-size:16px">通过邮箱找回密码</a></li>
          </ul>
          <div class="am-tabs-bd">
            <div class="am-tab-panel am-fade am-in am-active" id="tab1" style="background-color:#fff;">
              <div class="am-g" style="margin-top:3%;">
                <div class="am-u-sm-11 am-u-sm-centered" style="padding:0">
                  <div style="position:relative;">
                    <input type="text" id="mobile" class="am-form-field am-radius" style="padding-left:55px;height:45px;" placeholder="请输入手机号" />
                    <div class="iconp"><img src="${ctx }/static/images/phone-1.png"  alt=""/></div>
                  </div>
                  <div style="height:25px;font-size:12px;" id="mobileJS">&nbsp;</div>
                  <div style="position:relative;">
                    <input type="text" id="code" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请输入手机短信验证码" />
                    <div class="iconp"><img src="${ctx }/static/images/code-1.png"  alt=""/></div>
                    <button class="code" id="sendmsg">
                    	短信验证
                    </button>
                  </div>
                  <div style="height:25px;font-size:12px;" id="msgJS">&nbsp;</div>
                  <div style="position:relative;">
                    <input type="password" id="password" id="password" class="am-form-field am-radius inputi1" style="padding-left:55px;height:45px;" placeholder="请设置新登录密码" />
                    <div class="iconp"><img src="${ctx }/static/images/pwd-1.png"  alt=""/></div>
                  </div>
                  <div style="height:25px;font-size:12px;" id="passwordJS">&nbsp;</div>
                  <div style="position:relative;">
                    <input type="password" id="repassword" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请再次输入您的登录密码" />
                    <div class="iconp"><img src="${ctx }/static/images/pwd-1.png"  alt=""/></div>
                  </div>
                  <div style="height:25px;font-size:12px;" id="repasswordJS">&nbsp;</div>
                  <button type="button" id="submit" class="am-btn am-btn-secondary am-radius check1" style="width:100%; font-size:1.8rem; margin-bottom:5%">确 定</button>
                  <div style="text-align:right;width:120px;margin-left:410px;" data-am-popover="{content: '短信可能会延迟，如果您长时间没有收到短信验证码，请重发。', trigger: 'hover focus'}">没收到短信验证码？</div>
                </div>
              </div>
            </div>
            <div class="am-tab-panel am-fade" id="tab2" style="background-color:#fff;">
            <div class="am-g" style="margin-top:3%;">
                <div class="am-u-sm-11 am-u-sm-centered" style="padding:0">
                  <div style="position:relative;">
                    <input type="text" id="email" class="am-form-field am-radius" style="padding-left:55px;height:45px;" placeholder="请输入邮箱" />
                    <div class="iconp"><img src="${ctx }/static/images/mail-1.png"  alt=""/></div>
                  </div>
                  <div style="height:25px;font-size:12px;" id="emailJS">&nbsp;</div>
                  <div style="position:relative;">
                    <input type="text" id="imgcode" class="am-form-field am-radius inputi2" style="padding-left:55px;height:45px;" placeholder="请输入右图里的验证码" />
                    <div class="iconp"><img  src="${ctx }/static/images/code-1.png"  alt=""/></div>
                    <div class="code2">
                    <a href="#"><img id="img" src="${ctx }/draw.do" alt=""/></a>
                    </div>
                  </div>
                  <div style="height:25px;font-size:12px;" id="imgcodeJS">&nbsp;</div>
                  <button type="button" id="submit2" class="am-btn am-btn-secondary am-radius check1" style="width:100%; font-size:1.8rem; margin-bottom:5%">确 定</button>
                  <div style="text-align:right;width:120px;margin-left:410px;" data-am-popover="{content: '由于某些邮箱对邮件进行屏蔽，建议您进入垃圾箱中查找。', trigger: 'hover focus'}">还没收到重置邮件？</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">重置邮件已发送到您的邮箱
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a>
    </div>
    <div class="am-modal-bd">
      			 请登录至邮箱后点击邮件内的重置链接以重置密码，<br>还剩 <span style="font-size:15px;color:#009CE4" id="times">5</span> 秒后自动跳转至<span style="font-size:15px;color:#009CE4" id="go"></span>邮箱登陆<br>
       <a id="a1" href="#" style="font-size:15px;color:#009CE4">现在就去</a>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>

</html>
