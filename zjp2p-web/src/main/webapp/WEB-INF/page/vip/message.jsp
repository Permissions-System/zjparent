<%@page import="com.zjgt.util.DateConverterUtil"%>
<%@page import="java.util.Date"%>
<%@page import="org.apache.shiro.SecurityUtils"%>
<%@page import="org.apache.shiro.subject.Subject"%>
<%@page import="com.zjgt.shiro.ShiroMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>消息中心 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet"
	type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript"
	src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script language="javascript" type="text/javascript">
	function fn_browse() {
		document.test_form.browse.click();
		document.test_form.file.value = document.all.test_form.browse.value;
	}
</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
	$(function() {
		function getPager(data) {
			var $table = $("#accordion");
			var html = "";
			if (data.result.length == 0) {
				html = "<div class='am-panel am-panel-default'><div class='am-panel-hd' style='padding:0px;'><h4 class='am-panel-title'><table class='am-table' style='margin-bottom: 0px; text-align: center; font-weight: normal;'><tbody><tr style='height: 60px; background-color: #fff'><td style='vertical-align: middle; width: 100%'>无任何信息</td></tr></tbody></table></h4></div></div></div>";
			}else{
				for ( var i = 0; i < data.result.length; i++) {
					html += "<div class='am-panel am-panel-default' >";
					html += "<div class='am-panel-hd' style='padding:0px;'>";
					html += "<h4 class='am-panel-title'>"
					html += "<table class='am-table' style='margin-bottom:0px; text-align:center; "
							+ (data.result[i].status == 2 ? 'font-weight:normal'
									: '') + "'><tbody>";
					html += "<tr style='height: 60px; background-color: #fff'>";
					if (data.result[i].status == 1) {
						html += "<td style='vertical-align: middle; width: 10%'>未读</td>";
					} else if (data.result[i].status == 2) {
						html += "<td style='vertical-align: middle; width: 10%'>已读</td>";
					} else {
						html += "<td style='vertical-align: middle; width: 10%'>--</td>";
					}
					html += "<td style='vertical-align: middle; width: 20%'>"
							+ $.format.date(new Date(data.result[i].createdate),
									'yyyy-MM-dd') + "</td>";
					if (data.result[i].type == 1) {
						html += "<td style='vertical-align: middle; width: 15%'>系统通知</td>";
					} else {
						html += "<td style='vertical-align: middle; width: 15%'>----</td>";
					}
					html += "<td style='vertical-align: middle; width: 40%'>"
							+ data.result[i].title + "</td>";
					html += "<td style='vertical-align: middle; width: 15%'><span name=${ctx}/member/message/check.do?id="
							+ data.result[i].id
							+ " class='check' target='do-not-say-"
							+ data.result[i].id
							+ "' status='"
							+ data.result[i].status
							+ "' ><a  href='javascript:void(0);' >查看</a></spna> ";
					html += "<a href=${ctx}/member/message/delete.do?id="
							+ data.result[i].id + "&pageNow=" + data.currentPageNo
							+ " class='delete'>删除</a></td>"
					html += "</tr></tbody></table></h4></div>"
					html += "<div id='do-not-say-"+data.result[i].id+"' class='am-panel-collapse am-collapse detailCollapse'><div class='am-panel-bd' id="+data.result[i].id+">"
							+ data.result[i].content + "</div></div></div>";

				}
			}
			$table.html("");
			$table.html(html);
			var $pager = $(".classic .black2");
			var pagehtml = "";
			//判断是不是第一页决定是否显示前一页标签
			if (data.currentPageNo == 1) {
				pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
			}
			if (data.currentPageNo != 1) {
				var pre = data.currentPageNo - 1;
				pagehtml += "<a href=\"javascript:void(0);\" value=\"" + pre
						+ "\"> &lt;</a>";
			}
			if (data.currentPageNo > 5) {
				pagehtml += "<a href=\"javascript:void(0);\" value=\"" + 1
						+ "\">1</a>";
				pagehtml += "<a href=\"javascript:void(0);\" value=\"" + 2
						+ "\">2</a>";
				pagehtml += "<span>. . .</span>";
			}
			var begin;
			var end;
			if (data.currentPageNo - 3 < 1) {
				begin = 1;
			} else {
				begin = data.currentPageNo - 3;
			}
			if (data.totalPageCount < data.currentPageNo + 3) {
				end = data.totalPageCount;
			} else {
				end = data.currentPageNo + 3;
			}
			//从action中获取分页页码下表的开始和结束下标
			for ( var i = begin; i <= end; i++) {
				if (data.currentPageNo == i) {
					pagehtml += "<span class=\"current\">" + i + "</span>";
				}
				if (data.currentPageNo != i) {
					pagehtml += "<a href=\"javascript:void(0);\" value=\"" + i
							+ "\">" + i + "</a>";
				}
			}
			var less = data.totalPageCount - data.currentPageNo;
			if (less >= 5) {
				var endb = data.totalPageCount - 1;
				pagehtml += "<span>. . .</span>";
				//显示尾页下标
				pagehtml += "<a href=\"javascript:void(0);\" value=\"" + endb
						+ "\">" + endb + "</a>";
				pagehtml += "<a href=\"javascript:void(0);\" value=\""
						+ data.totalPageCount + "\">" + data.totalPageCount
						+ "</a>";
			}
			//判断是不是最后一页，决定是否显示后一页下标
			if (data.currentPageNo != data.totalPageCount) {
				var next = data.currentPageNo + 1;
				pagehtml += "<a href=\"javascript:void(0);\" value=\"" + next
						+ "\">> </a>";
			}
			if (data.currentPageNo == data.totalPageCount) {
				pagehtml += "<span>&nbsp;&nbsp; > </span>";
			}
			$pager.html("");
			$pager.html(pagehtml);

		}
		$('#msgstatus label').click(function() {
			var msvalue = $(this).find("input").val();
			$.post("${ctx}/member/ajaxmessage.do", {
				pageNow : 1,
				msstatus : msvalue
			}, function(data) {
				getPager(data);
			});
		});

		$(".classic .black2 a").live("click", function(e) {
			e.preventDefault();
			current = $(this).attr("value");
			var msstatusvalue;
			var msstatusradios = document.getElementsByName("options");
			for ( var i = 0; i < msstatusradios.length; i++) {
				if (msstatusradios[i].checked == true) {
					msstatusvalue = msstatusradios[i].value;
				}
			}
			if (msstatusvalue == null) {
				msstatusvalue = 0;
			}
			$.post("${ctx}/member/ajaxmessage.do", {
				pageNow : current,
				msstatus : msstatusvalue
			}, function(data) {
				getPager(data);
			});
		});

		// init table 
		$.post("${ctx}/member/ajaxmessage.do", {
			pageNow : 1,
			msstatus : 0
		}, function(data) {
			getPager(data);
		});

		//查看消息内容
		$(".check").live(
				"click",
				function(e) {
					// 按钮禁用,避免重复请求
					
					var thisBut = $(this);
					// 是否未读
					var isUnRead = false;
					if (thisBut.attr('status') == '1') {
						isUnRead = true;
					}
					
					// 展开详情
					$('#' + thisBut.attr('target')).collapse('toggle');
					// 未读
					if (isUnRead) {
						var url = $(this).attr("name");
						$.get(url, function(data) {
							if (data.status == 'SUCCESS') {
								thisBut.parents('tr')
										.children("td:first-child").html('已读');
								thisBut.parents('table').css({
									'font-weight' : 'normal'
								});
								thisBut.attr({
									'status' : "2"
								});
							}
						});
					}
					return false;
				});

		//删除消息
		$(".delete").live("click", function(e) {
			var msstatusvalue;
			var msstatusradios = document.getElementsByName("options");
			for ( var i = 0; i < msstatusradios.length; i++) {
				if (msstatusradios[i].checked == true) {
					msstatusvalue = msstatusradios[i].value;
				}
			}
			if (msstatusvalue == null) {
				msstatusvalue = 0;
			}
			var url = $(this).attr("href") + "&msstatus=" + msstatusvalue;
			$('#doc-modal-1').modal('open');
			//$('#deleteMessageBut').attr({"href":url});
			$('#deleteMessageBut').click(function(){
				$.get(url, function(data) {
					getPager(data);
					$('#doc-modal-1').modal('close');
				});
			});
		 
			return false;
		})
	});
