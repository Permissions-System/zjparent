<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<c:choose>
<c:when test="${empty map.bidtypeid }">
<title>P2P高收益理财产品，互联网理财，专业个人投资理财网站 - 百富网小额投资理财平台</title>
<meta name="keywords" content="网络理财产品，个人理财投资，个人投资理财网，高收益的网络理财产品，高收益互联网理财，p2p高收益理财产品，短期理财产品，高收益理财产品，高收益理财">
<meta name="description" content="百富网是一家专业的个人投资理财网，为您提供高收益网络理财产品，短期理财产品，P2P高收益理财产品等小额理财方式。一元起投，随时赎回，为有理财需求的投资人提供安全、有担保、高收益的互联网理财服务。">
</c:when>
<c:when test="${map.bidtypeid == 4}">
<title>小额短期理财产品，小额信托理财，小额信贷理财平台 - 百富网小额投资理财平台</title>
<meta name="keywords" content="小额理财产品，小额短期理财产品，小额信托，短期小额理财产品，小额信托理财，小额信贷理财">
<meta name="description" content="百富网专注于小额短期理财、小额信托理财、小额信贷理财等新兴的互联网金融理财产品。一元起投，随时赎回，资金由新浪支付全程托管，投资安全又灵活，专有的33道防火墙最大程度保证投资人的利益。">
</c:when>
<c:when test="${map.bidtypeid == 3}">
<title>低风险P2P个人理财，家庭小额理财，个人家庭专户理财产品 – 百富网小额投资理财平台</title>
<meta name="keywords" content="家庭理财，个人家庭理财， p2p家庭理财，家庭小额理财，低风险理财，专户理财">
<meta name="description" content="百富网为您提供P2P个人理财，P2P家庭理财，家庭小额理财，专户理财等低风险个人家庭理财产品。资金由新浪支付全程托管，1元起投，随时赎回，投资安全又灵活。">
</c:when>
<c:when test="${map.bidtypeid == 1}">
<title>P2P高收益理财，P2F信托理财产品，专业的P2F小额信贷平台 – 百富网小额投资理财平台</title>
<meta name="keywords" content="p2p理财，信托理财产品，p2p信贷平台，p2p金融理财产品，p2p高收益理财">
<meta name="description" content="百富网是一家为您提供低风险高收益的P2P金融理财产品，信托理财产品的专业P2P信贷平台。百富网拥有33道防火墙，1元起投，随时赎回，最大程度保证投资人的利益。">
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>
<%@include file="../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/banner01.jpg);
	background-position: center;
}


.classic {
	width:1000px;
	height:50px;
	margin-top: 20px;
	margin-left:auto;
	margin-right:auto;
}

div.black2 {
	font-family: "Myriad Pro";
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 10px;
	margin: 3px;
	padding-top: 10px;
	text-align: right;
	float: left;
	width: 935px;
	font-size: 16px;
}
div.black2 a {
	padding-right: 8px;
	padding-left: 8px;
	padding-bottom: 5px;
	margin: 2px;
	color: #565A5C;
	padding-top: 5px;
	text-decoration: none;
	border: 1px solid #565A5C;
}
div.black2 a:hover {
	color: #fff;
	background-color: #666;
	border: 1px solid #565A5C;
}
div.black2 a:active {
	color: #fff;
	background-color: #666;
	border: 1px solid #565A5C;
}
div.black2 span.current {
	padding-right: 8px;
	padding-left: 8px;
	font-size: 16px;
	padding-bottom: 5px;
	margin: 2px;
	color: #fff;
	padding-top: 5px;
	background-color: #565A5C;
	border: 1px solid #565A5C;
}
div.black2 s.disabled {
	border-right: #eee 1px solid;
	padding-right: 8px;
	border-top: #eee 1px solid; 
	padding-left: 8px;
	padding-bottom: 5x;
	margin: 2px;
	border-left: #eee 1px solid;
	color: #ddd;
	padding-top: 5px;
	border-bottom: #eee 1px solid
}
.titlename a{
	text-decoration:none; 
	color:#8F9496;
}

.titlename a:hover{
	color:#1E9ED5;
}

.company a{
	text-decoration:none; 
	color:#8F9496;
}

.company a:hover{
	color:#1E9ED5;
}
</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
		$("#invest_check").attr("class","current");
	});

</script>


</head>

