<%@page import="com.zjgt.p2p.model.Bidclass"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>小额投资理财网，P2P互联网投资理财，个人小额理财专业平台 - 百富网小额投资理财平台</title>
<meta name="keywords" content="小额投资理财，投资理财，保本理财，网上理财产品，个人小额理财，个人小额投资理财，投资理财网，p2p互联网金融，互联网保本理财，互联网金融p2p，p2p金融，p2p网络平台，p2p网络投资理财平台，专业理财网站，专业p2p理财">
<meta name="description" content="百富网是专业的个人投资理财平台，提供各种小额投资理财产品，P2P互联网金融产品，P2F保本理财等各类网上理财产品。一元起投，随时赎回，为有理财需求的投资人提供安全、有担保、高收益的互联网理财服务。">
<%@include file="../common/header.jsp"%>
<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />

<%
String[] pic1 = request.getAttribute("xinshou").toString().split(",");
String[] pic2 = request.getAttribute("dingcun").toString().split(",");
String[] pic3 = request.getAttribute("yuexi").toString().split(",");
%>
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>

<script type="text/javascript" src="${ctx}/static/js/mobile-common.js"></script>
<!-- <script type="text/javascript">
		if(isMobile()){
			window.location.href="http://www.biifoo.com/m";
		}
</script> -->
<script type="text/javascript">
		function request(paras) {
			var url = location.href;
			var paraString = url.substring(url.indexOf("?") + 1, url.length)
					.split("&");
			var paraObj = {}
			for (i = 0; j = paraString[i]; i++) {
				paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j
						.substring(j.indexOf("=") + 1, j.length);
			}
			var returnValue = paraObj[paras.toLowerCase()];
			if (typeof (returnValue) == "undefined") {
				return "";
			} else {
				return returnValue;
			}
		}
		if("window"!=request("from")){
		}
		else if(isMobile()){
			window.location.href="http://www.biifoo.com/m";
		}
</script>
<script>
  var i=1;
  setInterval(function(){
	$("#c1").attr("src","${ctx}/static/html/chart"+i%2+".htm?date="+new Date());
	i++;},10000)
</script>
</head>

<body>
<jsp:include page="headerV2.jsp"/><!--网站logo 导航条  end-->
<div class="flicker-example" data-block-text="false">
  <ul>
    <li onClick="javascript:window.open('${ctx}/help_detail.do#z1');" data-background="${ctx}/static/images/banner1.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.open('${ctx}/queryNewsOne.do?id=99');" data-background="${ctx}/static/images/banner2.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.open('${ctx}/team.do');" data-background="${ctx}/static/images/banner3.jpg" style="cursor:pointer">
      
    </li>
    <li onClick="javascript:window.open('${ctx}/queryNewsOne.do?id=96');" data-background="${ctx}/static/images/banner4.jpg" style="cursor:pointer">
      
    </li>
    <li data-background="${ctx}/static/images/banner5.jpg" onClick="javascript:window.location.href='${ctx}/queryBidAll.do?bidtypeid=4&investperiod=&annualizedrate=&raisestate=&pageNow=1';">
      <div class="flick-title"><span class="flickerplatespan3">小额理财<span class="flickerplatespan">好帮手</span></span><br><span class="flickerplatespan2">存款1个月不如投资天天富1天</span><br><a href="${ctx}/queryBidAll.do?bidtypeid=4&investperiod=&annualizedrate=&raisestate=&pageNow=1" class="flickerplatebtn">了解更多</a></div>
    </li>
  </ul>
</div>

