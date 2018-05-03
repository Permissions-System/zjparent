<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<title>关于百富 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/joinus.css" rel="stylesheet" type="text/css">
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/information-05.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1000px;
	height:200px;
	margin-left:auto;
	margin-right:auto;
	padding-top:145px;
	
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	font-size:20px;
	color:#FFF;
	font-family:"微软雅黑";
	text-align:center;
	line-height:40px;
}

.banner .banner_txt .txt span {
	font-size: 40px;
}


</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
       $("#i1").attr("checked","checked");
});
	$(function(){
		$("#t1").click(function(){
			$("#i1").attr("checked","checked");
		
		})
	})
	$(function(){
		$("#t3").click(function(){
			$("#i3").attr("checked","checked");
		
		})
	})
	$(function(){
		$("#t5").click(function(){
			$("#i5").attr("checked","checked");
		
		})
	})
	$(function(){
		$("#t7").click(function(){
			$("#i7").attr("checked","checked");
		
		})
	})
	$(function(){
		$("#t9").click(function(){
			$("#i9").attr("checked","checked");
		
		})
	})
	
	
</script>
</head>

<body>
<jsp:include page="informationHeader.jsp"/><!--网站logo 导航条  end-->

<div class="banner">
  <div class="banner_txt">
    <div class="txt"><span>信任　责任　专业　创新</span></div>
  </div>
</div>
<div style="width:100%;min-width:1200px;">
<div class="hs1">我们是谁？</div>
<div class="hst">互联网金融是一个能够改变世界的朝阳行业，<br>
虽然2013年才开始慢慢步入正轨，但是发展速度已经远远领先于绝大多数行业。<br>
据统计，2014年中国金融产品总规模为165万亿元人民币，而互联网金融产品渗透率已经达到了61.3%。<br>
未来，互联网金融将会是一块超级大蛋糕，等着所有有志之士一起来分享。<br>
<br> 
百富网成立于2014年，虽然我们很年轻，但是有一个大梦想。<br>
就是帮助所有投资者实现财富增值，享受财务自由。<br>
也正是这个梦想，召唤了一大批来自阿里、百度、谷歌、新浪、苏宁、正大的业务专家一起拼搏一起奋斗，<br>
我们誓要将自己的名字镌刻在互联网金融的史册上，为青春留下浓墨重彩的一笔。
<br>同样是因为这个梦想，我们才大声高喊：We need U！<br>
愿你来百富，与我们一道，为梦想插上翅膀，然后展翅高翔！</div>
<div class="hs2">期待你的加入，我们会更强！</div>
<div class="hsm"><img src="${ctx}/static/images/joinico.png" width="727" height="56"  alt=""/><br>
  <br>
<br>
  <br>
<img src="${ctx}/static/images/line.png" width="900" height="1"  alt=""/></div>
<div class="hpic"><br>
  与Biifoo一起<br>
  <br>
<img src="${ctx}/static/images/joinpic-02.png" width="1000" height="405"  alt=""/></div>
<div class="jobx">
  <div class="job">
<div data-am-widget="tabs" class="am-tabs am-tabs-default" style="margin:0">
    <ul class="am-tabs-nav am-cf" style="background-color:#fff;height:49.5px;">
    	<c:forEach items="${articlecategoryList}" var="articlecategory" varStatus="status">
	      <li class="am-active" style="background-color:#EDEDED; font-size:20px; <c:if test='${status.count ne 1}'>margin-left:3px;</c:if> " >
	        <a href="[data-tab-panel-${status.index}]"  class="" onclick="getRecruit(${articlecategory.id},${status.count*2-1})" id="t${status.count*2-1}">${articlecategory.name}</a>
	      </li>
	    </c:forEach>
    </ul>
    <div class="am-tabs-bd">
      <div data-tab-panel-0 class="am-tab-panel am-active" id="text1">
      </div>
      <div data-tab-panel-1 class="am-tab-panel " id="text3">
      </div>
      <div data-tab-panel-2 class="am-tab-panel " id="text5">
      </div>
      <div data-tab-panel-3 class="am-tab-panel " id="text7">
      </div>
      <div data-tab-panel-4 class="am-tab-panel " id="text9">
      </div>
    </div>
  </div>
				
</div>
</div>
<div class="email">欢迎加入我们</div>
<div class="emailto">EMail：hr@baifu360.com</div></div>
<jsp:include page="../footer.jsp"/>

</body>
<script type="text/javascript">
function getRecruit(num,count){
  	 $.ajax({   
		     type: "post",  
		     url: "queryArticle.do",   
		     data: {categoryid:num},  
		     dataType: "json",    
		     success: function (data) { 
		    	 var html="";
		    	 html+="<div class='tab-container'>";
		    	 for(var i=0;i<data.results.length;i++){
		    		 if(i==0){
		    			 html+="<label class='tab-label'>";
		    			 html+="<input class='tab-radio' type='radio' name='page' value='page1' id='i"+count+"' checked='checked'/>";
		    			 html+="<p class='tab'>"+data.results[i].title+"</p>";
		    			 html+="<div class='tab-page' id='page1' style='left:0;'>";
		    			 html+="<p>"+data.results[i].content+"</p>";
		    			 html+="</div></label>";
		    		 }else{
		    			 html+="<label class='tab-label' id='page"+(i+1)+"'>";
		    			 html+="<input class='tab-radio' type='radio' name='page' value='page"+(i+1)+"'/>";
		    			 html+="<p class='tab' id='page"+(i+1)+"'>"+data.results[i].title+"</p>";
		    			 html+="<div class='tab-page' id='page2"+(i+1)+"' style='left:0'>";
		    			 html+="<p id='page2"+(i+1)+"'>"+data.results[i].content+"</p>";
		    			 html+="</div></label>";
		    		 }
		    	 }
		    	 html+="</div>";
		    	 $('#text'+count).html("");
		    	 $('#text'+count).html(html);
		    },  
		    error: function (data) {
		    	console.info(data);
		    }    
		});        
	}  
window.onload=function(){
	$('#t1').trigger("click");
}
</script>
</html>