<body>
<jsp:include page="headerV2.jsp"/><!--网站logo 导航条  end-->
<div class="banner">
</div>
<div style="width:100%;min-width:1200px;">
<div class="hh1">全部产品</div>
<div class="goods">
	<input type="hidden" id="bidtypeid" value="${map.bidtypeid }"/>
	<input type="hidden" id="investperiod" value="${map.investperiod }"/>
	<input type="hidden" id="annualizedrate" value="${map.annualizedrate }"/>
	<input type="hidden" id="raisestate" value="${map.raisestate }"/>
	<input type="hidden" id="pageNow" value="1"/>
  <div class="lableclass"><table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="15" colspan="14">&nbsp;</td>
    </tr>
  <tr>
    <td width="39" height="25">&nbsp;</td>
    <td width="118" style=" text-align:left">产品类型：</td>
    <td width="70" <c:if test="${map.bidtypeid == '' || map.bidtypeid == null}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.bidtypeid == '' || map.bidtypeid == null}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue('','bidtypeid')">全部</a></td>
    <td width="15">&nbsp;</td>
    <c:forEach items="${bidType}" var="b">
    <c:if test="${b.key ne 2}">
    <td width="70" <c:if test="${map.bidtypeid == b.key}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.bidtypeid == b.key}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(${b.key},'bidtypeid')">${b.value}</a></td>
    <td width="15">&nbsp;</td>
    </c:if>
    </c:forEach>
    </tr>
  <tr>
    <td height="15" colspan="14">&nbsp;</td>
    </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td style="text-align:left">投资期限：</td>
    <td <c:if test="${map.investperiod == ''|| map.investperiod == null}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == ''|| map.investperiod == null}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue('','investperiod')">全部</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.investperiod == 1}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == 1}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(1,'investperiod')">1个月以内</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.investperiod == 2}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == 2}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(2,'investperiod')">1~3个月</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.investperiod == 3}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == 3}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(3,'investperiod')">3~6个月</a></td>
    <td>&nbsp;</td>
    <td width="70" <c:if test="${map.investperiod == 4}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == 4}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(4,'investperiod')">6~12个月</a></td>
    <td width="15">&nbsp;</td>
    <td width="70" <c:if test="${map.investperiod == 5}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.investperiod == 5}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(5,'investperiod')">12个月以上</a></td>
    <td width="195">&nbsp;</td>
  </tr>
  <tr>
    <td height="15" colspan="14">&nbsp;</td>
  </tr>
  <tr>
    <td height="27">&nbsp;</td>
    <td style="text-align:left">预期收益：</td>
    <td <c:if test="${map.annualizedrate == ''|| map.annualizedrate == null}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.annualizedrate == ''|| map.annualizedrate == null}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue('','annualizedrate')">全部</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.annualizedrate == 1}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.annualizedrate == 1}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(1,'annualizedrate')">6.5%以下</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.annualizedrate == 2}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.annualizedrate == 2}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(2,'annualizedrate')">6.5%-9.1%</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.annualizedrate == 3}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.annualizedrate == 3}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(3,'annualizedrate')">9.1%-12%</a></td>
    <td>&nbsp;</td>
    <td <c:if test="${map.annualizedrate == 4}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.annualizedrate == 4}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(4,'annualizedrate')">12%以上</a></td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td height="15" colspan="14">&nbsp;</td>
  </tr>
  <tr>
    <td height="25">&nbsp;</td>
    <td style="text-align:left">募集状态：</td>
    <td height="27" <c:if test="${map.raisestate == ''|| map.raisestate == null}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.raisestate == ''|| map.raisestate == null}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue('','raisestate')">全部</a></td>
    <td height="27">&nbsp;</td>
    <td height="27" <c:if test="${map.raisestate == 1}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.raisestate == 1}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(1,'raisestate')">预购中</a></td>
    <td height="27">&nbsp;</td>
    <td height="27" <c:if test="${map.raisestate == 2}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.raisestate == 2}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(2,'raisestate')">认购中</a></td>
    <td height="27">&nbsp;</td>
    <td height="27" <c:if test="${map.raisestate == 3}"> bgcolor="#009CE4" style="color:#FFF "</c:if> ><a <c:if test="${map.raisestate == 3}"> style="color:#fff;"</c:if> href="javascript:jump()" onclick="putValue(3,'raisestate')">已售罄</a></td>
    <td height="27">&nbsp;</td>
    <td height="27">&nbsp;</td>
    <td height="27">&nbsp;</td>
    <td height="27">&nbsp;</td>
    <td height="27">&nbsp;</td>
  </tr>
  </table>
