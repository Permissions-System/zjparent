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
<title>投资记录 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<%-- <script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script> --%>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>

<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
<script type="text/javascript">
	$(function(){
		$('#os label').click(function(){
			var osvalue=$(this).find("input").val();
			var bcvalue;
			var bcradios = document.getElementsByName("bcoptions");
	  		 for ( var i = 0; i <bcradios.length; i++) {
				  if (bcradios[i].checked==true) {
						bcvalue=bcradios[i].value;
				  }
			 }
	  		 if(bcvalue==null){
	  			 bcvalue=0;
	  		 }
	  		$.post("ajaxinvestmentrecord.do", {pageNow : 1,orderstatus:osvalue,bidtypeid:bcvalue}, function(data){
	  			getPager(data);
	  		});

		});
		$('#bc label').click(function(){
			var bcvalue=$(this).find("input").val();
			var osvalue;
			var osradios=document.getElementsByName("osoptions");
			 for ( var i = 0; i <osradios.length; i++) {
				  if (osradios[i].checked==true) {
						osvalue=osradios[i].value;
				  }
			 }
			 if(osvalue==null){
	  			 osvalue=1;
	  		 }
			 $.post("ajaxinvestmentrecord.do", {pageNow : 1,orderstatus:osvalue,bidtypeid:bcvalue}, function(data){
				 getPager(data); 	
			 });
		});
		/*
		function getOrderstatusDesc(bidtype,orderstatus){
			if(){
				return "未计息";
			}elseif(){}
		} */
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if( data.results == null || data.results.length == 0){
				html+='<tr><td colspan="8">无任何信息</td></tr>';
			}
			for(var i=0;i<data.results.length;i++){
				   if(i%2 == 0){
					   html+="<tr>";
				   }else{
					   html+="<tr>";
				   }
					html+="<input class='redeemfee' type='hidden' value="+data.results[i].redeemfee+">";
					html+="<input class='investorderid' type='hidden' value="+data.results[i].investorderid+">";   
				html+="<td name='investordercode' \"text-center\">"+data.results[i].investordercode+"</td>";
				html+="<td>"+$.format.date(new Date(data.results[i].orderdate), 'yyyy-MM-dd')+"</td>";
				html+="<td name='bidclassname'>"+data.results[i].bidclassname+"</td>";
				// 天天富
				if(data.results[i].bidtypeid == 4){
					html+="<td>-</td>";
				}else{
					html+="<td>"+data.results[i].timeofinvest+"</td>";
				}
				var buyAmount = data.results[i].amount;
				html+="<td name='amount'>"+buyAmount+"</td>";
				$("input[name=ttfrealAmount]").val(data.results[i].amount);
				html+="<td>"+$.format.number(data.results[i].income, '###,###.##')+"</td>";
				//天天富
				if(data.results[i].bidtypeid == 4){
					var bidtypeid = data.results[i].bidtypeid;
					var ttfUrl = ""+ctx+"/static/upload/buyprotocol/"+bidtypeid+"/<shiro:principal property='id'/>_"+data.results[i].investordercode+".pdf";
					//已完成
					if(data.results[i].orderstatus == 2){
						if(data.results[i].orderstatusdesc == 9){
							html+="<td>已转出</td>";	
							html+="<td></td>";
						}else{
							html+="<td>已兑付</td>";
							html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a></td>";
						}
						// 天天富没有查看 
						//html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a> </td>";
						//html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a><td/>";
                        //html+="<td><td/>";
					} else if(data.results[i].orderstatus == 1){
						if(data.results[i].orderstatusdesc==0){
							html+="<td>待计息</td>";
							html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a>　<font name='ttfOutBut' amount='"+buyAmount+"'><a href='#' data-am-modal=\"{target: '#doc-modal-2',closeViaDimmer:0}\">转出</a></font></td>";
						}else{
						html+="<td>计息中</td>";
						html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a>　<font name='ttfOutBut' amount='"+buyAmount+"'><a href='#' data-am-modal=\"{target: '#doc-modal-2',closeViaDimmer:0}\">转出</a></font></td>";
						}
					}
						
					//天天富以外的产品
				}else{
					//标的已完成
					console.info(data.results[i].orderstatus);
					if(data.results[i].orderstatus == 2){
						html+="<td>已兑付</td>";
						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
					}else{
					if(data.results[i].orderstatusdesc==0){
					html+="<td>待计息</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==3){
						html+="<td>计息中</td>";
						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<font name='a11'><a href='javascript:void(0);' onclick='debtFunc("+data.results[i].investordercode+");' data-am-modal=\"{target: '#doc-modal-1',closeViaDimmer:0}\">赎回</a></font></td>";
				}else if(data.results[i].orderstatusdesc==1){
					html+="<td>审核中</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==2){
					html+="<td>已赎回</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==6){
					html+="<td>审核中</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==7){
					html+="<td>已赎回</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==8){
					html+="<td>赎回失败</td>";
					html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
				}else if(data.results[i].orderstatusdesc==10){
					html+="<td>已流标</td>";
				}
				}
				}	
				
// 				if(data.results[i].orderstatusdesc!=3){
// 					if(data.results[i].bidtypeid == 4){
// 						if(data.results[i].orderstatus==1){
// 							html+="<td>计息中</td>";
// 							html+="<td><a style='color:#BEBFC3' href='javascript:void(0);' >查看<a>　<font name='ttfOutBut'><a href='#' data-am-modal=\"{target: '#doc-modal-2',closeViaDimmer:0}\">转出</a></font></td>";
// 						}else if(data.results[i].orderstatus==0){
// 							html+="<td>未计息</td>";
// 							html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
// 						}else {
// 							html+="<td>已兑付</td>";
// 							html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a> </td>";
// 						}
// 					}else if(data.results[i].orderstatusdesc==1 || data.results[i].orderstatusdesc==6){
// 						html+="<td>审核中</td>";
// 						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
// 					}else{
// 						html+="<td>已赎回</td>";
// 						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
// 					}
// 				}else{
// 					if(data.results[i].bidtypeid == 4){
// 						var bidtypeid = data.results[i].bidtypeid;
// 						var ttfUrl = ""+ctx+"/static/upload/buyprotocol/"+bidtypeid+"/<shiro:principal property='id'/>_"+data.results[i].investordercode+".pdf";
						
// 						// 天天富
// 						if(data.results[i].orderstatus==1){
// 							html+="<td>计息中</td>";
// 							html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a>　<font name='ttfOutBut'><a href='#' data-am-modal=\"{target: '#doc-modal-2',closeViaDimmer:0}\">转出</a></font></td>";
// 						}
// 						else{
// 							html+="<td>已兑付</td>";
// 							// 天天富没有查看 
// 							//html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a> </td>";
// 							html+="<td><a href='"+ttfUrl+"' target='_blank'>协议</a><td/>";
// 						}
// 					}
// 					else if(data.results[i].orderstatus==1){
// 						html+="<td>计息中</td>";
// 						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<font name='a11'><a href='#' data-am-modal=\"{target: '#doc-modal-1',closeViaDimmer:0}\">赎回</a></font></td>";
// 					}
// 					else if(data.results[i].orderstatus==0){
// 						html+="<td>未计息</td>";
// 						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a> </td>";
// 					}
// 					else{
// 						html+="<td>已兑付</td>";
// 						html+="<td><a href=searchdetail.do?investordercode="+data.results[i].investordercode+"&bidclassname="+data.results[i].bidclassname+"&id="+data.results[i].investorderid+">查看<a>　<a style='color:#BEBFC3' href='javascript:void(0);'>赎回</a></td>";
// 					}
// 				}
			
				html+="</tr>";
				
			   }
				$table.html("");
				$table.html(html);
			   var $pager = $(".classic .black2");
			   var pagehtml = "";
				//判断是不是第一页决定是否显示前一页标签
				if(data.pageNow<=1){
					pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
				}
				if(data.pageNow > 1){
					var pre = data.pageNow-1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a>";
				}
				if(data.pageNow > 5){
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+1+"\">1</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+2+"\">2</a>";
					pagehtml += "<span>. . .</span>";
				}
				//从action中获取分页页码下表的开始和结束下标
				for(var i=data.begin;i<=data.end;i++){
					if(data.pageNow == i){
						pagehtml += "<span class=\"current\">"+i+"</span>";
					}
					if(data.pageNow != i){
						pagehtml += "<a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a>";
					}
				}
				var less = data.totalPageCount-data.pageNow;
				if(less >= 5){
					var endb = data.totalPageCount-1;
					pagehtml += "<span>. . .</span>";
					//显示尾页下标
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a>";
				}
				//判断是不是最后一页，决定是否显示后一页下标
				if(data.pageNow < data.totalPageCount){
					var next = data.pageNow+1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+next+"\">> </a>";
				}
				if(data.pageNow >= data.totalPageCount){
					pagehtml += "<span>&nbsp;&nbsp; > </span>";
				}
				$pager.html("");
				$pager.html(pagehtml);
			
		}
		$(".classic .black2 a").live("click",function(e){
			e.preventDefault();
			current = $(this).attr("value"); 
			var bcvalue;
			var bcradios = document.getElementsByName("bcoptions");
	  		 for ( var i = 0; i <bcradios.length; i++) {
				  if (bcradios[i].checked==true) {
						bcvalue=bcradios[i].value;
				  }
			 }
	  		 if(bcvalue==null){
	  			 bcvalue=0;
	  		 }
	  		var osvalue;
			var osradios=document.getElementsByName("osoptions");
			 for ( var i = 0; i <osradios.length; i++) {
				  if (osradios[i].checked==true) {
						osvalue=osradios[i].value;
				  }
			 }
			 if(osvalue==null){
	  			 osvalue=1;
	  		 }
			$.post("ajaxinvestmentrecord.do", {pageNow : current,orderstatus:osvalue,bidtypeid:bcvalue}, function(data){
				getPager(data);
			});
		});	
		
		$.post("ajaxinvestmentrecord.do", {pageNow : 1,orderstatus:1,bidtypeid:0}, function(data){
		getPager(data);
	});
		$("font[name='a11']").live("click",function(){
				$("#JSdealpassword").html("");
				$("#dealpassword").val("");
				var $bidclassname=$(this).parents().find("td[name='bidclassname']").html();
				var $amount=$(this).parents().find("td[name='amount']").html();
				var $redeemfee=$(this).parents().find(".redeemfee").val();
				var $investorderid=$(this).parents().find(".investorderid").val();
				var $investordercode=$(this).parents().find("td[name=investordercode]").html();
				$("#bidclassname").html($bidclassname);
				$("#amount").html($amount);
				$("#redeemfee").html($redeemfee+"%");
				$("#investorderid").val($investorderid);
				$("#investordercode").val($investordercode);
		});
		$("font[name='ttfOutBut']").live("click",function(){
			var $bidclassname=$(this).parents().find("td[name='bidclassname']").html();
			var $amount=$(this).attr('amount');
			var $investorderid=$(this).parents().find(".investorderid").val();
			var $investordercode=$(this).parents().find("td[name=investordercode]").html();
			$("#ttfName").html($bidclassname);
			$("#ttfAmount").val($amount);
			$("#ttfOrderid").val($investorderid);
			$("#ttfOrdercode").val($investordercode);
			$("#ttfJSamount").html("");
			$("#ttfJSdealpassword").html("");
	});
		$("#s1").click(function(){
			var falg=$("#checkbox").is(":checked");
			if(!falg) {
					alert("同意百富条款才能赎回");
					return false;
			}
			var $investordercode=$("#investordercode").val();
			 $.ajax({ 
		            type: "POST", 
		            dataType:"json",
		            url: "redeem.do", 
		            data:{dealpassword:$("#dealpassword").val(),id:$("#investorderid").val(),investordercode:$investordercode},
		            success: function(data){
						if(data.result=="申请成功"){
							window.location.href="investmentrecord.do";
						}
						if(data.result=="交易密码未设置"){
							$("#JSdealpassword").html("<font color='red'>"+data.result+"</font>");
							$("#fdealpassword").html("<a href='securitycenter.do' style='color:#000; margin-top:-5px;'>去设置交易密码 </a>")
						}
						else{
							$("#JSdealpassword").html("<font color='red'>"+data.result+"</font>");
						}
		            },
		            error: function(result){
		            	$("#JSdealpassword").html("<font color='red'>"+getJsonErrorMsg(result)+"</font>");
		            }
		        }); 
			 
		});
		
		$("#ttfSubmit").click(function(){
			butDisabled($("#ttfSubmit"));
			var $investordercode=$("#ttfOrdercode").val();
			var $investorderid = $("#ttfOrderid").val();
			var $outAmount = $('#ttfAmount').val();
			var $dealpassword = $("#ttfPassword").val();
			console.info({dealpassword:$dealpassword,id:$investorderid,investordercode:$investordercode,outAmout:$outAmount});
			$.post("ttfRollout.do",{dealpassword:$dealpassword,id:$investorderid,investordercode:$investordercode,outAmout:$outAmount},function(data){
				if(data.result=="申请成功"){
					window.location.href="investmentrecord.do";
					butEnabled($("#ttfSubmit"),"提交");
				}
				if(data.result=="交易密码未设置"){
					
					$("#ttfJSdealpassword").html("<font color='red'>"+data.result+"</font>");
					$("#ttffdealpassword").html("<a href='securitycenter.do' style='color:#000; margin-top:-5px;'>去设置交易密码 </a>")
					butEnabled($("#ttfSubmit"),"提交");
				}else if(data.result=="转出金额不能为空"){
					
					$("#ttfJSamount").html("<font color='red'>"+data.result+"</font>");
					butEnabled($("#ttfSubmit"),"提交");
				}else if(data.result=="请输入正整数"){
					
					$("#ttfJSamount").html("<font color='red'>"+data.result+"</font>");
					butEnabled($("#ttfSubmit"),"提交");
				}else if(data.result=="转出金额不能大于订单金额"){
					$("#ttfJSamount").html("<font color='red'>"+data.result+"</font>");
					butEnabled($("#ttfSubmit"),"提交");
				}
				else{
					
					$("#ttfJSdealpassword").html("<font color='red'>"+data.result+"</font>");
					butEnabled($("#ttfSubmit"),"提交");
				}
			});
		});
	});
	function debtFunc(data){
		var hrefUrl=ctx+"/static/upload/buyprotocol/3/debt_<shiro:principal property='id'/>_"+data+".pdf" ;
		$('#debtA').attr('href',hrefUrl);
	}
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog" style="height:420px;">
    <div class="am-modal-hd">我要赎回<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px;"> <span style="font-size:14px">提前赎回将会收取投资本金的2%手续费。</span>
      <form class="am-form am-form-horizontal" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px; height:35px">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">名称：</div>
          <div class="am-u-sm-8" style="text-align:left" id="bidclassname">
            月息保YXT-000000</div>
        </div>
        <div class="am-form" style="font-size:13px; height:35px">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">待收本金：</div>
          <div class="am-u-sm-8" style="text-align:left" id="amount">
            5,000 元</div>
        </div>
        <div class="am-form" style="font-size:13px; height:35px">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">手续费率：</div>
          <div class="am-u-sm-8" style="text-align:left; color:#F00" id="redeemfee">
            100 元</div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <div class="am-u-sm-4 " style="font-weight:normal; margin-top:5px;text-align:right">交易密码：</div>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="dealpassword" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;">
            <a href="securitycenter.do"><span style="margin-left:10px; margin-top:5px; float:left" id="fdealpassword">忘记密码？</span></a> <small style="float:left; margin-left:-225px; margin-top:30px;" id="JSdealpassword">&nbsp;</small> </div>
        </div>
        <div class="am-form" style="margin-top:10px; margin-left:-10px; float:left; width:100%;font-size:13px;" >
          <input type="checkbox" id="checkbox">
          我同意<a id="debtA" target="_blank">《百富网债权转让协议》</a> </div>
          <input type="hidden" id="investorderid" >
          <input type="hidden" id="investordercode">
        <div style="margin-top:20px; margin-left:100px; float:left">
          <button type="button" class="am-btn am-btn-secondary" style="width:180px;" id="s1">提 交</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
    </div>
  </div>
