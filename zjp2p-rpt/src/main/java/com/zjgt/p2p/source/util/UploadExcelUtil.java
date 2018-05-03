package com.zjgt.p2p.source.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UploadExcelUtil
{
	/**
	 * @Description: 给出Excel表统计用户的开户数、投资数
	 * @param @param fileName
	 * @param @throws Exception
	 * @return void
	 * @throws FileNotFoundException 
	 * @throws
	 * @author kaiyun
	 * @date 2015-9-22
	 */
	public static String get_ku_invest_count(String filePath, String beginTime) 
	{
		String result = "";
		int isKaiHu = 0;// 开户数
		int noKaiHu = 0;// 未开户数
		int touZi = 0;// 投资数
		int nofind = 0;// 手机号未找到
		int count = 0;

		PreparedStatement pstmt = null;
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		// 使用POI 读取 Excel 文件，读取手机号码 变成 1.3471022771E10 如何 解决？
		DecimalFormat df = new DecimalFormat("#");
		
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
		
		Workbook wb = null;
		Sheet sheet1 = null;
		
		try
		{
			InputStream stream = new FileInputStream(filePath);
			
			if (fileType.equals("xls"))
			{
				wb = new HSSFWorkbook(stream);
			} else if (fileType.equals("xlsx"))
			{
				wb = new XSSFWorkbook(stream);
			} else
			{
				System.out.println("您输入的excel格式不正确");
			}
			sheet1 = wb.getSheetAt(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		
		
		System.out.println("编号" + "\t" + "手机号" + "\t\t" + "是否开户" + "\t" + "用户名"+ "\t\t" + "最后登录时间");
		
		for (Row row : sheet1)
		{
			for (Cell cell : row)
			{
				cell.setCellType(Cell.CELL_TYPE_STRING);
				
				int isHasFuiou = 0;
				String userName = "";
				java.util.Date loginDate = null;
				count++;
				String mobile = null;
				
				try
				{
					if (cell == null){continue;}
						
					switch (cell.getCellType())
					{
					case HSSFCell.CELL_TYPE_NUMERIC:
						mobile = "" + df.format(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						mobile = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						break;
					default:
						break;
					}
					
					conn = Jdbc.getConnection();

					sql = "select HasFuiou,userName,loginDate from tb_userInfo where mobile=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mobile);// row.getCell(j).toString()
					rs = pstmt.executeQuery();

					while (rs != null && rs.next())
					{
						isHasFuiou = rs.getInt("HasFuiou");// 判断用户是否开户
						userName = rs.getString("userName");// 用户名
						loginDate = rs.getDate("loginDate");
						if (isHasFuiou == 0)
						{
							noKaiHu = noKaiHu + 1;
						} else if (isHasFuiou == 1)
						{
							isKaiHu = isKaiHu + 1;
							String sql2 = "select Id from tb_lendInfo where (lendDate>='"
									+ beginTime
									+ "' AND lendDate<=getdate()) and userName=?";
							pstmt = conn.prepareStatement(sql2);
							pstmt.setString(1, userName);
							rs = pstmt.executeQuery();
							if (rs != null && rs.next() == true)
							{
								touZi = touZi + 1;
							}
						}
					}

				} catch (Exception e)
				{
					e.printStackTrace();
				} finally
				{
					Jdbc.release(rs, pstmt, conn);
				}

				// 输出
				System.out.println(count + "\t" + mobile + "\t" + isHasFuiou
						+ "\t" + userName + "\t" + loginDate);
			}
		}

		result = "开户数：" + String.valueOf(isKaiHu) + "\n" + "未开户数："
				+ String.valueOf(noKaiHu) + "\n" + "已投资数："
				+ String.valueOf(touZi) + "\n" + "找不到："
				+ String.valueOf(nofind);
		// 输出结构
		System.out.println(result);
		return result;
	}
	
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
	public static void createExcleOne(String inFileName ,String outFileName,String beginTime) 
	{
		
		try
		{
			List<String[]> list = findUserInfoByAll(inFileName,beginTime);
			
			HSSFWorkbook workBook = new HSSFWorkbook();		//创建 一个excel文档对象
	    	HSSFSheet sheet = workBook.createSheet();			//创建一个工作薄对象
	    	//设置样式
	    	HSSFCellStyle titleStyle = workBook.createCellStyle();	//创建样式对象
	    	titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);	//水平居中
	    	titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);	//垂直居中
	    	// 设置字体
	    	HSSFFont titleFont = workBook.createFont();			//创建字体对象
	    	titleFont.setFontHeightInPoints((short) 15);			//设置字体大小
	    	titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	//设置粗体
	    	titleFont.setFontName("黑体");	//设置为黑体字
	    	titleStyle.setFont(titleFont);
	    	// 合并单元格操作
	    	sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 5));
	    	HSSFRow row = null;
	    	HSSFCell cell = null;
	    	row = sheet.createRow(0);
	    	cell = row.createCell(0);
	    	cell.setCellStyle(titleStyle);
	    	cell.setCellValue(new HSSFRichTextString("学生信息表"));
	    	// 设置表文样式
	    	HSSFCellStyle tableStyle = workBook.createCellStyle();
	    	tableStyle.setBorderBottom((short)1);
	    	tableStyle.setBorderTop((short)1);
	    	tableStyle.setBorderLeft((short)1);
	    	tableStyle.setBorderRight((short)1);
	    	tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	    	// 设置表文字体
	    	HSSFFont tableFont = workBook.createFont();
	    	tableFont.setFontHeightInPoints((short) 12); 		//设置字体大小
	    	tableFont.setFontName("宋体"); 				//设置为黑体字
	    	tableStyle.setFont(tableFont);
	    	String[] title = {"编号","手机号","用户名","是否开户","最后登录时间","总投资金额"};
	    	row = sheet.createRow(2);
	    	for (int i = 0; i < title.length; i++) {
	    		cell = row.createCell(i);
	    		cell.setCellStyle(tableStyle);
	    		cell.setCellValue(new HSSFRichTextString(title[i]));
	    	}
	    	for (int i = 0; i < list.size(); i++) {
	    		row = sheet.createRow(i+3);
	    		String[] stuInfo = list.get(i);
	    		for (int j = 0; j < stuInfo.length; j++) {
	    			cell = row.createCell(j);
	        		cell.setCellStyle(tableStyle);
	        		cell.setCellValue(new HSSFRichTextString(stuInfo[j]));
	    		}
	    	}
	    	
	    	System.out.println("success");
	    	
	    	// 文件输出流,将文档对象写入文件输出流,关闭文件输出流
			FileOutputStream os = new FileOutputStream(outFileName);
			workBook.write(os);
			os.close();
			
			/*OutputStream out = response.getOutputStream();
			workBook.write(out);
			out.close();*/
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
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
	public static List<String[]> findUserInfoByAll(String filePath,String begin_login_lend_Date) 
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<String[]> list = new ArrayList<String[]>();
		int count = 0;
		Connection  conn = null;	
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		String allLendMonry = "";
		
		//使用POI 读取 Excel 文件，读取手机号码 变成  1.3471022771E10   如何 解决？ 
		DecimalFormat df = new DecimalFormat("#");
		
		String fileType = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
		Sheet sheet1 = null;
		
		try
		{
			
			InputStream stream = new FileInputStream(filePath);
			Workbook wb = null;
			if (fileType.equals("xls"))
			{
				wb = new HSSFWorkbook(stream);
			} else if (fileType.equals("xlsx"))
			{
				wb = new XSSFWorkbook(stream);
			} else
			{
				System.out.println("您输入的excel格式不正确");
			}
			sheet1 = wb.getSheetAt(0);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		for (Row row : sheet1)
		{
			for (Cell cell : row)
			{
				cell.setCellType(Cell.CELL_TYPE_STRING);
				//System.out.print(cell.getStringCellValue() + "  ");
				
				count++;
				String mobile = null;
				
				try
				{
					if (cell == null){continue;}
						
					switch (cell.getCellType())
					{
					case HSSFCell.CELL_TYPE_NUMERIC:
						mobile = "" + df.format(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						mobile = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						break;
					default:
						break;
					}
					
					//b_lendInfo投资记录表 HasFuiou--0未开户,1已开户
					conn = Jdbc.getConnection();
					sql = "select HasFuiou,userName,loginDate from tb_userInfo as u where (loginDate>='"+begin_login_lend_Date+"' AND loginDate<=getdate()) and mobile=? ";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,mobile );
					rs = pstmt.executeQuery();
					
					while (rs!=null && rs.next())
					{
						//获取用户信息
						String[] stuInfo = new String[6];
						stuInfo[0]=String.valueOf(count)+"";
						stuInfo[1]=mobile;
						stuInfo[2]=rs.getString("userName");
						stuInfo[3]=String.valueOf(rs.getInt("HasFuiou"));
						String loginDate = "";
						if(rs.getDate("loginDate")!=null){
							loginDate = sdf.format(rs.getDate("loginDate"));
						}
						stuInfo[4]=loginDate;
						
						//20150921,求每个用户的总投资金额
						allLendMonry = getAllLengMoney(rs.getString("userName"),begin_login_lend_Date);
						stuInfo[5]=allLendMonry;
						
						list.add(stuInfo);
					}
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				} 
				finally
				{
					Jdbc.release(rs, pstmt, conn);
				}
				System.out.println(count);
			}
		}
		return list;
		
	}
	
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
	public static String getAllLengMoney(String userName,String beginLendDate) 
	{
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		Connection conn = null;
		String aa = "";
		
		try
		{
			conn = Jdbc.getConnection();
			
			sql = "select sum(lendMoney) from tb_lendInfo where (lendDate>='"+beginLendDate+"' AND lendDate<=getdate()) and userName=?   ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userName );
			rs = pstmt.executeQuery();
			 if(rs!=null && rs.next()) {   
				 aa = rs.getString(1);
			 }  
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally{
			Jdbc.release(rs, pstmt, conn);
		}
		
		return aa;
	}
}
