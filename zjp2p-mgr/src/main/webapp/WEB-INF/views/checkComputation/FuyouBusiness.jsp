<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript">

var isCheck=false;

var isCheck11=false;

	function getNum(str)
	{
		if(str<10)
		{
		return "0"+str;
		}else{
			return str;
		}
	}
$(function(){  

	
	$('#startTime').datebox({
	    onSelect: function(date){
	    	
	    	var time=date.getFullYear()+""+(date.getMonth()+1)+""+getNum(date.getDate());
	        if(time<20151111)
        	{   
	        	isCheck11=true;
        	}else{
        		isCheck11=false;
        	}
	    }
	});

	$('#endTime').datebox({
	    onSelect: function(date){
	    var time=date.getFullYear()+""+(date.getMonth()+1)+""+getNum(date.getDate());
		var start=$('#startTime').datebox('getValue');
		if(start=="")
   		{
    		$.messager.alert('警告！','必须先选择开始时间'); 
    		  $("#endTime").datebox("setValue",""); 
    		  return;
   		}
		start=start.split("-").join('');
	    if(time<start)
    	{
	    	debugger;
    	  $.messager.alert('警告！','不能小于开始时间'); 
 		  $("#endTime").datebox("setValue","");  
 		  return;
    	}
    	if(isCheck11)
    		{
    		  if(time>20151111)
    			  {
	    			  $.messager.alert('警告！','当前只能选择2015-11-11前的数据');  
	    			  $("#endTime").datebox("setValue","");  
	    			  return;
    			  }
	    	}
    

    	
	    }
	});

	//设置时间  
	/* var curr_time = new Date();     
	$("#startTime").datebox("setValue",formaBeginDate(curr_time));  
	$("#endTime").datebox("setValue",formaEndDate(curr_time));   */
});  

/* //开始日期
function formaBeginDate(date){  
	var y = date.getFullYear();  
	var m = date.getMonth()+1;  
 	var d = date.getDate()-1;  
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
}  

//结束日期
function formaEndDate(date){  
	var y = date.getFullYear();  
	var m = date.getMonth()+1;  
	var d = date.getDate()-1;  
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
}  */ 



$(document).ready(function(){
	

   $('#datagrid').datagrid("options").view.onBeforeRender = function (target, rows) {  
	   //web展示总额
	   var result="";
	   //核对成功总额
	   var succedAmount=0;
	   var succedCount=0;
	   //核对失败总额
	   var faildAmount=0;
	   var faildCount=0;
	   //核对异常总额
	   var abnormalAmount=0;
	   var abnormalCount=0;
	   //数据总数
	   var pageCount=0;
	   isCheck=false;
	   $.each(rows, function (index, row) {
		isCheck=true;
		   pageCount++;
		 if(row.checkflag=="成功")
		 {
			 succedCount++;
			 succedAmount+=parseInt(row.txnAmt);
		 }
		 if(row.checkflag=="失败")
		 {
			 faildCount++;
			 faildAmount+=parseInt(row.txnAmt)
		 }
		 if(row.checkflag=="异常")
		 {
			 abnormalCount++;
			 abnormalAmount+=parseInt(row.txnAmt)
		 }

		  /*  if(row.fySun!="" && row.fySun!=null)
		   {
		   result+="富友总金额为："+formatThousandsNumber(row.fySun,2,1)+";&nbsp;&nbsp;";
		   }
		   if(row.ywSum!="" && row.ywSum!=null)
		   {
		   result+="  业务总金额为："+formatThousandsNumber(row.ywSum,2,1)+";&nbsp;&nbsp;";
		   } */
	    }); 
	   
	   result+="核对失败："+faildCount+"笔,失败总金额："+formatThousandsNumber(faildAmount,2,1)+";&nbsp;&nbsp;核对异常："+abnormalCount+"笔,异常总金额："+formatThousandsNumber(abnormalAmount,2,1)+"";
	   
	    $("#showCount").html("数据总数："+pageCount+"条;&nbsp;&nbsp;"+result);
	};
}); 



function exportExcel(){
	  if(isCheck){
		  var flag = $("input[name='businessType']").val();
		  var action="";
		  if(flag=='1' || flag=='2' ){
			  action="${path}/checkExport/export_zj2";
		  }else{
		  	  action="${path}/checkExport/exportExcel";
		  }
		  alert(action);
	      $("#searchdata").attr("action",action);
	  	  $("#searchdata").submit();
		}else{
			  $.messager.alert('警告！','无数据');  
		}
}



function submitForm(){
	$("#searchdata").attr("action","");
	$('#searchdata').form('submit',{
			onSubmit:function(){	
				return $(this).form('enableValidation').form('validate');
			},
			success:function(res){
				isCheck=false;
				
				$('#datagrid').datagrid('reload',{
					businessType:$("input[name='businessType']").val(),	
					beginTime: $("input[name='beginTime']").val(),
					endTime: $("input[name='endTime']").val(),
					isCheck11:isCheck11
				}); 
				
		/* 		$('#datagrid').datagrid({
					rowStyler:function(index,row){
					
						 if(row.checkflag=="成功")
						{
						return 'color:#48D83F;';
						}
						 
						if(row.checkflag=="失败")
						{
							return 'color:red;';
						}
						
						if(row.checkflag=="异常")
						{
							return 'color:#F1C40F';
						}
						
					}
				}); */
				
    		}
	});
}

