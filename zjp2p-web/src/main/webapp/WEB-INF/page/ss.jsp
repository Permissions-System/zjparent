<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>百富网小额投资理财平台</title>

<!-- Bootstrap -->
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/indexstyle.css" rel="stylesheet">
<link href="css/liststyle.css" rel="stylesheet">
<link href="css/flickerplate.css"  rel="stylesheet">
<link href="css/tooltip.css" rel="stylesheet">
<link rel="stylesheet" href="css/chartist.min.css">
<link href="css/chartistbanner.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="js/jquery.tabs.js"></script>
<script src="js/jquery.lazyload.js"></script>
<script src="js/cufon-yui.js"></script>
<script src="js/modernizr-custom-v2.7.1.js" type="text/javascript"></script>
<script src="js/jquery-finger-v0.1.0.js" type="text/javascript"></script>
<script src="js/flickerplate.js"></script>
<script src="js/jquery.DB_tabMotionBanner.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
</head>
<body>
<div class="top">
  <div class="topcontainer">
    <div class="outicon">
      <div class="caselist bottomwrap2"><a href="" class="tagImg1"><i class="iconfont">&#xe600;</i></a>
        <div class="tagDiv1">
			<a href="#" target="_blank" style="color:#00A0E9"><i class="iconfont">&#xe600;</i></a>
		</div>
      </div>
      <div class="caselist"><a href="" class="tagImg1"><i class="iconfont">&#xe601;</i></a>
        <div class="tagDiv1">
			<a href="#" target="_blank" style="color:#E60012"><i class="iconfont">&#xe601;</i></a>
		</div>
      </div>
      <div class="caselist bottomwrap"><a href="" class="tagImg1"><i class="iconfont">&#xe602;</i></a>
        <div class="tagDiv1">
			<a href="#" target="_blank" style="color:#8EC500"><i class="iconfont">&#xe602;</i></a>
		</div>
      </div>
      
    </div>
    <div class="bannerin">8%<br>天天富<br><span>30倍活期存款收益</span><br><a href="#" class="bannerinbtn" style="color:#fff">注册抢6大福利</a>
    </div>
    <div class="bannerin2"><span class="s1">百富网手机站</span><br>随投随取 一手掌控<br><img src="${ctx }images/2.jpg" alt=""/><br><span class="s2">扫一扫 马上变土豪</span></div>
    <div class="hotline"><div class="l1">客服热线: 400-9616-588</div><div class="l3"><a href="#" class="reg_1">注册账户</a></div><div class="l2"><a href="#">登录</a></div></div>
  </div>
  
</div>
<div class="navtop">
  <div class="topcontainer">
    <div class="logo"><img src="images/logo.png" alt="logo"/></div>
    <div class="navbarl">
      <ul>
        <li><a href="#"  class="current">　首页　</a></li>
        <li><a href="#">我要投资</a></li>
        <li><a href="#">服务专区</a></li>
        <li><a href="#">安全保障</a></li>
        <li><a href="#">关于百富</a></li>
      </ul>
      
    </div>
    <div class="oe_wrapper">
	  <ul id="oe_menu" class="oe_menu">
		 <li><a href=""><img src="images/avatar.png"   alt=""/> 我的百富</a>
		   <div>
			 <ul>
			   <li><a href="#">资产档案</a></li>
			   <li><a href="#">天 天 富</a></li>
			   <li><a href="#">投资记录</a></li>
               <li><a href="#">交易记录</a></li>
			 </ul>
		   </div>
		 </li>	
	   </ul>	
	 </div>
  </div>
</div>
<div class="flicker-example" data-block-text="false">
  <ul>
    <li onClick="javascript:window.location.href='#';" data-background="images/banner1.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.location.href='#';" data-background="images/banner2.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.location.href='#';" data-background="images/banner3.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.location.href='#';" data-background="images/banner4.jpg" style="cursor:pointer">
      
    </li>
    <li data-background="images/banner5.jpg">
      <div class="flick-title"><span class="flickerplatespan3">小额理财<span class="flickerplatespan">好帮手</span></span><br><span class="flickerplatespan2">存款1个月不如投资天天富1天</span><br><a href="#" class="flickerplatebtn">了解更多</a></div>
    </li>
  </ul>