</div>
<c:forEach items="${page.results}" var="bid" varStatus="status">
  <div class="lableclass2">
    <a <c:if test="${bid.bidstatus ne 4}">href='bidDetail.do?id=${bid.id}'</c:if> <c:if test="${bid.bidstatus eq 4}">href='attention.do'</c:if>>
    <div class="pro1"><img src="${ctx}${bid.bidimg}" width="276" height="236"/></a></div>
    <div class="pro_content">
      <c:if test="${bid.bidtypeid ne 4 }"><div style="position: absolute; left:128px; top: 45px;"><img src="${ctx}/static/images/tz.png"  alt=""/></div></c:if>
      <div class="titlename"><a <c:if test="${bid.bidstatus ne 4}">href='bidDetail.do?id=${bid.id}'</c:if> <c:if test="${bid.bidstatus eq 4}">href='attention.do'</c:if> >${bid.bidclassname}<c:if test="${bid.investordercode != null}"><img src="${ctx}/static/images/zhuan.jpg" /></c:if></a></div>
      <div class="company"><c:if test="${bid.bidtypeid eq 3 }"><div onclick="monthT(this,'${bid.pledgetype}')" class="monthT">　</div></c:if></div>
      <c:if test="${bid.raisestate eq 3 || (bid.amount - bid.raisemoney) le 0}"><div class="mark"></div></c:if>
      <div class="money">  
        <div class="year">
          <div class="year_stlye1">年化收益率</div>
          <div class="year_style2"><fmt:formatNumber type="number" value="${bid.annualizedrate}" maxFractionDigits="2" minFractionDigits="2"/><span style="font-size:20px"> %</span></div>
        </div>
        <div class="time">
          <div class="time_stlye1">期限</div>
          <div class="time_stlye2">
          	<c:if test="${bid.investperiodtypeid eq 1 && bid.bidtypeid ne 4}"><fmt:formatNumber type="number" value="${bid.investperiod}" maxFractionDigits="0"/>天</c:if>
          	<c:if test="${bid.investperiodtypeid ne 1 && bid.bidtypeid ne 4}"><fmt:formatNumber type="number" value="${bid.investperiod}" maxFractionDigits="0"/>个月</c:if>
          	<c:if test="${bid.bidtypeid eq 4 }">活期</c:if></div>
        </div>
        <div class="totalmoney" >
          <div class="totalmoney_stlye1">剩余额度</div>
          <div class="totalmoney_stlye2">${bid.amount - bid.raisemoney }</div>
        </div>
        <div class="restmoney">
          <div class="restmoney_stlye1">产品特色</div>
          <div class="restmoney_stlye2" style="width: 70px;margin-left: 24px;">${bid.remark}</div>
        </div>
      </div>
      <div class="tips">100%本息担保<c:if test="${bid.assureinstname!=null}">：${bid.assureinstname}</c:if>
      </div>
    </div>
    <div class="progress" style="position:relative;">
    	<div style="position:absolute; top:80px; font-size:13px; width:155px; text-align:center; color:#999">投资进度</div>
     	<div id="circle" class="circle" onclick='percent(this,<c:if test="${bid.investordercode == null && bid.amount ==0}">0</c:if><c:if test="${bid.investordercode == null && bid.amount >0}">${bid.raisemoney*100/bid.amount}</c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='2'}">0</c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='3'}">100</c:if>)'></div>
      
        <c:choose> 
        <c:when test="${bid.raisestate == 1 }"><a href="bidDetail.do?id=${bid.id}"> <div class="buy"  >即将开始</div></a></c:when>  
        <c:when test="${bid.raisestate == 2 }"> <a href="bidDetail.do?id=${bid.id}">
      											<div class="buy">立刻投资 </div></a> </c:when> 	  
        <c:when test="${bid.raisestate == 3 }"> <a  <c:if test="${bid.bidstatus ne 4}">href='bidDetail.do?id=${bid.id}'</c:if> <c:if test="${bid.bidstatus eq 4}">href='attention.do'</c:if>><div class="buy"  style=" position:absolute; z-index:99;left:28px;top:120px ;border-bottom-color: #a1acb4">查看详情</div></a></c:when>  
    	</c:choose> 
      <div class="ltd" style="position:absolute;left:20px;top:170px">投资多多，赚钱多多</div>
    </div>
  </div>
  </c:forEach>

