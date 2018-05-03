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
<title>百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">
<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->

<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/detail.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript">  
$(document).ready(function(){
	 // 红包 start  
    $('#bonusExceptmoney').html($.format.number('0', '###,###.##'));
    $('#redPackBlanceSpan').hide();
    $('#bonusExceptmoneyCheckbox').click(function(){
	    if($(this).attr("checked")){
	    	// 必须同步执行, 因为获取红包余额与红包加息不是在一个ajax中获取的
	    	$.ajax({
	    	  type: 'POST',
	    	  url: ctx+"/member/redpacketAcct.do",
	    	  async:false,
	    	  data: {},
	    	  success: function(data){
	  	      	 $("#redPackBlance").html(data.result.blance);
 	          },
	    	  dataType: 'json'
	    	});
	    	showmoney();
	    	$('#redPackBlanceSpan').show();
	    	$('#usebonus').val('true');
	    }else{
	    	$('#redPackBlanceSpan').hide();
	    	showmoney();
	    	$('#bonusExceptmoney').html($.format.number('0', '###,###.##'));
	    	$('#usebonus').val('false');
	    }
    });
	 // 红包 end
	 
	if($("#investordercode").val() == ''){
	var min = 1;
	var max = parseInt($("#lastmoney").val()/$("#mininvestamount").val());
	
	if(max < min){
	min = max;
	}
	$("#add").val(min);
	$("#redu img").attr("src","${ctx}/static/images/redu2.jpg");
	$("#add").blur(function(){
		if(max > parseInt($("#bidnum").val())){
			max = $("#bidnum").val();
			$("#redu img").attr("src","${ctx}/static/images/redu.jpg");
		}
		if(parseInt($("#add").val())>max){
			$("#add").val(max);
			$("#redu img").attr("src","${ctx}/static/images/redu.jpg");
		}
		if(parseInt($("#add").val())<min){
			$("#add").val(min);
			$("#redu img").attr("src","${ctx}/static/images/redu2.jpg");
		}
		if(parseInt($("#add").val())==min){
			$("#redu img").attr("src","${ctx}/static/images/redu2.jpg");
		}
		if(max < min){
			$("#add").val(max);
			$("#redu img").attr("src","${ctx}/static/images/redu.jpg");
		}
		var ss= /^\d+$/;
		if(!ss.test($("#add").val())){
			$("#add").val(min);
			$("#redu img").attr("src","${ctx}/static/images/redu2.jpg");
		}
		showmoney();
	});
      $("#add1").click(function(){  
      var oldValue=parseInt($("#add").val()); //取出现在的值，并使用parseInt转为int类型数据  
      if(max > parseInt($("#bidnum").val())){
			max = $("#bidnum").val();
		}
      if(oldValue < max)
      	oldValue++;   //自加1  
      $("#add").val(oldValue)  //将增加后的值付给控件
      $("#redu img").attr("src","${ctx}/static/images/redu.jpg");
      showmoney();
});  
$("#redu").click(function(){  
      var oldValue=parseInt($("#add").val()); //取出现在的值，并使用parseInt转为int类型数据
      if(oldValue > min){
      	oldValue--   //自减1  
      }
      if(oldValue == min){
    	  $("#redu img").attr("src","${ctx}/static/images/redu2.jpg");
      }
     $("#add").val(oldValue)  //将增加后的值付给控件  
     showmoney()
});  
	}
function showmoney(){
 	 $("#buymoney").html("");
     var money = parseInt($("#add").val()*$("#mininvestamount").val());
 	 if($("#investordercode").val() != ''){
 		 money = $("#remainpriamount").val();
 	 }
     $("input[name=buymoney]").val(money);
     $("#buymoney").html($.format.number(money, '###,###.##'));
     $("#exceptmoney").html("");
     // 是否使用红包
     var varUseBonus = $('#bonusExceptmoneyCheckbox').length > 0 ? $('#bonusExceptmoneyCheckbox').is(':checked') : false;
     ajaxPost("calcTotalInterest.do", {repaymentway:$("#repaymentway").val(),exptinterestdate:$("#exptinterestdate").val(),money:money,annualizedrate:$("#annualizedrate").val(),investperiod:$("#investperiod").val(),bidtypeid:$("#bidtypeid").val(),investordercode:$("#investordercode").val(),useBonus:varUseBonus}, function(data){
    	 $("#exceptmoney").html($.format.number(data.result.yieldInfo.totalInterest, '###,###.##'));
    	 if(varUseBonus){
    		 var bonusTotalInterest = data.result.bonusTotalInterest;
    		 $('#bonusExceptmoney').html(bonusTotalInterest);
    		 //alert(parseFloat($('#redPackBlance').html()) +' '+ parseFloat(bonusTotalInterest)+' '+(parseFloat($('#redPackBlance').html()) < parseFloat(bonusTotalInterest)))
    		 // 但红包账户可用余额小于红包加息金额时, 实际可加息金额 = 红包账户可用余额 
    		 if(parseFloat($('#redPackBlance').html()) < parseFloat(bonusTotalInterest)){
    			 $('#useRedPack').html($('#redPackBlance').html());
    		 }else{
    			 $('#useRedPack').html(bonusTotalInterest);
    		 }
    	 }
     });
     
}
showmoney();
var current = 0;
 $("#d3").click(function(){
	 current = 1;
	 if ($("input[name=islogin]").val() != 'false') {
	 ajaxPost("bidDetailPage.do", {pageNow : current, bidCode:$("#bidCode").val()}, function(data){
			getPager(data);
		});
	 } else {
		 $("#ttable").html("<tr><td colspan=\"3\">请<a href=\"javascript:void(0);\"  onClick=\"goLoginPage()\">登录</a>后查看</td></tr>");
	 }
 });
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
   
   function getPager(data){
// 	   console.info(data.results == null || data.results.length==0);
	   var $table = $("#ttable");
	   var html = "";
// 	   html += "<tr><th class=\"text-center\">投资人</th><th>购买金额</th><th>时间</th></tr>";
	   if(data.results == null || data.results.length==0){
			html+="<tr><td colspan=\"3\">无任何信息</td></tr>";
		}
	   for(var i=0;i<data.results.length;i++){
		   if(i%2 == 0){
			   html+="<tr>";
		   }else{
			   html+="<tr class=\"even\">";
		   }
		   //var name = data.results[i].customername;
		   var name=data.results[i].customernickname
		   var namelength=name.length;
		   if(name.length>1){
		   var cname = name.charAt(1);
		   var arr = [];
		   for(var n = 0;n < name.length;n++){
			   arr[n] = name.charAt(n);
			   if(n==1 || n==2 ){
				   arr[n] = "*";
			   }
		   }
		   name = "";
		   for(var m = 0;m < arr.length; m++){
			   name+=arr[m];
		   }
// 		   name = name.replace(name.charAt(1), "*");
		   }else if(name.length == 1){
			   name = name + "*";
		   }
		   if($("#bidtypeid").val()=='4' && data.results[i].orderstatusdesc == '9' || data.results[i].ifsum == '1'){
			   html+="";
		   }else{
		html+="<td class=\"text-center\">"+name+"</td>";
		html+="<td>"+$.format.number(data.results[i].amount, '###,###.##')+"</td>";
		html+="<td>"+$.format.date(new Date(data.results[i].orderdate), 'yyyy-MM-dd HH:mm:ss')+"</td>";
		//html+="<td>"+data.results[i].orderstatus+"</td>";
		html+="</tr>";
		   }
	   }
		$table.html("");
		$table.html(html);
	   
	   var $pager = $(".classic .black2");
	   var pagehtml = "";
		//判断是不是第一页决定是否显示前一页标签
		if(data.pageNow <= 1){
			pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
		}
		if(data.pageNow > 1){
			var pre = data.pageNow-1;
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a>";
		}
		if(data.pageNow > 5){
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+1+"\">1</a>";
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+2+"\">2</a>";
			pagehtml += "<span>. . .</span>";
		}
		//从action中获取分页页码下表的开始和结束下标
		for(var i=data.begin;i<=data.end;i++){
			if(data.pageNow == i){
				pagehtml += "<span class=\"current\">"+i+"</span>";
			}
			if(data.pageNow != i){
				pagehtml += "<a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a>";
			}
		}
		var less = data.totalPageCount-data.pageNow;
		if(less >= 5){
			var endb = data.totalPageCount-1;
			pagehtml += "<span>. . .</span>";
			//显示尾页下标
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a>";
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a>";
		}
		//判断是不是最后一页，决定是否显示后一页下标
		if(data.pageNow < data.totalPageCount){
			var next = data.pageNow+1;
			pagehtml += "<a href=\"javascript:void(0);\" value=\""+next+"\">> </a>";
		}
		if(data.pageNow >= data.totalPageCount){
			pagehtml += "<span>&nbsp;&nbsp; > </span>";
		}
		$pager.html("");
		$pager.html(pagehtml);
   }
		
   $(".classic .black2 a").live("click",function(e){
		e.preventDefault();
		current = $(this).attr("value"); 
		ajaxPost("bidDetailPage.do", {pageNow : current, bidCode:$("#bidCode").val()}, function(data){
			getPager(data);
		});
	});	
   var  param = {id : $("#id").val()};
   //担保机构Tab
	$("#d2").on("click",function(){
		orgTab();
		});
	
	$("#sctx").click(function(){
		$("#dbjg").attr("checked","checked");
		orgTab();
	});
	$("#showtd2").click(function(){
		$("#dbjg").attr("checked","checked");
		orgTab();
	});
	if($("#org").val()==1){
		$("#sctx").trigger("click");
	}
	function orgTab(){
// 		if($("#bidtypeid").val() == '3'){
// 			$("#td2").html($("#ensuretype").val());
// 		}else{
		ajaxPost("bidDetailOrg.do", param, function(data){
// 			$("#td1 img").attr("src",data.instlogo);
// 			$("#td1 img").attr('width','372').attr('height','42');
			$("#td1 span").html("");
			$("#td1 span").html(data.instname);
			$("#td2").html("");
			$("#td2").append(data.instdesc);
			$("#td3 img").attr("src",'${ctx}'+data.agreementimg);
// 			$("#td3 img").attr('width','835').attr('height','251');
		});
// 			}
	}
	
	$("#buy").on("click",function(){
		//	if($("#email").val() == '' || $("#email").val() == null){
			if($("#isauthed").val() != 'true'){
				goLoginPage();
// 				alert("请先登录");
			}else{
		   var data = {"email":$("#email").val()};
		   ajaxPost("buyBid.do",data,function(data){
			   $("input[name=memberid]").val(data.result.memberid);
			   var money = data.result.blance;
			   $("input[name=restmoney]").val(money);
			   $("input[name=acctid]").val(data.result.memberAcctid);
			   var buymoney = $("input[name=buymoney]").val();
			   if(buymoney>money){
				   $("#buy").attr("data-am-modal","{target: '#doc-modal-2'}");
				   $("#doc-modal-2").modal({closeViaDimmer:0}); 
				   $("#doc-modal-2").modal('open');
				   $("#cancle2").on("click",function(){
					   $("#buy").removeAttr("data-am-modal");
				   });
				   $(".am-close").on("click",function(){
						 $("#buy").removeAttr("data-am-modal");
					});
				   return false;
			   }else{
				   //$("#myform").attr("action","buyConform.do").submit();
				   $("#cpayamount").html($.format.number($("input[name=buymoney]").val(), '###,###.##'));
				   $("#camount").html($.format.number($("input[name=restmoney]").val(), '###,###.##'));
				   $("#cincome").html($("#exceptmoney").html());
				   $("#buy").attr("data-am-modal","{target: '#buyconfirm'}");
				   $("#buyconfirm").modal({closeViaDimmer:0}); 
				   $("#buyconfirm").modal('open');
				   $("#payconfirm").on("click",function(){
					   butDisabled($("#payconfirm"));
					   var code = $("input[name=investordercode]").val();
					   var url = "buyBidHandle.do";
						console.info(code);
						if(code != '' && typeof(code)!="undefined"){
							   url = "buyBidTrans.do";
						   }
						   $.ajax({
								type : "post",
								url : url,
								data:$('#myform').serialize(),
								success : function(data) {
									if(data.status == "1"){
										 $("#buyconfirm").modal('close');
										 $("#buy").attr("data-am-modal","{target: '#doc-modal-1'}");
										 $("#doc-modal-1").modal({closeViaDimmer:0});
										 $("#doc-modal-1").modal('open');
										 $(".am-close").on("click",function(){
											location.href = window.location.href;
										 });
									}else{
										 butEnabled($("#payconfirm"),"确认投资");
										 $("#buyconfirm").modal('close');
										 $("#buy").attr("data-am-modal","{target: '#doc-modal-3'}");
										 $("#doc-modal-3").modal({closeViaDimmer:0});
										 $("#doc-modal-3").modal('open');
										 $(".am-close").on("click",function(){
											 $("#buy").removeAttr("data-am-modal");
										});
										 $("#cancle1").on("click",function(){
											   $("#buy").removeAttr("data-am-modal");
										   }); 
									}
								},
								error : function(data){
									 butEnabled($("#payconfirm"),"确认投资");
									 $("#buyconfirm").modal('close');
									 $("#buy").attr("data-am-modal","{target: '#doc-modal-3'}");
									 $("#doc-modal-3").modal({closeViaDimmer:0});
									 $("#titlemessage").html(getJsonErrorMsg(data));
									 $("#doc-modal-3").modal('open');
									 $(".am-close").on("click",function(){
										 $("#buy").removeAttr("data-am-modal");
									});
									 $("#cancle1").on("click",function(){
										   $("#buy").removeAttr("data-am-modal");
									   }); 
								}
							});
					   console.info("123");
				   });
				   $("#back").on("click",function(){
					   butEnabled($("#payconfirm"),"确认投资");
				       $("#buy").removeAttr("data-am-modal");
					});
			   }
		   });
		   }
	});
	$("#unlogin").on('click',function(){
		goLoginPage();
		});
	
	//
	var buyShare = getQueryString('buyShare');
	if(buyShare!=null && buyShare!=''){
		$('#add').val(buyShare);
		$('#add').trigger('blur');
	}
});  