</div>

<div class="noticeout">
  <div class="notice"><img src="images/notice.png" alt=""/>　百富金融时报:  <span>5月12日百富网M站上线，用手机也能投资理财了</span>   ｜   百富网信息和资金安全   ｜  百富网投资流程</div>
</div>

<div class="bfh"><span>为什么选择百富网？</span><br>我们用技术让收益更简单，投资人获得好收益。</div>


<div class="xb1">
  <div class="xb1_1">
    <div class="cube1">百富视点</div>
    <div class="clt"><span>存款20年</span><br>不如投资天天富1年</div>
  </div>
  <div class="xb1_2"><div class="ct-chart chartistx"></div></div>
</div>

<div class="xb2">
  <div class="xb2a">
    <div class="xb2ai"><img src="images/box2_icon1.png" alt=""/><br><span>安全</span><br>新浪全程资金托管<br>100%本息保障</div>
    <div class="xb2ai"><img src="images/box2_icon2.png" alt=""/><br><span>便捷</span><br>技术智能分散投资<br>7×24小时随时存取</div>
    <div class="xb2ai"><img src="images/box2_icon3.png" alt=""/><br><span>收益高</span><br>100%对接优质金融资产<br>30倍存款收益</div>
  </div>
  <div class="xb2b">
    <div class="xb2bi1">快速了解百富网<br><span>获得高收益</span></div>
    <a href="#" class="xb2bi2">了解更多</a>
    <div class="xb2bi3"><img src="images/box2_icon4.png" alt=""/></div>
  </div>
</div>

<div class="bfh"><span>明星产品</span><br>安全便捷收益高的小额理财服务</div>

