<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
.my_style {
	float: left;
	overflow: visible;
}

.my_panel {
	float: left;
	height: 200px;
	padding-top: 5px;
	padding-left: 5px;
}

.my_transName {
	font-size: 14px;
	font-weight: bold;
	color: black;
}

.my_tasks {
	color: red;
	font-size: 14px;
	padding-left: 10px;
}
.title{
	padding: 10px 10px 5px 5px;
}
.title_span {
	font-size: 16px;
	font-weight: bold; 
	font-style: normal;
}
.task_div{
	padding-top: 10px;
}
.em_style{
	font-size:12px;
	color:#f00; 
	padding:0 3px;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',border:false">
		<div id="appendHere"></div>
	</div>
	<script type="text/javascript">
		var insertFlag = false;
		// 刷新页面
		function reloadPage(){
			location.reload();
		}
		
		// 创建待办任务
		function createToDoTask(data){
			if(isNull(data) || data.length==null || data.length==0){
				return;
			}
			var htmlStr1 = '<div id="todoTask">';
			htmlStr1 += '<div class="title">';
			htmlStr1 += 	'<p style="text-align: left;">';
			htmlStr1 += 		'<span class="title_span">待办任务提示</span>';
			htmlStr1 += 	'</p></div></div>';
			$('#appendHere').append(htmlStr1);
			var htmlStr2 = '<div class="my_style">';
			for(var i in data){
				htmlStr2 += createTaskPanel(data[i]);
			}
			htmlStr2 += 	'</div>';
			$('#appendHere').append(htmlStr2);
			insertFlag = true;
		}
		
		// 创建预警信息
		function createWarnings(data){
			if(isNull(data) || data.length==null || data.length==0){
				return;
			}
			if(insertFlag){
				var htmlStr = '<div style="clear:both;float:none;padding-top:20px;"></div>';
				$('#appendHere').append(htmlStr);
			}
			var htmlStr1 = '<div id="warnings">';
			htmlStr1 += '<div class="title">';
			htmlStr1 += 	'<p style="text-align: left;">';
			htmlStr1 += 		'<span class="title_span">预警提示</span>';
			htmlStr1 += 	'</p></div></div>';
			$('#appendHere').append(htmlStr1);
			var htmlStr2 = '<div class="my_style">';
			for(var i in data){
				htmlStr2 += createTaskPanel(data[i]);
			}
			htmlStr2 += 	'</div>';
			$('#appendHere').append(htmlStr2);
		}
		
		function createTaskPanel(data){
			if(!data || !data.subTasks){
				return '';
			}
			var htmlStr = '<div class="my_panel">';
			htmlStr += 		'<div id="'+data.transCode+'" class="easyui-panel" title="<span class=\'fl\'>'+data.name
															+'</span><span class=\'fr\'>总计<em class=\'em_style\'>'+data.total+'</em>件</span>"';
			htmlStr += 			'style="width: 250px; height: 200px;"';
			htmlStr += 			'data-options="">';
			htmlStr += 			'<ul>';
			for(var i in data.subTasks){
				htmlStr += createLi(data.subTasks[i]);
			}
			htmlStr +=			'</ul>';
			htmlStr +=		'</div>';
			htmlStr += 	'</div>';
			return htmlStr;
		}
		
		function createLi(data){
			if(!data){
				return '';
			}
			var htmlStr = '<li><div class="task_div">';
			htmlStr +=			'<a class="easyui-linkbutton" rel="'+data.url+'">';
			htmlStr +=				'<span class="my_transName">'+data.name+'</span>';
			if(true){//data.total){
				htmlStr += 			'<span class="my_tasks">'+data.total+'件</span>';
			}
			htmlStr += 			'</a></div>';
			if(data.subTasks && data.subTasks.length>0){
				htmlStr += '<ul>';
				for(var i in data.subTasks){
					htmlStr += createLi(data.subTasks[i]);
				}
				htmlStr += '</ul>';
			}
			htmlStr += '</li>';
			return htmlStr;
		}
			
		//解析Ajax请求失败的json错误信息
		function getJsonErrorMsg(data){
			var errorMsg = '';
			if(data && data.responseText){
				errorMsg = (eval('('+data.responseText+')')).string;
			}
			return errorMsg;
		}
		
		// 更新待办任务信息
		function refreshTasks(){
			// 如果当前处理页面不是首页待办任务页面，则暂停刷新处理
			var needToReloadData = true;
			if(self.parent.$('#tabs')){
				var currentTab = self.parent.$('#tabs').tabs('getSelected');
				var localTab = self.parent.$('#tabs').tabs('getTab', '欢迎使用');
				if(currentTab != localTab){
					needToReloadData = false;
				}
			}
			if(needToReloadData){
				$.ajax({
					type : 'POST',
					async: true,
					url : '${ctx}/base/home/task/getData',
					success : function(data, status) {
						// 清除原有的显示内容
						$('#appendHere').empty();
						// 创建新的显示内容
						if(data && data.toDoList && data.toDoList.length>0){
							createToDoTask(data.toDoList);
						}
						if(data && data.warningList && data.warningList.length>0){
							createWarnings(data.warningList);
						}
						$('[class="easyui-panel"]').panel({
							closable: false,
							collapsible: false,
							minimizable: false,
							maximizable: false,
							border: true
						});
						$('[class="easyui-linkbutton"]').linkbutton({
							plain:true
						});
						// 点击跳转功能页面
						$('a').click(function() {
							var menuName = $(this).find('.my_transName').text();
							var url = $(this).attr("rel");
							// 打开tab页
							if (url && url != '' && url != 'null') {
								self.parent.openTab(menuName, '${ctx}/' + url);
							}
						});
						setTimingReload();
					},
					error : function(data, status) {
						$.messager.show({
							title:'提示信息',
							msg:'获取待办任务、预警信息失败！<br/>'+getJsonErrorMsg(data),
							timeout:5000,
							showType:'slide'
						});
						// 出现异常后，不再重复查询
					},
					datatype : "json"
				});
			} else {
				setTimingReload();
			}
		}
		
		function setTimingReload(){
			// 每间隔1分钟刷新一次
			var intervalTime = 1000 * 60;
			setTimeout("refreshTasks()", intervalTime);
		}
		$(function(){
			// 查询待办、预警信息
			refreshTasks();
		});
	</script>
</body>
</html>