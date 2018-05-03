<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page buffer="15kb"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<body>
	<form action="${req_action}" id="recvForm" method="post">
		<ul>
			<li><input type="hidden" name="req_data" value='${req_data}' />
				<button name="next_btn" class="btn" type="submit" id="next_btn">连连支付</button></li>
		</ul>
	</form>
	<script language="javascript"> recvForm.submit();</script>
</body>
</html>