<div class="noticeout">
  <div class="notice"><img class="s4" src="${ctx}/static/images/notice.png" alt=""/>　百富金融时报:  <a href="${ctx}/queryNewsOne.do?id=103" ><span class="s3">5月12日百富网M站上线，用手机也能投资理财了</span> </a>  ｜  <a href="${ctx}/help_detail.do#21" target="_blank"> 百富网信息和资金安全  </a> ｜ <a href="${ctx}/help_detail.do#15" target="_blank"> 百富网投资流程</a>
    <div class="bannerin">8%<br>天天富<br><span>30倍活期存款收益</span><br>
  	 <shiro:notAuthenticated>
    	 <a href="${ctx}/register.do" class="bannerinbtn" style="color:#fff">注册抢6大福利</a>
   	</shiro:notAuthenticated>
    <shiro:authenticated>
   		 <a href="${ctx}/queryBidAll.do" class="bannerinbtn" style="color:#fff">立即投资</a>
    </shiro:authenticated>
    </div>
    <div class="bannerin2"><span class="s1">百富网手机站</span><br>随投随取 一手掌控<br><img src="${ctx}/static/images/2.jpg" alt=""/><br><span class="s2">扫一扫 马上变土豪</span></div>
  </div>
</div>

<div class="bfh"><span>为什么选择百富网？</span><br>我们用技术让收益更简单，投资人获得好收益。</div>


<div class="xb1">
  <div id="xb1">
    <div class="xb1_1">
      <img style="opacity:1;filter:alpha(opacity=100);" src="${ctx}/static/images/cube1.jpg" alt=""/>
      <img src="${ctx}/static/images/cube2.jpg" alt=""/>
    </div>
  </div>
  <div class="xb1_2">
    <iframe id="c1" src="${ctx}/static/html/chart0.htm" scrolling="no" frameborder="0" marginheight="0" marginwidth="0" height="260" width="880"></iframe>
  </div>
</div>

<div class="xb2">
  <div class="xb2a">
    <div class="xb2ai"><img src="${ctx}/static/images/box2_icon1.png" alt=""/><br><span>安全</span><br>新浪全程资金托管<br>100%本息保障</div>
    <div class="xb2ai"><img src="${ctx}/static/images/box2_icon2.png" alt=""/><br><span>便捷</span><br>技术智能分散投资<br>7×24小时随时存取</div>
    <div class="xb2ai"><img src="${ctx}/static/images/box2_icon3.png" alt=""/><br><span>收益高</span><br>100%对接优质金融资产<br>30倍存款收益</div>
  </div>
  <div class="xb2b">
    <div class="xb2bi1">快速了解百富网<br><span>获得高收益</span></div>
    <a href="${ctx}/helpcenter.do"  target="_blank" class="xb2bi2">了解更多</a>
    <div class="xb2bi3"><img src="${ctx}/static/images/box2_icon4.png" alt=""/></div>
  </div>
</div>

<div class="bfh"><span>明星产品</span><br>安全便捷收益高的小额理财服务</div>

