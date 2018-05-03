<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<%@include file="header.jsp"%>
<meta charset="utf-8">
<!--[if lte IE 8]>浏览器版本过低，请更新您的浏览器！<![endif]-->
<title>百富网-智富人生</title>
<link href="${ctx}/static/preview/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/preview/css/banner.css" />
<link href="${ctx}/static/preview/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/preview/css/detail.css" rel="stylesheet" type="text/css">
<style type="text/css">
.classic {
	width:900px;
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
	width: 850px;
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

</style>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/preview/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript">  
$(document).ready(function(){
	var min = 5;
	var max = parseInt($("#lastmoney").val())/$("#mininvestamount").val();
	
	if(max < min){
	min = max;
	}
	$("#add").val(min);
// 	$("#add").blur(function(){
// 		if(max > parseInt($("#bidnum").val())){
// 			max = $("#bidnum").val();
// 		}
// 		if(parseInt($("#add").val())>max){
// 			$("#add").val(max);
// 		}
// 		if(parseInt($("#add").val())<min){
// 			$("#add").val(min);
// 		}
// 		if(max < min){
// 			$("#add").val(max);
// 		}
// 		var ss= /^\d+$/;
// 		if(!ss.test($("#add").val())){
// 			$("#add").val(min);
// 		}
// 		showmoney();
// 	});
//       $("#add1").click(function(){  
//       var oldValue=parseInt($("#add").val()); //取出现在的值，并使用parseInt转为int类型数据  
//       if(max > parseInt($("#bidnum").val())){
// 			max = $("#bidnum").val();
// 		}
//       if(oldValue < max)
//       	oldValue++;   //自加1  
//       $("#add").val(oldValue)  //将增加后的值付给控件
//       showmoney();
// });  
// $("#redu").click(function(){  
//       var oldValue=parseInt($("#add").val()); //取出现在的值，并使用parseInt转为int类型数据
//       if(oldValue > min){
//       	oldValue--   //自减1  
//       }
//      $("#add").val(oldValue)  //将增加后的值付给控件  
//      showmoney()
// });  

function showmoney(){
 	 $("#buymoney").html("");
     var money = parseInt($("#add").val()*$("#mininvestamount").val());
     $("input[name=buymoney]").val(money);
     $("#buymoney").html($.format.number(money, '###,###.##'));
     $("#exceptmoney").html("");
     $("#exceptmoney").html($.format.number(money*$("#annualizedrate").val()/100, '###,###.##'));
}
showmoney();
 
function ajaxPost(url,dataParam,callback){  
	 var retData=null;  
	 $.ajax({   
	     type: "post",  
	     url: url,   
	     data: dataParam,  
	     dataType: "json",    
	     success: function (data) {  
	        retData=data;  
	        if(callback!=null&&callback!=""&&callback!=undefined)  
	            callback(data,status);   
	    },  
	    error: function (data) {
	    	console.info(data);
// 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
	    }    
	});        
	     return retData;  
	}  
   
			
   var  param = {id : $("#id").val()};
   //担保机构Tab
	$("#d2").on("click",function(){
		orgTab();
		});
	
	$("#sctx").click(function(){
		$("#dbjg").attr("checked","checked");
		orgTab();
	});
	if($("#org").val()==1){
		$("#d2").trigger("click");
	}
	var  param = {id : $("#id").val()};
	function orgTab(){
		ajaxPost("previewOrg.do", param, function(data){
			console.info(data);
			$("#td1 img").attr("src","${ctx}/"+data.instlogo);
			$("#td2").html("");
			$("#td2").append(data.instdesc);
			$("#td3 img").attr("src","${ctx}/"+data.agreementimg);
		});
	}
});  
</script>  


<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
</script>
<script type="text/javascript">
    jQuery (function ($)
    {
        $ ('div.tab-content').children ('div:gt(0)').hide ();
        $('a').attr('hidefocus', 'true');
        $ ('div.tab-title ul li').click (function ()
        {
            $(this).addClass('current').siblings('li[class="current"]').removeClass('current');
            $ ('div.tab-content').children ('div:eq(' + $ (this).index ('div.tab-title ul li') + ')')
                                    .show().siblings('div').hide();
        });
    });
</script>

</head>
<div class="top_1"><!--顶部扫微信 登录 注册   start-->
  <div class="top_wrap">
  	<p class="pa">关注我们</p>
    <div class="top_img"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image12','','${ctx }/static/preview/images/icon_weibo.fw.png',1)"><img src="${ctx }/static/preview/images/icon_weibo.png" alt="" width="21" height="21" id="Image12"></a> </div>
    <div class="top_img"><a class="tooltip" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image13','','${ctx }/static/preview/images/icon_wechat.fw.png',1)"><img src="${ctx }/static/preview/images/icon_wechat.png" alt="" width="21" height="21" id="Image13"></a></div>
    <p class="pb">登 录　注 册</p>
  </div>
</div><!--顶部扫微信 登录 注册  end-->


<div class="nav"><!--网站logo 导航条   start-->
  <div class="nav_wrap">
    <div class="logo"><a href="#"><img src="${ctx }/static/preview/images/biifoo_logo.png" alt="biifoo logo"/></a></div>
    <div class="navi">
      <ul>
        <li>&nbsp;首　页&nbsp;</li>
        <li>我要投资</li>
        <li>服务专区</li>
        <li>安全保障</li>
        <li>我的百富</li>
      </ul>
    </div>
  </div>
</div>
<body onLoad="MM_preloadImages('${ctx}/static/images/weibo2.png','${ctx}/static/images/wechat2.png')">
<jsp:include page="header.jsp"/><!--网站logo 导航条  end-->
<div class="subnav">首页 &gt; 我要投资 &gt; 定存宝 &gt; 定存宝详情</div><!-- 面包屑  -->
<div class="detail_content">
  <div class="detail_tleft">
    <div class="detail01"><span class="detail_style01"><c:out value="${bid.bidclassname}"/> ${bid.bidcode}</span><span class="detail_style02" ><img src="${ctx}/static/preview/images/shield.jpg" alt=""/> <a href="#d2"><span id="sctx">担保公司：${bid.assureinstname}</span></a></span></div>
    <div class="detail02"><span class="detail_style03">产品说明：</span><br>
<c:out value="${bid.bidclasssubject}"/></div>
    <div class="detail03">
      <div class="detail03_column">融资金额<br>
        <span class="detail_style04">&yen; <fmt:formatNumber value="${bid.amount}" type="number" maxFractionDigits="2"/></span><br>
      <br>计息日期<br><fmt:formatDate value="${bid.exptinterestdate}" pattern="yyyy-MM-dd"/></div>
      <div class="detail03_column">投资期限<br><span class="detail_style04"><c:if test="${bid.investperiod != null}"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bid.investperiod}"/>个月</c:if></span><br><br>资金到账日<br>
      <fmt:formatDate value="${bid.exptlastacctdate}" pattern="yyyy-MM-dd"/></div>
      <div class="detail03_column1">年化率<br><span class="detail_style05"><c:if test="${bid.annualizedrate != null}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.annualizedrate}" />%</c:if></span><br><br>还款方式<br><c:forEach items="${repaymentway}" var="rep">
               <c:if test="${bid.repaymentway == rep.key}">
               	${rep.value}
               	</c:if>
               </c:forEach></div>
