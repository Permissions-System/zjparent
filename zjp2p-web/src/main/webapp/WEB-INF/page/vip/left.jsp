<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/static/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.format-1.3.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/jquery.number.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#waitingcircle").hide();
		$("#imgfile").live(
				'change',
				function() {
					$("#imgfile").attr("data-am-modal","{closeViaDimmer:0}");
					var imgfile = $(this).attr('id');
					$("#waitingcircle").show();
					$.ajaxFileUpload({
						//跟具updateP得到不同的上传文本的ID
						url : 'uploadImg.do?updateP=' + imgfile, //需要链接到服务器地址
						secureuri : false,
						fileElementId : '' + imgfile + '', //文件选择框的id属性（必须）
						dataType : 'text',
						success : function(data, status) {
							var data = eval("(" + data + ")");
							if(data.state == '2'){
								$("#imgfile").attr("data-am-modal","{target: '#error'}");
								$("#error").modal({closeViaDimmer:0});
								$("#error").modal('open');
								$("#imgmsg").html("");
								$("#imgmsg").html(data.msg);
								 $("#cancle").on("click",function(){
									   $("#imgfile").removeAttr("data-am-modal");
								   });
							}else{
							$('#img1').attr(
									"src",
									ctx + "/static/upload/img/"
											+ data.fileName);
							}
							$("#waitingcircle").hide();
						},
						error : function(data, status, e) {
// 							console.info(data);
							$("#waitingcircle").hide();
							alert('上传失败');
						}
					});
				});
	});
	function fn_browse() {
		$('#imgfile').click();
	}
</script>
<script type="text/javascript">
    var oldNickName = '<shiro:principal property="nickname" />';
	$(function(){var pointnum=${membersafety.transpasswdverified+membersafety.mobileifverified+membersafety.emailifverified+membersafety.bankcardifverified+membersafety.idcardifverified+1};
	var point;
	if(pointnum<4){
		$("#safea").html("认证级别：低");
		$("#safeimg").attr("src","${ctx}/static/images/progressbar_red.png");
	}
	if(pointnum==4){
		$("#safea").html("认证级别：中");
		$("#safeimg").attr("src","${ctx}/static/images/progressbar.png");
	}
	if(pointnum==5){
		$("#safea").html("认证级别：中");
		$("#safeimg").attr("src","${ctx}/static/images/progressbar.png");
	}
	if(pointnum==6){
		$("#safea").html("认证级别：高");
		$("#safeimg").attr("src","${ctx}/static/images/progressbar_green.png");
	}
	$("#safeimg").click(function(){
			window.location.href="securitycenter.do";
	});
	$.ajax({
        type: "post",
        url: ctx+"/member/getblance.do",
        dataType: "json",
        success: function (data) {
        	/* $("#blance").html($.format.number(data.result.blance, '###,###.##'));
        	 $("#accountTotal").html($.format.number(data.result.account, '###,###.##'));
    		$("#blance1").html($.format.number(data.result.blance, '###,###.##')); */
        	$("#blance").html($.number(data.result.blance,2));
    		$("#accountTotal").html($.number(data.result.account,2));
    		$("#blance1").html($.number(data.result.blance,2));
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        }
	});
	$("#sp1").click(function(){
		$("#setnickname1").html("Hi,<br> <input type='text' id='setnickname' style='width:65px;height: 20px' value='"+oldNickName+"'>");
	});
	String.prototype.len = function() {
	    return this.replace(/[^\x00-\xff]/g, 'xx').length;
	};
	$("#setnickname").live("blur",function(e){
			var nickname=$("#setnickname").val();
			// 昵称长度验证 
			if(nickname.len()>8){
				alert('昵称不能超过4个中文或8个字母');
				return;
			}
			/* if(nickname==""||nickname.length>12){
				$("#setnickname1").html("Hi,<br><span  style='font-size: 12px; color: #2388CA'><shiro:principal property='nickname' /></span>");
				return;
			} */
			var url=encodeURI("modifynickname.do?nickname="+nickname);
			$.get(url,function(data){
				if(data.status=="1"){
					oldNickName = data.result;
				    $("#setnickname1").html("Hi,<br><span  style='font-size: 14px; color: #2388CA'>"+data.result+"</span>");
				}
			});
	});
	});
