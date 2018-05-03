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
<%@include file="pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<link rel="Stylesheet" type="text/css" href="${ctx}/static/assets/css/jquery.validity.css" />
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#redeemfee1").attr("disabled",true);
	$("#redeemfee2").attr("disabled",true);
	$("#pubdate").hide();
	
	var selectedOpt = $("#useProject").find("option:selected");
	$('#assureinstid').text($(selectedOpt).attr('instname'));
	
	if($("#ifredeem").attr("checked") == "checked"){
		$("#ifredeem1").attr("style","");
		$("#ifredeem2").attr("style","");
	} else {
		$("#ifredeem1").attr("style","display:none");
		$("#ifredeem2").attr("style","display:none");
	}
	
	$("input[name=pledgetype]").attr("checked",false);
	$("input[name=pledgetype1]").attr("checked",false);
	var type = $("#pledgetype").val();
	if(type.indexOf("0")!=-1){
		$("input[name=pledgetype]").attr("checked",true);
	}
	if(type.indexOf("1")!=-1){
		$("input[name=pledgetype1]").attr("checked",true);
	}
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
  <input type="hidden" name="bidstatus" id="bidstatus" >
  <input type="hidden" name="id" id="id" value="${bid.id}" >
    <div class="am-form-group">
      <label class="am-form-label">标的类型：</label>
      <c:forEach items="${bidtype}" var="b">
      <c:if test="${bid.bidtypeid == b.key}">
       <label class="am-radio-inline" style="margin-top:-6px;">
        <input type="radio"  value="${b.key}" name="bidtypeid" style="margin-top:8px;" checked="checked" disabled="disabled"> ${b.value}
      </label>
      <label for="bidtypeid"></label>
      </c:if>
      <c:if test="${bid.bidtypeid != b.key}">
       <label class="am-radio-inline" style="margin-top:-6px;">
        <input type="radio"  value="${b.key}" name="bidtypeid" style="margin-top:8px;" disabled="disabled"> ${b.value}
      </label>
      <label for="bidtypeid"></label>
      </c:if>
      </c:forEach>
    </div>
    <div class="tagcontent_f am-form-horizontal" style="padding-top:30px;">
      
      <div class="am-form-group am-input-group-sm">
            <label class="am-u-sm-2 am-form-label" style="margin-top:-10px;">产品编号：</label>
            <div class="am-u-sm-10" style=" color:#999">
              ${bid.bidcode}
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
           <div class="am-form-group am-input-group-sm">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">产品名称：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="bidclassname" name="bidclassname" placeholder="产品名称" style="float:left; width: 55%;" value="${bid.bidclassname}" disabled="disabled"><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          <div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">所属项目：</label>
						<div class="am-u-sm-10">
							<select id="useProject" name="projectcode" style="width: 55%;" class="am-input-sm"  disabled="disabled">
								<c:forEach items="${projects}" var="b">
								<c:if test="${b.projectcode == bid.projectcode}">
									<option value="${b.projectcode}" account="${b.account}" bidamount="${b.bidamount }" instname="${b.instname }" selected="selected">${b.projectname}</option>
								</c:if>
								<c:if test="${b.projectcode != bid.projectcode}">
									<option value="${b.projectcode}" account="${b.account}" bidamount="${b.bidamount }" instname="${b.instname }">${b.projectname}</option>
								</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
          <div class="am-divider"><hr>