<div class="box tab1">
  <div class="box_l">
    <div class="box_l1"><span>赚钱</span><br>分秒必争</div>
    <div class="box_l2">理财 ></div>
  </div>
    <ul class="tab_menu">
      <li class="current"><a href="">天天富</a></li>
      <li><a href="">月月富</a></li>
    </ul>
  
  <div class="tab_box">
    <div>
      <div class="tab_icon"><img src="images/boxicon.png" alt=""/></div>
      <div class="tab_box_1">
        <div class="tab_box_1a">
          <div class="tab_box_1a1">新浪支付<br><span>极速、安全、便捷</span></div>
          <div class="tab_box_1a2">
            <div class="tbi1"><img src="images/box_icon1.png"  alt=""/><br><span class="tsp">随时随地</span></div>
            <div class="tbi2"><img src="images/box_icon2.png"  alt=""/><br><span class="tsp">安全可靠</span></div>
            <div class="tbi3"><img src="images/box_icon3.png"  alt=""/><br><span class="tsp">极速支付</span></div>
          </div>
          <div class="tab_box_1a3">100%第三方资金托管</div>
        </div>
        
        <div class="tab_box_1b">
          <div class="tab_box_1b1">天天富<br><span>存款1个月不如投资天天富1天</span></div>
          <div class="tab_box_1b2">
            <div class="tbt1"><img src="images/box_icon4.png"  alt=""/><br><span class="tsp2">天天富</span></div>
            <div class="tbt2">8.0<span class="tsp4">%</span><br><span class="tsp3">预期年化收益率</span></div>
            <div class="tbt3">1<span class="tsp5"> 元</span><br><span class="tsp6">起投金额</span></div>
            <div class="tbt4">0<span class="tsp5"> 手续费</span><br><span class="tsp6">随时赎回</span></div>
          </div>
          <a href="#" class="tab_box_1b3">立刻投资</a>
        </div>
      </div>
      <div class="tab_box_2">
        <div class="tb2i"><img src="images/box_icon6.png" alt=""/><span>0门槛<br>1元即可投资</span></div>
        <div class="tb2i"><img src="images/box_icon7.png" alt=""/><span>0闲置<br>0时即会计息</span></div>
        <div class="tb2i"><img src="images/box_icon8.png" alt=""/><span>0等待<br>最快5分钟到账</span></div>
        <div class="tb2i"><img src="images/box_icon9.png" alt=""/><span>0限制<br>随时都可赎回</span></div>
      </div>
    </div>
    
    <div class="hide">
      <div class="tab_icon"><img src="images/boxicon.png" alt=""/></div>
      <div class="tab_box_1">
        <div class="tab_box_1a">
          <div class="tab_box_1a1">新浪支付<br><span>极速、安全、便捷</span></div>
          <div class="tab_box_1a2">
            <div class="tbi1"><img src="images/box_icon1.png"  alt=""/><br><span class="tsp">随时随地</span></div>
            <div class="tbi2"><img src="images/box_icon2.png"  alt=""/><br><span class="tsp">安全可靠</span></div>
            <div class="tbi3"><img src="images/box_icon3.png"  alt=""/><br><span class="tsp">极速支付</span></div>
          </div>
          <div class="tab_box_1a3">100%第三方资金托管</div>
        </div>
        
        <div class="tab_box_1b">
          <div class="tab_box_1b1">月月富<br><span>存款30年不如投资月月富1年</span></div>
          <div class="tab_box_1b2">
            <div class="tbt1"><img src="images/box_icon5.png"  alt=""/><br><span class="tsp2">月月富</span></div>
            <div class="tbt2">9.2<span class="tsp4">%</span><br><span class="tsp3">预期年化收益率</span></div>
            <div class="tbt3">100<span class="tsp5"> 元</span><br><span class="tsp6">起投金额</span></div>
            <div class="tbt4">0<span class="tsp5"> 手续费</span><br><span class="tsp6">随时赎回</span></div>
          </div>
          <a href="#" class="tab_box_1b3">立刻投资</a>
        </div>
        
      </div>
      
      <div class="tab_box_2">
        <div class="tb2i"><img src="images/box_icon10.png" alt=""/><span>好收益<br>存款30年不如投资月月富1年</span></div>
        <div class="tb2i"><img src="images/box_icon11.png" alt=""/><span>好稳健<br>产品100%对接优质金融资产</span></div>
        <div class="tb2i"><img src="images/box_icon12.png" alt=""/><span>好安全<br>资金100%新浪托管</span></div>
        <div class="tb2i"><img src="images/box_icon13.png" alt=""/><span>好方便<br>支持7×24小时交易</span></div>
      </div>
    </div>
  </div>
</div>

<div class="bfh"><span>百富，触“手”可得</span><br>关注百富微信或进入百富M站，第一时间获取理财资讯。</div>

<div class="xb3">
  <div class="xb3a">
    <div class="xb3a1"><img src="images/box3_pic1.png" alt=""/></div>
    <div class="xb3a2">
      <div class="xb3a2i mgn1"><img src="images/2_2.png" alt=""/><div class="xbtn"><img src="images/ult.png" alt=""/> 百富手机站</div></div>
      <div class="xb3a2i mgn2"><img src="images/2_2.png" alt=""/><div class="xbtn"><img src="images/wechatred.png" alt=""/> 关注微信</div></div>
      <div class="xb3a2t">扫描二维码关注百富网官方微信或进入百富网M站，及时获取第一手理财咨询，无缝享受投资收益，把手机培养成会赚钱的小伙伴。</div>
    </div>
    <div class="xb3a3"><img src="images/box3_pic2.png" alt=""/></div>
  </div>
  <div class="xb3b">
    <div class="tb2i"><a href="#"><img src="images/box3_icon1.png" alt=""/><span>如何充值？<br>快速充值更方便</span></a></div>
    <div class="tb2i"><a href="#"><img src="images/box3_icon2.png" alt=""/><span>如何投资？<br>1元起投更简单</span></a></div>
    <div class="tb2i"><a href="#"><img src="images/box3_icon3.png" alt=""/><span>如何赎回？<br>自由赎回更灵活</span></a></div>
    <div class="tb2i"><a href="#"><img src="images/box3_icon4.png" alt=""/><span>如何提现？<br>免费提现更省钱</span></a></div>
  </div>
