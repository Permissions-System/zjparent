/**
 * 文件上传
 *
 */
package com.zjgt.p2p.manage.base.web;

import java.io.File;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zjgt.p2p.manage.common.DateUtil;
import com.zjgt.p2p.manage.excel.FileOperate;
import com.zjgt.p2p.service.UploadExcelService;
import com.zjgt.p2p.source.util.UploadExcelUtil;

@Controller
public class UploadController {
	  Logger logger = LoggerFactory.getLogger(UploadController.class);

	 @Autowired
	 UploadExcelService uploadExcelService;
	    
  
	/**
	 * 跳转到文件上传初始页面
	 * @param model 
	 * @return
	 */
	@RequestMapping(value = "/uploadExcel/index",method = RequestMethod.GET)
    public String investIndex(Model model,HttpSession session,String beginTime,String endTime) {
        return "base/report/uploadExcel";
    }
    
	@RequestMapping(value = "/uploadExcel/upload")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) { 
		
		String result="";
  
        System.out.println("开始");  
        System.out.println("文件长度: " + file.getSize());  
        System.out.println("文件类型: " + file.getContentType());  
        System.out.println("文件名称: " + file.getName());  
        System.out.println("文件原名: " + file.getOriginalFilename());  
        System.out.println("========================================"); 
        
        String beginTime = request.getParameter("beginTime");
        if(beginTime==null && "".equals(beginTime) )
        {
        	beginTime = DateUtil.getCurrentYMD();
        }
        
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
      System.out.println(path);  
      File targetFile = new File(path, fileName);  
      if(!targetFile.exists()){  
          targetFile.mkdirs();  
      }  
      
      try {  
    	  //保存  
          file.transferTo(targetFile);  
          //multipartFile.getFileItem().getName();
          //本地文件路径
          String filePath =  path+File.separator+fileName;
          //给出Excel表统计用户的开户数、投资数
          result = UploadExcelUtil.get_ku_invest_count(filePath, beginTime);
          //删除文件
          boolean bo = new FileOperate().deleteFile(filePath);
          System.out.println("删除文件结果："+bo);
          
          model.addAttribute("result", result);  
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
  
        return "base/report/uploadResult";  
    } 
	
	@RequestMapping(value = "/uploadExcel/export",method = RequestMethod.POST)  
    public void ExcelExport(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response, ModelMap model) {  
  
        
        String beginTime = request.getParameter("beginTime");
        if(beginTime==null && "".equals(beginTime) )
        {
        	beginTime = DateUtil.getCurrentYMD();
        }
        
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists())
        {  
          targetFile.mkdirs();  
        }  
      
      try {  
    	  //保存  
          file.transferTo(targetFile);  
          
          //本地文件路径
          String filePath =  path+File.separator+fileName;
          
          response.setContentType("application/vnd.ms-excel");
          setFileDownloadHeader(request,response,fileName);
  		
          //将结果生成Excel("编号","手机号","用户名","是否开户","最后登录时间","总投资金额")
		    List<String[]> list = UploadExcelUtil.findUserInfoByAll(filePath,beginTime);
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
	    	cell.setCellValue(new HSSFRichTextString("根据手机号查相关信息"));
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
	    	
			OutputStream out = response.getOutputStream();
			workBook.write(out);
			out.close();
			
			//删除文件
	        boolean bo = new FileOperate().deleteFile(filePath);
	        System.out.println("删除文件结果："+bo);
          
      } 
      catch (Exception e) 
      {  
          e.printStackTrace();  
      }  
  
    } 
	
	public void setFileDownloadHeader(HttpServletRequest request, HttpServletResponse response, String fileName) {
        final String userAgent = request.getHeader("USER-AGENT");
        try {
            String finalFileName = null;
            if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器
                finalFileName = URLEncoder.encode(fileName,"UTF8");
            }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器
                finalFileName = new String(fileName.getBytes(), "ISO8859-1");
            }else{
                finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器
            }
            response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
    }
	
	
	
	
}