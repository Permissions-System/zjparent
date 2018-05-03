<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<title>帮助中心 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/helpbanner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<style type="text/css">
.banner {
	width: 100%;
	min-width: 1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/helpbanner.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1200px;
	height:345px;
	margin-left:auto;
	margin-right:auto;
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	
	font-size:55px;
	color:#2B2D2E;
	font-family:"微软雅黑";
	text-align:center;
	line-height:345px;
}

.banner .banner_txt .txt span {
	font-size: 55px;
}


</style>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
		$("#service_check").attr("class","current");
	});

</script>
</head>

<body>
<jsp:include page="../header.jsp"/><!--网站logo 导航条  end-->


<div class="banner">
  <div class="banner_txt">
    <div class="txt">快速了解百富网</div>
  </div>
</div>

<div class="help"><!--投资产品精选栏  start-->
  <div class="help1"><h1>快速了解百富网</h1><p>手把手教您如何百富 <a href="help_detail.do">查看更多</a></p></div>
</div>

<div class="helpsix" style="margin-bottom:50px">
  <a href="help_detail.do#r1" style="color:#6C6F71"><div class="helpsix_1">邮箱注册更便捷</div></a>
  <a href="help_detail.do#12" style="color:#6C6F71"><div class="helpsix_2">实名认证更安全</div></a>
  <a href="help_detail.do#13" style="color:#6C6F71"><div class="helpsix_3">快速充值更方便</div></a>
  <a href="help_detail.do#15" style="color:#6C6F71"><div class="helpsix_5">1 元起投更简单</div></a>
  <a href="help_detail.do#16" style="color:#6C6F71"><div class="helpsix_6">自由赎回更灵活</div></a>
  <a href="help_detail.do#14" style="color:#6C6F71"><div class="helpsix_4">免费提现更省钱</div></a>
</div>

<div class="DB_tab25"><!--banner条  start-->
  <ul class="DB_bgSet">
		<li style="background:url(${ctx}/static/images/helpbanner_1.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li style="background:url(${ctx}/static/images/helpbanner_2.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li style="background:url(${ctx}/static/images/helpbanner_3.jpg) no-repeat 100% 100%;background-position: center;"></li>
        <li style="background:url(${ctx}/static/images/helpbanner_4.jpg) no-repeat 100% 100%;background-position: center;"></li>
  </ul>

	<ul class="DB_imgSet">
		<li onClick="javascript:window.location.href='help_detail.do#n2';">
			<img class="DB_1_3" src="${ctx}/static/images/helpbanner_1.png" alt="">
		</li>

		<li onClick="javascript:window.location.href='help_detail.do#20';">
			<img class="DB_1_3" src="${ctx}/static/images/helpbanner_2.png" alt="">
		</li>

		<li onClick="javascript:window.location.href='help_detail.do#19';">
			<img class="DB_1_3" src="${ctx}/static/images/helpbanner_3.png" alt="">
		</li>

		<li onClick="javascript:window.location.href='help_detail.do#n1';">
			<img class="DB_1_3" src="${ctx}/static/images/helpbanner_4.png" alt="">
		</li>
        
        
	</ul>

	<div class="DB_menuWrap">
		<ul class="DB_menuSet">
			<li></li>
			<li></li>
			<li></li>
            <li></li>
            <li></li>
            <li></li>
			
		</ul>
		<div class="DB_next"><img src="${ctx}/static/images/nextArrow.png" alt="NEXT"></div>
		<div class="DB_prev"><img src="${ctx}/static/images/prevArrow.png" alt="PREV"></div>
  </div>
  
  
</div>

<div class="help"><!--投资产品精选栏  start-->
  <div class="help1" id="x2"><h1>常见问题</h1><p>帮您答问解惑 <a href="help_detail.do">查看更多</a></p></div>
</div>

<div class="question">
  <div class="question1"><a href="help_detail.do#z1" style="color:#6C6F71">● 百富网的模式？</a><br><br><a href="help_detail.do#z2" style="color:#6C6F71">● 如何进行投资？</a><br><br><a href="help_detail.do#n3" style="color:#6C6F71">● 本金和收益是否能够得到保障？</a></div>
  <div class="question2"><a href="help_detail.do#15" style="color:#6C6F71">● 百富网有哪些理财产品？</a><br><br><a href="help_detail.do#16" style="color:#6C6F71">● 投资后是否可以提前赎回？</a><br><br><a href="help_detail.do#n3" style="color:#6C6F71">● 百富网如何审核借款项目？</a></div>
  <div class="question3"><a href="help_detail.do#x1" style="color:#6C6F71">● 如何保证我的资金安全？</a><br><br><a href="help_detail.do#14" style="color:#6C6F71">● 提现需要收费吗？</a><br><br><a href="help_detail.do#z3" style="color:#6C6F71">● 投资人是否需要支付费用？</a></div>
</div>

<div class="helpcontant" style="margin-bottom:-65px;background-position: center;">
  <div class="helpc"><!--投资产品精选栏  start-->
  <div class="help1" style="width:500px;" id="x3"><h1>联系我们</h1><p>在线时间：9:00－18:00（周一至周五） <a href="mailto:kefu@baifu360.com">留言给百富网</a></p>
<p style="margin-top:0px;">地址： 上海市江场西路299号中环时代广场4座11楼</p></div>
</div>
<div class="helpbanner_img2">
<div style="position:absolute; left:197px; top:185px;" id="BizQQWPA9"><a href="#"><img src="${ctx }/static/images/cm.png" width="231" height="56"  alt=""/></a></div><script type="text/javascript">BizQQWPA.addCustom({aty: '0', a: '0', nameAccount: 4009616588, selector: 'BizQQWPA9'});</script>
</div>
</div>


<jsp:include page="../footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
<script type="text/javascript">
$('.DB_tab25').DB_tabMotionBanner({
	key:'b28551',
	autoRollingTime:6000,                            
	bgSpeed:500,
	motion:{
		DB_1_3:{left:0,opacity:0,speed:1000,delay:500},
		DB_2_1:{top:50,opacity:0,speed:1000,delay:500},
		DB_2_2:{top:50,opacity:0,speed:1000,delay:1000},
		DB_2_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_3_1:{left:-50,opacity:0,speed:1000,delay:500},
		DB_3_2:{top:50,opacity:0,speed:1000,delay:1000},
		DB_3_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_1:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_2:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_3:{top:0,opacity:0,speed:1000,delay:100},
		DB_4_4:{top:30,opacity:0,speed:1000,delay:2000},
		DB_4_5:{top:100,opacity:0,speed:1000,delay:3000},
		end:null
	}
})
</script>
</html>
