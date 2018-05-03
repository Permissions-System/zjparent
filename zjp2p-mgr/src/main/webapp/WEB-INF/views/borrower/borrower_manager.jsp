<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../pub/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百富网后台管理系统</title>
<link href="${ctx}/static/assets/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/assets/css/app.css" rel="stylesheet" type="text/css">
<script src="${ctx}/static/assets/js/jquery.min.js"></script>
<script src="${ctx}/static/assets/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/static/assets/js/handlebars.min.js"></script>
<script type="text/javascript" src="${ctx}/static/assets/js/jquery.format-1.3.min.js"></script>
</head>
<body>
<div class="backcontent">
  <div class="breadcrumb">
    <ol class="am-breadcrumb am-breadcrumb-slash">
      <li>首 页</li>
      <li>标的管理</li>
      <li class="am-active">借款人管理</li>
    </ol>
  </div>
  <div class="searchpanel">
    <form class="am-form-inline" role="form">
      
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" style="width: 180px;">借款人编号：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text"  placeholder="请输入借款人编号：" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" value="${map.instcode}" id="instcode" name="instcode"></div>
      </div> 
      <div class="am-form-group" style="margin-top:10px;">
        <label for="doc-ipt-3" class="am-u-sm-6 am-form-label" style="width: 180px;">借款人名称：</label>
        <div class="am-u-sm-2" style="float:left; margin-left:-45px;"><input class="am-form-field am-input-sm" type="text" placeholder="请输入借款人名称：" style="width:150px; height:30px;padding-top:0px; padding-bottom:0px;" value="${map.instname}" id="instname" name="instname"></div>
      </div>
      <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">当前状态：</label>
      <select id="doc-select-1" name="orgState" style="width:100px; height:30px; font-size:14px; color:#999">
             <option value=""  <c:if test="${map.orgState == ''}">selected="selected"</c:if>>全部</option>
             <option value="0" <c:if test="${map.orgState == '0'}">selected="selected"</c:if>>禁用</option>
             <option value="1" <c:if test="${map.orgState == 1}">selected="selected"</c:if>>正常</option>
      </select>
      <span class="am-form-caret"></span>
    </div>
       <br>
	<div style="margin-left:18px; margin-top:15px; float:left;">加入时间：</div>
    <div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:4px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:160px; height:30px;padding-top:0px; padding-bottom:0px;" id="beginTime" value="${map.beginTime}"/>
  </div><div style="float:left; margin-left:10px; margin-top:15px;"> - </div><div class="am-form-group am-form-icon" style=" margin-top:15px; margin-left:10px; float:left;">
    <i class="am-icon-calendar"></i>
    <input type="text" class="am-form-field am-radius" data-am-datepicker="{format: 'yyyy-mm'}" placeholder="日期" style="width:160px; height:30px;padding-top:0px; padding-bottom:0px;" id="endTime" value="${map.endTime}">
  </div>
  <div class="am-form-group am-form-select" style="margin-top:10px; margin-left:30px;">
      <label for="doc-select-1">借款人类型：</label>
      <select id="doc-select-1" name="borrowtype" style="width:100px; height:30px; font-size:14px; color:#999">
             <option value=""  <c:if test="${map.borrowtype == ''}">selected="selected"</c:if>>全部</option>
             <option value="1" <c:if test="${map.borrowtype == 1}">selected="selected"</c:if>>机构</option>
             <option value="2" <c:if test="${map.borrowtype == 2}">selected="selected"</c:if>>个人</option>
      </select>
      <span class="am-form-caret"></span>
    </div>
  <button type="button" id="search" class="am-btn am-btn-success am-btn-sm" style="margin-top:15px; margin-left:123px; height:30px; padding-top:6px;" onclick="jump(1)"><span class="am-icon-search">　搜索</span></button>
    </form>
  </div>
  <a href="editBorrower.do"><button type="button" class="am-btn am-btn-primary" style="margin-left:15px; margin-top:20px; float:left;"><span class=" am-icon-plus-square">　添加借款人</span></button></a>
  <input type="hidden" name="subject" id="subject" value="" >
  <div class="tablecontent"><table class="am-table am-table-bordered am-table-striped am-table-hover" style="text-align:center;">
    <thead>
        <tr style="text-align:center;">
            <th style="text-align:center;">序 号</th>
            <th style="text-align:center;">借款人编号</th>
            <th style="text-align:center;">借款人名称</th>
            <th style="text-align:center;">借款人类型</th>
            <th style="text-align:center;">加入时间</th>
            <th style="text-align:center;">当前状态</th>
            <th style="text-align:center;">操 作</th>
        </tr>
    </thead>
    <c:forEach items="${page.results}" var="borrower" varStatus="status">
    <tbody>
        <tr>
            <td>${status.count}</td>
            <td>${borrower.borrowercode}</td>
            <td>${borrower.borrowername}</td>
            <td><c:forEach items="${borrowtype}" var="o">
					 <c:if test="${borrower.borrowtype==o.key}">${o.value}</c:if>
				</c:forEach></td>
            <td><fmt:formatDate value="${borrower.validdate}" type="both"/></td>
            <td><c:forEach items="${orgState}" var="o">
					 <c:if test="${borrower.orgstate==o.key}">${o.value}</c:if>
				</c:forEach></td>
            <td><a href="viewBorrower.do?id=${borrower.id}" target="_blank"><button type="button" class="am-btn am-btn-secondary am-btn-sm">查看</button></a>
            	<a href="editBorrower.do?id=${borrower.id}"><button type="button" class="am-btn am-btn-secondary am-btn-sm">编辑</button></a>
            	<c:if test="${borrower.orgstate == 0}"><a href="changeOrgstate.do?id=${borrower.id}&orgstate=${borrower.orgstate}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="return confirm('您确定要启用该借款人吗?*该借款人启用后,可作为发布标的时待关联借款人的选项出现')">启用</button></a></c:if>
            	<c:if test="${borrower.orgstate == 1}"><a href="changeOrgstate.do?id=${borrower.id}&orgstate=${borrower.orgstate}" ><button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="return confirm('您确定要禁用该借款人吗?*该借款人被禁用后,发布标的时无法关联到该借款人')">禁用</button></a></c:if>
            	<button type="button" class="am-btn am-btn-secondary am-btn-sm" onclick="deleteVouchOrg(${borrower.id})">删除</button>
            </td>
        </tr>
    </tbody>
    </c:forEach>
