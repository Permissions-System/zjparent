<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>我的红包 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
.classic {
	width:900px;
	height:50px;
	margin-top: 20px;
	margin-left:auto;
	margin-right:auto;
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
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript">
function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}


</script>

<script type="text/javascript">
	$(function(){
		$('#bs label').click(function(){
			var bsvalue=$(this).find("input").val();
			var btvalue;
			var btradios = document.getElementsByName("btoptions");
	  		 for ( var i = 0; i <btradios.length; i++) {
				  if (btradios[i].checked==true) {
						btvalue=btradios[i].value;
				  }
			 }
	  		 if(btvalue==null){
	  			 btvalue=0;
	  		 }
	  		$.post("ajaxredpacketrecord.do", {pageNow : 1,bonusstatus:bsvalue,bonustype:btvalue}, function(data){
	  			getPager(data);
	  		});

		});
		$('#bt label').click(function(){
			var btvalue=$(this).find("input").val();
			var bsvalue;
			var bsradios=document.getElementsByName("bsoptions");
			 for ( var i = 0; i <bsradios.length; i++) {
				  if (bsradios[i].checked==true) {
						bsvalue=bsradios[i].value;
				  }
			 }
			 if(bsvalue==null){
				 bsvalue=0;
			 }
			 $.post("ajaxredpacketrecord.do", {pageNow : 1,bonusstatus:bsvalue,bonustype:btvalue}, function(data){
				 getPager(data); 	
			 });
		});
		
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if(data.result == null || data.result.length==0){
				html+='<tr><td colspan="6">无任何信息</td></tr>';
			}
			for(var i=0;i<data.result.length;i++){
					   html+="<tr style='height:60px;'>";
				html+="<td style='vertical-align:middle;'>"+data.result[i].bonusno+"</td>"
				if(data.result[i].source==1){
					html+="<td style='vertical-align:middle;'>注册</td>";
				}
				else if(data.result[i].source==2){
					html+="<td style='vertical-align:middle;'>推荐</td>";
				}
				else if(data.result[i].source==3){
					html+="<td style='vertical-align:middle;'>活动</td>";
				}else{
					html+="<td style='vertical-align:middle;'>其他</td>"
				}
				html+="<td style='vertical-align:middle;'>"+$.format.number(data.result[i].account, '###,###.##')+"元</td>";
				html+="<td style='vertical-align:middle;'>"+$.format.date(new Date(data.result[i].begindate), 'yyyy-MM-dd')+"</td>";
				if(data.result[i].status==1){
					html+="<td style='vertical-align:middle;'>正常</td>";
				}
				else if(data.result[i].status==2){
					html+="<td style='vertical-align:middle;'>冻结</td>";
				}
				else if(data.result[i].status==3){
					html+="<td style='vertical-align:middle;'>已过期</td>";
				}
				else if(data.result[i].status==4){
					html+="<td style='vertical-align:middle;'>已使用</td>";
				}else{
					html+="<td style='vertical-align:middle;'>其他</td>";
				}
				if(data.result[i].bonustype==1){  
				html+="<td style='vertical-align:middle;'>注册红包</td>";
				} 
				else if(data.result[i].bonustype==2){
					html+="<td style='vertical-align:middle;'>推荐红包</td>";	
				}
				else if(data.result[i].bonustype==3){
					html+="<td style='vertical-align:middle;'>活动红包</td>";
				}else{
					html+="<td style='vertical-align:middle;'>其他红包</td>";
				}
				html+="<td style='vertical-align:middle;'>"+data.result[i].subject+"</td>";
				html+="</tr>";
				
			   }
				$table.html("");
				$table.html(html);
			   var $pager = $(".classic .black2");
			   var pagehtml = "";
				//判断是不是第一页决定是否显示前一页标签
			   if(data.currentPageNo<=1){
					pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
				}
				if(data.currentPageNo > 1){
					var pre = data.currentPageNo-1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+pre+"\"> &lt;</a>";
				}
				if(data.currentPageNo > 5){
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+1+"\">1</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+2+"\">2</a>";
					pagehtml += "<span>. . .</span>";
				}
				var begin;
				var end;
				if (data.currentPageNo-3<1) {
					begin = 1;
				} else {
					begin = data.currentPageNo-3;
				}
				if (data.totalPageCount < data.currentPageNo + 3) {
					end = data.totalPageCount;
				} else {
					end = data.currentPageNo + 3;
				}
				//从action中获取分页页码下表的开始和结束下标
				for(var i=begin;i<=end;i++){
					if(data.currentPageNo == i){
						pagehtml += "<span class=\"current\">"+i+"</span>";
					}
					if(data.currentPageNo != i){
						pagehtml += "<a href=\"javascript:void(0);\" value=\""+i+"\">"+i+"</a>";
					}
				}
				var less = data.totalPageCount-data.currentPageNo;
				if(less >= 5){
					var endb = data.totalPageCount-1;
					pagehtml += "<span>. . .</span>";
					//显示尾页下标
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+endb+"\">"+endb+"</a>";
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+data.totalPageCount+"\">"+data.totalPageCount+"</a>";
				}
				//判断是不是最后一页，决定是否显示后一页下标
				if(data.currentPageNo < data.totalPageCount){
					var next = data.currentPageNo+1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+next+"\">> </a>";
				}
				if(data.currentPageNo >= data.totalPageCount){
					pagehtml += "<span>&nbsp;&nbsp; > </span>";
				}
				$pager.html("");
				$pager.html(pagehtml);
			
		}
		$(".classic .black2 a").live("click",function(e){
			e.preventDefault();
			current = $(this).attr("value"); 
			var bsvalue;
			var bsradios=document.getElementsByName("bsoptions");
			 for ( var i = 0; i <bsradios.length; i++) {
				  if (bsradios[i].checked==true) {
						bsvalue=bsradios[i].value;
				  }
			 }
			 if(bsvalue==null){
				 bsvalue=0;
			 }
			 var btvalue;
				var btradios = document.getElementsByName("btoptions");
		  		 for ( var i = 0; i <btradios.length; i++) {
					  if (btradios[i].checked==true) {
							btvalue=btradios[i].value;
					  }
				 }
		  		 if(btvalue==null){
		  			 btvalue=0;
		  		 }
			$.post("ajaxredpacketrecord.do", {pageNow : current,bonusstatus:bsvalue,bonustype:btvalue}, function(data){
				getPager(data);
			});
		});	
		$.post("ajaxredpacketrecord.do", {pageNow : 1,bonusstatus:0,bonustype:0}, function(data){
			getPager(data);
		});
		$("#hongbaoblance").html($.format.number("${blance}", '###,###.##'));
	});

