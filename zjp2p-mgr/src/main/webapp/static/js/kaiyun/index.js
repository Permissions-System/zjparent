$.fn.serializeObject = function() {  
	//将一个表单的数据返回成JSON对象  
      var o = {};  
      var a = this.serializeArray();  
      $.each(a, function() {  
        if (o[this.name]) {  
          if (!o[this.name].push) {  
            o[this.name] = [ o[this.name] ];  
          }  
          o[this.name].push(this.value || '');  
        } else {  
          o[this.name] = this.value || '';  
        }  
      });  
      return o;  
    };  
      
    $(document).ready(  
        function() {  
          jQuery.ajax( {  
            type : 'GET',  
            contentType : 'application/json',  
            url : 'http://localhost:8080/SpringMvcDemo/user/ajaxList',  
            dataType : 'json',  
            success : function(data) {  
              if (data && data.success == "true") {  
                $('#info').html("共" + data.total + "条数据。<br/>");  
                $.each(data.data, function(i, item) {  
                  $('#info').append(  
                      "编号：" + item.id + "，姓名：" + item.username  
                          + "，密码：" + item.password + ", 邮箱：" + item.email + "<br/>");  
                });  
              }  
            },  
            error : function() {  
              alert("error")  
            }  
          }); 
          
          
          
          $("#submit").click(function() {  
            var jsonuserinfo = $.toJSON($('#form').serializeObject());  
            alert(jsonuserinfo);  
            jQuery.ajax( {  
              type : 'POST',  
              contentType : 'application/json;charset=utf-8',  
              url : 'http://localhost:8080/SpringMvcDemo/user/ajaxAdd',  
              data : jsonuserinfo,  
              dataType : 'json',  
              success : function(data) {  
                alert("新增成功！");  
              },  
              error : function(data) {  
                alert("error")  
              }  
            });  
          });  
          /*$("#submit").click(function() {  
        	  var  str = {"username":"kaiyun222","password":"111111","email":"122@qq.com"};
        	  alert(str);
              jQuery.ajax( {  
                type : 'POST',  
                contentType : 'application/json;charset=utf-8',  
                url : 'http://localhost:8080/SpringMvcDemo/user/ajaxAdd',  
                data :  $.toJSON(str),  
                dataType : 'json',  
                success : function(data) {  
                  alert("新增成功！");  
                },  
                error : function(data) {  
                  alert("error")  
                }  
              });  
            });  */
          
          //语音验证
          $("#voiceVerify").click(function() {  
        	  //result = restAPI.voiceVerify("123456", "13816947328","13816947328","3","", "", "","","");
        	  
        	    var verifyCode="123456";	 		//必选参数 验证码内容，为数字和英文字母，不区分大小写，长度4-8位
        	    var to="13816947328";           	//必选参数 接收号码
        	    var displayNum="13816947328";   	//可选参数 显示主叫号码，显示权限由服务侧控制
        	    var playTimes="3";					//可选参数 循环播放次数，1－3次，默认播放1次
        	    var respUrl="";						//可选参数 语音验证码状态通知回调地址，云通讯平台将向该Url地址发送呼叫结果通知 
        	    var lang="";						//可选参数 语言类型
        	    var userData="";					//可选参数 第三方私有数据
        	    var welcomePrompt="";				//可选参数 欢迎提示音，在播放验证码语音前播放此内容（语音文件格式为wav） 
        	    var playVerifyCode="";				//可选参数 语音验证码的内容全部播放此节点下的全部语音文件
        	  
    	  var str = {
    			  "verifyCode":verifyCode,
    			  "to":to,
    			  "displayNum":displayNum,
    			  "playTimes":playTimes,
    			  "respUrl":respUrl,
    			  "lang":lang,
    			  "userData":userData,
    			  "welcomePrompt":welcomePrompt,
    			  "playVerifyCode":playVerifyCode};
    	  
          jQuery.ajax( {  
            type : 'POST',  
            contentType : 'application/json;charset=utf-8',  
            url : 'http://localhost:8080/SpringMvcDemo/yuntongxun/doVoiceVerifyByAjax',  
            data :  $.toJSON(str),  
            dataType : 'json',  
            success : function(data) {  
              
              if(data.statusCode==000000){
            	  alert("新增成功！"); 
              }else{
            	  var statusCode = data.statusCode;
                  var statusMsg = data.statusMsg;
                  alert(
                		  "error" + "\n" +
                		  statusCode + "\n" + 
                		  data.statusMsg
                		  );
              }
            },  
            error : function(data) {  
            	alert("error") 
            }  
          });  
        });  
          
          
          
          
          
          
          
        });  