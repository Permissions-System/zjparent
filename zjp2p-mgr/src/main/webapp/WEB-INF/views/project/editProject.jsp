<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<link rel="Stylesheet" type="text/css"
	href="${ctx}/static/assets/css/jquery.validity.css" />
<link rel="Stylesheet" type="text/css" href="${ctx}/static/assets/css/jquery.validity.css" />
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript">
        $(function() {
        	var rem="请输入，不能为空";
        	var num="请输入大于0的任意数值";
        	var parnt = /^\d+(\.\d+)|[1-9](\d*)$/;
            $('form').validity(function() {
                $("#projectname").require(rem);
                $("#instcode").require(rem);
                $("#account").require().match(parnt,num);
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
  <form class="am-form"  action="saveProject.do" method="post">
  <input type="hidden" name="id" id="id" value="${project.id}" >
  <input type="hidden" name="projectcode" id="projectcode" value="${project.projectcode}" >
      <div class="tagcontent_f am-form-horizontal" style="padding-top:30px;">
      <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;float:left;">项目编号：</label>
            <div class="am-u-sm-10" style=" color:#999">
              <p>${project.projectcode}</p>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
           <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">项目名称：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="projectname" name="projectname" placeholder="输入项目名称" style="float:left; width:50%;" value="${project.projectname}"><span style="float:left; color:#F00; height:40px; line-height:40px; margin-left:10px; font-size:20px;"> *</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
          
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">项目金额：</label>
            <div class="am-u-sm-10">
              <input type="text" class="am-input-sm" id="account" name="account" placeholder="产品发布金额" style="float:left; width:50%;" value="<fmt:formatNumber value="${project.account}" type="number" maxFractionDigits="2" minFractionDigits="2"/>"><span style="float:left; height:40px; line-height:40px; margin-left:10px;">元</span>
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

      <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">选择借款方：</label>
            <div class="am-u-sm-10">
              <select class="am-input-sm" id="instcode" name="instcode" style=" width:55%;" onchange="changeInstname(this)">
               <option value="">请选择</option>
               <c:forEach items="${orgs}" var="org">
               	<option value="${org.borrowercode}"<c:if test="${project.instcode == org.borrowercode}"> selected="selected" </c:if>>${org.borrowername}</option>
               </c:forEach>
              </select>
              <input type="hidden" id="instname" name="instname">
            </div>
          </div>
          
          <div class="am-divider"><hr>
</div>

<!--          
          <div class="am-divider"><hr>
</div>
        
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">归还计算方式：</label>
            <div class="am-u-sm-10">
              <select id="payway" name="payway" style="width:55%;" class="am-input-sm">
        <option value="">选择归还方式</option>
        <c:forEach items="${repaymentway}" var="b">
        <c:if test="${project.payway == b.key}">
  		<option value="${b.key}" selected="selected">${b.value}</option>
  		</c:if>
  		<c:if test="${project.payway != b.key}">
  		<option value="${b.key}">${b.value}</option>
  		</c:if>
  	    </c:forEach>
      </select>
            </div>
          </div>
-->           
          <div class="am-divider"><hr>
</div>

<div class="am-form-group">
            <label for="user-name" class="am-u-sm-2 am-form-label" style="margin-top:-5px;">项目介绍：</label>
            <div class="am-u-sm-10">
            	<textarea class="" rows="5" id="subject" name="subject" maxlength="1000">${project.subject}</textarea>
              	<small>500字以内<span style="color:#F00;"> *</span></small> </div>
          </div>
          
          <div class="am-divider"><hr>
</div>
     </div>
    <div class="tagconfirm"><button type="submit" id="save" class="am-btn am-btn-secondary">保 存</button> 
    <button type="button" class="am-btn am-btn-secondary" onclick="location='queryProjectList.do'">取消</button></div>
  </form>
  </div>
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>
<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
window.onload=function(){
	$('#instcode').trigger("change");
}

function changeInstname(obj){
	var opt = obj.options[obj.selectedIndex];
	$('#instname').attr('value',opt.text);
}
</script>
</body>
</html>