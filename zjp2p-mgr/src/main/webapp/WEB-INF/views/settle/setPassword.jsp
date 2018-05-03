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
    <form action="" method="post"  style="margin-left: 40px;">
    <table width="90%" border="0" cellpadding="0" cellspacing="0" class="tabl2">
      <tr>
        <td height="1" colspan="3" bgcolor="#999999"></td>
        </tr>
      <tr>
        <td height="45">请填写正确的邮箱地址：</td>
        <td height="45"><input type="text" name="email" id="email"></td>
        <td height="45" class="style4">${passwordMsg}</td>
        </tr>
      <tr>
        <td height="1" colspan="3" valign="middle" bgcolor="#999999"></td>
      </tr>
      <tr>
      	<td></td>
        <td height="91" colspan="2" class="td2">
          <button type="button" value="发送密码" onclick="sendEmail()">发送密码</button></td>
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
function sendEmail(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    data:{email:$('#email').val()},
	    url:'sendPassword.do',     
	    success:function(data){
	    	if("1" == data.status){
	        	alert("发送成功");
	        	location.href = "queryPlatformacct.do";
	        	}
	    	if("2" == data.status){
        		alert("发送失败");
        	}
		}  
	}); 
}
</script>
</body>
</html>