</div>

<div class="bfh"><span>关于我们</span><br>“百”是指付出一百分的努力去工作，而“富”是我对你的承诺。</div>

<div class="about">
  <div class="abouti aboutim2">
    <div class="abouth">百富是谁</div>
    <div class="boxes">
      <div id="imgs">
	    <div class="imgs">
		  <img style="opacity:1;filter:alpha(opacity=100);" src="images/member1.jpg" />
          <img src="images/member2.jpg" />
        </div>
      </div>
      <div class="redline"></div>
      <div class="abouttxt">百富网是一家面向普通大众的网络投资平台，用互联网开启全民理财潮流。为所有有理财需求的投资人提供安全、有担保、高收益的互联网理财服务。</div>
      <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div>
    </div>
  </div>
  
  <div class="abouti aboutim">
    <div class="abouth">合作伙伴</div>
    <div class="boxes">
      <div class="partner"><img src="images/partner1.png" alt=""/></div>
      <div class="partner"><img src="images/partner2.png" alt=""/></div>
      <div class="partner"><img src="images/partner3.png" alt=""/></div>
      <div class="partner"><img src="images/partner4.png" alt=""/></div>
      <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div>
    </div>
  </div>
  
  <div class="abouti aboutim2">
    <div class="abouth">媒体报道</div>
    <div class="boxes">
      <div class="timeline"><img src="images/timeline.png" alt=""/></div>
      <div class="report">
        <img src="images/report1.jpg" alt=""/>
        <div class="time">2015-05-07</div>
        <div class="reporth"><a href="#">和讯网采访百富网唐田：<br>P2F模式完爆P2P</a></div>
      </div>
      <div class="report2">
        <img src="images/report2.jpg" alt=""/>
        <div class="time">2015-04-23</div>
        <div class="reporth"><a href="#">中国财经时报报道百富网<br>牵手加多宝，天天富加息至8%</a></div>
      </div>
      <div class="report2">
        <img src="images/report3.jpg" alt=""/>
        <div class="time">2014-12-31</div>
        <div class="reporth"><a href="#">中华网报道百富网唐田博士<br>对话第一财经青年领袖</a></div>
      </div>
    <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti ">
    <div class="abouth">精英团队</div>
    <div class="boxes elite">
      <img src="images/elite1.png" alt=""/><br>
      <span>Raymond Tang<br>唐 田</span><br>百富金融集团创始人，<br>中国科学院微系统研究所博士，<br>中国最年轻的博士之一。
    <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti  aboutim">
    <div class="abouth">用户反馈</div>
    <div class="boxes">
      <div class="user"><img src="images/pic1.png" alt=""/><br><span>投资人</span><br>焦先生</div>
      <div class="usercontent">我和太太都在国有金融机构工作。之前我们都是通过信托和基金来理财的，经朋友介绍投资百富后，发现它是一个起投金额更低，赎回灵活度更高的产品，安全性和收益率丝毫不弱，我很享受在百富的投资经历，也愿意推荐更多像我一样的朋友购买天天富。</div>
    <div class="aboutmore"><a href="#">给我们反馈 <img src="images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti">
    <div class="abouth">帮助中心</div>
    <div class="boxes">
      <div class="faq faqm">
        <div class="faqp"><img src="images/about_icon1.png" alt=""/></div>
        <div class="faqc"><a href="#">百富网的模式？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon2.png" alt=""/></div>
        <div class="faqc"><a href="#">百富网有那些理财产品？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon3.png" alt=""/></div>
        <div class="faqc"><a href="#">如何保证我的资金安全？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon4.png" alt=""/></div>
        <div class="faqc"><a href="#">如何进行投资？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon5.png" alt=""/></div>
        <div class="faqc"><a href="#">投资后是否可以提前赎回？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon6.png" alt=""/></div>
        <div class="faqc"><a href="#">提现需要收费吗？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="images/about_icon7.png" alt=""/></div>
        <div class="faqc"><a href="#">本金和收益是否能够得到保障？</a></div>
      </div>
      <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div>
    </div>
  </div>
