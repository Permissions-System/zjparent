<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
<meta http-equiv="”Content-Type”" content="text/html; charset=UTF-8">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>

</head>
<body>

<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
    </ol>
  </div>
  
  <div class="moneypanel">
    <div class="moneypanel2">
      <div class="am-g" style="margin-top:8px; margin-left:10px;">
        <div class="am-u-sm-10">平台账户　　</div>
        <div class="am-u-sm-2" style="font-size:14px;"><a href="jumpPwd.do">密码设置</a></div>
      </div>
    <c:forEach var="platformAcct"  items="${platformAcctList}">
      <c:if test="${platformAcct.acctid eq 30}">
      <div class="am-g" style="margin-top:8px; margin-left:10px;">
        <div class="am-u-sm-12">流动活动金账户：　　<span style="color:#EE5858;"><fmt:formatNumber value="${platformAcct.account}" maxFractionDigits="2" type="number" minFractionDigits="2"/></span> 元</div>
      </div>
      </c:if>
    </c:forEach>
      
      <!-- 充值 -->
      <div class="am-g" style="margin-top:15px; margin-left:10px;">
        <div class="am-u-sm-2"><a href="#" data-am-modal="{target: '#doc-modal-3'}"><button type="button" class="am-btn am-btn-secondary">充 值</button></a>

