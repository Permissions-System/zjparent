<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<title>登录 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">
<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link rel="Stylesheet" type="text/css" href="${ctx}/static/css/jquery.validity.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/login.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.validity.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.cookie.js"></script>

<script type="text/javascript">
	$(function(){
		// checkbox 默认选中
	    var hideCheckbox = '${hideCheckbox}';
	    if(hideCheckbox == 'check'){
	    	 $('#checkbox').attr("checked","true");
	    }
		$.validity.setup({outputMode:"label"});
		$("#textfield").blur(function(){
			$("#nameprompt").html("");
			var $textfield=$.trim($("#textfield").val());
			var regmobile=/^0?1[3|4|5|8][0-9]\d{8}$/;
			var regemail=/^[a-zA-Z0-9_+.-]+\@([a-zA-Z0-9-]+\.)+[a-zA-Z0-9]{2,4}$/;
			if($textfield==""){
				$("#nameprompt").html("<font color='red'>账号不能为空</font>");
			} else if(!isNaN($textfield)){
				if(!regmobile.test($textfield)){
					$("#nameprompt").html("<font color='red'>手机号格式有误</font>");
				}
			}else{
				if(!regemail.test($textfield)){
					$("#nameprompt").html("<font color='red'>邮箱格式有误</font>");
				}
			}
		});
		$("#password").blur(function(){
			$("#passwordprompt").html("");
			var $password=$.trim($("#password").val());
			var reg=/^[a-zA-Z0-9]\w{5,17}$/;
			if($password==""){
				$("#passwordprompt").html("<font color='red'>密码不能为空</font>");
			}
		});
		
		$("#submit").click(function(){
			if($.trim($("#textfield").val())==""){
				$("#nameprompt").html("<font color='red'>账号不能为空</font>");
				return false;
			}
			if($.trim($("#password").val())==""){
				$("#passwordprompt").html("<font color='red'>密码不能为空</font>");
				return false;
			}
			return true;
		});
		$("#qq").click(function(){
			window.open("http://openapi.qzone.qq.com/oauth/show?which=Login&display=pc&client_id=101181022&response_type=token&scope=all&redirect_uri=http://www.biifoo.com/login.do");
		});
		$("#submit2").click(function(){
			window.location.href="register.do";
			return false;
		});
	});
</script>
<script type="text/javascript">
	$(function(){
		var accessToken =window.location.hash.substring(1);
		 $.ajax({
		      type: 'GET',
		      url: "https://graph.qq.com/oauth2.0/me?"+accessToken,
		      async: false,
		      dataType: "jsonp",
		      jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
		      jsonpCallback:"callback",
		      success: function(o){
		    	  if(o.error!=null){
		    		  return ;
		    	  }else{
		    		  $.post("qqloginafter.do",{openid:o.openid},function(){
		    			  window.location.href="index.do";
		    		  });
		    	  }
		      }
		 });
	});

</script>
<script type="text/javascript">
	$(function(){
		$("#imgregister").click(function(){
			window.location.href="register.do";
		});
	});

