/**
 * 文件上传
 */
package com.zjgt.p2p.service;

import java.util.List;

public interface UploadExcelService {
	
	/**
	 * @Description: 给出Excel表统计用户的开户数、投资数
	 * @param @param fileName
	 * @param @throws Exception
	 * @return void
	 * @throws
	 * @author kaiyun
	 * @date 2015-9-22
	 */
	public void get_ku_invest_count(String filePath, String beginTime) ;
	
	
	/**
	 * 
	 * @Description: 将结果生成Excel("编号","手机号","用户名","是否开户","最后登录时间","总投资金额")
	 * @param @param inFileName
	 * 					要读取的Excel文件名
	 * @param @param outFileName
	 * 					要生成的Excel文件名
	 * @param @param beginTime
	 * 					开始时间
	 * @param @throws Exception   
	 * @return void  
	 * @throws
	 * @author kaiyun
	 * @date 2015-9-18
	 */
	public void createExcleOne(String inFileName ,String outFileName,String beginTime) ;
	
	
	
	/**
	 * @Description: 读取Excel
	 * @param @param inFileName 
	 * 						要读取的文件
	 * @param @param login_lend_Date 
	 * 						开始时间
	 * @param @return
	 * @param @throws Exception   
	 * @return List<String[]>  
	 * @throws
	 * @author kaiyun
	 * @date 2015-9-18
	 */
	public List<String[]> findUserInfoByAll(String filePath,String begin_login_lend_Date) ;
	
	/**
	 * @Description: 获取用户的总投资金额
	 * @param @param userName
	 * 					用户名
	 * @param @param beginLendDate
	 * 					开始时间
	 * @param @return   
	 * @return double  
	 * @throws SQLException 
	 * @throws Exception 
	 * @throws
	 * @author kaiyun
	 * @date 2015-9-21
	 */
	public String getAllLengMoney(String userName,String beginLendDate) ;
	

}
