<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>天天富 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>

<script type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
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
	background-image:url(${ctx}/static/images/dayrich.jpg);
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
		
		
		$('#orderStatusDesc label').click(function(){
			var datevalue=$(this).find("input").val();
			$.post("${ctx}/member/ajaxttfrecord.do", {pageNow : 1,orderstatusdesc:datevalue}, function(data){
	  			getPager(data);
	  		});
		});
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if(data.result == null || data.result.length==0){
				html+='<tr><td colspan="3">无任何信息</td></tr>';
			}
			for(var i=0;i<data.result.length;i++){
				
				   if(i%2 == 0){
					   html+="<tr style='height:45px; background-color:#fff'>";
				   }else{
					   html+="<tr style='height:45px; background-color:#fff'>";
				   }
				html+="<td style='vertical-align:middle; width:20%'>"+data.result[i].investordercode+"</td>";
				html+="<td  style='vertical-align:middle; width:30%'>"+$.format.date(new Date(data.result[i].orderdate), 'yyyy-MM-dd HH:mm:ss')+"</td>";
				if(data.result[i].orderstatusdesc==0||data.result[i].orderstatusdesc==3){
					html+="<td  style='vertical-align:middle; width:20%; line-height:18px;'>买入　<span style='color:#3DB236;font-size:16px;'>+"+data.result[i].amount+"</span></td>";
				}else if(data.result[i].orderstatusdesc==9){
					html+="<td  style='vertical-align:middle; width:20%; line-height:18px;'>转出　<span style='color:#EA544A;font-size:16px;'>-"+data.result[i].amount+"</span></td>";	
				}
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
			var orderstatusvalue;
	  		var orderstatusradios = document.getElementsByName("options");
	  		 for ( var i = 0; i <orderstatusradios.length; i++) {
				  if (orderstatusradios[i].checked==true) {
					  orderstatusvalue=orderstatusradios[i].value;
				  }
			 }
	  		 if(orderstatusvalue==null){
	  			orderstatusvalue=0;
	  		 }
			$.post("${ctx}/member/ajaxttfrecord.do", {pageNow : current,orderstatusdesc:orderstatusvalue}, function(data){
				getPager(data);
			});
		});	
		$.post("${ctx}/member/ajaxttfrecord.do", {pageNow : 1,orderstatusdesc:"0"}, function(data){
			getPager(data);
		});
	});
</script>
</head>

<body>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
  <%@include file="left.jsp"%>
  <div class="person_info_right" style="background-image:url('${ctx}/static/images/person_img4.png')">
    <div class="member_h" style="width:95%"><img src="${ctx}/static/images/member_icon10.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 天天富</span></div>
    <div class="personalinfo" style="margin-top:50px;">
      <div class="box1">
        <div class="box2">天天富总金额：<br>
<br>
<span style="color:#EA544A;font-size:24px;"><fmt:formatNumber value="${amount}" type="number" maxFractionDigits="2" minFractionDigits="2"/></span> 元
        </div>
        
        <div class="box2">昨日收益：<br>
<br>
<span style="color:#EA544A;font-size:24px;"><fmt:formatNumber value="${lastincome}" type="number" maxFractionDigits="2" minFractionDigits="2"/></span> 元
        </div>
      </div>
      <div style="margin-left:23px;margin-top:15px;">
      <button type="button" class="am-btn am-btn-secondary" onclick="window.location.href='${ctx}/member/ttfrolloutIndex.do'" <c:if test="${amount == '0.00'}">disabled="disabled"</c:if>>转出至可用资金</button>
      </div>
      
      <div class="am-form-group" style="margin-left:23px;margin-top:100px;width:100%;margin-bottom:5px;">资金流向：
      <div class="am-btn-group" data-am-button id="orderStatusDesc">
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="options" id="option1" value="0"> 全部
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="options" id="option2" value="1"> 买入
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="options" id="option3" value="2"> 转出
  </label>
      </div>
     </div>
     <table class="am-table am-table-striped" style="margin-bottom:0px; text-align:center; font-weight:normal;width:752px; font-size:13px; margin-left:23px;">
        <thead>
          <tr style="height:50px;">
            <th style="vertical-align:middle; width:20%">订单号</th>
            <th style="vertical-align:middle; width:30%">创建时间</th>
            <th style="vertical-align:middle; width:20%">金额</th>
          </tr>
        </thead>
        <tbody id="table">
        </tbody>
       </table>
		 <div class="classic">
     		<div class="black2"></div>
     	 </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