</script>
<script type="text/javascript">
	$(function(){
	    $("#checkbox").click(function(){ //设置cookie  
            var loginCode = $("#textfield").val(); //获取用户名信息  
            var pwd = $("#password").val(); //获取登陆密码信息  
               $.cookie("login_code",loginCode,{expires: 5});//调用jquery.cookie.js中的方法设置cookie中的用户名  
               $.cookie("pwd",pwd,{expires: 5});//调用jquery.cookie.js中的方法设置cookie中的登陆密码，并使用base64（jquery.base64.js）进行加密  
       }); 
            var loginCode = $.cookie("login_code"); //获取cookie中的用户名  
            var pwd =  $.cookie("pwd"); //获取cookie中的登陆密码  
            if(pwd){//密码存在的话把“记住用户名和密码”复选框勾选住  
               $("#checkbox").attr("checked","true");  
            }  
            if(loginCode){//用户名存在的话把用户名填充到用户名文本框  
               $("#textfield").val(loginCode);  
            }  
            if(pwd){//密码存在的话把密码填充到密码文本框  
               $("#password").val(pwd);  
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

<body>
<jsp:include page="headerV2.jsp"/><!-- 引用header标签 -->


<div class="login"><!--login  start-->
  <div class="login_left"><a href="${ctx }/redadv.do"><img src="${ctx}/static/images/login.png" width="325" height="284"  alt=""/></a></div>
  <div class="login_right">
    <div class="login_h">
      <div class="login_hh">登录百富</div>
      <div class="login_pull"><a href="#"><img src="${ctx}/static/images/reg.png" width="66" height="64" id="imgregister" alt=""/></a></div>
      <div class="login_input" style="font-size:13px; font-family:'微软雅黑'; color:#565A5C; ">
      <form action="login.do" method="post">
	      <table width="550" border="0" cellspacing="0" cellpadding="0">
			  <tr>
			    <td height="30" colspan="8"><font color='red'>${errormsg }</font></td>
			    </tr>
			  <tr>
			    <td height="45" style="text-align:right;"></td>
			    <td height="45" colspan="7" ><input name="username" class="inputx" type="textfield" id="textfield" value="${email }" style="background-image:url(${ctx}/static/images/input-02.jpg); background-repeat:no-repeat; line-height:45px;" placeholder="请输入手机号或邮箱"></td>
			    </tr>
			  <tr>
			    <td height="30">&nbsp;</td>
			    <td height="30" colspan="7"><div id="nameprompt"><c:if test="${login=='1' }"><font color='red'>没有此用户，<a href="register.do">现在去注册</a></font></c:if><c:if test="${login!='1' }"><font color='red'>${login }</font></c:if></div></td>
			    </tr>
			  <tr>
			    <td height="45" style="text-align:right;"></td>
			    <td height="45" colspan="7"><input class="inputx" type="password" name="password" id="password" style="background-image:url(${ctx}/static/images/input-04.jpg); background-repeat:no-repeat; line-height:45px;" placeholder="请输入登录密码" autocomplete="off"></td>
			    </tr>
			  <tr>
			    <td height="30">&nbsp;</td>
			    <td height="30" colspan="7"><div id="passwordprompt"><font color='red'>${password }</font></div></td>
			    </tr>
			  <tr>
			    <td width="93" height="30" valign="middle">&nbsp;</td>
			    <td width="23" valign="middle"><div style="float:left;"><input type="checkbox" value="check" name="checkbox" id="checkbox" style="width:14px; height:14px; border-width: 0px; border-style:none; border-spacing:0px 0px;	border-collapse: collapse;	border-radius: 3px;"></div>　记住密码</td>
			    <td width="99" valign="middle"></td>
			    <td colspan="3" valign="middle">&nbsp;</td>
			    <td width="24" valign="middle"><img src="${ctx}/static/images/q.png" style="margin-top: 6px" alt=""/></td>
			    <td width="229" valign="middle"><a href="reset_pwdafter.do" style="text-decoration:none; color:#565A5C">忘记密码</a></td>
			  </tr>
			  <tr>
			    <td colspan="8">&nbsp;</td>
			  </tr>
			  <tr>
			    <td>&nbsp;</td>
			    <td colspan="7"><input class="inputx" type="submit" name="submit" id="submit" value="立即登录" style="background-color:#009CE4; text-indent:0px; color:#FFF; font-size:18px; font-family:'微软雅黑';"></td>
			    </tr>
			  <tr>
			    <td colspan="8">&nbsp;</td>
			    </tr>
			  <tr>
			    <td>&nbsp;</td>
			    <td width="130">第三方账户登录：</td>
			    <td width="26"><a href="#"><img id="qq" src="${ctx}/static/images/qq.png" style="cursor:hand" alt=""/></a></td>
			    <td><!-- <img id="sina" src="${ctx}/static/images/wb.png" width="30" height="30"  alt=""/> --></td>
			    <td>&nbsp;</td>
			    </tr>
			  <tr>
			    <td colspan="8">&nbsp;</td>
			  </tr>
			  <tr>
		    	<td>&nbsp;</td>
			    <td colspan="7">
			    	<input class="inputx" type="submit" name="submit2" id="submit2" value="立即注册" style="background-color:#009CE4; text-indent:0px; color:#FFF; font-size:18px; font-family:'微软雅黑';">
			    </td>
		      </tr>
	      </table>
      </form>
</div>
    </div>
  </div>
  
</div>

<jsp:include page="footerV2.jsp"/>
</body>
</html>