// 必须为全局函数
function goLoginPage(){
    // 购买份额	
    var buyShare = $('#add').val();	
    var encodeUrl = urlencode(window.location.href+"&buyShare="+buyShare);
	window.location.href = "${ctx}/login.do?preurl="+encodeUrl;
}
function urlencode(str) {  
    str = (str + '').toString();   
    return encodeURIComponent(str).replace(/!/g, '%21').replace(/'/g, '%27').replace(/\(/g, '%28').  
    replace(/\)/g, '%29').replace(/\*/g, '%2A').replace(/%20/g, '+');  
} 
function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
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
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
		$("#invest_check").attr("class","current");
	});

</script>
</head>

<body>
<jsp:include page="header.jsp"/><!--网站logo 导航条  end-->
<div class="subnav"><a href="index.do">首页</a> &gt; <a href="queryBidAll.do">我要投资</a> &gt; 
<c:forEach items="${bidtype}" var="b">
<c:if test="${b.key == bid.bidtypeid}"><a href="queryBidAll.do?bidtypeid=${bid.bidtypeid}">${b.value}</a> &gt; ${b.value}详情</c:if>
</c:forEach>


</div><!-- 面包屑  -->
<div class="detail_content">
  <div class="detail_tleft">
    <div class="detail01"><span class="detail_style01"><c:out value="${bid.bidclassname}"/><c:if test="${bid.investordercode != null}"><img src="${ctx}/static/images/zhuan.jpg" />  </c:if> ${bid.bidcode}</span>
    </div>
    <c:if test="${bid.bidtypeid != '4' }">
    <div class="detail_style02" ><img src="${ctx}/static/images/shield.jpg" alt=""/> <a href="#d2" style="color:#565A5C"><span id="sctx">
    <c:if test="${bid.bidtypeid != '3'}">
    	担保公司
    </c:if>
    <c:if test="${bid.bidtypeid == '3'}">
    	金融资产担保
    </c:if>
    	：${bid.assureinstname}</span></a></div>
    </c:if>
    <div class="detail02"><span class="detail_style03">产品说明：</span><br>
