<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>提现 - 百富网小额投资理财平台</title>
<%@include file="../../common/tdk.jsp"%>
<%@include file="../../common/header.jsp"%>
<meta charset="utf-8">

<!--[if lte IE 9]><script>window.location.href='upgrade-your-browser.html';</script><![endif]-->
<link href="${ctx }/static/images/biifoo_icon.png" rel="shortcut icon" />
<link rel="stylesheet" href="${ctx }/static/css/banner.css" />
<link href="${ctx }/static/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="${ctx }/static/css/style.css" rel="stylesheet" type="text/css">
<style type="text/css">
.am-btn-bank {
  color: #565A5C;
  background-color: #fff;
  border-color: #DBDBDB;
}

.am-btn-bank:hover,
.am-btn-bank:focus,
.am-btn-bank:active,
.am-btn-bank.am-active,
.am-active .am-dropdown-toggle.am-btn-bank {
  color: #fff;
  background-color: #fff;
  border-color: #3C97EA;
  border-width:2px;
}
</style>
<script type="text/javascript" src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jquery.DB_tabMotionBanner.min.js"></script>
<!--添加被选中  -->
<script type="text/javascript">
	$(function(){
		$("#all_check").find("a").removeClass();
	});

</script>
<script type="text/javascript">
	//交易
	$(function(){
		//是否有投资记录
		var investordertimes="${investordertimes}";
		$("#withdrawal").blur(function(){
			$("#message").html("");
			var m=$("#withdrawal").val();
			var m1=$("#blance1").html();
			var b=$("#blance1").html().replace(/[,]/g,"");
			if(isNaN(m)){
				alert("请输入正确的金额");
				return;
			}
			if(parseInt(m)>parseInt(b)){
				alert("提现金额不能超过可用金额");
				return;
			}
			if(parseInt(m)>50000){
				alert("提现金额一笔不能超过50000");
				return;
			}
			var m2=parseInt(m);
			var times=$("#times").html();
			
			if(parseInt(times)==0){
				if(investordertimes>0){
				$("#poundage").html(2);
				if(2>parseInt(m)){
					$("#message").html("<font color='red'>提现金额不能小于手续费</font>");
				}
				}else{
					$("#poundage").html($.number(m2*0.006+2,2));
					if(parseFloat(m2*0.006+2)>parseInt(m)){
						$("#message").html("<font color='red'>提现金额不能小于手续费</font>");
					}	
				}
			}
			$("#withdrawal1").html(m);
		});
		$("#dealpassword").blur(function(){
			$("#dealpassword1").val($("#dealpassword").val());
		});
		$("#submit").click(function(){
			$("#message").html("　");
			var m=$.trim($("#withdrawal").val());
			var $dealpassword=$.trim($("#dealpassword1").val());
			var b=$("#blance1").html().replace(/[,]/g,"");
			if(isNaN(m)){
				alert("请输入正确的金额");
				return;
			}
			if(parseInt(m)>parseInt(b)){
				alert("提现金额不能超过可用金额");
				return;
			}
			if(parseInt(m)>50000){
				alert("提现金额一笔不能超过50000");
				return;
			}
			var m2=parseInt(m);
			var times=$("#times").html();
			if(parseInt(times)==0){
				if(investordertimes>0){
				$("#poundage").html(2);
				if(parseInt(2)>parseInt(m)){
					$("#message").html("<font color='red'>提现金额不能小于手续费</font>");
					return;
				}
				}else{
					$("#poundage").html($.number(m2*0.006+2,2));
					if(parseFloat(m2*0.006+2)>parseInt(m)){
						$("#message").html("<font color='red'>提现金额不能小于手续费</font>");
						return;
					}	
				}
			}
			butDisabled($("#submit"));
			$.post("takecash.do",{dealpassword:$dealpassword},function(data){
				if(data.status==1){
					butEnabled($("#submit"),"确定提现");
					$("#message").html("<font color='red'>"+data.result+"</font>");
				}
				if(data.status==2){
					var $bankname="${membersafety.bankname}";
					var $bankCode="${membersafety.bankcode}";
					var $bankcardno="${membersafety.bankcardno}";
					var $bankprince="${membersafety.bankprince}";
					var $bankcity="${membersafety.bankcity}";
					var $bankinfo="${membersafety.bankinfo}";
					var $bankAcountName="${membersafety.realname}";
					var withdrawInf = 'sina';
					var withdrawUrl = '';
				    if(withdrawInf == 'll'){
				    	withdrawUrl = "${ctx}/pay/ll/withdraw/withdraw.do";
				    }else{
				    	withdrawUrl = "${ctx}/pay/withdrawV2/withdraw.do";
				    }
				    console.log("withdrawUrl:",withdrawUrl);
					 $.ajax({ 
				            type: "POST", 
				            dataType:"json",
				            url: withdrawUrl, 
				            data:{isRapid:"true",amount:$("#withdrawal").val(),bankName:$bankname,bankCode:$bankCode,bankAcountNo:$bankcardno,bankAcountName:$bankAcountName,bankprince:$bankprince,bankcity:$bankcity,subBankName:$bankinfo},
				            success: function(result) { 
				            	if(result.status == 'SUCCESS'){
									window.location.href="dealhistory.do";
				            	}else{
				            		butEnabled($("#submit"),"确定提现");
				            		$("#message").html("<font color='red'>"+result.msg+"</font>");
				            		$('#message').show();
				            	}
				            },
				            error: function(result){
				                butEnabled($("#submit"),"确定提现");
				            	$("#message").html("<font color='red'>"+getJsonErrorMsg(result)+"</font>");
				            	$('#message').show();
				            }
				        }); 
				}
			});			
		});
		var bankno="${membersafety.bankcardno}";
		$("#bankno").html("***  "+bankno.substring(15));
	});
