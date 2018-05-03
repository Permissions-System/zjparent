<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录属性详情</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
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
	var falg = true;
	var beginTime = $("input[name='beginTime']").val();
	var endTime = $("input[name='endTime']").val();
	if(beginTime==null || beginTime=='' ){
		alert("请选择开始时间 ");
		falg=false;
	}
	if(endTime==null || endTime=='' ){
		alert("请选择结束时间  ");
		falg=false;
	}
	if(falg==true){
		$('#datagrid').datagrid('reload',{
	 		beginTime: beginTime,
	 		endTime: endTime
		});
	}
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
    year = myDate.getFullYear();   //获取完整的年份(4位,1970-????)  
    month = myDate.getMonth()+1;      //获取当前月份(0-11,0代表1月)  
    date = myDate.getDate();       //获取当前日(1-31)  
    return year+"-"+month+"-"+date;
}

	/**
	 * 格式化 是否开户 字段 
	 *
	 * @param num 数值(Number或者String)
	 * @return 字符串,如0未开户,1已开户
	 * @type String
	 */
	function formatHasfuiou(hasfuiou) 
	{
		var result;
		if(hasfuiou==0)
		{
			result="未开户";
		}
		else if(hasfuiou==1)
		{
			result="已开户";
		}
		else
		{
			result="未知";
		}
		return result;
	}
	
	/**
	 * 格式化 是否开户 字段 
	 *
	 * @param num 数值(Number或者String)
	 * @return 字符串,如0未开户,1已开户
	 * @type String
	 */
	function formatCommon(param) 
	{
		var result;
		if(param==0)
		{
			result="没有";
		}
		else if(param>0)
		{
			result="有";
		}
		else
		{
			result="未知";
		}
		return result;
	}
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="用户登录属性详情" class="easyui-datagrid" fit="true"
			url="${path}/userAttrDedatil/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<!-- <th data-options="field:'id',width:100,align:'center'" >序号</th> -->
					<th data-options="field:'userId',width:100,align:'center'" >用户ID</th>
					<th data-options="field:'userName',width:100,align:'center'">用户注册名</th>
					<th data-options="field:'loginDate',width:120,align:'center'" >登录时间</th>
					<th data-options="field:'registerDate',width:120,align:'center'" >注册时间</th>
					<th data-options="field:'logintime',width:100,align:'center'" >注册至今登录次数</th>
					<th data-options="field:'notOpenAct',width:100,align:'center',formatter:formatHasfuiou" >是否已经开户</th>
					<th data-options="field:'notRechargePeople',width:100,align:'center',formatter:formatCommon">是否有过成功充值</th>
					<th data-options="field:'notInvestmentPeople',width:100,align:'center',formatter:formatCommon" >是否有过成功投资</th>
					<th data-options="field:'notTheTransfer',width:100,align:'center',formatter:formatCommon">是否有过成功转让</th>
					<th data-options="field:'notPlatformWithdrawPer',width:100,align:'center',formatter:formatCommon" >是否有过成功提取</th>
					<th data-options="field:'notExperience',width:100,align:'center',formatter:formatCommon" >是否投过体验标</th>
					<th data-options="field:'notZJB',width:100,align:'center',formatter:formatCommon" >是否领取过中金币</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="paramForm" action="${path}/userAttrDedatil/exportExcel" method="get">
					&nbsp;&nbsp;&nbsp;&nbsp;
					选择日期: 
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime">
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">统计</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a>
				</form>
			</div>
		</div>

	</div>
</body>
</html>
