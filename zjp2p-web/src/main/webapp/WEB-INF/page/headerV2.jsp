<%@ page language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link href="${ctx}/static/css/bootstrap.css" rel="stylesheet">
<link href="${ctx}/static/css/indexstyle.css" rel="stylesheet">
<link href="${ctx}/static/css/liststyleV2.css" rel="stylesheet">
<link href="${ctx}/static/css/flickerplate.css"  rel="stylesheet">
<link href="${ctx}/static/css/tooltip.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="${ctx}/static/js/jquery.tabs.js"></script>
<script src="${ctx}/static/js/jquery.lazyload.js"></script>
<script src="${ctx}/static/js/cufon-yui.js"></script>
<script src="${ctx}/static/js/modernizr-custom-v2.7.1.js"></script>
<script src="${ctx}/static/js/jquery-finger-v0.1.0.js"></script>
<script src="${ctx}/static/js/flickerplate.js"></script>
<script charset="utf-8" src="http://wpa.b.qq.com/cgi/wpa.php"></script>
<script type="text/javascript">
$(function(){
	var moveHeight = 30,
		moveTime = 200,
		curMove = null;
	$('.caselist').hover(function (e){
		var curLi = $(this);
		curMove = setTimeout(function (){
			curLi.children('a.tagImg1').animate({ top: '-' + moveHeight + 'px' }, moveTime);
			curLi.children('div.tagDiv1').animate({ top: '0px' }, moveTime);
		}, 50);
	},function(e){
		clearTimeout(curMove);
		$(this).children('a.tagImg1').animate({ top: '0px' }, moveTime);
		$(this).children('div.tagDiv1').animate({ top: moveHeight + 'px' }, moveTime);
	});
});
</script>
<script type="text/javascript">
$(function(){
	$('.tab1').Tabs();
});	
</script>
<script type="text/javascript">
  Cufon.replace('ul.oe_menu div a',{hover: true});
  Cufon.replace('h1,h2,.oe_heading');
</script>
<script>
	$(document).ready(function(){
		$('.flicker-example').flicker();
	});
</script>
<script type="text/javascript">
$(function(){

	var aPage = $('#xb1');
	var aImg = $('#xb1 .xb1_1 img');	
	var iSize = aImg.size();
	var index = 0;
	
	//分页按钮点击
	
	//切换过程
	function change(index){
		aPage.removeClass('active');
		aPage.eq(index).addClass('active');
		aImg.stop();
		//隐藏除了当前元素，所以图像
		aImg.eq(index).siblings().animate({
			opacity:0
		},700)
		//显示当前图像
		aImg.eq(index).animate({
			opacity:1
		},700)
	}

	 
	function autoshow() {
		index=index+1;
		if(index<=iSize-1){
		   change(index);
		}else{
			index=0;
			change(index);
		}
			
	}
	int=setInterval(autoshow,10000);
	function clearInt() {
		$('#btnLeft,#btnRight,.page a').mouseover(function() {
			clearInterval(int);
		})
	
	}
	function setInt() {
		$('#btnLeft,#btnRight,.page a').mouseout(function() {
			int=setInterval(autoshow,10000);
		})
	}
	clearInt();
	setInt();
})
</script>
<script type="text/javascript">
$(function(){

	var aPage = $('#imgs');
	var aImg = $('#imgs .imgs img');	
	var iSize = aImg.size();
	var index = 0;
	
	//分页按钮点击
	aPage.click(function(){
		index = $(this).index();
		change(index)
	});
	//切换过程
	function change(index){
		aPage.removeClass('active');
		aPage.eq(index).addClass('active');
		aImg.stop();
		//隐藏除了当前元素，所以图像
		aImg.eq(index).siblings().animate({
			opacity:0
		},1500)
		//显示当前图像
		aImg.eq(index).animate({
			opacity:1
		},1500)
	}

	 
	function autoshow() {
		index=index+1;
		if(index<=iSize-1){
		   change(index);
		}else{
			index=0;
			change(index);
		}
			
	}
	int=setInterval(autoshow,5000);
	function clearInt() {
		$('#btnLeft,#btnRight,.page a').mouseover(function() {
			clearInterval(int);
		})
	
	}
	function setInt() {
		$('#btnLeft,#btnRight,.page a').mouseout(function() {
			int=setInterval(autoshow,5000);
		})
	}
	clearInt();
	setInt();
})
</script>