<div class="box tab1">
  <div class="box_l">
    <div class="box_l1"><span>赚钱</span><br>分秒必争</div>
    <div class="box_l2">理财 ></div>
  </div>
    <ul class="tab_menu" id="chose">
      <li class="current"><a href="javascript:void(0)">天天富</a></li>
      <li><a href="javascript:void(0)">月月富</a></li>
    </ul>
  
  <div class="tab_box">
    <div>
      <div class="tab_icon"><img src="${ctx}/static/images/boxicon.png" alt=""/></div>
      <div class="tab_box_1">
        <div class="tab_box_1a">
          <div class="tab_box_1a1">新浪支付<br><span>极速、安全、便捷</span></div>
          <div class="tab_box_1a2">
            <div class="tbi1"><img src="${ctx}/static/images/box_icon1.png"  alt=""/><br><span class="tsp">随时随地</span></div>
            <div class="tbi2"><img src="${ctx}/static/images/box_icon2.png"  alt=""/><br><span class="tsp">安全可靠</span></div>
            <div class="tbi3"><img src="${ctx}/static/images/box_icon3.png"  alt=""/><br><span class="tsp">极速支付</span></div>
          </div>
          <div class="tab_box_1a3">100%第三方资金托管</div>
        </div>
        
        <div class="tab_box_1b">
          <div class="tab_box_1b1">天天富<br><span>投资天天富1天 = 银行存款1个月</span></div>
          <div class="tab_box_1b2">
            <div class="tbt1"><img src="${ctx}/static/images/box_icon4.png"  alt=""/><br><span class="tsp2">天天富</span></div>
            <div class="tbt2">8.0<span class="tsp4">%</span><br><span class="tsp3">预期年化收益率</span></div>
            <div class="tbt3">1<span class="tsp5"> 元</span><br><span class="tsp6">起投金额</span></div>
            <div class="tbt4">0<span class="tsp5"> 手续费</span><br><span class="tsp6">随时赎回</span></div>
          </div>
          <a href="${ctx}/queryBidAll.do?bidtypeid=4" class="tab_box_1b3">立刻投资</a>
        </div>
      </div>
      <div class="tab_box_2">
        <div class="tb2i"><img src="${ctx}/static/images/box_icon6.png" alt=""/><span>0门槛<br>1元即可投资</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon7.png" alt=""/><span>0闲置<br>0时即会计息</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon8.png" alt=""/><span>0等待<br>最快5分钟到账</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon9.png" alt=""/><span>0限制<br>随时都可赎回</span></div>
      </div>
    </div>
    
    <div class="hide">
      <div class="tab_icon"><img src="${ctx}/static/images/boxicon.png" alt=""/></div>
      <div class="tab_box_1">
        <div class="tab_box_1a">
          <div class="tab_box_1a1">新浪支付<br><span>极速、安全、便捷</span></div>
          <div class="tab_box_1a2">
            <div class="tbi1"><img src="${ctx}/static/images/box_icon1.png"  alt=""/><br><span class="tsp">随时随地</span></div>
            <div class="tbi2"><img src="${ctx}/static/images/box_icon2.png"  alt=""/><br><span class="tsp">安全可靠</span></div>
            <div class="tbi3"><img src="${ctx}/static/images/box_icon3.png"  alt=""/><br><span class="tsp">极速支付</span></div>
          </div>
          <div class="tab_box_1a3">100%第三方资金托管</div>
        </div>
        
        <div class="tab_box_1b">
          <div class="tab_box_1b1">月月富<br><span>投资月月富1年 = 银行存款30年</span></div>
          <div class="tab_box_1b2">
            <div class="tbt1"><img src="${ctx}/static/images/box_icon5.png"  alt=""/><br><span class="tsp2">月月富</span></div>
            <div class="tbt2">9.2<span class="tsp4">%</span><br><span class="tsp3">预期年化收益率</span></div>
            <div class="tbt3">100<span class="tsp5"> 元</span><br><span class="tsp6">起投金额</span></div>
            <div class="tbt4">0<span class="tsp5"> 手续费</span><br><span class="tsp6">到期赎回</span></div>
          </div>
          <a href="${ctx}/queryBidAll.do?bidtypeid=3" class="tab_box_1b3">立刻投资</a>
        </div>
        
      </div>
      
      <div class="tab_box_2">
        <div class="tb2i"><img src="${ctx}/static/images/box_icon10.png" alt=""/><span>好收益<br>存款30年不如投资月月富1年</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon11.png" alt=""/><span>好稳健<br>产品100%对接优质金融资产</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon12.png" alt=""/><span>好安全<br>资金100%新浪托管</span></div>
        <div class="tb2i"><img src="${ctx}/static/images/box_icon13.png" alt=""/><span>好方便<br>支持7×24小时交易</span></div>
      </div>
    </div>
  </div>
</div>

<div class="bfh"><span>百富，触“手”可得</span><br>真正让理财变得随时随地、随心所欲，把财富握在手里。</div>

