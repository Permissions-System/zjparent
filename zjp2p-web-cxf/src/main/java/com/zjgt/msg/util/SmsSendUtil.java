package com.zjgt.msg.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Properties;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;

import com.zjgt.msg.util.HttpRequest;
import com.zjgt.msg.util.Str2MD5;

public class SmsSendUtil {

	//企业信息通讯uRL
	static String sendMessageUrl="http://58.83.147.92:8080/qxt/smssenderv2";
	
	/**
	 *发送短信方法 
	 * @param user 用户名
	 * @param serialNumber 密码
	 * @param mobile 发送短信手机号
	 * @param strContent 发送内容
	 * @return
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 */
	public static String sendMessages(String user,String serialNumber,String mobile, String strContent) throws JSONException, UnsupportedEncodingException
	{

			   String postData="";

		       if(!"".equals(user))
		       {
		    	   postData="user="+user;
		       }
		       
		       if(!"".equals(serialNumber))
		       {
		    	   postData+="&password="+Str2MD5.MD5(serialNumber);
		       }
		       
		       if(!"".equals(mobile))
		       {
		    	   postData+="&tele="+mobile;
		       }
		       
		       if(!"".equals(strContent))
		       {
		    	   postData+="&msg="+URLEncoder.encode(strContent,"GBK");
		       }
		  
		    	postData+="&extno=1";

		   String resultStatus=HttpRequest.sendGet(sendMessageUrl, postData);
		   if(!"".equals(resultStatus))
		   {
			   
			   System.out.println("短信发送状态:"+ resultStatus);

		   }

		return resultStatus;
	}

}
