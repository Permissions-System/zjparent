<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<%@include file="pub/header.jsp"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script>

function confirm1(id,amount,raisemoney){
	$('#id').attr('value',id);
	var html="";
	var title="";
	title="您确定要进行流标操作？";
	html="标的金额："+amount+"元，已筹集："+raisemoney+"元<br>"+
	      "操作后，将不可撤销<br> 操作后,已投标资金将返还投标人";
	$('.am-modal-bd').html(html);
	$('.am-modal-hd').html(title);
	$('#my-confirm-1').modal({
	      relatedElement: this,
	      onConfirm: function() {
	    	  butDisabled($('#doc-confirm-toggle-1'+$('#id').attr('value')));
	    		$.ajax({ 
	    			dataType: "json",
	    		    type:'post',
	    		    url:ctx+'/bid/loseBid.do?id='+$('#id').attr('value')+'&bidcode='+$('#bidcode').attr('value'),     
	    		    success:function(data){
	    		    	if("1" == data.status){
		 	        		alert("流标审批完成");
		 	        		location.href = "bidApproveList.do";
		 	        	}
	    			},
		    		error: function (data) {
				    	console.info(data);
				    	alert(getJsonErrorMsg(data));
				    	location.href = "bidApproveList.do";
	//		 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
				    }    
	    		}); 
	      },
	      onCancel: function() {
	      }
	    });
}

function confirm2(id,amount,raisemoney){
	$('#id').attr('value',id);
	$('#amount').attr('value',amount);
	$('#raisemoney').attr('value',raisemoney);
	$('#bidcode').attr('value',bidcode);
	var html="";
	var title="";
	title="您确定要对该标的进行自充？";
	html="标的金额："+amount+"元，已筹集："+raisemoney+"元<br>自充金额："+(amount-raisemoney)
    "元<br>操作后，将不可撤销<br>自充成功后，标的将完成募集</div>";
	$('.am-modal-bd').html(html);
	$('.am-modal-hd').html(title);
	$('#my-confirm-2').modal({
	      relatedElement: this,
	      onConfirm: function() {
	    	  butDisabled($('#doc-confirm-toggle-2'+$('#id').attr('value')));
	    	  $.ajax({     
	    		  	dataType: "json",
	    		    type:'post',
	    		    url:ctx+'/bid/rechargeBySelf.do?id='+$('#id').attr('value')+'&amount='+$('#amount').attr('value')+
	    		    			'&raisemoney='+$('#raisemoney').attr('value')+'&bidcode='+$('#bidcode').attr('value'),     
	    		    success:function(data){
	    		    	if("1" == data.status){
		 	        		alert("自充审批完成,由平台用户："+data.result+",前去购买！");
		 	        		location.href = "bidApproveList.do";
		 	        	}
	    		    	if("2" == data.status){
	    		    		alert("平台用户余额不足");
	    		    	}
	    			},
		    		error: function (data) {
				    	console.info(data);
				    	alert(getJsonErrorMsg(data));
				    	location.href = "bidApproveList.do";
	//		 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
				    }    
	    		});
	      },
	      onCancel: function() {
	      }
	    });
}

function confirm3(id,amount,raisemoney){
	$('#id').attr('value',id);
	$('#raisemoney').attr('value',raisemoney);
	var html="";
	var title="";
	title="您确定对该标的直接发标？";
	html="标的金额："+amount+"元，已筹集："+raisemoney+"元<br>"+
    "操作后，将不可撤销<br>直接发标成功后，该标的金额按照已募集金额计算<br>直接发标完成后，该标的将完成筹集";
	$('.am-modal-bd').html(html);
	$('.am-modal-hd').html(title);
	$('#my-confirm-3').modal({
	      relatedElement: this,
	      onConfirm: function() {
	    	  butDisabled($('#doc-confirm-toggle-3'+$('#id').attr('value')));
	    	  $.ajax({     
	    		    url:ctx+'/bid/sendBidDirect.do', 
	    		    dataType: "json",
	    		    type:'post',
	    		    data:{id:$('#id').val(),raisemoney:$('#raisemoney').val()},
	    		    success:function(data){
	    		    	if("1" == data.status){
		 	        		alert("申请成功");
		 	        		location.href = "bidApproveList.do";
		 	        	}
	    			},
		    		error: function (data) {
				    	console.info(data);
				    	alert(getJsonErrorMsg(data));
				    	location.href = "bidApproveList.do";
	//		 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
				    }    
	    		});
	      },
	      onCancel: function() {
	      }
	    });
}

</script>
</head>
<body>

