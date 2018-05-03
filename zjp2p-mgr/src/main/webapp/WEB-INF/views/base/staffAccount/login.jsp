<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<title>运营管理系统登录</title>
	<link rel="shortcut icon" href="${ctx}/static/images/favicon.ico">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/js/pub/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/static/js/pub/jquery-easyui/themes/icon.css">
	<script src="${ctx}/static/js/pub/jquery-easyui/jquery-1.8.0.min.js"></script>
	<script src="${ctx}/static/js/pub/jquery-easyui/jquery.easyui.min.js"></script>
	<script src="${ctx}/static/js/pub/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="${ctx}/static/js/pub/common.js"></script>
	<link href="${ctx}/static/styles/reset.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/static/styles/global.css" rel="stylesheet" type="text/css">
	<link href="${ctx}/static/styles/common.css" rel="stylesheet" type="text/css">
</head>
<body class="loging" onkeydown="bindingEnterKey(event)">
	<div id="loginPage" style="display: none">
		<!-- 头部 开始 -->
		<div class="header clearfix">
			<a class="logo" href="#"></a>
		</div>
		<!-- 头部 结束 -->
		<!-- 内容 开始 -->
		<div class="login_box">
			<div class="logbox_con">
				<p class="login_tit">开开</p>
				<p class="login_manage fz-16 text_center">互联网金融管理后台</p>
				<form id="loginForm" action="${ctx}/login" method="post" class="form-horizontal">
					<ul class="login_inpt text_center">
						<li><input class="inp inp_user easyui-validatebox" type="text" value="" placeholder="登陆名" id="username" name="username" data-options="required:true,validType:'username'"></li>
						<li><input class="inp inp_pwd easyui-validatebox" type="password" value="" id="password" name="password" placeholder="密码" data-options="required:true,validType:'password'"></li>
					</ul>
					<p class="text_center mt20 mb30">
						<!--     	<a class="btn" href="#">登录</a> -->
						<input id="submit_btn" class="btn btn-primary" type="submit" value="登录" />
					</p>
				</form>
			</div>
		</div>
		<!-- 内容 结束 -->
		<!-- 底部 开始 -->
		<div class="footer footer_bor_top">
			<!-- <p>CopyRight &copy; 2012 All Rights Reserved 版权所有 信息技术有限公司</p> -->
			<p>沪ICP备14050495号-2</p>
		</div>
		<!-- 底部 结束 -->
	</div>
	<div id="redirectPage" style="display: none"></div>
	<script>
		$.extend($.fn.validatebox.defaults.rules, {
			/* username : {
				validator : function(value) {
					var p = new RegExp('[^a-zA-Z0-9]');
					return (value.length >= 1 && value.length <= 30 );
				},
				message : '登陆名错误'
			}, */
			password : {
				validator : function(value) {
					return true;//(value.length>=6 && value.length<=20);
				},
				message : '密码长度错误'
			}
		});
		
		$(document).ready(function() {
			var p = self.parent;
			while (p.parent && p.parent != p) {
				p = p.parent;
			}
			if (p.closeCurrentTab) {//父页面存在
				$('#redirectPage').removeAttr('style');
				$.messager.alert('错误', '登录超时，请重新登录！', 'error',
						redirect);
			} else {
				$('#loginPage').removeAttr('style');
			}

			$('#loginForm').submit(function(event) {
				if (!$("#loginForm").form("validate")) {
					event.preventDefault();
				}
			});
			// 务必等到页面初始化完毕后再创建新的页面元素（包括）弹出消息等，
			// 否则IE下存在BUG KB927917会报错, 可以通过打补丁KB2416400解决该问题。
			<%String error = (String) request
					.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
					if (error != null) {%>
				    $.messager.show({
						title : '错误',
						msg : '登录失败，请重试',
						timeout : 5000,
						showType : 'slide'
					});
			<%}%>
		});

		function redirect() {
			var p = self.parent;
			while (p.parent && p.parent != p) {
				p = p.parent;
			}
			p.window.location.href = "${ctx}/home/index";
		};

		/**
		 * 绑定 按钮 按回车 激发按钮单击事件
		 */
		function bindingEnterKey(event) {
			// 保存按钮OJBJECT
			var btnOjb = $("#submit_btn");
			// 点击 Enter按钮
			if (event.keyCode == 13) {
				btnOjb.click();
				event.returnValue = false;
			}
			prevent(event); //文本框、下拉框readonly、disabled时禁用退格键 
		}
	</script>
</body>
</html>
