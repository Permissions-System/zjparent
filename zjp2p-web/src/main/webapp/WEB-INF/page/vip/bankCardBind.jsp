<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		// 不需要支行的银行列表 工、农、中,  招,光大  浦发（对私打款），建行
		var notSubBankList = ["ICBC","ABC","BOC","CCB","CMB","SPDB","CEB"];
		var bankname="${membersafety.bankname}";
		var bankcode="${membersafety.bankcode}";
		var bankinfo="${membersafety.bankinfo}";
		// 省
		var bankprince="${membersafety.bankprince}";
		// 市
		var bankcity="${membersafety.bankcity}";
		$('#s2').click(function(){
			$("#s2").attr("disabled");
			var url="bankcardno.do?bankcardno="+$("#bankcardno").val();
			$.post(url,function(data){
				$("#s2").removeAttr("disabled");
				if(data.result=="银行卡号正确"){
					var selectPayBankCode = $('#payBankList').val();
					var isSelectNotSubBank = false;
					notSubBankList.forEach(function (value, index, ar) {
						 if(selectPayBankCode == value){
							 isSelectNotSubBank = true;
							 return;
					     }
					});
					if(!isSelectNotSubBank && $('#bankinfo').val() == ''){
						$("#JSbankinfo").html("<span style='color:red'>开户支行为必输项</span>");
						return false;
					}
					//提示信息
					$("#JSbankcardno").html("<span style='color:green'>"+data.result+"</span>");
					$('#bankCardBindForm').submit();
				}else{
					$("#JSbankcardno").html("<span style='color:red'>银行卡号不正确</span>");
				}
			});
		});
		
		$.ajax({
			type : "POST",
			url : "${ctx}/member/getPrinces.do",
			async : false,
			data : {},
			success : function(data) {
				var options = '';
				$(data.result).each(function(i,val) {
					if(bankprince == val.typeName){
						options += "<option value='"+val.typeName+"' selected='selected' >"+val.typeName+"</option>";
					}else{
						options += "<option value='"+val.typeName+"'>"+val.typeName+"</option>";
					}
				});
				$('#princeList').append(options);
				
				$('#princeList').change(function() {
					$.ajax({
						type : "POST",
						url : "${ctx}/member/getCitys.do",
						async : false,
						data : {princeName:$(this).val()},
						success : function(data) {
							var options = '';
							$(data.result).each(function(i,val) { 
								if(val.configName!=''){
									if(bankcity == val.configName){
										options += "<option value='"+val.configName+"' selected='selected' >"+val.configName+"</option>";
									}else{
										options += "<option value='"+val.configName+"' >"+val.configName+"</option>";
									}
								}
							});
							$('#cityList option').remove();
							$('#cityList').append(options);
						}
					});
				});
				$('#princeList').trigger("change");
				
				$('#payBankList').change(function() {
					$('#cardBindBankname').val($(this).find("option:selected").attr('bankname'));
				});
				$('#payBankList').trigger("change");
			}
		});

		$.ajax({
			type : "POST",
			url : "${ctx}/member/getPayBanks.do",
			async : false,
			data : {},
			success : function(data) {
				var options = '';
				var isExists = false;
				$(data.result).each(function(i,val) { 
					if(bankname == val.configName){
						isExists = true;
						options += "<option value='"+val.configCode+"' bankname='"+val.configName+"'  selected='selected' >"+val.configName+"</option>";
						$('#cardBindBankname').val(val.configName);
					}else{
						options += "<option value='"+val.configCode+"' bankname='"+val.configName+"' >"+val.configName+"</option>";
					}
				});
				// 已绑定到14家银行之外的银行卡
				if(!isExists && bankcode!=''){
					$('#notBankListDiv').html('为了更加严格的保障用户的资金安全，百富网进行了系统升级，认证的银行卡目前只支持以下14家银行：农业银行、工商银行、招商银行、中国银行、建设银行、光大银行、华夏银行、中信银行、兴业银行、邮储银行、平安银行、浦发银行、广发银行、民生银行。您认证的银行卡不在该14家银行范围内，请联系客服热线400-9616-588进行更改银行卡');
					options = "<option value='"+bankcode+"' bankname='"+bankname+"'  selected='selected' >"+bankname+"</option>" + options;
				    
				} 
				$('#payBankList').append(options);
				if($('#cardBindBankname').val() == ''){
					$('#cardBindBankname').val(data.result[0].configName);
				}
				if(bankcode!=''){
					// 已绑定银行卡则禁用
					disableBindCard();
				}
				// 绑定了银行卡
				if(bankcode!=''){
					$('#noticeDiv').html('<span style="color: #EA544A; text-align: center">温馨提示</span><br>银行卡修改，将牵扯到您的账户资金安全</br>如确认修改，请联系客服(客服时间：周一至周五 9:00-21:00，双休日 10:00-18:00</br>客服热线：400-9616-588</br>');
				}
			}
		});
		// 禁用卡绑定
		function disableBindCard(){
			$('#payBankList').attr("disabled", "disabled");
			$('#bankcardno').attr("disabled", "disabled");
			$('#princeList').attr("disabled", "disabled");
			$('#cityList').attr("disabled", "disabled");
			$('#bankinfo').attr("disabled", "disabled");
			$('#s2').attr("disabled", "disabled");
			
		}
	});
