<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta name="baidu-site-verification" content="jnjhLLGCoP" />
<meta property="qc:admins" content="1001377607621167763757164506230" />
<script type="text/javascript">
  var ctx = '${ctx}';
  
//解析Ajax请求失败的json错误信息
	function getJsonErrorMsg(data){
		var errorMsg = '';
		if(data && data.responseText){
			errorMsg = (eval('('+data.responseText+')')).string;
		}
		return errorMsg;
	}
    function butDisabled(but){
    	but.attr({"disabled":"disabled"});
		but.css("background-color","#C0C0C0");
		but.css("border-color","#C0C0C0");
		but.html("<i class='am-icon-spinner am-icon-spin'></i>处理中");
    }
    
    function butEnabled(but , butHtml){
    	but.removeAttr("disabled");
    	but.css("background-color","#36A2D8");
    	but.css("border-color","#36A2D8");
    	but.html(butHtml);
    	but.val(butHtml);
    }
</script>