</div>

					<div class="am-form-group am-input-group-sm">
						<label for="project" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">标的图片：</label>
						<div class="am-u-sm-10">
							<img id="showimg" src="${bid.bidimg}" />  
						</div>
					</div>
					
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-intro" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">产品介绍：</label>
            <div class="am-u-sm-10">
              <textarea class="" rows="5" id="bidclasssubject" name="bidclasssubject" maxlength="1000" disabled="disabled">${bid.bidclasssubject}</textarea>
              <small>500字以内<span style="color:#F00;"> *</span></small>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">产品发布金额：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="amount" name="amount" placeholder="产品发布金额" style="float:left; width:50%;" value='<fmt:formatNumber value="${bid.amount}" type="number" maxFractionDigits="2"/>' disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">元</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span><span style="float:left; color:#999; height:40px; line-height:40px; margin-left:10px; font-size:14px;">必须为投资起点的正倍数</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">投资期限：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="investperiod" name="investperiod" style="float:left; width: 25%;" value="${bid.investperiod}" disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">个月</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">募集期限：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="raiseperiod" name="raiseperiod" style="float:left; width: 150px;" value="${bid.raiseperiod}" disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">天</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">预计起息日：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" id="exptinterestdate" name="exptinterestdate" style="float:left; width: 250px;" value='<fmt:formatDate value="${bid.exptinterestdate}" pattern="yyyy-MM-dd"/>' disabled="disabled"><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">预计到期日：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" id="exptexpiredate" name="exptexpiredate" style="float:left; width: 250px;" value='<fmt:formatDate value="${bid.exptexpiredate}" pattern="yyyy-MM-dd"/>' disabled="disabled"><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">年化收益率：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="annualizedrate" name="annualizedrate" style="float:left; width: 150px;" value='<fmt:formatNumber value="${bid.annualizedrate}" type="number" maxFractionDigits="2"/>' disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">%</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">归还计算方式：</label>
            <div class="am-u-sm-10">
              <select id="repaymentway" name="repaymentway" style="width:55%;" class="am-input-sm" disabled="disabled">
        <option value="">选择归还方式</option>
        <c:forEach items="${repaymentway}" var="b">
        <c:if test="${bid.repaymentway == b.key}">
  		<option value="${b.key}" selected="selected">${b.value}</option>
  		</c:if>
  		<c:if test="${bid.repaymentway != b.key}">
  		<option value="${b.key}">${b.value}</option>
  		</c:if>
  	    </c:forEach>
      </select>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">预计最后到账日：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" id="exptlastacctdate" name="exptlastacctdate" style="float:left; width: 250px;" value='<fmt:formatDate value="${bid.exptlastacctdate}" pattern="yyyy-MM-dd"/>' disabled="disabled"><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">发行服务费设置：（一次性收取，进入风险保障金）
						</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="pubfee"
								name="pubfee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.pubfee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
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
							style="margin-top: -5px;">管理服务费设置：（按月收取，进入流动活动金）
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="yearservicefee"
								name="yearservicefee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.yearservicefee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
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
							style="margin-top: -5px;">信息服务费设置：（按月收取，进入流动保障金）
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="infofee"
								name="infofee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.infofee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
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
							style="margin-top: -5px;">逾期违约费设置：（还款到期日已截止3天内，按天计算，进入流动活动金）
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="overduefee"
								name="overduefee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.overduefee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
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
							style="margin-top: -5px;">欠付违约费设置：（还款到期日已截止3天后，按天计算，进入流动活动金）
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="unpaidfee"
								name="unpaidfee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.unpaidfee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
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
							style="margin-top: -5px;">风险保证金设置：（在放款时一次性收取，进入风险保障金）
							</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="riskmgrfee"
								name="riskmgrfee" style="float: left; width: 150px;" value="<fmt:formatNumber value="${bid.riskmgrfee}" type="number" maxFractionDigits="2"/>" disabled="disabled"><span
								style="float: left; height: 40px; line-height: 40px; margin-left: 10px;">%</span><span
								style="float: left; color: #F00; height: 40px; line-height: 40px; margin-left: 10px; font-size: 20px;">
								*</span>
						</div>
					</div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group am-input-group-sm">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">最小投资额：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="mininvestamount" name="mininvestamount" placeholder="不填写默认为100元" style="float:left; width: 40%;" value='<fmt:formatNumber value="${bid.mininvestamount}" type="number" maxFractionDigits="2"/>' disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">元</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
        </div>
        
        <div class="am-divider"><hr>
</div>
        
        <div class="am-form-group am-input-group-sm">
            <label for="user-name" class="am-u-sm-3 am-form-label" style="margin-top:-5px;margin-left:-8.4%">单笔最多投资总额：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="maxinvestamount" name="maxinvestamount" placeholder="不填写默认为产品发布金额" style="float:left; width: 40%;" value='<fmt:formatNumber value="${bid.maxinvestamount}" type="number" maxFractionDigits="2"/>' disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">元</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
        </div>
        
        <div class="am-divider"><hr>
</div>
        
        <div class="am-form-group am-input-group-sm">
            <label for="user-name" class="am-u-sm-3 am-form-label" style="margin-top:-5px; margin-left:-8.4%">单人最多购买份数：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="bidnum" name="bidnum" placeholder="不填写默认为剩余总份数" style="float:left; width: 40%;" value="${bid.bidnum}" disabled="disabled"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">份</span><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
        </div>
        
        <div class="am-divider"><hr>
