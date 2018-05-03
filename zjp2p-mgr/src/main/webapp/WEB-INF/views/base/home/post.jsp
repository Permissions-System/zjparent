<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${ctx}/static/js/pub/jquery-easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		var sid = "${sid}";
		var form = $('<form method="POST" name="jForm' +sid + '" id="jForm' + sid + '" target="_self" ></form>');
		$(form).appendTo("body");

		var html = self.parent.formHtml(sid);
		//追加
		$("#jForm" + sid).append(html);

		$(form).attr("action", self.parent.formUrls(sid));
		$(form).attr("method", "POST");
		$(form).submit();
	});
</script>
</head>
<body>
</body>
</html>
