package com.zjgt.p2p.manage.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.springfk.pancloud.exception.BusinessException;

/**
 * Tokern验证
 * 
 * @author 公共组
 */
public class TokenValidateInterceptor extends HandlerInterceptorAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			TokenValidate tokenValidate = handlerMethod.getMethodAnnotation(TokenValidate.class);
			if (null == tokenValidate) {
				// 没有声明需要token验证，放行
				return true;
			}
			if (!Token.validateToken(request)) {
				throw new BusinessException("非法的请求，请勿重复提交");
			}
			return true;
		}
		return true;

	}

}
