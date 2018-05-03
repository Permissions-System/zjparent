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
<title>新闻 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/news.css" rel="stylesheet" type="text/css">
<style type="text/css">
.banner {
	width: 100%;
	min-width:1200px;
	height: 345px;
	background-image: url(${ctx}/static/images/information-03.jpg);
	background-position: center;
}

.banner .banner_txt {
	width:1000px;
	height:240px;
	margin-left:auto;
	margin-right:auto;
	padding-top:155px;
	
}
.banner .banner_img {
	width:1000px;
	height:345px;
	margin-left:auto;
	margin-right:auto;
	background-image:url(${ctx}/static/images/news.png);
	background-repeat:no-repeat	
}

.banner .banner_txt .txt {
	margin-left:auto;
	margin-right:auto;
	font-size:38px;
	color:#FFF;
	font-family:"微软雅黑";
	text-align:center;
	line-height:40px;
	font-weight: normal;
}

.banner .banner_txt .txt span {
	font-size: 55px;
}

.classic {
	width:670px;
	height:50px;
	margin-top: 20px;
	float:right;
}

div.black2 {
	font-family: "arial";
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 10px;
	margin: 3px;
	padding-top: 10px;
	text-align: right;
	float: left;
	width:650px;
	font-size: 16px;
}
div.black2 a {
	padding-right: 8px;
	padding-left: 8px;
	padding-bottom: 5px;
	margin: 2px;
	color: #565A5C;
	padding-top: 5px;
	text-decoration: none;
	border: 1px solid #565A5C;
}
div.black2 a:hover {
	color: #fff;
	background-color: #1E92D2;
	border: 1px solid #1E92D2;
}
div.black2 a:active {
	color: #fff;
	background-color: #666;
	border: 1px solid #565A5C;
}
div.black2 span.current {
	padding-right: 8px;
	padding-left: 8px;
	font-size: 16px;
	padding-bottom: 5px;
	margin: 2px;
	color: #fff;
	padding-top: 5px;
	background-color: #1E92D2;
	border: 1px solid #1E92D2;
}
div.black2 s.disabled {
	border-right: #eee 1px solid;
	padding-right: 8px;
	border-top: #eee 1px solid; 
	padding-left: 8px;
	padding-bottom: 5x;
	margin: 2px;
	border-left: #eee 1px solid;
	color: #ddd;
	padding-top: 5px;
	border-bottom: #eee 1px solid
}

</style>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>


</head>

<body>
<jsp:include page="informationHeader.jsp"/><!--网站logo 导航条  end-->
<div class="banner">
<div class="banner_img">
    
  </div>
</div>
<div style="width:100%;min-width:1200px;">
<div class="content">
  <div class="content_left">
    <div class="content_title"><strong>新闻&amp;报道</strong></div>
    <div class="content_menu">
     <ul>
       <c:if test="${map.categoryid eq 21}"><li class="current" style="color: #349cd8;">百富新闻</li></c:if>
       <c:if test="${map.categoryid ne 21}"><li><a href="queryNewsAll.do?categoryid=21">百富新闻</a></li></c:if>
       <c:if test="${map.categoryid eq 22}"><li class="current" style="color: #349cd8;">媒体报道</li></c:if>
       <c:if test="${map.categoryid ne 22}"><li><a href="queryNewsAll.do?categoryid=22">媒体报道</a></li></c:if>
      </ul>
    </div>
  </div>
  <div class="content_right">
    <div class="content_h"><div style="margin-top:2px;float:left"><!-- Generator: Adobe Illustrator 17.0.0, SVG Export Plug-In  -->
<svg version="1.1"
	 xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:a="http://ns.adobe.com/AdobeSVGViewerExtensions/3.0/"
	 x="0px" y="0px" width="39.043px" height="25.422px" viewBox="0 0 39.043 25.422" enable-background="new 0 0 39.043 25.422"
	 xml:space="preserve">
