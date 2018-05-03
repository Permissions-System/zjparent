<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>交易详情 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
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
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
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
		function getPager(data){
			var $table=$("#table");
			var html = "";
			if(data.result == null || data.result.length==0){
				html+='<tr><td colspan="5">无任何信息</td></tr>';
			}
			for(var i=0;i<data.result.length;i++){
				   if(i%2 == 0){
					   html+="<tr style='height:40px; background-color:#fff'>";
				   }else{
					   html+="<tr style='height:40px; background-color:#fff'>";
				   }
				html+="<td style='vertical-align:middle;'>"+$.format.date(new Date(data.result[i].termdate), 'yyyy-MM-dd')+"</td>";
				html+="<td name='amount' style='vertical-align:middle;'>"+$.format.number(data.result[i].termamount, '###,###.##')+"</td>";
				html+="<td name='bidclassname' style='vertical-align:middle;'>"+$.format.number(data.result[i].remaininterest, '###,###.##')+"</td>";
				
				if(data.result[i].termstatus==1){
				html+="<td style='vertical-align:middle;'>已还</td>";	
				html+="<td><img src='${ctx}/static/images/status.png' width='24' height='24'  alt=''/></td>";
				}else if(data.result[i].termstatus==2){
				html+="<td style='vertical-align:middle;'>已转让</td>";	
				html+="<td><img src='${ctx}/static/images/status.png' width='24' height='24'  alt=''/></td>";
				}else{
				html+="<td style='vertical-align:middle;'>未还</td>";	
				html+="<td><img src='${ctx}/static/images/status2.png' width='24' height='24'  alt=''/></td>";
				}
				html+="</tr>";
				
			   }
				$table.html("");
				$table.html(html);
			   var $pager = $(".classic .black2");
			   var pagehtml = "";
				//判断是不是第一页决定是否显示前一页标签
				if(data.currentPageNo==1){
					pagehtml += "<span> &lt;&nbsp;&nbsp;</span>";
				}
				if(data.currentPageNo != 1){
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
				if(data.currentPageNo != data.totalPageCount){
					var next = data.currentPageNo+1;
					pagehtml += "<a href=\"javascript:void(0);\" value=\""+next+"\">> </a>";
				}
				if(data.currentPageNo == data.totalPageCount){
					pagehtml += "<span>&nbsp;&nbsp; > </span>";
				}
				$pager.html("");
				$pager.html(pagehtml);
			
		}
		
		$(".classic .black2 a").live("click",function(e){
			e.preventDefault();
			current = $(this).attr("value"); 
			$.post("ajaxdealdetail.do", {pageNow : current,investordercode:$("#investordercode").val()}, function(data){
				getPager(data);
			});
		});	
		
		$.post("ajaxdealdetail.do", {pageNow : 1,investordercode:$("#investordercode").val()}, function(data){
			getPager(data);
		});
		
	});
</script>
<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
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
</head>

<body onLoad="MM_preloadImages('${ctx}/static/images/banner_buttom2.png','${ctx}/static/images/weibo2.png','${ctx}/static/images/wechat2.png','${ctx}/static/images/icon_weibo.fw.png','${ctx}/static/images/icon_wechat.fw.png')">
<%@include file="../header.jsp" %>
<!--网站logo 导航条  end-->

<div class="person_info" style="height:1094px;">
<%@include file="left.jsp"%>
  <div class="person_info_right" style="height:1094px;background-image:url(${ctx}/static/images/deald.png);">
    <div class="deal_info">
      <div class="deal_txt">［机构宝］整合网络征信技术、金融风控技术，是百富网团队精心锤炼、呕心沥血的成果。5大模块，33道防火墙，100多道工序，层层保护，投资收益有保障。</div>
      <div style="float:right; margin-right:35px;"></div>
    </div>
    <div class="member_h" style="width:95%; margin-top:35px;"><img src="${ctx}/static/images/a.jpg" width="26" height="26" style="float:left" alt=""/> <span style="color:#009CE4; width:250px;float:left; margin-left:15px;">${bid.bidtype}-${io.bidcode }</span><span style="float:right; width:300px; font-size:14px; text-align:right; margin-right:20px;"><a href="#" style="color:#999">担保方：${bid.assureinstname }</a></span></div>
    <div class="deal_b"><!-- 合同编号：<span style="color:#8F9496">${bid.instcode }</span>　　［<a href="#">查看</a>］ -->
    <br>投资金额：<span style="color:#8F9496">${io.amount }</span> 
       		  <span style="color:#009CE4;margin-left: 30px;float:right;"> 
                  <a href="${ctx}/static/upload/buyprotocol/${bid.bidtypeid }/<shiro:principal property="id"/>_${io.investordercode}.pdf" target="_blank"> 《月月富T投资协议》 </a> 
              </span> 
        <br>
                   年化收益率：<span style="color:#8F9496"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${bid.annualizedrate}" />%</span>
              <span style="color:#009CE4;margin-left: 33px;float:right;"> 
                  <a href="${ctx}/static/upload/buyprotocol/${bid.bidtypeid }/debt_<shiro:principal property="id"/>_${io.investordercode}.pdf" target="_blank"> 《债权转让协议》 </a> 
              </span> 
    </div>
    <div id="circle3" style="color:#565A5C; margin-left:200px;"></div><script type="text/javascript">
window.onload = function(){

	var object = document.getElementById('circle3')
	function loadImg (data){
			var i = 0;
			setInterval(function(){
				i++
				if(i>data){
					i=data
				}
				var imgLeft = -(i*147+(i*9))+'px'
				object.style.backgroundPosition = imgLeft+'\t'+'0px'
				object.innerHTML = i+'%';
			},15)
	
	}
	var point=${point};
	if(point>100){
		point=100;
	}
	loadImg(point);
}
</script>
    <div style="font-size:14px; margin-left:-100px;margin-top:165px;float:left">还款进度</div>
	<input type="hidden" id="investordercode" value="${io.investordercode }">
    <div class="personalinfo" style="margin-top:100px;">
      <div style="height:450px"><table class="am-table am-table-hover" style="margin-bottom:0px; text-align:center; font-weight:normal;width:775px; font-size:13px">
        <thead>
          <tr style="height:40px;">
            <th style="vertical-align:middle; width:15%">还款时间</th>
            <th style="vertical-align:middle; width:10%">本息</th>
            <th style="vertical-align:middle; width:15%">剩余本息</th>
            <th style="vertical-align:middle; width:15%">还款状态</th>
            <th style="vertical-align:middle; width:15%"></th>
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