<div class="top">
	<div class="topcontainer">
		<div class="outicon">
			<div class="caselist bottomwrap2">
				<a href="#" class="tagImg1" id="qq1"><i class="iconfont">&#xe600;</i></a>
				<div class="tagDiv1">
					<a href="#" target="_blank" style="color: #00A0E9" id="qq2"><i class="iconfont">&#xe600;</i></a>
				</div>
			</div>
			<div class="caselist">
				<a href="http://weibo.com/u/5368161400" class="tagImg1" target="_blank"><i class="iconfont">&#xe601;</i></a>
				<div class="tagDiv1">
					<a href="http://weibo.com/u/5368161400" target="_blank" style="color: #E60012"><i class="iconfont">&#xe601;</i></a>
				</div>
			</div>
			<div class="caselist bottomwrap">
				<a href="" class="tagImg1"><i class="iconfont">&#xe602;</i></a>
				<div class="tagDiv1">
					<a href="javascript:void(0)" style="color: #8EC500"><i class="iconfont">&#xe602;</i></a>
				</div>
			</div>

		</div>
		<div class="hotline">
			<div class="l1">客服热线: 400-9616-588</div>
			<shiro:authenticated>
				<div class="l3">
					<a href="${ctx}/member/investdoc.do" class="reg_1"><shiro:principal
							property="nickname"></shiro:principal></a>
				</div>
				<div class="l2">
					<a href="${ctx}/loginout.do">退出</a>
				</div>
			</shiro:authenticated>
			<shiro:notAuthenticated>
				<div class="l3">
					<a href="${ctx}/register.do" class="reg_1">注册账户</a>
				</div>
				<div class="l2">
					<a href="${ctx}/login.do">登录</a>
				</div>
			</shiro:notAuthenticated>
		</div>
	</div>

</div>
<div class="navtop">
	<div class="topcontainer2">
		<div class="logo">
			<img src="${ctx}/static/images/V2/logo.png" alt="logo" />
		</div>
		<div class="navbarl">
			<ul id="all_check">
				<li><a href="${ctx}/" class="current" id="index_check">　首页　</a></li>
				<li><a href="${ctx}/queryBidAll.do" id="invest_check">我要投资</a></li>
				<li><a href="${ctx}/helpcenter.do"  target="_blank" id="service_check">新手指南</a></li>
				<li><a href="${ctx}/safeguard.do" target="_blank" id="security_check">安全保障</a></li>
				<li><a href="${ctx}/introduce.do" target="_blank" id="about_check">关于百富</a></li>
			</ul>

		</div>
		<div class="oe_wrapper">
			<ul id="oe_menu" class="oe_menu">
			<shiro:notAuthenticated>
				<li><a href="${ctx}/login.do"><img src="${ctx}/static/images/avatar.png" alt="" /> 我的百富</a>
					<div>
							<ul>
								<li><a href="${ctx}/login.do">资产档案</a></li>
								<li><a href="${ctx}/login.do">天 天 富</a></li>
								<li><a href="${ctx}/login.do">投资记录</a></li>
								<li><a href="${ctx}/login.do">交易记录</a></li>
							</ul>
					</div></li></shiro:notAuthenticated>
					<shiro:authenticated>
				<li><a href="${ctx}/member/investdoc.do"><img src="${ctx}/static/images/avatar.png" alt="" /> 我的百富</a>
					<div>
						    <ul>
								<li><a href="${ctx}/member/investdoc.do">资产档案</a></li>
								<li><a href="${ctx}/member/ttfrecord.do">天 天 富</a></li>
								<li><a href="${ctx}/member/investmentrecord.do">投资记录</a></li>
								<li><a href="${ctx}/member/dealhistory.do">交易记录</a></li>
							</ul>
					</div></li>
						</shiro:authenticated>
			</ul>
		</div>
	</div>
</div>
<!-- div class="am-dropdown" data-am-dropdown style="float:right; margin-top:28px; margin-right:-15px;">
  <button class="am-btn am-btn-biifoo am-dropdown-toggle" data-am-dropdown-toggle style="height:42px; padding-top: 12px;"><img src="${ctx}/static/images/mine.png" style="margin-top:-2px;" alt=""/> <span style="vertical-align:top;font-size:14px;">我的百富</span> <span class="am-icon-caret-down" style="vertical-align:top;margin-top:-2px;"></span></button>
  <shiro:authenticated>
  <ul class="am-dropdown-content">
    <li><a href="${ctx }/member/investdoc.do">资产总览</a></li>
    <li><a href="${ctx }/member/investmentrecord.do">我的理财</a></li>
    <li><a href="${ctx }/member/dealhistory.do">我的交易单</a></li>
  </ul>
  </shiro:authenticated>
   <shiro:notAuthenticated>
  <ul class="am-dropdown-content">
    <li><a href="${ctx }/login.do">资产总览</a></li>
    <li><a href="${ctx }/queryBidAll.do">我的理财</a></li>
    <li><a href="${ctx }/login.do">我的交易单</a></li>
  </ul>
  </shiro:notAuthenticated>
</div -->
</div>
</div>