<defs>
</defs>
<g>
	<g>
		<g>
			<g>
				<path fill="#565A5C" d="M33.144,9.169c-0.209,0-0.397-0.123-0.48-0.316c-0.119-0.279-0.263-0.542-0.428-0.785
					c-0.159-0.236-0.339-0.458-0.534-0.659l-0.038-0.034c-0.212-0.213-0.445-0.405-0.691-0.572
					c-0.252-0.169-0.516-0.314-0.784-0.427c-0.128-0.054-0.226-0.154-0.279-0.284c-0.054-0.129-0.052-0.27,0.003-0.397
					c0.08-0.193,0.269-0.318,0.48-0.318c0.068,0,0.138,0.013,0.201,0.04c0.341,0.145,0.664,0.32,0.962,0.522
					c0.303,0.204,0.588,0.439,0.849,0.697l0.088,0.089h-0.005c0.225,0.234,0.432,0.489,0.614,0.759
					c0.206,0.304,0.381,0.628,0.521,0.961c0.055,0.127,0.056,0.268,0.003,0.399c-0.052,0.129-0.149,0.23-0.277,0.284
					C33.284,9.155,33.215,9.169,33.144,9.169z"/>
			</g>
			<g>
				<path fill="#565A5C" d="M35.868,9.171c-0.234,0-0.442-0.159-0.502-0.387c-0.163-0.603-0.406-1.186-0.722-1.734
					c-0.315-0.54-0.701-1.043-1.154-1.497c-0.454-0.454-0.957-0.841-1.498-1.155c-0.543-0.316-1.126-0.558-1.735-0.723
					c-0.134-0.036-0.246-0.121-0.316-0.242c-0.07-0.121-0.088-0.26-0.053-0.395c0.061-0.228,0.268-0.387,0.503-0.387
					c0.046,0,0.09,0.006,0.134,0.017c0.69,0.186,1.359,0.466,1.988,0.829c0.628,0.364,1.205,0.806,1.715,1.317
					c0.507,0.508,0.949,1.084,1.315,1.714c0.362,0.624,0.641,1.292,0.829,1.988c0.035,0.134,0.017,0.274-0.053,0.396
					c-0.072,0.12-0.184,0.206-0.319,0.241C35.96,9.165,35.914,9.171,35.868,9.171z"/>
			</g>
			<g>
				<path fill="#565A5C" d="M38.52,9.171c-0.249,0-0.464-0.179-0.511-0.423c-0.187-0.937-0.512-1.847-0.968-2.701
					c-0.468-0.866-1.045-1.639-1.726-2.318c-0.688-0.691-1.469-1.271-2.318-1.726c-0.851-0.457-1.761-0.782-2.705-0.969
					c-0.135-0.027-0.253-0.105-0.331-0.22c-0.079-0.115-0.107-0.254-0.081-0.391C29.928,0.178,30.143,0,30.391,0l0.102,0.009
					c1.035,0.204,2.043,0.566,2.993,1.076c0.942,0.504,1.804,1.144,2.565,1.903c0.753,0.757,1.389,1.611,1.892,2.54
					c0.516,0.962,0.88,1.97,1.089,3.02c0.028,0.138-0.001,0.277-0.08,0.392c-0.077,0.115-0.197,0.195-0.334,0.22L38.52,9.171z"/>
			</g>
		</g>
		<g>
			<g>
				<path fill="#565A5C" d="M2.927,25.422C1.313,25.422,0,24.11,0,22.496V9.804C0,8.19,1.313,6.877,2.927,6.877h18.125
					c1.614,0,2.927,1.313,2.927,2.928v2.214l3.569-3.521c0.346-0.34,0.802-0.526,1.286-0.526h0.97c1.01,0,1.832,0.822,1.832,1.833
					v12.723c0,1.011-0.822,1.833-1.832,1.833h-0.97c-0.483,0-0.94-0.189-1.287-0.53l-3.568-3.519v2.185
					c0,1.615-1.313,2.927-2.927,2.927H2.927z M2.927,8.355c-0.798,0-1.449,0.65-1.449,1.45v12.691c0,0.798,0.651,1.449,1.449,1.449
					h18.125c0.798,0,1.449-0.65,1.449-1.449V9.804c0-0.799-0.65-1.45-1.449-1.45H2.927z M28.496,9.528l-4.487,4.435l-0.031,4.318
					l4.553,4.572l1.628,0.03V9.447H28.71L28.496,9.528z"/>
			</g>
		</g>
	</g>
</g>
<g>
	<path fill="#565A5C" d="M4.283,12.047c-0.268,0-0.489-0.22-0.489-0.489c0-0.27,0.22-0.489,0.489-0.489h14.64
		c0.27,0,0.489,0.219,0.489,0.489c0,0.268-0.219,0.489-0.489,0.489H4.283L4.283,12.047z"/>
	<path fill="#565A5C" d="M4.283,14.976c-0.268,0-0.489-0.218-0.489-0.489c0-0.268,0.22-0.489,0.489-0.489h14.64
		c0.27,0,0.489,0.22,0.489,0.489c0,0.27-0.219,0.489-0.489,0.489H4.283L4.283,14.976z"/>
	<path fill="#565A5C" d="M4.283,17.906c-0.268,0-0.489-0.22-0.489-0.489s0.22-0.489,0.489-0.489h14.64
		c0.27,0,0.489,0.22,0.489,0.489s-0.219,0.489-0.489,0.489H4.283L4.283,17.906z"/>
	<path fill="#565A5C" d="M4.283,20.835c-0.268,0-0.489-0.22-0.489-0.489c0-0.27,0.22-0.489,0.489-0.489h9.758
		c0.268,0,0.489,0.218,0.489,0.489c0,0.268-0.22,0.489-0.489,0.489H4.283L4.283,20.835z"/>
