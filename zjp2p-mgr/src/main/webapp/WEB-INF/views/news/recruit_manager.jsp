<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>

</head>
<body>
<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li>资讯管理</li>
      <li class="am-active">招聘</li>
    </ol>
  </div>
  <div class="searchpanel">
    <form class="am-form-inline" role="form">
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >招聘职位：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" value="${map.title}" type="text" placeholder="请输入标的名称" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" id="title" name="title"></div>
      </div>
      
	<div style="margin-left:18px; margin-top:15px; float:left;">发布时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;padding-top:0px; padding-bottom:0px;" id="beginTime" value="${map.beginTime}">
  </div>
  <div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px; padding-top:0px; padding-bottom:0px;" id="endTime" value="${map.endTime}">
  </div>
  <button type="button" id="search" class="am-btn am-btn-success am-btn-sm" style="margin-top:15px; margin-left:123px; height:30px; padding-top:6px;" onclick="jump(1)"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  <a href="editRecruit.do"><button type="button" class="am-btn am-btn-primary" style="margin-left:15px; margin-top:20px; float:left;"><span class=" am-icon-plus-square">　发布职位</span></button></a>
  
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">招聘职位</th>
            <th style="text-align:center;">所属类别</th>
            <th style="text-align:center;">发布时间</th>
            <th style="text-align:center;">发布人</th>
            <th style="text-align:center;">操 作</th>
        </tr>
    </thead>
    <c:forEach items="${page.results}" var="article" varStatus="status">
    <tbody>
        <tr>
            <td>${status.count}</td>
            <td>${article.title}</td>
            <td><c:forEach var="articlecategory" items="${articlecategoryList}">
            	<c:if test="${article.categoryid == articlecategory.id}">${articlecategory.name}</c:if>
            	</c:forEach></td>
            <td><fmt:formatDate value="${article.createDate}" type="both"/></td>
            <td>${article.author}</td>
            <td><a href="viewRecruit.do?id=${article.id}" target="_blank"><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看</button></a>
            	<a href="editRecruit.do?id=${article.id}"><button type="button" class="am-btn am-btn-secondary am-btn-sm">编辑</button></a> 
            	<a href="deleteRecruit.do?id=${article.id}"><button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="return confirm('删除吗?')">删除</button></a>  
            </td>
        </tr>
    </tbody>
    </c:forEach>
</table>
 <ul class="am-pagination am-pagination-right">
	        <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page.pageNow eq 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page.pageNow ne 1 }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow - 1})"> &lt;</a></li>
			</c:if>
			<c:if test="${page.pageNow > 4}">
				<li><a href="javascript:void(0)" onclick="jump(1)">1</a></li>
				<li><span>. . .</span></li>
			</c:if>
			<!-- 从action中获取分页页码下表的开始和结束下标 -->
			<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
				<c:if test="${page.pageNow eq i }">
					<li class="am-active"><span>${i}</span></li>
				</c:if>
				<c:if test="${page.pageNow ne i }">
					<li><a href="javascript:void(0)" onclick="jump(${i})">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${(page.totalPageCount-page.pageNow) >=4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="jump(${page.totalPageCount})">${page.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page.pageNow ne page.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page.pageNow eq page.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
</div>
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>

<form id="getTopost" action="queryRecruitList.do" method="post">
  <input id="titlehidden" type="hidden" name="title" />
  <input id="beginTimehidden" type="hidden" name="beginTime" />
  <input id="endTimehidden" type="hidden" name="endTime" />
  <input id="pageNowhidden" type="hidden" name="pageNow" />
</form>
<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
function jump(num){
	var title=$('#title').val();
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	$('#titlehidden').val(title);
	$('#beginTimehidden').val(beginTime);
	$('#endTimehidden').val(endTime);
	$('#pageNowhidden').val(num);
	$('#getTopost').submit();
}
</script>
</body>
</html>