</div>
    <div class="detail04"><strong>备注：</strong><br>
<c:out value="${bid.remark}"/></div>
  </div>
  <form action="success.do" method="post" id="myform">
  <input type="hidden" id="id" name="id" value="${bid.id}"/>
<input type="hidden" id="bidCode" name="bidCode" value="${bid.bidcode}"/>
<input type="hidden" name="raisemoney" value="${bid.raisemoney}"/>
<input type="hidden" name="amount" value="${bid.amount}"/>
<input type="hidden" name="buymoney" value=""/>
<input type="hidden" name="memberid" value=""/>
<input type="hidden" name="membername" value=""/>
<input type="hidden" name="restmoney" value=""/>
  <div class="detail_tright">
    <div id="circle"><div id="circle2" value="${bid.raisemoney/bid.amount*100}"></div><script type="text/javascript">
window.onload = function(){

	var object = document.getElementById('circle2')
	function loadImg (data){
			var i = 0;
			setInterval(function(){
				i++
				if(i>data){
					i=data
				}
				var imgLeft = -(i*147+(i*9))+'px'
				object.style.backgroundPosition = imgLeft+'\t'+'0px'
				object.innerHTML = i+'%';
			},15)
	
	}
	var result = $("#circle2").attr("value");
	loadImg(parseInt(result).toFixed(0))
}
</script></div>
    <div class="rest">剩余金额：￥<span><fmt:formatNumber value="${bid.amount-bid.raisemoney}" type="number" maxFractionDigits="2"/></span></div>
    <div class="add">
    <img src="${ctx}/static/preview/images/001.jpg" style="float:left;"   alt=""/>
    <input id="add" type="text" name="add" /><div style="font-size:16px; float:left; margin-top:12px; margin-left:5px; font-family:'微软雅黑';">份</div>
