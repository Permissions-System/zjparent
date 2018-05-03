<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
			<tr>
				<td>担保机构编号：</td>
				<td>${vouchOrg.instcode}</td>
			</tr>
			<tr>
				<td>担保机构名称：</td>
				<td>${vouchOrg.instname}</td>
			</tr>
			<tr>
        		<td colspan="2">担保机构简介：</td>
	      	</tr>
	      	<tr>
	        	<td colspan="2">${vouchOrg.instdesc}</td>
	        </tr>
	        <tr>
	        	<td><input type="button" name="button"   value="关闭" onclick="javascript:window.self.close()"></td>
	        </tr>
		</table>
</body>
</html>