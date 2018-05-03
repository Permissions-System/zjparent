<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>考勤数据查询</title>

<script type="text/javascript">

	var isCheck=false;
	var overtimeNum=0;
	var pageCount=0;

	
	
	
    
    $(document).ready(function(){
	 	
	   $('#checkdatagrid').datagrid("options").view.onBeforeRender = function (target, rows) {  
		   	overtimeNum=0;
		
		    $.each(rows, function (index, row) {  
		
		    	overtimeNum+=parseInt(row.overtimesecond);
		    	pageCount++;
		    }); 
		    var time=convertSFM(overtimeNum);
		    $('#checkdatagrid').datagrid('insertRow',{
    			index: pageCount,	// 索引从0开始
    			row: {
    				department: '加班总计',
    				username: '',
    				starttime:'',
    				endtime:'',
    				overtime:time,
    				overtimesecond:overtimeNum
    			}
    		});
		};
	}); 

	
    function convertSFM(value) {
        var theTime = parseInt(value);// 秒
        var theTime1 = 0;// 分
        var theTime2 = 0;// 小时
        // alert(theTime);
        if(theTime > 60) {
        theTime1 = parseInt(theTime/60);
        theTime = parseInt(theTime%60);
        // alert(theTime1+"-"+theTime);
        if(theTime1 > 60) {
        theTime2 = parseInt(theTime1/60);
        theTime1 = parseInt(theTime1%60);
        }
        }
        var result = ""+parseInt(theTime);
        if(theTime1 > 0) {
        result = ""+parseInt(theTime1)+":"+result;
        }
        if(theTime2 > 0) {
        result = ""+parseInt(theTime2)+":"+result;
        }
        return result;
        }
   
	

		function submitForm(){

			$("#searchdata").attr("action",""); 
			
			$('#searchdata').form('submit',{
					onSubmit:function(){	
						return $(this).form('enableValidation').form('validate');
					},
					success:function(res){

					isCheck=true;
					Loading();

					 $('#checkdatagrid').datagrid('reload',{
						 isCheck:'true',
					/* 	status:$("#status").combobox('getValue'), */
						starttime:$("input[name='starttimeY']").val(),
						username: $("input[name='usernameY']").val(),
						department: $("input[name='departmentY']").val(),
						endtime:$("input[name='endtimeY']").val()
						
					}); 
				  	closeLoading();
		    		}
				});
		}
		
		
		function exportExcel(){
		    
		   	  if(isCheck)
		   		  {
		   	
			    	var action="${path}/checkExport/cardresultexport";
			    	
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
	
	
		<!-- 考勤信息列表 toolbar="#toolbar" -->
		<table id="checkdatagrid" title="加班时间查询" class="easyui-datagrid"   fit="true"
			url="${path}/cardCheck/checkOverTimeData"    
			fitColumns="true" singleSelect="true" rownumbers="true"   toolbar="#tb"
			border="false" nowrap="false" > 
			<thead>
				<tr>
					<th data-options="field:'department',width:200" >部门</th>
				
					<th data-options="field:'username',width:100" >姓名</th>
				
					<th data-options="field:'starttime',width:100,align:'right'" >上班时间</th>
					<th data-options="field:'endtime',width:100,align:'right'" >下班时间</th>
					<th data-options="field:'overtime',width:100,align:'right'" >加班时间</th>
					<th data-options="field:'hour',width:100,align:'right'" >加班小时</th>
					<th data-options="field:'mealpay',width:100,align:'right'" >餐补(元)</th>
					<th data-options="field:'trafficpay',width:100,align:'right'" >交通补贴(元)</th>
					<th data-options="field:'week',width:100,align:'left'" >星期</th>
					<th hidden="true" data-options="field:'overtimesecond',width:50,align:'right'" >加班时间(秒)</th>
				</tr>
			</thead>      
		</table>


	<div id="tb" style="padding:5px;height:100px">
	<fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
 	<legend>加班数据查询</legend>
	<form id="searchdata" class="easyui-form"  style="height:35px;margin-top: 5px" method="get" data-options="novalidate:true">
	<table>
    <tr>
    <td>部门：<input id="departmentY" name="departmentY" class="easyui-textbox"  ></input></td>
    
    <td>用户名：<input id="usernameY" name="usernameY" class="easyui-textbox"  ></input></td>
   
    <td>开始时间：<input id="starttimeY" name="starttimeY" editable="false" missingMessage="开始时间必填"  data-options="required:true" class="easyui-datebox" ></input></td>
   
    <td>结束时间：<input id="endtimeY" name="endtimeY" editable="false" missingMessage="结束时间必填"  data-options="required:true" class="easyui-datebox" ></input></td>

	<td><a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search"  onclick="submitForm()">统 计</a></td>
	
	<td><a href="javascript:void(0)" id="export"  class="easyui-linkbutton" iconCls="icon-export"  onclick="exportExcel()">导 出Excel</a></td>
    </tr>
	</table>	
	</form>

	</fieldset>
	</div>


</div>

</body>
</html>
