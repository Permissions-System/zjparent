/**
 * 软件著作权：百富金融技术部
 * 
 * 系统名称：互联网金融项目
 * 
 */
package com.zjgt.p2p.manage.common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean工具类
 * 
 * @author chenliang
 * @version 1.0.0
 */
public class BeanUtil {

	/**
	 * Bean转换Map
	 * @param Object:待转换Bean          
	 * @return Map<Object,Object>:转换成的Map
	 * @throws Exception
	 */
	public static Map<Object, Object> Bean2Map(Object inObj) throws Exception {

		Map<Object, Object> retMap = new HashMap<Object, Object>();
		if (inObj != null) {
			try {
				Class cls = inObj.getClass();
				BeanInfo beanInfo = Introspector.getBeanInfo(cls);
				PropertyDescriptor[] propertyDescriptors = beanInfo
						.getPropertyDescriptors();
				for (int i = 0; i < propertyDescriptors.length; i++) {
					PropertyDescriptor descriptor = propertyDescriptors[i];
					String propertyName = descriptor.getName();
					if (!propertyName.equals("class")) {
						Method readMethod = descriptor.getReadMethod();
						Object result = readMethod.invoke(inObj, new Object[0]);
						if (result != null) {
							retMap.put(propertyName, result);
						} else {
							retMap.put(propertyName, "");
						}
					}
				}

			} catch (Exception err) {
				err.printStackTrace();
			}
		}
		return retMap;
	}

	/**
	 * Map转换Bean
	 * @param inObj:需要转换成的Object 
	 * @param Map<Object,Object>:待转换Map 
	 * @return Object：转换后的对象实例
	 * @throws Exception
	 */
	public static Object Map2Bean(Object inObj, Map<Object, Object> inMap)
			throws Exception {
		if (inObj == null || inMap == null) {
			return null;
		}
		Class<? extends Object> cls = inObj.getClass();
		BeanInfo beanInfo = Introspector.getBeanInfo(cls); /* 获取类属性 */
		Object obj = cls.newInstance(); /* 创建JavaBean对象 */
		/* 给 JavaBean 对象的属性赋值 */
		try {
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (inMap.containsKey(propertyName)) {
					Object value = inMap.get(propertyName);
					Object[] args = new Object[1];
					args[0] = value;
					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return obj;
	}
}
