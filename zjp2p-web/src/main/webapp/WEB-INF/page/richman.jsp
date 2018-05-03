<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<title>大富翁 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />


<link href="${ctx}/static/css/tools.css" type="text/css" rel="stylesheet">

<link href="${ctx}/static/css/info.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
 
<style type="text/css">
.banner {
	width: 100%;
	height: 345px;
	background-color: #54C4D2;
}

.banner .banner_txt {
	width:1200px;
	height:345px;
	margin-left:auto;
	margin-right:auto;
	background-image:url(${ctx}/static/images/richman.png);
	background-repeat:no-repeat;	
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	font-size:20px;
	color:#FFF;
	font-family:"微软雅黑";
	text-align:center;
	line-height:40px;
}

.banner .banner_txt .txt span {
	font-size: 55px;
}


</style>
<script type="text/javascript">
var environment = {
	userVo : '',
	role : '',
	userId : '',
	basePath : '',
	userCash : '',
	globalPath : 'http://www.biifoo.com/',
	userActiveTime : '',
	yoolibaoWhiteListStatus : '',
	yoolibaoOpenStatus : '',
	cerrencyOpenTime : "2014/11/30"//new Date()
};
</script>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/global-1.1.0.min.js"></script>


</head>
<body>
<!--顶部扫微信 登录 注册  end-->
<!--网站logo 导航条  end-->
<jsp:include page="header.jsp"/>


<div class="banner">
  <div class="banner_txt"></div>
</div>
<div class="content" style="height:505px;">
  
  <div class="help"><!--投资产品精选栏  start-->
  <div class="help1" style="width:900px"><h1>大富翁</h1><p>通过了解您的收入状况、存款金额等信息，大富翁可以迅速计算出您在百富投资若干年后的身价，让您更好地规划未来人生。</p></div>
</div>
  <hr data-am-widget="divider" style="margin-top:0px;" class="am-divider am-divider-default2"/>
  <div class="worth-calc">
    <div class="worth-chart" id="YModal"><div class="worth-div worth-0"><h2>当前身价(元)</h2><strong>0</strong></div></div>
        <div class="topics">
          <div class="topics-items" id="worthTopics"><h2>1.您当前的存款数额：</h2><div class="worth-input"><input type="text" id="curValue_0" class="input"> <label>元</label><div class="tip error" id="errorTip_0"></div></div><div class="worth-submint"><a href="javascript:;" name="NextTopic" class="am-btn am-btn-secondary" id="NextTopic" data-rel="0">下一步</a></div></div>
            <div class="topics-items" id="worthData" style="display: none;">
                <ul></ul>
                <span style="display:none" id="worthRecord"></span>
                <div class="worth-submint none" id="worthSubmint" style=" float:left"> <a href="${ctx}/queryBidAll.do" class="am-btn am-btn-secondary">立即开始投资</a> <a href="javascript:;" id="resetCount" class="am-btn am-btn-default">重新计算</a> 　　<!-- 分享到：</span><a href="" class="am-biifoo-btn am-icon-weibo"></a> <a href="${ctx}/index.do" class="am-biifoo-btn am-icon-wechat"></a> <a href="" class="am-biifoo-btn am-icon-qq"></a>--> </div>
            </div>
    </div>
  </div>

</div>
<jsp:include page="footer.jsp"/>

<script type="text/javascript" src="${ctx}/static/js/worth-calc.js"></script>
</body>
</html>
