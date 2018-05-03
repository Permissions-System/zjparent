<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>我的红包 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>
<script src="${ctx }/static/js/amazeui.js"></script>
<style type="text/css">
.box1 {
	width:765px;
	height:140px;
	margin-top:25px;
	margin-left:5px;
}

.box2 {
	width:355px;
	height:135px;
	border-color:#e0e0e0;
	border-width:1px;
	border-style:solid;
	float:left;
	margin-left:18px;
	background-image:url(images/dayrich.jpg);
	padding:24px;
	padding-top:15px;
	line-height:25px;
	font-size:16px;
}

.box3 {
	width:765px;
	height:190px;
	border-color:#e0e0e0;
	border-width:1px;
	border-style:solid;
	margin-top:120px;
	margin-left:5px;
	padding-left:22px;
}
</style>
<style type="text/css">
.classic {
	width:900px;
	height:50px;
	margin-top: 20px;
	margin-left:auto;
	margin-right:auto;
}

div.black2 {
	font-family: "Myriad Pro";
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 10px;
	margin: 3px;
	padding-top: 10px;
	text-align: right;
	float: left;
	width: 780px;
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
	background-color: #666;
	border: 1px solid #565A5C;
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
	background-color: #565A5C;
	border: 1px solid #565A5C;
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
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
	$(function(){
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if(data.result == null || data.result.length==0){
				html+='<tr><td colspan="5">无任何信息</td></tr>';
			}
			for(var i=0;i<data.result.length;i++){
				   if(i%2 == 0){
					   html+="<tr style='height:40px; background-color:#fff'>";
				   }else{
					   html+="<tr style='height:40px; background-color:#fff'>";
				   }
				html+="<td style='vertical-align:middle;'>"+$.format.date(new Date(data.result[i].transTime), 'yyyy-MM-dd hh:mm:ss')+"</td>";
				html+="<td name='amount' style='vertical-align:middle;'>"+data.result[i].bidClassName+"</td>";
				html+="<td name='bidclassname' style='vertical-align:middle;'>"+data.result[i].amount+"</td>";
				if(data.result[i].transCode==1031){
				html+="<td style='vertical-align:middle;'>投资冻结</td>";	
				}else if(data.result[i].transCode==1032){
				html+="<td style='vertical-align:middle;'>流标返还</td>";	
				}else if(data.result[i].transCode==1033){
				html+="<td style='vertical-align:middle;'>赎回扣返</td>";	
				}else if(data.result[i].transCode==1034){
				html+="<td style='vertical-align:middle;'>成功使用</td>";		
				}else{
				html+="<td style='vertical-align:middle;'>--</td>";	
				}
				html+="<td name='bidclassname' style='vertical-align:middle;'>"+data.result[i].memberAvailAmount+"</td>";
				html+="</tr>";
			   }
				$table.html("");
				$table.html(html);
			   var $pager = $(".classic .black2");
			   var pagehtml = "";
				//判断是不是第一页决定是否显示前一页标签
				if(data.currentPageNo==1){
					pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
				}
				if(data.currentPageNo != 1){
					var pre = data.currentPageNo-1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a>";
				}
				if(data.currentPageNo > 5){
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+1+"\">1</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+2+"\">2</a>";
					pagehtml += "<span>. . .</span>";
				}
				var begin;
				var end;
				if (data.currentPageNo-3<1) {
					begin = 1;
				} else {
					begin = data.currentPageNo-3;
				}
				if (data.totalPageCount < data.currentPageNo + 3) {
					end = data.totalPageCount;
				} else {
					end = data.currentPageNo + 3;
				}
				//从action中获取分页页码下表的开始和结束下标
				for(var i=begin;i<=end;i++){
					if(data.currentPageNo == i){
						pagehtml += "<span class=\"current\">"+i+"</span>";
					}
					if(data.currentPageNo != i){
						pagehtml += "<a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a>";
					}
				}
				var less = data.totalPageCount-data.currentPageNo;
				if(less >= 5){
					var endb = data.totalPageCount-1;
					pagehtml += "<span>. . .</span>";
					//显示尾页下标
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a>";
				}
				//判断是不是最后一页，决定是否显示后一页下标
				if(data.currentPageNo != data.totalPageCount){
					var next = data.currentPageNo+1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+next+"\">> </a>";
				}
				if(data.currentPageNo == data.totalPageCount){
					pagehtml += "<span>&nbsp;&nbsp; > </span>";
				}
				$pager.html("");
				$pager.html(pagehtml);
			
		}
		
		$(".classic .black2 a").live("click",function(e){
			e.preventDefault();
			current = $(this).attr("value"); 
			$.post("${ctx}/member/ajaxRedpacketUseRecord.do", {pageNow : current}, function(data){
				getPager(data);
			});
		});	
		
		$.post("${ctx}/member/ajaxRedpacketUseRecord.do", {pageNow : 1}, function(data){
				getPager(data);
		});
	});
</script>
</head>

<body>
<%@include file="../header.jsp" %>
<!--网站logo 导航条  end-->
<div class="person_info">
  <%@include file="left.jsp"%>
  <div class="person_info_right">
    <div class="member_h" style="width:95%"><img src="${ctx }/static/images/member_icon06.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 我的红包</span></div>
    <div class="personalinfo" style="margin-top:50px;">
      
      <div style="margin-left:23px; font-size:18px; color:#565A5C">红包使用记录：</div>
      <hr data-am-widget="divider" style="width:90%;margin-left:20px; margin-top:10px;" class="am-divider am-divider-default" />
     <div style="height:530px;"> 
     <table class="am-table am-table-striped" style="margin-bottom:0px; text-align:center; font-weight:normal;width:732px; font-size:13px; margin-left:23px;">
        <thead>
          <tr style="height:60px;">
            <th style="vertical-align:middle; width:20%">创建时间</th>
            <th style="vertical-align:middle; width:20%">关联产品</th>
            <th style="vertical-align:middle; width:20%">金 额</th>
            <th style="vertical-align:middle; width:15%">状 态</th>
            <th style="vertical-align:middle; width:25%">红包剩余额</th>
          </tr>
        </thead>
        <tbody id="table">
        </tbody>
       </table></div>
      <div class="classic">
     		<div class="black2"></div>
     	 </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
