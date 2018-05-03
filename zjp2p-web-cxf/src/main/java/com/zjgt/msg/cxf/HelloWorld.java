package com.zjgt.msg.cxf;

import javax.jws.WebService;

/**
 * @author tfj
 * 2015年1月7日
 * WS 接口
 */
@WebService
public interface HelloWorld {
	String sayHi(String name);
}


