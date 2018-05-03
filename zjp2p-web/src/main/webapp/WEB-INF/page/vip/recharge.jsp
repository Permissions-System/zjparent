<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>充值 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<style type="text/css">
.am-btn-bank {
	color: #565A5C;
	background-color: #fff;
	border-color: #DBDBDB;
}

.am-btn-bank2 {
	color: #565A5C;
	background-color: #fff;
	border-color: #DBDBDB;
}

.am-btn-bank:hover,.am-btn-bank:focus,.am-btn-bank:active,.am-btn-bank.am-active,.am-active .am-dropdown-toggle.am-btn-bank
	{
	color: #fff;
	background-color: #fff;
	border-color: #3C97EA;
	border-width: 2px;
}

.person_info2 {
	width: 1000px;
	margin-left: auto;
	margin-right: auto;
	height: 1080px;
}

.person_info2 .person_info_left2 {
	width: 175px;
	height: 1070px;
	margin-top: 23px;
	border-color: #CCC;
	border-width: 1px;
	border-style: solid;
	background-color: #EFEFEF;
	float: left;
}

.person_info2 .person_info_right2 {
	width: 815px;
	height: 1070px;
	margin-top: 23px;
	margin-left: 10px;
	float: left;
	background-image: url(images/person_img2.png);
	background-repeat: no-repeat;
}
</style>
<!--添加被选中  -->
<script type="text/javascript">
	$(function() {
		$("#all_check").find("a").removeClass();
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#quickPayDiv').hide();
		var currUserIdCard = '<shiro:principal property="idcard"/>';
		var bankno = "${membersafety.bankcardno}";
		if (bankno != '') {
			$("#bankno").html("***  " + bankno.substring(15));
		}
		if (currUserIdCard != '') {
			var length = currUserIdCard.length;
			$('#currUserIdCard').html(
					currUserIdCard.substring(0, 2) + '****'
							+ currUserIdCard.substring(length - 4, length));
		}
		$('.am-btn-bank').bind('click', function() {
			var val = $(this).children(':radio').val();
			if (val == 'QUICK_PAY') {
				$('#quickPayDiv').show();
			} else {
				$('#quickPayDiv').hide();
			}
		});
		$("#rechargeurl1")
				.click(
						function() {
							var bankId = $('input[name="bankId"]:checked')
									.val();
							var amount = $.trim($("#amount1").val());
							var datevalue;
							var dateradios = document
									.getElementsByName("bankId");
							var falg = $("#checkbox").is(":checked");
							if (!falg) {
								alert("充值前请同意《百富网资金管理规定》");
								return;
							}
							for ( var i = 0; i < dateradios.length; i++) {
								if (dateradios[i].checked == true) {
									datevalue = dateradios[i].value;
								}
							}
							if (datevalue == null) {
								alert("请选择充值方式");
								return;
							}
							if (amount == "") {
								alert("充值金额不能为空");
								return;
							}
							if (parseInt(amount) < 0) {
								alert("充值金额不能小于0");
								return;
							}
							if (parseInt(amount) > 1000000) {
								alert("充值金额一笔不能超过1000000");
								return;
							}
							$("#rechargeurl").trigger("click");
							if ('LL_PAY' == bankId) {
								window
										.open("${ctx}/pay/ll/recharge/recharge.do?orderAmount="
												+ amount);
								//window.open("${ctx}/pay/rechargeV2/recharge.do?orderAmount="+amount+'&bankId='+bankId);
							} else if ('QUICK_PAY' == bankId) {
								window
										.open("${ctx}/pay/ll/authRecharge/recharge.do?orderAmount="
												+ amount);
							}else if ('AUTH_PAY' == bankId) {
								window
								.open("${ctx}/pay/ll/wapRecharge/recharge.do?orderAmount="
										+ amount);
							} else {
								window
										.open("${ctx}/pay/rechargeV2/recharge.do?orderAmount="
												+ amount + '&bankId=' + bankId);
							}
						});
		$('#goSecuritycenter').click(function() {
			window.location.href = '${ctx}/member/securitycenter.do';
		});
	});
