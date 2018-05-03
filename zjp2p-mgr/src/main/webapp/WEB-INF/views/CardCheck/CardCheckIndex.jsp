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

/* 	function getNum(str)
	{
		if(str<10)
		{
		return "0"+str;
		}else{
			return str;
		}
	}
	
	
	 $(function(){  
	    	$('#starttimeY').datebox({
	    	    onSelect: function(date){
	    	    var time=date.getFullYear()+""+(date.getMonth()+1)+""+getNum(date.getDate());
	    	    if(time<'20151201')
	    		{
	    		  $.messager.alert('警告！','只能选择大于11月30日之前的日期'); 
	    			  $("#starttimeY").datebox("setValue","");  
	    			  return;
	    		}
	    	    }
	    	});

	    }); */
	
    $(document).ready(function(){
	
    	
    	$('#checkdatagrid').datagrid({   
    		rowStyler:function(index,row){   
		        if (row.status=="异常"){   
		            return 'color:red;';   
		        }   
		    }   
    	});
	  
	}); 

	
    
   
    
	
	 
	

		function submitForm(){

			$("#searchdata").attr("action",""); 
			
			$('#searchdata').form('submit',{
					onSubmit:function(){	
						return $(this).form('enableValidation').form('validate');
					},
					success:function(res){
						isCheck=false;
					
						var shangban=$("#shangbantime").combobox('getValue');
						var xiaban=$("#xiabantime").combobox('getValue');
						if(shangban=="请选择" || xiaban=="请选择")
						{
						  $.messager.alert('警告！','请选择上下班时间'); 
		    			  return;
						}else{
							Loading();
							 $('#checkdatagrid').datagrid('reload',{
								 isCheck:'true',
							/* 	status:$("#status").combobox('getValue'), */
								starttime:$("input[name='starttimeY']").val(),
								username: $("input[name='usernameY']").val(),
								department: $("input[name='departmentY']").val(),
								shangban:shangban,
								xiaban:xiaban
							}); 
						  	closeLoading();
						}
					
		    		}
				});
		}

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
      
      
      function valiUploadFile(){
			var isValid=true ;
			 var uploadFile = $("#uploadFile").val();
	            if (uploadFile == "") {
	                alert("请选择上传文件！");
	                isValid=false;
	            }else{
	            	//判断上传文件的后缀名  
		            var strExtension = uploadFile.substring(uploadFile.lastIndexOf('.') + 1);
		            if ( strExtension!='xls' && strExtension!='xlsx' ) {
		            	alert("请选择xls、xlsx文档文件 ");
		            	isValid=false;
		            }
	            }
	            
	            return isValid;
		}
      
      
    //导出Excel
		function submitForm2(){
			var isValid=true ;
	 		$("#ff").attr("action","${path}/uploadExcel/exelImport"); 

			//判断是否有选择上传文件
          isValid = valiUploadFile();
          if (isValid){ 
        	  
        	  var win = $.messager.progress({
        			title:'Please waiting',
        			msg:'Loading data...'
        			});
        	 /*  var filed=$("#uploadFile").val();
        	  var arry=filed.replace(/\\/g, '/').split('/');
        	  var result=arry[arry.length-1];
        	  var url="${path}/uploadExcel/exelImport";
        		
        	  url+="?file="+result;

        	   	 $.ajax({
        		        url:url ,
        		        async: false,
        		        success: function (data) {
        		        
        		        	  closeLoading();
        		        	  $.messager.alert('业务数据','导入成功');  
        		        },
        		        error: function (m) {
        		        	debugger;
        		            closeLoading();
        		            $.messager.alert('warning',m.responseText);  
        		        }
        		    }); */
        			$("#ff").submit();
        		    
        		    
        		    setTimeout(close, 5000);
        		    
        			
         
			}
		}
    
    function close()
    {
    	$.messager.progress('close');
    }
    
      
</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
	
	
		<!-- 考勤户信息列表 toolbar="#toolbar" -->
		<table id="checkdatagrid" title="考勤数据查询" class="easyui-datagrid"   fit="true"
			url="${path}/CardCheck/CardCheckData"    
			fitColumns="true" singleSelect="true" rownumbers="true"   toolbar="#tb"
			border="false" nowrap="false" > 
			<thead>
				<tr>
					<th data-options="field:'department',width:200" >部门</th>
				
					<th data-options="field:'username',width:50" >姓名</th>
				
					<th data-options="field:'starttime',width:150,align:'right'" >上班时间</th>
					<th data-options="field:'endtime',width:150,align:'right'" >下班时间</th>
					<th sortable="true" data-options="field:'status',width:50,align:'left'" >状态</th>
				</tr>
			</thead>      
		</table>


	<div id="tb" style="padding:5px;height:100px">
	<fieldset style="border: #dddddd solid 1px;border-radius: 5px;">
 	<legend>考勤数据查询</legend>
	<form id="searchdata" class="easyui-form"  style="height:35px;margin-top: 5px" method="post" data-options="novalidate:true">
	<table>
    <tr>
      <td>部门：<input id="departmentY" name="departmentY" class="easyui-textbox"  ></input></td>
    <td>用户名：<input id="usernameY" name="usernameY" class="easyui-textbox"  ></input></td>
    <%-- <td>数据类型：<input id="status" name="status" editable="false" class="easyui-combobox" name="dept" data-options="valueField:'key',textField:'value',url:'${path}/getCombox/boxData',required:true"></td> --%>
	
	 <td>上班时间：<input id="shangbantime" value="请选择" name="shangbantime" editable="false" class="easyui-combobox" style="width:100px"  data-options="valueField:'key',textField:'value',url:'${path}/CardCheck/getshangbanList',required:true"></td>
	
	 <td>下班时间：<input id="xiabantime"  value="请选择"  name="xiabantime"  editable="false" class="easyui-combobox"  data-options="valueField:'key',textField:'value',required:true,url:'${path}/CardCheck/getxiabanList'" style="width:100px"></td>
	
	
	
	<td>抽查时间：<input id="starttimeY" name="starttimeY" editable="false" missingMessage="开始时间必填"  data-options="required:true" class="easyui-datebox" ></input></td>
	<!-- <td>结束时间：<input id="endtimeY" name="endtimeY"  editable="false" missingMessage="结束时间必填"  data-options="required:true" class="easyui-datebox" ></input></td> -->
	<td><a href="javascript:void(0)" id="search" class="easyui-linkbutton" iconCls="icon-search"  onclick="submitForm()">查 询</a></td>
	<!-- <td><a href="javascript:void(0)" id="export"  class="easyui-linkbutton" iconCls="icon-export"  onclick="exportExcel()">导 出Excel</a></td> -->

	
    </tr>
	</table>	
	</form>
	
	 <form id="ff" class="easyui-form"  action="" method="post" data-options="novalidate:true" enctype="multipart/form-data">
	<table>
	<tr>
	<td>Excel文件：<input  type="file" name="file" id="uploadFile" data-options="required:true" ></input></td>
	  <td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm2()">导入Excel</a></td>
	</tr>
	</table>
	
	</form>
	</fieldset>
	</div>


</div>

</body>
</html>
