<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://ckfinder.com" prefix="ckfinder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>Insert title here</title>
<link rel="Stylesheet" type="text/css"
	href="${ctx}/static/assets/css/jquery.validity.css" />
<script type="text/javascript" src="${ctx}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${ctx}/static/ckfinder/ckfinder.js"></script>
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.validity.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("input[name='borrowtype']").click(function(){
		$("#idnum").toggle();
	});
	if('${borrower.borrowtype ==1}'){
		$("input[name=borrowtype][value=1]").attr("checked",true);
	}
	if('${borrower.borrowtype ==2}'){
		$("input[name=borrowtype][value=2]").attr("checked",true);
	}
	
	
	
});
</script>
<script type="text/javascript">
        $(function() {
        	var rem="请输入，不能为空";
            $('form').validity(function() {
                $("#borrowername").require(rem);
            });
        });
</script>
</head> 
<body>

	<form action="saveBorrower.do" method="post" id="form">
	<input type="hidden" name="id" value="${borrower.id}">
		<table>
			<tr>
				<td>借款人编号：</td>
				<td>${borrower.borrowercode}</td>
			</tr>
			<tr>
				<td>借款人类型</td>
				<c:if test='${empty count || count eq 0 }'>
				<td><input type="radio"  name="borrowtype" value="1" checked="checked"/>机构 <input type="radio" name="borrowtype" value="2"/>个人</td>
				</c:if>
				<c:if test='${! empty count && count ne 0  }'><td>
				<c:if test="${borrower.borrowtype ==1}">机构</c:if>
				<c:if test="${borrower.borrowtype ==2}">个人</c:if>
				</td></c:if>
			</tr>
			<tr>
				<td>借款人名称：</td>
				<td><input type="text" name="borrowername" value="${borrower.borrowername}" datatype="require" id="borrowername"
				 	<c:if test='${! empty count && count ne 0}'>disabled="disabled"</c:if>  msg="不能为空"/><span></span></td>
				 	
			</tr>
			<tr id="idnum" >
				<td>借款人身份证号：</td>
				<td><input type="text" name="identno" value="${borrower.identno}"
					<c:if test='${! empty count && count ne 0}'>disabled="disabled"</c:if> /></td>
			</tr>
			<tr>
        		<td colspan="2">借款人简介：</td>
	      	</tr>
	      	<tr>
	        	<td colspan="2">
	        	<textarea cols="80" id="editor1" name="corpdesc" rows="10">${borrower.corpdesc}</textarea>
	        	<ckfinder:setupCKEditor basePath="ckfinder/" editor="editor1" />
				<ckeditor:replace replace="editor1" basePath="ckeditor/" />
				</td>
	        </tr>
	        <tr>
	        	<td><input type="submit" name="submit"   value="保存"></td>
	        	<td><button onclick="location='queryBorrowerList.do'" >取消</button></td>
	        </tr>
		</table>
	</form>
</body>
</html>