<c:out value="${bid.bidclasssubject}"/></div>
    <div class="detail03">
      <div class="detail03_column">融资金额<br>
        <span class="detail_style04">&yen; <c:if test="${bid.investordercode == null}"><fmt:formatNumber value="${bid.amount}" type="number" maxFractionDigits="2"/></c:if>
        <c:if test="${bid.investordercode != null}"><fmt:formatNumber value="${bid.remainpriamount}" type="number" maxFractionDigits="2"/></c:if>
        </span><br>
      <br>
      <c:choose>
      <c:when test="${bid.bidstatus eq 2 or bid.bidstatus eq 4}">计息日期</c:when>
      <c:otherwise>预计起息日</c:otherwise>
      </c:choose>
      <br><c:if test="${bid.bidtypeid != 4}"><fmt:formatDate value="${bid.exptinterestdate}" pattern="yyyy-MM-dd"/></c:if>
      <c:if test="${bid.bidtypeid == 4}">翌日起息</c:if>
      </div>
      <div class="detail03_column">投资期限<br><span class="detail_style04">
      <c:if test="${bid.bidtypeid == 4}">活期</c:if>
      <c:if test="${bid.investperiod != null}"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bid.investperiod}"/><c:if test="${bid.investordercode == null}">个月</c:if>
      <c:if test="${bid.investordercode != null}">天</c:if></c:if></span><br><br>
