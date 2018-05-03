package com.zjgt.msg.cxf.client;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjgt.msg.cxf.HelloWorld;
import com.zjgt.msg.cxf.StaffLoginServive;

/**
 * @author tfj 2015年1月8日
 */
public class WsClient {

	private static ApplicationContext context;

	public static void main(String[] args) {
/*		String address = "http://localhost:8080/zjp2p-web-cxf/spring/hello";
		JaxWsClient(address);*/
		
		
		
		String identNo = "admin";
		String pwd = "123.com";
		String address = "http://localhost:8080/zjp2p-web-cxf/staffLoginService";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(address);
		factory.setServiceClass(StaffLoginServive.class);
		StaffLoginServive staffLoginServive = factory.create(StaffLoginServive.class);
		String result = staffLoginServive.isStaffLogin(identNo, pwd);
		System.out.println(result);
		
		
			
//		DynamicClient(address);
//		SpringClient();
	}

	/**
	 * 静态代理客户端
	 */
	public static void JaxWsClient(String address) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(address);
		factory.setServiceClass(HelloWorld.class);
		HelloWorld helloService = factory.create(HelloWorld.class);
		String result = helloService.sayHi("JaxWsClient");
		System.out.println(result);
	}

	/**
	 * 通用动态代理客户端
	 */
	public static void DynamicClient(String address) {
		//CXF发布用的是业务类(HelloWorldImpl.java)，那么默认的命名空间就会是业务类所在包（路径），
		//而对外界暴露的则是接口类(HelloWorld.java)，那么对于客户端（第三方）调用访问时，需要按照接口类所在包（路径）进行命名空间的定义
		QName opName = new QName("http://cxf.alibaba.com/", "sayHi");  // 指定到接口类所在包
		address = address+"?wsdl";
		DynamicClientFactory factory = DynamicClientFactory.newInstance();
		Client client = factory.createClient(address);
		try {
			Object[] results = client.invoke(opName, "DynamicClient");
			System.out.println(results[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果接口和实现在同一路径下，就使用下面的代码.
//		address = address+"?wsdl";
//		DynamicClientFactory factory = DynamicClientFactory.newInstance();
//		Client client = factory.createClient(address);
//		try {
//			Object[] results = client.invoke("sayHi", "DynamicClient");
//			System.out.println(results[0]);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	/**
	 * spring客户端
	 */
	public static void SpringClient() {
		context = new ClassPathXmlApplicationContext("spring-client.xml");
		HelloWorld helloService = context.getBean("helloWorld", HelloWorld.class);
        String result = helloService.sayHi("SpringClient");
        System.out.println(result);
	}
}
