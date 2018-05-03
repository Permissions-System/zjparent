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
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/help.css" rel="stylesheet" type="text/css">
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/helpbanner.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1000px;
	height:240px;
	margin-left:auto;
	margin-right:auto;
	padding-top:105px;
	
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
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
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
    <div class="txt" style="color:#565A5C"><span>帮助中心</span><br>用心服务每一位用户！</div>
  </div>
</div>
<div style="width:100%; min-width:1200px; margin-left:auto; margin-right:auto;">
<div class="content">
  <div class="content_left">
    <div class="content_title"><strong>导航类目</strong></div>
    <div class="content_menu">
     <ul>
       <li class="current">新手指引</li>
       <li><a href="#"><span class="am-icon-angle-right" style="margin-left:-25px;"> 会员注册</span></a></li>
       <li><a href="#12"><span class="am-icon-angle-right" style="margin-left:-25px;"> 账户认证</span></a></li>
       <li><a href="#13"><span class="am-icon-angle-right" style="margin-left:-25px;"> 账户充值</span></a></li>
       <li><a href="#14"><span class="am-icon-angle-right" style="margin-left:-25px;"> 账户提现</span></a></li>
       <li><a href="#15"><span class="am-icon-angle-right" style="margin-left:-25px;"> 如何投资</span></a></li>
       <li><a href="#16"><span class="am-icon-angle-right" style="margin-left:-25px;"> 如何赎回</span></a></li>
       <li><a href="#22"><span class="am-icon-angle-right" style="margin-left:-25px;"> 账号密码管理</span></a></li>
       <li class="current">产品介绍</li>
       <li><a href="#19"><span class="am-icon-angle-right" style="margin-left:-25px;"> 年年富</span></a></li>
       <li><a href="#20"><span class="am-icon-angle-right" style="margin-left:-25px;"> 月月富</span></a></li>
       <li><a href="#n1"><span class="am-icon-angle-right" style="margin-left:-25px;"> 月月富T</span></a></li>
       <li><a href="#n2"><span class="am-icon-angle-right" style="margin-left:-25px;"> 天天富</span></a></li>
       <li class="current">百富安全</li>
       <li><a href="#17"><span class="am-icon-angle-right" style="margin-left:-25px;"> 百富简介</span></a></li>
       <li><a href="#21"><span class="am-icon-angle-right" style="margin-left:-25px;"> 安全保障</span></a></li>
     </ul>
    </div>
  </div>
  <div class="content_right">
    <div class="content_h">帮助中心
    </div>
    <div class="content_intro">
      <div class="content_box">
        <div class="content_box_h" id="r1">如何注册、登录？</div>
        <p>1. 通过首页右上角“注册”按钮正确填写邮箱地址、密码进行注册。<br>
2. 第三方账户登录，点击百富网登录入口处该合作网站对应的图标，在合作网站账号登录页面中输入合作网站的账号、密码即可登录百富网。</p>
        <div class="gotop" id="my-sticky"><span class="am-icon-angle-up"></span> <a href="#" style="color:#EA544A">返回顶部</a></div><script>
$(function() {
  $('#my-sticky').sticky({
    top: 450,
	bottom: 800,
  })
});
</script>
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何修改个人资料？</div>
        <p>登录后点击“昵称”进入会员中心，在『个人资料』中进行修改操作。</p>
       
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何更换绑定手机？</div>
        <p>登录后进入“我的百富”，点击进入『账户认证』后进行手机修改操作。
