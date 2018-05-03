<%@page import="com.biifoo.model.Bidclass"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta property="qc:admins" content="1001377607621167763757164506230" />
<title>小额投资理财网，P2P互联网投资理财，个人小额理财专业平台 - 百富网小额投资理财平台</title>
<meta name="keywords" content="小额投资理财，投资理财，保本理财，网上理财产品，个人小额理财，个人小额投资理财，投资理财网，p2p互联网金融，互联网保本理财，互联网金融p2p，p2p金融，p2p网络平台，p2p网络投资理财平台，专业理财网站，专业p2p理财">
<meta name="description" content="百富网是专业的个人投资理财平台，提供各种小额投资理财产品，P2P互联网金融产品，P2F保本理财等各类网上理财产品。一元起投，随时赎回，为有理财需求的投资人提供安全、有担保、高收益的互联网理财服务。">
<%@include file="../common/header.jsp"%>
<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<%
String[] pic1 = request.getAttribute("xinshou").toString().split(",");
String[] pic2 = request.getAttribute("dingcun").toString().split(",");
String[] pic3 = request.getAttribute("yuexi").toString().split(",");
%>
<style type="text/css">
 #logo{
	margin: 0 auto;
	position: relative;/*相对定位,为了下面hover的绝对定位*/
	background: url("<%=pic1[0]%>") left top no-repeat;/*设置背景图*/
	width: 380px;
	height: 420px;/*注意这里高度*/
	display: block;
	text-indent: -9999px;
 }

#logo .hover{/*为JQ准备*/
  background:url("<%=pic1[1]%>") left bottom no-repeat;/*background-position和上面不同*/
  position:absolute;/*为了使两张图片重叠在一起*/
  top:0;
  left:0;
  height:420px;
  width:380px;
 }

#logo2{
	margin: 0 auto;
	position: relative;/*相对定位,为了下面hover的绝对定位*/
	background: url("<%=pic2[0]%>") left top no-repeat;/*设置背景图*/
	width: 380px;
	height: 420px;/*注意这里高度*/
	display: block;
	text-indent: -9999px;
}

#logo2 .hover{/*为JQ准备*/
  background:url("<%=pic2[1]%>") left bottom no-repeat;/*background-position和上面不同*/
  position:absolute;/*为了使两张图片重叠在一起*/
  top:0;
  left:0;
  height:420px;
  width:380px;
}

#logo3{
	margin: 0 auto;
	position: relative;/*相对定位,为了下面hover的绝对定位*/
	background: url("<%=pic3[0]%>") left top no-repeat;/*设置背景图*/
	width: 380px;
	height: 420px;/*注意这里高度*/
	display: block;
	text-indent: -9999px;
}

#logo3 .hover{/*为JQ准备*/
  background:url("<%=pic3[1]%>") left bottom no-repeat;/*background-position和上面不同*/
  position:absolute;/*为了使两张图片重叠在一起*/
  top:0;
  left:0;
  height:420px;
  width:380px;
}
</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/mobile-common.js"></script>
<script type="text/javascript">
		if(isMobile()){
			window.location.href="http://www.biifoo.com/m";
		}
</script>
</script>

</head>

<body>
<jsp:include page="header.jsp"/><!--网站logo 导航条  end-->