</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body >
<%@include file="../header.jsp" %>
<!--网站logo 导航条  end-->

<div class="person_info">
  <%@include file="left.jsp"%>
  <div class="person_info_right">
    <div class="member_h" style="width:95%"><img src="${ctx}/static/images/member_icon06.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 我的红包</span><span style="float:right; width:150px; font-size:14px;"><!--  <a href="#">＋ 激活我的红包</a>--></span></div>
    <div class="personalinfo" style="margin-top:50px;">
      <div style="position:relative;width:100%; font-size:16px;">红包账户：<span style="font-size:24px;color:#EA544A" id="hongbaoblance"></span> 元（可用）&nbsp; <div style="position: absolute;left:600px;top:10px"><a href="redpacketUseRecord.do" >红包使用记录</a></div></div>
      <div style="width:813px;height:80px;background-color:#F5F5F5;margin-left:-19px;margin-top:5px;margin-bottom:25px;padding-left:25px;padding-top:18px;font-size:14px;color:#8F9496">注：1.您所有的红包有效期为3年，本次计算时间为：（2015年1月1日——2017年12月31日），到期后将统一归零。<br>
　　2.每3年循环一次，如在2019年领取的所有红包将在以2018年1月1日为计算开始日，将在2020年12月31日额度归零。</div>
      <div style="margin-left:5px;">红包来源：<div class="am-btn-group" data-am-button id="bt">
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="btoptions" id="option1" value="0"> 全 部
  </label>
 	<c:forEach items="${bonustype}" var="b">
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="btoptions" value="${b.key }" >${b.value }
  </label>
	</c:forEach>
</div></div>
      <div style="margin-left:5px;margin-top:10px;">红包状态：<div class="am-btn-group" data-am-button id="bs">
  <label class="am-btn am-btn-biifoo am-btn-sm am-active">
    <input type="radio" name="bsoptions" id="option1" value="0"> 全 部
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="bsoptions" id="option2" value="1"> 正  常
  </label>
  <label class="am-btn am-btn-biifoo am-btn-sm">
    <input type="radio" name="bsoptions" id="option3" value="3"> 已过期
  </label>
  
</div></div>
      <div style="height:340px;">
      <table class="am-table" style="margin-bottom:0px; text-align:center; font-weight:normal;width:775px; font-size:13px">
        <thead>
          <tr style="height:60px;">
            <th style="vertical-align:middle; width:21%">红包编号</th>
            <th style="vertical-align:middle; width:10%">红包来源</th>
            <th style="vertical-align:middle; width:10%">面 值</th>
            <th style="vertical-align:middle; width:15%">领取日期</th>
            <th style="vertical-align:middle; width:9%">状 态</th>
            <th style="vertical-align:middle; width:10%">红包描述</th>
            <th style="vertical-align:middle; width:25%">使用规则</th>
          </tr>
        </thead>
        <tbody id="table">
        </tbody>
      </table></div>
      
        <div class="classic">
     		<div class="black2"></div>
     	</div>
    </div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
	