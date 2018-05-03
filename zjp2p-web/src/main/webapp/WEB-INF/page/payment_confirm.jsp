<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!doctype html>
<html>
<head>
<title>我要投资 - 百富网小额投资理财平台</title>
<%@include file="../common/tdk.jsp"%> 
<%@include file="../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<style type="text/css">
.confirm {
	width:1000px;
	height:450px;
	margin-left:auto;
	margin-right:auto;
	border-color:#CCC;
	border-width:1px;
	border-style:solid;
	background-color:#fff;
	margin-top:45px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var code = $("input[name=investordercode]").val();
	$("#buy").on("click",function(){
		butDisabled($("#buy"));
		//确认交易密码是否正确
		$.ajax({
			type : "post",
			url : "comparepassword.do",
			data:{password:$('#password').val()},
			dataType: "json",
			success: function(data){
				if(data.status == '1'){
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
									 $("#buy").attr("data-am-modal","{target: '#doc-modal-1'}");
									 $("#doc-modal-1").modal({closeViaDimmer:0});
									 $("#doc-modal-1").modal('open');
									 $(".am-close").on("click",function(){
										location.href = "bidDetail.do?id="+$("#id").val();
									 });
								}else{
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
								butEnabled($("#buy"),"确认投资");
							},
							error : function(data){
								 butEnabled($("#buy"),"确认投资");
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
					   return true;
				}
				if(data.status == '2'){
					alert(data.result);
				}
				butEnabled($("#buy"),"确认投资");
			},
			error: function(data){
				butEnabled($("#buy"),"确认投资");
			}
		});
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

<div class="confirm">
<form action="" id="myform" method="post">
  <div style="width:86%; margin-left:auto; margin-right:auto; font-size:24px; font-family:'微软雅黑'; color:#565A5C; margin-top:25px;"><c:forEach var="type" items="${bidtypes}">
  <c:if test="${bidtypeid == type.key}">
       ${type.value}
  </c:if>
  </c:forEach><hr data-am-widget="divider" style="margin-top:10px;" class="am-divider am-divider-default"
/></div>
  <div style="width:86%; margin-left:auto; margin-right:auto; font-size:24px; font-family:'微软雅黑'; color:#565A5C; margin-top:25px; height:30px;">
    <div style="width:43%; float:left;font-size:15px; font-family:'微软雅黑'; color:#565A5C">您的账户余额：</div>
    <div style="width:23%; float:left;font-size:18px; font-family:'微软雅黑'; color:#EA544A; text-align:right"><fmt:formatNumber value="${restmoney}" type="number" maxFractionDigits="2"/> 元</div>
  </div>
  
  <div style="width:86%; margin-left:auto; margin-right:auto; font-size:24px; font-family:'微软雅黑'; color:#565A5C; margin-top:20px;height:30px;">
    <div style="width:43%; float:left;font-size:15px; font-family:'微软雅黑'; color:#565A5C">投资本金：</div>
    <div style="width:23%; float:left;font-size:18px; font-family:'微软雅黑'; color:#EA544A; text-align:right"><fmt:formatNumber value="${buymoney}" type="number" maxFractionDigits="2"/> 元</div>
  </div>
  
  <div style="width:86%; margin-left:auto; margin-right:auto; font-size:24px; font-family:'微软雅黑'; color:#565A5C; margin-top:20px;height:30px;">
    <div style="width:43%; float:left;font-size:15px; font-family:'微软雅黑'; color:#565A5C">您需要支付：</div>
    <div style="width:23%; float:left;font-size:18px; font-family:'微软雅黑'; color:#EA544A; text-align:right"><fmt:formatNumber value="${buymoney}" type="number" maxFractionDigits="2"/> 元</div>
  </div>
  
  <div style="width:86%; margin-left:auto; margin-right:auto;margin-top:25px;"><hr data-am-widget="divider" style="margin-top:10px;" class="am-divider am-divider-default"
/></div>

  <!--div style="width:86%;margin-left:auto; margin-right:auto;margin-top:25px; height:30px;">
    <label class="am-checkbox">
      <input type="checkbox" checked="checked" value="" data-am-ucheck checked>
      我已阅读并同意<a href="#">《百富网月月富投资协议》</a>
    </label>
  </div-->
  
  <div style="width:50%;margin-left:auto; margin-right:auto;margin-top:25px; height:50px;">
    <!--input type="password" id="password" class="am-form-field" placeholder="交易密码" style="width:272px; height:45px; float:left"--> 
    <button type="button" id="buy" class="am-btn am-btn-secondary" style="height:45px; width:145px; font-size:18px; float:left; margin-left:27px;font-family:'微软雅黑'">确认投资</button>
    <button type="button" class="am-btn am-btn-secondary" style="height:45px; width:145px; font-size:18px; float:left; margin-left:27px;font-family:'微软雅黑'" onclick="location='${ctx}/bidDetail.do?id=${id}'">返 回</button>
    </div>
<input type="hidden" name="memberid" value="${memberid}" >
<input type="hidden" name="id" id="id" value="${id}" >
<input type="hidden" name="amount" value="${amount}" >
<input type="hidden" name="bidCode" value="${bidCode}" >
<input type="hidden" name="restmoney" value="${restmoney}" >
<input type="hidden" name="buymoney" value="${buymoney}" >
<input type="hidden" name="raisemoney" value="${raisemoney}" >
<input type="hidden" name="acctid" value="${memberacctid}" >
<input type="hidden" name="repaymentway" value="${repaymentway}" >
<input type="hidden" name="exptinterestdate" value="${exptinterestdate}" >
<input type="hidden" name="annualizedrate" value="${annualizedrate}" >
<input type="hidden" name="investordercode" value="${investordercode}" >
<input type="hidden" name="investperiod" value="${investperiod}" >
<input type="hidden" name="bidtypeid" value="${bidtypeid}" >
<input type="hidden" name="usebonus" value="${usebonus}" >

</form>
  </div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
        <div class="am-modal-dialog">
          <div class="am-modal-hd" style="color:#009CE4; font-size:22px;"><span class="am-icon-check"></span> 恭喜，投资成功！
          
          <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
          <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
          </div>
        <div class="am-modal-bd">
         您还可以：<a href="queryBidAll.do">继续投资</a>　　<a href="${ctx}/member/dealhistory.do">查看交易纪录</a>　　<a href="${ctx}/member/investdoc.do">返回我的账户</a><br>
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
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
