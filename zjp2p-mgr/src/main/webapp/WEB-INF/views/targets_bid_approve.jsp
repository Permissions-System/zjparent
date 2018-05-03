<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		 	        		//alert("流标审批完成");
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
	    		    		//alert("自充审批完成,由平台用户前去购买！");
		 	        		location.href = "bidApproveList.do";
		 	        	}
	    		    	if("2" == data.status){
	    		    		alert("平台用户余额不足");
	    		    		butEnabled($('#doc-confirm-toggle-2'+$('#id').attr('value')), "自冲");
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
	    			} ,
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


function confirm4(id,amount) {
	$('#id').attr('value',id);
	var html="";
	var title="";
	title="您确定同意该用户的提前赎回申请？";
	html="赎回金额 "+amount+"元<br>操作后,将不可撤销<br>";
	$('.am-modal-bd').html(html);
	$('.am-modal-hd').html(title);
	$('#my-confirm-4').modal({
      relatedElement: this,
      onConfirm: function() {
    	  butDisabled($('#doc-confirm-toggle-4'+$('#id').attr('value')));
    	  $.ajax({     
    		dataType: "json",
  		    type:'post',
  		    url:ctx+'/bid/agreeRedeem.do?id='+$('#id').attr('value'),     
  		    success:function(data){
  		    	if("1" == data.status){
 	        		alert("同意申请");
 	        		location.href = "redeemApproveList.do";
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

function confirm5(id,amount) {
	$('#id').attr('value',id);
	var html="";
	var title="";
	title="您确定转让该用户的提前赎回申请？";
	html="赎回金额 "+amount+"元<br>操作后,将不可撤销<br>";
	$('.am-modal-bd').html(html);
	$('.am-modal-hd').html(title);
	$('#my-confirm-5').modal({
      relatedElement: this,
      onConfirm: function() {
    	  butDisabled($('#doc-confirm-toggle-5'+$('#id').attr('value')));
    	  $.ajax({
    		  	dataType: "json",
  		    	type:'post',
    		    url:ctx+'/bid/beTransfer.do?id='+$('#id').attr('value'),     
    		    success:function(data){
    		    	if("1" == data.status){
	 	        		alert("进行转让");
	 	        		location.href = "redeemApproveList.do";
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
<div class="am-modal am-modal-confirm" id="my-confirm-4" tabindex="-1"><!-- 隐藏的弹出层 start-->
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd"></div>
    <div class="am-modal-footer"> <span class="am-modal-btn" data-am-modal-confirm>确定</span> <span class="am-modal-btn" data-am-modal-cancel>取消</span> </div>
  </div>
</div>
<div class="am-modal am-modal-confirm" id="my-confirm-5" tabindex="-1"><!-- 隐藏的弹出层 start-->
  <div class="am-modal-dialog">
    <div class="am-modal-hd"></div>
    <div class="am-modal-bd"></div>
    <div class="am-modal-footer"> <span class="am-modal-btn" data-am-modal-confirm>确定</span> <span class="am-modal-btn" data-am-modal-cancel>取消</span> </div>
  </div>
</div>
<!-- 隐藏的弹出层 end -->


<input type="hidden" id="tab" value="${map.tab}"/>
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
  <div data-am-widget="tabs" class="am-tabs am-tabs-default" style="float:left">
    <ul class="am-tabs-nav am-cf">
      <li onclick="putjump(1)" <c:if test="${map.tab ne 2 }">class="am-active"</c:if> > <a href="[data-tab-panel-0]" >流标审批</a> </li>
      <li onclick="putjump(2)" <c:if test="${map.tab eq 2 }">class="am-active"</c:if> > <a href="[data-tab-panel-1]" >提前赎回审批</a> </li>
    </ul>
    <div class="am-tabs-bd">
      <div data-tab-panel-0 class="am-tab-panel <c:if test='${map.tab ne 2 }'>am-active</c:if>">
        <div class="searchpanel" style="margin-top:15px; margin-left:0px; height:50px;">
          <form class="am-form-inline" role="form">
            <div class="am-form-group" style="margin-top:10px;">
              <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >标的名称：</label>
              <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
                <input class="am-form-field am-input-sm" type="text" name="bidclassname" id="bidclassname"  value="${map.bidclassname}" placeholder="请输入标的名称" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
              </div>
            </div>
            <div class="am-form-group" style="margin-top:10px;">
              <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >标的编号：</label>
              <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
                <input class="am-form-field am-input-sm" type="text" name="bidCode" id="bidCode" value="${map.bidcode}" placeholder="请输入标的编号" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
              </div>
            </div>
            <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
              <label for="doc-select-1">审批状态：</label>
              <select id="doc-select-1" name="appstatus" style="width:100px; height:30px; font-size:14px; color:#999">
                <option value=""  <c:if test="${map.appstatus == ''}">selected="selected"</c:if>>全部</option>
                <option value="0" <c:if test="${map.appstatus == '0'}">selected="selected"</c:if>>未审批</option>
                <option value="1" <c:if test="${map.appstatus == 1}">selected="selected"</c:if>>已审批</option>
              </select>
              <span class="am-form-caret"></span> </div>
            <button type="button" class="am-btn am-btn-success am-btn-sm" style="margin-top:10px; margin-left:50px; height:30px; padding-top:6px;" onclick="bidjump(1)"><span class="am-icon-search">　搜索</span></button>
          </form>
        </div>
        <div class="tablecontent" style="margin-left:0px;">
          <table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
            <thead>
              <tr style="text-align:center;">
                <th style="text-align:center;">序 号</th>
                <th style="text-align:center;">标的名称</th>
                <th style="text-align:center;">标的编号</th>
                <th style="text-align:center;">标的金额</th>
                <th style="text-align:center;">状 态</th>
                <th style="text-align:center;">申请建议</th>
                <th style="text-align:center;">申请人</th>
                <th style="text-align:center;">操 作</th>
              </tr>
            </thead>
            <c:forEach items="${page.results}" var="bidApprove" varStatus="status">
	            <tbody>
	              <tr>
	                <td>${status.count}</td>
	                <td>${bidApprove.bid.bidclassname}</td>
	                <td>${bidApprove.bid.bidcode}</td>
	                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${bidApprove.bid.amount}"/>元</td>
	                <td><c:forEach items="${approveStatus}" var="a">
					  		<c:if test="${bidApprove.bid.approstatus==a.key}">${a.value}</c:if>
					 	</c:forEach>
	                <td><c:forEach items="${approveSubject}" var="a">
							<c:if test="${bidApprove.approve.subject==a.key}">${a.value}</c:if>
						</c:forEach></td>
	                <td>${bidApprove.approve.staffName}</td>
	                <td><c:if test="${bidApprove.bid.approstatus ne 0}"><a href="approvedBid.do?id=${bidApprove.approve.serviceno}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看详情</button></a></c:if>
	                	<c:if test="${bidApprove.bid.approstatus eq 0}"><a href="unapprovedBid.do?id=${bidApprove.approve.serviceno}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看详情</button></a>
	                		<button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-1" onclick="confirm1(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-1${bidApprove.bid.id}" >流 标</button>
	                  		<button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-2" onclick="confirm2(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-2${bidApprove.bid.id}">自 充</button>
	                  		<button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-3" onclick="confirm3(${bidApprove.bid.id},${bidApprove.bid.amount},${bidApprove.bid.raisemoney})" id="doc-confirm-toggle-3${bidApprove.bid.id}">直 接 发 标</button>
	                  	</c:if>
	                	</td>
	              </tr>
	            </tbody>
            </c:forEach>
          </table>
          <ul class="am-pagination am-pagination-right">
	        <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page.pageNow le 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page.pageNow gt 1 }">
				<li><a href="javascript:void(0)" onclick="bidjump(${page.pageNow - 1})"> &lt;</a></li>
			</c:if>
			<c:if test="${page.pageNow > 4}">
				<li><a href="javascript:void(0)" onclick="bidjump(1)">1</a></li>
				<li><span>. . .</span></li>
			</c:if>
			<!-- 从action中获取分页页码下表的开始和结束下标 -->
			<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
				<c:if test="${page.pageNow eq i }">
					<li class="am-active"><span>${i}</span></li>
				</c:if>
				<c:if test="${page.pageNow ne i }">
					<li><a href="javascript:void(0)" onclick="bidjump(${i})">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${(page.totalPageCount-page.pageNow) >= 4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="bidjump(${page.totalPageCount})">${page.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page.pageNow lt page.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="bidjump(${page.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page.pageNow ge page.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
        </div>
      </div>
      
      <div data-tab-panel-1 class="am-tab-panel <c:if test='${map.tab eq 2 }'>am-active</c:if>">
        <div class="searchpanel" style="margin-top:15px; margin-left:0px; height:50px;">
          <form class="am-form-inline" role="form">
            <div class="am-form-group" style="margin-top:10px;">
              <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >用户帐号：</label>
              <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
                <input class="am-form-field am-input-sm" type="text" autocomplete="off" id="email"  value="${map.email}" placeholder="请输入用户账户" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
              </div>
            </div>
            <div class="am-form-group" style="margin-top:10px;">
              <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >用户姓名：</label>
              <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
                <input class="am-form-field am-input-sm" type="text" autocomplete="off" id="name" value="${map.name}" placeholder="请输入用户姓名" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
              </div>
            </div>
            <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
              <label for="doc-select-1">当前状态：</label>
              <select id="doc-select-1" name="orderStatusDesc" style="width:100px; height:30px; font-size:14px; color:#999">
                <option value="" >全部</option>
                <c:forEach items="${orderStatusDesc}" var="o">
                	<c:if test="${o.key ne 3 && o.key ne 0}">
			  		<option value="${o.key}" <c:if test="${map.orderStatusDesc == o.key}">selected="selected"</c:if>>${o.value}</option>
			  		</c:if>
			  	</c:forEach>
              </select>
              <span class="am-form-caret"></span> </div>
            <button type="button" class="am-btn am-btn-success am-btn-sm" style="margin-top:10px; margin-left:50px; height:30px; padding-top:6px;" onclick="redeemjump(1)"><span class="am-icon-search">　搜索</span></button>
          </form>
        </div>
        <div class="tablecontent" style="margin-left:0px;">
          <table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
            <thead>
              <tr style="text-align:center;">
                <th style="text-align:center;">序 号</th>
                <th style="text-align:center;">用户帐号</th>
                <th style="text-align:center;">用户姓名</th>
                <th style="text-align:center;">申请份额</th>
                <th style="text-align:center;">申请时间</th>
                <th style="text-align:center;">审核状态</th>
                <th style="text-align:center;">所属标的</th>
                <th style="text-align:center;">操 作</th>
              </tr>
            </thead>
            <c:forEach items="${page1.results}" var="investOrderApprove" varStatus="status">
	            <tbody>
	              <tr>
	                <td>${status.count}</td>
	                <td>${investOrderApprove.member.email}</td>
	                <td>${investOrderApprove.member.realname}</td>
	                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${investOrderApprove.investOrder.amount}"/>元</td>
	                <td><fmt:formatDate value="${investOrderApprove.approve.opdate}" type="both"/></td>
	                <td><c:forEach items="${orderStatusDesc}" var="o">
					  		<c:if test="${investOrderApprove.investOrder.orderstatusdesc==o.key && o.key ne 1}">${o.value}</c:if>
					  		<c:if test="${investOrderApprove.investOrder.orderstatusdesc==o.key && o.key eq 3}">赎回失败</c:if>
					 	</c:forEach>　
	                </td>
	                <td>${investOrderApprove.bid.bidclassname} ${investOrderApprove.bid.bidcode} </td>
	                <td><c:if test="${investOrderApprove.investOrder.orderstatusdesc ne 1}"><a href="approvedRedeem.do?id=${investOrderApprove.approve.serviceno}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看详情</button></a></c:if>
	                	<c:if test="${investOrderApprove.investOrder.orderstatusdesc eq 1}"><a href="unapprovedRedeem.do?id=${investOrderApprove.approve.serviceno}"><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看详情</button></a>
	                		<button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-4" onclick="confirm4(${investOrderApprove.investNo},${investOrderApprove.investOrder.amount})" id="doc-confirm-toggle-4${investOrderApprove.investNo}">同 意 赎 回</button>
	                  		<button type="button" class="am-btn am-btn-secondary am-btn-sm doc-confirm-toggle-5" onclick="confirm5(${investOrderApprove.investNo},${investOrderApprove.investOrder.amount})" id="doc-confirm-toggle-5${investOrderApprove.investNo}">进 行 转 让</button></c:if>
	                	</td>
	              </tr>
	            </tbody>
            </c:forEach>
          </table>
          <ul class="am-pagination am-pagination-right">
            <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page1.pageNow le 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page1.pageNow gt 1 }">
				<li><a href="javascript:void(0)" onclick="redeemjump(${page1.pageNow - 1})"> &lt;</a></li>
			</c:if>
			<c:if test="${page1.pageNow > 4}">
				<li><a href="javascript:void(0)" onclick="redeemjump(1)">1</a></li>
				<li><span>. . .</span></li>
			</c:if>
			<!-- 从action中获取分页页码下表的开始和结束下标 -->
			<c:forEach begin="${page1.begin}" end="${page1.end}" step="1" var="i">
				<c:if test="${page1.pageNow eq i }">
					<li class="am-active"><span>${i}</span></li>
				</c:if>
				<c:if test="${page1.pageNow ne i }">
					<li><a href="javascript:void(0)" onclick="redeemjump(${i})">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${(page1.totalPageCount-page1.pageNow) >= 4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="redeemjump(${page1.totalPageCount})">${page1.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page1.pageNow lt page1.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="redeemjump(${page1.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page1.pageNow ge page1.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<form id="getTopost" action="bidApproveList.do" method="post">
  <input id="tabhidden" type="hidden" name="tab" />
  <input id="appstatushidden" type="hidden" name="appstatus" />
  <input id="bidclassnamehidden" type="hidden" name="bidclassname" />
  <input id="bidcodehidden" type="hidden" name="bidcode" />
  <input id="pageNowhidden" type="hidden" name="pageNow" />
</form>
<form id="getTopost2" action="redeemApproveList.do" method="post">
  <input id="tabhidden2" type="hidden" name="tab" />
  <input id="orderStatusDeschidden" type="hidden" name="orderStatusDesc" />
  <input id="usernamehidden" type="hidden" name="username" />
  <input id="namehidden" type="hidden" name="name" />
  <input id="pageNowhidden2" type="hidden" name="pageNow" />
</form>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>
<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
function bidjump(num){
	var tab=$('#tab').val();
	var appstatus=$("select[name='appstatus']").val();
	var bidclassname=$("#bidclassname").val();
	var bidcode=$("#bidCode").val();
	$('#tabhidden').val(tab);
	$('#appstatushidden').val(appstatus);
	$('#bidclassnamehidden').val(bidclassname);
	$('#bidcodehidden').val(bidcode);
	$('#pageNowhidden').val(num);
	$('#getTopost').submit();
}

function redeemjump(num){
	var tab=$('#tab').val();
	var orderStatusDesc=$("select[name='orderStatusDesc']").val();
	var username=$("#username").val();
	var name=$("#name").val();
	$('#tabhidden2').val(tab);
	$('#orderStatusDeschidden').val(orderStatusDesc);
	$('#usernamehidden').val(username);
	$('#namehidden').val(name);
	$('#pageNowhidden2').val(num);
	$('#getTopost2').submit();
}

function putjump(domValue){
	$('#tab').attr("value",domValue);
	if(domValue==1){
		bidjump(1);
	}
	if(domValue==2){
		redeemjump(1);
	}
}
</script>
</body>
</html>