<c:choose>
      <c:when test="${bid.bidstatus eq 2 or bid.bidstatus eq 4}">到期日</c:when>
      <c:otherwise>预计到期日</c:otherwise>
      </c:choose>
<br>
      <c:if test="${bid.bidtypeid != 4}"><fmt:formatDate value="${bid.exptlastacctdate}" pattern="yyyy-MM-dd"/></c:if>
      <c:if test="${bid.bidtypeid == 4}">无</c:if>
      </div>
      <div class="detail03_column1">预期年化收益率<br><span class="detail_style05"><c:if test="${bid.annualizedrate != null}"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bid.annualizedrate}" />% <c:if test="${bid.bidtypeid != '4' }"><span style="font-size:14px; color:#565A5C; font-weight:normal;">可加息0.5%</span></c:if></c:if></span><span style="display:block; margin-top:23px;">还款方式<br>${bid.incomedesc}</span></div>
</div>
    <div class="detail04"><strong>项目特点：</strong><br>
<c:out value="${bid.projectfeature}"/></div>
  </div>
  <form action="" method="post" id="myform">
  <input type="hidden" id="id" name="id" value="${bid.id}"/>
<input type="hidden" id="bidCode" name="bidCode" value="${bid.bidcode}"/>
<input type="hidden" name="raisemoney" value="${bid.raisemoney}"/>
<input type="hidden" name="amount" <c:if test="${bid.investordercode == null}">value="${bid.amount}"</c:if>
<c:if test="${bid.investordercode != null}">value="${bid.remainpriamount}"</c:if> />
<input type="hidden" name="buymoney" value=""/>
<input type="hidden" name="memberid" value=""/>
<input type="hidden" name="restmoney" value=""/>
<input type="hidden" name="exptinterestdate" id="exptinterestdate" value="${bid.exptinterestdate}"/>
<input type="hidden" name="repaymentway" id="repaymentway" value="${bid.repaymentway}"/>
<input type="hidden" name="investperiod" id="investperiod" value="${bid.investperiod}"/>
<input type="hidden" id="annualizedrate" name="annualizedrate" value="${bid.annualizedrate}"/>
<input type="hidden" name="acctid" value=""/>
<input type="hidden" name="remainpriamount" id="remainpriamount" value="${bid.remainpriamount}"/>
<input type="hidden" name="investordercode" id="investordercode" value="${bid.investordercode}"/>
<input type="hidden" id="bidtypeid" name="bidtypeid" value="${bid.bidtypeid}"/>
<input type="hidden" id="ensuretype" name="ensuretype" value="${bid.ensuretype}"/>
<input type="hidden" id="usebonus" name="usebonus" value="false"/>
  <div class="detail_tright">
    <div id="circle"><div id="circle2" <c:if test="${bid.investordercode == null}">value="${bid.raisemoney*100/bid.amount}"</c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='2'}">value="0"</c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='3'}">value="100"</c:if>></div><script type="text/javascript">
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
	loadImg(Math.floor(result).toFixed(0));
}
</script></div>
    <div class="rest">融资余额：￥<span><c:if test="${bid.investordercode == null}"><fmt:formatNumber value="${bid.amount-bid.raisemoney}" type="number" maxFractionDigits="2"/></c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='2'}"><fmt:formatNumber value="${bid.remainpriamount}" type="number" maxFractionDigits="2"/></c:if>
    <c:if test="${bid.investordercode != null && bid.raisestate =='3'}">0</c:if>
    </span></div>
    <div class="rest" style="margin-bottom: 10px">账户余额：
    <shiro:authenticated>
    	￥<span><fmt:formatNumber value="${blance}" type="number" maxFractionDigits="2"/></span>　<a href="${ctx}/member/recharge.do" target="new">充值</a>
    	<input type="hidden" name="islogin" value="true"> 
    </shiro:authenticated>
    <shiro:notAuthenticated>
    <a  id="unlogin" href="javascript:void(0)">未登录</a>
    <input type="hidden" name="islogin" value="false">
    </shiro:notAuthenticated>
    </div>
    <c:if test="${bid.investordercode == null}">
    <div class="add">
    <img src="${ctx}/static/images/001.jpg" style="float:left;"   alt=""/>
    <input id="add" type="text" name="add" onkeydown="if(event.keyCode==13){return false;}"/><div style="font-size:16px; float:left; margin-top:12px; margin-left:5px; font-family:'微软雅黑';">份</div>
