package com.zjgt.msg.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.zjgt.msg.util.PropertiesUtils;

/**
 * @FileName:PropertiesUtils.java
 * @Function:TODO
 * @date:2014年12月3日 上午10:33:40
 * @author zhouyi
 * @since jdk1.7
 */
public class PropertiesUtils {

    static Properties config = null;

    static Properties messageConfig = null;

    static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    public static void load() {
        config = new Properties();// Create a Properties object
        /** 
         * Get properties file attributes for the current value  
         * of the inter-class compiled bytecode  
         * in file list of files of the documents  
         * called fileName input stream 
         */
        InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            config.load(in);// Load the file Properties to flow to the object
        } catch (IOException e) {
            logger.error("解析 config.properties 文件失败", e);
            e.printStackTrace();
        }

        messageConfig = new Properties();// Create a Properties object
        InputStream messageIn = PropertiesUtils.class.getClassLoader().getResourceAsStream("messages.properties");
        try {
            messageConfig.load(messageIn);// Load the file Properties to flow to the object
        } catch (IOException e) {
            logger.error("解析 config.properties 文件失败", e);
            e.printStackTrace();
        }
    }

    public static String getProperties(String propertyName) {
        if (config.get(propertyName) == null) {
            return null;
        }
        return config.get(propertyName).toString();
    }

    public static String getPropertiesByMessage(String propertyName) {
        if (messageConfig.get(propertyName) == null) {
            return null;
        }
        return messageConfig.get(propertyName).toString();
    }

    public static String getEmail(String email) throws Exception {
        return getProperties(email);
    }

    public static String getBonus(String propertyName) throws Exception {
        return getProperties(propertyName);
    }
}
