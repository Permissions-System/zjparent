<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<script src="static/js/jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript"> 
    
    function withdraw(isRapid) { 
        $.ajax({ 
            type: "POST", 
            url: "pay/withdraw/withdraw.do", 
            data: "isRapid="+isRapid+"&amount=200&bankName=招商银行&bankAcountNo=1234561408016370871&bankSheng=上海市&bankShi=上海市&bankSubName=招商银行", 
            success: function(result) { 
            	console.log("isRapid="+isRapid , result.msg); 
            } 
        }); 
    } 
</script>
</head>
<body>
	<a href="pay/recharge/recharge.do?orderAmount=10000">recharge</a>
	<a href="javascript:void(0)" onclick="withdraw(true);">RapidWithdraw</a>
	<a href="javascript:void(0)" onclick="withdraw(false);">withdraw</a>
</body>
</html>