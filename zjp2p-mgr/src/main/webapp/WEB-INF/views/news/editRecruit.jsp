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

 <form action="saveRecruit.do" method="post" >
 <input type="hidden" name="id" value="${article.id}"/>
    <table width="90%" border="0" cellpadding="0" cellspacing="0" class="tabl2">
      <tr>
         <td>
          <label for="textfield">招聘职位:</label>
          <input type="text" name="title"  value="${article.title}">
         </td>
         <td>
          <label for="textfield">seo描述:</label>
          <input type="text" name="seoDescription" value="${article.seoDescription}">
         </td>
         <td>
          <label for="textfield">seo关键词:</label>
          <input type="text" name="seoKeywords" value="${article.seoKeywords}">
         </td>
      </tr>
      <tr>
         <td>
          <label for="textfield">seo标题:</label>
          <input type="text" name="seoTitle" value="${article.seoTitle}">
         </td>
         <td>
          <label for="textfield">作者:</label>
          <input type="text" name="author" value="${article.author}">
         </td>
      </tr>
      <tr>
      <td colspan="3"><label>所属类别：</label>
		<select name="categoryid" id="categoryid"> 		
		<c:forEach items="${articlecategoryList}" var="articlecategory"> 
 		<option value="${articlecategory.id}"  <c:if test="${article.categoryid == articlecategory.id}">selected="selected"</c:if> >${articlecategory.name}</option> 
 		</c:forEach>
		</select>
		</td>
      </tr>
      <tr>
        <td colspan="5">招聘内容：</td>
      </tr>
      <tr>
        <td colspan="5">
        	<textarea cols="80" id="editor1" name="content" rows="10">${article.content}</textarea>
        	<ckfinder:setupCKEditor basePath="ckfinder/" editor="editor1" />
			<ckeditor:replace replace="editor1" basePath="ckeditor/" />
		</td>
        </tr>
      <tr>
      	<td colspan="2"></td>
        <td><input type="submit" name="submit" id="submit"  value="保存"></td>
        <td><button type="button" name="button" value="" onclick="location='queryRecruitList.do'">取消</button>
        <td colspan="1"></td>
      </tr>
      </table></form>   
</body>
</html>