<div style="margin-top: 3px; margin-left:10px; width: 24px; float:left;"><span id="add1"><img  style="margin-bottom:5px;" src="${ctx}/static/preview/images/add.jpg" alt=""/></span>
<span id="redu"><img src="${ctx}/static/preview/images/redu.jpg" alt=""/></span></div></div>
    <div class="money">购买金额：￥<span id="buymoney"></span><br>
    预期收益：￥<span id="exceptmoney"></span></div>
    <div class="license">
      <input type="checkbox" name="checkbox" id="checkbox">
      <label for="checkbox"> &nbsp;&nbsp;我同意<a href="#">《百富网定存宝投资协议》</a></label>
      </div>
    <a href="javaScript:void(0);" style="text-decoration:none;" id="buy"><div class="purchase">我 要 购 买</div></a>
  </div>
  </form>
</div>
<input type="hidden" id="lastmoney" name="lastmoney" value="${bid.amount-bid.raisemoney}"/>
<input type="hidden" id="mininvestamount" value="${bid.mininvestamount}"/>
<input type="hidden" id="annualizedrate" value="${bid.annualizedrate}"/>
<input type="hidden" id="org" value="${org}"/>
<input type="hidden" id="bidnum" value="${bid.bidnum}"/>
<div class="detail_para">
  <div class="detail_content2">
    <div class="tab-container">
					<label class="tab-label">
						<input class="tab-radio" type="radio" name="page" value="page1" checked="checked"/>
						<p class="tab"><img src="${ctx}/static/preview/images/detail_01.png" alt=""/></p>
						<div class="tab-page" id="page1">
							<table style="font-family:'微软雅黑'; text-indent: 5px;
font-size:14px; color:#565A5C; margin-left:auto; margin-right:auto;" width="95%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="135" height="40">产品名称</td>
    <td width="86%"><c:out value="${bid.bidclassname}"/></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">产品编号</td>
    <td>${bid.bidcode}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">产品介绍</td>
    <td>${bid.bidclassintro}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">投资范围</td>
    <td>由合作机构提供100%本息担保的借款项目，包括抵押、质押、保证等类型</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">收益详情</td>
    <td>${bid.incomedesc}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">加入条件</td>
    <td><c:if test="${bid.mininvestamount != null}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.mininvestamount}"/>元起，且以<fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.mininvestamount}"/>元的倍数递增</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">加入期</td>
    <td><fmt:formatDate value="${bid.raisebegindate}" pattern="yyyy-MM-dd"/>~<fmt:formatDate value="${bid.raiseenddate}" pattern="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">单笔额度上限</td>
    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.maxinvestamount/10000}"/>万元</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">单户总额上限</td>
    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.maxinvestamount/10000}"/>万元</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">期限</td>
    <td><c:if test="${bid.investperiod != null}"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bid.investperiod}"/>个月</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">到期日</td>
    <td><fmt:formatDate value="${bid.exptexpiredate}" pattern="yyyy-MM-dd"/></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">到期赎回方式</td>
    <td>${bid.redeemway}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">提前赎回方式</td>
    <td height="40">期限内支持提前赎回，详情参见<a href="#" style="text-decoration:none;
	color:#009CE4;">《百富网定存宝投资协议》</a></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">转让方式</td>
    <td>详情参见<a href="#" style="text-decoration:none;
	color:#009CE4;">《百富网定存宝投资协议》</a></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td rowspan="4">费用</td>
    <td height="30">加入费率：<c:if test="${bid.raiserate != null}"><fmt:formatNumber value="${bid.raiserate}" type="number" maxFractionDigits="2"/>%</c:if>；</td>
  </tr>
  <tr>
    <td height="30">到期赎回费率：<c:if test="${bid.redemrate != null}"><fmt:formatNumber value="${bid.redemrate}" type="number" maxFractionDigits="2"/>%</c:if>；</td>
  </tr>
  <tr>
    <td height="30">转让费率：<c:if test="${bid.transrate != null}"><fmt:formatNumber value="${bid.transrate}" type="number" maxFractionDigits="2"/>%</c:if></td>
  </tr>
  <tr>
    <td height="30">提前赎回费率：加入金额的<fmt:formatNumber value="${bid.prepayrate}" type="number" maxFractionDigits="2"/>%，参见详情参考<a href="#" style="text-decoration:none;
	color:#009CE4;">《百富网定存宝投资协议》</a></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">保障方式</td>
    <td>由合作机构100%本息担保</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">担保机构</td>
    <td>经百富网审核，运营稳健且具国有、上市、大集团背景的小额贷款公司、保理公司、融资租赁公司等，详见合作机构名单</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">电子回单</td>
    <td height="40">${bid.receiptdesc}网上交易保障中心证明该项目的电子回单真实、有效、不可篡改</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">定存宝协议</td>
    <td><a href="#" style="text-decoration:none;
	color:#009CE4;">《百富网定存宝投资协议》</a></td>
  </tr>
  <tr>
    <td  colspan="2" ></td>
  </tr>