系统提交新的手机号及短信验证码<br>
（若手机停用或收不到验证码，可以发送以下信息到客服邮箱：<a href="mailto:kefu@baifu360.com">kefu@baifu360.com</a> ， 邮箱地址，绑定手机号和身份证正反面照片，并在照片上注明“仅用于百富网修改手机号使用”。收到邮件后我们会提交后台解绑手机号，解绑之后您会收到邮件提醒，您绑定新的手机号即可。）</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">注册账号后可以注销吗？</div>
        <p>可以发送以下信息到客服邮箱：<a href="mailto:kefu@baifu360.com">kefu@baifu360.com</a> ， 邮箱地址，绑定手机号和身份证正反面照片，并在照片上注明“仅用于百富网账户注销”。收到邮件后我们会提交后台注销账号，注销之后您会收到邮件提醒。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">新手可以投资什么项目？</div>
        <p>新手可以投资包括天天富、年年富、月月富，月月富T等所有投资项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="12">为什么要进行实名认证？</div>
        <p>为确保投资人的资金安全，账号安全，密码安全等。我们建议投资人在首次充值前完成个人身份信息的验证。投资人可在“账户认证”页面完成实名认证。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何进行手机认证？</div>
        <p>登录后点击“昵称”进入会员中心，在『账户认证』中进行修改操作。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何进行邮箱认证？</div>
        <p>登录后点击“昵称”进入会员中心，在『账户认证』中进行修改操作。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">实名认证成功后能修改吗？可以申请注册几个实名认证的账号？</div>
        <p>实名认证成功后不能修改。每个人（同一身份证）仅可以实名认证一个账号。为确保用户更好的管理自己的账户资产，建议您谨慎填写您的认证信息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="13">充值收手续费吗？</div>
        <p>在百富网上充值是完全免费的。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="14">如何充值？是实时到账吗？</div>
        <p>1. 登录百富网后进入“我的百富”选择『充值』，输入充值金额，选择充值方式：网上银行。点击“充值”跳转到对应银行的支付网关完成充值。百富网在收到来自第三方支付的扣款成功通知消息后，会在您的百富网账户余额中做记账处理。<br>
2. 登入百富进入“我的百富”选择『充值』，输入充值金额，选择充值方式：微钱包。输入第三方的账号密码完成充值。百富网在收到来自第三方支付的扣款成功通知消息后，会在您的百富网账户余额中做记账处理。 </p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">充值是否有限额？是否有次数限制？</div>
        <p>百富网对于客户的充值没有金额和次数限制，但客户在充值时的单笔限额取决于充值第三方支付平台或银行。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">为什么银行扣钱了百富网账户余额却没有增加？</div>
        <p>这种情况可能由以下几种原因导致：<br>
（1）银行已扣款，但是可能由于银行系统原因，资金没有同步到第三方支付平台，第三方支付平台没有收到扣款，您的百富账户余额就不会增加，这种情况您不用担心，银行会在发现问题之后和第三方支付平台对接，第三支付平台收到资金之后，您的百富网账户余额就会增加，如银行没有把钱对接给第三方支付平台，会在2个工作日之内把钱退回您的银行卡。<br>
（2）第三方支付平台判断您的网络存在钓鱼风险，自动关闭交易，您的钱会在2个工作日之内退回您的银行卡。发生此情况请准备您充值时产生的财付通28位订单号，联系百富客服进行处理。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="14">提现收费吗？手续费收多少？</div>
        <p>本金利息收益提现，每日免费一次，超出一次后每笔2元；无投资纪录按提现金额的0.6%收取且每笔加收2元，单笔最低收取5元。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何进行提现？</div>
        <p>按照以下步骤进行提现：<br>
1、登录后进入“我的百富”，点击左侧提现按钮；<br>
2、选择要进行提现的银行卡并输入提现金额；<br>
3、输入交易密码，完成提现申请</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">投资人申请提现后何时到账？</div>
        <p>具体到账时间取决于不同的银行。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">什么是免费提现额度？</div>
        <p>免费提现额度指：已投资的本金及利息收益。</p>
        
      </div>
     
      
      <div class="content_box">
        <div class="content_box_h">提现是否有限额？是否有次数限制？</div>
        <p>百富网对于客户的提现没有金额限制。本金利息收益提现，每日免费一次，超出一次后每笔2元；无投资纪录按提现金额的0.6%收取且每笔加收2元，且单笔最低收取5元。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">什么情况下钱会退回充值原卡？退回原卡何时到账？</div>
        <p>下列几种情况，款项将会退回充值原卡：<br>
1、利用百富网进行套现、洗钱、匿名转账，对于频繁的非正常投资为目的的资金充提行为，一经发现，百富网将通过原充值渠道进行资金清退；<br>
2、第三方支付充值具有匿名性，充值后未用于投资的提现申请金额，将视情况通过第三方支付平台退回原卡；<br>
3、恶意重复操作，或申请中的提现记录超过3笔（含），将根据历史提现记录来进行提现转账或转入退款；<br>
4、申请提现的充值未投资资金累计达到反洗钱审查限额；资金通过第三方支付原路清退；<br>
注：2周内有3笔（含）及以上退款，系统将暂缓您的充值功能
 