</script>
<c:if
	test="${membersafety.idcardifverified+membersafety.mobileifverified!=2 }">
	<script type="text/javascript">
		$(document).ready(function() {
			$("#doc-modal-1").modal({
				closeViaDimmer : 0
			});
			$('#doc-modal-1').modal('open');
		});
	</script>
</c:if>
</head>

<body>

	<%@include file="../header.jsp"%>
	<!--网站logo 导航条  end-->

	<div class="person_info" style="height: 1080px;">
		<%@include file="left.jsp"%>
		<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
			<div class="am-modal-dialog">
				<div class="am-modal-bd" style="font-size: 17px;">
					为了保护您的账户安全，充值前请前往<a href="securitycenter.do">账户认证</a>完成"实名认证"及"手机认证"！
				</div>
			</div>
		</div>
		<!-- bank logo start -->
		<div class="person_info_right"
			style="height:1020px;background-image:url(${ctx }/static/images/person_img2.png);background-repeat:no-repeat;">
			<div class="member_h">
				<img src="${ctx}/static/images/member_icon07.png"
					style="margin-top: -7px; vertical-align: middle" alt="" /><span
					style="color: #009CE4; font-size: 18px; line-height: normal;">
					充 值</span>
			</div>
			<div class="personalinfo" style="margin-top: 60px;">
				<div style="margin-left: 33px; font-size: 16px; color: #565A5C">
					网上银行：<span style="font-size: 14px;">（亲，使用此项支付，必须确认您已成功开通网上银行哦。）</span>
				</div>

				<div class="am-btn-group" data-am-button
					style="margin-left: 33px; margin-top: 15px;">

					<label name="bankIdLabel" class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 12px;">
						<input type="radio" name="bankId" value="ABC"><img
						src="${ctx }/static/images/recharge/bank_logo/ABC.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 4px; padding-left: 10px; margin-left: 10px;">
						<input type="radio" name="bankId" value="ICBC"><img
						src="${ctx }/static/images/recharge/bank_logo/ICBC.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 18px; margin-left: 10px;">
						<input type="radio" name="bankId" value="BOC"><img
						src="${ctx }/static/images/recharge/bank_logo/BOC.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 3px; padding-left: 20px; margin-left: 10px;">
						<input type="radio" name="bankId" value="CCB"><img
						src="${ctx }/static/images/recharge/bank_logo/CCB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 3px; padding-left: 20px; margin-left: 10px;">
						<input type="radio" name="bankId" value="CMB"><img
						src="${ctx }/static/images/recharge/bank_logo/CMB.gif" alt="" />
					</label><br> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 20px; margin-top: 15px;">
						<input type="radio" name="bankId" value="COMM"><img
						src="${ctx }/static/images/recharge/bank_logo/COMM.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 12px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CITIC"><img
						src="${ctx }/static/images/recharge/bank_logo/CITIC.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 18px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CIB"><img
						src="${ctx }/static/images/recharge/bank_logo/CIB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 8px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CEB"><img
						src="${ctx }/static/images/recharge/bank_logo/CEB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 8px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="SZPAB"><img
						src="${ctx }/static/images/recharge/bank_logo/SZPAB.gif" alt="" />
					</label><br> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 9px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CMBC"><img
						src="${ctx }/static/images/recharge/bank_logo/CMBC.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 15px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="BOS"><img
						src="${ctx }/static/images/recharge/bank_logo/BOS.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 13px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="HXB"><img
						src="${ctx }/static/images/recharge/bank_logo/HXB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 2px; padding-left: 13px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="GDB"><img
						src="${ctx }/static/images/recharge/bank_logo/GDB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 3px; padding-left: 13px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="BCCB"><img
						src="${ctx }/static/images/recharge/bank_logo/BCCB.gif" alt="" />
					</label><br> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 4px; padding-left: 13px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CZB"><img
						src="${ctx }/static/images/recharge/bank_logo/CZB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 4px; padding-left: 15px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="CBHB"><img
						src="${ctx }/static/images/recharge/bank_logo/CBHB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 3px; padding-left: 10px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="SPDB"><img
						src="${ctx }/static/images/recharge/bank_logo/SPDB.gif" alt="" />
					</label> <label class="am-btn am-btn-bank"
						style="width: 138px; height: 43px; padding-top: 3px; padding-left: 10px; margin-left: 10px; margin-top: 15px;">
						<input type="radio" name="bankId" value="SHRCB"><img
						src="${ctx }/static/images/recharge/bank_logo/SHRCB.gif" alt="" />
					</label> <br>

					<div
						style="width: 800px; height: 60px; margin-top: 155px; font-size: 16px">
						第三方支付：<span style="font-size: 14px;">（亲，微钱包由新浪支付提供，方式一：开通网上银行；方式二：可注册新浪支付账户，<br>
							绑定开通快捷支付，<span style="color: #1F92D3">此项无需开通网银哦</span>）
						</span>
					</div>
					<label class="am-btn am-btn-bank"
						style="width: 138px; height: 45px; padding-top: 1px; padding-left: 10px; margin-top: 10px; ">
						<input type="radio" name="bankId" value="LL_PAY"> <img
						src="${ctx }/static/images/lianlian_logo.png" alt="" />
					</label> 
					<label class="am-btn am-btn-bank"
						style="width: 138px; height: 45px; padding-top: 1px; padding-left: 10px; margin-top: 10px; margin-left: 10px;">
						<input type="radio" name="bankId" value="SINA_PAY"><img
						src="${ctx }/static/images/sina.png" alt="" />
					</label> 
					<label class="am-btn am-btn-bank"
						style="width: 138px; height: 45px; padding-top: 1px; padding-left: 10px; margin-top: 10px; margin-left: 10px;">
						<input type="radio" name="bankId" value="QUICK_PAY"> <img
						src="${ctx }/static/images/quick.jpg" alt="" />
					</label>
				</div>
				<div id="quickPayDiv" class="am-btn-group" data-am-button
					style="margin-left: 33px; margin-top: 15px">
					<c:choose>
						<c:when
							test="${membersafety.bankcode == 'ABC' or 
						membersafety.bankcode == 'ICBC' or
						membersafety.bankcode == 'CMB' or
						membersafety.bankcode == 'BOC' or
						membersafety.bankcode == 'CCB' or
						membersafety.bankcode == 'CEB' or
						membersafety.bankcode == 'HXB' or
						membersafety.bankcode == 'CITIC' or
						membersafety.bankcode == 'CIB' or
						membersafety.bankcode == 'PSBC' or
						membersafety.bankcode == 'SZPAB' or
						membersafety.bankcode == 'SPDB' or
						membersafety.bankcode == 'GDB' or
						membersafety.bankcode == 'CMBC'}">
						 <label class="am-btn am-btn-bank2"
								style="width: 245px; height: 43px; padding-top: 8px;"> <img
								src="${ctx }/static/images/withdraw/bank_logo/${membersafety.bankcode}.gif"
								alt="" /> <span
								style="vertical-align: 10px; font-size: 12px; margin-left: 20px"
								id="bankno"></span>
							</label>
							<div
								style="margin-left: 50px; margin-top: 10px; float: left; font-size: 14px">
								<shiro:principal property="realname" />
								(<span id="currUserIdCard"></span>)
							</div>
						</c:when>
						<c:when test="${!empty membersafety.bankcode}">
							为了更加严格的保障用户的资金安全，百富网进行了系统升级，认证的银行卡目前只支持以下14家银行：农业银行、工商银行、招商银行、中国银行、建设银行、光大银行、华夏银行、中信银行、兴业银行、邮储银行、平安银行、浦发银行、广发银行、民生银行。