<div style="margin-left:10px; width: 24px; float:left;"><span id="add1"><img  src="${ctx}/static/images/add.jpg" alt=""/></span>
<span id="redu"><img src="${ctx}/static/images/redu.jpg" alt=""/></span></div></div></c:if>
    <div class="money">购买金额：￥<span id="buymoney" style=color:#565A5C;></span><br>
    <c:if test="${bid.bidtypeid != 4}">预期收益</c:if>
    <c:if test="${bid.bidtypeid == 4}">预计每日收息</c:if>
    ：￥<span id="exceptmoney"></span></div>
    <shiro:authenticated>
	    <c:if test="${bid.bidtypeid != 4}">
		   	<div class="money2"><label class="am-checkbox" style="margin-top:5px;margin-bottom:5px;">
		      <input id="bonusExceptmoneyCheckbox" type="checkbox"   value="" data-am-ucheck>
		   	   使用加息红包：￥<span id="bonusExceptmoney"></span>　　 <br/>
		   	 <span id="redPackBlanceSpan"> 
		   		   可用红包余额 ￥<span id="redPackBlance">0</span>,<br>本次可用 ￥<span id="useRedPack">0</span>
		   	 </span>
		    </label></div>
	    </c:if>
    </shiro:authenticated>
<!--     <div class="license"> -->
         <div>
        <!--
        <label for="checkbox" class="am-checkbox" style="font-size:15px;margin-top:5px;">我同意
      	<input type="checkbox" name="checkbox" id="checkbox" checked="checked" data-am-ucheck checked>
		  <span style="color:#009CE4"><c:if test="${bid.bidtypeid == '1'}">《年年富投资协议》</c:if>
		  <c:if test="${bid.bidtypeid == '2'}">《月月富投资协议》</c:if>
		  <c:if test="${bid.bidtypeid == '3'}"><a href="${ctx }/contractmm.do" target="_black">《月月富T投资协议》</a></c:if>
		  <c:if test="${bid.bidtypeid == '4'}"><a href="${ctx }/contractdd.do" target="_black">《天天富投资协议》</a></c:if>
		</label> 
		-->
      <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
        <div class="am-modal-dialog">
          <div class="am-modal-hd" style="color:#009CE4; font-size:22px;"><span class="am-icon-check"></span> 恭喜，投资成功！
          
          <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
          <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
          </div>
        <div class="am-modal-bd">
         您还可以：<a href="${ctx}/queryBidAll.do">继续投资</a>　　<a href="${ctx}/member/dealhistory.do">查看交易纪录</a>　　<a href="${ctx}/member/investdoc.do">返回我的账户</a><br>