</script>
<script type="text/javascript">
	//处理空的输入框提交
	$(function(){
		$("#nextstep").click(function(){
			$("#message").html("　");
			var $withdrawal=$("#withdrawal").val();
			var $dealpassword=$("#dealpassword").val();
			if($withdrawal==""||$withdrawal==0){
				alert("请输入交易密码且提现金额不能为空或0");
			}else{
				$("#doc-modal-2").modal("open");
			}
		});
	})
</script>
<c:if test="${membersafety.mobileifverified+membersafety.transpasswdverified+membersafety.bankcardifverified!=3 }">
<script type="text/javascript">
	$(document).ready(function(){
	   $("#doc-modal-1").modal({closeViaDimmer:0});
       $('#doc-modal-1').modal('open');	   
});
</script>
</c:if>
</head>

<body>
<%@include file="../header.jsp"%>
<!--网站logo 导航条  end-->
<%@include file="bankCardBind.jsp"%>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-1">
  <div class="am-modal-dialog">
     <div class="am-modal-bd" style="font-size:17px;">
    为了保护您的账户安全，提现前请前往<a href="securitycenter.do">账户认证</a>完成"银行卡绑定"及"交易密码设置"！
    </div>
  </div>
</div>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-2">
  <div class="am-modal-dialog" style="height:490px;">
    <div class="am-modal-hd">确认提现信息<br>
      <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a> </div>
    <div class="am-modal-bd"> <span style="font-size:14px">请核对您的提现信息，并保证银行卡的准确性</span>
      <form class="am-form am-form-horizontal" style="width:90%; margin-top:10px; margin-left:auto; margin-right:auto">
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:18px;">银行卡：</label>
          <div class="am-u-sm-9" style="width:75.5%; margin-top:-20px;text-align: left;">${membersafety.bankname }（${membersafety.bankcardno }） </div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:18px;">提现金额：</label>
          <div class="am-u-sm-9" style="width:75.5%; margin-top:-20px; text-align:left" id="withdrawal1"> 0 元</div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:18px;">手续费：</label>
          <div class="am-u-sm-9" style="width:75.5%; margin-top:-20px; text-align:left; color:#F00" id="poundage"> 0.00 元</div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style="font-weight:normal; margin-top:18px;">到账时间：</label>
          <div class="am-u-sm-9" style="width:75.5%; margin-top:-20px; text-align:left"> 2小时内，最终以银行实际到账时间为准</div>
        </div>
        
        <div class="am-form" style="font-size:13px;">
          <label for="user-name" class="am-u-sm-3 am-form-label" style=" font-weight:normal; margin-top:18px;">交易密码：</label>
          <div class="am-u-sm-9" style="text-align:left">
            <input type="password" id="dealpassword1" class="am-input-sm" id="dealpassword1" style="width: 240px; height:30px; padding-top:1px; padding-bottom:0px;margin-top:22px;">
            <small></small> </div>
        </div>
        <div class="am-u-sm-10 am-form-label" style="font-size:14px; color:red;display: none;text-align: left;" id="errorMessage"></div>
        <div class="am-u-sm-10 am-form-label" style="font-size:14px; color:#999;text-align: left;text-indent:120px;" id="message">您处于百富系统安全保障中，请放心输入交易密码</div>
        
        <div style="margin-top:30px; margin-left:100px; float:left">
          <button type="button" class="am-btn am-btn-secondary" style="width:180px;" id="submit">确认提现</button>
          <a href="javascript: void(0)" style="font-size:16px; margin-top:3px;margin-left:20px" data-am-modal-close>取 消</a> </div>
      </form>
      
    </div>
  </div>