<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-3">
  <div class="am-modal-dialog" style="height:270px;">
    <div class="am-modal-hd">充 值<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" >
      <form  class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-5 am-form-label" style=" font-weight:normal">请输入需要充值的金额：</label>
          <div class="am-u-sm-7" style="text-align:left">
            <input type="text" name="rechargeAmount" class="am-input-sm" id="user-name" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;">
            </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-5 am-form-label" style="font-weight:normal; margin-top:15px;">请输入充值密码：</label>
          <div class="am-u-sm-7" style="text-align:left">
            <input type="password" name="rechargePwd" class="am-input-sm" id="user-name" autocomplete="off" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div style="margin-top:20px; margin-left:100px; float:left">
          <button type="button" onclick="recharge()" class="am-btn am-btn-secondary" style="width:180px;">提 交</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div>
        </div>
        
        <!-- 提现 -->
        <div class="am-u-sm-2"><a href="#" data-am-modal="{target: '#doc-modal-2'}"><button type="button" class="am-btn am-btn-secondary">提 现</button></a>
        <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
  <div class="am-modal-dialog" style="height:270px;">
    <div class="am-modal-hd">提 现<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd" >
      <form  class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-5 am-form-label" style=" font-weight:normal">请输入需要提现的金额：</label>
          <div class="am-u-sm-7" style="text-align:left">
            <input type="text" name="withdrawAmount" class="am-input-sm" id="user-name" autocomplete="off" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;">
            </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-5 am-form-label" style="font-weight:normal; margin-top:15px;">请输入提现密码：</label>
          <div class="am-u-sm-7" style="text-align:left">
            <input type="password"  name="withdrawPwd" class="am-input-sm" id="user-name" autocomplete="off" style="width: 150px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div style="margin-top:20px; margin-left:100px; float:left">
          <button type="button" onclick="withdraw()" class="am-btn am-btn-secondary" style="width:180px;">提 交</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px; margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div>
        
        </div>
        
        <!-- 调拨 -->
        <div class="am-u-sm-2"><a href="#" data-am-modal="{target: '#doc-modal-1'}"><button type="button" class="am-btn am-btn-secondary">调 拨</button></a>
       <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog" style="height:500px;">
    <div class="am-modal-hd">资金调拨<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd">请选择调拨账户</span>
      <form  class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:15px;">从：</label>
          <div class="am-u-sm-9">
            <select id="doc-select-1" name="fromAcct" class="am-input-sm" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
                <option value="请选择账户">请选择账户</option>
                <c:forEach items="${platformAcctList}" var="platformAcct">
                <option value="platform${platformAcct.acctid}">平台账户- ${platformAcct.acctName}</option>
                </c:forEach>
                <c:forEach items="${memberList}" var="member">
                <option value="member${member.id}">内部会员账户- ${member.email}</option>
                </c:forEach>
            </select>
          </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:15px;">调拨到：</label>
          <div class="am-u-sm-9">
            <select id="doc-select-1" name="toAcct" class="am-input-sm" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
                <option value="请选择账户">请选择账户</option>
                <c:forEach items="${platformAcctList}" var="platformAcct">
                <option value="platform${platformAcct.acctid}">平台账户- ${platformAcct.acctName}</option>
                </c:forEach>
                <c:forEach items="${memberList}" var="member">
                <option value="member${member.id}">内部会员账户- ${member.email}</option>
                </c:forEach>
            </select>
          </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:15px;">调拨金额：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" name="allotAmount" class="am-input-sm"  autocomplete="off" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:15px;">备注：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <textarea class="" name="allotRemark" rows="4" id="doc-ta-1" style="width: 240px; height:90px; margin-top:15px;" ></textarea>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:80px;">调拨密码：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="password" name="allotPwd" class="am-input-sm" id="user-name" autocomplete="off" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div style="margin-top:30px; margin-left:100px; float:left">
          <button type="button" onclick="allot()" class="am-btn am-btn-secondary" style="width:180px;">提交认证</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div> 
        
        
        
        </div>
        
            <!-- 会员补偿 -->
        <div class="am-u-sm-2"><a href="#" data-am-modal="{target: '#doc-modal-4'}"><button type="button" class="am-btn am-btn-secondary">会员补偿</button></a>
       <div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-4">
  <div class="am-modal-dialog" style="height:500px;">
    <div class="am-modal-hd">会员补偿<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd">请选择调拨账户</span>
      <form id="compensation" class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto" >
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:15px;">平台账户：</label>
          <div class="am-u-sm-9">
            <select id="doc-select-1" name="platAcct" class="am-input-sm" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
                <option value="请选择账户">请选择账户</option>
                <c:forEach items="${platformAcctList}" var="platformAcct">
                <option value="${platformAcct.acctid}">平台账户- ${platformAcct.acctName}</option>
                </c:forEach>
            </select>
          </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:15px;">会员Id：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" name="memberID" class="am-input-sm" id="user-name" autocomplete="off" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:15px;">账户类型：</label>
          <div class="am-u-sm-9">
            <select id="doc-select-1" name="acctType" class="am-input-sm" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;float:left;margin-top:15px;">
                <option value="请选择账户">请选择账户类型</option>
                <c:forEach items="${acctTypeList}" var="acctType">
                <option value="${acctType.key}">${acctType.value}</option>
                </c:forEach>
            </select>
          </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:15px;">调拨金额：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="text" name="comAmount" class="am-input-sm"  autocomplete="off" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:15px;">备注：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <textarea class="" name="comRemark" rows="4" id="doc-ta-1" style="width: 240px; height:60px; margin-top:15px;" ></textarea>
            </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:50px;">调拨密码：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="password" name="comPwd" class="am-input-sm" id="user-name" autocomplete="off" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:15px;">
            </div>
        </div>
        
        <div style="margin-top:30px; margin-left:100px; float:left">
          <button type="button" onclick="compensation()" class="am-btn am-btn-secondary" style="width:180px;">提交认证</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div> 
        
        
        
        </div>
        
      </div>
	 <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
      <div class="am-g" style="margin-top:8px; margin-left:10px;">
      <div class="am-u-sm-12">平台累计收益共计：　　<span style="color:#EE5858;"><fmt:formatNumber value="${(asset.income+income)}" type="number" maxFractionDigits="2" minFractionDigits="2"/></span> 元</div></div> 
      
    </div>
    <br>
    <div class="moneypanel3" style="height: 240px;">
    <div>
      <div class="am-u-sm-6" style="text-align:left;height: 50px;padding-left: 25px;">
        <div >净值总额：
        <span style="color:#EE5858"><fmt:formatNumber value="${(asset.account)}" type="number" maxFractionDigits="2" minFractionDigits="2"/></span> 元</div>
      </div>
      <c:forEach var="platformAcct"  items="${platformAcctList}">
      	<c:if test="${platformAcct.acctid ne 30}">
	      <div class="am-u-sm-6" style="text-align:left;height: 50px;padding-left: 25px;">
	        <div >${platformAcct.acctName}：
	        <span style="color:#EE5858"><fmt:formatNumber value="${platformAcct.account}" maxFractionDigits="2" type="number" minFractionDigits="2"/></span> 元</div>
	      </div>
	    </c:if>
      </c:forEach>
      </div>
      <div>
      <div class="am-u-sm-6" style="text-align:left;height: 50px;padding-left: 25px;">
        <div >内部会员账户：
        <span style="color:#EE5858"><fmt:formatNumber value="${decimal}" type="number" maxFractionDigits="2" minFractionDigits="2"/></span> 元</div>
      </div>
      </div>
    </div>
  </div>
  
  <div class="searchpanel">
    <form class="am-form-inline" role="form">
      <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">收支类型：</label>
      <select id="doc-select-1" name="budgetType" style="width:100px; height:30px; font-size:14px; color:#999">
          <option value="">全部</option>
          <option value="1101" <c:if test="${map.budgetType == 1101}">selected="selected"</c:if>>投资人充值费</option>
          <option value="1102" <c:if test="${map.budgetType == 1102}">selected="selected"</c:if>>投资人提现费</option>
          <option value="1110" <c:if test="${map.budgetType == 1110}">selected="selected"</c:if>>提前赎回费</option>
          <option value="1111" <c:if test="${map.budgetType == 1111}">selected="selected"</c:if>>发行服务费</option>
          <option value="1112" <c:if test="${map.budgetType == 1112}">selected="selected"</c:if>>信息服务费</option>
          <option value="1115" <c:if test="${map.budgetType == 1115}">selected="selected"</c:if>>管理服务费</option>
          <option value="1019" <c:if test="${map.budgetType == 1019}">selected="selected"</c:if>>调拨</option>          
          <option value="1020" <c:if test="${map.budgetType == 1020}">selected="selected"</c:if>>平台充值</option>
          <option value="1021" <c:if test="${map.budgetType == 1021}">selected="selected"</c:if>>平台提现</option>          
          <option value="1022" <c:if test="${map.budgetType == 1022}">selected="selected"</c:if>>自充本金</option>
          <option value="1023" <c:if test="${map.budgetType == 1023}">selected="selected"</c:if>>自充利息</option>
          <option value="1024" <c:if test="${map.budgetType == 1024}">selected="selected"</c:if>>购买转让标</option>
          <option value="1025" <c:if test="${map.budgetType == 1025}">selected="selected"</c:if>>转让标收益</option>
          <option value="1026" <c:if test="${map.budgetType == 1026}">selected="selected"</c:if>>坏账垫付</option>          
          <option value="1027" <c:if test="${map.budgetType == 1027}">selected="selected"</c:if>>红包费</option>
          <option value="1030" <c:if test="${map.budgetType == 1030}">selected="selected"</c:if>>付款</option>
      </select>
      <span class="am-form-caret"></span>
    </div> 
    <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">资金流向：</label>
      <select id="doc-select-1" name="capitalFlow"  style="width:100px; height:30px; font-size:14px; color:#999">
        <option value="">全部</option>
        <option value="1" <c:if test="${map.capitalFlow == 1}">selected="selected"</c:if>>增加</option>
        <option value="2" <c:if test="${map.capitalFlow == 2}">selected="selected"</c:if>>减少</option>
        <option value="3" <c:if test="${map.capitalFlow == 3}">selected="selected"</c:if>>持平</option>
      </select>
      <span class="am-form-caret"></span>
    </div>
    <div class="am-form-group" style="margin-top:10px;">
         <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >付款方ID：</label>
         <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
           <input class="am-form-field am-input-sm" type="text" name="payerId" id="payerId"  value="${map.payerId}" placeholder="付款方ID" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
         </div>
    </div>
    <div class="am-form-group" style="margin-top:10px;">
         <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >收款方ID：</label>
    <div class="am-u-sm-2" style="float:left; margin-left:-45px;">
         <input class="am-form-field am-input-sm" type="text" name="payeeId" id="payeeId" value="${map.payeeId}" placeholder="收款方ID" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;">
    </div>
    </div>
    <br>
	<div style="margin-left:18px; margin-top:15px; float:left;">交易时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;padding-top:0px; padding-bottom:0px;" id="beginTime" value="${map.beginTime}"/>
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;padding-top:0px; padding-bottom:0px;" id="endTime" value="${map.endTime}">
  </div>
  <button type="button" class="am-btn am-btn-success am-btn-sm" onclick="jump(1)" style="margin-top:15px; margin-left:123px; height:30px; padding-top:6px;"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">流水号</th>
            <th style="text-align:center;">流水时间</th>
            <th style="text-align:center;">收支类型</th>
            <th style="text-align:center;">付款方ID</th>
            <th style="text-align:center;">付款方账户</th>
            <th style="text-align:center;">付款方余额</th>
            <th style="text-align:center;">收款方ID</th>
            <th style="text-align:center;">收款方账户</th>
            <th style="text-align:center;">收款方余额</th>
            <th style="text-align:center;">收支</th>
            <th style="text-align:center;">账户余额</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="translog" items="${page.results}" varStatus="status">
    	<tr>
    		<td>${status.count}</td>
    		<td>${translog.id}</td>
    		<td><fmt:formatDate value="${translog.transtime}" type="both"/></td>
    		<td><c:forEach var="o"  items="${acctTranDef}" >
    			<c:if test="${translog.transcode == o.tranCode}">${o.showName}</c:if>
    		</c:forEach></td>
    		<td>${translog.payaccountid}<c:if test="${translog.payaccounttype ne 1}">${translog.paymemberid}</c:if><c:if test="${translog.payaccounttype eq 1}">${translog.payaccountid}</c:if></td>
    		<td>${translog.payername}</td>
    		<td>${translog.paysubamount}</td>
    		<td>${translog.payeeaccountid}<c:if test="${translog.payeeaccounttype ne 1}">${translog.payeememberid}</c:if><c:if test="${translog.payeeaccounttype eq 1}">${translog.payeeaccountid}</c:if></td>
    		<td>${translog.payeename}</td>
    		<td>${translog.payeesubamount}</td>
    		<td><c:if test="${translog.payaccounttype eq 1 && translog.payeeaccounttype eq 1}"> </c:if>
	    		<c:if test="${translog.payaccounttype ne 1 && translog.payeeaccounttype eq 1}">+</c:if>
	    		<c:if test="${translog.payaccounttype eq 1 && translog.payeeaccounttype ne 1}">-</c:if>
    		${translog.amount}</td>
    		<td>${translog.platavailamount}</td>
    	</tr>
    </c:forEach>
    </tbody>