</div>
       </div>
      </div>
      
      <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
        <div class="am-modal-dialog">
          <div class="am-modal-hd" style="color:#EA544A; font-size:22px;"><span class="am-icon-times"></span> 抱歉，您的余额不足！
          
          <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
          <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
          </div>
        <div class="am-modal-bd">
         可选择前去充值，我们为您的账户安全保驾护航！<br>
<br>
<a href="${ctx }/member/recharge.do"><div class="am-btn am-btn-default">我要充值</div></a>　<a href="javascript: void(0)" id="cancle2" data-am-modal-close>取消</a><br><br>
您还可以：<a href="${ctx}/help_detail.do#13"  target="_blank">查询如何充值</a>
</div>
       </div>
      </div>
      
      <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-3">
        <div class="am-modal-dialog">
          <div class="am-modal-hd" style="color:#EA544A; font-size:22px;"><span class="am-icon-times"></span> 抱歉，购买失败！
          
          <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
          <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
          </div>
        <div class="am-modal-bd">
         <div id="titlemessage">您下手太慢啦，该产品已售罄~<br>我知道了，去看看其他 <a href="${ctx}/queryBidAll.do">投资产品</a></div>
         
         <br>
<br>
<a href="${ctx }/member/recharge.do"><div class="am-btn am-btn-default">我要充值</div></a>　　<a href="javascript: void(0)" id="cancle1" data-am-modal-close>取消</a><br><br>
您还可以：<a href="${ctx}/help_detail.do#13"  target="_blank">查询如何充值</a>
</div>
       </div>
      </div>
      
      <div class="am-modal am-modal-alert" tabindex="-1" id="buyconfirm">
  <div class="am-modal-dialog" style="height:320px;">
    <div class="am-modal-hd">确认信息<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <!-- a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a--> </div>
    <div class="am-modal-bd" style="margin-top:-20px">
      <div class="am-g" style="text-align:left; line-height:40px;">
        <div class="am-u-sm-2">&nbsp;</div>
        <div class="am-u-sm-4">产品名称</div>
        <div class="am-u-sm-6">${bid.bidclassname}</div>
      </div>
      <div class="am-g" style="text-align:left; line-height:40px;">
        <div class="am-u-sm-2">&nbsp;</div>
        <div class="am-u-sm-4">您的账户余额</div>
        <div class="am-u-sm-6"><span style="color:#EA544A" id="camount"></span> 元</div>
      </div>
      <div class="am-g" style="text-align:left; line-height:40px;">
        <div class="am-u-sm-2">&nbsp;</div>
        <div class="am-u-sm-4">本次投资金额</div>
        <div class="am-u-sm-6"><span style="color:#EA544A" id="cpayamount"></span> 元</div>
      </div>
      <div class="am-g" style="text-align:left; line-height:40px;">
        <div class="am-u-sm-2">&nbsp;</div>
        <div class="am-u-sm-4">预期收益</div>
        <div class="am-u-sm-6"><span style="color:#EA544A" id="cincome"></span> 元</div>
      </div>
        <div style="margin-top:30px; margin-left:100px; float:left">
          <span  class="am-btn am-btn-secondary" style="width:180px;" id="payconfirm">确认投资</span>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:40px" data-am-modal-close id="back">返 回</a> </div>
      
    </div>
  </div>