<div class="DB_tab25"><!--banner条  start-->
  <ul class="DB_bgSet">
		<li onClick="javascript:window.location.href='redadv.do';" style="background:url(${ctx}/static/images/bg01.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li onClick="javascript:window.location.href='queryBidAll.do';" style="background:url(${ctx}/static/images/bg14.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li onClick="javascript:window.location.href='helpcenter.do';" style="background:url(${ctx}/static/images/bg02.jpg) no-repeat 100% 100%;background-position: center;"></li>
        <li onClick="javascript:window.location.href='${ctx}/team.do';" style="background:url(${ctx}/static/images/bg03.jpg) no-repeat 100% 100%;background-position: center;"></li>
        <li onClick="javascript:window.location.href='${ctx}/queryNewsOne.do?id=96';" style="background:url(${ctx}/static/images/bg15.jpg) no-repeat 100% 100%;background-position: center;"></li>
        <li onClick="javascript:window.location.href='${ctx}/safeguard.do';" style="background:url(${ctx}/static/images/bg04.jpg) no-repeat 100% 100%;background-position: center;"></li>
  </ul>

	<ul class="DB_imgSet">
		<li>
		</li>

		<li>
		</li>

		<li>
		</li>

		<li>
		</li>
        
        <li>
			
		</li>
        
        <li>
			
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
  
  <div class="DB_bottom_1">
    <div class="bannericon">
      <div class="bannericon1"><a href="help_detail.do#21" target="_blank">安 全<br><span class="banner_style3">33道防火墙 安全交易</span></a></div>
      <div class="bannericon2"><a href="help_detail.do#14" target="_blank">便 捷<br><span class="banner_style3">7×24小时 随时存取</span></a></div>
      <div class="bannericon3"><a href="help_detail.do#17" target="_blank">收益高<br><span class="banner_style3">36倍银行利率 稳健收益</span></a></div>      
    </div>
  </div>
</div><!--banner条  end-->


<div class="diamond"><!--投资产品精选栏  start-->
  <div class="diamond1"><h1>聪明你的理财</h1><p>每日 <span style="color: #009ce4;">10:00</span> <span style="color: #009ce4;">14:00</span> <span style="color: #009ce4;">19:30</span> 更新</p></div>
</div><!--投资产品精选栏  end-->


<div class="product"><!--新手标 定存宝 月息宝  start-->
  <div class="product1">
    <div class="product2"><a id="logo" href="queryBidAll.do?bidtypeid=4"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo .hover").css('opacity', 0);//先不显示
     $("#logo .hover").parent().hover(
  function(){
   $("#logo .hover").stop().animate({opacity: '1'},500);
  },
  function(){
   $("#logo .hover").stop().animate({opacity: '0'},500);
  });
    </script></div>
    <div class="product2"><a id="logo2" href="queryBidAll.do?bidtypeid=3"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo2").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo2 .hover").css('opacity', 0);//先不显示
     $("#logo2 .hover").parent().hover(
  function(){
   $("#logo2 .hover").stop().animate({opacity: '1'},500);
  },
  function(){
   $("#logo2 .hover").stop().animate({opacity: '0'},500);
  });
    </script></div>
    <div class="product3"><a id="logo3" href="queryBidAll.do?bidtypeid=1"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo3").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo3 .hover").css('opacity', 0);//先不显示
     $("#logo3 .hover").parent().hover(
  function(){
   $("#logo3 .hover").stop().animate({opacity: '1'},500);
  },
  function(){
   $("#logo3 .hover").stop().animate({opacity: '0'},500);
  });
    </script></div>
  </div>
</div><!-- 新手标 定存宝 月息宝 end-->

<div class="DB_tab25"><!--banner条  start-->
	<ul class="DB_bgSet">
		<li style="background:url(${ctx}/static/images/bg07.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li style="background:url(${ctx}/static/images/bg12.jpg) no-repeat 100% 100%;background-position: center;"></li>
		<li style="background:url(${ctx}/static/images/bg11.jpg) no-repeat 100% 100%;background-position: center;"></li>
		
	</ul>

	<ul class="DB_imgSet">
		<li>
			
		</li>

		<li>
			
		</li>

		<li>
			
		</li>

		
	</ul>

	<div class="DB_menuWrap">
		<ul class="DB_menuSet">
			<li></li>
			<li></li>
			<li></li>
			
		</ul>
		<div class="DB_next"><img src="${ctx}/static/images/nextArrow.png" alt="NEXT"></div>
		<div class="DB_prev"><img src="${ctx}/static/images/prevArrow.png" alt="PREV"></div>
  </div>

</div>
</div><!--banner条  end-->

<div class="life"><!--百富你的生活栏  start-->
  <div class="life1"><h1>百富你的生活</h1>
  <p>改变，从百富开始</p></div>
</div><!--百富你的生活栏  start-->