</div>

<div class="bfh"><span>媒体评价</span><br>真实客观的媒体评价，助您更好地了解百富网。</div>

<div class="xb4">
  <div class="xb4i">
    <div class="xb4p"><img src="images/media1.png" alt=""/></div>
    <div class="xb4c">投资门槛极低，仅为1元，这就是百富网提出的“零钱理财”的概念。吃饭购物的找钱、口袋里面的零钱、银行卡里面的结余都是可以投资天天富的资金来源。天天富就等于是一个会让你的零钱自动升值的钱包，不知不觉零钱变整钱，让你的钱包鼓起来。</div>
  </div>
  <div class="xb4i xb4m">
    <div class="xb4p"><img src="images/media2.png" alt=""/></div>
    <div class="xb4c">百富网是由正大集团原投资总经理唐田博士一手创立的一家网络小额理财平台，核心团队由曾经就职于诸如阿里、百度等一流公司的专业人员组成。深厚的专业背景和严谨的风控意识毋庸置疑。</div>
  </div>
  <div class="xb4i">
    <div class="xb4p"><img src="images/media3.png" alt=""/></div>
    <div class="xb4c">互联网+金融”的模式在两会和博鳌亚洲论坛上大放异彩，聚焦了不少人的注意力。百富网乘着互联网金融概念持续火热这股东风，成为了小额理财市场的领导者。</div>
  </div>
  <div class="aboutmore"><a href="#">更多 <img src="images/more.png" alt=""/></a></div>
</div>

<div class="regp">
  <div class="rego">
    <div class="regpt">开启安全好收益的投资之旅吧！</div>
    <div class="regpb"><a href="#">立即注册</a></div>
  </div>
</div>

<div class="footer_o1">
  <div class="footer_i1">
    <div class="f_logo">
      <div class="b_logo"><img src="images/logo_b.png" alt="logo"/></div>
      <div class="rol rolm1"><a href="#">&#xe601;</a></div>
      <div class="rol rolm2"><a href="#">&#xe600;</a></div>
    </div>
    <div class="f_link">
      <div class="svc"><img src="images/service.png" alt="hotline"/><br><span class="txr1">400-9616-588</span></div>
      <ul class="f_link1">
        <li class="current">公司信息</li>
        <li><a href="#">百富网介绍</a></li>
        <li><a href="#">精英团队</a></li>
        <li><a href="#">公司新闻</a></li>
        <li><a href="#">媒体报道</a></li>
        <li><a href="#">投资人关系</a></li>
        <li><a href="#">加入我们</a></li>
        <li><a href="#">政策法规</a></li>
      </ul>
      <ul class="f_link2">
        <li class="current">发 现</li>
        <li><a href="#">百富精选</a></li>
        <li><a href="#">大富翁测试</a></li>
        <li><a href="#">投资收益计算器</a></li>
        <li><a href="#">分享红包</a></li>
      </ul>
      <ul class="f_link3">
        <li class="current">安全与帮助</li>
        <li><a href="#">产品安全</a></li>
        <li><a href="#">资金安全</a></li>
        <li><a href="#">数据及信息</a></li>
        <li><a href="#">隐私保密</a></li>
        <li><a href="#">常见问题</a></li>
      </ul>
      <ul class="f_link4">
        <li class="current">手机应用</li>
        <li><a href="#">iPhone版下载</a></li>
        <li><a href="#">Android版下载</a></li>
        <li class="f_2"><img src="images/2_1.png" alt=""/></li>
        <li class="bfp">百富网<br>微信公众号</li>
      </ul>
    </div>
  </div>
</div>