<div class="classic"><div class="black2">
<!-- 判断是不是第一页决定是否显示前一页标签 -->
		<c:if test="${page.pageNow le 1 }">
			<span> &lt;&nbsp;&nbsp;</span>
		</c:if>
		<c:if test="${page.pageNow gt 1 }">
			<a href="javascript:jump()" onclick="putValue(${page.pageNow - 1},'pageNow')"> &lt;</a>
		</c:if>
		<c:if test="${page.pageNow > 4}">
			<a href="javascript:jump()" onclick="putValue(1,'pageNow')">1</a>
			<span>. . .</span>
		</c:if>
		<!-- 从action中获取分页页码下表的开始和结束下标 -->
		<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
			<c:if test="${page.pageNow eq i }">
				<span class="current">${i}</span>
			</c:if>
			<c:if test="${page.pageNow ne i }">
				<a href="javascript:jump()" onclick="putValue(${i},'pageNow')">${i}</a>
			</c:if>
		</c:forEach>
		<c:if test="${(page.totalPageCount-page.pageNow) >= 4}">
			<span>. . .</span>
			<!-- 显示尾页下标 -->
			<a href="javascript:jump()" onclick="putValue(${page.totalPageCount},'pageNow')">${page.totalPageCount}</a>
		</c:if>
		<!-- 判断是不是最后一页，决定是否显示后一页下标-->
		<c:if test="${page.pageNow lt page.totalPageCount }">
			<a href="javascript:jump()" onclick="putValue(${page.pageNow + 1},'pageNow')"> > </a>
		</c:if>
		<c:if test="${page.pageNow ge page.totalPageCount }">
			<span>&nbsp;&nbsp; > </span>
		</c:if>
	</div></div></div>
<jsp:include page="footerV2.jsp"/>
</body>
<script type="text/javascript">
window.onload=function(){
	$('.circle').trigger("click");
	$('.totalmoney_stlye2').trigger("click");
	$('.monthT').trigger("click");
}

function monthT(dom,pledgetype){
	var type=""+pledgetype;
	var html='';
	if(type.indexOf("0")!=-1){
		html+='<span class="am-icon-check-square-o" style="color:#009CE4"></span> 资产质押 ';
	}
	if(type.indexOf("1")!=-1){
		html+='<span class="am-icon-check-square-o" style="color:#009CE4"></span> 股权质押 ';
	}
	dom.innerHTML=html;
}

//客户端倒计时方式
/* function showtime(dom,time,id) { 
	var flag="";
	var data="";
	var now=new Date();
	var nMS=time-now.getTime();
	
	if(nMS>0){
 		var nD = Math.floor(nMS/(1000 * 60 * 60 * 24)); 
		var nH= (Math.floor(nMS/(1000*60*60)) % 24); 
		var nM= (Math.floor(nMS/(1000*60)) % 60); 
		var nS= (Math.floor(nMS/1000) % 60); 
		data= nD+"天"+nH+"小时"; 
		dom.innerHTML=data;
		setTimeout(function()
				{showtime(dom,time,id);}, 3600000); 
	}else {
		window.location="timeCountDown.do?id="+id;
	}
 
} */
	
	
 function percent(object,num){

	function loadImg (data){
			var i = 0;
			setInterval(function(){
				i++
				if(i>data){
					i=data
				}
				var imgLeft = -(i*104+(i*9))+'px'
				object.style.backgroundPosition = imgLeft+'\t'+'0px'
				object.innerHTML = i+'%';
			},15)
	
	}
	num=Math.floor(num);
	var result=(num).toFixed(0); 
	loadImg(result)
 }
</script>
<script type="text/javascript">
function putValue(domValue,selectValue){
	$("#"+selectValue).attr("value",domValue);
}

function jump(){
	var bidtypeid=$("#bidtypeid").attr("value");
	var investperiod=$("#investperiod").attr("value");
	var annualizedrate=$("#annualizedrate").attr("value");
	var raisestate=$("#raisestate").attr("value");
	var pageNow=$("#pageNow").attr("value");
	window.location='queryBidAll.do?bidtypeid='+bidtypeid+'&investperiod='+investperiod+
			'&annualizedrate='+annualizedrate+'&raisestate='+raisestate+'&pageNow='+pageNow;
}
</script>
</html>
