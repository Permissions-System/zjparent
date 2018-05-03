<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<%@ taglib uri="http://ckfinder.com" prefix="ckfinder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctx}/static/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${ctx}/static/ckfinder/ckfinder.js"></script>  
 

</head>
	
<body>

    <table width="90%" border="0" cellpadding="0" cellspacing="0" class="tabl2">
      <tr>
         <td><label for="textfield">百富故事标题:</label></td>
         <td>${article.title}</td>
         <td><label for="textfield">seo描述:</label></td>
         <td>${article.seoDescription}</td>
         <td><label for="textfield">seo关键词:</label></td>
         <td>${article.seoKeywords}</td>
      </tr>
      <tr>
         <td><label for="textfield">seo标题:</label></td>
         <td>${article.seoTitle}</td>
         <td><label for="textfield">作者:</label></td>
         <td>${article.author}</td>
      </tr>
      <tr>
      <td colspan="3"><label>所属部门：</label>
		<select name="categoryid" id="categoryid"> 		
		<c:forEach items="${articlecategoryList}" var="articlecategory"> 
 		<option value="${articlecategory.id}"  <c:if test="${article.categoryid == articlecategory.id}">selected="selected"</c:if> >${articlecategory.name}</option> 
 		</c:forEach>
		</select>
		</td>
      </tr>
      <tr>
        <td colspan="5">百富故事内容：</td>
      </tr>
      <tr>
        <td colspan="5">${article.content}</td>
        </tr>
      <tr>
      	<td colspan="2"></td>
        <td><button onclick="javascript:window.self.close()" class="button">关 闭</button></td>
        <td colspan="2"></td>
      </tr>
      </table> 
</body>
</html>