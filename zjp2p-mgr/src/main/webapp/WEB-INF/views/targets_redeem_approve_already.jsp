<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script>

</script>
</head>
<body>

<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li>标的管理</li>
      <li class="am-active">标的审批</li>
    </ol>
  </div>
  
  <div class="tag_h">用户ID:${investOrderApprove.investOrder.customerid}</div>
  
  <div class="tag_record_1">用户帐号：${investOrderApprove.member.email}　　　用户姓名：${investOrderApprove.member.realname}　　　注册时间：<fmt:formatDate value="${investOrderApprove.member.createDate}" type="both"/></div>
  
  <div class="tag_record_1">产品金额：<fmt:formatNumber type="number" maxFractionDigits="2" value="${investOrderApprove.investOrder.amount}"/>元</div>
  
  <div class="tag_record_1">产品的买入时间：<fmt:formatDate value="${investOrderApprove.investOrder.orderdate}" type="both"/></div>
  
  <div class="tag_record_1">产品申请提前赎回时间：<fmt:formatDate value="${investOrderApprove.approve.opdate}" type="both"/></div>
  
  <div class="tag_record_2">审批状态：<span style="color:#093"><c:forEach items="${approveSubject}" var="a">
							<c:if test="${investOrderApprove.approve.subject==a.key}">${a.value}</c:if>
						</c:forEach></span></div>
  
  <div class="tag_record_3">标的概要描述：</div>
  
  <div class="tag_record_1">
  	标的类型：<c:forEach items="${bidtype}" var="b">
		  		<c:if test="${investOrderApprove.bid.bidtypeid==b.key}">${b.value}</c:if>
		 	</c:forEach>　　　
  	标的状态： <c:forEach items="${bidstatus}" var="b">
				<c:if test="${investOrderApprove.bid.bidstatus==b.key}">${b.value}</c:if>
			</c:forEach></div>
  
  <div class="tag_record_1">标的名称：${investOrderApprove.bid.bidclassname}　　标的编号：${investOrderApprove.bid.bidcode}　<a href="${ctx}/approve/redeemToBid.do?bidcode=${investOrderApprove.bid.bidcode}" style="font-size:14px;">标的详情</a></div>
  
  <div class="tag_record_1">
  <c:if test="${investOrderApprove.bid.ifredeem == 1}"><input type="checkbox" checked="checked" disabled="disabled"> 允许提前赎回费用： 
  		<c:if test="${investOrderApprove.bid.redeemfeetype == 0}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${investOrderApprove.bid.redeemfee}"/></c:if>
  		<c:if test="${investOrderApprove.bid.redeemfeetype == 1}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${investOrderApprove.bid.redeemfee/100*investOrderApprove.bid.amount}"/></c:if>  元/笔</c:if>
  <c:if test="${investOrderApprove.bid.ifredeem != 1}"><input type="checkbox" disabled="disabled"> 不允许提前赎回</c:if>
  <input type="checkbox" disabled="disabled" checked="checked"> 不允许转让</div>
  
  <div class="tag_record_1" >标的金额：<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${investOrderApprove.bidamount}"/> 元　　　截止目前已募集金额：<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${investOrderApprove.bid.raisemoney}"/> 元　　　募集截止时间：<fmt:formatDate value="${investOrderApprove.bid.raiseenddate}"  type="both"/></div>
  
  <div class="tag_record_2">已投标人数：${count} 人　　　被赎回人次：${num} 次　　</div>
  
<%--   <div class="tag_record_3">公司账务参考：</div>
  
  <div class="tag_record_1">剩余流动保障金：${platformAcct.account} 元</div>
  
  <div class="tag_record_1" style="margin-bottom:30px;">本次最多可用流动保障金：100,000 元</div> --%>
  
  <div class="tagconfirm"><button onclick="location='redeemApproveList.do'" class="am-btn am-btn-secondary am-btn-sm">返回</button>
</div>
  </div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