</script>
</head>
<body class="easyui-layout" >
<div region="center" border="false" style="overflow: hidden;">

		<!-- 用户信息列表 toolbar="#toolbar" -->
			<table id="datagrid" title="充值、提现核算结果展示" class="easyui-datagrid" fit="true"
			url="${path}/getBusinessGridData/getFuyouBusiness"   toolbar="#tb"
			fitColumns="true" singleSelect="true" rownumbers="true"
			border="false" nowrap="false">
			<thead>
				<tr>
					<th data-options="field:'username',width:100" >用户名</th>
				<!-- 	<th data-options="field:'regdate',width:100,formatter:CEdit">注册时间</th>
					<th data-options="field:'lenddate',width:100,formatter:CEdit" >投资时间</th>
					<th data-options="field:'lendmoney',width:100,formatter:formatCurrency">投资金额</th> -->
					
				<!-- 	<th data-options="field:'servType',width:100" >业务类型</th> -->
					<th data-options="field:'busiTp',width:50" >核算类型</th>
				<!--<th data-options="field:'extTp',width:100" >扩展类型</th> -->
				<!-- 	<th data-options="field:'mchntSsn',width:150" >流水号</th> -->
					<th data-options="field:'txnDate',width:100,align:'right',formatter:YMDData" >交易日期</th>
					<th data-options="field:'txnTime',width:100,align:'right',formatter:SFMData" >交易时分</th>
					<th data-options="field:'txnAmt',width:100,align:'right',formatter:ThousandsNumber" >交易金额</th>
				<!-- 	<th data-options="field:'txnAmtSuc',width:100,align:'right',formatter:ThousandsNumber" >成功交易金额</th> -->
					<!-- <th data-options="field:'contractNo',width:100" >合同号</th> 
					 <th data-options="field:'outFuiouAcctNo',width:100" >出账用户虚拟账户</th>
					 <th data-options="field:'outCustNo',width:100" >出账用户名</th>
					<th data-options="field:'outArtifNm',width:100" >出账用户名称</th>
					<th data-options="field:'inFuiouAcctNo',width:100" >入账用户虚拟账户</th>
					<th data-options="field:'inCustNo',width:100" >入账用户名</th>
					<th data-options="field:'inArtifNm',width:100" >入账用户名称</th> -->
					<!-- <th data-options="field:'txnRspCd',width:100" >交易返回码</th>
					<th data-options="field:'rspCdDesc',width:100" >交易返回码描述</th> -->
					<th data-options="field:'sourCode',width:100" >数据来源</th>
					<th  sortable="true" data-options="field:'checkflag',width:60,formatter:GetColor">核算结果</th>
					<th data-options="field:'checkdesp',width:200" >核算结果描述</th>
					<th data-options="field:'remark',width:100" >备注</th>
				</tr>
			</thead>
		</table>

		<div id="tb" style="padding:5px;height:120px">
			<form id="searchdata" class="easyui-form" style="height:35px;margin-top: 5px" method="get" data-options="novalidate:true">
				<div style="width:100%;">
					<fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
			 			<legend>核算</legend>
							<table>
							    <tr>
							    <td>
							   核算类型：<input id="businessType"  name="businessType"  editable="false" missingMessage="核算类型必填" class="easyui-combobox"  data-options="valueField:'key',textField:'value',required:true,url:'${path}/getBusiness/businessData'">
							    </td>
								<td>&nbsp;开始时间：<input id="startTime" name="beginTime"  editable="false" missingMessage="开始时间必填"   data-options="required:true"  class="easyui-datebox" ></input></td>
								<td>&nbsp;结束时间：<input id="endTime" name="endTime"      editable="false" missingMessage="结束时间必填"  data-options="required:true"  class="easyui-datebox" ></input></td>
								<td>&nbsp;<a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search"  onclick="submitForm()">核 算</a></td>
							 <!--     <td><a href="javascript:void(0)" id="excel" name="excel" class="easyui-linkbutton" iconCls="icon-export"  onclick="exportExcel()">导出Excel</a></td> -->
							    </tr>
							</table>	
					</fieldset>
					
	<fieldset style="border: #dddddd solid 1px;border-radius: 5px;margin-top: 5px;">
	<legend>核算统计</legend>
	<table>
	<tr>
<!-- 	<td><span id="showCount">统计结果为：2015-10-01至2015-10-15业务总额为：180000;富友总额为：170000;相差100000;异常数据100条</span></td> -->
	<td><span id="showCount"><font style="color:red">点击核算后会自动统计核算失败、核算异常的总数和总金额</font></span></td>
	</tr>
	</table>
	</fieldset>
				</div>
		
		</div>
</div>

</body>
</html>