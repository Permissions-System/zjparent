<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!doctype html>
<html>
<head>
<%@include file="pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet"
	type="text/css">
<link rel="Stylesheet" type="text/css"
	href="${ctx}/static/assets/css/jquery.validity.css" />
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#pubdate").hide();
						// 项目联调 start
						$("#useProject").change(function(){
							var selectedOpt = $(this).find("option:selected");
							$('#borrowercode').text($(selectedOpt).attr('instname'));
							$("input[name=borrowercode]").val($(selectedOpt).attr('instcode'));
							$("input[name=borrowername]").val($(selectedOpt).attr('instname'));
							// 可募集金额 = 项目金额-已募集金额
							var account = $(selectedOpt).attr('account');
							var bidamount = $(selectedOpt).attr('bidamount');
							if(!isNaN(account) && account !== null && account !== undefined && account !== ''){
								account = parseInt(account);
							}else{
								account = 0;
							}
							if(!isNaN(bidamount) && bidamount !== null && bidamount !== undefined && bidamount !== ''){
								bidamount = parseInt(bidamount);
							}else{
								bidamount = 0;
							}
							var surplusPublishAmount = account - bidamount;
							surplusPublishAmount = parseFloat(surplusPublishAmount) ;
							$('#surplusPublishAmountSpan').text(surplusPublishAmount);
						});
						$("#useProject").trigger("change");
						// 项目联调 end
						$("#ifredeem")
								.click(
										function() {
											if ($("#ifredeem").attr("checked") == "checked") {
												$("input[name=redeemfeetype]").val("2");
												$("#ifredeem2").attr("style",
														"");
											} else {
												$("input[name=redeemfeetype]").val("");
												$("#ifredeem2").attr("style",
														"display:none");
												$("#redeemfee").val("");
											}
										});
						$("input[name=doc-radio-1][value=1]").click(function() {
							$("#pubdate").val("");
							$("#pubdate").hide();
						});
						$("input[name=doc-radio-1][value=2]").click(function() {
							$("#pubdate").show();
						});

						$("input[name=bidtypeid][value=1]").attr('checked',
								'checked');

						$("#annualizedrate").blur(function(){
							$("#touzifee").html($(this).val());
							$("#itouzifee").val($(this).val());
							
							if($("#borrowerinterest").val() != '' && $("#borrowerinterest").val() != null && $("#borrowerinterest").val() != 'undefined'){
								$("#infofee").val(Number(($("#borrowerinterest").val()-$("#annualizedrate").val()).toFixed(2)));
							}
							if($("#iborrowerinterest").val() != '' && $("#iborrowerinterest").val() != null && $("#iborrowerinterest").val() != 'undefined'){
								$("#iinfofee").val(Number(($("#iborrowerinterest").val()-$("#annualizedrate").val()).toFixed(2)));
							}
						});
						
						$("#borrowerinterest").blur(function(){
							var parnt = /^\d+(\.\d+)|[1-9](\d*)$/;
							$.validity.start();
							$(this).require("请输入一个数值").match(parnt,"请输入一个数值");
							var result = $.validity.end();
							if(result.valid&&$("#annualizedrate").val()!=''&&$("#annualizedrate").val()!=null&&$("#annualizedrate").val()!='undefined'){
								$("#infofee").val(Number(($("#borrowerinterest").val()-$("#annualizedrate").val()).toFixed(2)));
							}
						});
						
						$("#iborrowerinterest").blur(function(){
							var parnt = /^\d+(\.\d+)|[1-9](\d*)$/;
							$.validity.start();
							$(this).require("请输入一个数值").match(parnt,"请输入一个数值");
							var result = $.validity.end();
							if(result.valid&&$("#annualizedrate").val()!=''&&$("#annualizedrate").val()!=null&&$("#annualizedrate").val()!='undefined'){
								$("#iinfofee").val(Number(($("#iborrowerinterest").val()-$("#annualizedrate").val()).toFixed(2)));
							}
						});
						
						function setVal() {
							if ($("#mininvestamount").val() == "") {
								$("#mininvestamount").val("100");
							}
							if ($("#maxinvestamount").val() == "") {
								$("#maxinvestamount").val($("#amount").val());

							}
							if ($("#bidnum").val() == ""
									&& $("#amount").val() != "") {
								var mun = parseInt($("#amount").val()) 
										/ parseInt($("#mininvestamount").val());
								$("#bidnum").val(mun);
							}
							if ($("#yearservicefee").val() == "") {
								$("#yearservicefee").val(0);
							}
							if ($("#riskmgrfee").val() == "") {
								$("#riskmgrfee").val(0);
							}
							if ($("#pubfee").val() == "") {
								$("#pubfee").val(0);
							}
							if ($("#unpaidfee").val() == "") {
								$("#unpaidfee").val(0);
							}
							if ($("#infofee").val() == "") {
								$("#infofee").val(0);
							}
							if ($("#overduefee").val() == "") {
								$("#overduefee").val(0);
							}
						}

						$("#save")
								.bind(
										"click",
										function() {
											$("#bidstatus").val("8");
											setVal();
											if (submitValidate()) {
												butDisabled($('#save'));
												$
														.ajax({
															type : "post",
															url : "saveBid.do",
															data : $('#myform')
																	.serialize(),
															success : function(
																	data) {
																if (data.status == "1") {
																	alert("保存成功");
																	$("#id")
																			.val(
																					data.result);
																	location.href = "bidManager.do";
																} else {
																	alert("保存失败");
																	butEnabled($('#save'), "保存");
																}
															},
															error : function(
																	data) {
																console
																		.info(data);
															}
														});
											}

										});
						$("#publish").bind(
								"click",
								function() {
									setVal();
									if (submitValidate()) {
										butDisabled($('#publish'));
										$("#myform").attr("action",
												"saveAndPublishBid.do")
												.submit();
									}
								});
						$("#preview").click(function() {
							window.open("preview.do?id=" + $("#id").val());
						});

						$.validity.setup({
							outputMode : "label"
						});
						var parnt = /^\d+(\.\d+)|[1-9](\d*)$/;
						var parnt2 = /^[0-9]*[1-9][0-9]*$/;
						var parnt3 = /^\d+|[1-9](\d*)$/;
						var dateParnt = /^\d{4}-\d{2}-\d{2}$/;
						var rem = "请输入，不能为空";
						var msg = "请输入大于0的任意数值";
						var dateMsg = "请输入正确的日期格式";
						function submitValidate() {
							$.validity.start();
							$("#bidclassname").require(rem);
							$("#bidclasssubject").require(rem);
							$("#amount").require(rem).match(parnt, msg);
							if($("input[name=bidtypeid]:checked").val() != '4'){
								$("#investperiod").require(rem).match(parnt, msg);
								$("#raiseperiod").require(rem).match(parnt, msg);
								$("#exptinterestdate").require(rem).match(
										dateParnt, dateMsg);
								$("#exptexpiredate").require(rem).match(dateParnt,
										dateMsg);
								$("#repaymentway").require(rem);
								$("#instcode").require(rem);
								$("#exptlastacctdate").require(rem);
								$("#yearservicefee").match(parnt3, msg);
								$("#riskmgrfee").match(parnt3, msg);
								$("#pubfee").match(parnt3, msg);
								$("#unpaidfee").match(parnt3, msg);
								$("#infofee").match(parnt3, msg);
								$("#overduefee").match(parnt3, msg);
								$("#maxinvestamount").match(parnt, msg);
								$("#bidnum").match(parnt2, msg);
							}
							
							$("#annualizedrate").require(rem).match(parnt, msg);
							$("#lockupperiod").match(parnt2, msg);
							$("#mininvestamount").require(rem)
									.match(parnt, msg);
							
							if ($("#ifredeem").attr("checked") == "checked") {
								$("#redeemfee").require(rem).match(parnt, msg);
							}
							if ($("input[name=doc-radio-1][value=2]").attr(
									"checked") == "checked") {
								$("#pubdate").require(rem).match(dateParnt,
										dateMsg);
							}
							var result = $.validity.end();
							console.info(result);
							if (result.valid) {
								return true;
							}
							return false;
						}

						function ajaxPost(url, dataParam, callback) {
							var retData = null;
							$.ajax({
								type : "post",
								url : url,
								data : dataParam,
								dataType : "json",
								success : function(data) {
									retData = data;
									if (callback != null && callback != ""
											&& callback != undefined)
										callback(data, status);
								},
								error : function(data) {
									console.info(data);
									//	 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
								}
							});
							return retData;
						}
						
						//是否上传标的图片
						$("#ischecked").html("未上传");
						$('.uploadButton').click(function() {
							var val = $("#imgfile").val();
							if(val === undefined || typeof val === 'undefined' || val == '' ){
								alert("请选择上传文件");
								return;
							}
							$.ajaxFileUpload({
								//跟具updateP得到不同的上传文本的ID
								url : 'upload.do', //需要链接到服务器地址
								secureuri : false,
								fileElementId : 'imgfile', //文件选择框的id属性（必须）
								dataType: 'text',
								success : function(data) {
									console.info(data);
									if(data.indexOf("/") == 0){
										$('#check').attr("checked", true);
										$("#ischecked").html("").html("已上传");
										$("#bidimg").val(data);
										alert('上传成功');
									} else {
										$('#check').attr("checked", false);
										$("#ischecked").html("").html("未上传");
										alert('上传失败');
									}
									
								},
								error : function(data, status, e) {
									alert('上传失败');
								}
							});
						});
					});