</table>
<ul class="am-pagination am-pagination-right">
	        <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page.pageNow eq 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page.pageNow ne 1 }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow - 1})"> &lt;</a></li>
			</c:if>
			<c:if test="${page.pageNow > 4}">
				<li><a href="javascript:void(0)" onclick="jump(1)">1</a></li>
				<li><span>. . .</span></li>
			</c:if>
			<!-- 从action中获取分页页码下表的开始和结束下标 -->
			<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
				<c:if test="${page.pageNow eq i }">
					<li class="am-active"><span>${i}</span></li>
				</c:if>
				<c:if test="${page.pageNow ne i }">
					<li><a href="javascript:void(0)" onclick="jump(${i})">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${(page.totalPageCount-page.pageNow) >= 4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="jump(${page.totalPageCount})">${page.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page.pageNow ne page.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page.pageNow eq page.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
</div>
<p><button value="" onclick="exportEcxel()">导出Excel下载</button></p>
</div>
<form id="getTopost" action="queryPlatformacct.do" method="post">
  <input id="capitalFlowhidden" type="hidden" name="capitalFlow" />
  <input id="budgetTypehidden" type="hidden" name="budgetType" />
  <input id="payerIdhidden" type="hidden" name="payerId" />
  <input id="payeeIdhidden" type="hidden" name="payeeId" />
  <input id="beginTimehidden" type="hidden" name="beginTime" />
  <input id="endTimehidden" type="hidden" name="endTime" />
  <input id="pageNowhidden" type="hidden" name="pageNow" />
</form>
<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
function jump(num){
	var capitalFlow=$("select[name='capitalFlow']").val();
	var budgetType=$("select[name='budgetType']").val();
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var payerId=$("#payerId").val();
	var payeeId=$("#payeeId").val();
	$('#capitalFlowhidden').val(capitalFlow);
	$('#budgetTypehidden').val(budgetType);
	$('#beginTimehidden').val(beginTime);
	$('#endTimehidden').val(endTime);
	$('#payerIdhidden').val(payerId);
	$('#payeeIdhidden').val(payeeId);
	$('#pageNowhidden').val(num);
	$('#getTopost').submit();
}



function exportEcxel(){
	var capitalFlow=$("select[name='capitalFlow']").val();
	var budgetType=$("select[name='budgetType']").val();
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	var payerId=$("#payerId").val();
	var payeeId=$("#payeeId").val();
	window.location='platformExcel.do?capitalFlow='+capitalFlow+'&budgetType='+budgetType+
	'&beginTime='+beginTime+'&endTime='+endTime+'&payerId='+payerId+'&payeeId='+payeeId;    
}
</script>
<script type="text/javascript">
function recharge(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    data:{rechargeAmount:$('input[name="rechargeAmount"]').val(),rechargePwd:$('input[name="rechargePwd"]').val()},
	    url:'recharge.do',     
	    success:function(data){
	    	if("1" == data.status){
	        		alert("充值成功");
	        		location.href = "queryPlatformacct.do";
	        	}
	    	if("2" == data.status){
        		alert("密码错误");
        	}
	    	if("3" == data.status){
        		alert("密码不存在,请设置交易密码");
        		location.href = "setPassword.do";
        	}
		},		
	    error: function (data) {
	    	console.info(data);
	    	alert(getJsonErrorMsg(data));
	    	location.href = "queryPlatformacct.do";
    	}   
	}); 
}

