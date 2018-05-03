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
<%@include file="pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	var _transname = {
			// 购买
			BUY:1,
			// 赎回
			REDEEM:2
	};
	
	var _orderstatusdesc = {
			// 待提交(提前赎回申请)
			BEWAITED:1,
			// 已赎回
			REDEEMED:2,
			// 正常
			NORMAL:3,
			// 审查审批中
			CHECKING:4,
			// 收回修改
			RECOVER:5
	};
	
	var _orderstatus = {
			// 有效
			VALID:1,
			// 作废
			UNVALID:0	
	};
	
	var current = 1;
	ajaxPost("queryBidInvestOrderList.do", {pageNow : current,bidcode:$("#bidcode").val()}, function(data){
		getPager(data);
	});
	
	$("#search").click(function(){
		console.info({pageNow : current,bidcode:$("#bidcode").val(),customerNickName:$("#customerNickName").val(),customerName:$("#customerName").val(),orderStatusDesc:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),applystarttime:$("#applystarttime").val(),applyendtime:$("#applyendtime").val()});
		ajaxPost("queryBidInvestOrderList.do", {pageNow : current,bidcode:$("#bidcode").val(),customerNickName:$("#customerNickName").val(),customerName:$("#customerName").val(),orderStatusDesc:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),applystarttime:$("#applystarttime").val(),applyendtime:$("#applyendtime").val()}, function(data){
			getPager(data);
		});
	});
	
	function ajaxPost(url,dataParam,callback){  
		 var retData=null;  
		 $.ajax({   
		     type: "post",  
		     url: url,   
		     data: dataParam,  
		     dataType: "json",    
		     success: function (data) {  
		        retData=data;  
		        if(callback!=null&&callback!=""&&callback!=undefined)  
		            callback(data,status);   
		    },  
		    error: function (data) {
		    	console.info(data);
		    	alert("系统异常");
//	 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
		    }    
		});        
		     return retData;  
		}  
	
	function getPager(data){
		   var $table = $(".tablecontent table tbody");
		   var html = "";
		   for(var i=0;i<data.results.length;i++){
			   if(data.results[i].ifsum == '1'){
				   html+="";
			   }else{
			   html+="<tr>";
			   html+="<td>"+parseInt(i+1)+"</td>"; 
			   html+="<td>"+data.results[i].customerid+"</td>";
			   html+="<td>"+data.results[i].customernickname+"</td>";
			   html+="<td>"+data.results[i].customername+"</td>";
			   html+="<td>"+$.format.number(data.results[i].amount, '###,###.##')+"</td>";
			   html+="<td>"+$.format.date(new Date(data.results[i].orderdate), 'yyyy-MM-dd HH:mm:ss')+"</td>";
			   html+="<td>"+status(data.results[i].orderstatusdesc,data.results[i].orderstatus)+"</td>";
			   html+="<td>"+$.format.number(data.results[i].exptincome, '###,###.##')+"</td>";
			   html+="<td>"+$.format.date(new Date(data.results[i].opdate), 'yyyy-MM-dd HH:mm:ss')+"</td>";
			   html+="<td id=\""+data.results[i].id+"\">";
			   if("提前赎回申请" == status(data.results[i].transname,data.results[i].orderstatus,data.results[i].orderstatusdesc)){
			   html+="<button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" name=\"agree\">同意赎回</button>";
 			   html+=" <button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" name=\"disagree\">进行转让</button>";
			   }else{
				   html+="<button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" disabled=\"disabled\">同意赎回</button>";
 				   html+=" <button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" disabled=\"disabled\">进行转让</button>";
			   }
			   html+=" <div class=\"am-modal am-modal-confirm\" id=\"my-confirm"+data.results[i].id+"\" tabindex=\"-1\">";
			   html+="<div class=\"am-modal-dialog\">";
			   html+="<div class=\"am-modal-hd\">您确定同意该用户的赎回申请？</div>";
			   html+="<div class=\"am-modal-bd\">赎回金额 "+$.format.number(data.results[i].amount, '###,###.##')+" 元</div>";
			   html+="<div class=\"am-modal-footer\">";
			   html+="<span class=\"am-modal-btn\" data-am-modal-confirm>确定</span>";
			   html+="<span class=\"am-modal-btn\" data-am-modal-cancel>取消</span>";
			   html+="</div>";
			   html+="</div>";
			   html+="</div>";
			   html+="<div class=\"am-modal am-modal-confirm\" id=\"my-disagree"+data.results[i].id+"\" tabindex=\"-1\">";
			   html+="<div class=\"am-modal-dialog\">";
			   html+="<div class=\"am-modal-hd\">您确定转让该用户的赎回标的？</div>";
			   html+="<div class=\"am-modal-bd\">赎回金额 "+$.format.number(data.results[i].amount, '###,###.##')+" 元</div>";
			   html+="<div class=\"am-modal-bd\">3天内转让不成功，用户赎回将失败</div>";
			   html+="<div class=\"am-modal-footer\">";
			   html+="<span class=\"am-modal-btn\" data-am-modal-confirm>确定</span>";
			   html+="<span class=\"am-modal-btn\" data-am-modal-cancel>取消</span>";
			   html+="</div>";
			   html+="</div>";
			   html+="</div>";
			   html+="</td>";
			   html+="</tr>";
		   }}
			$table.html("");
			$table.html(html);
			
			 var $pager = $("#pagenate");
			 var pagehtml = "";
			//判断是不是第一页决定是否显示前一页标签
			if(data.pageNow==1){
				pagehtml += "<li class=\"am-disabled\">&laquo;</li>";
			}
			if(data.pageNow != 1){
				var pre = data.pageNow-1;
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a></li>";
			}
			if(data.pageNow > 5){
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+1+"\">1</a></li>";
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+2+"\">2</a></li>";
				pagehtml += "<span>. . .</span>";
			}
			//从action中获取分页页码下表的开始和结束下标
			for(var i=data.begin;i<=data.end;i++){
				if(data.pageNow == i){
					pagehtml += "<li class=\"am-active\">"+i+"</li>";
				}
				if(data.pageNow != i){
					pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a></li>";
				}
			}
			var less = data.totalPageCount-data.pageNow;
			if(less >= 5){
				var endb = data.totalPageCount-1;
				pagehtml += "<span>. . .</span>";
				//显示尾页下标
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a></li>";
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a></li>";
			}
			//判断是不是最后一页，决定是否显示后一页下标
			if(data.pageNow != data.totalPageCount){
				var next = data.pageNow+1;
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+next+"\">&raquo; </a></li>";
			}
			if(data.pageNow == data.totalPageCount){
				pagehtml += "<li class=\"am-disabled\">&raquo; </li>";
			}
			$pager.html("");
			$pager.html(pagehtml);
	   }
	
	$("#pagenate li a").live("click",function(e){
		e.preventDefault();
		current = $(this).attr("value"); 
		ajaxPost("queryBidInvestOrderList.do", {pageNow : current,bidcode:$("#bidcode").val(),customerNickName:$("#customerNickName").val(),customerName:$("#customerName").val(),orderStatusDesc:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),applystarttime:$("#applystarttime").val(),applyendtime:$("#applyendtime").val()}, function(data){
			getPager(data);
		});
	});	
	
	function status(key,orderstatus,bidtypeid){
		var value = "";
		$("#doc-select-1 option").each(function(){
			if(key == $(this).val())
				value = $(this).text();
		});
		if(orderstatus == '2' && $("#bidtypeid").val()=='4'){
			value = "转出成功";
		}
		return value;
	}
	
	$("button[name=agree]").live("click",function(){
		$(this).each(function(){
			var value = $(this).parent().attr("id");
			$('#my-confirm'+value).modal({
			      relatedElement: this,
			      onConfirm: function() {
			        ajaxPost("agreeRedeem.do", {id : value}, function(data){
		 	        	if("1" == data.status){
		 	        		alert("同意申请");
		 	        		location.href = "bidDetail.do?id="+$("#bidid").val();
		 	        	}
		 	        	if("2" == data.status){
		 	        		alert("用户余额不足");
		 	        	}
		 	        });
			      },
			      onCancel: function() {
			      }
			    });
		});
	
	});
	
	 $("button[name=disagree]").live("click", function() {
		 $(this).each(function(){
			 var value = $(this).parent().attr("id");
			 $('#my-disagree'+value).modal({
			      relatedElement: this,
			      onConfirm: function() {
			        alert('转让申请'+value);
			        ajaxPost("beTransfer.do", {id : value}, function(data){
			        	if("1" == data.status){
		 	        		alert("转让中");
		 	        		location.href = "bidDetail.do?id="+$("#bidid").val();
		 	        	}
		 	        });
			      },
			      onCancel: function() {
			      }
			 });
		 });
		
		  });
});
</script>
</head>
<body>