</div>

<!-- 天天富转出 start -->
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
  <div class="am-modal-dialog" style="height:420px;">
    <div class="am-modal-hd">转出<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" style="margin-top:-20px;"> 
      <form class="am-form am-form-horizontal" style="width:90%; margin-top:20px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px; height:35px">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">名称：</div>
          <div class="am-u-sm-8" style="text-align:left" id="ttfName"> </div>
        </div>
        <div class="am-form" style="font-size:13px; height:35px">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">转出金额（元）：</div>
          <div class="am-u-sm-8" style="text-align:left"> <input type="text"  class="am-input-sm" id="ttfAmount" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;"><small style="float:left; margin-left:-150px; margin-top:30px;" id="ttfJSamount">&nbsp;</small> </div>
        </div>
        <div class="am-form" style="font-size:13px; height:35px;margin-top:20px;">
          <div class="am-u-sm-4" style=" font-weight:normal; text-align:right">手续费：</div>
          <div class="am-u-sm-8" style="text-align:left; color:#F00" > 0 </div>
        </div>
        <div class="am-form" style="font-size:13px; margin-top:10px">
          <div class="am-u-sm-4 " style="font-weight:normal; margin-top:5px;text-align:right">交易密码：</div>
          <div class="am-u-sm-8" style="text-align:left">
            <input type="password" class="am-input-sm" id="ttfPassword" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;float:left;">
            <a href="securitycenter.do"><span style="margin-left:10px; margin-top:5px; float:left" id="ttffdealpassword">忘记密码？</span></a> <small style="float:left; margin-left:-225px; margin-top:30px;" id="ttfJSdealpassword">&nbsp;</small> </div>
        </div>
        <input type="hidden" id="ttfOrderid" >
        <input type="hidden" id="ttfOrdercode">
        <div style="margin-top:20px; margin-left:100px; float:left">
          <button type="button" class="am-btn am-btn-secondary" style="width:180px;" id="ttfSubmit">提 交</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
    </div>
  </div>
