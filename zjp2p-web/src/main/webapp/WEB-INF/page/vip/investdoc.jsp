<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html>
<head>
<title>资产档案 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx}/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx}/static/css/banner.css" />
<link href="${ctx}/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${ctx}/static/js/ichart.latest.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.number.min.js"></script>
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
<script language="javascript" type="text/javascript"> 
function fn_browse() 
{ 
document.test_form.browse.click(); 
document.test_form.file.value = document.all.test_form.browse.value; 
} 
</script>
<c:if test="${all!=0 }">
<script type="text/javascript">

	var data1 = [
		        	{name : "可用余额："+$.number("${memberaccount.blance }",2),value :${memberaccount.blance/(memberaccount.blance+memberaccount.income+memberaccount.recvincome+memberaccount.freezeBlance)},color:'#f3c600'},
		        	{name : "待收本金："+$.number("${memberaccount.income }",2),value : ${memberaccount.income/(memberaccount.blance+memberaccount.income+memberaccount.recvincome+memberaccount.freezeBlance)},color:'#009CE4'},
		        	{name : '待收收益：'+$.number("${memberaccount.recvincome }",2),value : ${memberaccount.recvincome/(memberaccount.blance+memberaccount.income+memberaccount.recvincome+memberaccount.freezeBlance)},color:'#EA544A'},
		        	{name : '冻结资金：'+$.number("${memberaccount.freezeBlance }",2),value : ${memberaccount.freezeBlance/(memberaccount.blance+memberaccount.income+memberaccount.recvincome+memberaccount.freezeBlance)},color:'#3DB236'},
		        	
		        	];
</script>
</c:if>	
<c:if test="${all==0 }">
<script type="text/javascript">
	var data1 = [
	         	{name : "可用余额：0.00",value :0,color:'#f3c600'},
	        	{name : "待收本金：0.00",value : 0,color:'#009CE4'},
	        	{name : '待收收益：0.00',value : 0,color:'#EA544A'},
	        	{name : '冻结资金：0.00',value : 0,color:'#3DB236'},
	        	
        	];
</script>
</c:if>	
<script>
$(function(){
			var chart = new iChart.Donut2D({
				render : 'canvasDiv',
				data: data1,
				offsetx: 170,
				shadow:false,
				separate_angle:0,//分离角度
				legend : {
					enable : true,
					shadow:true,
					offsetx:80,
					offsety:10,
					background_color:false,
					border:false,
					align:'left',
					legend_space:30,//图例间距
					line_height:30,//设置行高
					sign_space:10,//小图标与文本间距
					sign_size:20,//小图标大小
					color:'#6f6f6f',
					fontsize:15//文本大小
				},
				sub_option : {
					mini_label_threshold_angle : 400,//迷你label的阀值,单位:角度
					mini_label:{//迷你label配置项
						fontsize:20,
						fontweight:400,
						color : '#4572a7'
					},
					listeners:{
						parseText:function(d, t){
							return d.get('value');//自定义label文本
						}
					} 
				},
				animation:true,
				showpercent:true,
				decimalsnum:2,
				width : 815,
				height : 255,
				radius:255
			});

			/**
			 *利用自定义组件构造左侧说明文本。
			 */
			chart.plugin(new iChart.Custom({
						drawFn:function(){
							//在右侧的位置，渲染说明的文字
							chart.target.textAlign('start')
							.textBaseline('top')
							.textFont('200 18px 微软雅黑')
							.fillText('资产结构',60,40,false,'#009CE4')
							
							
						}
				}));
				
				chart.draw();
			});
</script>			
<c:if test="${allamount!=0 }">
<script type="text/javascript">	
	var data2 = [
						<c:forEach items="${investdocviews}" var="b">
			        	{name : '${b.bidclassname}：'+$.number("${b.amount}",2),value : ${b.amount/b.allamount},color:'${b.color}'},
			        	</c:forEach>
			        	];
</script>
</c:if>
<c:if test="${allamount==0 }">
<script type="text/javascript">	
	var data2 = [
		<c:forEach items="${investdocviews}" var="b">
		{name : '${b.bidclassname}：'+$.number("${b.amount}",2),value : 0,color:'${b.color}'},
		</c:forEach>
			    ];