<div class="xb3">
  <div class="xb3a">
    <div class="xb3a1"><img src="${ctx}/static/images/box3_pic1.png" alt=""/></div>
    <div class="xb3a2">
      <div class="xb3a2i mgn1"><img src="${ctx}/static/images/2_3.png" alt=""/><div class="xbtn"><img src="${ctx}/static/images/ult.png" alt=""/> 百富手机站</div></div>
      <div class="xb3a2i mgn2"><img src="${ctx}/static/images/2_2.png" alt=""/><div class="xbtn"><img src="${ctx}/static/images/wechatred.png" alt=""/> 关注微信</div></div>
      <div class="xb3a2t">扫描二维码关注百富网官方微信或进入百富网M站，及时获取第一手理财资讯，无缝享受投资收益，把手机培养成会赚钱的小伙伴。</div>
    </div>
    <div class="xb3a3"><img src="${ctx}/static/images/box3_pic2.png" alt=""/></div>
  </div>
  <div class="xb3b">
    <div class="tb2i"><a href="${ctx}/help_detail.do#13" target="_blank"><img src="${ctx}/static/images/box3_icon1.png" alt=""/><span>如何充值？<br>快速充值更方便</span></a></div>
    <div class="tb2i"><a href="help_detail.do#15" target="_blank"><img src="${ctx}/static/images/box3_icon2.png" alt=""/><span>如何投资？<br>1元起投更简单</span></a></div>
    <div class="tb2i"><a href="help_detail.do#16" target="_blank"><img src="${ctx}/static/images/box3_icon3.png" alt=""/><span>如何赎回？<br>自由赎回更灵活</span></a></div>
    <div class="tb2i"><a href="help_detail.do#14" target="_blank"><img src="${ctx}/static/images/box3_icon4.png" alt=""/><span>如何提现？<br>免费提现更省钱</span></a></div>
  </div>
</div>

<div class="bfh"><span>关于我们</span><br>“百”是指付出一百分的努力去工作，而“富”是我对你的承诺。</div>

<div class="about">
  <div class="abouti aboutim2">
    <div class="abouth">百富是谁</div>
    <div class="boxes">
      <div id="imgs">
	    <div class="imgs">
		  <img style="opacity:1;filter:alpha(opacity=100);" src="${ctx}/static/images/member1.jpg" />
          <img src="${ctx}/static/images/member2.jpg" />
        </div>
      </div>
      <div class="redline"></div>
      <div class="abouttxt">百富网是一家面向普通大众的网络投资平台，用互联网开启全民理财潮流。为所有有理财需求的投资人提供安全、有担保、高收益的互联网理财服务。</div>
      <div class="aboutmore"><a href="${ctx}/introduce.do" target="_blank">更多 <img src="${ctx}/static/images/more.png" alt=""/></a></div>
    </div>
  </div>
  
  <div class="abouti aboutim">
    <div class="abouth">合作伙伴</div>
    <div class="boxes">
      <div class="partner"><img src="${ctx}/static/images/partner1.png" alt=""/></div>
      <div class="partner"><img src="${ctx}/static/images/partner2.png" alt=""/></div>
      <div class="partner"><img src="${ctx}/static/images/partner3.png" alt=""/></div>
      <div class="partner"><img src="${ctx}/static/images/partner4.png" alt=""/></div>
      <%-- 
      <div class="aboutmore"><a href="javascript:void(0)">更多 <img src="${ctx}/static/images/more.png" alt=""/></a></div>
      --%>
    </div>
  </div>
  
  <div class="abouti aboutim2">
    <div class="abouth">媒体报道</div>
    <div class="boxes">
      <div class="timeline"><img src="${ctx}/static/images/timeline.png" alt=""/></div>
      <div class="report">
        <img src="${ctx}/static/images/report1.jpg" alt=""/>
        <div class="time">2015-05-07</div>
        <div class="reporth"><a href="${ctx}/queryNewsOne.do?id=102" target="_blank">和讯网采访百富网唐田：<br>P2F模式完爆P2P</a></div>
      </div>
      <div class="report2">
        <img src="${ctx}/static/images/report2.jpg" alt=""/>
        <div class="time">2015-04-23</div>
        <div class="reporth"><a href="${ctx}/queryNewsOne.do?id=99" target="_blank">中国财经时报报道百富网<br>牵手加多宝，天天富加息至8%</a></div>
      </div>
      <div class="report2">
        <img src="${ctx}/static/images/report3.jpg" alt=""/>
        <div class="time">2014-12-31</div>
        <div class="reporth"><a href="${ctx}/queryNewsOne.do?id=96" target="_blank">中华网报道百富网唐田博士<br>对话第一财经青年领袖</a></div>
      </div>
    <div class="aboutmore"><a href="${ctx}/queryNewsAll.do" target="_blank">更多 <img src="${ctx}/static/images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti ">
    <div class="abouth">精英团队</div>
    <div class="boxes elite">
      <img src="${ctx}/static/images/elite1.png" alt=""/><br>
      <span>Raymond Tang<br>唐 田</span><br>百富金融集团创始人，<br>中国科学院微系统研究所博士，<br>中国最年轻的博士之一。
    <div class="aboutmore"><a href="team.do">更多 <img src="${ctx}/static/images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti  aboutim">
    <div class="abouth">用户反馈</div>
    <div class="boxes">
      <div class="user"><img src="${ctx}/static/images/pic1.png" alt=""/><br><span>投资人</span><br>焦先生</div>
      <div class="usercontent">我和太太都在国有金融机构工作。之前我们都是通过信托和基金来理财的，经朋友介绍投资百富后，发现它是一个起投金额更低，赎回灵活度更高的产品，安全性和收益率丝毫不弱，我很享受在百富的投资经历，也愿意推荐更多像我一样的朋友购买天天富。</div>
    <div class="aboutmore"><a href="mailto:biifoolove@baifu360.com">给我们反馈 <img src="${ctx}/static/images/more.png" alt=""/></a></div></div>
  </div>
  
  <div class="abouti">
    <div class="abouth">帮助中心</div>
    <div class="boxes">
      <div class="faq faqm">
        <div class="faqp"><img src="${ctx}/static/images/about_icon1.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#z1" target="_blank">百富网的模式？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon2.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#19" target="_blank">百富网有哪些理财产品？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon3.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#21" target="_blank">如何保证我的资金安全？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon4.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#15" target="_blank">如何进行投资？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon5.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#16" target="_blank">投资后是否可以提前赎回？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon6.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#14" target="_blank">如何进行充值提现？</a></div>
      </div>
      <div class="faq">
        <div class="faqp"><img src="${ctx}/static/images/about_icon7.png" alt=""/></div>
        <div class="faqc"><a href="${ctx}/help_detail.do#21" target="_blank">本金和收益是否能够得到保障？</a></div>
      </div>
      <div class="aboutmore"><a href="${ctx}/help_detail.do" target="_blank">更多 <img src="${ctx}/static/images/more.png" alt=""/></a></div>
    </div>
  </div>
