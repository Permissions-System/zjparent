<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>推荐好友 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/static/js/ZeroClipboard.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 


</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
$(function(){
	init();
});
function init() {

	ZeroClipboard.setMoviePath( '${ctx}/static/js/ZeroClipboard.swf' );
	var clip = new ZeroClipboard.Client(); // 新建一个对象
	clip.setHandCursor( true );
	clip.setText($('#referralURL').val()); // 设置要复制的文本。
	clip.addEventListener( "mouseUp", function(client) {
		alert("复制成功！");
	});
	// 注册一个 button，参数为 id。点击这个 button 就会复制。
	//这个 button 不一定要求是一个 input 按钮，也可以是其他 DOM 元素。
	clip.glue("copycardid"); // 和上一句位置不可调换
}

function becomeMiddle(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    url:'becomeMiddle.do',     
	    success:function(data){
	    	if(data.status=="FAIL"){
	    		alert(data.msg);
	    	}
	    	if(data.status=="SUCCESS"){
	    		alert(data.msg);
	    		location.href='referral.do';
	    	}
	    	if(data.status==2){
	    		alert(data.msg);
	    		location.href='referral.do';
	    	}
		},
		error: function (data) {
	    	console.info(data);
	    	alert(getJsonErrorMsg(data));
    	}  
	});
}
</script>
<style type="text/css">
.box1 {
	width:765px;
	height:155px;
	border-color:#e0e0e0;
	border-width:1px;
	border-style:solid;
	margin-top:25px;
	margin-left:5px;
}

.box2 {
	width:95%;
	margin-left:auto;
	margin-right:auto;
	font-size:16px;
	padding-left:5px;
	line-height:50px;
}

.box3 {
	width:765px;
	height:190px;
	border-color:#e0e0e0;
	border-width:1px;
	border-style:solid;
	margin-top:-20px;
	margin-left:5px;
	padding-left:22px;
}
.box4 {
	width:765px;
	height:155px;
	margin-top:40px;
	margin-left:5px;
}
</style>
</head>

<body>


<%@include file="../header.jsp" %>

<div class="person_info">
<%@include file="left.jsp"%>
  <div class="person_info_right">
    <div class="member_h" style="width:95%"><img src="${ctx}/static/images/member_icon09.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 好友推荐</span><span style="float:right; width:150px; font-size:14px;"><a href="referral_2.do" target="_blank">＋ 查看推荐规则</a></span></div>
    <div class="personalinfo" style="margin-top:50px;">
      <div class="box1">
        <div class="box2">
        		我的推荐佣金：<c:if test="${empty agent }">0.00</c:if><c:if test="${ !empty agent }"><span style="color:#EA544A;font-size:24px;"><fmt:formatNumber type="number" minFractionDigits="2" value="${account.commisiontotalaccount}"/></span></c:if> 元</div>
        
        <hr data-am-widget="divider" style="margin-top:0;margin-bottom:0;width:96%" class="am-divider am-divider-default" />
        
        <div class="box2"><div style="font-size:14px;float:left;width:35%;">本期预计佣金：<strong><c:if test="${empty agent}">0.00</c:if><c:if test="${!empty agent }"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${accountmap.sumRecvincome * agent.commissionrate}"/></c:if></strong> 元</div><div style="font-size:14px;float:left;width:40%;">好友成功投资总额：<strong><c:if test="${empty accountmap.sumAccount }">0.00</c:if><c:if test="${!empty accountmap.sumAccount }"><fmt:formatNumber value="${accountmap.sumAccount}" minFractionDigits="2" type="number"/></c:if></strong> 元</div><div style="font-size:14px;float:left;width:25%;">成功注册好友数：${accountmap.memberNum} 人</div></div> 
        
        <hr data-am-widget="divider" style="margin-top:0px;margin-bottom:0;width:96%" class="am-divider am-divider-default" />
        
        <div class="box2"><div style="font-size:14px;float:left;width:35%;">已获推荐红包：<strong><fmt:formatNumber value="${sum}" minFractionDigits="2" type="number"/> </strong> 元</div><div style="font-size:14px;float:left;width:40%;">成功认证：<strong>${num}</strong> 人（红包${num}个）</div>
		<div style="font-size:14px;float:left;width:25%;">等级：
				<strong><c:if test="${!empty agent }"><c:if test="${agent.level eq 1}">你已经是助理经纪人</c:if>
      												   <c:if test="${agent.level eq 2}">你已经是经纪人</c:if>
              										   <c:if test="${agent.level eq 3}">你已经是金牌经纪人</c:if></c:if>
              										   <c:if test="${empty agent }">你还不是经纪人</c:if></strong> 
              										   </div></div>
              										   
      </div>
      
      <div class="box4"><c:if test="${empty agent }"><button class="am-btn am-btn-secondary" onclick="becomeMiddle()">申请成为经纪人</button></c:if></div>
      <div class="box3">
        <div style="font-size:16px;margin-top:15px;margin-bottom:25px;width:100%">推荐方法</div>
        <div style="width:100%;height:45px;"><input type="text" id="referralURL" class="am-form-field" style="float:left;height:45px;width:540px;" value="http://www.biifoo.com/register.do?agentid=<shiro:principal property='id'/>"  disabled="disabled"><button type="button" id="copycardid"  class="am-btn am-btn-secondary" style="float:left;width:140px;height:45px;margin-left:-1px;">复制链接</button></div>
        <div style="font-size:14px;margin-top:15px;width:100%;margin-left:3px;">复制以上链接，发给您的好友</div>
      </div>

    </div>
  </div>
</div>
<script src="${ctx }/static/js/amazeui.js"></script>
<%@include file="../footer.jsp"%>
</body>
</html>