</script>
</c:if>
<script type="text/javascript">	
$(function(){
			
			
	    	
			var chart = new iChart.Donut2D({
				render : 'canvasDiv2',
				center:{
					text:' ',
					shadow:true,
					shadow_offsetx:0,
					shadow_offsety:2,
					shadow_blur:2,
					shadow_color:'#b7b7b7',
					color:'#6f6f6f',
					
				},
				data: data2,
				offsetx:170,
				shadow:false,
				separate_angle:0,//分离角度
				legend : {
					enable : true,
					shadow:true,
					offsetx:80,
					offsety:10,
					background_color:false,
					border:false,
					align:'left',
					legend_space:30,//图例间距
					line_height:30,//设置行高
					sign_space:10,//小图标与文本间距
					sign_size:20,//小图标大小
					color:'#6f6f6f',
					fontsize:15//文本大小
				},
				sub_option : {
					mini_label_threshold_angle : 400,//迷你label的阀值,单位:角度
					mini_label:{//迷你label配置项
						fontsize:20,
						fontweight:400,
						color : '#4572a7'
					},
					listeners:{
						parseText:function(d, t){
							return d.get('value');//自定义label文本
						}
					} 
				},
				animation:true,
				showpercent:true,
				decimalsnum:2,
				width : 815,
				height : 255,
				radius:255
			});

			/**
			 *利用自定义组件构造左侧说明文本。
			 */
			chart.plugin(new iChart.Custom({
						drawFn:function(){
							//在右侧的位置，渲染说明的文字
							chart.target.textAlign('start')
							.textBaseline('top')
							.textFont('200 18px 微软雅黑')
							.fillText('投资结构',60,40,false,'#009CE4')
							
							
						}
				}));
				
				chart.draw();
			});</script>

<script type="text/javascript">
	$(function(){
		var usedaccount="${memberaccount.usedaccount }";
		$("#usedaccount").html($.number($.format.number(usedaccount, '###,###.##'),2));
		var freezeBlance="${memberaccount.freezeBlance }";
		$("#freezeBlance").html("冻结资金："+$.number($.format.number(freezeBlance, '###,###.##'),2)+" 元");
		var totalincome=$.number("${memberaccount.totalincome }",2);
		$("#totalincome").html($.number($.format.number(totalincome, '###,###.##'),2));
		$('#memberaccountRecvincome').html($.number('${memberaccount.recvincome }',2));
	});

</script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
</head>

<body>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->

<div class="person_info">
<%@include file="left.jsp"%>
  <div class="invest_doc">
    <div class="member_h"><img src="${ctx}/static/images/member_icon01.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 投资档案</span></div>
    <div class="invest_1">
      <div class="invest_box1">
        总资产<span class="am-icon-question-circle" style="color:#E0E0E0" data-am-popover="{content: '可用资金、正在投资的、冻结资金', trigger: 'hover focus'}"></span><br>
<span style="color:#EA544A; font-size:22px; font-weight:bold" id="accountTotal"></span> 元<br>

<span style="font-size:13px; line-height:45px;" id="freezeBlance"> </span><br/>
      </div>
    
      <div class="invest_box2">
      累计收益 <span class="am-icon-question-circle" style="color:#E0E0E0" data-am-popover="{content: '不含待收收益', trigger: 'hover focus'}"></span><br>
<span style="color:#565A5C; font-size:22px;" id="totalincome"></span> 元<br>

<span style="font-size:13px; line-height:45px;">待收收益: <span id="memberaccountRecvincome">  </span></span> 元
      </div>
    
      <div class="invest_box3">
      累计投资额 <br>
<span style="color:##565A5C; font-size:22px;" id="usedaccount"></span> 元<br>

<span style="font-size:13px; line-height:45px;">最近一次投资：<c:if test="${empty  investorder.amount}"> 0.00</c:if> <c:if test="${!empty  investorder.amount}"> ${investorder.amount } </c:if>元</span>
      </div>
    
    
    </div>
    <div id='canvasDiv' style="float:left; margin-top:35px; margin-left:1px"></div>
    
    <div id='canvasDiv2' style="float:left; margin-top:15px;"></div>
  </div>
</div>
<%@include file="../footer.jsp"%>
</body>
</html>