<div class="product"><!--三个生活  start-->
  <div class="product1">
    <div class="product4">
      <a id="logo7" href="s2.do"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo7").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo7 .hover").css('opacity', 0);//先不显示
     $("#logo7 .hover").parent().hover(
  function(){
   $("#logo7 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo7 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
    <div class="product5">
      <a id="logo8" href="s1.do"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo8").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo8 .hover").css('opacity', 0);//先不显示
     $("#logo8 .hover").parent().hover(
  function(){
   $("#logo8 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo8 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
    <div class="product6">
      <a id="logo9" href="s3.do"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo9").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo9 .hover").css('opacity', 0);//先不显示
     $("#logo9 .hover").parent().hover(
  function(){
   $("#logo9 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo9 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
  </div>
</div><!--三个生活  end-->

<div class="discover"><!--发现栏  start-->
  <div class="discover1"><h1>发现</h1>
  <p>百富，我们的乐园</p>
  </div>
</div><!--发现栏  end-->

<div class="sixgrids"><!--六个发现  start-->
  <div class="sixgridst">
    <div class="sixgridst1">
       <a id="logo10" href="mailto:biifoolove@baifu360.com""><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo10").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo10 .hover").css('opacity', 0);//先不显示
     $("#logo10 .hover").parent().hover(
  function(){
   $("#logo10 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo10 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
    <div class="sixgridst2">
      <a id="logo11" href="${ctx }/richman.do"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo11").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo11 .hover").css('opacity', 0);//先不显示
     $("#logo11 .hover").parent().hover(
  function(){
   $("#logo11 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo11 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
    <div class="sixgridst3">
      <a id="logo12"><span>111111111111111111111111</span></a>
<script type="text/javascript">
  $("#logo12").append("<span class='hover'></span>");//添加一个标签用来和灰图重叠起来
  $("#logo12 .hover").css('opacity', 0);//先不显示
     $("#logo12 .hover").parent().hover(
  function(){
   $("#logo12 .hover").stop().animate({opacity: '1'},300);
  },
  function(){
   $("#logo12 .hover").stop().animate({opacity: '0'},300);
  });
    </script>
    </div>
  </div>
  
</div><!--六个发现  end-->

<div class="cor"><!--发现栏  start-->
  <div class="cor1">
    <h1>伙伴</h1>
  <p>是梦想，让我们走到了一起</p>
  </div>
</div>

<div class="company_1">
  <div class="company1">
    <div class="company2"><a href="http://www.sina.com.cn/" target="new">
<img src="${ctx}/static/images/sina_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.yicai.com/
" target="new"><img src="${ctx}/static/images/cbn_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.cmbchina.com/
" target="new"><img src="${ctx}/static/images/cmb_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://fund.cnfol.com/jijinkanshi/20150106/19853523.shtml
" target="new"><img src="${ctx}/static/images/cnfol_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://news.163.com/14/1223/18/AE5V5BK000014AEE.html
" target="new"><img src="${ctx}/static/images/163_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://pay.sina.com.cn/
" target="new"><img src="${ctx}/static/images/money_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://finance.china.com/" target="new"><img src="${ctx}/static/images/china_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.huanqiu.com/" target="new"><img src="${ctx}/static/images/huanqiu_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.zgjrjw.com/
" target="new"><img src="${ctx}/static/images/zgjrjw_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.gmw.cn/" target="new"><img src="${ctx}/static/images/gmw_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.cctvcj.com/sh/" target="new"><img src="${ctx}/static/images/cctv_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.stockstar.com/" target="new"><img src="${ctx}/static/images/stockstar_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.ce.cn/" target="new"><img src="${ctx}/static/images/ce_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.21cn.com/" target="new"><img src="${ctx}/static/images/21cn_logo.png" alt=""/></a></div>
    <div class="company2"><a href="http://www.chinadaily.com.cn/" target="new"><img src="${ctx}/static/images/chinadaily_logo.png" alt=""/></a></div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
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
		DB_4_3:{top:0,opacity:0,speed:1000,delay:500},
		DB_4_4:{top:30,opacity:0,speed:1000,delay:2000},
		DB_4_5:{top:100,opacity:0,speed:1000,delay:3000},
		end:null
	}
})
</script>
</html>