</div>
        
      <div class="am-form-group">
      <label class="am-form-label" style="margin-left:50px;">
        <input type="checkbox" id="ifredeem" name="ifredeem" value="1" <c:if test="${bid.ifredeem == '1' }"> checked="checked"</c:if> disabled="disabled"> 是否允许提前赎回（如果允许，赎回费用请选择以下 1 种方式计算。）
      </label>
        </div>
        
    <div class="am-form-group" id="ifredeem2" style="display:none;">
      <label class="am-u-sm-3" style=" margin-left:70px;">
        <input type="radio" name="redeemfeetype" id="redeemfeetype2" value="2"<c:if test="${bid.redeemfeetype == 2}"> checked="checked"</c:if>>
        按投资总额比例计算
      </label>
      <input type="text" class="am-input-sm" id="redeemfee2" <c:if test="${bid.redeemfeetype == 2}"> value="${bid.redeemfee}"</c:if> style="float:left; width: 25%; margin-left:-5%;"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">%</span>
    </div>
    <input type="hidden" name="redeemfee" id="redeemfee">
    <div class="am-divider"><hr>
</div>
        
      <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">选择借款人：</label>
            <span>${bid.borrowername}</span>
            </div>
          
          <div class="am-divider"><hr>
</div>
        
      <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">选择担保机构：</label>
            <span>${bid.assureinstname}</span>
            </div><br>
          
			<div class="am-divider"><hr>
</div>

		<div class="am-form-group">
				<label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top: -5px;">质押：</label>
					<div class="am-u-sm-10">
						<input type="checkbox" name="pledgetype" value="0" disabled="disabled"/>资产质押 
						<input type="checkbox" name="pledgetype1" value="1" disabled="disabled"/>股权质押
						<input type="hidden" id="pledgetype" value="${bid.pledgetype}" />
					</div>
		</div><br>
					
			<div class="am-divider"><hr>
</div>
					
			<div class="am-form-group">
					<label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top: -5px;">保障方式：</label>
						<div class="am-u-sm-10">
							<textarea class="" rows="5" id="ensuretype"
								name="ensuretype" maxlength="1000" disabled="disabled">${bid.ensuretype}</textarea><small>500字以内<span style="color: #F00;"> *</span></small>
						</div>
					</div><br>
          
          <div class="am-divider"><hr>
</div>
        <div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">产品特色：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="remark" name="remark" value="${bid.remark}"
							style="width: 25%; margin-left: -5%;" disabled="disabled">
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
					<div class="am-form-group">
						<label for="user-name" class="am-u-sm-2 am-form-label"
							style="margin-top: -5px;">锁定期：</label>
						<div class="am-u-sm-10">
							<input type="text" class="am-input-sm" id="lockupperiod" name="lockupperiod" value="${bid.lockupperiod}"
							style="width: 25%; margin-left: -5%;" disabled="disabled">
						</div>
					</div>
					<div class="am-divider">
						<hr>
					</div>
        <div class="am-form-group">
      <label class="am-form-label" style="margin-left:50px;">前台发布时间：</label>
        </div>
        
        <div class="am-form-group">
      <label class="am-u-sm-3 " style=" margin-left:70px;">
        <input type="radio" name="doc-radio-1" value="1" checked  disabled="disabled"> 直接发布   
      </label>      
    </div>

    <div class="am-form-group">
      <label class="am-u-sm-3 " style=" margin-left:70px;">
        <input type="radio" name="doc-radio-1" value="2" disabled="disabled">
        定时发布
      </label>
      <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" id="pubdate" name="pubdate" style="float:left; width: 25%; margin-left:-13%;"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">
    </div>
    
    <div class="am-divider"><hr>
</div>
<!--         <div class="am-form-group"> -->
<!--       <label class="am-form-label" style="margin-left:50px;"> -->
<!--         <input type="checkbox" > 是否设定为预约： -->
<!--       </label> -->
<!--         </div> -->
        
<!--         <div class="am-form-group"> -->
<!--       <label class="am-u-sm-3 " style=" margin-left:70px; margin-top:5px;"> -->
<!--         预约截止时间         -->
<!--       </label> -->
<!--       <input type="date" class="am-input-sm" id="date" style="float:left; width: 25%; margin-left:-13%;"><span style="float:left; height:40px; line-height:40px; margin-left:10px;"> - </span> -->
<!--       <input type="date" class="am-input-sm" id="date" style="float:left; width: 25%; margin-left:10px;"> -->
<!--     </div> -->

          
    <button type="button" class="am-btn am-btn-secondary" onclick="location='bidManager.do'">返 回</button></div>
      </div></div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