</script>
<div class="am-modal am-modal-no-btn" tabindex="-1" id="doc-modal-5">
	<div class="am-modal-dialog" style="height: 600px;">
		<div class="am-modal-hd">
			银行卡认证<br> <hr data-am-widget="divider" style="" class="am-divider am-divider-default"
/> <a href="javascript: void(0)"
				class="am-close am-close-spin" data-am-modal-close>&times;</a>
		</div>
		<div class="am-modal-bd" style="margin-top:-20px">
			<span style="font-size: 14px">请填写本人有效银行账户信息，保证信息正确。</span>
			<br/>
			<span style="color: red;" id="notBankListDiv"> </span>
			<form class="am-form am-form-horizontal"
			    id="bankCardBindForm"
				action="authenticationBankcard.do" method="post"
				style="width: 90%; margin-top: 20px; margin-left: auto; margin-right: auto">
				<div class="am-form" style="font-size: 13px;">
					<label for="user-name" class="am-u-sm-3 am-form-label"
						style="font-weight: normal; margin-top: 18px;">姓名：</label>
					<div class="am-u-sm-9" style="width: 75.5%; margin-top: -18px; text-align: left;">
						${membersafety.realname }</div>
				</div>
				<div class="am-form" style="font-size: 13px;">
					<label for="user-name" class="am-u-sm-3 am-form-label"
						style="font-weight: normal; margin-top: 15px;">银行：</label>
					<div class="am-u-sm-9">
						<select id="payBankList" name="bankcode" class="am-input-sm" 
							style="width: 240px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left; margin-top: 15px;">
						</select>
						<input type="hidden" id="cardBindBankname" name="bankname" >
					</div>
				</div>
				<div class="am-form" style="font-size: 13px;">
					<label for="user-name" class="am-u-sm-3 am-form-label"
						style="font-weight: normal; margin-top: 15px;">卡号：</label>
					<div class="am-u-sm-9" style="text-align: left">
						<input type="text" class="am-input-sm" id="bankcardno"
							name="bankcardno" value="${membersafety.bankcardno }"
							style="width: 240px; height: 30px; padding-top: 1px; padding-bottom: 0px; margin-top: 15px;">
						<small id="JSbankcardno">　</small>
					</div>
				</div>
				<div class="am-form" style="font-size: 13px;">
					<label for="user-name" class="am-u-sm-3 am-form-label"
						style="font-weight: normal; margin-top: 38px;">开户城市：</label>
					<div class="am-u-sm-9">
						<select id="princeList" name="bankprince" class="am-input-sm"
							style="width: 120px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left; margin-top: 15px;">
						</select> <select id="cityList" class="am-input-sm" name="bankcity"
							style="width: 120px; height: 30px; padding-top: 1px; padding-bottom: 0px; float: left; margin-top: 15px;">
						</select>
					</div>
				</div>
				<div class="am-form" style="font-size: 13px;">
					<label for="user-name" class="am-u-sm-3 am-form-label"
						style="font-weight: normal; margin-top: 18px;">开户支行：</label>
					<div class="am-u-sm-9" style="text-align: left">
						<input type="text" class="am-input-sm" id="bankinfo"
							name="bankinfo" value="${membersafety.bankinfo }"
							style="width: 240px; height: 30px; padding-top: 1px; padding-bottom: 0px; margin-top: 15px;">
						<small id="JSbankinfo">　</small>
					</div>
				</div>
				<div style="margin-top: 30px; margin-left: 100px; float: left">
					<input type="button" id="s2" class="am-btn am-btn-secondary"
						style="width: 180px;" value="提交认证"> <a
						href="javascript: void(0)"
						style="font-size: 16px; margin-top: 3px; margin-left: 20px"
						data-am-modal-close>取 消</a>
				</div>
			</form>
			<div id="noticeDiv"
				style="font-size: 12px; float: left; text-align: left; margin-top: 20px; margin-left: 25px; color: #999">
				<span style="color: #EA544A; text-align: center">温馨提示</span><br>
				1. 如果您填写的开户行支行不正确，可能将无法成功提现，由此产生的提现费将不予返还。<br> 2.
				如果您不确定开户行支行名称，可打电话到所在地银行的营业网点询问或上网查询。<br> 3. 不支持提现至信用卡账户。<br>
				4. 若绑定银行卡过程存在困难或疑问，可联系在线客服或服务热线 400-9616-588
			</div>
		</div>
	</div>
</div>
