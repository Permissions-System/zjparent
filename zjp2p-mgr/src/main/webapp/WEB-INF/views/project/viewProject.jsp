<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
</head>
<body>
<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li>标的管理</li>
      <li class="am-active">借款项目管理</li>
    </ol>
  </div>
  

  <div class="tag_record_2">项目编号：${project.projectcode} &nbsp;&nbsp; 项目名称：${project.projectname}  &nbsp;&nbsp; 项目金额：<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${project.account}" />元 </div>
  
  <div class="tag_record_2">借款方：${project.instname}  &nbsp;&nbsp; 项目添加时间：<fmt:formatDate value="${project.opdate}" type="both"/>
  							还款方式 ：<c:forEach items="${repaymentway}" var="r">
										<c:if test="${project.payway == r.key}">${r.value}</c:if>
								  	</c:forEach> &nbsp;&nbsp; 剩余可发标的金额：${project.account-project.bidamount}元</div>
  

  
  	<div class="tag_record_2" style="height: 100px;">项目简介： ${project.subject }</div>
  
  	<div class="tag_record_2">项目所含标的列表：  共  ${fn:length(bidList)}条记录    </div>
  
  <table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
  	<thead>
  		<tr style="text-align:center;">
  			<th style="text-align:center;">序号</th>
  			<th style="text-align:center;">标的编号</th>
  			<th style="text-align:center;">标的金额</th>
  			<th style="text-align:center;">发标时间</th>
  			<th style="text-align:center;">发标操作人</th>
  		</tr>
  	</thead>
  	<tbody>
	  	<c:forEach items="${bidList}" var="bid" varStatus="status">
	  		<tr>
	  			<td>${status.count}</td>
	  			<td>${bid.bidcode}</td>
	  			<td><fmt:formatNumber value="${bid.amount}" minFractionDigits="2" maxFractionDigits="2"/> 元</td>
	  			<td><fmt:formatDate value="${bid.pubdate}" type="both"/></td>
	  			<td>${bid.membername}</td>
	  		</tr>
	  	</c:forEach>
  	</tbody>
  </table>
  <button onclick="javascript:window.self.close()" class="button">关 闭</button>
  </div>
</body>
</html>