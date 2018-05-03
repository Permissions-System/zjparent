<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../../pub/header.jsp"%>
<style type="text/css">
input{
    	width:150px;
    }
</style>
</head>
<body class="easyui-layout">
	<div id="north" data-options="region:'north',split:false" style="height:40px;">
		<div id="type" style="float:left;margin-left:3%;padding-top:10px;">
			单位类型:&nbsp;
				<select id="entType" class="easyui-combobox" panelHeight="auto" data-options="editable:false" name="单位类型">
					<option value="-1">请选择</option>
					<c:forEach var="type" items="${typeList}">
						<option value="${type.configCode }">${type.configName }</option>
					</c:forEach>
				</select>
		</div>
		<div style="float:right;margin-right:3%;padding-top:10px;">
			<input type="text" id="find" class="easyui-validatebox" placeholder="企业名称或组织机构代码"/>
			<a id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>
		</div>
	</div>
	<div data-options="region:'center',title:'圈外客户列表'" style="padding:5px;background:#eee;">
		<table id="entTable" data-options="fit:true,rownumbers:true,singleSelect:true,pagination:true" style="width:100%"> 
		</table>     
	</div>
<script type="text/javascript">
	$(document).ready(function() {
	    //根据类别获取企业信息列表
		var height = getComBoboxPanelHeight($("#entType"));
		$("#entType").combobox({
		    editable:false,
		    panelHeight:height,
			onSelect : function() {
			      search();
			}
		});
		
		$('#find').click(function(){
            $('#find').val("");
        });
        $('#find').blur(function(){
            if($.trim($('#find').val())==""){
                //$('#find').val("企业名称或组织机构代码");
            }
        });
        $.ajaxSetup ({
               cache: false //关闭AJAX响应的缓存
        });
        //搜索
        $("#search").bind("click", function() {
            search();
        });
        //enter键搜索
         $('#find').bind('keypress',function(event){
            if(event.keyCode == "13"){
                search();
            }
            else{
                 return;
            }
        });
        
        // 初始化Grid
		initEntGird();
		
	});
	
	/**
	 *初始化
	 */
	function initEntGird(){
	    $('#entTable').datagrid({    
	        url:'${ctx}/base/outent/byPage',
	        pageSize:10,
	        pageList:[10,20,30],
	        loadMsg: '加载数据，请稍候...',
	        method:'post',
	        nowrap:false,
	        autoRowHeight: true,
	        striped:true,
	        fitColumns:true,
	        columns:[[        
	                {field:'orgCode',title:'组织机构代码',width:80,align:'center',halign:'center'},     
	                {field:'chineseFullName',title:'企业名称',width:250,align:'left',halign:'center'},
	                {field:'entType',title:'单位类型',width:80,align:'center',halign:'center',
	                    formatter : function(value, row, index) {
	                        if(value){
	                            var data = $('#entTable').datagrid('getData');
	                            var result=0;
	                            for(var i=0;i<data.typeList.length;i++){
	                                if(value==data.typeList[i].configCode){
	                                    result=i;
	                                    i=0;
	                                    break;
	                                }
	                            }
	                            return data.typeList[result].configName;
	                            }
	                        else{
	                            return "";
	                        }
	                    }
	                },
	                {field:'opetation',title:'操作',width:120,align:'center',halign:'center',          
	                    formatter : function(value, row, index) {
	                        var opt='';
	                        opt+='<a href="#" onclick="entDetail('+index +')" class="easyui-linkbutton">详情>></a>';
	                        return opt;
	                    }
	                }     
	         ]],
	         onLoadSuccess: function(data){
	             if(data.total==0){
	                 $.messager.show({
	                        title:'消息',
	                        msg:'没有记录。',
	                        timeout:5000,
	                        showType:'slide'
	                    });
	             }
	         },
	         onLoadError: function(){
	             $.messager.alert('错误信息','信息查询失败!','error');
	         }      
	    });
		
	}
	//查看
	function entDetail(index) {
		$('#entTable').datagrid('selectRow', index); //选中当前记录
		var gridNode = $('#entTable').datagrid('getSelected');
		var entNo = gridNode.entNo;
		self.parent.openTab("查看-"+gridNode.chineseFullName,'${ctx}/base/outent/info/'+entNo);
	}

	// 查询
	function search(){
		var inputString = $('#find').val();
		$('#entTable').datagrid('load',{
			entType : $('#entType').combobox('getValue')=="-1"?null:$('#entType').combobox('getValue'),
			param : $.trim(inputString)
		});
	}
</script>
</body>
</html>