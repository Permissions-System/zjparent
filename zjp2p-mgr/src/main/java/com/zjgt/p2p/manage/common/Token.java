package com.zjgt.p2p.manage.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.springfk.pancloud.utils.UUIDUtils;
import com.zjgt.util.UUIDUtils;

/**
 * ToKen
 * 
 * @author 公共组
 */
public class Token {
	private static Map<String, String> formToken = new HashMap<String, String>();
	private static Logger logger = LoggerFactory.getLogger(Token.class);

	/**
	 * 使用GUID生成token
	 * 
	 * @param session
	 * @return
	 */
	public synchronized static String generateToken(HttpSession session) {
		Object obj = session.getAttribute("FORMTOKEN");
		if (obj != null) {
			formToken = (Map<String, String>) session.getAttribute("FORMTOKEN");
		}
		String token = UUIDUtils.generate();
		formToken.put(token, "");
		session.setAttribute("FORMTOKEN", formToken);
		return token;
	}

	/**
	 * 验证提交的token是否与session中的token是否一致
	 * 
	 * @param request
	 * @return
	 */
	public static boolean validateToken(HttpServletRequest request) {
		String token = request.getParameter("formtoken");
		if (token == null) {
			logger.warn("formtoken参数不存在");
			return false;
		}
		HttpSession session = request.getSession();
		Map<String, String> tokenMap = (Map<String, String>) session.getAttribute("FORMTOKEN");
		if (tokenMap == null || tokenMap.size() < 1) {
			logger.warn("session中没有token");
			return false;
		}
		if (!tokenMap.containsKey(token)) {
			logger.warn("session中没有匹配的token");
			return false;
		}
		tokenMap.remove(token);
		session.setAttribute("FORMTOKEN", tokenMap);
		return true;
	}

}
