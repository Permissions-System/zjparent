<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>每日数据汇总</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

//初始化输入日期框
$(function(){
	var year = getYear();
	var month = getMonth();
	   //$("input[name='yearStr']").attr("value",year);  
	   //$("input[name='monthStr']").attr("value",month);  
	   
	   $('#yearStr').combobox('setValue', year);
	   $('#monthStr').combobox('setValue', month);
	}); 
	
	//快速查询
 	function searchUserQ()
	{
		var flg = false;
 		var year = $("input[name='yearStr']").val();
 		var month = $("input[name='monthStr']").val();
 		
 		var mydate = new Date();
 		
 		if(year==null || year=="")
 		{
 			year = mydate.getFullYear();; //获取当前年份(2位)
 		}
 		else if(month==null || month=="")
 		{
 			month = mydate.getMonth()+1; //获取当前月份(0-11,0代表1月)
 		}
 		
 		$('#datagrid').datagrid('reload',{
		 		yearStr: year,
		 		monthStr: month
			}); 
 		
	}
	
	
 	//导出Excel 	
	function redirectURL()
	{
		$("#paramForm").submit();
	}
 	
	
	function getYear()
 	{
 		var year;
 		var myDate = new Date();  
 	    year = myDate.getFullYear();   //获取完整的年份(4位,1970-????)  
 	    return year;
 	}
	
	function getMonth()
	{
		var month;
		var myDate = new Date();  
		month = myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)  
		return month;
	}
	
	
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="每日数据汇总" class="easyui-datagrid" fit="true"
			url="${path}/daily/datagrid"  pagination="true" toolbar="#tb"
			fitColumns="false" singleSelect="true" rownumbers="true"
			border="false" nowrap="false" data-options="pageSize:40">
			<thead>
				<tr>
					<!--共18： 日期		注册人数		登录人次		登录人数		"老客户登录人次"		"老客户登录人数"		开户人数		充值笔数		充值人数	
					充值金额		投资笔数		投资人数		投资金额		首次投资人数		首次投资者金额	提现笔数		提现人数		提现金额 -->
					
					<th data-options="field:'currentdate',width:100,formatter:CEditymd,align:'center'" >日期</th>
					<th data-options="field:'regcnt',width:100,align:'center'" >注册人数</th>
					<th data-options="field:'logintime',width:100,align:'center'" >登录人次	</th>
					<th data-options="field:'logincnt',width:100,align:'center'" >登录人数</th>
					<th data-options="field:'customerslogintime',width:100,align:'center'" >老客户登录人次</th>
					<th data-options="field:'customerslogincnt',width:100,align:'center'" >老客户登录人数</th>
					<th data-options="field:'openactnum',width:100,align:'center'" >开户人数</th>
					<th data-options="field:'platformrechargenum',width:100,align:'center'" >平台充值笔数</th>
					<th data-options="field:'platformrechargepernum',width:100,align:'center'" >平台充值人数</th>
					<th data-options="field:'platformrechargeamount',width:100,align:'center',formatter:formatCurrency" >平台充值金额</th>
					<th data-options="field:'fuyourechargenum',width:100,align:'center'" >富有充值笔数</th>
					<th data-options="field:'fuyourechargepernum',width:100,align:'center'" >富有充值人数</th>
					<th data-options="field:'fuyourechargeamount',width:100,align:'center',formatter:formatCurrency" >富有充值金额</th>
					<th data-options="field:'investnum',width:100,align:'center'" >投资笔数	</th>
					<th data-options="field:'investpernum',width:100,align:'center'" >投资人数</th>
					<th data-options="field:'investamount',width:100,align:'center',formatter:formatCurrency" >投资金额	</th>
					<th data-options="field:'firstinvestpernum',width:100,align:'center'" >首次投资人数</th>
					<th data-options="field:'firstinvestamount',width:100,align:'center',formatter:formatCurrency" >首次投资者金额</th>
					<th data-options="field:'platformwithdrawnum',width:100,align:'center'" >平台提现笔数</th>
					<th data-options="field:'platformwithdrawpernumber',width:100,align:'center'" >平台提现人数	</th>
					<th data-options="field:'platformwithdrawamount',width:100,align:'center',formatter:formatCurrency" >平台提现金额</th>
					<th data-options="field:'fuyouwithdrawnum',width:100,align:'center'" >富有提现笔数</th>
					<th data-options="field:'fuyouwithdrawpernumber',width:100,align:'center'" >富有提现人数	</th>
					<th data-options="field:'fuyouwithdrawamount',width:100,align:'center',formatter:formatCurrency" >富有提现金额</th>
					<th data-options="field:'remark',width:100,align:'center' ">记录</th>
					
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/daily/exportExcel" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					选择年份  :  
					<select class="easyui-combobox" name="yearStr" id="yearStr" panelHeight="auto" style="width:100px">
						<option value=""></option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
					</select>
					选择月份  :  
					<select class="easyui-combobox" name="monthStr" id="monthStr" panelHeight="auto" style="width:100px">
						<option value=""></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
					<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
