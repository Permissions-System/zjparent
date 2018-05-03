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
    	 
	  $.messager.alert('警告！','不能小于开始时间'); 
		  $("#endTime").datebox("setValue","");  
		  return;
	}
    }
});

});

function importzjgt(){
	
	var win = $.messager.progress({
		title:'请等待……',
		msg:'加载中...'
		});
	
	$('#importdata').form('submit',{
		onSubmit:function(){	
			return $(this).form('enableValidation').form('validate');
		},
		success:function(res){
		
	var url="${path}/checkDataImport/deal";
	
	url+="?inCustNo=daoruYW"+"&beginTime="+$("input[name='beginTime']").val()+"&endTime="+$("input[name='endTime']").val();

	 $.ajax({
	        url:url ,
	        async: false,
	        success: function (data) {
	        	  $.messager.progress('close');
	        	  $.messager.alert('业务数据','导入成功');  
	        },
	        error: function (m) {
	            $.messager.progress('close');
	            $.messager.alert('warning',m.responseText);  
	        }
	    });
		}
		});
}


function  importFy(){
	var win = $.messager.progress({
		title:'请等待……',
		msg:'加载中...'
		});
	
	$('#importdata').form('submit',{
		onSubmit:function(){	
			return $(this).form('enableValidation').form('validate');
		},
		success:function(res){
			
			var url="${path}/checkDataImport/dealFy";
			
			url+="?inCustNo=daoruFY"+"&beginTime="+$("input[name='beginTime']").val()+"&endTime="+$("input[name='endTime']").val();
			
			 $.ajax({
			        url:url ,
			        async: false,
			        success: function (data) {
			        	  $.messager.progress('close');
			        	  $.messager.alert('富友数据','导入成功');  
			        },
			        error: function (m) {
			            $.messager.progress('close');
			            $.messager.alert('warning',m.responseText);  
			        }
			    });
			
		}
});
	

}

</script>
</head>

<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<form id="importdata" class="easyui-form" style="height:35px;margin-top: 5px" method="post" data-options="novalidate:true" >
			<table>
		    <tr>
				<td>&nbsp;开始时间：<input id="startTime" name="beginTime"  editable="false" missingMessage="开始时间必填"  data-options="required:true"  class="easyui-datebox" ></input></td>
				<td>&nbsp;结束时间：<input id="endTime" name="endTime"  editable="false" missingMessage="结束时间必填"  data-options="required:true"  class="easyui-datebox" ></input></td>
				<td><a href="javascript:void(0)" id="fy" class="easyui-linkbutton" iconCls="icon-import"  onclick="importFy()">富友数据导入</a></td>
				<td><a href="javascript:void(0)" id="zjgt" class="easyui-linkbutton" iconCls="icon-import"  onclick="importzjgt()">中金数据导入</a></td>
		    </tr>
			</table>	
		</form>
	</div>

</body>
</html>