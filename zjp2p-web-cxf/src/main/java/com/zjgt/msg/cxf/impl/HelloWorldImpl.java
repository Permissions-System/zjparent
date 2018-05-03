package com.zjgt.msg.cxf.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.zjgt.msg.cxf.HelloWorld;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口实现
 */
@Component
@WebService
public class HelloWorldImpl implements HelloWorld{

	@Override
	public String sayHi(String name) {
		 return "hello " + name;
	}

}