<div class="footer_o2">
  <div class="footer_i2">
    <div class="footer_i2_1"><img src="images/linkicon.png" alt="friendship link"/> 友情链接</div>
    <div class="footer_i2_2"><a href="#">微财富</a>　　<a href="#">财付通</a>　　<a href="#">微钱包</a>　　<a href="#">上海资信</a>　　<a href="#">和讯互联网金融</a>　　<a href="#">亚洲金融</a>　　<a href="#">亚汇网</a>　　<a href="#">平安银行</a>　　<a href="#">融360</a>　　<a href="#">金融界</a></div>
  </div>
</div>

<div class="footer_o3">
  <div class="footer_i3">
    <div class="footer_i3_1">©2015 百富网  ｜  沪ICP备14050495号-2  ｜  上海必富金融信息服务有限公司  ｜  Shanghai BiiFoo Financial Information Service Co.ltd </div>
    <div class="footer_i3_2"><img src="images/ologo-1.png" alt=""/>　　　　<img src="images/ologo-2.png" alt=""/>　　　　<img src="images/ologo-3.png" alt=""/></div>
  </div>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 

<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.min.js"></script>
<script src="js/chartist.js"></script>
<script src="js/tinytip.js"></script>
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
		DB_4_3:{top:-10,opacity:0,speed:1000,delay:500},
		DB_4_4:{top:30,opacity:0,speed:1000,delay:2000},
		DB_4_5:{top:100,opacity:0,speed:1000,delay:3000},
		end:null
	}
})
</script>
<script>
  $(function() {
	  var $oe_menu = $('#oe_menu');
	  var $oe_menu_items = $oe_menu.children('li');
	  var $oe_overlay = $('#oe_overlay');

                $oe_menu_items.bind('mouseenter',function(){
					var $this = $(this);
					$this.addClass('slided selected');
					$this.children('div').css('z-index','9999').stop(true,true).slideDown(200,function(){
						$oe_menu_items.not('.slided').children('div').hide();
						$this.removeClass('slided');
					});
				}).bind('mouseleave',function(){
					var $this = $(this);
					$this.removeClass('selected').children('div').css('z-index','1');
				});

				$oe_menu.bind('mouseenter',function(){
					var $this = $(this);
					$oe_overlay.stop(true,true).fadeTo(200, 0.6);
					$this.addClass('hovered');
				}).bind('mouseleave',function(){
					var $this = $(this);
					$this.removeClass('hovered');
					$oe_overlay.stop(true,true).fadeTo(200, 0);
					$oe_menu_items.children('div').hide();
				})
            });
</script>

<script>
var chart = new Chartist.Line('.ct-chart', {
  labels: ['1', '2', '3', '4', '5', '6', '7'],
  series: [
    [1, 4, 2, 4, 3, 1, 4],
  ]
}, {
  low: 0,
  showArea: true,
  showPoint: true,
  fullWidth: true
});

chart.on('draw', function(data) {
  if(data.type === 'line' || data.type === 'area') {
    data.element.animate({
      d: {
        begin: 2000 * data.index,
        dur: 2000,
        from: data.path.clone().scale(1, 0).translate(0, data.chartRect.height()).stringify(),
        to: data.path.clone().stringify(),
        easing: Chartist.Svg.Easing.easeOutQuint
      }
    });
  }
});
 </script>

<script>
    $(document).ready(function(){
        $('.caselist.bottomwrap').tinytip({
            position : 'bottom',
            // fix : {
            //     left : 30,
            //     top: 7
            // },
            speed : 100,
            tooltip: '扫描关注微信公众号',
            animation : {
                top : 20
            },
            // on : 'click',
            wrapper : '<span class="tooltips" style="display:block;padding:50px;"></span>',
            addClass : 'top_arrow_box center',
            preventClose : true
        });

    });
	$(document).ready(function(){
        $('.caselist.bottomwrap2').tinytip({
            position : 'bottom',
            // fix : {
            //     left : 30,
            //     top: 7
            // },
            speed : 100,
            tooltip: '百富网官方QQ群<br>433212926',
            animation : {
                top : 20
            },
            // on : 'click',
            wrapper : '<span class="tooltips2" style="display:block;padding:50px;"></span>',
            addClass : 'top_arrow_box2 center',
            preventClose : true
        });

    });
	
</script>
</body>
</html>