</div>

<!-- 天天富转出 end -->
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
	<%@include file="left.jsp" %>
  <div class="person_info_right">
    <div class="member_h"><img src="${ctx}/static/images/member_icon05.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 投资记录</span></div>
    <div class="personalinfo" style="margin-top:60px;">
      <div style="margin-left:5px;margin-bottom:10px;">投资状态：<div class="am-btn-group" id="os" data-am-button>
   <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="osoptions" id="osoption1" value="1" > 全部
   </label>
   <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="osoption2" value="6" > 待计息 
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="osoption2" value="2" > 计息中
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="osoption5" value="5" > 已兑付
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="osoption3" value="3" > 赎回审核
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="osoptions" id="osoption4" value="4" > 赎回处理
  </label>

  <label class="am-btn am-btn-biifoo am-btn-sm" >
    <input type="radio" name="osoptions" id="osoption6" value="0"> 已赎回
  </label>
</div></div>
      <div style="margin-left:5px;">投资产品：<div class="am-btn-group" id="bc" data-am-button>
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="bcoptions" value="0" > 全部
  </label>
	<c:forEach items="${bidtype}" var="b">
  	<c:if test="${b.key!=4}">
  <label class="am-btn am-btn-biifoo am-btn-sm">
  	<input type="radio" name="bcoptions" value="${b.key }" >${b.value }
  </label>
  	</c:if>
	</c:forEach>
	<input type="hidden" name="ttfrealAmount" >
</div></div>
      <div style="height: 500px"><table class="am-table am-table-hover" style="margin-bottom:0px; text-align:center; font-weight:normal;width:775px; font-size:13px; ">
        <thead>
          <tr style="height:60px;">
            <th style="vertical-align:middle; width:15%">订单号</th>
            <th style="vertical-align:middle; width:12%">购买时间</th>
            <th style="vertical-align:middle; width:20%">项目名称</th>
            <th style="vertical-align:middle; width:10%">投资期限</th>
            <th style="vertical-align:middle; width:10%">投资金额</th>
            <th style="vertical-align:middle; width:13%">预期收益</th>
            <th style="vertical-align:middle; width:8%">状态</th>
            <th style="vertical-align:middle; width:15%">操作</th>
          </tr>
        </thead>
        <tbody id="table"></tbody>
      </table></div>
    	 <div class="classic">
     		<div class="black2"></div>
     	 </div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>

</html>