<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li class="am-active">标的管理</li>
    </ol>
  </div>
  
  <div class="tag_h">${bid.bidclassname}<span style="color:#999; font-size:14px; font-weight:normal;"> (只有募集完成后的标的才显示赎回与转让相关信息)</span></div>
  
  <div class="tag_record_1">标的类型：
  <c:forEach items="${bidtype}" var="b">
  <c:if test="${bid.bidtypeid==b.key}">${b.value}</c:if>
  </c:forEach>　　　标的状态： <c:forEach items="${bidstatus}" var="b">
  <c:if test="${bid.bidstatus==b.key}">${b.value}</c:if>
  </c:forEach>　　　<c:if test="${bid.ifredeem == 1}"><input type="checkbox" checked="checked" disabled="disabled"> 允许提前赎回费用： <c:if test="${bid.redeemfeetype == 0}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.redeemfee}"/></c:if>
  <c:if test="${bid.redeemfeetype == 1}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.redeemfee/100*bid.amount}"/></c:if>  元/笔</c:if>
  <c:if test="${bid.ifredeem != 1}"><input type="checkbox" disabled="disabled"> 允许提前赎回</c:if>
  　　　<input type="checkbox" disabled="disabled" checked="checked"> 不允许转让</div>
  
  <div class="tag_record_1">标的金额：<fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.amount}"/> 元　　　截止目前已募集金额：<fmt:formatNumber type="number" maxFractionDigits="2" value="${bid.raisemoney}"/> 元　　　募集截止时间：<fmt:formatDate value="${bid.raiseenddate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
  
  <div class="tag_record_1">已投标人次：${count} 人　　　还款日期：<fmt:formatDate value="${bid.exptlastacctdate}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
  
  <div class="tag_record_2">提前赎回人数：${num} 人　　提前赎回金额：<fmt:formatNumber type="number" maxFractionDigits="2" value="${amount}"/>元</div>
  <input type="hidden" name="bidtypeid" id="bidtypeid" value="${bid.bidtypeid}">
  <input type="hidden" name="bidcode" id="bidcode" value="${bid.bidcode}"/>
  <input type="hidden" name="bidid" id="bidid" value="${bid.id}"/>
  <div class="tag_record_3">投资人列表</div>
  
  <div class="searchpanel" style="margin-top:10px;">
    <form class="am-form-inline" role="form">
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >用户帐号：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入用户帐号" style="width:150px; height:30px;" id="customerNickName"></div>
      </div>
      
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >用户姓名：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入用户姓名" style="width:150px; height:30px;" id="customerName"></div>
      </div> 
      <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">当前状态：</label>
      <select id="doc-select-1" style="width:100px; height:30px; font-size:14px; color:#999">
        <option value="">全 部</option>
        <c:forEach items="${statusdesc}" var="b">
        	<option value="${b.key}">${b.value}</option>
  		</c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div> <br>
	<div style="margin-left:18px; margin-top:15px; float:left;">投标时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left; width:12%;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:100%; height:30px;" id="bidstarttime">
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left; width:12%;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:100%; height:30px;" id="bidendtime">
  </div>
  <div style="margin-left:18px; margin-top:15px; float:left;">申请时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left; width:12%;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:100%; height:30px;" id="applystarttime">
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left; width:12%;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:100%; height:30px;" id="applyendtime">
  </div>
  
  <button type="button" id="search" class="am-btn am-btn-success am-btn-sm" style="margin-top:15px; margin-left:123px; height:30px; padding-top:6px;"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">用户 ID</th>
            <th style="text-align:center;">用户帐号</th>
            <th style="text-align:center;">用户姓名</th>
            <th style="text-align:center;">投标金额</th>
            <th style="text-align:center;">投标时间</th>
            <th style="text-align:center;">当前状态</th>
            <th style="text-align:center;">待收收益</th>
            <th style="text-align:center;">申请时间</th>
            <th style="text-align:center;">操 作</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<ul class="am-pagination am-pagination-right" id="pagenate">
  <li class="am-disabled"><a href="#">&laquo;</a></li>
  <li class="am-active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul>
</div>
  
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