</div>
      
      
      </div>
      <c:if test="${bid.raisestate!='2' || bid.bidstatus !='1' && bid.bidstatus !='5' && bid.bidstatus !='6'}">
    <div class="purchase" style="background-color:#ccc;">立 刻 投 资</div>
  	</c:if>
  	<c:if test="${bid.raisestate=='2'&&(bid.bidstatus =='1' || bid.bidstatus =='5' || bid.bidstatus =='6')}">
    <a href="javaScript:void(0);" style="text-decoration:none;" data-am-modal="{closeViaDimmer: 0, width: 450, height: 255}" id="buy"><div class="purchase">立 刻 投 资</div></a>
  	</c:if>
  </div>
  </form>
</div>
<input type="hidden" id="lastmoney" name="lastmoney" <c:if test="${bid.investordercode == null}">value="${bid.amount-bid.raisemoney}"</c:if>
<c:if test="${bid.investordercode != null}">value="${bid.remainpriamount}"</c:if> />
<input type="hidden" id="mininvestamount" value="${bid.mininvestamount}"/>
<input type="hidden" id="org" value="${org}"/>
<input type="hidden" id="bidnum" value="${bid.bidnum}"/>
<input type="hidden" id="email" value="<shiro:principal property="email"/>"/>
<shiro:authenticated>
<input type="hidden" id="isauthed" value="true"/>
</shiro:authenticated>
<div class="detail_para" style="margin-bottom: -65px;">
  <div class="detail_content2">
    <div class="tab-container">
					<label class="tab-label">
						<input class="tab-radio" type="radio" name="page" value="page1" checked="checked"/>
						<p class="tab"><img src="${ctx}/static/images/detail_01.png" alt=""/></p>
						<div class="tab-page" id="page1">
							<table style="font-family:'微软雅黑'; text-indent: 5px;