</table>
						</div>
					</label>
					<label class="tab-label" id="label2">
						<input class="tab-radio" type="radio" name="page" value="page2" id="dbjg" />
	  <p class="tab" id="d2"><img src="${ctx}/static/preview/images/detail_02.png" alt=""/></p>
	  <div class="tab-page" id="page2">
							<p><table style="font-family:'微软雅黑'; font-size:14px; color:#565A5C; margin-left:auto; margin-right:auto;" width="95%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="105" id="td1"><img src="" width="372" height="42"  alt=""/></td>
  </tr>
  <tr>
    <td height="35" style="font-size:18px;">公司概况：</td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="240" id="td2"></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="35" style="font-size:18px;">合作协议：</td>
  </tr>
  <tr>
    <td height="25">※ 由于保密条款限制，除担保条款以外其余部分内容不作公开。</td>
  </tr>
  <tr>
    <td height="1" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="380" style="text-align:center;" id="td3"><img src="" alt=""/></td>
  </tr>
  <tr>
    <td height="1"></td>
  </tr>
</table></p>
						</div>
					</label>
					<label class="tab-label">
						<input class="tab-radio" type="radio" name="page" value="page3" />
	  <p class="tab" id="d3" style="display: none"><img src="${ctx}/static/preview/images/detail_03.png" alt=""/></p>
	  <div class="tab-page" id="page3">
							<div class="tab-list"><table border="0" cellpadding="0" cellspacing="0">
</table></div>
<div class="classic"><div class="black2">
</div>

</div>

						</div>
					</label>					
	</div>
  </div>
</div>
<div class="footer">
  <div class="footer_nav">
    <div class="footer_logo">
      <div class="logo"><img src="${ctx }/static/preview/images/logo.png" width="201" height="64"  alt=""/></div>
      <div class="we"><a href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image10','','${ctx }/static/preview/images/weibo2.png',1)"><img src="${ctx }/static/preview/images/weibo1.png" alt="" width="53" height="53" id="Image10"></a></div>
      <div class="we2"><a class="tooltip" href="#" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image11','','${ctx }/static/preview/images/wechat2.png',1)"><img src="${ctx }/static/preview/images/wechat1.png" alt="" width="52" height="53" id="Image11"></a></div>
      <p>与我快乐的玩耍吧！</p>
    </div>
    <div class="footernav1">
      <ul>
        <li class="current">基本信息</li>
        <li><a href="#">百富网介绍</a></li>
        <li><a href="#">精英团队</a></li>
        <li><a href="#">公司新闻</a></li>
        <li><a href="#">媒体报道</a></li>
        <li><a href="#">投资人关系</a></li>
        <li><a href="#">加入我们</a></li>
        <li><a href="#">政策法规</a></li>
      </ul>
    </div>
    <div class="footernav2">
      <ul>
        <li class="current">发现</li>
        <li><a href="#">百富精选</a></li>
        <li>每日任务（即将上线）</li>
        <li><a href="#">大富翁测试（即将上线）</a></li>
        <li><a href="#">投资收益计算器</a></li>
        <li><a href="#">分享红包</a></li>
        <li><a href="#">访问移动端</a></li>
        <li><a href="#">网站地图</a></li>
      </ul>
    </div>
    <div class="footernav3">
      <ul>
        <li class="current">安全与帮助</li>
        <li><a href="#">产品安全</a></li>
        <li><a href="#">资金安全</a></li>
        <li><a href="#">数据及信息</a></li>
        <li><a href="#">隐私保密</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">在线客服</a></li>
        <li><a href="#">常见问题</a></li>
      </ul>
    </div>
  </div>
  <div class="footer_bottom">市场有风险，投资需谨慎 沪ICP000000号</div>
</div>
</body>
</html>
