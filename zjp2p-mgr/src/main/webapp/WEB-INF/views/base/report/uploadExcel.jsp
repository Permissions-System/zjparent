<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>给出Excel表统计用户的开户数、投资数</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>

<!-- 对话框的样式 -->
<link href="${path}/css/userList.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	
</script>

</head>
<body>
	<h2>1.给出Excel表统计用户的开户数、投资数</h2>
	<h2>2.导出生成Excel("编号","手机号","用户名","是否开户","最后登录时间","总投资金额")</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="给出Excel表统计用户的开户数、投资数" style="width:400px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="ff" class="easyui-form"  action="" method="post" data-options="novalidate:true" enctype="multipart/form-data">
	    	<table cellpadding="5">
	    		<tr>
	    			<td >时间:</td>
	    			<td><input class="easyui-datebox" style="width:100px" name="beginTime" id="beginTime" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td >Excel文件:</td>
	    			<td><input  type="file" name="file" id="uploadFile" data-options="required:true" ></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">查询开户/投资数</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm2()">导出Excel</a>
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	    </div>
	    </div>
	</div>
	<script>
	
		//查询开户/投资数
		function submitForm(param){
			$("#ff").attr("action",path+'/uploadExcel/upload'); 
			$('#ff').form('submit',{
				onSubmit:function(){
					var isValid=true ;
					//isValid = $(this).form('enableValidation').form('validate');
					//判断开始时间 
					isValid = valiBeginTime();
					//判断是否有选择上传文件
		            isValid = valiUploadFile();
					if (isValid){ 
						//显示进度框 
			 		    showProcess(true);
					}
					return isValid; 
				},    
			    success:function(data){ 
			    	showProcess(false);
			    	alert(data)
			    }   
			});
		}
		//导出Excel
		function submitForm2(){
			var isValid=true ;
	 		$("#ff").attr("action",path+'/uploadExcel/export'); 
	 		//判断开始时间 
			isValid = valiBeginTime();
			//判断是否有选择上传文件
            isValid = valiUploadFile();
            if (isValid){ 
            	$("#ff").submit();
            	//showProcess(false);
			}
		}
		//重置
		function clearForm(){
			$('#ff').form('clear');
		}
		//进度条 
		function showProcess(isShow) 
		{
			   if (isShow==false) 
			   {
			   		$.messager.progress('close');
			   		return;
			   }else{
				   var win = $.messager.progress({
					   title:'请稍后', 
		 				msg:'页面加载中...',
		 				text:'',
		 				interval:600
				     });
			   }
		}
		
		function valiBeginTime(){
			var isValid=true ;
			var beginTime = $("input[name='beginTime']").val();
			if(beginTime==null || beginTime==''){
				alert("请选择开始时间 ！");
				 isValid=false;
	 		}
			return isValid;
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
		
	</script>
	
	
</body>
</html>