font-size:14px; color:#565A5C; margin-left:auto; margin-right:auto; font-weight:normal" width="95%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="135" height="40">名称</td>
    <td width="86%"><c:out value="${bid.bidclassname}"/></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <!--<tr>
    <td height="40">产品编号</td>
    <td>${bid.bidcode}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>-->
  <tr>
    <td height="60">产品介绍</td>
    <td>${bid.bidclasssubject}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">投资范围</td>
    <td><c:if test="${bid.bidtypeid != '3'}">由合作机构提供100%本息担保的借款项目，包括抵押、质押、保证等类型</c:if>
    <c:if test="${bid.bidtypeid == '3'}">借款人的借款质押物必须为国有大型信托公司发行的金融资产</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">预期年化收益率</td>
    <td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bid.annualizedrate}" />%<c:if test="${bid.bidtypeid != '4' }"> 　可加息0.5%</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">付息方式</td>
    <td>${bid.incomedesc}</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
    <td height="40">认购条件</td>
    <td><c:if test="${bid.mininvestamount != null}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.mininvestamount}"/>元起，且以<fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.mininvestamount}"/>元的倍数递增</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <c:if test="${bid.bidtypeid == '4'}">
  <tr>
    <td height="40">认购期</td>
    <td>即时认购，翌日起息</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <!--tr>
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
  </tr-->
  <!--tr>
    <td height="40">单户总额上限</td>
    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.maxinvestamount/10000}"/>万元</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr-->
  <tr>
    <td height="40">期限</td>
    <td><c:if test="${bid.bidtypeid != '4'}"><c:if test="${bid.investordercode != null}"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bid.investperiod}"/>天</c:if>
    <c:if test="${bid.investordercode == null}"><fmt:formatNumber type="number" maxFractionDigits="0" value="${bid.investperiod}"/>个月</c:if></c:if>
    <c:if test="${bid.bidtypeid == '4'}">随存随取</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <c:if test="${bid.bidtypeid != '4'}">
  <tr>
    <td height="40">到期日</td>
    <!--td><fmt:formatDate value="${bid.exptexpiredate}" pattern="yyyy-MM-dd"/></td-->
    <td>具体根据起息日调整顺延</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <c:if test="${bid.bidtypeid == '3'}">
  <tr>
    <td height="40">到期赎回方式</td>
    <td>债权优先购买，平台统筹赎回</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <c:if test="${bid.bidtypeid != '4'}">
  <tr>
    <td height="40">提前赎回</td>
    <td><c:if test="${bid.lockupperiod != null}">锁定期${bid.lockupperiod}天，锁定期后可提前赎回，赎回费为本金的2%</c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <c:if test="${bid.bidtypeid == '4'}">
  <tr>
    <td height="40">交易费</td>
    <td>免认缴费、免赎回费</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <tr>
    <td height="40">本息保障</td>
    <td><c:if test="${bid.bidtypeid != '3'}">由担保机构100%本息担保或金融资产质押担保</c:if>
    <c:if test="${bid.bidtypeid == '3'}"><a href="#d2" id="showtd2">详情请见保障方式</a></c:if></td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <c:if test="${bid.bidtypeid != '3'}">
  <tr>
    <td height="40">担保机构</td>
    <td>经百富网审核，运营稳健且具国有、上市、大集团背景的小额贷款公司、保理公司、融资租赁公司等，详见合作机构名单</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr></c:if>
  <tr>
    <td height="40">电子回单</td>
    <td height="40">网上交易保障中心证明该项目的电子回单真实、有效、不可篡改</td>
  </tr>
  <tr>
    <td height="1" colspan="2" bgcolor="#CCCCCC"></td>
  </tr>
  <tr>
  <c:if test="${bid.bidtypeid == '1'}"><td height="40">本息宝协议</td>
    <td>详见<span style="color:#009CE4">《年年富投资协议》</span></td></c:if>
  <c:if test="${bid.bidtypeid == '2'}"><td height="40">月月富协议</td>
    <td><span style="color:#009CE4">《月月富投资协议》</span></td></c:if>
  <c:if test="${bid.bidtypeid == '3'}"><td height="40">月月富T相关协议</td>
    <td><span style="color:#009CE4"><a href="${ctx }/contractmm.do" target="_black">《月月富T投资协议》</a></span></td></c:if>
  <c:if test="${bid.bidtypeid == '4'}"><td height="40">天天富协议</td>
    <td><span style="color:#009CE4"><a href="${ctx }/contractdd.do" target="_black">《天天富投资协议》</a></span></td></c:if>	
  </tr>
  <tr>
    <td  colspan="2" ></td>
  </tr>
</table>
						</div>
					</label>
					
					<c:if test="${bid.bidtypeid != '4' }">
					<label class="tab-label" id="label2">
						<input class="tab-radio" type="radio" name="page" value="page2" id="dbjg" />
	  <p class="tab" id="d2"><c:if test="${bid.bidtypeid != '3'}"><img src="${ctx}/static/images/detail_02.png" alt=""/></c:if>
	  <c:if test="${bid.bidtypeid == '3'}"><img src="${ctx}/static/images/detail_04.png" alt=""/></c:if>
	  </p>
	  <div class="tab-page" id="page2" style="left:0px;">
							<p><table style="font-family:'微软雅黑'; font-size:14px; color:#565A5C; margin-left:auto; margin-right:auto; font-weight:normal" width="95%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="105" id="td1"><span style="font-size:22px;"></span><img src="" alt=""/></td>
  </tr>
  <tr>
    <td height="35" style="font-size:18px;"></td>
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
    <td height="35" style="font-size:18px;"></td>
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
					</c:if>
					
					
					<label class="tab-label">
						<input class="tab-radio" type="radio" name="page" value="page3" />
	  <p class="tab" id="d3"><img src="${ctx}/static/images/detail_03.png" alt=""/></p>
	  <div class="tab-page" id="page3" style="left:0px;">
							<div class="tab-list"><table border="0" cellpadding="0" cellspacing="0" style="font-weight:normal">
							<thead><tr><th class="text-center">投资人</th><th>购买金额</th><th>时间</th></tr></thead>
							<tbody id="ttable"></tbody>
</table></div>
<div class="classic"><div class="black2">
</div>

</div>

						</div>
					</label>					
	</div>
  </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