您认证的银行卡不在该14家银行范围内，请联系客服热线400-9616-588进行更改银行卡。
						</c:when>
						<c:otherwise>
							<div
								style="margin-left: 50px; margin-top: 10px; float: left; font-size: 14px">
								请先前往<a id="goSecuritycenter" href="javascript:void(0)">账户认证</a>完成"银行卡绑定"
							</div>
						</c:otherwise>
					</c:choose>
				</div>
				<!-- bank logo end -->
				<div
					style="margin-left: 33px; margin-top: 40px; font-size: 16px; color: #565A5C">
					可用余额：<span style="color: #f00; font-size: 18px;" id="blance1">0.00</span>
					元
				</div>

				<div
					style="margin-left: 33px; margin-top: 40px; font-size: 16px; color: #565A5C; position: relative;">
					<span style="float: left">充值金额：</span> <input type="text"
						id="amount1" class="am-form-field am-radius"
						onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"
						onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}"
						style="width: 115px; height: 30px; float: left" /> <span
						style="float: left; margin-left: 30px; font-size: 14px; margin-top: 5px;">没有手续费哦~</span>
					<!-- <span style="display:block; position:absolute;font-size:14px;top:30px;">没有手续费哦~</span> -->
				</div>

				<div
					style="margin-left: 33px; margin-top: 110px; font-size: 16px; color: #565A5C">
					<label class="am-checkbox"> <input type="checkbox"
						checked="checked" id="checkbox" value="" data-am-ucheck checked>我已阅读并且同意<a
						href="${ctx }/static/protocol/biifoomanage.pdf" target="_blank">《百富网资金管理规定》</a>
					</label>
				</div>

				<div style="margin-left: 33px; margin-top: 30px; font-size: 16px;">
					<button type="button" id="rechargeurl1"
						class="am-btn am-btn-secondary">确认充值</button>
					<button type="button" style="display: none;"
						class="am-btn am-btn-secondary" id="rechargeurl"
						data-am-modal="{target: '#doc-modal-2', closeViaDimmer: 0, width: 500, height: 255}">确认充值</button>

					<div class="am-modal am-modal-no-btn" tabindex="-1"
						id="doc-modal-2">
						<div class="am-modal-dialog">
							<div class="am-modal-hd">
								充值信息确认<br>
								<hr data-am-widget="divider" style=""
									class="am-divider am-divider-default" />
								<a href="javascript: void(0)" class="am-close am-close-spin"
									data-am-modal-close>&times;</a>
							</div>
							<div class="am-modal-bd">
								请在新开支付页面完成充值后根据情况选择。<br>
								<div
									style="text-align: left; width: 300px; margin-left: auto; margin-right: auto; margin-top: 30px; font-size: 16px;">
									<span class="am-icon-check" style="color: #18B161;"></span>
									充值成功 您可选择： <a href="${ctx}/member/dealhistory.do?status=2">查看充值记录</a><br>
									<br> <span class="am-icon-times"
										style="color: #EA544A; margin-right: 3px;"> </span> 充值失败 建议尝试：
									<a href="recharge.do">重新充值</a>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="dealtips"
					style="margin-left: 33px; margin-top: 20px; height: 195px">
					<span style="color: #f00">温馨提示</span><br> 1. 充值是免费的。<br>
					2. 您的充值将会在10~15分钟内到账,请耐心等候。<br> 3.
					不同银行对线上支付均有不同的限额规定，如支付超过限额，请致电银行客服申请提高额度再来充值。各大银行的限额表您可查看：<a
						href="${ctx}/limited.jsp" target="_blank">《银行线上支付限额表》</a>。<br>
					4. 判定为风险、可疑交易的资金将通过第三方支付平台退回原卡，到账时间以发卡行通知为准。<br> 5.
					充值过程遇到问题，请致电客服，400-9616-588，或是联系QQ在线。
				</div>


			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>
