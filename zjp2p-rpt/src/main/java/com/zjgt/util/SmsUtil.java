package com.zjgt.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zjgt.util.SmsUtil;

public class SmsUtil {

    Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    /**
     * 维信(发送维信得模板短信)
     * @param phone
     * @param content
     * @throws IOException
     */
    // edit:2015/2/11 13:51 其他操作的用手机发送短信通知
    public void sendbyweixin2(String phone, String content) {
        logger.info("sendbyweixin2 {},{}" , phone , content);
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

        NameValuePair[] data = {// 提交短信
        new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), // 密码可以使用明文密码或使用32位MD5加密
                // new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone), new NameValuePair("content", content), };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult = method.getResponseBodyAsString();
            logger.info(SubmitResult);
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if (code == "2") {
                logger.info("短信发送成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("短信发送失败");
        }

    }

    /**
     * 维信(发送验证码的单独方法)
     * @param phone
     * @param content
     * @throws IOException
     */
    public void sendbyweixin(String phone, String content) throws IOException {
        logger.info("sendbyweixin {},{}" , phone , content);
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod("http://121.199.16.178/webservice/sms.php?method=Submit");
        client.getParams().setContentCharset("UTF-8");
        method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=UTF-8");

        String con = "您的手机验证码：【"+content+"】，有效时间10分钟，感谢使用百富网，如有疑问或非本人操作请联系400-9616-588。";
        NameValuePair[] data = {// 提交短信
        new NameValuePair("account", "cf_baifu360"), new NameValuePair("password", "a123456"), // 密码可以使用明文密码或使用32位MD5加密
                // new NameValuePair("password",
                // util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone), new NameValuePair("content", con), };
        method.setRequestBody(data);
        try {
            client.executeMethod(method);
            String SubmitResult = method.getResponseBodyAsString();
            logger.info(SubmitResult);
            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if (code == "2") {
                logger.info("短信发送成功");
            }
        } catch (Exception e) {
            throw new RuntimeException("短信发送失败");
        }

    }

    /**
     * mandao通道(发送验证码的单独方法)
     * 
     * @param content
     * @param mobile
     * @throws Exception
     */
    public void sendbymandao(String mobile, String content) throws Exception {
        logger.info("sendbymandao {},{}" , mobile , content);
        String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));
        // params.add(new
        // NameValuePair("pwd","3@0f44@4"));193CC2758C6A2B741B7B89CD0433C25E
        params.add(new NameValuePair("pwd","32D67380AC09E360A7A99090AD63AB05"));
        params.add(new NameValuePair("mobile", mobile));
        params.add(new NameValuePair("content", URLEncoder.encode("您的验证码是:" + content + ",请不要把验证码泄露给其他人。【百富网】", "utf-8")));
        params.add(new NameValuePair("ext", ""));
        params.add(new NameValuePair("stime", ""));
        params.add(new NameValuePair("rrid", ""));
        params.add(new NameValuePair("msgfmt", ""));
        String result = SmsUtil.request(url, params.toArray(new NameValuePair[params.size()]));
        Document doc = DocumentHelper.parseText(result);
        Element root = doc.getRootElement();
        String code = root.elementText("code");
        String msg = root.elementText("msg");
        String smsid = root.elementText("smsid");
        if (code == "2") {
            System.out.println("短信提交成功");
            logger.info("短信发送成功");
        }
        System.out.println(result);
    }

    /**
     * mandao通道(发送模板短信方法)
     * 
     * @param content
     * @param mobile
     * @throws Exception
     */
    public void sendbymandao2(String mobile, String content) throws Exception {
        logger.info("sendbymandao2 {},{}" , mobile , content);
        String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new NameValuePair("sn", "SDK-WSS-010-07721"));
        // params.add(new
        // NameValuePair("pwd","3@0f44@4"));193CC2758C6A2B741B7B89CD0433C25E
        params.add(new NameValuePair("pwd", "32D67380AC09E360A7A99090AD63AB05"));
        params.add(new NameValuePair("mobile", mobile));
        params.add(new NameValuePair("content", URLEncoder.encode(content + "【百富网】", "utf-8")));
        params.add(new NameValuePair("ext", ""));
        params.add(new NameValuePair("stime", ""));
        params.add(new NameValuePair("rrid", ""));
        params.add(new NameValuePair("msgfmt", ""));
        String result = SmsUtil.request(url, params.toArray(new NameValuePair[params.size()]));
        Document doc = DocumentHelper.parseText(result);
        Element root = doc.getRootElement();
        String code = root.elementText("code");
        String msg = root.elementText("msg");
        String smsid = root.elementText("smsid");
        if (code == "2") {
            System.out.println("短信提交成功");
            logger.info("短信发送成功");
        }
        System.out.println(result);
    }

    // private static Logger logger = Logger.getLogger("myLogger");

    public static void main(String[] args) throws Exception {
        /*
         * String url = "http://sdk.entinfo.cn:8061/webservice.asmx/mdsmssend";
         * 
         * List<NameValuePair> params = new ArrayList<NameValuePair>(); params.add(new NameValuePair("sn", "序列号")); params.add(new NameValuePair("pwd","加密之后的密码")); params.add(new
         * NameValuePair("mobile", "111111111")); params.add(new NameValuePair("content", URLEncoder.encode("测试", "utf-8"))); params.add(new NameValuePair("ext", "")); params.add(new
         * NameValuePair("stime", "")); params.add(new NameValuePair("rrid", "")); params.add(new NameValuePair("msgfmt", "")); String result = SmsUtil.request(url, params.toArray(new
         * NameValuePair[params.size()]));
         * 
         * System.out.println(result);
         */
        String mobile = "13916594637";
        SmsUtil smsutil = new SmsUtil();
        smsutil.sendbymandao(mobile, "测试，你好,mandao");
        smsutil.sendbyweixin(mobile, "测试，你好,weixin");
    }

    public static String request(String url, NameValuePair[] params) {

        String result = null;

        HttpClient client = new HttpClient();

        PostMethod postMethod = new PostMethod(url);

        postMethod.setRequestBody(params);

        int statusCode = 0;
        try {
            statusCode = client.executeMethod(postMethod);
        } catch (HttpException e) {
        } catch (IOException e) {
        }

        try {
            if (statusCode == HttpStatus.SC_OK) {
                result = postMethod.getResponseBodyAsString();
                return result;
            } else {
            }
        } catch (IOException e) {
        }
        postMethod.releaseConnection();
        return result;

    }
	public String getMD5(String sourceStr) throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