</g>
</svg></div>
    <c:choose>
    	<c:when test="${map.categoryid eq 21}">&nbsp;百富新闻</c:when>
    	<c:when test="${map.categoryid eq 22}">&nbsp;媒体报道</c:when>
    	<c:otherwise>百富新闻</c:otherwise>
    </c:choose></div>
    <div class="time">
    	<div class="ym">${timeList[0]}</div>
    	<c:forEach items="${timeList}" var="time" varStatus="status" begin="1">
    		<c:if test="${status.current eq timeList[status.index-1]}"><div class="ym2"></div></c:if>
    		<c:if test="${status.current ne timeList[status.index-1]}"><div class="ym3">${time}</div></c:if>
    	</c:forEach>
    </div>
    <div class="newslist">
    	<c:forEach items="${page.results}" var="news">
	      <a href="queryNewsOne.do?id=${news.id}" style="text-decoration:none;"><div class="news">
	        <table width="700" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td width="35" height="57"><img src="${ctx}/static/images/35.png" width="35" height="57"  alt=""/></td>
	            <td width="360" style="padding-right:30px;">${news.title}</td>
	            <td width="105" style="font-size:13px;padding-left:20px;"><fmt:formatDate value="${news.createDate}"  type="both" pattern="yyyy-MM-dd"/> </td>
	            <td width="8" style="font-size:13px;">&nbsp;</td>
	            <td width="192" rowspan="2">
	            <img <c:if test='${! empty news.thumbnail}'>src="${news.thumbnail}"</c:if>
						<c:if test='${empty news.thumbnail}'>src="static/images/news-02.jpg"</c:if>  width="191" height="149" style="margin-top: -4px;" alt=""/></td>
	          </tr>
	          <tr>
	            <td><img src="${ctx}/static/images/93.png" width="35" height="89"  alt=""/></td>
	            <td colspan="2" valign="top" style="font-size:13px; color:#8F9496; line-height:20px;">${news.content}</td>
	            <td valign="top">&nbsp;</td>
	          </tr>
	        </table>
	      </div></a>
		</c:forEach>
    </div>
<!-- 分页代码 -->
<div class="classic"><div class="black2">
<!-- 判断是不是第一页决定是否显示前一页标签 -->
		<c:if test="${page.pageNow eq 1 }">
			<span> &lt;&nbsp;&nbsp;</span>
		</c:if>
		<c:if test="${page.pageNow ne 1 }">
			<a href="queryNewsAll.do?pageNow=${page.pageNow - 1}&categoryid=${map.categoryid}" > &lt;</a>
		</c:if>
		<c:if test="${page.pageNow > 5}">
			<a href="queryNewsAll.do?pageNow=1&categoryid=${map.categoryid}" >1</a>
			<span>. . .</span>
		</c:if>
		<!-- 从action中获取分页页码下表的开始和结束下标 -->
		<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
			<c:if test="${page.pageNow eq i }">
				<span class="current">${i}</span>
			</c:if>
			<c:if test="${page.pageNow ne i }">
				<a href="queryNewsAll.do?pageNow=${i}&categoryid=${map.categoryid}" >${i}</a>
			</c:if>
		</c:forEach>
		<c:if test="${(page.totalPageCount-page.pageNow) >= 5}">
			<span>. . .</span>
			<!-- 显示尾页下标 -->
			<a href="queryNewsAll.do?pageNow=${page.totalPageCount}&categoryid=${map.categoryid}" >${page.totalPageCount}</a>
		</c:if>
		<!-- 判断是不是最后一页，决定是否显示后一页下标-->
		<c:if test="${page.pageNow ne page.totalPageCount }">
			<a href="queryNewsAll.do?pageNow=${page.pageNow + 1}&categoryid=${map.categoryid}" > > </a>
		</c:if>
		<c:if test="${page.pageNow eq page.totalPageCount }">
			<span>&nbsp;&nbsp; > </span>
		</c:if>
	</div></div>
  </div>
</div></div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
