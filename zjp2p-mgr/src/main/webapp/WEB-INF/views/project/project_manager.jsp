<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
      <li>标的管理</li>
      <li class="am-active">借款项目管理</li>
    </ol>
  </div>
  <div class="searchpanel">
    <form class="am-form-inline" role="form">
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >项目编号：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text"  placeholder="请输入项目编号：" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" value="${map.projectcode}" id="projectcode" name="projectcode"></div>
      </div> 
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >项目名称：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入项目名称：" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" value="${map.projectname}" id="projectname" name="projectname"></div>
      </div>
       <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">还款方式：</label>
      <select id="doc-select-1" name="repaymentway" style="width:100px; height:30px; font-size:14px; color:#999">
       <option value="">全部</option>
	      <c:forEach items="${repaymentWay}" var="r">
	  		<option value="${r.key}" <c:if test="${map.repaymentway == r.key}">selected="selected"</c:if>>${r.value}</option>
	  	   </c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div>
    <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">项目状态：</label>
      <select id="doc-select-1" name="status" style="width:100px; height:30px; font-size:14px; color:#999">
       <option value="">全部</option>
      <c:forEach items="${projectStatus}" var="p">
  		<option value="${p.key}"  <c:if test="${map.status eq p.key }">selected="selected"</c:if> >${p.value}</option>
  	  </c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div><br>
	<div style="margin-left:18px; margin-top:15px; float:left;">添加时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;padding-top:0px; padding-bottom:0px;" id="beginTime" value="${map.beginTime}"/>
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;padding-top:0px; padding-bottom:0px;" id="endTime" value="${map.endTime}">
  </div>
  <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >借款方名称：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入担保机构名称：" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" value="${map.instname}" id="instname" name="instname"></div>
      </div>
  <button type="button" id="search" class="am-btn am-btn-success am-btn-sm" style="margin-top:15px;  height:30px; padding-top:6px;" onclick="jump(1)"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  <a href="editProject.do"><button type="button" class="am-btn am-btn-primary" style="margin-left:15px; margin-top:20px; float:left;"><span class=" am-icon-plus-square">　添加借款项目</span></button></a>
  <input type="hidden" name="subject" id="subject" value="" >
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">项目编号</th>
            <th style="text-align:center;">项目名称</th>
            <th style="text-align:center;">添加时间</th>
            <th style="text-align:center;">项目金额</th>
            <th style="text-align:center;">借款方名称</th>
            <th style="text-align:center;">还款方式</th>
            <th style="text-align:center;">项目状态</th>
            <th style="text-align:center;">包含标的数目</th>
            <th style="text-align:center;">操 作</th>
        </tr>
    </thead>
    <c:forEach items="${page.results}" var="project" varStatus="status">
    <tbody>
        <tr>
            <td>${status.count}</td>
            <td>${project.projectcode}</td>
            <td>${project.projectname}</td>
            <td><fmt:formatDate value="${project.opdate}" type="both"/></td>
            <td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"  value="${project.account}"/>元 </td>
            <td>${project.instname}</td>
            <td><c:forEach items="${repaymentWay}" var="r">
					<c:if test="${project.payway == r.key}">${r.value}</c:if>
	  	   		</c:forEach></td>
            <td><c:forEach items="${projectStatus}" var="p">
					<c:if test="${project.status == p.key}">${p.value}</c:if>
	  	   		</c:forEach></td>
            <td>${project.bidnum}</td>
            <td><c:if test="${project.status ne 1}"><a href="viewProject.do?id=${project.id}" target="_blank"><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看</button></a></c:if>
            	<c:if test="${project.status eq 1}">
            	<a href="editProject.do?id=${project.id}"><button type="button" class="am-btn am-btn-secondary am-btn-sm">编辑</button></a> 
            	</c:if> 
            	<button type="button" class="am-btn am-btn-secondary am-btn-sm"  <c:if test="${project.status ne 1}">disabled="disabled"</c:if> 
            	<c:if test="${project.status eq 1}"> onclick="deleteProject(${project.id})" </c:if> >删除</button>
            	<c:if test="${project.status eq 3}"><a href="changeStatus.do?id=${project.id}&status=${project.status}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="return confirm('您确定要启用该借款项目吗?*该借款项目启用后,可作为发布标的时待关联借款项目的选项出现')">开启</button></a></c:if>
            	<c:if test="${project.status ne 3}"><a href="changeStatus.do?id=${project.id}&status=${project.status}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="return confirm('您确定要禁用该借款项目吗?*该借款项目被禁用后,发布标的时无法关联到该借款项目')">冻结</button></a></c:if>
            </td>
        </tr>
    </tbody>
    </c:forEach>
</table>
<ul class="am-pagination am-pagination-right">
	        <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page.pageNow le 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page.pageNow gt 1 }">
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
			<c:if test="${(page.totalPageCount-page.pageNow) >= 4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="jump(${page.totalPageCount})">${page.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page.pageNow lt page.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page.pageNow ge page.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
</div>
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>

<form id="getTopost" action="queryProjectList.do" method="post">
  <input id="projectcodehidden" type="hidden" name="projectcode" />
  <input id="projectnamehidden" type="hidden" name="projectname" />
  <input id="instnamehidden" type="hidden" name="instname" />
  <input id="repaymentwayhidden" type="hidden" name="repaymentway" />
  <input id="statushidden" type="hidden" name="status" />
  <input id="beginTimehidden" type="hidden" name="beginTime" />
  <input id="endTimehidden" type="hidden" name="endTime" />
  <input id="pageNowhidden" type="hidden" name="pageNow" />
</form>
<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
function jump(num){
	var projectcode=$('#projectcode').val();
	var projectname=$('#projectname').val();
	var instname=$('#instname').val();
	var repaymentway=$("select[name='repaymentway']").val();
	var status=$("select[name='status']").val();
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	$('#projectcodehidden').val(projectcode);
	$('#projectnamehidden').val(projectname);
	$('#instnamehidden').val(instname);
	$('#repaymentwayhidden').val(repaymentway);
	$('#statushidden').val(status);
	$('#beginTimehidden').val(beginTime);
	$('#endTimehidden').val(endTime);
	$('#pageNowhidden').val(num);
	$('#getTopost').submit();
}

function deleteProject(id){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    url:'deleteProject.do?id='+id,     
	    success:function(data){
	    	if("1" == data.status){
	    			alert('删除成功');
	        		location.href = "queryProjectList.do";
	        	}
	    	if("0" == data.status){
	    		alert('已关联标的，无法删除');
        		location.href = "queryProjectList.do";
        	}
		}  
	});
}
</script>
</body>
</html>