</div>



<div class="person_info" style="height:760px;">
<%@include file="left.jsp"%>
  <div class="person_info_right2" style="height:760px;">
    <div class="member_h"><img src="${ctx}/static/images/member_icon08.png" style="margin-top:-5px; vertical-align:middle" alt=""/><span style="color:#009CE4; font-size:18px;line-height:normal;"> 提 现</span></div>
    <div class="personalinfo" style="margin-top:60px;">
      <div style="margin-left:33px; font-size:16px; color:#565A5C">银行卡：</div>
      <div class="am-btn-group" data-am-button style="margin-left:33px; margin-top:15px">
        <label class="am-btn am-btn-bank" style="width:245px; height:43px; padding-top:8px; ">
       	 <c:if test="${!empty membersafety.bankcode}">
            <img src="${ctx }/static/images/withdraw/bank_logo/${membersafety.bankcode}.gif"  alt=""/> 
         </c:if>
         	<span style=" vertical-align: 10px; font-size:12px; margin-left:20px" id="bankno"></span>
        </label>
        <div style="margin-left:50px; margin-top:10px; float:left; font-size:14px">限额：20,000元/次</div>
        <div style="margin-left:50px; margin-top:10px; float:left; font-size:14px"><a href="#" data-am-modal="{target: '#doc-modal-5'}">修改</a></div>
      </div>


      
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C">可用余额：<span style="color:#f00; font-size:18px;" id="blance1">0.00</span> 元</div>
      
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C">
        <span style="float:left">交易金额：</span>
        <input type="text" class="am-form-field am-radius" onkeyup="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;"  
                                    onafterpaste="if(this.value==this.value2)return;if(this.value.search(/^\d*(?:\.\d{0,2})?$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=this.value;" style="width:115px; height:30px; float:left; padding-top:0px; padding-bottom:0px;" id="withdrawal"/>　元       
      </div>
      
      <div style="margin-left:33px; margin-top:40px; font-size:16px; color:#565A5C">剩余免费次数：<span style="color:#f00; font-size:18px;" id="times">${times }</span> 次</div>
      
     
      <div style="margin-left:33px; margin-top:40px; font-size:16px; float:left">
        <button type="button"   id="nextstep" class="am-btn am-btn-secondary">下一步</button>
      </div>
      
      <div class="dealtips2" style="margin-left:33px; margin-top:150px;">
        <span style="color:#f00">温馨提示</span><br>
1. 有投资记录每天限一次免费提现；<br>
2. 有投资记录但超出限制次数每笔收2元；<br>
3. 无投资记录按提现金额的0.6%收取且每笔加收2元；<br>
4. 平台对非正常频率提现将进行审查；<br>
5. 天天富产品当日转入并转出，算作一次投资记录。<br>
      </div>
      
      
    </div>
  </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
