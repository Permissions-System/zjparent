package com.zjgt.p2p.manage.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 取config文件值
 * @author 李君
 */
public class PropertiesUtils {
	
	private static Properties config = null;
	 
	static{
		load();
	}
	
	//初始化
	public static void load(){
		 try {
			 config = new Properties();
			 InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("wsdl.properties");
		      config.load(in);
		 } catch (IOException e) {
		      e.printStackTrace();
		 }
	}
	
	//取值
	public static String getProperties(String propertyName) {
		if (config.get(propertyName) == null) {
		      return null;
		}
		return config.get(propertyName).toString();
	}
	
}
