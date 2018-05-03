<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<%@include file="../pub/header.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/pub/jquery.number.min.js"></script>
<style type="text/css">
.tabs-container {
	width: 100%;
	height: 100%;
}

.easyui-tabs {
	width: 100%;
	height: 100%;
}

.easyui-layout {
	width: 100%;
	height: 100%;
}

.easyui-panel {
	width: 300px;
	height: 400px;
	padding: 10px;
}
#infoForm td{
 padding-left: 30px;
 padding-bottom: 20px;
}
</style>

</head>
<body>
	<div style="width: 100%; height: 100%;">
		<div class="easyui-tabs">
			<div title="基本信息" style="padding: 10px">
				<div id="infoPanel">
					<form id="infoForm" method="post" >
						<table style="margin-left: 50px;width: 500px;">
							<tr>
								<td><label>用户ID:</label></td>
								<td><input class="easyui-validatebox" type="text" id="id"
									disabled="disabled" name="id"></input></td>
							</tr>
							<tr>
								<td><label>用户名:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="username" disabled="disabled" name="username"></input></td>
							</tr>
							<tr>
								<td><label>注册时间:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="createDate" disabled="disabled" name="createDate"></input></td>
							</tr>
							<tr>
								<td><label>性别:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="gender" disabled="disabled" name="gender"></input></td>
							</tr>
							<tr>
								<td><label>年龄:</label></td>
								<td><input class="easyui-validatebox" id="age"
									disabled="disabled" type="text"></input></td>
							</tr>
							</tr>
							<tr>
								<td><label>邮箱:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="email" disabled="disabled" name="email"></input> <span
									id="emailverify"></span>
									</div></td>
							</tr>
							</tr>
							<tr>
								<td><label>手机:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="mobile" disabled="disabled" name="mobile"></input> <span
									id="mobileverify"></span></td>
							</tr>
							<tr>
								<td><label>联系地址:</label></td>
								<td><span id="address">  </span></td>
							</tr>
							</tr>
							<tr>
								<td><label>身份证:</label></td>
								<td><input class="easyui-validatebox" type="text"
									id="idcard" disabled="disabled" name="idcard"></input> <span
									id="idcardverify"></span></td>
							</tr>
							</tr>
							<tr>
								<td><label>银行卡:</label></td>
								<td><span id="bankCard"></span></td>
							</tr>
							</tr>
							<tr>
								<td><label>交易密码:</label></td>
								<td><span id="tranPassword"></span></td>
							</tr>
							</tr>
							<tr>
								<td><label>帐号状态:</label></td>
								<td><span id="userstatus" name="userstatus"></span> &nbsp;
								<a href="javaScript:void(0);" class="easyui-linkbutton"
										  id="userstatusBut">冻结</a>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div title="账户详情">
				<div style="padding: 10px 60px 20px 60px">
					<form method="post">
						<table cellpadding="5">
							<tr>
								<td>账户总额:</td>
								<td><span id="totalAccount"></span></td>
							</tr>
							<tr>
								<td>可用余额:</td>
								<td><span id="availableBalance"></span></td>
							</tr>
							<tr>
								<td>收益总额:</td>
								<td><span id="yesterdayIncome"></span></td>
							</tr>
							<tr>
								<td>
									<div id="rechargeTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="充值总额" data-options="collapsible:true">
										<span> 网上充值 </span> <span id="rechargeTotal"></span>
									</div>
								</td>
								<td>
									<div id="withdrawTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="提现总额" data-options="collapsible:true">
										<span> 提现总额 </span> <span id="withdrawTotal"></span>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="freezeTotalPanel" style="width: 300px; height: 120px;"
										class="easyui-panel" title="冻结总额"
										data-options="collapsible:true"></div>
								</td>
								<td>
									<div id="earningsTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="收益总额" data-options="collapsible:true">
										<span> 奖励</span> <span id="reward">0</span> <br /> <span>
											提成 </span> <span id="deductPercentage">0</span> <br /> <span>
											利息 </span> <span id="interestEarnings">0</span> <br /> <span>
											积分兑换 </span> <span>0</span> <br />
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="investmentTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="投资总额" data-options="collapsible:true"></div>
								</td>
								<td>
									<div id="collectionTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="待收总额" data-options="collapsible:true">
										<span>待收本金</span> <span id="collectionPrincipal">0</span> <br />
										<span>待收利息</span> <span id="collectionInterest">0</span> <br />
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div id="receivedTotalPanel"
										style="width: 300px; height: 120px;" class="easyui-panel"
										title="已收总额" data-options="collapsible:true">
										<span>已收本金</span> <span id="receivedPrincipal">0</span> <br />
										<span>已收利息</span> <span id="receivedInterest">0</span> <br />
									</div>
								</td>
								<td>
									<div id="feeTotalPanel" style="width: 300px; height: 120px;"
										class="easyui-panel" title="成本支出总额"
										data-options="collapsible:true">
										<span>转让费</span> <span id="transferFee">0</span> <br /> <span>提前赎回费用</span>
										<span id="redemptionFee">0</span>
									</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div title="资金流水">
				<div class="easyui-layout" data-options="fit:true,selected:true"
					style="width: 100%; height: 500px;">
					<div class="datagrid-toolbar"
						data-options="region:'north',split:true,title:'查询'"
						style="height: 130px; padding: 20px 0px 10px 30px">
						<form id="queryForm" method="post" novalidate>
							<table class="datagrid-toolbar"
								style="width: 100%; height: 70%; border: 0px; font-size: 12px">
								<tr>
									<td><label for="qyCreateDateStart">发生时间:</label></td>
									<td><input id="qyCreateDateStart"
										class="easyui-datetimebox" style="width: 155px;"
										data-options="editable:false"></td>
									<td><input id="qyCreateDateEnd" class="easyui-datetimebox"
										style="width: 160px;" data-options="editable:false"></td>
									<td><label for="qyOperastatusvalue">资金类型:</label></td>
									<td>
										<div>
											<select id="qyOperastatusvalue" class="easyui-combobox"
												panelHeight="auto" style="width: 155px;">
												<option value="">全部</option>
												<option value="1001">充值</option>
												<option value="1002">提现</option>
												<option value="1004">投资</option>
												<option value="1016">回收利息</option>
												<option value="1015">回收本金</option>
												<option value="FEE">手续费</option>
											</select>
										</div>
									</td>
									<td><label for="qyCapitalDirection">资金方向:</label></td>
									<td>
										<div>
											<select id="qyCapitalDirection" class="easyui-combobox"
												panelHeight="auto" style="width: 155px;">
												<option value="">全部</option>
												<option value="I">增加</option>
												<option value="O">减少</option>
											</select>
										</div>
									</td>
									<td><a href="#" class="easyui-linkbutton"
										iconCls="icon-search" id="btnQuery">查询</a> <a href="#"
										class="easyui-linkbutton" iconCls="icon-undo" id="btnCancel">清空</a>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div data-options="region:'center',border:true,title:'列表'">
						<table id="itLogInfo"
							data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
						</table>
					</div>
				</div>
			</div>
			<div title="交易记录">
				<div class="easyui-layout" data-options="fit:true,selected:true"
					style="width: 100%; height: 500px;">
					<div class="datagrid-toolbar"
						data-options="region:'north',split:true,title:'查询'"
						style="height: 130px; padding: 20px 0px 10px 30px">
						<form id="invesTransInfoForm" method="post" novalidate>
							<table class="datagrid-toolbar"
								style="width: 100%; height: 70%; border: 0px; font-size: 12px">
								<tr>
									<td><label for="qyBidName">标的名称:</label></td>
									<td><input type="text" id="qyBidName" /></td>
									<td><label for="qyTransType">标的类型:</label></td>
									<td>
										<div>
											<select id="qyTransType" class="easyui-combobox"
												panelHeight="auto" style="width: 155px;">
												<option value="">全部</option>
												<option value="1">投资</option>
												<option value="2">提前赎回</option>
											</select>
										</div>
									</td>
									<td><label for="qyOrderStatus">状态:</label></td>
									<td>
										<div>
											<select id="qyOrderStatus" class="easyui-combobox"
												panelHeight="auto" style="width: 155px;">
												<option value="">全部</option>
												<option value="1">募集中</option>
												<option value="2">募集完成(已计息)</option>
												<option value="3">募集完成(未计息)</option>
												<option value="4">已兑付</option>
												<option value="5">提前赎回中</option>
												<option value="6">已赎回</option>
												<option value="7">赎回失败</option>
												<option value="8">(天天富)未计息</option>
												<option value="9">(天天富)计息中</option>
												<option value="10">(天天富)已转出</option>
												<option value="11">(天天富)已兑付</option>
											</select>
										</div>
									</td>
								</tr>
								<tr>
									<td><label for="qyCreateDateStartInvesTrans">发生时间:</label></td>
									<td><input id="qyCreateDateStartInvesTrans"
										class="easyui-datetimebox" style="width: 155px;"
										data-options="editable:false"> -- <input
										id="qyCreateDateEndInvesTrans" class="easyui-datetimebox"
										style="width: 160px;" data-options="editable:false"></td>
									<td colspan="4"><a href="#" class="easyui-linkbutton"
										iconCls="icon-search" id="btnQueryInvestTrans">查询</a> <a
										href="#" class="easyui-linkbutton" iconCls="icon-undo"
										id="btnCancelInvestTrans">清空</a></td>
								</tr>
							</table>
						</form>
					</div>
					<div data-options="region:'center',border:true,title:'列表'">
						<table id="invesTransInfo"
							data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
						</table>
					</div>
				</div>
			</div>
			<div title="推荐好友">
				<div class="easyui-layout" data-options="fit:true,selected:true"
					style="width: 100%; height: 500px;">
					<div data-options="region:'center',border:true,title:'列表'">
						<table id="referralInfo"
							data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true">
						</table>
					</div>
				</div>
			</div>
			<div title="积分明细"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var memberId = '${memberId}';
	$(function() {
		updateInfo(memberId);
		getAccountSummary(memberId);
		
		// 资金流水 start
		$("#btnQuery").bind("click", function() {
			queryInfo();
		});
		// 查询取消按钮事件
		$("#btnCancel").bind("click", function() {
			queryCancel();
		});
		initDataGrid();
		// 资金流水 end
		
		// 交易流水 start
		$("#btnQueryInvestTrans").bind("click", function() {
			queryInfoInvestTrans();
		});
		// 查询取消按钮事件
		$("#btnCancelInvestTrans").bind("click", function() {
			queryCancelInvestTrans();
		});
		initDataGridInvestTrans();
		// 交易流水 end
		
		
		//推荐好友
		initDataGridReferral();
		
	});
	// 资金流水 start
		function initDataGrid() {
			$("#itLogInfo")
					.datagrid(
							{
								pagination : true,
								rownumbers : true,
								pageSize : 10,
								pageList : [ 10, 20 ],
								nowrap : false,
								autoRowHeight : false,
								striped : true,
								border : false,
								fitColumns : true,
								method : 'post',
								singleSelect : true,
								fit : true,
								url : '${ctx}/member/getCapitalTransByPage.do?memberId='+memberId,
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : '交易流水号',
											field : 'id',
											width : 100
										},
										{
											title : '时间',
											field : 'transtime',
											width : 150,
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}
										},
										{
											title : '类型',
											field : 'transCodeName',
											width : 150,
											formatter : function(value, rec) {
												// update by liulei 2015年3月26日 17:55:48 flag001-赎回回收本金
												if(rec.paymemberid==memberId && rec.transcode=='1015'){
													 return '投资扣款(转让标)';
												} 
												return value;
											}
										},
										{
											title : '资金方向',
											field : 'capitalDirection',
											width : 100,
											align : 'center',
											formatter : function(value, rec) {
												// update by liulei 2015年3月26日 17:55:48 flag001-赎回回收本金
												if(rec.paymemberid==memberId && rec.transcode=='1015'){
													 return '减少';
												} 
												return value;
											}
										},
										{
											title : '金额（元）',
											field : 'amount',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										},
										{
											title : '账户余额（元）',
											field : 'availamount',
											width : 100,
											formatter : function(value, rec) {
												// update by liulei 2015年3月26日 17:55:48 flag001-赎回回收本金
												if(rec.paymemberid==memberId){
													 return $.number(rec.paysubamount,2);
												}else{
													 return $.number(rec.availamount,2);
												}
												return $.number(value,2);
											}
										},
										{
											title : '状态',
											field : 'transstatus',
											width : 100,
											formatter : function(value, rec) {
												var statusStr = '';
												if(value=='1'){
													statusStr="成功";
												}else if(value=='0'){
													statusStr="处理中";
												}else if(value=='2'){
													if(rec.transcode==1002 && rec.remark!= ''){
														statusStr="未完成("+rec.remark+")";
													}else{
														statusStr="未完成";
													}
												}
												return statusStr;
											}
										} ] ]
							});
		}
	
		function queryInfo() {
			// 为明细分页组件赋值
			// 根据查询组合条件，取记录当前的页面 取第一页数据 load
			$('#itLogInfo').datagrid(
					'load',
					{
						startdate : $('#qyCreateDateStart').datetimebox('getValue'),
						enddate : $('#qyCreateDateEnd').datetimebox('getValue'),
						operastatusvalue : $('#qyOperastatusvalue').combobox('getValue'),
						capitalDirection : $('#qyCapitalDirection').combobox('getValue')
					});
			disPagelistOption();
		}
		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOption() {
			$(".pagination-num").attr('disabled', 'disabled');
		}
		
		function queryCancel() {
			$('#queryForm').form('clear');
		}
	
	// 资金流水 end
	
	// 交易流水 start
		function initDataGridInvestTrans() {
			$("#invesTransInfo")
					.datagrid(
							{
								pagination : true,
								rownumbers : true,
								pageSize : 10,
								pageList : [ 10, 20 ],
								nowrap : false,
								autoRowHeight : false,
								striped : true,
								border : false,
								fitColumns : true,
								method : 'post',
								singleSelect : true,
								fit : true,
								url : '${ctx}/member/getInvertTrans.do?memberId='+memberId,
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : '订单号',
											field : 'investordercode',
											width : 190
										},
										{
											title : '标的名称',
											field : 'bidclassname',
											width : 100
										},
										{
											title : '标的编号',
											field : 'bidcode',
											width : 170
										},
										{
											title : '类型',
											field : 'transname',
											width : 100,
											align : 'center',
											formatter : function(value , rec){
												if(value == '1'){
													return '投标';
												}else if(value == '2'){
													return '提前赎回';
												}
												return value;
											}
										},
										{
											title : '交易时间',
											field : 'orderdate',
											width : 150,
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}
										},
										{
											title : '状态',
											field : 'showStatus',
											width : 130,
											align : 'center',
											formatter : function(value, rec) {
												//天天富
												if(rec.bidtypeid == 4){
													var bidtypeid = rec.bidtypeid;
													//已完成
													if(rec.orderstatus == 2){
														if(rec.orderstatusdesc == 9){
															return '已转出';	
														}else{
															return '已兑付';
														}
													} else if(rec.orderstatus == 1){
														if(rec.orderstatusdesc==0){
															return '未计息';
														}else{
															return '计息中';
														}
													}
													//天天富以外的产品
												}
												return value;
											}
										},
										{
											title : '年化收益率%',
											field : 'annualizedrate',
											width : 70
										},
										{
											title : '每份金额',
											field : 'mininvestamount',
											width : 80,
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										},
										{
											title : '份数',
											field : 'sharenumber',
											width : 50
										},
										{
											title : '计息时间',
											field : 'exptinterestdate',
											width : 110,
											formatter : function(value, rec) {
												if(!value == null){
												   var date = new Date(value);
												   return date.format('yyyy-mm-dd HH:MM:ss');
												}
												return value;
											}
										},
										{
											title : '还款时间',
											field : 'exptlastacctdate',
											width : 110,
											formatter : function(value, rec) {
												if(!value == null){
													   var date = new Date(value);
													   return date.format('yyyy-mm-dd HH:MM:ss');
												}
												return value;
											}
										},
										{
											title : '预期利息',
											field : 'accruedInterestSum',
											width : 100
										},
										{
											title : '已收益',
											field : 'repaidInterestSum',
											width : 100
										},
										{
											title : '交易金额(元)',
											field : 'amount',
											width : 100,
											formatter : function(value, rec) {
												return $.number(value,2);
											}
										},
										{
											field : 'opation',
											title : '操作',
											align : 'center',
											width : 90,
											formatter : function(value, row,
													index) {
												var opt = '';
												// 月月富T
												if(row.bidtypeid == '3'){
													var url = webCtx+'static/upload/buyprotocol/'+row.bidtypeid+'/'+row.customerId+'_'+row.investordercode+'.pdf';
													var zrUrl = webCtx+'static/upload/buyprotocol/'+row.bidtypeid+'/debt_'+row.customerId+'_'+row.investordercode+'.pdf';
													opt += '<a href="'+url+'" target="_blank"  class="easyui-linkbutton">购买协议</a>&nbsp;&nbsp;';
													opt += '<a href="'+zrUrl+'" target="_blank"  class="easyui-linkbutton">转让协议</a>';
													// 天天富
												}else if(row.bidtypeid == '4'){
													var url = webCtx+'static/upload/buyprotocol/'+row.bidtypeid+'/'+row.customerId+'_'+row.investordercode+'.pdf';
													opt += '<a href="'+url+'" target="_blank"  class="easyui-linkbutton">协议</a>';
												}
												return opt;
											}
										} ] ]
							});
		}
	
		function queryInfoInvestTrans() {
			// 为明细分页组件赋值
			// 根据查询组合条件，取记录当前的页面 取第一页数据 load
			$('#invesTransInfo').datagrid(
					'load',
					{
						startdate : $('#qyCreateDateStartInvesTrans').datetimebox('getValue'),
						enddate : $('#qyCreateDateEndInvesTrans').datetimebox('getValue'),
						transType : $('#qyTransType').combobox('getValue'),
						orderStatus : $('#qyOrderStatus').combobox('getValue'),
						bidName : $('#qyBidName').val()
					});
			disPagelistOptionInvestTrans();
		}
		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOptionInvestTrans() {
			$(".pagination-num").attr('disabled', 'disabled');
		}
		
		function queryCancelInvestTrans() {
			$('#invesTransInfoForm').form('clear');
		}
	
	// 资金流水 end
	
	// 推荐好友
		function initDataGridReferral() {
			$("#referralInfo")
					.datagrid(
							{
								pagination : true,
								rownumbers : true,
								pageSize : 10,
								pageList : [ 10, 20 ],
								nowrap : false,
								autoRowHeight : false,
								striped : true,
								border : false,
								fitColumns : true,
								method : 'post',
								singleSelect : true,
								fit : true,
								url : '${ctx}/member/getReferralByPage.do?agentid='+memberId,
								onSelect : function(rowIndex, rowData) {
								},
								onLoadError : function() {
									showSlideMessage("信息查询失败!");
								},
								columns : [ [
										{
											title : 'id',
											field : 'id',
											width : 80
										},
										{
											title : '账号',
											field : 'email',
											width : 150
										},
										{
											title : '姓名',
											field : 'realname',
											width : 100
										},
										{
											title : '账号状态',
											field : 'userstatus',
											width : 100,
											formatter : function(value, rec) {
												var userStatus = '';
												if (value == '0') {
													userStatus = '冻结的';
												} else if (value == '1') {
													userStatus = '正常的';
												} else if (value == '2') {
													userStatus = '未激活';
												}
												return userStatus;
											}
										},
										{
											title : '注册时间',
											field : 'createDate',
											width : 150,
											align : 'center',
											formatter : function(value, rec) {
												var date = new Date(value);
												return date.format('yyyy-mm-dd HH:MM:ss');
											}										
										},
										{
											title : '成交次数',
											field : 'num',
											width : 150
										},
										{
											title : '累计红包',
											field : 'account',
											width : 150,
											formatter : function(value, rec)  {
												if(value == null){
													   return 0;
												}
												return value;
											}
										},
										{
											title : '用户来源',
											field : 'a',
											width : 50
										},
										{
											field : 'opation',
											title : '操作',
											align : 'center',
											width : 150,
											formatter : function(value, row,
													index) {
												var opt = '';
												opt += '<a href="javascript:void(0)" onclick="jump('+index+');" class="easyui-linkbutton">查看明细</a>';
												return opt;
											}
										}
									 ] ]
							});
		}
	
		/**
		 * 格式化 分页栏 每页显示页数不可选择，当天页数不可编辑
		 */
		function disPagelistOptionReferral() {
			$(".pagination-num").attr('disabled', 'disabled');
		}
	
	function getAccountSummary(memberId) {
		$.ajax({
					async : false,
					type : 'POST',
					url : '${ctx}/member/getAccountSummary.do',
					data : {
						memberId : memberId
					},
					success : function(data, status) {
						if (data.status == 'SUCCESS') {
							var memberAccount = data.result;
							if(memberAccount != null){
								$('#totalAccount').html('￥'+$.number(memberAccount.totalAccount,2));
								$('#availableBalance').html(
										'￥'+$.number(memberAccount.availableBalance,2));
								//历史收益
								$('#yesterdayIncome').html(
										'￥'+$.number(memberAccount.earningsTotal,2));
	
								$('#rechargeTotalPanel').panel(
										"setTitle",
										'充值总额         ￥'
												+ $.number(memberAccount.rechargeTotal,2));
								$('#rechargeTotal').html(
										'￥'+$.number(memberAccount.rechargeTotal,2));
								$('#withdrawTotalPanel').panel(
										"setTitle",
										'提现总额         ￥'+$.number(memberAccount.withdrawTotal,2));
								$('#withdrawTotal').html(
										$.number(memberAccount.withdrawTotal,2));
	
								$('#freezeTotalPanel')
										.panel(
												"setTitle",
												'冻结总额        ￥'+$.number(memberAccount.freezeTotal,2));
	
								$('#earningsTotalPanel').panel(
										"setTitle",
										'收益总额         ￥'+$.number(memberAccount.earningsTotal,2));
								// 利息收益
								$('#interestEarnings').html('￥'+$.number(memberAccount.earningsTotal,2));
	
								$('#investmentTotalPanel').panel(
										"setTitle",
										'投资总额         ￥'+$.number(memberAccount.investmentTotal,2));
	
								$('#collectionTotalPanel')
										.panel(
												"setTitle",
												'待收总额        ￥'+ $.number((memberAccount.collectionPrincipal + memberAccount.collectionInterest),2));
								$('#collectionPrincipal').html('￥'+$.number(memberAccount.collectionPrincipal,2));
								$('#collectionInterest').html('￥'+$.number(memberAccount.collectionInterest,2));
	
								// 已收本金 = 投资总额 - 待收本金
								var receivedPrincipal = (memberAccount.investmentTotal - memberAccount.collectionPrincipal);
								console.log(parseFloat(receivedPrincipal)+'--'+parseFloat($.number(memberAccount.receivedInterest,2)));
								$('#receivedTotalPanel')
										.panel(
												"setTitle",
												'已收总额       ￥'+$.number((parseFloat(receivedPrincipal) + parseFloat($.number(memberAccount.receivedInterest,2))),2));
								$('#receivedPrincipal').html(
										'￥'+$.number(receivedPrincipal,2));
								// 已收利息
								$('#receivedInterest').html(
										'￥'+$.number(memberAccount.receivedInterest,2));
	
								$('#feeTotalPanel')
										.panel(
												"setTitle",
												'成本支出总额         ￥'+ $.number((memberAccount.transferFee + memberAccount.redemptionFee),2));
								$('#transferFee').html('￥'+$.number(memberAccount.transferFee,2));
								$('#redemptionFee').html('￥'+$.number(memberAccount.redemptionFee,2));
							}
						}
					}
				});
	}
	
	function jump(rowId){
		 $('#referralInfo').datagrid('selectRow', rowId);
		 var node = $('#referralInfo').datagrid('getSelected');
		 var url = '${ctx}/member/getReferralInfo.do?memberId='+node.id;
		 var username = '';
		 var realname = '';
		 if(node.email != null){
			 username = node.email;
		 }
		 if(node.realname != null){
			 realname = '('+node.realname+')';
		 }
		 self.parent.openTab('用户详情:'+username+''+realname+'', url);
		
	}
	
	function updateInfo(memberId) {
		var memberSafety = '';
		var member = '';
		$.ajax({
			async : false,
			type : 'POST',
			url : '${ctx}/member/getMemberInfo.do',
			data : {
				memberId : memberId
			},
			success : function(data, status) {
				if (data.status == 'SUCCESS') {
					member = data.result[0];
					memberSafety = data.result[1];
				}
			}
		});

		$('#id').val(member.id);
		$("#username").val(member.email);
		$('#createDate').val(
				new Date(member.createDate).format('yyyy-mm-dd HH:MM:ss'));
		var gender = '';
		if (member.gender == '1') {
			gender = '男';
		} else if (member.gender == '0') {
			gender = '女';
		}
		$('#gender').val(gender);
		$('#email').val(member.email);
		if (memberSafety.emailifverified == 1) {
			$('#emailverify').html(
					'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
							+ new Date(memberSafety.emailverifydate).format('yyyy-mm-dd HH:MM:ss'));
		} else {
			$('#emailverify').html('未验证');
		}

		$('#mobile').val(member.mobile);
		if (memberSafety.mobileifverified == 1) {
			$('#mobileverify').html(
					'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
							+ new Date(memberSafety.mobileifverifydate).format('yyyy-mm-dd HH:MM:ss'));
		} else {
			$('#mobileverify').html('未验证');
		}
		
		 
		$('#address').html(member.address); 
		$('#idcard').val(member.idcard);
		 
		if (memberSafety.idcardifverified == 1) {
			if(memberSafety.idcardverifydate == null){
				$('#idcardverify').html(
						'<input type="checkbox" checked="checked" /> 已验证 , 验证时间');
			}
			$('#idcardverify').html(
					'<input type="checkbox" checked="checked" /> 已验证 , 验证时间:'
							+ new Date(memberSafety.idcardverifydate).format('yyyy-mm-dd HH:MM:ss'));
		} else {
			$('#idcardverify').html('未验证');
		}

		var userStatus = '';
		if (member.userstatus == '0') {
			userStatus = '冻结的';
			$('#userstatusBut').linkbutton({text:'解冻'});
			$('#userstatusBut').attr('status' , '1');
		} else if (member.userstatus == '1') {
			userStatus = '正常的';
			$('#userstatusBut').linkbutton({text:'冻结'});
			$('#userstatusBut').attr('status' , '0');
		} else if (member.userstatus == '2') {
			userStatus = '未激活';
		}
		$('#userstatus').html(userStatus);
		
		$('#userstatusBut').click(function(){
			var userstatus = $(this).attr('status');
			$.ajax({
				async : false,
				type : 'POST',
				url : '${ctx}/member/updateStatus.do',
				data : {
					memberId : memberId,
					status : userstatus
				},
				success : function(data, status) {
					if (data.status == 'SUCCESS') {
						 var userStatus = '';
							if (userstatus == '0') {
								userStatus = '冻结的';
								$('#userstatusBut').linkbutton({text:'解冻'});
								$('#userstatusBut').attr('status' , '1');
								//alert('冻结成功');
							} else if (userstatus == '1') {
								userStatus = '正常的';
								$('#userstatusBut').linkbutton({text:'冻结'});
								$('#userstatusBut').attr('status' , '0');
								//alert('解冻成功');
							} else if (userstatus == '2') {
								userStatus = '未激活';
							}
							$('#userstatus').html(userStatus);
					}else{
						alert($(this).attr(text)+'失败');
					}
				}/* ,
				error: function() {
					alert($(this).attr(text)+'失败');
				} */
			});
		});
		
		if ($('#idcard').val() !== '') {
			var age = discriCard($('#idcard').val());
			$('#age').val('' + age + ' 周岁');
		}
		if (memberSafety.transpasswdverified == 1) {
			$('#tranPassword').html('已设置');
		} else {
			$('#tranPassword').html('未设置');
		}

	    if(memberSafety.bankcardno != null){
			$('#bankCard').html(
					memberSafety.bankname + '  ' + memberSafety.bankcardno);
	    }
	};

	function discriCard(UUserCard) {
		//获取出生日期 
		UUserCard.substring(6, 10) + "-" + UUserCard.substring(10, 12) + "-"
				+ UUserCard.substring(12, 14);
		//获取性别 
		if (parseInt(UUserCard.substr(16, 1)) % 2 == 1) {
			//是男则执行代码 ... 
		} else {
			//是女则执行代码 ... 
		}
		//获取年龄 
		var myDate = new Date();
		var month = myDate.getMonth() + 1;
		var day = myDate.getDate();
		var age = myDate.getFullYear() - UUserCard.substring(6, 10) - 1;
		if (UUserCard.substring(10, 12) < month
				|| UUserCard.substring(10, 12) == month
				&& UUserCard.substring(12, 14) <= day) {
			age++;
		}
		return age;
		//年龄 age 
	};
</script>
</html>