</script>
<style type="text/css">
.classic {
	width: 900px;
	height: 50px;
	margin-top: 20px;
	margin-left: auto;
	margin-right: auto;
}

div.black2 {
	font-family: "Myriad Pro";
	padding-right: 10px;
	padding-left: 10px;
	padding-bottom: 10px;
	margin: 3px;
	padding-top: 10px;
	text-align: right;
	float: left;
	width: 780px;
	font-size: 16px;
}

div.black2 a {
	padding-right: 8px;
	padding-left: 8px;
	padding-bottom: 5px;
	margin: 2px;
	color: #565A5C;
	padding-top: 5px;
	text-decoration: none;
	border: 1px solid #565A5C;
}

div.black2 a:hover {
	color: #fff;
	background-color: #666;
	border: 1px solid #565A5C;
}

div.black2 a:active {
	color: #fff;
	background-color: #666;
	border: 1px solid #565A5C;
}

div.black2 span.current {
	padding-right: 8px;
	padding-left: 8px;
	font-size: 16px;
	padding-bottom: 5px;
	margin: 2px;
	color: #fff;
	padding-top: 5px;
	background-color: #565A5C;
	border: 1px solid #565A5C;
}

div.black2 s.disabled {
	border-right: #eee 1px solid;
	padding-right: 8px;
	border-top: #eee 1px solid;
	padding-left: 8px;
	padding-bottom: 5x;
	margin: 2px;
	border-left: #eee 1px solid;
	color: #ddd;
	padding-top: 5px;
	border-bottom: #eee 1px solid
}
</style>
</head>

