<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>运营管理系统</title>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
/* 解决双垂直滚动条问题,如有异常，则删除此条另寻解决方案  */
.panel-body {
	overflow: hidden;
	border-top-width: 0px;
}
/*设置菜单最小显示高度，及高度不足时显示滚动条,如果必要，在此设置最小高度min-height*/
.accordin_limit {
	overflow: auto;
}
/*如果整个菜单显示不全，则在此处设置overflow-y:auto;*/
.accordin_ov {
	
}

.navlist {
	list-style-type: none;
	margin: 0px;
	padding: 0 5px 0 5px;
}

.navlist li {
	padding: 0px;
}

.navlist li a {
	line-height: 20px;
	height: 20px;
}

.navlist li div {
	margin: 2px 0px;
	padding-left: 0px;
	padding-top: 0px;
	border: 1px dashed #ffffff;
}

.navlist li div.hover {
	border: 1px dashed #99BBE8;
	background: #E0ECFF;
	cursor: pointer;
}

.navlist li div.hover a {
	color: #416AA3;
}

.navlist li div.selected {
	border: 1px solid #99BBE8;
	background: #E0ECFF;
	cursor: default;
}

.navlist li div.selected a {
	color: #416AA3;
	font-weight: bold;
}

.navlist li a.l-btn-plain {
	border: none;
	padding: 1px 6px 1px 1px;
}

.navlist_ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: none;
	margin-left: 15px;
}

#editInfo tr {
	height: 30px;
}

#editPWD tr {
	height: 30px;
}

#editPWD input {
	width: 155px;
}

#nav .panel-title {
	padding-left: 10px;
}
/*----- header -----*/
.header {
	width: 100%;
	height: 66px;
	border-bottom: 4px solid #61c8a8;
	background: #fff;
}

.header .logo {
	background: url(${ctx}/static/images/logo.png) 0 0 no-repeat;
	width: 430px;
	height: 46px;
	
	
	float: left;
	margin-top: 10px;
	margin-left: 44px;
}

.header .head_left_info {
	float: right;
	line-height: 66px;
	margin-right: 80px;
}

.header .head_left_info a {
	margin-left: 12px;
}
/*----- 头部 链接 -----*/
.link_red {
	color: #f7824a;
	text-decoration: underline;
}
/*----- 左侧导航覆盖linkbutton -----*/
a.menu_icon_menu span span.icon-leaf {
	background-position: 3px center;
}

a.menu_icon_menu span span.l-btn-icon-left {
	padding-left: 12px;
}

a.menu_icon_menu span.l-btn-left {
	padding: 0 0 0 5px;
}
</style>
</head>
<body class="easyui-layout">

	<!-- 首页头部 begin -->
	<div class="header clearfix" data-options="region:'north',border:false">
		<a class="logo" href="#"></a>
		<shiro:user>
			<span class="head_left_info fz-14">欢迎 <shiro:principal property="name" /> 
				<a class="link_red" href="javascript:void(0)" onclick="editPersonInfo()">修改个人信息</a> 
				<a class="link_red" href="javascript:void(0)" onclick="editPassword()">修改密码</a> 
				<a class="link_red" href="${ctx}/logout">退出后台</a>
			</span>
		</shiro:user>
	</div>
	<!-- end 首页头部 -->
	
	<!-- begin 导航菜单 -->
	<div data-options="region:'west',split:false,title:'导航菜单'" style="width: 250px;">
		<div id="nav" class="easyui-accordion"></div>
	</div>
	<!-- end 导航菜单 -->
	
	<!-- content begin -->
	<div data-options="region:'center'">
		<div id="tabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true"></div>
	</div>
	<!-- end content -->
	
	<!-- 修改个人信息 弹窗 begin -->
	<div id="editInfo" style="width: 300px; height: 200px; padding: 10px 0px 10px 30px">
		<table style="width: 100%; magrin-top: 1px; magrin-left: 5px; magrin-right: 5px; magrin-bottom: 2px; padding: 0px 0px 0px 0px; font-size: 12px">
			<tr>
				<td><label>用户名:</label></td>
				<td><input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true,validType:['nameValid','length[1,20]']" value="<shiro:principal property="name"/>"></input></td>
			</tr>
			<tr>
				<td><label>电话:</label></td>
				<td><input class="easyui-validatebox" type="text" id="tel" name="tel" data-options="validType:'phoneNum'"></td>
			</tr>
			<tr>
				<td><label>E-mail:</label></td>
				<td><input class="easyui-validatebox" type="text" id="email" name="email" data-options="validType:['email','length[0,32]']"></td>
			</tr>
		</table>
	</div>
	<!-- end 修改个人信息 弹窗 -->
	
	<!-- 修改密码 弹窗 begin -->
	<div id="editPWD" style="width: 350px; height: 210px; padding: 10px 0px 10px 30px">
		<table style="width: 100%; magrin-top: 1px; magrin-left: 5px; magrin-right: 5px; magrin-bottom: 2px; padding: 0px 0px 0px 0px; font-size: 12px">
			<tr>
				<td><label>原密码:</label></td>
				<td><input class="easyui-validatebox" type="password" id="oldPassword" data-options="required:true,validType:'length[6,20]'"></input></td>
			</tr>
			<tr>
				<td><label>设置新密码:</label></td>
				<td><input class="easyui-validatebox" type="password" id="plainPassword" data-options="required:true,validType:'length[6,20]'"></input></td>
			</tr>
			<tr>
				<td><label>新密码确认:</label></td>
				<td><input class="easyui-validatebox" type="password" id="passwordConfirm" data-options="required:true,validType:'length[6,20]'"></input></td>
			</tr>
		</table>
	</div>
	<!-- end 修改密码 弹窗 -->
	
