<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
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
	width:730px;
	height:890px;
	border-color:#e0e0e0;
	border-width:1px;
	border-style:solid;
	margin-top:20px;
	margin-left:23px;
	padding-left:22px;
	padding-top:30px;
	padding-right:22px;
	line-height:20px;
	font-size:14px;
}
</style>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog" style="height:320px;">
    <div class="am-modal-hd">激活收到的红包<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" > <span style="font-size:14px">请仔细核对您收到的红包编号及密码，然后进行激活。</span>
      <form class="am-form am-form-horizontal" style="width:90%; margin-top:30px; margin-left:auto; margin-right:auto">
        
        <div class="am-form" style="font-size:13px;">
          <div class="am-u-sm-4 " style="font-weight:normal; margin-top:5px;text-align:right">编号：</div>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="text" class="am-input-sm" id="user-name" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;">
          </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <div class="am-u-sm-4 " style="font-weight:normal; margin-top:42px;text-align:right">交易密码：</div>
          <div class="am-u-sm-8" style="text-align:left;margin-top:30px">
            <input type="password" class="am-input-sm" id="user-name" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;">
          </div>
        </div>
        
        <div style="margin-top:20px; margin-left:100px; float:left">
          <button type="button" class="am-btn am-btn-secondary" style="width:180px;">提 交</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
    </div>
  </div>
</div>

<%@include file="../header.jsp" %>

<div class="person_info" style="height: 1070px;">
<%@include file="left.jsp"%>
  <div class="person_info_right2" style="height:1070px;">
    <div class="member_h" style="width:95%"><img src="${ctx }/static/images/member_icon09.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 好友推荐</span></div>
    <div class="personalinfo" style="margin-top:50px;">
      <div style="width:100%;text-align:center;font-size:18px;color:#009CE4;margin-top:15px;margin-left:-20px;">推荐规则</div>
      <div class="box3">
<strong style="font-size:16px;">如何成为经纪人</strong><br>
1. 百富网注册用户且完成全部身份认证。<br>
2. 投资资金超过3000元。<br>
3. 经过其介绍的投资者不少于2人(不含经纪人本人)。
<br><br>
<strong style="font-size:16px;">返佣率</strong><br>
经纪人每发展一名投资用户，除获得红包奖励外，可按其所发展的投资人实际投资收益的5%-10%结算返佣。返佣比例是由该经纪人级别决定的。
助理经纪人的返佣比例为5%、经纪人为7%、金牌经纪人为10%。<br>
<br>
<strong style="font-size:16px;">经纪人等级升降</strong><br>
经纪人会随着自己名下投资者和投资者资产的变化自动升降级。经纪人分为三个档次：<br>
等级一：助理经纪人，指名下不少于2个活跃投资者，投资资金超过3000元并已完成全部身份认证；<br>
等级二：经纪人，指名下不少于10个活跃投资者，且人均投资额不低于50000元；<br>
等级三：金牌经纪人，指名下客户总投资额达到500万元。<br>
<br>
每个季度末进行经纪人等级的调整， 按3个月内的平均投资额；<br>
当经纪人名下的投资者数下降时，按相应标准降级；<br>
百富网举行年度经纪人奖励计划，并给予额外奖励。<br>
<br>
<strong style="font-size:16px;">单层制</strong><br>
经纪人为单层制，即经纪人只能从自己直接发展的投资者的投资中获取收益。<br>
<br>
<strong style="font-size:16px;">返佣来源</strong><br>
返佣来源为经纪人人名下的投资者投资收益的百分比，每个投资者的收益单独计算累计。若投资者收益为负数或小0.01元（提前赎回情况可能发生收益为负数），则不计入，也不累计。<br>
<br>
<strong style="font-size:16px;">佣金结算时间</strong><br>
经纪人名下投资者获得收益每日计算，投资用户标的终止的，同步结算。<br>
<br>
<strong style="font-size:16px;">返佣资金拨付和提现</strong><br>
佣金账户每月5号拨付给经纪人的一般账户，经纪人可提现或投资，后台可通过微信等方式提醒经纪人，佣金已经拨付进一般账户，并鼓励经纪人不提现，直接投资平台产品。<br>
<br>
<strong style="font-size:16px;">存量折现</strong><br>
经纪人可获得投资用户返佣仅限用户注册后12个月内；<br>
超出12个月后，投资用户留存并继续投资的，经纪人可获得额外奖励，奖励细则另行约定。<br>
<br>
<br>
</div>
      
    </div>
  </div>
</div>
<script src="${ctx }/static/js/amazeui.js"></script>
<%@include file="../footer.jsp"%>
</body>
</html>
