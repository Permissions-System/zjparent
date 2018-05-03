<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
</head>
<body>


<div class="messagetab"><table width="100%" border="0" cellspacing="0" class="tabl">
  <tr>
    <td height="45" bgcolor="#898989" class="tdd"><span class="style1">密码设置</span></td>
    </tr>
  <tr>
    <td height="540" valign="top" class="tdd">
    <form action="updateTransPassword.do" method="post"  style="margin-left: 40px;">
    <table width="90%" border="0" cellpadding="0" cellspacing="0" class="tabl2">
      <tr>
        <td width="10%" height="49" valign="middle">
          <label for="textfield"></label>
          旧密码：</td>
        <td width="24%" valign="middle"><input type="password" name="oldPassword" id="password"></td>
        <td width="66%" class="style4">${msg}</td>
        </tr>
      <tr>
        <td height="1" colspan="3" bgcolor="#999999"></td>
        </tr>
      <tr>
        <td height="45">新密码：</td>
        <td height="45"><input type="password" name="newpassword" id="newpassword"></td>
        <td height="45" class="style4" id="JSnewpassword">密码长度必须为6-20位字符，由数字、字母组成，区分大小写</td>
        </tr>
      <tr>
        <td height="1" colspan="3" valign="middle" bgcolor="#999999"></td>
        </tr>
      <tr>
        <td height="45" valign="middle">确认新密码：</td>
        <td height="45" valign="middle"><input type="password" name="renewpassword" id="renewpassword"></td>
        <td height="45" valign="middle" id="JSrenewpassword"></td>
      </tr>
      <tr>
        <td height="1" colspan="3" valign="middle" bgcolor="#999999"></td>
      </tr>
      <tr>
      	<td></td>
        <td height="91" colspan="2" class="td2">
          <button type="button" value="保存" id="s1" onclick="">保存</button></td>
      </tr>
      <tr>
        <td colspan="3">&nbsp;</td>
      </tr>
    </table>
    </form>
    </td>
  </tr>
  </table>
</div>

<script type="text/javascript">
//重置登录密码
	$(function(){
		var newpassword=false;
		var renewpassword=false;
		$("#newpassword").blur(function(){
			var $newpassword=$.trim($("#newpassword").val());
			 var reg=/^[a-zA-Z0-9]\w{5,17}$/;
			 if($newpassword==""){
				 $("#JSnewpassword").html("<font color='red'>密码不能为空</font>");
				 newpassword=false;
			 }else if(!reg.test($newpassword)){
				 $("#JSnewpassword").html("<font color='red'>密码长度6~18位</font>");
				 newpassword=false;
			 }else{
				 $("#JSnewpassword").html("<font color='blue'>密码格式正确</font>");
				 newpassword=true;
			 }
		});
		$("#renewpassword").blur(function(){
			 var $renewpassword=$.trim($("#renewpassword").val());
			 var $newpassword=$.trim($("#newpassword").val());
			 if($renewpassword!=$newpassword){
				 $("#JSrenewpassword").html("<font color='red'>密码不同</font>");
				 renewpassword=false;
			 }else{
				 $("#JSrenewpassword").html("<font color='blue'>确定密码相同</font>");
				 renewpassword=true;
			 }
		 });
		
		$("#s1").click(function(){
			if(newpassword&&renewpassword){
				$.ajax({
					dataType: "json",
				    type:'get',
				    data: {oldPassword:$('#password').val(),plainPassword:$('#newpassword').val()},  
				    url:'updateTransPassword.do',     
				    success:function(data){
				    	if("success" == data.status){
				    		alert('密码修改成功');
				    		location.href = "queryPlatformacct.do";
				    	}
				    	if("fail" == data.status){
				    		alert(data.msg);
				    	}
					} 
				});						
			}else{
				return false;
			}
		});

	});
</script>
</body>
</html>
