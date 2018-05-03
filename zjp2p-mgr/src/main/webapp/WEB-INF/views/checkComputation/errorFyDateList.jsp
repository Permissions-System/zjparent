<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>富友错误数据查询</title>

<script type="text/javascript">
	var pageCount=0;
	var resultAmount=0;
	var isCheck=false;


		//开始日期
		function formaBeginDate(date){  
			var y = date.getFullYear();  
			var m = date.getMonth()+1;  
		 	var d = 01;  
		    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
		}  
		
		//结束日期
		function formaEndDate(date){  
			var y = date.getFullYear();  
			var m = date.getMonth()+1;  
			var d = date.getDate();
		    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);  
		}  

		function submitForm(){

			$("#searchdata").attr("action",""); 
			
			$('#searchdata').form('submit',{
					onSubmit:function(){	
						return $(this).form('enableValidation').form('validate');
					},
					success:function(res){
						isCheck=false;
					Loading();
				  	/*  $(datagrid).datagrid('load',"${path}/CheckSearchDate/datagrid"); */
				 	
					 $('#datagrid').datagrid('reload',{
						 isCheck:'true',
						busiTp:$("#busiTp").combobox('getValue'),
						username:$("input[name='username']").val(),
						beginTime: $("input[name='beginTime']").val(),
						endTime: $("input[name='endTime']").val()
					}); 
				  	closeLoading();
		    		}
				});
		}
		
		
        $(document).ready(function(){
    	 	//初始化日期
   			var curr_time = new Date();     
   			$("#startTime").datebox("setValue",formaBeginDate(curr_time));  
   			$("#endTime").datebox("setValue",formaEndDate(curr_time));  
   	

    	   $('#datagrid').datagrid("options").view.onBeforeRender = function (target, rows) {  
    		    resultAmount=0;
    		    pageCount=0;
    		    isCheck=false;
    		    $.each(rows, function (index, row) {  
    		    	isCheck=true;
    		    	pageCount++;
    		    	if(row.txnRspCd=='0000')
    		    	{
    		    	resultAmount+=row.txnAmt;
    	   			}
    		    }); 
    		    
    		    $('#datagrid').datagrid('insertRow',{
        			index: pageCount,	// 索引从0开始
        			row: {
        				username: '金额总计',
        				busiTp: '',
        				txnDate: null,
        				txnTime:null,
        				txnAmt:resultAmount,
        				sourCode:'',
        				checkflag:'',
        				checkdesp:'',
        				remark:''
        			}
        		});
    		};
  
    		
    		
		}); 


      function exportExcel(){
    
   	  if(isCheck)
   		  {
   	
	    	var action="${path}/checkExport/export";
	    	
	    	$("#searchdata").attr("action",action);
	    	
	  		$("#searchdata").submit();
	  		
	  		
   		  }else{
   			  $.messager.alert('警告！','无数据');  
   		  }
      }
      
</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">




		<!-- 用户信息列表 toolbar="#toolbar" -->
		<table id="datagrid" title="富友数据查询" class="easyui-datagrid"   fit="true"
			url="${path}/CheckSearchDate/errordatagrid"    
			fitColumns="true" singleSelect="true" rownumbers="true"   toolbar="#tb"
			border="false" nowrap="false" > 
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
					<th data-options="field:'txnDate',width:60,align:'right',formatter:YMDData" >交易日期</th>
					<th data-options="field:'txnTime',width:60,align:'right',formatter:SFMData" >交易时分</th>
					<th data-options="field:'txnAmt',width:80,align:'right',formatter:ThousandsNumber" >交易金额</th>
				<!-- 	<th data-options="field:'txnAmtSuc',width:100,align:'right',formatter:ThousandsNumber" >成功交易金额</th> -->
					<!-- <th data-options="field:'contractNo',width:100" >合同号</th> 
					 <th data-options="field:'outFuiouAcctNo',width:100" >出账用户虚拟账户</th>
					 <th data-options="field:'outCustNo',width:100" >出账用户名</th>
					<th data-options="field:'outArtifNm',width:100" >出账用户名称</th>
					<th data-options="field:'inFuiouAcctNo',width:100" >入账用户虚拟账户</th>
					<th data-options="field:'inCustNo',width:100" >入账用户名</th>
					<th data-options="field:'inArtifNm',width:100" >入账用户名称</th> -->
					<th data-options="field:'sourCode',width:50" >数据来源</th>
					 <th data-options="field:'txnRspCd',width:60" >交易返回码</th>
					<th data-options="field:'rspCdDesc',width:150" >交易返回码描述</th>
					<th  sortable="true" data-options="field:'checkflag',width:50,formatter:GetColor" >核对结果</th>
					<th data-options="field:'checkdesp',width:250" >核对结果描述</th>
					<th data-options="field:'remark',width:250" >备注</th>
				</tr>
			</thead>
		</table>


	<div id="tb" style="padding:5px;height:70px">
	<fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
 	<legend>富友数据查询</legend>
	<form id="searchdata" class="easyui-form"  style="height:35px;margin-top: 5px" method="get" data-options="novalidate:true">
	<table>
    <tr>
    <td>用户名：<input id="username" name="username" missingMessage="用户名必填" class="easyui-textbox"  ></input></td>
    <td>数据类型：<input id="busiTp" name="busiTp" editable="false" class="easyui-combobox" name="dept" data-options="valueField:'key',textField:'value',url:'${path}/getCombox/boxData',required:true"></td>

	<td>开始时间：<input id="startTime" name="beginTime" editable="false" missingMessage="开始时间必填"  data-options="required:true" class="easyui-datebox" ></input></td>
	<td>结束时间：<input id="endTime" name="endTime"  editable="false" missingMessage="结束时间必填"  data-options="required:true" class="easyui-datebox" ></input></td>
	<td><a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search"  onclick="submitForm()">查 询</a></td>
	<!-- <td><a href="javascript:void(0)" id="export"  class="easyui-linkbutton" iconCls="icon-export"  onclick="exportExcel()">导 出Excel</a></td> -->
    </tr>
	</table>	
	</fieldset>
	
	
	
	<!-- <fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
 	<legend>核对结果</legend>
 	<div id="pn1" class="easyui-panel" 
    style="width:100%;height:235px;overflow: auto;border: #dddddd solid 1px;padding:10px;background:#fafafa;"
    data-options="collapsible:true">
	</div>
 	</fieldset> -->
	</form>
	</div>


			</div>

	
		</div>
		

	</div>
	
	
	

</body>
</html>