</script>
</head>
<body>

	<div class="backcontent">
		<div class="breadcrumb">
			<ol class="am-breadcrumb am-breadcrumb-slash">
				<li>首 页</li>
				<li class="am-active">标的管理</li>
			</ol>
		</div>
		<div class="tagcontent">
			<form class="am-form" id="myform" action="" name="bidForm" method="post" enctype="multipart/form-data">
				<input type="hidden" name="bidstatus" id="bidstatus"> <input
					type="hidden" name="id" id="id">
				<div class="am-form-group">
					<label class="am-form-label">标的类型：</label>
					<c:forEach items="${bidtype}" var="b">
						<label class="am-radio-inline" style="margin-top: -6px;">
							<input type="radio" value="${b.key}" name="bidtypeid"
							style="margin-top: 8px;"> ${b.value}
						</label>
						<label for="bidtypeid"></label>
					</c:forEach>
				</div>
				<div class="tagcontent_f am-form-horizontal"
					style="padding-top: 30px;">

					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">产品名称：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="bidclassname"
								name="bidclassname" placeholder="产品名称"
								style="float: left; width: 55%;" maxlength="18"><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								<small style="color: black;">9个字以内</small>*</span>
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
					<div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">所属项目：</label>
						<div class="am-u-sm-10">
							<select id="useProject" name="projectcode" style="width: 55%;" class="am-input-sm">
								<c:forEach items="${projects}" var="b">
									<option value="${b.projectcode}" account="${b.account}" bidamount="${b.bidamount }" instcode="${b.instcode}" instname="${b.instname }">${b.projectname}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					<div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">标的图片：</label>
						<div class="am-u-sm-10">
							<input type="file" id="imgfile" name="imgfile"/>
							<input type="button" class="uploadButton" value="上传" />
							<input id="check"  type="checkbox" name="check" disabled="disabled"><span id="ischecked"></span>
							<span id="imgurl" hidden="hidden"></span>  
							<input type="hidden" name="bidimg" id="bidimg" value="" />
							<small style="color: #F00;">仅支持gif、jpg、jpeg、png等图片格式<span style="color: #F00;"> *</span></small>
						</div>
					</div>
					
					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-intro" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">产品介绍：</label>
						<div class="am-u-sm-10">
							<textarea class="" rows="5" id="bidclasssubject"
								name="bidclasssubject" maxlength="64"></textarea>
							<small>32字以内<span style="color: #F00;"> *</span></small>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-intro" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">项目特色：</label>
						<div class="am-u-sm-10">
							<textarea class="" rows="5" id="projectfeature"
								name="projectfeature" maxlength="300"></textarea>
							<small>150字以内<span style="color: #F00;"> *</span></small>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">产品发布金额：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="amount" name="amount"
								placeholder="产品发布金额" style="float: left; width: 50%;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">元</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