</script>
<div class="person_info_left" style="position:relative;">
<div style="position:absolute;left:42px;top:18px" id="waitingcircle"><img src="${ctx}/static/images/spinning-circles.svg" width="30" alt=""></div>
	<div class="face imgtest">
      <figure>
		<form name="test_form" action="uploadimg.do" method="post"
			ENCTYPE="multipart/form-data" />
		<input type="file" id="imgfile" name="imgfile" style="display: none;" /><div><a
			href="javascript:fn_browse();"><img name="btn" title="上传头像" id="img1"
			src="${ctx}<shiro:principal property="headImgPath"/>" alt=""
			border="0"/></a></div>
		</form>
      </figure>
	</div>
	<div class="nickname" id="setnickname1" style="width: 60px">
		Hi,<br> <span  style="font-size: 12px; color: #2388CA"><shiro:principal
				property="nickname" /></span>
	</div>
	<div style="position:absolute;top:18px;left:140px">
		<a href="#" style="color: #909395; font-size: 15px;"><span id="sp1"
			class="am-icon-edit"></span></a>
	</div>

	<div class="security">
		
		<a href="securitycenter.do" id="safea">认证级别：中</a>
	</div>
	<div class="progressbar">
		<img src="${ctx}/static/images/progressbar.png" alt="" id="safeimg"/>
	</div>
	<div class="s_money">可用资金</div>
	<div class="m_number">
		<span id="blance" class="am-icon-jpy"></span>
	</div>
	<div class="m_btn">
		<a href="${ctx}/member/recharge.do" style="color: #fff"><span class="bn">充值</span></a>
		<a href="${ctx}/member/takecash.do" style="color: #fff"><span class="bn">提现</span></a>
	</div>
	<div class="m_record">
		<a href="${ctx}/member/dealhistory.do?status=2" style="color: #8F9496">查看充值记录</a>
	</div>
	<div class="m_h1">投资管理</div>
	<div class="m_list" style="margin-top: 25px;">
		<a href="${ctx}/member/ttfrecord.do">天 天 富&nbsp;&nbsp;＞</a>
	</div>
	<div class="m_list">
		<a href="${ctx}/member/investdoc.do">资产档案 ＞</a>
	</div>
	<div class="m_list" style="margin-bottom: 20px;">
		<a href="${ctx}/member/investmentrecord.do">投资记录 ＞</a>
	</div>
	<div class="m_h2">账户管理</div>
	<div class="m_list" style="margin-top: 25px;">
		<a href="${ctx}/member/membercenter.do">个人资料 ＞</a>
	</div>
	<div class="m_list">
		<a href="${ctx}/member/securitycenter.do">账户认证 ＞</a>
	</div>
	<div class="m_list">
		<a href="${ctx}/member/redpacketrecord.do">我的红包 ＞</a>
	</div>
	<div class="m_list">
		<a href="${ctx}/member/referral.do">推荐好友 ＞</a>
	</div>
	<div class="m_list">
		<a href="${ctx}/member/dealhistory.do">交易记录 ＞</a>
	</div>
	<!--<div class="m_list">我的积分　<span style="color:#CCC">即将上线</span></div>-->
    <div class="m_list"><a href="${ctx }/member/message.do">消息中心 ＞</a></div>
	<div class="m_bottomline"></div>

<div class="am-modal am-modal-alert" tabindex="-2" id="error">
        <div class="am-modal-dialog">
          <div class="am-modal-hd" id="imgmsg"></div>
          <div class="am-modal-bd" id="msg">
          </div>
           <div class="am-modal-footer">
             <span class="am-modal-btn" id="cancle">确定</span>
           </div>
         </div>
       </div>




</div>