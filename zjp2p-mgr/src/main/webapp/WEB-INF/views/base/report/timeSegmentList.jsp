<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>时段基础数据</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<SCRIPT src= "${path}/static/js/kaiyun/Clock.js" type= text/javascript></SCRIPT >
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	//初始化输入日期框
	$(function(){
		var today = getYmd();
		　　$('#beginTime').datebox('setValue', today);	
		　   $('#endTime').datebox('setValue', today);	
		}); 
	
	//快速查询
 	function searchUserQ()
	{
		var flag = true;
 		var beginTime = $("input[name='beginTime']").val();
 		var endTime = $("input[name='endTime']").val();
 		
 		$('#datagrid').datagrid('reload',{
		 		beginTime: beginTime,
		 		endTime: endTime
			});
	}
	
 	//导出Excel 	
	function redirectURL()
	{
		$("#paramForm").submit();
	}
 	
 	function getYmd()
 	{
 		var year,month,date;
 		var myDate = new Date();  
 	    //myDate.getYear();       //获取当前年份(2位)  
 	    year = myDate.getFullYear();   //获取完整的年份(4位,1970-????)  
 	    month = myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)  
 	    date = myDate.getDate();       //获取当前日(1-31)  
 	    //myDate.getDay();        //获取当前星期X(0-6,0代表星期天)  
 	    //myDate.getTime();       //获取当前时间(从1970.1.1开始的毫秒数)  
 	    //myDate.getHours();      //获取当前小时数(0-23)  
 	    //myDate.getMinutes();    //获取当前分钟数(0-59)  
 	    //myDate.getSeconds();    //获取当前秒数(0-59)  
 	    //myDate.getMilliseconds();   //获取当前毫秒数(0-999)  
 	    //myDate.toLocaleDateString();    //获取当前日期  
 	    //var mytime=myDate.toLocaleTimeString();    //获取当前时间  
 	    //myDate.toLocaleString( );       //获取日期与时间  
	 	//if (mytime<"23:30:00")  
	 	//{  
	 	//alert(mytime);  
	 	//} 
 	    return year+"-"+month+"-"+date;
 	}
	 
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="时段基础数据" class="easyui-datagrid" fit="true"
			url="${path}/timeSegment/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'regcnt',width:100,align:'center'" >注册人数</th>
					<th data-options="field:'logincnt',width:100,align:'center'" >登录人数</th>
					<th data-options="field:'openactnum',width:100,align:'center'" >开户人数</th>
					<th data-options="field:'platformrechargepernum',width:100,align:'center'" >充值人数</th>
					<th data-options="field:'platformrechargeamount',width:100,align:'center'" >充值金额（万）	</th>
					<th data-options="field:'platformwithdrawpernumber',width:100,align:'center'" >提现人数</th>
					<th data-options="field:'platformwithdrawamount',width:100,align:'center'" >提现金额（万）	</th>
					<th data-options="field:'investamount',width:100,align:'center'" >投资金额（万）	</th>
					<th data-options="field:'investpernum',width:100,align:'center'" >投资人数</th>
					<th data-options="field:'investnum',width:100,align:'center'" >投资笔数</th>
					<th data-options="field:'avgInvestpernum',width:100,align:'center'" >人均投资金额（万）	</th>
					<th data-options="field:'avgInvestnum',width:100,align:'center'" >笔均投资额(万)	</th>
					<th data-options="field:'firstinvestpernum',width:100,align:'center'" >首次投资者</th>
					<th data-options="field:'firstinvestamount',width:100,align:'center'" >首次投资者投资金额</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/lendInfo/exportExcel" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					投资时间  :  
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" >
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime" ><!-- class="easyui-datebox easyui-datetimebox" 年月日 -->
					&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ()" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- <a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a> -->
				</form>
			</div>
		</div>

	</div>
</body>
</html>