<!-- 								（剩余可发金额： <span id="surplusPublishAmountSpan"> </span>元） -->
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">投资期限：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="investperiod"
								name="investperiod" style="float: left; width: 25%;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">个月</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">募集期限：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="raiseperiod"
								name="raiseperiod" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">天</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">预计起息日：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-form-field am-radius"
								data-am-datepicker="{format: 'yyyy-mm'}" id="exptinterestdate"
								name="exptinterestdate" style="float: left; width: 250px;"><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">预计到期日：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-form-field am-radius"
								data-am-datepicker="{format: 'yyyy-mm'}" id="exptexpiredate"
								name="exptexpiredate" style="float: left; width: 250px;"><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">年化收益率：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="annualizedrate"
								name="annualizedrate" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">归还计算方式：</label>
						<div class="am-u-sm-10">
							<select id="repaymentway" name="repaymentway" style="width: 55%;"
								class="am-input-sm">
								<option value="">选择归还方式</option>
								<c:forEach items="${repaymentway}" var="b">
									<option value="${b.key}">${b.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">预计最后到账日：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-form-field am-radius"
								data-am-datepicker="{format: 'yyyy-mm'}" id="exptlastacctdate"
								name="exptlastacctdate" style="float: left; width: 250px;"><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>
					
					<div class="am-divider">
						<hr>
					</div>
       <!-- 费用设置 -->
        <div class="am-form-group"><a href="#" data-am-modal="{target: '#doc-modal-1'}">
        <button type="button" class="am-btn am-btn-secondary">费用设置</button></a></div>
        
       <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog" style="height:500px;">
    <form  class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">发行服务费设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="ipubfee" name="ipubfee" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">管理服务费设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="iyearservicefee" name="iyearservicefee" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">借款人费率设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="iborrowerinterest" name="iborrowerinterest" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span> 
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">投资人费率：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="itouzifee" name="itouzifee" disabled="disabled" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span> 
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">信息服务费设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="iinfofee" name="iinfofee"  class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span> 
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">逾期违约费设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="ioverduefee" name="ioverduefee" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left; padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">欠付违约费设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="iunpaidfee" name="iunpaidfee" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:10px;height:40px;">风险保证金设置：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" id="iriskmgrfee" name="iriskmgrfee" class="am-input-sm"  autocomplete="off" style="width: 150px; height:30px;float:left;  padding-bottom:0px;margin-top:15px;">
            <span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;margin-top:10px;">%</span>
            </div>
        </div>
        
        
        <div style="margin-top:ghf0px; margin-left:100px; float:left">
          <button type="button" onclick="setup()" class="am-btn am-btn-secondary" style="width:180px;">设置完成</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>

        

					<div class="am-divider">
						<hr>
					</div>
			
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">发行服务费设置：
						</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="pubfee" disabled="disabled"
								name="pubfee" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（一次性收取，进入风险保障金）
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">管理服务费设置：
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="yearservicefee" disabled="disabled"
								name="yearservicefee" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（按月收取，进入流动保障金）
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">信息服务费设置：
							</label>
						<div class="am-u-sm-10"><span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">借款人费率：</span>
							<input type="text" class="am-input-sm" id="borrowerinterest" name="borrowerinterest" style="float: left; width: 150px;" disabled="disabled">
							<span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">% - 投资人费率：</span> 
							<span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;" id="touzifee"></span>
							<span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（按月收取，进入流动活动金）
								<input type="text" class="am-input-sm" id="infofee" name="infofee" style="float: left; width: 150px;" value="" disabled="disabled" >
								<span style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">逾期违约费设置：
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="overduefee" disabled="disabled"
								name="overduefee" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（还款到期日已截止3天内，按天计算，进入流动活动金）
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">欠付违约费设置：
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="unpaidfee" disabled="disabled"
								name="unpaidfee" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（还款到期日已截止3天后，按天计算，进入流动活动金）
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">风险保证金设置：
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="riskmgrfee" disabled="disabled"
								name="riskmgrfee" style="float: left; width: 150px;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>（在放款时一次性收取，进入风险保障金）
						</div>
					</div>
					
					<div class="am-divider">
						<hr>
					</div>

<!-- 					<div class="am-form-group"> -->
<!-- 						<label for="user-name" class="am-u-sm-2 am-form-label" -->
<!-- 							style="margin-top: -5px;">发行费用：</label> -->
<!-- 						<div class="am-u-sm-10"> -->
<!-- 							<input type="text" class="am-input-sm" id="pubfee" -->
<!-- 								name="pubfee" style="float: left; width: 150px;"><span -->
<!-- 								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;"> -->
<!-- 								*</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<div class="am-divider"> -->
<!-- 						<hr> -->
<!-- 					</div> -->

<!-- 					<div class="am-form-group"> -->
<!-- 						<label for="user-name" class="am-u-sm-2 am-form-label" -->
<!-- 							style="margin-top: -5px;">信息服务费：</label> -->
<!-- 						<div class="am-u-sm-10"> -->
<!-- 							<input type="text" class="am-input-sm" id="infofee" -->
<!-- 								name="infofee" style="float: left; width: 150px;"><span -->
<!-- 								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;"> -->
<!-- 								*</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<div class="am-divider"> -->
<!-- 						<hr> -->
<!-- 					</div> -->

<!-- 					<div class="am-form-group"> -->
<!-- 						<label for="user-name" class="am-u-sm-2 am-form-label" -->
<!-- 							style="margin-top: -5px;">逾期违约费：</label> -->
<!-- 						<div class="am-u-sm-10"> -->
<!-- 							<input type="text" class="am-input-sm" id="overduefee" -->
<!-- 								name="overduefee" style="float: left; width: 150px;"><span -->
<!-- 								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;"> -->
<!-- 								*</span> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 					<div class="am-divider"> -->
<!-- 						<hr> -->
<!-- 					</div> -->

<!-- 					<div class="am-form-group"> -->
<!-- 						<label for="user-name" class="am-u-sm-2 am-form-label" -->
<!-- 							style="margin-top: -5px;">欠付违约费：</label> -->
<!-- 						<div class="am-u-sm-10"> -->
<!-- 							<input type="text" class="am-input-sm" id="unpaidfee" -->
<!-- 								name="unpaidfee" style="float: left; width: 150px;"><span -->
<!-- 								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;"> -->
<!-- 								*</span> -->
<!-- 						</div> -->
<!-- 					</div>					 -->

<!-- 					<div class="am-divider"> -->
<!-- 						<hr> -->
<!-- 					</div> -->

					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">最小投资额：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="mininvestamount"
								name="mininvestamount" placeholder="不填写默认为100元"
								style="float: left; width: 40%;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">元</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-3 am-form-label"
							style="margin-top: -5px; margin-left: -8.4%">单笔最多投资总额：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="maxinvestamount"
								name="maxinvestamount" placeholder="不填写默认为产品发布金额"
								style="float: left; width: 40%;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">元</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group am-input-group-sm">
						<label for="user-name" class="am-u-sm-3 am-form-label"
							style="margin-top: -5px; margin-left: -8.4%">单人最多购买份数：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="bidnum" name="bidnum"
								placeholder="不填写默认为剩余总份数" style="float: left; width: 40%;"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">份</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label class="am-form-label" style="margin-left: 50px;"> <input
							type="checkbox" id="ifredeem" name="ifredeem" value="1">
							是否允许提前赎回（如果允许，赎回费用请选择以下 1 种方式计算。）
						</label>
					</div>

					<div class="am-form-group" id="ifredeem2" style="display: none;">
						<label class="am-u-sm-3" style="margin-left: 70px;"> 
							按投资总额比例计算
						</label> <input type="text" class="am-input-sm" id="redeemfee" name="redeemfee" value=""
							style="float: left; width: 25%; margin-left: -5%;"><span
							style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span>
					</div>
					<input type="hidden" name="redeemfeetype" value="">
					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">借款人：</label>
						<div class="am-u-sm-10">
							<span id="borrowercode"></span> 
							<input type="hidden"
								name="borrowercode">
							<input type="hidden"
								name="borrowername">
						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">担保机构：</label>
						<div class="am-u-sm-10">
							<select id="instcode" name="instcode" style="width:55%;" class="am-input-sm">
						        <option value="">选择担保机构</option>
						        <c:forEach items="${org}" var="b">
						        <c:if test="${bid.instcode == b.instcode}">
						  		<option value="${b.instcode}" selected="selected">${b.instname}</option>
						  		</c:if>
						  		<c:if test="${bid.instcode != b.instcode}">
						  		<option value="${b.instcode}">${b.instname}</option>
						  		</c:if>
						  	    </c:forEach>
						      </select>
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">质押：</label>
						<div class="am-u-sm-10">
							<input type="checkbox" name="pledgetype" value="0" />资产质押 
							<input type="checkbox" name="pledgetype1" value="1" />股权质押
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">保障方式：</label>
						<div class="am-u-sm-10">
							<textarea class="" rows="5" id="ensuretype"
								name="ensuretype" maxlength="1000"></textarea><small>500字以内<span style="color: #F00;"> *</span></small>
<!-- 							100%本息保障 <input type="hidden" name="ensuretype" value="1"> -->

						</div>
					</div>

					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">产品特色：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="remark" name="remark" value=""
							style="width: 25%; margin-left: -5%;float: left;" maxlength="20"><span style="float: left;">10个字</span>
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
					
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">锁定期：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="lockupperiod" name="lockupperiod" value=""
							style="width: 25%; margin-left: -5%;">
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>

					<div class="am-form-group">
						<label class="am-form-label" style="margin-left: 50px;">前台发布时间：</label>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 " style="margin-left: 70px;"> <input
							type="radio" name="doc-radio-1" value="1" checked> 直接发布
						</label>
					</div>

					<div class="am-form-group">
						<label class="am-u-sm-3 " style="margin-left: 70px;"> <input
							type="radio" name="doc-radio-1" value="2"> 定时发布
						</label> <input type="text" class="am-form-field am-radius"
							data-am-datepicker="{format: 'yyyy-mm'}" id="pubdate"
							name="pubdate"
							style="float: left; width: 25%; margin-left: -13%;">
					</div>

					<div class="am-divider">
						<hr>
					</div>

				<div class="am-form-group">
					<label class="am-form-label">标的属性：</label>
					 <input type="radio" name="ifvirtual" value="0" checked> 
							真实标
					 <input type="radio" name="ifvirtual" value="1" > 
							模拟标
				</div>

				<div class="am-divider">
						<hr>
					</div>
				</div>
				<div class="tagconfirm">
					<button type="button" id="save" class="am-btn am-btn-secondary">保
						存</button>
					<button type="button" id="publish" class="am-btn am-btn-secondary">保存并发标</button>
					<button type="button" class="am-btn am-btn-secondary"
						onclick="location='bidManager.do'">返 回</button>
				</div>
			</form>
		</div>
	</div>
	<footer>
		<p class="am-padding-left">© 2014 Biifoo.com Backend Management
			System Ver 1.0</p>
	</footer>

<script type="text/javascript">
function setup(){
	var pubfee=$('#ipubfee').val();
	if(pubfee==""){
		pubfee=0;
	}
	$('#pubfee').val(pubfee);
	var overduefee=$('#ioverduefee').val();
	if(overduefee==""){
		overduefee=0;
	}
	$('#overduefee').val(overduefee);
	var unpaidfee=$('#iunpaidfee').val();
	if(unpaidfee==""){
		unpaidfee=0;
	}
	$('#unpaidfee').val(unpaidfee);
	var yearservicefee=$('#iyearservicefee').val();
	if(yearservicefee==""){
		yearservicefee=0;
	}
	$('#yearservicefee').val(yearservicefee);
	var riskmgrfee=$('#iriskmgrfee').val();
	if(riskmgrfee==""){
		riskmgrfee=0;
	}
	$('#riskmgrfee').val(riskmgrfee);
	var borrowerinterest=$('#iborrowerinterest').val();
	if(borrowerinterest==""){
		borrowerinterest=0;
	}
	$('#borrowerinterest').val(borrowerinterest);
	var infofee=$('#iinfofee').val();
	if(infofee==""){
		infofee=0;
	}
	$('#infofee').val(infofee);
	var $modal = $('#doc-modal-1');
	$modal.modal('close');
}
</script>
	<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
