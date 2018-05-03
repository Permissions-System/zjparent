<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>数据抓取</title>
<%@include file="/WEB-INF/views/base/include/easyui.jsp"%>
<script type="text/javascript">
	/**
	 * cps-cpa渠道数据分析 type=1 初始、11增量
	 * 每日数据列表 type=2 初始、22增量
	 * 投资管理报表 type=3 初始、33增量
	 * 用户基本信息 type=4 初始、44增量
	 * 实时数据统计 type=5 初始、55增量
	 */
	function getDate(url,type)
	{
		$.messager.confirm('数据导入', '您确定要执行该操作吗?', function(r){
				if (r)
				{
					//显示进度框 
					showProcess(true);
					
			        //如果是true ，那么就把页面转向thcjp.cnblogs.com
					 $.post(path+url,{type:type},function(result){
							if (result.success){
								//mesTitle = '导入成功';
								showProcess(false);
							    $.messager.alert('通知消息',result.msg,'info');
							} else {
								//mesTitle = 'error';
								showProcess(false);
								$.messager.alert('数据导入失败 ');
							} 						
							/* $.messager.show({ 
								 title: mesTitle,
								 msg: result.msg
							}); */
						},'json');
				}
			});
	}
	
	
	function redirectURL()
	{
		var flg = false;
		var year = $("input[name='year']").val();
 		var month = $("input[name='month']").val();
		if(year==null || year=="")
 		{
 			alert("请输入年份 ");
 			flg=false;
 		}else if(month==null || month=="")
 		{
 			alert("请输入月份");
 			 flg=false;
 		}else{
 			flg=true;
 		}
 		
 		if(flg==true)
 		{
 			$("#paramForm").submit();
 		}  
	}
	
	function getDailyData(url,type,isAllOrDaily)
	{
		var flg = false;
		var ymdTime;
		ymdTime = $("input[name='ymdTime']").val();
		if(ymdTime==null || ymdTime=="")
 		{
 			alert("请输入日期！  ");
 			flg=false;
 		}
		else
		{
 			flg=true;
 		}
		
 		if(flg==true)
 		{
 				$.messager.confirm('数据导入', '您确定要执行该操作吗?', function(r){
 					if (r)
 					{
 						//显示进度框 
 		 				showProcess(true);

 		 		        //如果是true ，那么就把页面转向thcjp.cnblogs.com
 		 				 $.post(path+url,{type:type,isAllOrDaily:isAllOrDaily,ymdTime:ymdTime},function(result){
 		 						if (result.success){
 		 							//mesTitle = '导入成功';
 		 							showProcess(false);
 		 							$.messager.alert('通知消息',result.msg,'info');
 		 						} else {
 		 							//mesTitle = 'error';
 		 							showProcess(false);
 		 							$.messager.alert('数据导入失败 ');
 		 						} 						
 		 						/* $.messager.show({ 
 		 							 title: mesTitle,
 		 							 msg: result.msg
 		 						});  */
 		 					},'json'); 
 					}
 				});
 		} 
	}
	
	//进度条 
	function showProcess(isShow) 
	{
		   if (!isShow) 
		   {
		   		$.messager.progress('close');
		   		return;
		   }
		   
		   var win = $.messager.progress({
			   title:'请稍后', 
 				msg:'页面加载中...',
 				text:'',
 				interval:600
		     });
	}
</script>

</head>
<body >
	公用的时间选择器：
	<input class="easyui-datebox" style="width:100px" name="ymdTime" id="ymdTime" >
	<hr color="red">
	<div style="padding:5px;">
		<div>"每日数据列表"数据:</div>
		<div>
			<form id="paramForm" action="${path}/dataimp/dataImport?type=2" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<!-- 选择年份  :  
					<select class="easyui-combobox" name="year" id="year" panelHeight="auto" style="width:100px">
						<option value=""></option>
						<option value="2015" selected="selected">2015</option>
					</select>
					选择月份  :  
					<select class="easyui-combobox" name="month" id="month" panelHeight="auto" style="width:100px">
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
					<a href="javascript:redirectURL();" id="submit_search" class="easyui-linkbutton" iconCls="">数据导入</a>-->
					<a href="javascript:getDailyData('/dataimp/dataImport',2,1);" id="submit_search" class="easyui-linkbutton" iconCls="">导入选中的“日”的数据</a>
					<a href="javascript:getDailyData('/dataimp/dataImport',2,0);" id="submit_search" class="easyui-linkbutton" iconCls="">导入选中“月”的数据</a>
			</form>
		</div>
		<!-- <a href="javascript:getDate('/dataimp/dataImport',2);" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">初始数据导入</a> -->
		<!-- <a href="javascript:alert('weishixian');" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">增量数据导入</a> -->
	</div>
	<hr color="red">
	<div style="padding:5px;">
		<div>"投资管理报表"数据:</div>
		<a href="javascript:getDate('/dataimp/dataImport',3);" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">初始数据导入</a>
		<a href="javascript:getDate('/dataimp/dataImport',33);" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">增量数据导入</a>
		
		<!-- <input class="easyui-datebox" style="width:100px" name="ymdDailyTime" id="ymdDailyTime" > -->
		<a href="javascript:getDailyData('/dataimp/dataImport',333,'');" id="submit_search" class="easyui-linkbutton" iconCls="">导入选中“日”的数据</a>
	</div>
	<hr color="red">
	<div style="padding:5px;">
		<div>"用户基本信息"数据:</div>
		<a href="javascript:getDate('/dataimp/dataImport',4);" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">初始数据导入</a>
		<a href="javascript:getDate('/dataimp/dataImport',44);;" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">增量数据导入</a>
		
		<a href="javascript:getDailyData('/dataimp/dataImport',444,'');" id="submit_search" class="easyui-linkbutton" iconCls="">导入选中“日”的数据</a>
	</div>
	<hr color="red">
	<div style="padding:5px;">
		<div>"手机归属地"数据:</div>
		<a href="javascript:getDate('/dataimp/dataImport',5);" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">初始数据导入</a>
		<a href="javascript:getDate('/dataimp/dataImport',55);;" id="submit_search" class="easyui-linkbutton" iconCls="icon-search">增量数据导入</a>
		<a href="javascript:getDailyData('/dataimp/dataImport',555,'');" id="submit_search" class="easyui-linkbutton" iconCls="">导入选中“日”的数据</a>
	</div>
</body>
</html>