百富网提交充值订单退款申请后，因第三方支付机构与发卡银行结算需要，通常2-7工作日后资金方可退达充值银行卡（或第三方支付账户）；
若退款金额超过反洗钱审查上限，第三方支付机构可能要求持卡人提供信息以供核对，具体到账时间请以发卡行结算为准。
注：若充值银行卡状态异常，造成的到账延迟请持卡人自行承担、解决。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="15">百富网有哪些理财产品？</div>
        <p>百富网的理财产品有天天富、年年富、月月富，月月富T。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="z2">如何进行投资？</div>
        <p>按照以下步骤进行投资：<br>
1、在百富网上注册、通过实名认证、成功绑定手机、银行卡；<br>
2、点击"我的百富"页面的"充值"按钮给账户充值；<br>
3、点击"我要投资"浏览投资项目列表；<br>
4、选择购买所需的投资项目。月富。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="z3">投资人是否需要支付费用？</div>
        <p>投资人在百富网充值、投资不需支付任何费用。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">投资人的本金和收益是否可以得到保障？</div>
        <p>是的，目前百富推出的年年富、月月富、天天富、月月富T项目都是由合作机构100%本息担保，保障投资者利益。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">最低多少钱可以投资？</div>
        <p>月月富、月月富T、年年富最小起投资金额为100元起，100元的整数倍递增；<br>
天天富最小起投单位为1元，以1元的整数倍递增；</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">你们是如何做到预期收益的？</div>
        <p>预期收益按照不同产品计算方式是不同的，具体看哪款产品。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">投标后能否撤销？</div>
        <p>投标后资金进入冻结期，是不可以撤销的。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">投资人什么时候开始计算收益？</div>
        <p>天天富产品按翌日0点起息，以天为单位，小于1天的不记；<br>
月月富产品按投资人、合作机构的起息在标的成立当日，同时协议生效当日开始起息；<br>
月月富T产品按隔日计息；<br>
年年富按标的成立隔日起息（当日00：00）；<br>
天天富计息举例：如1月1日投资，1月2日开始计息，1月3日账户中显示1月2日的利息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="16">投资后是否可以提前赎回？</div>
        <p>目前网站所有产品都可以提前赎回，但需要支付本金2%手续费（天天富可以随时赎回，无手续费）。</p>
        <div class="gotop"></div>
      </div>
      
      <div class="content_box">
        <div class="content_box_h">项目投资成功后如何赎回？</div>
        <p>投资人可在"我的百富"下的"我的理财"页面选择您投资的项目点击赎回持有的投资项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">购买产品后多久可以赎回？</div>
        <p>天天富产品随时可以赎回；<br>
月月富、月月富T会有5个工作日锁定期，5个工作日后可赎回；<br>
年年富会有10个工作日锁定期，10个工作日后可赎回；</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">赎回手续费怎么收取?</div>
        <p>提前赎回按投资本金2%收取手续费。（天天富可以随时赎回，无手续费）</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">申请赎回后是否可以取消？</div>
        <p>在赎回审核状态中可以取消，但成功赎回后无法取消。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="17">公司简介</div>
        <p>百富金融集团（Baifu Finance Group）由正大中国投资总经理唐田博士创立于上海。百富专注于智能网络资讯、网络金融及资产管理领域，致力于发展为中国领先的网络金融服务商。唐田博士将泰国正大集团“普惠于民”的企业经营理念引入国内金融服务市场，以“关注用户终身价值”为己任，以新互联网技术推动网络金融服务市场的进步，为广大的互联网用户，创造可信赖的“财富生活”。<br>
百富网（<a href="http://www.biifoo.com">www.biifoo.com</a>）是百富集团旗下网络金融服务平台及独立品牌，在第三方金融服务、网络资讯、网络社交等领域充分创新，为广大用户创造价值和极致体验，致力于发展为中国最具影响力的互联网金融信息服务平台。2014年11月底，百富网成功获得由沿海基金领投的千万级天使投资。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="19">什么是年年富？</div>
        <p>年年富是百富网推出的由合作机构100%本息担保的融资项目进行自动投资的理财服务。投资人投资的本金加利息之和将在投资期内每月等额返还，至产品到期。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年年富产品起投金额是多少？</div>
        <p>年年富产品起投金额是50元以上整数，单个产品最高投资5万元。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年年富产品的收益是多少？</div>
        <p>年年富项目年化收益率在11.30%--12.30%不等，具体收益率可参考网站上线项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年年富什么时候可以购买？</div>
        <p>年年富产品T-3启动认购。即发标日后3天为认购期。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">购买年年富何时计算？</div>
        <p>年年富产品是翌日起息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年年富可以中途赎回吗？</div>
        <p>年年富产品中途可以赎回，但需要支付投资本金的2%手续费。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年年富提前赎回收费吗？</div>
        <p>年年富产品中途赎回需要支付投资本金的2%手续费。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">年化利率是如何定的？</div>
        <p>年化利率是与百富网合作的机构根据自身的经营模式结合市场规定，结合百富的风控体系所确定的。该利率即有足够的市场吸引力又能保证实体企业健康运营成长。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">为什么在百富网投资年年富的实际收益率比公布的年化利率低？</div>
        <p>百富网公布的"年化利率"并非"年化收益率"。为了提高投资人的资金流动性和降低投资风险，年年富项目采用的是"等额本息"的还款方式，投资人每期都有资金回笼。
