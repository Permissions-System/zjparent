package com.zjgt.p2p.manage.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Token拦截器
 * 
 * @author 公共组
 */
public class TokenInjectInterceptor extends HandlerInterceptorAdapter {

	final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Token拦截器处理
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			TokenInject tokenInject = handlerMethod.getMethodAnnotation(TokenInject.class);
			if (null != tokenInject) { 
				// 声明需要token插入，在model中插入formtoken变量
				modelAndView.addObject("formtoken", Token.generateToken(request.getSession()));
			}
		}

	}
}
