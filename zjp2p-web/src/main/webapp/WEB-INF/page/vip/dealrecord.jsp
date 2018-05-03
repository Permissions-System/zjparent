<%@page import="com.zjgt.util.DateConverterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>交易记录 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
.classic {
	width:100%;
	height:50px;
	margin-top: 20px;
	margin-left:auto;
	margin-right:auto;
}

div.black2 {
	font-family: "微软雅黑";
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 10px;
	margin: 3px;
	padding-top: 10px;
	text-align: right;
	float: left;
	width: 750px;
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
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>

<script type="text/javascript">
	$(function(){
			var status="${status}";
			if(status==""||status==null){
				status=1;
			}
			// "起始日期""查询"按钮 click
			$('#date label').click(function(){
				var datevalue=$(this).find("input").val();
				var startdate;
				var enddate;
				if(datevalue=="search"){
					var startdate1=$("#startdate").val().split("-");
					var enddate1=$("#enddate").val().split("-");
					startdate=new Date(startdate1[0],startdate1[1]-1,startdate1[2]).getTime();
					enddate=new Date(enddate1[0],enddate1[1]-1,enddate1[2]).getTime()+1000*60*60*24-1;
				}
				if(datevalue==null||datevalue=="month"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*30;
				}
				if(datevalue=="today"){
					var date=$("#nowdate").val().split("-");;
					var startdate=new Date(date[0],date[1]-1,date[2]).getTime();
					var enddate=new Date(date[0],date[1]-1,date[2]).getTime()+1000*60*60*24-1;
				}
				if(datevalue=="trmonth"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*90;
				}
				if(datevalue=="year"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*365;
				}
				if(datevalue=="oneyear"){
					var startdate=new Date().getTime()-1000*60*60*24*365*2;
					var enddate=new Date().getTime()-1000*60*60*24*365;
				}
				var operastatusvalue;
				var osradios = document.getElementsByName("osoptions");
		  		 for ( var i = 0; i <osradios.length; i++) {
					  if (osradios[i].checked==true) {
						  operastatusvalue=osradios[i].value;
					  }
				 }
		  		 
		  		 if(operastatusvalue==null){
		  			operastatusvalue=status;
		  		 }
		  		var orderstatusvalue;
		  		var orderstatusradios = document.getElementsByName("oso");
		  		 for ( var i = 0; i <orderstatusradios.length; i++) {
					  if (orderstatusradios[i].checked==true) {
						  orderstatusvalue=orderstatusradios[i].value;
					  }
				 }
		  		 if(orderstatusvalue==null){
		  			orderstatusvalue=1;
		  		 }
		  		$.post("ajaxdetailhistory.do", {pageNow : 1,"startdate":startdate,"enddate":enddate,operastatusvalue:operastatusvalue,orderstatusvalue:orderstatusvalue}, function(data){
		  			getPager(data);
		  		});
		});
			// 交易类型 按钮
			$('#operastatus label').click(function(){
				var operastatusvalue=$(this).find("input").val();
				var datevalue;
				var dateradios = document.getElementsByName("dateoptions");
		  		 for ( var i = 0; i <dateradios.length; i++) {
					  if (dateradios[i].checked==true) {
						  datevalue=dateradios[i].value;
					  }
				 }
		  		var startdate;
				var enddate;
				if(datevalue=="search"){
					var startdate1=$("#startdate").val().split("-");
					var enddate1=$("#enddate").val().split("-");
					startdate=new Date(startdate1[0],startdate1[1]-1,startdate1[2]).getTime();
					enddate=new Date(enddate1[0],enddate1[1]-1,enddate1[2]).getTime()+1000*60*60*24-1;
				}
				if(datevalue==null||datevalue=="month"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*30;
				}
				if(datevalue=="today"){
					var date=$("#nowdate").val().split("-");;
					var startdate=new Date(date[0],date[1]-1,date[2]).getTime();
					var enddate=startdate+1000*60*60*24-1;
				}
				if(datevalue=="trmonth"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*90;
				}
				if(datevalue=="year"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*365;
				}
				if(datevalue=="oneyear"){
					var startdate=new Date().getTime()-1000*60*60*24*365*2;
					var enddate=new Date().getTime()-1000*60*60*24*365;
				}
		  		var orderstatusvalue;
		  		var orderstatusradios = document.getElementsByName("oso");
		  		 for ( var i = 0; i <orderstatusradios.length; i++) {
					  if (orderstatusradios[i].checked==true) {
						  orderstatusvalue=orderstatusradios[i].value;
					  }
				 }
		  		 if(orderstatusvalue==null){
		  			orderstatusvalue=1;
		  		 }
		  		$.post("ajaxdetailhistory.do", {pageNow : 1,"startdate":startdate,"enddate":enddate,operastatusvalue:operastatusvalue,orderstatusvalue:orderstatusvalue}, function(data){
		  			getPager(data);
		  		});
		});	
			// "交易状态" click
		$('#orderstatus label').click(function(){
				var orderstatusvalue=$(this).find("input").val();
				var datevalue;
				var dateradios = document.getElementsByName("dateoptions");
		  		 for ( var i = 0; i <dateradios.length; i++) {
					  if (dateradios[i].checked==true) {
						  datevalue=dateradios[i].value;
					  }
				 }
		  		var startdate;
				var enddate;
				if(datevalue=="search"){
					var startdate1=$("#startdate").val().split("-");
					var enddate1=$("#enddate").val().split("-");
					startdate=new Date(startdate1[0],startdate1[1],startdate1[2]).getTime();
					enddate=new Date(enddate1[0],enddate1[1],enddate1[2]).getTime()+1000*60*60*24-1;
				}
				if(datevalue==null||datevalue=="month"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*30;
				}
				if(datevalue=="today"){
					var date=$("#nowdate").val().split("-");;
					var startdate=new Date(date[0],date[1]-1,date[2]).getTime();
					var enddate=startdate+1000*60*60*24-1;
				}
				if(datevalue=="trmonth"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*90;
				}
				if(datevalue=="year"){
					var enddate=new Date().getTime()+1000*60*60*24;
					var startdate=enddate-1000*60*60*24*365;
				}
				if(datevalue=="oneyear"){
					var startdate=new Date().getTime()-1000*60*60*24*365*2;
					var enddate=new Date().getTime()-1000*60*60*24*365;
				}
		  		var operastatusvalue;
				var osradios = document.getElementsByName("osoptions");
		  		 for ( var i = 0; i <osradios.length; i++) {
					  if (osradios[i].checked==true) {
						  operastatusvalue=osradios[i].value;
					  }
				 }
		  		 
		  		 if(operastatusvalue==null){
		  			operastatusvalue=status;
		  		 }
		  		$.post("ajaxdetailhistory.do", {pageNow : 1,"startdate":startdate,"enddate":enddate,operastatusvalue:operastatusvalue,orderstatusvalue:orderstatusvalue}, function(data){
		  			getPager(data);
		  		});
		});	
		var memberid="${membersafety.memberid}";
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if(data.result == null || data.result.length==0){
				html+='<tr><td colspan="7">无任何信息</td></tr>';
			}
			for(var i=0;i<data.result.length;i++){
				   if(i%2 == 0){
					   html+="<tr>";
				   }else{
					   html+="<tr>";
				   }
				html+="<td>"+data.result[i].id+"</td>";
				html+="<td>"+$.format.date(new Date(data.result[i].transtime), 'yyyy-MM-dd HH:mm')+"</td>";
				if(data.result[i].transcode==1001){
					html+="<td>充值</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1002){
					html+="<td>提现</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1004){
					html+="<td>投资</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1003){
					html+="<td>赎回</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1005){
					html+="<td>放款</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1110){
					html+="<td>提前赎回手续费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1006){
					html+="<td>还款</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1007){
					html+="<td>分润</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1008){
					html+="<td>解冻</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1009){
					html+="<td>转账</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1010){
					html+="<td>调增</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1011){
					html+="<td>调减</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1012){
					html+="<td>提前还款</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1013){
					html+="<td>代偿</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1014){
					html+="<td>调增</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1015){
					if(data.result[i].paymemberid==memberid){
						html+="<td>投资</td>";
						html+="<td>会员</td>";
						
					}else{
						html+="<td>回收本金</td>";
						html+="<td>会员</td>";
					}
				}
				else if(data.result[i].transcode==1016){
					html+="<td>回收利息</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1017){
					html+="<td>提前赎回</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1018){
					html+="<td>流标</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1019){
					html+="<td>调拨</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1101){
					html+="<td>充值费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1102){
					html+="<td>提现手续费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1103){
					html+="<td>业务服务费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1104){
					html+="<td>账户管理费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1105){
					html+="<td>债权转让费</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1106){
					html+="<td>担保费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1107){
					html+="<td>央行征信认证费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1108){
					html+="<td>银行流水认证费</td>";
					html+="<td>平台</td>";
				}
				else if(data.result[i].transcode==1109){
					html+="<td>提前还款费</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1028){
					html+="<td>天天富利息</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1027){
					html+="<td>红包费</td>";
					html+="<td>会员</td>";
				}
				else if(data.result[i].transcode==1029){
					html+="<td>流标退款</td>";
					html+="<td>平台</td>";
				}else if(data.result[i].transcode==1035){
					html+="<td>佣金拨付</td>";
					html+="<td>会员</td>";
				}else if(data.result[i].transcode==1036){
					html+="<td>佣金返还</td>";
					html+="<td>平台</td>";
				}else{
					html+="<td>-</td>";
					html+="<td>-</td>";
				}
				
				html+="<td name='amount'>"+$.format.number(data.result[i].amount, '###,###.##')+"</td>";
				if(data.result[i].paymemberid==memberid){
					html+="<td>"+data.result[i].paysubamount+"</td>";
					
				}else{
					html+="<td>"+data.result[i].availamount+"</td>";
				}
				
				if(data.result[i].transstatus==1){
					html+="<td>成功</td>";
				}
				if(data.result[i].transstatus==0){
					html+="<td>处理中</td>";
					}
				if(data.result[i].transstatus==2){
					var str = '';
					if(data.result[i].transcode==1002 && data.result[i].remark!= ''){
						str ="<td>关闭("+data.result[i].remark+")</td>";
					}else{
						str ="<td>关闭</td>";
					}
					html+= str;
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
		// 分页按钮
		$(".classic .black2 a").live("click",function(e){
			e.preventDefault();
			current = $(this).attr("value");
			var orderstatusvalue;
	  		var orderstatusradios = document.getElementsByName("oso");
	  		 for ( var i = 0; i <orderstatusradios.length; i++) {
				  if (orderstatusradios[i].checked==true) {
					  orderstatusvalue=orderstatusradios[i].value;
				  }
			 }
	  		 if(orderstatusvalue==null){
	  			orderstatusvalue=1;
	  		 }
	  		var datevalue;
			var dateradios = document.getElementsByName("dateoptions");
	  		 for ( var i = 0; i <dateradios.length; i++) {
				  if (dateradios[i].checked==true) {
					  datevalue=dateradios[i].value;
				  }
			 }
	   		var startdate;
			var enddate;
			if(datevalue=="search"){
				var startdate1=$("#startdate").val().split("-");
				var enddate1=$("#enddate").val().split("-");
				startdate=new Date(startdate1[0],startdate1[1]-1,startdate1[2]).getTime();
				enddate=new Date(enddate1[0],enddate1[1]-1,enddate1[2]).getTime()+1000*60*60*24-1;
			}
			if(datevalue==null||datevalue=="month"){
				var enddate=new Date().getTime()+1000*60*60*24;
				var startdate=enddate-1000*60*60*24*30;
			}
			if(datevalue=="today"){
				var date=$("#nowdate").val().split("-");;
				var startdate=new Date(date[0],date[1]-1,date[2]).getTime();
				var enddate=startdate+1000*60*60*24-1;
			}
			if(datevalue=="trmonth"){
				var enddate=new Date().getTime()+1000*60*60*24;
				var startdate=enddate-1000*60*60*24*90;
			}
			if(datevalue=="year"){
				var enddate=new Date().getTime()+1000*60*60*24;
				var startdate=enddate-1000*60*60*24*365;
			}
			if(datevalue=="oneyear"){
				var startdate=new Date().getTime()-1000*60*60*24*365*2;
				var enddate=new Date().getTime()-1000*60*60*24*365;
			}

			var operastatusvalue;
			var osradios = document.getElementsByName("osoptions");
	  		 for ( var i = 0; i <osradios.length; i++) {
				  if (osradios[i].checked==true) {
					  operastatusvalue=osradios[i].value;
				  }
			 }
	  		 
	  		 if(operastatusvalue==null){
	  			operastatusvalue=status;
	  		 }

			$.post("ajaxdetailhistory.do", {pageNow : current,"startdate":startdate,"enddate":enddate,operastatusvalue:operastatusvalue,orderstatusvalue:orderstatusvalue}, function(data){
	  			getPager(data);
	  		});
		});	
		if(status==2){
			$()
			$.post("ajaxdetailhistory.do", {pageNow : 1,"enddate":new Date().getTime()+1000*60*60*24,"startdate":(new Date().getTime()-1000*60*60*24*30),operastatusvalue:2,orderstatusvalue:1}, function(data){
	  			getPager(data);
	  		});
		}else{
			$.post("ajaxdetailhistory.do", {pageNow : 1,"enddate":new Date().getTime()+1000*60*60*24,"startdate":(new Date().getTime()-1000*60*60*24*30),operastatusvalue:1,orderstatusvalue:1}, function(data){
	  			getPager(data);
	  		});
		}
	});
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
<%@include file="left.jsp"%>
  <div class="person_info_right">
  <input type="hidden" id="nowdate" value="${nowdate }">
    <div class="member_h"><img src="${ctx}/static/images/member_icon02.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 交易记录</span></div>
    <div class="personalinfo" style="margin-top:60px;">
      <div class="am-form-group" style="margin-left:5px;margin-bottom:10px;"><span style="float:left">起止日期：</span>
  <input id="startdate" type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm-dd'}" style="width:115px; height:30px; float:left"/> <span style="float:left">&nbsp;-&nbsp;</span> <input id="enddate" type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm-dd'}" style="width:115px; height:30px; float:left"/>
  <div class="am-btn-group" data-am-button style="margin-left:30px; margin-top:-5px" id="date">
 <label class="am-btn am-btn-biifoo am-btn-sm"  style="background-color:#3C97EA; color:#fff; margin-left:-20px; margin-right:45px; height:32px;margin-top:4px; padding-top:7px;">
    <input type="radio" name="dateoptions" id="doption0" value="search"> 查询
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="dateoptions" id="doption1" value="today"> 今天
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="dateoptions" id="doption2" value="month"> 最近一个月
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="dateoptions" id="doption3" value="trmonth"> 3个月
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="dateoptions" id="doption3" value="year"> 1年
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="dateoptions" id="doption3" value="oneyear"> 1年前
  </label></div>
</div>
<hr>

<div class="am-form-group" style="margin-left:5px;margin-bottom:10px; margin-top:10px;width:100%">交易类型：
<div class="am-btn-group" data-am-button id="operastatus">
  <c:if test="${status==2 }">
  <label class="am-btn am-btn-biifoo am-btn-sm ">
    <input type="radio" name="osoptions" id="option1" value="1"> 全部
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="osoptions" id="option2" value="2"> 充值
  </label>
  </c:if>
  <c:if test="${status!=2 }">
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="osoptions" id="option1" value="1"> 全部
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option2" value="2"> 充值
  </label>
  </c:if>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option4" value="3"> 提现
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option5" value="4"> 投资
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option6" value="5"> 回收利息
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option7" value="6"> 回收本金
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option8" value="7"> 手续费
  </label>
   <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option9" value="8"> 佣金返还
  </label>
   <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="option10" value="9"> 佣金拨付
  </label>
</div></div>
      <div style="margin-left:5px;">交易状态：
      <div class="am-btn-group" data-am-button id="orderstatus">
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="oso" id="option1" value="1"> 全部
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="oso" id="option2" value="2"> 完成
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="oso" id="option3" value="3"> 关闭
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="oso" id="option3" value="5"> 处理中
  </label>
</div></div>
      <div style="height: 420px">
      <table class="am-table am-table-striped" style="margin-bottom:0px; text-align:center; font-weight:normal;width:775px; font-size:13px">
        <thead>
          <tr style="height:60px;">
            <th style="vertical-align:middle; width:15%">交易流水号</th>
            <th style="vertical-align:middle; width:20%">时间</th>
            <th style="vertical-align:middle; width:15%">交易类型</th>
            <th style="vertical-align:middle; width:15%">来源</th>
            <th style="vertical-align:middle; width:10%">金额</th>
            <th style="vertical-align:middle; width:10%">可用金额</th>
            <th style="vertical-align:middle; width:15%">交易状态</th>
          </tr>
        </thead>
        <tbody id="table">
        
        </tbody>
      </table>
    </div>
      <div class="classic">
     		<div class="black2"></div>
     	 </div>
      
    </div>
  </div>
  
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