用以计算收益率的本金并不是固定的初始本金，投资者的借出本金随着借款人每期的还款逐渐减少。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">收到还款后可以马上再投资吗？</div>
        <p>可以，实际上我们建议您在收到回款后及时地进行再次投资，确保收益最大化。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="20">什么是月月富？</div>
        <p>月月富是百富网推出的由合作机构100%本息担保的融资项目进行自动投资理财服务。投资人投资的本金将在到期日一次性返回其账户，利息收益每月返还。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富产品起投金额是多少？</div>
        <p>月月富产品起投金额是100元起，且以100元的倍数递增，每天X笔数限制。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富产品的收益是多少？</div>
        <p>月月富项目产品的收益范围：6.2%--12.3%。具体收益率可参考网站上线项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富什么时候可以购买？</div>
        <p>月月富产品：T-3启动认购，认购期3天，周末不定时发标。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">购买月月富何时计算？</div>
        <p>投资人、合作机构的起息在标的成立当日，同时协议生效当日开始起息</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富可以中途赎回吗？</div>
        <p>月月富可以提前赎回，提前赎回手续费为本金的2%。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富提前赎回收费吗？</div>
        <p>月月富提前赎回手续费为本金2%。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富的付息方式是？</div>
        <p>月月富的付息方式是按月付息，到期还本。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">提前赎回如何操作？</div>
        <p>可以在“我的百富”中找到相应赎回按钮进行赎回操作。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富提前赎回到账时间？</div>
        <p>工作时间操作当天可以到您的百富网账户中。如非工作时间操作将再第二天到您的百富网账户中。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富还款时间？</div>
        <p>还款时间从计算收益时间开始计算，每过一个月支付一次收益，期限结束时返还本金。还款时间不提前不顺延。年年富到期后最晚3个工作日内（含3个工作日），甲方将乙方购买的月月富的本金返还至乙方的百富网账户。超过年年富到期日的，则按日计息，甲方将在返还本金时将上述利息一并返还。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富还款时间？</div>
        <p>还款时间从计算收益时间开始计算，每过一个月支付一次收益，期限结束时返还本金。还款时间不提前不顺延。年年富到期后最晚3个工作日内（含3个工作日），甲方将乙方购买的月月富的本金返还至乙方的百富网账户。超过年年富到期日的，则按日计息，甲方将在返还本金时将上述利息一并返还。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="n1">什么是月月富T？</div>
        <p>月月富T是百富网为用户严格甄选的优质融资项目，融资范围为金融资产质押的债权项目，资金安全、收益稳健，资源有限，不定期开抢，金融资产由授牌优秀金融机构管理。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富T的收益率是多少？</div>
        <p>月月富T产品的年化收益率为：6.2%-9.1%之间，具体收益率可参考网站上线项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富T的付息方式是？</div>
        <p>月月富T的付息方式是按天计息（复利），到期还本付息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富T的何时计息？</div>
        <p>月月富T产品是翌日计息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富T的起投金额是多少？</div>
        <p>月月富T产品的投资金额为100元起，且以100元的倍数递增。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">月月富T是否可以提前赎回？</div>
        <p>月月富T产品可提前赎回，但提前赎回需要收取本金的2%做为手续费。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="n2">什么是天天富？</div>
        <p>天天富是百富网推出的由合作机构100%本息担保的收益权项目进行自动投资及定时自动转让的理财服务。投资所得的利息将在每日返回其账户，利息收益按日累积计算，本金在赎回后一次性返回账户。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富的起投资金需要多少？</div>
        <p>1元起，以1元的整数倍递增，若当天收益不足1分钱，系统不会自动分配收益，也不回累加。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富是如何认购的？</div>
        <p>天天富是即时认购，即时成立，隔日起息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富的付息方式是？</div>
        <p>天天富产品是按日计息，到期还本息。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富的收益率是多少？</div>
        <p>天天富产品的年化收益率为：8%。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富产品什么时候可以赎回？</div>
        <p>天天富产品可以根据投资人的要求进行赎回，支持随时转出。并且天天富产品赎回都是免费的。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">天天富产品资金是否有保障？</div>
        <p>是的，天天富产品是由合作机构提供100％本息担保的收益权项目。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="21">百富网是什么？</div>
        <p>百富网（<a href="http://www.biifoo.com">www.biifoo.com</a>）是百富集团旗下网络金融服务平台及独立品牌，在第三方金融服务、网络资讯、网络社交等领域充分创新，为广大用户创造价值和极致体验，致力于发展为中国最具影响力的互联网金融信息服务平台。2014年11月底，百富网成功获得由沿海基金领投的千万级天使投资。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="z1">百富网的模式？</div>
        <p>百富构建的网络金融体系专注于“Peer To Finance”模式，以成熟的信用体系为基础，透过互联网技术创新使得更多普通用户有机会享用金融服务，提升传统金融机构的服务覆盖面和效率。
