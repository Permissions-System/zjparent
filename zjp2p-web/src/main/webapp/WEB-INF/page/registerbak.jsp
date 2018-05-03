<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">
<title>百富网-智富人生</title>
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
		var emailisuseful=false;
		$("#a1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		$("#img1").click(function(){
			$("#img1").attr("src","draw.do?date="+new Date());
		})
		$("#email").blur(function(){
			var $email=$.trim($("#email").val());
			var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if($email==""){
				$("#emailJS").html("<font color='red'>邮箱不能为空</font>")
				emailisuseful=false;
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
		$("#password").blur(function(){
			 var $password=$.trim($("#password").val());
			 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
			 if($password==""){
				 $("#passwordJS").html("<font color='red'>密码不能为空</font>");
				 passwordisuseful=false;
			 }else if(!reg.test($password)){
				 $("#passwordJS").html("<font color='red'>密码长度为6~20位字符</font>");
				 passwordisuseful=false;
			 }else{
				 $("#passwordJS").html("<font color='green'>密码格式正确</font>");
				 passwordisuseful=true;
			 }
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
				 $("#repasswordJS").html("<font color='green'>密码与确认密码一致</font>");
				 repasswordisuseful=true;
			 }
		 });
		$("#textfield").blur(function(){
			$.get("imgcheck.do?msg="+$("#textfield").val(),function(data){
				if(data.status=="1"){
					$("#errormsg").html("<font color='red'>"+data.result+"</font>");
				}else{
					$("#errormsg").html("<font color='green'>"+data.result+"</font>");
					imgisuserful=true;
				}
			});
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
		function butDisabled1(but){
	    	but.attr({"disabled":"disabled"});
			but.css("background-color","#C0C0C0");
			but.css("border-color","#C0C0C0");
			but.html("<i class='am-icon-spinner am-icon-spin'></i>注册中");
	    }
		$("#submit").click(function(){
			butDisabled1($("#submit"));
			var falg=$("#checkbox").is(":checked");
				if(!falg) {
					alert("同意百富条款才能注册");
					butEnabled($("#submit"),"立即注册");
					return false;
				}
				else{
					//
						var $email=$.trim($("#email").val());
						var reg=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
						if($email==""){
							$("#emailJS").html("<font color='red'>邮箱不能为空</font>");
							butEnabled($("#submit"),"立即注册");
							return;
						}else if(!reg.test($email)){
							$("#emailJS").html("<font color='red'>邮箱格式有误</font>");
							butEnabled($("#submit"),"立即注册");
							return;
						}else{
							$.get("emailajax.do?email="+$email,function(date){
								if(date.result=="E-mail不可用"){
									$("#emailJS").html("<font color='red'>此邮箱已被注册</font>");
									butEnabled($("#submit"),"立即注册");
								}else{
									$("#emailJS").html("<font color='green'>恭喜，该邮箱可用</font>");
									 var $password=$.trim($("#password").val());
									 var reg=/^[a-zA-Z0-9]\w{5,19}$/;
									 if($password==""){
										 $("#passwordJS").html("<font color='red'>密码不能为空</font>");
										 butEnabled($("#submit"),"立即注册");
									 }else if(!reg.test($password)){
										 $("#passwordJS").html("<font color='red'>密码长度为6~20位字符</font>");
										 butEnabled($("#submit"),"立即注册");
									 }else{
										 $("#passwordJS").html("<font color='green'>密码格式正确</font>");
										 var $repassword=$.trim($("#repassword").val());
										 var $password=$.trim($("#password").val());
										 if($repassword==""){
											 $("#repasswordJS").html("<font color='red'>确认密码不能为空</font>");
											 butEnabled($("#submit"),"立即注册");
										 } else if($repassword!=$password){
											 $("#repasswordJS").html("<font color='red'>密码与确认密码不一致</font>");
											 butEnabled($("#submit"),"立即注册");
										 }else{
											 
											 $("#repasswordJS").html("<font color='green'>密码与确认密码一致</font>");
											 $.get("imgcheck.do?msg="+$("#textfield").val(),function(data){
													if(data.status=="1"){
														$("#errormsg").html("<font color='red'>"+data.result+"</font>");
														butEnabled($("#submit"),"立即注册");
													}else{
														$("#errormsg").html("<font color='green'>"+data.result+"</font>");
<<<<<<< .mine
														$.post("registerAjax.do",{email:$("#email").val(),password:$("#password").val()},function(data){
=======
														$.post("register.do",{email:$("#email").val(),password:$("#password").val(),agentid:request('agentid')},function(data){
>>>>>>> .r3615
															if(data.status=="1"){
																window.location.href="${ctx}/member/reg_return.do"
															}else{
																$("#emailJS").html("<font color='red'>"+data.result+"</font>");
																butEnabled($("#submit"),"立即注册");
															}
														});
													}
												});
										 }
									 }
								}
							})
						
					}
					
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
</head>

<body>
<jsp:include page="header.jsp"/>
<!--网站logo 导航条  end-->

<div class="login"><!--login  start-->
  <div class="login_left"><a href="redadv.do"><img src="${ctx}/static/images/login.png" width="325" height="284"  alt=""/></a></div>
  <div class="login_right">
    <div class="login_h">
      <div class="login_hh">注册百富</div>
      <div class="login_pull"><a href="#"><img src="${ctx}/static/images/log_in.png" width="66" height="64" id="imglogin" alt=""/></a></div>
      <div class="login_input" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; "><form action="" method="post"><table width="550" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" colspan="2">&nbsp;</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr>
    <td height="45" colspan="2" style="text-align:right;">电子邮箱：</td>
    <td colspan="2" style="padding-left:10px;"><input type="email" name="email" id="email"  style="background-image:url(${ctx}/static/images/input-02.jpg); background-repeat:no-repeat; line-height:45px; font-size:18px;"></td>
  </tr>
  <tr>
    <td height="30" colspan="2">&nbsp;</td>
    <td colspan="2" valign="top" style="font-size:11px; padding-top:5px; padding-left:10px;"><c:if test="${register_error==null }"><div id="emailJS">激活后可作为登录账号，并用于找回密码</div></c:if><c:if test="${register_error!=null }"><div id="emailJS"><font color="red">${register_error }</font></div></c:if></td>
  </tr>
  <tr>
    <td height="45" colspan="2" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; text-align:right;">密码：</td>
    <td colspan="2" style="padding-left:10px;"><input type="password" name="password" id="password" onkeyup="value=value.replace(/[\W]/g,'') " 
      onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="background-image:url(${ctx}/static/images/input-04.jpg); background-repeat:no-repeat; line-height:45px; font-size:18px;" autocomplete="off"></td>
  </tr>
  <tr>
    <td height="30" colspan="2">&nbsp;</td>
    <td height="30" colspan="2" valign="top" style="font-size:11px; padding-top:5px; padding-left:10px;"><div id="passwordJS">6~20位字符，可为字母、数字、符号</div></td>
  </tr>
  <tr>
    <td height="45" colspan="2" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; text-align:right;">确认密码：</td>
    <td colspan="2" style="padding-left:10px;"><input type="password" name="repassword" id="repassword" onkeyup="value=value.replace(/[\W]/g,'') " 
      onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" style="background-image:url(${ctx}/static/images/input-05.jpg); background-repeat:no-repeat; line-height:45px; font-size:18px;"></td>
  </tr>
  <tr>
    <td height="30" colspan="2">&nbsp;</td>
    <td colspan="2" valign="top" style="font-size:11px; padding-top:5px; padding-left:10px;"><div id="repasswordJS"></div></td>
  </tr>
  <tr>
    <td height="45" colspan="2" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; text-align:right;">验证码：</td>
    <td width="112" style="padding-left:10px; width:70px;"><input type="text" name="msg" id="textfield" style=" width:100px; height:40px; text-indent:10px; font-size:18px;"></td>
    <td width="353" style="padding-left:10px;"><a href="#"><img id="img1" src="draw.do"></a><a href="#" id="a1">看不清，换一张</a></td>
    </tr>
  <tr>
    <td height="30" colspan="2">&nbsp;</td>
    <td colspan="2" valign="top" style="font-size:11px; padding-top:5px; padding-left:10px;" id="errormsg"><font color='red' >${errormsg }</font></td>
  </tr>
  <tr>
    <td colspan="4"></td>
    </tr>
  <tr>
    <td width="70" height="30" valign="top" id="imgmassage">&nbsp;</td>
    <td width="27" valign="top"><span style="padding-left:10px; text-align:right;">
      <input type="checkbox" name="checkbox" id="checkbox" style="width:14px; height:14px; border-width: 0px; border-style:none; border-spacing:0px 0px;border-collapse: collapse;border-radius: 3px; text-align:right" checked="checked">
    </span></td>
    <td colspan="2" style="padding-left:10px;line-height:20px;">
    我已阅读并同意<a href="${ctx }/static/protocol/registerprotocol.pdf" target="_blank">《百富网注册协议》</a>
            <br>
    　　　　　　　<a href="${ctx }/static/protocol/manageprotocol.pdf" target="_blank">《百富网投资咨询与管理服务协议》</a></td>
    </tr>
  <tr>
    <td colspan="4">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
    <td colspan="2"  style="padding-left:10px;">
    <button type="button"  id="submit" value="立即注册" class="am-btn am-btn-secondary" style="width:360px; background-color: #009CE4;height:45px;">立即注册</button></td>
    </tr>
      </table></form>
</div>
    </div>
  </div>
  
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