<body>
	<%@include file="../header.jsp"%>
	<!--网站logo 导航条  end-->
	<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
		<div class="am-modal-dialog" style="height: 220px;">
			<div class="am-modal-hd">
				删除信息<br>
				<hr data-am-widget="divider" style=""
					class="am-divider am-divider-default" />
				<a href="javascript: void(0)" class="am-close am-close-spin"
					data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd" style="font-size: 17px;">
				确认要删除所选的信息吗？
			</div>
			<div style="margin-top: 20px; margin-left: 100px; float: left">
				<button type="button" class="am-btn am-btn-secondary"
					style="width: 180px;" id="deleteMessageBut">确认</button>
				<a href="javascript: void(0)"
					style="font-size: 16px; margin-top: 3px; margin-left: 20px"
					data-am-modal-close>取 消</a>
			</div>
		</div>
	</div>

	<div class="person_info">

		<%@include file="left.jsp"%>
		<div id="recordTable" class="person_info_right">
			<div class="member_h">
				<span class="am-icon-comment-o am-icon-sm" style="color: #009CE4">
					消息中心</span>
			</div>
			<div class="personalinfo">
				<div style="margin-left: 5px;">
					消息状态：
					<div class="am-btn-group" data-am-button id="msgstatus">
						<label class="am-btn am-btn-biifoo am-btn-sm am-active"> <input
							type="radio" name="options" id="option1" value="0"> 全部
						</label> <label class="am-btn am-btn-biifoo am-btn-sm"> <input
							type="radio" name="options" id="option2" value="1"> 未读
						</label> <label class="am-btn am-btn-biifoo am-btn-sm"> <input
							type="radio" name="options" id="option3" value="2"> 已读
						</label>
					</div>
				</div>
				<table class="am-table am-table-striped"
					style="margin-bottom: 0px; text-align: center; font-weight: normal; width: 775px;">
					<thead>
						<tr style="height: 60px;">
							<th style="vertical-align: middle; width: 10%">状态</th>
							<th style="vertical-align: middle; width: 20%">时间</th>
							<th style="vertical-align: middle; width: 15%">消息类型</th>
							<th style="vertical-align: middle; width: 40%">消息标题</th>
							<th style="vertical-align: middle; width: 15%">操作</th>
						</tr>
					</thead>
				</table>
				<div class="am-panel-group" id="accordion"
					style="width: 775px; height: 410px;"></div>
				<div class="classic">
					<div class="black2"></div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
</html>
