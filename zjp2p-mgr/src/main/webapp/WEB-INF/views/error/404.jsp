<%@ page import="org.springfk.pancloud.exception.BusinessException"%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
	String errorMessage = "";
	if (exception != null){
	    Throwable cause = exception;
	    do {
	        if(cause instanceof BusinessException){
	            errorMessage = cause.getMessage();
	            break;
	        } else {
	            cause = cause.getCause();
	        }
	    } while(cause!=null);
	}
	if(errorMessage==null || errorMessage.trim().length()==0){
	    errorMessage = "您要查找的资源有问题无法显示。";
	}
	// 如果是ajax请求，则返回异常信息,否则返回异常页面
	if("XMLHttpRequest".equals(((HttpServletRequest) request)
            .getHeader("X-Requested-With"))) {
%>
{"string":'<%=errorMessage%>'}
<%    
	} else {
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>404-错误</title>
<link href="${ctx}/static/styles/reset.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/static/styles/global.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
	.main{width:1000px; margin:0 auto;}
	.area404{margin-left:auto; margin-right:auto; height:180px; width:520px; margin-top:150px;}
	.leftLogo{width:200px; float:left;}
	.right{width:320px; float:left;}
	.right img{padding-top:25px;}
	.right p{font-size:14px; padding-top:25px;}
	.right a{color:#05BA8D; text-decoration:underline;}
</style>
</head>

<body>
<script type="text/javascript">
function closeCurrentPage(){
	if(self.parent && self.parent.closeCurrentTab){
		self.parent.closeCurrentTab();
	} else {
		window.opener = null;
		window.open('', '_self');
		window.close();
	}
}
</script>
<!-- 内容 开始 -->
<div class="main">
	<div class="area404 clearfix">
		<div class="leftLogo">
			<img alt="" src="${ctx}/static/images/error/pople_bg.png">
		</div>
		<div class="right">
			<img src="${ctx}/static/images/error/false2.png" alt=""/>
			<p>您要查找的资源有问题无法显示。</p>
			<p>您可以<a href="javascript:closeCurrentPage()">关闭</a>当前页面</p>
		</div>
	</div>
</div>
<!-- 内容 结束 -->
</body>
</html>
<% 
	}
%>