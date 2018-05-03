<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<%@include file="pub/header.jsp"%>
<meta charset="utf-8">
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport"
        content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var _BIDSTATUS = {
			// 募集中
			INVESTING:1,
			// 募集完成(已计息)
			UNINVESTED:2,
			// 募集完成(未计息)
			INVESTED:3,
			// 已结束
			FINISHED:4,
			// 未满标
			UNFULL:5, 
			// 流标审核中
			BADBIDING:6,
			// 已流标
			BADBID:7,
			// 未发布
			UNPUBLISH:8
	};
	
	var current = 1;
	ajaxPost("queryBidList.do", {pageNow : current}, function(data){
		getPager(data);
	});
	
	$("#search").click(function(){
		console.info({pageNow : current,bidclassname:$("#bidclassname").val(),bidcode:$("#bidcode").val(),bidtypeid:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),bidstatus:$("#doc-select-2").val()});
		ajaxPost("queryBidList.do", {pageNow : current,bidclassname:$("#bidclassname").val(),bidcode:$("#bidcode").val(),bidtypeid:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),bidstatus:$("#doc-select-2").val()}, function(data){
			getPager(data);
		});
	});
	
	function ajaxPost(url,dataParam,callback){  
		 var retData=null;  
		 $.ajax({   
		     type: "post",  
		     url: url,   
		     data: dataParam,  
		     dataType: "json",    
		     success: function (data) {  
		        retData=data;  
		        if(callback!=null&&callback!=""&&callback!=undefined)  
		            callback(data,status);   
		    },  
		    error: function (data) {
		    	console.info(data);
		    	alert(getJsonErrorMsg(data));
		    	location.href = "bidManager.do";
//	 	        alertMsg.error("调用方法发生异常:"+JSON.stringify(err)+"err1"+ JSON.stringify(err1)+"err2:"+JSON.stringify(err2));  
		    }    
		});        
		     return retData;  
		}  
	
	function getPager(data){
		   var $table = $(".tablecontent table tbody");
		   var html = "";
		   for(var i=0;i<data.results.length;i++){
			html+="<tr>";
			html+="<td>"+parseInt(i+1)+"</td>";   
			html+="<td>"+data.results[i].bidclassname+"</td>";
			html+="<td>"+data.results[i].bidcode+"</td>";
			html+="<td>"+$.format.number(data.results[i].amount, '###,###.##')+"</td>";
			html+="<td>"+status(data.results[i].bidstatus)+"</td>";
			html+="<td>"+$.format.date(new Date(data.results[i].pubdate), 'yyyy-MM-dd HH:mm:ss')+"</td>";
			html+="<td>"+data.results[i].membername+"</td>";
			html+="<td id=\""+data.results[i].id+"\">";
			html+="<a href=\"bidDetail.do?id="+data.results[i].id+"\" target='_blank'><button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\">投标记录</button></a>";
			if(data.results[i].bidtypeid != '4'&&_BIDSTATUS.BADBIDING != data.results[i].bidstatus && _BIDSTATUS.BADBID != data.results[i].bidstatus &&  data.results[i].approstatus != 1){
			html+=" <button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" name=\"liubiao\" value=\""+data.results[i].bidcode+"\">流标申请</button>";
			}
			if(_BIDSTATUS.UNPUBLISH == data.results[i].bidstatus){
			html+=" <a href=\"editBid.do?id="+data.results[i].id+"\"><button type=\"button\" class=\"am-btn am-btn-success am-btn-sm\">编 辑</button></a>"; 
			html+=" <button type=\"button\" class=\"am-btn am-btn-danger am-btn-sm\" name=\"delete\">删 除</button>";
			}else{
				html+=" <a href=\"continueBid.do?id="+data.results[i].id+"\"><button type=\"button\" class=\"am-btn am-btn-success am-btn-sm\" name=\"continue\">续标</button></a>"; 
				html+=" <a href=\"viewBid.do?id="+data.results[i].id+"\"><button type=\"button\" class=\"am-btn am-btn-success am-btn-sm\" name=\"view\">查 看</button></a>"; 
				html+=" <button type=\"button\" class=\"am-btn am-btn-danger am-btn-sm\" disabled=\"disabled\">删 除</button>";
			}
			if(_BIDSTATUS.INVESTED == data.results[i].bidstatus && data.results[i].bidtypeid != 4 && data.results[i].borrowstatus != 2){
			html+=" <button type=\"button\" class=\"am-btn am-btn-secondary am-btn-sm\" name=\"fukuan\" id=\"fukuan"+data.results[i].id+"\" value=\""+data.results[i].id+"\">付款</button>";
			}
			html+="<div class=\"am-modal am-modal-confirm\" id=\"my-pay"+data.results[i].id+"\" tabindex=\"-1\">";
			html+=" <div class=\"am-modal-dialog\">";
			html+="<div class=\"am-modal-hd\">您确定要将该标的付款给借款人？</div>";
			html+="<div class=\"am-modal-footer\">";
			html+="<span class=\"am-modal-btn\" data-am-modal-confirm>确定</span>";
			html+="<span class=\"am-modal-btn\" data-am-modal-cancel>取消</span>";
			html+="</div>";
			html+="</div>";
			html+="</div>";
			
			html+="<div class=\"am-modal am-modal-confirm\" id=\"my-delete"+data.results[i].id+"\" tabindex=\"-1\">";
			html+=" <div class=\"am-modal-dialog\">";
			html+="<div class=\"am-modal-hd\">您确定要删除该条记录？</div>";
			html+="<div class=\"am-modal-bd\">记录删除后将不可恢复。</div>";
			html+="<div class=\"am-modal-footer\">";
			html+="<span class=\"am-modal-btn\" data-am-modal-confirm>确定</span>";
			html+="<span class=\"am-modal-btn\" data-am-modal-cancel>取消</span>";
			html+="</div>";
			html+="</div>";
			html+="</div>";
			html+="<div class=\"am-modal am-modal-confirm\" id=\"my-confirm"+data.results[i].id+"\" tabindex=\"-1\">";
			html+="<div class=\"am-modal-dialog\" style=\"text-align:left\">";
			html+="<div class=\"am-modal-hd\" style=\"width:85%; margin-left:auto; margin-right:auto;\">请选择申请建议：</div>";
			html+="<div class=\"am-modal-bd\" style=\"width:100%; padding-left:55px; text-align:left\">";
			html+="<input type=\"radio\" name=\"doc-radio-1\" value=\"1\" checked>";
			html+="流 标　　";
			html+="<input type=\"radio\" name=\"doc-radio-1\" value=\"2\">";
			html+="自 充　　";
			html+="<input type=\"radio\" name=\"doc-radio-1\" value=\"3\">";
			html+="直接发标</div>";
			html+="<form class=\"am-form\">";
			html+="";
			html+="<div class=\"am-form-group\">";
			html+="<div style=\"text-align:left; width:80%; margin-left:auto; margin-right:auto; height:35px; margin-top:10px;\">建议原因：</div>";
			html+="<textarea class=\"\" rows=\"4\" id=\"appreason"+data.results[i].id+"\" style=\"width:80%;margin-left:auto; margin-right:auto\"></textarea>";
			html+="</div></form>";
			html+="<div class=\"am-modal-bd\" ></div>";
			html+="	<div class=\"am-modal-footer\">";
			html+="<span class=\"am-modal-btn\" data-am-modal-confirm>确定</span>";
			html+="<span class=\"am-modal-btn\" data-am-modal-cancel>取消</span>";	 
				      html+="</div>";
				  html+="</div>";
				  html+="</div></td>";
				
			html+="</tr>";
		   }
			$table.html("");
			$table.html(html);
		   
			var $pager = $("#pagenate");
			var pagehtml = "";
			//判断是不是第一页决定是否显示前一页标签
			if(data.pageNow==1){
				pagehtml += "<li class=\"am-disabled\">&laquo;</li>";
			}
			if(data.pageNow != 1){
				var pre = data.pageNow-1;
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a></li>";
			}
			if(data.pageNow > 5){
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+1+"\">1</a></li>";
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+2+"\">2</a></li>";
				pagehtml += "<span>. . .</span>";
			}
			//从action中获取分页页码下表的开始和结束下标
			for(var i=data.begin;i<=data.end;i++){
				if(data.pageNow == i){
					pagehtml += "<li class=\"am-active\">"+i+"</li>";
				}
				if(data.pageNow != i){
					pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a></li>";
				}
			}
			var less = data.totalPageCount-data.pageNow;
			if(less >= 5){
				var endb = data.totalPageCount-1;
				pagehtml += "<span>. . .</span>";
				//显示尾页下标
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a></li>";
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a></li>";
			}
			//判断是不是最后一页，决定是否显示后一页下标
			if(data.pageNow != data.totalPageCount){
				var next = data.pageNow+1;
				pagehtml += "<li><a href=\"javascript:void(0);\" value=\""+next+"\">&raquo; </a></li>";
			}
			if(data.pageNow == data.totalPageCount){
				pagehtml += "<li class=\"am-disabled\">&raquo; </li>";
			}
			$pager.html("");
			$pager.html(pagehtml);
	   }
	
	$("#pagenate li a").live("click",function(e){
		e.preventDefault();
		current = $(this).attr("value"); 
		ajaxPost("queryBidList.do", {pageNow : current,bidclassname:$("#bidclassname").val(),bidcode:$("#bidcode").val(),bidtypeid:$("#doc-select-1").val(),bidstarttime:$("#bidstarttime").val(),bidendtime:$("#bidendtime").val(),bidstatus:$("#doc-select-2").val()}, function(data){
			getPager(data);
		});
	});	
	
	$("button[name=fukuan]").live('click', function(e){
		e.preventDefault();
		$(this).each(function(){
			var value = $(this).parent().attr("id");
			console.info("pay"+value);
			
			$('#my-pay'+value).modal({
			      relatedElement: this,
			      onConfirm: function() {
			    	  butDisabled($('#fukuan'+value));
		 	        ajaxPost("payToBorrower.do", {id : value}, function(data){
		 	        	if(data.status == "1"){
		 	        		alert(data.result);
		 	        		location.href = "bidManager.do";
		 	        	}else if(data.status == "3"){
		 	        		alert(data.result);
		 	        		location.href = "bidManager.do";
		 	        	}else if(data.status == "4"){
		 	        		alert(data.result);
		 	        		location.href = "bidManager.do";
		 	        	}else {
		 	        		alert("付款遇到问题！");
		 	        		butEnabled($('#fukuan'+value), "付款");
		 	        	}
		 	        });
			      },
			      onCancel: function() {
			      }
		});
	});
	});
	$("button[name=delete]").live('click', function(e) {
		e.preventDefault();
		$(this).each(function(){
		var value = $(this).parent().attr("id");
			$('#my-delete'+value).modal({
			      relatedElement: this,
			      onConfirm: function() {
		 	        ajaxPost("deleteBid.do", {id : value}, function(data){
		 	        	alert(data.result);
		 	        	if("删除成功" == data.result){
		 	        		location.href = "bidManager.do";
		 	        	}
		 	        });
			      },
			      onCancel: function() {
			      }
			    });
		});
	  });
	
	$('button[name=liubiao]').live('click', function(e) {
		e.preventDefault();
		var bidcode = "";
		var valueid = "";
		$(this).each(function(){
			bidcode = $(this).val();
			valueid = $(this).parent().attr("id");
			$("#my-confirm"+valueid).modal({
			      relatedElement: this,
			      onConfirm: function() {
		 	        ajaxPost("applyLoseBid.do", {id : valueid,bidcode:bidcode,subject:$("input:radio[name=doc-radio-1]:checked").val(),appreason:$("#appreason"+valueid).attr("value")}, function(data){
		 	        	if("1" == data.status){
		 	        		alert("申请成功");
		 	        		location.href = "bidManager.do";
		 	        	}
		 	        	if("2" == data.status){
		 	        		alert(data.msg);
		 	        		location.href = "bidManager.do";
		 	        	}
		 	        });
			      },
			      onCancel: function() {
			      }
			    });
		});
		
	  });
	
	function status(key){
		var value = "";
		$("#doc-select-2 option").each(function(){
			if(key == $(this).val() && key != 0)
				value = $(this).text();
		});
		return value;
	}
	
	function butDisabled(but){
    	but.attr({"disabled":"disabled"});
		but.css("background-color","#C0C0C0");
		but.css("border-color","#C0C0C0");
		but.html("<i class='am-icon-spinner am-icon-spin'></i>处理中");
    }
    
    function butEnabled(but , butHtml){
    	but.removeAttr("disabled");
    	but.css("background-color","#36A2D8");
    	but.css("border-color","#36A2D8");
    	but.html(butHtml);
    }
	
});
</script>
</head>
<body>
<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li class="am-active">标的管理</li>
    </ol>
  </div>
  <div class="searchpanel">
    <form class="am-form-inline" role="form">
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >标的名称：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入标的名称" style="width:150px; height:30px;" id="bidclassname" name="bidclassname"></div>
      </div>
      
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" >标的编号：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入标的编号" style="width:150px; height:30px;" id="bidcode" name="bidcode"></div>
      </div> 
      <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">标的类型：</label>
      <select id="doc-select-1" style="width:100px; height:30px; font-size:14px; color:#999">
       <option value="">全部</option>
      <c:forEach items="${bidtype}" var="b">
  		<option value="${b.key}">${b.value}</option>
  	  </c:forEach>
      </select>
      <span class="am-form-caret"></span>
    </div> <br>
	<div style="margin-left:18px; margin-top:15px; float:left;">发标时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;" id="bidstarttime" />
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:200px; height:30px;" id="bidendtime">
  </div><div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;"><label for="doc-select-2">标的状态：</label>
      <select id="doc-select-2" style="width:100px; height:30px; font-size:14px; color:#999">
      <option value="">全部</option>
      <c:forEach items="${bidstatus}" var="b">
  		<option value="${b.key}">${b.value}</option>
  	  </c:forEach>
      </select></div>
  <button type="button" id="search" class="am-btn am-btn-success am-btn-sm" style="margin-top:15px; margin-left:123px; height:30px; padding-top:6px;"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  <a href="bidPublishIndex.do"><button type="button" class="am-btn am-btn-primary" style="margin-left:15px; margin-top:20px; float:left;"><span class=" am-icon-plus-square">　发布标的</span></button></a>
  <input type="hidden" name="subject" id="subject" value="" >
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">标的名称</th>
            <th style="text-align:center;">标的编号</th>
            <th style="text-align:center;">标的金额</th>
            <th style="text-align:center;">状 态</th>
            <th style="text-align:center;">发布时间</th>
            <th style="text-align:center;">发布人</th>
            <th style="text-align:center;">操 作</th>
        </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<ul class="am-pagination am-pagination-right" id="pagenate">
</ul>
</div>
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
</body>
</html>
