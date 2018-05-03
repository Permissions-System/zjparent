package com.zjgt.p2p.source.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Jdbc {
	
	private static String driverClassName;
	private static String url;
	private static String user;
	private static String password;
	
	public static Connection jdbcDb(){
		Connection dbConn= null;
		try {
			InputStream in = Jdbc.class.getClassLoader().getResourceAsStream("config.properties");
			Properties props = new Properties();
			props.load(in);
			driverClassName = props.getProperty("jdbc_source_driver");
			url = props.getProperty("jdbc_source_url");
			user = props.getProperty("jdbc_source_username");
			password = props.getProperty("jdbc_source_password");
			Class.forName(driverClassName);
			dbConn = DriverManager.getConnection(url, user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbConn;
	}

	
	public static void closeResource(ResultSet rs, Statement pstmt, Connection dbConn){
		try {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(dbConn != null){
				dbConn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection dbConn= null;
		
		try {
			InputStream in = Jdbc.class.getClassLoader()
					.getResourceAsStream("config.properties");
			Properties props = new Properties();
			props.load(in);
			driverClassName = props.getProperty("jdbc_source_driver");
			url = props.getProperty("jdbc_source_url");
			user = props.getProperty("jdbc_source_username");
			password = props.getProperty("jdbc_source_password");
			Class.forName(driverClassName);
			dbConn = DriverManager.getConnection(url, user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dbConn;
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
   
}