<input type="hidden" id="id"/>
<input type="hidden" id="amount"/>
<input type="hidden" id="raisemoney"/>
<input type="hidden" id="bidcode"/>
<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li>标的管理</li>
      <li class="am-active">标的审批</li>
    </ol>
  </div>
  
  <div class="tag_h">${bidApprove.bid.bidclassname}<span style="color:#999; font-size:14px; font-weight:normal;"> (只有募集完成后的标的才显示赎回与转让相关信息)</span></div>
  
  <div class="tag_record_1">申请人：${bidApprove.approve.staffName}</div>
  
  <div class="tag_record_1">申请时间：<fmt:formatDate value="${bidApprove.approve.opdate}"  type="both"/></div>
  
  <div class="tag_record_1">申请建议：<c:forEach items="${approveSubject}" var="a">
							<c:if test="${bidApprove.approve.subject==a.key}">${a.value}</c:if>
						</c:forEach></div>
  
  <div class="tag_record_1">建议原因：${bidApprove.approve.appreason}</div>
  
  <div class="tag_record_2">审批状态：<span style="color:#F00">待审批</span></div>
  
  <div class="tag_record_3">标的概要描述：</div>
  
  <div class="tag_record_1">
  	标的类型：<c:forEach items="${bidtype}" var="b">
		  		<c:if test="${bidApprove.bid.bidtypeid==b.key}">${b.value}</c:if>
		 	</c:forEach>　　　
  	标的状态： <c:forEach items="${bidstatus}" var="b">
				<c:if test="${bidApprove.bid.bidstatus==b.key}">${b.value}</c:if>
			</c:forEach></div>
  
  <div class="tag_record_1">标的名称：${bidApprove.bid.bidclassname}　　标的编号：${bidApprove.bid.bidcode}　<a href="${ctx}/bid/viewBid.do?id=${bidApprove.bid.id}" style="font-size:14px;">标的详情</a></div>
  
  <div class="tag_record_1">
  <c:if test="${bidApprove.bid.ifredeem == 1}"><input type="checkbox" checked="checked" disabled="disabled"> 允许提前赎回费用： 
  		<c:if test="${bidApprove.bid.redeemfeetype == 0}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bidApprove.bid.redeemfee}"/></c:if>
  		<c:if test="${bidApprove.bid.redeemfeetype == 1}"><fmt:formatNumber type="number" maxFractionDigits="2" value="${bidApprove.bid.redeemfee/100*bidApprove.bid.amount}"/></c:if>  元/笔</c:if>
  <c:if test="${bidApprove.bid.ifredeem != 1}"><input type="checkbox" disabled="disabled"> 不允许提前赎回</c:if>
  <input type="checkbox" disabled="disabled" checked="checked"> 不允许转让</div>
  
  <div class="tag_record_1" >标的金额：<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bidApprove.bid.amount}"/> 元　　　截止目前已募集金额：<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bidApprove.bid.raisemoney}"/> 元　　　募集截止时间：<fmt:formatDate value="${bidApprove.bid.raiseenddate}"  type="both"/></div>
  
  <div class="tag_record_2">已投标人数：${count} 人</div>
  
<%--   <div class="tag_record_3">公司账务参考：</div>
  
  <div class="tag_record_1">剩余流动保障金：${platformAcct.account} 元</div>
  
  <div class="tag_record_1" style="margin-bottom:30px;">本次最多可用流动保障金：100,000 元</div> --%>
  
  <div class="tagconfirm">
  	   <button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-1" onclick="confirm1(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-1${bidApprove.bid.id}">流 标</button>
	   <button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-2" onclick="confirm2(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-2${bidApprove.bid.id}">自 充</button>
	   <button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-2" onclick="confirm3(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-3${bidApprove.bid.id}">直 接 发 标</button>
       <button onclick="location='bidApproveList.do'" class="am-btn am-btn-secondary am-btn-sm">返回</button>
  
  <div class="am-modal am-modal-confirm" id="my-confirm-1" tabindex="-1"><!-- 隐藏的弹出层 start-->
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd"></div>
    <div class="am-modal-footer"> <span class="am-modal-btn" data-am-modal-confirm>确定</span> <span class="am-modal-btn" data-am-modal-cancel>取消</span> </div>
  </div>
</div>
  <div class="am-modal am-modal-confirm" id="my-confirm-2" tabindex="-1"><!-- 隐藏的弹出层 start-->
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd"></div>
    <div class="am-modal-footer"> <span class="am-modal-btn" data-am-modal-confirm>确定</span> <span class="am-modal-btn" data-am-modal-cancel>取消</span> </div>
  </div>
</div>
  <div class="am-modal am-modal-confirm" id="my-confirm-3" tabindex="-1"><!-- 隐藏的弹出层 start-->
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd"></div>
    <div class="am-modal-footer"> <span class="am-modal-btn" data-am-modal-confirm>确定</span> <span class="am-modal-btn" data-am-modal-cancel>取消</span> </div>
  </div>
</div>


</div>
  </div>
  
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