</body>
<script type="text/javascript">
	// 初始化菜单
	function initMenu(menuData) {
		if (!menuData || !menuData.subMenuList || menuData.subMenuList == 0) {
			alert("菜单为空或没有子菜单");
			return;
		}
		//手风琴展示分类空间允许用户使用多面板，但在同一时间只会显示一个。每个面板都内建支持展开和折叠功能。点击一个面板的标题将会展开或折叠面板主体。面板内容可以通过指定的'href'属性使用ajax方式读取面板内容。用户可以定义一个被默认选中的面板，如果未指定，那么第一个面板就是默认的
		$("#nav").accordion({
			animate : false,	//在展开和折叠的时候是否显示动画效果
			fit : true,			//分类容器大小将自适应父容器
			border : false		//定义是否显示边框
		});
		// 遍历第一层菜单,即accordion元素
		$.each(menuData.subMenuList, function(i, subMenu) {
			var menuHtml = '';
			//alert(subMenu.subMenuList);
			if (subMenu.subMenuList && subMenu.subMenuList.length > 0) {
				menuHtml = '<ul class="navlist">';
				$.each(subMenu.subMenuList, function(j, childMenu) {
					// 本处根据菜单是否有叶子节点定义菜单栏图标
					var aClass = (childMenu.subMenuList && childMenu.subMenuList.length > 0) ? 'icon-node' : 'icon-leaf';
					menuHtml += '<li><div ><a class="easyui-linkbutton menu_icon_menu" data-options="plain:true,iconCls:\''+aClass+'\'" rel="' + childMenu.url 
								+ '" ></span><span class="nav" title="'+childMenu.menuName+'">' + childMenu.menuName + '</span></a></div> ';
					// 递归zen
					menuHtml += initSubMenu(childMenu.subMenuList, 1);
					menuHtml += '</li>';
				});
				menuHtml += '</ul>';
			}
			//增加accordion元素
			$('#nav').accordion('add', {
				title : subMenu.menuName,
				content : menuHtml,
				border : false,
				iconCls : '',	// 菜单图标
				selected : true	// 务必保证本处值为true，避免带来加载问题
			});
			$("[class='panel-body panel-body-noborder accordion-body']").addClass('accordin_limit');
			$("[class='easyui-accordion accordion accordion-noborder']").addClass('accordin_ov');
		});
		// 添加菜单点击事件
		$('.navlist li a').click(function() {
			var menuName = $(this).find('.nav').text();
			var url = $(this).attr("rel");
			var ul = $(this).parent().next();
			if (ul.is(":hidden")) {
				ul.slideDown();
			} else {
				ul.slideUp();
			}
			$('.navlist li div').removeClass("selected");
			var parent = $(this).parent();
			parent.addClass("selected");
			// 打开tab页
			if (url && url != '' && url != 'null') {
				openTab(menuName, '${ctx}/' + url);
			}
		}).hover(function() {
			$(this).parent().addClass("hover");
		}, function() {
			$(this).parent().removeClass("hover");
		});
		$('#nav').accordion({
			animate : true,
			fit : true,
			border : false
		});
	}

	function initSubMenu(menuList, level) {
		if (!menuList || menuList.length == 0) {
			return "";
		}
		var menuHtml = "";
		if (menuList && menuList.length > 0) {
			menuHtml = '<ul class="navlist_ul">';
			$.each(menuList, function(i, subMenu) {
				// 本处根据菜单是否有叶子节点定义菜单栏图标
				var aClass = (subMenu.subMenuList && subMenu.subMenuList.length > 0) ? 'icon-node' : 'icon-leaf';
				menuHtml += '<li><div>' + getBlank(level) + '<a class="easyui-linkbutton menu_icon_menu" data-options="plain:true,iconCls:\''+aClass+'\'" rel="' + subMenu.url 
					+ '" ><span class="nav" title="'+subMenu.menuName+'">' + subMenu.menuName + '</span></a></div>';
				menuHtml += initSubMenu(subMenu.subMenuList, level + 1);
				menuHtml += '</li>';
			});
			menuHtml += '</ul>';
		}
		return menuHtml;
	}

	function getBlank(level) {
		var blank = "";
		while (level-- > 0) {
			blank += "&nbsp;";
		}
		return blank;
	}

	$(document).ready(function() {
		/* // 打开待办页面
		 $("#tabs").tabs('add', {
			title : '欢迎使用',
			content : '<iframe scrolling="auto" frameborder="0"  src="${ctx}/base/home/task" style="width:100%;height:100%;"></iframe>',
			closable : false,
			icon : ''
		});  */
		// 加载菜单
		jQuery.ajax({
			type : 'POST',
			async : false,
			url : '${ctx}/home/getStaffMenuTree',
			data : {},
			success : function(data, status) {
				initMenu(data.result);				
			},
			error : function(data, status) {
				$.messager.show({
					title : '提示信息',
					msg : '菜单加载失败！',
					timeout : 5000,
					showType : 'slide'
				});
			},
			datatype : "json"
		});
	});

	/* 打开一个标签 */
	function openTab(title, url, icon) {
		/**
		如果这个标题的标签存在，则选择该标签
		否则添加一个标签到标签组
		 */
		if ($("#tabs").tabs('exists', title)) {
			$("#tabs").tabs('select', title);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
			$("#tabs").tabs('add', {
				title : title,
				content : content,
				closable : true,
				icon : icon
			});
		}
	}

	/* 打开一个标签 */
	function openTabExt(title, url, data) {
		if ($("#tabs").tabs('exists', title)) {
			$("#tabs").tabs('select', title);
		} else {
			var id = new Date().getTime();
			var dv = $('<div id="div'+id+'" url="' + url + '"></div>');
			if (data) {
				for ( var i in data) {
					$('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(dv);
				}
			}
			$(dv).appendTo("body");

			var content = '<iframe id="jIframe' + id + '" scrolling="auto" frameborder="0" src="${ctx}/home/post/'+ id + '" style="width:100%;height:100%;"></iframe>';
			$("#tabs").tabs('add', {
				title : title,
				content : content,
				closable : true
			});
		}
	}
	/*获取form的内容*/
	function formHtml(id) {
		return $("#div" + id).html();
	}
	/*获取跳转的URL*/
	function formUrls(id) {
		return $("#div" + id).attr("url");
	}
	/*刷新一个tab中的datagrid*/
	function reloadTabGrid(tabTitle, datagridID) {
		if ($("#tabs").tabs('exists', tabTitle)) {
			var roleWin = $('#tabs').tabs('getTab', tabTitle).find('iframe')[0].contentWindow.$;
			var roleTable = $('#tabs').tabs('getTab', tabTitle).find('iframe').contents().find(datagridID);
			roleWin.fn.datagrid.methods["reload"](roleTable);
		}

	}

	/**
	 * 调用指定页面方法
	 * @author xrwang
	
	 * @param tabTitle 页面名称
	 * @param funcName 方法名称
	 * @param agrs 方法参数,数组如[a,b]
	 * @return 返回方法执行结果
	 */
	function invokeTabFunc(tabTitle, funcName, agrs) {
		if ($("#tabs").tabs('exists', tabTitle)) {
			if ($('#tabs').tabs('getTab', tabTitle).find('iframe')[0].contentWindow[funcName]) {
				if (isNull(agrs) || agrs.length == null || agrs.length == 0) {
					return $('#tabs').tabs('getTab', tabTitle).find('iframe')[0].contentWindow[funcName]();
				} else {
					var evalStr = '$("#tabs").tabs("getTab",tabTitle).find("iframe")[0].contentWindow[funcName](';
					var first = true;
					for ( var i in agrs) {
						if (first) {
							evalStr += 'agrs[' + i + ']';
							first = false;
						} else {
							evalStr += ', agrs[' + i + ']';
						}
					}
					evalStr += ')';
					return eval(evalStr);
				}
			}
		}
		return null;
	}

	/**关闭制定title的tab页面*/
	function closeTab(title) {
		if ($("#tabs").tabs('exists', title)) {
			$("#tabs").tabs('close', title);
		}
	}

	/*关闭当前打开的tab页面*/
	function closeCurrentTab() {
		var tab = $('#tabs').tabs('getSelected');
		var index = $('#tabs').tabs('getTabIndex', tab);
		$('#tabs').tabs('close', index);

	}

	/*在顶级窗口弹出message框*/
	function showMessage(options) {
		$.messager.show(options);
	}

	$.extend($.fn.validatebox.defaults.rules, {
		nameValid : {
			validator : function(value, param) {
				var p = new RegExp('[^a-zA-Z0-9\u4E00-\u9FA5\(\)\（\）_]');
				return !p.test(value);
			},
			message : '名称应由数字、字母、中文字符、下划线或括号组成'
		},
		phoneNum : {
			validator : function(value, param) {
				var p = /^1[3|4|5|8][0-9]\d{8}$/;
				return p.test(value);
			},
			message : '请输入正确的手机号码！'
		}

	});

	//修改个人信息 	
	function editPersonInfo() {
		$.ajax({
			type : 'POST',
			url : '${ctx}/base/staff/getPersonalInfo',
			success : function(data) {
				$('#tel').val(data.tel);
				$('#email').val(data.email);
			}
		});
		$('#editInfo').dialog({
			title : '修改个人信息',
			modal : true,
			buttons : [ {
				text : '提交',
				handler : function() {
					$.ajax({
						type : 'POST',
						url : '${ctx}/base/staff/updatePersonalInfo',
						data : {
							name : $('#name').val(),
							tel : $('#tel').val(),
							email : $('#email').val()
						},
						success : function(data, status) {
							if (data.status == "SUCCESS") {
								$('#editInfo').dialog('close');
								$.messager.show({
									title : '消息',
									msg : '更新成功！',
									timeout : 5000,
									showType : 'slide'
								});
							} else {
								$.messager.alert("error");
							}
						}
					});
				}
			}, {
				text : '取消',
				handler : function() {
					$('#editInfo').dialog('close');
				}
			} ]
		});
	}

	//修改个人密码
	function editPassword() {
		$('#editPWD').dialog({
			title : '修改个人密码',
			modal : true,
			buttons : [ {
				text : '提交',
				handler : function() {
					if (!($('#plainPassword').val() == $('#passwordConfirm').val())) {
						$.messager.alert('提示', '两次密码不同，请重新输入！', 'error');
						return;
					}
					$.ajax({
						type : 'POST',
						url : '${ctx}/base/staff/updatePersonalPassword',
						data : {
							staffNo : '<shiro:principal property="id"/>',
							plainPassword : $('#plainPassword').val(),
							oldPassword : $('#oldPassword').val()
						},
						success : function(data, status) {
							if (data.status == "SUCCESS") {
								$('#editPWD').dialog('close');
								$.messager.show({
									title : '消息',
									msg : '更新成功！',
									timeout : 5000,
									showType : 'slide'
								});
							} else {
								$.messager.alert("错误", data.result, 'error');
							}
						}
					});
				}
			}, {
				text : '取消',
				handler : function() {
					$('#editPWD').dialog('close');
				}
			} ]
		});
	}
</script>
</html>