目前P2F是最安全的一种模式，融资人是正规银行、证券、保险等金融机构，金融机构具有完整的风控措施，能够保证资金的安全和收益的稳定。安全性远高于一般的P2P、P2B类产品。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">百富网具体的投资方是？</div>
        <p>百富网成功获得由沿海基金领投的千万级天使投资。沿海基金是沿海控股集团旗下私募股权投资基金，主要投资于商业地产、基础设施、保障房等领域，截至2014年6月，沿海基金团队已成功为超过100亿等值人民币的房地产投资及资产管理业务提供服务。2014年起沿海基金进入互联网、创新金融服务等新兴产业。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="x1">如何保证我的资金安全？</div>
        <p>资金安全：百富网推荐的投资项目均是由合作小额贷款机构推荐的本息安全有保障的项目，充分保障投资人本金及投资收益。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何保证我的数据安全？</div>
        <p>数据安全： 三层防火墙隔离系统的访问层、应用层和数据层集群；有效的入侵防范及容灾备份，确保交易数据安全无虞。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">如何保证我的隐私安全？</div>
        <p>隐私安全：百富网在任何情况下都绝不会出售、出租或以任何其他形式泄漏您的信息。您的信息按规定被严格保护。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="n3">本金和收益是否可以得到保障？</div>
        <p>百富网推荐的投资项目均是由合作机构推荐的100%本息安全有保障的项目，且有充足的增信资产作为质押，充分保障投资人本金及投资收益。<br>
另外：<br>
1. 首创IIF（独立互联网金融）模式，规避关联交易。<br>
2. 对接成熟信用体系，从源头上把好安全关。<br>
3. 落实监管风控，在机制上拒绝不良资产。<br>
4. 引入准备金制度，确保用户资金万无一失。<br>
5. 卓越的资质，获得金融信息服务业务资格的互联网金融企业，业务资质行业领先。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h" id="22">忘记登录密码怎么办？</div>
        <p>在登录页面选择“忘记登录密码”进行重置，但需要用户已经绑定过邮件。</p>
        
      </div>
      
      <div class="content_box">
        <div class="content_box_h">忘记交易密码怎么办？</div>
        <p>1、登录百富网“我的百富”，在“账户认证”中通过手机验证码，重新设置交易密码。<br>
2、如果无法自行找回交易密码，可以发送您的用户名和身份证正反面照片到客服邮箱：<a href="mailto:kefu@baifu360.com">kefu@baifu360.com</a> ，并在照片上注明“仅用于百富网注销交易密码使用”。
收到邮件后我们会提交后台帮您把交易密码注销，注销完成后您会收到邮件提醒。</p>
       
      </div>
      
      <div class="content_box">
        <div class="content_box_h">手机收不到验证码怎么办？</div>
        <p>因工信部管制垃圾短信，现各手机运营商都在对106短信网关号段进行品牌改造和升级，造成暂时收不到短信验证码或接收验证码延迟。</p>
        
      </div>
      
    </div>
    
    
    
  </div>
</div></div>
<jsp:include page="../footer.jsp"/>
<script src="${ctx}/static/js/amazeui.js"></script>
</body>
</html>