</div>

<div class="bfh"><span>媒体评价</span><br>真实客观的媒体评价，助您更好地了解百富网。</div>

<div class="xb4">
  <div class="xb4i">
    <div class="xb4p"><img src="${ctx}/static/images/media1.png" alt=""/></div>
    <div class="xb4c">投资门槛极低，仅为1元，这就是百富网提出的“零钱理财”的概念。吃饭购物的找钱、口袋里面的零钱、银行卡里面的结余都是可以投资天天富的资金来源。天天富就等于是一个会让你的零钱自动升值的钱包，不知不觉零钱变整钱，让你的钱包鼓起来。</div>
  </div>
  <div class="xb4i xb4m">
    <div class="xb4p"><img src="${ctx}/static/images/media2.png" alt=""/></div>
    <div class="xb4c">百富网是由正大集团原投资总经理唐田博士一手创立的一家网络小额理财平台，核心团队由曾经就职于诸如阿里、百度等一流公司的专业人员组成。深厚的专业背景和严谨的风控意识毋庸置疑。</div>
  </div>
  <div class="xb4i">
    <div class="xb4p"><img src="${ctx}/static/images/media3.png" alt=""/></div>
    <div class="xb4c">互联网+金融”的模式在两会和博鳌亚洲论坛上大放异彩，聚焦了不少人的注意力。百富网乘着互联网金融概念持续火热这股东风，成为了小额理财市场的领导者。</div>
  </div>
  <div class="aboutmore"></div>
</div>

<div class="boxz">
  <div class="rego">
      <div class="regpt">聚合点滴，为您创生无限财富！</div>
      <div class="regpb"><a href="${ctx}/register.do">立即注册</a></div>
  </div>
  <div class="regp">
  </div>
</div>

<jsp:include page="footerV2.jsp"/>
</body>
</html>