</table>
<ul class="am-pagination am-pagination-right">
	        <!-- 判断是不是第一页决定是否显示前一页标签 -->
			<c:if test="${page.pageNow le 1 }">
				<li class="am-disabled"><span> &laquo;</span></li>
			</c:if>
			<c:if test="${page.pageNow gt 1 }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow - 1})"> &lt;</a></li>
			</c:if>
			<c:if test="${page.pageNow > 4}">
				<li><a href="javascript:void(0)" onclick="jump(1)">1</a></li>
				<li><span>. . .</span></li>
			</c:if>
			<!-- 从action中获取分页页码下表的开始和结束下标 -->
			<c:forEach begin="${page.begin}" end="${page.end}" step="1" var="i">
				<c:if test="${page.pageNow eq i }">
					<li class="am-active"><span>${i}</span></li>
				</c:if>
				<c:if test="${page.pageNow ne i }">
					<li><a href="javascript:void(0)" onclick="jump(${i})">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${(page.totalPageCount-page.pageNow) >= 4}">
				<li><span>. . .</span></li>
				<!-- 显示尾页下标 -->
				<li><a href="javascript:void(0)" onclick="jump(${page.totalPageCount})">${page.totalPageCount}</a></li>
			</c:if>
			<!-- 判断是不是最后一页，决定是否显示后一页下标-->
			<c:if test="${page.pageNow lt page.totalPageCount }">
				<li><a href="javascript:void(0)" onclick="jump(${page.pageNow + 1})">&raquo;</a></li>
			</c:if>
			<c:if test="${page.pageNow ge page.totalPageCount }">
				<li class="am-disabled"><span>&raquo; </span></li>
			</c:if>
          </ul>
</div>

<form id="getTopost" action="queryBorrowerList.do" method="post">
  <input id="instcodehidden" type="hidden" name="instcode" />
  <input id="instnamehidden" type="hidden" name="instname" />
  <input id="orgStatehidden" type="hidden" name="orgState" />
  <input id="borrowtypehidden" type="hidden" name="borrowtype" />
  <input id="beginTimehidden" type="hidden" name="beginTime" />
  <input id="endTimehidden" type="hidden" name="endTime" />
  <input id="pageNowhidden" type="hidden" name="pageNow" />
</form>
</div>
<footer>
  <p class="am-padding-left">© 2014 Biifoo.com Backend Management System Ver 1.0</p>
</footer>


<script src="${ctx}/static/assets/js/amazeui.js"></script>
<script type="text/javascript">
function jump(num){
	var instcode=$('#instcode').val();
	var instname=$('#instname').val();
	var orgState=$("select[name='orgState']").val();
	var borrowtype=$("select[name='borrowtype']").val();
	var beginTime=$("#beginTime").val();
	var endTime=$("#endTime").val();
	$('#instcodehidden').val(instcode);
	$('#instnamehidden').val(instname);
	$('#orgStatehidden').val(orgState);
	$('#borrowtypehidden').val(borrowtype);
	$('#beginTimehidden').val(beginTime);
	$('#endTimehidden').val(endTime);
	$('#pageNowhidden').val(num);
	$('#getTopost').submit();

}

function deleteVouchOrg(id){
	$.ajax({ 
		dataType: "json",
	    type:'post',
	    url:'deleteBorrower.do?id='+id,     
	    success:function(data){
	    	if("1" == data.status){
	    			alert('删除成功');
	        		location.href = "queryBorrowerList.do";
	        	}
	    	if("0" == data.status){
	    		alert('已关联项目，无法删除');
        		location.href = "queryBorrowerList.do";
        	}
		}  
	});
}
</script>
</body>
</html>