<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录属性统计</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

//初始化输入日期框
$(function(){
		var today = getYmd();
	　　 $('#beginTime').datebox('setValue', today);	
	　     $('#endTime').datebox('setValue', today);	
	　     
	　     /* $('#datagrid').datagrid({  
	　        	fitColumns: true,  
	         url: path+'/userAttr/datagrid',  
	         pagination: true,  
	         pageSize: 3,   
	         onLoadSuccess: function (data) {  
	             if (data.total == 0) {  
	                 //添加一个新数据行，第一列的值为你需要的提示信息，然后将其他列合并到第一列来，注意修改colspan参数为你columns配置的总列数  
	                 $(this).datagrid('appendRow', { itemid: '<div style="text-align:center;color:red">没有相关记录！</div>' }).datagrid('mergeCells', { index: 0, field: 'itemid', colspan: 4 })  
	                 //隐藏分页导航条，这个需要熟悉datagrid的html结构，直接用jquery操作DOM对象，easyui datagrid没有提供相关方法隐藏导航条  
	                 $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').hide();  
	             }  
	             //如果通过调用reload方法重新加载数据有数据时显示出分页导航容器  
	             else $(this).closest('div.datagrid-wrap').find('div.datagrid-pager').show();  
	         },  
	         title: 'easyui datagrid没有数据显示无数据提示信息',  
	         width: 550
	     });   */
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
	//$("#paramForm").submit();
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
</script>

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="用户登录属性统计" class="easyui-datagrid" fit="true"
			url="${path}/userAttr/datagrid"  pagination="false" toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th field="logincnt" width="100" align="center">登录人数</th>
					<th data-options="field:'openNumber',width:100,align:'center'">开户人数</th>
					<th field="rechargePeopleNumber" width="100" align="center">成功充值人数</th>
					<th field="investmentPeopleNumber" width="100" align="center">成功投资人数</th>
					<th field="theTransferNumber" width="100" align="center">成功转让人数</th>
					<th field="platformWithdrawPerNumber" width="100" align="center">成功提现人数</th>
					<th data-options="field:'experienceNumber',width:100,align:'center'">投过体验标人数</th>
					<th field="zjbNumber" width="100" align="center">领过中金币人数</th>
				</tr>
			</thead>
		</table>

		<!-- 按钮 -->
		<div id="tb" style="padding:5px;height:auto">
			<div>
				<form id="form_search" action="" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;
					选择日期: 
					<input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime">
					-
					<input class="easyui-datebox" style="width:100px" name="endTime" id="endTime">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="javascript:searchUserQ();" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">统计</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- <a href="javascript:redirectURL();" class="easyui-linkbutton" >导出Excel</a> -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>
