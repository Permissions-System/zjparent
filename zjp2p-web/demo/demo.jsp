<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>shit</title>

<script type="text/javascript">
window.onload = function(){

	var object = document.getElementById('box')
	function loadImg (data){
			var i = 0;
			setInterval(function(){
				i++
				if(i>data){
					i=data
				}
				var imgLeft = -(i*44+(i*10))+'px'
				object.style.backgroundPosition = imgLeft+'\t'+'0px'
				object.innerHTML = i+'%';
			},50)
	
	}
	var data=${percent}
	loadImg(data);
}
</script>

<style type="text/css">
#box{
	width:44px;
	margin:120px auto 0 auto;
	height:44px;
	line-height:44px;
	text-align:center;
	background: url(${ctx}/static/images/investjd.png);
}
</style>

</head>
<body>

<div id="box"></div>

</body>
</html>
