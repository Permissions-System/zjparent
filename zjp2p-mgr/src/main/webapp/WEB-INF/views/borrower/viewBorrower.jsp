<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
			<tr>
				<td>借款人编号：</td>
				<td>${borrower.borrowercode}</td>
			</tr>
			<tr>
				<td>借款人类型：</td>
				<td><c:forEach items="${borrowtype}" var="o">
					 <c:if test="${borrower.borrowtype==o.key}">${o.value}</c:if>
				</c:forEach></td>
			</tr>
			<tr>
				<td>借款人名称：</td>
				<td>${borrower.borrowername}</td>
			</tr>
			<c:if test="${borrower.borrowtype == 1}">
			<tr>
				<td>借款人身份证号：</td>
				<td>${borrower.identno}</td>
			</tr>
			</c:if>
			<tr>
        		<td colspan="2">借款人简介：</td>
	      	</tr>
	      	<tr>
	        	<td colspan="2">${borrower.corpdesc}</td>
	        </tr>
	        <tr>
	        	<td><input type="button" name="button"   value="关闭" onclick="javascript:window.self.close()"></td>
	        </tr>
		</table>
</body>
</html>