function withdraw(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    data:{withdrawAmount:$('input[name="withdrawAmount"]').val(),withdrawPwd:$('input[name="withdrawPwd"]').val()},
	    url:'withdraw.do',     
	    success:function(data){
	    	if("1" == data.status){
	        		alert("提现成功");
	        		location.href = "queryPlatformacct.do";
	        	}
	    	if("2" == data.status){
        		alert("密码错误");
        	}
	    	if("3" == data.status){
        		alert("密码不存在,请设置交易密码");
        		location.href = "setPassword.do";
        	}
		} ,
		error: function (data) {
	    	console.info(data);
	    	alert(getJsonErrorMsg(data));
	    	location.href = "queryPlatformacct.do";
    	}  
	}); 
}

function allot(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    data:{fromAcct:$('select[name="fromAcct"]').val(), toAcct:$('select[name="toAcct"]').val(),allotAmount:$('input[name="allotAmount"]').val(),
	    	  allotPwd:$('input[name="allotPwd"]').val(),allotRemark:$('textarea[name="allotRemark"]').val()},
	    url:'allot.do',     
	    success:function(data){
	    	if("1" == data.status){
	        		alert("调拨成功");
	        		location.href = "queryPlatformacct.do";
	        	}
	    	if("2" == data.status){
        		alert("密码错误");
        	}
	    	if("3" == data.status){
        		alert("密码不存在,请设置交易密码");
        		location.href = "setPassword.do";
        	}
	    	if("4" == data.status){
        		alert("调拨失败");
        	}
	    	if("5" == data.status){
        		alert("余额不足");
        	}
		},
		error: function (data) {
	    	console.info(data);
	    	alert(getJsonErrorMsg(data));
	    	location.href = "queryPlatformacct.do";
    	}  
	}); 
}

function compensation(){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    data:$('#compensation').serialize(),
	    url:'compensation.do',     
	    success:function(data){
	    	if("1" == data.status){
	        		alert("调拨成功");
	        		location.href = "queryPlatformacct.do";
	        	}
	    	if("2" == data.status){
        		alert("密码错误");
        	}
	    	if("3" == data.status){
        		alert("密码不存在,请设置交易密码");
        		location.href = "setPassword.do";
        	}
	    	if("4" == data.status){
        		alert("调拨失败");
        	}
		},
		error: function (data) {
	    	console.info(data);
	    	alert(getJsonErrorMsg(data));
	    	location.href = "queryPlatformacct.do";
    	}  
	}); 
}
</script>
</body>
</html>
